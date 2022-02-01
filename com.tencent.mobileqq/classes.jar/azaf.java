import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azaf
  implements View.OnClickListener
{
  azaf(azac paramazac, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Azac.a(this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getTextId());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azaf
 * JD-Core Version:    0.7.0.1
 */