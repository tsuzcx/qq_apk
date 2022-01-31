import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class awqj
  implements View.OnClickListener
{
  awqj(awqh paramawqh, awne paramawne) {}
  
  public void onClick(View paramView)
  {
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramView.getTag())) {
      awqh.a(this.jdField_a_of_type_Awqh, paramView.getContext(), this.jdField_a_of_type_Awne);
    }
    try
    {
      axqw.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "P_CliOper", "Grp_find", "", "grptab", "Clk_join", 0, 0, this.jdField_a_of_type_Awne.b, "", "", "");
      return;
    }
    catch (Throwable paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqj
 * JD-Core Version:    0.7.0.1
 */