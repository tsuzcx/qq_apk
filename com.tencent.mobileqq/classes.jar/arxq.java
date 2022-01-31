import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class arxq
  implements aruz
{
  arxq(arxj paramarxj, LocationRoom.Venue paramVenue) {}
  
  public Pair<arum, LocationRoom.Venue> a()
  {
    return new Pair(arxj.a(this.jdField_a_of_type_Arxj), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(arum paramarum, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] removeVenue: onResult. roomKey: " + paramarum + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramarum.equals(arxj.a(this.jdField_a_of_type_Arxj))) || (arxj.a(this.jdField_a_of_type_Arxj).a() == null) || (paramVenue == null) || (!arxj.a(this.jdField_a_of_type_Arxj).a().equals(paramVenue))) {
      return;
    }
    arxj.a(this.jdField_a_of_type_Arxj).setVenueOprating(false);
    arxj.a(this.jdField_a_of_type_Arxj).setVisibility(8);
    if (paramBoolean)
    {
      arxj.a(this.jdField_a_of_type_Arxj).setVenue(null);
      arxj.b(this.jdField_a_of_type_Arxj);
      axqy.b(null, "CliOper", "", "", "0X800A969", "0X800A969", 0, 0, "0", "0", "0", "");
      return;
    }
    bcql.a(arxj.a(this.jdField_a_of_type_Arxj), 1, "移除失败，请稍后重试", 0).a();
    if ((paramInt2 == 10001) || (paramInt2 == 10003) || (paramInt2 == 10004) || (paramInt2 == 10100))
    {
      axqy.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 2, 0, "0", "0", "0", "");
      return;
    }
    axqy.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxq
 * JD-Core Version:    0.7.0.1
 */