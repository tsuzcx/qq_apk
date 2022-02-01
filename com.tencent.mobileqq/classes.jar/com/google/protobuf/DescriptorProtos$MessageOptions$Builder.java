package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$MessageOptions$Builder
  extends GeneratedMessageV3.ExtendableBuilder<DescriptorProtos.MessageOptions, Builder>
  implements DescriptorProtos.MessageOptionsOrBuilder
{
  private int a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private List<DescriptorProtos.UninterpretedOption> f = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> g;
  
  private DescriptorProtos$MessageOptions$Builder()
  {
    i();
  }
  
  private DescriptorProtos$MessageOptions$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
    if ((this.a & 0x10) == 0)
    {
      this.f = new ArrayList(this.f);
      this.a |= 0x10;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> k()
  {
    if (this.g == null)
    {
      List localList = this.f;
      boolean bool;
      if ((this.a & 0x10) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.g = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.f = null;
    }
    return this.g;
  }
  
  public Builder a()
  {
    super.g();
    this.b = false;
    this.a &= 0xFFFFFFFE;
    this.c = false;
    this.a &= 0xFFFFFFFD;
    this.d = false;
    this.a &= 0xFFFFFFFB;
    this.e = false;
    this.a &= 0xFFFFFFF7;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.g;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.f = Collections.emptyList();
      this.a &= 0xFFFFFFEF;
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
    //   2: getstatic 100	com/google/protobuf/DescriptorProtos$MessageOptions:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 106 3 0
    //   12: checkcast 96	com/google/protobuf/DescriptorProtos$MessageOptions
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 109	com/google/protobuf/DescriptorProtos$MessageOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$MessageOptions;)Lcom/google/protobuf/DescriptorProtos$MessageOptions$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 113	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 96	com/google/protobuf/DescriptorProtos$MessageOptions
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 117	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 109	com/google/protobuf/DescriptorProtos$MessageOptions$Builder:a	(Lcom/google/protobuf/DescriptorProtos$MessageOptions;)Lcom/google/protobuf/DescriptorProtos$MessageOptions$Builder;
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
  
  public Builder a(DescriptorProtos.MessageOptions paramMessageOptions)
  {
    if (paramMessageOptions == DescriptorProtos.MessageOptions.getDefaultInstance()) {
      return this;
    }
    if (paramMessageOptions.hasMessageSetWireFormat()) {
      a(paramMessageOptions.getMessageSetWireFormat());
    }
    if (paramMessageOptions.hasNoStandardDescriptorAccessor()) {
      b(paramMessageOptions.getNoStandardDescriptorAccessor());
    }
    if (paramMessageOptions.hasDeprecated()) {
      c(paramMessageOptions.getDeprecated());
    }
    if (paramMessageOptions.hasMapEntry()) {
      d(paramMessageOptions.getMapEntry());
    }
    if (this.g == null)
    {
      if (!DescriptorProtos.MessageOptions.access$18600(paramMessageOptions).isEmpty())
      {
        if (this.f.isEmpty())
        {
          this.f = DescriptorProtos.MessageOptions.access$18600(paramMessageOptions);
          this.a &= 0xFFFFFFEF;
        }
        else
        {
          j();
          this.f.addAll(DescriptorProtos.MessageOptions.access$18600(paramMessageOptions));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.MessageOptions.access$18600(paramMessageOptions).isEmpty()) {
      if (this.g.d())
      {
        this.g.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.g = null;
        this.f = DescriptorProtos.MessageOptions.access$18600(paramMessageOptions);
        this.a &= 0xFFFFFFEF;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = k();
        }
        this.g = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.g.a(DescriptorProtos.MessageOptions.access$18600(paramMessageOptions));
      }
    }
    a(paramMessageOptions);
    b(paramMessageOptions.unknownFields);
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
    if ((paramMessage instanceof DescriptorProtos.MessageOptions)) {
      return a((DescriptorProtos.MessageOptions)paramMessage);
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
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.g;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.UninterpretedOption)this.f.get(paramInt);
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
  
  public DescriptorProtos.MessageOptions b()
  {
    return DescriptorProtos.MessageOptions.getDefaultInstance();
  }
  
  public Builder c(boolean paramBoolean)
  {
    this.a |= 0x4;
    this.d = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.MessageOptions c()
  {
    DescriptorProtos.MessageOptions localMessageOptions = d();
    if (localMessageOptions.isInitialized()) {
      return localMessageOptions;
    }
    throw newUninitializedMessageException(localMessageOptions);
  }
  
  public Builder d(boolean paramBoolean)
  {
    this.a |= 0x8;
    this.e = paramBoolean;
    onChanged();
    return this;
  }
  
  public DescriptorProtos.MessageOptions d()
  {
    DescriptorProtos.MessageOptions localMessageOptions = new DescriptorProtos.MessageOptions(this, null);
    int k = this.a;
    if ((k & 0x1) != 0)
    {
      DescriptorProtos.MessageOptions.access$18202(localMessageOptions, this.b);
      j = 1;
    }
    else
    {
      j = 0;
    }
    int i = j;
    if ((k & 0x2) != 0)
    {
      DescriptorProtos.MessageOptions.access$18302(localMessageOptions, this.c);
      i = j | 0x2;
    }
    int j = i;
    if ((k & 0x4) != 0)
    {
      DescriptorProtos.MessageOptions.access$18402(localMessageOptions, this.d);
      j = i | 0x4;
    }
    i = j;
    if ((k & 0x8) != 0)
    {
      DescriptorProtos.MessageOptions.access$18502(localMessageOptions, this.e);
      i = j | 0x8;
    }
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.g;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((this.a & 0x10) != 0)
      {
        this.f = Collections.unmodifiableList(this.f);
        this.a &= 0xFFFFFFEF;
      }
      DescriptorProtos.MessageOptions.access$18602(localMessageOptions, this.f);
    }
    else
    {
      DescriptorProtos.MessageOptions.access$18602(localMessageOptions, localRepeatedFieldBuilderV3.f());
    }
    DescriptorProtos.MessageOptions.access$18702(localMessageOptions, i);
    onBuilt();
    return localMessageOptions;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public int f()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.g;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.f.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.D();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.E().a(DescriptorProtos.MessageOptions.class, Builder.class);
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
 * Qualified Name:     com.google.protobuf.DescriptorProtos.MessageOptions.Builder
 * JD-Core Version:    0.7.0.1
 */