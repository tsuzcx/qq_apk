import android.view.animation.Animation;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.qphone.base.util.QLog;

public class awxg
  extends awxe
{
  public awxg(LSRecordPanel paramLSRecordPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startRecordingBarAnimation onAnimationEnd");
    }
    this.a.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awxg
 * JD-Core Version:    0.7.0.1
 */