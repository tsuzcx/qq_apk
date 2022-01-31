import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneVideoDownloadActivity;
import java.util.concurrent.atomic.AtomicBoolean;

public class bgzw
  extends Handler
{
  public bgzw(QZoneVideoDownloadActivity paramQZoneVideoDownloadActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1000: 
            if (QLog.isDevelopLevel()) {
              QLog.d("QZoneVideoDownloadActivity", 4, "mIsUIInited=" + QZoneVideoDownloadActivity.a(this.a));
            }
            break;
          }
        } while (QZoneVideoDownloadActivity.a(this.a).get());
        this.a.setContentView(2131562646);
        this.a.a();
        QZoneVideoDownloadActivity.a(this.a).set(true);
        return;
      } while ((this.a.jdField_a_of_type_AndroidWidgetTextView == null) || (this.a.jdField_a_of_type_AndroidWidgetProgressBar == null));
      i = paramMessage.arg1;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131712496) + i + ajya.a(2131712490));
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      return;
    } while ((this.a.jdField_a_of_type_AndroidWidgetTextView == null) || (this.a.jdField_a_of_type_AndroidWidgetProgressBar == null));
    int i = paramMessage.arg1;
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131712532) + i + ajya.a(2131712487));
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
    return;
    String str2 = ajya.a(2131712539);
    String str1 = str2;
    if (paramMessage != null)
    {
      str1 = str2;
      if (paramMessage.obj != null)
      {
        str1 = str2;
        if ((paramMessage.obj instanceof String)) {
          str1 = (String)paramMessage.obj;
        }
      }
    }
    Toast.makeText(this.a.getApplicationContext(), str1, 1).show();
    bhqq.a(this.a.jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "1005", null);
    this.a.finish();
    return;
    Toast.makeText(this.a.getApplicationContext(), ajya.a(2131712607), 1).show();
    bhqq.a(this.a.jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "1006", null);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgzw
 * JD-Core Version:    0.7.0.1
 */