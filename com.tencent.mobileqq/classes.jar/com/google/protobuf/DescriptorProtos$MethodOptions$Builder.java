package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$MethodOptions$Builder
  extends GeneratedMessageV3.ExtendableBuilder<DescriptorProtos.MethodOptions, Builder>
  implements DescriptorProtos.MethodOptionsOrBuilder
{
  private int a;
  private boolean b;
  private int c = 0;
  private List<DescriptorProtos.UninterpretedOption> d = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> e;
  
  private DescriptorProtos$MethodOptions$Builder()
  {
    i();
  }
  
  private DescriptorProtos$MethodOptions$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    this.c = 0;
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
    //   2: getstatic 95	com/google/protobuf/DescriptorProtos$MethodOptions:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 101 3 0
    //   12: checkcast 91	com/google/protobuf/DescriptorProtos$MethodOptions
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 104	com/google/protobuf/DescriptorProtos$MethodOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$MethodOptions;)Lcom/google/protobuf/DescriptorProtos$MethodOptions$Builder;
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
    //   39: checkcast 91	com/google/protobuf/DescriptorProtos$MethodOptions
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 112	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 104	com/google/protobuf/DescriptorProtos$MethodOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$MethodOptions;)Lcom/google/protobuf/DescriptorProtos$MethodOptions$Builder;
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
  
  public Builder a(DescriptorProtos.MethodOptions.IdempotencyLevel paramIdempotencyLevel)
  {
    if (paramIdempotencyLevel != null)
    {
      this.a |= 0x2;
      this.c = paramIdempotencyLevel.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder a(DescriptorProtos.MethodOptions paramMethodOptions)
  {
    if (paramMethodOptions == DescriptorProtos.MethodOptions.getDefaultInstance()) {
      return this;
    }
    if (paramMethodOptions.hasDeprecated()) {
      a(paramMethodOptions.getDeprecated());
    }
    if (paramMethodOptions.hasIdempotencyLevel()) {
      a(paramMethodOptions.getIdempotencyLevel());
    }
    if (this.e == null)
    {
      if (!DescriptorProtos.MethodOptions.access$24500(paramMethodOptions).isEmpty())
      {
        if (this.d.isEmpty())
        {
          this.d = DescriptorProtos.MethodOptions.access$24500(paramMethodOptions);
          this.a &= 0xFFFFFFFB;
        }
        else
        {
          j();
          this.d.addAll(DescriptorProtos.MethodOptions.access$24500(paramMethodOptions));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.MethodOptions.access$24500(paramMethodOptions).isEmpty()) {
      if (this.e.d())
      {
        this.e.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.e = null;
        this.d = DescriptorProtos.MethodOptions.access$24500(paramMethodOptions);
        this.a &= 0xFFFFFFFB;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = k();
        }
        this.e = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.e.a(DescriptorProtos.MethodOptions.access$24500(paramMethodOptions));
      }
    }
    a(paramMethodOptions);
    b(paramMethodOptions.unknownFields);
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
    if ((paramMessage instanceof DescriptorProtos.MethodOptions)) {
      return a((DescriptorProtos.MethodOptions)paramMessage);
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
  
  public DescriptorProtos.MethodOptions b()
  {
    return DescriptorProtos.MethodOptions.getDefaultInstance();
  }
  
  public DescriptorProtos.MethodOptions c()
  {
    DescriptorProtos.MethodOptions localMethodOptions = d();
    if (localMethodOptions.isInitialized()) {
      return localMethodOptions;
    }
    throw newUninitializedMessageException(localMethodOptions);
  }
  
  public DescriptorProtos.MethodOptions d()
  {
    DescriptorProtos.MethodOptions localMethodOptions = new DescriptorProtos.MethodOptions(this, null);
    int k = this.a;
    int i;
    if ((k & 0x1) != 0)
    {
      DescriptorProtos.MethodOptions.access$24302(localMethodOptions, this.b);
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = i;
    if ((k & 0x2) != 0) {
      j = i | 0x2;
    }
    DescriptorProtos.MethodOptions.access$24402(localMethodOptions, this.c);
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.e;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((this.a & 0x4) != 0)
      {
        this.d = Collections.unmodifiableList(this.d);
        this.a &= 0xFFFFFFFB;
      }
      DescriptorProtos.MethodOptions.access$24502(localMethodOptions, this.d);
    }
    else
    {
      DescriptorProtos.MethodOptions.access$24502(localMethodOptions, localRepeatedFieldBuilderV3.f());
    }
    DescriptorProtos.MethodOptions.access$24602(localMethodOptions, j);
    onBuilt();
    return localMethodOptions;
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
    return DescriptorProtos.P();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.Q().a(DescriptorProtos.MethodOptions.class, Builder.class);
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.MethodOptions.Builder
 * JD-Core Version:    0.7.0.1
 */