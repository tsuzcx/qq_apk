package com.tencent.biz.pubaccount.readinjoy.weaknet;

import com.tencent.qphone.base.util.QLog;
import ndn;
import obz;

public final class WeakNetHelper$1
  implements Runnable
{
  public WeakNetHelper$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = obz.a();
    QLog.d("WeakNetHelper", 1, new Object[] { "actionName = ", this.a, "\n", "r2 = ", str, " r5 = ", this.b });
    ndn.a(null, "", this.a, this.a, 0, 0, str, "", "", this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.weaknet.WeakNetHelper.1
 * JD-Core Version:    0.7.0.1
 */