package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;

public class NativeButtonImp
  extends DrawableCenterTextView
  implements IView
{
  public NativeButtonImp(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return getMeasuredWidth();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int b()
  {
    return getMeasuredHeight();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp
 * JD-Core Version:    0.7.0.1
 */