package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.qphone.base.util.QLog;

public class SideBarView
  extends BezierSideBarView
{
  private String a;
  
  public SideBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SideBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SideBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    int j = super.a();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  public int b()
  {
    int j = super.b();
    int i = j;
    if (j > getMeasuredHeight()) {
      i = getMeasuredHeight();
    }
    return i;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    }
    super.onDraw(paramCanvas);
  }
  
  public void setBgColor(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      int i = Color.parseColor(paramString);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("ProteusRecycleView", 1, "", paramString);
    }
  }
  
  public void setPath(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label64;
      }
      Drawable localDrawable = getContext().getResources().getDrawable(2130843321);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = DrawableUtil.getDrawable(getContext(), paramString, localDrawable, localDrawable);
    }
    label64:
    do
    {
      return;
      paramString = ImageCommon.getDrawableResourceId(paramString);
    } while (paramString == null);
    QLog.d("ProteusRecycleView", 2, "loadImage: cant find in offline dir, try to load from resources");
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(paramString.intValue());
      return;
    }
    catch (Resources.NotFoundException paramString)
    {
      QLog.d("ProteusRecycleView", 2, "loadImage: cant find in resources dir, do nothing");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.SideBarView
 * JD-Core Version:    0.7.0.1
 */