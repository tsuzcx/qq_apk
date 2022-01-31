import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class arbv
  implements aqzj
{
  arbv(arbp paramarbp, LocationRoom.Venue paramVenue) {}
  
  public Pair<aqyw, LocationRoom.Venue> a()
  {
    return new Pair(arbp.a(this.jdField_a_of_type_Arbp), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(aqyw paramaqyw, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] setVenue: onResult. roomKey: " + paramaqyw + " venue: " + paramVenue + " mRoomKey: " + arbp.a(this.jdField_a_of_type_Arbp) + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramaqyw.equals(arbp.a(this.jdField_a_of_type_Arbp))) || (paramVenue == null)) {
      return;
    }
    arbp.a(this.jdField_a_of_type_Arbp).setVenueOprating(false);
    arbp.a(this.jdField_a_of_type_Arbp).setVisibility(8);
    if (paramBoolean)
    {
      arbp.a(this.jdField_a_of_type_Arbp).setVenue(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      bbmy.a(arbp.a(this.jdField_a_of_type_Arbp), 2, "集合点设置成功", 0).a();
      awqx.b(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    switch (paramInt2)
    {
    default: 
      bbmy.a(arbp.a(this.jdField_a_of_type_Arbp), 1, "设置失败，请稍后重试", 0).a();
      if (arbp.a(this.jdField_a_of_type_Arbp).a() != null) {
        arbp.a(this.jdField_a_of_type_Arbp);
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10001) && (paramInt2 != 10003) && (paramInt2 != 10004) && (paramInt2 != 10100)) {
        break label389;
      }
      awqx.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
      return;
      bbmy.a(arbp.a(this.jdField_a_of_type_Arbp), 1, "你已离开共享会话", 0).a();
      arbp.a(this.jdField_a_of_type_Arbp).finish();
      break;
      bbmy.a(arbp.a(this.jdField_a_of_type_Arbp), 1, "已有人设置集合点", 0).a();
      break;
      arbp.b(this.jdField_a_of_type_Arbp);
    }
    label389:
    awqx.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arbv
 * JD-Core Version:    0.7.0.1
 */