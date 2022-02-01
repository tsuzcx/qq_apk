package com.tencent.mm.hardcoder;

import android.os.Bundle;
import android.os.Process;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class HardCoderManager$HardCoderIPCModule
  extends QIPCModule
{
  public static final String NAME = "HardCoderModule";
  private static HardCoderIPCModule sInstance;
  
  public HardCoderManager$HardCoderIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static HardCoderIPCModule getInstance()
  {
    if (sInstance == null) {
      try
      {
        sInstance = new HardCoderIPCModule("HardCoderModule");
      }
      finally {}
    }
    return sInstance;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall action = ");
      localStringBuilder.append(paramString);
      QLog.d("HardCoder.QQManager", 2, localStringBuilder.toString());
    }
    if (paramString.equals("start"))
    {
      paramInt = paramBundle.getInt("key_delay");
      int i = paramBundle.getInt("key_cpu");
      int j = paramBundle.getInt("key_io");
      int k = paramBundle.getInt("key_bind");
      int m = paramBundle.getInt("key_timeout");
      int n = paramBundle.getInt("key_scene");
      long l = paramBundle.getLong("key_action");
      paramString = paramBundle.getString("key_tag");
      return EIPCResult.createResult(HCPerfManager.getInstance().start(paramInt, i, j, k, m, n, l, Process.myTid(), paramString), null);
    }
    if (paramString.equals("stop"))
    {
      paramInt = paramBundle.getInt("key_code");
      HCPerfManager.getInstance().stop(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderManager.HardCoderIPCModule
 * JD-Core Version:    0.7.0.1
 */