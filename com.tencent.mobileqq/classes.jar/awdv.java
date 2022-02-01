import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qphone.base.util.QLog;

class awdv
  implements View.OnLongClickListener
{
  awdv(awdu paramawdu, awdy paramawdy) {}
  
  public boolean onLongClick(View paramView)
  {
    if (awdu.a(this.jdField_a_of_type_Awdu) != null)
    {
      QLog.i("leba_sort_LebaTableMgrAdpter", 1, "startDrag");
      awdu.a(this.jdField_a_of_type_Awdu).startDrag(this.jdField_a_of_type_Awdy);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdv
 * JD-Core Version:    0.7.0.1
 */