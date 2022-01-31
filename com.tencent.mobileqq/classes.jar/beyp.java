import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import java.util.List;
import org.json.JSONObject;

class beyp
  implements AsyncResult
{
  beyp(beyo parambeyo, List paramList) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      besl.a("MiniProgramReporter", "onDcReport() called with: isSuc = [true], ret = [" + paramJSONObject + "]");
      return;
    }
    besl.d("MiniProgramReporter", "performReportViaSSO onDcReport: sso command failed, try again");
    this.jdField_a_of_type_Beyo.a(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beyp
 * JD-Core Version:    0.7.0.1
 */