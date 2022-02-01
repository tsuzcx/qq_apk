import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class armc
  implements View.OnClickListener
{
  public armc(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onClick(View paramView)
  {
    bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E2F", "0X8009E2F", 0, 0, "", "", "", "");
    if (this.a.jdField_a_of_type_Arky != null)
    {
      aroq.a().b(3);
      this.a.jdField_a_of_type_Arky.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armc
 * JD-Core Version:    0.7.0.1
 */