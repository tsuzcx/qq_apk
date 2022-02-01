package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/ProtoReader;", "", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "bufferStack", "", "Lokio/Buffer;", "limit", "", "nextFieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "pos", "pushedLimit", "recursionDepth", "", "state", "tag", "addUnknownField", "", "fieldEncoding", "value", "afterPackableScalar", "beforeLengthDelimitedScalar", "beginMessage", "endMessage", "token", "endMessageAndGetUnknownFields", "Lokio/ByteString;", "forEachTag", "tagHandler", "Lkotlin/Function1;", "-forEachTag", "internalReadVarint32", "nextTag", "peekFieldEncoding", "readBytes", "readFixed32", "readFixed64", "readString", "", "readUnknownField", "readVarint32", "readVarint64", "skip", "skipGroup", "expectedEndTag", "Companion", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class ProtoReader
{
  public static final ProtoReader.Companion Companion = new ProtoReader.Companion(null);
  private static final int FIELD_ENCODING_MASK = 7;
  private static final int RECURSION_LIMIT = 65;
  private static final int STATE_END_GROUP = 4;
  private static final int STATE_FIXED32 = 5;
  private static final int STATE_FIXED64 = 1;
  private static final int STATE_LENGTH_DELIMITED = 2;
  private static final int STATE_PACKED_TAG = 7;
  private static final int STATE_START_GROUP = 3;
  private static final int STATE_TAG = 6;
  private static final int STATE_VARINT = 0;
  public static final int TAG_FIELD_ENCODING_BITS = 3;
  private final List<Buffer> bufferStack;
  private long limit;
  private FieldEncoding nextFieldEncoding;
  private long pos;
  private long pushedLimit;
  private int recursionDepth;
  private final BufferedSource source;
  private int state;
  private int tag;
  
  public ProtoReader(@NotNull BufferedSource paramBufferedSource)
  {
    this.source = paramBufferedSource;
    this.limit = 9223372036854775807L;
    this.state = 2;
    this.tag = -1;
    this.pushedLimit = -1L;
    this.bufferStack = ((List)new ArrayList());
  }
  
  private final void afterPackableScalar(int paramInt)
  {
    if (this.state == paramInt)
    {
      this.state = 6;
      return;
    }
    long l1 = this.pos;
    long l2 = this.limit;
    if (l1 <= l2)
    {
      if (l1 == l2)
      {
        this.limit = this.pushedLimit;
        this.pushedLimit = -1L;
        this.state = 6;
        return;
      }
      this.state = 7;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected to end at ");
    localStringBuilder.append(this.limit);
    localStringBuilder.append(" but was ");
    localStringBuilder.append(this.pos);
    throw ((Throwable)new IOException(localStringBuilder.toString()));
  }
  
  private final long beforeLengthDelimitedScalar()
  {
    if (this.state == 2)
    {
      long l = this.limit - this.pos;
      this.source.require(l);
      this.state = 6;
      this.pos = this.limit;
      this.limit = this.pushedLimit;
      this.pushedLimit = -1L;
      return l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected LENGTH_DELIMITED but was ");
    localStringBuilder.append(this.state);
    throw ((Throwable)new ProtocolException(localStringBuilder.toString()));
  }
  
  private final int internalReadVarint32()
  {
    this.source.require(1L);
    this.pos += 1L;
    int i = this.source.readByte();
    if (i >= 0) {
      return i;
    }
    i &= 0x7F;
    this.source.require(1L);
    this.pos += 1L;
    int j = this.source.readByte();
    if (j >= 0) {
      j <<= 7;
    }
    for (;;)
    {
      return i | j;
      i |= (j & 0x7F) << 7;
      this.source.require(1L);
      this.pos += 1L;
      j = this.source.readByte();
      if (j >= 0)
      {
        j <<= 14;
      }
      else
      {
        i |= (j & 0x7F) << 14;
        this.source.require(1L);
        this.pos += 1L;
        j = this.source.readByte();
        if (j < 0) {
          break;
        }
        j <<= 21;
      }
    }
    this.source.require(1L);
    this.pos += 1L;
    int k = this.source.readByte();
    j = i | (j & 0x7F) << 21 | k << 28;
    if (k < 0)
    {
      i = 0;
      while (i <= 4)
      {
        this.source.require(1L);
        this.pos += 1L;
        if (this.source.readByte() >= 0) {
          return j;
        }
        i += 1;
      }
      throw ((Throwable)new ProtocolException("Malformed VARINT"));
    }
    return j;
  }
  
  private final void skipGroup(int paramInt)
  {
    while ((this.pos < this.limit) && (!this.source.exhausted()))
    {
      int j = internalReadVarint32();
      if (j != 0)
      {
        int i = j >> 3;
        j &= 0x7;
        if (j == 3)
        {
          skipGroup(i);
        }
        else
        {
          if (j == 4)
          {
            if (i == paramInt) {
              return;
            }
            throw ((Throwable)new ProtocolException("Unexpected end group"));
          }
          if (j == 2)
          {
            i = internalReadVarint32();
            long l1 = this.pos;
            long l2 = i;
            this.pos = (l1 + l2);
            this.source.skip(l2);
          }
          else if (j == 0)
          {
            this.state = 0;
            readVarint64();
          }
          else if (j == 1)
          {
            this.state = 1;
            readFixed64();
          }
          else if (j == 5)
          {
            this.state = 5;
            readFixed32();
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Unexpected field encoding: ");
            ((StringBuilder)localObject).append(j);
            throw ((Throwable)new ProtocolException(((StringBuilder)localObject).toString()));
          }
        }
      }
      else
      {
        throw ((Throwable)new ProtocolException("Unexpected tag 0"));
      }
    }
    Object localObject = (Throwable)new EOFException();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @JvmName(name="-forEachTag")
  @NotNull
  public final ByteString -forEachTag(@NotNull Function1<? super Integer, ? extends Object> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "tagHandler");
    long l = beginMessage();
    for (;;)
    {
      int i = nextTag();
      if (i == -1) {
        return endMessageAndGetUnknownFields(l);
      }
      paramFunction1.invoke(Integer.valueOf(i));
    }
  }
  
  public final void addUnknownField(int paramInt, @NotNull FieldEncoding paramFieldEncoding, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramFieldEncoding, "fieldEncoding");
    ProtoWriter localProtoWriter = new ProtoWriter((BufferedSink)this.bufferStack.get(this.recursionDepth - 1));
    paramFieldEncoding = paramFieldEncoding.rawProtoAdapter();
    if (paramFieldEncoding != null)
    {
      paramFieldEncoding.encodeWithTag(localProtoWriter, paramInt, paramObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
  }
  
  public final long beginMessage()
  {
    int i;
    if (this.state == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.recursionDepth += 1;
      i = this.recursionDepth;
      if (i <= 65)
      {
        if (i > this.bufferStack.size()) {
          ((Collection)this.bufferStack).add(new Buffer());
        }
        long l = this.pushedLimit;
        this.pushedLimit = -1L;
        this.state = 6;
        return l;
      }
      throw ((Throwable)new IOException("Wire recursion limit exceeded"));
    }
    throw ((Throwable)new IllegalStateException("Unexpected call to beginMessage()".toString()));
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="prefer endMessageAndGetUnknownFields()", replaceWith=@ReplaceWith(expression="endMessageAndGetUnknownFields(token)", imports={}))
  public final void endMessage(long paramLong)
  {
    endMessageAndGetUnknownFields(paramLong);
  }
  
  @NotNull
  public final ByteString endMessageAndGetUnknownFields(long paramLong)
  {
    int i = this.state;
    int j = 1;
    if (i == 6) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.recursionDepth -= 1;
      if ((this.recursionDepth >= 0) && (this.pushedLimit == -1L)) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((this.pos != this.limit) && (this.recursionDepth != 0))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Expected to end at ");
          ((StringBuilder)localObject).append(this.limit);
          ((StringBuilder)localObject).append(" but was ");
          ((StringBuilder)localObject).append(this.pos);
          throw ((Throwable)new IOException(((StringBuilder)localObject).toString()));
        }
        this.limit = paramLong;
        Object localObject = (Buffer)this.bufferStack.get(this.recursionDepth);
        if (((Buffer)localObject).size() > 0L) {
          return ((Buffer)localObject).readByteString();
        }
        return ByteString.EMPTY;
      }
      throw ((Throwable)new IllegalStateException("No corresponding call to beginMessage()".toString()));
    }
    throw ((Throwable)new IllegalStateException("Unexpected call to endMessage()".toString()));
  }
  
  public final int nextTag()
  {
    int i = this.state;
    if (i == 7)
    {
      this.state = 2;
      return this.tag;
    }
    if (i == 6)
    {
      while ((this.pos < this.limit) && (!this.source.exhausted()))
      {
        i = internalReadVarint32();
        if (i != 0)
        {
          this.tag = (i >> 3);
          i &= 0x7;
          if (i == 3)
          {
            skipGroup(this.tag);
          }
          else
          {
            if (i != 4)
            {
              if (i == 2)
              {
                this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
                this.state = 2;
                i = internalReadVarint32();
                if (i >= 0)
                {
                  if (this.pushedLimit == -1L)
                  {
                    this.pushedLimit = this.limit;
                    this.limit = (this.pos + i);
                    if (this.limit <= this.pushedLimit) {
                      return this.tag;
                    }
                    throw ((Throwable)new EOFException());
                  }
                  throw ((Throwable)new IllegalStateException());
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Negative length: ");
                ((StringBuilder)localObject).append(i);
                throw ((Throwable)new ProtocolException(((StringBuilder)localObject).toString()));
              }
              if (i == 0)
              {
                this.nextFieldEncoding = FieldEncoding.VARINT;
                this.state = 0;
                return this.tag;
              }
              if (i == 1)
              {
                this.nextFieldEncoding = FieldEncoding.FIXED64;
                this.state = 1;
                return this.tag;
              }
              if (i == 5)
              {
                this.nextFieldEncoding = FieldEncoding.FIXED32;
                this.state = 5;
                return this.tag;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Unexpected field encoding: ");
              ((StringBuilder)localObject).append(i);
              throw ((Throwable)new ProtocolException(((StringBuilder)localObject).toString()));
            }
            throw ((Throwable)new ProtocolException("Unexpected end group"));
          }
        }
        else
        {
          throw ((Throwable)new ProtocolException("Unexpected tag 0"));
        }
      }
      return -1;
    }
    Object localObject = (Throwable)new IllegalStateException("Unexpected call to nextTag()");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  public final FieldEncoding peekFieldEncoding()
  {
    return this.nextFieldEncoding;
  }
  
  @NotNull
  public final ByteString readBytes()
  {
    long l = beforeLengthDelimitedScalar();
    this.source.require(l);
    return this.source.readByteString(l);
  }
  
  public final int readFixed32()
  {
    int i = this.state;
    if ((i != 5) && (i != 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected FIXED32 or LENGTH_DELIMITED but was ");
      localStringBuilder.append(this.state);
      throw ((Throwable)new ProtocolException(localStringBuilder.toString()));
    }
    this.source.require(4L);
    this.pos += 4;
    i = this.source.readIntLe();
    afterPackableScalar(5);
    return i;
  }
  
  public final long readFixed64()
  {
    int i = this.state;
    if ((i != 1) && (i != 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected FIXED64 or LENGTH_DELIMITED but was ");
      localStringBuilder.append(this.state);
      throw ((Throwable)new ProtocolException(localStringBuilder.toString()));
    }
    this.source.require(8L);
    this.pos += 8;
    long l = this.source.readLongLe();
    afterPackableScalar(1);
    return l;
  }
  
  @NotNull
  public final String readString()
  {
    long l = beforeLengthDelimitedScalar();
    this.source.require(l);
    return this.source.readUtf8(l);
  }
  
  public final void readUnknownField(int paramInt)
  {
    FieldEncoding localFieldEncoding = peekFieldEncoding();
    if (localFieldEncoding == null) {
      Intrinsics.throwNpe();
    }
    addUnknownField(paramInt, localFieldEncoding, localFieldEncoding.rawProtoAdapter().decode(this));
  }
  
  public final int readVarint32()
  {
    int i = this.state;
    if ((i != 0) && (i != 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected VARINT or LENGTH_DELIMITED but was ");
      localStringBuilder.append(this.state);
      throw ((Throwable)new ProtocolException(localStringBuilder.toString()));
    }
    i = internalReadVarint32();
    afterPackableScalar(0);
    return i;
  }
  
  public final long readVarint64()
  {
    int i = this.state;
    if ((i != 0) && (i != 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Expected VARINT or LENGTH_DELIMITED but was ");
      ((StringBuilder)localObject).append(this.state);
      throw ((Throwable)new ProtocolException(((StringBuilder)localObject).toString()));
    }
    long l = 0L;
    i = 0;
    while (i < 64)
    {
      this.source.require(1L);
      this.pos += 1L;
      int j = this.source.readByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        afterPackableScalar(0);
        return l;
      }
      i += 7;
    }
    Object localObject = (Throwable)new ProtocolException("WireInput encountered a malformed varint");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public final void skip()
  {
    int i = this.state;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 5)
          {
            readFixed32();
            return;
          }
          throw ((Throwable)new IllegalStateException("Unexpected call to skip()"));
        }
        long l = beforeLengthDelimitedScalar();
        this.source.skip(l);
        return;
      }
      readFixed64();
      return;
    }
    readVarint64();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoReader
 * JD-Core Version:    0.7.0.1
 */