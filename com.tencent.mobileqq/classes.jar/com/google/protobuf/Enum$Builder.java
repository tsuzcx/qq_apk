package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Enum$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements EnumOrBuilder
{
  private int a;
  private Object b = "";
  private List<EnumValue> c = Collections.emptyList();
  private RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> d;
  private List<Option> e = Collections.emptyList();
  private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> f;
  private SourceContext g;
  private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> h;
  private int i = 0;
  
  private Enum$Builder()
  {
    f();
  }
  
  private Enum$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    if (GeneratedMessageV3.alwaysUseFieldBuilders)
    {
      h();
      j();
    }
  }
  
  private void g()
  {
    if ((this.a & 0x1) == 0)
    {
      this.c = new ArrayList(this.c);
      this.a |= 0x1;
    }
  }
  
  private RepeatedFieldBuilderV3<EnumValue, EnumValue.Builder, EnumValueOrBuilder> h()
  {
    if (this.d == null)
    {
      List localList = this.c;
      int j = this.a;
      boolean bool = true;
      if ((j & 0x1) == 0) {
        bool = false;
      }
      this.d = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.c = null;
    }
    return this.d;
  }
  
  private void i()
  {
    if ((this.a & 0x2) == 0)
    {
      this.e = new ArrayList(this.e);
      this.a |= 0x2;
    }
  }
  
  private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> j()
  {
    if (this.f == null)
    {
      List localList = this.e;
      boolean bool;
      if ((this.a & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.f = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.e = null;
    }
    return this.f;
  }
  
  public Builder a()
  {
    super.clear();
    this.b = "";
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.d;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.c = Collections.emptyList();
      this.a &= 0xFFFFFFFE;
    }
    else
    {
      localRepeatedFieldBuilderV3.e();
    }
    localRepeatedFieldBuilderV3 = this.f;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.e = Collections.emptyList();
      this.a &= 0xFFFFFFFD;
    }
    else
    {
      localRepeatedFieldBuilderV3.e();
    }
    if (this.h == null)
    {
      this.g = null;
    }
    else
    {
      this.g = null;
      this.h = null;
    }
    this.i = 0;
    return this;
  }
  
  public Builder a(int paramInt)
  {
    this.i = paramInt;
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 120	com/google/protobuf/Enum:access$800	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 126 3 0
    //   12: checkcast 116	com/google/protobuf/Enum
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 129	com/google/protobuf/Enum$Builder:a	(Lcom/google/protobuf/Enum;)Lcom/google/protobuf/Enum$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 133	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 116	com/google/protobuf/Enum
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 137	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 129	com/google/protobuf/Enum$Builder:a	(Lcom/google/protobuf/Enum;)Lcom/google/protobuf/Enum$Builder;
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
  
  public Builder a(Enum paramEnum)
  {
    if (paramEnum == Enum.getDefaultInstance()) {
      return this;
    }
    if (!paramEnum.getName().isEmpty())
    {
      this.b = Enum.access$300(paramEnum);
      onChanged();
    }
    Object localObject1 = this.d;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      if (!Enum.access$400(paramEnum).isEmpty())
      {
        if (this.c.isEmpty())
        {
          this.c = Enum.access$400(paramEnum);
          this.a &= 0xFFFFFFFE;
        }
        else
        {
          g();
          this.c.addAll(Enum.access$400(paramEnum));
        }
        onChanged();
      }
    }
    else if (!Enum.access$400(paramEnum).isEmpty()) {
      if (this.d.d())
      {
        this.d.b();
        this.d = null;
        this.c = Enum.access$400(paramEnum);
        this.a &= 0xFFFFFFFE;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = h();
        } else {
          localObject1 = null;
        }
        this.d = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.d.a(Enum.access$400(paramEnum));
      }
    }
    if (this.f == null)
    {
      if (!Enum.access$500(paramEnum).isEmpty())
      {
        if (this.e.isEmpty())
        {
          this.e = Enum.access$500(paramEnum);
          this.a &= 0xFFFFFFFD;
        }
        else
        {
          i();
          this.e.addAll(Enum.access$500(paramEnum));
        }
        onChanged();
      }
    }
    else if (!Enum.access$500(paramEnum).isEmpty()) {
      if (this.f.d())
      {
        this.f.b();
        this.f = null;
        this.e = Enum.access$500(paramEnum);
        this.a &= 0xFFFFFFFD;
        localObject1 = localObject2;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = j();
        }
        this.f = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.f.a(Enum.access$500(paramEnum));
      }
    }
    if (paramEnum.hasSourceContext()) {
      a(paramEnum.getSourceContext());
    }
    if (Enum.access$700(paramEnum) != 0) {
      a(paramEnum.getSyntaxValue());
    }
    b(paramEnum.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(Message paramMessage)
  {
    if ((paramMessage instanceof Enum)) {
      return a((Enum)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public Builder a(SourceContext paramSourceContext)
  {
    Object localObject = this.h;
    if (localObject == null)
    {
      localObject = this.g;
      if (localObject != null) {
        this.g = SourceContext.newBuilder((SourceContext)localObject).a(paramSourceContext).d();
      } else {
        this.g = paramSourceContext;
      }
      onChanged();
      return this;
    }
    ((SingleFieldBuilderV3)localObject).b(paramSourceContext);
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
  
  public Enum b()
  {
    return Enum.getDefaultInstance();
  }
  
  public Enum c()
  {
    Enum localEnum = d();
    if (localEnum.isInitialized()) {
      return localEnum;
    }
    throw newUninitializedMessageException(localEnum);
  }
  
  public Enum d()
  {
    Enum localEnum = new Enum(this, null);
    int j = this.a;
    Enum.access$302(localEnum, this.b);
    Object localObject = this.d;
    if (localObject == null)
    {
      if ((this.a & 0x1) != 0)
      {
        this.c = Collections.unmodifiableList(this.c);
        this.a &= 0xFFFFFFFE;
      }
      Enum.access$402(localEnum, this.c);
    }
    else
    {
      Enum.access$402(localEnum, ((RepeatedFieldBuilderV3)localObject).f());
    }
    localObject = this.f;
    if (localObject == null)
    {
      if ((this.a & 0x2) != 0)
      {
        this.e = Collections.unmodifiableList(this.e);
        this.a &= 0xFFFFFFFD;
      }
      Enum.access$502(localEnum, this.e);
    }
    else
    {
      Enum.access$502(localEnum, ((RepeatedFieldBuilderV3)localObject).f());
    }
    localObject = this.h;
    if (localObject == null) {
      Enum.access$602(localEnum, this.g);
    } else {
      Enum.access$602(localEnum, (SourceContext)((SingleFieldBuilderV3)localObject).d());
    }
    Enum.access$702(localEnum, this.i);
    onBuilt();
    return localEnum;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return TypeProto.e;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return TypeProto.f.a(Enum.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Enum.Builder
 * JD-Core Version:    0.7.0.1
 */