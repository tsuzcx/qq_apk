package com.tencent.biz.qqstory.storyHome.discover.view;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import nwl;

public class StoryDiscoverAdapter$StoryDiscoverViewHolder
  extends RecyclerView.ViewHolder
{
  public int a;
  public ImageView a;
  public TextView a;
  public StoryDiscoverAdapter.OnHolderItemClickListener a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  public TextView d;
  public TextView e;
  
  public StoryDiscoverAdapter$StoryDiscoverViewHolder(View paramView, StoryDiscoverAdapter.OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371807));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371808));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371809));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371811));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371812));
    this.d = ((TextView)paramView.findViewById(2131371813));
    this.e = ((TextView)paramView.findViewById(2131371814));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371815));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewStoryDiscoverAdapter$OnHolderItemClickListener = paramOnHolderItemClickListener;
    paramView.setOnClickListener(new nwl(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.view.StoryDiscoverAdapter.StoryDiscoverViewHolder
 * JD-Core Version:    0.7.0.1
 */