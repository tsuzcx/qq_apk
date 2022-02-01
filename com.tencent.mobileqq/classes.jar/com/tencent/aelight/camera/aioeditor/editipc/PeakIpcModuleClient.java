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
  private static PeakIpcModuleClient jdField_a_of_type_ComTencentAelightCameraAioeditorEditipcPeakIpcModuleClient;
  public static boolean a = false;
  private String jdField_a_of_type_JavaLangString;
  private boolean b = false;
  
  private PeakIpcModuleClient()
  {
    super("PeakIpcModuleClient");
    b();
  }
  
  public static PeakIpcModuleClient a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentAelightCameraAioeditorEditipcPeakIpcModuleClient == null) {
        try
        {
          if (jdField_a_of_type_ComTencentAelightCameraAioeditorEditipcPeakIpcModuleClient == null) {
            jdField_a_of_type_ComTencentAelightCameraAioeditorEditipcPeakIpcModuleClient = new PeakIpcModuleClient();
          }
        }
        finally {}
      }
      PeakIpcModuleClient localPeakIpcModuleClient = jdField_a_of_type_ComTencentAelightCameraAioeditorEditipcPeakIpcModuleClient;
      return localPeakIpcModuleClient;
    }
    finally {}
  }
  
  public static void a()
  {
    PeakIpcModuleClient localPeakIpcModuleClient = a();
    if (!jdField_a_of_type_Boolean)
    {
      QIPCClientHelper.getInstance().register(localPeakIpcModuleClient);
      jdField_a_of_type_Boolean = true;
    }
  }
  
  private void b()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleClient
 * JD-Core Version:    0.7.0.1
 */