package com.tencent.av.ui.avatar;

import com.tencent.qphone.base.util.QLog;

public class QavAvatarUtil
{
  private static final int[] a = { 40, 100, 140, 640, 0 };
  
  public static int a(String paramString)
  {
    int j = -1;
    int i = j;
    int k;
    if (paramString != null)
    {
      k = paramString.lastIndexOf('=');
      i = j;
      if (k > 0)
      {
        i = j;
        if (k >= paramString.length() - 1) {}
      }
    }
    try
    {
      i = Integer.parseInt(paramString.substring(k + 1));
      return i;
    }
    catch (Throwable paramString) {}
    return -1;
  }
  
  public static String a(String paramString, int paramInt, byte paramByte)
  {
    int i = paramInt;
    if (paramInt == 1080) {
      i = a[4];
    }
    paramInt = 0;
    for (;;)
    {
      localObject = a;
      if (paramInt >= localObject.length) {
        break;
      }
      if (localObject[paramInt] == i)
      {
        i = paramInt;
        break label51;
      }
      paramInt += 1;
    }
    i = -1;
    label51:
    if (i >= 0)
    {
      paramInt = i;
      if (i < a.length) {}
    }
    else
    {
      paramInt = 2;
    }
    Object localObject = new boolean[a.length];
    a(paramByte, (boolean[])localObject);
    int k = a[2];
    i = paramInt;
    int j;
    for (;;)
    {
      j = k;
      if (i < 0) {
        break;
      }
      if (localObject[i] != 0)
      {
        j = a[paramInt];
        break;
      }
      i -= 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(j);
    paramString = ((StringBuilder)localObject).toString();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAvatarDownloadUrl, bFaceFlags = ");
      ((StringBuilder)localObject).append(paramByte);
      ((StringBuilder)localObject).append(", imgSize = ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QavAvatarUtil", 4, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  public static void a(byte paramByte, boolean[] paramArrayOfBoolean)
  {
    if ((paramByte & 0x20) != 0) {
      paramArrayOfBoolean[4] = true;
    } else {
      paramArrayOfBoolean[4] = false;
    }
    if ((paramByte & 0x10) != 0) {
      paramArrayOfBoolean[3] = true;
    } else {
      paramArrayOfBoolean[3] = false;
    }
    if ((paramByte & 0x8) != 0) {
      paramArrayOfBoolean[2] = true;
    } else {
      paramArrayOfBoolean[2] = false;
    }
    if ((paramByte & 0x4) != 0) {
      paramArrayOfBoolean[1] = true;
    } else {
      paramArrayOfBoolean[1] = false;
    }
    paramArrayOfBoolean[0] = true;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1024) || (paramInt == 1020) || (paramInt == 1021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.avatar.QavAvatarUtil
 * JD-Core Version:    0.7.0.1
 */