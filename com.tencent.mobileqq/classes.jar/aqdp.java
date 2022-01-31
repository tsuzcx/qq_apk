import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

public class aqdp
  extends GestureDetector.SimpleOnGestureListener
{
  public aqdp(HiBoomTextView paramHiBoomTextView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Aqdv != null)
    {
      this.a.jdField_a_of_type_Aqdv.a(this.a);
      return true;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    aqcz localaqcz = aqcx.a().a(this.a.jdField_a_of_type_Int, this.a.b, this.a.jdField_a_of_type_Aqcy);
    if (this.a.b())
    {
      localaqcz.a(true);
      this.a.invalidate();
      return true;
    }
    if (HiBoomTextView.a(this.a)) {
      this.a.a();
    }
    for (;;)
    {
      return super.onSingleTapConfirmed(paramMotionEvent);
      if (localaqcz.jdField_a_of_type_Int == 3)
      {
        this.a.a(true);
      }
      else if (localaqcz.jdField_a_of_type_Int == 4)
      {
        this.a.jdField_a_of_type_Boolean = true;
        this.a.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqdp
 * JD-Core Version:    0.7.0.1
 */