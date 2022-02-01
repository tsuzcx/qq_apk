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
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return;
    }
    int j = 0;
    ReminderListItemModel localReminderListItemModel;
    int i;
    if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localReminderListItemModel = (ReminderListItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (paramString.equals(localReminderListItemModel.jdField_a_of_type_WalletAcsMsg.msg_id))
      {
        i = j;
        if (!StringUtil.a(localReminderListItemModel.jdField_a_of_type_JavaLangString))
        {
          i = j;
          if (j + 1 < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if ((localReminderListItemModel.jdField_a_of_type_Int != 1) || (((ReminderListItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1)).jdField_a_of_type_Int != 1)) {
              break label206;
            }
            ((ReminderListItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1)).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713343);
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      j = i;
      if (i == this.jdField_a_of_type_JavaUtilArrayList.size()) {
        j = i - 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.remove(j);
      notifyItemRemoved(j);
      notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilArrayList.size());
      if (getItemCount() == 0) {
        ReminderListFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment);
      }
      ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, paramString);
      return;
      label206:
      i = j;
      if (localReminderListItemModel.jdField_a_of_type_Int == 0)
      {
        i = j;
        if (((ReminderListItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1)).jdField_a_of_type_Int == 0)
        {
          ((ReminderListItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1)).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713332);
          i = j;
          continue;
          j += 1;
          break;
          i = 0;
        }
      }
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
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ReminderListFragment.ReminderListItemVH))
    {
      ReminderListFragment.ReminderListItemVH localReminderListItemVH = (ReminderListFragment.ReminderListItemVH)paramViewHolder;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        localReminderListItemVH.a((ReminderListItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561048, null, false);
    return new ReminderListFragment.ReminderListItemVH(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.ReminderListAdapter
 * JD-Core Version:    0.7.0.1
 */