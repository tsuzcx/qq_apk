package com.qq.wx.voice.util;

import android.os.Environment;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Common
{
  private static byte[] a = parseScreKey("5c42508c5bb7cd318c9aacf33513c7f3");
  private static byte[] b = new byte[16];
  
  public static byte[] AES(byte[] paramArrayOfByte)
  {
    Object localObject;
    int i;
    int j;
    try
    {
      localObject = new byte[16];
      if (a == null) {
        break label103;
      }
      i = a.length;
    }
    catch (Exception paramArrayOfByte)
    {
      Cipher localCipher;
      paramArrayOfByte.printStackTrace();
      return null;
    }
    if (j >= 16)
    {
      localObject = new SecretKeySpec((byte[])localObject, "AES");
      localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, (java.security.Key)localObject, new IvParameterSpec(b));
      return localCipher.doFinal(paramArrayOfByte);
    }
    if (j < i) {
      localObject[j] = a[j];
    }
    for (;;)
    {
      b[j] = 0;
      j += 1;
      break;
      label103:
      i = 0;
      j = 0;
      break;
      localObject[j] = 123;
    }
  }
  
  public static int calculateSum(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= paramInt) {
        return j;
      }
      j += Math.abs((short)((paramArrayOfByte[(i + 1)] & 0xFF) << 8 | paramArrayOfByte[i] & 0xFF)) / (paramInt / 2);
      i += 2;
    }
  }
  
  public static int calculateVolumn(int paramInt)
  {
    double d = 64.0D;
    if (paramInt < 30)
    {
      d = 0.0D;
    }
    else if (paramInt <= 16383)
    {
      d = paramInt;
      Double.isNaN(d);
      d = 64.0D * ((d - 30.0D) / 12737.0D);
    }
    return (int)d;
  }
  
  public static int calculateVolumn(byte[] paramArrayOfByte, int paramInt)
  {
    return calculateVolumn(calculateSum(paramArrayOfByte, paramInt));
  }
  
  public static void compress(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    paramOutputStream = new GZIPOutputStream(paramOutputStream);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1)
      {
        paramOutputStream.flush();
        paramOutputStream.close();
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static byte[] compress(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    compress(paramArrayOfByte, localByteArrayOutputStream);
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
  
  public static String genVoiceId(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = new Random().nextLong();
    paramString = new StringBuilder(String.valueOf(paramString));
    paramString.append(String.valueOf(l1));
    paramString.append(String.valueOf(l2));
    return Hex.encode(Hex.generateMD5(paramString.toString().getBytes()));
  }
  
  public static byte[] parseScreKey(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[16];
    Key.convertKey(paramString, arrayOfByte);
    return arrayOfByte;
  }
  
  public static void saveFile(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject1 = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()));
    ((StringBuilder)localObject1).append("/wxvoicerecord/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new Date();
    localObject2 = new StringBuilder(String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format((Date)localObject2)));
    ((StringBuilder)localObject2).append(".");
    ((StringBuilder)localObject2).append(paramString);
    localObject1 = new File((String)localObject1, ((StringBuilder)localObject2).toString());
    if (!((File)localObject1).exists()) {
      try
      {
        ((File)localObject1).createNewFile();
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramString = null;
    try
    {
      localObject1 = new FileOutputStream((File)localObject1);
      paramString = (String)localObject1;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
    if (paramString == null) {
      return;
    }
    try
    {
      paramString.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramString.close();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.util.Common
 * JD-Core Version:    0.7.0.1
 */