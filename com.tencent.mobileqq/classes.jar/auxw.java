import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qphone.base.util.QLog;

class auxw
  implements View.OnLongClickListener
{
  auxw(auxv paramauxv, auxz paramauxz) {}
  
  public boolean onLongClick(View paramView)
  {
    if (auxv.a(this.jdField_a_of_type_Auxv) != null)
    {
      QLog.i("leba_sort_LebaTableMgrAdpter", 1, "startDrag");
      auxv.a(this.jdField_a_of_type_Auxv).startDrag(this.jdField_a_of_type_Auxz);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxw
 * JD-Core Version:    0.7.0.1
 */