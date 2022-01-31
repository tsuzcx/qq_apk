import android.os.Bundle;
import com.tencent.intervideo.nowproxy.NowEntryData;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;

class arja
  extends CustomizedReport
{
  arja(arik paramarik) {}
  
  public void onNowEntry(Bundle paramBundle, NowEntryData paramNowEntryData) {}
  
  public void onReport(Bundle paramBundle)
  {
    arib localarib = arjj.a().a();
    if (localarib != null) {
      localarib.a(paramBundle);
    }
    if ((paramBundle != null) && ("weishi_service_num".equals(paramBundle.getString("id", "")))) {
      smn.a(arji.jdField_a_of_type_JavaLangString, "", "", arji.b, arji.jdField_a_of_type_Int, 4, 2, paramBundle.getInt("play_time"));
    }
  }
  
  public void setNowEntryData(NowEntryData paramNowEntryData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arja
 * JD-Core Version:    0.7.0.1
 */