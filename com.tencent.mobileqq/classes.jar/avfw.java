import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class avfw
  implements avdd
{
  avfw(avfq paramavfq, LocationRoom.Venue paramVenue) {}
  
  public Pair<avcq, LocationRoom.Venue> a()
  {
    return new Pair(avfq.a(this.jdField_a_of_type_Avfq), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(avcq paramavcq, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] setVenue: onResult. roomKey: " + paramavcq + " venue: " + paramVenue + " mRoomKey: " + avfq.a(this.jdField_a_of_type_Avfq) + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramavcq.equals(avfq.a(this.jdField_a_of_type_Avfq))) || (paramVenue == null)) {
      return;
    }
    avfq.a(this.jdField_a_of_type_Avfq).setVenueOprating(false);
    avfq.a(this.jdField_a_of_type_Avfq).setVisibility(8);
    if (paramBoolean)
    {
      avfq.a(this.jdField_a_of_type_Avfq).setVenue(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      QQToast.a(avfq.a(this.jdField_a_of_type_Avfq), 2, "集合点设置成功", 0).a();
      bcef.b(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    switch (paramInt2)
    {
    default: 
      QQToast.a(avfq.a(this.jdField_a_of_type_Avfq), 1, "设置失败，请稍后重试", 0).a();
      if (avfq.a(this.jdField_a_of_type_Avfq).a() != null) {
        avfq.a(this.jdField_a_of_type_Avfq);
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10001) && (paramInt2 != 10003) && (paramInt2 != 10004) && (paramInt2 != 10100)) {
        break label389;
      }
      bcef.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
      return;
      QQToast.a(avfq.a(this.jdField_a_of_type_Avfq), 1, "你已离开共享会话", 0).a();
      avfq.a(this.jdField_a_of_type_Avfq).finish();
      break;
      QQToast.a(avfq.a(this.jdField_a_of_type_Avfq), 1, "已有人设置集合点", 0).a();
      break;
      avfq.b(this.jdField_a_of_type_Avfq);
    }
    label389:
    bcef.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfw
 * JD-Core Version:    0.7.0.1
 */