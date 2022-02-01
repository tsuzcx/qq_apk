import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;

class axzs
  implements ayab
{
  axzs(axzl paramaxzl, VideoData paramVideoData, boolean paramBoolean) {}
  
  public void a(axzw paramaxzw)
  {
    if (this.jdField_a_of_type_Axzl.jdField_a_of_type_Axzu != null) {
      this.jdField_a_of_type_Axzl.jdField_a_of_type_Axzu.c();
    }
    axxu localaxxu;
    if (((this.jdField_a_of_type_Axzl.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_Axzl.jdField_a_of_type_AndroidContentContext).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "player truly start! app=" + this.jdField_a_of_type_Axzl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_Axzl.jdField_a_of_type_Axww.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_a_of_type_Axzl.jdField_a_of_type_Axye != null) {
        this.jdField_a_of_type_Axzl.jdField_a_of_type_Axye.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 100, 0, "");
      }
      ((ayks)this.jdField_a_of_type_Axzl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).f(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      localaxxu = new axxu().i("video_view").h("video");
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Boolean) {
        break label367;
      }
    }
    label367:
    for (paramaxzw = "0";; paramaxzw = "1")
    {
      localaxxu.g(paramaxzw).b().f(axxu.a + "").a(this.jdField_a_of_type_Axzl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Axzl.jdField_a_of_type_Axzw.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        long l = this.jdField_a_of_type_Axzl.b();
        double d = this.jdField_a_of_type_Axzl.c() / l;
        axxv.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 1, String.valueOf(d), String.valueOf(l), String.valueOf(this.jdField_a_of_type_Axzl.c()), String.valueOf(axxv.a()), true);
      }
      this.jdField_a_of_type_Axzl.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
      this.jdField_a_of_type_Axzl.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2025, 100L);
      this.jdField_a_of_type_Axzl.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2026, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzs
 * JD-Core Version:    0.7.0.1
 */