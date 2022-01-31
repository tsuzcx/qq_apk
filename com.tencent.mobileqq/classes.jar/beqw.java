import android.view.View;
import android.view.View.OnClickListener;

class beqw
  implements View.OnClickListener
{
  beqw(beqv parambeqv, bequ parambequ) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bequ.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Beqv.a.a(this.jdField_a_of_type_Bequ.itemView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beqw
 * JD-Core Version:    0.7.0.1
 */