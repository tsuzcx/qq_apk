import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axtv
  implements View.OnClickListener
{
  axtv(axtr paramaxtr, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    if ((axtr.a(this.jdField_a_of_type_Axtr) != null) && (paramView != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getTextId();
      axtr.a(this.jdField_a_of_type_Axtr, (View)paramView.getParent(), i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtv
 * JD-Core Version:    0.7.0.1
 */