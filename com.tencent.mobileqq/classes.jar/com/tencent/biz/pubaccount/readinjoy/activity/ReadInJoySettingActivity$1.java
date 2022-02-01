package com.tencent.biz.pubaccount.readinjoy.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.ReadInJoyUserDataUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoySettingActivity$1
  implements CompoundButton.OnCheckedChangeListener
{
  ReadInJoySettingActivity$1(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int i;
    if (paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      ReadInJoyUserDataUtils.a(i);
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        i = j;
      }
      try
      {
        for (;;)
        {
          localJSONObject.put("click_opt", i);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800A80B", "0X800A80B", 0, 0, "", "", "", localJSONObject.toString(), false);
          EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
          return;
          i = 1;
          break;
          i = 2;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity.1
 * JD-Core Version:    0.7.0.1
 */