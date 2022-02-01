package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import ozc;
import qea;
import sul;
import suo;
import txb;

public class NativeReadInjoyImageView
  extends KandianUrlImageView
  implements IView
{
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  private static Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  public NativeReadInjoyImageView(Context paramContext)
  {
    super(paramContext);
    this.mController.a(false);
  }
  
  public NativeReadInjoyImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mController.a(false);
  }
  
  public NativeReadInjoyImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mController.a(false);
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
    suo localsuo = this.mController.a();
    if (((localsuo == null) || (localsuo.jdField_a_of_type_Boolean)) && (this.jdField_a_of_type_JavaLangString != null)) {
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
    suo localsuo = this.mController.a();
    if (((localsuo == null) || (localsuo.jdField_a_of_type_Boolean)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
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
    try
    {
      Object localObject;
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = (Drawable)jdField_a_of_type_JavaUtilMap.get(paramString);
        if (localObject != null)
        {
          setImageDrawable((Drawable)localObject);
          return;
        }
      }
      if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)))
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | current path changed ");
      }
      for (;;)
      {
        URL localURL = txb.a.a(this.jdField_a_of_type_JavaLangString);
        localObject = localURL;
        if (localURL == null)
        {
          localObject = new URL(paramString);
          txb.a.a((URL)localObject);
        }
        QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | mPathUrl :" + this.jdField_a_of_type_JavaLangString);
        if (!ozc.a(getContext(), (URL)localObject)) {
          break;
        }
        setImageResource(2130841690);
        return;
        QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | current path unchanged ");
      }
      setImage((URL)localObject);
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  public void setIsCacheIcon(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      setPublicAccountImageDownListener(new qea(null));
    }
  }
  
  public void setIsClosedoAlphaAniamation(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      setImagePlaceHolder(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView
 * JD-Core Version:    0.7.0.1
 */