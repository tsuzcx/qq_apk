package com.tencent.biz.pubaccount.readinjoy.common;

import android.text.TextUtils;
import bmhv;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pju;
import pjy;

public class ReadInJoyProteusFamilyUtil$4
  implements Runnable
{
  public ReadInJoyProteusFamilyUtil$4(pju parampju) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = (String)bmhv.a(pju.c(), "");
      QLog.d(pju.a(), 2, "local card data str " + (String)localObject2);
      Object localObject1 = localObject2;
      Object localObject3;
      int j;
      int i;
      if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.context))
      {
        localObject3 = pju.b(null);
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
            ((JSONObject)localObject1).put(((JSONObject)localObject3).optString(pju.d()), ((JSONObject)localObject3).optString(pju.e()));
          }
        }
        else
        {
          if (((JSONObject)localObject1).length() > 0)
          {
            localObject1 = ((JSONObject)localObject1).toString();
            QLog.d(pju.a(), 2, "loadProteusFamilyData | update local cardDataStr " + (String)localObject1);
            bmhv.a(pju.c(), localObject1);
            pju.a(this.this$0, pju.a((String)localObject1));
            if (pju.a(this.this$0) != null) {
              pju.a(this.this$0).a(true, pju.a(this.this$0));
            }
            localObject1 = pju.a();
            localObject2 = new StringBuilder().append("loadProteusFamilyData | proteus family members updated ");
            if (pju.a() == null) {
              break label316;
            }
          }
          label316:
          for (i = pju.a().size();; i = 0)
          {
            QLog.d((String)localObject1, 2, i);
            return;
            localObject1 = (String)bmhv.a(pju.c(), "");
            QLog.d(pju.a(), 2, "loadProteusFamilyData | no need to update just use local cardDataStr " + (String)localObject1);
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