import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class bert
  implements ValueAnimator.AnimatorUpdateListener
{
  public bert(ParticipleView paramParticipleView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    long l = System.currentTimeMillis();
    paramValueAnimator = ParticipleView.a(this.a).iterator();
    int i = 1;
    if (paramValueAnimator.hasNext())
    {
      berx localberx = (berx)paramValueAnimator.next();
      float f = Math.min((float)(l - berx.a(localberx)) / ParticipleView.a(this.a), 1.0F);
      berx.a(localberx, f);
      if (f < 1.0F) {
        i = 0;
      }
      for (;;)
      {
        break;
        paramValueAnimator.remove();
      }
    }
    if (i != 0)
    {
      ParticipleView.a(this.a).cancel();
      ParticipleView.a(this.a, null);
      ParticipleView.a(this.a).clear();
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleView", 2, "selectedAnimation end cancel");
      }
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bert
 * JD-Core Version:    0.7.0.1
 */