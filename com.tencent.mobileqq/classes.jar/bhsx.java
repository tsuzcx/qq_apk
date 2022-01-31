import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.List;

class bhsx
  implements View.OnClickListener
{
  bhsx(bhsw parambhsw, bhsy parambhsy, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (bhsw.a(this.jdField_a_of_type_Bhsw) != this.jdField_a_of_type_Bhsy.getLayoutPosition()) {
      bhci.a().f(this.jdField_a_of_type_JavaLangString);
    }
    if (bhsw.a(this.jdField_a_of_type_Bhsw) == -1)
    {
      bhsw.a(this.jdField_a_of_type_Bhsw).a(this.jdField_a_of_type_JavaLangString, ((bhsi)bhsh.a.get(0)).jdField_a_of_type_JavaLangString, ((bhsi)bhsh.a.get(0)).b);
      bhsw.a(this.jdField_a_of_type_Bhsw).a(true, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhsw.a();
      bhsw.a(this.jdField_a_of_type_Bhsw, this.jdField_a_of_type_Bhsy.getLayoutPosition());
      ((bhsg)bhsw.a(this.jdField_a_of_type_Bhsw).get(bhsw.a(this.jdField_a_of_type_Bhsw) - 1)).a(true);
      this.jdField_a_of_type_Bhsy.a(true);
      return;
      bhsw.a(this.jdField_a_of_type_Bhsw).a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhsx
 * JD-Core Version:    0.7.0.1
 */