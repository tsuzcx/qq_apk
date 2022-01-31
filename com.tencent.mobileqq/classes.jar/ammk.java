import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback;

public class ammk
  extends GestureDetector.SimpleOnGestureListener
{
  public ammk(ItemTouchHelper paramItemTouchHelper) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    Object localObject = this.a.a(paramMotionEvent);
    if (localObject != null)
    {
      localObject = this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
      if ((localObject != null) && (this.a.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.a(this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, (RecyclerView.ViewHolder)localObject))) {
        break label57;
      }
    }
    label57:
    do
    {
      do
      {
        return;
      } while (paramMotionEvent.getPointerId(0) != this.a.jdField_a_of_type_Int);
      int i = paramMotionEvent.findPointerIndex(this.a.jdField_a_of_type_Int);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      this.a.jdField_a_of_type_Float = f1;
      this.a.b = f2;
      paramMotionEvent = this.a;
      this.a.f = 0.0F;
      paramMotionEvent.e = 0.0F;
    } while (!this.a.jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchHelper$Callback.b());
    this.a.a((RecyclerView.ViewHolder)localObject, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ammk
 * JD-Core Version:    0.7.0.1
 */