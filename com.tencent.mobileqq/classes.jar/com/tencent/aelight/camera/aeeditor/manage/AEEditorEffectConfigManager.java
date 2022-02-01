package com.tencent.aelight.camera.aeeditor.manage;

import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.FILES;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;

public class AEEditorEffectConfigManager
{
  private static volatile AEEditorEffectConfigManager a;
  private static final byte[] c = new byte[0];
  private AEEditorEffectConfigManager.IEffectGroupListBack b;
  private Runnable d;
  
  private AEEditorEffectConfigManager()
  {
    AEQLog.b("AEEditorEffectConfigManager", "AEEditorEffectConfigManager init.");
  }
  
  public static AEEditorEffectConfigManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AEEditorEffectConfigManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.FILES.c);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("effect_group_list.json");
    return localStringBuilder.toString();
  }
  
  private void d()
  {
    this.d = new AEEditorEffectConfigManager.2(this);
    ThreadManager.getFileThreadHandler().post(this.d);
  }
  
  public void a(AEEditorEffectConfigManager.IEffectGroupListBack paramIEffectGroupListBack)
  {
    this.b = paramIEffectGroupListBack;
    d();
  }
  
  public void a(AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean)
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorEffectConfigManager.1(this, paramAEEditorEffectGroupListBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectConfigManager
 * JD-Core Version:    0.7.0.1
 */