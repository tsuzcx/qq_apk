package com.tencent.gdtad.aditem;

import abkp;
import abkr;
import abrk;
import abrl;
import absn;
import abso;
import android.content.Context;
import com.tencent.ad.tangram.loader.AdLoaderWithJSON;
import com.tencent.ad.tangram.loader.AdLoaderWithJSON.Session;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
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
  public GdtAdLoader$1(abkp paramabkp, WeakReference paramWeakReference) {}
  
  public void run()
  {
    abrl.b("GdtAdLoader", "load");
    if ((this.a == null) || (this.a.get() == null)) {}
    label153:
    AdLoaderWithJSON.Session localSession;
    do
    {
      do
      {
        do
        {
          abkp.a(this.this$0);
          return;
          absn.a().a((Context)this.a.get(), new abso());
          AdReporterForAnalysis.reportForLoadAdStart((Context)this.a.get());
        } while ((abkp.a(this.this$0) == null) || (!abkp.a(this.this$0).a()));
        abkp.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.support_https.set(true);
        localObject = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject).businessIdForAidTicketAndTaidTicket = "d61533";
        localObject = GdtDeviceInfoHelper.create((Context)this.a.get(), (GdtDeviceInfoHelper.Params)localObject);
        if (localObject == null) {
          break;
        }
        localObject = ((GdtDeviceInfoHelper.Result)localObject).deviceInfo;
        if (localObject != null) {
          abkp.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.device_info.set((MessageMicro)localObject);
        }
        localObject = abrk.a(abkp.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
      } while ((localObject == null) || (!(localObject instanceof JSONObject)));
      localSession = new AdLoaderWithJSON.Session();
      localSession.request = ((JSONObject)JSONObject.class.cast(localObject));
      AdLoaderWithJSON.load(localSession);
      abkp.a(this.this$0).jdField_a_of_type_Long = localSession.timeMillis;
      abkp.a(this.this$0).jdField_a_of_type_Int = localSession.httpResponseCode;
    } while ((localSession.httpResponseCode != 200) || (localSession.response == null) || (JSONObject.NULL.equals(localSession.response)));
    abkp.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp(), localSession.response)));
    Object localObject = (Context)this.a.get();
    long l = abkp.a(this.this$0).jdField_a_of_type_Long;
    int j = abkp.a(this.this$0).jdField_a_of_type_Int;
    int k = abkp.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
    if (abkp.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() > 0) {}
    for (int i = ((qq_ad_get.QQAdGetRsp.PosAdInfo)abkp.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();; i = -2147483648)
    {
      AdReporterForAnalysis.reportForLoadAdEnd((Context)localObject, l, j, k, i);
      break;
      localObject = null;
      break label153;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.1
 * JD-Core Version:    0.7.0.1
 */