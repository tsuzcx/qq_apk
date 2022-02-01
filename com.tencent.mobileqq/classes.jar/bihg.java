import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class bihg
  extends aser
{
  bihg(bihf parambihf) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject;
    String str;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.a.a.key))
    {
      localObject = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
    }
    for (;;)
    {
      try
      {
        if (TextUtils.equals((CharSequence)localObject, "ipc_video_isinstalled"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoApiPlugin", 2, "video remote response cmd=" + (String)localObject);
          }
          boolean bool = paramBundle.getBoolean("isInstalled");
          this.a.callJs(str, new String[] { String.valueOf(bool) });
          return;
        }
        if (!TextUtils.equals((CharSequence)localObject, "ipc_video_install_plugin")) {
          break label347;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoApiPlugin", 2, "video remote response cmd=" + (String)localObject);
        }
        int i = paramBundle.getInt("status");
        localObject = new JSONObject();
        ((JSONObject)localObject).put("status", i);
        switch (i)
        {
        case 3: 
          this.a.callJs(str, new String[] { ((JSONObject)localObject).toString() });
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      ((JSONObject)localObject).put("result", 0);
      ((JSONObject)localObject).put("progress", 100);
      ((JSONObject)localObject).put("msg", "install finished");
      continue;
      ((JSONObject)localObject).put("result", 1);
      ((JSONObject)localObject).put("progress", paramBundle.getFloat("progress"));
      ((JSONObject)localObject).put("msg", "install progress");
      continue;
      ((JSONObject)localObject).put("result", paramBundle.getInt("errCode"));
      ((JSONObject)localObject).put("progress", bihh.a);
      ((JSONObject)localObject).put("msg", "install failed");
      continue;
      label347:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bihg
 * JD-Core Version:    0.7.0.1
 */