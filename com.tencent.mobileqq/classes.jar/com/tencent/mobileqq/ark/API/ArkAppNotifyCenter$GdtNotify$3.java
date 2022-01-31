package com.tencent.mobileqq.ark.API;

import aaie;
import aaig;
import aano;
import angm;
import angn;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;

public class ArkAppNotifyCenter$GdtNotify$3
  implements Runnable
{
  public ArkAppNotifyCenter$GdtNotify$3(angm paramangm, String paramString1, WeakReference paramWeakReference1, boolean paramBoolean, String paramString2, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    try
    {
      this.this$0.a = new angn(this);
      aaig localaaig = new aaig();
      localaaig.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(aano.a(new qq_ad_get.QQAdGet(), new JSONObject(this.jdField_b_of_type_JavaLangString))));
      new aaie(localaaig, new WeakReference(this.this$0.a)).a(this.jdField_b_of_type_JavaLangRefWeakReference);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ark.ArkAppNotifyCenter", 1, "ark.notify error!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.3
 * JD-Core Version:    0.7.0.1
 */