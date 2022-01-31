package com.tencent.mobileqq.activity.aio.doodle.control;

import aekt;
import aevw;
import aexh;
import aexi;
import aexj;
import alpo;
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
import ayck;
import azmj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GifTemplatePicker
  extends RDBaseListLayout<aexh, aexj>
  implements View.OnClickListener, ayck
{
  private aexi a;
  
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
    a(new aexh(2130837749, 0), false);
    Object localObject = aevw.a().a(1);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!aevw.a().a(1, localInteger.intValue()))
        {
          if (paramBoolean) {
            aevw.a().a(1, localInteger.intValue(), this, this);
          }
        }
        else {
          a(new aexh(localInteger.intValue(), 1), false);
        }
      }
    }
  }
  
  public aexj a(int paramInt, aexh paramaexh)
  {
    aexj localaexj = new aexj();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(aekt.a(50.0F, getResources()), aekt.a(37.0F, getResources())));
    localaexj.a(localRelativeLayout);
    localaexj.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = new RelativeLayout.LayoutParams(aekt.a(40.0F, getResources()), aekt.a(27.0F, getResources()));
    paramInt = aekt.a(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    localaexj.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = null;
    if (paramaexh.a == 1) {
      localObject = aevw.a().a(1, paramaexh.b);
    }
    for (;;)
    {
      localaexj.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localaexj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localRelativeLayout.addView(localaexj.jdField_a_of_type_AndroidWidgetImageView);
      localaexj.jdField_a_of_type_AndroidViewView = new View(getContext());
      localaexj.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localaexj.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1427313428);
      localaexj.jdField_a_of_type_AndroidViewView.setClickable(false);
      localRelativeLayout.addView(localaexj.jdField_a_of_type_AndroidViewView, 0);
      return localaexj;
      if (paramaexh.a == 0) {
        localObject = getContext().getResources().getDrawable(paramaexh.b);
      }
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt, aexh paramaexh)
  {
    if ((this.a != null) && (paramaexh != null))
    {
      if (paramaexh.a == 0) {
        this.a.a(-1);
      }
    }
    else {
      return;
    }
    this.a.a(paramaexh.b);
  }
  
  public void a(int paramInt, aexh paramaexh, aexj paramaexj)
  {
    if (paramaexj.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = null;
      if (paramaexh.a != 1) {
        break label89;
      }
      localObject = aevw.a().a(1, paramaexh.b);
      paramaexj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (AppSetting.c) {
        if (paramInt != 0) {
          break label115;
        }
      }
    }
    label89:
    label115:
    for (Object localObject = alpo.a(2131705647);; localObject = alpo.a(2131705646) + paramInt)
    {
      paramaexj.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      if (paramaexj.jdField_a_of_type_AndroidViewView != null)
      {
        if (!paramaexh.a()) {
          break label142;
        }
        paramaexj.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      if (paramaexh.a != 0) {
        break;
      }
      localObject = getContext().getResources().getDrawable(paramaexh.b);
      break;
    }
    label142:
    paramaexj.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    paramView = (aexh)a(i);
    QQAppInterface localQQAppInterface;
    if (paramView != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 == paramView.a) {
        azmj.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, paramView.b, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    azmj.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, 0, "", "", "", "");
  }
  
  public void setListener(aexi paramaexi)
  {
    this.a = paramaexi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker
 * JD-Core Version:    0.7.0.1
 */