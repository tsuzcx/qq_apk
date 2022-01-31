import android.os.Handler;
import android.view.animation.Animation;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.mobileqq.ptt.LSRecordPanel.2.1;
import com.tencent.qphone.base.util.QLog;

public class awsy
  extends awsv
{
  public awsy(LSRecordPanel paramLSRecordPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopRecordingBarAnimation onAnimationEnd");
    }
    LSRecordPanel.a(this.a).post(new LSRecordPanel.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awsy
 * JD-Core Version:    0.7.0.1
 */