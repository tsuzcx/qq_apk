import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class avzy
  implements avxc
{
  avzy(avzs paramavzs, LocationRoom.Venue paramVenue) {}
  
  public Pair<avwp, LocationRoom.Venue> a()
  {
    return new Pair(avzs.a(this.jdField_a_of_type_Avzs), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(avwp paramavwp, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] setVenue: onResult. roomKey: " + paramavwp + " venue: " + paramVenue + " mRoomKey: " + avzs.a(this.jdField_a_of_type_Avzs) + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramavwp.equals(avzs.a(this.jdField_a_of_type_Avzs))) || (paramVenue == null)) {
      return;
    }
    avzs.a(this.jdField_a_of_type_Avzs).setVenueOprating(false);
    avzs.a(this.jdField_a_of_type_Avzs).setVisibility(8);
    if (paramBoolean)
    {
      avzs.a(this.jdField_a_of_type_Avzs).setVenue(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      QQToast.a(avzs.a(this.jdField_a_of_type_Avzs), 2, "集合点设置成功", 0).a();
      bcst.b(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    switch (paramInt2)
    {
    default: 
      QQToast.a(avzs.a(this.jdField_a_of_type_Avzs), 1, "设置失败，请稍后重试", 0).a();
      if (avzs.a(this.jdField_a_of_type_Avzs).a() != null) {
        avzs.a(this.jdField_a_of_type_Avzs);
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10001) && (paramInt2 != 10003) && (paramInt2 != 10004) && (paramInt2 != 10100)) {
        break label389;
      }
      bcst.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
      return;
      QQToast.a(avzs.a(this.jdField_a_of_type_Avzs), 1, "你已离开共享会话", 0).a();
      avzs.a(this.jdField_a_of_type_Avzs).finish();
      break;
      QQToast.a(avzs.a(this.jdField_a_of_type_Avzs), 1, "已有人设置集合点", 0).a();
      break;
      avzs.b(this.jdField_a_of_type_Avzs);
    }
    label389:
    bcst.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzy
 * JD-Core Version:    0.7.0.1
 */