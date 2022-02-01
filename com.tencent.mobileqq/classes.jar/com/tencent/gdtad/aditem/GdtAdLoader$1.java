package com.tencent.gdtad.aditem;

import android.content.Context;
import com.tencent.ad.tangram.loader.AdLoaderWithJSON;
import com.tencent.ad.tangram.loader.AdLoaderWithJSON.Session;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
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

class GdtAdLoader$1
  implements Runnable
{
  GdtAdLoader$1(GdtAdLoader paramGdtAdLoader, WeakReference paramWeakReference) {}
  
  public void run()
  {
    GdtLog.b("GdtAdLoader", "load");
    if ((this.a == null) || (this.a.get() == null)) {}
    label153:
    AdLoaderWithJSON.Session localSession;
    do
    {
      do
      {
        do
        {
          GdtAdLoader.a(this.this$0);
          return;
          GdtManager.a().a((Context)this.a.get(), new GdtManager.Params());
          AdReporterForAnalysis.reportForLoadAdStart((Context)this.a.get());
        } while ((GdtAdLoader.a(this.this$0) == null) || (!GdtAdLoader.a(this.this$0).a()));
        GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.support_https.set(true);
        localObject = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject).a = "d61533";
        localObject = GdtDeviceInfoHelper.a((Context)this.a.get(), (GdtDeviceInfoHelper.Params)localObject);
        if (localObject == null) {
          break;
        }
        localObject = ((GdtDeviceInfoHelper.Result)localObject).a;
        if (localObject != null) {
          GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.device_info.set((MessageMicro)localObject);
        }
        localObject = GdtJsonPbUtil.a(GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
      } while ((localObject == null) || (!(localObject instanceof JSONObject)));
      localSession = new AdLoaderWithJSON.Session();
      localSession.request = ((JSONObject)JSONObject.class.cast(localObject));
      AdLoaderWithJSON.load(localSession);
      GdtAdLoader.a(this.this$0).jdField_a_of_type_Long = localSession.timeMillis;
      GdtAdLoader.a(this.this$0).jdField_a_of_type_Int = localSession.httpResponseCode;
    } while ((localSession.httpResponseCode != 200) || (localSession.response == null) || (JSONObject.NULL.equals(localSession.response)));
    GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp(), localSession.response)));
    Object localObject = (Context)this.a.get();
    long l = GdtAdLoader.a(this.this$0).jdField_a_of_type_Long;
    int j = GdtAdLoader.a(this.this$0).jdField_a_of_type_Int;
    int k = GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
    if (GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() > 0) {}
    for (int i = ((qq_ad_get.QQAdGetRsp.PosAdInfo)GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();; i = -2147483648)
    {
      AdReporterForAnalysis.reportForLoadAdEnd((Context)localObject, l, j, k, i);
      break;
      localObject = null;
      break label153;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.1
 * JD-Core Version:    0.7.0.1
 */