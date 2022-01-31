import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;

final class arbx
  implements View.OnClickListener
{
  arbx(Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity))
    {
      arni.a(((BasePluginActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity(), this.jdField_a_of_type_JavaLangString);
      return;
    }
    arni.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbx
 * JD-Core Version:    0.7.0.1
 */