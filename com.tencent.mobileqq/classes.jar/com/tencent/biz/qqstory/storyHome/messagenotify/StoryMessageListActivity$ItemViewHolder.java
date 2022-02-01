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
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  StoryCoverView jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView;
  String jdField_a_of_type_JavaLangString;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  
  public StoryMessageListActivity$ItemViewHolder(StoryMessageListActivity paramStoryMessageListActivity, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363135));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView = ((StoryCoverView)paramView.findViewById(2131378667));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371854));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364910));
    this.c = ((TextView)paramView.findViewById(2131371959));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370030);
    this.d = ((TextView)paramView.findViewById(2131378723));
    this.e = ((TextView)paramView.findViewById(2131380506));
    this.f = ((TextView)paramView.findViewById(2131380507));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370041);
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
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.ItemViewHolder
 * JD-Core Version:    0.7.0.1
 */