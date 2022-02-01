package com.tencent.gdtad.aditem;

import android.content.Context;
import com.tencent.ad.tangram.loader.AdLoaderWithJSON;
import com.tencent.ad.tangram.loader.AdLoaderWithJSON.Session;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
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
    Object localObject = this.a;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (IGdtAdAPI)QRoute.api(IGdtAdAPI.class);
      if (localObject == null)
      {
        QLog.i("GdtAdLoader", 1, "gdtAdAPI == null");
      }
      else
      {
        ((IGdtAdAPI)localObject).initGdtContext((Context)this.a.get(), new InitGdtContextParams());
        AdAnalysisHelperForUtil.reportForLoadAdStart((Context)this.a.get());
        if ((GdtAdLoader.a(this.this$0) != null) && (GdtAdLoader.a(this.this$0).a()))
        {
          GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.support_https.set(true);
          localObject = new GdtDeviceInfoHelper.Params();
          ((GdtDeviceInfoHelper.Params)localObject).a = "d61533";
          localObject = GdtDeviceInfoHelper.a((Context)this.a.get(), (GdtDeviceInfoHelper.Params)localObject);
          if (localObject != null) {
            localObject = ((GdtDeviceInfoHelper.Result)localObject).a;
          } else {
            localObject = null;
          }
          if (localObject != null) {
            GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.device_info.set((MessageMicro)localObject);
          }
          localObject = GdtJsonPbUtil.a(GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
          if ((localObject != null) && ((localObject instanceof JSONObject)))
          {
            AdLoaderWithJSON.Session localSession = new AdLoaderWithJSON.Session();
            localSession.request = ((JSONObject)JSONObject.class.cast(localObject));
            AdLoaderWithJSON.load(localSession);
            GdtAdLoader.a(this.this$0).jdField_a_of_type_Long = localSession.timeMillis;
            GdtAdLoader.a(this.this$0).jdField_a_of_type_Int = localSession.httpResponseCode;
            if ((localSession.httpResponseCode == 200) && (localSession.response != null) && (!JSONObject.NULL.equals(localSession.response)))
            {
              GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp(), localSession.response)));
              localObject = (Context)this.a.get();
              long l = GdtAdLoader.a(this.this$0).jdField_a_of_type_Long;
              int j = GdtAdLoader.a(this.this$0).jdField_a_of_type_Int;
              int k = GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
              int i;
              if (GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() > 0) {
                i = ((qq_ad_get.QQAdGetRsp.PosAdInfo)GdtAdLoader.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();
              } else {
                i = -2147483648;
              }
              AdAnalysisHelperForUtil.reportForLoadAdEnd((Context)localObject, l, j, k, i);
            }
          }
        }
      }
    }
    GdtAdLoader.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.1
 * JD-Core Version:    0.7.0.1
 */