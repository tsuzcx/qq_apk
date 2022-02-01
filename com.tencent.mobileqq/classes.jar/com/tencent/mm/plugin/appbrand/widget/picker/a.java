package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public final class a
  extends d
{
  private static final int f = 2131428562;
  
  public a(Context paramContext)
  {
    super(paramContext);
    super.setId(f);
    setBackgroundResource(2131168376);
    setOnClickListener(new a.1(this));
  }
  
  public static a a(View paramView)
  {
    return (a)paramView.getRootView().findViewById(f);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void b()
  {
    super.b();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!isShown())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i;
    if ((getParent() != null) && ((getParent() instanceof ViewGroup))) {
      i = ((ViewGroup)getParent()).getMeasuredHeight();
    } else {
      i = 0;
    }
    if (i > 0)
    {
      a(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setHeader(String paramString)
  {
    super.setHeader(paramString);
  }
  
  public void setId(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.a
 * JD-Core Version:    0.7.0.1
 */