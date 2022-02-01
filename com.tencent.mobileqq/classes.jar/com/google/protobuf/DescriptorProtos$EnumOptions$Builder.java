package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$EnumOptions$Builder
  extends GeneratedMessageV3.ExtendableBuilder<DescriptorProtos.EnumOptions, Builder>
  implements DescriptorProtos.EnumOptionsOrBuilder
{
  private int a;
  private boolean b;
  private boolean c;
  private List<DescriptorProtos.UninterpretedOption> d = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> e;
  
  private DescriptorProtos$EnumOptions$Builder()
  {
    i();
  }
  
  private DescriptorProtos$EnumOptions$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    if ((this.a & 0x4) == 0)
    {
      this.d = new ArrayList(this.d);
      this.a |= 0x4;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> k()
  {
    if (this.e == null)
    {
      List localList = this.d;
      boolean bool;
      if ((this.a & 0x4) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.e = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.d = null;
    }
    return this.e;
  }
  
  public Builder a()
  {
    super.g();
    this.b = false;
    this.a &= 0xFFFFFFFE;
    this.c = false;
    this.a &= 0xFFFFFFFD;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.e;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.d = Collections.emptyList();
      this.a &= 0xFFFFFFFB;
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
    //   2: getstatic 95	com/google/protobuf/DescriptorProtos$EnumOptions:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 101 3 0
    //   12: checkcast 91	com/google/protobuf/DescriptorProtos$EnumOptions
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 104	com/google/protobuf/DescriptorProtos$EnumOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$EnumOptions;)Lcom/google/protobuf/DescriptorProtos$EnumOptions$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 108	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 91	com/google/protobuf/DescriptorProtos$EnumOptions
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 112	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 104	com/google/protobuf/DescriptorProtos$EnumOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$EnumOptions;)Lcom/google/protobuf/DescriptorProtos$EnumOptions$Builder;
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
  
  public Builder a(DescriptorProtos.EnumOptions paramEnumOptions)
  {
    if (paramEnumOptions == DescriptorProtos.EnumOptions.getDefaultInstance()) {
      return this;
    }
    if (paramEnumOptions.hasAllowAlias()) {
      a(paramEnumOptions.getAllowAlias());
    }
    if (paramEnumOptions.hasDeprecated()) {
      b(paramEnumOptions.getDeprecated());
    }
    if (this.e == null)
    {
      if (!DescriptorProtos.EnumOptions.access$21700(paramEnumOptions).isEmpty())
      {
        if (this.d.isEmpty())
        {
          this.d = DescriptorProtos.EnumOptions.access$21700(paramEnumOptions);
          this.a &= 0xFFFFFFFB;
        }
        else
        {
          j();
          this.d.addAll(DescriptorProtos.EnumOptions.access$21700(paramEnumOptions));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.EnumOptions.access$21700(paramEnumOptions).isEmpty()) {
      if (this.e.d())
      {
        this.e.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.e = null;
        this.d = DescriptorProtos.EnumOptions.access$21700(paramEnumOptions);
        this.a &= 0xFFFFFFFB;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = k();
        }
        this.e = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.e.a(DescriptorProtos.EnumOptions.access$21700(paramEnumOptions));
      }
    }
    a(paramEnumOptions);
    b(paramEnumOptions.unknownFields);
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
    if ((paramMessage instanceof DescriptorProtos.EnumOptions)) {
      return a((DescriptorProtos.EnumOptions)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.a |= 0x1;
    this.b = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.UninterpretedOption a(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.e;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.UninterpretedOption)this.d.get(paramInt);
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
  
  public Builder b(boolean paramBoolean)
  {
    this.a |= 0x2;
    this.c = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.EnumOptions b()
  {
    return DescriptorProtos.EnumOptions.getDefaultInstance();
  }
  
  public DescriptorProtos.EnumOptions c()
  {
    DescriptorProtos.EnumOptions localEnumOptions = d();
    if (localEnumOptions.isInitialized()) {
      return localEnumOptions;
    }
    throw newUninitializedMessageException(localEnumOptions);
  }
  
  public DescriptorProtos.EnumOptions d()
  {
    DescriptorProtos.EnumOptions localEnumOptions = new DescriptorProtos.EnumOptions(this, null);
    int k = this.a;
    int i;
    if ((k & 0x1) != 0)
    {
      DescriptorProtos.EnumOptions.access$21502(localEnumOptions, this.b);
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = i;
    if ((k & 0x2) != 0)
    {
      DescriptorProtos.EnumOptions.access$21602(localEnumOptions, this.c);
      j = i | 0x2;
    }
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.e;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((this.a & 0x4) != 0)
      {
        this.d = Collections.unmodifiableList(this.d);
        this.a &= 0xFFFFFFFB;
      }
      DescriptorProtos.EnumOptions.access$21702(localEnumOptions, this.d);
    }
    else
    {
      DescriptorProtos.EnumOptions.access$21702(localEnumOptions, localRepeatedFieldBuilderV3.f());
    }
    DescriptorProtos.EnumOptions.access$21802(localEnumOptions, j);
    onBuilt();
    return localEnumOptions;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public int f()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.e;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.d.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.J();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.K().a(DescriptorProtos.EnumOptions.class, Builder.class);
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.EnumOptions.Builder
 * JD-Core Version:    0.7.0.1
 */