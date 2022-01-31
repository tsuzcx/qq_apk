package com.tencent.mobileqq.activity.aio.doodle.control;

import aciy;
import acte;
import acuj;
import acuk;
import acul;
import acum;
import ajjy;
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
import avhl;
import awqx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ColorPicker
  extends RDBaseListLayout<acuk, acum>
  implements View.OnClickListener, avhl
{
  private acul jdField_a_of_type_Acul;
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
      return ajjy.a(2131636367);
    case -5789785: 
      return ajjy.a(2131636359);
    case -2148308: 
    case -845543: 
      return ajjy.a(2131636363);
    case -1009097: 
    case -27392: 
      return ajjy.a(2131636366);
    case -274353: 
      return ajjy.a(2131636358);
    case -10233288: 
    case -8136876: 
      return ajjy.a(2131636364);
    case -13338378: 
    case -9576193: 
      return ajjy.a(2131636365);
    case -6989057: 
      return ajjy.a(2131636360);
    }
    return ajjy.a(2131636361);
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      a(new acuk(0, -1, this.jdField_a_of_type_ArrayOfInt[i]), false);
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject = acte.a().a(0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!acte.a().c(0, localInteger.intValue()))
        {
          acte.a().a(0, localInteger.intValue(), this, this);
          acte.a().b(0, localInteger.intValue(), this, this);
        }
        else
        {
          a(new acuk(1, localInteger.intValue(), -1), false);
        }
      }
    }
  }
  
  public acum a(int paramInt, acuk paramacuk)
  {
    acum localacum = new acum();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(aciy.a(32.0F, getResources()), -1));
    paramInt = aciy.a(4.0F, getResources());
    int i = aciy.a(9.5F, getResources());
    localRelativeLayout.setPadding(paramInt, i, paramInt, i);
    localacum.a(localRelativeLayout);
    localRelativeLayout.setOnClickListener(this);
    localacum.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = getContext().getResources().getDrawable(2130837680);
    localacum.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    localacum.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramacuk.a()) {
      localacum.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      localacum.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView = new ColorView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(aciy.a(18.0F, getResources()), aciy.a(18.0F, getResources()));
      paramInt = aciy.a(3.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt, paramInt, paramInt, paramInt);
      ((RelativeLayout)localacum.a()).addView(localacum.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView);
      localRelativeLayout.addView(localacum.jdField_a_of_type_AndroidWidgetImageView);
      localacum.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setListener(new acuj(this, localacum));
      localacum.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramacuk.a != 0) {
        break;
      }
      localacum.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramacuk.c);
      return localacum;
      localacum.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    paramacuk = acte.a().b(0, paramacuk.b);
    localacum.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap(paramacuk);
    return localacum;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Acul = null;
  }
  
  public void a(int paramInt, acuk paramacuk)
  {
    if ((paramacuk != null) && (this.jdField_a_of_type_Acul != null)) {
      this.jdField_a_of_type_Acul.a(paramacuk);
    }
  }
  
  public void a(int paramInt, acuk paramacuk, acum paramacum)
  {
    if ((paramacum == null) || (paramacuk == null)) {}
    label137:
    label146:
    for (;;)
    {
      return;
      Object localObject = "";
      if (paramacuk.a == 0)
      {
        paramacum.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramacuk.c);
        localObject = a(paramacuk.c);
        if (paramacum.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          if (!paramacuk.a()) {
            break label137;
          }
          paramacum.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label146;
        }
        paramacum.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setContentDescription((CharSequence)localObject);
        return;
        if (paramacuk.a != 1) {
          break;
        }
        localObject = acte.a().b(0, paramacuk.b);
        paramacum.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap((Bitmap)localObject);
        localObject = ajjy.a(2131636362) + (paramInt + 1);
        break;
        paramacum.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
    paramView = (acuk)a(i);
    QQAppInterface localQQAppInterface;
    if (paramView != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != paramView.a) {
        break label74;
      }
      awqx.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, paramView.b, "", "", "", "");
    }
    label74:
    while (paramView.a != 0) {
      return;
    }
    awqx.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, paramView.c, "", "", "", "");
  }
  
  public void setListener(acul paramacul)
  {
    this.jdField_a_of_type_Acul = paramacul;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker
 * JD-Core Version:    0.7.0.1
 */