package com.tencent.mobileqq.activity.aio.doodle.control;

import agcw;
import ageh;
import agei;
import agej;
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

public class GifTemplatePicker
  extends RDBaseListLayout<ageh, agej>
  implements View.OnClickListener, bbye
{
  private agei a;
  
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
    a(new ageh(2130838027, 0), false);
    Object localObject = agcw.a().a(1);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!agcw.a().a(1, localInteger.intValue()))
        {
          if (paramBoolean) {
            agcw.a().a(1, localInteger.intValue(), this, this);
          }
        }
        else {
          a(new ageh(localInteger.intValue(), 1), false);
        }
      }
    }
  }
  
  public agej a(int paramInt, ageh paramageh)
  {
    agej localagej = new agej();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.dp2px(50.0F, getResources()), AIOUtils.dp2px(37.0F, getResources())));
    localagej.a(localRelativeLayout);
    localagej.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = new RelativeLayout.LayoutParams(AIOUtils.dp2px(40.0F, getResources()), AIOUtils.dp2px(27.0F, getResources()));
    paramInt = AIOUtils.dp2px(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    localagej.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = null;
    if (paramageh.a == 1) {
      localObject = agcw.a().a(1, paramageh.b);
    }
    for (;;)
    {
      localagej.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localagej.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localRelativeLayout.addView(localagej.jdField_a_of_type_AndroidWidgetImageView);
      localagej.jdField_a_of_type_AndroidViewView = new View(getContext());
      localagej.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localagej.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1427313428);
      localagej.jdField_a_of_type_AndroidViewView.setClickable(false);
      localRelativeLayout.addView(localagej.jdField_a_of_type_AndroidViewView, 0);
      return localagej;
      if (paramageh.a == 0) {
        localObject = getContext().getResources().getDrawable(paramageh.b);
      }
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt, ageh paramageh)
  {
    if ((this.a != null) && (paramageh != null))
    {
      if (paramageh.a == 0) {
        this.a.a(-1);
      }
    }
    else {
      return;
    }
    this.a.a(paramageh.b);
  }
  
  public void a(int paramInt, ageh paramageh, agej paramagej)
  {
    if (paramagej.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = null;
      if (paramageh.a != 1) {
        break label89;
      }
      localObject = agcw.a().a(1, paramageh.b);
      paramagej.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (AppSetting.c) {
        if (paramInt != 0) {
          break label115;
        }
      }
    }
    label89:
    label115:
    for (Object localObject = anvx.a(2131704741);; localObject = anvx.a(2131704740) + paramInt)
    {
      paramagej.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      if (paramagej.jdField_a_of_type_AndroidViewView != null)
      {
        if (!paramageh.a()) {
          break label142;
        }
        paramagej.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      if (paramageh.a != 0) {
        break;
      }
      localObject = getContext().getResources().getDrawable(paramageh.b);
      break;
    }
    label142:
    paramagej.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    ageh localageh = (ageh)a(i);
    QQAppInterface localQQAppInterface;
    if (localageh != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != localageh.a) {
        break label89;
      }
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, localageh.b, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label89:
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, 0, "", "", "", "");
    }
  }
  
  public void setListener(agei paramagei)
  {
    this.a = paramagei;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker
 * JD-Core Version:    0.7.0.1
 */