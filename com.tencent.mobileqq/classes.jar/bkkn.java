import android.text.TextUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class bkkn
  extends BaseJsPlugin
{
  @JsEvent({"getCMShowInfo"})
  public void getCMShowInfo(RequestEvent paramRequestEvent)
  {
    if (paramRequestEvent == null)
    {
      QLog.e("CMShowJsPlugin", 1, "[getCMShowInfo] error! req is null!");
      return;
    }
    String str2;
    try
    {
      String str1 = getMiniAppInfo().appId;
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      str2 = ((JSONObject)localObject).getString("openid");
      if (TextUtils.isEmpty(str2))
      {
        paramRequestEvent.fail("invalid params!");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CMShowJsPlugin", 1, new Object[] { Integer.valueOf(1), "[getCMShowInfo] error! ", localThrowable });
      paramRequestEvent.fail("invalid params!");
      return;
    }
    String str3 = ((JSONObject)localObject).getString("engineType");
    if ((!"laya".equals(str3)) && (!"egret".equals(str3)) && (!"cocos".equals(str3)))
    {
      paramRequestEvent.fail("invalid params!");
      return;
    }
    String str4 = ((JSONObject)localObject).getString("engineVersion");
    Object localObject = ((JSONObject)localObject).optString("avatarType", "3D");
    if ((!"2D".equals(localObject)) && (!"3D".equals(localObject)))
    {
      paramRequestEvent.fail("invalid params!");
      return;
    }
    MiniAppCmdUtil.getInstance().getCMShowInfo(str2, localThrowable, str3, str4, (String)localObject, new bkkp(this, paramRequestEvent));
  }
  
  @JsEvent({"setCMShowPetStatus"})
  public void setCMShowPetStatus(RequestEvent paramRequestEvent)
  {
    if (paramRequestEvent == null)
    {
      QLog.e("CMShowJsPlugin", 1, "[setCMShowPetStatus] error! req is null!");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("data");
      int i = localJSONObject.optInt("roleId");
      int j = localJSONObject.optInt("petStatus");
      MiniAppCmdUtil.getInstance().setCMShowPetStatus(i, j, new bkko(this, paramRequestEvent));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CMShowJsPlugin", 1, new Object[] { Integer.valueOf(1), "[setCMShowPetStatus] error! ", localThrowable });
      paramRequestEvent.fail("invalid params!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkn
 * JD-Core Version:    0.7.0.1
 */