package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363196));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView = ((StoryCoverView)paramView.findViewById(2131379315));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372265));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365027));
    this.c = ((TextView)paramView.findViewById(2131372377));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370364);
    this.d = ((TextView)paramView.findViewById(2131379372));
    this.e = ((TextView)paramView.findViewById(2131381252));
    this.f = ((TextView)paramView.findViewById(2131381253));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370380);
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.onItemClick(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a, paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.onItemLongClick(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a, paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.ItemViewHolder
 * JD-Core Version:    0.7.0.1
 */