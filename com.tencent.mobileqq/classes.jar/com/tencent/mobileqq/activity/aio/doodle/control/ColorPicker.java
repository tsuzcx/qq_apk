package com.tencent.mobileqq.activity.aio.doodle.control;

import agcw;
import ageb;
import agec;
import aged;
import agee;
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
import anvx;
import bbye;
import bdla;
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
  extends RDBaseListLayout<agec, agee>
  implements View.OnClickListener, bbye
{
  private aged jdField_a_of_type_Aged;
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
      return anvx.a(2131701659);
    case -5789785: 
      return anvx.a(2131701651);
    case -2148308: 
    case -845543: 
      return anvx.a(2131701655);
    case -1009097: 
    case -27392: 
      return anvx.a(2131701658);
    case -274353: 
      return anvx.a(2131701650);
    case -10233288: 
    case -8136876: 
      return anvx.a(2131701656);
    case -13338378: 
    case -9576193: 
      return anvx.a(2131701657);
    case -6989057: 
      return anvx.a(2131701652);
    }
    return anvx.a(2131701653);
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      a(new agec(0, -1, this.jdField_a_of_type_ArrayOfInt[i]), false);
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject = agcw.a().a(0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!agcw.a().c(0, localInteger.intValue()))
        {
          agcw.a().a(0, localInteger.intValue(), this, this);
          agcw.a().b(0, localInteger.intValue(), this, this);
        }
        else
        {
          a(new agec(1, localInteger.intValue(), -1), false);
        }
      }
    }
  }
  
  public agee a(int paramInt, agec paramagec)
  {
    agee localagee = new agee();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.dp2px(32.0F, getResources()), -1));
    paramInt = AIOUtils.dp2px(4.0F, getResources());
    int i = AIOUtils.dp2px(9.5F, getResources());
    localRelativeLayout.setPadding(paramInt, i, paramInt, i);
    localagee.a(localRelativeLayout);
    localRelativeLayout.setOnClickListener(this);
    localagee.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = getContext().getResources().getDrawable(2130838023);
    localagee.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    localagee.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramagec.a()) {
      localagee.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      localagee.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView = new ColorView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(AIOUtils.dp2px(18.0F, getResources()), AIOUtils.dp2px(18.0F, getResources()));
      paramInt = AIOUtils.dp2px(3.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt, paramInt, paramInt, paramInt);
      ((RelativeLayout)localagee.a()).addView(localagee.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView);
      localRelativeLayout.addView(localagee.jdField_a_of_type_AndroidWidgetImageView);
      localagee.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setListener(new ageb(this, localagee));
      localagee.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramagec.a != 0) {
        break;
      }
      localagee.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramagec.c);
      return localagee;
      localagee.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    paramagec = agcw.a().b(0, paramagec.b);
    localagee.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap(paramagec);
    return localagee;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aged = null;
  }
  
  public void a(int paramInt, agec paramagec)
  {
    if ((paramagec != null) && (this.jdField_a_of_type_Aged != null)) {
      this.jdField_a_of_type_Aged.a(paramagec);
    }
  }
  
  public void a(int paramInt, agec paramagec, agee paramagee)
  {
    if ((paramagee == null) || (paramagec == null)) {}
    label137:
    label146:
    for (;;)
    {
      return;
      Object localObject = "";
      if (paramagec.a == 0)
      {
        paramagee.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramagec.c);
        localObject = a(paramagec.c);
        if (paramagee.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          if (!paramagec.a()) {
            break label137;
          }
          paramagee.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label146;
        }
        paramagee.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setContentDescription((CharSequence)localObject);
        return;
        if (paramagec.a != 1) {
          break;
        }
        localObject = agcw.a().b(0, paramagec.b);
        paramagee.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap((Bitmap)localObject);
        localObject = anvx.a(2131701654) + (paramInt + 1);
        break;
        paramagee.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
    agec localagec = (agec)a(i);
    QQAppInterface localQQAppInterface;
    if (localagec != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != localagec.a) {
        break label83;
      }
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, localagec.b, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      if (localagec.a == 0) {
        bdla.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, localagec.c, "", "", "", "");
      }
    }
  }
  
  public void setListener(aged paramaged)
  {
    this.jdField_a_of_type_Aged = paramaged;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker
 * JD-Core Version:    0.7.0.1
 */