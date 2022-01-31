import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class awhz
  implements View.OnClickListener
{
  awhz(awhx paramawhx, awod paramawod) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Awod.d))
    {
      awwa.a(this.jdField_a_of_type_Awhx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awhx.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Awod.d);
      awwa.a("hot_list", "clk_title", new String[] { String.valueOf(1), String.valueOf(this.jdField_a_of_type_Awhx.jdField_a_of_type_Int) });
      return;
    }
    awwa.a("hot_list", "clk_title", new String[] { String.valueOf(2), String.valueOf(this.jdField_a_of_type_Awhx.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhz
 * JD-Core Version:    0.7.0.1
 */