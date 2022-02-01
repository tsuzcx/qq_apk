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
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEvent.ActionId;
import com.tencent.biz.pubaccount.weishi_new.view.WSLoadingDialog;
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
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      if (localContext == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSLoadingDialog = new WSLoadingDialog(localContext, localContext.getResources().getString(2131695612));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSLoadingDialog.show();
  }
  
  private void a(GroupEntity paramGroupEntity)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
    if ((localObject != null) && (((WSFollowFeedHolder)localObject).a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a().feed == null)) {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a().feed.poster_id;
    } else {
      localObject = "";
    }
    WSJoinGroupDataProcessor.a().a(paramGroupEntity.c, (String)localObject, new GroupAdapter.2(this));
  }
  
  private void a(GroupEntity paramGroupEntity, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
    if (localObject != null)
    {
      stFeed localstFeed = ((WSFollowFeedHolder)localObject).a();
      localObject = new HashMap();
      ((Map)localObject).put("qq_group_num", paramGroupEntity.c);
      String str = WSReportEvent.ActionId.a;
      if (localstFeed != null) {
        paramGroupEntity = localstFeed.feed;
      } else {
        paramGroupEntity = null;
      }
      WSFollowBeaconReport.a("qqgroup_add", paramInt + 1, str, (Map)localObject, paramGroupEntity);
    }
  }
  
  private void b()
  {
    WSLoadingDialog localWSLoadingDialog = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSLoadingDialog;
    if ((localWSLoadingDialog != null) && (localWSLoadingDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSLoadingDialog.dismiss();
    }
  }
  
  public GroupViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560024, paramViewGroup, false);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localLayoutParams.height = ((int)paramViewGroup.getContext().getResources().getDimension(2131296598));
    localView.setLayoutParams(localLayoutParams);
    return new GroupViewHolder(localView);
  }
  
  public void a(GroupViewHolder paramGroupViewHolder, int paramInt)
  {
    GroupEntity localGroupEntity = (GroupEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    WSPicLoader.a(this.jdField_a_of_type_AndroidContentContext, paramGroupViewHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, localGroupEntity.a());
    paramGroupViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localGroupEntity.b());
    paramGroupViewHolder.b.setOnClickListener(new GroupAdapter.1(this, localGroupEntity, paramInt));
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.GroupAdapter
 * JD-Core Version:    0.7.0.1
 */