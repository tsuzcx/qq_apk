import android.os.Bundle;
import com.tencent.intervideo.nowproxy.NowEntryData;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;

class aqot
  extends CustomizedReport
{
  aqot(aqod paramaqod) {}
  
  public void onNowEntry(Bundle paramBundle, NowEntryData paramNowEntryData) {}
  
  public void onReport(Bundle paramBundle)
  {
    aqnu localaqnu = aqpc.a().a();
    if (localaqnu != null) {
      localaqnu.a(paramBundle);
    }
    if ((paramBundle != null) && ("weishi_service_num".equals(paramBundle.getString("id", "")))) {
      rzu.a(aqpb.jdField_a_of_type_JavaLangString, "", "", aqpb.b, aqpb.jdField_a_of_type_Int, 4, 2, paramBundle.getInt("play_time"));
    }
  }
  
  public void setNowEntryData(NowEntryData paramNowEntryData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqot
 * JD-Core Version:    0.7.0.1
 */