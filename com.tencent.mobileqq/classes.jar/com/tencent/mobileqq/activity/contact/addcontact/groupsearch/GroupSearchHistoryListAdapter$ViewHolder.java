package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GroupSearchHistoryListAdapter$ViewHolder
  implements View.OnClickListener
{
  public View a;
  public View b;
  public ImageView c;
  public TextView d;
  public PressEffectImageView e;
  public int f;
  
  GroupSearchHistoryListAdapter$ViewHolder(GroupSearchHistoryListAdapter paramGroupSearchHistoryListAdapter) {}
  
  public void onClick(View paramView)
  {
    String str = this.g.a(this.f);
    if (paramView == this.e)
    {
      GroupSearchHistoryManager.a().b(GroupSearchHistoryListAdapter.a(this.g), str);
      this.g.a();
    }
    else if ((paramView == this.a) && (GroupSearchHistoryListAdapter.b(this.g) != null))
    {
      GroupSearchHistoryListAdapter.b(this.g).a(str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchHistoryListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */