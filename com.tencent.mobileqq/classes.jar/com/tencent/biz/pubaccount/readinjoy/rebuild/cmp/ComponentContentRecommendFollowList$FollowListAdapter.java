package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;

class ComponentContentRecommendFollowList$FollowListAdapter
  extends BaseAdapter
{
  private List<RecommendFollowInfo> jdField_a_of_type_JavaUtilList;
  
  private ComponentContentRecommendFollowList$FollowListAdapter(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList) {}
  
  public void a(List<RecommendFollowInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    Object localObject1;
    RecommendFollowInfo localRecommendFollowInfo;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560378, paramViewGroup, false);
      localObject1 = new ComponentContentRecommendFollowList.ViewHolder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList, null);
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368306));
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368315));
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381108));
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378406));
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372296));
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378921));
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367297));
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367289));
      paramView.setTag(localObject1);
      paramView.setOnClickListener((View.OnClickListener)localObject1);
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject1);
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject1);
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject1);
      localRecommendFollowInfo = (RecommendFollowInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo = localRecommendFollowInfo;
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_Int = paramInt;
      ComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList).mRecommendFollowInfos.a.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
      if (TextUtils.isEmpty(localRecommendFollowInfo.headUrl)) {
        break label479;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = ImageUtil.c();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
      localObject2 = URLDrawable.getDrawable(localRecommendFollowInfo.headUrl, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.a);
      ((URLDrawable)localObject2).setFadeInImage(true);
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      label316:
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.nickName);
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
      if (!localRecommendFollowInfo.isFollowed) {
        break label493;
      }
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702393));
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849835);
      label383:
      localObject2 = ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView;
      if (!localRecommendFollowInfo.isVip) {
        break label530;
      }
      i = 0;
      label401:
      ((ImageView)localObject2).setVisibility(i);
      localObject1 = ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView;
      if (!localRecommendFollowInfo.isStar) {
        break label537;
      }
    }
    label530:
    label537:
    for (int i = j;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      ComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList);
      ComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList, paramInt, localRecommendFollowInfo);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = (ComponentContentRecommendFollowList.ViewHolder)paramView.getTag();
      break;
      label479:
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.c());
      break label316;
      label493:
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702383));
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      ((ComponentContentRecommendFollowList.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849791);
      break label383;
      i = 8;
      break label401;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList.FollowListAdapter
 * JD-Core Version:    0.7.0.1
 */