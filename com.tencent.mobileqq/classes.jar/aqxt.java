import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

public class aqxt
  extends GestureDetector.SimpleOnGestureListener
{
  public aqxt(HiBoomTextView paramHiBoomTextView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Aqxz != null)
    {
      this.a.jdField_a_of_type_Aqxz.a(this.a);
      return true;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    aqxd localaqxd = aqxb.a().a(this.a.jdField_a_of_type_Int, this.a.b, this.a.jdField_a_of_type_Aqxc);
    if (this.a.b())
    {
      localaqxd.a(true);
      this.a.invalidate();
      return true;
    }
    if (HiBoomTextView.a(this.a)) {
      this.a.a();
    }
    for (;;)
    {
      return super.onSingleTapConfirmed(paramMotionEvent);
      if (localaqxd.jdField_a_of_type_Int == 3)
      {
        this.a.a(true);
      }
      else if (localaqxd.jdField_a_of_type_Int == 4)
      {
        this.a.jdField_a_of_type_Boolean = true;
        this.a.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqxt
 * JD-Core Version:    0.7.0.1
 */