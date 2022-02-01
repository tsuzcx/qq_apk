import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class basi
  implements View.OnClickListener
{
  basi(basg parambasg, bayo parambayo) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bayo.d))
    {
      bbgk.a(this.jdField_a_of_type_Basg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Basg.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bayo.d);
      bbgk.a("hot_list", "clk_title", new String[] { String.valueOf(1), String.valueOf(this.jdField_a_of_type_Basg.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bbgk.a("hot_list", "clk_title", new String[] { String.valueOf(2), String.valueOf(this.jdField_a_of_type_Basg.jdField_a_of_type_Int) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basi
 * JD-Core Version:    0.7.0.1
 */