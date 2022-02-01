package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileOptions$Builder
  extends GeneratedMessageV3.ExtendableBuilder<DescriptorProtos.FileOptions, Builder>
  implements DescriptorProtos.FileOptionsOrBuilder
{
  private int a;
  private Object b = "";
  private Object c = "";
  private boolean d;
  private boolean e;
  private boolean f;
  private int g = 1;
  private Object h = "";
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private Object o = "";
  private Object p = "";
  private Object q = "";
  private Object r = "";
  private Object s = "";
  private Object t = "";
  private Object u = "";
  private List<DescriptorProtos.UninterpretedOption> v = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> w;
  
  private DescriptorProtos$FileOptions$Builder()
  {
    i();
  }
  
  private DescriptorProtos$FileOptions$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    if ((this.a & 0x100000) == 0)
    {
      this.v = new ArrayList(this.v);
      this.a |= 0x100000;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> k()
  {
    if (this.w == null)
    {
      List localList = this.v;
      boolean bool;
      if ((this.a & 0x100000) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.w = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.v = null;
    }
    return this.w;
  }
  
  public Builder a()
  {
    super.g();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    this.c = "";
    this.a &= 0xFFFFFFFD;
    this.d = false;
    this.a &= 0xFFFFFFFB;
    this.e = false;
    this.a &= 0xFFFFFFF7;
    this.f = false;
    this.a &= 0xFFFFFFEF;
    this.g = 1;
    this.a &= 0xFFFFFFDF;
    this.h = "";
    this.a &= 0xFFFFFFBF;
    this.i = false;
    this.a &= 0xFFFFFF7F;
    this.j = false;
    this.a &= 0xFFFFFEFF;
    this.k = false;
    this.a &= 0xFFFFFDFF;
    this.l = false;
    this.a &= 0xFFFFFBFF;
    this.m = false;
    this.a &= 0xFFFFF7FF;
    this.n = false;
    this.a &= 0xFFFFEFFF;
    this.o = "";
    this.a &= 0xFFFFDFFF;
    this.p = "";
    this.a &= 0xFFFFBFFF;
    this.q = "";
    this.a &= 0xFFFF7FFF;
    this.r = "";
    this.a &= 0xFFFEFFFF;
    this.s = "";
    this.a &= 0xFFFDFFFF;
    this.t = "";
    this.a &= 0xFFFBFFFF;
    this.u = "";
    this.a &= 0xFFF7FFFF;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.w;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.v = Collections.emptyList();
      this.a &= 0xFFEFFFFF;
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
    //   2: getstatic 155	com/google/protobuf/DescriptorProtos$FileOptions:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 161 3 0
    //   12: checkcast 151	com/google/protobuf/DescriptorProtos$FileOptions
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 164	com/google/protobuf/DescriptorProtos$FileOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$FileOptions;)Lcom/google/protobuf/DescriptorProtos$FileOptions$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 168	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 151	com/google/protobuf/DescriptorProtos$FileOptions
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 172	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 164	com/google/protobuf/DescriptorProtos$FileOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$FileOptions;)Lcom/google/protobuf/DescriptorProtos$FileOptions$Builder;
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
  
  public Builder a(DescriptorProtos.FileOptions.OptimizeMode paramOptimizeMode)
  {
    if (paramOptimizeMode != null)
    {
      this.a |= 0x20;
      this.g = paramOptimizeMode.getNumber();
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder a(DescriptorProtos.FileOptions paramFileOptions)
  {
    if (paramFileOptions == DescriptorProtos.FileOptions.getDefaultInstance()) {
      return this;
    }
    if (paramFileOptions.hasJavaPackage())
    {
      this.a |= 0x1;
      this.b = DescriptorProtos.FileOptions.access$15400(paramFileOptions);
      onChanged();
    }
    if (paramFileOptions.hasJavaOuterClassname())
    {
      this.a |= 0x2;
      this.c = DescriptorProtos.FileOptions.access$15500(paramFileOptions);
      onChanged();
    }
    if (paramFileOptions.hasJavaMultipleFiles()) {
      a(paramFileOptions.getJavaMultipleFiles());
    }
    if (paramFileOptions.hasJavaGenerateEqualsAndHash()) {
      b(paramFileOptions.getJavaGenerateEqualsAndHash());
    }
    if (paramFileOptions.hasJavaStringCheckUtf8()) {
      c(paramFileOptions.getJavaStringCheckUtf8());
    }
    if (paramFileOptions.hasOptimizeFor()) {
      a(paramFileOptions.getOptimizeFor());
    }
    if (paramFileOptions.hasGoPackage())
    {
      this.a |= 0x40;
      this.h = DescriptorProtos.FileOptions.access$16000(paramFileOptions);
      onChanged();
    }
    if (paramFileOptions.hasCcGenericServices()) {
      d(paramFileOptions.getCcGenericServices());
    }
    if (paramFileOptions.hasJavaGenericServices()) {
      e(paramFileOptions.getJavaGenericServices());
    }
    if (paramFileOptions.hasPyGenericServices()) {
      f(paramFileOptions.getPyGenericServices());
    }
    if (paramFileOptions.hasPhpGenericServices()) {
      g(paramFileOptions.getPhpGenericServices());
    }
    if (paramFileOptions.hasDeprecated()) {
      h(paramFileOptions.getDeprecated());
    }
    if (paramFileOptions.hasCcEnableArenas()) {
      i(paramFileOptions.getCcEnableArenas());
    }
    if (paramFileOptions.hasObjcClassPrefix())
    {
      this.a |= 0x2000;
      this.o = DescriptorProtos.FileOptions.access$16700(paramFileOptions);
      onChanged();
    }
    if (paramFileOptions.hasCsharpNamespace())
    {
      this.a |= 0x4000;
      this.p = DescriptorProtos.FileOptions.access$16800(paramFileOptions);
      onChanged();
    }
    if (paramFileOptions.hasSwiftPrefix())
    {
      this.a |= 0x8000;
      this.q = DescriptorProtos.FileOptions.access$16900(paramFileOptions);
      onChanged();
    }
    if (paramFileOptions.hasPhpClassPrefix())
    {
      this.a |= 0x10000;
      this.r = DescriptorProtos.FileOptions.access$17000(paramFileOptions);
      onChanged();
    }
    if (paramFileOptions.hasPhpNamespace())
    {
      this.a |= 0x20000;
      this.s = DescriptorProtos.FileOptions.access$17100(paramFileOptions);
      onChanged();
    }
    if (paramFileOptions.hasPhpMetadataNamespace())
    {
      this.a |= 0x40000;
      this.t = DescriptorProtos.FileOptions.access$17200(paramFileOptions);
      onChanged();
    }
    if (paramFileOptions.hasRubyPackage())
    {
      this.a |= 0x80000;
      this.u = DescriptorProtos.FileOptions.access$17300(paramFileOptions);
      onChanged();
    }
    if (this.w == null)
    {
      if (!DescriptorProtos.FileOptions.access$17400(paramFileOptions).isEmpty())
      {
        if (this.v.isEmpty())
        {
          this.v = DescriptorProtos.FileOptions.access$17400(paramFileOptions);
          this.a &= 0xFFEFFFFF;
        }
        else
        {
          j();
          this.v.addAll(DescriptorProtos.FileOptions.access$17400(paramFileOptions));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FileOptions.access$17400(paramFileOptions).isEmpty()) {
      if (this.w.d())
      {
        this.w.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.w = null;
        this.v = DescriptorProtos.FileOptions.access$17400(paramFileOptions);
        this.a = (0xFFEFFFFF & this.a);
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = k();
        }
        this.w = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.w.a(DescriptorProtos.FileOptions.access$17400(paramFileOptions));
      }
    }
    a(paramFileOptions);
    b(paramFileOptions.unknownFields);
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
    if ((paramMessage instanceof DescriptorProtos.FileOptions)) {
      return a((DescriptorProtos.FileOptions)paramMessage);
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
    this.a |= 0x4;
    this.d = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.UninterpretedOption a(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.w;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.UninterpretedOption)this.v.get(paramInt);
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
  
  @Deprecated
  public Builder b(boolean paramBoolean)
  {
    this.a |= 0x8;
    this.e = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.FileOptions b()
  {
    return DescriptorProtos.FileOptions.getDefaultInstance();
  }
  
  public Builder c(boolean paramBoolean)
  {
    this.a |= 0x10;
    this.f = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.FileOptions c()
  {
    DescriptorProtos.FileOptions localFileOptions = d();
    if (localFileOptions.isInitialized()) {
      return localFileOptions;
    }
    throw newUninitializedMessageException(localFileOptions);
  }
  
  public Builder d(boolean paramBoolean)
  {
    this.a |= 0x80;
    this.i = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.FileOptions d()
  {
    DescriptorProtos.FileOptions localFileOptions = new DescriptorProtos.FileOptions(this, null);
    int i3 = this.a;
    if ((i3 & 0x1) != 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    DescriptorProtos.FileOptions.access$15402(localFileOptions, this.b);
    int i1 = i2;
    if ((i3 & 0x2) != 0) {
      i1 = i2 | 0x2;
    }
    DescriptorProtos.FileOptions.access$15502(localFileOptions, this.c);
    int i2 = i1;
    if ((i3 & 0x4) != 0)
    {
      DescriptorProtos.FileOptions.access$15602(localFileOptions, this.d);
      i2 = i1 | 0x4;
    }
    i1 = i2;
    if ((i3 & 0x8) != 0)
    {
      DescriptorProtos.FileOptions.access$15702(localFileOptions, this.e);
      i1 = i2 | 0x8;
    }
    i2 = i1;
    if ((i3 & 0x10) != 0)
    {
      DescriptorProtos.FileOptions.access$15802(localFileOptions, this.f);
      i2 = i1 | 0x10;
    }
    i1 = i2;
    if ((i3 & 0x20) != 0) {
      i1 = i2 | 0x20;
    }
    DescriptorProtos.FileOptions.access$15902(localFileOptions, this.g);
    i2 = i1;
    if ((i3 & 0x40) != 0) {
      i2 = i1 | 0x40;
    }
    DescriptorProtos.FileOptions.access$16002(localFileOptions, this.h);
    i1 = i2;
    if ((i3 & 0x80) != 0)
    {
      DescriptorProtos.FileOptions.access$16102(localFileOptions, this.i);
      i1 = i2 | 0x80;
    }
    i2 = i1;
    if ((i3 & 0x100) != 0)
    {
      DescriptorProtos.FileOptions.access$16202(localFileOptions, this.j);
      i2 = i1 | 0x100;
    }
    i1 = i2;
    if ((i3 & 0x200) != 0)
    {
      DescriptorProtos.FileOptions.access$16302(localFileOptions, this.k);
      i1 = i2 | 0x200;
    }
    i2 = i1;
    if ((i3 & 0x400) != 0)
    {
      DescriptorProtos.FileOptions.access$16402(localFileOptions, this.l);
      i2 = i1 | 0x400;
    }
    i1 = i2;
    if ((i3 & 0x800) != 0)
    {
      DescriptorProtos.FileOptions.access$16502(localFileOptions, this.m);
      i1 = i2 | 0x800;
    }
    i2 = i1;
    if ((i3 & 0x1000) != 0)
    {
      DescriptorProtos.FileOptions.access$16602(localFileOptions, this.n);
      i2 = i1 | 0x1000;
    }
    i1 = i2;
    if ((i3 & 0x2000) != 0) {
      i1 = i2 | 0x2000;
    }
    DescriptorProtos.FileOptions.access$16702(localFileOptions, this.o);
    i2 = i1;
    if ((i3 & 0x4000) != 0) {
      i2 = i1 | 0x4000;
    }
    DescriptorProtos.FileOptions.access$16802(localFileOptions, this.p);
    i1 = i2;
    if ((0x8000 & i3) != 0) {
      i1 = i2 | 0x8000;
    }
    DescriptorProtos.FileOptions.access$16902(localFileOptions, this.q);
    i2 = i1;
    if ((0x10000 & i3) != 0) {
      i2 = i1 | 0x10000;
    }
    DescriptorProtos.FileOptions.access$17002(localFileOptions, this.r);
    i1 = i2;
    if ((0x20000 & i3) != 0) {
      i1 = i2 | 0x20000;
    }
    DescriptorProtos.FileOptions.access$17102(localFileOptions, this.s);
    i2 = i1;
    if ((0x40000 & i3) != 0) {
      i2 = i1 | 0x40000;
    }
    DescriptorProtos.FileOptions.access$17202(localFileOptions, this.t);
    i1 = i2;
    if ((i3 & 0x80000) != 0) {
      i1 = i2 | 0x80000;
    }
    DescriptorProtos.FileOptions.access$17302(localFileOptions, this.u);
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.w;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((this.a & 0x100000) != 0)
      {
        this.v = Collections.unmodifiableList(this.v);
        this.a &= 0xFFEFFFFF;
      }
      DescriptorProtos.FileOptions.access$17402(localFileOptions, this.v);
    }
    else
    {
      DescriptorProtos.FileOptions.access$17402(localFileOptions, localRepeatedFieldBuilderV3.f());
    }
    DescriptorProtos.FileOptions.access$17502(localFileOptions, i1);
    onBuilt();
    return localFileOptions;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Builder e(boolean paramBoolean)
  {
    this.a |= 0x100;
    this.j = paramBoolean;
    onChanged();
    return this;
  }
  
  public int f()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.w;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.v.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public Builder f(boolean paramBoolean)
  {
    this.a |= 0x200;
    this.k = paramBoolean;
    onChanged();
    return this;
  }
  
  public Builder g(boolean paramBoolean)
  {
    this.a |= 0x400;
    this.l = paramBoolean;
    onChanged();
    return this;
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.B();
  }
  
  public Builder h(boolean paramBoolean)
  {
    this.a |= 0x800;
    this.m = paramBoolean;
    onChanged();
    return this;
  }
  
  public Builder i(boolean paramBoolean)
  {
    this.a |= 0x1000;
    this.n = paramBoolean;
    onChanged();
    return this;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.C().a(DescriptorProtos.FileOptions.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    int i1 = 0;
    while (i1 < f())
    {
      if (!a(i1).isInitialized()) {
        return false;
      }
      i1 += 1;
    }
    return h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FileOptions.Builder
 * JD-Core Version:    0.7.0.1
 */