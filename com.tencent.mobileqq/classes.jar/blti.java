import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector;
import cooperation.qzone.QZoneTopGestureLayout;

public class blti
  extends TopGestureLayout.TopGestureDetector
{
  public blti(QZoneTopGestureLayout paramQZoneTopGestureLayout, Context paramContext)
  {
    super(paramQZoneTopGestureLayout, paramContext);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return false;
    }
    if (!QZoneTopGestureLayout.b()) {
      QZoneTopGestureLayout.b(this.a, -1);
    }
    if (QZoneTopGestureLayout.a(this.a)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
    if (QZoneTopGestureLayout.a(this.a, 1))
    {
      if ((paramFloat2 < 0.0F) && (f < 0.5F) && (this.a.mOnFlingGesture != null) && (paramFloat1 > 500.0F))
      {
        QZoneTopGestureLayout.c(this.a, -1);
        this.a.mOnFlingGesture.flingLToR();
        return true;
      }
    }
    else if ((QZoneTopGestureLayout.b(this.a, 0)) && (paramFloat2 > 0.0F) && (f < 0.5F) && (this.a.mOnFlingGesture != null) && (-1.0F * paramFloat1 > 500.0F))
    {
      QZoneTopGestureLayout.d(this.a, -1);
      this.a.mOnFlingGesture.flingRToL();
      return true;
    }
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!QZoneTopGestureLayout.b()) {
      QZoneTopGestureLayout.a(this.a, -1);
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blti
 * JD-Core Version:    0.7.0.1
 */