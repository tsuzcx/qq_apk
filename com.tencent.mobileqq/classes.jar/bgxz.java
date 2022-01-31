import com.tencent.mobileqq.triton.sdk.APICallback;
import com.tencent.qqmini.sdk.core.plugins.QQFriendJsPlugin.IAddFriendCallBack;
import org.json.JSONObject;

class bgxz
  implements QQFriendJsPlugin.IAddFriendCallBack
{
  bgxz(bgxx parambgxx, APICallback paramAPICallback) {}
  
  public void onAddFriendCallBack(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPICallback != null) {
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (paramString1 = bgop.a(paramString1, null);; paramString1 = bgop.a(paramString1, null, paramString2))
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPICallback.onCallback(paramBoolean, paramString1.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxz
 * JD-Core Version:    0.7.0.1
 */