package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
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

public class GifTemplatePicker
  extends RDBaseListLayout<GifTemplatePicker.GifTemplatePickerData, GifTemplatePicker.ViewHolder>
  implements View.OnClickListener, ResCallback
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
    a(new GifTemplatePicker.GifTemplatePickerData(2130837948, 0), false);
    Object localObject = DoodleResHelper.a().a(1);
    if (localObject == null) {
      return;
    }
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
  
  public GifTemplatePicker.ViewHolder a(int paramInt, GifTemplatePicker.GifTemplatePickerData paramGifTemplatePickerData)
  {
    GifTemplatePicker.ViewHolder localViewHolder = new GifTemplatePicker.ViewHolder();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(Utils.a(50.0F, getResources()), Utils.a(37.0F, getResources())));
    localViewHolder.a(localRelativeLayout);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Utils.a(40.0F, getResources()), Utils.a(27.0F, getResources()));
    paramInt = Utils.a(5.0F, getResources());
    localLayoutParams.leftMargin = paramInt;
    localLayoutParams.topMargin = paramInt;
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    if (paramGifTemplatePickerData.a == 1) {
      paramGifTemplatePickerData = DoodleResHelper.a().a(1, paramGifTemplatePickerData.b);
    } else if (paramGifTemplatePickerData.a == 0) {
      paramGifTemplatePickerData = getContext().getResources().getDrawable(paramGifTemplatePickerData.b);
    } else {
      paramGifTemplatePickerData = null;
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramGifTemplatePickerData);
    localRelativeLayout.addView(localViewHolder.jdField_a_of_type_AndroidWidgetImageView);
    localViewHolder.jdField_a_of_type_AndroidViewView = new View(getContext());
    localViewHolder.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1427313428);
    localViewHolder.jdField_a_of_type_AndroidViewView.setClickable(false);
    localRelativeLayout.addView(localViewHolder.jdField_a_of_type_AndroidViewView, 0);
    return localViewHolder;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt, GifTemplatePicker.GifTemplatePickerData paramGifTemplatePickerData)
  {
    if ((this.a != null) && (paramGifTemplatePickerData != null))
    {
      if (paramGifTemplatePickerData.a == 0)
      {
        this.a.a(-1);
        return;
      }
      this.a.a(paramGifTemplatePickerData.b);
    }
  }
  
  public void a(int paramInt, GifTemplatePicker.GifTemplatePickerData paramGifTemplatePickerData, GifTemplatePicker.ViewHolder paramViewHolder)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      Object localObject = null;
      if (paramGifTemplatePickerData.a == 1) {
        localObject = DoodleResHelper.a().a(1, paramGifTemplatePickerData.b);
      } else if (paramGifTemplatePickerData.a == 0) {
        localObject = getContext().getResources().getDrawable(paramGifTemplatePickerData.b);
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (AppSetting.d)
      {
        if (paramInt == 0)
        {
          localObject = HardCodeUtil.a(2131705358);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131705357));
          ((StringBuilder)localObject).append(paramInt);
          localObject = ((StringBuilder)localObject).toString();
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      }
    }
    if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramGifTemplatePickerData.a())
      {
        paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a(View paramView, int paramInt1, ResInfo paramResInfo, int paramInt2)
  {
    if (paramInt1 == 4)
    {
      if (1 == paramInt2)
      {
        a(false);
        b(false);
        c();
        return;
      }
      if (4 == paramInt2) {
        return;
      }
      paramView = new StringBuilder();
      paramView.append("ScribbleResMgr down error:");
      paramView.append(paramInt2);
      QLog.d("GifTemplatePicker", 2, paramView.toString());
    }
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
    GifTemplatePicker.GifTemplatePickerData localGifTemplatePickerData = (GifTemplatePicker.GifTemplatePickerData)a(i);
    if (localGifTemplatePickerData != null)
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (1 == localGifTemplatePickerData.a) {
        ReportController.b(localAppRuntime, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, localGifTemplatePickerData.b, "", "", "", "");
      } else {
        ReportController.b(localAppRuntime, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setListener(GifTemplatePicker.GifTemplatePickerListener paramGifTemplatePickerListener)
  {
    this.a = paramGifTemplatePickerListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker
 * JD-Core Version:    0.7.0.1
 */