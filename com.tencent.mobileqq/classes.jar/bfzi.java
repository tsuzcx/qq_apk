import android.view.View;
import android.view.View.OnLongClickListener;

class bfzi
  implements View.OnLongClickListener
{
  bfzi(bfzg parambfzg, bfzf parambfzf) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bfzf.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Bfzg.a.a(this.jdField_a_of_type_Bfzf.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfzi
 * JD-Core Version:    0.7.0.1
 */