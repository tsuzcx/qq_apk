package com.tencent.mobileqq.auto.engine.main;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;

public class IASBaseFrame
  implements IASFrame
{
  protected Context a;
  protected View b;
  
  public Fragment a(View paramView)
  {
    this.b = paramView;
    this.a = paramView.getContext();
    return null;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void c() {}
  
  public boolean d()
  {
    return false;
  }
  
  public void e() {}
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.main.IASBaseFrame
 * JD-Core Version:    0.7.0.1
 */