package com.tencent.gdtad.aditem;

import aamt;
import aamv;
import aasd;
import aase;
import aatd;
import aate;
import aatf;
import aath;
import aati;
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
  public GdtAdLoader$1(aamt paramaamt, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdLoaderWithJSON.Session localSession = null;
    aase.b("GdtAdLoader", "load");
    aath.a().a((Context)this.a.get(), new aati());
    if (this.a != null)
    {
      localObject = (Context)this.a.get();
      AdReporterForAnalysis.reportForLoadAdStart((Context)localObject);
      if ((this.a != null) && (this.a.get() != null) && (aamt.a(this.this$0) != null) && (aamt.a(this.this$0).a())) {
        break label111;
      }
    }
    label111:
    do
    {
      do
      {
        aamt.a(this.this$0);
        return;
        localObject = null;
        break;
        aamt.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.support_https.set(true);
        localObject = new aate();
        ((aate)localObject).a = "d61533";
        aatf localaatf = aatd.a((Context)this.a.get(), (aate)localObject);
        localObject = localSession;
        if (localaatf != null) {
          localObject = localaatf.a;
        }
        if (localObject != null) {
          aamt.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.device_info.set((MessageMicro)localObject);
        }
        localObject = aasd.a(aamt.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
      } while ((localObject == null) || (!(localObject instanceof JSONObject)));
      localSession = new AdLoaderWithJSON.Session();
      localSession.request = ((JSONObject)JSONObject.class.cast(localObject));
      AdLoaderWithJSON.load(localSession);
      aamt.a(this.this$0).jdField_a_of_type_Long = localSession.timeMillis;
      aamt.a(this.this$0).jdField_a_of_type_Int = localSession.httpResponseCode;
    } while ((localSession.httpResponseCode != 200) || (localSession.response == null) || (localSession.response == JSONObject.NULL));
    aamt.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(aasd.a(new qq_ad_get.QQAdGetRsp(), localSession.response)));
    Object localObject = (Context)this.a.get();
    long l = aamt.a(this.this$0).jdField_a_of_type_Long;
    int j = aamt.a(this.this$0).jdField_a_of_type_Int;
    int k = aamt.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
    if (aamt.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() > 0) {}
    for (int i = ((qq_ad_get.QQAdGetRsp.PosAdInfo)aamt.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();; i = -2147483648)
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