import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class axvi
  implements View.OnClickListener
{
  public axvi(StructMsgForGeneralShare paramStructMsgForGeneralShare, Context paramContext, Resources paramResources, PopupWindow paramPopupWindow) {}
  
  public void onClick(View paramView)
  {
    int k;
    int m;
    try
    {
      ViewGroup localViewGroup = (ViewGroup)((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().c.findViewById(2131362550);
      if (localViewGroup == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        arrayOfInt1 = null;
      }
      int[] arrayOfInt2 = new int[2];
      arrayOfInt1.getLocationOnScreen(arrayOfInt2);
      int i = arrayOfInt2[1];
      int j = arrayOfInt1.getHeight();
      int[] arrayOfInt1 = new int[2];
      paramView.getLocationOnScreen(arrayOfInt1);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionX = arrayOfInt1[0];
      this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionY = arrayOfInt1[1];
      k = actj.a(106.0F, this.jdField_a_of_type_AndroidContentResResources);
      m = paramView.getHeight();
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionY - i + m + k <= j) {
        break label257;
      }
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846195));
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionX, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionY - k);
    for (;;)
    {
      ((nqu)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(139)).a(9, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message);
      paramView = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getAttributes();
      paramView.alpha = 0.5F;
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().setAttributes(paramView);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(new axvj(this));
      return;
      label257:
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846194));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionX, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionY + m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvi
 * JD-Core Version:    0.7.0.1
 */