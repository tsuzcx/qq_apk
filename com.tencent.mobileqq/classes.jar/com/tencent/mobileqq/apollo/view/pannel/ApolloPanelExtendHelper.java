package com.tencent.mobileqq.apollo.view.pannel;

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
  private int jdField_a_of_type_Int;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private int b = 0;
  private int c;
  
  public ApolloPanelExtendHelper(ViewGroup paramViewGroup, QQAppInterface paramQQAppInterface, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Int = ((int)(paramQQAppInterface.getApp().getResources().getDisplayMetrics().heightPixels * 0.6D));
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
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
      ApolloDtReportUtil.a("panel", "bigpanel", "expose", this.jdField_a_of_type_JavaUtilHashMap);
      return;
    }
    ApolloDtReportUtil.a("panel", "smallpanel", "expose", this.jdField_a_of_type_JavaUtilHashMap);
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_Int > this.c;
  }
  
  void a()
  {
    this.c = XPanelContainer.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int > this.c) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanelExtendHelper", 2, "onShow " + AppSetting.g() + " init panelH " + this.c + " needExtendPanel" + bool);
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      d();
      b(a());
      return;
    }
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanelExtendHelper", 2, "onHide.");
    }
    if (!paramBoolean) {
      XPanelContainer.jdField_a_of_type_Int = this.c;
    }
    for (;;)
    {
      this.b = 0;
      return;
      if (this.b != 0) {
        XPanelContainer.jdField_a_of_type_Int = this.b;
      }
    }
  }
  
  public boolean a()
  {
    return XPanelContainer.jdField_a_of_type_Int == this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if (!b()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.jdField_a_of_type_Int != this.c);
      b(true);
      a(200, XPanelContainer.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanelExtendHelper", 2, "onPullUp");
  }
  
  public void c()
  {
    if (!b()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.jdField_a_of_type_Int != this.jdField_a_of_type_Int);
      b(false);
      a(250, XPanelContainer.jdField_a_of_type_Int, this.c);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanelExtendHelper", 2, "onPullDown");
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanelExtendHelper", 2, "onShow.");
    }
    this.b = 0;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanelExtendHelper
 * JD-Core Version:    0.7.0.1
 */