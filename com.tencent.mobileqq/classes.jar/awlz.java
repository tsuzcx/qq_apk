import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class awlz
  implements awjg
{
  awlz(awlt paramawlt, LocationRoom.Venue paramVenue) {}
  
  public Pair<awit, LocationRoom.Venue> a()
  {
    return new Pair(awlt.a(this.jdField_a_of_type_Awlt), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(awit paramawit, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] setVenue: onResult. roomKey: " + paramawit + " venue: " + paramVenue + " mRoomKey: " + awlt.a(this.jdField_a_of_type_Awlt) + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramawit.equals(awlt.a(this.jdField_a_of_type_Awlt))) || (paramVenue == null)) {
      return;
    }
    awlt.a(this.jdField_a_of_type_Awlt).setVenueOprating(false);
    awlt.a(this.jdField_a_of_type_Awlt).setVisibility(8);
    if (paramBoolean)
    {
      awlt.a(this.jdField_a_of_type_Awlt).setVenue(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      QQToast.a(awlt.a(this.jdField_a_of_type_Awlt), 2, "集合点设置成功", 0).a();
      bdla.b(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    switch (paramInt2)
    {
    default: 
      QQToast.a(awlt.a(this.jdField_a_of_type_Awlt), 1, "设置失败，请稍后重试", 0).a();
      if (awlt.a(this.jdField_a_of_type_Awlt).a() != null) {
        awlt.a(this.jdField_a_of_type_Awlt);
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10001) && (paramInt2 != 10003) && (paramInt2 != 10004) && (paramInt2 != 10100)) {
        break label389;
      }
      bdla.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
      return;
      QQToast.a(awlt.a(this.jdField_a_of_type_Awlt), 1, "你已离开共享会话", 0).a();
      awlt.a(this.jdField_a_of_type_Awlt).finish();
      break;
      QQToast.a(awlt.a(this.jdField_a_of_type_Awlt), 1, "已有人设置集合点", 0).a();
      break;
      awlt.b(this.jdField_a_of_type_Awlt);
    }
    label389:
    bdla.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlz
 * JD-Core Version:    0.7.0.1
 */