import android.view.View;
import android.view.View.OnClickListener;
import java.util.Calendar;

class baqi
  implements View.OnClickListener
{
  baqi(baqg parambaqg, baqk parambaqk) {}
  
  public void onClick(View paramView)
  {
    if ((baqg.a(this.jdField_a_of_type_Baqg) != null) && (baqg.a(this.jdField_a_of_type_Baqg).isShowing())) {
      baqg.a(this.jdField_a_of_type_Baqg).dismiss();
    }
    if ((this.jdField_a_of_type_Baqk != null) && (baqg.a(this.jdField_a_of_type_Baqg) != null)) {
      this.jdField_a_of_type_Baqk.a(baqg.a(this.jdField_a_of_type_Baqg).getTimeInMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baqi
 * JD-Core Version:    0.7.0.1
 */