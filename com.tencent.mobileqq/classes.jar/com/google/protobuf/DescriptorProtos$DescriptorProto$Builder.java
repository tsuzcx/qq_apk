package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$DescriptorProto$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.DescriptorProtoOrBuilder
{
  private int a;
  private Object b = "";
  private List<DescriptorProtos.FieldDescriptorProto> c = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> d;
  private List<DescriptorProtos.FieldDescriptorProto> e = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> f;
  private List<DescriptorProtos.DescriptorProto> g = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.DescriptorProto, Builder, DescriptorProtos.DescriptorProtoOrBuilder> h;
  private List<DescriptorProtos.EnumDescriptorProto> i = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> j;
  private List<DescriptorProtos.DescriptorProto.ExtensionRange> k = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.DescriptorProto.ExtensionRange, DescriptorProtos.DescriptorProto.ExtensionRange.Builder, DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> l;
  private List<DescriptorProtos.OneofDescriptorProto> m = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.OneofDescriptorProto, DescriptorProtos.OneofDescriptorProto.Builder, DescriptorProtos.OneofDescriptorProtoOrBuilder> n;
  private DescriptorProtos.MessageOptions o;
  private SingleFieldBuilderV3<DescriptorProtos.MessageOptions, DescriptorProtos.MessageOptions.Builder, DescriptorProtos.MessageOptionsOrBuilder> p;
  private List<DescriptorProtos.DescriptorProto.ReservedRange> q = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.DescriptorProto.ReservedRange, DescriptorProtos.DescriptorProto.ReservedRange.Builder, DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder> r;
  private LazyStringList s = LazyStringArrayList.a;
  
  private DescriptorProtos$DescriptorProto$Builder()
  {
    n();
  }
  
  private DescriptorProtos$DescriptorProto$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    n();
  }
  
  private SingleFieldBuilderV3<DescriptorProtos.MessageOptions, DescriptorProtos.MessageOptions.Builder, DescriptorProtos.MessageOptionsOrBuilder> A()
  {
    if (this.p == null)
    {
      this.p = new SingleFieldBuilderV3(m(), getParentForChildren(), isClean());
      this.o = null;
    }
    return this.p;
  }
  
  private void B()
  {
    if ((this.a & 0x100) == 0)
    {
      this.q = new ArrayList(this.q);
      this.a |= 0x100;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.DescriptorProto.ReservedRange, DescriptorProtos.DescriptorProto.ReservedRange.Builder, DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder> C()
  {
    if (this.r == null)
    {
      List localList = this.q;
      boolean bool;
      if ((this.a & 0x100) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.r = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.q = null;
    }
    return this.r;
  }
  
  private void D()
  {
    if ((this.a & 0x200) == 0)
    {
      this.s = new LazyStringArrayList(this.s);
      this.a |= 0x200;
    }
  }
  
  private void n()
  {
    if (GeneratedMessageV3.alwaysUseFieldBuilders)
    {
      p();
      r();
      t();
      v();
      x();
      z();
      A();
      C();
    }
  }
  
  private void o()
  {
    if ((this.a & 0x2) == 0)
    {
      this.c = new ArrayList(this.c);
      this.a |= 0x2;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> p()
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
  
  private void q()
  {
    if ((this.a & 0x4) == 0)
    {
      this.e = new ArrayList(this.e);
      this.a |= 0x4;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> r()
  {
    if (this.f == null)
    {
      List localList = this.e;
      boolean bool;
      if ((this.a & 0x4) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.f = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.e = null;
    }
    return this.f;
  }
  
  private void s()
  {
    if ((this.a & 0x8) == 0)
    {
      this.g = new ArrayList(this.g);
      this.a |= 0x8;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.DescriptorProto, Builder, DescriptorProtos.DescriptorProtoOrBuilder> t()
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
  
  private void u()
  {
    if ((this.a & 0x10) == 0)
    {
      this.i = new ArrayList(this.i);
      this.a |= 0x10;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> v()
  {
    if (this.j == null)
    {
      List localList = this.i;
      boolean bool;
      if ((this.a & 0x10) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.j = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.i = null;
    }
    return this.j;
  }
  
  private void w()
  {
    if ((this.a & 0x20) == 0)
    {
      this.k = new ArrayList(this.k);
      this.a |= 0x20;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.DescriptorProto.ExtensionRange, DescriptorProtos.DescriptorProto.ExtensionRange.Builder, DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> x()
  {
    if (this.l == null)
    {
      List localList = this.k;
      boolean bool;
      if ((this.a & 0x20) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.l = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.k = null;
    }
    return this.l;
  }
  
  private void y()
  {
    if ((this.a & 0x40) == 0)
    {
      this.m = new ArrayList(this.m);
      this.a |= 0x40;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.OneofDescriptorProto, DescriptorProtos.OneofDescriptorProto.Builder, DescriptorProtos.OneofDescriptorProtoOrBuilder> z()
  {
    if (this.n == null)
    {
      List localList = this.m;
      boolean bool;
      if ((this.a & 0x40) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.n = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.m = null;
    }
    return this.n;
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
    if (localObject == null)
    {
      this.e = Collections.emptyList();
      this.a &= 0xFFFFFFFB;
    }
    else
    {
      ((RepeatedFieldBuilderV3)localObject).e();
    }
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
    localObject = this.j;
    if (localObject == null)
    {
      this.i = Collections.emptyList();
      this.a &= 0xFFFFFFEF;
    }
    else
    {
      ((RepeatedFieldBuilderV3)localObject).e();
    }
    localObject = this.l;
    if (localObject == null)
    {
      this.k = Collections.emptyList();
      this.a &= 0xFFFFFFDF;
    }
    else
    {
      ((RepeatedFieldBuilderV3)localObject).e();
    }
    localObject = this.n;
    if (localObject == null)
    {
      this.m = Collections.emptyList();
      this.a &= 0xFFFFFFBF;
    }
    else
    {
      ((RepeatedFieldBuilderV3)localObject).e();
    }
    localObject = this.p;
    if (localObject == null) {
      this.o = null;
    } else {
      ((SingleFieldBuilderV3)localObject).g();
    }
    this.a &= 0xFFFFFF7F;
    localObject = this.r;
    if (localObject == null)
    {
      this.q = Collections.emptyList();
      this.a &= 0xFFFFFEFF;
    }
    else
    {
      ((RepeatedFieldBuilderV3)localObject).e();
    }
    this.s = LazyStringArrayList.a;
    this.a &= 0xFFFFFDFF;
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 200	com/google/protobuf/DescriptorProtos$DescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 206 3 0
    //   12: checkcast 196	com/google/protobuf/DescriptorProtos$DescriptorProto
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 209	com/google/protobuf/DescriptorProtos$DescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$DescriptorProto;)Lcom/google/protobuf/DescriptorProtos$DescriptorProto$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 213	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 196	com/google/protobuf/DescriptorProtos$DescriptorProto
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 217	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 209	com/google/protobuf/DescriptorProtos$DescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$DescriptorProto;)Lcom/google/protobuf/DescriptorProtos$DescriptorProto$Builder;
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
  
  public Builder a(DescriptorProtos.DescriptorProto.ExtensionRange paramExtensionRange)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.l;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if (paramExtensionRange != null)
      {
        w();
        this.k.add(paramExtensionRange);
        onChanged();
        return this;
      }
      throw new NullPointerException();
    }
    localRepeatedFieldBuilderV3.a(paramExtensionRange);
    return this;
  }
  
  public Builder a(DescriptorProtos.DescriptorProto paramDescriptorProto)
  {
    if (paramDescriptorProto == DescriptorProtos.DescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (paramDescriptorProto.hasName())
    {
      this.a |= 0x1;
      this.b = DescriptorProtos.DescriptorProto.access$5000(paramDescriptorProto);
      onChanged();
    }
    Object localObject1 = this.d;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      if (!DescriptorProtos.DescriptorProto.access$5100(paramDescriptorProto).isEmpty())
      {
        if (this.c.isEmpty())
        {
          this.c = DescriptorProtos.DescriptorProto.access$5100(paramDescriptorProto);
          this.a &= 0xFFFFFFFD;
        }
        else
        {
          o();
          this.c.addAll(DescriptorProtos.DescriptorProto.access$5100(paramDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.DescriptorProto.access$5100(paramDescriptorProto).isEmpty()) {
      if (this.d.d())
      {
        this.d.b();
        this.d = null;
        this.c = DescriptorProtos.DescriptorProto.access$5100(paramDescriptorProto);
        this.a &= 0xFFFFFFFD;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = p();
        } else {
          localObject1 = null;
        }
        this.d = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.d.a(DescriptorProtos.DescriptorProto.access$5100(paramDescriptorProto));
      }
    }
    if (this.f == null)
    {
      if (!DescriptorProtos.DescriptorProto.access$5200(paramDescriptorProto).isEmpty())
      {
        if (this.e.isEmpty())
        {
          this.e = DescriptorProtos.DescriptorProto.access$5200(paramDescriptorProto);
          this.a &= 0xFFFFFFFB;
        }
        else
        {
          q();
          this.e.addAll(DescriptorProtos.DescriptorProto.access$5200(paramDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.DescriptorProto.access$5200(paramDescriptorProto).isEmpty()) {
      if (this.f.d())
      {
        this.f.b();
        this.f = null;
        this.e = DescriptorProtos.DescriptorProto.access$5200(paramDescriptorProto);
        this.a &= 0xFFFFFFFB;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = r();
        } else {
          localObject1 = null;
        }
        this.f = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.f.a(DescriptorProtos.DescriptorProto.access$5200(paramDescriptorProto));
      }
    }
    if (this.h == null)
    {
      if (!DescriptorProtos.DescriptorProto.access$5300(paramDescriptorProto).isEmpty())
      {
        if (this.g.isEmpty())
        {
          this.g = DescriptorProtos.DescriptorProto.access$5300(paramDescriptorProto);
          this.a &= 0xFFFFFFF7;
        }
        else
        {
          s();
          this.g.addAll(DescriptorProtos.DescriptorProto.access$5300(paramDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.DescriptorProto.access$5300(paramDescriptorProto).isEmpty()) {
      if (this.h.d())
      {
        this.h.b();
        this.h = null;
        this.g = DescriptorProtos.DescriptorProto.access$5300(paramDescriptorProto);
        this.a &= 0xFFFFFFF7;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = t();
        } else {
          localObject1 = null;
        }
        this.h = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.h.a(DescriptorProtos.DescriptorProto.access$5300(paramDescriptorProto));
      }
    }
    if (this.j == null)
    {
      if (!DescriptorProtos.DescriptorProto.access$5400(paramDescriptorProto).isEmpty())
      {
        if (this.i.isEmpty())
        {
          this.i = DescriptorProtos.DescriptorProto.access$5400(paramDescriptorProto);
          this.a &= 0xFFFFFFEF;
        }
        else
        {
          u();
          this.i.addAll(DescriptorProtos.DescriptorProto.access$5400(paramDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.DescriptorProto.access$5400(paramDescriptorProto).isEmpty()) {
      if (this.j.d())
      {
        this.j.b();
        this.j = null;
        this.i = DescriptorProtos.DescriptorProto.access$5400(paramDescriptorProto);
        this.a &= 0xFFFFFFEF;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = v();
        } else {
          localObject1 = null;
        }
        this.j = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.j.a(DescriptorProtos.DescriptorProto.access$5400(paramDescriptorProto));
      }
    }
    if (this.l == null)
    {
      if (!DescriptorProtos.DescriptorProto.access$5500(paramDescriptorProto).isEmpty())
      {
        if (this.k.isEmpty())
        {
          this.k = DescriptorProtos.DescriptorProto.access$5500(paramDescriptorProto);
          this.a &= 0xFFFFFFDF;
        }
        else
        {
          w();
          this.k.addAll(DescriptorProtos.DescriptorProto.access$5500(paramDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.DescriptorProto.access$5500(paramDescriptorProto).isEmpty()) {
      if (this.l.d())
      {
        this.l.b();
        this.l = null;
        this.k = DescriptorProtos.DescriptorProto.access$5500(paramDescriptorProto);
        this.a &= 0xFFFFFFDF;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = x();
        } else {
          localObject1 = null;
        }
        this.l = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.l.a(DescriptorProtos.DescriptorProto.access$5500(paramDescriptorProto));
      }
    }
    if (this.n == null)
    {
      if (!DescriptorProtos.DescriptorProto.access$5600(paramDescriptorProto).isEmpty())
      {
        if (this.m.isEmpty())
        {
          this.m = DescriptorProtos.DescriptorProto.access$5600(paramDescriptorProto);
          this.a &= 0xFFFFFFBF;
        }
        else
        {
          y();
          this.m.addAll(DescriptorProtos.DescriptorProto.access$5600(paramDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.DescriptorProto.access$5600(paramDescriptorProto).isEmpty()) {
      if (this.n.d())
      {
        this.n.b();
        this.n = null;
        this.m = DescriptorProtos.DescriptorProto.access$5600(paramDescriptorProto);
        this.a &= 0xFFFFFFBF;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = z();
        } else {
          localObject1 = null;
        }
        this.n = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.n.a(DescriptorProtos.DescriptorProto.access$5600(paramDescriptorProto));
      }
    }
    if (paramDescriptorProto.hasOptions()) {
      a(paramDescriptorProto.getOptions());
    }
    if (this.r == null)
    {
      if (!DescriptorProtos.DescriptorProto.access$5800(paramDescriptorProto).isEmpty())
      {
        if (this.q.isEmpty())
        {
          this.q = DescriptorProtos.DescriptorProto.access$5800(paramDescriptorProto);
          this.a &= 0xFFFFFEFF;
        }
        else
        {
          B();
          this.q.addAll(DescriptorProtos.DescriptorProto.access$5800(paramDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.DescriptorProto.access$5800(paramDescriptorProto).isEmpty()) {
      if (this.r.d())
      {
        this.r.b();
        this.r = null;
        this.q = DescriptorProtos.DescriptorProto.access$5800(paramDescriptorProto);
        this.a &= 0xFFFFFEFF;
        localObject1 = localObject2;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = C();
        }
        this.r = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.r.a(DescriptorProtos.DescriptorProto.access$5800(paramDescriptorProto));
      }
    }
    if (!DescriptorProtos.DescriptorProto.access$5900(paramDescriptorProto).isEmpty())
    {
      if (this.s.isEmpty())
      {
        this.s = DescriptorProtos.DescriptorProto.access$5900(paramDescriptorProto);
        this.a &= 0xFFFFFDFF;
      }
      else
      {
        D();
        this.s.addAll(DescriptorProtos.DescriptorProto.access$5900(paramDescriptorProto));
      }
      onChanged();
    }
    b(paramDescriptorProto.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(DescriptorProtos.MessageOptions paramMessageOptions)
  {
    Object localObject = this.p;
    if (localObject == null)
    {
      if ((this.a & 0x80) != 0)
      {
        localObject = this.o;
        if ((localObject != null) && (localObject != DescriptorProtos.MessageOptions.getDefaultInstance()))
        {
          this.o = DescriptorProtos.MessageOptions.newBuilder(this.o).a(paramMessageOptions).d();
          break label62;
        }
      }
      this.o = paramMessageOptions;
      label62:
      onChanged();
    }
    else
    {
      ((SingleFieldBuilderV3)localObject).b(paramMessageOptions);
    }
    this.a |= 0x80;
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
    if ((paramMessage instanceof DescriptorProtos.DescriptorProto)) {
      return a((DescriptorProtos.DescriptorProto)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder a(String paramString)
  {
    if (paramString != null)
    {
      this.a |= 0x1;
      this.b = paramString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public DescriptorProtos.FieldDescriptorProto a(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.d;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.FieldDescriptorProto)this.c.get(paramInt);
    }
    return (DescriptorProtos.FieldDescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public Builder b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (Builder)super.addRepeatedField(paramFieldDescriptor, paramObject);
  }
  
  public final Builder b(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.mergeUnknownFields(paramUnknownFieldSet);
  }
  
  public DescriptorProtos.DescriptorProto b()
  {
    return DescriptorProtos.DescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.FieldDescriptorProto b(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.f;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.FieldDescriptorProto)this.e.get(paramInt);
    }
    return (DescriptorProtos.FieldDescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public DescriptorProtos.DescriptorProto c()
  {
    DescriptorProtos.DescriptorProto localDescriptorProto = d();
    if (localDescriptorProto.isInitialized()) {
      return localDescriptorProto;
    }
    throw newUninitializedMessageException(localDescriptorProto);
  }
  
  public DescriptorProtos.DescriptorProto c(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.h;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.DescriptorProto)this.g.get(paramInt);
    }
    return (DescriptorProtos.DescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public DescriptorProtos.DescriptorProto d()
  {
    DescriptorProtos.DescriptorProto localDescriptorProto = new DescriptorProtos.DescriptorProto(this, null);
    int i3 = this.a;
    int i1;
    if ((i3 & 0x1) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    DescriptorProtos.DescriptorProto.access$5002(localDescriptorProto, this.b);
    Object localObject = this.d;
    if (localObject == null)
    {
      if ((this.a & 0x2) != 0)
      {
        this.c = Collections.unmodifiableList(this.c);
        this.a &= 0xFFFFFFFD;
      }
      DescriptorProtos.DescriptorProto.access$5102(localDescriptorProto, this.c);
    }
    else
    {
      DescriptorProtos.DescriptorProto.access$5102(localDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    localObject = this.f;
    if (localObject == null)
    {
      if ((this.a & 0x4) != 0)
      {
        this.e = Collections.unmodifiableList(this.e);
        this.a &= 0xFFFFFFFB;
      }
      DescriptorProtos.DescriptorProto.access$5202(localDescriptorProto, this.e);
    }
    else
    {
      DescriptorProtos.DescriptorProto.access$5202(localDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    localObject = this.h;
    if (localObject == null)
    {
      if ((this.a & 0x8) != 0)
      {
        this.g = Collections.unmodifiableList(this.g);
        this.a &= 0xFFFFFFF7;
      }
      DescriptorProtos.DescriptorProto.access$5302(localDescriptorProto, this.g);
    }
    else
    {
      DescriptorProtos.DescriptorProto.access$5302(localDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    localObject = this.j;
    if (localObject == null)
    {
      if ((this.a & 0x10) != 0)
      {
        this.i = Collections.unmodifiableList(this.i);
        this.a &= 0xFFFFFFEF;
      }
      DescriptorProtos.DescriptorProto.access$5402(localDescriptorProto, this.i);
    }
    else
    {
      DescriptorProtos.DescriptorProto.access$5402(localDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    localObject = this.l;
    if (localObject == null)
    {
      if ((this.a & 0x20) != 0)
      {
        this.k = Collections.unmodifiableList(this.k);
        this.a &= 0xFFFFFFDF;
      }
      DescriptorProtos.DescriptorProto.access$5502(localDescriptorProto, this.k);
    }
    else
    {
      DescriptorProtos.DescriptorProto.access$5502(localDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    localObject = this.n;
    if (localObject == null)
    {
      if ((this.a & 0x40) != 0)
      {
        this.m = Collections.unmodifiableList(this.m);
        this.a &= 0xFFFFFFBF;
      }
      DescriptorProtos.DescriptorProto.access$5602(localDescriptorProto, this.m);
    }
    else
    {
      DescriptorProtos.DescriptorProto.access$5602(localDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    int i2 = i1;
    if ((i3 & 0x80) != 0)
    {
      localObject = this.p;
      if (localObject == null) {
        DescriptorProtos.DescriptorProto.access$5702(localDescriptorProto, this.o);
      } else {
        DescriptorProtos.DescriptorProto.access$5702(localDescriptorProto, (DescriptorProtos.MessageOptions)((SingleFieldBuilderV3)localObject).d());
      }
      i2 = i1 | 0x2;
    }
    localObject = this.r;
    if (localObject == null)
    {
      if ((this.a & 0x100) != 0)
      {
        this.q = Collections.unmodifiableList(this.q);
        this.a &= 0xFFFFFEFF;
      }
      DescriptorProtos.DescriptorProto.access$5802(localDescriptorProto, this.q);
    }
    else
    {
      DescriptorProtos.DescriptorProto.access$5802(localDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    if ((this.a & 0x200) != 0)
    {
      this.s = this.s.e();
      this.a &= 0xFFFFFDFF;
    }
    DescriptorProtos.DescriptorProto.access$5902(localDescriptorProto, this.s);
    DescriptorProtos.DescriptorProto.access$6002(localDescriptorProto, i2);
    onBuilt();
    return localDescriptorProto;
  }
  
  public DescriptorProtos.EnumDescriptorProto d(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.j;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.EnumDescriptorProto)this.i.get(paramInt);
    }
    return (DescriptorProtos.EnumDescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public DescriptorProtos.DescriptorProto.ExtensionRange e(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.l;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.DescriptorProto.ExtensionRange)this.k.get(paramInt);
    }
    return (DescriptorProtos.DescriptorProto.ExtensionRange)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public int f()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.d;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.c.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public DescriptorProtos.OneofDescriptorProto f(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.n;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.OneofDescriptorProto)this.m.get(paramInt);
    }
    return (DescriptorProtos.OneofDescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public int g()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.f;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.e.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.f();
  }
  
  public int h()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.h;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.g.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public int i()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.j;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.i.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.g().a(DescriptorProtos.DescriptorProto.class, Builder.class);
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
    i1 = 0;
    while (i1 < g())
    {
      if (!b(i1).isInitialized()) {
        return false;
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < h())
    {
      if (!c(i1).isInitialized()) {
        return false;
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < i())
    {
      if (!d(i1).isInitialized()) {
        return false;
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < j())
    {
      if (!e(i1).isInitialized()) {
        return false;
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < k())
    {
      if (!f(i1).isInitialized()) {
        return false;
      }
      i1 += 1;
    }
    return (!l()) || (m().isInitialized());
  }
  
  public int j()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.l;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.k.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public int k()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.n;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.m.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public boolean l()
  {
    return (this.a & 0x80) != 0;
  }
  
  public DescriptorProtos.MessageOptions m()
  {
    Object localObject = this.p;
    if (localObject == null)
    {
      DescriptorProtos.MessageOptions localMessageOptions = this.o;
      localObject = localMessageOptions;
      if (localMessageOptions == null) {
        localObject = DescriptorProtos.MessageOptions.getDefaultInstance();
      }
      return localObject;
    }
    return (DescriptorProtos.MessageOptions)((SingleFieldBuilderV3)localObject).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.DescriptorProto.Builder
 * JD-Core Version:    0.7.0.1
 */