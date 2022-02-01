import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class awma
  implements awjg
{
  awma(awlt paramawlt, LocationRoom.Venue paramVenue) {}
  
  public Pair<awit, LocationRoom.Venue> a()
  {
    return new Pair(awlt.a(this.jdField_a_of_type_Awlt), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(awit paramawit, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] removeVenue: onResult. roomKey: " + paramawit + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramawit.equals(awlt.a(this.jdField_a_of_type_Awlt))) || (awlt.a(this.jdField_a_of_type_Awlt).a() == null) || (paramVenue == null) || (!awlt.a(this.jdField_a_of_type_Awlt).a().equals(paramVenue))) {
      return;
    }
    awlt.a(this.jdField_a_of_type_Awlt).setVenueOprating(false);
    awlt.a(this.jdField_a_of_type_Awlt).setVisibility(8);
    if (paramBoolean)
    {
      awlt.a(this.jdField_a_of_type_Awlt).setVenue(null);
      awlt.b(this.jdField_a_of_type_Awlt);
      bdla.b(null, "CliOper", "", "", "0X800A969", "0X800A969", 0, 0, "0", "0", "0", "");
      return;
    }
    QQToast.a(awlt.a(this.jdField_a_of_type_Awlt), 1, "移除失败，请稍后重试", 0).a();
    if ((paramInt2 == 10001) || (paramInt2 == 10003) || (paramInt2 == 10004) || (paramInt2 == 10100))
    {
      bdla.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 2, 0, "0", "0", "0", "");
      return;
    }
    bdla.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awma
 * JD-Core Version:    0.7.0.1
 */