import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azgp
  implements View.OnClickListener
{
  azgp(azgj paramazgj, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getTextId();
    this.jdField_a_of_type_Azgj.a(i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgp
 * JD-Core Version:    0.7.0.1
 */