import android.view.View;
import android.view.View.OnLongClickListener;

class bltb
  implements View.OnLongClickListener
{
  bltb(blsz paramblsz, blsy paramblsy) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Blsy.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Blsz.a.a(this.jdField_a_of_type_Blsy.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltb
 * JD-Core Version:    0.7.0.1
 */