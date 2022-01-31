import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.tencent.widget.itemtouchhelper.GestureDetectorCompat;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback;
import java.util.List;

public class amme
  implements RecyclerView.OnItemTouchListener
{
  public amme(ItemTouchHelper paramItemTouchHelper) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    this.a.jdField_a_of_type_ComTencentWidgetItemtouchhelperGestureDetectorCompat.a(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.a.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
      this.a.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.a.b = paramMotionEvent.getY();
      this.a.a();
      if (this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null)
      {
        paramRecyclerView = this.a.a(paramMotionEvent);
        if (paramRecyclerView != null)
        {
          ItemTouchHelper localItemTouchHelper = this.a;
          localItemTouchHelper.jdField_a_of_type_Float -= paramRecyclerView.e;
          localItemTouchHelper = this.a;
          localItemTouchHelper.b -= paramRecyclerView.f;
          this.a.a(paramRecyclerView.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, true);
          if (this.a.jdField_a_of_type_JavaUtilList.remove(paramRecyclerView.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView)) {
            this.a.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramRecyclerView.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
          }
          this.a.a(paramRecyclerView.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, paramRecyclerView.jdField_b_of_type_Int);
          this.a.a(paramMotionEvent, this.a.c, 0);
        }
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidViewVelocityTracker != null) {
        this.a.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      }
      if (this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        break;
      }
      return true;
      if ((i == 3) || (i == 1))
      {
        this.a.jdField_a_of_type_Int = -1;
        this.a.a(null, 0);
      }
      else if (this.a.jdField_a_of_type_Int != -1)
      {
        int j = paramMotionEvent.findPointerIndex(this.a.jdField_a_of_type_Int);
        if (j >= 0) {
          this.a.a(i, paramMotionEvent, j);
        }
      }
    }
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.a.a(null, 0);
  }
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = 0;
    this.a.jdField_a_of_type_ComTencentWidgetItemtouchhelperGestureDetectorCompat.a(paramMotionEvent);
    if (this.a.jdField_a_of_type_AndroidViewVelocityTracker != null) {
      this.a.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    }
    if (this.a.jdField_a_of_type_Int == -1) {}
    int j;
    do
    {
      int k;
      do
      {
        return;
        j = paramMotionEvent.getActionMasked();
        k = paramMotionEvent.findPointerIndex(this.a.jdField_a_of_type_Int);
        if (k >= 0) {
          this.a.a(j, paramMotionEvent, k);
        }
        paramRecyclerView = this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
      } while (paramRecyclerView == null);
      switch (j)
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          this.a.a(null, 0);
          this.a.jdField_a_of_type_Int = -1;
          return;
          if (k < 0) {
            break;
          }
          this.a.a(paramMotionEvent, this.a.c, k);
          this.a.a(paramRecyclerView);
          this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
          this.a.jdField_a_of_type_JavaLangRunnable.run();
          this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.invalidate();
          return;
          if (this.a.jdField_a_of_type_AndroidViewVelocityTracker != null) {
            this.a.jdField_a_of_type_AndroidViewVelocityTracker.clear();
          }
        }
      }
      j = paramMotionEvent.getActionIndex();
    } while (paramMotionEvent.getPointerId(j) != this.a.jdField_a_of_type_Int);
    if (j == 0) {
      i = 1;
    }
    this.a.jdField_a_of_type_Int = paramMotionEvent.getPointerId(i);
    this.a.a(paramMotionEvent, this.a.c, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amme
 * JD-Core Version:    0.7.0.1
 */