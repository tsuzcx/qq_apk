package com.tencent.mobileqq.ark.api.notify;

import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;

class GdtNotify$3
  implements Runnable
{
  GdtNotify$3(GdtNotify paramGdtNotify, String paramString1, WeakReference paramWeakReference1, boolean paramBoolean, String paramString2, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    try
    {
      this.this$0.b = new GdtNotify.3.1(this);
      GdtAdLoader.Session localSession = new GdtAdLoader.Session();
      localSession.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGet(), new JSONObject(this.d))));
      new GdtAdLoader(localSession, new WeakReference(this.this$0.b)).a(this.e);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtNotify", 1, "ark.notify error!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.3
 * JD-Core Version:    0.7.0.1
 */