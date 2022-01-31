import android.os.Bundle;
import com.tencent.intervideo.nowproxy.NowEntryData;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;

class aszo
  extends CustomizedReport
{
  aszo(asyy paramasyy) {}
  
  public void onNowEntry(Bundle paramBundle, NowEntryData paramNowEntryData) {}
  
  public void onReport(Bundle paramBundle)
  {
    asyp localasyp = aszx.a().a();
    if (localasyp != null) {
      localasyp.a(paramBundle);
    }
    if ((paramBundle != null) && ("weishi_service_num".equals(paramBundle.getString("id", "")))) {
      tjr.a(aszw.jdField_a_of_type_JavaLangString, "", "", aszw.b, aszw.jdField_a_of_type_Int, 4, 2, paramBundle.getInt("play_time"));
    }
  }
  
  public void setNowEntryData(NowEntryData paramNowEntryData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszo
 * JD-Core Version:    0.7.0.1
 */