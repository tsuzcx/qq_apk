package com.tencent.mobileqq.ark.api.notify;

import android.content.Context;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ark.ark;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class GdtNotify$3$1$1
  implements Runnable
{
  GdtNotify$3$1$1(GdtNotify.3.1 param1, GdtAdLoader paramGdtAdLoader) {}
  
  public void run()
  {
    Object localObject2 = GdtJsonPbUtil.a(this.a.a().b);
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("rsp", localObject2);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    ark.arkNotify(this.b.a.a, "ad_req_callback", ((JSONObject)localObject1).toString(), "json");
    if (this.b.a.b != null) {
      localObject1 = (Context)this.b.a.b.get();
    } else {
      localObject1 = null;
    }
    AdAnalysisHelperForUtil.reportForARKSendNotification((Context)localObject1, this.b.a.c, "ad_req_callback", this.b.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.3.1.1
 * JD-Core Version:    0.7.0.1
 */