package com.tencent.aelight.camera.aeeditor.manage;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class AEEditorEffectIpcModule
  extends QIPCModule
{
  private static boolean a = false;
  private static volatile AEEditorEffectIpcModule b;
  
  private AEEditorEffectIpcModule()
  {
    super("AEEditorEffectIpcModule");
  }
  
  public static AEEditorEffectIpcModule a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new AEEditorEffectIpcModule();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static void b()
  {
    if (!a)
    {
      a = true;
      QIPCClientHelper.getInstance().getClient().registerModule(a());
    }
  }
  
  public static void c()
  {
    if (a)
    {
      a = false;
      QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_get_effect_list".equals(paramString)) {
      AEEditorEffectConfigManager.a().a(new AEEditorEffectIpcModule.1(this, paramInt));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectIpcModule
 * JD-Core Version:    0.7.0.1
 */