package com.tencent.mobileqq.Doraemon.test;

import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import org.json.JSONObject;

class TestAppFragment$5
  extends TestAppFragment.MyAPICallback
{
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    paramJSONObject = paramJSONObject.optString("openid", "");
    this.a.c.a("getAppFriends", null, new TestAppFragment.5.1(this, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment.5
 * JD-Core Version:    0.7.0.1
 */