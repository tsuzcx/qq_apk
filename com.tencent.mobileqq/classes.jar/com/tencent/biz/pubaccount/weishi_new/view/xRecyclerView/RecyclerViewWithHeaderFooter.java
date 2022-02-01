package com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecyclerViewWithHeaderFooter
  extends RecyclerView
{
  public boolean a = false;
  private final List<View> b = new ArrayList();
  private final List<View> c = new ArrayList();
  private RecyclerViewHeaderViewAdapter.ContentDataObserver d;
  private RecyclerViewHeaderViewAdapter.OnBindHeaderObserver e;
  
  public RecyclerViewWithHeaderFooter(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecyclerViewWithHeaderFooter(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecyclerViewWithHeaderFooter(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView)
  {
    this.c.add(paramView);
  }
  
  public RecyclerViewHeaderViewAdapter.ContentDataObserver getContentDataObserver()
  {
    return this.d;
  }
  
  public int getFooterViewsCount()
  {
    List localList = this.c;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getHeaderViewsCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a)
    {
      super.onInterceptTouchEvent(paramMotionEvent);
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a)
    {
      if (paramMotionEvent.getAction() == 1) {
        this.a = false;
      }
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    Object localObject;
    if (this.b.size() <= 0)
    {
      localObject = paramAdapter;
      if (this.c.size() <= 0) {}
    }
    else
    {
      localObject = new RecyclerViewHeaderViewAdapter(paramAdapter);
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((RecyclerViewHeaderViewAdapter)localObject).a((View)localIterator.next());
      }
      localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((RecyclerViewHeaderViewAdapter)localObject).b((View)localIterator.next());
      }
      ((RecyclerViewHeaderViewAdapter)localObject).setHasStableIds(paramAdapter.hasStableIds());
      if ((getLayoutManager() instanceof GridLayoutManager))
      {
        paramAdapter = (GridLayoutManager)getLayoutManager();
        paramAdapter.setSpanSizeLookup(new HeaderSpanSizeLookup((RecyclerViewHeaderViewAdapter)localObject, paramAdapter));
      }
      paramAdapter = this.d;
      if (paramAdapter != null) {
        ((RecyclerViewHeaderViewAdapter)localObject).a(paramAdapter);
      }
      paramAdapter = this.e;
      if (paramAdapter != null) {
        ((RecyclerViewHeaderViewAdapter)localObject).a(paramAdapter);
      }
    }
    super.setAdapter((RecyclerView.Adapter)localObject);
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    super.setLayoutManager(paramLayoutManager);
    if ((getAdapter() != null) && ((getAdapter() instanceof RecyclerViewHeaderViewAdapter)))
    {
      Object localObject = (RecyclerViewHeaderViewAdapter)getAdapter();
      if ((getLayoutManager() instanceof GridLayoutManager))
      {
        paramLayoutManager = (GridLayoutManager)getLayoutManager();
        localObject = new HeaderSpanSizeLookup((RecyclerViewHeaderViewAdapter)localObject, paramLayoutManager);
        ((HeaderSpanSizeLookup)localObject).a(paramLayoutManager.getSpanSizeLookup());
        paramLayoutManager.setSpanSizeLookup((GridLayoutManager.SpanSizeLookup)localObject);
      }
    }
  }
  
  public void setOnBindHeaderObserver(RecyclerViewHeaderViewAdapter.OnBindHeaderObserver paramOnBindHeaderObserver)
  {
    this.e = paramOnBindHeaderObserver;
    if ((getAdapter() instanceof RecyclerViewHeaderViewAdapter)) {
      ((RecyclerViewHeaderViewAdapter)getAdapter()).a(paramOnBindHeaderObserver);
    }
  }
  
  public void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    super.setRecycledViewPool(new RecyclerViewWithHeaderFooter.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.RecyclerViewWithHeaderFooter
 * JD-Core Version:    0.7.0.1
 */