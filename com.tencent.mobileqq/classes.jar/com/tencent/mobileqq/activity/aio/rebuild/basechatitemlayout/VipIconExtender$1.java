package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VipIconExtender$1
  implements View.OnClickListener
{
  VipIconExtender$1(VipIconExtender paramVipIconExtender) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof NamePlateCfgInfo)))
    {
      NamePlateCfgInfo localNamePlateCfgInfo = (NamePlateCfgInfo)paramView.getTag();
      if ((localNamePlateCfgInfo.mVipType != 3) && (localNamePlateCfgInfo.mVipType != 259)) {
        break label106;
      }
      VipUtils.a(BaseActivity.sTopActivity.app, VipIconExtender.a(this.a), localNamePlateCfgInfo.mVipType, localNamePlateCfgInfo.mNamePlateId, "mios.p.cl.cztx_qlncmp");
    }
    for (;;)
    {
      ReportController.b(BaseActivity.sTopActivity.app, "dc00898", "", "", "qq_vip", "0X8009CAB", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label106:
      VipUtils.b(BaseActivity.sTopActivity.app, VipIconExtender.b(this.a), "mios.p.cl.cztx_qlncmp");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.VipIconExtender.1
 * JD-Core Version:    0.7.0.1
 */