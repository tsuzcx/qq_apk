package com.tencent.mobileqq.activity.qwallet.widget;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import axwd;
import axwe;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import cooperation.qwallet.plugin.QWalletPicHelper;

class HongBaoPanel$2
  extends axwe
{
  HongBaoPanel$2(HongBaoPanel paramHongBaoPanel, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, Drawable paramDrawable) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    paramURLDrawable = QWalletPicHelper.getDrawableForAIO(this.val$info.resPath, axwd.a);
    HongBaoPanel.access$100(this.this$0).setImageDrawable(paramURLDrawable);
    ((URLDrawable)this.val$backDrawable).setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.2
 * JD-Core Version:    0.7.0.1
 */