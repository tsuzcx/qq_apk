import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class bddg
  implements AsyncResult
{
  bddg(bdde parambdde) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bdnw.d("AuthState", "updateUserSetting() onCmdListener isSuccess: " + paramBoolean + "   ; ret: " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bddg
 * JD-Core Version:    0.7.0.1
 */