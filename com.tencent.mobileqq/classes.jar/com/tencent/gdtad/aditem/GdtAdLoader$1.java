package com.tencent.gdtad.aditem;

import acoh;
import acoj;
import acvb;
import acvc;
import acwb;
import acwc;
import acwd;
import acwf;
import acwg;
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
  public GdtAdLoader$1(acoh paramacoh, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdLoaderWithJSON.Session localSession = null;
    acvc.b("GdtAdLoader", "load");
    acwf.a().a((Context)this.a.get(), new acwg());
    if (this.a != null)
    {
      localObject = (Context)this.a.get();
      AdReporterForAnalysis.reportForLoadAdStart((Context)localObject);
      if ((this.a != null) && (this.a.get() != null) && (acoh.a(this.this$0) != null) && (acoh.a(this.this$0).a())) {
        break label111;
      }
    }
    label111:
    do
    {
      do
      {
        acoh.a(this.this$0);
        return;
        localObject = null;
        break;
        acoh.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.support_https.set(true);
        localObject = new acwc();
        ((acwc)localObject).a = "d61533";
        acwd localacwd = acwb.a((Context)this.a.get(), (acwc)localObject);
        localObject = localSession;
        if (localacwd != null) {
          localObject = localacwd.a;
        }
        if (localObject != null) {
          acoh.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.device_info.set((MessageMicro)localObject);
        }
        localObject = acvb.a(acoh.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
      } while ((localObject == null) || (!(localObject instanceof JSONObject)));
      localSession = new AdLoaderWithJSON.Session();
      localSession.request = ((JSONObject)JSONObject.class.cast(localObject));
      AdLoaderWithJSON.load(localSession);
      acoh.a(this.this$0).jdField_a_of_type_Long = localSession.timeMillis;
      acoh.a(this.this$0).jdField_a_of_type_Int = localSession.httpResponseCode;
    } while ((localSession.httpResponseCode != 200) || (localSession.response == null) || (JSONObject.NULL.equals(localSession.response)));
    acoh.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(acvb.a(new qq_ad_get.QQAdGetRsp(), localSession.response)));
    Object localObject = (Context)this.a.get();
    long l = acoh.a(this.this$0).jdField_a_of_type_Long;
    int j = acoh.a(this.this$0).jdField_a_of_type_Int;
    int k = acoh.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
    if (acoh.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() > 0) {}
    for (int i = ((qq_ad_get.QQAdGetRsp.PosAdInfo)acoh.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();; i = -2147483648)
    {
      AdReporterForAnalysis.reportForLoadAdEnd((Context)localObject, l, j, k, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.1
 * JD-Core Version:    0.7.0.1
 */