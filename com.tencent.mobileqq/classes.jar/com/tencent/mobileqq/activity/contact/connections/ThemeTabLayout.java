package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.TabLayoutCompat.OnTabSelectedListener;
import java.util.ArrayList;

public class ThemeTabLayout
  extends FrameLayout
{
  public float a;
  public float b;
  public float c;
  public float d;
  private ConnectionsTabLayout e = null;
  private TabThemeMaskView f;
  
  public ThemeTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ThemeTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ThemeTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public void a()
  {
    Object localObject = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2131627603, this, false);
    this.e = ((ConnectionsTabLayout)((RelativeLayout)localObject).findViewById(2131431244));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = ViewUtils.dip2px(10.0F);
    addView((View)localObject, localLayoutParams);
    this.f = new TabThemeMaskView(getContext());
    localObject = new FrameLayout.LayoutParams(-1, -1);
    addView(this.f, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public void a(TabLayoutCompat.OnTabSelectedListener paramOnTabSelectedListener)
  {
    ConnectionsTabLayout localConnectionsTabLayout = this.e;
    if (localConnectionsTabLayout == null) {
      return;
    }
    localConnectionsTabLayout.b(paramOnTabSelectedListener);
  }
  
  public void a(ArrayList<ConnectionsTabInfo> paramArrayList, int paramInt)
  {
    ConnectionsTabLayout localConnectionsTabLayout = this.e;
    if (localConnectionsTabLayout != null)
    {
      if (this.f == null) {
        return;
      }
      if ((paramArrayList != null) && (paramInt >= 0)) {
        localConnectionsTabLayout.a(paramArrayList, paramInt);
      }
    }
  }
  
  public void b()
  {
    this.e.b();
  }
  
  public void b(ArrayList<ConnectionsTabInfo> paramArrayList, int paramInt)
  {
    this.e.b(paramArrayList, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i == 2))
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.a += Math.abs(f1 - this.c);
        this.b += Math.abs(f2 - this.d);
        this.c = f1;
        this.d = f2;
        if (this.a <= this.b) {
          getParent().requestDisallowInterceptTouchEvent(false);
        } else {
          getParent().requestDisallowInterceptTouchEvent(true);
        }
      }
    }
    else
    {
      this.b = 0.0F;
      this.a = 0.0F;
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public float getScrollPositionOffset()
  {
    ConnectionsTabLayout localConnectionsTabLayout = this.e;
    if (localConnectionsTabLayout != null) {
      return localConnectionsTabLayout.getScrollX();
    }
    return 0.0F;
  }
  
  public int getSelectedTabPosition()
  {
    ConnectionsTabLayout localConnectionsTabLayout = this.e;
    if (localConnectionsTabLayout != null) {
      return localConnectionsTabLayout.getSelectedTabPosition();
    }
    return 0;
  }
  
  public void setOnTabSelectedListener(TabLayoutCompat.OnTabSelectedListener paramOnTabSelectedListener)
  {
    ConnectionsTabLayout localConnectionsTabLayout = this.e;
    if (localConnectionsTabLayout != null)
    {
      if (this.f == null) {
        return;
      }
      if (paramOnTabSelectedListener != null) {
        localConnectionsTabLayout.a(paramOnTabSelectedListener);
      }
    }
  }
  
  public void setScrollPosition(float paramFloat)
  {
    ConnectionsTabLayout localConnectionsTabLayout = this.e;
    if (localConnectionsTabLayout != null) {
      localConnectionsTabLayout.setScrollX((int)paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ThemeTabLayout
 * JD-Core Version:    0.7.0.1
 */