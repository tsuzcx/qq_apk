package com.google.protobuf;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessage
  extends AbstractMessage
  implements Serializable
{
  protected static boolean alwaysUseFieldBuilders = false;
  private static final long serialVersionUID = 1L;
  protected UnknownFieldSet unknownFields;
  
  protected GeneratedMessage()
  {
    this.unknownFields = UnknownFieldSet.b();
  }
  
  protected GeneratedMessage(GeneratedMessage.Builder<?> paramBuilder)
  {
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private static <MessageType extends GeneratedMessage.ExtendableMessage<MessageType>, T> Extension<MessageType, T> a(ExtensionLite<MessageType, T> paramExtensionLite)
  {
    if (!paramExtensionLite.c()) {
      return (Extension)paramExtensionLite;
    }
    throw new IllegalArgumentException("Expected non-lite extension.");
  }
  
  private static Object a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if (!(paramMethod instanceof RuntimeException))
      {
        if ((paramMethod instanceof Error)) {
          throw ((Error)paramMethod);
        }
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
      }
      throw ((RuntimeException)paramMethod);
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
  }
  
  private static Method a(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramVarArgs = paramClass.getMethod(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (NoSuchMethodException paramVarArgs)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Generated message class \"");
      localStringBuilder.append(paramClass.getName());
      localStringBuilder.append("\" missing method \"");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\".");
      throw new RuntimeException(localStringBuilder.toString(), paramVarArgs);
    }
  }
  
  private Map<Descriptors.FieldDescriptor, Object> a(boolean paramBoolean)
  {
    TreeMap localTreeMap = new TreeMap();
    List localList = GeneratedMessage.FieldAccessorTable.a(internalGetFieldAccessorTable()).f();
    int j;
    for (int i = 0; i < localList.size(); i = j + 1)
    {
      Descriptors.FieldDescriptor localFieldDescriptor = (Descriptors.FieldDescriptor)localList.get(i);
      Object localObject = localFieldDescriptor.w();
      if (localObject != null)
      {
        j = i + (((Descriptors.OneofDescriptor)localObject).d() - 1);
        if (!hasOneof((Descriptors.OneofDescriptor)localObject)) {
          continue;
        }
        localObject = getOneofFieldDescriptor((Descriptors.OneofDescriptor)localObject);
      }
      else
      {
        if (localFieldDescriptor.p())
        {
          localObject = (List)getField(localFieldDescriptor);
          j = i;
          if (((List)localObject).isEmpty()) {
            continue;
          }
          localTreeMap.put(localFieldDescriptor, localObject);
          j = i;
          continue;
        }
        j = i;
        localObject = localFieldDescriptor;
        if (!hasField(localFieldDescriptor))
        {
          j = i;
          continue;
        }
      }
      if ((paramBoolean) && (((Descriptors.FieldDescriptor)localObject).g() == Descriptors.FieldDescriptor.JavaType.STRING)) {
        localTreeMap.put(localObject, getFieldRaw((Descriptors.FieldDescriptor)localObject));
      } else {
        localTreeMap.put(localObject, getField((Descriptors.FieldDescriptor)localObject));
      }
    }
    return localTreeMap;
  }
  
  protected static int computeStringSize(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return CodedOutputStream.b(paramInt, (String)paramObject);
    }
    return CodedOutputStream.c(paramInt, (ByteString)paramObject);
  }
  
  protected static int computeStringSizeNoTag(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return CodedOutputStream.b((String)paramObject);
    }
    return CodedOutputStream.b((ByteString)paramObject);
  }
  
  static void enableAlwaysUseFieldBuildersForTesting()
  {
    alwaysUseFieldBuilders = true;
  }
  
  public static <ContainingType extends Message, Type> GeneratedMessage.GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(Class paramClass, Message paramMessage)
  {
    return new GeneratedMessage.GeneratedExtension(null, paramClass, paramMessage, Extension.ExtensionType.IMMUTABLE);
  }
  
  public static <ContainingType extends Message, Type> GeneratedMessage.GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(Class paramClass, Message paramMessage, String paramString1, String paramString2)
  {
    return new GeneratedMessage.GeneratedExtension(new GeneratedMessage.4(paramClass, paramString1, paramString2), paramClass, paramMessage, Extension.ExtensionType.MUTABLE);
  }
  
  public static <ContainingType extends Message, Type> GeneratedMessage.GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(Message paramMessage1, int paramInt, Class paramClass, Message paramMessage2)
  {
    return new GeneratedMessage.GeneratedExtension(new GeneratedMessage.2(paramMessage1, paramInt), paramClass, paramMessage2, Extension.ExtensionType.IMMUTABLE);
  }
  
  public static <ContainingType extends Message, Type> GeneratedMessage.GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(Message paramMessage1, String paramString, Class paramClass, Message paramMessage2)
  {
    return new GeneratedMessage.GeneratedExtension(new GeneratedMessage.3(paramMessage1, paramString), paramClass, paramMessage2, Extension.ExtensionType.MUTABLE);
  }
  
  protected static <M extends Message> M parseDelimitedWithIOException(Parser<M> paramParser, InputStream paramInputStream)
  {
    try
    {
      paramParser = (Message)paramParser.parseDelimitedFrom(paramInputStream);
      return paramParser;
    }
    catch (InvalidProtocolBufferException paramParser)
    {
      throw paramParser.unwrapIOException();
    }
  }
  
  protected static <M extends Message> M parseDelimitedWithIOException(Parser<M> paramParser, InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      paramParser = (Message)paramParser.parseDelimitedFrom(paramInputStream, paramExtensionRegistryLite);
      return paramParser;
    }
    catch (InvalidProtocolBufferException paramParser)
    {
      throw paramParser.unwrapIOException();
    }
  }
  
  protected static <M extends Message> M parseWithIOException(Parser<M> paramParser, CodedInputStream paramCodedInputStream)
  {
    try
    {
      paramParser = (Message)paramParser.parseFrom(paramCodedInputStream);
      return paramParser;
    }
    catch (InvalidProtocolBufferException paramParser)
    {
      throw paramParser.unwrapIOException();
    }
  }
  
  protected static <M extends Message> M parseWithIOException(Parser<M> paramParser, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      paramParser = (Message)paramParser.parseFrom(paramCodedInputStream, paramExtensionRegistryLite);
      return paramParser;
    }
    catch (InvalidProtocolBufferException paramParser)
    {
      throw paramParser.unwrapIOException();
    }
  }
  
  protected static <M extends Message> M parseWithIOException(Parser<M> paramParser, InputStream paramInputStream)
  {
    try
    {
      paramParser = (Message)paramParser.parseFrom(paramInputStream);
      return paramParser;
    }
    catch (InvalidProtocolBufferException paramParser)
    {
      throw paramParser.unwrapIOException();
    }
  }
  
  protected static <M extends Message> M parseWithIOException(Parser<M> paramParser, InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    try
    {
      paramParser = (Message)paramParser.parseFrom(paramInputStream, paramExtensionRegistryLite);
      return paramParser;
    }
    catch (InvalidProtocolBufferException paramParser)
    {
      throw paramParser.unwrapIOException();
    }
  }
  
  protected static void writeString(CodedOutputStream paramCodedOutputStream, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramCodedOutputStream.a(paramInt, (String)paramObject);
      return;
    }
    paramCodedOutputStream.a(paramInt, (ByteString)paramObject);
  }
  
  protected static void writeStringNoTag(CodedOutputStream paramCodedOutputStream, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramCodedOutputStream.a((String)paramObject);
      return;
    }
    paramCodedOutputStream.a((ByteString)paramObject);
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields()
  {
    return Collections.unmodifiableMap(a(false));
  }
  
  Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw()
  {
    return Collections.unmodifiableMap(a(true));
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return GeneratedMessage.FieldAccessorTable.a(internalGetFieldAccessorTable());
  }
  
  public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return GeneratedMessage.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).a(this);
  }
  
  Object getFieldRaw(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return GeneratedMessage.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).b(this);
  }
  
  public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    return GeneratedMessage.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramOneofDescriptor).b(this);
  }
  
  public Parser<? extends GeneratedMessage> getParserForType()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt)
  {
    return GeneratedMessage.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).a(this, paramInt);
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return GeneratedMessage.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).d(this);
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    this.memoizedSize = MessageReflection.a(this, getAllFieldsRaw());
    return this.memoizedSize;
  }
  
  public UnknownFieldSet getUnknownFields()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return GeneratedMessage.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).c(this);
  }
  
  public boolean hasOneof(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    return GeneratedMessage.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramOneofDescriptor).a(this);
  }
  
  protected abstract GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable();
  
  protected MapField internalGetMapField(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("No map fields found in ");
    localStringBuilder.append(getClass().getName());
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  public boolean isInitialized()
  {
    Iterator localIterator = getDescriptorForType().f().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject = (Descriptors.FieldDescriptor)localIterator.next();
        if ((((Descriptors.FieldDescriptor)localObject).n()) && (!hasField((Descriptors.FieldDescriptor)localObject))) {
          return false;
        }
        if (((Descriptors.FieldDescriptor)localObject).g() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        {
          if (((Descriptors.FieldDescriptor)localObject).p())
          {
            localObject = ((List)getField((Descriptors.FieldDescriptor)localObject)).iterator();
            if (!((Iterator)localObject).hasNext()) {
              continue;
            }
            if (((Message)((Iterator)localObject).next()).isInitialized()) {
              break;
            }
            return false;
          }
          if ((hasField((Descriptors.FieldDescriptor)localObject)) && (!((Message)getField((Descriptors.FieldDescriptor)localObject)).isInitialized())) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  protected void makeExtensionsImmutable() {}
  
  protected Message.Builder newBuilderForType(AbstractMessage.BuilderParent paramBuilderParent)
  {
    return newBuilderForType(new GeneratedMessage.1(this, paramBuilderParent));
  }
  
  protected abstract Message.Builder newBuilderForType(GeneratedMessage.BuilderParent paramBuilderParent);
  
  protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
  {
    return paramBuilder.a(paramInt, paramCodedInputStream);
  }
  
  protected Object writeReplace()
  {
    return new GeneratedMessageLite.SerializedForm(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    MessageReflection.a(this, getAllFieldsRaw(), paramCodedOutputStream, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessage
 * JD-Core Version:    0.7.0.1
 */