package com.tencent.mobileqq.activity.aio.helper;

import android.text.Editable;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.tips.RobotContext;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;

public class AIOInputRightHelper
  implements ILifeCycleHelper
{
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  public AIOInputRightHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramBaseChatPie.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext instanceof RobotContext)) {
      return;
    }
    if (SimpleUIUtil.a()) {
      return;
    }
    EditTextUI localEditTextUI = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
    if (!((HiBoomHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(18)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), localEditTextUI.a().toString(), localEditTextUI)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
    AIOZhituHelper localAIOZhituHelper = (AIOZhituHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(116);
    if (localView != null)
    {
      if (localView.getVisibility() != 0)
      {
        localView.setVisibility(0);
        ABTestController.a().a("exp_qq_msg_marketface_input_icon").a();
        localAIOZhituHelper.jdField_a_of_type_Boolean = false;
      }
      AIOZhituHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ImageButton)localObject);
      ((ImageButton)localObject).setContentDescription(HardCodeUtil.a(2131701190));
      int j = localView.getWidth();
      int i;
      if (j == 0) {
        i = AIOUtils.b(37.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getResources());
      } else {
        i = j;
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showZhituIcon.rightPadding.");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" ,pr = ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(",input.getPaddingRight() = ");
        ((StringBuilder)localObject).append(localEditTextUI.a());
        QLog.d("ZhituManager", 4, ((StringBuilder)localObject).toString());
      }
      if (localEditTextUI.a() < i) {
        localEditTextUI.a(localEditTextUI.b(), localEditTextUI.c(), i, localEditTextUI.d());
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800932B", "0X800932B", 0, 0, "", "", "", "");
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void a(Editable paramEditable)
  {
    EditTextUI localEditTextUI = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
    int j = paramEditable.toString().trim().length();
    int i = 1;
    boolean bool;
    if ((j > 0) && (((HiBoomHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(18)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), paramEditable.toString(), localEditTextUI))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("check valid input condition: ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(118)).jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a));
      QLog.d("AIOInputRightHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ReplyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(119);
    if ((bool) && (!((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(118)).jdField_a_of_type_Boolean) && (ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a)) && (((ReplyHelper)localObject).a() == null) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof GameRoomChatPie))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("afterTextChange,isValidInput = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ZhituManager", 2, ((StringBuilder)localObject).toString());
    }
    localObject = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((!bool) || (!((ZhituManager)localObject).a(paramEditable))) {
      i = 0;
    }
    if (i == 0)
    {
      ((AIOZhituHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(116)).a();
      b();
    }
    ImageButton localImageButton = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
    if (i != 0) {
      if (RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        if (localView.getVisibility() == 0)
        {
          if ((paramEditable.length() <= 20) && (((ZhituManager)localObject).a(paramEditable)))
          {
            a();
            return;
          }
          localImageButton.setSelected(false);
          ((AIOZhituHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(116)).jdField_a_of_type_Boolean = false;
          a();
          ((ZhituManager)localObject).c();
          AIOZhituHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localImageButton);
          return;
        }
        a();
        if (!((AIODraftHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(111)).b) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80094D0", "0X80094D0", 0, 0, "", "", "", "");
        }
      }
      else
      {
        localView.setVisibility(8);
        localEditTextUI.a(localEditTextUI.b(), localEditTextUI.c(), AIOUtils.b(11.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getResources()), localEditTextUI.d());
      }
    }
  }
  
  public void b()
  {
    ImageButton localImageButton = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
    EditTextUI localEditTextUI = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() != null) && (localView != null) && (localView.getVisibility() == 0))
    {
      AIOZhituHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localImageButton);
      localView.setVisibility(8);
      ((AIOZhituHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(116)).jdField_a_of_type_Boolean = false;
      localEditTextUI.a(localEditTextUI.b(), localEditTextUI.c(), AIOUtils.b(11.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getResources()), localEditTextUI.d());
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "AIOInputRightHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 15)
    {
      this.jdField_a_of_type_Boolean = false;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOInputRightHelper
 * JD-Core Version:    0.7.0.1
 */