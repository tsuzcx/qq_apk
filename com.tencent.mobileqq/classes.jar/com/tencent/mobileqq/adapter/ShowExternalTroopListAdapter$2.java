package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShowExternalTroopListAdapter$2
  implements View.OnClickListener
{
  ShowExternalTroopListAdapter$2(ShowExternalTroopListAdapter paramShowExternalTroopListAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof NearbyTroops.CustomViewHolder)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (NearbyTroops.CustomViewHolder)localObject;
      this.a.a.a(((NearbyTroops.CustomViewHolder)localObject).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.2
 * JD-Core Version:    0.7.0.1
 */