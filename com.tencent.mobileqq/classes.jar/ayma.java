import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class ayma
  extends ayly
  implements View.OnClickListener
{
  protected acis a;
  protected String a;
  protected Context b;
  protected View b;
  protected String b;
  protected boolean b;
  
  public ayma()
  {
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  boolean a()
  {
    return (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8);
  }
  
  protected void c()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void d()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_AndroidContentContext = null;
    this.jdField_b_of_type_JavaLangString = null;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Acis != null) {
      this.jdField_a_of_type_Acis.a(null);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!baip.a(this.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      paramView.getContext().startActivity(localIntent);
      return;
    }
    if (this.jdField_a_of_type_Acis != null) {
      this.jdField_a_of_type_Acis.a(null);
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "sys_msg", "Clk_notice", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayma
 * JD-Core Version:    0.7.0.1
 */