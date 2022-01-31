import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import java.util.List;
import org.json.JSONObject;

class bezh
  implements AsyncResult
{
  bezh(bezf parambezf, List paramList) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      betc.a("MiniProgramReporter", "performDataReportViaSSO  onDcReport() called with: isSuc = [true], ret = [" + paramJSONObject + "]");
      return;
    }
    betc.d("MiniProgramReporter", "performDataReportViaSSO onDcReport: sso command failed, try again");
    this.jdField_a_of_type_Bezf.b(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezh
 * JD-Core Version:    0.7.0.1
 */