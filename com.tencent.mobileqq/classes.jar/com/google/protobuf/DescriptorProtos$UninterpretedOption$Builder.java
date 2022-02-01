package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$UninterpretedOption$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.UninterpretedOptionOrBuilder
{
  private int a;
  private List<DescriptorProtos.UninterpretedOption.NamePart> b = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption.NamePart, DescriptorProtos.UninterpretedOption.NamePart.Builder, DescriptorProtos.UninterpretedOption.NamePartOrBuilder> c;
  private Object d = "";
  private long e;
  private long f;
  private double g;
  private ByteString h = ByteString.EMPTY;
  private Object i = "";
  
  private DescriptorProtos$UninterpretedOption$Builder()
  {
    g();
  }
  
  private DescriptorProtos$UninterpretedOption$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
  
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption.NamePart, DescriptorProtos.UninterpretedOption.NamePart.Builder, DescriptorProtos.UninterpretedOption.NamePartOrBuilder> i()
  {
    if (this.c == null)
    {
      List localList = this.b;
      int j = this.a;
      boolean bool = true;
      if ((j & 0x1) == 0) {
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
    }
    else
    {
      localRepeatedFieldBuilderV3.e();
    }
    this.d = "";
    this.a &= 0xFFFFFFFD;
    this.e = 0L;
    this.a &= 0xFFFFFFFB;
    this.f = 0L;
    this.a &= 0xFFFFFFF7;
    this.g = 0.0D;
    this.a &= 0xFFFFFFEF;
    this.h = ByteString.EMPTY;
    this.a &= 0xFFFFFFDF;
    this.i = "";
    this.a &= 0xFFFFFFBF;
    return this;
  }
  
  public Builder a(double paramDouble)
  {
    this.a |= 0x10;
    this.g = paramDouble;
    onChanged();
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.a |= 0x4;
    this.e = paramLong;
    onChanged();
    return this;
  }
  
  public Builder a(ByteString paramByteString)
  {
    if (paramByteString != null)
    {
      this.a |= 0x20;
      this.h = paramByteString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 124	com/google/protobuf/DescriptorProtos$UninterpretedOption:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 130 3 0
    //   12: checkcast 120	com/google/protobuf/DescriptorProtos$UninterpretedOption
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 133	com/google/protobuf/DescriptorProtos$UninterpretedOption$Builder:a	(Lcom/google/protobuf/DescriptorProtos$UninterpretedOption;)Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 137	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 120	com/google/protobuf/DescriptorProtos$UninterpretedOption
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 141	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 133	com/google/protobuf/DescriptorProtos$UninterpretedOption$Builder:a	(Lcom/google/protobuf/DescriptorProtos$UninterpretedOption;)Lcom/google/protobuf/DescriptorProtos$UninterpretedOption$Builder;
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
  
  public Builder a(DescriptorProtos.UninterpretedOption paramUninterpretedOption)
  {
    if (paramUninterpretedOption == DescriptorProtos.UninterpretedOption.getDefaultInstance()) {
      return this;
    }
    if (this.c == null)
    {
      if (!DescriptorProtos.UninterpretedOption.access$26200(paramUninterpretedOption).isEmpty())
      {
        if (this.b.isEmpty())
        {
          this.b = DescriptorProtos.UninterpretedOption.access$26200(paramUninterpretedOption);
          this.a &= 0xFFFFFFFE;
        }
        else
        {
          h();
          this.b.addAll(DescriptorProtos.UninterpretedOption.access$26200(paramUninterpretedOption));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.UninterpretedOption.access$26200(paramUninterpretedOption).isEmpty()) {
      if (this.c.d())
      {
        this.c.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.c = null;
        this.b = DescriptorProtos.UninterpretedOption.access$26200(paramUninterpretedOption);
        this.a &= 0xFFFFFFFE;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = i();
        }
        this.c = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.c.a(DescriptorProtos.UninterpretedOption.access$26200(paramUninterpretedOption));
      }
    }
    if (paramUninterpretedOption.hasIdentifierValue())
    {
      this.a |= 0x2;
      this.d = DescriptorProtos.UninterpretedOption.access$26300(paramUninterpretedOption);
      onChanged();
    }
    if (paramUninterpretedOption.hasPositiveIntValue()) {
      a(paramUninterpretedOption.getPositiveIntValue());
    }
    if (paramUninterpretedOption.hasNegativeIntValue()) {
      b(paramUninterpretedOption.getNegativeIntValue());
    }
    if (paramUninterpretedOption.hasDoubleValue()) {
      a(paramUninterpretedOption.getDoubleValue());
    }
    if (paramUninterpretedOption.hasStringValue()) {
      a(paramUninterpretedOption.getStringValue());
    }
    if (paramUninterpretedOption.hasAggregateValue())
    {
      this.a |= 0x40;
      this.i = DescriptorProtos.UninterpretedOption.access$26800(paramUninterpretedOption);
      onChanged();
    }
    b(paramUninterpretedOption.unknownFields);
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
    if ((paramMessage instanceof DescriptorProtos.UninterpretedOption)) {
      return a((DescriptorProtos.UninterpretedOption)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public DescriptorProtos.UninterpretedOption.NamePart a(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.c;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.UninterpretedOption.NamePart)this.b.get(paramInt);
    }
    return (DescriptorProtos.UninterpretedOption.NamePart)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public Builder b(long paramLong)
  {
    this.a |= 0x8;
    this.f = paramLong;
    onChanged();
    return this;
  }
  
  public Builder b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (Builder)super.addRepeatedField(paramFieldDescriptor, paramObject);
  }
  
  public final Builder b(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.mergeUnknownFields(paramUnknownFieldSet);
  }
  
  public DescriptorProtos.UninterpretedOption b()
  {
    return DescriptorProtos.UninterpretedOption.getDefaultInstance();
  }
  
  public DescriptorProtos.UninterpretedOption c()
  {
    DescriptorProtos.UninterpretedOption localUninterpretedOption = d();
    if (localUninterpretedOption.isInitialized()) {
      return localUninterpretedOption;
    }
    throw newUninitializedMessageException(localUninterpretedOption);
  }
  
  public DescriptorProtos.UninterpretedOption d()
  {
    DescriptorProtos.UninterpretedOption localUninterpretedOption = new DescriptorProtos.UninterpretedOption(this, null);
    int m = this.a;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.c;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((m & 0x1) != 0)
      {
        this.b = Collections.unmodifiableList(this.b);
        this.a &= 0xFFFFFFFE;
      }
      DescriptorProtos.UninterpretedOption.access$26202(localUninterpretedOption, this.b);
    }
    else
    {
      DescriptorProtos.UninterpretedOption.access$26202(localUninterpretedOption, localRepeatedFieldBuilderV3.f());
    }
    if ((m & 0x2) != 0) {
      k = 1;
    } else {
      k = 0;
    }
    DescriptorProtos.UninterpretedOption.access$26302(localUninterpretedOption, this.d);
    int j = k;
    if ((m & 0x4) != 0)
    {
      DescriptorProtos.UninterpretedOption.access$26402(localUninterpretedOption, this.e);
      j = k | 0x2;
    }
    int k = j;
    if ((m & 0x8) != 0)
    {
      DescriptorProtos.UninterpretedOption.access$26502(localUninterpretedOption, this.f);
      k = j | 0x4;
    }
    j = k;
    if ((m & 0x10) != 0)
    {
      DescriptorProtos.UninterpretedOption.access$26602(localUninterpretedOption, this.g);
      j = k | 0x8;
    }
    k = j;
    if ((m & 0x20) != 0) {
      k = j | 0x10;
    }
    DescriptorProtos.UninterpretedOption.access$26702(localUninterpretedOption, this.h);
    j = k;
    if ((m & 0x40) != 0) {
      j = k | 0x20;
    }
    DescriptorProtos.UninterpretedOption.access$26802(localUninterpretedOption, this.i);
    DescriptorProtos.UninterpretedOption.access$26902(localUninterpretedOption, j);
    onBuilt();
    return localUninterpretedOption;
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
    return DescriptorProtos.R();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.S().a(DescriptorProtos.UninterpretedOption.class, Builder.class);
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
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.UninterpretedOption.Builder
 * JD-Core Version:    0.7.0.1
 */