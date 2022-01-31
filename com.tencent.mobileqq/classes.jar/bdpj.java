import com.tencent.mobileqq.triton.sdk.APICallback;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class bdpj
  implements AsyncResult
{
  bdpj(bdpe parambdpe, APICallback paramAPICallback) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = bdgg.a("getUserInfo", paramJSONObject);
      if (paramJSONObject != null) {
        paramJSONObject = paramJSONObject.toString();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPICallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPICallback.onCallback(paramBoolean, paramJSONObject);
      }
      return;
      paramJSONObject = "";
      continue;
      paramJSONObject = bdgg.a("getUserInfo", paramJSONObject, null);
      if (paramJSONObject != null) {
        paramJSONObject = paramJSONObject.toString();
      } else {
        paramJSONObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdpj
 * JD-Core Version:    0.7.0.1
 */