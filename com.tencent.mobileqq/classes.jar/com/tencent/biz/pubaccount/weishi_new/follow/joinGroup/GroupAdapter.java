package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEvent.ActionId;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WSLoadingDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAdapter
  extends RecyclerView.Adapter<GroupViewHolder>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private WSFollowFeedHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
  private WSLoadingDialog jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSLoadingDialog;
  private List<GroupEntity> jdField_a_of_type_JavaUtilList;
  
  public GroupAdapter(Context paramContext, List<GroupEntity> paramList, WSFollowFeedHolder paramWSFollowFeedHolder)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder = paramWSFollowFeedHolder;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSLoadingDialog == null)
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSLoadingDialog = new WSLoadingDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695601));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSLoadingDialog.show();
  }
  
  private void a(GroupEntity paramGroupEntity)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a() != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a().feed == null) {
          str1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a().feed.poster_id;
        }
      }
    }
    WSJoinGroupDataProcessor.a().a(paramGroupEntity.c, str1, new GroupAdapter.2(this));
  }
  
  private void a(GroupEntity paramGroupEntity, int paramInt)
  {
    stFeed localstFeed;
    HashMap localHashMap;
    String str;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder != null)
    {
      localstFeed = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a();
      localHashMap = new HashMap();
      localHashMap.put("qq_group_num", paramGroupEntity.c);
      str = WSReportEvent.ActionId.a;
      if (localstFeed == null) {
        break label66;
      }
    }
    label66:
    for (paramGroupEntity = localstFeed.feed;; paramGroupEntity = null)
    {
      WSFollowBeaconReport.a("qqgroup_add", paramInt + 1, str, localHashMap, paramGroupEntity);
      return;
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSLoadingDialog != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSLoadingDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSLoadingDialog.dismiss();
    }
  }
  
  public GroupViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560141, paramViewGroup, false);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localLayoutParams.height = ((int)paramViewGroup.getContext().getResources().getDimension(2131296619));
    localView.setLayoutParams(localLayoutParams);
    return new GroupViewHolder(localView);
  }
  
  public void a(GroupViewHolder paramGroupViewHolder, int paramInt)
  {
    GroupEntity localGroupEntity = (GroupEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    WeishiUtils.a(this.jdField_a_of_type_AndroidContentContext, paramGroupViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, localGroupEntity.a());
    paramGroupViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localGroupEntity.b());
    paramGroupViewHolder.b.setOnClickListener(new GroupAdapter.1(this, localGroupEntity, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramGroupViewHolder, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.GroupAdapter
 * JD-Core Version:    0.7.0.1
 */