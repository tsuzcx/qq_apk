package com.qq.im.poi;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import mqq.app.AppRuntime;

class LbsCaiShenActivity$9
  extends LbsPackObserver
{
  LbsCaiShenActivity$9(LbsCaiShenActivity paramLbsCaiShenActivity) {}
  
  public void onGetSenderNick(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = ((LbsPackManager)this.this$0.getAppRuntime().getManager(214)).b(LbsCaiShenActivity.access$000(this.this$0).a + "");
      if (!TextUtils.isEmpty(paramBundle)) {
        LbsCaiShenActivity.access$500(this.this$0).setText(paramBundle + "的红包");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsCaiShenActivity.9
 * JD-Core Version:    0.7.0.1
 */