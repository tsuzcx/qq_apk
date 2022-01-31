import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

final class beti
  implements AsyncResult
{
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    besl.a("GameGrowthGuardianManager", "onReceived() called with: success = [" + paramBoolean + "], stReportExecuteRsp = [" + paramJSONObject + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beti
 * JD-Core Version:    0.7.0.1
 */