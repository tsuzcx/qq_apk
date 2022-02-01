package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Api$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements ApiOrBuilder
{
  private int a;
  private Object b = "";
  private List<Method> c = Collections.emptyList();
  private RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> d;
  private List<Option> e = Collections.emptyList();
  private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> f;
  private Object g = "";
  private SourceContext h;
  private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> i;
  private List<Mixin> j = Collections.emptyList();
  private RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> k;
  private int l = 0;
  
  private Api$Builder()
  {
    f();
  }
  
  private Api$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
      l();
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
  
  private RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> h()
  {
    if (this.d == null)
    {
      List localList = this.c;
      int m = this.a;
      boolean bool = true;
      if ((m & 0x1) == 0) {
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
  
  private void k()
  {
    if ((this.a & 0x4) == 0)
    {
      this.j = new ArrayList(this.j);
      this.a |= 0x4;
    }
  }
  
  private RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> l()
  {
    if (this.k == null)
    {
      List localList = this.j;
      boolean bool;
      if ((this.a & 0x4) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.k = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.j = null;
    }
    return this.k;
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
    this.g = "";
    if (this.i == null)
    {
      this.h = null;
    }
    else
    {
      this.h = null;
      this.i = null;
    }
    localRepeatedFieldBuilderV3 = this.k;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.j = Collections.emptyList();
      this.a &= 0xFFFFFFFB;
    }
    else
    {
      localRepeatedFieldBuilderV3.e();
    }
    this.l = 0;
    return this;
  }
  
  public Builder a(int paramInt)
  {
    this.l = paramInt;
    onChanged();
    return this;
  }
  
  public Builder a(Api paramApi)
  {
    if (paramApi == Api.getDefaultInstance()) {
      return this;
    }
    if (!paramApi.getName().isEmpty())
    {
      this.b = Api.access$300(paramApi);
      onChanged();
    }
    Object localObject1 = this.d;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      if (!Api.access$400(paramApi).isEmpty())
      {
        if (this.c.isEmpty())
        {
          this.c = Api.access$400(paramApi);
          this.a &= 0xFFFFFFFE;
        }
        else
        {
          g();
          this.c.addAll(Api.access$400(paramApi));
        }
        onChanged();
      }
    }
    else if (!Api.access$400(paramApi).isEmpty()) {
      if (this.d.d())
      {
        this.d.b();
        this.d = null;
        this.c = Api.access$400(paramApi);
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
        this.d.a(Api.access$400(paramApi));
      }
    }
    if (this.f == null)
    {
      if (!Api.access$500(paramApi).isEmpty())
      {
        if (this.e.isEmpty())
        {
          this.e = Api.access$500(paramApi);
          this.a &= 0xFFFFFFFD;
        }
        else
        {
          i();
          this.e.addAll(Api.access$500(paramApi));
        }
        onChanged();
      }
    }
    else if (!Api.access$500(paramApi).isEmpty()) {
      if (this.f.d())
      {
        this.f.b();
        this.f = null;
        this.e = Api.access$500(paramApi);
        this.a &= 0xFFFFFFFD;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = j();
        } else {
          localObject1 = null;
        }
        this.f = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.f.a(Api.access$500(paramApi));
      }
    }
    if (!paramApi.getVersion().isEmpty())
    {
      this.g = Api.access$600(paramApi);
      onChanged();
    }
    if (paramApi.hasSourceContext()) {
      a(paramApi.getSourceContext());
    }
    if (this.k == null)
    {
      if (!Api.access$800(paramApi).isEmpty())
      {
        if (this.j.isEmpty())
        {
          this.j = Api.access$800(paramApi);
          this.a &= 0xFFFFFFFB;
        }
        else
        {
          k();
          this.j.addAll(Api.access$800(paramApi));
        }
        onChanged();
      }
    }
    else if (!Api.access$800(paramApi).isEmpty()) {
      if (this.k.d())
      {
        this.k.b();
        this.k = null;
        this.j = Api.access$800(paramApi);
        this.a &= 0xFFFFFFFB;
        localObject1 = localObject2;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localObject1 = l();
        }
        this.k = ((RepeatedFieldBuilderV3)localObject1);
      }
      else
      {
        this.k.a(Api.access$800(paramApi));
      }
    }
    if (Api.access$900(paramApi) != 0) {
      a(paramApi.getSyntaxValue());
    }
    b(paramApi.unknownFields);
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 214	com/google/protobuf/Api:access$1000	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 220 3 0
    //   12: checkcast 127	com/google/protobuf/Api
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 222	com/google/protobuf/Api$Builder:a	(Lcom/google/protobuf/Api;)Lcom/google/protobuf/Api$Builder;
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
    //   39: checkcast 127	com/google/protobuf/Api
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 230	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 222	com/google/protobuf/Api$Builder:a	(Lcom/google/protobuf/Api;)Lcom/google/protobuf/Api$Builder;
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
    if ((paramMessage instanceof Api)) {
      return a((Api)paramMessage);
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
  
  public Api b()
  {
    return Api.getDefaultInstance();
  }
  
  public Api c()
  {
    Api localApi = d();
    if (localApi.isInitialized()) {
      return localApi;
    }
    throw newUninitializedMessageException(localApi);
  }
  
  public Api d()
  {
    Api localApi = new Api(this, null);
    int m = this.a;
    Api.access$302(localApi, this.b);
    Object localObject = this.d;
    if (localObject == null)
    {
      if ((this.a & 0x1) != 0)
      {
        this.c = Collections.unmodifiableList(this.c);
        this.a &= 0xFFFFFFFE;
      }
      Api.access$402(localApi, this.c);
    }
    else
    {
      Api.access$402(localApi, ((RepeatedFieldBuilderV3)localObject).f());
    }
    localObject = this.f;
    if (localObject == null)
    {
      if ((this.a & 0x2) != 0)
      {
        this.e = Collections.unmodifiableList(this.e);
        this.a &= 0xFFFFFFFD;
      }
      Api.access$502(localApi, this.e);
    }
    else
    {
      Api.access$502(localApi, ((RepeatedFieldBuilderV3)localObject).f());
    }
    Api.access$602(localApi, this.g);
    localObject = this.i;
    if (localObject == null) {
      Api.access$702(localApi, this.h);
    } else {
      Api.access$702(localApi, (SourceContext)((SingleFieldBuilderV3)localObject).d());
    }
    localObject = this.k;
    if (localObject == null)
    {
      if ((this.a & 0x4) != 0)
      {
        this.j = Collections.unmodifiableList(this.j);
        this.a &= 0xFFFFFFFB;
      }
      Api.access$802(localApi, this.j);
    }
    else
    {
      Api.access$802(localApi, ((RepeatedFieldBuilderV3)localObject).f());
    }
    Api.access$902(localApi, this.l);
    onBuilt();
    return localApi;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return ApiProto.a;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ApiProto.b.a(Api.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Api.Builder
 * JD-Core Version:    0.7.0.1
 */