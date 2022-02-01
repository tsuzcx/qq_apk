package com.tencent.mobileqq.activity.contact.troop;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.QuickRecyclerAdapter.OnItemClickListener;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopNotifyAndRecommendView$22
  implements QuickRecyclerAdapter.OnItemClickListener
{
  TroopNotifyAndRecommendView$22(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!(paramViewHolder instanceof SuspiciousHolder)) {}
    do
    {
      return;
      paramView = (SuspiciousHolder)paramViewHolder;
    } while (paramView.a.msg_type.get() != 2);
    TroopNotifyAndRecommendView.a(this.a, paramView);
  }
  
  public boolean a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.22
 * JD-Core Version:    0.7.0.1
 */