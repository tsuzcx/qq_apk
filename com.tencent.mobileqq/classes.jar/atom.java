import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class atom
  implements atlu
{
  atom(atof paramatof, LocationRoom.Venue paramVenue) {}
  
  public Pair<atlh, LocationRoom.Venue> a()
  {
    return new Pair(atof.a(this.jdField_a_of_type_Atof), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(atlh paramatlh, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] removeVenue: onResult. roomKey: " + paramatlh + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramatlh.equals(atof.a(this.jdField_a_of_type_Atof))) || (atof.a(this.jdField_a_of_type_Atof).a() == null) || (paramVenue == null) || (!atof.a(this.jdField_a_of_type_Atof).a().equals(paramVenue))) {
      return;
    }
    atof.a(this.jdField_a_of_type_Atof).setVenueOprating(false);
    atof.a(this.jdField_a_of_type_Atof).setVisibility(8);
    if (paramBoolean)
    {
      atof.a(this.jdField_a_of_type_Atof).setVenue(null);
      atof.b(this.jdField_a_of_type_Atof);
      azmj.b(null, "CliOper", "", "", "0X800A969", "0X800A969", 0, 0, "0", "0", "0", "");
      return;
    }
    QQToast.a(atof.a(this.jdField_a_of_type_Atof), 1, "移除失败，请稍后重试", 0).a();
    if ((paramInt2 == 10001) || (paramInt2 == 10003) || (paramInt2 == 10004) || (paramInt2 == 10100))
    {
      azmj.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 2, 0, "0", "0", "0", "");
      return;
    }
    azmj.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atom
 * JD-Core Version:    0.7.0.1
 */