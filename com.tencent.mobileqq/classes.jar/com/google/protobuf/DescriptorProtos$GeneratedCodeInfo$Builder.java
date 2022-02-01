package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$GeneratedCodeInfo$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.GeneratedCodeInfoOrBuilder
{
  private int a;
  private List<DescriptorProtos.GeneratedCodeInfo.Annotation> b = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.GeneratedCodeInfo.Annotation, DescriptorProtos.GeneratedCodeInfo.Annotation.Builder, DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder> c;
  
  private DescriptorProtos$GeneratedCodeInfo$Builder()
  {
    f();
  }
  
  private DescriptorProtos$GeneratedCodeInfo$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
      h();
    }
  }
  
  private void g()
  {
    if ((this.a & 0x1) == 0)
    {
      this.b = new ArrayList(this.b);
      this.a |= 0x1;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.GeneratedCodeInfo.Annotation, DescriptorProtos.GeneratedCodeInfo.Annotation.Builder, DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder> h()
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
    //   2: getstatic 90	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 96 3 0
    //   12: checkcast 86	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 99	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Builder:a	(Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo;)Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 103	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 86	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 107	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 99	com/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Builder:a	(Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo;)Lcom/google/protobuf/DescriptorProtos$GeneratedCodeInfo$Builder;
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
  
  public Builder a(DescriptorProtos.GeneratedCodeInfo paramGeneratedCodeInfo)
  {
    if (paramGeneratedCodeInfo == DescriptorProtos.GeneratedCodeInfo.getDefaultInstance()) {
      return this;
    }
    if (this.c == null)
    {
      if (!DescriptorProtos.GeneratedCodeInfo.access$30600(paramGeneratedCodeInfo).isEmpty())
      {
        if (this.b.isEmpty())
        {
          this.b = DescriptorProtos.GeneratedCodeInfo.access$30600(paramGeneratedCodeInfo);
          this.a &= 0xFFFFFFFE;
        }
        else
        {
          g();
          this.b.addAll(DescriptorProtos.GeneratedCodeInfo.access$30600(paramGeneratedCodeInfo));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.GeneratedCodeInfo.access$30600(paramGeneratedCodeInfo).isEmpty()) {
      if (this.c.d())
      {
        this.c.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.c = null;
        this.b = DescriptorProtos.GeneratedCodeInfo.access$30600(paramGeneratedCodeInfo);
        this.a &= 0xFFFFFFFE;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = h();
        }
        this.c = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.c.a(DescriptorProtos.GeneratedCodeInfo.access$30600(paramGeneratedCodeInfo));
      }
    }
    b(paramGeneratedCodeInfo.unknownFields);
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
    if ((paramMessage instanceof DescriptorProtos.GeneratedCodeInfo)) {
      return a((DescriptorProtos.GeneratedCodeInfo)paramMessage);
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
  
  public DescriptorProtos.GeneratedCodeInfo b()
  {
    return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
  }
  
  public DescriptorProtos.GeneratedCodeInfo c()
  {
    DescriptorProtos.GeneratedCodeInfo localGeneratedCodeInfo = d();
    if (localGeneratedCodeInfo.isInitialized()) {
      return localGeneratedCodeInfo;
    }
    throw newUninitializedMessageException(localGeneratedCodeInfo);
  }
  
  public DescriptorProtos.GeneratedCodeInfo d()
  {
    DescriptorProtos.GeneratedCodeInfo localGeneratedCodeInfo = new DescriptorProtos.GeneratedCodeInfo(this, null);
    int i = this.a;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.c;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((i & 0x1) != 0)
      {
        this.b = Collections.unmodifiableList(this.b);
        this.a &= 0xFFFFFFFE;
      }
      DescriptorProtos.GeneratedCodeInfo.access$30602(localGeneratedCodeInfo, this.b);
    }
    else
    {
      DescriptorProtos.GeneratedCodeInfo.access$30602(localGeneratedCodeInfo, localRepeatedFieldBuilderV3.f());
    }
    onBuilt();
    return localGeneratedCodeInfo;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.Z();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.aa().a(DescriptorProtos.GeneratedCodeInfo.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.Builder
 * JD-Core Version:    0.7.0.1
 */