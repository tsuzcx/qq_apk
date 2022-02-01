package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.activateFriend.biz.ReminderListItemModel;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ReminderListFragment$ReminderListAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private ArrayList<ReminderListItemModel> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private ReminderListFragment$ReminderListAdapter(ReminderListFragment paramReminderListFragment) {}
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return;
      }
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        localObject = (ReminderListItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (paramString.equals(((ReminderListItemModel)localObject).jdField_a_of_type_WalletAcsMsg.msg_id))
        {
          if (!StringUtil.a(((ReminderListItemModel)localObject).jdField_a_of_type_JavaLangString))
          {
            j = i + 1;
            if (j < this.jdField_a_of_type_JavaUtilArrayList.size()) {
              if ((((ReminderListItemModel)localObject).jdField_a_of_type_Int == 1) && (((ReminderListItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Int == 1)) {
                ((ReminderListItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713311);
              } else if ((((ReminderListItemModel)localObject).jdField_a_of_type_Int == 0) && (((ReminderListItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Int == 0)) {
                ((ReminderListItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713300);
              }
            }
          }
          j = i;
          break;
        }
        i += 1;
      }
      i = j;
      if (j == this.jdField_a_of_type_JavaUtilArrayList.size()) {
        i = j - 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      notifyItemRemoved(i);
      notifyItemRangeChanged(i, this.jdField_a_of_type_JavaUtilArrayList.size());
      if (getItemCount() == 0) {
        ReminderListFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment);
      }
      ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, paramString);
    }
  }
  
  public void a(ArrayList<ReminderListItemModel> paramArrayList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ReminderListFragment.ReminderListItemVH))
    {
      ReminderListFragment.ReminderListItemVH localReminderListItemVH = (ReminderListFragment.ReminderListItemVH)paramViewHolder;
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        localReminderListItemVH.a((ReminderListItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560912, null, false);
    return new ReminderListFragment.ReminderListItemVH(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.ReminderListAdapter
 * JD-Core Version:    0.7.0.1
 */