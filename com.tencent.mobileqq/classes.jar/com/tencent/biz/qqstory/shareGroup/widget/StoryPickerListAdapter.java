package com.tencent.biz.qqstory.shareGroup.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoryPickerListAdapter
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  StoryPickerHorizontalListView.OnCheckBoxClickListener jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnCheckBoxClickListener;
  StoryPickerHorizontalListView.OnHorizontalItemClickListener jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnHorizontalItemClickListener;
  StoryPickerHorizontalListView.OnHorizontalScrollListener jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnHorizontalScrollListener;
  ArrayList<VideoCollectionItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, WeakReference<StoryPickerListAdapter.DayItemViewHolder>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public StoryPickerListAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561930, paramViewGroup, false);
    paramViewGroup.setTag(new StoryPickerListAdapter.DayItemViewHolder(this, paramViewGroup, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnHorizontalScrollListener));
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView)
  {
    VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ((StoryPickerListAdapter.DayItemViewHolder)paramView.getTag()).a(paramInt, localVideoCollectionItem);
  }
  
  public VideoCollectionItem a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    }
    return null;
  }
  
  public List<VideoCollectionItem> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(StoryPickerHorizontalListView.OnCheckBoxClickListener paramOnCheckBoxClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnCheckBoxClickListener = paramOnCheckBoxClickListener;
  }
  
  public void a(StoryPickerHorizontalListView.OnHorizontalItemClickListener paramOnHorizontalItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnHorizontalItemClickListener = paramOnHorizontalItemClickListener;
  }
  
  public void a(StoryPickerHorizontalListView.OnHorizontalScrollListener paramOnHorizontalScrollListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnHorizontalScrollListener = paramOnHorizontalScrollListener;
  }
  
  public void a(String paramString, List<VideoCollectionItem.FakeVideoUIItem> paramList)
  {
    WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((StoryPickerHorizontalListAdapter)((StoryPickerListAdapter.DayItemViewHolder)localWeakReference.get()).a.a()).b(paramList, paramString);
    }
  }
  
  public void a(List<VideoCollectionItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void b(List<VideoCollectionItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = a(paramViewGroup);
    }
    for (;;)
    {
      a(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerListAdapter
 * JD-Core Version:    0.7.0.1
 */