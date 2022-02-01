import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qphone.base.util.QLog;

class awks
  implements View.OnLongClickListener
{
  awks(awkr paramawkr, awkv paramawkv) {}
  
  public boolean onLongClick(View paramView)
  {
    if (awkr.a(this.jdField_a_of_type_Awkr) != null)
    {
      QLog.i("leba_sort_LebaTableMgrAdpter", 1, "startDrag");
      awkr.a(this.jdField_a_of_type_Awkr).startDrag(this.jdField_a_of_type_Awkv);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awks
 * JD-Core Version:    0.7.0.1
 */