import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneVideoDownloadActivity;
import java.util.concurrent.atomic.AtomicBoolean;

public class bjfg
  extends Handler
{
  public bjfg(QZoneVideoDownloadActivity paramQZoneVideoDownloadActivity) {}
  
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
        this.a.setContentView(2131562868);
        this.a.a();
        QZoneVideoDownloadActivity.a(this.a).set(true);
        return;
      } while ((this.a.jdField_a_of_type_AndroidWidgetTextView == null) || (this.a.jdField_a_of_type_AndroidWidgetProgressBar == null));
      i = paramMessage.arg1;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131712880) + i + alud.a(2131712874));
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      return;
    } while ((this.a.jdField_a_of_type_AndroidWidgetTextView == null) || (this.a.jdField_a_of_type_AndroidWidgetProgressBar == null));
    int i = paramMessage.arg1;
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131712916) + i + alud.a(2131712871));
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
    return;
    String str2 = alud.a(2131712923);
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
    bjwi.a(this.a.jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "1005", null);
    this.a.finish();
    return;
    Toast.makeText(this.a.getApplicationContext(), alud.a(2131712991), 1).show();
    bjwi.a(this.a.jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "1006", null);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjfg
 * JD-Core Version:    0.7.0.1
 */