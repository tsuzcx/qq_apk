import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class atic
  implements nbg
{
  atic(atib paramatib) {}
  
  public void a(Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(this.a.a))
    {
      paramBundle = paramBundle.getString("info");
      localJSONObject = new JSONObject();
    }
    while (!QLog.isColorLevel()) {
      try
      {
        JSONObject localJSONObject;
        localJSONObject.put("data", paramBundle);
        this.a.callJs(this.a.a, new String[] { localJSONObject.toString() });
        if (QLog.isColorLevel()) {
          QLog.d("PushApiPlugin", 2, new Object[] { "handleJsRequest callback:", paramBundle });
        }
        return;
      }
      catch (Throwable paramBundle)
      {
        QLog.e("PushApiPlugin", 1, paramBundle, new Object[0]);
        return;
      }
    }
    QLog.d("PushApiPlugin", 2, "handleJsRequest callback is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atic
 * JD-Core Version:    0.7.0.1
 */