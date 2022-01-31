import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class atsu
  implements atqd
{
  atsu(atso paramatso, LocationRoom.Venue paramVenue) {}
  
  public Pair<atpq, LocationRoom.Venue> a()
  {
    return new Pair(atso.a(this.jdField_a_of_type_Atso), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(atpq paramatpq, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] setVenue: onResult. roomKey: " + paramatpq + " venue: " + paramVenue + " mRoomKey: " + atso.a(this.jdField_a_of_type_Atso) + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramatpq.equals(atso.a(this.jdField_a_of_type_Atso))) || (paramVenue == null)) {
      return;
    }
    atso.a(this.jdField_a_of_type_Atso).setVenueOprating(false);
    atso.a(this.jdField_a_of_type_Atso).setVisibility(8);
    if (paramBoolean)
    {
      atso.a(this.jdField_a_of_type_Atso).setVenue(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      QQToast.a(atso.a(this.jdField_a_of_type_Atso), 2, "集合点设置成功", 0).a();
      azqs.b(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    switch (paramInt2)
    {
    default: 
      QQToast.a(atso.a(this.jdField_a_of_type_Atso), 1, "设置失败，请稍后重试", 0).a();
      if (atso.a(this.jdField_a_of_type_Atso).a() != null) {
        atso.a(this.jdField_a_of_type_Atso);
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10001) && (paramInt2 != 10003) && (paramInt2 != 10004) && (paramInt2 != 10100)) {
        break label389;
      }
      azqs.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
      return;
      QQToast.a(atso.a(this.jdField_a_of_type_Atso), 1, "你已离开共享会话", 0).a();
      atso.a(this.jdField_a_of_type_Atso).finish();
      break;
      QQToast.a(atso.a(this.jdField_a_of_type_Atso), 1, "已有人设置集合点", 0).a();
      break;
      atso.b(this.jdField_a_of_type_Atso);
    }
    label389:
    azqs.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsu
 * JD-Core Version:    0.7.0.1
 */