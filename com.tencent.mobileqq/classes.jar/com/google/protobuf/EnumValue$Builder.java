package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EnumValue$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements EnumValueOrBuilder
{
  private int a;
  private Object b = "";
  private int c;
  private List<Option> d = Collections.emptyList();
  private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> e;
  
  private EnumValue$Builder()
  {
    f();
  }
  
  private EnumValue$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
      this.d = new ArrayList(this.d);
      this.a |= 0x1;
    }
  }
  
  private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> h()
  {
    if (this.e == null)
    {
      List localList = this.d;
      int i = this.a;
      boolean bool = true;
      if ((i & 0x1) == 0) {
        bool = false;
      }
      this.e = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.d = null;
    }
    return this.e;
  }
  
  public Builder a()
  {
    super.clear();
    this.b = "";
    this.c = 0;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.e;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.d = Collections.emptyList();
      this.a &= 0xFFFFFFFE;
      return this;
    }
    localRepeatedFieldBuilderV3.e();
    return this;
  }
  
  public Builder a(int paramInt)
  {
    this.c = paramInt;
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 102	com/google/protobuf/EnumValue:access$600	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 108 3 0
    //   12: checkcast 98	com/google/protobuf/EnumValue
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 111	com/google/protobuf/EnumValue$Builder:a	(Lcom/google/protobuf/EnumValue;)Lcom/google/protobuf/EnumValue$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 115	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 98	com/google/protobuf/EnumValue
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 119	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 111	com/google/protobuf/EnumValue$Builder:a	(Lcom/google/protobuf/EnumValue;)Lcom/google/protobuf/EnumValue$Builder;
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
  
  public Builder a(EnumValue paramEnumValue)
  {
    if (paramEnumValue == EnumValue.getDefaultInstance()) {
      return this;
    }
    if (!paramEnumValue.getName().isEmpty())
    {
      this.b = EnumValue.access$300(paramEnumValue);
      onChanged();
    }
    if (paramEnumValue.getNumber() != 0) {
      a(paramEnumValue.getNumber());
    }
    if (this.e == null)
    {
      if (!EnumValue.access$500(paramEnumValue).isEmpty())
      {
        if (this.d.isEmpty())
        {
          this.d = EnumValue.access$500(paramEnumValue);
          this.a &= 0xFFFFFFFE;
        }
        else
        {
          g();
          this.d.addAll(EnumValue.access$500(paramEnumValue));
        }
        onChanged();
      }
    }
    else if (!EnumValue.access$500(paramEnumValue).isEmpty()) {
      if (this.e.d())
      {
        this.e.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.e = null;
        this.d = EnumValue.access$500(paramEnumValue);
        this.a &= 0xFFFFFFFE;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = h();
        }
        this.e = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.e.a(EnumValue.access$500(paramEnumValue));
      }
    }
    b(paramEnumValue.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(Message paramMessage)
  {
    if ((paramMessage instanceof EnumValue)) {
      return a((EnumValue)paramMessage);
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
  
  public EnumValue b()
  {
    return EnumValue.getDefaultInstance();
  }
  
  public EnumValue c()
  {
    EnumValue localEnumValue = d();
    if (localEnumValue.isInitialized()) {
      return localEnumValue;
    }
    throw newUninitializedMessageException(localEnumValue);
  }
  
  public EnumValue d()
  {
    EnumValue localEnumValue = new EnumValue(this, null);
    int i = this.a;
    EnumValue.access$302(localEnumValue, this.b);
    EnumValue.access$402(localEnumValue, this.c);
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.e;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((this.a & 0x1) != 0)
      {
        this.d = Collections.unmodifiableList(this.d);
        this.a &= 0xFFFFFFFE;
      }
      EnumValue.access$502(localEnumValue, this.d);
    }
    else
    {
      EnumValue.access$502(localEnumValue, localRepeatedFieldBuilderV3.f());
    }
    onBuilt();
    return localEnumValue;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return TypeProto.g;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return TypeProto.h.a(EnumValue.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.EnumValue.Builder
 * JD-Core Version:    0.7.0.1
 */