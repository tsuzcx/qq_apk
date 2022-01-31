import android.view.View;
import android.view.View.OnClickListener;

class bfzh
  implements View.OnClickListener
{
  bfzh(bfzg parambfzg, bfzf parambfzf) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bfzf.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Bfzg.a.a(this.jdField_a_of_type_Bfzf.itemView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfzh
 * JD-Core Version:    0.7.0.1
 */