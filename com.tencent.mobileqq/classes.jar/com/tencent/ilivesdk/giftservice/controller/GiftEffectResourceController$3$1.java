package com.tencent.ilivesdk.giftservice.controller;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.giftservice.GiftService;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceAdapter;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class GiftEffectResourceController$3$1
  implements Runnable
{
  GiftEffectResourceController$3$1(GiftEffectResourceController.3 param3) {}
  
  public void run()
  {
    Object localObject1 = this.this$1.val$sb.toString();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject((String)localObject1).getJSONArray("list");
        if (localObject1 != null) {
          break label187;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2 = GiftEffectResourceController.access$000(this.this$1.this$0).getServiceAdapter().getLogger();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("loadLocalResMd5Info is error:");
        ((StringBuilder)localObject3).append(localJSONException.getMessage());
        ((LogInterface)localObject2).e("GiftEffectResourceController", ((StringBuilder)localObject3).toString(), new Object[0]);
      }
      if (i < ((JSONArray)localObject1).length())
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        if (localObject3 != null)
        {
          localObject2 = ((JSONObject)localObject3).getString("giftId");
          localObject3 = ((JSONObject)localObject3).getString("md5");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
            GiftEffectResourceController.access$500(this.this$1.this$0).put(localObject2, localObject3);
          }
        }
        i += 1;
      }
      else
      {
        return;
        label187:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController.3.1
 * JD-Core Version:    0.7.0.1
 */