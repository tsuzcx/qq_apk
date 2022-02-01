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
      Object localObject2 = ((GdtDeviceInfoHelper.Result)localObject1).a;
      localObject1 = null;
      if (localObject2 != null) {}
      try
      {
        localObject2 = GdtJsonPbUtil.a((PBField)localObject2);
        if ((localObject2 != null) && ((localObject2 instanceof JSONObject)))
        {
          localObject1 = (JSONObject)JSONObject.class.cast(localObject2);
          LocalMultiProcConfig.putString("cache_key_gdt_args", ((JSONObject)localObject1).toString());
        }
        localObject2 = new JSONObject(WSVerticalDataManager.c());
        if ((localObject1 != null) && (localObject1 != JSONObject.NULL)) {
          WSVerticalDataManager.a((JSONObject)localObject1, (JSONObject)localObject2);
        } else {
          GdtLog.d("WSVerticalDataManagerLog", "onResult error");
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setGdtArgs success args =");
        ((StringBuilder)localObject1).append(WSVerticalDataManager.c());
        GdtLog.a("WSVerticalDataManagerLog", ((StringBuilder)localObject1).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        GdtLog.a("WSVerticalDataManagerLog", localJSONException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager.2
 * JD-Core Version:    0.7.0.1
 */