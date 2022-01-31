import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

public class assq
  extends GestureDetector.SimpleOnGestureListener
{
  public assq(HiBoomTextView paramHiBoomTextView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Assw != null)
    {
      this.a.jdField_a_of_type_Assw.a(this.a);
      return true;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    assa localassa = asry.a().a(this.a.jdField_a_of_type_Int, this.a.b, this.a.jdField_a_of_type_Asrz);
    if (this.a.b())
    {
      localassa.a(true);
      this.a.invalidate();
      return true;
    }
    if (HiBoomTextView.a(this.a)) {
      this.a.a();
    }
    for (;;)
    {
      return super.onSingleTapConfirmed(paramMotionEvent);
      if (localassa.jdField_a_of_type_Int == 3)
      {
        this.a.a(true);
      }
      else if (localassa.jdField_a_of_type_Int == 4)
      {
        this.a.jdField_a_of_type_Boolean = true;
        this.a.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assq
 * JD-Core Version:    0.7.0.1
 */