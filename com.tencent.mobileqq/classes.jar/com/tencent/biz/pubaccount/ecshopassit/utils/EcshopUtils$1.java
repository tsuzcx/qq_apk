package com.tencent.biz.pubaccount.ecshopassit.utils;

import acoo;
import adab;
import bdol;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import oek;
import ofz;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class EcshopUtils$1
  implements Runnable
{
  public EcshopUtils$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    do
    {
      try
      {
        localObject1 = this.a;
        if (localObject1 == null) {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        int i;
        Object localObject3;
        QLog.e("Ecshop_EcshopUtils", 1, QLog.getStackTraceString(localThrowable));
        return;
      }
      finally
      {
        if (this.a.a() == null) {
          break label290;
        }
        this.a.a().a("3046055438", 1008, false);
      }
      i = this.a.a().a("3046055438", 1008);
      if (i != 0) {
        break;
      }
    } while (this.a.a() == null);
    this.a.a().a("3046055438", 1008, false);
    return;
    localObject1 = this.a.a().b("3046055438", 1008);
    localObject3 = ofz.a((MessageRecord)localObject1);
    if ((localObject3 != null) && (((bdol)localObject3).c != 100))
    {
      localObject1 = oek.a((MessageRecord)localObject1);
      if (localObject1 != null) {
        acoo.a().a(new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1));
      }
    }
    while (this.a.a() != null)
    {
      this.a.a().a("3046055438", 1008, false);
      return;
      if ((localObject1 instanceof MessageForArkApp))
      {
        localObject3 = ofz.a((MessageRecord)localObject1);
        if ((localObject3 != null) && (String.valueOf(1).equals(((JSONObject)localObject3).optString("action_type"))))
        {
          localObject1 = oek.a((MessageRecord)localObject1);
          if (localObject1 != null) {
            acoo.a().a(new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.utils.EcshopUtils.1
 * JD-Core Version:    0.7.0.1
 */