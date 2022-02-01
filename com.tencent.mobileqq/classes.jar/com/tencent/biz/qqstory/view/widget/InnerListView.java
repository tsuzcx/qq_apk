package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.List;

public class InnerListView
  extends LinearLayout
{
  private LayoutInflater a;
  private List<BaseViewHolder> b;
  private InnerListView.OnItemClickListener c;
  private InnerListView.OnItemLongClickListener d;
  private InnerListViewAdapter e;
  private List<View> f;
  
  public InnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InnerListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext);
    this.b = new ArrayList();
  }
  
  public void a()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if ((((InnerListViewAdapter)localObject).b() != null) && (!this.e.b().isEmpty()))
      {
        int j = this.e.b().size();
        if (j < getChildCount() - getFooterCount()) {
          removeViews(j, getChildCount() - j - getFooterCount());
        }
        int i = 0;
        while (i < j)
        {
          if (this.b.size() - 1 >= i)
          {
            localObject = (BaseViewHolder)this.b.get(i);
          }
          else
          {
            localObject = new BaseViewHolder(this.a.inflate(this.e.a(), this, false));
            this.b.add(localObject);
          }
          this.e.a(i, (BaseViewHolder)localObject);
          localObject = ((BaseViewHolder)localObject).a();
          if (((View)localObject).getParent() == null) {
            addView((View)localObject, getChildCount() - getFooterCount());
          }
          ((View)localObject).setOnClickListener(new InnerListView.1(this, i));
          ((View)localObject).setOnLongClickListener(new InnerListView.2(this, i));
          i += 1;
        }
      }
      removeViews(0, getChildCount() - getFooterCount());
      return;
    }
    removeViews(0, getChildCount() - getFooterCount());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    int i = 0;
    while (i < paramInt2)
    {
      BaseViewHolder localBaseViewHolder = new BaseViewHolder(this.a.inflate(paramInt1, this, false));
      this.b.add(localBaseViewHolder);
      i += 1;
    }
    SLog.e("DEBUG_TIME", "InnerListView initVHCaches:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void a(View paramView)
  {
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.f.add(paramView);
    addView(paramView);
  }
  
  public int getFooterCount()
  {
    List localList = this.f;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public void setAdapter(InnerListViewAdapter paramInnerListViewAdapter)
  {
    this.e = paramInnerListViewAdapter;
    a();
  }
  
  public void setFooterView(int paramInt, View paramView)
  {
    List localList = this.f;
    if ((localList != null) && (localList.size() > paramInt))
    {
      this.f.set(paramInt, paramView);
      paramInt = getChildCount() - getFooterCount() + paramInt;
      removeViewAt(paramInt);
      addView(paramView, paramInt);
      return;
    }
    a(paramView);
  }
  
  public void setOnItemClickListener(InnerListView.OnItemClickListener paramOnItemClickListener)
  {
    this.c = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(InnerListView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.d = paramOnItemLongClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.InnerListView
 * JD-Core Version:    0.7.0.1
 */