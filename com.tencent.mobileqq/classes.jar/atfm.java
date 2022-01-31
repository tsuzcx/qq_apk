import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class atfm
  implements MiniMsgUser.IMiniMsgActionCallback
{
  public atfm(UiApiPlugin paramUiApiPlugin) {}
  
  public void onFromMiniAIOToAIO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "onFromMiniAIOToAIO ");
    }
    JSONObject localJSONObject = new JSONObject();
    this.a.a("fromMiniAIOToAIO", localJSONObject);
  }
  
  public void onGoToConversation()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "onGoToConversation ");
      }
      JSONObject localJSONObject = new JSONObject();
      this.a.a("returnMsgList", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("UiApiPlugin", 1, localException, new Object[0]);
    }
  }
  
  public void onOpenMiniAIOCallback()
  {
    WebViewFragment localWebViewFragment = this.a.mRuntime.a();
    Object localObject1 = localWebViewFragment.q;
    if (TextUtils.isEmpty(localWebViewFragment.q)) {
      localObject1 = localWebViewFragment.a.getTitle();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!"‎".equals(localObject1)) {}
    }
    else
    {
      localObject2 = alpo.a(2131716227);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("banner_wording", (String)localObject2);
    Object localObject2 = this.a.a.getParam();
    ((MiniMsgUserParam)localObject2).backConversationIntent = localWebViewFragment.a((Bundle)localObject1);
    befr.a(((MiniMsgUserParam)localObject2).backConversationIntent);
    try
    {
      localObject1 = new JSONObject();
      this.a.a("entryClicked", (JSONObject)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("UiApiPlugin", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfm
 * JD-Core Version:    0.7.0.1
 */