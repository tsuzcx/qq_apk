import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

public class auzu
  extends GestureDetector.SimpleOnGestureListener
{
  public auzu(HiBoomTextView paramHiBoomTextView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Avaa != null)
    {
      this.a.jdField_a_of_type_Avaa.a(this.a);
      return true;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    auze localauze = auzc.a().a(this.a.jdField_a_of_type_Int, this.a.b, this.a.jdField_a_of_type_Auzd);
    if (this.a.b())
    {
      localauze.a(true);
      this.a.invalidate();
      return true;
    }
    if (HiBoomTextView.a(this.a)) {
      this.a.a();
    }
    for (;;)
    {
      return super.onSingleTapConfirmed(paramMotionEvent);
      if (localauze.jdField_a_of_type_Int == 3)
      {
        this.a.a(true);
      }
      else if (localauze.jdField_a_of_type_Int == 4)
      {
        this.a.jdField_a_of_type_Boolean = true;
        this.a.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzu
 * JD-Core Version:    0.7.0.1
 */