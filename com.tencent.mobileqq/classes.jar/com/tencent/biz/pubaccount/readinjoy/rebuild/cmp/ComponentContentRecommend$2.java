package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

class ComponentContentRecommend$2
  extends BaseAdapter
{
  ComponentContentRecommend$2(ComponentContentRecommend paramComponentContentRecommend) {}
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    return ComponentContentRecommend.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return ComponentContentRecommend.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)ComponentContentRecommend.a(this.a).get(paramInt);
    ComponentContentRecommend.a(this.a).mRecommendFollowInfos.a.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
    ComponentContentRecommend.FollowHolder localFollowHolder;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131562888, null, false);
      localFollowHolder = new ComponentContentRecommend.FollowHolder(this.a);
      localFollowHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131368314));
      localFollowHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)paramView.findViewById(2131376480));
      localFollowHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368368));
      localFollowHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131379536));
      localFollowHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365697));
      localFollowHolder.b = ((TextView)paramView.findViewById(2131364011));
      localFollowHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365922);
      paramView.setTag(localFollowHolder);
    }
    for (;;)
    {
      if (localFollowHolder != null) {}
      try
      {
        localFollowHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImage(new URL(localRecommendFollowInfo.headUrl));
        ComponentContentRecommend.2.1 local1 = new ComponentContentRecommend.2.1(this, localRecommendFollowInfo);
        localFollowHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(local1);
        localFollowHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(local1);
        localFollowHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(local1);
        if (localRecommendFollowInfo.isStar)
        {
          localFollowHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView.showStarRing();
          if (!localRecommendFollowInfo.isVip) {
            break label470;
          }
          localFollowHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localFollowHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localRecommendFollowInfo.nickName);
          localFollowHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
          if (!localRecommendFollowInfo.isFollowed) {
            break label483;
          }
          localFollowHolder.b.setText(HardCodeUtil.a(2131702402));
          localFollowHolder.b.setTextColor(Color.parseColor("#777777"));
          localFollowHolder.b.setBackgroundResource(2130849835);
          localFollowHolder.b.setOnClickListener(new ComponentContentRecommend.2.2(this, localRecommendFollowInfo));
          localFollowHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localFollowHolder = (ComponentContentRecommend.FollowHolder)paramView.getTag();
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e(ComponentContentRecommend.a, 2, "getView, followItem.headUrl = " + localRecommendFollowInfo.headUrl + ", e = " + QLog.getStackTraceString(localMalformedURLException));
          localMalformedURLException.printStackTrace();
          continue;
          localFollowHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView.showNormal();
          continue;
          label470:
          localFollowHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
          label483:
          localFollowHolder.b.setText(HardCodeUtil.a(2131702353));
          localFollowHolder.b.setTextColor(-1);
          localFollowHolder.b.setBackgroundResource(2130849791);
          localFollowHolder.b.setCompoundDrawablePadding(AIOUtils.a(3.0F, this.a.getResources()));
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend.2
 * JD-Core Version:    0.7.0.1
 */