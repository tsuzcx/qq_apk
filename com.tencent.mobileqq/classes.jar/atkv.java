import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;

class atkv
  implements atle
{
  atkv(atko paramatko, VideoData paramVideoData, boolean paramBoolean) {}
  
  public void a(atkz paramatkz)
  {
    if (this.jdField_a_of_type_Atko.jdField_a_of_type_Atkx != null) {
      this.jdField_a_of_type_Atko.jdField_a_of_type_Atkx.c();
    }
    atix localatix;
    if (((this.jdField_a_of_type_Atko.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_Atko.jdField_a_of_type_AndroidContentContext).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "player truly start! app=" + this.jdField_a_of_type_Atko.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_Atko.jdField_a_of_type_Atib.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_a_of_type_Atko.jdField_a_of_type_Atjh != null) {
        this.jdField_a_of_type_Atko.jdField_a_of_type_Atjh.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 100, 0, "");
      }
      ((atvs)this.jdField_a_of_type_Atko.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      localatix = new atix().i("video_view").h("video");
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Boolean) {
        break label367;
      }
    }
    label367:
    for (paramatkz = "0";; paramatkz = "1")
    {
      localatix.g(paramatkz).b().f(atix.a + "").a(this.jdField_a_of_type_Atko.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Atko.jdField_a_of_type_Atkz.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        long l = this.jdField_a_of_type_Atko.b();
        double d = this.jdField_a_of_type_Atko.c() / l;
        atiy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 1, String.valueOf(d), String.valueOf(l), String.valueOf(this.jdField_a_of_type_Atko.c()), String.valueOf(atiy.a()), true);
      }
      this.jdField_a_of_type_Atko.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
      this.jdField_a_of_type_Atko.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2025, 100L);
      this.jdField_a_of_type_Atko.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2026, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atkv
 * JD-Core Version:    0.7.0.1
 */