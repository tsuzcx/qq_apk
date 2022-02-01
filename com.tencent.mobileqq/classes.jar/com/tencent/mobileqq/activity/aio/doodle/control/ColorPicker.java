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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResCallback;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ColorPicker
  extends RDBaseListLayout<ColorPicker.ColorPickerData, ColorPicker.ViewHolder>
  implements View.OnClickListener, ScribbleResMgr.ResCallback
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
    case -16777216: 
      return HardCodeUtil.a(2131702214);
    case -5789785: 
      return HardCodeUtil.a(2131702206);
    case -2148308: 
    case -845543: 
      return HardCodeUtil.a(2131702210);
    case -1009097: 
    case -27392: 
      return HardCodeUtil.a(2131702213);
    case -274353: 
      return HardCodeUtil.a(2131702205);
    case -10233288: 
    case -8136876: 
      return HardCodeUtil.a(2131702211);
    case -13338378: 
    case -9576193: 
      return HardCodeUtil.a(2131702212);
    case -6989057: 
      return HardCodeUtil.a(2131702207);
    }
    return HardCodeUtil.a(2131702208);
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      a(new ColorPicker.ColorPickerData(0, -1, this.jdField_a_of_type_ArrayOfInt[i]), false);
      i += 1;
    }
  }
  
  private void e()
  {
    Object localObject = DoodleResHelper.a().a(0);
    if (localObject == null) {}
    for (;;)
    {
      return;
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
  }
  
  public ColorPicker.ViewHolder a(int paramInt, ColorPicker.ColorPickerData paramColorPickerData)
  {
    ColorPicker.ViewHolder localViewHolder = new ColorPicker.ViewHolder();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.a(32.0F, getResources()), -1));
    paramInt = AIOUtils.a(4.0F, getResources());
    int i = AIOUtils.a(9.5F, getResources());
    localRelativeLayout.setPadding(paramInt, i, paramInt, i);
    localViewHolder.a(localRelativeLayout);
    localRelativeLayout.setOnClickListener(this);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = getContext().getResources().getDrawable(2130838094);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramColorPickerData.a()) {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView = new ColorView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(AIOUtils.a(18.0F, getResources()), AIOUtils.a(18.0F, getResources()));
      paramInt = AIOUtils.a(3.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).setMargins(paramInt, paramInt, paramInt, paramInt);
      ((RelativeLayout)localViewHolder.a()).addView(localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView);
      localRelativeLayout.addView(localViewHolder.jdField_a_of_type_AndroidWidgetImageView);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setListener(new ColorPicker.1(this, localViewHolder));
      localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramColorPickerData.a != 0) {
        break;
      }
      localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramColorPickerData.c);
      return localViewHolder;
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
    if ((paramColorPickerData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker$ColorSelectListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker$ColorSelectListener.a(paramColorPickerData);
    }
  }
  
  public void a(int paramInt, ColorPicker.ColorPickerData paramColorPickerData, ColorPicker.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder == null) || (paramColorPickerData == null)) {}
    label137:
    label146:
    for (;;)
    {
      return;
      Object localObject = "";
      if (paramColorPickerData.a == 0)
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setColor(paramColorPickerData.c);
        localObject = a(paramColorPickerData.c);
        if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          if (!paramColorPickerData.a()) {
            break label137;
          }
          paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!AppSetting.d) {
          break label146;
        }
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setContentDescription((CharSequence)localObject);
        return;
        if (paramColorPickerData.a != 1) {
          break;
        }
        localObject = DoodleResHelper.a().b(0, paramColorPickerData.b);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorView.setBtmap((Bitmap)localObject);
        localObject = HardCodeUtil.a(2131702209) + (paramInt + 1);
        break;
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
    ColorPicker.ColorPickerData localColorPickerData = (ColorPicker.ColorPickerData)a(i);
    QQAppInterface localQQAppInterface;
    if (localColorPickerData != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != localColorPickerData.a) {
        break label83;
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, localColorPickerData.b, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      if (localColorPickerData.a == 0) {
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, localColorPickerData.c, "", "", "", "");
      }
    }
  }
  
  public void setListener(ColorPicker.ColorSelectListener paramColorSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker$ColorSelectListener = paramColorSelectListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker
 * JD-Core Version:    0.7.0.1
 */