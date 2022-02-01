package com.tencent.av.tips;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AvTipsView
  implements IAvTipsView
{
  final String a;
  View b;
  LinearLayout c;
  AvTipsView.MainTips d;
  AvTipsView.SubTips e;
  int f;
  ViewTreeObserver.OnGlobalLayoutListener g = new AvTipsView.1(this);
  int h = 0;
  int i = 0;
  VideoAppInterface j;
  boolean k = false;
  
  public AvTipsView()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AvTipsView_");
    localStringBuilder.append(AudioHelper.c());
    this.a = localStringBuilder.toString();
  }
  
  @SuppressLint({"NewApi"})
  private void a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    int m = paramContext.getResources().getDimensionPixelSize(2131298621);
    this.f = ((localDisplayMetrics.widthPixels - m * 5) / 4 + AIOUtils.b(123.0F, paramContext.getResources()));
  }
  
  static void a(TextView paramTextView, AvTipsView.TipsInfo paramTipsInfo)
  {
    paramTextView.setTextSize(paramTipsInfo.e);
    paramTextView.setTextColor(paramTipsInfo.f);
    paramTextView.setText(paramTipsInfo.i);
    paramTextView.setVisibility(0);
    AvTipsView.TipsInfo.a(paramTextView, paramTipsInfo.g, paramTipsInfo.h);
  }
  
  private boolean i()
  {
    return true;
  }
  
  private void j()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    localLayoutParams.height = -2;
    localLayoutParams.bottomMargin = this.f;
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(12);
  }
  
  public void a(int paramInt)
  {
    AvTipsView.MainTips localMainTips = this.d;
    if (localMainTips != null) {
      localMainTips.a = paramInt;
    }
  }
  
  public void a(long paramLong, float paramFloat)
  {
    if (this.c != null)
    {
      if (i()) {
        return;
      }
      float f1 = this.c.getRotation();
      if (f1 != paramFloat)
      {
        String str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setRotation, rotation[");
        localStringBuilder.append(f1);
        localStringBuilder.append("->");
        localStringBuilder.append(paramFloat);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
        this.c.setRotation(paramFloat);
        a(true);
      }
    }
  }
  
  void a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.height = -2;
    paramLayoutParams.topMargin = (this.i + (int)UITools.a(this.c.getContext(), 6.0F));
    paramLayoutParams.addRule(14, -1);
    paramLayoutParams.addRule(13, 0);
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.k) {
      h();
    }
    ((TipsManager)this.j.c(11)).c();
    this.b = null;
    this.c = null;
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, ViewGroup paramViewGroup)
  {
    this.b = paramViewGroup.findViewById(2131441294);
    this.c = ((LinearLayout)paramViewGroup.findViewById(2131441291));
    this.j = paramVideoAppInterface;
    this.d = new AvTipsView.MainTips(this.c);
    this.e = new AvTipsView.SubTips(this.c);
    a(paramViewGroup.getContext());
    g();
  }
  
  void a(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    if (i())
    {
      j();
      return;
    }
    int m = this.b.getWidth();
    int i1 = this.b.getHeight();
    if ((this.h == m) && (this.i == i1) && (!paramBoolean)) {
      return;
    }
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("adjustPos, w[");
    ((StringBuilder)localObject2).append(this.h);
    ((StringBuilder)localObject2).append("->");
    ((StringBuilder)localObject2).append(m);
    ((StringBuilder)localObject2).append("], h[");
    ((StringBuilder)localObject2).append(this.i);
    ((StringBuilder)localObject2).append("->");
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append("], force[");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append("], tips_layout[");
    Object localObject3 = this.c;
    int n = 0;
    if (localObject3 != null) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (this.c == null) {
      return;
    }
    this.h = m;
    this.i = i1;
    localObject1 = this.j.b().k();
    i1 = ((SessionInfo)localObject1).g;
    if (i1 == 2)
    {
      m = i1;
      if (!((SessionInfo)localObject1).I)
      {
        m = i1;
        if (!((SessionInfo)localObject1).H) {
          m = 1;
        }
      }
    }
    else if (i1 != 4)
    {
      m = i1;
      if (i1 != 3) {}
    }
    else
    {
      if (((SessionInfo)localObject1).bi.size() > 0)
      {
        if ((!((SessionInfo)localObject1).bN) && (!((VideoViewInfo)((SessionInfo)localObject1).bi.get(0)).d)) {
          m = 0;
        } else {
          m = 1;
        }
        n = ((VideoViewInfo)((SessionInfo)localObject1).bi.get(0)).b;
      }
      else
      {
        m = 1;
      }
      if ((m != 0) && (n != 0)) {
        m = 4;
      } else {
        m = 3;
      }
    }
    if (QLog.isDevelopLevel())
    {
      localObject2 = this.a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("adjustPos, sessionType[");
      ((StringBuilder)localObject3).append(((SessionInfo)localObject1).g);
      ((StringBuilder)localObject3).append("->");
      ((StringBuilder)localObject3).append(m);
      ((StringBuilder)localObject3).append("]");
      QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    }
    localObject1 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m == 4) {
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
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  public void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AvTipsView.SubTips localSubTips = this.e;
    if ((localSubTips != null) && (localSubTips.g != null))
    {
      this.e.g.setOnClickListener(paramOnClickListener);
      if (paramBoolean) {
        TintStateDrawable.a(this.e.g, 2130843051, 2131166717);
      }
      paramOnClickListener = this.e.g;
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      paramOnClickListener.setVisibility(m);
    }
  }
  
  public boolean a()
  {
    AvTipsView.MainTips localMainTips = this.d;
    if (localMainTips == null) {
      return false;
    }
    return localMainTips.a();
  }
  
  public boolean a(AvTipsItemBase paramAvTipsItemBase)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return false;
    }
    paramAvTipsItemBase = AvTipsView.TipsInfo.a(((AvTipsView.MainTips)localObject).c(), paramAvTipsItemBase, this.d);
    if (QLog.isDevelopLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShowMainTipsView, tipsInfo[");
      localStringBuilder.append(paramAvTipsItemBase.i);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    return this.d.a(paramAvTipsItemBase);
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.a, 1, "RemoveMainTipsView");
    }
    AvTipsView.MainTips localMainTips = this.d;
    if (localMainTips != null) {
      localMainTips.b();
    }
  }
  
  public void b(int paramInt)
  {
    AvTipsView.MainTips localMainTips = this.d;
    if ((localMainTips != null) && (localMainTips.h != null)) {
      this.d.h.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
    }
  }
  
  void b(RelativeLayout.LayoutParams paramLayoutParams)
  {
    float f1;
    if (Build.VERSION.SDK_INT >= 11) {
      f1 = this.c.getRotation();
    } else {
      f1 = 0.0F;
    }
    if (f1 % 180.0F == 0.0F)
    {
      paramLayoutParams.height = -2;
      paramLayoutParams.topMargin = ((int)UITools.a(this.c.getContext(), 188.0F));
      paramLayoutParams.addRule(14, -1);
      paramLayoutParams.addRule(13, 0);
      return;
    }
    paramLayoutParams.height = (UITools.a(this.c.getContext()) * 23 / 25);
    paramLayoutParams.topMargin = 0;
    paramLayoutParams.addRule(14, 0);
    paramLayoutParams.addRule(13, -1);
  }
  
  public void b(VideoAppInterface paramVideoAppInterface) {}
  
  public boolean b(AvTipsItemBase paramAvTipsItemBase)
  {
    Object localObject = this.e;
    if (localObject == null) {
      return false;
    }
    paramAvTipsItemBase = AvTipsView.TipsInfo.a(((AvTipsView.SubTips)localObject).c(), paramAvTipsItemBase, this.e);
    if (QLog.isDevelopLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ShowSubTipsView, tipsInfo[");
      localStringBuilder.append(paramAvTipsItemBase.i);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    return this.e.a(paramAvTipsItemBase);
  }
  
  void c(RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.height = -2;
    paramLayoutParams.topMargin = (this.i + (int)UITools.a(this.c.getContext(), 6.0F));
    paramLayoutParams.addRule(14, -1);
    paramLayoutParams.addRule(13, 0);
  }
  
  public void c(VideoAppInterface paramVideoAppInterface)
  {
    g();
  }
  
  public boolean c()
  {
    AvTipsView.SubTips localSubTips = this.e;
    if (localSubTips == null) {
      return false;
    }
    return localSubTips.a();
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.a, 1, "RemoveSubTipView");
    }
    AvTipsView.SubTips localSubTips = this.e;
    if (localSubTips != null) {
      localSubTips.b();
    }
  }
  
  void d(RelativeLayout.LayoutParams paramLayoutParams)
  {
    float f1;
    if (Build.VERSION.SDK_INT >= 11) {
      f1 = this.c.getRotation();
    } else {
      f1 = 0.0F;
    }
    if (f1 % 180.0F == 0.0F)
    {
      paramLayoutParams.height = -2;
      paramLayoutParams.topMargin = ((int)UITools.a(this.c.getContext(), 188.0F));
      paramLayoutParams.addRule(14, -1);
      paramLayoutParams.addRule(13, 0);
      return;
    }
    paramLayoutParams.height = (UITools.a(this.c.getContext()) * 23 / 25);
    paramLayoutParams.topMargin = 0;
    paramLayoutParams.addRule(14, 0);
    paramLayoutParams.addRule(13, -1);
  }
  
  public void e()
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((AvTipsView.MainTips)localObject).a(4);
    }
    localObject = this.e;
    if (localObject != null) {
      ((AvTipsView.SubTips)localObject).a(4);
    }
  }
  
  public void f()
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((AvTipsView.MainTips)localObject).a(0);
    }
    localObject = this.e;
    if (localObject != null) {
      ((AvTipsView.SubTips)localObject).a(0);
    }
  }
  
  void g()
  {
    if (AudioHelper.e())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attach, isAttach[");
      localStringBuilder.append(this.k);
      localStringBuilder.append("], titleBar[");
      boolean bool;
      if (this.b != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (this.k) {
      h();
    }
    if (!this.k) {
      ((TipsManager)this.j.c(11)).a(this);
    }
    this.k = true;
    Object localObject = this.b;
    if (localObject != null) {
      ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener(this.g);
    }
    a(true);
  }
  
  void h()
  {
    if (AudioHelper.e())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detach, isAttach[");
      localStringBuilder.append(this.k);
      localStringBuilder.append("], qav_activity_root[");
      boolean bool;
      if (this.b != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.k) {
      ((TipsManager)this.j.c(11)).a(null);
    }
    this.k = false;
    if (this.b != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this.g);
        return;
      }
      this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.AvTipsView
 * JD-Core Version:    0.7.0.1
 */