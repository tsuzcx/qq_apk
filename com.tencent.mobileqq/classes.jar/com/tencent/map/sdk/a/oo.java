package com.tencent.map.sdk.a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class oo
{
  public static void a(File paramFile, String paramString)
  {
    Object localObject1 = new File(paramString);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    paramFile = new ZipFile(paramFile);
    localObject1 = new byte[49152];
    Enumeration localEnumeration = paramFile.entries();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject3 = (ZipEntry)localEnumeration.nextElement();
      Object localObject2 = ((ZipEntry)localObject3).getName();
      if ((localObject2 == null) || (!((String)localObject2).contains("../"))) {
        if (((ZipEntry)localObject3).isDirectory())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append(((ZipEntry)localObject3).getName());
          new File(((StringBuilder)localObject2).toString()).mkdir();
        }
        else
        {
          localObject2 = paramFile.getInputStream((ZipEntry)localObject3);
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramString);
          ((StringBuilder)localObject4).append(File.separator);
          ((StringBuilder)localObject4).append(((ZipEntry)localObject3).getName());
          localObject3 = new File(((StringBuilder)localObject4).toString());
          if (!((File)localObject3).exists())
          {
            localObject4 = ((File)localObject3).getParentFile();
            if (!((File)localObject4).exists()) {
              ((File)localObject4).mkdirs();
            }
            ((File)localObject3).createNewFile();
          }
          localObject3 = new FileOutputStream((File)localObject3);
          for (;;)
          {
            int i = ((InputStream)localObject2).read((byte[])localObject1);
            if (i <= 0) {
              break;
            }
            ((OutputStream)localObject3).write((byte[])localObject1, 0, i);
          }
          ((OutputStream)localObject3).flush();
          ((InputStream)localObject2).close();
          ((OutputStream)localObject3).close();
        }
      }
    }
    paramFile.close();
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: new 114	java/util/zip/InflaterInputStream
    //   3: dup
    //   4: new 116	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: bipush 10
    //   11: iload_1
    //   12: invokespecial 118	java/io/ByteArrayInputStream:<init>	([BII)V
    //   15: invokespecial 121	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: new 123	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: invokespecial 124	java/io/ByteArrayOutputStream:<init>	()V
    //   26: astore_0
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore_3
    //   33: aload_2
    //   34: aload_3
    //   35: invokevirtual 125	java/util/zip/InflaterInputStream:read	([B)I
    //   38: istore_1
    //   39: iload_1
    //   40: ifle +10 -> 50
    //   43: aload_0
    //   44: aload_3
    //   45: iconst_0
    //   46: iload_1
    //   47: invokevirtual 126	java/io/ByteArrayOutputStream:write	([BII)V
    //   50: iload_1
    //   51: ifgt -18 -> 33
    //   54: aload_2
    //   55: invokevirtual 127	java/util/zip/InflaterInputStream:close	()V
    //   58: aload_0
    //   59: invokevirtual 131	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   62: astore_2
    //   63: aload_0
    //   64: invokevirtual 132	java/io/ByteArrayOutputStream:close	()V
    //   67: aload_2
    //   68: areturn
    //   69: aload_2
    //   70: invokevirtual 127	java/util/zip/InflaterInputStream:close	()V
    //   73: aconst_null
    //   74: areturn
    //   75: astore_0
    //   76: goto -7 -> 69
    //   79: astore_2
    //   80: goto -22 -> 58
    //   83: astore_0
    //   84: aload_2
    //   85: areturn
    //   86: astore_0
    //   87: goto -14 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramArrayOfByte	byte[]
    //   0	90	1	paramInt	int
    //   18	52	2	localObject	Object
    //   79	6	2	localIOException	java.io.IOException
    //   32	13	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   33	39	75	java/io/IOException
    //   54	58	79	java/io/IOException
    //   63	67	83	java/io/IOException
    //   69	73	86	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.oo
 * JD-Core Version:    0.7.0.1
 */