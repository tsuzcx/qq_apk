package com.tencent.map.sdk.a;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public final class ou
{
  public static String a(File paramFile)
  {
    int i = 0;
    Object localObject1 = new FileInputStream(paramFile);
    Object localObject2 = new byte[1024];
    paramFile = new char[16];
    paramFile[0] = 48;
    paramFile[1] = 49;
    paramFile[2] = 50;
    paramFile[3] = 51;
    paramFile[4] = 52;
    paramFile[5] = 53;
    paramFile[6] = 54;
    paramFile[7] = 55;
    paramFile[8] = 56;
    paramFile[9] = 57;
    paramFile[10] = 97;
    paramFile[11] = 98;
    paramFile[12] = 99;
    paramFile[13] = 100;
    paramFile[14] = 101;
    paramFile[15] = 102;
    paramFile;
    MessageDigest localMessageDigest;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      for (;;)
      {
        j = ((FileInputStream)localObject1).read((byte[])localObject2, 0, 1024);
        if (j == -1) {
          break;
        }
        localMessageDigest.update((byte[])localObject2, 0, j);
      }
      ((FileInputStream)localObject1).close();
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    localObject1 = localMessageDigest.digest();
    localObject2 = new char[32];
    int j = 0;
    for (;;)
    {
      paramFile = new String((char[])localObject2);
      return paramFile;
      while (i < 16)
      {
        int k = localObject1[i];
        int m = j + 1;
        localObject2[j] = paramFile[(k >>> 4 & 0xF)];
        j = m + 1;
        localObject2[m] = paramFile[(k & 0xF)];
        i += 1;
      }
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar = new char[16];
    char[] tmp10_8 = arrayOfChar;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 97;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 98;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 99;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 100;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 101;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 102;
    tmp94_88;
    for (;;)
    {
      Object localObject;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        localObject = new char[32];
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
      while (i < 16)
      {
        int k = paramArrayOfByte[i];
        int m = j + 1;
        localObject[j] = arrayOfChar[(k >>> 4 & 0xF)];
        j = m + 1;
        localObject[m] = arrayOfChar[(k & 0xF)];
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ou
 * JD-Core Version:    0.7.0.1
 */