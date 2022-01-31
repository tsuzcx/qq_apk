import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class atsv
  implements atqd
{
  atsv(atso paramatso, LocationRoom.Venue paramVenue) {}
  
  public Pair<atpq, LocationRoom.Venue> a()
  {
    return new Pair(atso.a(this.jdField_a_of_type_Atso), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(atpq paramatpq, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] removeVenue: onResult. roomKey: " + paramatpq + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramatpq.equals(atso.a(this.jdField_a_of_type_Atso))) || (atso.a(this.jdField_a_of_type_Atso).a() == null) || (paramVenue == null) || (!atso.a(this.jdField_a_of_type_Atso).a().equals(paramVenue))) {
      return;
    }
    atso.a(this.jdField_a_of_type_Atso).setVenueOprating(false);
    atso.a(this.jdField_a_of_type_Atso).setVisibility(8);
    if (paramBoolean)
    {
      atso.a(this.jdField_a_of_type_Atso).setVenue(null);
      atso.b(this.jdField_a_of_type_Atso);
      azqs.b(null, "CliOper", "", "", "0X800A969", "0X800A969", 0, 0, "0", "0", "0", "");
      return;
    }
    QQToast.a(atso.a(this.jdField_a_of_type_Atso), 1, "移除失败，请稍后重试", 0).a();
    if ((paramInt2 == 10001) || (paramInt2 == 10003) || (paramInt2 == 10004) || (paramInt2 == 10100))
    {
      azqs.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 2, 0, "0", "0", "0", "");
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsv
 * JD-Core Version:    0.7.0.1
 */