package com.tencent.ark.open;

import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import java.util.HashMap;
import java.util.Locale;

class ArkAppMgr$16
  implements ArkAppMgr.IUpdateAppByNameCallback
{
  ArkAppMgr$16(ArkAppMgr paramArkAppMgr) {}
  
  public void onUpdateAppByName(ArkAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask, Object arg2)
  {
    for (;;)
    {
      synchronized (ArkAppMgr.access$400(this.this$0))
      {
        ArkAppMgr.access$400(this.this$0).remove(paramUpdateAppByNameTask.appName);
        if ((paramUpdateAppByNameTask.result == 1) || (paramUpdateAppByNameTask.result == 2))
        {
          String str = "";
          ??? = str;
          if (paramUpdateAppByNameTask.appPathInfo != null)
          {
            ??? = str;
            if (paramUpdateAppByNameTask.appPathInfo.desc != null)
            {
              ??? = str;
              if (!TextUtils.isEmpty(paramUpdateAppByNameTask.appPathInfo.desc.version)) {
                ??? = paramUpdateAppByNameTask.appPathInfo.desc.version;
              }
            }
          }
          if (paramUpdateAppByNameTask.downloadInfo == null) {
            break label204;
          }
          i = paramUpdateAppByNameTask.downloadInfo.updatePeriodByMinutes;
          ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", String.format(Locale.CHINA, "ArkTemp.runUpdateLocalAppTask, updateAppByName success, result=%s, app-name=%s, app-version=%s, update-period=%d", new Object[] { ArkAppMgr.UpdateAppByNameTask.Result.toString(paramUpdateAppByNameTask.result), paramUpdateAppByNameTask.appName, ???, Integer.valueOf(i) }));
          return;
        }
      }
      ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", String.format("ArkTemp.runUpdateLocalAppTask, updateAppByName fail, result=%s, app-name=%s", new Object[] { ArkAppMgr.UpdateAppByNameTask.Result.toString(paramUpdateAppByNameTask.result), paramUpdateAppByNameTask.appName }));
      return;
      label204:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.16
 * JD-Core Version:    0.7.0.1
 */