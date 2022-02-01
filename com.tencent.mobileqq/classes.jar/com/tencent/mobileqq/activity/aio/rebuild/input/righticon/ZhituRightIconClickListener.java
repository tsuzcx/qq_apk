package com.tencent.mobileqq.activity.aio.rebuild.input.righticon;

import android.view.View;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.IOnRightIconClickListener;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOZhituHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class ZhituRightIconClickListener
  implements IOnRightIconClickListener
{
  public void a(AIOContext paramAIOContext, View paramView)
  {
    AIOZhituHelper localAIOZhituHelper = (AIOZhituHelper)paramAIOContext.a(116);
    localAIOZhituHelper.a ^= true;
    ImageButton localImageButton = paramAIOContext.a().a().a().a();
    AIOZhituHelper.a(paramAIOContext.a(), localImageButton);
    localImageButton.setActivated(localAIOZhituHelper.a);
    if (localAIOZhituHelper.a) {
      paramAIOContext.a().a(28, false);
    } else {
      paramAIOContext.a().a(true);
    }
    ((AIODtReportHelper)paramAIOContext.a(101)).a(paramView);
  }
  
  public boolean a(AIOContext paramAIOContext, View paramView)
  {
    if (!ZhituManager.a(paramAIOContext.a()).a(paramAIOContext.a().a().a().a()))
    {
      QQToast.a(paramAIOContext.a(), HardCodeUtil.a(2131701202), 0).a();
      ReportController.b(paramAIOContext.a(), "dc00898", "", "", "0X800932D", "0X800932D", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.righticon.ZhituRightIconClickListener
 * JD-Core Version:    0.7.0.1
 */