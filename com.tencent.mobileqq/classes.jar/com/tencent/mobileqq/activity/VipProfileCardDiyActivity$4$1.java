package com.tencent.mobileqq.activity;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.util.WeakReferenceHandler;

class VipProfileCardDiyActivity$4$1
  implements Runnable
{
  VipProfileCardDiyActivity$4$1(VipProfileCardDiyActivity.4 param4, Card paramCard) {}
  
  public void run()
  {
    if (this.b.a.a((int)this.a.lCurrentStyleId, (int)this.a.lCurrentBgId, this.a.backgroundUrl, (int)this.a.backgroundColor, this.a.templateRet)) {
      this.b.a.ak.sendEmptyMessage(0);
    } else {
      this.b.a.ak.sendEmptyMessage(1);
    }
    VasWebviewUtil.a("", "card_mall", "0X80081C2", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "0", String.valueOf(this.b.a.af));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.4.1
 * JD-Core Version:    0.7.0.1
 */