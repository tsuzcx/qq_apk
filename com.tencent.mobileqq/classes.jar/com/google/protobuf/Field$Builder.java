package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Field$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements FieldOrBuilder
{
  private int a;
  private int b = 0;
  private int c = 0;
  private int d;
  private Object e = "";
  private Object f = "";
  private int g;
  private boolean h;
  private List<Option> i = Collections.emptyList();
  private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> j;
  private Object k = "";
  private Object l = "";
  
  private Field$Builder()
  {
    f();
  }
  
  private Field$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
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
      this.i = new ArrayList(this.i);
      this.a |= 0x1;
    }
  }
  
  private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> h()
  {
    if (this.j == null)
    {
      List localList = this.i;
      int m = this.a;
      boolean bool = true;
      if ((m & 0x1) == 0) {
        bool = false;
      }
      this.j = new RepeatedFieldBuilderV3(localList, bool, getParentForChildren(), isClean());
      this.i = null;
    }
    return this.j;
  }
  
  public Builder a()
  {
    super.clear();
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.e = "";
    this.f = "";
    this.g = 0;
    this.h = false;
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.j;
    if (localRepeatedFieldBuilderV3 == null)
    {
      this.i = Collections.emptyList();
      this.a &= 0xFFFFFFFE;
    }
    else
    {
      localRepeatedFieldBuilderV3.e();
    }
    this.k = "";
    this.l = "";
    return this;
  }
  
  public Builder a(int paramInt)
  {
    this.b = paramInt;
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 120	com/google/protobuf/Field:access$1300	()Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 126 3 0
    //   12: checkcast 116	com/google/protobuf/Field
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 129	com/google/protobuf/Field$Builder:a	(Lcom/google/protobuf/Field;)Lcom/google/protobuf/Field$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 133	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 116	com/google/protobuf/Field
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 137	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 129	com/google/protobuf/Field$Builder:a	(Lcom/google/protobuf/Field;)Lcom/google/protobuf/Field$Builder;
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
  
  public Builder a(Field paramField)
  {
    if (paramField == Field.getDefaultInstance()) {
      return this;
    }
    if (Field.access$300(paramField) != 0) {
      a(paramField.getKindValue());
    }
    if (Field.access$400(paramField) != 0) {
      b(paramField.getCardinalityValue());
    }
    if (paramField.getNumber() != 0) {
      c(paramField.getNumber());
    }
    if (!paramField.getName().isEmpty())
    {
      this.e = Field.access$600(paramField);
      onChanged();
    }
    if (!paramField.getTypeUrl().isEmpty())
    {
      this.f = Field.access$700(paramField);
      onChanged();
    }
    if (paramField.getOneofIndex() != 0) {
      d(paramField.getOneofIndex());
    }
    if (paramField.getPacked()) {
      a(paramField.getPacked());
    }
    if (this.j == null)
    {
      if (!Field.access$1000(paramField).isEmpty())
      {
        if (this.i.isEmpty())
        {
          this.i = Field.access$1000(paramField);
          this.a &= 0xFFFFFFFE;
        }
        else
        {
          g();
          this.i.addAll(Field.access$1000(paramField));
        }
        onChanged();
      }
    }
    else if (!Field.access$1000(paramField).isEmpty()) {
      if (this.j.d())
      {
        this.j.b();
        RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = null;
        this.j = null;
        this.i = Field.access$1000(paramField);
        this.a &= 0xFFFFFFFE;
        if (GeneratedMessageV3.alwaysUseFieldBuilders) {
          localRepeatedFieldBuilderV3 = h();
        }
        this.j = localRepeatedFieldBuilderV3;
      }
      else
      {
        this.j.a(Field.access$1000(paramField));
      }
    }
    if (!paramField.getJsonName().isEmpty())
    {
      this.k = Field.access$1100(paramField);
      onChanged();
    }
    if (!paramField.getDefaultValue().isEmpty())
    {
      this.l = Field.access$1200(paramField);
      onChanged();
    }
    b(paramField.unknownFields);
    onChanged();
    return this;
  }
  
  public Builder a(Message paramMessage)
  {
    if ((paramMessage instanceof Field)) {
      return a((Field)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    onChanged();
    return this;
  }
  
  public Builder b(int paramInt)
  {
    this.c = paramInt;
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
  
  public Field b()
  {
    return Field.getDefaultInstance();
  }
  
  public Builder c(int paramInt)
  {
    this.d = paramInt;
    onChanged();
    return this;
  }
  
  public Field c()
  {
    Field localField = d();
    if (localField.isInitialized()) {
      return localField;
    }
    throw newUninitializedMessageException(localField);
  }
  
  public Builder d(int paramInt)
  {
    this.g = paramInt;
    onChanged();
    return this;
  }
  
  public Field d()
  {
    Field localField = new Field(this, null);
    int m = this.a;
    Field.access$302(localField, this.b);
    Field.access$402(localField, this.c);
    Field.access$502(localField, this.d);
    Field.access$602(localField, this.e);
    Field.access$702(localField, this.f);
    Field.access$802(localField, this.g);
    Field.access$902(localField, this.h);
    RepeatedFieldBuilderV3 localRepeatedFieldBuilderV3 = this.j;
    if (localRepeatedFieldBuilderV3 == null)
    {
      if ((this.a & 0x1) != 0)
      {
        this.i = Collections.unmodifiableList(this.i);
        this.a &= 0xFFFFFFFE;
      }
      Field.access$1002(localField, this.i);
    }
    else
    {
      Field.access$1002(localField, localRepeatedFieldBuilderV3.f());
    }
    Field.access$1102(localField, this.k);
    Field.access$1202(localField, this.l);
    onBuilt();
    return localField;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return TypeProto.c;
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return TypeProto.d.a(Field.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Field.Builder
 * JD-Core Version:    0.7.0.1
 */