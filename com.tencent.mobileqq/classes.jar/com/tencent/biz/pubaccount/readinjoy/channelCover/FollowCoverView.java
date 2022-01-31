package com.tencent.biz.pubaccount.readinjoy.channelCover;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendFeedsTitle;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class FollowCoverView
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FollowCoverAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverFollowCoverAdapter;
  private TopicRecommendFeedsInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private TextView b;
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentWidgetListView != null) {
        this.jdField_a_of_type_ComTencentWidgetListView.removeHeaderView(this.jdField_a_of_type_AndroidViewView);
      }
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount() < 1)) {
      this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString);
      }
    }
    else
    {
      if ((this.b == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b.jdField_b_of_type_JavaLangString))) {
        break label266;
      }
      this.b.setVisibility(0);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b.jdField_a_of_type_JavaLangString)) {
        break label254;
      }
      this.b.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b.jdField_a_of_type_JavaLangString);
      label220:
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.b.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverFollowCoverAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("话题更新");
      break;
      label254:
      this.b.setText("更多");
      break label220;
      label266:
      if (this.b != null)
      {
        this.b.setVisibility(8);
        this.jdField_a_of_type_JavaLangString = null;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    str = "";
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", "" + ReadInJoyUtils.d);
        if (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext)) {
          continue;
        }
        paramView = "2";
        localJSONObject.put("network_type", paramView);
        paramView = localJSONObject.toString();
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
        paramView = str;
        continue;
      }
      PublicAccountReportUtils.a(null, "", "0X8008451", "0X8008451", 0, 0, "", "", "", paramView, false);
      return;
      paramView = "1";
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt == 0) || (paramInt == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverFollowCoverAdapter.getCount() - 1)) {}
    TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 1) || (paramInt > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size()));
      localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
    } while ((localTopicRecommendInfo == null) || (TextUtils.isEmpty(localTopicRecommendInfo.jdField_b_of_type_JavaLangString)));
    ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, localTopicRecommendInfo.jdField_b_of_type_JavaLangString);
    paramView = "";
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", "" + ReadInJoyUtils.d);
        if (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext)) {
          continue;
        }
        paramAdapterView = "2";
        localJSONObject.put("network_type", paramAdapterView);
        paramAdapterView = localJSONObject.toString();
      }
      catch (JSONException paramAdapterView)
      {
        paramAdapterView.printStackTrace();
        paramAdapterView = paramView;
        continue;
      }
      PublicAccountReportUtils.a(null, "", "0X8008450", "0X8008450", 0, 0, String.valueOf(localTopicRecommendInfo.a), String.valueOf(paramInt - 1), String.valueOf(localTopicRecommendInfo.jdField_b_of_type_Int), paramAdapterView, false);
      localTopicRecommendInfo.jdField_b_of_type_Int = 0;
      ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverFollowCoverAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList);
      a();
      return;
      paramAdapterView = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.FollowCoverView
 * JD-Core Version:    0.7.0.1
 */