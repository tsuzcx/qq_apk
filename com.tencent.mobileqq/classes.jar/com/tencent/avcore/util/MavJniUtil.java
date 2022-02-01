package com.tencent.avcore.util;

import com.tencent.avcore.jni.data.AVUserInfo;
import java.util.ArrayList;

public class MavJniUtil
{
  static final String TAG = "MavJniUtil";
  
  public static AVUserInfo getAVInfoFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length < 16) {
        return null;
      }
      Object localObject = new byte[8];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, 8);
      long l = getLongFromByte((byte[])localObject);
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, 8, localObject, 0, 4);
      int i = getIntFromByte((byte[])localObject);
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, 12, localObject, 0, 4);
      int j = getIntFromByte((byte[])localObject);
      paramInt = 2;
      if (paramArrayOfByte.length > 16)
      {
        localObject = new byte[1];
        System.arraycopy(paramArrayOfByte, 16, localObject, 0, 1);
        paramInt = localObject[0];
      }
      else
      {
        AVCoreLog.e("MavJniUtil", "getAVInfoFromByte", new Throwable("打印调用栈"));
      }
      paramArrayOfByte = new AVUserInfo();
      paramArrayOfByte.account = l;
      paramArrayOfByte.accountType = i;
      paramArrayOfByte.pstnStatus = j;
      paramArrayOfByte.micAuthByAdmin = paramInt;
      if (AVCoreLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("AVUserInfo-->Uin = ");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" ,isPstn = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" ,pstnState = ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" ,micOffByAdmin = ");
        ((StringBuilder)localObject).append(paramInt);
        AVCoreLog.d("MavJniUtil", ((StringBuilder)localObject).toString());
      }
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static ArrayList<AVUserInfo> getAVInfoListFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("MavJniUtil", "getAVInfoListFromByte--> buf is null");
      }
      return null;
    }
    if (paramInt == 0)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("MavJniUtil", "getAVInfoListFromByte--> structLen is 0");
      }
      return null;
    }
    int i = paramArrayOfByte.length;
    if (i % paramInt != 0)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("MavJniUtil", "getAVInfoListFromByte--> buf len is incorrect");
      }
      return null;
    }
    int j = i / paramInt;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < j)
    {
      Object localObject = new byte[paramInt];
      System.arraycopy(paramArrayOfByte, i * paramInt, localObject, 0, paramInt);
      localObject = getAVInfoFromByte((byte[])localObject, paramInt);
      if (localObject == null)
      {
        if (AVCoreLog.isColorLevel()) {
          AVCoreLog.i("MavJniUtil", "Can not get AVUserInfo...Error");
        }
        return null;
      }
      if ((((AVUserInfo)localObject).accountType != 1) || (((AVUserInfo)localObject).pstnStatus == 3)) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    if (AVCoreLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("getAVInfoListFromByte --> length = ");
      paramArrayOfByte.append(localArrayList.size());
      AVCoreLog.d("MavJniUtil", paramArrayOfByte.toString());
    }
    return localArrayList;
  }
  
  public static int getIntFromByte(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      int k = 3 - i;
      j |= (paramArrayOfByte[k] & 0xFF) << k * 4;
      i += 1;
    }
    return j;
  }
  
  public static long getLongFromByte(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      int j = 7 - i;
      l |= (paramArrayOfByte[j] & 0xFF) << j * 8;
      i += 1;
    }
    return l;
  }
  
  public static long[] getUinListFromBuf(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < 8) {
        return null;
      }
      int i = paramArrayOfByte.length;
      if (i % 8 != 0) {
        return null;
      }
      long[] arrayOfLong = new long[i / 8];
      byte[] arrayOfByte = new byte[8];
      int j = 0;
      for (;;)
      {
        localObject = arrayOfLong;
        if (i < 8) {
          break;
        }
        System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, 8);
        long l = getLongFromByte(arrayOfByte);
        if (l == 0L)
        {
          AVCoreLog.e("MavJniUtil", "getUinListFromBuf-->get the wrong uin==0");
          return arrayOfLong;
        }
        arrayOfLong[(j / 8)] = l;
        j += 8;
        i -= 8;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.util.MavJniUtil
 * JD-Core Version:    0.7.0.1
 */