package com.tencent.mobileqq.activity.aio.doodle.control;

import actj;
import addu;
import adff;
import adfg;
import adfh;
import ajya;
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
import awhg;
import axqy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GifTemplatePicker
  extends RDBaseListLayout<adff, adfh>
  implements View.OnClickListener, awhg
{
  private adfg a;
  
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
    a(new adff(2130837694, 0), false);
    Object localObject = addu.a().a(1);
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (!addu.a().a(1, localInteger.intValue()))
        {
          if (paramBoolean) {
            addu.a().a(1, localInteger.intValue(), this, this);
          }
        }
        else {
          a(new adff(localInteger.intValue(), 1), false);
        }
      }
    }
  }
  
  public adfh a(int paramInt, adff paramadff)
  {
    adfh localadfh = new adfh();
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setOnClickListener(this);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(actj.a(50.0F, getResources()), actj.a(37.0F, getResources())));
    localadfh.a(localRelativeLayout);
    localadfh.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    Object localObject = new RelativeLayout.LayoutParams(actj.a(40.0F, getResources()), actj.a(27.0F, getResources()));
    paramInt = actj.a(5.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    localadfh.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = null;
    if (paramadff.a == 1) {
      localObject = addu.a().a(1, paramadff.b);
    }
    for (;;)
    {
      localadfh.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localadfh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localRelativeLayout.addView(localadfh.jdField_a_of_type_AndroidWidgetImageView);
      localadfh.jdField_a_of_type_AndroidViewView = new View(getContext());
      localadfh.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localadfh.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1427313428);
      localadfh.jdField_a_of_type_AndroidViewView.setClickable(false);
      localRelativeLayout.addView(localadfh.jdField_a_of_type_AndroidViewView, 0);
      return localadfh;
      if (paramadff.a == 0) {
        localObject = getContext().getResources().getDrawable(paramadff.b);
      }
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt, adff paramadff)
  {
    if ((this.a != null) && (paramadff != null))
    {
      if (paramadff.a == 0) {
        this.a.a(-1);
      }
    }
    else {
      return;
    }
    this.a.a(paramadff.b);
  }
  
  public void a(int paramInt, adff paramadff, adfh paramadfh)
  {
    if (paramadfh.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = null;
      if (paramadff.a != 1) {
        break label89;
      }
      localObject = addu.a().a(1, paramadff.b);
      paramadfh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (AppSetting.d) {
        if (paramInt != 0) {
          break label115;
        }
      }
    }
    label89:
    label115:
    for (Object localObject = ajya.a(2131705275);; localObject = ajya.a(2131705274) + paramInt)
    {
      paramadfh.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      if (paramadfh.jdField_a_of_type_AndroidViewView != null)
      {
        if (!paramadff.a()) {
          break label142;
        }
        paramadfh.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
      if (paramadff.a != 0) {
        break;
      }
      localObject = getContext().getResources().getDrawable(paramadff.b);
      break;
    }
    label142:
    paramadfh.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    paramView = (adff)a(i);
    QQAppInterface localQQAppInterface;
    if (paramView != null)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (1 == paramView.a) {
        axqy.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, paramView.b, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    axqy.b(localQQAppInterface, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, 0, "", "", "", "");
  }
  
  public void setListener(adfg paramadfg)
  {
    this.a = paramadfg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker
 * JD-Core Version:    0.7.0.1
 */