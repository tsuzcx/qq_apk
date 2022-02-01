package com.tencent.mobileqq.Doraemon.test;

import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class TestAppFragment$5$1
  extends TestAppFragment.MyAPICallback
{
  TestAppFragment$5$1(TestAppFragment.5 param5, String paramString) {}
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    for (;;)
    {
      int i;
      try
      {
        Object localObject = paramJSONObject.optJSONArray("appfriends");
        paramJSONObject = new JSONObject();
        paramJSONObject.put("rankingID", 11001);
        JSONArray localJSONArray = new JSONArray();
        i = 0;
        int j = ((JSONArray)localObject).length();
        if (i < j)
        {
          String str = ((JSONArray)localObject).getJSONObject(i).getString("openid");
          if (!str.equals(this.a))
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("openid", str);
            localJSONObject.put("score", (int)Math.floor(Math.random() * 1000.0D));
            localJSONArray.put(localJSONObject);
          }
        }
        else
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("openid", this.a);
          ((JSONObject)localObject).put("score", (int)Math.floor(Math.random() * 1000.0D));
          localJSONArray.put(localObject);
          paramJSONObject.put("scoreList", localJSONArray);
          this.b.a.c.a("reportScore", paramJSONObject, new TestAppFragment.MyAPICallback(this.b.a.d));
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment.5.1
 * JD-Core Version:    0.7.0.1
 */