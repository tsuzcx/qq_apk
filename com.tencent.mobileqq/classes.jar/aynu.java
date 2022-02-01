import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aynu
  implements View.OnClickListener
{
  aynu(aynq paramaynq, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    if ((aynq.a(this.jdField_a_of_type_Aynq) != null) && (paramView != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getTextId();
      aynq.a(this.jdField_a_of_type_Aynq, (View)paramView.getParent(), i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynu
 * JD-Core Version:    0.7.0.1
 */