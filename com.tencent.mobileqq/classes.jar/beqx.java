import android.view.View;
import android.view.View.OnLongClickListener;

class beqx
  implements View.OnLongClickListener
{
  beqx(beqv parambeqv, bequ parambequ) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bequ.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Beqv.a.a(this.jdField_a_of_type_Bequ.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beqx
 * JD-Core Version:    0.7.0.1
 */