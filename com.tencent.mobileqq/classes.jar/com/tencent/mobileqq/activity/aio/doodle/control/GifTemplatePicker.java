package com.tencent.mobileqq.activity.aio.doodle.control;

import afur;
import aggx;
import agii;
import agij;
import agik;
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
import anni;
import bbfb;
import bcst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class GifTemplatePicker
  extends RDBaseListLayout<agii, agik>
  implements View.OnClickListener, bbfb
{
  private agij a;
  
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
    a(new agii(2130837981, 0), false);
    Object localObject = aggx.a().a(1);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!aggx.a().a(1, localInteger.intValue()))
        {
          if (paramBoolean) {
            aggx.a().a(1, localInteger.intValue(), this, this);
          }
        }
        else {
          a(new agii(localInteger.intValue(), 1), false);
        }
      }
    }
  }
  
  public agik a(int paramInt, agii paramagii)
  {
    agik localagik = new agik();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(afur.a(50.0F, getResources()), afur.a(37.0F, getResources())));
    localagik.a(localRelativeLayout);
    localagik.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = new RelativeLayout.LayoutParams(afur.a(40.0F, getResources()), afur.a(27.0F, getResources()));
    paramInt = afur.a(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    localagik.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = null;
    if (paramagii.a == 1) {
      localObject = aggx.a().a(1, paramagii.b);
    }
    for (;;)
    {
      localagik.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localagik.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localRelativeLayout.addView(localagik.jdField_a_of_type_AndroidWidgetImageView);
      localagik.jdField_a_of_type_AndroidViewView = new View(getContext());
      localagik.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localagik.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1427313428);
      localagik.jdField_a_of_type_AndroidViewView.setClickable(false);
      localRelativeLayout.addView(localagik.jdField_a_of_type_AndroidViewView, 0);
      return localagik;
      if (paramagii.a == 0) {
        localObject = getContext().getResources().getDrawable(paramagii.b);
      }
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt, agii paramagii)
  {
    if ((this.a != null) && (paramagii != null))
    {
      if (paramagii.a == 0) {
        this.a.a(-1);
      }
    }
    else {
      return;
    }
    this.a.a(paramagii.b);
  }
  
  public void a(int paramInt, agii paramagii, agik paramagik)
  {
    if (paramagik.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = null;
      if (paramagii.a != 1) {
        break label89;
      }
      localObject = aggx.a().a(1, paramagii.b);
      paramagik.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (AppSetting.c) {
        if (paramInt != 0) {
          break label115;
        }
      }
    }
    label89:
    label115:
    for (Object localObject = anni.a(2131704054);; localObject = anni.a(2131704053) + paramInt)
    {
      paramagik.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      if (paramagik.jdField_a_of_type_AndroidViewView != null)
      {
        if (!paramagii.a()) {
          break label142;
        }
        paramagik.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      if (paramagii.a != 0) {
        break;
      }
      localObject = getContext().getResources().getDrawable(paramagii.b);
      break;
    }
    label142:
    paramagik.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    agii localagii = (agii)a(i);
    QQAppInterface localQQAppInterface;
    if (localagii != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 != localagii.a) {
        break label89;
      }
      bcst.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, localagii.b, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label89:
      bcst.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, 0, "", "", "", "");
    }
  }
  
  public void setListener(agij paramagij)
  {
    this.a = paramagij;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker
 * JD-Core Version:    0.7.0.1
 */