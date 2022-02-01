package com.tencent.biz.qqstory.shareGroup.widget;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.utils.DateUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class StoryPickerListAdapter$DayItemViewHolder
{
  public TextView a;
  public StoryPickerHorizontalListView a;
  
  public StoryPickerListAdapter$DayItemViewHolder(StoryPickerListAdapter paramStoryPickerListAdapter, View paramView, StoryPickerHorizontalListView.OnHorizontalScrollListener paramOnHorizontalScrollListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365584));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView = ((StoryPickerHorizontalListView)paramView.findViewById(2131368522));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setSelection(0);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setOnHorizontalScrollListener(paramOnHorizontalScrollListener);
    paramView = (StoryPickerHorizontalListAdapter)this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.a();
    paramView.a(paramStoryPickerListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnHorizontalItemClickListener);
    paramView.a(paramStoryPickerListAdapter.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnCheckBoxClickListener);
  }
  
  public void a(int paramInt, VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setData(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setTag(Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(DateUtils.b(paramVideoCollectionItem.collectionTime));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerListAdapter.jdField_a_of_type_JavaUtilHashMap.put(paramVideoCollectionItem.collectionId, new WeakReference(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerListAdapter.DayItemViewHolder
 * JD-Core Version:    0.7.0.1
 */