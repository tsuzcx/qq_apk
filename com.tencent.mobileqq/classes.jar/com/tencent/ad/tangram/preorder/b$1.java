package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.protocol.msg_content;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class b$1
  implements Runnable
{
  b$1(AdHttp.Params paramParams, String paramString1, String paramString2, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdHttp.send(this.val$params);
    msg_content localmsg_content;
    if (this.val$params.isSuccess())
    {
      Object localObject = new String(this.val$params.responseData);
      AdLog.i("AdAppPreOrderManagerForPreDownload", String.format("fetchAdInfo url:%s %s", new Object[] { this.val$url, localObject }));
      try
      {
        localObject = (msg_content)msg_content.class.cast(AdJSON.toObject(new JSONObject((String)localObject).optJSONObject("msg_content"), msg_content.class));
      }
      catch (Throwable localThrowable)
      {
        AdLog.e("AdAppPreOrderManagerForPreDownload", "fetchAdInfo error:", localThrowable);
      }
    }
    else
    {
      localmsg_content = null;
    }
    AdThreadManager.INSTANCE.post(new b.1.1(this, localmsg_content), 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.b.1
 * JD-Core Version:    0.7.0.1
 */