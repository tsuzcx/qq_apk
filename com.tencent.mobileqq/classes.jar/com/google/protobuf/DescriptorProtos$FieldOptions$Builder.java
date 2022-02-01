package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FieldOptions$Builder
  extends GeneratedMessageV3.ExtendableBuilder<DescriptorProtos.FieldOptions, Builder>
  implements DescriptorProtos.FieldOptionsOrBuilder
{
  private int a;
  private int b = 0;
  private boolean c;
  private int d = 0;
  private boolean e;
  private boolean f;
  private boolean g;
  private List<DescriptorProtos.UninterpretedOption> h = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> i;
  
  private DescriptorProtos$FieldOptions$Builder()
  {
    i();
  }
  
  private DescriptorProtos$FieldOptions$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    if ((this.a & 0x40) == 0)
    {
      this.h = new ArrayList(this.h);
      this.a |= 0x40;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> k()
  {
    if (this.i == null)
    {
      List localList = this.h;
      boolean bool;
      if ((this.a & 0x40) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.i = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.h = null;
    }
    return this.i;
  }
  
  public Builder a()
  {
    super.g();
    this.b = 0;
    this.a &= 0xFFFFFFFE;
    this.c = false;
    this.a &= 0xFFFFFFFD;
    this.d = 0;
    this.a &= 0xFFFFFFFB;
    this.e = false;
    this.a &= 0xFFFFFFF7;
    this.f = false;
    this.a &= 0xFFFFFFEF;
    this.g = false;
    this.a &= 0xFFFFFFDF;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.i;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.h = Collections.emptyList();
      this.a &= 0xFFFFFFBF;
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
    //   2: getstatic 105	com/google/protobuf/DescriptorProtos$FieldOptions:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 111 3 0
    //   12: checkcast 101	com/google/protobuf/DescriptorProtos$FieldOptions
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 114	com/google/protobuf/DescriptorProtos$FieldOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$FieldOptions;)Lcom/google/protobuf/DescriptorProtos$FieldOptions$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 118	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 101	com/google/protobuf/DescriptorProtos$FieldOptions
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 122	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 114	com/google/protobuf/DescriptorProtos$FieldOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$FieldOptions;)Lcom/google/protobuf/DescriptorProtos$FieldOptions$Builder;
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
  
  public Builder a(DescriptorProtos.FieldOptions.CType paramCType)
  {
    if (paramCType != null)
    {
      this.a |= 0x1;
      this.b = paramCType.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder a(DescriptorProtos.FieldOptions.JSType paramJSType)
  {
    if (paramJSType != null)
    {
      this.a |= 0x4;
      this.d = paramJSType.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder a(DescriptorProtos.FieldOptions paramFieldOptions)
  {
    if (paramFieldOptions == DescriptorProtos.FieldOptions.getDefaultInstance()) {
      return this;
    }
    if (paramFieldOptions.hasCtype()) {
      a(paramFieldOptions.getCtype());
    }
    if (paramFieldOptions.hasPacked()) {
      a(paramFieldOptions.getPacked());
    }
    if (paramFieldOptions.hasJstype()) {
      a(paramFieldOptions.getJstype());
    }
    if (paramFieldOptions.hasLazy()) {
      b(paramFieldOptions.getLazy());
    }
    if (paramFieldOptions.hasDeprecated()) {
      c(paramFieldOptions.getDeprecated());
    }
    if (paramFieldOptions.hasWeak()) {
      d(paramFieldOptions.getWeak());
    }
    if (this.i == null)
    {
      if (!DescriptorProtos.FieldOptions.access$20000(paramFieldOptions).isEmpty())
      {
        if (this.h.isEmpty())
        {
          this.h = DescriptorProtos.FieldOptions.access$20000(paramFieldOptions);
          this.a &= 0xFFFFFFBF;
        }
        else
        {
          j();
          this.h.addAll(DescriptorProtos.FieldOptions.access$20000(paramFieldOptions));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FieldOptions.access$20000(paramFieldOptions).isEmpty()) {
      if (this.i.d())
      {
        this.i.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.i = null;
        this.h = DescriptorProtos.FieldOptions.access$20000(paramFieldOptions);
        this.a &= 0xFFFFFFBF;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = k();
        }
        this.i = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.i.a(DescriptorProtos.FieldOptions.access$20000(paramFieldOptions));
      }
    }
    a(paramFieldOptions);
    b(paramFieldOptions.unknownFields);
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
    if ((paramMessage instanceof DescriptorProtos.FieldOptions)) {
      return a((DescriptorProtos.FieldOptions)paramMessage);
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
    this.a |= 0x2;
    this.c = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.UninterpretedOption a(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.i;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.UninterpretedOption)this.h.get(paramInt);
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
    this.a |= 0x8;
    this.e = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.FieldOptions b()
  {
    return DescriptorProtos.FieldOptions.getDefaultInstance();
  }
  
  public Builder c(boolean paramBoolean)
  {
    this.a |= 0x10;
    this.f = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.FieldOptions c()
  {
    DescriptorProtos.FieldOptions localFieldOptions = d();
    if (localFieldOptions.isInitialized()) {
      return localFieldOptions;
    }
    throw newUninitializedMessageException(localFieldOptions);
  }
  
  public Builder d(boolean paramBoolean)
  {
    this.a |= 0x20;
    this.g = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.FieldOptions d()
  {
    DescriptorProtos.FieldOptions localFieldOptions = new DescriptorProtos.FieldOptions(this, null);
    int m = this.a;
    if ((m & 0x1) != 0) {
      k = 1;
    } else {
      k = 0;
    }
    DescriptorProtos.FieldOptions.access$19402(localFieldOptions, this.b);
    int j = k;
    if ((m & 0x2) != 0)
    {
      DescriptorProtos.FieldOptions.access$19502(localFieldOptions, this.c);
      j = k | 0x2;
    }
    int k = j;
    if ((m & 0x4) != 0) {
      k = j | 0x4;
    }
    DescriptorProtos.FieldOptions.access$19602(localFieldOptions, this.d);
    j = k;
    if ((m & 0x8) != 0)
    {
      DescriptorProtos.FieldOptions.access$19702(localFieldOptions, this.e);
      j = k | 0x8;
    }
    k = j;
    if ((m & 0x10) != 0)
    {
      DescriptorProtos.FieldOptions.access$19802(localFieldOptions, this.f);
      k = j | 0x10;
    }
    j = k;
    if ((m & 0x20) != 0)
    {
      DescriptorProtos.FieldOptions.access$19902(localFieldOptions, this.g);
      j = k | 0x20;
    }
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.i;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((this.a & 0x40) != 0)
      {
        this.h = Collections.unmodifiableList(this.h);
        this.a &= 0xFFFFFFBF;
      }
      DescriptorProtos.FieldOptions.access$20002(localFieldOptions, this.h);
    }
    else
    {
      DescriptorProtos.FieldOptions.access$20002(localFieldOptions, localRepeatedFieldBuilderV3.f());
    }
    DescriptorProtos.FieldOptions.access$20102(localFieldOptions, j);
    onBuilt();
    return localFieldOptions;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public int f()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.i;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.h.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.F();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.G().a(DescriptorProtos.FieldOptions.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    int j = 0;
    while (j < f())
    {
      if (!a(j).isInitialized()) {
        return false;
      }
      j += 1;
    }
    return h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FieldOptions.Builder
 * JD-Core Version:    0.7.0.1
 */