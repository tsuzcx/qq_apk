package com.tencent.ad.tangram.canvas;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import org.json.JSONObject;

class AdCanvasJsonManager$1
  implements Runnable
{
  AdCanvasJsonManager$1(AdCanvasJsonManager paramAdCanvasJsonManager, String paramString1, long paramLong, Ad paramAd, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = new AdHttp.Params();
    ((AdHttp.Params)localObject1).method = "GET";
    ((AdHttp.Params)localObject1).setUrl(this.val$canvasJsonUrl);
    AdHttp.send((AdHttp.Params)localObject1);
    if ((((AdHttp.Params)localObject1).responseCode == 200) && (((AdHttp.Params)localObject1).responseData != null))
    {
      try
      {
        localObject1 = new JSONObject(new String(((AdHttp.Params)localObject1).responseData));
        if (((JSONObject)localObject1).getInt("code") != 0) {
          return;
        }
        localObject1 = ((JSONObject)localObject1).optString("data");
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          long l1;
          long l2;
          AdLog.e("AdCanvasJsonManager", "invalid canvasJson :" + localThrowable);
          localObject2 = null;
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      l1 = System.currentTimeMillis();
      l2 = this.val$startTime;
      AdCanvasJsonManager.access$000(this.this$0, this.val$ad, 75, 0, l1 - l2);
      AdCanvasJsonManager.access$100(this.this$0, this.val$canvasJsonKey, (String)localObject1);
      return;
    }
    Object localObject2;
    AdLog.i("AdCanvasJsonManager", "preloadCanvasJson failed :" + localObject2.responseCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.AdCanvasJsonManager.1
 * JD-Core Version:    0.7.0.1
 */