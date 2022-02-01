package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/squareup/wire/AnyMessage$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/squareup/wire/AnyMessage;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class AnyMessage$Companion$ADAPTER$1
  extends ProtoAdapter<AnyMessage>
{
  AnyMessage$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public AnyMessage decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    ByteString localByteString = ByteString.EMPTY;
    long l = paramProtoReader.beginMessage();
    String str = "square.github.io/wire/unknown";
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1)
      {
        paramProtoReader.endMessageAndGetUnknownFields(l);
        return new AnyMessage(str, localByteString);
      }
      if (i != 1)
      {
        if (i != 2) {
          paramProtoReader.readUnknownField(i);
        } else {
          localByteString = (ByteString)ProtoAdapter.BYTES.decode(paramProtoReader);
        }
      }
      else {
        str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull AnyMessage paramAnyMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramAnyMessage, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramAnyMessage.getTypeUrl());
    ProtoAdapter.BYTES.encodeWithTag(paramProtoWriter, 2, paramAnyMessage.getValue());
  }
  
  public int encodedSize(@NotNull AnyMessage paramAnyMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramAnyMessage, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramAnyMessage.getTypeUrl()) + ProtoAdapter.BYTES.encodedSizeWithTag(2, paramAnyMessage.getValue());
  }
  
  @NotNull
  public AnyMessage redact(@NotNull AnyMessage paramAnyMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramAnyMessage, "value");
    return new AnyMessage("square.github.io/wire/redacted", ByteString.EMPTY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.AnyMessage.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */