package com.google.protobuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class Descriptors$FileDescriptor
  extends Descriptors.GenericDescriptor
{
  private DescriptorProtos.FileDescriptorProto a;
  private final Descriptors.Descriptor[] b;
  private final Descriptors.EnumDescriptor[] c;
  private final Descriptors.ServiceDescriptor[] d;
  private final Descriptors.FieldDescriptor[] e;
  private final FileDescriptor[] f;
  private final FileDescriptor[] g;
  private final Descriptors.DescriptorPool h;
  
  private Descriptors$FileDescriptor(DescriptorProtos.FileDescriptorProto paramFileDescriptorProto, FileDescriptor[] paramArrayOfFileDescriptor, Descriptors.DescriptorPool paramDescriptorPool, boolean paramBoolean)
  {
    this.h = paramDescriptorPool;
    this.a = paramFileDescriptorProto;
    this.f = ((FileDescriptor[])paramArrayOfFileDescriptor.clone());
    HashMap localHashMap = new HashMap();
    int k = paramArrayOfFileDescriptor.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      localObject = paramArrayOfFileDescriptor[i];
      localHashMap.put(((FileDescriptor)localObject).b(), localObject);
      i += 1;
    }
    Object localObject = new ArrayList();
    i = 0;
    while (i < paramFileDescriptorProto.getPublicDependencyCount())
    {
      k = paramFileDescriptorProto.getPublicDependency(i);
      if ((k >= 0) && (k < paramFileDescriptorProto.getDependencyCount()))
      {
        paramArrayOfFileDescriptor = paramFileDescriptorProto.getDependency(k);
        FileDescriptor localFileDescriptor = (FileDescriptor)localHashMap.get(paramArrayOfFileDescriptor);
        if (localFileDescriptor == null)
        {
          if (!paramBoolean)
          {
            paramFileDescriptorProto = new StringBuilder();
            paramFileDescriptorProto.append("Invalid public dependency: ");
            paramFileDescriptorProto.append(paramArrayOfFileDescriptor);
            throw new Descriptors.DescriptorValidationException(this, paramFileDescriptorProto.toString(), null);
          }
        }
        else {
          ((List)localObject).add(localFileDescriptor);
        }
        i += 1;
      }
      else
      {
        throw new Descriptors.DescriptorValidationException(this, "Invalid public dependency index.", null);
      }
    }
    this.g = new FileDescriptor[((List)localObject).size()];
    ((List)localObject).toArray(this.g);
    paramDescriptorPool.a(e(), this);
    this.b = new Descriptors.Descriptor[paramFileDescriptorProto.getMessageTypeCount()];
    i = 0;
    while (i < paramFileDescriptorProto.getMessageTypeCount())
    {
      this.b[i] = new Descriptors.Descriptor(paramFileDescriptorProto.getMessageType(i), this, null, i, null);
      i += 1;
    }
    this.c = new Descriptors.EnumDescriptor[paramFileDescriptorProto.getEnumTypeCount()];
    i = 0;
    while (i < paramFileDescriptorProto.getEnumTypeCount())
    {
      this.c[i] = new Descriptors.EnumDescriptor(paramFileDescriptorProto.getEnumType(i), this, null, i, null);
      i += 1;
    }
    this.d = new Descriptors.ServiceDescriptor[paramFileDescriptorProto.getServiceCount()];
    i = 0;
    while (i < paramFileDescriptorProto.getServiceCount())
    {
      this.d[i] = new Descriptors.ServiceDescriptor(paramFileDescriptorProto.getService(i), this, i, null);
      i += 1;
    }
    this.e = new Descriptors.FieldDescriptor[paramFileDescriptorProto.getExtensionCount()];
    i = j;
    while (i < paramFileDescriptorProto.getExtensionCount())
    {
      this.e[i] = new Descriptors.FieldDescriptor(paramFileDescriptorProto.getExtension(i), this, null, i, true, null);
      i += 1;
    }
  }
  
  Descriptors$FileDescriptor(String paramString, Descriptors.Descriptor paramDescriptor)
  {
    this.h = new Descriptors.DescriptorPool(new FileDescriptor[0], true);
    DescriptorProtos.FileDescriptorProto.Builder localBuilder = DescriptorProtos.FileDescriptorProto.newBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDescriptor.c());
    localStringBuilder.append(".placeholder.proto");
    this.a = localBuilder.a(localStringBuilder.toString()).b(paramString).a(paramDescriptor.a()).c();
    this.f = new FileDescriptor[0];
    this.g = new FileDescriptor[0];
    this.b = new Descriptors.Descriptor[] { paramDescriptor };
    this.c = new Descriptors.EnumDescriptor[0];
    this.d = new Descriptors.ServiceDescriptor[0];
    this.e = new Descriptors.FieldDescriptor[0];
    this.h.a(paramString, this);
    this.h.c(paramDescriptor);
  }
  
  public static FileDescriptor a(DescriptorProtos.FileDescriptorProto paramFileDescriptorProto, FileDescriptor[] paramArrayOfFileDescriptor, boolean paramBoolean)
  {
    paramFileDescriptorProto = new FileDescriptor(paramFileDescriptorProto, paramArrayOfFileDescriptor, new Descriptors.DescriptorPool(paramArrayOfFileDescriptor, paramBoolean), paramBoolean);
    paramFileDescriptorProto.m();
    return paramFileDescriptorProto;
  }
  
  /* Error */
  public static FileDescriptor a(String[] paramArrayOfString, FileDescriptor[] paramArrayOfFileDescriptor)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 211	com/google/protobuf/Descriptors$FileDescriptor:a	([Ljava/lang/String;)[B
    //   4: astore_0
    //   5: aload_0
    //   6: invokestatic 215	com/google/protobuf/DescriptorProtos$FileDescriptorProto:parseFrom	([B)Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto;
    //   9: astore_0
    //   10: aload_0
    //   11: aload_1
    //   12: iconst_1
    //   13: invokestatic 217	com/google/protobuf/Descriptors$FileDescriptor:a	(Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto;[Lcom/google/protobuf/Descriptors$FileDescriptor;Z)Lcom/google/protobuf/Descriptors$FileDescriptor;
    //   16: astore_1
    //   17: aload_1
    //   18: areturn
    //   19: astore_1
    //   20: new 71	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   27: astore_2
    //   28: aload_2
    //   29: ldc 219
    //   31: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_2
    //   36: aload_0
    //   37: invokevirtual 222	com/google/protobuf/DescriptorProtos$FileDescriptorProto:getName	()Ljava/lang/String;
    //   40: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: ldc 224
    //   47: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: new 226	java/lang/IllegalArgumentException
    //   54: dup
    //   55: aload_2
    //   56: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: aload_1
    //   60: invokespecial 229	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: athrow
    //   64: astore_0
    //   65: new 226	java/lang/IllegalArgumentException
    //   68: dup
    //   69: ldc 231
    //   71: aload_0
    //   72: invokespecial 229	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramArrayOfString	String[]
    //   0	76	1	paramArrayOfFileDescriptor	FileDescriptor[]
    //   27	29	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	17	19	com/google/protobuf/Descriptors$DescriptorValidationException
    //   5	10	64	com/google/protobuf/InvalidProtocolBufferException
  }
  
  private static byte[] a(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    if (j == 1) {
      return paramArrayOfString[0].getBytes(Internal.b);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    j = paramArrayOfString.length;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfString[i]);
      i += 1;
    }
    return localStringBuilder.toString().getBytes(Internal.b);
  }
  
  private void m()
  {
    Object localObject = this.b;
    int k = localObject.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      Descriptors.Descriptor.a(localObject[i]);
      i += 1;
    }
    localObject = this.d;
    k = localObject.length;
    i = 0;
    while (i < k)
    {
      Descriptors.ServiceDescriptor.a(localObject[i]);
      i += 1;
    }
    localObject = this.e;
    k = localObject.length;
    i = j;
    while (i < k)
    {
      Descriptors.FieldDescriptor.b(localObject[i]);
      i += 1;
    }
  }
  
  public DescriptorProtos.FileDescriptorProto a()
  {
    return this.a;
  }
  
  public Descriptors.FieldDescriptor a(String paramString)
  {
    if (paramString.indexOf('.') != -1) {
      return null;
    }
    String str = e();
    Object localObject = paramString;
    if (!str.isEmpty())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append('.');
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = this.h.a((String)localObject);
    if ((paramString != null) && ((paramString instanceof Descriptors.FieldDescriptor)) && (paramString.d() == this)) {
      return (Descriptors.FieldDescriptor)paramString;
    }
    return null;
  }
  
  public String b()
  {
    return this.a.getName();
  }
  
  public String c()
  {
    return this.a.getName();
  }
  
  public FileDescriptor d()
  {
    return this;
  }
  
  public String e()
  {
    return this.a.getPackage();
  }
  
  public DescriptorProtos.FileOptions f()
  {
    return this.a.getOptions();
  }
  
  public List<Descriptors.Descriptor> g()
  {
    return Collections.unmodifiableList(Arrays.asList(this.b));
  }
  
  public List<Descriptors.EnumDescriptor> h()
  {
    return Collections.unmodifiableList(Arrays.asList(this.c));
  }
  
  public List<FileDescriptor> i()
  {
    return Collections.unmodifiableList(Arrays.asList(this.g));
  }
  
  public Descriptors.FileDescriptor.Syntax j()
  {
    if (Descriptors.FileDescriptor.Syntax.access$000(Descriptors.FileDescriptor.Syntax.PROTO3).equals(this.a.getSyntax())) {
      return Descriptors.FileDescriptor.Syntax.PROTO3;
    }
    return Descriptors.FileDescriptor.Syntax.PROTO2;
  }
  
  boolean k()
  {
    return j() == Descriptors.FileDescriptor.Syntax.PROTO3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Descriptors.FileDescriptor
 * JD-Core Version:    0.7.0.1
 */