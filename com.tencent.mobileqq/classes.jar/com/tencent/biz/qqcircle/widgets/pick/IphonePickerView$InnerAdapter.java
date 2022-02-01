package com.tencent.biz.qqcircle.widgets.pick;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class IphonePickerView$InnerAdapter
  extends BaseAdapter
{
  private int b = 25;
  private int c;
  
  public IphonePickerView$InnerAdapter(IphonePickerView paramIphonePickerView, int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.b = ((int)TypedValue.applyDimension(1, paramInt2, paramIphonePickerView.getResources().getDisplayMetrics()));
  }
  
  public int getCount()
  {
    return IphonePickerView.b(this.a).a(this.c);
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new WheelTextView(this.a.getContext());
      ((View)localObject).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.b));
      ((View)localObject).setFocusable(true);
      ((View)localObject).setFocusableInTouchMode(true);
    }
    paramView = IphonePickerView.b(this.a).a(this.c, paramInt);
    WheelTextView localWheelTextView = (WheelTextView)localObject;
    localWheelTextView.setTextSize(20.0F);
    localWheelTextView.setTextColor(IphonePickerView.a);
    localWheelTextView.setGravity(17);
    localWheelTextView.setText(paramView);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.IphonePickerView.InnerAdapter
 * JD-Core Version:    0.7.0.1
 */