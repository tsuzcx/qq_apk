import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;

class avge
  implements avgn
{
  avge(avfx paramavfx, VideoData paramVideoData, boolean paramBoolean) {}
  
  public void a(avgi paramavgi)
  {
    if (this.jdField_a_of_type_Avfx.jdField_a_of_type_Avgg != null) {
      this.jdField_a_of_type_Avfx.jdField_a_of_type_Avgg.c();
    }
    aveg localaveg;
    if (((this.jdField_a_of_type_Avfx.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_Avfx.jdField_a_of_type_AndroidContentContext).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "player truly start! app=" + this.jdField_a_of_type_Avfx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_Avfx.jdField_a_of_type_Avdj.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_a_of_type_Avfx.jdField_a_of_type_Aveq != null) {
        this.jdField_a_of_type_Avfx.jdField_a_of_type_Aveq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 100, 0, "");
      }
      ((avrb)this.jdField_a_of_type_Avfx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      localaveg = new aveg().i("video_view").h("video");
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Boolean) {
        break label367;
      }
    }
    label367:
    for (paramavgi = "0";; paramavgi = "1")
    {
      localaveg.g(paramavgi).b().f(aveg.a + "").a(this.jdField_a_of_type_Avfx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Avfx.jdField_a_of_type_Avgi.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        long l = this.jdField_a_of_type_Avfx.b();
        double d = this.jdField_a_of_type_Avfx.c() / l;
        aveh.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 1, String.valueOf(d), String.valueOf(l), String.valueOf(this.jdField_a_of_type_Avfx.c()), String.valueOf(aveh.a()), true);
      }
      this.jdField_a_of_type_Avfx.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
      this.jdField_a_of_type_Avfx.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2025, 100L);
      this.jdField_a_of_type_Avfx.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2026, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avge
 * JD-Core Version:    0.7.0.1
 */