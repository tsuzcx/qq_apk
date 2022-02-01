import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bimw
  implements View.OnClickListener
{
  public bimw(OpenCardContainer paramOpenCardContainer) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(true);
    this.a.jdField_a_of_type_Bine.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimw
 * JD-Core Version:    0.7.0.1
 */