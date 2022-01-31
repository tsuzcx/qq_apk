import com.tencent.mobileqq.triton.sdk.APICallback;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class bdpi
  implements AsyncResult
{
  bdpi(bdph parambdph) {}
  
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
      if (this.a.a != null) {
        this.a.a.onCallback(paramBoolean, paramJSONObject);
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
 * Qualified Name:     bdpi
 * JD-Core Version:    0.7.0.1
 */