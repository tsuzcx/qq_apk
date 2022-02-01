package com.tencent.biz.qqcircle.richframework.widget.drag;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.qphone.base.util.QLog;

@TargetApi(19)
public class DragTextView
  extends TextView
  implements IDragView
{
  private static int a;
  private static int b;
  private static int c;
  private IDragView.OnChangeModeListener d;
  private int e = -1;
  private boolean f;
  private Rect g = null;
  private View h = null;
  
  public DragTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public DragTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public DragTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private static void a(Context paramContext)
  {
    if (a == 0)
    {
      float f1 = paramContext.getResources().getDisplayMetrics().density * 16.0F;
      a = (int)f1;
      b = (int)(1.5F * f1);
      c = (int)(f1 * 0.5F);
    }
  }
  
  private void a(View paramView, Rect paramRect)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    super.getGlobalVisibleRect(paramRect);
    if (this.e == 2)
    {
      paramRect.top = (paramRect.top - localRect.top - a);
      paramRect.left = (paramRect.left - localRect.left - c);
      paramRect.bottom = (paramRect.bottom - localRect.top + c);
      paramRect.right = (paramRect.right - localRect.left + a);
      return;
    }
    paramRect.top = (paramRect.top - localRect.top - b);
    paramRect.left = (paramRect.left - localRect.left - b);
    paramRect.bottom = (paramRect.bottom - localRect.top + a);
    paramRect.right = (paramRect.right - localRect.left + a);
  }
  
  public int getDragViewType()
  {
    return this.e;
  }
  
  public IDragView.OnChangeModeListener getOnModeChangeListener()
  {
    return this.d;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Rect localRect = this.g;
    if ((localRect != null) && (paramBoolean)) {
      a(this.h, localRect);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.e != -1) && (!this.f) && (paramMotionEvent.getAction() == 0))
    {
      if (this.d != null)
      {
        if ((!QCircleHostConstants._AppSetting.isPublicVersion()) && (QLog.isColorLevel()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onTouchEvent hit: ");
          localStringBuilder.append(paramMotionEvent);
          localStringBuilder.append("; cur Rect:");
          localStringBuilder.append(this.g);
          QLog.d("DragTextView", 2, localStringBuilder.toString());
        }
        this.f = true;
        this.d.a(this, this.e);
        return true;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setDragViewType(int paramInt)
  {
    setDragViewType(paramInt, null);
  }
  
  public void setDragViewType(int paramInt, View paramView)
  {
    this.e = paramInt;
    this.h = paramView;
    if (this.h == null) {
      this.h = ((ViewGroup)getParent());
    }
    if ((this.d != null) && (this.h != null) && (this.g == null))
    {
      this.g = new Rect();
      this.h.setTouchDelegate(new DragTextView.DragTouchDelegate(this, this.g, this));
    }
  }
  
  public void setOnModeChangeListener(IDragView.OnChangeModeListener paramOnChangeModeListener)
  {
    this.d = paramOnChangeModeListener;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setOnModeChangeListener:");
      localStringBuilder.append(paramOnChangeModeListener);
      QLog.d("Drag", 2, localStringBuilder.toString());
    }
    if ((this.d != null) && (this.h != null) && (this.g == null))
    {
      this.g = new Rect();
      this.h.setTouchDelegate(new DragTextView.DragTouchDelegate(this, this.g, this));
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((this.f) && (paramInt == 0)) {
      this.f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView
 * JD-Core Version:    0.7.0.1
 */