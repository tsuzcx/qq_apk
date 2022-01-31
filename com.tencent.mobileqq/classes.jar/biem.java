import android.view.View;
import android.view.View.OnLongClickListener;

class biem
  implements View.OnLongClickListener
{
  biem(biek parambiek, biej parambiej) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_Biej.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Biek.a.a(this.jdField_a_of_type_Biej.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biem
 * JD-Core Version:    0.7.0.1
 */