package com.qq.im.poi;

import com.tencent.mobileqq.armap.JniCommon;
import mqq.app.AppRuntime;

class LbsCaiShenActivity$2
  implements Runnable
{
  LbsCaiShenActivity$2(LbsCaiShenActivity paramLbsCaiShenActivity) {}
  
  public void run()
  {
    JniCommon.nativeSetCallback();
    JniCommon.nativeSetAnswer(LbsCaiShenActivity.access$000(this.this$0).c);
    LbsPackManager localLbsPackManager = (LbsPackManager)this.this$0.getAppRuntime().getManager(214);
    JniCommon.nativeSetIconUin(String.valueOf(LbsCaiShenActivity.access$000(this.this$0).a));
    JniCommon.nativeSetModelLogo(localLbsPackManager.c(String.valueOf(LbsCaiShenActivity.access$000(this.this$0).a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsCaiShenActivity.2
 * JD-Core Version:    0.7.0.1
 */