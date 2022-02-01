package com.tencent.aelight.camera.aeeditor.manage;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import java.io.File;
import mqq.os.MqqHandler;

class AEEditorEffectConfigManager$2
  implements Runnable
{
  AEEditorEffectConfigManager$2(AEEditorEffectConfigManager paramAEEditorEffectConfigManager) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(AEEditorEffectConfigManager.a())) {
      try
      {
        synchronized (AEEditorEffectConfigManager.a())
        {
          if (new File(AEEditorEffectConfigManager.a()).exists())
          {
            if (AEEditorEffectConfigManager.a(this.this$0) != null) {
              AEEditorEffectConfigManager.a(this.this$0).a(AEEditorEffectConfigManager.a());
            } else {
              AEQLog.d("AEEditorEffectConfigManager", "group list back is null.");
            }
          }
          else if (AEEditorEffectConfigManager.a(this.this$0) != null)
          {
            ((AEEditorEffectConfigProcessor)QConfigManager.a().a(643)).a();
            ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(AEEditorEffectConfigManager.a(this.this$0));
            ThreadManager.getSubThreadHandler().postAtTime(new AEEditorEffectConfigManager.2.1(this), AEEditorEffectConfigManager.a(this.this$0), SystemClock.uptimeMillis() + 5000L);
          }
          else
          {
            AEQLog.d("AEEditorEffectConfigManager", "group list back is null && data empty.");
          }
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        AEQLog.d("AEEditorEffectConfigManager", localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectConfigManager.2
 * JD-Core Version:    0.7.0.1
 */