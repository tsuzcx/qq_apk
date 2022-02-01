package com.tencent.mobileqq.ark.API;

import acoh;
import acoj;
import acvb;
import apwi;
import apwj;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;

public class ArkAppNotifyCenter$GdtNotify$3
  implements Runnable
{
  public ArkAppNotifyCenter$GdtNotify$3(apwi paramapwi, String paramString1, WeakReference paramWeakReference1, boolean paramBoolean, String paramString2, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    try
    {
      this.this$0.a = new apwj(this);
      acoj localacoj = new acoj();
      localacoj.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(acvb.a(new qq_ad_get.QQAdGet(), new JSONObject(this.jdField_b_of_type_JavaLangString))));
      new acoh(localacoj, new WeakReference(this.this$0.a)).a(this.jdField_b_of_type_JavaLangRefWeakReference);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ark.ArkAppNotifyCenter", 1, "ark.notify error!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.3
 * JD-Core Version:    0.7.0.1
 */