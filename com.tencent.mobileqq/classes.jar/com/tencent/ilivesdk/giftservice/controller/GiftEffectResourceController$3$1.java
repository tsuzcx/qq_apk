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
        if (localObject1 == null) {
          break;
        }
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break;
        }
        Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        if (localObject2 != null)
        {
          String str = ((JSONObject)localObject2).getString("giftId");
          localObject2 = ((JSONObject)localObject2).getString("md5");
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
            GiftEffectResourceController.access$500(this.this$1.this$0).put(str, localObject2);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        GiftEffectResourceController.access$000(this.this$1.this$0).getServiceAdapter().getLogger().e("GiftEffectResourceController", "loadLocalResMd5Info is error:" + localJSONException.getMessage(), new Object[0]);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController.3.1
 * JD-Core Version:    0.7.0.1
 */