package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelClassificationListView$ClassificationAdapter$1
  implements View.OnClickListener
{
  ChannelClassificationListView$ClassificationAdapter$1(ChannelClassificationListView.ClassificationAdapter paramClassificationAdapter, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (ChannelClassificationListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView$ClassificationAdapter.a) != null) {
      ChannelClassificationListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView$ClassificationAdapter.a).onItemClick((AdapterView)this.jdField_a_of_type_AndroidViewViewGroup, paramView, i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView$ClassificationAdapter.getItemId(i));
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("subchannelid", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView$ClassificationAdapter.a(i).b());
      localJSONObject.put("subchannelname", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView$ClassificationAdapter.a(i).a());
      localJSONObject.put("channelid", ChannelClassificationListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView$ClassificationAdapter.a));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyUtils.a() + "", "0X8009933", "0X8009933", 0, 0, "", "", "", localJSONObject.toString(), false);
      EventCollector.getInstance().onViewClicked(paramView);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView.ClassificationAdapter.1
 * JD-Core Version:    0.7.0.1
 */