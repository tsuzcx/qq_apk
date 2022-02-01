import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class amst
  implements EIPCResultCallback
{
  amst(amss paramamss) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("type");
    if (i == 1) {
      paramEIPCResult = paramEIPCResult.getString("nickName");
    }
    JSONObject localJSONObject;
    while (i != 2) {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("nickname", 1);
        localJSONObject.put("data", paramEIPCResult);
        localJSONObject.put("openId", this.a.jdField_a_of_type_JavaLangString);
        ApolloGameInterfaceProxy.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameInterfaceProxy, "cs.get_userInfo.local", "" + localJSONObject.toString() + "");
        return;
      }
      catch (Throwable paramEIPCResult)
      {
        QLog.e("ApolloGameInterfaceProxy", 1, paramEIPCResult, new Object[0]);
        return;
      }
    }
    paramEIPCResult = amta.a((Bitmap)paramEIPCResult.getParcelable("head"), 100);
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("avatar", 1);
      localJSONObject.put("data", paramEIPCResult);
      localJSONObject.put("openId", this.a.jdField_a_of_type_JavaLangString);
      ApolloGameInterfaceProxy.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameInterfaceProxy, "cs.get_userInfo.local", "" + localJSONObject.toString() + "");
      return;
    }
    catch (Throwable paramEIPCResult)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramEIPCResult, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amst
 * JD-Core Version:    0.7.0.1
 */