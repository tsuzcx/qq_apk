import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bece
  implements MiniMsgUser.IMiniMsgActionCallback
{
  public bece(WebViewFragment paramWebViewFragment) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", paramString);
      localJSONObject.put("options", paramJSONObject);
      paramString = "javascript:mqq.dispatchEvent(\"miniAIOEvent\"," + localJSONObject.toString() + ");";
      this.a.jdField_a_of_type_ComTencentBizUiTouchWebView.callJs(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("WebLog_WebViewFragment", 1, paramString, new Object[0]);
    }
  }
  
  public void onFromMiniAIOToAIO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onFromMiniAIOToAIO ");
    }
    a("fromMiniAIOToAIO", new JSONObject());
  }
  
  public void onGoToConversation()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "onGoToConversation ");
      }
      a("returnMsgList", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      QLog.d("WebLog_WebViewFragment", 1, localException, new Object[0]);
    }
  }
  
  public void onOpenMiniAIOCallback()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser == null) {
      return;
    }
    WebViewFragment localWebViewFragment = this.a;
    Object localObject1 = localWebViewFragment.q;
    if (TextUtils.isEmpty(localWebViewFragment.q)) {
      localObject1 = localWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.getTitle();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!"‎".equals(localObject1)) {}
    }
    else
    {
      localObject2 = alpo.a(2131717276);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("banner_wording", (String)localObject2);
    Object localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam();
    ((MiniMsgUserParam)localObject2).backConversationIntent = localWebViewFragment.a((Bundle)localObject1);
    befr.a(((MiniMsgUserParam)localObject2).backConversationIntent);
    try
    {
      a("entryClicked", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      QLog.d("WebLog_WebViewFragment", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bece
 * JD-Core Version:    0.7.0.1
 */