import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;

class asop
  implements asoy
{
  asop(asoi paramasoi, VideoData paramVideoData, boolean paramBoolean) {}
  
  public void a(asot paramasot)
  {
    if (this.jdField_a_of_type_Asoi.jdField_a_of_type_Asor != null) {
      this.jdField_a_of_type_Asoi.jdField_a_of_type_Asor.c();
    }
    asmr localasmr;
    if (((this.jdField_a_of_type_Asoi.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_Asoi.jdField_a_of_type_AndroidContentContext).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "player truly start! app=" + this.jdField_a_of_type_Asoi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_Asoi.jdField_a_of_type_Aslv.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_a_of_type_Asoi.jdField_a_of_type_Asnb != null) {
        this.jdField_a_of_type_Asoi.jdField_a_of_type_Asnb.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 100, 0, "");
      }
      ((aszm)this.jdField_a_of_type_Asoi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      localasmr = new asmr().i("video_view").h("video");
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Boolean) {
        break label367;
      }
    }
    label367:
    for (paramasot = "0";; paramasot = "1")
    {
      localasmr.g(paramasot).b().f(asmr.a + "").a(this.jdField_a_of_type_Asoi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Asoi.jdField_a_of_type_Asot.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        long l = this.jdField_a_of_type_Asoi.b();
        double d = this.jdField_a_of_type_Asoi.c() / l;
        asms.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 1, String.valueOf(d), String.valueOf(l), String.valueOf(this.jdField_a_of_type_Asoi.c()), String.valueOf(asms.a()), true);
      }
      this.jdField_a_of_type_Asoi.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
      this.jdField_a_of_type_Asoi.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2025, 100L);
      this.jdField_a_of_type_Asoi.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2026, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asop
 * JD-Core Version:    0.7.0.1
 */