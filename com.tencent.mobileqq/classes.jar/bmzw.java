import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import java.util.ArrayList;
import mqq.util.WeakReference;

class bmzw
  implements View.OnTouchListener
{
  bmzw(bmzr parambmzr, bmyx parambmyx, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Bmyx.a.isChecked())
    {
      paramView = (LocalMediaInfo)bmzr.a(this.jdField_a_of_type_Bmzr).get(this.jdField_a_of_type_Int);
      bmzr.a(this.jdField_a_of_type_Bmzr, paramView, this.jdField_a_of_type_Bmyx);
      bmzr.a(this.jdField_a_of_type_Bmzr, this.jdField_a_of_type_Bmyx);
      bmzr.a(this.jdField_a_of_type_Bmzr);
      if (bmzr.b(this.jdField_a_of_type_Bmzr).isEmpty()) {
        ((bmyq)this.jdField_a_of_type_Bmzr.a.get()).a.notifyDataSetChanged();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzw
 * JD-Core Version:    0.7.0.1
 */