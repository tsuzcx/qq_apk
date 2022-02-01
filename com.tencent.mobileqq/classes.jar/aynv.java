import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aynv
  implements View.OnClickListener
{
  aynv(aynq paramaynq, AutoReplyText paramAutoReplyText, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (aynq.a(this.jdField_a_of_type_Aynq) != null) {
      aynq.a(this.jdField_a_of_type_Aynq).b(this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText, this.jdField_a_of_type_Boolean);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynv
 * JD-Core Version:    0.7.0.1
 */