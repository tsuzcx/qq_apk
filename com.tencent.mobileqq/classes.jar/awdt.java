import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;

class awdt
  implements View.OnClickListener
{
  awdt(awdp paramawdp, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    if ((awdp.a(this.jdField_a_of_type_Awdp) != null) && (paramView != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getTextId();
      awdp.a(this.jdField_a_of_type_Awdp, (View)paramView.getParent(), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awdt
 * JD-Core Version:    0.7.0.1
 */