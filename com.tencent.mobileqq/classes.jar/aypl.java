import android.annotation.TargetApi;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
class aypl
  implements View.OnDragListener
{
  private int jdField_a_of_type_Int;
  
  public aypl(ayot paramayot, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      QLog.d("onDrag", 4, "ACTION_DRAG_STARTED");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypl
 * JD-Core Version:    0.7.0.1
 */