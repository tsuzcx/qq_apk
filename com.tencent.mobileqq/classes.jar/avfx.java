import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class avfx
  implements avdd
{
  avfx(avfq paramavfq, LocationRoom.Venue paramVenue) {}
  
  public Pair<avcq, LocationRoom.Venue> a()
  {
    return new Pair(avfq.a(this.jdField_a_of_type_Avfq), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(avcq paramavcq, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] removeVenue: onResult. roomKey: " + paramavcq + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramavcq.equals(avfq.a(this.jdField_a_of_type_Avfq))) || (avfq.a(this.jdField_a_of_type_Avfq).a() == null) || (paramVenue == null) || (!avfq.a(this.jdField_a_of_type_Avfq).a().equals(paramVenue))) {
      return;
    }
    avfq.a(this.jdField_a_of_type_Avfq).setVenueOprating(false);
    avfq.a(this.jdField_a_of_type_Avfq).setVisibility(8);
    if (paramBoolean)
    {
      avfq.a(this.jdField_a_of_type_Avfq).setVenue(null);
      avfq.b(this.jdField_a_of_type_Avfq);
      bcef.b(null, "CliOper", "", "", "0X800A969", "0X800A969", 0, 0, "0", "0", "0", "");
      return;
    }
    QQToast.a(avfq.a(this.jdField_a_of_type_Avfq), 1, "移除失败，请稍后重试", 0).a();
    if ((paramInt2 == 10001) || (paramInt2 == 10003) || (paramInt2 == 10004) || (paramInt2 == 10100))
    {
      bcef.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 2, 0, "0", "0", "0", "");
      return;
    }
    bcef.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfx
 * JD-Core Version:    0.7.0.1
 */