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
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ChatHistoryTroopMemberFragment$SearchResultAdapter
  extends FacePreloadBaseAdapter
{
  public List<ChatHistoryTroopMemberFragment.ATroopMember> a;
  
  public ChatHistoryTroopMemberFragment$SearchResultAdapter(List<ChatHistoryTroopMemberFragment.ATroopMember> paramList)
  {
    super(paramList.getActivity(), paramList.b, paramList.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
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
    Object localObject1;
    Object localObject2;
    label59:
    boolean bool;
    if (paramView == null) {
      if (i == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563152, paramViewGroup, false);
        paramView = new ChatHistoryTroopMemberFragment.TmViewHolder((View)localObject1, false);
        ((View)localObject1).setTag(paramView);
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
        localObject2 = (ChatHistoryTroopMemberFragment.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).g.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject2).a);
        ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).b.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject2).a);
        ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setTag(((ChatHistoryTroopMemberFragment.ATroopMember)localObject2).a);
        ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        ChatHistoryTroopMemberFragment localChatHistoryTroopMemberFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment;
        Bitmap localBitmap = a(1, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject2).a);
        if (i != 1) {
          break label343;
        }
        bool = true;
        label152:
        localChatHistoryTroopMemberFragment.a((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1, (ChatHistoryTroopMemberFragment.ATroopMember)localObject2, localBitmap, true, bool);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.d == 12)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.jdField_a_of_type_JavaUtilList.contains(localObject2)) {
            break label349;
          }
          ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper.a((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1, (ChatHistoryTroopMemberFragment.ATroopMember)localObject2);
        if (((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).f.getVisibility() == 0)
        {
          i = VipUtils.d(2);
          ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).e.setMaxWidth(i);
          ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.b, ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).e, ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).d, ((ChatHistoryTroopMemberFragment.ATroopMember)localObject2).a, i);
        }
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563156, paramViewGroup, false);
      paramView = new ChatHistoryTroopMemberFragment.TmViewHolder((View)localObject1, true);
      break;
      localObject1 = (ChatHistoryTroopMemberFragment.TmViewHolder)paramView.getTag();
      break label59;
      label343:
      bool = false;
      break label152;
      label349:
      ((ChatHistoryTroopMemberFragment.TmViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */