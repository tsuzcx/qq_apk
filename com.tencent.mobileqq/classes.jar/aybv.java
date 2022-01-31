import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aybv
  extends WebViewPlugin
{
  public aybv()
  {
    this.mPluginNameSpace = "historicalSig";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (paramString2.equalsIgnoreCase("historicalSig"))
    {
      paramString1 = this.mRuntime.a().getAccount();
      paramJsBridgeListener = this.mRuntime.a();
      if (paramString3.equalsIgnoreCase("historicalSiglist")) {}
      do
      {
        do
        {
          do
          {
            try
            {
              paramString2 = new JSONObject(paramVarArgs[0]);
              paramString1 = paramString2.optString("fromType");
              paramString2 = paramString2.optString("fromUin");
              if (ChatActivityUtils.a(paramString2))
              {
                paramString3 = new Intent(paramJsBridgeListener, PublicFragmentActivity.class);
                paramString3.putExtra("key_uin", paramString2);
                if (paramString1.equalsIgnoreCase("1"))
                {
                  paramString3.putExtra("key_open_via", "history-msglist");
                  paramJsBridgeListener.finish();
                }
                adpn.a(paramJsBridgeListener, paramString3, PublicFragmentActivity.class, SignatureHistoryFragment.class);
              }
              QLog.d("JumpProfilePlugin", 1, new Object[] { "historicalSiglist", "fromType=", paramString1, " fromUin", bdnn.e(paramString2) });
            }
            catch (JSONException paramJsBridgeListener)
            {
              while (!QLog.isColorLevel()) {}
              QLog.i("JumpProfilePlugin", 2, paramJsBridgeListener.getMessage(), paramJsBridgeListener);
              return true;
            }
            return true;
            if (!paramString3.equalsIgnoreCase("personalTagList")) {
              break;
            }
            try
            {
              paramString2 = new JSONObject(paramVarArgs[0]);
              paramString1 = paramString2.optString("fromType");
              paramString2 = paramString2.optString("fromUin");
              if (ChatActivityUtils.a(paramString2))
              {
                paramString3 = new Intent(this.mRuntime.a(), PersonalityLabelGalleryActivity.class);
                paramString3.putExtra("uin", paramString2);
                if (paramString1.equalsIgnoreCase("1")) {
                  paramString3.putExtra("fromType", 4);
                }
                paramJsBridgeListener.startActivity(paramString3);
                paramJsBridgeListener.finish();
              }
              QLog.d("JumpProfilePlugin", 1, new Object[] { "personalTagList", "fromType=", paramString1, " fromUin", bdnn.e(paramString2) });
              return true;
            }
            catch (JSONException paramJsBridgeListener) {}
          } while (!QLog.isColorLevel());
          QLog.i("JumpProfilePlugin", 2, paramJsBridgeListener.getMessage(), paramJsBridgeListener);
          return true;
        } while (!paramString3.equalsIgnoreCase("zanlist"));
        try
        {
          paramString3 = new JSONObject(paramVarArgs[0]);
          paramString2 = paramString3.optString("fromType");
          paramString3 = paramString3.optString("fromUin");
          if ((ChatActivityUtils.a(paramString3)) && (paramString3.equalsIgnoreCase(paramString1)))
          {
            paramString1 = new Intent(paramJsBridgeListener, VisitorsActivity.class);
            paramString1.putExtra("toUin", Long.valueOf(paramString3));
            paramString1.putExtra("extra_show_rank", true);
            if (paramString2.equalsIgnoreCase("1")) {
              paramString1.putExtra("extra_from", 2);
            }
            paramJsBridgeListener.startActivity(paramString1);
            paramJsBridgeListener.finish();
          }
          QLog.d("JumpProfilePlugin", 1, new Object[] { "zanlist", "fromType=", paramString2, " fromUin", bdnn.e(paramString3) });
          return true;
        }
        catch (JSONException paramJsBridgeListener) {}
      } while (!QLog.isColorLevel());
      QLog.i("JumpProfilePlugin", 2, paramJsBridgeListener.getMessage(), paramJsBridgeListener);
      return true;
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybv
 * JD-Core Version:    0.7.0.1
 */