package com.google.protobuf.compiler;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class PluginProtos$CodeGeneratorResponse$File$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements PluginProtos.CodeGeneratorResponse.FileOrBuilder
{
  private int a;
  private Object b = "";
  private Object c = "";
  private Object d = "";
  
  private PluginProtos$CodeGeneratorResponse$File$Builder()
  {
    f();
  }
  
  private PluginProtos$CodeGeneratorResponse$File$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    PluginProtos.CodeGeneratorResponse.File.access$3300();
  }
  
  public Builder a()
  {
    super.clear();
    this.b = "";
    this.a &= 0xFFFFFFFE;
    this.c = "";
    this.a &= 0xFFFFFFFD;
    this.d = "";
    this.a &= 0xFFFFFFFB;
    return this;
  }
  
  /* Error */
  public Builder a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 56	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 62 3 0
    //   12: checkcast 38	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 65	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder:a	(Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;)Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 69	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 38	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 73	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 65	com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder:a	(Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;)Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder;
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
    if ((paramMessage instanceof PluginProtos.CodeGeneratorResponse.File)) {
      return a((PluginProtos.CodeGeneratorResponse.File)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder a(PluginProtos.CodeGeneratorResponse.File paramFile)
  {
    if (paramFile == PluginProtos.CodeGeneratorResponse.File.getDefaultInstance()) {
      return this;
    }
    if (paramFile.hasName())
    {
      this.a |= 0x1;
      this.b = PluginProtos.CodeGeneratorResponse.File.access$3500(paramFile);
      onChanged();
    }
    if (paramFile.hasInsertionPoint())
    {
      this.a |= 0x2;
      this.c = PluginProtos.CodeGeneratorResponse.File.access$3600(paramFile);
      onChanged();
    }
    if (paramFile.hasContent())
    {
      this.a |= 0x4;
      this.d = PluginProtos.CodeGeneratorResponse.File.access$3700(paramFile);
      onChanged();
    }
    b(PluginProtos.CodeGeneratorResponse.File.access$3900(paramFile));
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
  
  public PluginProtos.CodeGeneratorResponse.File b()
  {
    return PluginProtos.CodeGeneratorResponse.File.getDefaultInstance();
  }
  
  public PluginProtos.CodeGeneratorResponse.File c()
  {
    PluginProtos.CodeGeneratorResponse.File localFile = d();
    if (localFile.isInitialized()) {
      return localFile;
    }
    throw newUninitializedMessageException(localFile);
  }
  
  public PluginProtos.CodeGeneratorResponse.File d()
  {
    PluginProtos.CodeGeneratorResponse.File localFile = new PluginProtos.CodeGeneratorResponse.File(this, null);
    int k = this.a;
    if ((k & 0x1) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    PluginProtos.CodeGeneratorResponse.File.access$3502(localFile, this.b);
    int i = j;
    if ((k & 0x2) != 0) {
      i = j | 0x2;
    }
    PluginProtos.CodeGeneratorResponse.File.access$3602(localFile, this.c);
    int j = i;
    if ((k & 0x4) != 0) {
      j = i | 0x4;
    }
    PluginProtos.CodeGeneratorResponse.File.access$3702(localFile, this.d);
    PluginProtos.CodeGeneratorResponse.File.access$3802(localFile, j);
    onBuilt();
    return localFile;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return PluginProtos.h();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return PluginProtos.i().a(PluginProtos.CodeGeneratorResponse.File.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.Builder
 * JD-Core Version:    0.7.0.1
 */