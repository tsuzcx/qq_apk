import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class aylo
  implements View.OnClickListener
{
  aylo(aylm paramaylm, ayij paramayij) {}
  
  public void onClick(View paramView)
  {
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramView.getTag())) {
      aylm.a(this.jdField_a_of_type_Aylm, paramView.getContext(), this.jdField_a_of_type_Ayij);
    }
    try
    {
      azmj.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "P_CliOper", "Grp_find", "", "grptab", "Clk_join", 0, 0, this.jdField_a_of_type_Ayij.b, "", "", "");
      return;
    }
    catch (Throwable paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylo
 * JD-Core Version:    0.7.0.1
 */