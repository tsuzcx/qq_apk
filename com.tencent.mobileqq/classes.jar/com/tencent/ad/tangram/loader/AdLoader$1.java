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
    if ((this.val$session == null) || (!this.val$session.canSend())) {}
    for (;;)
    {
      AdThreadManager.INSTANCE.post(new AdLoader.1.1(this), 0);
      return;
      this.val$session.request.support_https = true;
      try
      {
        Object localObject1 = AdJSON.fromObject(this.val$session.request);
        if ((localObject1 == null) || (!(localObject1 instanceof JSONObject))) {
          continue;
        }
        AdLoaderWithJSON.Session localSession = new AdLoaderWithJSON.Session();
        localSession.request = ((JSONObject)JSONObject.class.cast(localObject1));
        AdLoaderWithJSON.load(localSession);
        this.val$session.httpResponseCode = localSession.httpResponseCode;
        if ((localSession.httpResponseCode != 200) || (localSession.response == null) || (JSONObject.NULL.equals(localSession.response))) {
          continue;
        }
        try
        {
          this.val$session.response = ((qq_ad_get.QQAdGetRsp)qq_ad_get.QQAdGetRsp.class.cast(AdJSON.toObject(localSession.response, qq_ad_get.QQAdGetRsp.class)));
        }
        catch (Exception localException1)
        {
          AdLog.e("AdLoader", "load", localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          AdLog.e("AdLoader", "load", localException2);
          Object localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.loader.AdLoader.1
 * JD-Core Version:    0.7.0.1
 */