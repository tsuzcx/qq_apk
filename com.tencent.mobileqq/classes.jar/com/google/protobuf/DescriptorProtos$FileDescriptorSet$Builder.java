package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileDescriptorSet$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.FileDescriptorSetOrBuilder
{
  private int a;
  private List<DescriptorProtos.FileDescriptorProto> b = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> c;
  
  private DescriptorProtos$FileDescriptorSet$Builder()
  {
    g();
  }
  
  private DescriptorProtos$FileDescriptorSet$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    g();
  }
  
  private void g()
  {
    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
      i();
    }
  }
  
  private void h()
  {
    if ((this.a & 0x1) == 0)
    {
      this.b = new ArrayList(this.b);
      this.a |= 0x1;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> i()
  {
    if (this.c == null)
    {
      List localList = this.b;
      int i = this.a;
      boolean bool = true;
      if ((i & 0x1) == 0) {
        bool = false;
      }
      this.c = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.b = null;
    }
    return this.c;
  }
  
  public DescriptorProtos.FileDescriptorProto a(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.c;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.FileDescriptorProto)this.b.get(paramInt);
    }
    return (DescriptorProtos.FileDescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public Builder a()
  {
    super.clear();
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.c;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.b = Collections.emptyList();
      this.a &= 0xFFFFFFFE;
      return this;
    }
    localRepeatedFieldBuilderV3.e();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 102	com/google/protobuf/DescriptorProtos$FileDescriptorSet:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 108 3 0
    //   12: checkcast 98	com/google/protobuf/DescriptorProtos$FileDescriptorSet
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 111	com/google/protobuf/DescriptorProtos$FileDescriptorSet$Builder:a	(Lcom/google/protobuf/DescriptorProtos$FileDescriptorSet;)Lcom/google/protobuf/DescriptorProtos$FileDescriptorSet$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 115	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 98	com/google/protobuf/DescriptorProtos$FileDescriptorSet
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 119	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 111	com/google/protobuf/DescriptorProtos$FileDescriptorSet$Builder:a	(Lcom/google/protobuf/DescriptorProtos$FileDescriptorSet;)Lcom/google/protobuf/DescriptorProtos$FileDescriptorSet$Builder;
    //   58: pop
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	Builder
    //   0	61	1	paramCodedInputStream	CodedInputStream
    //   0	61	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   1	29	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   35	43	28	finally
    //   2	16	34	com/google/protobuf/InvalidProtocolBufferException
    //   43	48	48	finally
  }
  
  public Builder a(DescriptorProtos.FileDescriptorSet paramFileDescriptorSet)
  {
    if (paramFileDescriptorSet == DescriptorProtos.FileDescriptorSet.getDefaultInstance()) {
      return this;
    }
    if (this.c == null)
    {
      if (!DescriptorProtos.FileDescriptorSet.access$500(paramFileDescriptorSet).isEmpty())
      {
        if (this.b.isEmpty())
        {
          this.b = DescriptorProtos.FileDescriptorSet.access$500(paramFileDescriptorSet);
          this.a &= 0xFFFFFFFE;
        }
        else
        {
          h();
          this.b.addAll(DescriptorProtos.FileDescriptorSet.access$500(paramFileDescriptorSet));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FileDescriptorSet.access$500(paramFileDescriptorSet).isEmpty()) {
      if (this.c.d())
      {
        this.c.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.c = null;
        this.b = DescriptorProtos.FileDescriptorSet.access$500(paramFileDescriptorSet);
        this.a &= 0xFFFFFFFE;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = i();
        }
        this.c = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.c.a(DescriptorProtos.FileDescriptorSet.access$500(paramFileDescriptorSet));
      }
    }
    b(paramFileDescriptorSet.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return (Builder)super.clearField(paramFieldDescriptor);
  }
  
  public Builder a(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt, Object paramObject)
  {
    return (Builder)super.setRepeatedField(paramFieldDescriptor, paramInt, paramObject);
  }
  
  public Builder a(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (Builder)super.setField(paramFieldDescriptor, paramObject);
  }
  
  public Builder a(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    return (Builder)super.clearOneof(paramOneofDescriptor);
  }
  
  public Builder a(Message paramMessage)
  {
    if ((paramMessage instanceof DescriptorProtos.FileDescriptorSet)) {
      return a((DescriptorProtos.FileDescriptorSet)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (Builder)super.addRepeatedField(paramFieldDescriptor, paramObject);
  }
  
  public final Builder b(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.mergeUnknownFields(paramUnknownFieldSet);
  }
  
  public DescriptorProtos.FileDescriptorSet b()
  {
    return DescriptorProtos.FileDescriptorSet.getDefaultInstance();
  }
  
  public DescriptorProtos.FileDescriptorSet c()
  {
    DescriptorProtos.FileDescriptorSet localFileDescriptorSet = d();
    if (localFileDescriptorSet.isInitialized()) {
      return localFileDescriptorSet;
    }
    throw newUninitializedMessageException(localFileDescriptorSet);
  }
  
  public DescriptorProtos.FileDescriptorSet d()
  {
    DescriptorProtos.FileDescriptorSet localFileDescriptorSet = new DescriptorProtos.FileDescriptorSet(this, null);
    int i = this.a;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.c;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((i & 0x1) != 0)
      {
        this.b = Collections.unmodifiableList(this.b);
        this.a &= 0xFFFFFFFE;
      }
      DescriptorProtos.FileDescriptorSet.access$502(localFileDescriptorSet, this.b);
    }
    else
    {
      DescriptorProtos.FileDescriptorSet.access$502(localFileDescriptorSet, localRepeatedFieldBuilderV3.f());
    }
    onBuilt();
    return localFileDescriptorSet;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public int f()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.c;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.b.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.b();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.c().a(DescriptorProtos.FileDescriptorSet.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    int i = 0;
    while (i < f())
    {
      if (!a(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FileDescriptorSet.Builder
 * JD-Core Version:    0.7.0.1
 */