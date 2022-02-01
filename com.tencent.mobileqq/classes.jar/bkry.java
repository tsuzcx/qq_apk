import android.view.View;
import android.view.View.OnLongClickListener;

class bkry
  implements View.OnLongClickListener
{
  bkry(bkrw parambkrw, bkrv parambkrv) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bkrv.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Bkrw.a.a(this.jdField_a_of_type_Bkrv.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkry
 * JD-Core Version:    0.7.0.1
 */