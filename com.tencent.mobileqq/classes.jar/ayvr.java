import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class ayvr
  extends GestureDetector.SimpleOnGestureListener
{
  ayvr(ayvq paramayvq, ayvs paramayvs) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((ayvq.a(this.jdField_a_of_type_Ayvq) != null) && (this.jdField_a_of_type_Ayvs != null)) {
      this.jdField_a_of_type_Ayvs.b(ayvq.a(this.jdField_a_of_type_Ayvq), ayvq.a(this.jdField_a_of_type_Ayvq).getChildPosition(ayvq.a(this.jdField_a_of_type_Ayvq)));
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((ayvq.a(this.jdField_a_of_type_Ayvq) != null) && (this.jdField_a_of_type_Ayvs != null)) {
      this.jdField_a_of_type_Ayvs.a(ayvq.a(this.jdField_a_of_type_Ayvq), ayvq.a(this.jdField_a_of_type_Ayvq).getChildPosition(ayvq.a(this.jdField_a_of_type_Ayvq)));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvr
 * JD-Core Version:    0.7.0.1
 */