import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bafg
  implements View.OnClickListener
{
  public bafg(AbsProfileHeaderView paramAbsProfileHeaderView, View paramView) {}
  
  public void onClick(View paramView)
  {
    azyk.a().c(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafg
 * JD-Core Version:    0.7.0.1
 */