package com.tencent.aelight.camera.aioeditor.editipc;

import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class PeakIpcModuleClient
  extends QIPCModule
{
  public static boolean a = false;
  private static PeakIpcModuleClient d;
  private boolean b = false;
  private String c;
  
  private PeakIpcModuleClient()
  {
    super("PeakIpcModuleClient");
    c();
  }
  
  public static PeakIpcModuleClient a()
  {
    try
    {
      if (d == null) {
        try
        {
          if (d == null) {
            d = new PeakIpcModuleClient();
          }
        }
        finally {}
      }
      PeakIpcModuleClient localPeakIpcModuleClient = d;
      return localPeakIpcModuleClient;
    }
    finally {}
  }
  
  public static void b()
  {
    PeakIpcModuleClient localPeakIpcModuleClient = a();
    if (!a)
    {
      QIPCClientHelper.getInstance().register(localPeakIpcModuleClient);
      a = true;
    }
  }
  
  private void c()
  {
    QIPCClientHelper.getInstance().getClient().connect(new PeakIpcModuleClient.1(this));
    QIPCClientHelper.getInstance().getClient().addListener(new PeakIpcModuleClient.2(this));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (("action_update_status".equals(paramString)) && (paramBundle != null))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramInt = paramBundle.getInt("key_status");
      int i = paramBundle.getInt("key_progress");
      paramString = paramBundle.getString("uin");
      int j = paramBundle.getInt("uintype");
      paramBundle.getString("key_file_md5");
      long l = paramBundle.getLong("key_uinsequence");
      SendPanelManager.a().a(paramString, j, paramInt, i, l);
      localBundle.putBoolean("key_result", false);
    }
    return EIPCResult.createSuccessResult(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleClient
 * JD-Core Version:    0.7.0.1
 */