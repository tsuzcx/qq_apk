import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

public class aqxr
  extends GestureDetector.SimpleOnGestureListener
{
  public aqxr(HiBoomTextView paramHiBoomTextView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Aqxx != null)
    {
      this.a.jdField_a_of_type_Aqxx.a(this.a);
      return true;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    aqxb localaqxb = aqwz.a().a(this.a.jdField_a_of_type_Int, this.a.b, this.a.jdField_a_of_type_Aqxa);
    if (this.a.b())
    {
      localaqxb.a(true);
      this.a.invalidate();
      return true;
    }
    if (HiBoomTextView.a(this.a)) {
      this.a.a();
    }
    for (;;)
    {
      return super.onSingleTapConfirmed(paramMotionEvent);
      if (localaqxb.jdField_a_of_type_Int == 3)
      {
        this.a.a(true);
      }
      else if (localaqxb.jdField_a_of_type_Int == 4)
      {
        this.a.jdField_a_of_type_Boolean = true;
        this.a.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqxr
 * JD-Core Version:    0.7.0.1
 */