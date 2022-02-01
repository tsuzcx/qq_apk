package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractMessageLite$Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>>
  implements MessageLite.Builder
{
  @Deprecated
  protected static <T> void addAll(Iterable<T> paramIterable, Collection<? super T> paramCollection)
  {
    addAll(paramIterable, (List)paramCollection);
  }
  
  protected static <T> void addAll(Iterable<T> paramIterable, List<? super T> paramList)
  {
    Internal.a(paramIterable);
    if ((paramIterable instanceof LazyStringList))
    {
      Object localObject = ((LazyStringList)paramIterable).d();
      paramIterable = (LazyStringList)paramList;
      int j = paramList.size();
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = paramList.next();
        if (localObject == null)
        {
          paramList = new StringBuilder();
          paramList.append("Element at index ");
          paramList.append(paramIterable.size() - j);
          paramList.append(" is null.");
          paramList = paramList.toString();
          int i = paramIterable.size() - 1;
          while (i >= j)
          {
            paramIterable.remove(i);
            i -= 1;
          }
          throw new NullPointerException(paramList);
        }
        if ((localObject instanceof ByteString)) {
          paramIterable.a((ByteString)localObject);
        } else {
          paramIterable.add((String)localObject);
        }
      }
    }
    if ((paramIterable instanceof PrimitiveNonBoxingCollection))
    {
      paramList.addAll((Collection)paramIterable);
      return;
    }
    addAllCheckingNulls(paramIterable, paramList);
  }
  
  private static <T> void addAllCheckingNulls(Iterable<T> paramIterable, List<? super T> paramList)
  {
    if (((paramList instanceof ArrayList)) && ((paramIterable instanceof Collection))) {
      ((ArrayList)paramList).ensureCapacity(paramList.size() + ((Collection)paramIterable).size());
    }
    int j = paramList.size();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (localObject == null)
      {
        paramIterable = new StringBuilder();
        paramIterable.append("Element at index ");
        paramIterable.append(paramList.size() - j);
        paramIterable.append(" is null.");
        paramIterable = paramIterable.toString();
        int i = paramList.size() - 1;
        while (i >= j)
        {
          paramList.remove(i);
          i -= 1;
        }
        throw new NullPointerException(paramIterable);
      }
      paramList.add(localObject);
    }
  }
  
  private String getReadingExceptionMessage(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Reading ");
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" from a ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" threw an IOException (should never happen).");
    return localStringBuilder.toString();
  }
  
  protected static UninitializedMessageException newUninitializedMessageException(MessageLite paramMessageLite)
  {
    return new UninitializedMessageException(paramMessageLite);
  }
  
  public abstract BuilderType clone();
  
  protected abstract BuilderType internalMergeFrom(MessageType paramMessageType);
  
  public boolean mergeDelimitedFrom(InputStream paramInputStream)
  {
    return mergeDelimitedFrom(paramInputStream, ExtensionRegistryLite.d());
  }
  
  public boolean mergeDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i = paramInputStream.read();
    if (i == -1) {
      return false;
    }
    mergeFrom(new AbstractMessageLite.Builder.LimitedInputStream(paramInputStream, CodedInputStream.a(i, paramInputStream)), paramExtensionRegistryLite);
    return true;
  }
  
  public BuilderType mergeFrom(ByteString paramByteString)
  {
    try
    {
      paramByteString = paramByteString.newCodedInput();
      mergeFrom(paramByteString);
      paramByteString.a(0);
      return this;
    }
    catch (IOException paramByteString)
    {
      throw new RuntimeException(getReadingExceptionMessage("ByteString"), paramByteString);
    }
    catch (InvalidProtocolBufferException paramByteString)
    {
      throw paramByteString;
    }
  }
  
  public BuilderType mergeFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      paramByteString = paramByteString.newCodedInput();
      mergeFrom(paramByteString, paramExtensionRegistryLite);
      paramByteString.a(0);
      return this;
    }
    catch (IOException paramByteString)
    {
      throw new RuntimeException(getReadingExceptionMessage("ByteString"), paramByteString);
    }
    catch (InvalidProtocolBufferException paramByteString)
    {
      throw paramByteString;
    }
  }
  
  public BuilderType mergeFrom(CodedInputStream paramCodedInputStream)
  {
    return mergeFrom(paramCodedInputStream, ExtensionRegistryLite.d());
  }
  
  public abstract BuilderType mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public BuilderType mergeFrom(MessageLite paramMessageLite)
  {
    if (getDefaultInstanceForType().getClass().isInstance(paramMessageLite)) {
      return internalMergeFrom((AbstractMessageLite)paramMessageLite);
    }
    throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
  }
  
  public BuilderType mergeFrom(InputStream paramInputStream)
  {
    paramInputStream = CodedInputStream.a(paramInputStream);
    mergeFrom(paramInputStream);
    paramInputStream.a(0);
    return this;
  }
  
  public BuilderType mergeFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramInputStream = CodedInputStream.a(paramInputStream);
    mergeFrom(paramInputStream, paramExtensionRegistryLite);
    paramInputStream.a(0);
    return this;
  }
  
  public BuilderType mergeFrom(byte[] paramArrayOfByte)
  {
    return mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public BuilderType mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = CodedInputStream.a(paramArrayOfByte, paramInt1, paramInt2);
      mergeFrom(paramArrayOfByte);
      paramArrayOfByte.a(0);
      return this;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException(getReadingExceptionMessage("byte array"), paramArrayOfByte);
    }
    catch (InvalidProtocolBufferException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  public BuilderType mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      paramArrayOfByte = CodedInputStream.a(paramArrayOfByte, paramInt1, paramInt2);
      mergeFrom(paramArrayOfByte, paramExtensionRegistryLite);
      paramArrayOfByte.a(0);
      return this;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException(getReadingExceptionMessage("byte array"), paramArrayOfByte);
    }
    catch (InvalidProtocolBufferException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  public BuilderType mergeFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramExtensionRegistryLite);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.AbstractMessageLite.Builder
 * JD-Core Version:    0.7.0.1
 */