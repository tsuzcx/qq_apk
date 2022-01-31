import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class awql
  implements View.OnClickListener
{
  awql(awqj paramawqj, awng paramawng) {}
  
  public void onClick(View paramView)
  {
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramView.getTag())) {
      awqj.a(this.jdField_a_of_type_Awqj, paramView.getContext(), this.jdField_a_of_type_Awng);
    }
    try
    {
      axqy.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "P_CliOper", "Grp_find", "", "grptab", "Clk_join", 0, 0, this.jdField_a_of_type_Awng.b, "", "", "");
      return;
    }
    catch (Throwable paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awql
 * JD-Core Version:    0.7.0.1
 */