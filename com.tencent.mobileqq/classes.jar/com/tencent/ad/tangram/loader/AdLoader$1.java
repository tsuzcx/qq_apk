package com.tencent.ad.tangram.loader;

import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class AdLoader$1
  implements Runnable
{
  AdLoader$1(AdLoader.Session paramSession, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdLog.i("AdLoader", "load");
    Object localObject1 = this.val$session;
    if ((localObject1 != null) && (((AdLoader.Session)localObject1).canSend()))
    {
      this.val$session.request.support_https = true;
      localObject1 = null;
      try
      {
        Object localObject2 = AdJSON.fromObject(this.val$session.request);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        AdLog.e("AdLoader", "load", localException2);
      }
      if ((localObject1 != null) && ((localObject1 instanceof JSONObject)))
      {
        AdLoaderWithJSON.Session localSession = new AdLoaderWithJSON.Session();
        localSession.request = ((JSONObject)JSONObject.class.cast(localObject1));
        AdLoaderWithJSON.load(localSession);
        this.val$session.httpResponseCode = localSession.httpResponseCode;
        if ((localSession.httpResponseCode == 200) && (localSession.response != null) && (!JSONObject.NULL.equals(localSession.response))) {
          try
          {
            this.val$session.response = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(AdJSON.toObject(localSession.response, qq_ad_get.QQAdGetRsp.class)));
          }
          catch (Exception localException1)
          {
            AdLog.e("AdLoader", "load", localException1);
          }
        }
      }
    }
    AdThreadManager.INSTANCE.post(new AdLoader.1.1(this), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.loader.AdLoader.1
 * JD-Core Version:    0.7.0.1
 */