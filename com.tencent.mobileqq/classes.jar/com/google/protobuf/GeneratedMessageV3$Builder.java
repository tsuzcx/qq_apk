package com.google.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessageV3$Builder<BuilderType extends Builder<BuilderType>>
  extends AbstractMessage.Builder<BuilderType>
{
  private GeneratedMessageV3.BuilderParent builderParent;
  private boolean isClean;
  private Builder<BuilderType>.BuilderParentImpl meAsParent;
  private UnknownFieldSet unknownFields = UnknownFieldSet.b();
  
  protected GeneratedMessageV3$Builder()
  {
    this(null);
  }
  
  protected GeneratedMessageV3$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    this.builderParent = paramBuilderParent;
  }
  
  private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable()
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
      localTreeMap.put(localObject, getField((Descriptors.FieldDescriptor)localObject));
    }
    return localTreeMap;
  }
  
  private BuilderType setUnknownFieldsInternal(UnknownFieldSet paramUnknownFieldSet)
  {
    this.unknownFields = paramUnknownFieldSet;
    onChanged();
    return this;
  }
  
  public BuilderType addRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).b(this, paramObject);
    return this;
  }
  
  public BuilderType clear()
  {
    this.unknownFields = UnknownFieldSet.b();
    onChanged();
    return this;
  }
  
  public BuilderType clearField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).d(this);
    return this;
  }
  
  public BuilderType clearOneof(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramOneofDescriptor).c(this);
    return this;
  }
  
  public BuilderType clone()
  {
    Builder localBuilder = (Builder)getDefaultInstanceForType().newBuilderForType();
    localBuilder.mergeFrom(buildPartial());
    return localBuilder;
  }
  
  void dispose()
  {
    this.builderParent = null;
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields()
  {
    return Collections.unmodifiableMap(getAllFieldsMutable());
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable());
  }
  
  public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    Object localObject = GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).a(this);
    if (paramFieldDescriptor.p()) {
      return Collections.unmodifiableList((List)localObject);
    }
    return localObject;
  }
  
  public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).e(this);
  }
  
  public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramOneofDescriptor).b(this);
  }
  
  protected GeneratedMessageV3.BuilderParent getParentForChildren()
  {
    if (this.meAsParent == null) {
      this.meAsParent = new GeneratedMessageV3.Builder.BuilderParentImpl(this, null);
    }
    return this.meAsParent;
  }
  
  public Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).a(this, paramInt);
  }
  
  public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).b(this, paramInt);
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).c(this);
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).b(this);
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
  
  protected MapField internalGetMutableMapField(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("No map fields found in ");
    localStringBuilder.append(getClass().getName());
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  protected boolean isClean()
  {
    return this.isClean;
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
  
  protected void markClean()
  {
    this.isClean = true;
  }
  
  public BuilderType mergeUnknownFields(UnknownFieldSet paramUnknownFieldSet)
  {
    return setUnknownFields(UnknownFieldSet.a(this.unknownFields).a(paramUnknownFieldSet).a());
  }
  
  public Message.Builder newBuilderForField(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).a();
  }
  
  protected void onBuilt()
  {
    if (this.builderParent != null) {
      markClean();
    }
  }
  
  protected final void onChanged()
  {
    if (this.isClean)
    {
      GeneratedMessageV3.BuilderParent localBuilderParent = this.builderParent;
      if (localBuilderParent != null)
      {
        localBuilderParent.a();
        this.isClean = false;
      }
    }
  }
  
  public BuilderType setField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).a(this, paramObject);
    return this;
  }
  
  public BuilderType setRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt, Object paramObject)
  {
    GeneratedMessageV3.FieldAccessorTable.a(internalGetFieldAccessorTable(), paramFieldDescriptor).a(this, paramInt, paramObject);
    return this;
  }
  
  public BuilderType setUnknownFields(UnknownFieldSet paramUnknownFieldSet)
  {
    return setUnknownFieldsInternal(paramUnknownFieldSet);
  }
  
  protected BuilderType setUnknownFieldsProto3(UnknownFieldSet paramUnknownFieldSet)
  {
    return setUnknownFieldsInternal(paramUnknownFieldSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.GeneratedMessageV3.Builder
 * JD-Core Version:    0.7.0.1
 */