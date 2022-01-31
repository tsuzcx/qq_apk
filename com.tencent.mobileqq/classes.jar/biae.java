import android.view.View;
import android.view.View.OnClickListener;

class biae
  implements View.OnClickListener
{
  biae(biad parambiad, biac parambiac) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Biac.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Biad.a.a(this.jdField_a_of_type_Biac.itemView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biae
 * JD-Core Version:    0.7.0.1
 */