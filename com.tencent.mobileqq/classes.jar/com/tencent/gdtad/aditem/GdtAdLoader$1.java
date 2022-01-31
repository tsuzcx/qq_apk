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
import ysn;
import ysp;
import yxo;
import yxp;
import yyp;
import yyq;
import yyr;
import yyt;
import yyu;

public class GdtAdLoader$1
  implements Runnable
{
  public GdtAdLoader$1(ysn paramysn, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdLoaderWithJSON.Session localSession = null;
    yxp.b("GdtAdLoader", "load");
    yyt.a().a((Context)this.a.get(), new yyu());
    if (this.a != null)
    {
      localObject = (Context)this.a.get();
      AdReporterForAnalysis.reportForLoadAdStart((Context)localObject);
      if ((this.a != null) && (this.a.get() != null) && (ysn.a(this.this$0) != null) && (ysn.a(this.this$0).a())) {
        break label111;
      }
    }
    label111:
    do
    {
      do
      {
        ysn.a(this.this$0);
        return;
        localObject = null;
        break;
        ysn.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.support_https.set(true);
        localObject = new yyq();
        ((yyq)localObject).a = "d61533";
        yyr localyyr = yyp.a((Context)this.a.get(), (yyq)localObject);
        localObject = localSession;
        if (localyyr != null) {
          localObject = localyyr.a;
        }
        if (localObject != null) {
          ysn.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet.device_info.set((MessageMicro)localObject);
        }
        localObject = yxo.a(ysn.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
      } while ((localObject == null) || (!(localObject instanceof JSONObject)));
      localSession = new AdLoaderWithJSON.Session();
      localSession.request = ((JSONObject)JSONObject.class.cast(localObject));
      AdLoaderWithJSON.load(localSession);
      ysn.a(this.this$0).jdField_a_of_type_Long = localSession.timeMillis;
      ysn.a(this.this$0).jdField_a_of_type_Int = localSession.httpResponseCode;
    } while ((localSession.httpResponseCode != 200) || (localSession.response == null) || (localSession.response == JSONObject.NULL));
    ysn.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(yxo.a(new qq_ad_get.QQAdGetRsp(), localSession.response)));
    Object localObject = (Context)this.a.get();
    long l = ysn.a(this.this$0).jdField_a_of_type_Long;
    int j = ysn.a(this.this$0).jdField_a_of_type_Int;
    int k = ysn.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
    if (ysn.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() > 0) {}
    for (int i = ((qq_ad_get.QQAdGetRsp.PosAdInfo)ysn.a(this.this$0).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();; i = -2147483648)
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