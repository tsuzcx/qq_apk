package com.tencent.av.tips;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsManager;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.tips.data.AvTipsItemBase;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AvTipsView
  implements IAvTipsView
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new AvTipsView.1(this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  AvTipsView.MainTips jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips;
  AvTipsView.SubTips jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips;
  final String jdField_a_of_type_JavaLangString = "AvTipsView_" + AudioHelper.b();
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  
  static void a(TextView paramTextView, AvTipsView.TipsInfo paramTipsInfo)
  {
    paramTextView.setTextSize(paramTipsInfo.jdField_a_of_type_Int);
    paramTextView.setTextColor(paramTipsInfo.b);
    paramTextView.setText(paramTipsInfo.jdField_a_of_type_AndroidTextSpannableString);
    paramTextView.setVisibility(0);
    AvTipsView.TipsInfo.a(paramTextView, paramTipsInfo.c, paramTipsInfo.d);
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "RemoveMainTipsView");
    }
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips != null) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips != null) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    float f;
    do
    {
      return;
      f = this.jdField_a_of_type_AndroidWidgetLinearLayout.getRotation();
    } while (f == paramFloat);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setRotation, rotation[" + f + "->" + paramFloat + "], seq[" + paramLong + "]");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(paramFloat);
    a(true);
  }
  
  void a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.height = -2;
    paramLayoutParams.topMargin = (this.b + (int)UITools.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 6.0F));
    paramLayoutParams.addRule(14, -1);
    paramLayoutParams.addRule(13, 0);
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      f();
    }
    ((TipsManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).b();
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131374073);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131374070));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips = new AvTipsView.MainTips(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips = new AvTipsView.SubTips(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    e();
  }
  
  void a(boolean paramBoolean)
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    int k;
    do
    {
      do
      {
        return;
        j = this.jdField_a_of_type_AndroidViewView.getWidth();
        k = this.jdField_a_of_type_AndroidViewView.getHeight();
      } while ((this.jdField_a_of_type_Int == j) && (this.b == k) && (!paramBoolean));
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("adjustPos, w[").append(this.jdField_a_of_type_Int).append("->").append(j).append("], h[").append(this.b).append("->").append(k).append("], force[").append(paramBoolean).append("], tips_layout[");
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        break;
      }
      paramBoolean = true;
      QLog.w((String)localObject, 1, paramBoolean + "]");
    } while (this.jdField_a_of_type_AndroidWidgetLinearLayout == null);
    this.jdField_a_of_type_Int = j;
    this.b = k;
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    int j = ((SessionInfo)localObject).d;
    if (j == 2)
    {
      if ((((SessionInfo)localObject).k) || (((SessionInfo)localObject).j)) {
        break label454;
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "adjustPos, sessionType[" + ((SessionInfo)localObject).d + "->" + i + "]");
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      switch (i)
      {
      default: 
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        paramBoolean = false;
        break;
        if ((j == 4) || (j == 3)) {
          if (((SessionInfo)localObject).c.size() > 0) {
            if ((((SessionInfo)localObject).e()) || (((VideoViewInfo)((SessionInfo)localObject).c.get(0)).b))
            {
              i = 1;
              k = ((VideoViewInfo)((SessionInfo)localObject).c.get(0)).jdField_a_of_type_Int;
              j = i;
              i = k;
            }
          }
        }
      case 1: 
      case 2: 
      case 3: 
      case 4: 
        for (;;)
        {
          label304:
          label368:
          if ((j == 0) || (i == 0))
          {
            i = 3;
            break;
            i = 0;
            break label368;
          }
          i = 4;
          break;
          a((RelativeLayout.LayoutParams)localObject);
          break label304;
          b((RelativeLayout.LayoutParams)localObject);
          break label304;
          c((RelativeLayout.LayoutParams)localObject);
          break label304;
          d((RelativeLayout.LayoutParams)localObject);
          break label304;
          j = 1;
        }
        label454:
        i = j;
      }
    }
  }
  
  public void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips != null) && (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a != null))
    {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a.setOnClickListener(paramOnClickListener);
      if (paramBoolean) {
        TintStateDrawable.a(this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a, 2130842227, 2131165984);
      }
      paramOnClickListener = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a;
      if (!paramBoolean) {
        break label68;
      }
    }
    label68:
    for (int i = 0;; i = 8)
    {
      paramOnClickListener.setVisibility(i);
      return;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips.a();
  }
  
  public boolean a(AvTipsItemBase paramAvTipsItemBase)
  {
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips == null) {
      return false;
    }
    paramAvTipsItemBase = AvTipsView.TipsInfo.a(this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips.a(), paramAvTipsItemBase, this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips);
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "ShowMainTipsView, tipsInfo[" + paramAvTipsItemBase.jdField_a_of_type_AndroidTextSpannableString + "]");
    }
    return this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips.a(paramAvTipsItemBase);
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "RemoveSubTipView");
    }
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips != null) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a();
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips != null) && (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips.jdField_a_of_type_AndroidWidgetProgressBar != null)) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    }
  }
  
  void b(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (float f = this.jdField_a_of_type_AndroidWidgetLinearLayout.getRotation();; f = 0.0F)
    {
      if (f % 180.0F == 0.0F)
      {
        paramLayoutParams.height = -2;
        paramLayoutParams.topMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 188.0F));
        paramLayoutParams.addRule(14, -1);
        paramLayoutParams.addRule(13, 0);
        return;
      }
      paramLayoutParams.height = (UITools.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()) * 23 / 25);
      paramLayoutParams.topMargin = 0;
      paramLayoutParams.addRule(14, 0);
      paramLayoutParams.addRule(13, -1);
      return;
    }
  }
  
  public void b(VideoAppInterface paramVideoAppInterface) {}
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a();
  }
  
  public boolean b(AvTipsItemBase paramAvTipsItemBase)
  {
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips == null) {
      return false;
    }
    paramAvTipsItemBase = AvTipsView.TipsInfo.a(this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a(), paramAvTipsItemBase, this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips);
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "ShowSubTipsView, tipsInfo[" + paramAvTipsItemBase.jdField_a_of_type_AndroidTextSpannableString + "]");
    }
    return this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a(paramAvTipsItemBase);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips != null) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips.a(4);
    }
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips != null) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a(4);
    }
  }
  
  void c(RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.height = -2;
    paramLayoutParams.topMargin = (this.b + (int)UITools.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 6.0F));
    paramLayoutParams.addRule(14, -1);
    paramLayoutParams.addRule(13, 0);
  }
  
  public void c(VideoAppInterface paramVideoAppInterface)
  {
    e();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips != null) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips.a(0);
    }
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips != null) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a(0);
    }
  }
  
  void d(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (float f = this.jdField_a_of_type_AndroidWidgetLinearLayout.getRotation();; f = 0.0F)
    {
      if (f % 180.0F == 0.0F)
      {
        paramLayoutParams.height = -2;
        paramLayoutParams.topMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 188.0F));
        paramLayoutParams.addRule(14, -1);
        paramLayoutParams.addRule(13, 0);
        return;
      }
      paramLayoutParams.height = (UITools.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext()) * 23 / 25);
      paramLayoutParams.topMargin = 0;
      paramLayoutParams.addRule(14, 0);
      paramLayoutParams.addRule(13, -1);
      return;
    }
  }
  
  void e()
  {
    String str;
    StringBuilder localStringBuilder;
    if (AudioHelper.e())
    {
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("attach, isAttach[").append(this.jdField_a_of_type_Boolean).append("], titleBar[");
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_Boolean) {
        f();
      }
      if (!this.jdField_a_of_type_Boolean) {
        ((TipsManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(this);
      }
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      a(true);
      return;
    }
  }
  
  void f()
  {
    String str;
    StringBuilder localStringBuilder;
    if (AudioHelper.e())
    {
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("detach, isAttach[").append(this.jdField_a_of_type_Boolean).append("], qav_activity_root[");
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break label123;
      }
    }
    label123:
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_Boolean) {
        ((TipsManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(null);
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (Build.VERSION.SDK_INT < 16) {
          break;
        }
        this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      return;
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.tips.AvTipsView
 * JD-Core Version:    0.7.0.1
 */