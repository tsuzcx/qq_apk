package com.tencent.mobileqq.activity.aio.doodle.control;

import aepi;
import afal;
import afbw;
import afbx;
import afby;
import alud;
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
import aygt;
import azqs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GifTemplatePicker
  extends RDBaseListLayout<afbw, afby>
  implements View.OnClickListener, aygt
{
  private afbx a;
  
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
    a(new afbw(2130837750, 0), false);
    Object localObject = afal.a().a(1);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!afal.a().a(1, localInteger.intValue()))
        {
          if (paramBoolean) {
            afal.a().a(1, localInteger.intValue(), this, this);
          }
        }
        else {
          a(new afbw(localInteger.intValue(), 1), false);
        }
      }
    }
  }
  
  public afby a(int paramInt, afbw paramafbw)
  {
    afby localafby = new afby();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(aepi.a(50.0F, getResources()), aepi.a(37.0F, getResources())));
    localafby.a(localRelativeLayout);
    localafby.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = new RelativeLayout.LayoutParams(aepi.a(40.0F, getResources()), aepi.a(27.0F, getResources()));
    paramInt = aepi.a(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    localafby.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = null;
    if (paramafbw.a == 1) {
      localObject = afal.a().a(1, paramafbw.b);
    }
    for (;;)
    {
      localafby.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localafby.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localRelativeLayout.addView(localafby.jdField_a_of_type_AndroidWidgetImageView);
      localafby.jdField_a_of_type_AndroidViewView = new View(getContext());
      localafby.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localafby.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1427313428);
      localafby.jdField_a_of_type_AndroidViewView.setClickable(false);
      localRelativeLayout.addView(localafby.jdField_a_of_type_AndroidViewView, 0);
      return localafby;
      if (paramafbw.a == 0) {
        localObject = getContext().getResources().getDrawable(paramafbw.b);
      }
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt, afbw paramafbw)
  {
    if ((this.a != null) && (paramafbw != null))
    {
      if (paramafbw.a == 0) {
        this.a.a(-1);
      }
    }
    else {
      return;
    }
    this.a.a(paramafbw.b);
  }
  
  public void a(int paramInt, afbw paramafbw, afby paramafby)
  {
    if (paramafby.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = null;
      if (paramafbw.a != 1) {
        break label89;
      }
      localObject = afal.a().a(1, paramafbw.b);
      paramafby.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (AppSetting.c) {
        if (paramInt != 0) {
          break label115;
        }
      }
    }
    label89:
    label115:
    for (Object localObject = alud.a(2131705659);; localObject = alud.a(2131705658) + paramInt)
    {
      paramafby.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      if (paramafby.jdField_a_of_type_AndroidViewView != null)
      {
        if (!paramafbw.a()) {
          break label142;
        }
        paramafby.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      if (paramafbw.a != 0) {
        break;
      }
      localObject = getContext().getResources().getDrawable(paramafbw.b);
      break;
    }
    label142:
    paramafby.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    paramView = (afbw)a(i);
    QQAppInterface localQQAppInterface;
    if (paramView != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 == paramView.a) {
        azqs.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, paramView.b, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    azqs.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, 0, "", "", "", "");
  }
  
  public void setListener(afbx paramafbx)
  {
    this.a = paramafbx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker
 * JD-Core Version:    0.7.0.1
 */