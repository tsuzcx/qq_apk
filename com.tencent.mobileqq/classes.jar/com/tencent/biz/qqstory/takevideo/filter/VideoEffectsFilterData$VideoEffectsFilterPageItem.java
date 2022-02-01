package com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class VideoEffectsFilterData$VideoEffectsFilterPageItem
  extends FilterData.FilterPageItem<VideoEffectsFilterData>
{
  public final ImageView a;
  public final TextView a;
  public final TextView b = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379167);
  
  VideoEffectsFilterData$VideoEffectsFilterPageItem(VideoEffectsFilterData paramVideoEffectsFilterData, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379091));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368729));
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561816, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void a(VideoEffectsFilterData paramVideoEffectsFilterData, int paramInt)
  {
    super.a(paramVideoEffectsFilterData, paramInt);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData != null) && (((VideoEffectsFilterData)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData).c != 0) && (((VideoEffectsFilterData)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData).a != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((VideoEffectsFilterData)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData).c);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((VideoEffectsFilterData)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData).a);
      this.b.setText(((VideoEffectsFilterData)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData).b);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.b.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.filter.VideoEffectsFilterData.VideoEffectsFilterPageItem
 * JD-Core Version:    0.7.0.1
 */