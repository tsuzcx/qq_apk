import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class arbw
  implements aqzj
{
  arbw(arbp paramarbp, LocationRoom.Venue paramVenue) {}
  
  public Pair<aqyw, LocationRoom.Venue> a()
  {
    return new Pair(arbp.a(this.jdField_a_of_type_Arbp), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(aqyw paramaqyw, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] removeVenue: onResult. roomKey: " + paramaqyw + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramaqyw.equals(arbp.a(this.jdField_a_of_type_Arbp))) || (arbp.a(this.jdField_a_of_type_Arbp).a() == null) || (paramVenue == null) || (!arbp.a(this.jdField_a_of_type_Arbp).a().equals(paramVenue))) {
      return;
    }
    arbp.a(this.jdField_a_of_type_Arbp).setVenueOprating(false);
    arbp.a(this.jdField_a_of_type_Arbp).setVisibility(8);
    if (paramBoolean)
    {
      arbp.a(this.jdField_a_of_type_Arbp).setVenue(null);
      arbp.b(this.jdField_a_of_type_Arbp);
      awqx.b(null, "CliOper", "", "", "0X800A969", "0X800A969", 0, 0, "0", "0", "0", "");
      return;
    }
    bbmy.a(arbp.a(this.jdField_a_of_type_Arbp), 1, "移除失败，请稍后重试", 0).a();
    if ((paramInt2 == 10001) || (paramInt2 == 10003) || (paramInt2 == 10004) || (paramInt2 == 10100))
    {
      awqx.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 2, 0, "0", "0", "0", "");
      return;
    }
    awqx.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arbw
 * JD-Core Version:    0.7.0.1
 */