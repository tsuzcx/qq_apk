import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vashealth.VideoCallBack;
import com.tencent.qphone.base.util.QLog;

public class bdyy
  extends Handler
{
  public bdyy(VideoCallBack paramVideoCallBack, bety parambety, String paramString, Activity paramActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
        this.jdField_a_of_type_Bety.dismiss();
      }
      i = paramMessage.arg1;
      if (i != 0) {
        break;
      }
      paramMessage = paramMessage.getData().getString("maxvideo.file.mp4");
      Intent localIntent = new Intent();
      localIntent.putExtra("video_dir", paramMessage);
      localIntent.putExtra("thumb_dir", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppActivity.setResult(1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    } while (!QLog.isColorLevel());
    QLog.i("VideoCallBack", 2, "encode success: " + paramMessage);
    return;
    this.jdField_a_of_type_AndroidAppActivity.setResult(2);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    QLog.e("VideoCallBack", 1, "error! ret = " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyy
 * JD-Core Version:    0.7.0.1
 */