import android.view.View;
import android.view.View.OnClickListener;

class bkxi
  implements View.OnClickListener
{
  bkxi(bkxh parambkxh, bkxk parambkxk) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bkxk.getLayoutPosition();
    bkxh.a(this.jdField_a_of_type_Bkxh).a(this.jdField_a_of_type_Bkxk.itemView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxi
 * JD-Core Version:    0.7.0.1
 */