package com.tencent.mobileqq.ark.API;

import alpv;
import alpw;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import ysn;
import ysp;
import yxo;

public class ArkAppNotifyCenter$GdtNotify$3
  implements Runnable
{
  public ArkAppNotifyCenter$GdtNotify$3(alpv paramalpv, String paramString1, WeakReference paramWeakReference1, boolean paramBoolean, String paramString2, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    try
    {
      this.this$0.a = new alpw(this);
      ysp localysp = new ysp();
      localysp.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(yxo.a(new qq_ad_get.QQAdGet(), new JSONObject(this.jdField_b_of_type_JavaLangString))));
      new ysn(localysp, new WeakReference(this.this$0.a)).a(this.jdField_b_of_type_JavaLangRefWeakReference);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ark.ArkAppNotifyCenter", 1, "ark.notify error!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.3
 * JD-Core Version:    0.7.0.1
 */