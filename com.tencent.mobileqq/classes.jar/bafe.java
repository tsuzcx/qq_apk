import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bafe
  implements View.OnClickListener
{
  public bafe(AbsProfileHeaderView paramAbsProfileHeaderView, azxr paramazxr) {}
  
  public void onClick(View paramView)
  {
    AbsProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView, this.jdField_a_of_type_Azxr);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafe
 * JD-Core Version:    0.7.0.1
 */