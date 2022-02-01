package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import acvb;
import acvc;
import acwb;
import acwc;
import acwd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBField;
import cooperation.qzone.LocalMultiProcConfig;
import org.json.JSONException;
import org.json.JSONObject;

final class WSVerticalDataManager$5
  implements Runnable
{
  public void run()
  {
    Object localObject1 = new acwc();
    ((acwc)localObject1).a = "23c763";
    localObject1 = acwb.a(BaseApplicationImpl.getContext(), (acwc)localObject1);
    if (localObject1 != null)
    {
      localObject1 = ((acwd)localObject1).a;
      JSONObject localJSONObject = null;
      if (localObject1 == null) {
        localObject1 = localJSONObject;
      }
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject(WSVerticalDataManager.a());
          if ((localObject1 == null) || (localObject1 == JSONObject.NULL)) {
            break label146;
          }
          WSVerticalDataManager.a((JSONObject)localObject1, localJSONObject);
          acvc.d("WSVerticalDataManagerLog", "setGdtArgs success args =" + WSVerticalDataManager.a());
          return;
        }
        catch (JSONException localJSONException)
        {
          Object localObject2;
          acvc.a("WSVerticalDataManagerLog", localJSONException.getMessage());
          return;
        }
        localObject2 = acvb.a((PBField)localObject1);
        localObject1 = localJSONObject;
        if (localObject2 != null)
        {
          localObject1 = localJSONObject;
          if ((localObject2 instanceof JSONObject))
          {
            localObject1 = (JSONObject)JSONObject.class.cast(localObject2);
            LocalMultiProcConfig.putString("cache_key_gdt_args", ((JSONObject)localObject1).toString());
            continue;
            label146:
            acvc.d("WSVerticalDataManagerLog", "onResult error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager.5
 * JD-Core Version:    0.7.0.1
 */