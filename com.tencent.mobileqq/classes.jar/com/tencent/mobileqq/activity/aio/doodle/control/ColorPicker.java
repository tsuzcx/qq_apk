package com.tencent.mobileqq.activity.aio.doodle.control;

import agej;
import agpy;
import agrd;
import agre;
import agrf;
import agrg;
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
import anzj;
import bbxu;
import bdll;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ColorPicker
  extends RDBaseListLayout<agre, agrg>
  implements View.OnClickListener, bbxu
{
  private agrf jdField_a_of_type_Agrf;
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
      return anzj.a(2131701073);
    case -5789785: 
      return anzj.a(2131701065);
    case -2148308: 
    case -845543: 
      return anzj.a(2131701069);
    case -1009097: 
    case -27392: 
      return anzj.a(2131701072);
    case -274353: 
      return anzj.a(2131701064);
    case -10233288: 
    case -8136876: 
      return anzj.a(2131701070);
    case -13338378: 
    case -9576193: 
      return anzj.a(2131701071);
    case -6989057: 
      return anzj.a(2131701066);
    }
    return anzj.a(2131701067);
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      a(new agre(0, -1, this.jdField_a_of_type_ArrayOfInt[i]), false);
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject = agpy.a().a(0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!agpy.a().c(0, localInteger.intValue()))
        {
          agpy.a().a(0, localInteger.intValue(), this, this);
          agpy.a().b(0, localInteger.intValue(), this, this);
        }
        else
        {
          a(new agre(1, localInteger.intValue(), -1), false);
        }
      }
    }
  }
  
  public agrg a(int paramInt, agre paramagre)
  {
    agrg localagrg = new agrg();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(agej.a(32.0F, getResources()), -1));
    paramInt = agej.a(4.0F, getResources());
    int i = agej.a(9.5F, getResources());
    localRelativeLayout.setPadding(paramInt, i, paramInt, i);
    localagrg.a(localRelativeLayout);
    localRelativeLayout.setOnClickListener(this);
    localagrg.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = getContext().getResources().getDrawable(2130837984);
    localagrg.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    localagrg.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramagre.a()) {
      localagrg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      localagrg.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView = new ColorView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(agej.a(18.0F, getResources()), agej.a(18.0F, getResources()));
      paramInt = agej.a(3.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt, paramInt, paramInt, paramInt);
      ((RelativeLayout)localagrg.a()).addView(localagrg.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView);
      localRelativeLayout.addView(localagrg.jdField_a_of_type_AndroidWidgetImageView);
      localagrg.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setListener(new agrd(this, localagrg));
      localagrg.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramagre.a != 0) {
        break;
      }
      localagrg.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramagre.c);
      return localagrg;
      localagrg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    paramagre = agpy.a().b(0, paramagre.b);
    localagrg.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap(paramagre);
    return localagrg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Agrf = null;
  }
  
  public void a(int paramInt, agre paramagre)
  {
    if ((paramagre != null) && (this.jdField_a_of_type_Agrf != null)) {
      this.jdField_a_of_type_Agrf.a(paramagre);
    }
  }
  
  public void a(int paramInt, agre paramagre, agrg paramagrg)
  {
    if ((paramagrg == null) || (paramagre == null)) {}
    label137:
    label146:
    for (;;)
    {
      return;
      Object localObject = "";
      if (paramagre.a == 0)
      {
        paramagrg.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramagre.c);
        localObject = a(paramagre.c);
        if (paramagrg.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          if (!paramagre.a()) {
            break label137;
          }
          paramagrg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label146;
        }
        paramagrg.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setContentDescription((CharSequence)localObject);
        return;
        if (paramagre.a != 1) {
          break;
        }
        localObject = agpy.a().b(0, paramagre.b);
        paramagrg.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap((Bitmap)localObject);
        localObject = anzj.a(2131701068) + (paramInt + 1);
        break;
        paramagrg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
    agre localagre = (agre)a(i);
    QQAppInterface localQQAppInterface;
    if (localagre != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != localagre.a) {
        break label83;
      }
      bdll.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, localagre.b, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      if (localagre.a == 0) {
        bdll.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, localagre.c, "", "", "", "");
      }
    }
  }
  
  public void setListener(agrf paramagrf)
  {
    this.jdField_a_of_type_Agrf = paramagrf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker
 * JD-Core Version:    0.7.0.1
 */