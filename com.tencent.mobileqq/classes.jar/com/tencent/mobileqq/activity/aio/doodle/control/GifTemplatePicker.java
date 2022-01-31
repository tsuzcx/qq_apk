package com.tencent.mobileqq.activity.aio.doodle.control;

import actn;
import addx;
import adfi;
import adfj;
import adfk;
import ajyc;
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
import awhe;
import axqw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GifTemplatePicker
  extends RDBaseListLayout<adfi, adfk>
  implements View.OnClickListener, awhe
{
  private adfj a;
  
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
    a(new adfi(2130837694, 0), false);
    Object localObject = addx.a().a(1);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!addx.a().a(1, localInteger.intValue()))
        {
          if (paramBoolean) {
            addx.a().a(1, localInteger.intValue(), this, this);
          }
        }
        else {
          a(new adfi(localInteger.intValue(), 1), false);
        }
      }
    }
  }
  
  public adfk a(int paramInt, adfi paramadfi)
  {
    adfk localadfk = new adfk();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(actn.a(50.0F, getResources()), actn.a(37.0F, getResources())));
    localadfk.a(localRelativeLayout);
    localadfk.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = new RelativeLayout.LayoutParams(actn.a(40.0F, getResources()), actn.a(27.0F, getResources()));
    paramInt = actn.a(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    localadfk.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = null;
    if (paramadfi.a == 1) {
      localObject = addx.a().a(1, paramadfi.b);
    }
    for (;;)
    {
      localadfk.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localadfk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localRelativeLayout.addView(localadfk.jdField_a_of_type_AndroidWidgetImageView);
      localadfk.jdField_a_of_type_AndroidViewView = new View(getContext());
      localadfk.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localadfk.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1427313428);
      localadfk.jdField_a_of_type_AndroidViewView.setClickable(false);
      localRelativeLayout.addView(localadfk.jdField_a_of_type_AndroidViewView, 0);
      return localadfk;
      if (paramadfi.a == 0) {
        localObject = getContext().getResources().getDrawable(paramadfi.b);
      }
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt, adfi paramadfi)
  {
    if ((this.a != null) && (paramadfi != null))
    {
      if (paramadfi.a == 0) {
        this.a.a(-1);
      }
    }
    else {
      return;
    }
    this.a.a(paramadfi.b);
  }
  
  public void a(int paramInt, adfi paramadfi, adfk paramadfk)
  {
    if (paramadfk.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = null;
      if (paramadfi.a != 1) {
        break label89;
      }
      localObject = addx.a().a(1, paramadfi.b);
      paramadfk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (AppSetting.d) {
        if (paramInt != 0) {
          break label115;
        }
      }
    }
    label89:
    label115:
    for (Object localObject = ajyc.a(2131705264);; localObject = ajyc.a(2131705263) + paramInt)
    {
      paramadfk.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      if (paramadfk.jdField_a_of_type_AndroidViewView != null)
      {
        if (!paramadfi.a()) {
          break label142;
        }
        paramadfk.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      if (paramadfi.a != 0) {
        break;
      }
      localObject = getContext().getResources().getDrawable(paramadfi.b);
      break;
    }
    label142:
    paramadfk.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    paramView = (adfi)a(i);
    QQAppInterface localQQAppInterface;
    if (paramView != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 == paramView.a) {
        axqw.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, paramView.b, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    axqw.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, 0, "", "", "", "");
  }
  
  public void setListener(adfj paramadfj)
  {
    this.a = paramadfj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker
 * JD-Core Version:    0.7.0.1
 */