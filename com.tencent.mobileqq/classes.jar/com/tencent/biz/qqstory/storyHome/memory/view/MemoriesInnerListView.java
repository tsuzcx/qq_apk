package com.tencent.biz.qqstory.storyHome.memory.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.HorizontalListView;
import java.util.List;

@TargetApi(9)
public class MemoriesInnerListView
  extends HorizontalListView
{
  public MemoriesInnerListView.OnInnerListRefreshListener a = null;
  protected int b;
  protected int c;
  private MemoriesInnerListAdapter d;
  
  public MemoriesInnerListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MemoriesInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.b = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.c = DisplayUtil.a(paramContext, 82.0F);
    this.d = new MemoriesInnerListAdapter(getContext());
    super.setAdapter(this.d);
    super.setOnItemClickListener(this.d);
    super.setOnScrollStateChangedListener(new MemoriesInnerListView.1(this));
    setOverScrollMode(1);
  }
  
  public BaseAdapter getAdapter()
  {
    return this.d;
  }
  
  public void setDate(List<VideoCollectionItem.FakeVideoUIItem> paramList, String paramString)
  {
    this.d.a(paramList, paramString);
    int i = this.b / this.c;
    if (paramList.size() >= i)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView
 * JD-Core Version:    0.7.0.1
 */