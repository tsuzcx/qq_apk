import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class aype
  extends GestureDetector.SimpleOnGestureListener
{
  aype(aypd paramaypd, aypf paramaypf) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((aypd.a(this.jdField_a_of_type_Aypd) != null) && (this.jdField_a_of_type_Aypf != null)) {
      this.jdField_a_of_type_Aypf.b(aypd.a(this.jdField_a_of_type_Aypd), aypd.a(this.jdField_a_of_type_Aypd).getChildPosition(aypd.a(this.jdField_a_of_type_Aypd)));
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((aypd.a(this.jdField_a_of_type_Aypd) != null) && (this.jdField_a_of_type_Aypf != null)) {
      this.jdField_a_of_type_Aypf.a(aypd.a(this.jdField_a_of_type_Aypd), aypd.a(this.jdField_a_of_type_Aypd).getChildPosition(aypd.a(this.jdField_a_of_type_Aypd)));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aype
 * JD-Core Version:    0.7.0.1
 */