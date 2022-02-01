package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$ServiceDescriptorProto$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.ServiceDescriptorProtoOrBuilder
{
  private int a;
  private Object b = "";
  private List<DescriptorProtos.MethodDescriptorProto> c = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.MethodDescriptorProto, DescriptorProtos.MethodDescriptorProto.Builder, DescriptorProtos.MethodDescriptorProtoOrBuilder> d;
  private DescriptorProtos.ServiceOptions e;
  private SingleFieldBuilderV3<DescriptorProtos.ServiceOptions, DescriptorProtos.ServiceOptions.Builder, DescriptorProtos.ServiceOptionsOrBuilder> f;
  
  private DescriptorProtos$ServiceDescriptorProto$Builder()
  {
    i();
  }
  
  private DescriptorProtos$ServiceDescriptorProto$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
  
  private RepeatedFieldBuilderV3<DescriptorProtos.MethodDescriptorProto, DescriptorProtos.MethodDescriptorProto.Builder, DescriptorProtos.MethodDescriptorProtoOrBuilder> k()
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
  
  private SingleFieldBuilderV3<DescriptorProtos.ServiceOptions, DescriptorProtos.ServiceOptions.Builder, DescriptorProtos.ServiceOptionsOrBuilder> l()
  {
    if (this.f == null)
    {
      this.f = new SingleFieldBuilderV3(h(), getParentForChildren(), isClean());
      this.e = null;
    }
    return this.f;
  }
  
  public DescriptorProtos.MethodDescriptorProto a(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.d;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.MethodDescriptorProto)this.c.get(paramInt);
    }
    return (DescriptorProtos.MethodDescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
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
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 133	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 139 3 0
    //   12: checkcast 129	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 142	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$ServiceDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$ServiceDescriptorProto$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 146	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 129	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 150	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 142	com/google/protobuf/DescriptorProtos$ServiceDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$ServiceDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$ServiceDescriptorProto$Builder;
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
  
  public Builder a(DescriptorProtos.ServiceDescriptorProto paramServiceDescriptorProto)
  {
    if (paramServiceDescriptorProto == DescriptorProtos.ServiceDescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (paramServiceDescriptorProto.hasName())
    {
      this.a |= 0x1;
      this.b = DescriptorProtos.ServiceDescriptorProto.access$13100(paramServiceDescriptorProto);
      onChanged();
    }
    if (this.d == null)
    {
      if (!DescriptorProtos.ServiceDescriptorProto.access$13200(paramServiceDescriptorProto).isEmpty())
      {
        if (this.c.isEmpty())
        {
          this.c = DescriptorProtos.ServiceDescriptorProto.access$13200(paramServiceDescriptorProto);
          this.a &= 0xFFFFFFFD;
        }
        else
        {
          j();
          this.c.addAll(DescriptorProtos.ServiceDescriptorProto.access$13200(paramServiceDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.ServiceDescriptorProto.access$13200(paramServiceDescriptorProto).isEmpty()) {
      if (this.d.d())
      {
        this.d.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.d = null;
        this.c = DescriptorProtos.ServiceDescriptorProto.access$13200(paramServiceDescriptorProto);
        this.a &= 0xFFFFFFFD;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = k();
        }
        this.d = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.d.a(DescriptorProtos.ServiceDescriptorProto.access$13200(paramServiceDescriptorProto));
      }
    }
    if (paramServiceDescriptorProto.hasOptions()) {
      a(paramServiceDescriptorProto.getOptions());
    }
    b(paramServiceDescriptorProto.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(DescriptorProtos.ServiceOptions paramServiceOptions)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      if ((this.a & 0x4) != 0)
      {
        localObject = this.e;
        if ((localObject != null) && (localObject != DescriptorProtos.ServiceOptions.getDefaultInstance()))
        {
          this.e = DescriptorProtos.ServiceOptions.newBuilder(this.e).a(paramServiceOptions).d();
          break label60;
        }
      }
      this.e = paramServiceOptions;
      label60:
      onChanged();
    }
    else
    {
      ((SingleFieldBuilderV3)localObject).b(paramServiceOptions);
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
    if ((paramMessage instanceof DescriptorProtos.ServiceDescriptorProto)) {
      return a((DescriptorProtos.ServiceDescriptorProto)paramMessage);
    }
    super.mergeFrom(paramMessage);
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
  
  public DescriptorProtos.ServiceDescriptorProto b()
  {
    return DescriptorProtos.ServiceDescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.ServiceDescriptorProto c()
  {
    DescriptorProtos.ServiceDescriptorProto localServiceDescriptorProto = d();
    if (localServiceDescriptorProto.isInitialized()) {
      return localServiceDescriptorProto;
    }
    throw newUninitializedMessageException(localServiceDescriptorProto);
  }
  
  public DescriptorProtos.ServiceDescriptorProto d()
  {
    DescriptorProtos.ServiceDescriptorProto localServiceDescriptorProto = new DescriptorProtos.ServiceDescriptorProto(this, null);
    int k = this.a;
    int i;
    if ((k & 0x1) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    DescriptorProtos.ServiceDescriptorProto.access$13102(localServiceDescriptorProto, this.b);
    Object localObject = this.d;
    if (localObject == null)
    {
      if ((this.a & 0x2) != 0)
      {
        this.c = Collections.unmodifiableList(this.c);
        this.a &= 0xFFFFFFFD;
      }
      DescriptorProtos.ServiceDescriptorProto.access$13202(localServiceDescriptorProto, this.c);
    }
    else
    {
      DescriptorProtos.ServiceDescriptorProto.access$13202(localServiceDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    int j = i;
    if ((k & 0x4) != 0)
    {
      localObject = this.f;
      if (localObject == null) {
        DescriptorProtos.ServiceDescriptorProto.access$13302(localServiceDescriptorProto, this.e);
      } else {
        DescriptorProtos.ServiceDescriptorProto.access$13302(localServiceDescriptorProto, (DescriptorProtos.ServiceOptions)((SingleFieldBuilderV3)localObject).d());
      }
      j = i | 0x2;
    }
    DescriptorProtos.ServiceDescriptorProto.access$13402(localServiceDescriptorProto, j);
    onBuilt();
    return localServiceDescriptorProto;
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
    return DescriptorProtos.x();
  }
  
  public DescriptorProtos.ServiceOptions h()
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      DescriptorProtos.ServiceOptions localServiceOptions = this.e;
      localObject = localServiceOptions;
      if (localServiceOptions == null) {
        localObject = DescriptorProtos.ServiceOptions.getDefaultInstance();
      }
      return localObject;
    }
    return (DescriptorProtos.ServiceOptions)((SingleFieldBuilderV3)localObject).c();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.y().a(DescriptorProtos.ServiceDescriptorProto.class, Builder.class);
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
    return (!g()) || (h().isInitialized());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.ServiceDescriptorProto.Builder
 * JD-Core Version:    0.7.0.1
 */