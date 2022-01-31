package com.tencent.mobileqq.activity.aio.doodle.control;

import aepi;
import afal;
import afbq;
import afbr;
import afbs;
import afbt;
import alud;
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
import aygt;
import azqs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ColorPicker
  extends RDBaseListLayout<afbr, afbt>
  implements View.OnClickListener, aygt
{
  private afbs jdField_a_of_type_Afbs;
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
      return alud.a(2131702546);
    case -5789785: 
      return alud.a(2131702538);
    case -2148308: 
    case -845543: 
      return alud.a(2131702542);
    case -1009097: 
    case -27392: 
      return alud.a(2131702545);
    case -274353: 
      return alud.a(2131702537);
    case -10233288: 
    case -8136876: 
      return alud.a(2131702543);
    case -13338378: 
    case -9576193: 
      return alud.a(2131702544);
    case -6989057: 
      return alud.a(2131702539);
    }
    return alud.a(2131702540);
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      a(new afbr(0, -1, this.jdField_a_of_type_ArrayOfInt[i]), false);
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject = afal.a().a(0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!afal.a().c(0, localInteger.intValue()))
        {
          afal.a().a(0, localInteger.intValue(), this, this);
          afal.a().b(0, localInteger.intValue(), this, this);
        }
        else
        {
          a(new afbr(1, localInteger.intValue(), -1), false);
        }
      }
    }
  }
  
  public afbt a(int paramInt, afbr paramafbr)
  {
    afbt localafbt = new afbt();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(aepi.a(32.0F, getResources()), -1));
    paramInt = aepi.a(4.0F, getResources());
    int i = aepi.a(9.5F, getResources());
    localRelativeLayout.setPadding(paramInt, i, paramInt, i);
    localafbt.a(localRelativeLayout);
    localRelativeLayout.setOnClickListener(this);
    localafbt.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = getContext().getResources().getDrawable(2130837746);
    localafbt.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    localafbt.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramafbr.a()) {
      localafbt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      localafbt.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView = new ColorView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(aepi.a(18.0F, getResources()), aepi.a(18.0F, getResources()));
      paramInt = aepi.a(3.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt, paramInt, paramInt, paramInt);
      ((RelativeLayout)localafbt.a()).addView(localafbt.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView);
      localRelativeLayout.addView(localafbt.jdField_a_of_type_AndroidWidgetImageView);
      localafbt.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setListener(new afbq(this, localafbt));
      localafbt.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramafbr.a != 0) {
        break;
      }
      localafbt.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramafbr.c);
      return localafbt;
      localafbt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    paramafbr = afal.a().b(0, paramafbr.b);
    localafbt.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap(paramafbr);
    return localafbt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Afbs = null;
  }
  
  public void a(int paramInt, afbr paramafbr)
  {
    if ((paramafbr != null) && (this.jdField_a_of_type_Afbs != null)) {
      this.jdField_a_of_type_Afbs.a(paramafbr);
    }
  }
  
  public void a(int paramInt, afbr paramafbr, afbt paramafbt)
  {
    if ((paramafbt == null) || (paramafbr == null)) {}
    label137:
    label146:
    for (;;)
    {
      return;
      Object localObject = "";
      if (paramafbr.a == 0)
      {
        paramafbt.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramafbr.c);
        localObject = a(paramafbr.c);
        if (paramafbt.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          if (!paramafbr.a()) {
            break label137;
          }
          paramafbt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label146;
        }
        paramafbt.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setContentDescription((CharSequence)localObject);
        return;
        if (paramafbr.a != 1) {
          break;
        }
        localObject = afal.a().b(0, paramafbr.b);
        paramafbt.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap((Bitmap)localObject);
        localObject = alud.a(2131702541) + (paramInt + 1);
        break;
        paramafbt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
    paramView = (afbr)a(i);
    QQAppInterface localQQAppInterface;
    if (paramView != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != paramView.a) {
        break label74;
      }
      azqs.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, paramView.b, "", "", "", "");
    }
    label74:
    while (paramView.a != 0) {
      return;
    }
    azqs.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, paramView.c, "", "", "", "");
  }
  
  public void setListener(afbs paramafbs)
  {
    this.jdField_a_of_type_Afbs = paramafbs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker
 * JD-Core Version:    0.7.0.1
 */