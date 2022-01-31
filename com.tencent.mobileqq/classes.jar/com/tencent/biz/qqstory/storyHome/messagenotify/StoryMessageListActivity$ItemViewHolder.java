package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.StoryCoverView;
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367037));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView = ((StoryCoverView)paramView.findViewById(2131364191));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362743));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366884));
    this.c = ((TextView)paramView.findViewById(2131362134));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371903);
    this.d = ((TextView)paramView.findViewById(2131365215));
    this.e = ((TextView)paramView.findViewById(2131371904));
    this.f = ((TextView)paramView.findViewById(2131371905));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365554);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a, paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
  }
  
  public boolean onLongClick(View paramView)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a, paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.ItemViewHolder
 * JD-Core Version:    0.7.0.1
 */