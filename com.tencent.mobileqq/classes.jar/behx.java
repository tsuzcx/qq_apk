import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class behx
  implements AsyncResult
{
  behx(behw parambehw) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    betc.d("AuthState", "setAuthorize() onCmdListener isSuccess: " + paramBoolean + "   ; ret: " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     behx
 * JD-Core Version:    0.7.0.1
 */