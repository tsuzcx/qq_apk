import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class atol
  implements atlu
{
  atol(atof paramatof, LocationRoom.Venue paramVenue) {}
  
  public Pair<atlh, LocationRoom.Venue> a()
  {
    return new Pair(atof.a(this.jdField_a_of_type_Atof), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(atlh paramatlh, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] setVenue: onResult. roomKey: " + paramatlh + " venue: " + paramVenue + " mRoomKey: " + atof.a(this.jdField_a_of_type_Atof) + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramatlh.equals(atof.a(this.jdField_a_of_type_Atof))) || (paramVenue == null)) {
      return;
    }
    atof.a(this.jdField_a_of_type_Atof).setVenueOprating(false);
    atof.a(this.jdField_a_of_type_Atof).setVisibility(8);
    if (paramBoolean)
    {
      atof.a(this.jdField_a_of_type_Atof).setVenue(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      QQToast.a(atof.a(this.jdField_a_of_type_Atof), 2, "集合点设置成功", 0).a();
      azmj.b(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    switch (paramInt2)
    {
    default: 
      QQToast.a(atof.a(this.jdField_a_of_type_Atof), 1, "设置失败，请稍后重试", 0).a();
      if (atof.a(this.jdField_a_of_type_Atof).a() != null) {
        atof.a(this.jdField_a_of_type_Atof);
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10001) && (paramInt2 != 10003) && (paramInt2 != 10004) && (paramInt2 != 10100)) {
        break label389;
      }
      azmj.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
      return;
      QQToast.a(atof.a(this.jdField_a_of_type_Atof), 1, "你已离开共享会话", 0).a();
      atof.a(this.jdField_a_of_type_Atof).finish();
      break;
      QQToast.a(atof.a(this.jdField_a_of_type_Atof), 1, "已有人设置集合点", 0).a();
      break;
      atof.b(this.jdField_a_of_type_Atof);
    }
    label389:
    azmj.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atol
 * JD-Core Version:    0.7.0.1
 */