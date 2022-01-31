package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResCallback;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GifTemplatePicker
  extends RDBaseListLayout
  implements View.OnClickListener, ScribbleResMgr.ResCallback
{
  private GifTemplatePicker.GifTemplatePickerListener a;
  
  public GifTemplatePicker(Context paramContext)
  {
    super(paramContext);
    a(1);
  }
  
  public GifTemplatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(1);
  }
  
  public GifTemplatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(1);
  }
  
  private void b(boolean paramBoolean)
  {
    a(new GifTemplatePicker.GifTemplatePickerData(2130837566, 0), false);
    Object localObject = DoodleResHelper.a().a(1);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!DoodleResHelper.a().a(1, localInteger.intValue()))
        {
          if (paramBoolean) {
            DoodleResHelper.a().a(1, localInteger.intValue(), this, this);
          }
        }
        else {
          a(new GifTemplatePicker.GifTemplatePickerData(localInteger.intValue(), 1), false);
        }
      }
    }
  }
  
  public GifTemplatePicker.ViewHolder a(int paramInt, GifTemplatePicker.GifTemplatePickerData paramGifTemplatePickerData)
  {
    GifTemplatePicker.ViewHolder localViewHolder = new GifTemplatePicker.ViewHolder();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, getResources()), AIOUtils.a(37.0F, getResources())));
    localViewHolder.a(localRelativeLayout);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = new RelativeLayout.LayoutParams(AIOUtils.a(40.0F, getResources()), AIOUtils.a(27.0F, getResources()));
    paramInt = AIOUtils.a(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = null;
    if (paramGifTemplatePickerData.a == 1) {
      localObject = DoodleResHelper.a().a(1, paramGifTemplatePickerData.b);
    }
    for (;;)
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localRelativeLayout.addView(localViewHolder.jdField_a_of_type_AndroidWidgetImageView);
      localViewHolder.jdField_a_of_type_AndroidViewView = new View(getContext());
      localViewHolder.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1427313428);
      localViewHolder.jdField_a_of_type_AndroidViewView.setClickable(false);
      localRelativeLayout.addView(localViewHolder.jdField_a_of_type_AndroidViewView, 0);
      return localViewHolder;
      if (paramGifTemplatePickerData.a == 0) {
        localObject = getContext().getResources().getDrawable(paramGifTemplatePickerData.b);
      }
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt, GifTemplatePicker.GifTemplatePickerData paramGifTemplatePickerData)
  {
    if ((this.a != null) && (paramGifTemplatePickerData != null))
    {
      if (paramGifTemplatePickerData.a == 0) {
        this.a.a(-1);
      }
    }
    else {
      return;
    }
    this.a.a(paramGifTemplatePickerData.b);
  }
  
  public void a(int paramInt, GifTemplatePicker.GifTemplatePickerData paramGifTemplatePickerData, GifTemplatePicker.ViewHolder paramViewHolder)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = null;
      if (paramGifTemplatePickerData.a != 1) {
        break label86;
      }
      localObject = DoodleResHelper.a().a(1, paramGifTemplatePickerData.b);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (AppSetting.b) {
        if (paramInt != 0) {
          break label112;
        }
      }
    }
    label86:
    label112:
    for (Object localObject = "不使用模板";; localObject = "使用模板" + paramInt)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
      {
        if (!paramGifTemplatePickerData.a()) {
          break label136;
        }
        paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      if (paramGifTemplatePickerData.a != 0) {
        break;
      }
      localObject = getContext().getResources().getDrawable(paramGifTemplatePickerData.b);
      break;
    }
    label136:
    paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(View paramView, int paramInt1, ScribbleResMgr.ResInfo paramResInfo, int paramInt2)
  {
    if (paramInt1 == 4)
    {
      if (1 != paramInt2) {
        break label26;
      }
      a(false);
      b(false);
      c();
    }
    label26:
    while (4 == paramInt2) {
      return;
    }
    QLog.d("GifTemplatePicker", 2, "ScribbleResMgr down error:" + paramInt2);
  }
  
  public boolean a()
  {
    b(true);
    c();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = a(paramView);
    a(i, false);
    paramView = (GifTemplatePicker.GifTemplatePickerData)a(i);
    QQAppInterface localQQAppInterface;
    if (paramView != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 == paramView.a) {
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, paramView.b, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, 0, "", "", "", "");
  }
  
  public void setListener(GifTemplatePicker.GifTemplatePickerListener paramGifTemplatePickerListener)
  {
    this.a = paramGifTemplatePickerListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker
 * JD-Core Version:    0.7.0.1
 */