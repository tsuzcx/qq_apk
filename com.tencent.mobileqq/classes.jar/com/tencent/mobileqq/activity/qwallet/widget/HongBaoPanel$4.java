package com.tencent.mobileqq.activity.qwallet.widget;

import aemp;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class HongBaoPanel$4
  implements aemp
{
  HongBaoPanel$4(HongBaoPanel paramHongBaoPanel, String paramString, ImageView paramImageView, int paramInt) {}
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongBaoPanel", 2, "templateId = " + this.val$templateId + ",action info.icon = " + paramRedPacketInfo.icon + ",imageView.getTag() = " + this.val$imageView.getTag() + ",info.skinType = " + paramRedPacketInfo.skinType);
    }
    if (this.val$templateId.equals(this.val$imageView.getTag()))
    {
      if (paramRedPacketInfo.icon != null) {
        this.val$imageView.setImageBitmap(paramRedPacketInfo.icon);
      }
    }
    else {
      return;
    }
    HongBaoPanel.access$600(this.this$0).add(Integer.valueOf(this.val$pos));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel.4
 * JD-Core Version:    0.7.0.1
 */