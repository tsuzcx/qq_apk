import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbyx
  implements View.OnClickListener
{
  bbyx(bbyv parambbyv, bcfe parambcfe) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bcfe.d))
    {
      bcnc.a(this.jdField_a_of_type_Bbyv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bbyv.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bcfe.d);
      bcnc.a("hot_list", "clk_title", new String[] { String.valueOf(1), String.valueOf(this.jdField_a_of_type_Bbyv.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcnc.a("hot_list", "clk_title", new String[] { String.valueOf(2), String.valueOf(this.jdField_a_of_type_Bbyv.jdField_a_of_type_Int) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyx
 * JD-Core Version:    0.7.0.1
 */