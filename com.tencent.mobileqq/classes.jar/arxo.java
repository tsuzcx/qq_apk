import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class arxo
  implements arux
{
  arxo(arxh paramarxh, LocationRoom.Venue paramVenue) {}
  
  public Pair<aruk, LocationRoom.Venue> a()
  {
    return new Pair(arxh.a(this.jdField_a_of_type_Arxh), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(aruk paramaruk, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] removeVenue: onResult. roomKey: " + paramaruk + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramaruk.equals(arxh.a(this.jdField_a_of_type_Arxh))) || (arxh.a(this.jdField_a_of_type_Arxh).a() == null) || (paramVenue == null) || (!arxh.a(this.jdField_a_of_type_Arxh).a().equals(paramVenue))) {
      return;
    }
    arxh.a(this.jdField_a_of_type_Arxh).setVenueOprating(false);
    arxh.a(this.jdField_a_of_type_Arxh).setVisibility(8);
    if (paramBoolean)
    {
      arxh.a(this.jdField_a_of_type_Arxh).setVenue(null);
      arxh.b(this.jdField_a_of_type_Arxh);
      axqw.b(null, "CliOper", "", "", "0X800A969", "0X800A969", 0, 0, "0", "0", "0", "");
      return;
    }
    bcpw.a(arxh.a(this.jdField_a_of_type_Arxh), 1, "移除失败，请稍后重试", 0).a();
    if ((paramInt2 == 10001) || (paramInt2 == 10003) || (paramInt2 == 10004) || (paramInt2 == 10100))
    {
      axqw.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 2, 0, "0", "0", "0", "");
      return;
    }
    axqw.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxo
 * JD-Core Version:    0.7.0.1
 */