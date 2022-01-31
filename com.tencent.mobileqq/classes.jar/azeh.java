import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class azeh
  extends ArrowKeyMovementMethod
{
  private static azeh a;
  
  public static MovementMethod a()
  {
    if (a == null) {
      a = new azeh();
    }
    return a;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if (paramTextView.getTag(2131307025) != null)
      {
        azei localazei = (azei)paramTextView.getTag(2131307025);
        Drawable localDrawable = localazei.getDrawable();
        if ((localDrawable != null) && (new Rect(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight()).contains(i, j)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("zivonchen", 2, "我擦呢,命中------------------");
          }
          localazei.a(paramTextView);
          return true;
        }
      }
    }
    return Touch.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azeh
 * JD-Core Version:    0.7.0.1
 */