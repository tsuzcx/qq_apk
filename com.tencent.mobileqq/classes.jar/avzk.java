import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;

class avzk
  implements View.OnClickListener
{
  avzk(avzg paramavzg, AutoReplyText paramAutoReplyText) {}
  
  public void onClick(View paramView)
  {
    if ((avzg.a(this.jdField_a_of_type_Avzg) != null) && (paramView != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getTextId();
      avzg.a(this.jdField_a_of_type_Avzg, (View)paramView.getParent(), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avzk
 * JD-Core Version:    0.7.0.1
 */