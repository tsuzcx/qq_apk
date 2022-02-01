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
  public StoryPickerHorizontalListView b;
  
  public StoryPickerListAdapter$DayItemViewHolder(StoryPickerListAdapter paramStoryPickerListAdapter, View paramView, StoryPickerHorizontalListView.OnHorizontalScrollListener paramOnHorizontalScrollListener)
  {
    this.a = ((TextView)paramView.findViewById(2131431631));
    this.b = ((StoryPickerHorizontalListView)paramView.findViewById(2131435139));
    this.b.setSelection(0);
    this.b.setOnHorizontalScrollListener(paramOnHorizontalScrollListener);
    paramView = (StoryPickerHorizontalListAdapter)this.b.getAdapter();
    paramView.a(paramStoryPickerListAdapter.e);
    paramView.a(paramStoryPickerListAdapter.f);
  }
  
  public void a(int paramInt, VideoCollectionItem paramVideoCollectionItem)
  {
    this.b.setData(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
    this.b.setTag(Integer.valueOf(paramInt));
    this.a.setText(DateUtils.c(paramVideoCollectionItem.collectionTime));
    this.c.c.put(paramVideoCollectionItem.collectionId, new WeakReference(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerListAdapter.DayItemViewHolder
 * JD-Core Version:    0.7.0.1
 */