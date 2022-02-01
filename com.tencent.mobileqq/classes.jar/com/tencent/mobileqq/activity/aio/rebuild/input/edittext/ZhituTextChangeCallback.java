package com.tencent.mobileqq.activity.aio.rebuild.input.edittext;

import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.AIODraftHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOInputRightHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOZhituHelper;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;

public class ZhituTextChangeCallback
  implements IEditTextChangeCallback
{
  private boolean a = false;
  
  public void a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(AIOContext paramAIOContext, @Nullable String paramString)
  {
    if ((paramAIOContext.O().a == 0) && (PokeItemHelper.f(paramAIOContext.a())))
    {
      if (((ReceiptHelper)paramAIOContext.a(118)).a) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituTextChangeCallback", 2, String.format("showStickerBubbleQuickButtonIfNeeded  peInputSwitch :%dentryType:%d,viewType:%d ", new Object[] { Integer.valueOf(PokeItemHelper.b(paramAIOContext.a(), 9)), Integer.valueOf(PokeItemHelper.b(paramAIOContext.a(), 4)), Integer.valueOf(PokeItemHelper.b(paramAIOContext.a(), 11)) }));
      }
      Object localObject1 = paramAIOContext.p().d().f();
      if (paramString == null) {
        paramString = ((EditTextUI)localObject1).a().toString();
      }
      if ((paramString.isEmpty()) && (StickerBubbleAnimationHelper.a(paramAIOContext.a().getCurrentUin()) > 0))
      {
        Object localObject2 = paramAIOContext.p().d().c().a();
        paramString = paramAIOContext.p().d().c().b();
        ((View)localObject2).setVisibility(0);
        ABTestController.a().a("exp_qq_msg_marketface_input_icon").h();
        paramString.setImageDrawable(StickerBubbleAnimationHelper.b(paramAIOContext.a().getCurrentUin()));
        int j = ((View)localObject2).getWidth();
        int i;
        if (j == 0) {
          i = AIOUtils.b(37.0F, paramAIOContext.b().getResources());
        } else {
          i = j;
        }
        if (((EditTextUI)localObject1).d() < i) {
          ((EditTextUI)localObject1).a(((EditTextUI)localObject1).e(), ((EditTextUI)localObject1).f(), i, ((EditTextUI)localObject1).g());
        }
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("showZhituIcon.rightPadding.");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" ,pr = ");
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append(",input.getPaddingRight() = ");
          ((StringBuilder)localObject2).append(((EditTextUI)localObject1).d());
          QLog.d("ZhituManager", 4, ((StringBuilder)localObject2).toString());
        }
        if (AppSetting.e)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131899198));
          ((StringBuilder)localObject1).append(PEPanelHelper.a(StickerBubbleAnimationHelper.a(paramAIOContext.a().getCurrentUin())));
          paramString.setContentDescription(((StringBuilder)localObject1).toString());
        }
        if (!this.a)
        {
          ReportController.b(paramAIOContext.a(), "dc00898", "", "", "0X8009272", "0X8009272", StickerBubbleAnimationHelper.a(paramAIOContext.a().getCurrentUin()), 0, "", "", "", "");
          this.a = true;
        }
      }
    }
  }
  
  public boolean a(AIOContext paramAIOContext, Editable paramEditable)
  {
    AIODraftHelper localAIODraftHelper = (AIODraftHelper)paramAIOContext.a(111);
    if (localAIODraftHelper.f)
    {
      boolean bool;
      if (paramEditable.length() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      localAIODraftHelper.f = bool;
    }
    ((AIOInputRightHelper)paramAIOContext.a(117)).a(paramEditable);
    a(paramAIOContext, paramEditable.toString());
    ((AIOZhituHelper)paramAIOContext.a(116)).a(paramEditable);
    return false;
  }
  
  public void b(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.edittext.ZhituTextChangeCallback
 * JD-Core Version:    0.7.0.1
 */