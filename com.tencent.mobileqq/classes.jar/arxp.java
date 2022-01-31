import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;

class arxp
  implements aruz
{
  arxp(arxj paramarxj, LocationRoom.Venue paramVenue) {}
  
  public Pair<arum, LocationRoom.Venue> a()
  {
    return new Pair(arxj.a(this.jdField_a_of_type_Arxj), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(arum paramarum, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] setVenue: onResult. roomKey: " + paramarum + " venue: " + paramVenue + " mRoomKey: " + arxj.a(this.jdField_a_of_type_Arxj) + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramarum.equals(arxj.a(this.jdField_a_of_type_Arxj))) || (paramVenue == null)) {
      return;
    }
    arxj.a(this.jdField_a_of_type_Arxj).setVenueOprating(false);
    arxj.a(this.jdField_a_of_type_Arxj).setVisibility(8);
    if (paramBoolean)
    {
      arxj.a(this.jdField_a_of_type_Arxj).setVenue(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      bcql.a(arxj.a(this.jdField_a_of_type_Arxj), 2, "集合点设置成功", 0).a();
      axqy.b(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    switch (paramInt2)
    {
    default: 
      bcql.a(arxj.a(this.jdField_a_of_type_Arxj), 1, "设置失败，请稍后重试", 0).a();
      if (arxj.a(this.jdField_a_of_type_Arxj).a() != null) {
        arxj.a(this.jdField_a_of_type_Arxj);
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10001) && (paramInt2 != 10003) && (paramInt2 != 10004) && (paramInt2 != 10100)) {
        break label389;
      }
      axqy.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
      return;
      bcql.a(arxj.a(this.jdField_a_of_type_Arxj), 1, "你已离开共享会话", 0).a();
      arxj.a(this.jdField_a_of_type_Arxj).finish();
      break;
      bcql.a(arxj.a(this.jdField_a_of_type_Arxj), 1, "已有人设置集合点", 0).a();
      break;
      arxj.b(this.jdField_a_of_type_Arxj);
    }
    label389:
    axqy.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxp
 * JD-Core Version:    0.7.0.1
 */