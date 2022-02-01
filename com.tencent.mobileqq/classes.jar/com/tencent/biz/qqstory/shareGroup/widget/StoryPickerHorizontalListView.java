package com.tencent.biz.qqstory.shareGroup.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.HorizontalListView;
import java.util.List;

@TargetApi(9)
public class StoryPickerHorizontalListView
  extends HorizontalListView
{
  StoryPickerHorizontalListAdapter a;
  StoryPickerHorizontalListView.OnHorizontalScrollListener b;
  int c;
  int d;
  
  public StoryPickerHorizontalListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StoryPickerHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.c = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.d = DisplayUtil.a(paramContext, 105.0F);
    this.a = new StoryPickerHorizontalListAdapter(getContext());
    super.setAdapter(this.a);
    super.setOnItemClickListener(this.a);
    super.setOnScrollStateChangedListener(new StoryPickerHorizontalListView.1(this));
    setOverScrollMode(1);
  }
  
  public BaseAdapter getAdapter()
  {
    return this.a;
  }
  
  public void setData(List<VideoCollectionItem.FakeVideoUIItem> paramList, String paramString)
  {
    this.a.a(paramList, paramString);
    int i = this.c / this.d;
    if (paramList.size() >= i)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setOnHorizontalScrollListener(StoryPickerHorizontalListView.OnHorizontalScrollListener paramOnHorizontalScrollListener)
  {
    this.b = paramOnHorizontalScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView
 * JD-Core Version:    0.7.0.1
 */