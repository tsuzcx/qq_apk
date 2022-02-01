package com.tencent.TMG.channel;

import com.tencent.TIMManager;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.timint.TIMIntManager;
import java.util.ArrayList;

public class IMAppChannel
  extends AVAppChannel
{
  public int getServerEnvType()
  {
    return TIMManager.getInstance().getEnv();
  }
  
  public long getTinyId()
  {
    return TIMIntManager.getInstance().getTinyId();
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
    TIMIntManager.getInstance().userIdToTinyId(paramString1, new IMAppChannel.IdToIdCallbackImpl(this, paramIdToIdCallback));
    return true;
  }
  
  public boolean loginWithParam(AVContext.StartParam paramStartParam)
  {
    return false;
  }
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, int paramInt, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    return true;
  }
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    TIMIntManager.getInstance().requestMultiVideoApp(paramArrayOfByte, new IMAppChannel.CsCmdCallbackImpl(this, paramCsCmdCallback));
    return true;
  }
  
  public boolean requestCmd(String paramString, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    TIMIntManager.getInstance().request(paramString, paramArrayOfByte, new IMAppChannel.CsCmdCallbackImpl(this, paramCsCmdCallback));
    return true;
  }
  
  public boolean requestInfoCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    TIMIntManager.getInstance().requestMultiVideoInfo(paramArrayOfByte, new IMAppChannel.CsCmdCallbackImpl(this, paramCsCmdCallback));
    return true;
  }
  
  public boolean requestReportCmd(int paramInt, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    TIMIntManager.getInstance().requestQualityReport(paramInt, paramArrayOfByte, new IMAppChannel.ReportCallbackImpl(this, paramCsCmdCallback));
    return true;
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
    TIMIntManager.getInstance().tinyIdToUserId(localArrayList, new IMAppChannel.IdToIdCallbackImpl(this, paramIdToIdCallback));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.channel.IMAppChannel
 * JD-Core Version:    0.7.0.1
 */