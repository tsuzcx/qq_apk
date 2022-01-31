package com.tencent.mobileqq.activity.aio.doodle.control;

import actj;
import addu;
import adez;
import adfa;
import adfb;
import adfc;
import ajya;
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
import awhg;
import axqy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ColorPicker
  extends RDBaseListLayout<adfa, adfc>
  implements View.OnClickListener, awhg
{
  private adfb jdField_a_of_type_Adfb;
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
      return ajya.a(2131702162);
    case -5789785: 
      return ajya.a(2131702154);
    case -2148308: 
    case -845543: 
      return ajya.a(2131702158);
    case -1009097: 
    case -27392: 
      return ajya.a(2131702161);
    case -274353: 
      return ajya.a(2131702153);
    case -10233288: 
    case -8136876: 
      return ajya.a(2131702159);
    case -13338378: 
    case -9576193: 
      return ajya.a(2131702160);
    case -6989057: 
      return ajya.a(2131702155);
    }
    return ajya.a(2131702156);
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      a(new adfa(0, -1, this.jdField_a_of_type_ArrayOfInt[i]), false);
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject = addu.a().a(0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!addu.a().c(0, localInteger.intValue()))
        {
          addu.a().a(0, localInteger.intValue(), this, this);
          addu.a().b(0, localInteger.intValue(), this, this);
        }
        else
        {
          a(new adfa(1, localInteger.intValue(), -1), false);
        }
      }
    }
  }
  
  public adfc a(int paramInt, adfa paramadfa)
  {
    adfc localadfc = new adfc();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(actj.a(32.0F, getResources()), -1));
    paramInt = actj.a(4.0F, getResources());
    int i = actj.a(9.5F, getResources());
    localRelativeLayout.setPadding(paramInt, i, paramInt, i);
    localadfc.a(localRelativeLayout);
    localRelativeLayout.setOnClickListener(this);
    localadfc.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = getContext().getResources().getDrawable(2130837690);
    localadfc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    localadfc.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramadfa.a()) {
      localadfc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      localadfc.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView = new ColorView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(actj.a(18.0F, getResources()), actj.a(18.0F, getResources()));
      paramInt = actj.a(3.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt, paramInt, paramInt, paramInt);
      ((RelativeLayout)localadfc.a()).addView(localadfc.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView);
      localRelativeLayout.addView(localadfc.jdField_a_of_type_AndroidWidgetImageView);
      localadfc.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setListener(new adez(this, localadfc));
      localadfc.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramadfa.a != 0) {
        break;
      }
      localadfc.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramadfa.c);
      return localadfc;
      localadfc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    paramadfa = addu.a().b(0, paramadfa.b);
    localadfc.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap(paramadfa);
    return localadfc;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Adfb = null;
  }
  
  public void a(int paramInt, adfa paramadfa)
  {
    if ((paramadfa != null) && (this.jdField_a_of_type_Adfb != null)) {
      this.jdField_a_of_type_Adfb.a(paramadfa);
    }
  }
  
  public void a(int paramInt, adfa paramadfa, adfc paramadfc)
  {
    if ((paramadfc == null) || (paramadfa == null)) {}
    label137:
    label146:
    for (;;)
    {
      return;
      Object localObject = "";
      if (paramadfa.a == 0)
      {
        paramadfc.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramadfa.c);
        localObject = a(paramadfa.c);
        if (paramadfc.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          if (!paramadfa.a()) {
            break label137;
          }
          paramadfc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!AppSetting.d) {
          break label146;
        }
        paramadfc.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setContentDescription((CharSequence)localObject);
        return;
        if (paramadfa.a != 1) {
          break;
        }
        localObject = addu.a().b(0, paramadfa.b);
        paramadfc.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap((Bitmap)localObject);
        localObject = ajya.a(2131702157) + (paramInt + 1);
        break;
        paramadfc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
    paramView = (adfa)a(i);
    QQAppInterface localQQAppInterface;
    if (paramView != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != paramView.a) {
        break label74;
      }
      axqy.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, paramView.b, "", "", "", "");
    }
    label74:
    while (paramView.a != 0) {
      return;
    }
    axqy.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, paramView.c, "", "", "", "");
  }
  
  public void setListener(adfb paramadfb)
  {
    this.jdField_a_of_type_Adfb = paramadfb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker
 * JD-Core Version:    0.7.0.1
 */