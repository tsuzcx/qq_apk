import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class avzz
  implements avxc
{
  avzz(avzs paramavzs, LocationRoom.Venue paramVenue) {}
  
  public Pair<avwp, LocationRoom.Venue> a()
  {
    return new Pair(avzs.a(this.jdField_a_of_type_Avzs), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(avwp paramavwp, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] removeVenue: onResult. roomKey: " + paramavwp + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramavwp.equals(avzs.a(this.jdField_a_of_type_Avzs))) || (avzs.a(this.jdField_a_of_type_Avzs).a() == null) || (paramVenue == null) || (!avzs.a(this.jdField_a_of_type_Avzs).a().equals(paramVenue))) {
      return;
    }
    avzs.a(this.jdField_a_of_type_Avzs).setVenueOprating(false);
    avzs.a(this.jdField_a_of_type_Avzs).setVisibility(8);
    if (paramBoolean)
    {
      avzs.a(this.jdField_a_of_type_Avzs).setVenue(null);
      avzs.b(this.jdField_a_of_type_Avzs);
      bcst.b(null, "CliOper", "", "", "0X800A969", "0X800A969", 0, 0, "0", "0", "0", "");
      return;
    }
    QQToast.a(avzs.a(this.jdField_a_of_type_Avzs), 1, "移除失败，请稍后重试", 0).a();
    if ((paramInt2 == 10001) || (paramInt2 == 10003) || (paramInt2 == 10004) || (paramInt2 == 10100))
    {
      bcst.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 2, 0, "0", "0", "0", "");
      return;
    }
    bcst.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzz
 * JD-Core Version:    0.7.0.1
 */