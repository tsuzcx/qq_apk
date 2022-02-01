package com.tencent.av.tips;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

class AvTipsView$MainTips
  extends AvTipsView.BaseTips
{
  ImageView f;
  View g;
  ProgressBar h;
  TextView i;
  View j;
  
  AvTipsView$MainTips(LinearLayout paramLinearLayout)
  {
    this.e = paramLinearLayout;
    this.f = ((ImageView)paramLinearLayout.findViewById(2131441289));
    this.i = ((TextView)paramLinearLayout.findViewById(2131441286));
    this.g = paramLinearLayout.findViewById(2131441290);
    this.h = ((ProgressBar)paramLinearLayout.findViewById(2131441292));
    this.j = paramLinearLayout.findViewById(2131441186);
  }
  
  boolean a()
  {
    return (this.i != null) && (this.h != null);
  }
  
  boolean a(AvTipsView.TipsInfo paramTipsInfo)
  {
    b();
    Object localObject;
    if ((paramTipsInfo.b) && (paramTipsInfo.d != null))
    {
      localObject = this.f;
      if (localObject != null)
      {
        ((ImageView)localObject).setImageBitmap(paramTipsInfo.d);
        this.f.setVisibility(0);
      }
    }
    if (paramTipsInfo.c)
    {
      localObject = this.h;
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(0);
      }
    }
    if (paramTipsInfo.a)
    {
      localObject = this.g;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    int k;
    if ((paramTipsInfo.i != null) && (this.i != null)) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0) {
      AvTipsView.a(this.i, paramTipsInfo);
    }
    if (k != 0)
    {
      localObject = this.j;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    if ((paramTipsInfo.j) && (this.e != null)) {
      this.e.setVisibility(0);
    }
    return true;
  }
  
  void b()
  {
    if (!a()) {
      return;
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(8);
      this.f.setImageBitmap(null);
    }
    localObject = this.i;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(4);
    }
    localObject = this.g;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.h;
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(8);
    }
    localObject = this.j;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  Resources c()
  {
    return this.i.getResources();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.AvTipsView.MainTips
 * JD-Core Version:    0.7.0.1
 */