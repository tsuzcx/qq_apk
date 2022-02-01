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
  private ArrayList<ReminderListItemModel> b = new ArrayList();
  
  private ReminderListFragment$ReminderListAdapter(ReminderListFragment paramReminderListFragment) {}
  
  public void a(String paramString)
  {
    Object localObject = this.b;
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
        if (i >= this.b.size()) {
          break;
        }
        localObject = (ReminderListItemModel)this.b.get(i);
        if (paramString.equals(((ReminderListItemModel)localObject).a.msg_id))
        {
          if (!StringUtil.isEmpty(((ReminderListItemModel)localObject).b))
          {
            j = i + 1;
            if (j < this.b.size()) {
              if ((((ReminderListItemModel)localObject).c == 1) && (((ReminderListItemModel)this.b.get(j)).c == 1)) {
                ((ReminderListItemModel)this.b.get(j)).b = HardCodeUtil.a(2131910864);
              } else if ((((ReminderListItemModel)localObject).c == 0) && (((ReminderListItemModel)this.b.get(j)).c == 0)) {
                ((ReminderListItemModel)this.b.get(j)).b = HardCodeUtil.a(2131910853);
              }
            }
          }
          j = i;
          break;
        }
        i += 1;
      }
      i = j;
      if (j == this.b.size()) {
        i = j - 1;
      }
      this.b.remove(i);
      notifyItemRemoved(i);
      notifyItemRangeChanged(i, this.b.size());
      if (getItemCount() == 0) {
        ReminderListFragment.j(this.a);
      }
      ReminderListFragment.b(this.a, paramString);
    }
  }
  
  public void a(ArrayList<ReminderListItemModel> paramArrayList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.clear();
    }
    this.b.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.b;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      return this.b.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ReminderListFragment.ReminderListItemVH))
    {
      ReminderListFragment.ReminderListItemVH localReminderListItemVH = (ReminderListFragment.ReminderListItemVH)paramViewHolder;
      ArrayList localArrayList = this.b;
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        localReminderListItemVH.a((ReminderListItemModel)this.b.get(paramInt));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131627253, null, false);
    return new ReminderListFragment.ReminderListItemVH(this.a, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.ReminderListAdapter
 * JD-Core Version:    0.7.0.1
 */