package com.tencent.mobileqq.activity.history;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ChatHistoryTroopMemberFragment$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  public List<ChatHistoryTroopMemberFragment.ATroopMember> a;
  
  public ChatHistoryTroopMemberFragment$SearchResultAdapter(List<ChatHistoryTroopMemberFragment.ATroopMember> paramList)
  {
    super(paramList.getBaseActivity(), paramList.b, paramList.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment))
    {
      ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localATroopMember.m)) && (!TextUtils.isEmpty(localATroopMember.p)) && (!TextUtils.isEmpty(localATroopMember.g)) && (!localATroopMember.g.equals(localATroopMember.p))) {
        return 1;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    ChatHistoryTroopMemberFragment.TmViewHolder localTmViewHolder;
    if (paramView == null)
    {
      if (i == 0)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562975, paramViewGroup, false);
        localTmViewHolder = new ChatHistoryTroopMemberFragment.TmViewHolder(paramView, false);
      }
      else
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562979, paramViewGroup, false);
        localTmViewHolder = new ChatHistoryTroopMemberFragment.TmViewHolder(paramView, true);
      }
      paramView.setTag(localTmViewHolder);
    }
    else
    {
      localTmViewHolder = (ChatHistoryTroopMemberFragment.TmViewHolder)paramView.getTag();
    }
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = (ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localTmViewHolder.g.setTag(localATroopMember.a);
    localTmViewHolder.b.setTag(localATroopMember.a);
    localTmViewHolder.jdField_a_of_type_AndroidViewView.setTag(localATroopMember.a);
    localTmViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
    ChatHistoryTroopMemberFragment localChatHistoryTroopMemberFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment;
    Bitmap localBitmap = a(1, localATroopMember.a);
    boolean bool;
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localChatHistoryTroopMemberFragment.a(localTmViewHolder, localATroopMember, localBitmap, true, bool);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.d == 12) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.contains(localATroopMember)) {
        localTmViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        localTmViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper.a(localTmViewHolder, localATroopMember);
      if (localTmViewHolder.f.getVisibility() == 0)
      {
        i = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getMaxWidthForNameInTroopMemberListActivity(2);
        localTmViewHolder.e.setMaxWidth(i);
        ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.b, localTmViewHolder.e, localTmViewHolder.d, localATroopMember.a, i);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */