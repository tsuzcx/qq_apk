import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class awvg
  implements View.OnClickListener
{
  public awvg(StructMsgForGeneralShare paramStructMsgForGeneralShare, PopupWindow paramPopupWindow, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QLog.d(StructMsgForGeneralShare.access$000(), 1, "delete_ad");
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
    ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message);
    ((nfw)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(139)).a(8, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message);
    bbmy.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131626779), 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awvg
 * JD-Core Version:    0.7.0.1
 */