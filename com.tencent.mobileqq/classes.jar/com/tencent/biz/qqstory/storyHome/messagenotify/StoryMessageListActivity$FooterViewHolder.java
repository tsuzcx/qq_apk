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
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View b;
  
  public StoryMessageListActivity$FooterViewHolder(StoryMessageListActivity paramStoryMessageListActivity, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370360);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370392));
    this.b = paramView.findViewById(2131371498);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371487));
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    StoryMessageListActivity localStoryMessageListActivity = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity;
    SwipListView localSwipListView = localStoryMessageListActivity.a;
    int i = this.jdField_a_of_type_Int;
    localStoryMessageListActivity.onItemClick(localSwipListView, paramView, i, i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    StoryMessageListActivity localStoryMessageListActivity = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity;
    SwipListView localSwipListView = localStoryMessageListActivity.a;
    int i = this.jdField_a_of_type_Int;
    return localStoryMessageListActivity.onItemLongClick(localSwipListView, paramView, i, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.FooterViewHolder
 * JD-Core Version:    0.7.0.1
 */