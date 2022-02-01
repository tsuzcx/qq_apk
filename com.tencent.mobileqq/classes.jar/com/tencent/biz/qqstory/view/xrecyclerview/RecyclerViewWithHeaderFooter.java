package com.tencent.biz.qqstory.view.xrecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
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
      paramAdapter = this.b.iterator();
      while (paramAdapter.hasNext()) {
        ((RecyclerViewHeaderViewAdapter)localObject).a((View)paramAdapter.next());
      }
      paramAdapter = this.c.iterator();
      while (paramAdapter.hasNext()) {
        ((RecyclerViewHeaderViewAdapter)localObject).b((View)paramAdapter.next());
      }
      paramAdapter = this.d;
      if (paramAdapter != null) {
        ((RecyclerViewHeaderViewAdapter)localObject).a(paramAdapter);
      }
    }
    super.setAdapter((RecyclerView.Adapter)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.xrecyclerview.RecyclerViewWithHeaderFooter
 * JD-Core Version:    0.7.0.1
 */