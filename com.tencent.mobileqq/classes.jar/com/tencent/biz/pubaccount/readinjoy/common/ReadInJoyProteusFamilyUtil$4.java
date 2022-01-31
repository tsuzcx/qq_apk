package com.tencent.biz.pubaccount.readinjoy.common;

import android.text.TextUtils;
import bhvy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import nao;
import omu;
import omy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyProteusFamilyUtil$4
  implements Runnable
{
  public ReadInJoyProteusFamilyUtil$4(omu paramomu) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = (String)bhvy.a(omu.c(), "");
      QLog.d(omu.a(), 2, "local card data str " + (String)localObject2);
      Object localObject1 = localObject2;
      Object localObject3;
      int j;
      int i;
      if (nao.a(BaseApplicationImpl.context))
      {
        localObject3 = omu.b(null);
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
            ((JSONObject)localObject1).put(((JSONObject)localObject3).optString(omu.d()), ((JSONObject)localObject3).optString(omu.e()));
          }
        }
        else
        {
          if (((JSONObject)localObject1).length() > 0)
          {
            localObject1 = ((JSONObject)localObject1).toString();
            QLog.d(omu.a(), 2, "loadProteusFamilyData | update local cardDataStr " + (String)localObject1);
            bhvy.a(omu.c(), localObject1);
            omu.a(this.this$0, omu.a((String)localObject1));
            if (omu.a(this.this$0) != null) {
              omu.a(this.this$0).a(true, omu.a(this.this$0));
            }
            localObject1 = omu.a();
            localObject2 = new StringBuilder().append("loadProteusFamilyData | proteus family members updated ");
            if (omu.a() == null) {
              break label316;
            }
          }
          label316:
          for (i = omu.a().size();; i = 0)
          {
            QLog.d((String)localObject1, 2, i);
            return;
            localObject1 = (String)bhvy.a(omu.c(), "");
            QLog.d(omu.a(), 2, "loadProteusFamilyData | no need to update just use local cardDataStr " + (String)localObject1);
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