import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class arxn
  implements arux
{
  arxn(arxh paramarxh, LocationRoom.Venue paramVenue) {}
  
  public Pair<aruk, LocationRoom.Venue> a()
  {
    return new Pair(arxh.a(this.jdField_a_of_type_Arxh), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(aruk paramaruk, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] setVenue: onResult. roomKey: " + paramaruk + " venue: " + paramVenue + " mRoomKey: " + arxh.a(this.jdField_a_of_type_Arxh) + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramaruk.equals(arxh.a(this.jdField_a_of_type_Arxh))) || (paramVenue == null)) {
      return;
    }
    arxh.a(this.jdField_a_of_type_Arxh).setVenueOprating(false);
    arxh.a(this.jdField_a_of_type_Arxh).setVisibility(8);
    if (paramBoolean)
    {
      arxh.a(this.jdField_a_of_type_Arxh).setVenue(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      bcpw.a(arxh.a(this.jdField_a_of_type_Arxh), 2, "集合点设置成功", 0).a();
      axqw.b(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    switch (paramInt2)
    {
    default: 
      bcpw.a(arxh.a(this.jdField_a_of_type_Arxh), 1, "设置失败，请稍后重试", 0).a();
      if (arxh.a(this.jdField_a_of_type_Arxh).a() != null) {
        arxh.a(this.jdField_a_of_type_Arxh);
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10001) && (paramInt2 != 10003) && (paramInt2 != 10004) && (paramInt2 != 10100)) {
        break label389;
      }
      axqw.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
      return;
      bcpw.a(arxh.a(this.jdField_a_of_type_Arxh), 1, "你已离开共享会话", 0).a();
      arxh.a(this.jdField_a_of_type_Arxh).finish();
      break;
      bcpw.a(arxh.a(this.jdField_a_of_type_Arxh), 1, "已有人设置集合点", 0).a();
      break;
      arxh.b(this.jdField_a_of_type_Arxh);
    }
    label389:
    axqw.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxn
 * JD-Core Version:    0.7.0.1
 */