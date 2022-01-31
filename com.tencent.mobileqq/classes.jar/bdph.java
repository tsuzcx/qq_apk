import com.tencent.mobileqq.triton.sdk.APICallback;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import org.json.JSONObject;

class bdph
  implements bdql
{
  bdph(bdpe parambdpe, ChannelProxy paramChannelProxy, boolean paramBoolean, String paramString, APICallback paramAPICallback) {}
  
  public void a(boolean paramBoolean)
  {
    bdnw.b("APIProxyImpl", "onAuthorizeFinish " + paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyChannelProxy.getUserInfo(bdqa.a().a(), this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, new bdpi(this));
    }
    do
    {
      return;
      bdnw.b("APIProxyImpl", "user denied SCOPE_USER_INFO request");
    } while (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPICallback == null);
    Object localObject = bdgg.a("getUserInfo", null, "auth deny");
    if (localObject != null) {}
    for (localObject = ((JSONObject)localObject).toString();; localObject = "")
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPICallback.onCallback(false, (String)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdph
 * JD-Core Version:    0.7.0.1
 */