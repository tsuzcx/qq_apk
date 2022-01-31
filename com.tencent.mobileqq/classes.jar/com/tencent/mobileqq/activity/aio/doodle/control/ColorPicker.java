package com.tencent.mobileqq.activity.aio.doodle.control;

import aekt;
import aevw;
import aexb;
import aexc;
import aexd;
import aexe;
import alpo;
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
import ayck;
import azmj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ColorPicker
  extends RDBaseListLayout<aexc, aexe>
  implements View.OnClickListener, ayck
{
  private aexd jdField_a_of_type_Aexd;
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
      return alpo.a(2131702534);
    case -5789785: 
      return alpo.a(2131702526);
    case -2148308: 
    case -845543: 
      return alpo.a(2131702530);
    case -1009097: 
    case -27392: 
      return alpo.a(2131702533);
    case -274353: 
      return alpo.a(2131702525);
    case -10233288: 
    case -8136876: 
      return alpo.a(2131702531);
    case -13338378: 
    case -9576193: 
      return alpo.a(2131702532);
    case -6989057: 
      return alpo.a(2131702527);
    }
    return alpo.a(2131702528);
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      a(new aexc(0, -1, this.jdField_a_of_type_ArrayOfInt[i]), false);
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject = aevw.a().a(0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!aevw.a().c(0, localInteger.intValue()))
        {
          aevw.a().a(0, localInteger.intValue(), this, this);
          aevw.a().b(0, localInteger.intValue(), this, this);
        }
        else
        {
          a(new aexc(1, localInteger.intValue(), -1), false);
        }
      }
    }
  }
  
  public aexe a(int paramInt, aexc paramaexc)
  {
    aexe localaexe = new aexe();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(aekt.a(32.0F, getResources()), -1));
    paramInt = aekt.a(4.0F, getResources());
    int i = aekt.a(9.5F, getResources());
    localRelativeLayout.setPadding(paramInt, i, paramInt, i);
    localaexe.a(localRelativeLayout);
    localRelativeLayout.setOnClickListener(this);
    localaexe.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = getContext().getResources().getDrawable(2130837745);
    localaexe.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    localaexe.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramaexc.a()) {
      localaexe.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      localaexe.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView = new ColorView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(aekt.a(18.0F, getResources()), aekt.a(18.0F, getResources()));
      paramInt = aekt.a(3.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt, paramInt, paramInt, paramInt);
      ((RelativeLayout)localaexe.a()).addView(localaexe.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView);
      localRelativeLayout.addView(localaexe.jdField_a_of_type_AndroidWidgetImageView);
      localaexe.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setListener(new aexb(this, localaexe));
      localaexe.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramaexc.a != 0) {
        break;
      }
      localaexe.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramaexc.c);
      return localaexe;
      localaexe.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    paramaexc = aevw.a().b(0, paramaexc.b);
    localaexe.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap(paramaexc);
    return localaexe;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aexd = null;
  }
  
  public void a(int paramInt, aexc paramaexc)
  {
    if ((paramaexc != null) && (this.jdField_a_of_type_Aexd != null)) {
      this.jdField_a_of_type_Aexd.a(paramaexc);
    }
  }
  
  public void a(int paramInt, aexc paramaexc, aexe paramaexe)
  {
    if ((paramaexe == null) || (paramaexc == null)) {}
    label137:
    label146:
    for (;;)
    {
      return;
      Object localObject = "";
      if (paramaexc.a == 0)
      {
        paramaexe.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramaexc.c);
        localObject = a(paramaexc.c);
        if (paramaexe.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          if (!paramaexc.a()) {
            break label137;
          }
          paramaexe.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label146;
        }
        paramaexe.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setContentDescription((CharSequence)localObject);
        return;
        if (paramaexc.a != 1) {
          break;
        }
        localObject = aevw.a().b(0, paramaexc.b);
        paramaexe.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap((Bitmap)localObject);
        localObject = alpo.a(2131702529) + (paramInt + 1);
        break;
        paramaexe.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
    paramView = (aexc)a(i);
    QQAppInterface localQQAppInterface;
    if (paramView != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != paramView.a) {
        break label74;
      }
      azmj.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, paramView.b, "", "", "", "");
    }
    label74:
    while (paramView.a != 0) {
      return;
    }
    azmj.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, paramView.c, "", "", "", "");
  }
  
  public void setListener(aexd paramaexd)
  {
    this.jdField_a_of_type_Aexd = paramaexd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker
 * JD-Core Version:    0.7.0.1
 */