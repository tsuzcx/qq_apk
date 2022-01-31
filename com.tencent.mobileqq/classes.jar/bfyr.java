import android.view.View;
import android.view.View.OnLongClickListener;

class bfyr
  implements View.OnLongClickListener
{
  bfyr(bfyp parambfyp, bfyo parambfyo) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bfyo.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Bfyp.a.a(this.jdField_a_of_type_Bfyo.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfyr
 * JD-Core Version:    0.7.0.1
 */