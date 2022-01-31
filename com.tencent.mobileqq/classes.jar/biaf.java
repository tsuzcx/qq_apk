import android.view.View;
import android.view.View.OnLongClickListener;

class biaf
  implements View.OnLongClickListener
{
  biaf(biad parambiad, biac parambiac) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Biac.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Biad.a.a(this.jdField_a_of_type_Biac.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biaf
 * JD-Core Version:    0.7.0.1
 */