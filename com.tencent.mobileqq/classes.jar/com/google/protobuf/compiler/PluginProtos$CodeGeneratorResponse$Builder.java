package com.google.protobuf.compiler;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PluginProtos$CodeGeneratorResponse$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements PluginProtos.CodeGeneratorResponseOrBuilder
{
  private int a;
  private Object b = "";
  private List<PluginProtos.CodeGeneratorResponse.File> c = Collections.emptyList();
  private RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> d;
  
  private PluginProtos$CodeGeneratorResponse$Builder()
  {
    f();
  }
  
  private PluginProtos$CodeGeneratorResponse$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    if (PluginProtos.CodeGeneratorResponse.access$4300()) {
      h();
    }
  }
  
  private void g()
  {
    if ((this.a & 0x2) == 0)
    {
      this.c = new ArrayList(this.c);
      this.a |= 0x2;
    }
  }
  
  private RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> h()
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
  
  public Builder a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.d;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.c = Collections.emptyList();
      this.a &= 0xFFFFFFFD;
      return this;
    }
    localRepeatedFieldBuilderV3.e();
    return this;
  }
  
  /* Error */
  public Builder a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 93	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 99 3 0
    //   12: checkcast 46	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 102	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$Builder:a	(Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;)Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 106	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 46	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 110	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 102	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$Builder:a	(Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;)Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$Builder;
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
    if ((paramMessage instanceof PluginProtos.CodeGeneratorResponse)) {
      return a((PluginProtos.CodeGeneratorResponse)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder a(PluginProtos.CodeGeneratorResponse paramCodeGeneratorResponse)
  {
    if (paramCodeGeneratorResponse == PluginProtos.CodeGeneratorResponse.getDefaultInstance()) {
      return this;
    }
    if (paramCodeGeneratorResponse.hasError())
    {
      this.a |= 0x1;
      this.b = PluginProtos.CodeGeneratorResponse.access$4500(paramCodeGeneratorResponse);
      onChanged();
    }
    if (this.d == null)
    {
      if (!PluginProtos.CodeGeneratorResponse.access$4600(paramCodeGeneratorResponse).isEmpty())
      {
        if (this.c.isEmpty())
        {
          this.c = PluginProtos.CodeGeneratorResponse.access$4600(paramCodeGeneratorResponse);
          this.a &= 0xFFFFFFFD;
        }
        else
        {
          g();
          this.c.addAll(PluginProtos.CodeGeneratorResponse.access$4600(paramCodeGeneratorResponse));
        }
        onChanged();
      }
    }
    else if (!PluginProtos.CodeGeneratorResponse.access$4600(paramCodeGeneratorResponse).isEmpty()) {
      if (this.d.d())
      {
        this.d.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.d = null;
        this.c = PluginProtos.CodeGeneratorResponse.access$4600(paramCodeGeneratorResponse);
        this.a &= 0xFFFFFFFD;
        if (PluginProtos.CodeGeneratorResponse.access$4800()) {
          localRepeatedFieldBuilderV3 = h();
        }
        this.d = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.d.a(PluginProtos.CodeGeneratorResponse.access$4600(paramCodeGeneratorResponse));
      }
    }
    b(PluginProtos.CodeGeneratorResponse.access$4900(paramCodeGeneratorResponse));
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
  
  public PluginProtos.CodeGeneratorResponse b()
  {
    return PluginProtos.CodeGeneratorResponse.getDefaultInstance();
  }
  
  public PluginProtos.CodeGeneratorResponse c()
  {
    PluginProtos.CodeGeneratorResponse localCodeGeneratorResponse = d();
    if (localCodeGeneratorResponse.isInitialized()) {
      return localCodeGeneratorResponse;
    }
    throw newUninitializedMessageException(localCodeGeneratorResponse);
  }
  
  public PluginProtos.CodeGeneratorResponse d()
  {
    PluginProtos.CodeGeneratorResponse localCodeGeneratorResponse = new PluginProtos.CodeGeneratorResponse(this, null);
    int j = this.a;
    int i = 1;
    if ((j & 0x1) == 0) {
      i = 0;
    }
    PluginProtos.CodeGeneratorResponse.access$4502(localCodeGeneratorResponse, this.b);
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.d;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((this.a & 0x2) != 0)
      {
        this.c = Collections.unmodifiableList(this.c);
        this.a &= 0xFFFFFFFD;
      }
      PluginProtos.CodeGeneratorResponse.access$4602(localCodeGeneratorResponse, this.c);
    }
    else
    {
      PluginProtos.CodeGeneratorResponse.access$4602(localCodeGeneratorResponse, localRepeatedFieldBuilderV3.f());
    }
    PluginProtos.CodeGeneratorResponse.access$4702(localCodeGeneratorResponse, i);
    onBuilt();
    return localCodeGeneratorResponse;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return PluginProtos.f();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return PluginProtos.g().a(PluginProtos.CodeGeneratorResponse.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Builder
 * JD-Core Version:    0.7.0.1
 */