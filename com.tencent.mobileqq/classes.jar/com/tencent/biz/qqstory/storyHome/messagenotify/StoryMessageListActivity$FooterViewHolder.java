package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;

public class StoryMessageListActivity$FooterViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  View a;
  TextView b;
  View c;
  ImageView d;
  int e;
  
  public StoryMessageListActivity$FooterViewHolder(StoryMessageListActivity paramStoryMessageListActivity, View paramView)
  {
    this.a = paramView.findViewById(2131437622);
    this.b = ((TextView)paramView.findViewById(2131437659));
    this.c = paramView.findViewById(2131438875);
    this.d = ((ImageView)paramView.findViewById(2131438862));
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void onClick(View paramView)
  {
    StoryMessageListActivity localStoryMessageListActivity = this.f;
    SwipListView localSwipListView = localStoryMessageListActivity.b;
    int i = this.e;
    localStoryMessageListActivity.onItemClick(localSwipListView, paramView, i, i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    StoryMessageListActivity localStoryMessageListActivity = this.f;
    SwipListView localSwipListView = localStoryMessageListActivity.b;
    int i = this.e;
    return localStoryMessageListActivity.onItemLongClick(localSwipListView, paramView, i, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.FooterViewHolder
 * JD-Core Version:    0.7.0.1
 */