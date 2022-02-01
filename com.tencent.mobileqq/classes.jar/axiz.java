import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class axiz
  extends GestureDetector.SimpleOnGestureListener
{
  axiz(axiy paramaxiy, axja paramaxja) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((axiy.a(this.jdField_a_of_type_Axiy) != null) && (this.jdField_a_of_type_Axja != null)) {
      this.jdField_a_of_type_Axja.b(axiy.a(this.jdField_a_of_type_Axiy), axiy.a(this.jdField_a_of_type_Axiy).getChildPosition(axiy.a(this.jdField_a_of_type_Axiy)));
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((axiy.a(this.jdField_a_of_type_Axiy) != null) && (this.jdField_a_of_type_Axja != null)) {
      this.jdField_a_of_type_Axja.a(axiy.a(this.jdField_a_of_type_Axiy), axiy.a(this.jdField_a_of_type_Axiy).getChildPosition(axiy.a(this.jdField_a_of_type_Axiy)));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axiz
 * JD-Core Version:    0.7.0.1
 */