import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class attx
  implements View.OnClickListener
{
  attx(Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity)) {
      auea.a(((BasePluginActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity(), this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      auea.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attx
 * JD-Core Version:    0.7.0.1
 */