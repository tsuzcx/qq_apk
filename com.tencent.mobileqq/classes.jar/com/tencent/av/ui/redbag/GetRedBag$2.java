package com.tencent.av.ui.redbag;

import com.tencent.qphone.base.util.QLog;
import mpn;

public class GetRedBag$2
  implements Runnable
{
  public GetRedBag$2(mpn parammpn, int paramInt) {}
  
  public void run()
  {
    this.this$0.a = null;
    QLog.w(this.this$0.i, 1, "getRedBag还没回包，超时结束, resultCode[" + this.a + "]");
    mpn.a(this.this$0, this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.GetRedBag.2
 * JD-Core Version:    0.7.0.1
 */