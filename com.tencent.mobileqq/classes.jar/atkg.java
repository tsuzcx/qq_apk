import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;

class atkg
  implements View.OnClickListener
{
  atkg(atkc paramatkc, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    if ((atkc.a(this.jdField_a_of_type_Atkc) != null) && (paramView != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getTextId();
      atkc.a(this.jdField_a_of_type_Atkc, (View)paramView.getParent(), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atkg
 * JD-Core Version:    0.7.0.1
 */