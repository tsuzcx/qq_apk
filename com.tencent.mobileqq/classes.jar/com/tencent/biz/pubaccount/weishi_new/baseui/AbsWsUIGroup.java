package com.tencent.biz.pubaccount.weishi_new.baseui;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;

public abstract class AbsWsUIGroup<T>
  extends AbsWsUI<T>
  implements IPlayModeChangeListener
{
  protected int c = 1;
  
  public AbsWsUIGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  protected View a(int paramInt)
  {
    if (this.a != null) {
      return this.a.findViewById(paramInt);
    }
    return null;
  }
  
  public void a(ViewStub paramViewStub)
  {
    paramViewStub.setLayoutResource(b());
    this.a = paramViewStub.inflate();
    e();
  }
  
  protected abstract int b();
  
  protected abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup
 * JD-Core Version:    0.7.0.1
 */