import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

public class azcg
  extends ScaleGestureDetector
{
  private float a;
  private float b;
  
  public azcg(Context paramContext, ScaleGestureDetector.OnScaleGestureListener paramOnScaleGestureListener)
  {
    super(paramContext, paramOnScaleGestureListener);
    a();
  }
  
  private void a()
  {
    long l = System.currentTimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  @TargetApi(19)
  private boolean a()
  {
    return (Build.VERSION.SDK_INT >= 19) && (isQuickScaleEnabled()) && (getCurrentSpan() == getCurrentSpanY());
  }
  
  public float getScaleFactor()
  {
    float f2 = 1.0F;
    float f3 = super.getScaleFactor();
    if (a())
    {
      float f1;
      if ((this.a <= this.b) || (f3 <= 1.0F))
      {
        f1 = f2;
        if (this.a < this.b)
        {
          f1 = f2;
          if (f3 >= 1.0F) {}
        }
      }
      else
      {
        f1 = Math.max(0.8F, Math.min(f3, 1.25F));
      }
      return f1;
    }
    return f3;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    this.b = this.a;
    this.a = paramMotionEvent.getY();
    if (paramMotionEvent.getActionMasked() == 0) {
      this.b = paramMotionEvent.getY();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcg
 * JD-Core Version:    0.7.0.1
 */