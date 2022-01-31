package com.tencent.mobileqq.activity.aio.doodle.control;

import aciy;
import acte;
import acup;
import acuq;
import acur;
import ajjy;
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
import avhl;
import awqx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GifTemplatePicker
  extends RDBaseListLayout<acup, acur>
  implements View.OnClickListener, avhl
{
  private acuq a;
  
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
    a(new acup(2130837684, 0), false);
    Object localObject = acte.a().a(1);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!acte.a().a(1, localInteger.intValue()))
        {
          if (paramBoolean) {
            acte.a().a(1, localInteger.intValue(), this, this);
          }
        }
        else {
          a(new acup(localInteger.intValue(), 1), false);
        }
      }
    }
  }
  
  public acur a(int paramInt, acup paramacup)
  {
    acur localacur = new acur();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(aciy.a(50.0F, getResources()), aciy.a(37.0F, getResources())));
    localacur.a(localRelativeLayout);
    localacur.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = new RelativeLayout.LayoutParams(aciy.a(40.0F, getResources()), aciy.a(27.0F, getResources()));
    paramInt = aciy.a(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    localacur.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = null;
    if (paramacup.a == 1) {
      localObject = acte.a().a(1, paramacup.b);
    }
    for (;;)
    {
      localacur.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localacur.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localRelativeLayout.addView(localacur.jdField_a_of_type_AndroidWidgetImageView);
      localacur.jdField_a_of_type_AndroidViewView = new View(getContext());
      localacur.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localacur.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1427313428);
      localacur.jdField_a_of_type_AndroidViewView.setClickable(false);
      localRelativeLayout.addView(localacur.jdField_a_of_type_AndroidViewView, 0);
      return localacur;
      if (paramacup.a == 0) {
        localObject = getContext().getResources().getDrawable(paramacup.b);
      }
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt, acup paramacup)
  {
    if ((this.a != null) && (paramacup != null))
    {
      if (paramacup.a == 0) {
        this.a.a(-1);
      }
    }
    else {
      return;
    }
    this.a.a(paramacup.b);
  }
  
  public void a(int paramInt, acup paramacup, acur paramacur)
  {
    if (paramacur.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = null;
      if (paramacup.a != 1) {
        break label89;
      }
      localObject = acte.a().a(1, paramacup.b);
      paramacur.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (AppSetting.c) {
        if (paramInt != 0) {
          break label115;
        }
      }
    }
    label89:
    label115:
    for (Object localObject = ajjy.a(2131639479);; localObject = ajjy.a(2131639478) + paramInt)
    {
      paramacur.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      if (paramacur.jdField_a_of_type_AndroidViewView != null)
      {
        if (!paramacup.a()) {
          break label142;
        }
        paramacur.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      if (paramacup.a != 0) {
        break;
      }
      localObject = getContext().getResources().getDrawable(paramacup.b);
      break;
    }
    label142:
    paramacur.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    paramView = (acup)a(i);
    QQAppInterface localQQAppInterface;
    if (paramView != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 == paramView.a) {
        awqx.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, paramView.b, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    awqx.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, 0, "", "", "", "");
  }
  
  public void setListener(acuq paramacuq)
  {
    this.a = paramacuq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker
 * JD-Core Version:    0.7.0.1
 */