import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class awsr
  implements awpx
{
  awsr(awsk paramawsk, LocationRoom.Venue paramVenue) {}
  
  public Pair<awpk, LocationRoom.Venue> a()
  {
    return new Pair(awsk.a(this.jdField_a_of_type_Awsk), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(awpk paramawpk, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] removeVenue: onResult. roomKey: " + paramawpk + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramawpk.equals(awsk.a(this.jdField_a_of_type_Awsk))) || (awsk.a(this.jdField_a_of_type_Awsk).a() == null) || (paramVenue == null) || (!awsk.a(this.jdField_a_of_type_Awsk).a().equals(paramVenue))) {
      return;
    }
    awsk.a(this.jdField_a_of_type_Awsk).setVenueOprating(false);
    awsk.a(this.jdField_a_of_type_Awsk).setVisibility(8);
    if (paramBoolean)
    {
      awsk.a(this.jdField_a_of_type_Awsk).setVenue(null);
      awsk.b(this.jdField_a_of_type_Awsk);
      bdll.b(null, "CliOper", "", "", "0X800A969", "0X800A969", 0, 0, "0", "0", "0", "");
      return;
    }
    QQToast.a(awsk.a(this.jdField_a_of_type_Awsk), 1, "移除失败，请稍后重试", 0).a();
    if ((paramInt2 == 10001) || (paramInt2 == 10003) || (paramInt2 == 10004) || (paramInt2 == 10100))
    {
      bdll.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 2, 0, "0", "0", "0", "");
      return;
    }
    bdll.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsr
 * JD-Core Version:    0.7.0.1
 */