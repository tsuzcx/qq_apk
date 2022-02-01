import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axtw
  implements View.OnClickListener
{
  axtw(axtr paramaxtr, AutoReplyText paramAutoReplyText, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (axtr.a(this.jdField_a_of_type_Axtr) != null) {
      axtr.a(this.jdField_a_of_type_Axtr).b(this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText, this.jdField_a_of_type_Boolean);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtw
 * JD-Core Version:    0.7.0.1
 */