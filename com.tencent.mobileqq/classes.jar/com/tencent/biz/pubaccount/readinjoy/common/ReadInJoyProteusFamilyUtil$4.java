package com.tencent.biz.pubaccount.readinjoy.common;

import android.text.TextUtils;
import bhvh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import nar;
import omx;
import onb;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyProteusFamilyUtil$4
  implements Runnable
{
  public ReadInJoyProteusFamilyUtil$4(omx paramomx) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = (String)bhvh.a(omx.c(), "");
      QLog.d(omx.a(), 2, "local card data str " + (String)localObject2);
      Object localObject1 = localObject2;
      Object localObject3;
      int j;
      int i;
      if (nar.a(BaseApplicationImpl.context))
      {
        localObject3 = omx.b(null);
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
            ((JSONObject)localObject1).put(((JSONObject)localObject3).optString(omx.d()), ((JSONObject)localObject3).optString(omx.e()));
          }
        }
        else
        {
          if (((JSONObject)localObject1).length() > 0)
          {
            localObject1 = ((JSONObject)localObject1).toString();
            QLog.d(omx.a(), 2, "loadProteusFamilyData | update local cardDataStr " + (String)localObject1);
            bhvh.a(omx.c(), localObject1);
            omx.a(this.this$0, omx.a((String)localObject1));
            if (omx.a(this.this$0) != null) {
              omx.a(this.this$0).a(true, omx.a(this.this$0));
            }
            localObject1 = omx.a();
            localObject2 = new StringBuilder().append("loadProteusFamilyData | proteus family members updated ");
            if (omx.a() == null) {
              break label316;
            }
          }
          label316:
          for (i = omx.a().size();; i = 0)
          {
            QLog.d((String)localObject1, 2, i);
            return;
            localObject1 = (String)bhvh.a(omx.c(), "");
            QLog.d(omx.a(), 2, "loadProteusFamilyData | no need to update just use local cardDataStr " + (String)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyProteusFamilyUtil.4
 * JD-Core Version:    0.7.0.1
 */