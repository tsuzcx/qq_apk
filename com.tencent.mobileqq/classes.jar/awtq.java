import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;

class awtq
  implements awtz
{
  awtq(awtj paramawtj, VideoData paramVideoData, boolean paramBoolean) {}
  
  public void a(awtu paramawtu)
  {
    if (this.jdField_a_of_type_Awtj.jdField_a_of_type_Awts != null) {
      this.jdField_a_of_type_Awtj.jdField_a_of_type_Awts.c();
    }
    awrs localawrs;
    if (((this.jdField_a_of_type_Awtj.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_Awtj.jdField_a_of_type_AndroidContentContext).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "player truly start! app=" + this.jdField_a_of_type_Awtj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_Awtj.jdField_a_of_type_Awqu.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_a_of_type_Awtj.jdField_a_of_type_Awsc != null) {
        this.jdField_a_of_type_Awtj.jdField_a_of_type_Awsc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 100, 0, "");
      }
      ((axen)this.jdField_a_of_type_Awtj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      localawrs = new awrs().i("video_view").h("video");
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Boolean) {
        break label367;
      }
    }
    label367:
    for (paramawtu = "0";; paramawtu = "1")
    {
      localawrs.g(paramawtu).b().f(awrs.a + "").a(this.jdField_a_of_type_Awtj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Awtj.jdField_a_of_type_Awtu.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        long l = this.jdField_a_of_type_Awtj.b();
        double d = this.jdField_a_of_type_Awtj.c() / l;
        awrt.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 1, String.valueOf(d), String.valueOf(l), String.valueOf(this.jdField_a_of_type_Awtj.c()), String.valueOf(awrt.a()), true);
      }
      this.jdField_a_of_type_Awtj.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
      this.jdField_a_of_type_Awtj.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2025, 100L);
      this.jdField_a_of_type_Awtj.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2026, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtq
 * JD-Core Version:    0.7.0.1
 */