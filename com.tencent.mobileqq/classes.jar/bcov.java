import android.view.View;
import android.view.View.OnClickListener;
import java.util.Calendar;

class bcov
  implements View.OnClickListener
{
  bcov(bcot parambcot, bcox parambcox) {}
  
  public void onClick(View paramView)
  {
    if ((bcot.a(this.jdField_a_of_type_Bcot) != null) && (bcot.a(this.jdField_a_of_type_Bcot).isShowing())) {
      bcot.a(this.jdField_a_of_type_Bcot).dismiss();
    }
    if ((this.jdField_a_of_type_Bcox != null) && (bcot.a(this.jdField_a_of_type_Bcot) != null)) {
      this.jdField_a_of_type_Bcox.a(bcot.a(this.jdField_a_of_type_Bcot).getTimeInMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcov
 * JD-Core Version:    0.7.0.1
 */