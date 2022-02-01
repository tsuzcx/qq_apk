package com.tencent.mobileqq.activity.contact.troop;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.QuickRecyclerAdapter.OnItemClickListener;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopSuspiciousFragment$4
  implements QuickRecyclerAdapter.OnItemClickListener
{
  TroopSuspiciousFragment$4(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!(paramViewHolder instanceof SuspiciousHolder)) {}
    do
    {
      return;
      paramView = (SuspiciousHolder)paramViewHolder;
    } while (paramView.a.msg_type.get() != 2);
    TroopSuspiciousFragment.a(this.a, paramView);
  }
  
  public boolean a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment.4
 * JD-Core Version:    0.7.0.1
 */