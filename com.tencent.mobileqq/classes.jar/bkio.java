import android.os.Bundle;
import mqq.observer.BusinessObserver;

class bkio
  implements BusinessObserver
{
  bkio(bkil parambkil, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("extra_result_code");
    String str = paramBundle.getString("extra_result_err_msg");
    paramBundle = paramBundle.getString("extra_cmd");
    if (!paramBoolean)
    {
      bfrz.a("WadlProxyServiceManager", "onReportDownloadEvent fail operId=" + this.jdField_a_of_type_JavaLangString + ",cmd=" + paramBundle + ",errCode=" + paramInt + ",errMsg=" + str);
      return;
    }
    bfrz.c("WadlProxyServiceManager", "onReportDownloadEvent success operId=" + this.jdField_a_of_type_JavaLangString + ",cmd=" + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkio
 * JD-Core Version:    0.7.0.1
 */