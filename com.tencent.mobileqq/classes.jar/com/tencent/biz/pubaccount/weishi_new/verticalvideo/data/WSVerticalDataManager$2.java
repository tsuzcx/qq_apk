package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.PBField;
import cooperation.qzone.LocalMultiProcConfig;
import org.json.JSONException;
import org.json.JSONObject;

final class WSVerticalDataManager$2
  implements Runnable
{
  public void run()
  {
    Object localObject1 = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject1).a = "23c763";
    localObject1 = GdtDeviceInfoHelper.a(BaseApplicationImpl.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
    if (localObject1 != null)
    {
      localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).a;
      JSONObject localJSONObject = null;
      if (localObject1 == null) {
        localObject1 = localJSONObject;
      }
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject(WSVerticalDataManager.b());
          if ((localObject1 == null) || (localObject1 == JSONObject.NULL)) {
            break label146;
          }
          WSVerticalDataManager.a((JSONObject)localObject1, localJSONObject);
          GdtLog.d("WSVerticalDataManagerLog", "setGdtArgs success args =" + WSVerticalDataManager.b());
          return;
        }
        catch (JSONException localJSONException)
        {
          Object localObject2;
          GdtLog.a("WSVerticalDataManagerLog", localJSONException.getMessage());
          return;
        }
        localObject2 = GdtJsonPbUtil.a((PBField)localObject1);
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
            GdtLog.d("WSVerticalDataManagerLog", "onResult error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager.2
 * JD-Core Version:    0.7.0.1
 */