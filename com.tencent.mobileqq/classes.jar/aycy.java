import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class aycy
  extends GestureDetector.SimpleOnGestureListener
{
  aycy(aycx paramaycx, aycz paramaycz) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((aycx.a(this.jdField_a_of_type_Aycx) != null) && (this.jdField_a_of_type_Aycz != null)) {
      this.jdField_a_of_type_Aycz.b(aycx.a(this.jdField_a_of_type_Aycx), aycx.a(this.jdField_a_of_type_Aycx).getChildPosition(aycx.a(this.jdField_a_of_type_Aycx)));
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((aycx.a(this.jdField_a_of_type_Aycx) != null) && (this.jdField_a_of_type_Aycz != null)) {
      this.jdField_a_of_type_Aycz.a(aycx.a(this.jdField_a_of_type_Aycx), aycx.a(this.jdField_a_of_type_Aycx).getChildPosition(aycx.a(this.jdField_a_of_type_Aycx)));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycy
 * JD-Core Version:    0.7.0.1
 */