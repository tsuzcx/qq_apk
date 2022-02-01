package com.tencent.mobileqq.activity.aio.doodle.control;

import afls;
import afmx;
import afmy;
import afmz;
import afna;
import amtj;
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
import barp;
import bcef;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ColorPicker
  extends RDBaseListLayout<afmy, afna>
  implements View.OnClickListener, barp
{
  private afmz jdField_a_of_type_Afmz;
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
      return amtj.a(2131701308);
    case -5789785: 
      return amtj.a(2131701300);
    case -2148308: 
    case -845543: 
      return amtj.a(2131701304);
    case -1009097: 
    case -27392: 
      return amtj.a(2131701307);
    case -274353: 
      return amtj.a(2131701299);
    case -10233288: 
    case -8136876: 
      return amtj.a(2131701305);
    case -13338378: 
    case -9576193: 
      return amtj.a(2131701306);
    case -6989057: 
      return amtj.a(2131701301);
    }
    return amtj.a(2131701302);
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      a(new afmy(0, -1, this.jdField_a_of_type_ArrayOfInt[i]), false);
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject = afls.a().a(0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!afls.a().c(0, localInteger.intValue()))
        {
          afls.a().a(0, localInteger.intValue(), this, this);
          afls.a().b(0, localInteger.intValue(), this, this);
        }
        else
        {
          a(new afmy(1, localInteger.intValue(), -1), false);
        }
      }
    }
  }
  
  public afna a(int paramInt, afmy paramafmy)
  {
    afna localafna = new afna();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.dp2px(32.0F, getResources()), -1));
    paramInt = AIOUtils.dp2px(4.0F, getResources());
    int i = AIOUtils.dp2px(9.5F, getResources());
    localRelativeLayout.setPadding(paramInt, i, paramInt, i);
    localafna.a(localRelativeLayout);
    localRelativeLayout.setOnClickListener(this);
    localafna.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = getContext().getResources().getDrawable(2130838009);
    localafna.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    localafna.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramafmy.a()) {
      localafna.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      localafna.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView = new ColorView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(AIOUtils.dp2px(18.0F, getResources()), AIOUtils.dp2px(18.0F, getResources()));
      paramInt = AIOUtils.dp2px(3.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt, paramInt, paramInt, paramInt);
      ((RelativeLayout)localafna.a()).addView(localafna.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView);
      localRelativeLayout.addView(localafna.jdField_a_of_type_AndroidWidgetImageView);
      localafna.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setListener(new afmx(this, localafna));
      localafna.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramafmy.a != 0) {
        break;
      }
      localafna.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramafmy.c);
      return localafna;
      localafna.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    paramafmy = afls.a().b(0, paramafmy.b);
    localafna.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap(paramafmy);
    return localafna;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Afmz = null;
  }
  
  public void a(int paramInt, afmy paramafmy)
  {
    if ((paramafmy != null) && (this.jdField_a_of_type_Afmz != null)) {
      this.jdField_a_of_type_Afmz.a(paramafmy);
    }
  }
  
  public void a(int paramInt, afmy paramafmy, afna paramafna)
  {
    if ((paramafna == null) || (paramafmy == null)) {}
    label137:
    label146:
    for (;;)
    {
      return;
      Object localObject = "";
      if (paramafmy.a == 0)
      {
        paramafna.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramafmy.c);
        localObject = a(paramafmy.c);
        if (paramafna.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          if (!paramafmy.a()) {
            break label137;
          }
          paramafna.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label146;
        }
        paramafna.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setContentDescription((CharSequence)localObject);
        return;
        if (paramafmy.a != 1) {
          break;
        }
        localObject = afls.a().b(0, paramafmy.b);
        paramafna.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap((Bitmap)localObject);
        localObject = amtj.a(2131701303) + (paramInt + 1);
        break;
        paramafna.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
    afmy localafmy = (afmy)a(i);
    QQAppInterface localQQAppInterface;
    if (localafmy != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != localafmy.a) {
        break label83;
      }
      bcef.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, localafmy.b, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      if (localafmy.a == 0) {
        bcef.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, localafmy.c, "", "", "", "");
      }
    }
  }
  
  public void setListener(afmz paramafmz)
  {
    this.jdField_a_of_type_Afmz = paramafmz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker
 * JD-Core Version:    0.7.0.1
 */