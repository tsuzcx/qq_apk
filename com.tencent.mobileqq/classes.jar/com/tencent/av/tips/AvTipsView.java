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
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.UITools;
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
  final String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  
  public AvTipsView()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AvTipsView_");
    localStringBuilder.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
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
    AvTipsView.MainTips localMainTips = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips;
    if (localMainTips != null) {
      localMainTips.a();
    }
  }
  
  public void a(int paramInt)
  {
    AvTipsView.MainTips localMainTips = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips;
    if (localMainTips != null) {
      localMainTips.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(long paramLong, float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      return;
    }
    float f = ((LinearLayout)localObject).getRotation();
    if (f != paramFloat)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRotation, rotation[");
      localStringBuilder.append(f);
      localStringBuilder.append("->");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setRotation(paramFloat);
      a(true);
    }
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
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131373628);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131373625));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips = new AvTipsView.MainTips(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips = new AvTipsView.SubTips(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    e();
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 == null) {
      return;
    }
    int i = ((View)localObject1).getWidth();
    int k = this.jdField_a_of_type_AndroidViewView.getHeight();
    if ((this.jdField_a_of_type_Int == i) && (this.b == k) && (!paramBoolean)) {
      return;
    }
    localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("adjustPos, w[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject2).append("->");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("], h[");
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append("->");
    ((StringBuilder)localObject2).append(k);
    ((StringBuilder)localObject2).append("], force[");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append("], tips_layout[");
    Object localObject3 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    int j = 0;
    if (localObject3 != null) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    this.jdField_a_of_type_Int = i;
    this.b = k;
    localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    k = ((SessionInfo)localObject1).d;
    if (k == 2)
    {
      i = k;
      if (!((SessionInfo)localObject1).k)
      {
        i = k;
        if (!((SessionInfo)localObject1).j) {
          i = 1;
        }
      }
    }
    else if (k != 4)
    {
      i = k;
      if (k != 3) {}
    }
    else
    {
      if (((SessionInfo)localObject1).c.size() > 0)
      {
        if ((!((SessionInfo)localObject1).ao) && (!((VideoViewInfo)((SessionInfo)localObject1).c.get(0)).b)) {
          i = 0;
        } else {
          i = 1;
        }
        j = ((VideoViewInfo)((SessionInfo)localObject1).c.get(0)).jdField_a_of_type_Int;
      }
      else
      {
        i = 1;
      }
      if ((i != 0) && (j != 0)) {
        i = 4;
      } else {
        i = 3;
      }
    }
    if (QLog.isDevelopLevel())
    {
      localObject2 = this.jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("adjustPos, sessionType[");
      ((StringBuilder)localObject3).append(((SessionInfo)localObject1).d);
      ((StringBuilder)localObject3).append("->");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("]");
      QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    }
    localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            d((RelativeLayout.LayoutParams)localObject1);
          }
        }
        else {
          c((RelativeLayout.LayoutParams)localObject1);
        }
      }
      else {
        b((RelativeLayout.LayoutParams)localObject1);
      }
    }
    else {
      a((RelativeLayout.LayoutParams)localObject1);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  public void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AvTipsView.SubTips localSubTips = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips;
    if ((localSubTips != null) && (localSubTips.a != null))
    {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a.setOnClickListener(paramOnClickListener);
      if (paramBoolean) {
        TintStateDrawable.a(this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a, 2130842125, 2131165995);
      }
      paramOnClickListener = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      paramOnClickListener.setVisibility(i);
    }
  }
  
  public boolean a()
  {
    AvTipsView.MainTips localMainTips = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips;
    if (localMainTips == null) {
      return false;
    }
    return localMainTips.a();
  }
  
  public boolean a(AvTipsItemBase paramAvTipsItemBase)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips;
    if (localObject == null) {
      return false;
    }
    paramAvTipsItemBase = AvTipsView.TipsInfo.a(((AvTipsView.MainTips)localObject).a(), paramAvTipsItemBase, this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips);
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShowMainTipsView, tipsInfo[");
      localStringBuilder.append(paramAvTipsItemBase.jdField_a_of_type_AndroidTextSpannableString);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips.a(paramAvTipsItemBase);
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "RemoveSubTipView");
    }
    AvTipsView.SubTips localSubTips = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips;
    if (localSubTips != null) {
      localSubTips.a();
    }
  }
  
  public void b(int paramInt)
  {
    AvTipsView.MainTips localMainTips = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips;
    if ((localMainTips != null) && (localMainTips.jdField_a_of_type_AndroidWidgetProgressBar != null)) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips.jdField_a_of_type_AndroidWidgetProgressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    }
  }
  
  void b(RelativeLayout.LayoutParams paramLayoutParams)
  {
    float f;
    if (Build.VERSION.SDK_INT >= 11) {
      f = this.jdField_a_of_type_AndroidWidgetLinearLayout.getRotation();
    } else {
      f = 0.0F;
    }
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
  }
  
  public void b(VideoAppInterface paramVideoAppInterface) {}
  
  public boolean b()
  {
    AvTipsView.SubTips localSubTips = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips;
    if (localSubTips == null) {
      return false;
    }
    return localSubTips.a();
  }
  
  public boolean b(AvTipsItemBase paramAvTipsItemBase)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips;
    if (localObject == null) {
      return false;
    }
    paramAvTipsItemBase = AvTipsView.TipsInfo.a(((AvTipsView.SubTips)localObject).a(), paramAvTipsItemBase, this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips);
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShowSubTipsView, tipsInfo[");
      localStringBuilder.append(paramAvTipsItemBase.jdField_a_of_type_AndroidTextSpannableString);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips.a(paramAvTipsItemBase);
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips;
    if (localObject != null) {
      ((AvTipsView.MainTips)localObject).a(4);
    }
    localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips;
    if (localObject != null) {
      ((AvTipsView.SubTips)localObject).a(4);
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
    Object localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$MainTips;
    if (localObject != null) {
      ((AvTipsView.MainTips)localObject).a(0);
    }
    localObject = this.jdField_a_of_type_ComTencentAvTipsAvTipsView$SubTips;
    if (localObject != null) {
      ((AvTipsView.SubTips)localObject).a(0);
    }
  }
  
  void d(RelativeLayout.LayoutParams paramLayoutParams)
  {
    float f;
    if (Build.VERSION.SDK_INT >= 11) {
      f = this.jdField_a_of_type_AndroidWidgetLinearLayout.getRotation();
    } else {
      f = 0.0F;
    }
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
  }
  
  void e()
  {
    if (AudioHelper.b())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attach, isAttach[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("], titleBar[");
      boolean bool;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      f();
    }
    if (!this.jdField_a_of_type_Boolean) {
      ((TipsManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(this);
    }
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    a(true);
  }
  
  void f()
  {
    if (AudioHelper.b())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detach, isAttach[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("], qav_activity_root[");
      boolean bool;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      ((TipsManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(null);
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.AvTipsView
 * JD-Core Version:    0.7.0.1
 */