import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;
import android.view.ViewParent;

class baco
  implements RecyclerView.OnItemTouchListener
{
  private float jdField_a_of_type_Float;
  private boolean jdField_a_of_type_Boolean;
  private float b;
  
  baco(bacm parambacm) {}
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    return Math.abs(this.jdField_a_of_type_Float - f1) > Math.abs(this.b - f2);
  }
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          return false;
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
          this.b = paramMotionEvent.getY();
          this.jdField_a_of_type_Boolean = false;
          return false;
        } while (this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_Boolean = true;
      } while ((!a(paramMotionEvent)) || (paramRecyclerView.getParent() == null));
      paramRecyclerView.getParent().requestDisallowInterceptTouchEvent(true);
      return false;
    } while (paramRecyclerView.getParent() == null);
    paramRecyclerView.getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baco
 * JD-Core Version:    0.7.0.1
 */