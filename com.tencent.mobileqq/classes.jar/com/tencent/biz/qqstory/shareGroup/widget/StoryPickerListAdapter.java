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
  Context a;
  ArrayList<VideoCollectionItem> b = new ArrayList();
  HashMap<String, WeakReference<StoryPickerListAdapter.DayItemViewHolder>> c = new HashMap();
  StoryPickerHorizontalListView.OnHorizontalScrollListener d;
  StoryPickerHorizontalListView.OnHorizontalItemClickListener e;
  StoryPickerHorizontalListView.OnCheckBoxClickListener f;
  
  public StoryPickerListAdapter(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131628156, paramViewGroup, false);
    paramViewGroup.setTag(new StoryPickerListAdapter.DayItemViewHolder(this, paramViewGroup, this.d));
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView)
  {
    VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)this.b.get(paramInt);
    ((StoryPickerListAdapter.DayItemViewHolder)paramView.getTag()).a(paramInt, localVideoCollectionItem);
  }
  
  public List<VideoCollectionItem> a()
  {
    return this.b;
  }
  
  public void a(StoryPickerHorizontalListView.OnCheckBoxClickListener paramOnCheckBoxClickListener)
  {
    this.f = paramOnCheckBoxClickListener;
  }
  
  public void a(StoryPickerHorizontalListView.OnHorizontalItemClickListener paramOnHorizontalItemClickListener)
  {
    this.e = paramOnHorizontalItemClickListener;
  }
  
  public void a(StoryPickerHorizontalListView.OnHorizontalScrollListener paramOnHorizontalScrollListener)
  {
    this.d = paramOnHorizontalScrollListener;
  }
  
  public void a(String paramString, List<VideoCollectionItem.FakeVideoUIItem> paramList)
  {
    WeakReference localWeakReference = (WeakReference)this.c.get(paramString);
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((StoryPickerHorizontalListAdapter)((StoryPickerListAdapter.DayItemViewHolder)localWeakReference.get()).b.getAdapter()).b(paramList, paramString);
    }
  }
  
  public void a(List<VideoCollectionItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.b.clear();
      this.b.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public VideoCollectionItem b()
  {
    if (!this.b.isEmpty())
    {
      ArrayList localArrayList = this.b;
      return (VideoCollectionItem)localArrayList.get(localArrayList.size() - 1);
    }
    return null;
  }
  
  public void b(List<VideoCollectionItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.b.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramViewGroup);
    }
    a(paramInt, localView);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerListAdapter
 * JD-Core Version:    0.7.0.1
 */