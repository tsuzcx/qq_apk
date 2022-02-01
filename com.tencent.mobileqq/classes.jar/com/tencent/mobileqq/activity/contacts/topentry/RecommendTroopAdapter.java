package com.tencent.mobileqq.activity.contacts.topentry;

import NearbyGroup.GroupInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.biz.addContactTroopView.GroupViewAdapter;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.recommend.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecommendTroopAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  private List<RecentRecommendTroopItem> a = new ArrayList();
  private Context b;
  private QQAppInterface c;
  private RecommendTroopAdapter.IRecommendTroopAdapterCallback d;
  
  public RecommendTroopAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean, RecommendTroopAdapter.IRecommendTroopAdapterCallback paramIRecommendTroopAdapterCallback)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.d = paramIRecommendTroopAdapterCallback;
    this.b = paramContext;
    this.c = paramQQAppInterface;
  }
  
  private void a(RecommendTroopAdapter.RecTroopViewHolder paramRecTroopViewHolder, RecentRecommendTroopItem paramRecentRecommendTroopItem)
  {
    paramRecTroopViewHolder.a.setText(paramRecentRecommendTroopItem.name);
    paramRecTroopViewHolder.b.setText(paramRecentRecommendTroopItem.labelStr);
    paramRecTroopViewHolder.c.setText(HardCodeUtil.a(2131910746));
    paramRecTroopViewHolder.A.setImageBitmap(a(4, paramRecentRecommendTroopItem.uin));
    paramRecTroopViewHolder.e = paramRecentRecommendTroopItem;
    paramRecTroopViewHolder.y = paramRecentRecommendTroopItem.uin;
    paramRecTroopViewHolder.z = 4;
    ReportController.b(null, "dc00899", "Grp_recom", "", "link_top", "exp_grp", 0, 0, paramRecentRecommendTroopItem.uin, paramRecentRecommendTroopItem.recomAlgol, "", "");
    if (AppSetting.e)
    {
      View localView = paramRecTroopViewHolder.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRecentRecommendTroopItem.name);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramRecentRecommendTroopItem.labelStr);
      localView.setContentDescription(localStringBuilder.toString());
      paramRecTroopViewHolder.a.setContentDescription(paramRecentRecommendTroopItem.name);
      paramRecTroopViewHolder.b.setContentDescription(paramRecentRecommendTroopItem.labelStr);
    }
  }
  
  public RecentRecommendTroopItem a(int paramInt)
  {
    return (RecentRecommendTroopItem)this.a.get(paramInt);
  }
  
  public void a()
  {
    super.c();
    this.b = null;
    this.c = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
  }
  
  public void a(List<RecentRecommendTroopItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.a.clear();
      this.a.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    notifyDataSetChanged();
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((RecentRecommendTroopItem)localIterator.next()).uin.equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new RecommendTroopAdapter.RecTroopViewHolder();
      localView = LayoutInflater.from(this.b).inflate(2131624565, null);
      paramView.A = ((ImageView)localView.findViewById(2131427337));
      paramView.a = ((SingleLineTextView)localView.findViewById(2131439320));
      paramView.b = ((SingleLineTextView)localView.findViewById(2131444728));
      paramView.c = ((Button)localView.findViewById(2131444718));
      paramView.d = ((TextView)localView.findViewById(2131444726));
      paramView.f = ((ImageView)localView.findViewById(2131431708));
      paramView.g = localView;
      ((ThemeImageView)paramView.A).setSupportMaskView(true);
      paramView.f.setOnClickListener(this);
      paramView.c.setOnClickListener(this);
      localView.setOnClickListener(this);
      localView.setTag(paramView);
      paramView.f.setTag(paramView);
      paramView.c.setTag(paramView);
      localObject = paramView;
    }
    else
    {
      localObject = (RecommendTroopAdapter.RecTroopViewHolder)paramView.getTag();
      localView = paramView;
    }
    if (RecommendTroopEntryController.i)
    {
      ReportController.b(null, "dc00899", "Grp_recom", "", "link_top", "exp", 0, 0, "", "", "", "");
      RecommendTroopEntryController.i = false;
    }
    a((RecommendTroopAdapter.RecTroopViewHolder)localObject, a(paramInt));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131431708) {
      if (i != 2131444718)
      {
        if (i != 2131444905) {
          break label411;
        }
        localObject1 = ((RecommendTroopAdapter.RecTroopViewHolder)paramView.getTag()).e;
        localObject2 = new GroupInfo();
      }
    }
    try
    {
      ((GroupInfo)localObject2).lCode = Long.valueOf(((RecentRecommendTroopItem)localObject1).uin).longValue();
      ((GroupInfo)localObject2).strName = ((RecentRecommendTroopItem)localObject1).name;
      if (TextUtils.isEmpty(((RecentRecommendTroopItem)localObject1).recommendReason)) {
        ((GroupInfo)localObject2).strIntro = ((RecentRecommendTroopItem)localObject1).intro;
      } else {
        ((GroupInfo)localObject2).strIntro = ((RecentRecommendTroopItem)localObject1).recommendReason;
      }
      ((GroupInfo)localObject2).iMemberCnt = ((RecentRecommendTroopItem)localObject1).memberNum;
      localObject3 = GroupViewAdapter.a((RecommendTroopItem)localObject1);
      if (localObject3 != null) {
        ((GroupInfo)localObject2).labels = ((ArrayList)localObject3);
      }
      ((GroupInfo)localObject2).strJoinSig = ((RecentRecommendTroopItem)localObject1).authSig;
      localObject2 = TroopUtils.a(108, (GroupInfo)localObject2, 10020, false);
      TroopUtils.a(this.b, (Bundle)localObject2, 2);
      ReportController.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_grp", 0, 0, ((RecentRecommendTroopItem)localObject1).uin, ((RecentRecommendTroopItem)localObject1).recomAlgol, "", "");
    }
    catch (Exception localException)
    {
      Object localObject3;
      break label411;
    }
    Object localObject1 = ((RecommendTroopAdapter.RecTroopViewHolder)paramView.getTag()).e;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=");
    ((StringBuilder)localObject2).append(((RecentRecommendTroopItem)localObject1).uin);
    ((StringBuilder)localObject2).append("&subsource_id=10019");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject3 = new Intent(this.b, JoinGroupTransitActivity.class);
    ((Intent)localObject3).putExtra("source_scheme", (String)localObject2);
    this.b.startActivity((Intent)localObject3);
    ReportController.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_add", 0, 0, ((RecentRecommendTroopItem)localObject1).uin, ((RecentRecommendTroopItem)localObject1).recomAlgol, "", "");
    break label411;
    localObject1 = (RecommendTroopAdapter.RecTroopViewHolder)paramView.getTag();
    this.a.remove(((RecommendTroopAdapter.RecTroopViewHolder)localObject1).e);
    notifyDataSetChanged();
    localObject2 = this.d;
    if (localObject2 != null) {
      ((RecommendTroopAdapter.IRecommendTroopAdapterCallback)localObject2).a(((RecommendTroopAdapter.RecTroopViewHolder)localObject1).e.uin, this.a.size());
    }
    ReportController.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_delete", 0, 0, ((RecommendTroopAdapter.RecTroopViewHolder)localObject1).e.uin, ((RecommendTroopAdapter.RecTroopViewHolder)localObject1).e.recomAlgol, "", "");
    label411:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.RecommendTroopAdapter
 * JD-Core Version:    0.7.0.1
 */