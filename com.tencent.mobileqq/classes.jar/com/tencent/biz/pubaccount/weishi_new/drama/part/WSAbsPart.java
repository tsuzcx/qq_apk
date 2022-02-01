package com.tencent.biz.pubaccount.weishi_new.drama.part;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;

public abstract class WSAbsPart
  implements IWSPartLifeCycle
{
  protected Context b;
  protected ViewStub c;
  protected View d;
  
  public WSAbsPart(Context paramContext, ViewStub paramViewStub)
  {
    this.b = paramContext;
    this.c = paramViewStub;
  }
  
  private void a(ViewStub paramViewStub)
  {
    paramViewStub.setLayoutResource(b());
    this.d = paramViewStub.inflate();
  }
  
  protected View a(int paramInt)
  {
    View localView = this.d;
    if (localView != null) {
      return localView.findViewById(paramInt);
    }
    return null;
  }
  
  protected abstract int b();
  
  public void c()
  {
    a(this.c);
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void m() {}
  
  public void n() {}
  
  public Context o()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.part.WSAbsPart
 * JD-Core Version:    0.7.0.1
 */