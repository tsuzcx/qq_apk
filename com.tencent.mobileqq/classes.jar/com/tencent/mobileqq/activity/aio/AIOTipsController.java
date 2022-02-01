package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.qphone.base.util.QLog;

public class AIOTipsController
{
  AIOTipsController.AIOTipsListener a;
  private ViewGroup b;
  
  public AIOTipsController(ViewGroup paramViewGroup)
  {
    this.b = paramViewGroup;
  }
  
  public void a(View paramView, TipsBarTask paramTipsBarTask1, TipsBarTask paramTipsBarTask2)
  {
    if (paramView != null)
    {
      int j = this.b.indexOfChild(paramView);
      if (j == -1) {
        this.b.addView(paramView, new ViewGroup.LayoutParams(-1, -2));
      }
      int i = 0;
      while (i < this.b.getChildCount())
      {
        this.b.getChildAt(i).setVisibility(8);
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        String str;
        if (paramTipsBarTask2 == null) {
          str = "null";
        } else {
          str = Integer.toHexString(System.identityHashCode(paramTipsBarTask2));
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showHearerTips called childIndex = ");
        localStringBuilder.append(j);
        localStringBuilder.append(" object=");
        localStringBuilder.append(str);
        QLog.d("AIOTipsController", 2, localStringBuilder.toString());
      }
      paramView.setVisibility(0);
      this.b.setVisibility(0);
      this.b.post(new AIOTipsController.1(this, paramTipsBarTask1, paramTipsBarTask2));
    }
  }
  
  public void a(AIOTipsController.AIOTipsListener paramAIOTipsListener)
  {
    this.a = paramAIOTipsListener;
  }
  
  public void a(TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel())
    {
      String str;
      if (paramTipsBarTask == null) {
        str = "null";
      } else {
        str = Integer.toHexString(System.identityHashCode(paramTipsBarTask));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showHearerTips called object=");
      localStringBuilder.append(str);
      QLog.d("AIOTipsController", 2, localStringBuilder.toString());
    }
    this.b.setVisibility(8);
    this.b.post(new AIOTipsController.2(this, paramTipsBarTask));
  }
  
  public boolean a()
  {
    ViewGroup localViewGroup = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localViewGroup != null)
    {
      bool1 = bool2;
      if (localViewGroup.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    this.b.removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTipsController
 * JD-Core Version:    0.7.0.1
 */