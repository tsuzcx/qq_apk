import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

final class bgsg
  implements AsyncResult
{
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("GameGrowthGuardianManager", "onReceived() called with: success = [" + paramBoolean + "], stReportExecuteRsp = [" + paramJSONObject + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsg
 * JD-Core Version:    0.7.0.1
 */