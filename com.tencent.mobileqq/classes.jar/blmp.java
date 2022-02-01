import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import java.util.ArrayList;
import mqq.util.WeakReference;

class blmp
  implements View.OnTouchListener
{
  blmp(blmi paramblmi, bllo parambllo, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Bllo.a.isChecked())
    {
      paramView = (LocalMediaInfo)blmi.a(this.jdField_a_of_type_Blmi).get(this.jdField_a_of_type_Int);
      blmi.a(this.jdField_a_of_type_Blmi, paramView, this.jdField_a_of_type_Bllo);
      blmi.a(this.jdField_a_of_type_Blmi, this.jdField_a_of_type_Bllo);
      blmi.a(this.jdField_a_of_type_Blmi);
      if (blmi.b(this.jdField_a_of_type_Blmi).isEmpty()) {
        ((bllh)this.jdField_a_of_type_Blmi.a.get()).a.notifyDataSetChanged();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmp
 * JD-Core Version:    0.7.0.1
 */