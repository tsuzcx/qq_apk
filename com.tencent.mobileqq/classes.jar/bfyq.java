import android.view.View;
import android.view.View.OnClickListener;

class bfyq
  implements View.OnClickListener
{
  bfyq(bfyp parambfyp, bfyo parambfyo) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bfyo.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Bfyp.a.a(this.jdField_a_of_type_Bfyo.itemView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfyq
 * JD-Core Version:    0.7.0.1
 */