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
  private LayoutInflater a;
  private Context b;
  private WSFollowFeedHolder c;
  private List<GroupEntity> d;
  private WSLoadingDialog e;
  
  public GroupAdapter(Context paramContext, List<GroupEntity> paramList, WSFollowFeedHolder paramWSFollowFeedHolder)
  {
    this.a = LayoutInflater.from(paramContext);
    this.b = paramContext;
    this.d = paramList;
    this.c = paramWSFollowFeedHolder;
  }
  
  private void a()
  {
    if (this.e == null)
    {
      Context localContext = this.b;
      if (localContext == null) {
        return;
      }
      this.e = new WSLoadingDialog(localContext, localContext.getResources().getString(2131893371));
    }
    this.e.show();
  }
  
  private void a(GroupEntity paramGroupEntity)
  {
    Object localObject = this.c;
    if ((localObject != null) && (((WSFollowFeedHolder)localObject).i() != null) && (this.c.i().feed == null)) {
      localObject = this.c.i().feed.poster_id;
    } else {
      localObject = "";
    }
    WSJoinGroupDataProcessor.a().a(paramGroupEntity.c, (String)localObject, new GroupAdapter.2(this));
  }
  
  private void a(GroupEntity paramGroupEntity, int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      stFeed localstFeed = ((WSFollowFeedHolder)localObject).i();
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
    WSLoadingDialog localWSLoadingDialog = this.e;
    if ((localWSLoadingDialog != null) && (localWSLoadingDialog.isShowing())) {
      this.e.dismiss();
    }
  }
  
  public GroupViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.a.inflate(2131626067, paramViewGroup, false);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localLayoutParams.height = ((int)paramViewGroup.getContext().getResources().getDimension(2131296894));
    localView.setLayoutParams(localLayoutParams);
    return new GroupViewHolder(localView);
  }
  
  public void a(GroupViewHolder paramGroupViewHolder, int paramInt)
  {
    GroupEntity localGroupEntity = (GroupEntity)this.d.get(paramInt);
    WSPicLoader.a().a(this.b, paramGroupViewHolder.a, localGroupEntity.a());
    paramGroupViewHolder.b.setText(localGroupEntity.b());
    paramGroupViewHolder.c.setOnClickListener(new GroupAdapter.1(this, localGroupEntity, paramInt));
  }
  
  public int getItemCount()
  {
    List localList = this.d;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.GroupAdapter
 * JD-Core Version:    0.7.0.1
 */