import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbza
  implements View.OnClickListener
{
  bbza(bbyy parambbyy, bcfm parambcfm) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bcfm.d))
    {
      bcni.a(this.jdField_a_of_type_Bbyy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bbyy.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bcfm.d);
      bcni.a("hot_list", "clk_title", new String[] { String.valueOf(1), String.valueOf(this.jdField_a_of_type_Bbyy.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcni.a("hot_list", "clk_title", new String[] { String.valueOf(2), String.valueOf(this.jdField_a_of_type_Bbyy.jdField_a_of_type_Int) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbza
 * JD-Core Version:    0.7.0.1
 */