import android.view.View;
import android.view.View.OnClickListener;

class binq
  implements View.OnClickListener
{
  binq(binp parambinp, bins parambins) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bins.getLayoutPosition();
    binp.a(this.jdField_a_of_type_Binp).a(this.jdField_a_of_type_Bins.itemView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     binq
 * JD-Core Version:    0.7.0.1
 */