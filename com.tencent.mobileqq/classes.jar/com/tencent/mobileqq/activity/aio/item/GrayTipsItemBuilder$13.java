package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vip.AioVipDonateHelper;

class GrayTipsItemBuilder$13
  implements QQFileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$13(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(VasH5PayUtil.e, "QQ会员");
    paramView.putString(VasH5PayUtil.f, "LTMCLUB");
    paramView.putString(VasH5PayUtil.d, "1450000515");
    paramView.putInt(VasH5PayUtil.b, 3);
    paramView.putString(VasH5PayUtil.a, this.a.d.b);
    paramView.putString(VasH5PayUtil.i, AioVipDonateHelper.a().g(this.a.a));
    VasH5PayUtil.a(this.a.c, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.13
 * JD-Core Version:    0.7.0.1
 */