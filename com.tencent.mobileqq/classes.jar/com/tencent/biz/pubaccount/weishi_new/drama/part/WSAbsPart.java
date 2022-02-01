package com.tencent.biz.pubaccount.weishi_new.drama.part;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;

public abstract class WSAbsPart
  implements IWSPartLifeCycle
{
  protected Context a;
  protected View a;
  protected ViewStub a;
  
  public WSAbsPart(Context paramContext, ViewStub paramViewStub)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
  }
  
  private void a(ViewStub paramViewStub)
  {
    paramViewStub.setLayoutResource(a());
    this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
  }
  
  public void E_()
  {
    a(this.jdField_a_of_type_AndroidViewViewStub);
  }
  
  public void F_() {}
  
  protected abstract int a();
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  protected View a(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      return localView.findViewById(paramInt);
    }
    return null;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void h() {}
  
  public void i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.part.WSAbsPart
 * JD-Core Version:    0.7.0.1
 */