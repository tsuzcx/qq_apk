package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Method$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements MethodOrBuilder
{
  private int a;
  private Object b = "";
  private Object c = "";
  private boolean d;
  private Object e = "";
  private boolean f;
  private List<Option> g = Collections.emptyList();
  private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> h;
  private int i = 0;
  
  private Method$Builder()
  {
    f();
  }
  
  private Method$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
      h();
    }
  }
  
  private void g()
  {
    if ((this.a & 0x1) == 0)
    {
      this.g = new ArrayList(this.g);
      this.a |= 0x1;
    }
  }
  
  private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> h()
  {
    if (this.h == null)
    {
      List localList = this.g;
      int j = this.a;
      boolean bool = true;
      if ((j & 0x1) == 0) {
        bool = false;
      }
      this.h = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.g = null;
    }
    return this.h;
  }
  
  public Builder a()
  {
    super.clear();
    this.b = "";
    this.c = "";
    this.d = false;
    this.e = "";
    this.f = false;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.h;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.g = Collections.emptyList();
      this.a &= 0xFFFFFFFE;
    }
    else
    {
      localRepeatedFieldBuilderV3.e();
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
    //   2: invokestatic 111	com/google/protobuf/Method:access$1000	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 117 3 0
    //   12: checkcast 107	com/google/protobuf/Method
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 120	com/google/protobuf/Method$Builder:a	(Lcom/google/protobuf/Method;)Lcom/google/protobuf/Method$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 124	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 107	com/google/protobuf/Method
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 128	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 120	com/google/protobuf/Method$Builder:a	(Lcom/google/protobuf/Method;)Lcom/google/protobuf/Method$Builder;
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
    if ((paramMessage instanceof Method)) {
      return a((Method)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public Builder a(Method paramMethod)
  {
    if (paramMethod == Method.getDefaultInstance()) {
      return this;
    }
    if (!paramMethod.getName().isEmpty())
    {
      this.b = Method.access$300(paramMethod);
      onChanged();
    }
    if (!paramMethod.getRequestTypeUrl().isEmpty())
    {
      this.c = Method.access$400(paramMethod);
      onChanged();
    }
    if (paramMethod.getRequestStreaming()) {
      a(paramMethod.getRequestStreaming());
    }
    if (!paramMethod.getResponseTypeUrl().isEmpty())
    {
      this.e = Method.access$600(paramMethod);
      onChanged();
    }
    if (paramMethod.getResponseStreaming()) {
      b(paramMethod.getResponseStreaming());
    }
    if (this.h == null)
    {
      if (!Method.access$800(paramMethod).isEmpty())
      {
        if (this.g.isEmpty())
        {
          this.g = Method.access$800(paramMethod);
          this.a &= 0xFFFFFFFE;
        }
        else
        {
          g();
          this.g.addAll(Method.access$800(paramMethod));
        }
        onChanged();
      }
    }
    else if (!Method.access$800(paramMethod).isEmpty()) {
      if (this.h.d())
      {
        this.h.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.h = null;
        this.g = Method.access$800(paramMethod);
        this.a &= 0xFFFFFFFE;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = h();
        }
        this.h = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.h.a(Method.access$800(paramMethod));
      }
    }
    if (Method.access$900(paramMethod) != 0) {
      a(paramMethod.getSyntaxValue());
    }
    b(paramMethod.unknownFields);
    onChanged();
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.d = paramBoolean;
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
  
  public Builder b(boolean paramBoolean)
  {
    this.f = paramBoolean;
    onChanged();
    return this;
  }
  
  public Method b()
  {
    return Method.getDefaultInstance();
  }
  
  public Method c()
  {
    Method localMethod = d();
    if (localMethod.isInitialized()) {
      return localMethod;
    }
    throw newUninitializedMessageException(localMethod);
  }
  
  public Method d()
  {
    Method localMethod = new Method(this, null);
    int j = this.a;
    Method.access$302(localMethod, this.b);
    Method.access$402(localMethod, this.c);
    Method.access$502(localMethod, this.d);
    Method.access$602(localMethod, this.e);
    Method.access$702(localMethod, this.f);
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.h;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((this.a & 0x1) != 0)
      {
        this.g = Collections.unmodifiableList(this.g);
        this.a &= 0xFFFFFFFE;
      }
      Method.access$802(localMethod, this.g);
    }
    else
    {
      Method.access$802(localMethod, localRepeatedFieldBuilderV3.f());
    }
    Method.access$902(localMethod, this.i);
    onBuilt();
    return localMethod;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return ApiProto.c;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return ApiProto.d.a(Method.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Method.Builder
 * JD-Core Version:    0.7.0.1
 */