package com.tencent.mobileqq.Doraemon.test;

import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import org.json.JSONObject;

class TestAppFragment$6
  extends TestAppFragment.MyAPICallback
{
  TestAppFragment$6(TestAppFragment paramTestAppFragment) {}
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    paramJSONObject.optString("openid", "");
    this.a.a.a("getAppFriends", null, new TestAppFragment.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment.6
 * JD-Core Version:    0.7.0.1
 */