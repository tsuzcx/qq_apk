package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import pxl;
import rpv;
import rpx;

public class ReadInJoyLifeCycleLinearLayout
  extends LinearLayout
  implements rpv
{
  private boolean a;
  
  public ReadInJoyLifeCycleLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    Object localObject = getTag();
    if ((localObject instanceof pxl))
    {
      localObject = ((pxl)localObject).a();
      if ((localObject instanceof rpx)) {
        ((rpx)localObject).a();
      }
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void b()
  {
    Object localObject = getTag();
    if ((localObject instanceof pxl))
    {
      localObject = ((pxl)localObject).a();
      if ((localObject instanceof rpx)) {
        ((rpx)localObject).b();
      }
    }
  }
  
  public void setIsResume(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyLifeCycleLinearLayout
 * JD-Core Version:    0.7.0.1
 */