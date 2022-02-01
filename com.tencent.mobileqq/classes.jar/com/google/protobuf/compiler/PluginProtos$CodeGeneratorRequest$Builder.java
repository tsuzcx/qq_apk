package com.google.protobuf.compiler;

import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto.Builder;
import com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PluginProtos$CodeGeneratorRequest$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements PluginProtos.CodeGeneratorRequestOrBuilder
{
  private int a;
  private LazyStringList b = LazyStringArrayList.a;
  private Object c = "";
  private List<DescriptorProtos.FileDescriptorProto> d = Collections.emptyList();
  private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> e;
  private PluginProtos.Version f;
  private SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> g;
  
  private PluginProtos$CodeGeneratorRequest$Builder()
  {
    h();
  }
  
  private PluginProtos$CodeGeneratorRequest$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    h();
  }
  
  private void h()
  {
    if (PluginProtos.CodeGeneratorRequest.access$1700())
    {
      k();
      l();
    }
  }
  
  private void i()
  {
    if ((this.a & 0x1) == 0)
    {
      this.b = new LazyStringArrayList(this.b);
      this.a |= 0x1;
    }
  }
  
  private void j()
  {
    if ((this.a & 0x4) == 0)
    {
      this.d = new ArrayList(this.d);
      this.a |= 0x4;
    }
  }
  
  private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> k()
  {
    if (this.e == null)
    {
      List localList = this.d;
      boolean bool;
      if ((this.a & 0x4) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.e = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.d = null;
    }
    return this.e;
  }
  
  private SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> l()
  {
    if (this.g == null)
    {
      this.g = new SingleFieldBuilderV3(g(), getParentForChildren(), isClean());
      this.f = null;
    }
    return this.g;
  }
  
  public DescriptorProtos.FileDescriptorProto a(int paramInt)
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.e;
    if (localRepeatedFieldBuilderV3 == null) {
      return (DescriptorProtos.FileDescriptorProto)this.d.get(paramInt);
    }
    return (DescriptorProtos.FileDescriptorProto)localRepeatedFieldBuilderV3.a(paramInt);
  }
  
  public Builder a()
  {
    super.clear();
    this.b = LazyStringArrayList.a;
    this.a &= 0xFFFFFFFE;
    this.c = "";
    this.a &= 0xFFFFFFFD;
    Object localObject = this.e;
    if (localObject == null)
    {
      this.d = Collections.emptyList();
      this.a &= 0xFFFFFFFB;
    }
    else
    {
      ((RepeatedFieldBuilderV3)localObject).e();
    }
    localObject = this.g;
    if (localObject == null) {
      this.f = null;
    } else {
      ((SingleFieldBuilderV3)localObject).g();
    }
    this.a &= 0xFFFFFFF7;
    return this;
  }
  
  /* Error */
  public Builder a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 140	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 146 3 0
    //   12: checkcast 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 149	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest$Builder:a	(Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;)Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 153	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 59	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 157	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 149	com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest$Builder:a	(Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;)Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest$Builder;
    //   58: pop
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	Builder
    //   0	61	1	paramCodedInputStream	com.google.protobuf.CodedInputStream
    //   0	61	2	paramExtensionRegistryLite	com.google.protobuf.ExtensionRegistryLite
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
    if ((paramMessage instanceof PluginProtos.CodeGeneratorRequest)) {
      return a((PluginProtos.CodeGeneratorRequest)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder a(PluginProtos.CodeGeneratorRequest paramCodeGeneratorRequest)
  {
    if (paramCodeGeneratorRequest == PluginProtos.CodeGeneratorRequest.getDefaultInstance()) {
      return this;
    }
    if (!PluginProtos.CodeGeneratorRequest.access$1900(paramCodeGeneratorRequest).isEmpty())
    {
      if (this.b.isEmpty())
      {
        this.b = PluginProtos.CodeGeneratorRequest.access$1900(paramCodeGeneratorRequest);
        this.a &= 0xFFFFFFFE;
      }
      else
      {
        i();
        this.b.addAll(PluginProtos.CodeGeneratorRequest.access$1900(paramCodeGeneratorRequest));
      }
      onChanged();
    }
    if (paramCodeGeneratorRequest.hasParameter())
    {
      this.a |= 0x2;
      this.c = PluginProtos.CodeGeneratorRequest.access$2000(paramCodeGeneratorRequest);
      onChanged();
    }
    if (this.e == null)
    {
      if (!PluginProtos.CodeGeneratorRequest.access$2100(paramCodeGeneratorRequest).isEmpty())
      {
        if (this.d.isEmpty())
        {
          this.d = PluginProtos.CodeGeneratorRequest.access$2100(paramCodeGeneratorRequest);
          this.a &= 0xFFFFFFFB;
        }
        else
        {
          j();
          this.d.addAll(PluginProtos.CodeGeneratorRequest.access$2100(paramCodeGeneratorRequest));
        }
        onChanged();
      }
    }
    else if (!PluginProtos.CodeGeneratorRequest.access$2100(paramCodeGeneratorRequest).isEmpty()) {
      if (this.e.d())
      {
        this.e.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.e = null;
        this.d = PluginProtos.CodeGeneratorRequest.access$2100(paramCodeGeneratorRequest);
        this.a &= 0xFFFFFFFB;
        if (PluginProtos.CodeGeneratorRequest.access$2400()) {
          localRepeatedFieldBuilderV3 = k();
        }
        this.e = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.e.a(PluginProtos.CodeGeneratorRequest.access$2100(paramCodeGeneratorRequest));
      }
    }
    if (paramCodeGeneratorRequest.hasCompilerVersion()) {
      a(paramCodeGeneratorRequest.getCompilerVersion());
    }
    b(PluginProtos.CodeGeneratorRequest.access$2500(paramCodeGeneratorRequest));
    onChanged();
    return this;
  }
  
  public Builder a(PluginProtos.Version paramVersion)
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      if ((this.a & 0x8) != 0)
      {
        localObject = this.f;
        if ((localObject != null) && (localObject != PluginProtos.Version.getDefaultInstance()))
        {
          this.f = PluginProtos.Version.newBuilder(this.f).a(paramVersion).d();
          break label61;
        }
      }
      this.f = paramVersion;
      label61:
      onChanged();
    }
    else
    {
      ((SingleFieldBuilderV3)localObject).b(paramVersion);
    }
    this.a |= 0x8;
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
  
  public PluginProtos.CodeGeneratorRequest b()
  {
    return PluginProtos.CodeGeneratorRequest.getDefaultInstance();
  }
  
  public PluginProtos.CodeGeneratorRequest c()
  {
    PluginProtos.CodeGeneratorRequest localCodeGeneratorRequest = d();
    if (localCodeGeneratorRequest.isInitialized()) {
      return localCodeGeneratorRequest;
    }
    throw newUninitializedMessageException(localCodeGeneratorRequest);
  }
  
  public PluginProtos.CodeGeneratorRequest d()
  {
    PluginProtos.CodeGeneratorRequest localCodeGeneratorRequest = new PluginProtos.CodeGeneratorRequest(this, null);
    int k = this.a;
    if ((k & 0x1) != 0)
    {
      this.b = this.b.e();
      this.a &= 0xFFFFFFFE;
    }
    PluginProtos.CodeGeneratorRequest.access$1902(localCodeGeneratorRequest, this.b);
    int i;
    if ((k & 0x2) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    PluginProtos.CodeGeneratorRequest.access$2002(localCodeGeneratorRequest, this.c);
    Object localObject = this.e;
    if (localObject == null)
    {
      if ((this.a & 0x4) != 0)
      {
        this.d = Collections.unmodifiableList(this.d);
        this.a &= 0xFFFFFFFB;
      }
      PluginProtos.CodeGeneratorRequest.access$2102(localCodeGeneratorRequest, this.d);
    }
    else
    {
      PluginProtos.CodeGeneratorRequest.access$2102(localCodeGeneratorRequest, ((RepeatedFieldBuilderV3)localObject).f());
    }
    int j = i;
    if ((k & 0x8) != 0)
    {
      localObject = this.g;
      if (localObject == null) {
        PluginProtos.CodeGeneratorRequest.access$2202(localCodeGeneratorRequest, this.f);
      } else {
        PluginProtos.CodeGeneratorRequest.access$2202(localCodeGeneratorRequest, (PluginProtos.Version)((SingleFieldBuilderV3)localObject).d());
      }
      j = i | 0x2;
    }
    PluginProtos.CodeGeneratorRequest.access$2302(localCodeGeneratorRequest, j);
    onBuilt();
    return localCodeGeneratorRequest;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public int f()
  {
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.e;
    if (localRepeatedFieldBuilderV3 == null) {
      return this.d.size();
    }
    return localRepeatedFieldBuilderV3.c();
  }
  
  public PluginProtos.Version g()
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      PluginProtos.Version localVersion = this.f;
      localObject = localVersion;
      if (localVersion == null) {
        localObject = PluginProtos.Version.getDefaultInstance();
      }
      return localObject;
    }
    return (PluginProtos.Version)((SingleFieldBuilderV3)localObject).c();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return PluginProtos.d();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return PluginProtos.e().a(PluginProtos.CodeGeneratorRequest.class, Builder.class);
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
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.Builder
 * JD-Core Version:    0.7.0.1
 */