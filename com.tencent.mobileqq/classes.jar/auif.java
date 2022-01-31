import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;

class auif
  implements View.OnClickListener
{
  auif(auib paramauib, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    if ((auib.a(this.jdField_a_of_type_Auib) != null) && (paramView != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getTextId();
      auib.a(this.jdField_a_of_type_Auib, (View)paramView.getParent(), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auif
 * JD-Core Version:    0.7.0.1
 */