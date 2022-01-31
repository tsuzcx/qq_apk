package com.tencent.TMG.channel;

import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;

public class KSAppChannel
  extends AVAppChannel
{
  public static String TAG = "KSAppChannel";
  public AVContext.StartParam startParam_;
  
  public long getTinyId()
  {
    try
    {
      long l = Long.valueOf(this.startParam_.identifier).longValue();
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }
  
  public boolean identifierToTinyId(String paramString1, String paramString2, String[] paramArrayOfString, AVAppChannel.IdToIdCallback paramIdToIdCallback)
  {
    paramString1 = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramString1.add(paramArrayOfString[i]);
      i += 1;
    }
    identifierToTinyIdIntern(paramArrayOfString, new KSAppChannel.IdToIdCallbackImpl(this, paramIdToIdCallback));
    return true;
  }
  
  public void identifierToTinyIdIntern(String[] paramArrayOfString, KSAppChannel.IdToIdCallbackImpl paramIdToIdCallbackImpl)
  {
    long[] arrayOfLong = new long[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfLong[i] = Long.valueOf(paramArrayOfString[i]).longValue();
      i += 1;
    }
    paramIdToIdCallbackImpl.onSuccess(paramArrayOfString, arrayOfLong);
  }
  
  public boolean loginWithParam(AVContext.StartParam paramStartParam)
  {
    this.startParam_ = paramStartParam;
    return true;
  }
  
  public native byte[] nativeConvertToIMReportData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3);
  
  public native void nativeRequestVideoAppCmd(byte[] paramArrayOfByte, int paramInt, AVContext.StartParam paramStartParam, AVAppChannel.CsCmdCallback paramCsCmdCallback);
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, int paramInt, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    return true;
  }
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    return requestCmd("0", paramArrayOfByte, paramCsCmdCallback);
  }
  
  public boolean requestCmd(String paramString, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    String str = paramString;
    if (paramString.equals("VideoCCSvc.opensdk")) {
      str = "2";
    }
    try
    {
      nativeRequestVideoAppCmd(paramArrayOfByte, Integer.parseInt(str), this.startParam_, new KSAppChannel.CsCmdCallbackImpl(this, paramCsCmdCallback));
      return true;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean requestInfoCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    return requestCmd("1", paramArrayOfByte, paramCsCmdCallback);
  }
  
  public boolean requestReportCmd(int paramInt, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    if (paramArrayOfByte.length >= 0) {
      return requestCmd("3", nativeConvertToIMReportData(paramArrayOfByte, paramInt, this.startParam_.sdkAppId, getTinyId(), (int)System.currentTimeMillis() / 1000), paramCsCmdCallback);
    }
    QLog.e(TAG, 0, "requestReportCmd reportData == NULL");
    return false;
  }
  
  public boolean tinyIdToIdentifier(long[] paramArrayOfLong, AVAppChannel.IdToIdCallback paramIdToIdCallback)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    tinyIdToIdentifierIntern(paramArrayOfLong, new KSAppChannel.IdToIdCallbackImpl(this, paramIdToIdCallback));
    return true;
  }
  
  public void tinyIdToIdentifierIntern(long[] paramArrayOfLong, KSAppChannel.IdToIdCallbackImpl paramIdToIdCallbackImpl)
  {
    String[] arrayOfString = new String[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfString[i] = Long.toString(paramArrayOfLong[i]);
      i += 1;
    }
    paramIdToIdCallbackImpl.onSuccess(arrayOfString, paramArrayOfLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.channel.KSAppChannel
 * JD-Core Version:    0.7.0.1
 */