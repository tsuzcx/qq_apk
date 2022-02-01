package com.tencent.mobileqq.Doraemon.test;

import android.widget.EditText;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import org.json.JSONException;
import org.json.JSONObject;

class TestAppFragment$4
  extends TestAppFragment.MyAPICallback
{
  TestAppFragment$4(TestAppFragment paramTestAppFragment, EditText paramEditText, JSONObject paramJSONObject)
  {
    super(paramEditText);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    try
    {
      this.a.put("rankingID", 11002);
      this.a.put("topCount", 11);
      this.b.c.a("getRankingList", this.a, new TestAppFragment.MyAPICallback(this.b.d));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment.4
 * JD-Core Version:    0.7.0.1
 */