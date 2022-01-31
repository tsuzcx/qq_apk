import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import java.util.List;
import org.json.JSONObject;

class bdst
  implements AsyncResult
{
  bdst(bdsr parambdsr, List paramList) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      bdnw.a("MiniProgramReporter", "performDataReportViaSSO  onDcReport() called with: isSuc = [true], ret = [" + paramJSONObject + "]");
      return;
    }
    bdnw.d("MiniProgramReporter", "performDataReportViaSSO onDcReport: sso command failed, try again");
    this.jdField_a_of_type_Bdsr.b(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdst
 * JD-Core Version:    0.7.0.1
 */