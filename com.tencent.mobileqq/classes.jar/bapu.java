import android.view.View;
import android.view.View.OnClickListener;
import java.util.Calendar;

class bapu
  implements View.OnClickListener
{
  bapu(baps parambaps, bapw parambapw) {}
  
  public void onClick(View paramView)
  {
    if ((baps.a(this.jdField_a_of_type_Baps) != null) && (baps.a(this.jdField_a_of_type_Baps).isShowing())) {
      baps.a(this.jdField_a_of_type_Baps).dismiss();
    }
    if ((this.jdField_a_of_type_Bapw != null) && (baps.a(this.jdField_a_of_type_Baps) != null)) {
      this.jdField_a_of_type_Bapw.a(baps.a(this.jdField_a_of_type_Baps).getTimeInMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bapu
 * JD-Core Version:    0.7.0.1
 */