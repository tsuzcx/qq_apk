package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Type$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements TypeOrBuilder
{
  private int a;
  private Object b = "";
  private List<Field> c = Collections.emptyList();
  private RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> d;
  private LazyStringList e = LazyStringArrayList.a;
  private List<Option> f = Collections.emptyList();
  private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> g;
  private SourceContext h;
  private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> i;
  private int j = 0;
  
  private Type$Builder()
  {
    f();
  }
  
  private Type$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    if (GeneratedMessageV3.alwaysUseFieldBuilders)
    {
      h();
      k();
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
  
  private RepeatedFieldBuilderV3<Field, Field.Builder, FieldOrBuilder> h()
  {
    if (this.d == null)
    {
      List localList = this.c;
      int k = this.a;
      boolean bool = true;
      if ((k & 0x1) == 0) {
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
      this.e = new LazyStringArrayList(this.e);
      this.a |= 0x2;
    }
  }
  
  private void j()
  {
    if ((this.a & 0x4) == 0)
    {
      this.f = new ArrayList(this.f);
      this.a |= 0x4;
    }
  }
  
  private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> k()
  {
    if (this.g == null)
    {
      List localList = this.f;
      boolean bool;
      if ((this.a & 0x4) != 0) {
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
    this.e = LazyStringArrayList.a;
    this.a &= 0xFFFFFFFD;
    localRepeatedFieldBuilderV3 = this.g;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.f = Collections.emptyList();
      this.a &= 0xFFFFFFFB;
    }
    else
    {
      localRepeatedFieldBuilderV3.e();
    }
    if (this.i == null)
    {
      this.h = null;
    }
    else
    {
      this.h = null;
      this.i = null;
    }
    this.j = 0;
    return this;
  }
  
  public Builder a(int paramInt)
  {
    this.j = paramInt;
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 131	com/google/protobuf/Type:access$900	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 137 3 0
    //   12: checkcast 127	com/google/protobuf/Type
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 140	com/google/protobuf/Type$Builder:a	(Lcom/google/protobuf/Type;)Lcom/google/protobuf/Type$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 144	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 127	com/google/protobuf/Type
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 148	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 140	com/google/protobuf/Type$Builder:a	(Lcom/google/protobuf/Type;)Lcom/google/protobuf/Type$Builder;
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
  
  public Builder a(Message paramMessage)
  {
    if ((paramMessage instanceof Type)) {
      return a((Type)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public Builder a(SourceContext paramSourceContext)
  {
    Object localObject = this.i;
    if (localObject == null)
    {
      localObject = this.h;
      if (localObject != null) {
        this.h = SourceContext.newBuilder((SourceContext)localObject).a(paramSourceContext).d();
      } else {
        this.h = paramSourceContext;
      }
      onChanged();
      return this;
    }
    ((SingleFieldBuilderV3)localObject).b(paramSourceContext);
    return this;
  }
  
  public Builder a(Type paramType)
  {
    if (paramType == Type.getDefaultInstance()) {
      return this;
    }
    if (!paramType.getName().isEmpty())
    {
      this.b = Type.access$300(paramType);
      onChanged();
    }
    Object localObject1 = this.d;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      if (!Type.access$400(paramType).isEmpty())
      {
        if (this.c.isEmpty())
        {
          this.c = Type.access$400(paramType);
          this.a &= 0xFFFFFFFE;
        }
        else
        {
          g();
          this.c.addAll(Type.access$400(paramType));
        }
        onChanged();
      }
    }
    else if (!Type.access$400(paramType).isEmpty()) {
      if (this.d.d())
      {
        this.d.b();
        this.d = null;
        this.c = Type.access$400(paramType);
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
        this.d.a(Type.access$400(paramType));
      }
    }
    if (!Type.access$500(paramType).isEmpty())
    {
      if (this.e.isEmpty())
      {
        this.e = Type.access$500(paramType);
        this.a &= 0xFFFFFFFD;
      }
      else
      {
        i();
        this.e.addAll(Type.access$500(paramType));
      }
      onChanged();
    }
    if (this.g == null)
    {
      if (!Type.access$600(paramType).isEmpty())
      {
        if (this.f.isEmpty())
        {
          this.f = Type.access$600(paramType);
          this.a &= 0xFFFFFFFB;
        }
        else
        {
          j();
          this.f.addAll(Type.access$600(paramType));
        }
        onChanged();
      }
    }
    else if (!Type.access$600(paramType).isEmpty()) {
      if (this.g.d())
      {
        this.g.b();
        this.g = null;
        this.f = Type.access$600(paramType);
        this.a &= 0xFFFFFFFB;
        localObject1 = localObject2;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = k();
        }
        this.g = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.g.a(Type.access$600(paramType));
      }
    }
    if (paramType.hasSourceContext()) {
      a(paramType.getSourceContext());
    }
    if (Type.access$800(paramType) != 0) {
      a(paramType.getSyntaxValue());
    }
    b(paramType.unknownFields);
    onChanged();
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
  
  public Type b()
  {
    return Type.getDefaultInstance();
  }
  
  public Type c()
  {
    Type localType = d();
    if (localType.isInitialized()) {
      return localType;
    }
    throw newUninitializedMessageException(localType);
  }
  
  public Type d()
  {
    Type localType = new Type(this, null);
    int k = this.a;
    Type.access$302(localType, this.b);
    Object localObject = this.d;
    if (localObject == null)
    {
      if ((this.a & 0x1) != 0)
      {
        this.c = Collections.unmodifiableList(this.c);
        this.a &= 0xFFFFFFFE;
      }
      Type.access$402(localType, this.c);
    }
    else
    {
      Type.access$402(localType, ((RepeatedFieldBuilderV3)localObject).f());
    }
    if ((this.a & 0x2) != 0)
    {
      this.e = this.e.e();
      this.a &= 0xFFFFFFFD;
    }
    Type.access$502(localType, this.e);
    localObject = this.g;
    if (localObject == null)
    {
      if ((this.a & 0x4) != 0)
      {
        this.f = Collections.unmodifiableList(this.f);
        this.a &= 0xFFFFFFFB;
      }
      Type.access$602(localType, this.f);
    }
    else
    {
      Type.access$602(localType, ((RepeatedFieldBuilderV3)localObject).f());
    }
    localObject = this.i;
    if (localObject == null) {
      Type.access$702(localType, this.h);
    } else {
      Type.access$702(localType, (SourceContext)((SingleFieldBuilderV3)localObject).d());
    }
    Type.access$802(localType, this.j);
    onBuilt();
    return localType;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return TypeProto.a;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return TypeProto.b.a(Type.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Type.Builder
 * JD-Core Version:    0.7.0.1
 */