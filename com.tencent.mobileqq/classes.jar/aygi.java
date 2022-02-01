import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;

class aygi
  implements aygr
{
  aygi(aygb paramaygb, VideoData paramVideoData, boolean paramBoolean) {}
  
  public void a(aygm paramaygm)
  {
    if (this.jdField_a_of_type_Aygb.jdField_a_of_type_Aygk != null) {
      this.jdField_a_of_type_Aygb.jdField_a_of_type_Aygk.c();
    }
    ayek localayek;
    if (((this.jdField_a_of_type_Aygb.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_Aygb.jdField_a_of_type_AndroidContentContext).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "player truly start! app=" + this.jdField_a_of_type_Aygb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_Aygb.jdField_a_of_type_Aydm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_a_of_type_Aygb.jdField_a_of_type_Ayeu != null) {
        this.jdField_a_of_type_Aygb.jdField_a_of_type_Ayeu.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 100, 0, "");
      }
      ((ayrf)this.jdField_a_of_type_Aygb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      localayek = new ayek().i("video_view").h("video");
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Boolean) {
        break label367;
      }
    }
    label367:
    for (paramaygm = "0";; paramaygm = "1")
    {
      localayek.g(paramaygm).b().f(ayek.a + "").a(this.jdField_a_of_type_Aygb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Aygb.jdField_a_of_type_Aygm.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        long l = this.jdField_a_of_type_Aygb.b();
        double d = this.jdField_a_of_type_Aygb.c() / l;
        ayel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 1, String.valueOf(d), String.valueOf(l), String.valueOf(this.jdField_a_of_type_Aygb.c()), String.valueOf(ayel.a()), true);
      }
      this.jdField_a_of_type_Aygb.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
      this.jdField_a_of_type_Aygb.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2025, 100L);
      this.jdField_a_of_type_Aygb.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2026, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygi
 * JD-Core Version:    0.7.0.1
 */