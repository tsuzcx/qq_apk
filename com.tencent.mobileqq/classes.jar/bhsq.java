import android.view.View;
import android.view.View.OnClickListener;
import java.util.Set;

class bhsq
  implements View.OnClickListener
{
  bhsq(bhsp parambhsp, bhsf parambhsf, int paramInt, bhsv parambhsv) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.jdField_a_of_type_Bhsf.jdField_a_of_type_Int == 13)
    {
      if (this.jdField_a_of_type_Bhsf.a()) {
        break label73;
      }
      bool = true;
      if (!bool) {
        break label78;
      }
      bhsp.a(this.jdField_a_of_type_Bhsp).add(Integer.valueOf(this.jdField_a_of_type_Int));
      bhsp.a(this.jdField_a_of_type_Bhsp, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhsf.a(bool);
      this.jdField_a_of_type_Bhsv.a(bool);
      return;
      label73:
      bool = false;
      break;
      label78:
      bhsp.a(this.jdField_a_of_type_Bhsp).remove(Integer.valueOf(this.jdField_a_of_type_Int));
      if (bhsp.a(this.jdField_a_of_type_Bhsp).size() < 1) {
        bhsp.a(this.jdField_a_of_type_Bhsp, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhsq
 * JD-Core Version:    0.7.0.1
 */