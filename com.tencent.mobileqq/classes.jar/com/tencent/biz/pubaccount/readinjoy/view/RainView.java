package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import aybg;
import aybi;
import aybk;
import ayck;
import aycn;
import bawz;
import bbdr;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import ral;
import ram;
import ran;

public class RainView
  extends SpriteGLView
  implements Runnable
{
  private static int jdField_a_of_type_Int = 4000;
  private static int jdField_b_of_type_Int = 200;
  private static int d = 100;
  private static int e = 3;
  private static int f = 6;
  private Context jdField_a_of_type_AndroidContentContext;
  private aycn jdField_a_of_type_Aycn;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private ran jdField_a_of_type_Ran;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public RainView(Context paramContext)
  {
    super(paramContext, 1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  private int a(int paramInt)
  {
    switch (new Random().nextInt(5))
    {
    default: 
      return paramInt;
    case 0: 
      return (int)(paramInt - this.k * Math.tan(0.174532925199433D));
    case 1: 
      return (int)(paramInt - this.k * Math.tan(0.349065850398866D));
    case 2: 
      return (int)(paramInt + this.k * Math.tan(0.174532925199433D));
    }
    return (int)(paramInt + this.k * Math.tan(0.349065850398866D));
  }
  
  private Bitmap a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists()))
    {
      paramString = null;
      return paramString;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    bbdr.a(paramString, (BitmapFactory.Options)localObject);
    int i2 = ((BitmapFactory.Options)localObject).outHeight;
    int m = ((BitmapFactory.Options)localObject).outWidth;
    int n = bawz.a(getContext(), 80.0F);
    int i1 = bawz.a(getContext(), 80.0F);
    if ((i2 > n) || (m > i1))
    {
      i2 /= 2;
      int i3 = m / 2;
      m = 2;
      while ((i2 / m >= n) && (i3 / m >= i1)) {
        m *= 2;
      }
      n = m;
      if (QLog.isColorLevel()) {
        QLog.d("SpriteGLView", 2, "inSampleSize = " + m);
      }
    }
    for (n = m;; n = 1) {
      for (;;)
      {
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
        ((BitmapFactory.Options)localObject).inSampleSize = n;
        ((BitmapFactory.Options)localObject).inTargetDensity = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
        ((BitmapFactory.Options)localObject).inDensity = 320;
        ((BitmapFactory.Options)localObject).inScaled = true;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        try
        {
          localObject = bbdr.a(paramString, (BitmapFactory.Options)localObject);
          paramString = (String)localObject;
          if (localObject != null) {
            break;
          }
          QLog.e("SpriteGLView", 1, "getPngDrawable bitmap = null");
          return null;
        }
        catch (OutOfMemoryError paramString)
        {
          QLog.e("SpriteGLView", 1, "getPngDrawable oom = " + paramString);
          return null;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    int m = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    if (m == 1)
    {
      paramString = a(paramString);
      if (paramString != null) {
        this.jdField_a_of_type_Aycn = new aycn(this, paramString);
      }
      if (this.jdField_a_of_type_Aycn != null)
      {
        this.g = (paramInt1 / e);
        this.h = paramInt2;
        this.i = (bawz.a(getContext(), 20.0F) + paramInt3);
        this.k = (paramInt3 - paramInt2);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
        b(this);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpriteGLView", 2, "rain animation run initCount = " + m + " mTexture = " + this.jdField_a_of_type_Aycn);
      }
      return;
      if ((m > 1) && (this.jdField_a_of_type_Aycn != null)) {
        b(this);
      }
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "rain animation run mLoopNum = " + this.j);
    }
    if (this.j >= f)
    {
      this.j = 0;
      return;
    }
    int m = 0;
    while (m < e)
    {
      ayck localayck = new ayck(this);
      localayck.a(this.jdField_a_of_type_Aycn);
      localayck.e = ((new Random().nextInt(2) * 2 + 8) / 10.0F);
      int n = this.h - new Random().nextInt(bawz.a(getContext(), d));
      int i1 = this.i;
      int i2 = this.g * m + new Random().nextInt(this.g + 1);
      localayck.a(i2, n);
      Object localObject = new aybk(jdField_a_of_type_Int, i2, n, a(i2), i1);
      localayck.a(new aybg[] { localObject });
      ((aybk)localObject).a(new ral(this, localayck));
      if (m == 0)
      {
        localObject = new aybi(jdField_b_of_type_Int);
        localayck.a(new aybg[] { localObject });
        ((aybi)localObject).a(new ram(this));
      }
      a(localayck);
      m += 1;
    }
    this.j += 1;
  }
  
  public void setAnimationEndListener(ran paramran)
  {
    this.jdField_a_of_type_Ran = paramran;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RainView
 * JD-Core Version:    0.7.0.1
 */