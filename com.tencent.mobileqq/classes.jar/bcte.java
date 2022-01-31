import android.view.View;
import android.view.View.OnClickListener;
import java.util.Calendar;

class bcte
  implements View.OnClickListener
{
  bcte(bctc parambctc, bctg parambctg) {}
  
  public void onClick(View paramView)
  {
    if ((bctc.a(this.jdField_a_of_type_Bctc) != null) && (bctc.a(this.jdField_a_of_type_Bctc).isShowing())) {
      bctc.a(this.jdField_a_of_type_Bctc).dismiss();
    }
    if ((this.jdField_a_of_type_Bctg != null) && (bctc.a(this.jdField_a_of_type_Bctc) != null)) {
      this.jdField_a_of_type_Bctg.a(bctc.a(this.jdField_a_of_type_Bctc).getTimeInMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcte
 * JD-Core Version:    0.7.0.1
 */