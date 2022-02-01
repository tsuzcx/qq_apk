import android.view.animation.Animation;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.qphone.base.util.QLog;

public class bahc
  extends bagx
{
  public bahc(LSRecordPanel paramLSRecordPanel) {}
  
  public void a(Animation paramAnimation, float paramFloat)
  {
    if ((this.a.c == null) && (this.a.a != null) && (paramFloat >= 0.5F)) {
      this.a.e();
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startExpandAnimation onAnimationEnd");
    }
    if (paramAnimation == this.a.a) {
      this.a.h();
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahc
 * JD-Core Version:    0.7.0.1
 */