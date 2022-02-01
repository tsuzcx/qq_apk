import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcht
  implements View.OnClickListener
{
  bcht(bchs parambchs, bcep parambcep) {}
  
  public void onClick(View paramView)
  {
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramView.getTag())) {
      bchs.a(this.jdField_a_of_type_Bchs, paramView.getContext(), this.jdField_a_of_type_Bcep);
    }
    try
    {
      bdll.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "P_CliOper", "Grp_find", "", "grptab", "Clk_join", 0, 0, this.jdField_a_of_type_Bcep.b, "", "", "");
      label64:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcht
 * JD-Core Version:    0.7.0.1
 */