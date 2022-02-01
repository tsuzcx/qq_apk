package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.qphone.base.util.QLog;

public class AIOTipsController
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  AIOTipsController.AIOTipsListener jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController$AIOTipsListener;
  
  public AIOTipsController(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
  }
  
  public void a(View paramView, TipsBarTask paramTipsBarTask1, TipsBarTask paramTipsBarTask2)
  {
    if (paramView != null)
    {
      int j = this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(paramView);
      if (j == -1) {
        this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, new ViewGroup.LayoutParams(-1, -2));
      }
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
      {
        this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i).setVisibility(8);
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
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.post(new AIOTipsController.1(this, paramTipsBarTask1, paramTipsBarTask2));
    }
  }
  
  public void a(AIOTipsController.AIOTipsListener paramAIOTipsListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController$AIOTipsListener = paramAIOTipsListener;
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
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.post(new AIOTipsController.2(this, paramTipsBarTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTipsController
 * JD-Core Version:    0.7.0.1
 */