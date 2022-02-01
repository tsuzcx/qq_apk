package com.tencent.aelight.camera.aioeditor.capture.music;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class QIMMusicConfigManager$3
  extends BroadcastReceiver
{
  QIMMusicConfigManager$3(QIMMusicConfigManager paramQIMMusicConfigManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      Object localObject = paramIntent.getStringExtra("data");
      paramContext = paramIntent.getStringExtra("event");
      if (!TextUtils.isEmpty(paramContext))
      {
        if (!paramContext.equals("kTribeSelectMusic")) {
          return;
        }
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("onReceive:");
          paramContext.append((String)localObject);
          QLog.d("QIMMusicConfigManager", 2, paramContext.toString());
        }
        paramIntent = null;
        paramContext = paramIntent;
        try
        {
          JSONObject localJSONObject = new JSONObject((String)localObject);
          paramContext = paramIntent;
          int i = localJSONObject.optInt("id");
          paramContext = paramIntent;
          localObject = this.a.a(i);
          paramContext = (Context)localObject;
          boolean bool = localJSONObject.optBoolean("is_from_story", false);
          paramIntent = (Intent)localObject;
          if (localObject == null)
          {
            paramContext = (Context)localObject;
            paramIntent = QIMMusicConfigManager.a(this.a, localJSONObject, bool);
          }
          paramContext = paramIntent;
          paramIntent.mSongMid = localJSONObject.optString("mid");
        }
        catch (JSONException localJSONException)
        {
          paramIntent = paramContext;
          if (QLog.isColorLevel())
          {
            QLog.e("QIMMusicConfigManager", 2, QLog.getStackTraceString(localJSONException));
            paramIntent = paramContext;
          }
        }
        if (QIMMusicConfigManager.a(this.a) != null)
        {
          paramContext = QIMMusicConfigManager.a(this.a).iterator();
          while (paramContext.hasNext()) {
            ((QIMMusicConfigManager.LoadMusicStepListener)paramContext.next()).a(paramIntent);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager.3
 * JD-Core Version:    0.7.0.1
 */