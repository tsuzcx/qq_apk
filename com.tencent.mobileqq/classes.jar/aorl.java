import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoReq;

class aorl
  implements Runnable
{
  aorl(aork paramaork) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidContentIntent != null)
    {
      int i = this.a.jdField_a_of_type_AndroidContentIntent.getIntExtra("file_send_business_type", 2);
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "#SendTask# run(), busiType = " + i + ",VideoFileDir = " + this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("file_video_source_dir"));
      }
      int j = this.a.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
      if (j == 9501) {
        i = 4;
      }
      ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(0, i);
      localShortVideoReq.a(ShortVideoBusiManager.a(this.a.jdField_a_of_type_AndroidContentIntent, localShortVideoReq));
      if ((j != 9501) || (QLog.isColorLevel())) {
        QLog.d("SendVideoActivity", 2, "#SendTask# run(): success");
      }
    }
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aorl
 * JD-Core Version:    0.7.0.1
 */