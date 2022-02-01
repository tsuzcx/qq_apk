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
  private Context jdField_a_of_type_AndroidContentContext;
  private RecommendTroopAdapter.IRecommendTroopAdapterCallback jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter$IRecommendTroopAdapterCallback;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<RecentRecommendTroopItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public RecommendTroopAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean, RecommendTroopAdapter.IRecommendTroopAdapterCallback paramIRecommendTroopAdapterCallback)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter$IRecommendTroopAdapterCallback = paramIRecommendTroopAdapterCallback;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(RecommendTroopAdapter.RecTroopViewHolder paramRecTroopViewHolder, RecentRecommendTroopItem paramRecentRecommendTroopItem)
  {
    paramRecTroopViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentRecommendTroopItem.name);
    paramRecTroopViewHolder.b.setText(paramRecentRecommendTroopItem.labelStr);
    paramRecTroopViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131713191));
    paramRecTroopViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramRecentRecommendTroopItem.uin));
    paramRecTroopViewHolder.jdField_a_of_type_ComTencentMobileqqTroopRecommendDataRecentRecommendTroopItem = paramRecentRecommendTroopItem;
    paramRecTroopViewHolder.jdField_a_of_type_JavaLangString = paramRecentRecommendTroopItem.uin;
    paramRecTroopViewHolder.jdField_c_of_type_Int = 4;
    ReportController.b(null, "dc00899", "Grp_recom", "", "link_top", "exp_grp", 0, 0, paramRecentRecommendTroopItem.uin, paramRecentRecommendTroopItem.recomAlgol, "", "");
    if (AppSetting.d)
    {
      View localView = paramRecTroopViewHolder.jdField_a_of_type_AndroidViewView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRecentRecommendTroopItem.name);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramRecentRecommendTroopItem.labelStr);
      localView.setContentDescription(localStringBuilder.toString());
      paramRecTroopViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(paramRecentRecommendTroopItem.name);
      paramRecTroopViewHolder.b.setContentDescription(paramRecentRecommendTroopItem.labelStr);
    }
  }
  
  public RecentRecommendTroopItem a(int paramInt)
  {
    return (RecentRecommendTroopItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    super.c();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(List<RecentRecommendTroopItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((RecentRecommendTroopItem)localIterator.next()).uin.equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
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
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558934, null);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361799));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131371877));
      paramView.b = ((SingleLineTextView)localView.findViewById(2131376487));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376477));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376485));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365494));
      paramView.jdField_a_of_type_AndroidViewView = localView;
      ((ThemeImageView)paramView.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localView.setOnClickListener(this);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetButton.setTag(paramView);
      localObject = paramView;
    }
    else
    {
      localObject = (RecommendTroopAdapter.RecTroopViewHolder)paramView.getTag();
      localView = paramView;
    }
    if (RecommendTroopEntryController.a)
    {
      ReportController.b(null, "dc00899", "Grp_recom", "", "link_top", "exp", 0, 0, "", "", "", "");
      RecommendTroopEntryController.a = false;
    }
    a((RecommendTroopAdapter.RecTroopViewHolder)localObject, a(paramInt));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131365494) {
      if (i != 2131376477)
      {
        if (i != 2131376644) {
          break label411;
        }
        localObject1 = ((RecommendTroopAdapter.RecTroopViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqTroopRecommendDataRecentRecommendTroopItem;
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
      TroopUtils.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject2, 2);
      ReportController.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_grp", 0, 0, ((RecentRecommendTroopItem)localObject1).uin, ((RecentRecommendTroopItem)localObject1).recomAlgol, "", "");
    }
    catch (Exception localException)
    {
      Object localObject3;
      break label411;
    }
    Object localObject1 = ((RecommendTroopAdapter.RecTroopViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqTroopRecommendDataRecentRecommendTroopItem;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=");
    ((StringBuilder)localObject2).append(((RecentRecommendTroopItem)localObject1).uin);
    ((StringBuilder)localObject2).append("&subsource_id=10019");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, JoinGroupTransitActivity.class);
    ((Intent)localObject3).putExtra("source_scheme", (String)localObject2);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
    ReportController.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_add", 0, 0, ((RecentRecommendTroopItem)localObject1).uin, ((RecentRecommendTroopItem)localObject1).recomAlgol, "", "");
    break label411;
    localObject1 = (RecommendTroopAdapter.RecTroopViewHolder)paramView.getTag();
    this.jdField_a_of_type_JavaUtilList.remove(((RecommendTroopAdapter.RecTroopViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTroopRecommendDataRecentRecommendTroopItem);
    notifyDataSetChanged();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryRecommendTroopAdapter$IRecommendTroopAdapterCallback;
    if (localObject2 != null) {
      ((RecommendTroopAdapter.IRecommendTroopAdapterCallback)localObject2).a(((RecommendTroopAdapter.RecTroopViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTroopRecommendDataRecentRecommendTroopItem.uin, this.jdField_a_of_type_JavaUtilList.size());
    }
    ReportController.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_delete", 0, 0, ((RecommendTroopAdapter.RecTroopViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTroopRecommendDataRecentRecommendTroopItem.uin, ((RecommendTroopAdapter.RecTroopViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTroopRecommendDataRecentRecommendTroopItem.recomAlgol, "", "");
    label411:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.RecommendTroopAdapter
 * JD-Core Version:    0.7.0.1
 */