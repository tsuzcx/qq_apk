package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class NumberWheelView$NumberAdapter
  extends BaseAdapter
{
  public List<Integer> a;
  private Context c;
  private int d = 36;
  
  public NumberWheelView$NumberAdapter(NumberWheelView paramNumberWheelView, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramContext;
    this.d = ((int)TypedValue.applyDimension(1, paramInt1, this.c.getResources().getDisplayMetrics()));
    a(paramInt2, paramInt3);
  }
  
  public View a(int paramInt)
  {
    return getView(paramInt, null, null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = new ArrayList();
    while (paramInt1 <= paramInt2)
    {
      this.a.add(Integer.valueOf(paramInt1));
      paramInt1 += 1;
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new WheelTextView(this.c);
      ((View)localObject1).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.d));
      paramView = (WheelTextView)localObject1;
    }
    else
    {
      localObject2 = null;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    Object localObject2 = paramView;
    if (paramView == null) {
      localObject2 = (WheelTextView)localObject1;
    }
    paramView = String.format("%d", new Object[] { this.a.get(paramInt) });
    ((WheelTextView)localObject2).setTextSize(18.0F);
    ((WheelTextView)localObject2).setTextColor(-7829368);
    ((WheelTextView)localObject2).setGravity(5);
    ((WheelTextView)localObject2).setVisibility(0);
    ((WheelTextView)localObject2).setText(paramView);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.NumberWheelView.NumberAdapter
 * JD-Core Version:    0.7.0.1
 */