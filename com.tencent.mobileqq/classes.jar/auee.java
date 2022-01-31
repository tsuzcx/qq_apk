import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public abstract interface auee
{
  public abstract void a(Matrix paramMatrix);
  
  public abstract void a(MotionEvent paramMotionEvent);
  
  public abstract void a(ScaleGestureDetector paramScaleGestureDetector);
  
  public abstract boolean a(MotionEvent paramMotionEvent);
  
  public abstract boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  
  public abstract boolean a(ScaleGestureDetector paramScaleGestureDetector);
  
  public abstract void b(MotionEvent paramMotionEvent);
  
  public abstract boolean b(MotionEvent paramMotionEvent);
  
  public abstract boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  
  public abstract boolean b(ScaleGestureDetector paramScaleGestureDetector);
  
  public abstract void c(MotionEvent paramMotionEvent);
  
  public abstract boolean c(MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auee
 * JD-Core Version:    0.7.0.1
 */