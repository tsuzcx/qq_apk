import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.qphone.base.util.QLog;

public class azqp
  extends GestureDetector.SimpleOnGestureListener
{
  public azqp(VasProfileTagView paramVasProfileTagView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onScroll invoked");
    }
    VasProfileTagView.a(this.a, true);
    paramFloat1 = paramFloat2;
    if (paramMotionEvent1 != null)
    {
      paramFloat1 = paramFloat2;
      if (paramMotionEvent2 != null) {
        paramFloat1 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onScroll distance = " + paramFloat1);
    }
    if (Math.abs(paramFloat1) > VasProfileTagView.a(this.a))
    {
      if ((paramFloat1 > 0.0F) && (this.a.b)) {
        if (this.a.a())
        {
          this.a.g();
          VasProfileTagView.a(this.a).b(null);
        }
      }
      while ((paramFloat1 >= 0.0F) || (this.a.b)) {
        return true;
      }
      this.a.a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqp
 * JD-Core Version:    0.7.0.1
 */