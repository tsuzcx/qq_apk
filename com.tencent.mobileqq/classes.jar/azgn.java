import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azgn
  implements View.OnClickListener
{
  azgn(azgj paramazgj, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    if ((azgj.a(this.jdField_a_of_type_Azgj) != null) && (paramView != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getTextId();
      azgj.a(this.jdField_a_of_type_Azgj, (View)paramView.getParent(), i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgn
 * JD-Core Version:    0.7.0.1
 */