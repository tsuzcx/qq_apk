package com.google.protobuf;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public abstract class GeneratedMessageV3
  extends AbstractMessage
  implements Serializable
{
  protected static boolean alwaysUseFieldBuilders = false;
  private static final long serialVersionUID = 1L;
  protected UnknownFieldSet unknownFields;
  
  protected GeneratedMessageV3()
  {
    this.unknownFields = UnknownFieldSet.b();
  }
  
  protected GeneratedMessageV3(GeneratedMessageV3.Builder<?> paramBuilder)
  {
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  protected static boolean canUseUnsafe()
  {
    return (UnsafeUtil.a()) && (UnsafeUtil.b());
  }
  
  private static <MessageType extends GeneratedMessageV3.ExtendableMessage<MessageType>, T> Extension<MessageType, T> checkNotLite(ExtensionLite<MessageType, T> paramExtensionLite)
  {
    if (!paramExtensionLite.c()) {
      return (Extension)paramExtensionLite;
    }
    throw new IllegalArgumentException("Expected non-lite extension.");
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
  
  protected static Internal.BooleanList emptyBooleanList()
  {
    return BooleanArrayList.d();
  }
  
  protected static Internal.DoubleList emptyDoubleList()
  {
    return DoubleArrayList.d();
  }
  
  protected static Internal.FloatList emptyFloatList()
  {
    return FloatArrayList.d();
  }
  
  protected static Internal.IntList emptyIntList()
  {
    return IntArrayList.d();
  }
  
  protected static Internal.LongList emptyLongList()
  {
    return LongArrayList.d();
  }
  
  static void enableAlwaysUseFieldBuildersForTesting()
  {
    alwaysUseFieldBuilders = true;
  }
  
  private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean paramBoolean)
  {
    TreeMap localTreeMap = new TreeMap();
    List localList = GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable()).f();
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
  
  private static Method getMethodOrDie(Class paramClass, String paramString, Class... paramVarArgs)
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
  
  private static Object invokeOrDie(Method paramMethod, Object paramObject, Object... paramVarArgs)
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
  
  private static <V> void maybeSerializeBooleanEntryTo(CodedOutputStream paramCodedOutputStream, Map<Boolean, V> paramMap, MapEntry<Boolean, V> paramMapEntry, int paramInt, boolean paramBoolean)
  {
    if (paramMap.containsKey(Boolean.valueOf(paramBoolean))) {
      paramCodedOutputStream.a(paramInt, paramMapEntry.c().a(Boolean.valueOf(paramBoolean)).b(paramMap.get(Boolean.valueOf(paramBoolean))).e());
    }
  }
  
  protected static Internal.BooleanList mutableCopy(Internal.BooleanList paramBooleanList)
  {
    int i = paramBooleanList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    }
    return paramBooleanList.a(i);
  }
  
  protected static Internal.DoubleList mutableCopy(Internal.DoubleList paramDoubleList)
  {
    int i = paramDoubleList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    }
    return paramDoubleList.a(i);
  }
  
  protected static Internal.FloatList mutableCopy(Internal.FloatList paramFloatList)
  {
    int i = paramFloatList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    }
    return paramFloatList.a(i);
  }
  
  protected static Internal.IntList mutableCopy(Internal.IntList paramIntList)
  {
    int i = paramIntList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    }
    return paramIntList.a(i);
  }
  
  protected static Internal.LongList mutableCopy(Internal.LongList paramLongList)
  {
    int i = paramLongList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    }
    return paramLongList.a(i);
  }
  
  protected static Internal.BooleanList newBooleanList()
  {
    return new BooleanArrayList();
  }
  
  protected static Internal.DoubleList newDoubleList()
  {
    return new DoubleArrayList();
  }
  
  protected static Internal.FloatList newFloatList()
  {
    return new FloatArrayList();
  }
  
  protected static Internal.IntList newIntList()
  {
    return new IntArrayList();
  }
  
  protected static Internal.LongList newLongList()
  {
    return new LongArrayList();
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
  
  protected static <V> void serializeBooleanMapTo(CodedOutputStream paramCodedOutputStream, MapField<Boolean, V> paramMapField, MapEntry<Boolean, V> paramMapEntry, int paramInt)
  {
    paramMapField = paramMapField.a();
    if (!paramCodedOutputStream.a())
    {
      serializeMapTo(paramCodedOutputStream, paramMapField, paramMapEntry, paramInt);
      return;
    }
    maybeSerializeBooleanEntryTo(paramCodedOutputStream, paramMapField, paramMapEntry, paramInt, false);
    maybeSerializeBooleanEntryTo(paramCodedOutputStream, paramMapField, paramMapEntry, paramInt, true);
  }
  
  protected static <V> void serializeIntegerMapTo(CodedOutputStream paramCodedOutputStream, MapField<Integer, V> paramMapField, MapEntry<Integer, V> paramMapEntry, int paramInt)
  {
    paramMapField = paramMapField.a();
    if (!paramCodedOutputStream.a())
    {
      serializeMapTo(paramCodedOutputStream, paramMapField, paramMapEntry, paramInt);
      return;
    }
    int[] arrayOfInt = new int[paramMapField.size()];
    Iterator localIterator = paramMapField.keySet().iterator();
    int j = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfInt[i] = ((Integer)localIterator.next()).intValue();
      i += 1;
    }
    Arrays.sort(arrayOfInt);
    int k = arrayOfInt.length;
    i = j;
    while (i < k)
    {
      j = arrayOfInt[i];
      paramCodedOutputStream.a(paramInt, paramMapEntry.c().a(Integer.valueOf(j)).b(paramMapField.get(Integer.valueOf(j))).e());
      i += 1;
    }
  }
  
  protected static <V> void serializeLongMapTo(CodedOutputStream paramCodedOutputStream, MapField<Long, V> paramMapField, MapEntry<Long, V> paramMapEntry, int paramInt)
  {
    paramMapField = paramMapField.a();
    if (!paramCodedOutputStream.a())
    {
      serializeMapTo(paramCodedOutputStream, paramMapField, paramMapEntry, paramInt);
      return;
    }
    long[] arrayOfLong = new long[paramMapField.size()];
    Iterator localIterator = paramMapField.keySet().iterator();
    int j = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfLong[i] = ((Long)localIterator.next()).longValue();
      i += 1;
    }
    Arrays.sort(arrayOfLong);
    int k = arrayOfLong.length;
    i = j;
    while (i < k)
    {
      long l = arrayOfLong[i];
      paramCodedOutputStream.a(paramInt, paramMapEntry.c().a(Long.valueOf(l)).b(paramMapField.get(Long.valueOf(l))).e());
      i += 1;
    }
  }
  
  private static <K, V> void serializeMapTo(CodedOutputStream paramCodedOutputStream, Map<K, V> paramMap, MapEntry<K, V> paramMapEntry, int paramInt)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramCodedOutputStream.a(paramInt, paramMapEntry.c().a(localEntry.getKey()).b(localEntry.getValue()).e());
    }
  }
  
  protected static <V> void serializeStringMapTo(CodedOutputStream paramCodedOutputStream, MapField<String, V> paramMapField, MapEntry<String, V> paramMapEntry, int paramInt)
  {
    paramMapField = paramMapField.a();
    if (!paramCodedOutputStream.a())
    {
      serializeMapTo(paramCodedOutputStream, paramMapField, paramMapEntry, paramInt);
      return;
    }
    String[] arrayOfString = new String[paramMapField.size()];
    arrayOfString = (String[])paramMapField.keySet().toArray(arrayOfString);
    Arrays.sort(arrayOfString);
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      paramCodedOutputStream.a(paramInt, paramMapEntry.c().a(str).b(paramMapField.get(str)).e());
      i += 1;
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
    return Collections.unmodifiableMap(getAllFieldsMutable(false));
  }
  
  Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw()
  {
    return Collections.unmodifiableMap(getAllFieldsMutable(true));
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable());
  }
  
  public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).a(this);
  }
  
  Object getFieldRaw(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).b(this);
  }
  
  public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramOneofDescriptor).b(this);
  }
  
  public Parser<? extends GeneratedMessageV3> getParserForType()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).a(this, paramInt);
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).d(this);
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
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).c(this);
  }
  
  public boolean hasOneof(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramOneofDescriptor).a(this);
  }
  
  protected abstract GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable();
  
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
    return newBuilderForType(new GeneratedMessageV3.1(this, paramBuilderParent));
  }
  
  protected abstract Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent);
  
  protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter paramUnusedPrivateParameter)
  {
    throw new UnsupportedOperationException("This method must be overridden by the subclass.");
  }
  
  protected boolean parseUnknownField(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
  {
    if (paramCodedInputStream.w()) {
      return paramCodedInputStream.b(paramInt);
    }
    return paramBuilder.a(paramInt, paramCodedInputStream);
  }
  
  protected boolean parseUnknownFieldProto3(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, int paramInt)
  {
    return parseUnknownField(paramCodedInputStream, paramBuilder, paramExtensionRegistryLite, paramInt);
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
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3
 * JD-Core Version:    0.7.0.1
 */