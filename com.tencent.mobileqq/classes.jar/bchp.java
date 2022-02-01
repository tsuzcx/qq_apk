import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bchp
  implements View.OnClickListener
{
  public bchp(StructMsgForGeneralShare paramStructMsgForGeneralShare, Context paramContext, Resources paramResources, PopupWindow paramPopupWindow) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    int k;
    int m;
    try
    {
      ViewGroup localViewGroup = (ViewGroup)((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().mAIORootView.findViewById(2131362701);
      if (localViewGroup == null)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = null;
      }
      int[] arrayOfInt = new int[2];
      ((ViewGroup)localObject).getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1];
      int j = ((ViewGroup)localObject).getHeight();
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionX = localObject[0];
      this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionY = localObject[1];
      k = AIOUtils.dp2px(106.0F, this.jdField_a_of_type_AndroidContentResResources);
      m = paramView.getHeight();
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionY - i + m + k <= j) {
        break label269;
      }
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847014));
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionX, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionY - k);
    for (;;)
    {
      ((oge)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(139)).a(9, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message);
      localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).alpha = 0.5F;
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(new bchq(this));
      break;
      label269:
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847013));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionX, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionY + m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchp
 * JD-Core Version:    0.7.0.1
 */