package com.tencent.gdtad.aditem;

import aaie;
import aaig;
import aano;
import aanp;
import aaoo;
import aaop;
import aaoq;
import aaos;
import aaot;
import android.content.Context;
import com.tencent.ad.tangram.loader.AdLoaderWithJSON;
import com.tencent.ad.tangram.loader.AdLoaderWithJSON.Session;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class GdtAdLoader$1
  implements Runnable
{
  public GdtAdLoader$1(aaie paramaaie, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdLoaderWithJSON.Session localSession = null;
    aanp.b("GdtAdLoader", "load");
    aaos.a().a((Context)this.a.get(), new aaot());
    if (this.a != null)
    {
      localObject = (Context)this.a.get();
      AdReporterForAnalysis.reportForLoadAdStart((Context)localObject);
      if ((this.a != null) && (this.a.get() != null) && (aaie.a(this.this$0) != null) && (aaie.a(this.this$0).a())) {
        break label111;
      }
    }
    label111:
    do
    {
      do
      {
        aaie.a(this.this$0);
        return;
        localObject = null;
        break;
        aaie.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.support_https.set(true);
        localObject = new aaop();
        ((aaop)localObject).a = "d61533";
        aaoq localaaoq = aaoo.a((Context)this.a.get(), (aaop)localObject);
        localObject = localSession;
        if (localaaoq != null) {
          localObject = localaaoq.a;
        }
        if (localObject != null) {
          aaie.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.device_info.set((MessageMicro)localObject);
        }
        localObject = aano.a(aaie.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
      } while ((localObject == null) || (!(localObject instanceof JSONObject)));
      localSession = new AdLoaderWithJSON.Session();
      localSession.request = ((JSONObject)JSONObject.class.cast(localObject));
      AdLoaderWithJSON.load(localSession);
      aaie.a(this.this$0).jdField_a_of_type_Long = localSession.timeMillis;
      aaie.a(this.this$0).jdField_a_of_type_Int = localSession.httpResponseCode;
    } while ((localSession.httpResponseCode != 200) || (localSession.response == null) || (localSession.response == JSONObject.NULL));
    aaie.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(aano.a(new qq_ad_get.QQAdGetRsp(), localSession.response)));
    Object localObject = (Context)this.a.get();
    long l = aaie.a(this.this$0).jdField_a_of_type_Long;
    int j = aaie.a(this.this$0).jdField_a_of_type_Int;
    int k = aaie.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
    if (aaie.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() > 0) {}
    for (int i = ((qq_ad_get.QQAdGetRsp.PosAdInfo)aaie.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();; i = -2147483648)
    {
      AdReporterForAnalysis.reportForLoadAdEnd((Context)localObject, l, j, k, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.1
 * JD-Core Version:    0.7.0.1
 */