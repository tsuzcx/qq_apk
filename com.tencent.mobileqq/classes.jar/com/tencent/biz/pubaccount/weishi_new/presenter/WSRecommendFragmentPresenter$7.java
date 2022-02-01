package com.tencent.biz.pubaccount.weishi_new.presenter;

import achn;
import acho;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.PBField;
import cooperation.qzone.LocalMultiProcConfig;
import org.json.JSONException;
import org.json.JSONObject;
import vij;

public final class WSRecommendFragmentPresenter$7
  implements Runnable
{
  public void run()
  {
    Object localObject1 = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject1).businessIdForAidTicketAndTaidTicket = "23c763";
    localObject1 = GdtDeviceInfoHelper.create(BaseApplicationImpl.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
    if (localObject1 != null)
    {
      localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).deviceInfo;
      JSONObject localJSONObject = null;
      if (localObject1 == null) {
        localObject1 = localJSONObject;
      }
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject(vij.a());
          if ((localObject1 == null) || (localObject1 == JSONObject.NULL)) {
            break label146;
          }
          vij.a((JSONObject)localObject1, localJSONObject);
          acho.d("WSRecommendFragmentPresenter", "setGdtArgs success args =" + vij.a());
          return;
        }
        catch (JSONException localJSONException)
        {
          Object localObject2;
          acho.a("WSRecommendFragmentPresenter", localJSONException.getMessage());
          return;
        }
        localObject2 = achn.a((PBField)localObject1);
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
            acho.d("WSRecommendFragmentPresenter", "onResult error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSRecommendFragmentPresenter.7
 * JD-Core Version:    0.7.0.1
 */