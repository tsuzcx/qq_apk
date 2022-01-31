import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class avie
  implements View.OnClickListener
{
  avie(avic paramavic, avoi paramavoi) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Avoi.d))
    {
      avwf.a(this.jdField_a_of_type_Avic.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Avic.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Avoi.d);
      avwf.a("hot_list", "clk_title", new String[] { String.valueOf(1), String.valueOf(this.jdField_a_of_type_Avic.jdField_a_of_type_Int) });
      return;
    }
    avwf.a("hot_list", "clk_title", new String[] { String.valueOf(2), String.valueOf(this.jdField_a_of_type_Avic.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avie
 * JD-Core Version:    0.7.0.1
 */