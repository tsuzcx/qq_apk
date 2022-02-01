package com.tencent.mobileqq.activity.aio.coreui.input;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import java.util.Iterator;
import java.util.List;

public class InputBarUI
  implements View.OnLayoutChangeListener
{
  private final InputLinearLayout a;
  private final AIOContext b;
  
  public InputBarUI(AIOContext paramAIOContext, InputLinearLayout paramInputLinearLayout)
  {
    this.a = paramInputLinearLayout;
    this.b = paramAIOContext;
  }
  
  public InputLinearLayout a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
  
  public void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.a.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void b()
  {
    this.a.addOnLayoutChangeListener(this);
  }
  
  public final int c()
  {
    return this.a.getHeight();
  }
  
  public final int d()
  {
    return this.a.getTop();
  }
  
  public int e()
  {
    return this.a.getVisibility();
  }
  
  public Drawable f()
  {
    return this.a.getBackground();
  }
  
  public void g()
  {
    this.a.removeOnLayoutChangeListener(this);
  }
  
  public void h()
  {
    this.a.requestLayout();
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    Iterator localIterator = this.b.p().c().h().iterator();
    while (localIterator.hasNext()) {
      ((IInputBarLayoutChangeCallback)localIterator.next()).a(this.b, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI
 * JD-Core Version:    0.7.0.1
 */