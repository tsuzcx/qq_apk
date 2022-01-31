import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager.LoadMusicStepListener;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class amvs
  extends BroadcastReceiver
{
  public amvs(QIMMusicConfigManager paramQIMMusicConfigManager) {}
  
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
        if (paramContext != null) {}
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              paramIntent = new MusicItemInfo();
            }
            catch (JSONException paramIntent)
            {
              JSONObject localJSONObject;
              continue;
            }
            try
            {
              paramIntent.d = 5;
              paramIntent.jdField_a_of_type_JavaLangString = localJSONObject.optString("title");
              paramIntent.b = localJSONObject.optString("desc");
              paramIntent.jdField_a_of_type_Int = localJSONObject.optInt("id");
              paramIntent.e = localJSONObject.optString("mid");
              paramContext = paramIntent;
            }
            catch (JSONException localJSONException)
            {
              paramContext = paramIntent;
              paramIntent = localJSONException;
              continue;
            }
            try
            {
              paramContext.e = localJSONObject.optString("mid");
              if (QIMMusicConfigManager.a(this.a) == null) {
                break;
              }
              paramIntent = QIMMusicConfigManager.a(this.a).iterator();
              if (!paramIntent.hasNext()) {
                break;
              }
              ((QIMMusicConfigManager.LoadMusicStepListener)paramIntent.next()).a(paramContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amvs
 * JD-Core Version:    0.7.0.1
 */