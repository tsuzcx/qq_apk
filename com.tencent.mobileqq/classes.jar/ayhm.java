import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class ayhm
  implements View.OnClickListener
{
  ayhm(ayhk paramayhk, aynp paramaynp) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Aynp.d))
    {
      ayvm.a(this.jdField_a_of_type_Ayhk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ayhk.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aynp.d);
      ayvm.a("hot_list", "clk_title", new String[] { String.valueOf(1), String.valueOf(this.jdField_a_of_type_Ayhk.jdField_a_of_type_Int) });
      return;
    }
    ayvm.a("hot_list", "clk_title", new String[] { String.valueOf(2), String.valueOf(this.jdField_a_of_type_Ayhk.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhm
 * JD-Core Version:    0.7.0.1
 */