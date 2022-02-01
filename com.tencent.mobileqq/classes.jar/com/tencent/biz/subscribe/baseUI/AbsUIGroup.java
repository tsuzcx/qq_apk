package com.tencent.biz.subscribe.baseUI;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

public abstract class AbsUIGroup<T>
  extends AbsUI<T>
{
  protected int f = -1;
  
  public AbsUIGroup(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }
  
  protected void a()
  {
    this.b = l();
    j();
  }
  
  public void a(View paramView)
  {
    if ((paramView != null) && (m())) {
      ((ViewGroup)this.b).addView(paramView);
    }
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub == null) {
      return;
    }
    int i = this.f;
    if (i != -1)
    {
      a(paramViewStub, i);
      return;
    }
    paramViewStub.setLayoutResource(k());
    this.b = paramViewStub.inflate();
    if (k() == 2131628885) {
      a(l());
    }
    j();
  }
  
  public void a(ViewStub paramViewStub, int paramInt)
  {
    if (paramViewStub != null)
    {
      paramViewStub.setLayoutResource(paramInt);
      this.b = paramViewStub.inflate();
      j();
    }
  }
  
  protected View b(int paramInt)
  {
    if (this.b != null) {
      return this.b.findViewById(paramInt);
    }
    return null;
  }
  
  protected abstract void j();
  
  protected abstract int k();
  
  protected abstract View l();
  
  protected boolean m()
  {
    return (this.b != null) && ((this.b instanceof ViewGroup));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.baseUI.AbsUIGroup
 * JD-Core Version:    0.7.0.1
 */