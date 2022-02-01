package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelClassificationListView$1
  implements HorizontalListView.OnScrollStateChangedListener
{
  ChannelClassificationListView$1(ChannelClassificationListView paramChannelClassificationListView) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    JSONObject localJSONObject;
    if (paramInt == 4098) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("channelid", ChannelClassificationListView.a(this.a));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X8009934", "0X8009934", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView.1
 * JD-Core Version:    0.7.0.1
 */