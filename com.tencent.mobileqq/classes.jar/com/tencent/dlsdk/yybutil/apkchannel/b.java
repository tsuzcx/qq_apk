package com.tencent.dlsdk.yybutil.apkchannel;

import com.tencent.dlsdk.yybutil.apkchannel.a.c;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;

class b
{
  private static final c c = new c(38650);
  Properties a = new Properties();
  byte[] b;
  
  void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      System.out.println("WARNING:[YYBComment]decode|data=null|exit");
      return;
    }
    Object localObject = ByteBuffer.wrap(paramArrayOfByte);
    int i = c.a().length;
    byte[] arrayOfByte = new byte[i];
    ((ByteBuffer)localObject).get(arrayOfByte);
    if (c.equals(new c(arrayOfByte)))
    {
      if (paramArrayOfByte.length - i <= 2)
      {
        System.out.println("ERROR:[YYBComment]decode|data.length - headLength <= 2|1|exit");
        return;
      }
      arrayOfByte = new byte[2];
      ((ByteBuffer)localObject).get(arrayOfByte);
      int j = new c(arrayOfByte).b();
      if (paramArrayOfByte.length - i - 2 < j)
      {
        System.out.println("ERROR:[YYBComment]decode|data.length - headLength <= 2|2|exit");
        return;
      }
      arrayOfByte = new byte[j];
      ((ByteBuffer)localObject).get(arrayOfByte);
      this.a.load(new InputStreamReader(new ByteArrayInputStream(arrayOfByte), "UTF-8"));
      i = paramArrayOfByte.length - i - j - 2;
      if (i > 0)
      {
        this.b = new byte[i];
        ((ByteBuffer)localObject).get(this.b);
      }
      return;
    }
    System.out.println("ERROR:[YYBComment]decode|unknow protocol|exit");
    localObject = new StringBuilder("[YYBComment] unknow protocl [");
    ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfByte));
    ((StringBuilder)localObject).append("]");
    throw new ProtocolException(((StringBuilder)localObject).toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("YYBComment [p=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", otherData=");
    localStringBuilder.append(Arrays.toString(this.b));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.b
 * JD-Core Version:    0.7.0.1
 */