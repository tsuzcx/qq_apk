import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import java.util.ArrayList;
import mqq.util.WeakReference;

class bohm
  implements View.OnTouchListener
{
  bohm(bohl parambohl, bogs parambogs, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Bogs.a.isChecked())
    {
      paramView = (LocalMediaInfo)bohl.a(this.jdField_a_of_type_Bohl).get(this.jdField_a_of_type_Int);
      bohl.a(this.jdField_a_of_type_Bohl, paramView, this.jdField_a_of_type_Bogs);
      bohl.a(this.jdField_a_of_type_Bohl, this.jdField_a_of_type_Bogs);
      bohl.a(this.jdField_a_of_type_Bohl);
      if (bohl.b(this.jdField_a_of_type_Bohl).isEmpty()) {
        ((bogn)this.jdField_a_of_type_Bohl.a.get()).a.notifyDataSetChanged();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohm
 * JD-Core Version:    0.7.0.1
 */