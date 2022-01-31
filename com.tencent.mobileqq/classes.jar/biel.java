import android.view.View;
import android.view.View.OnClickListener;

class biel
  implements View.OnClickListener
{
  biel(biek parambiek, biej parambiej) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Biej.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Biek.a.a(this.jdField_a_of_type_Biej.itemView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biel
 * JD-Core Version:    0.7.0.1
 */