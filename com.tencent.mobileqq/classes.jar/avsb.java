import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qphone.base.util.QLog;

class avsb
  implements View.OnLongClickListener
{
  avsb(avsa paramavsa, avse paramavse) {}
  
  public boolean onLongClick(View paramView)
  {
    if (avsa.a(this.jdField_a_of_type_Avsa) != null)
    {
      QLog.i("leba_sort_LebaTableMgrAdpter", 1, "startDrag");
      avsa.a(this.jdField_a_of_type_Avsa).startDrag(this.jdField_a_of_type_Avse);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsb
 * JD-Core Version:    0.7.0.1
 */