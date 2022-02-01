import android.os.Bundle;
import com.tencent.intervideo.nowproxy.NowEntryData;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;

class avuz
  extends CustomizedReport
{
  avuz(avux paramavux) {}
  
  public void onNowEntry(Bundle paramBundle, NowEntryData paramNowEntryData) {}
  
  public void onReport(Bundle paramBundle)
  {
    avuo localavuo = avvz.a().a();
    if (localavuo != null) {
      localavuo.a(paramBundle);
    }
    if ((paramBundle != null) && ("weishi_service_num".equals(paramBundle.getString("id", "")))) {
      vjx.a(avvy.jdField_a_of_type_JavaLangString, "", "", avvy.b, avvy.jdField_a_of_type_Int, 4, 2, paramBundle.getInt("play_time"));
    }
  }
  
  public void setNowEntryData(NowEntryData paramNowEntryData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avuz
 * JD-Core Version:    0.7.0.1
 */