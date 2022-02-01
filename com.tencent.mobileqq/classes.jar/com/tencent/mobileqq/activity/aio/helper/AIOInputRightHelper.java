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
  private BaseChatPie a;
  private AIOContext b;
  private QQAppInterface c;
  private boolean d;
  
  public AIOInputRightHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.b = paramBaseChatPie.bv();
    this.c = this.b.a();
  }
  
  public void a()
  {
    if ((this.b instanceof RobotContext)) {
      return;
    }
    if (SimpleUIUtil.e()) {
      return;
    }
    EditTextUI localEditTextUI = this.b.p().d().f();
    if (!((HiBoomHelper)this.b.a(18)).a(this.b.b(), localEditTextUI.a().toString(), localEditTextUI)) {
      return;
    }
    Object localObject = this.b.p().d().c().b();
    View localView = this.b.p().d().c().a();
    AIOZhituHelper localAIOZhituHelper = (AIOZhituHelper)this.b.a(116);
    if (localView != null)
    {
      if (localView.getVisibility() != 0)
      {
        localView.setVisibility(0);
        ABTestController.a().a("exp_qq_msg_marketface_input_icon").h();
        localAIOZhituHelper.a = false;
      }
      AIOZhituHelper.a(this.c, (ImageButton)localObject);
      ((ImageButton)localObject).setContentDescription(HardCodeUtil.a(2131899205));
      int j = localView.getWidth();
      int i;
      if (j == 0) {
        i = AIOUtils.b(37.0F, this.b.b().getResources());
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
        ((StringBuilder)localObject).append(localEditTextUI.d());
        QLog.d("ZhituManager", 4, ((StringBuilder)localObject).toString());
      }
      if (localEditTextUI.d() < i) {
        localEditTextUI.a(localEditTextUI.e(), localEditTextUI.f(), i, localEditTextUI.g());
      }
      if (!this.d)
      {
        ReportController.b(this.c, "dc00898", "", "", "0X800932B", "0X800932B", 0, 0, "", "", "", "");
        this.d = true;
      }
    }
  }
  
  public void a(Editable paramEditable)
  {
    EditTextUI localEditTextUI = this.b.p().d().f();
    int j = paramEditable.toString().trim().length();
    int i = 1;
    boolean bool;
    if ((j > 0) && (((HiBoomHelper)this.b.a(18)).a(this.b.b(), paramEditable.toString(), localEditTextUI))) {
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
      ((StringBuilder)localObject).append(((ReceiptHelper)this.b.a(118)).a);
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(ZhituManager.d(this.b.O().a));
      QLog.d("AIOInputRightHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ReplyHelper)this.b.a(119);
    if ((bool) && (!((ReceiptHelper)this.b.a(118)).a) && (ZhituManager.d(this.b.O().a)) && (((ReplyHelper)localObject).a() == null) && (!(this.a instanceof GameRoomChatPie))) {
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
    localObject = ZhituManager.a(this.c);
    if ((!bool) || (!((ZhituManager)localObject).a(paramEditable))) {
      i = 0;
    }
    if (i == 0)
    {
      ((AIOZhituHelper)this.b.a(116)).a();
      b();
    }
    ImageButton localImageButton = this.b.p().d().c().b();
    View localView = this.b.p().d().c().a();
    if (i != 0) {
      if (RichTextChatManager.a(this.c).c(this.c))
      {
        if (localView.getVisibility() == 0)
        {
          if ((paramEditable.length() <= 20) && (((ZhituManager)localObject).a(paramEditable)))
          {
            a();
            return;
          }
          localImageButton.setSelected(false);
          ((AIOZhituHelper)this.b.a(116)).a = false;
          a();
          ((ZhituManager)localObject).o();
          AIOZhituHelper.a(this.c, localImageButton);
          return;
        }
        a();
        if (!((AIODraftHelper)this.b.a(111)).f) {
          ReportController.b(this.c, "CliOper", "", "", "0X80094D0", "0X80094D0", 0, 0, "", "", "", "");
        }
      }
      else
      {
        localView.setVisibility(8);
        localEditTextUI.a(localEditTextUI.e(), localEditTextUI.f(), AIOUtils.b(11.0F, this.b.b().getResources()), localEditTextUI.g());
      }
    }
  }
  
  public void b()
  {
    ImageButton localImageButton = this.b.p().d().c().b();
    View localView = this.b.p().d().c().a();
    EditTextUI localEditTextUI = this.b.p().d().f();
    if ((this.b.b() != null) && (localView != null) && (localView.getVisibility() == 0))
    {
      AIOZhituHelper.a(this.c, localImageButton);
      localView.setVisibility(8);
      ((AIOZhituHelper)this.b.a(116)).a = false;
      localEditTextUI.a(localEditTextUI.e(), localEditTextUI.f(), AIOUtils.b(11.0F, this.b.b().getResources()), localEditTextUI.g());
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
      this.d = false;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOInputRightHelper
 * JD-Core Version:    0.7.0.1
 */