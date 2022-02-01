package com.google.protobuf.compiler;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.google.protobuf.GeneratedMessageV3.BuilderParent;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class PluginProtos$Version$Builder
  extends GeneratedMessageV3.Builder<Builder>
  implements PluginProtos.VersionOrBuilder
{
  private int a;
  private int b;
  private int c;
  private int d;
  private Object e = "";
  
  private PluginProtos$Version$Builder()
  {
    f();
  }
  
  private PluginProtos$Version$Builder(GeneratedMessageV3.BuilderParent paramBuilderParent)
  {
    super(paramBuilderParent);
    f();
  }
  
  private void f()
  {
    PluginProtos.Version.access$400();
  }
  
  public Builder a()
  {
    super.clear();
    this.b = 0;
    this.a &= 0xFFFFFFFE;
    this.c = 0;
    this.a &= 0xFFFFFFFD;
    this.d = 0;
    this.a &= 0xFFFFFFFB;
    this.e = "";
    this.a &= 0xFFFFFFF7;
    return this;
  }
  
  public Builder a(int paramInt)
  {
    this.a |= 0x1;
    this.b = paramInt;
    onChanged();
    return this;
  }
  
  /* Error */
  public Builder a(com.google.protobuf.CodedInputStream paramCodedInputStream, com.google.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 63	com/google/protobuf/compiler/PluginProtos$Version:PARSER	Lcom/google/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 69 3 0
    //   12: checkcast 35	com/google/protobuf/compiler/PluginProtos$Version
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 72	com/google/protobuf/compiler/PluginProtos$Version$Builder:a	(Lcom/google/protobuf/compiler/PluginProtos$Version;)Lcom/google/protobuf/compiler/PluginProtos$Version$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +18 -> 49
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 76	com/google/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lcom/google/protobuf/MessageLite;
    //   39: checkcast 35	com/google/protobuf/compiler/PluginProtos$Version
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 80	com/google/protobuf/InvalidProtocolBufferException:unwrapIOException	()Ljava/io/IOException;
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 72	com/google/protobuf/compiler/PluginProtos$Version$Builder:a	(Lcom/google/protobuf/compiler/PluginProtos$Version;)Lcom/google/protobuf/compiler/PluginProtos$Version$Builder;
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
    if ((paramMessage instanceof PluginProtos.Version)) {
      return a((PluginProtos.Version)paramMessage);
    }
    super.mergeFrom(paramMessage);
    return this;
  }
  
  public final Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return (Builder)super.setUnknownFields(paramUnknownFieldSet);
  }
  
  public Builder a(PluginProtos.Version paramVersion)
  {
    if (paramVersion == PluginProtos.Version.getDefaultInstance()) {
      return this;
    }
    if (paramVersion.hasMajor()) {
      a(paramVersion.getMajor());
    }
    if (paramVersion.hasMinor()) {
      b(paramVersion.getMinor());
    }
    if (paramVersion.hasPatch()) {
      c(paramVersion.getPatch());
    }
    if (paramVersion.hasSuffix())
    {
      this.a |= 0x8;
      this.e = PluginProtos.Version.access$900(paramVersion);
      onChanged();
    }
    b(PluginProtos.Version.access$1100(paramVersion));
    onChanged();
    return this;
  }
  
  public Builder b(int paramInt)
  {
    this.a |= 0x2;
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
  
  public PluginProtos.Version b()
  {
    return PluginProtos.Version.getDefaultInstance();
  }
  
  public Builder c(int paramInt)
  {
    this.a |= 0x4;
    this.d = paramInt;
    onChanged();
    return this;
  }
  
  public PluginProtos.Version c()
  {
    PluginProtos.Version localVersion = d();
    if (localVersion.isInitialized()) {
      return localVersion;
    }
    throw newUninitializedMessageException(localVersion);
  }
  
  public PluginProtos.Version d()
  {
    PluginProtos.Version localVersion = new PluginProtos.Version(this, null);
    int k = this.a;
    if ((k & 0x1) != 0)
    {
      PluginProtos.Version.access$602(localVersion, this.b);
      j = 1;
    }
    else
    {
      j = 0;
    }
    int i = j;
    if ((k & 0x2) != 0)
    {
      PluginProtos.Version.access$702(localVersion, this.c);
      i = j | 0x2;
    }
    int j = i;
    if ((k & 0x4) != 0)
    {
      PluginProtos.Version.access$802(localVersion, this.d);
      j = i | 0x4;
    }
    i = j;
    if ((k & 0x8) != 0) {
      i = j | 0x8;
    }
    PluginProtos.Version.access$902(localVersion, this.e);
    PluginProtos.Version.access$1002(localVersion, i);
    onBuilt();
    return localVersion;
  }
  
  public Builder e()
  {
    return (Builder)super.clone();
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return PluginProtos.b();
  }
  
  protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return PluginProtos.c().a(PluginProtos.Version.class, Builder.class);
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.compiler.PluginProtos.Version.Builder
 * JD-Core Version:    0.7.0.1
 */