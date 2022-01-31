package com.tencent.mobileqq.activity.aio.doodle.control;

import actn;
import addx;
import adfc;
import adfd;
import adfe;
import adff;
import ajyc;
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
import awhe;
import axqw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ColorPicker
  extends RDBaseListLayout<adfd, adff>
  implements View.OnClickListener, awhe
{
  private adfe jdField_a_of_type_Adfe;
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
      return ajyc.a(2131702151);
    case -5789785: 
      return ajyc.a(2131702143);
    case -2148308: 
    case -845543: 
      return ajyc.a(2131702147);
    case -1009097: 
    case -27392: 
      return ajyc.a(2131702150);
    case -274353: 
      return ajyc.a(2131702142);
    case -10233288: 
    case -8136876: 
      return ajyc.a(2131702148);
    case -13338378: 
    case -9576193: 
      return ajyc.a(2131702149);
    case -6989057: 
      return ajyc.a(2131702144);
    }
    return ajyc.a(2131702145);
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      a(new adfd(0, -1, this.jdField_a_of_type_ArrayOfInt[i]), false);
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject = addx.a().a(0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!addx.a().c(0, localInteger.intValue()))
        {
          addx.a().a(0, localInteger.intValue(), this, this);
          addx.a().b(0, localInteger.intValue(), this, this);
        }
        else
        {
          a(new adfd(1, localInteger.intValue(), -1), false);
        }
      }
    }
  }
  
  public adff a(int paramInt, adfd paramadfd)
  {
    adff localadff = new adff();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(actn.a(32.0F, getResources()), -1));
    paramInt = actn.a(4.0F, getResources());
    int i = actn.a(9.5F, getResources());
    localRelativeLayout.setPadding(paramInt, i, paramInt, i);
    localadff.a(localRelativeLayout);
    localRelativeLayout.setOnClickListener(this);
    localadff.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = getContext().getResources().getDrawable(2130837690);
    localadff.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    localadff.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramadfd.a()) {
      localadff.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      localadff.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView = new ColorView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(actn.a(18.0F, getResources()), actn.a(18.0F, getResources()));
      paramInt = actn.a(3.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt, paramInt, paramInt, paramInt);
      ((RelativeLayout)localadff.a()).addView(localadff.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView);
      localRelativeLayout.addView(localadff.jdField_a_of_type_AndroidWidgetImageView);
      localadff.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setListener(new adfc(this, localadff));
      localadff.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramadfd.a != 0) {
        break;
      }
      localadff.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramadfd.c);
      return localadff;
      localadff.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    paramadfd = addx.a().b(0, paramadfd.b);
    localadff.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap(paramadfd);
    return localadff;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Adfe = null;
  }
  
  public void a(int paramInt, adfd paramadfd)
  {
    if ((paramadfd != null) && (this.jdField_a_of_type_Adfe != null)) {
      this.jdField_a_of_type_Adfe.a(paramadfd);
    }
  }
  
  public void a(int paramInt, adfd paramadfd, adff paramadff)
  {
    if ((paramadff == null) || (paramadfd == null)) {}
    label137:
    label146:
    for (;;)
    {
      return;
      Object localObject = "";
      if (paramadfd.a == 0)
      {
        paramadff.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramadfd.c);
        localObject = a(paramadfd.c);
        if (paramadff.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          if (!paramadfd.a()) {
            break label137;
          }
          paramadff.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!AppSetting.d) {
          break label146;
        }
        paramadff.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setContentDescription((CharSequence)localObject);
        return;
        if (paramadfd.a != 1) {
          break;
        }
        localObject = addx.a().b(0, paramadfd.b);
        paramadff.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap((Bitmap)localObject);
        localObject = ajyc.a(2131702146) + (paramInt + 1);
        break;
        paramadff.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
    paramView = (adfd)a(i);
    QQAppInterface localQQAppInterface;
    if (paramView != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != paramView.a) {
        break label74;
      }
      axqw.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, paramView.b, "", "", "", "");
    }
    label74:
    while (paramView.a != 0) {
      return;
    }
    axqw.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, paramView.c, "", "", "", "");
  }
  
  public void setListener(adfe paramadfe)
  {
    this.jdField_a_of_type_Adfe = paramadfe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker
 * JD-Core Version:    0.7.0.1
 */