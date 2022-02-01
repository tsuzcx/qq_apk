import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import java.util.ArrayList;
import mqq.util.WeakReference;

class bnge
  implements View.OnTouchListener
{
  bnge(bngd parambngd, bnfk parambnfk, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Bnfk.a.isChecked())
    {
      paramView = (LocalMediaInfo)bngd.a(this.jdField_a_of_type_Bngd).get(this.jdField_a_of_type_Int);
      bngd.a(this.jdField_a_of_type_Bngd, paramView, this.jdField_a_of_type_Bnfk);
      bngd.a(this.jdField_a_of_type_Bngd, this.jdField_a_of_type_Bnfk);
      bngd.a(this.jdField_a_of_type_Bngd);
      if (bngd.b(this.jdField_a_of_type_Bngd).isEmpty()) {
        ((bnff)this.jdField_a_of_type_Bngd.a.get()).a.notifyDataSetChanged();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnge
 * JD-Core Version:    0.7.0.1
 */