import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awbr
  implements View.OnClickListener
{
  public awbr(UiApiPlugin paramUiApiPlugin, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbr
 * JD-Core Version:    0.7.0.1
 */