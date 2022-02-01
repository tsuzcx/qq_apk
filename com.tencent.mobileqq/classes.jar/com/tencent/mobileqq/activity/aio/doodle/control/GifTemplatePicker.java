package com.tencent.mobileqq.activity.aio.doodle.control;

import agej;
import agpy;
import agrj;
import agrk;
import agrl;
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

public class GifTemplatePicker
  extends RDBaseListLayout<agrj, agrl>
  implements View.OnClickListener, bbxu
{
  private agrk a;
  
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
    a(new agrj(2130837988, 0), false);
    Object localObject = agpy.a().a(1);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!agpy.a().a(1, localInteger.intValue()))
        {
          if (paramBoolean) {
            agpy.a().a(1, localInteger.intValue(), this, this);
          }
        }
        else {
          a(new agrj(localInteger.intValue(), 1), false);
        }
      }
    }
  }
  
  public agrl a(int paramInt, agrj paramagrj)
  {
    agrl localagrl = new agrl();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(agej.a(50.0F, getResources()), agej.a(37.0F, getResources())));
    localagrl.a(localRelativeLayout);
    localagrl.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = new RelativeLayout.LayoutParams(agej.a(40.0F, getResources()), agej.a(27.0F, getResources()));
    paramInt = agej.a(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    localagrl.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = null;
    if (paramagrj.a == 1) {
      localObject = agpy.a().a(1, paramagrj.b);
    }
    for (;;)
    {
      localagrl.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localagrl.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localRelativeLayout.addView(localagrl.jdField_a_of_type_AndroidWidgetImageView);
      localagrl.jdField_a_of_type_AndroidViewView = new View(getContext());
      localagrl.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localagrl.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1427313428);
      localagrl.jdField_a_of_type_AndroidViewView.setClickable(false);
      localRelativeLayout.addView(localagrl.jdField_a_of_type_AndroidViewView, 0);
      return localagrl;
      if (paramagrj.a == 0) {
        localObject = getContext().getResources().getDrawable(paramagrj.b);
      }
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt, agrj paramagrj)
  {
    if ((this.a != null) && (paramagrj != null))
    {
      if (paramagrj.a == 0) {
        this.a.a(-1);
      }
    }
    else {
      return;
    }
    this.a.a(paramagrj.b);
  }
  
  public void a(int paramInt, agrj paramagrj, agrl paramagrl)
  {
    if (paramagrl.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = null;
      if (paramagrj.a != 1) {
        break label89;
      }
      localObject = agpy.a().a(1, paramagrj.b);
      paramagrl.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (AppSetting.c) {
        if (paramInt != 0) {
          break label115;
        }
      }
    }
    label89:
    label115:
    for (Object localObject = anzj.a(2131704161);; localObject = anzj.a(2131704160) + paramInt)
    {
      paramagrl.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      if (paramagrl.jdField_a_of_type_AndroidViewView != null)
      {
        if (!paramagrj.a()) {
          break label142;
        }
        paramagrl.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      if (paramagrj.a != 0) {
        break;
      }
      localObject = getContext().getResources().getDrawable(paramagrj.b);
      break;
    }
    label142:
    paramagrl.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    agrj localagrj = (agrj)a(i);
    QQAppInterface localQQAppInterface;
    if (localagrj != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != localagrj.a) {
        break label89;
      }
      bdll.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, localagrj.b, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label89:
      bdll.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, 0, "", "", "", "");
    }
  }
  
  public void setListener(agrk paramagrk)
  {
    this.a = paramagrk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker
 * JD-Core Version:    0.7.0.1
 */