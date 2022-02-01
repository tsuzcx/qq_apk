package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$OneofOptions$Builder
  extends GeneratedMessageV3.ExtendableBuilder<DescriptorProtos.OneofOptions, Builder>
  implements DescriptorProtos.OneofOptionsOrBuilder
{
  private int a;
  private List<DescriptorProtos.UninterpretedOption> b = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> c;
  
  private DescriptorProtos$OneofOptions$Builder()
  {
    i();
  }
  
  private DescriptorProtos$OneofOptions$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    i();
  }
  
  private void i()
  {
    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
      k();
    }
  }
  
  private void j()
  {
    if ((this.a & 0x1) == 0)
    {
      this.b = new ArrayList(this.b);
      this.a |= 0x1;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> k()
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
    super.g();
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
    //   2: getstatic 90	com/google/protobuf/DescriptorProtos$OneofOptions:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 96 3 0
    //   12: checkcast 86	com/google/protobuf/DescriptorProtos$OneofOptions
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 99	com/google/protobuf/DescriptorProtos$OneofOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$OneofOptions;)Lcom/google/protobuf/DescriptorProtos$OneofOptions$Builder;
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
    //   39: checkcast 86	com/google/protobuf/DescriptorProtos$OneofOptions
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 107	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 99	com/google/protobuf/DescriptorProtos$OneofOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$OneofOptions;)Lcom/google/protobuf/DescriptorProtos$OneofOptions$Builder;
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
  
  public Builder a(DescriptorProtos.OneofOptions paramOneofOptions)
  {
    if (paramOneofOptions == DescriptorProtos.OneofOptions.getDefaultInstance()) {
      return this;
    }
    if (this.c == null)
    {
      if (!DescriptorProtos.OneofOptions.access$20800(paramOneofOptions).isEmpty())
      {
        if (this.b.isEmpty())
        {
          this.b = DescriptorProtos.OneofOptions.access$20800(paramOneofOptions);
          this.a &= 0xFFFFFFFE;
        }
        else
        {
          j();
          this.b.addAll(DescriptorProtos.OneofOptions.access$20800(paramOneofOptions));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.OneofOptions.access$20800(paramOneofOptions).isEmpty()) {
      if (this.c.d())
      {
        this.c.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.c = null;
        this.b = DescriptorProtos.OneofOptions.access$20800(paramOneofOptions);
        this.a &= 0xFFFFFFFE;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = k();
        }
        this.c = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.c.a(DescriptorProtos.OneofOptions.access$20800(paramOneofOptions));
      }
    }
    a(paramOneofOptions);
    b(paramOneofOptions.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(Descriptors.FieldDescriptor paramFieldDescriptor)
  {
    return (Builder)super.b(paramFieldDescriptor);
  }
  
  public Builder a(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt, Object paramObject)
  {
    return (Builder)super.b(paramFieldDescriptor, paramInt, paramObject);
  }
  
  public Builder a(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (Builder)super.d(paramFieldDescriptor, paramObject);
  }
  
  public Builder a(Descriptors.OneofDescriptor paramOneofDescriptor)
  {
    return (Builder)super.clearOneof(paramOneofDescriptor);
  }
  
  public Builder a(Message paramMessage)
  {
    if ((paramMessage instanceof DescriptorProtos.OneofOptions)) {
      return a((DescriptorProtos.OneofOptions)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public DescriptorProtos.UninterpretedOption a(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.c;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.UninterpretedOption)this.b.get(paramInt);
    }
    return (DescriptorProtos.UninterpretedOption)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public Builder b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (Builder)super.c(paramFieldDescriptor, paramObject);
  }
  
  public final Builder b(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.mergeUnknownFields(paramUnknownFieldSet);
  }
  
  public DescriptorProtos.OneofOptions b()
  {
    return DescriptorProtos.OneofOptions.getDefaultInstance();
  }
  
  public DescriptorProtos.OneofOptions c()
  {
    DescriptorProtos.OneofOptions localOneofOptions = d();
    if (localOneofOptions.isInitialized()) {
      return localOneofOptions;
    }
    throw newUninitializedMessageException(localOneofOptions);
  }
  
  public DescriptorProtos.OneofOptions d()
  {
    DescriptorProtos.OneofOptions localOneofOptions = new DescriptorProtos.OneofOptions(this, null);
    int i = this.a;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.c;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((i & 0x1) != 0)
      {
        this.b = Collections.unmodifiableList(this.b);
        this.a &= 0xFFFFFFFE;
      }
      DescriptorProtos.OneofOptions.access$20802(localOneofOptions, this.b);
    }
    else
    {
      DescriptorProtos.OneofOptions.access$20802(localOneofOptions, localRepeatedFieldBuilderV3.f());
    }
    onBuilt();
    return localOneofOptions;
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
    return DescriptorProtos.H();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.I().a(DescriptorProtos.OneofOptions.class, Builder.class);
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
    return h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.OneofOptions.Builder
 * JD-Core Version:    0.7.0.1
 */