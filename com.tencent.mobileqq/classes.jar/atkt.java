import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;

class atkt
  implements atlc
{
  atkt(atkm paramatkm, VideoData paramVideoData, boolean paramBoolean) {}
  
  public void a(atkx paramatkx)
  {
    if (this.jdField_a_of_type_Atkm.jdField_a_of_type_Atkv != null) {
      this.jdField_a_of_type_Atkm.jdField_a_of_type_Atkv.c();
    }
    ativ localativ;
    if (((this.jdField_a_of_type_Atkm.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_Atkm.jdField_a_of_type_AndroidContentContext).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "player truly start! app=" + this.jdField_a_of_type_Atkm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_Atkm.jdField_a_of_type_Athz.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_a_of_type_Atkm.jdField_a_of_type_Atjf != null) {
        this.jdField_a_of_type_Atkm.jdField_a_of_type_Atjf.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 100, 0, "");
      }
      ((atvq)this.jdField_a_of_type_Atkm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      localativ = new ativ().i("video_view").h("video");
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Boolean) {
        break label367;
      }
    }
    label367:
    for (paramatkx = "0";; paramatkx = "1")
    {
      localativ.g(paramatkx).b().f(ativ.a + "").a(this.jdField_a_of_type_Atkm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Atkm.jdField_a_of_type_Atkx.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        long l = this.jdField_a_of_type_Atkm.b();
        double d = this.jdField_a_of_type_Atkm.c() / l;
        atiw.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 1, String.valueOf(d), String.valueOf(l), String.valueOf(this.jdField_a_of_type_Atkm.c()), String.valueOf(atiw.a()), true);
      }
      this.jdField_a_of_type_Atkm.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
      this.jdField_a_of_type_Atkm.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2025, 100L);
      this.jdField_a_of_type_Atkm.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2026, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atkt
 * JD-Core Version:    0.7.0.1
 */