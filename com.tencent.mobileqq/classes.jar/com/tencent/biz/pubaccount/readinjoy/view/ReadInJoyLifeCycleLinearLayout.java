package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import pqq;
import qzy;
import raa;

public class ReadInJoyLifeCycleLinearLayout
  extends LinearLayout
  implements qzy
{
  private boolean a;
  
  public ReadInJoyLifeCycleLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    Object localObject = getTag();
    if ((localObject instanceof pqq))
    {
      localObject = ((pqq)localObject).a();
      if ((localObject instanceof raa)) {
        ((raa)localObject).a();
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
    if ((localObject instanceof pqq))
    {
      localObject = ((pqq)localObject).a();
      if ((localObject instanceof raa)) {
        ((raa)localObject).b();
      }
    }
  }
  
  public void setIsResume(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyLifeCycleLinearLayout
 * JD-Core Version:    0.7.0.1
 */