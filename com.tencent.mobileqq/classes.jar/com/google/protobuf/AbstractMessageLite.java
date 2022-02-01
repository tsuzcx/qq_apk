package com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends AbstractMessageLite.Builder<MessageType, BuilderType>>
  implements MessageLite
{
  protected int memoizedHashCode = 0;
  
  @Deprecated
  protected static <T> void addAll(Iterable<T> paramIterable, Collection<? super T> paramCollection)
  {
    AbstractMessageLite.Builder.addAll(paramIterable, (List)paramCollection);
  }
  
  protected static <T> void addAll(Iterable<T> paramIterable, List<? super T> paramList)
  {
    AbstractMessageLite.Builder.addAll(paramIterable, paramList);
  }
  
  protected static void checkByteStringIsUtf8(ByteString paramByteString)
  {
    if (paramByteString.isValidUtf8()) {
      return;
    }
    throw new IllegalArgumentException("Byte string is not UTF-8.");
  }
  
  private Class<AbstractMessageLite<MessageType, BuilderType>> getClassInternal()
  {
    return getClass();
  }
  
  private String getSerializingExceptionMessage(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Serializing ");
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" to a ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" threw an IOException (should never happen).");
    return localStringBuilder.toString();
  }
  
  int getMemoizedSerializedSize()
  {
    throw new UnsupportedOperationException();
  }
  
  int getSerializedSize(Schema paramSchema)
  {
    int j = getMemoizedSerializedSize();
    int i = j;
    if (j == -1)
    {
      i = paramSchema.b(this);
      setMemoizedSerializedSize(i);
    }
    return i;
  }
  
  protected final int getSerializedSizeInternal()
  {
    return Protobuf.a().a(this).b(this);
  }
  
  protected final boolean isInitializedInternal()
  {
    return Protobuf.a().a(this).e(this);
  }
  
  protected void makeImmutableInternal()
  {
    Protobuf.a().a(getClassInternal()).d(this);
  }
  
  protected void mergeFromInternal(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      Protobuf.a().a(getClassInternal()).a(this, CodedInputStreamReader.a(paramCodedInputStream), paramExtensionRegistryLite);
      return;
    }
    catch (IOException paramCodedInputStream)
    {
      throw new InvalidProtocolBufferException(paramCodedInputStream).setUnfinishedMessage(this);
    }
    catch (InvalidProtocolBufferException paramCodedInputStream)
    {
      throw paramCodedInputStream.setUnfinishedMessage(this);
    }
  }
  
  UninitializedMessageException newUninitializedMessageException()
  {
    return new UninitializedMessageException(this);
  }
  
  void setMemoizedSerializedSize(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public byte[] toByteArray()
  {
    try
    {
      byte[] arrayOfByte = new byte[getSerializedSize()];
      CodedOutputStream localCodedOutputStream = CodedOutputStream.a(arrayOfByte);
      writeTo(localCodedOutputStream);
      localCodedOutputStream.d();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(getSerializingExceptionMessage("byte array"), localIOException);
    }
  }
  
  public ByteString toByteString()
  {
    try
    {
      Object localObject = ByteString.newCodedBuilder(getSerializedSize());
      writeTo(((ByteString.CodedBuilder)localObject).b());
      localObject = ((ByteString.CodedBuilder)localObject).a();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(getSerializingExceptionMessage("ByteString"), localIOException);
    }
  }
  
  public void writeDelimitedTo(OutputStream paramOutputStream)
  {
    int i = getSerializedSize();
    paramOutputStream = CodedOutputStream.a(paramOutputStream, CodedOutputStream.a(CodedOutputStream.r(i) + i));
    paramOutputStream.q(i);
    writeTo(paramOutputStream);
    paramOutputStream.b();
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    paramOutputStream = CodedOutputStream.a(paramOutputStream, CodedOutputStream.a(getSerializedSize()));
    writeTo(paramOutputStream);
    paramOutputStream.b();
  }
  
  protected final void writeToInternal(CodedOutputStream paramCodedOutputStream)
  {
    Protobuf.a().a(getClassInternal()).a(this, CodedOutputStreamWriter.a(paramCodedOutputStream));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.AbstractMessageLite
 * JD-Core Version:    0.7.0.1
 */