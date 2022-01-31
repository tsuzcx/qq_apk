package com.tencent.gdtad.util;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import org.json.JSONObject;
import yxp;
import yyo;

public class GdtCanvasJsonManager$1
  implements Runnable
{
  public GdtCanvasJsonManager$1(yyo paramyyo, String paramString1, long paramLong, Ad paramAd, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = new AdHttp.Params();
    ((AdHttp.Params)localObject1).method = "GET";
    ((AdHttp.Params)localObject1).setUrl(this.jdField_a_of_type_JavaLangString);
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
          yxp.d("GdtCanvasJsonManager", "invalid canvasJson :" + localThrowable);
          localObject2 = null;
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      yyo.a(this.this$0, this.jdField_a_of_type_ComTencentAdTangramAd, 75, 0, l1 - l2);
      yyo.a(this.this$0, this.b, (String)localObject1);
      return;
    }
    Object localObject2;
    yxp.b("GdtCanvasJsonManager", "preloadCanvasJson failed :" + localObject2.responseCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtCanvasJsonManager.1
 * JD-Core Version:    0.7.0.1
 */