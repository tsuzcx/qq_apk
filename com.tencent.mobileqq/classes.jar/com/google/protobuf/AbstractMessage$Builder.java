package com.google.protobuf;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AbstractMessage$Builder<BuilderType extends Builder<BuilderType>>
  extends AbstractMessageLite.Builder
  implements Message.Builder
{
  protected static UninitializedMessageException newUninitializedMessageException(Message paramMessage)
  {
    return new UninitializedMessageException(MessageReflection.b(paramMessage));
  }
  
  public BuilderType clear()
  {
    Iterator localIterator = getAllFields().entrySet().iterator();
    while (localIterator.hasNext()) {
      clearField((Descriptors.FieldDescriptor)((Map.Entry)localIterator.next()).getKey());
    }
    return this;
  }
  
  public BuilderType clearOneof(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    throw new UnsupportedOperationException("clearOneof() is not implemented.");
  }
  
  public BuilderType clone()
  {
    throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
  }
  
  void dispose()
  {
    throw new IllegalStateException("Should be overridden by subclasses.");
  }
  
  public List<String> findInitializationErrors()
  {
    return MessageReflection.b(this);
  }
  
  public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
  }
  
  public String getInitializationErrorString()
  {
    return MessageReflection.a(findInitializationErrors());
  }
  
  public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
  }
  
  public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt)
  {
    throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
  }
  
  public boolean hasOneof(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    throw new UnsupportedOperationException("hasOneof() is not implemented.");
  }
  
  protected BuilderType internalMergeFrom(AbstractMessageLite paramAbstractMessageLite)
  {
    return mergeFrom((Message)paramAbstractMessageLite);
  }
  
  void markClean()
  {
    throw new IllegalStateException("Should be overridden by subclasses.");
  }
  
  public boolean mergeDelimitedFrom(InputStream paramInputStream)
  {
    return super.mergeDelimitedFrom(paramInputStream);
  }
  
  public boolean mergeDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return super.mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite);
  }
  
  public BuilderType mergeFrom(ByteString paramByteString)
  {
    return (Builder)super.mergeFrom(paramByteString);
  }
  
  public BuilderType mergeFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Builder)super.mergeFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public BuilderType mergeFrom(CodedInputStream paramCodedInputStream)
  {
    return mergeFrom(paramCodedInputStream, ExtensionRegistry.a());
  }
  
  public BuilderType mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    UnknownFieldSet.Builder localBuilder;
    if (paramCodedInputStream.w()) {
      localBuilder = null;
    } else {
      localBuilder = UnknownFieldSet.a(getUnknownFields());
    }
    int i;
    MessageReflection.BuilderAdapter localBuilderAdapter;
    do
    {
      i = paramCodedInputStream.a();
      if (i == 0) {
        break;
      }
      localBuilderAdapter = new MessageReflection.BuilderAdapter(this);
    } while (MessageReflection.a(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, getDescriptorForType(), localBuilderAdapter, i));
    if (localBuilder != null) {
      setUnknownFields(localBuilder.a());
    }
    return this;
  }
  
  public BuilderType mergeFrom(Message paramMessage)
  {
    return mergeFrom(paramMessage, paramMessage.getAllFields());
  }
  
  BuilderType mergeFrom(Message paramMessage, Map<Descriptors.FieldDescriptor, Object> paramMap)
  {
    if (paramMessage.getDescriptorForType() == getDescriptorForType())
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)((Map.Entry)localObject).getKey();
        if (localFieldDescriptor.p())
        {
          localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
          while (((Iterator)localObject).hasNext()) {
            addRepeatedField(localFieldDescriptor, ((Iterator)localObject).next());
          }
        }
        else if (localFieldDescriptor.g() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        {
          Message localMessage = (Message)getField(localFieldDescriptor);
          if (localMessage == localMessage.getDefaultInstanceForType()) {
            setField(localFieldDescriptor, ((Map.Entry)localObject).getValue());
          } else {
            setField(localFieldDescriptor, localMessage.newBuilderForType().mergeFrom(localMessage).mergeFrom((Message)((Map.Entry)localObject).getValue()).build());
          }
        }
        else
        {
          setField(localFieldDescriptor, ((Map.Entry)localObject).getValue());
        }
      }
      mergeUnknownFields(paramMessage.getUnknownFields());
      return this;
    }
    paramMessage = new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
    for (;;)
    {
      throw paramMessage;
    }
  }
  
  public BuilderType mergeFrom(InputStream paramInputStream)
  {
    return (Builder)super.mergeFrom(paramInputStream);
  }
  
  public BuilderType mergeFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Builder)super.mergeFrom(paramInputStream, paramExtensionRegistryLite);
  }
  
  public BuilderType mergeFrom(byte[] paramArrayOfByte)
  {
    return (Builder)super.mergeFrom(paramArrayOfByte);
  }
  
  public BuilderType mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (Builder)super.mergeFrom(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public BuilderType mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Builder)super.mergeFrom(paramArrayOfByte, paramInt1, paramInt2, paramExtensionRegistryLite);
  }
  
  public BuilderType mergeFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Builder)super.mergeFrom(paramArrayOfByte, paramExtensionRegistryLite);
  }
  
  public BuilderType mergeUnknownFields(UnknownFieldSet paramUnknownFieldSet)
  {
    setUnknownFields(UnknownFieldSet.a(getUnknownFields()).a(paramUnknownFieldSet).a());
    return this;
  }
  
  public String toString()
  {
    return TextFormat.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.AbstractMessage.Builder
 * JD-Core Version:    0.7.0.1
 */