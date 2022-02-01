package com.tencent.mobileqq.activity.aio.doodle.control;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.scribble.ResCallback;
import com.tencent.mobileqq.scribble.ResInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ColorPicker
  extends RDBaseListLayout<ColorPicker.ColorPickerData, ColorPicker.ViewHolder>
  implements View.OnClickListener, ResCallback
{
  private ColorPicker.ColorSelectListener jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker$ColorSelectListener;
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
    case -1: 
      return HardCodeUtil.a(2131702344);
    case -274353: 
      return HardCodeUtil.a(2131702341);
    case -1009097: 
    case -27392: 
      return HardCodeUtil.a(2131702349);
    case -2148308: 
    case -845543: 
      return HardCodeUtil.a(2131702346);
    case -5789785: 
      return HardCodeUtil.a(2131702342);
    case -6989057: 
      return HardCodeUtil.a(2131702343);
    case -10233288: 
    case -8136876: 
      return HardCodeUtil.a(2131702347);
    case -13338378: 
    case -9576193: 
      return HardCodeUtil.a(2131702348);
    }
    return HardCodeUtil.a(2131702350);
  }
  
  private void d()
  {
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (i >= arrayOfInt.length) {
        break;
      }
      a(new ColorPicker.ColorPickerData(0, -1, arrayOfInt[i]), false);
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject = DoodleResHelper.a().a(0);
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      if (!DoodleResHelper.a().c(0, localInteger.intValue()))
      {
        DoodleResHelper.a().a(0, localInteger.intValue(), this, this);
        DoodleResHelper.a().b(0, localInteger.intValue(), this, this);
      }
      else
      {
        a(new ColorPicker.ColorPickerData(1, localInteger.intValue(), -1), false);
      }
    }
  }
  
  public ColorPicker.ViewHolder a(int paramInt, ColorPicker.ColorPickerData paramColorPickerData)
  {
    ColorPicker.ViewHolder localViewHolder = new ColorPicker.ViewHolder();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(Utils.a(32.0F, getResources()), -1));
    paramInt = Utils.a(4.0F, getResources());
    int i = Utils.a(9.5F, getResources());
    localRelativeLayout.setPadding(paramInt, i, paramInt, i);
    localViewHolder.a(localRelativeLayout);
    localRelativeLayout.setOnClickListener(this);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = getContext().getResources().getDrawable(2130837944);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramColorPickerData.a()) {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView = new ColorView(getContext(), null);
    localObject = new RelativeLayout.LayoutParams(Utils.a(18.0F, getResources()), Utils.a(18.0F, getResources()));
    paramInt = Utils.a(3.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt, paramInt, paramInt, paramInt);
    ((RelativeLayout)localViewHolder.a()).addView(localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView);
    localRelativeLayout.addView(localViewHolder.jdField_a_of_type_AndroidWidgetImageView);
    localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setListener(new ColorPicker.1(this, localViewHolder));
    localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramColorPickerData.a == 0)
    {
      localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramColorPickerData.c);
      return localViewHolder;
    }
    paramColorPickerData = DoodleResHelper.a().b(0, paramColorPickerData.b);
    localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap(paramColorPickerData);
    return localViewHolder;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker$ColorSelectListener = null;
  }
  
  public void a(int paramInt, ColorPicker.ColorPickerData paramColorPickerData)
  {
    if (paramColorPickerData != null)
    {
      ColorPicker.ColorSelectListener localColorSelectListener = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker$ColorSelectListener;
      if (localColorSelectListener != null) {
        localColorSelectListener.a(paramColorPickerData);
      }
    }
  }
  
  public void a(int paramInt, ColorPicker.ColorPickerData paramColorPickerData, ColorPicker.ViewHolder paramViewHolder)
  {
    if (paramViewHolder != null)
    {
      if (paramColorPickerData == null) {
        return;
      }
      Object localObject;
      if (paramColorPickerData.a == 0)
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramColorPickerData.c);
        localObject = a(paramColorPickerData.c);
      }
      else if (paramColorPickerData.a == 1)
      {
        localObject = DoodleResHelper.a().b(0, paramColorPickerData.b);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap((Bitmap)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131702345));
        ((StringBuilder)localObject).append(paramInt + 1);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "";
      }
      if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView != null) {
        if (paramColorPickerData.a()) {
          paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        } else {
          paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
      }
      if (AppSetting.d) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setContentDescription((CharSequence)localObject);
      }
    }
  }
  
  public void a(View paramView, int paramInt1, ResInfo paramResInfo, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      if (1 == paramInt2)
      {
        a(false);
        a();
        return;
      }
      if (4 == paramInt2) {
        return;
      }
      paramView = new StringBuilder();
      paramView.append("ScribbleResMgr down error:");
      paramView.append(paramInt2);
      QLog.d("ColorPicker", 2, paramView.toString());
      return;
    }
    if ((paramInt1 == 1) && (1 == paramInt2)) {
      c();
    }
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
    ColorPicker.ColorPickerData localColorPickerData = (ColorPicker.ColorPickerData)a(i);
    if (localColorPickerData != null)
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (1 == localColorPickerData.a) {
        ReportController.b(localAppRuntime, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, localColorPickerData.b, "", "", "", "");
      } else if (localColorPickerData.a == 0) {
        ReportController.b(localAppRuntime, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, localColorPickerData.c, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setListener(ColorPicker.ColorSelectListener paramColorSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker$ColorSelectListener = paramColorSelectListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker
 * JD-Core Version:    0.7.0.1
 */