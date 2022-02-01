package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class BaseViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  public View a;
  public SparseArray<View> b;
  public SparseArray<String> c;
  public int d;
  public String e;
  public int f = -1;
  public int g = -1;
  public Object h;
  public ChildViewClickListener i;
  public boolean j = false;
  public HashMap<String, Object> k;
  
  public BaseViewHolder(View paramView)
  {
    this.a = paramView;
    this.b = new SparseArray();
    this.c = new SparseArray();
    this.k = new HashMap();
    paramView.setTag(this);
  }
  
  public View a()
  {
    return this.a;
  }
  
  public <T extends View> T a(int paramInt)
  {
    View localView2 = (View)this.b.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.a.findViewById(paramInt);
      this.b.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public Object a(String paramString)
  {
    return this.k.get(paramString);
  }
  
  public void a(ChildViewClickListener paramChildViewClickListener)
  {
    this.i = paramChildViewClickListener;
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.k.put(paramString, paramObject);
  }
  
  public void onClick(View paramView)
  {
    ChildViewClickListener localChildViewClickListener = this.i;
    if (localChildViewClickListener != null) {
      localChildViewClickListener.a(this.f, paramView, this.h, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    ChildViewClickListener localChildViewClickListener = this.i;
    if (localChildViewClickListener != null) {
      localChildViewClickListener.b(this.f, paramView, this.h, this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */