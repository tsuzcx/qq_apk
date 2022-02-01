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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bdph
  implements View.OnClickListener
{
  public bdph(StructMsgForGeneralShare paramStructMsgForGeneralShare, Context paramContext, PopupWindow paramPopupWindow) {}
  
  public void onClick(View paramView)
  {
    QLog.d(StructMsgForGeneralShare.access$000(), 1, "filter_ad");
    ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message);
    ((oer)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(139)).a(7, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message);
    QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131692048), 1).a();
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdph
 * JD-Core Version:    0.7.0.1
 */