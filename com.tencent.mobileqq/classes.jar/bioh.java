import android.view.View;
import android.view.View.OnClickListener;

class bioh
  implements View.OnClickListener
{
  bioh(biog parambiog, bioj parambioj) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bioj.getLayoutPosition();
    biog.a(this.jdField_a_of_type_Biog).a(this.jdField_a_of_type_Bioj.itemView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bioh
 * JD-Core Version:    0.7.0.1
 */