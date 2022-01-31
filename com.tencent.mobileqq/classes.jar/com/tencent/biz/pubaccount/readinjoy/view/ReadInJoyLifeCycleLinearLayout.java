package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import pez;
import qns;
import qnt;

public class ReadInJoyLifeCycleLinearLayout
  extends LinearLayout
  implements qns
{
  private boolean a;
  
  public ReadInJoyLifeCycleLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    Object localObject = getTag();
    if ((localObject instanceof pez))
    {
      localObject = ((pez)localObject).a();
      if ((localObject instanceof qnt)) {
        ((qnt)localObject).a();
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
    if ((localObject instanceof pez))
    {
      localObject = ((pez)localObject).a();
      if ((localObject instanceof qnt)) {
        ((qnt)localObject).b();
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