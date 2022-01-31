import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;

class avbv
  implements avce
{
  avbv(avbo paramavbo, VideoData paramVideoData, boolean paramBoolean) {}
  
  public void a(avbz paramavbz)
  {
    if (this.jdField_a_of_type_Avbo.jdField_a_of_type_Avbx != null) {
      this.jdField_a_of_type_Avbo.jdField_a_of_type_Avbx.c();
    }
    auzx localauzx;
    if (((this.jdField_a_of_type_Avbo.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_Avbo.jdField_a_of_type_AndroidContentContext).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "player truly start! app=" + this.jdField_a_of_type_Avbo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_Avbo.jdField_a_of_type_Auza.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_a_of_type_Avbo.jdField_a_of_type_Avah != null) {
        this.jdField_a_of_type_Avbo.jdField_a_of_type_Avah.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 100, 0, "");
      }
      ((avms)this.jdField_a_of_type_Avbo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      localauzx = new auzx().i("video_view").h("video");
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Boolean) {
        break label367;
      }
    }
    label367:
    for (paramavbz = "0";; paramavbz = "1")
    {
      localauzx.g(paramavbz).b().f(auzx.a + "").a(this.jdField_a_of_type_Avbo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Avbo.jdField_a_of_type_Avbz.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        long l = this.jdField_a_of_type_Avbo.b();
        double d = this.jdField_a_of_type_Avbo.c() / l;
        auzy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 1, String.valueOf(d), String.valueOf(l), String.valueOf(this.jdField_a_of_type_Avbo.c()), String.valueOf(auzy.a()), true);
      }
      this.jdField_a_of_type_Avbo.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
      this.jdField_a_of_type_Avbo.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2025, 100L);
      this.jdField_a_of_type_Avbo.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2026, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avbv
 * JD-Core Version:    0.7.0.1
 */