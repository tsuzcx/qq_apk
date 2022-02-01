package com.tencent.mobileqq.apollo.aio.panel;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;

class ApolloPanelExtendHelper
{
  private ViewGroup a;
  private int b;
  private int c = 0;
  private int d;
  private HashMap<String, String> e;
  
  public ApolloPanelExtendHelper(ViewGroup paramViewGroup, QQAppInterface paramQQAppInterface, HashMap<String, String> paramHashMap)
  {
    this.a = paramViewGroup;
    double d1 = paramQQAppInterface.getApp().getResources().getDisplayMetrics().heightPixels;
    Double.isNaN(d1);
    this.b = ((int)(d1 * 0.6D));
    this.e = paramHashMap;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.addUpdateListener(new ApolloPanelExtendHelper.1(this));
    localValueAnimator.start();
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ApolloDtReportUtil.a("panel", "bigpanel", "expose", this.e);
      return;
    }
    ApolloDtReportUtil.a("panel", "smallpanel", "expose", this.e);
  }
  
  private boolean f()
  {
    return this.b > this.d;
  }
  
  void a()
  {
    this.d = XPanelContainer.a;
    boolean bool;
    if (this.b > this.d) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShow ");
      localStringBuilder.append(AppSetting.i());
      localStringBuilder.append(" init panelH ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" needExtendPanel");
      localStringBuilder.append(bool);
      QLog.d("[cmshow]ApolloPanelExtendHelper", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      e();
      b(d());
      return;
    }
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanelExtendHelper", 2, "onHide.");
    }
    if (!paramBoolean)
    {
      XPanelContainer.a = this.d;
    }
    else
    {
      int i = this.c;
      if (i != 0) {
        XPanelContainer.a = i;
      }
    }
    this.c = 0;
  }
  
  public void b()
  {
    if (!f()) {
      return;
    }
    if (XPanelContainer.a == this.d)
    {
      b(true);
      a(200, XPanelContainer.a, this.b);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanelExtendHelper", 2, "onPullUp");
      }
    }
  }
  
  public void c()
  {
    if (!f()) {
      return;
    }
    if (XPanelContainer.a == this.b)
    {
      b(false);
      a(250, XPanelContainer.a, this.d);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanelExtendHelper", 2, "onPullDown");
      }
    }
  }
  
  public boolean d()
  {
    return XPanelContainer.a == this.b;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanelExtendHelper", 2, "onShow.");
    }
    this.c = 0;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelExtendHelper
 * JD-Core Version:    0.7.0.1
 */