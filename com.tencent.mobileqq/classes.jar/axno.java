import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;

class axno
  implements axnx
{
  axno(axnh paramaxnh, VideoData paramVideoData, boolean paramBoolean) {}
  
  public void a(axns paramaxns)
  {
    if (this.jdField_a_of_type_Axnh.jdField_a_of_type_Axnq != null) {
      this.jdField_a_of_type_Axnh.jdField_a_of_type_Axnq.c();
    }
    axlq localaxlq;
    if (((this.jdField_a_of_type_Axnh.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_Axnh.jdField_a_of_type_AndroidContentContext).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "player truly start! app=" + this.jdField_a_of_type_Axnh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_Axnh.jdField_a_of_type_Axks.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_a_of_type_Axnh.jdField_a_of_type_Axma != null) {
        this.jdField_a_of_type_Axnh.jdField_a_of_type_Axma.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 100, 0, "");
      }
      ((axyl)this.jdField_a_of_type_Axnh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      localaxlq = new axlq().i("video_view").h("video");
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Boolean) {
        break label367;
      }
    }
    label367:
    for (paramaxns = "0";; paramaxns = "1")
    {
      localaxlq.g(paramaxns).b().f(axlq.a + "").a(this.jdField_a_of_type_Axnh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Axnh.jdField_a_of_type_Axns.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        long l = this.jdField_a_of_type_Axnh.b();
        double d = this.jdField_a_of_type_Axnh.c() / l;
        axlr.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 1, String.valueOf(d), String.valueOf(l), String.valueOf(this.jdField_a_of_type_Axnh.c()), String.valueOf(axlr.a()), true);
      }
      this.jdField_a_of_type_Axnh.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
      this.jdField_a_of_type_Axnh.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2025, 100L);
      this.jdField_a_of_type_Axnh.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2026, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axno
 * JD-Core Version:    0.7.0.1
 */