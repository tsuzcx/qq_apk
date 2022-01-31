import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bjsh
  extends bjts
{
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("qqexplive")) || (this.a == null)) {}
    while (TextUtils.isEmpty(paramString3)) {
      return false;
    }
    QLog.i("QZoneECLiveJsPlugin", 2, "ec_live_jsbridge, dispatch method callback linkchain, " + paramString3);
    try
    {
      paramJsBridgeListener = new Intent("com.tencent.mobileqq.action.ACTION_EC_LIVE_DISPATCH_EVENT");
      paramJsBridgeListener.putExtra("event", paramString3);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        if (paramString1 != null) {
          paramJsBridgeListener.putExtra("data", paramString1.toString());
        }
      }
      BaseApplicationImpl.getContext().sendBroadcast(paramJsBridgeListener, "com.tencent.msg.permission.pushnotify");
      return true;
    }
    catch (Throwable paramJsBridgeListener)
    {
      QLog.e("QZoneECLiveJsPlugin", 1, "qz_livevideo_jsbridge, dispatch method callback linkchain exception", paramJsBridgeListener);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjsh
 * JD-Core Version:    0.7.0.1
 */