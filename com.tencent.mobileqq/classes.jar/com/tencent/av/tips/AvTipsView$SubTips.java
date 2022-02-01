package com.tencent.av.tips;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

class AvTipsView$SubTips
  extends AvTipsView.BaseTips
{
  TextView f;
  Button g;
  View h;
  
  AvTipsView$SubTips(LinearLayout paramLinearLayout)
  {
    this.e = paramLinearLayout;
    this.f = ((TextView)paramLinearLayout.findViewById(2131441287));
    this.g = ((Button)paramLinearLayout.findViewById(2131441028));
    this.h = paramLinearLayout.findViewById(2131441281);
  }
  
  boolean a()
  {
    return this.f != null;
  }
  
  boolean a(AvTipsView.TipsInfo paramTipsInfo)
  {
    b();
    if (paramTipsInfo.i != null)
    {
      TextView localTextView = this.f;
      if (localTextView != null)
      {
        AvTipsView.a(localTextView, paramTipsInfo);
        this.h.setVisibility(0);
        return true;
      }
    }
    return false;
  }
  
  void b()
  {
    if (!a()) {
      return;
    }
    this.f.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  Resources c()
  {
    return this.f.getResources();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.AvTipsView.SubTips
 * JD-Core Version:    0.7.0.1
 */