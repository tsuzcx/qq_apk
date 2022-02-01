import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class awsq
  implements awpx
{
  awsq(awsk paramawsk, LocationRoom.Venue paramVenue) {}
  
  public Pair<awpk, LocationRoom.Venue> a()
  {
    return new Pair(awsk.a(this.jdField_a_of_type_Awsk), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(awpk paramawpk, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] setVenue: onResult. roomKey: " + paramawpk + " venue: " + paramVenue + " mRoomKey: " + awsk.a(this.jdField_a_of_type_Awsk) + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramawpk.equals(awsk.a(this.jdField_a_of_type_Awsk))) || (paramVenue == null)) {
      return;
    }
    awsk.a(this.jdField_a_of_type_Awsk).setVenueOprating(false);
    awsk.a(this.jdField_a_of_type_Awsk).setVisibility(8);
    if (paramBoolean)
    {
      awsk.a(this.jdField_a_of_type_Awsk).setVenue(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      QQToast.a(awsk.a(this.jdField_a_of_type_Awsk), 2, "集合点设置成功", 0).a();
      bdll.b(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    switch (paramInt2)
    {
    default: 
      QQToast.a(awsk.a(this.jdField_a_of_type_Awsk), 1, "设置失败，请稍后重试", 0).a();
      if (awsk.a(this.jdField_a_of_type_Awsk).a() != null) {
        awsk.a(this.jdField_a_of_type_Awsk);
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10001) && (paramInt2 != 10003) && (paramInt2 != 10004) && (paramInt2 != 10100)) {
        break label389;
      }
      bdll.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
      return;
      QQToast.a(awsk.a(this.jdField_a_of_type_Awsk), 1, "你已离开共享会话", 0).a();
      awsk.a(this.jdField_a_of_type_Awsk).finish();
      break;
      QQToast.a(awsk.a(this.jdField_a_of_type_Awsk), 1, "已有人设置集合点", 0).a();
      break;
      awsk.b(this.jdField_a_of_type_Awsk);
    }
    label389:
    bdll.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsq
 * JD-Core Version:    0.7.0.1
 */