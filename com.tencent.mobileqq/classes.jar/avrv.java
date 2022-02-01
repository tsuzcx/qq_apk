import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

public class avrv
  extends GestureDetector.SimpleOnGestureListener
{
  public avrv(HiBoomTextView paramHiBoomTextView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Avsb != null)
    {
      this.a.jdField_a_of_type_Avsb.a(this.a);
      return true;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    avrf localavrf = avrd.a().a(this.a.jdField_a_of_type_Int, this.a.b, this.a.jdField_a_of_type_Avre);
    if (this.a.b())
    {
      localavrf.a(true);
      this.a.invalidate();
      return true;
    }
    if (HiBoomTextView.a(this.a)) {
      this.a.a();
    }
    for (;;)
    {
      return super.onSingleTapConfirmed(paramMotionEvent);
      if (localavrf.jdField_a_of_type_Int == 3)
      {
        this.a.a(true);
      }
      else if (localavrf.jdField_a_of_type_Int == 4)
      {
        this.a.jdField_a_of_type_Boolean = true;
        this.a.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrv
 * JD-Core Version:    0.7.0.1
 */