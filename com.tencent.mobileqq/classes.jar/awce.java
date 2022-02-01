import android.os.Bundle;
import com.tencent.intervideo.nowproxy.NowEntryData;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;

class awce
  extends CustomizedReport
{
  awce(awcc paramawcc) {}
  
  public void onNowEntry(Bundle paramBundle, NowEntryData paramNowEntryData) {}
  
  public void onReport(Bundle paramBundle)
  {
    awbt localawbt = awde.a().a();
    if (localawbt != null) {
      localawbt.a(paramBundle);
    }
    if ((paramBundle != null) && ("weishi_service_num".equals(paramBundle.getString("id", "")))) {
      uno.a(awdd.jdField_a_of_type_JavaLangString, "", "", awdd.b, awdd.jdField_a_of_type_Int, 4, 2, paramBundle.getInt("play_time"));
    }
  }
  
  public void setNowEntryData(NowEntryData paramNowEntryData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awce
 * JD-Core Version:    0.7.0.1
 */