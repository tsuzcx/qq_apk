package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FrameAdapter
  extends BaseAdapter
{
  private FrameLoader a;
  private Context b;
  private int c;
  private int d;
  private int e;
  
  public FrameAdapter(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramContext;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public Bitmap a(int paramInt)
  {
    return null;
  }
  
  public void a()
  {
    this.a = null;
    this.b = null;
  }
  
  public void a(FrameLoader paramFrameLoader)
  {
    this.a = paramFrameLoader;
  }
  
  public int getCount()
  {
    return this.c;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new ImageView(this.b);
      float f = TakeVideoUtils.b(this.b.getResources());
      int i = this.d;
      paramView = new ViewGroup.LayoutParams(i, (int)(f * i));
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ImageView)localObject).setLayoutParams(paramView);
      paramView = new FrameAdapter.Holder();
      paramView.a = ((ImageView)localObject);
      paramView.a.setImageDrawable(new ColorDrawable(-12303292));
      ((View)localObject).setTag(paramView);
    }
    else
    {
      FrameAdapter.Holder localHolder = (FrameAdapter.Holder)paramView.getTag();
      localObject = paramView;
      paramView = localHolder;
    }
    this.a.b(paramView.a, Integer.valueOf(paramInt));
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.FrameAdapter
 * JD-Core Version:    0.7.0.1
 */