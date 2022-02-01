package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.widget.menu.MMPopupMenu;

public class SelectableTextHelper$Builder
{
  private View a;
  private SelectableTextHelper.OuterMenuAction b;
  private View.OnClickListener c;
  private View.OnTouchListener d;
  private MMPopupMenu e;
  private int f = 2131165923;
  private int g = 2131167937;
  private int h = 0;
  private int i = 0;
  
  public SelectableTextHelper$Builder(View paramView, MMPopupMenu paramMMPopupMenu)
  {
    this.a = paramView;
    this.e = paramMMPopupMenu;
  }
  
  public SelectableTextHelper$Builder(View paramView, MMPopupMenu paramMMPopupMenu, SelectableTextHelper.OuterMenuAction paramOuterMenuAction, View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener)
  {
    this(paramView, paramMMPopupMenu);
    this.b = paramOuterMenuAction;
    this.c = paramOnClickListener;
    this.d = paramOnTouchListener;
  }
  
  public SelectableTextHelper build()
  {
    return new SelectableTextHelper(this);
  }
  
  public Builder setCursorHandleColor(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public Builder setCursorHandleSizeInDp(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public Builder setLeftPadding(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public Builder setSelectedColor(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.Builder
 * JD-Core Version:    0.7.0.1
 */