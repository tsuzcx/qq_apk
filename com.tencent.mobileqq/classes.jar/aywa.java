import android.view.View;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.now.message.MessageReceivingAdapter;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class aywa
  extends aywe
{
  public aywa(MessageReceivingAdapter paramMessageReceivingAdapter, int paramInt, MessageForStructing paramMessageForStructing, StructMsgForGeneralShare paramStructMsgForGeneralShare) {}
  
  public boolean onClick(View paramView)
  {
    ayxc.b(this.jdField_a_of_type_Int + 1, ayvz.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), "1");
    if (MessageReceivingAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare)) {
      return true;
    }
    return super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywa
 * JD-Core Version:    0.7.0.1
 */