import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.List;
import org.json.JSONObject;

class bgyc
  implements AsyncResult
{
  bgyc(bgya parambgya, List paramList) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QMLog.d("MiniProgramReporter", "performDataReportViaSSO  onDcReport() called with: isSuc = [true], ret = [" + paramJSONObject + "]");
      return;
    }
    QMLog.e("MiniProgramReporter", "performDataReportViaSSO onDcReport: sso command failed, try again");
    this.jdField_a_of_type_Bgya.b(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgyc
 * JD-Core Version:    0.7.0.1
 */