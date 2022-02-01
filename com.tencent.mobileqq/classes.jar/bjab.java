import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

public class bjab
  extends BaseJsPlugin
{
  @JsEvent({"sendMsg"})
  public void sendMsg(RequestEvent paramRequestEvent)
  {
    QLog.d("SmsPlugin", 1, "start sendMsg");
    if (this.mContext == null)
    {
      QLog.d("SmsPlugin", 1, "sendMsg, but mContext is null");
      return;
    }
    String str4 = paramRequestEvent.jsonParams;
    String str2 = "";
    String str3 = "";
    paramRequestEvent = str3;
    String str1 = str2;
    try
    {
      Object localObject = new JSONObject(str4).optJSONObject("data");
      paramRequestEvent = str3;
      str1 = str2;
      str2 = ((JSONObject)localObject).optString("to", "");
      paramRequestEvent = str3;
      str1 = str2;
      str3 = ((JSONObject)localObject).optString("text", "");
      paramRequestEvent = str3;
      str1 = str2;
      localObject = new Intent("android.intent.action.VIEW");
      paramRequestEvent = str3;
      str1 = str2;
      ((Intent)localObject).setData(Uri.parse("smsto:"));
      paramRequestEvent = str3;
      str1 = str2;
      ((Intent)localObject).setType("vnd.android-dir/mms-sms");
      paramRequestEvent = str3;
      str1 = str2;
      ((Intent)localObject).putExtra("address", str2);
      paramRequestEvent = str3;
      str1 = str2;
      ((Intent)localObject).putExtra("sms_body", str3);
      paramRequestEvent = str3;
      str1 = str2;
      this.mContext.startActivity((Intent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SmsPlugin", 1, new Object[] { "sendSms exception : ", localException.getMessage(), "jsonParams : ", str4 });
      Intent localIntent = new Intent("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse("smsto:" + str1));
      localIntent.putExtra("sms_body", paramRequestEvent);
      this.mContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjab
 * JD-Core Version:    0.7.0.1
 */