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
      this.jdField_a_of_type_OrgJsonJSONObject.put("rankingID", 11002);
      this.jdField_a_of_type_OrgJsonJSONObject.put("topCount", 11);
      this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getRankingList", this.jdField_a_of_type_OrgJsonJSONObject, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.jdField_a_of_type_AndroidWidgetEditText));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment.4
 * JD-Core Version:    0.7.0.1
 */