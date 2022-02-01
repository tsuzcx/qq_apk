package com.tencent.mobileqq.activity.aio.doodle.control;

import afur;
import aggx;
import agic;
import agid;
import agie;
import agif;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anni;
import bbfb;
import bcst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ColorPicker
  extends RDBaseListLayout<agid, agif>
  implements View.OnClickListener, bbfb
{
  private agie jdField_a_of_type_Agie;
  private final int[] jdField_a_of_type_ArrayOfInt = { -16777216, -5789785, -845543, -27392, -274353, -10233288, -9576193, -6989057 };
  
  public ColorPicker(Context paramContext)
  {
    super(paramContext);
    a(1);
  }
  
  public ColorPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(1);
  }
  
  public ColorPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(1);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case -16777216: 
      return anni.a(2131700966);
    case -5789785: 
      return anni.a(2131700958);
    case -2148308: 
    case -845543: 
      return anni.a(2131700962);
    case -1009097: 
    case -27392: 
      return anni.a(2131700965);
    case -274353: 
      return anni.a(2131700957);
    case -10233288: 
    case -8136876: 
      return anni.a(2131700963);
    case -13338378: 
    case -9576193: 
      return anni.a(2131700964);
    case -6989057: 
      return anni.a(2131700959);
    }
    return anni.a(2131700960);
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      a(new agid(0, -1, this.jdField_a_of_type_ArrayOfInt[i]), false);
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject = aggx.a().a(0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!aggx.a().c(0, localInteger.intValue()))
        {
          aggx.a().a(0, localInteger.intValue(), this, this);
          aggx.a().b(0, localInteger.intValue(), this, this);
        }
        else
        {
          a(new agid(1, localInteger.intValue(), -1), false);
        }
      }
    }
  }
  
  public agif a(int paramInt, agid paramagid)
  {
    agif localagif = new agif();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(afur.a(32.0F, getResources()), -1));
    paramInt = afur.a(4.0F, getResources());
    int i = afur.a(9.5F, getResources());
    localRelativeLayout.setPadding(paramInt, i, paramInt, i);
    localagif.a(localRelativeLayout);
    localRelativeLayout.setOnClickListener(this);
    localagif.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = getContext().getResources().getDrawable(2130837977);
    localagif.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    localagif.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramagid.a()) {
      localagif.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      localagif.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView = new ColorView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(afur.a(18.0F, getResources()), afur.a(18.0F, getResources()));
      paramInt = afur.a(3.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt, paramInt, paramInt, paramInt);
      ((RelativeLayout)localagif.a()).addView(localagif.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView);
      localRelativeLayout.addView(localagif.jdField_a_of_type_AndroidWidgetImageView);
      localagif.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setListener(new agic(this, localagif));
      localagif.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramagid.a != 0) {
        break;
      }
      localagif.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramagid.c);
      return localagif;
      localagif.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    paramagid = aggx.a().b(0, paramagid.b);
    localagif.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap(paramagid);
    return localagif;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Agie = null;
  }
  
  public void a(int paramInt, agid paramagid)
  {
    if ((paramagid != null) && (this.jdField_a_of_type_Agie != null)) {
      this.jdField_a_of_type_Agie.a(paramagid);
    }
  }
  
  public void a(int paramInt, agid paramagid, agif paramagif)
  {
    if ((paramagif == null) || (paramagid == null)) {}
    label137:
    label146:
    for (;;)
    {
      return;
      Object localObject = "";
      if (paramagid.a == 0)
      {
        paramagif.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramagid.c);
        localObject = a(paramagid.c);
        if (paramagif.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          if (!paramagid.a()) {
            break label137;
          }
          paramagif.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label146;
        }
        paramagif.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setContentDescription((CharSequence)localObject);
        return;
        if (paramagid.a != 1) {
          break;
        }
        localObject = aggx.a().b(0, paramagid.b);
        paramagif.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap((Bitmap)localObject);
        localObject = anni.a(2131700961) + (paramInt + 1);
        break;
        paramagif.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
  }
  
  public void a(View paramView, int paramInt1, ScribbleResMgr.ResInfo paramResInfo, int paramInt2)
  {
    if (paramInt1 == 3) {
      if (1 == paramInt2) {
        a(false);
      }
    }
    do
    {
      do
      {
        a();
        do
        {
          return;
        } while (4 == paramInt2);
        QLog.d("ColorPicker", 2, "ScribbleResMgr down error:" + paramInt2);
        return;
      } while (paramInt1 != 1);
      if (1 == paramInt2)
      {
        c();
        return;
      }
    } while (4 != paramInt2);
  }
  
  public boolean a()
  {
    e();
    d();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = a(paramView);
    a(i, false);
    agid localagid = (agid)a(i);
    QQAppInterface localQQAppInterface;
    if (localagid != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != localagid.a) {
        break label83;
      }
      bcst.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, localagid.b, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      if (localagid.a == 0) {
        bcst.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, localagid.c, "", "", "", "");
      }
    }
  }
  
  public void setListener(agie paramagie)
  {
    this.jdField_a_of_type_Agie = paramagie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker
 * JD-Core Version:    0.7.0.1
 */