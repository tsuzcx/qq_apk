package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$EnumDescriptorProto$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.EnumDescriptorProtoOrBuilder
{
  private int a;
  private Object b = "";
  private List<DescriptorProtos.EnumValueDescriptorProto> c = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.EnumValueDescriptorProto, DescriptorProtos.EnumValueDescriptorProto.Builder, DescriptorProtos.EnumValueDescriptorProtoOrBuilder> d;
  private DescriptorProtos.EnumOptions e;
  private SingleFieldBuilderV3<DescriptorProtos.EnumOptions, DescriptorProtos.EnumOptions.Builder, DescriptorProtos.EnumOptionsOrBuilder> f;
  private List<DescriptorProtos.EnumDescriptorProto.EnumReservedRange> g = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.EnumDescriptorProto.EnumReservedRange, DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder, DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder> h;
  private LazyStringList i = LazyStringArrayList.a;
  
  private DescriptorProtos$EnumDescriptorProto$Builder()
  {
    i();
  }
  
  private DescriptorProtos$EnumDescriptorProto$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    i();
  }
  
  private void i()
  {
    if (GeneratedMessageV3.alwaysUseFieldBuilders)
    {
      k();
      l();
      n();
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
  
  private RepeatedFieldBuilderV3<DescriptorProtos.EnumValueDescriptorProto, DescriptorProtos.EnumValueDescriptorProto.Builder, DescriptorProtos.EnumValueDescriptorProtoOrBuilder> k()
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
  
  private SingleFieldBuilderV3<DescriptorProtos.EnumOptions, DescriptorProtos.EnumOptions.Builder, DescriptorProtos.EnumOptionsOrBuilder> l()
  {
    if (this.f == null)
    {
      this.f = new SingleFieldBuilderV3(h(), getParentForChildren(), isClean());
      this.e = null;
    }
    return this.f;
  }
  
  private void m()
  {
    if ((this.a & 0x8) == 0)
    {
      this.g = new ArrayList(this.g);
      this.a |= 0x8;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.EnumDescriptorProto.EnumReservedRange, DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder, DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder> n()
  {
    if (this.h == null)
    {
      List localList = this.g;
      boolean bool;
      if ((this.a & 0x8) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.h = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.g = null;
    }
    return this.h;
  }
  
  private void o()
  {
    if ((this.a & 0x10) == 0)
    {
      this.i = new LazyStringArrayList(this.i);
      this.a |= 0x10;
    }
  }
  
  public Builder a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    Object localObject = this.d;
    if (localObject == null)
    {
      this.c = Collections.emptyList();
      this.a &= 0xFFFFFFFD;
    }
    else
    {
      ((RepeatedFieldBuilderV3)localObject).e();
    }
    localObject = this.f;
    if (localObject == null) {
      this.e = null;
    } else {
      ((SingleFieldBuilderV3)localObject).g();
    }
    this.a &= 0xFFFFFFFB;
    localObject = this.h;
    if (localObject == null)
    {
      this.g = Collections.emptyList();
      this.a &= 0xFFFFFFF7;
    }
    else
    {
      ((RepeatedFieldBuilderV3)localObject).e();
    }
    this.i = LazyStringArrayList.a;
    this.a &= 0xFFFFFFEF;
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 143	com/google/protobuf/DescriptorProtos$EnumDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 149 3 0
    //   12: checkcast 139	com/google/protobuf/DescriptorProtos$EnumDescriptorProto
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 152	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 156	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 139	com/google/protobuf/DescriptorProtos$EnumDescriptorProto
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 160	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 152	com/google/protobuf/DescriptorProtos$EnumDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto$Builder;
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
  
  public Builder a(DescriptorProtos.EnumDescriptorProto paramEnumDescriptorProto)
  {
    if (paramEnumDescriptorProto == DescriptorProtos.EnumDescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (paramEnumDescriptorProto.hasName())
    {
      this.a |= 0x1;
      this.b = DescriptorProtos.EnumDescriptorProto.access$10900(paramEnumDescriptorProto);
      onChanged();
    }
    Object localObject1 = this.d;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      if (!DescriptorProtos.EnumDescriptorProto.access$11000(paramEnumDescriptorProto).isEmpty())
      {
        if (this.c.isEmpty())
        {
          this.c = DescriptorProtos.EnumDescriptorProto.access$11000(paramEnumDescriptorProto);
          this.a &= 0xFFFFFFFD;
        }
        else
        {
          j();
          this.c.addAll(DescriptorProtos.EnumDescriptorProto.access$11000(paramEnumDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.EnumDescriptorProto.access$11000(paramEnumDescriptorProto).isEmpty()) {
      if (this.d.d())
      {
        this.d.b();
        this.d = null;
        this.c = DescriptorProtos.EnumDescriptorProto.access$11000(paramEnumDescriptorProto);
        this.a &= 0xFFFFFFFD;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = k();
        } else {
          localObject1 = null;
        }
        this.d = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.d.a(DescriptorProtos.EnumDescriptorProto.access$11000(paramEnumDescriptorProto));
      }
    }
    if (paramEnumDescriptorProto.hasOptions()) {
      a(paramEnumDescriptorProto.getOptions());
    }
    if (this.h == null)
    {
      if (!DescriptorProtos.EnumDescriptorProto.access$11200(paramEnumDescriptorProto).isEmpty())
      {
        if (this.g.isEmpty())
        {
          this.g = DescriptorProtos.EnumDescriptorProto.access$11200(paramEnumDescriptorProto);
          this.a &= 0xFFFFFFF7;
        }
        else
        {
          m();
          this.g.addAll(DescriptorProtos.EnumDescriptorProto.access$11200(paramEnumDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.EnumDescriptorProto.access$11200(paramEnumDescriptorProto).isEmpty()) {
      if (this.h.d())
      {
        this.h.b();
        this.h = null;
        this.g = DescriptorProtos.EnumDescriptorProto.access$11200(paramEnumDescriptorProto);
        this.a &= 0xFFFFFFF7;
        localObject1 = localObject2;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = n();
        }
        this.h = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.h.a(DescriptorProtos.EnumDescriptorProto.access$11200(paramEnumDescriptorProto));
      }
    }
    if (!DescriptorProtos.EnumDescriptorProto.access$11300(paramEnumDescriptorProto).isEmpty())
    {
      if (this.i.isEmpty())
      {
        this.i = DescriptorProtos.EnumDescriptorProto.access$11300(paramEnumDescriptorProto);
        this.a &= 0xFFFFFFEF;
      }
      else
      {
        o();
        this.i.addAll(DescriptorProtos.EnumDescriptorProto.access$11300(paramEnumDescriptorProto));
      }
      onChanged();
    }
    b(paramEnumDescriptorProto.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(DescriptorProtos.EnumOptions paramEnumOptions)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      if ((this.a & 0x4) != 0)
      {
        localObject = this.e;
        if ((localObject != null) && (localObject != DescriptorProtos.EnumOptions.getDefaultInstance()))
        {
          this.e = DescriptorProtos.EnumOptions.newBuilder(this.e).a(paramEnumOptions).d();
          break label60;
        }
      }
      this.e = paramEnumOptions;
      label60:
      onChanged();
    }
    else
    {
      ((SingleFieldBuilderV3)localObject).b(paramEnumOptions);
    }
    this.a |= 0x4;
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
    if ((paramMessage instanceof DescriptorProtos.EnumDescriptorProto)) {
      return a((DescriptorProtos.EnumDescriptorProto)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public DescriptorProtos.EnumValueDescriptorProto a(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.d;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.EnumValueDescriptorProto)this.c.get(paramInt);
    }
    return (DescriptorProtos.EnumValueDescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public Builder b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (Builder)super.addRepeatedField(paramFieldDescriptor, paramObject);
  }
  
  public final Builder b(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.mergeUnknownFields(paramUnknownFieldSet);
  }
  
  public DescriptorProtos.EnumDescriptorProto b()
  {
    return DescriptorProtos.EnumDescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.EnumDescriptorProto c()
  {
    DescriptorProtos.EnumDescriptorProto localEnumDescriptorProto = d();
    if (localEnumDescriptorProto.isInitialized()) {
      return localEnumDescriptorProto;
    }
    throw newUninitializedMessageException(localEnumDescriptorProto);
  }
  
  public DescriptorProtos.EnumDescriptorProto d()
  {
    DescriptorProtos.EnumDescriptorProto localEnumDescriptorProto = new DescriptorProtos.EnumDescriptorProto(this, null);
    int m = this.a;
    int j;
    if ((m & 0x1) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    DescriptorProtos.EnumDescriptorProto.access$10902(localEnumDescriptorProto, this.b);
    Object localObject = this.d;
    if (localObject == null)
    {
      if ((this.a & 0x2) != 0)
      {
        this.c = Collections.unmodifiableList(this.c);
        this.a &= 0xFFFFFFFD;
      }
      DescriptorProtos.EnumDescriptorProto.access$11002(localEnumDescriptorProto, this.c);
    }
    else
    {
      DescriptorProtos.EnumDescriptorProto.access$11002(localEnumDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    int k = j;
    if ((m & 0x4) != 0)
    {
      localObject = this.f;
      if (localObject == null) {
        DescriptorProtos.EnumDescriptorProto.access$11102(localEnumDescriptorProto, this.e);
      } else {
        DescriptorProtos.EnumDescriptorProto.access$11102(localEnumDescriptorProto, (DescriptorProtos.EnumOptions)((SingleFieldBuilderV3)localObject).d());
      }
      k = j | 0x2;
    }
    localObject = this.h;
    if (localObject == null)
    {
      if ((this.a & 0x8) != 0)
      {
        this.g = Collections.unmodifiableList(this.g);
        this.a &= 0xFFFFFFF7;
      }
      DescriptorProtos.EnumDescriptorProto.access$11202(localEnumDescriptorProto, this.g);
    }
    else
    {
      DescriptorProtos.EnumDescriptorProto.access$11202(localEnumDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    if ((this.a & 0x10) != 0)
    {
      this.i = this.i.e();
      this.a &= 0xFFFFFFEF;
    }
    DescriptorProtos.EnumDescriptorProto.access$11302(localEnumDescriptorProto, this.i);
    DescriptorProtos.EnumDescriptorProto.access$11402(localEnumDescriptorProto, k);
    onBuilt();
    return localEnumDescriptorProto;
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
  
  public boolean g()
  {
    return (this.a & 0x4) != 0;
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.r();
  }
  
  public DescriptorProtos.EnumOptions h()
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      DescriptorProtos.EnumOptions localEnumOptions = this.e;
      localObject = localEnumOptions;
      if (localEnumOptions == null) {
        localObject = DescriptorProtos.EnumOptions.getDefaultInstance();
      }
      return localObject;
    }
    return (DescriptorProtos.EnumOptions)((SingleFieldBuilderV3)localObject).c();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.s().a(DescriptorProtos.EnumDescriptorProto.class, Builder.class);
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
    return (!g()) || (h().isInitialized());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.EnumDescriptorProto.Builder
 * JD-Core Version:    0.7.0.1
 */