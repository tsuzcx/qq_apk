package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileDescriptorProto$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements DescriptorProtos.FileDescriptorProtoOrBuilder
{
  private int a;
  private Object b = "";
  private Object c = "";
  private LazyStringList d = LazyStringArrayList.a;
  private Internal.IntList e = GeneratedMessageV3.emptyIntList();
  private Internal.IntList f = GeneratedMessageV3.emptyIntList();
  private List<DescriptorProtos.DescriptorProto> g = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.DescriptorProto, DescriptorProtos.DescriptorProto.Builder, DescriptorProtos.DescriptorProtoOrBuilder> h;
  private List<DescriptorProtos.EnumDescriptorProto> i = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> j;
  private List<DescriptorProtos.ServiceDescriptorProto> k = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.ServiceDescriptorProto, DescriptorProtos.ServiceDescriptorProto.Builder, DescriptorProtos.ServiceDescriptorProtoOrBuilder> l;
  private List<DescriptorProtos.FieldDescriptorProto> m = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> n;
  private DescriptorProtos.FileOptions o;
  private SingleFieldBuilderV3<DescriptorProtos.FileOptions, DescriptorProtos.FileOptions.Builder, DescriptorProtos.FileOptionsOrBuilder> p;
  private DescriptorProtos.SourceCodeInfo q;
  private SingleFieldBuilderV3<DescriptorProtos.SourceCodeInfo, DescriptorProtos.SourceCodeInfo.Builder, DescriptorProtos.SourceCodeInfoOrBuilder> r;
  private Object s = "";
  
  private DescriptorProtos$FileDescriptorProto$Builder()
  {
    m();
  }
  
  private DescriptorProtos$FileDescriptorProto$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    m();
  }
  
  private void m()
  {
    if (GeneratedMessageV3.alwaysUseFieldBuilders)
    {
      r();
      t();
      v();
      x();
      y();
      z();
    }
  }
  
  private void n()
  {
    if ((this.a & 0x4) == 0)
    {
      this.d = new LazyStringArrayList(this.d);
      this.a |= 0x4;
    }
  }
  
  private void o()
  {
    if ((this.a & 0x8) == 0)
    {
      this.e = GeneratedMessageV3.mutableCopy(this.e);
      this.a |= 0x8;
    }
  }
  
  private void p()
  {
    if ((this.a & 0x10) == 0)
    {
      this.f = GeneratedMessageV3.mutableCopy(this.f);
      this.a |= 0x10;
    }
  }
  
  private void q()
  {
    if ((this.a & 0x20) == 0)
    {
      this.g = new ArrayList(this.g);
      this.a |= 0x20;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.DescriptorProto, DescriptorProtos.DescriptorProto.Builder, DescriptorProtos.DescriptorProtoOrBuilder> r()
  {
    if (this.h == null)
    {
      List localList = this.g;
      boolean bool;
      if ((this.a & 0x20) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.h = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.g = null;
    }
    return this.h;
  }
  
  private void s()
  {
    if ((this.a & 0x40) == 0)
    {
      this.i = new ArrayList(this.i);
      this.a |= 0x40;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> t()
  {
    if (this.j == null)
    {
      List localList = this.i;
      boolean bool;
      if ((this.a & 0x40) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.j = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.i = null;
    }
    return this.j;
  }
  
  private void u()
  {
    if ((this.a & 0x80) == 0)
    {
      this.k = new ArrayList(this.k);
      this.a |= 0x80;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.ServiceDescriptorProto, DescriptorProtos.ServiceDescriptorProto.Builder, DescriptorProtos.ServiceDescriptorProtoOrBuilder> v()
  {
    if (this.l == null)
    {
      List localList = this.k;
      boolean bool;
      if ((this.a & 0x80) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.l = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.k = null;
    }
    return this.l;
  }
  
  private void w()
  {
    if ((this.a & 0x100) == 0)
    {
      this.m = new ArrayList(this.m);
      this.a |= 0x100;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> x()
  {
    if (this.n == null)
    {
      List localList = this.m;
      boolean bool;
      if ((this.a & 0x100) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.n = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.m = null;
    }
    return this.n;
  }
  
  private SingleFieldBuilderV3<DescriptorProtos.FileOptions, DescriptorProtos.FileOptions.Builder, DescriptorProtos.FileOptionsOrBuilder> y()
  {
    if (this.p == null)
    {
      this.p = new SingleFieldBuilderV3(k(), getParentForChildren(), isClean());
      this.o = null;
    }
    return this.p;
  }
  
  private SingleFieldBuilderV3<DescriptorProtos.SourceCodeInfo, DescriptorProtos.SourceCodeInfo.Builder, DescriptorProtos.SourceCodeInfoOrBuilder> z()
  {
    if (this.r == null)
    {
      this.r = new SingleFieldBuilderV3(l(), getParentForChildren(), isClean());
      this.q = null;
    }
    return this.r;
  }
  
  public DescriptorProtos.DescriptorProto a(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.h;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.DescriptorProto)this.g.get(paramInt);
    }
    return (DescriptorProtos.DescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public Builder a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    this.c = "";
    this.a &= 0xFFFFFFFD;
    this.d = LazyStringArrayList.a;
    this.a &= 0xFFFFFFFB;
    this.e = GeneratedMessageV3.emptyIntList();
    this.a &= 0xFFFFFFF7;
    this.f = GeneratedMessageV3.emptyIntList();
    this.a &= 0xFFFFFFEF;
    Object localObject = this.h;
    if (localObject == null)
    {
      this.g = Collections.emptyList();
      this.a &= 0xFFFFFFDF;
    }
    else
    {
      ((RepeatedFieldBuilderV3)localObject).e();
    }
    localObject = this.j;
    if (localObject == null)
    {
      this.i = Collections.emptyList();
      this.a &= 0xFFFFFFBF;
    }
    else
    {
      ((RepeatedFieldBuilderV3)localObject).e();
    }
    localObject = this.l;
    if (localObject == null)
    {
      this.k = Collections.emptyList();
      this.a &= 0xFFFFFF7F;
    }
    else
    {
      ((RepeatedFieldBuilderV3)localObject).e();
    }
    localObject = this.n;
    if (localObject == null)
    {
      this.m = Collections.emptyList();
      this.a &= 0xFFFFFEFF;
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
    this.a &= 0xFFFFFDFF;
    localObject = this.r;
    if (localObject == null) {
      this.q = null;
    } else {
      ((SingleFieldBuilderV3)localObject).g();
    }
    this.a &= 0xFFFFFBFF;
    this.s = "";
    this.a &= 0xFFFFF7FF;
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 213	com/google/protobuf/DescriptorProtos$FileDescriptorProto:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 219 3 0
    //   12: checkcast 209	com/google/protobuf/DescriptorProtos$FileDescriptorProto
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 222	com/google/protobuf/DescriptorProtos$FileDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 226	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 209	com/google/protobuf/DescriptorProtos$FileDescriptorProto
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 230	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 222	com/google/protobuf/DescriptorProtos$FileDescriptorProto$Builder:a	(Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto;)Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto$Builder;
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
  
  public Builder a(DescriptorProtos.DescriptorProto paramDescriptorProto)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.h;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if (paramDescriptorProto != null)
      {
        q();
        this.g.add(paramDescriptorProto);
        onChanged();
        return this;
      }
      throw new NullPointerException();
    }
    localRepeatedFieldBuilderV3.a(paramDescriptorProto);
    return this;
  }
  
  public Builder a(DescriptorProtos.FileDescriptorProto paramFileDescriptorProto)
  {
    if (paramFileDescriptorProto == DescriptorProtos.FileDescriptorProto.getDefaultInstance()) {
      return this;
    }
    if (paramFileDescriptorProto.hasName())
    {
      this.a |= 0x1;
      this.b = DescriptorProtos.FileDescriptorProto.access$1200(paramFileDescriptorProto);
      onChanged();
    }
    if (paramFileDescriptorProto.hasPackage())
    {
      this.a |= 0x2;
      this.c = DescriptorProtos.FileDescriptorProto.access$1300(paramFileDescriptorProto);
      onChanged();
    }
    if (!DescriptorProtos.FileDescriptorProto.access$1400(paramFileDescriptorProto).isEmpty())
    {
      if (this.d.isEmpty())
      {
        this.d = DescriptorProtos.FileDescriptorProto.access$1400(paramFileDescriptorProto);
        this.a &= 0xFFFFFFFB;
      }
      else
      {
        n();
        this.d.addAll(DescriptorProtos.FileDescriptorProto.access$1400(paramFileDescriptorProto));
      }
      onChanged();
    }
    if (!DescriptorProtos.FileDescriptorProto.access$1500(paramFileDescriptorProto).isEmpty())
    {
      if (this.e.isEmpty())
      {
        this.e = DescriptorProtos.FileDescriptorProto.access$1500(paramFileDescriptorProto);
        this.a &= 0xFFFFFFF7;
      }
      else
      {
        o();
        this.e.addAll(DescriptorProtos.FileDescriptorProto.access$1500(paramFileDescriptorProto));
      }
      onChanged();
    }
    if (!DescriptorProtos.FileDescriptorProto.access$1600(paramFileDescriptorProto).isEmpty())
    {
      if (this.f.isEmpty())
      {
        this.f = DescriptorProtos.FileDescriptorProto.access$1600(paramFileDescriptorProto);
        this.a &= 0xFFFFFFEF;
      }
      else
      {
        p();
        this.f.addAll(DescriptorProtos.FileDescriptorProto.access$1600(paramFileDescriptorProto));
      }
      onChanged();
    }
    Object localObject1 = this.h;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      if (!DescriptorProtos.FileDescriptorProto.access$1700(paramFileDescriptorProto).isEmpty())
      {
        if (this.g.isEmpty())
        {
          this.g = DescriptorProtos.FileDescriptorProto.access$1700(paramFileDescriptorProto);
          this.a &= 0xFFFFFFDF;
        }
        else
        {
          q();
          this.g.addAll(DescriptorProtos.FileDescriptorProto.access$1700(paramFileDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FileDescriptorProto.access$1700(paramFileDescriptorProto).isEmpty()) {
      if (this.h.d())
      {
        this.h.b();
        this.h = null;
        this.g = DescriptorProtos.FileDescriptorProto.access$1700(paramFileDescriptorProto);
        this.a &= 0xFFFFFFDF;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = r();
        } else {
          localObject1 = null;
        }
        this.h = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.h.a(DescriptorProtos.FileDescriptorProto.access$1700(paramFileDescriptorProto));
      }
    }
    if (this.j == null)
    {
      if (!DescriptorProtos.FileDescriptorProto.access$1800(paramFileDescriptorProto).isEmpty())
      {
        if (this.i.isEmpty())
        {
          this.i = DescriptorProtos.FileDescriptorProto.access$1800(paramFileDescriptorProto);
          this.a &= 0xFFFFFFBF;
        }
        else
        {
          s();
          this.i.addAll(DescriptorProtos.FileDescriptorProto.access$1800(paramFileDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FileDescriptorProto.access$1800(paramFileDescriptorProto).isEmpty()) {
      if (this.j.d())
      {
        this.j.b();
        this.j = null;
        this.i = DescriptorProtos.FileDescriptorProto.access$1800(paramFileDescriptorProto);
        this.a &= 0xFFFFFFBF;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = t();
        } else {
          localObject1 = null;
        }
        this.j = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.j.a(DescriptorProtos.FileDescriptorProto.access$1800(paramFileDescriptorProto));
      }
    }
    if (this.l == null)
    {
      if (!DescriptorProtos.FileDescriptorProto.access$1900(paramFileDescriptorProto).isEmpty())
      {
        if (this.k.isEmpty())
        {
          this.k = DescriptorProtos.FileDescriptorProto.access$1900(paramFileDescriptorProto);
          this.a &= 0xFFFFFF7F;
        }
        else
        {
          u();
          this.k.addAll(DescriptorProtos.FileDescriptorProto.access$1900(paramFileDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FileDescriptorProto.access$1900(paramFileDescriptorProto).isEmpty()) {
      if (this.l.d())
      {
        this.l.b();
        this.l = null;
        this.k = DescriptorProtos.FileDescriptorProto.access$1900(paramFileDescriptorProto);
        this.a &= 0xFFFFFF7F;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = v();
        } else {
          localObject1 = null;
        }
        this.l = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.l.a(DescriptorProtos.FileDescriptorProto.access$1900(paramFileDescriptorProto));
      }
    }
    if (this.n == null)
    {
      if (!DescriptorProtos.FileDescriptorProto.access$2000(paramFileDescriptorProto).isEmpty())
      {
        if (this.m.isEmpty())
        {
          this.m = DescriptorProtos.FileDescriptorProto.access$2000(paramFileDescriptorProto);
          this.a &= 0xFFFFFEFF;
        }
        else
        {
          w();
          this.m.addAll(DescriptorProtos.FileDescriptorProto.access$2000(paramFileDescriptorProto));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FileDescriptorProto.access$2000(paramFileDescriptorProto).isEmpty()) {
      if (this.n.d())
      {
        this.n.b();
        this.n = null;
        this.m = DescriptorProtos.FileDescriptorProto.access$2000(paramFileDescriptorProto);
        this.a &= 0xFFFFFEFF;
        localObject1 = localObject2;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = x();
        }
        this.n = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.n.a(DescriptorProtos.FileDescriptorProto.access$2000(paramFileDescriptorProto));
      }
    }
    if (paramFileDescriptorProto.hasOptions()) {
      a(paramFileDescriptorProto.getOptions());
    }
    if (paramFileDescriptorProto.hasSourceCodeInfo()) {
      a(paramFileDescriptorProto.getSourceCodeInfo());
    }
    if (paramFileDescriptorProto.hasSyntax())
    {
      this.a |= 0x800;
      this.s = DescriptorProtos.FileDescriptorProto.access$2300(paramFileDescriptorProto);
      onChanged();
    }
    b(paramFileDescriptorProto.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(DescriptorProtos.FileOptions paramFileOptions)
  {
    Object localObject = this.p;
    if (localObject == null)
    {
      if ((this.a & 0x200) != 0)
      {
        localObject = this.o;
        if ((localObject != null) && (localObject != DescriptorProtos.FileOptions.getDefaultInstance()))
        {
          this.o = DescriptorProtos.FileOptions.newBuilder(this.o).a(paramFileOptions).d();
          break label62;
        }
      }
      this.o = paramFileOptions;
      label62:
      onChanged();
    }
    else
    {
      ((SingleFieldBuilderV3)localObject).b(paramFileOptions);
    }
    this.a |= 0x200;
    return this;
  }
  
  public Builder a(DescriptorProtos.SourceCodeInfo paramSourceCodeInfo)
  {
    Object localObject = this.r;
    if (localObject == null)
    {
      if ((this.a & 0x400) != 0)
      {
        localObject = this.q;
        if ((localObject != null) && (localObject != DescriptorProtos.SourceCodeInfo.getDefaultInstance()))
        {
          this.q = DescriptorProtos.SourceCodeInfo.newBuilder(this.q).a(paramSourceCodeInfo).d();
          break label62;
        }
      }
      this.q = paramSourceCodeInfo;
      label62:
      onChanged();
    }
    else
    {
      ((SingleFieldBuilderV3)localObject).b(paramSourceCodeInfo);
    }
    this.a |= 0x400;
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
    if ((paramMessage instanceof DescriptorProtos.FileDescriptorProto)) {
      return a((DescriptorProtos.FileDescriptorProto)paramMessage);
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
  
  public DescriptorProtos.EnumDescriptorProto b(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.j;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.EnumDescriptorProto)this.i.get(paramInt);
    }
    return (DescriptorProtos.EnumDescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public Builder b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject)
  {
    return (Builder)super.addRepeatedField(paramFieldDescriptor, paramObject);
  }
  
  public final Builder b(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.mergeUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder b(String paramString)
  {
    if (paramString != null)
    {
      this.a |= 0x2;
      this.c = paramString;
      onChanged();
      return this;
    }
    throw new NullPointerException();
  }
  
  public DescriptorProtos.FileDescriptorProto b()
  {
    return DescriptorProtos.FileDescriptorProto.getDefaultInstance();
  }
  
  public DescriptorProtos.FileDescriptorProto c()
  {
    DescriptorProtos.FileDescriptorProto localFileDescriptorProto = d();
    if (localFileDescriptorProto.isInitialized()) {
      return localFileDescriptorProto;
    }
    throw newUninitializedMessageException(localFileDescriptorProto);
  }
  
  public DescriptorProtos.ServiceDescriptorProto c(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.l;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.ServiceDescriptorProto)this.k.get(paramInt);
    }
    return (DescriptorProtos.ServiceDescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public DescriptorProtos.FieldDescriptorProto d(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.n;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.FieldDescriptorProto)this.m.get(paramInt);
    }
    return (DescriptorProtos.FieldDescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public DescriptorProtos.FileDescriptorProto d()
  {
    DescriptorProtos.FileDescriptorProto localFileDescriptorProto = new DescriptorProtos.FileDescriptorProto(this, null);
    int i3 = this.a;
    if ((i3 & 0x1) != 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    DescriptorProtos.FileDescriptorProto.access$1202(localFileDescriptorProto, this.b);
    int i1 = i2;
    if ((i3 & 0x2) != 0) {
      i1 = i2 | 0x2;
    }
    DescriptorProtos.FileDescriptorProto.access$1302(localFileDescriptorProto, this.c);
    if ((this.a & 0x4) != 0)
    {
      this.d = this.d.e();
      this.a &= 0xFFFFFFFB;
    }
    DescriptorProtos.FileDescriptorProto.access$1402(localFileDescriptorProto, this.d);
    if ((this.a & 0x8) != 0)
    {
      this.e.b();
      this.a &= 0xFFFFFFF7;
    }
    DescriptorProtos.FileDescriptorProto.access$1502(localFileDescriptorProto, this.e);
    if ((this.a & 0x10) != 0)
    {
      this.f.b();
      this.a &= 0xFFFFFFEF;
    }
    DescriptorProtos.FileDescriptorProto.access$1602(localFileDescriptorProto, this.f);
    Object localObject = this.h;
    if (localObject == null)
    {
      if ((this.a & 0x20) != 0)
      {
        this.g = Collections.unmodifiableList(this.g);
        this.a &= 0xFFFFFFDF;
      }
      DescriptorProtos.FileDescriptorProto.access$1702(localFileDescriptorProto, this.g);
    }
    else
    {
      DescriptorProtos.FileDescriptorProto.access$1702(localFileDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    localObject = this.j;
    if (localObject == null)
    {
      if ((this.a & 0x40) != 0)
      {
        this.i = Collections.unmodifiableList(this.i);
        this.a &= 0xFFFFFFBF;
      }
      DescriptorProtos.FileDescriptorProto.access$1802(localFileDescriptorProto, this.i);
    }
    else
    {
      DescriptorProtos.FileDescriptorProto.access$1802(localFileDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    localObject = this.l;
    if (localObject == null)
    {
      if ((this.a & 0x80) != 0)
      {
        this.k = Collections.unmodifiableList(this.k);
        this.a &= 0xFFFFFF7F;
      }
      DescriptorProtos.FileDescriptorProto.access$1902(localFileDescriptorProto, this.k);
    }
    else
    {
      DescriptorProtos.FileDescriptorProto.access$1902(localFileDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    localObject = this.n;
    if (localObject == null)
    {
      if ((this.a & 0x100) != 0)
      {
        this.m = Collections.unmodifiableList(this.m);
        this.a &= 0xFFFFFEFF;
      }
      DescriptorProtos.FileDescriptorProto.access$2002(localFileDescriptorProto, this.m);
    }
    else
    {
      DescriptorProtos.FileDescriptorProto.access$2002(localFileDescriptorProto, ((RepeatedFieldBuilderV3)localObject).f());
    }
    int i2 = i1;
    if ((i3 & 0x200) != 0)
    {
      localObject = this.p;
      if (localObject == null) {
        DescriptorProtos.FileDescriptorProto.access$2102(localFileDescriptorProto, this.o);
      } else {
        DescriptorProtos.FileDescriptorProto.access$2102(localFileDescriptorProto, (DescriptorProtos.FileOptions)((SingleFieldBuilderV3)localObject).d());
      }
      i2 = i1 | 0x4;
    }
    i1 = i2;
    if ((i3 & 0x400) != 0)
    {
      localObject = this.r;
      if (localObject == null) {
        DescriptorProtos.FileDescriptorProto.access$2202(localFileDescriptorProto, this.q);
      } else {
        DescriptorProtos.FileDescriptorProto.access$2202(localFileDescriptorProto, (DescriptorProtos.SourceCodeInfo)((SingleFieldBuilderV3)localObject).d());
      }
      i1 = i2 | 0x8;
    }
    i2 = i1;
    if ((i3 & 0x800) != 0) {
      i2 = i1 | 0x10;
    }
    DescriptorProtos.FileDescriptorProto.access$2302(localFileDescriptorProto, this.s);
    DescriptorProtos.FileDescriptorProto.access$2402(localFileDescriptorProto, i2);
    onBuilt();
    return localFileDescriptorProto;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public int f()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.h;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.g.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public int g()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.j;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.i.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.d();
  }
  
  public int h()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.l;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.k.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public int i()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.n;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.m.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.e().a(DescriptorProtos.FileDescriptorProto.class, Builder.class);
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
    return (!j()) || (k().isInitialized());
  }
  
  public boolean j()
  {
    return (this.a & 0x200) != 0;
  }
  
  public DescriptorProtos.FileOptions k()
  {
    Object localObject = this.p;
    if (localObject == null)
    {
      DescriptorProtos.FileOptions localFileOptions = this.o;
      localObject = localFileOptions;
      if (localFileOptions == null) {
        localObject = DescriptorProtos.FileOptions.getDefaultInstance();
      }
      return localObject;
    }
    return (DescriptorProtos.FileOptions)((SingleFieldBuilderV3)localObject).c();
  }
  
  public DescriptorProtos.SourceCodeInfo l()
  {
    Object localObject = this.r;
    if (localObject == null)
    {
      DescriptorProtos.SourceCodeInfo localSourceCodeInfo = this.q;
      localObject = localSourceCodeInfo;
      if (localSourceCodeInfo == null) {
        localObject = DescriptorProtos.SourceCodeInfo.getDefaultInstance();
      }
      return localObject;
    }
    return (DescriptorProtos.SourceCodeInfo)((SingleFieldBuilderV3)localObject).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder
 * JD-Core Version:    0.7.0.1
 */