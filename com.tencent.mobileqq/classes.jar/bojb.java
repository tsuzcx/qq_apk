import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class bojb
  extends BroadcastReceiver
{
  public bojb(QIMMusicConfigManager paramQIMMusicConfigManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("kTribeSelectMusic"))) {
        break label43;
      }
    }
    for (;;)
    {
      return;
      label43:
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "onReceive:" + paramContext);
      }
      try
      {
        localJSONObject = new JSONObject(paramContext);
        int i = localJSONObject.optInt("id");
        paramContext = this.a.a(i);
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              boolean bool = localJSONObject.optBoolean("is_from_story", false);
              if (paramContext != null) {
                continue;
              }
              paramIntent = QIMMusicConfigManager.a(this.a, localJSONObject, bool);
              paramContext = paramIntent;
            }
            catch (JSONException paramIntent)
            {
              JSONObject localJSONObject;
              continue;
              continue;
            }
            try
            {
              paramContext.mSongMid = localJSONObject.optString("mid");
              if (QIMMusicConfigManager.a(this.a) == null) {
                break;
              }
              paramIntent = QIMMusicConfigManager.a(this.a).iterator();
              if (!paramIntent.hasNext()) {
                break;
              }
              ((bojc)paramIntent.next()).a(paramContext);
              continue;
              paramIntent = paramIntent;
              paramContext = null;
            }
            catch (JSONException paramIntent) {}
          }
          if (QLog.isColorLevel()) {
            QLog.e("QIMMusicConfigManager", 2, QLog.getStackTraceString(paramIntent));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojb
 * JD-Core Version:    0.7.0.1
 */