import com.tencent.mobileqq.triton.sdk.APICallback;
import com.tencent.qqmini.sdk.core.plugins.QQFriendJsPlugin.IAddFriendCallBack;
import org.json.JSONObject;

class beuo
  implements QQFriendJsPlugin.IAddFriendCallBack
{
  beuo(beum parambeum, APICallback paramAPICallback) {}
  
  public void onAddFriendCallBack(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPICallback != null) {
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (paramString1 = bekg.a(paramString1, null);; paramString1 = bekg.a(paramString1, null, paramString2))
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPICallback.onCallback(paramBoolean, paramString1.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beuo
 * JD-Core Version:    0.7.0.1
 */