package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import obj;
import pbp;
import rct;
import rcw;

public class NativeReadInjoyImageView
  extends KandianUrlImageView
  implements IView
{
  private static Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private URL jdField_a_of_type_JavaNetURL;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  public NativeReadInjoyImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Rct.a(false);
  }
  
  public NativeReadInjoyImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Rct.a(false);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rcw localrcw = this.jdField_a_of_type_Rct.a();
    if ((localrcw == null) || (localrcw.jdField_a_of_type_Boolean)) {
      setImageSrc(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((this.d > 0) || (this.c > 0) || (this.jdField_a_of_type_Int > 0) || (this.jdField_b_of_type_Int > 0)) {
      VirtualViewUtils.clipCanvas(paramCanvas, getWidth(), getHeight(), 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.d, this.c);
    }
    super.onDraw(paramCanvas);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    rcw localrcw = this.jdField_a_of_type_Rct.a();
    if ((localrcw == null) || (localrcw.jdField_a_of_type_Boolean)) {
      setImageSrc(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void setCorner(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt4;
    this.d = paramInt3;
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_JavaLangString, paramDrawable);
      QLog.d("NativeReadInjoyImageView", 2, "setImageDrawable: path is " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Boolean) {
      paramBoolean = false;
    }
    super.setImageDrawable(paramDrawable, paramBoolean);
  }
  
  public void setImageSrc(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_Boolean)
        {
          Drawable localDrawable = (Drawable)jdField_a_of_type_JavaUtilMap.get(paramString);
          if (localDrawable != null)
          {
            setImageDrawable(localDrawable);
            return;
          }
        }
        if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) || (this.jdField_a_of_type_JavaNetURL == null))
        {
          this.jdField_a_of_type_JavaLangString = paramString;
          this.jdField_a_of_type_JavaNetURL = new URL(this.jdField_a_of_type_JavaLangString);
          QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | current path changed ");
          QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | mPathUrl :" + this.jdField_a_of_type_JavaNetURL);
          obj.a(this, this.jdField_a_of_type_JavaNetURL, getContext());
          return;
        }
      }
      catch (MalformedURLException paramString)
      {
        this.jdField_a_of_type_JavaNetURL = null;
        return;
      }
      QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | current path unchanged ");
    }
  }
  
  public void setIsCacheIcon(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      setPublicAccountImageDownListener(new pbp(null));
    }
  }
  
  public void setIsClosedoAlphaAniamation(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      a(jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView
 * JD-Core Version:    0.7.0.1
 */