package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VipExtendIconExtender$1
  implements View.OnClickListener
{
  VipExtendIconExtender$1(VipExtendIconExtender paramVipExtendIconExtender) {}
  
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("vip_card_extension jumpUrl=");
      localStringBuilder.append(str);
      QLog.d("VipExtendIconExtender", 2, localStringBuilder.toString());
    }
    if (!StringUtil.isEmpty(str)) {
      VasWebviewUtil.a(VipExtendIconExtender.a(this.a), str, 256L, null, false, -1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.VipExtendIconExtender.1
 * JD-Core Version:    0.7.0.1
 */