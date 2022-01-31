package com.tencent.TMG.channel;

import com.tencent.TIMCallBack;
import com.tencent.TIMManager;
import com.tencent.TIMUser;
import com.tencent.TIMValueCallBack;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.timint.TIMIntManager;
import java.util.ArrayList;
import java.util.List;

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
    TIMIntManager.getInstance().userIdToTinyId(paramString1, new IdToIdCallbackImpl(paramIdToIdCallback));
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
    TIMIntManager.getInstance().requestMultiVideoApp(paramArrayOfByte, new CsCmdCallbackImpl(paramCsCmdCallback));
    return true;
  }
  
  public boolean requestCmd(String paramString, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    TIMIntManager.getInstance().request(paramString, paramArrayOfByte, new CsCmdCallbackImpl(paramCsCmdCallback));
    return true;
  }
  
  public boolean requestInfoCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    TIMIntManager.getInstance().requestMultiVideoInfo(paramArrayOfByte, new CsCmdCallbackImpl(paramCsCmdCallback));
    return true;
  }
  
  public boolean requestReportCmd(int paramInt, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    TIMIntManager.getInstance().requestQualityReport(paramInt, paramArrayOfByte, new ReportCallbackImpl(paramCsCmdCallback));
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
    TIMIntManager.getInstance().tinyIdToUserId(localArrayList, new IdToIdCallbackImpl(paramIdToIdCallback));
    return true;
  }
  
  public class CsCmdCallbackImpl
    implements TIMValueCallBack<byte[]>
  {
    private AVAppChannel.CsCmdCallback mCallback;
    
    public CsCmdCallbackImpl(AVAppChannel.CsCmdCallback paramCsCmdCallback)
    {
      this.mCallback = paramCsCmdCallback;
    }
    
    public void onError(int paramInt, String paramString)
    {
      if (this.mCallback != null)
      {
        this.mCallback.onError(paramInt, paramString);
        this.mCallback = null;
      }
    }
    
    public void onSuccess(byte[] paramArrayOfByte)
    {
      if (this.mCallback != null)
      {
        this.mCallback.onSuccess(paramArrayOfByte);
        this.mCallback = null;
      }
    }
  }
  
  public class IdToIdCallbackImpl
    implements TIMValueCallBack<List<TIMUser>>
  {
    private AVAppChannel.IdToIdCallback mCallback;
    
    public IdToIdCallbackImpl(AVAppChannel.IdToIdCallback paramIdToIdCallback)
    {
      this.mCallback = paramIdToIdCallback;
    }
    
    public void onError(int paramInt, String paramString)
    {
      if (this.mCallback != null)
      {
        this.mCallback.onError(paramInt, paramString);
        this.mCallback = null;
      }
    }
    
    public void onSuccess(List<TIMUser> paramList)
    {
      if (this.mCallback != null)
      {
        int j = paramList.size();
        String[] arrayOfString = new String[j];
        long[] arrayOfLong = new long[j];
        int i = 0;
        while (i < j)
        {
          TIMUser localTIMUser = (TIMUser)paramList.get(i);
          arrayOfString[i] = localTIMUser.getIdentifier();
          arrayOfLong[i] = localTIMUser.getTinyId();
          i += 1;
        }
        this.mCallback.onSuccess(arrayOfString, arrayOfLong);
        this.mCallback = null;
      }
    }
  }
  
  public class ReportCallbackImpl
    implements TIMCallBack
  {
    private AVAppChannel.CsCmdCallback mCallback;
    
    public ReportCallbackImpl(AVAppChannel.CsCmdCallback paramCsCmdCallback)
    {
      this.mCallback = paramCsCmdCallback;
    }
    
    public void onError(int paramInt, String paramString)
    {
      if (this.mCallback != null)
      {
        this.mCallback.onError(paramInt, paramString);
        this.mCallback = null;
      }
    }
    
    public void onSuccess()
    {
      if (this.mCallback != null)
      {
        this.mCallback.onSuccess(null);
        this.mCallback = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.channel.IMAppChannel
 * JD-Core Version:    0.7.0.1
 */