package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.tipmessage;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.msgbox.RIJMsgBoxUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class RIJTipMessageManager$4
  implements View.OnClickListener
{
  RIJTipMessageManager$4(RIJTipMessageManager paramRIJTipMessageManager) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    Object localObject = ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    if ((localObject != null) && (((KandianMsgBoxRedPntInfo)localObject).isFromNotification))
    {
      RIJMsgBoxUtils.a(RIJTipMessageManager.a(this.a).a(), 5, false, ((KandianMsgBoxRedPntInfo)localObject).mMsgId);
      if (Aladdin.getConfig(338).getIntegerFromString("allow_report_in_dau", 0) == 1)
      {
        if (!(RIJTipMessageManager.a(this.a).a() instanceof ReadInJoyNewFeedsActivity)) {
          break label127;
        }
        ((ReadInJoyNewFeedsActivity)RIJTipMessageManager.a(this.a).a()).g(2);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      RIJMsgBoxUtils.a(RIJTipMessageManager.a(this.a).a(), 3);
      break;
      label127:
      if ((RIJTipMessageManager.a(this.a).a() instanceof SplashActivity))
      {
        localObject = RIJJumpUtils.a(RIJTipMessageManager.a(this.a).a());
        if (localObject != null) {
          ((RIJTabFrameBase)localObject).b(2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.tipmessage.RIJTipMessageManager.4
 * JD-Core Version:    0.7.0.1
 */