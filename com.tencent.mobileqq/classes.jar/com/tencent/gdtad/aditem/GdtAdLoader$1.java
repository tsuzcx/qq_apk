package com.tencent.gdtad.aditem;

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
import yjm;
import yjo;
import ynv;
import yny;
import yoy;
import yoz;
import ypa;
import ypc;
import ypd;

public class GdtAdLoader$1
  implements Runnable
{
  public GdtAdLoader$1(yjm paramyjm, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdLoaderWithJSON.Session localSession = null;
    yny.b("GdtAdLoader", "load");
    ypc.a().a((Context)this.a.get(), new ypd());
    if (this.a != null)
    {
      localObject = (Context)this.a.get();
      AdReporterForAnalysis.reportForLoadAdStart((Context)localObject);
      if ((this.a != null) && (this.a.get() != null) && (yjm.a(this.this$0) != null) && (yjm.a(this.this$0).a())) {
        break label111;
      }
    }
    label111:
    do
    {
      do
      {
        yjm.a(this.this$0);
        return;
        localObject = null;
        break;
        yjm.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.support_https.set(true);
        localObject = new yoz();
        ((yoz)localObject).a = "d61533";
        ypa localypa = yoy.a((Context)this.a.get(), (yoz)localObject);
        localObject = localSession;
        if (localypa != null) {
          localObject = localypa.a;
        }
        if (localObject != null) {
          yjm.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.device_info.set((MessageMicro)localObject);
        }
        localObject = ynv.a(yjm.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
      } while ((localObject == null) || (!(localObject instanceof JSONObject)));
      localSession = new AdLoaderWithJSON.Session();
      localSession.request = ((JSONObject)JSONObject.class.cast(localObject));
      AdLoaderWithJSON.load(localSession);
      yjm.a(this.this$0).jdField_a_of_type_Long = localSession.timeMillis;
      yjm.a(this.this$0).jdField_a_of_type_Int = localSession.httpResponseCode;
    } while ((localSession.httpResponseCode != 200) || (localSession.response == null) || (localSession.response == JSONObject.NULL));
    yjm.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp(), localSession.response)));
    Object localObject = (Context)this.a.get();
    long l = yjm.a(this.this$0).jdField_a_of_type_Long;
    int j = yjm.a(this.this$0).jdField_a_of_type_Int;
    int k = yjm.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
    if (yjm.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() > 0) {}
    for (int i = ((qq_ad_get.QQAdGetRsp.PosAdInfo)yjm.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();; i = -2147483648)
    {
      AdReporterForAnalysis.reportForLoadAdEnd((Context)localObject, l, j, k, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.1
 * JD-Core Version:    0.7.0.1
 */