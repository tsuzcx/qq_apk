package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$ServiceOptions$Builder
  extends GeneratedMessageV3.ExtendableBuilder<DescriptorProtos.ServiceOptions, Builder>
  implements DescriptorProtos.ServiceOptionsOrBuilder
{
  private int a;
  private boolean b;
  private List<DescriptorProtos.UninterpretedOption> c = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> d;
  
  private DescriptorProtos$ServiceOptions$Builder()
  {
    i();
  }
  
  private DescriptorProtos$ServiceOptions$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    if ((this.a & 0x2) == 0)
    {
      this.c = new ArrayList(this.c);
      this.a |= 0x2;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> k()
  {
    if (this.d == null)
    {
      List localList = this.c;
      boolean bool;
      if ((this.a & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.d = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.c = null;
    }
    return this.d;
  }
  
  public Builder a()
  {
    super.g();
    this.b = false;
    this.a &= 0xFFFFFFFE;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.d;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.c = Collections.emptyList();
      this.a &= 0xFFFFFFFD;
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
    //   2: getstatic 93	com/google/protobuf/DescriptorProtos$ServiceOptions:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 99 3 0
    //   12: checkcast 89	com/google/protobuf/DescriptorProtos$ServiceOptions
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 102	com/google/protobuf/DescriptorProtos$ServiceOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$ServiceOptions;)Lcom/google/protobuf/DescriptorProtos$ServiceOptions$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 106	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 89	com/google/protobuf/DescriptorProtos$ServiceOptions
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 110	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 102	com/google/protobuf/DescriptorProtos$ServiceOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$ServiceOptions;)Lcom/google/protobuf/DescriptorProtos$ServiceOptions$Builder;
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
  
  public Builder a(DescriptorProtos.ServiceOptions paramServiceOptions)
  {
    if (paramServiceOptions == DescriptorProtos.ServiceOptions.getDefaultInstance()) {
      return this;
    }
    if (paramServiceOptions.hasDeprecated()) {
      a(paramServiceOptions.getDeprecated());
    }
    if (this.d == null)
    {
      if (!DescriptorProtos.ServiceOptions.access$23500(paramServiceOptions).isEmpty())
      {
        if (this.c.isEmpty())
        {
          this.c = DescriptorProtos.ServiceOptions.access$23500(paramServiceOptions);
          this.a &= 0xFFFFFFFD;
        }
        else
        {
          j();
          this.c.addAll(DescriptorProtos.ServiceOptions.access$23500(paramServiceOptions));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.ServiceOptions.access$23500(paramServiceOptions).isEmpty()) {
      if (this.d.d())
      {
        this.d.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.d = null;
        this.c = DescriptorProtos.ServiceOptions.access$23500(paramServiceOptions);
        this.a &= 0xFFFFFFFD;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = k();
        }
        this.d = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.d.a(DescriptorProtos.ServiceOptions.access$23500(paramServiceOptions));
      }
    }
    a(paramServiceOptions);
    b(paramServiceOptions.unknownFields);
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
    if ((paramMessage instanceof DescriptorProtos.ServiceOptions)) {
      return a((DescriptorProtos.ServiceOptions)paramMessage);
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
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.d;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.UninterpretedOption)this.c.get(paramInt);
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
  
  public DescriptorProtos.ServiceOptions b()
  {
    return DescriptorProtos.ServiceOptions.getDefaultInstance();
  }
  
  public DescriptorProtos.ServiceOptions c()
  {
    DescriptorProtos.ServiceOptions localServiceOptions = d();
    if (localServiceOptions.isInitialized()) {
      return localServiceOptions;
    }
    throw newUninitializedMessageException(localServiceOptions);
  }
  
  public DescriptorProtos.ServiceOptions d()
  {
    DescriptorProtos.ServiceOptions localServiceOptions = new DescriptorProtos.ServiceOptions(this, null);
    int j = this.a;
    int i = 1;
    if ((j & 0x1) != 0) {
      DescriptorProtos.ServiceOptions.access$23402(localServiceOptions, this.b);
    } else {
      i = 0;
    }
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.d;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((this.a & 0x2) != 0)
      {
        this.c = Collections.unmodifiableList(this.c);
        this.a &= 0xFFFFFFFD;
      }
      DescriptorProtos.ServiceOptions.access$23502(localServiceOptions, this.c);
    }
    else
    {
      DescriptorProtos.ServiceOptions.access$23502(localServiceOptions, localRepeatedFieldBuilderV3.f());
    }
    DescriptorProtos.ServiceOptions.access$23602(localServiceOptions, i);
    onBuilt();
    return localServiceOptions;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public int f()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.d;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.c.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.N();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.O().a(DescriptorProtos.ServiceOptions.class, Builder.class);
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.ServiceOptions.Builder
 * JD-Core Version:    0.7.0.1
 */