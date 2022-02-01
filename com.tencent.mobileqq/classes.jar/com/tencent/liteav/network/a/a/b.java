package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;

public final class b
{
  private static String a(DataInputStream paramDataInputStream, byte[] paramArrayOfByte)
  {
    int i = paramDataInputStream.readUnsignedByte();
    if ((i & 0xC0) == 192)
    {
      i = ((i & 0x3F) << 8) + paramDataInputStream.readUnsignedByte();
      paramDataInputStream = new HashSet();
      paramDataInputStream.add(Integer.valueOf(i));
      return a(paramArrayOfByte, i, paramDataInputStream);
    }
    if (i == 0) {
      return "";
    }
    Object localObject = new byte[i];
    paramDataInputStream.readFully((byte[])localObject);
    localObject = IDN.toUnicode(new String((byte[])localObject));
    paramArrayOfByte = a(paramDataInputStream, paramArrayOfByte);
    paramDataInputStream = (DataInputStream)localObject;
    if (paramArrayOfByte.length() > 0)
    {
      paramDataInputStream = new StringBuilder();
      paramDataInputStream.append((String)localObject);
      paramDataInputStream.append(".");
      paramDataInputStream.append(paramArrayOfByte);
      paramDataInputStream = paramDataInputStream.toString();
    }
    return paramDataInputStream;
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt, HashSet<Integer> paramHashSet)
  {
    int i = paramArrayOfByte[paramInt] & 0xFF;
    if ((i & 0xC0) == 192)
    {
      paramInt = ((i & 0x3F) << 8) + (paramArrayOfByte[(paramInt + 1)] & 0xFF);
      if (!paramHashSet.contains(Integer.valueOf(paramInt)))
      {
        paramHashSet.add(Integer.valueOf(paramInt));
        return a(paramArrayOfByte, paramInt, paramHashSet);
      }
      throw new com.tencent.liteav.network.a.a("", "Cyclic offsets detected.");
    }
    if (i == 0) {
      return "";
    }
    paramInt += 1;
    String str = new String(paramArrayOfByte, paramInt, i);
    paramHashSet = a(paramArrayOfByte, paramInt + i, paramHashSet);
    paramArrayOfByte = str;
    if (paramHashSet.length() > 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(str);
      paramArrayOfByte.append(".");
      paramArrayOfByte.append(paramHashSet);
      paramArrayOfByte = paramArrayOfByte.toString();
    }
    return paramArrayOfByte;
  }
  
  private static void a(DataInputStream paramDataInputStream, byte[] paramArrayOfByte, int paramInt)
  {
    while (paramInt > 0)
    {
      a(paramDataInputStream, paramArrayOfByte);
      paramDataInputStream.readUnsignedShort();
      paramDataInputStream.readUnsignedShort();
      paramInt -= 1;
    }
  }
  
  private static void a(OutputStream paramOutputStream, String paramString)
  {
    paramString = paramString.split("[.。．｡]");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      byte[] arrayOfByte = IDN.toASCII(paramString[i]).getBytes();
      paramOutputStream.write(arrayOfByte.length);
      paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
      i += 1;
    }
    paramOutputStream.write(0);
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(512);
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    com.tencent.liteav.network.a.b.a locala = new com.tencent.liteav.network.a.b.a();
    locala.a(8);
    paramInt = (short)paramInt;
    try
    {
      localDataOutputStream.writeShort(paramInt);
      localDataOutputStream.writeShort((short)locala.a());
      localDataOutputStream.writeShort(1);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.flush();
      b(localByteArrayOutputStream, paramString);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public static e[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    int i = localDataInputStream.readUnsignedShort();
    if (i == paramInt)
    {
      int j = localDataInputStream.readUnsignedShort();
      i = 1;
      if ((j >> 8 & 0x1) == 1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((j >> 7 & 0x1) != 1) {
        i = 0;
      }
      if ((i != 0) && (paramInt != 0))
      {
        paramInt = localDataInputStream.readUnsignedShort();
        i = localDataInputStream.readUnsignedShort();
        localDataInputStream.readUnsignedShort();
        localDataInputStream.readUnsignedShort();
        a(localDataInputStream, paramArrayOfByte, paramInt);
        return b(localDataInputStream, paramArrayOfByte, i);
      }
      throw new com.tencent.liteav.network.a.a(paramString, "the dns server cant support recursion ");
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("the answer id ");
    paramArrayOfByte.append(i);
    paramArrayOfByte.append(" is not match ");
    paramArrayOfByte.append(paramInt);
    throw new com.tencent.liteav.network.a.a(paramString, paramArrayOfByte.toString());
  }
  
  private static e b(DataInputStream paramDataInputStream, byte[] paramArrayOfByte)
  {
    a(paramDataInputStream, paramArrayOfByte);
    int j = paramDataInputStream.readUnsignedShort();
    paramDataInputStream.readUnsignedShort();
    long l1 = paramDataInputStream.readUnsignedShort();
    long l2 = paramDataInputStream.readUnsignedShort();
    int k = paramDataInputStream.readUnsignedShort();
    if (j != 1)
    {
      if (j != 5)
      {
        int i = 0;
        while (i < k)
        {
          paramDataInputStream.readByte();
          i += 1;
        }
        paramDataInputStream = null;
      }
      else
      {
        paramDataInputStream = a(paramDataInputStream, paramArrayOfByte);
      }
    }
    else
    {
      paramArrayOfByte = new byte[4];
      paramDataInputStream.readFully(paramArrayOfByte);
      paramDataInputStream = InetAddress.getByAddress(paramArrayOfByte).getHostAddress();
    }
    if (paramDataInputStream != null) {
      return new e(paramDataInputStream, j, (int)((l1 << 16) + l2), System.currentTimeMillis() / 1000L);
    }
    paramDataInputStream = new UnknownHostException("no record");
    for (;;)
    {
      throw paramDataInputStream;
    }
  }
  
  private static void b(OutputStream paramOutputStream, String paramString)
  {
    DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
    a(paramOutputStream, paramString);
    localDataOutputStream.writeShort(1);
    localDataOutputStream.writeShort(1);
  }
  
  private static e[] b(DataInputStream paramDataInputStream, byte[] paramArrayOfByte, int paramInt)
  {
    e[] arrayOfe = new e[paramInt];
    int i = 0;
    while (paramInt > 0)
    {
      arrayOfe[i] = b(paramDataInputStream, paramArrayOfByte);
      i += 1;
      paramInt -= 1;
    }
    return arrayOfe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.a.a.b
 * JD-Core Version:    0.7.0.1
 */