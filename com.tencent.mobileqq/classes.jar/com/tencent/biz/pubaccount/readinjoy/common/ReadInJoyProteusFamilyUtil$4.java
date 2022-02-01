package com.tencent.biz.pubaccount.readinjoy.common;

import android.text.TextUtils;
import bkwm;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pal;
import pap;

public class ReadInJoyProteusFamilyUtil$4
  implements Runnable
{
  public ReadInJoyProteusFamilyUtil$4(pal parampal) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = (String)bkwm.a(pal.c(), "");
      QLog.d(pal.a(), 2, "local card data str " + (String)localObject2);
      Object localObject1 = localObject2;
      Object localObject3;
      int j;
      int i;
      if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.context))
      {
        localObject3 = pal.b(null);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject1 = new JSONObject();
          localObject2 = new JSONArray((String)localObject3);
          j = ((JSONArray)localObject2).length();
          i = 0;
        }
      }
      for (;;)
      {
        if (i < j)
        {
          localObject3 = ((JSONArray)localObject2).optJSONObject(i);
          if (localObject3 != null) {
            ((JSONObject)localObject1).put(((JSONObject)localObject3).optString(pal.d()), ((JSONObject)localObject3).optString(pal.e()));
          }
        }
        else
        {
          if (((JSONObject)localObject1).length() > 0)
          {
            localObject1 = ((JSONObject)localObject1).toString();
            QLog.d(pal.a(), 2, "loadProteusFamilyData | update local cardDataStr " + (String)localObject1);
            bkwm.a(pal.c(), localObject1);
            pal.a(this.this$0, pal.a((String)localObject1));
            if (pal.a(this.this$0) != null) {
              pal.a(this.this$0).a(true, pal.a(this.this$0));
            }
            localObject1 = pal.a();
            localObject2 = new StringBuilder().append("loadProteusFamilyData | proteus family members updated ");
            if (pal.a() == null) {
              break label316;
            }
          }
          label316:
          for (i = pal.a().size();; i = 0)
          {
            QLog.d((String)localObject1, 2, i);
            return;
            localObject1 = (String)bkwm.a(pal.c(), "");
            QLog.d(pal.a(), 2, "loadProteusFamilyData | no need to update just use local cardDataStr " + (String)localObject1);
            break;
          }
        }
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyProteusFamilyUtil.4
 * JD-Core Version:    0.7.0.1
 */