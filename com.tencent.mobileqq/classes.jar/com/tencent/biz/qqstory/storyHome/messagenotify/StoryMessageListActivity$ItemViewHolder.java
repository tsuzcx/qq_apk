package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;

public class StoryMessageListActivity$ItemViewHolder
  extends SwipRightMenuBuilder.SwipItemBaseHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  String a;
  ImageView b;
  String c;
  StoryCoverView d;
  TextView e;
  TextView f;
  TextView g;
  View h;
  TextView i;
  TextView j;
  TextView k;
  View l;
  int m;
  
  public StoryMessageListActivity$ItemViewHolder(StoryMessageListActivity paramStoryMessageListActivity, View paramView)
  {
    this.b = ((ImageView)paramView.findViewById(2131428988));
    this.d = ((StoryCoverView)paramView.findViewById(2131447324));
    this.e = ((TextView)paramView.findViewById(2131439295));
    this.f = ((TextView)paramView.findViewById(2131431033));
    this.g = ((TextView)paramView.findViewById(2131439404));
    this.h = paramView.findViewById(2131437186);
    this.i = ((TextView)paramView.findViewById(2131447382));
    this.j = ((TextView)paramView.findViewById(2131449463));
    this.k = ((TextView)paramView.findViewById(2131449464));
    this.l = paramView.findViewById(2131437197);
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void onClick(View paramView)
  {
    StoryMessageListActivity localStoryMessageListActivity = this.n;
    SwipListView localSwipListView = localStoryMessageListActivity.b;
    int i1 = this.m;
    localStoryMessageListActivity.onItemClick(localSwipListView, paramView, i1, i1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    StoryMessageListActivity localStoryMessageListActivity = this.n;
    SwipListView localSwipListView = localStoryMessageListActivity.b;
    int i1 = this.m;
    return localStoryMessageListActivity.onItemLongClick(localSwipListView, paramView, i1, i1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.ItemViewHolder
 * JD-Core Version:    0.7.0.1
 */