package com.tencent.biz.pubaccount.weishi_new.presenter;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBField;
import cooperation.qzone.LocalMultiProcConfig;
import org.json.JSONException;
import org.json.JSONObject;
import rzd;
import ynv;
import yny;
import yoy;
import yoz;
import ypa;

public final class WSRecommendFragmentPresenter$4
  implements Runnable
{
  public void run()
  {
    Object localObject1 = new yoz();
    ((yoz)localObject1).a = "23c763";
    localObject1 = yoy.a(BaseApplicationImpl.getContext(), (yoz)localObject1);
    if (localObject1 != null)
    {
      localObject1 = ((ypa)localObject1).a;
      JSONObject localJSONObject = null;
      if (localObject1 == null) {
        localObject1 = localJSONObject;
      }
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject(rzd.a());
          if ((localObject1 == null) || (localObject1 == JSONObject.NULL)) {
            break label146;
          }
          rzd.a((JSONObject)localObject1, localJSONObject);
          yny.d("WSRecommendFragmentPresenter", "setGdtArgs success args =" + rzd.a());
          return;
        }
        catch (JSONException localJSONException)
        {
          Object localObject2;
          yny.a("WSRecommendFragmentPresenter", localJSONException.getMessage());
          return;
        }
        localObject2 = ynv.a((PBField)localObject1);
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
            yny.d("WSRecommendFragmentPresenter", "onResult error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSRecommendFragmentPresenter.4
 * JD-Core Version:    0.7.0.1
 */