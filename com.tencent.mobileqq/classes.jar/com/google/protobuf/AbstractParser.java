package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract class AbstractParser<MessageType extends MessageLite>
  implements Parser<MessageType>
{
  private static final ExtensionRegistryLite EMPTY_REGISTRY = ;
  
  private MessageType checkMessageInitialized(MessageType paramMessageType)
  {
    if (paramMessageType != null)
    {
      if (paramMessageType.isInitialized()) {
        return paramMessageType;
      }
      throw newUninitializedMessageException(paramMessageType).asInvalidProtocolBufferException().setUnfinishedMessage(paramMessageType);
    }
    return paramMessageType;
  }
  
  private UninitializedMessageException newUninitializedMessageException(MessageType paramMessageType)
  {
    if ((paramMessageType instanceof AbstractMessageLite)) {
      return ((AbstractMessageLite)paramMessageType).newUninitializedMessageException();
    }
    return new UninitializedMessageException(paramMessageType);
  }
  
  public MessageType parseDelimitedFrom(InputStream paramInputStream)
  {
    return parseDelimitedFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialDelimitedFrom(paramInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(ByteString paramByteString)
  {
    return parseFrom(paramByteString, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialFrom(paramByteString, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(CodedInputStream paramCodedInputStream)
  {
    return parseFrom(paramCodedInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized((MessageLite)parsePartialFrom(paramCodedInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(InputStream paramInputStream)
  {
    return parseFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialFrom(paramInputStream, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(ByteBuffer paramByteBuffer)
  {
    return parseFrom(paramByteBuffer, EMPTY_REGISTRY);
  }
  
  /* Error */
  public MessageType parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 108	com/google/protobuf/CodedInputStream:a	(Ljava/nio/ByteBuffer;)Lcom/google/protobuf/CodedInputStream;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 92	com/google/protobuf/AbstractParser:parsePartialFrom	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Ljava/lang/Object;
    //   11: checkcast 27	com/google/protobuf/MessageLite
    //   14: astore_2
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 111	com/google/protobuf/CodedInputStream:a	(I)V
    //   20: aload_0
    //   21: aload_2
    //   22: invokespecial 69	com/google/protobuf/AbstractParser:checkMessageInitialized	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   25: areturn
    //   26: astore_1
    //   27: aload_1
    //   28: aload_2
    //   29: invokevirtual 47	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   32: athrow
    //   33: astore_1
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	AbstractParser
    //   0	36	1	paramByteBuffer	ByteBuffer
    //   0	36	2	paramExtensionRegistryLite	ExtensionRegistryLite
    // Exception table:
    //   from	to	target	type
    //   15	20	26	com/google/protobuf/InvalidProtocolBufferException
    //   0	15	33	com/google/protobuf/InvalidProtocolBufferException
    //   27	33	33	com/google/protobuf/InvalidProtocolBufferException
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte)
  {
    return parseFrom(paramArrayOfByte, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return parseFrom(paramArrayOfByte, paramInt1, paramInt2, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return checkMessageInitialized(parsePartialFrom(paramArrayOfByte, paramInt1, paramInt2, paramExtensionRegistryLite));
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return parseFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramExtensionRegistryLite);
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream paramInputStream)
  {
    return parsePartialDelimitedFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      int i = paramInputStream.read();
      if (i == -1) {
        return null;
      }
      i = CodedInputStream.a(i, paramInputStream);
      return parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(paramInputStream, i), paramExtensionRegistryLite);
    }
    catch (IOException paramInputStream)
    {
      throw new InvalidProtocolBufferException(paramInputStream);
    }
  }
  
  public MessageType parsePartialFrom(ByteString paramByteString)
  {
    return parsePartialFrom(paramByteString, EMPTY_REGISTRY);
  }
  
  /* Error */
  public MessageType parsePartialFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 174	com/google/protobuf/ByteString:newCodedInput	()Lcom/google/protobuf/CodedInputStream;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 92	com/google/protobuf/AbstractParser:parsePartialFrom	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Ljava/lang/Object;
    //   11: checkcast 27	com/google/protobuf/MessageLite
    //   14: astore_2
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 111	com/google/protobuf/CodedInputStream:a	(I)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_1
    //   23: aload_1
    //   24: aload_2
    //   25: invokevirtual 47	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   28: athrow
    //   29: astore_1
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	AbstractParser
    //   0	32	1	paramByteString	ByteString
    //   0	32	2	paramExtensionRegistryLite	ExtensionRegistryLite
    // Exception table:
    //   from	to	target	type
    //   15	20	22	com/google/protobuf/InvalidProtocolBufferException
    //   0	15	29	com/google/protobuf/InvalidProtocolBufferException
    //   23	29	29	com/google/protobuf/InvalidProtocolBufferException
  }
  
  public MessageType parsePartialFrom(CodedInputStream paramCodedInputStream)
  {
    return (MessageLite)parsePartialFrom(paramCodedInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(InputStream paramInputStream)
  {
    return parsePartialFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    paramInputStream = CodedInputStream.a(paramInputStream);
    paramExtensionRegistryLite = (MessageLite)parsePartialFrom(paramInputStream, paramExtensionRegistryLite);
    try
    {
      paramInputStream.a(0);
      return paramExtensionRegistryLite;
    }
    catch (InvalidProtocolBufferException paramInputStream)
    {
      throw paramInputStream.setUnfinishedMessage(paramExtensionRegistryLite);
    }
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfByte)
  {
    return parsePartialFrom(paramArrayOfByte, 0, paramArrayOfByte.length, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return parsePartialFrom(paramArrayOfByte, paramInt1, paramInt2, EMPTY_REGISTRY);
  }
  
  /* Error */
  public MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: iload_3
    //   3: invokestatic 180	com/google/protobuf/CodedInputStream:a	([BII)Lcom/google/protobuf/CodedInputStream;
    //   6: astore_1
    //   7: aload_0
    //   8: aload_1
    //   9: aload 4
    //   11: invokevirtual 92	com/google/protobuf/AbstractParser:parsePartialFrom	(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Ljava/lang/Object;
    //   14: checkcast 27	com/google/protobuf/MessageLite
    //   17: astore 4
    //   19: aload_1
    //   20: iconst_0
    //   21: invokevirtual 111	com/google/protobuf/CodedInputStream:a	(I)V
    //   24: aload 4
    //   26: areturn
    //   27: astore_1
    //   28: aload_1
    //   29: aload 4
    //   31: invokevirtual 47	com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   34: athrow
    //   35: astore_1
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	AbstractParser
    //   0	38	1	paramArrayOfByte	byte[]
    //   0	38	2	paramInt1	int
    //   0	38	3	paramInt2	int
    //   0	38	4	paramExtensionRegistryLite	ExtensionRegistryLite
    // Exception table:
    //   from	to	target	type
    //   19	24	27	com/google/protobuf/InvalidProtocolBufferException
    //   0	19	35	com/google/protobuf/InvalidProtocolBufferException
    //   28	35	35	com/google/protobuf/InvalidProtocolBufferException
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return parsePartialFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramExtensionRegistryLite);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.AbstractParser
 * JD-Core Version:    0.7.0.1
 */