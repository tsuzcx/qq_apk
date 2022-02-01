package com.tencent.TMG.channel;

import com.tencent.TMG.sdk.AVContext.StartParam;

public abstract class AVAppChannel
{
  public int getServerEnvType()
  {
    return -1;
  }
  
  public abstract long getTinyId();
  
  public boolean identifierToTinyId(String paramString1, String paramString2, String[] paramArrayOfString, AVAppChannel.IdToIdCallback paramIdToIdCallback)
  {
    paramString1 = new long[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramString1[i] = Long.parseLong(paramArrayOfString[i]);
      i += 1;
    }
    paramIdToIdCallback.onSuccess(paramArrayOfString, paramString1);
    return true;
  }
  
  public abstract boolean loginWithParam(AVContext.StartParam paramStartParam);
  
  public abstract boolean requestAppCmd(byte[] paramArrayOfByte, int paramInt, AVAppChannel.CsCmdCallback paramCsCmdCallback);
  
  public abstract boolean requestAppCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback);
  
  public abstract boolean requestCmd(String paramString, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback);
  
  public abstract boolean requestInfoCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback);
  
  public abstract boolean requestReportCmd(int paramInt, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback);
  
  public boolean tinyIdToIdentifier(long[] paramArrayOfLong, AVAppChannel.IdToIdCallback paramIdToIdCallback)
  {
    String[] arrayOfString = new String[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfString[i] = Long.toString(paramArrayOfLong[i]);
      i += 1;
    }
    paramIdToIdCallback.onSuccess(arrayOfString, paramArrayOfLong);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.channel.AVAppChannel
 * JD-Core Version:    0.7.0.1
 */