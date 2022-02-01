package com.tencent.mobileqq.activity.aio.anim;

import agce;
import agcf;
import android.annotation.TargetApi;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import bgjw;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class VipPngPlayAnimationDrawable
  extends Drawable
  implements Runnable
{
  public int a;
  public agce a;
  public agcf a;
  public Resources a;
  public Bitmap a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Handler a;
  public Object a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public int f;
  public int g;
  public int h;
  private int i = -1;
  private int j;
  
  public VipPngPlayAnimationDrawable(Resources paramResources)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 50;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Agce = new agce();
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == this.j - 1)
    {
      this.f -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  @TargetApi(11)
  public Bitmap a(int paramInt1, Object paramObject, int paramInt2)
  {
    Object localObject = new BitmapFactory.Options();
    switch (paramInt1)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      paramObject = (int[])paramObject;
      paramInt1 = paramObject[((paramInt2 + 1) % paramObject.length)];
      return BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, paramInt1, (BitmapFactory.Options)localObject);
    }
    paramObject = (String[])paramObject;
    paramObject = paramObject[((paramInt2 + 1) % paramObject.length)];
    ((BitmapFactory.Options)localObject).inDensity = 320;
    ((BitmapFactory.Options)localObject).inTargetDensity = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
    if (paramObject.startsWith("file:///android_assets/bubbles/"))
    {
      paramObject = paramObject.substring("file:///android_assets/".length());
      paramObject = new BufferedInputStream(this.jdField_a_of_type_AndroidContentResResources.getAssets().open(paramObject));
    }
    for (;;)
    {
      localObject = BitmapFactory.decodeStream(paramObject, null, (BitmapFactory.Options)localObject);
      if (paramObject != null) {}
      try
      {
        paramObject.close();
        return localObject;
        paramObject = new BufferedInputStream(new FileInputStream(paramObject));
      }
      catch (IOException paramObject)
      {
        for (;;)
        {
          paramObject.printStackTrace();
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agce != null) {
      this.jdField_a_of_type_Agce.a();
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_a_of_type_Agcf != null)
    {
      this.jdField_a_of_type_Agcf.cancel(false);
      this.jdField_a_of_type_Agcf = null;
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 50;
    this.f = -1;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      super.invalidateSelf();
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if ((this.jdField_a_of_type_Int == 0) && (Arrays.equals((String[])this.jdField_a_of_type_JavaLangObject, paramArrayOfString))) {
      return;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    String str = paramArrayOfString[0];
    if (str.startsWith("file:///android_assets/bubbles/"))
    {
      paramArrayOfString = str.substring("file:///android_assets/".length());
      paramArrayOfString = this.jdField_a_of_type_AndroidContentResResources.getAssets().open(paramArrayOfString);
      BitmapFactory.decodeStream(paramArrayOfString, null, localOptions);
      if (paramArrayOfString == null) {}
    }
    for (;;)
    {
      try
      {
        paramArrayOfString.close();
        this.jdField_d_of_type_Int = bgjw.a(localOptions.outWidth, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
        this.e = bgjw.a(localOptions.outHeight, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
        this.g = this.jdField_d_of_type_Int;
        this.h = this.e;
        return;
      }
      catch (IOException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        continue;
      }
      paramArrayOfString = new BufferedInputStream(new FileInputStream(paramArrayOfString[0]));
      BitmapFactory.decodeStream(paramArrayOfString, null, localOptions);
      paramArrayOfString.close();
    }
  }
  
  public void a(String[] paramArrayOfString, int paramInt)
  {
    if ((this.jdField_a_of_type_Int == 0) && (Arrays.equals((String[])this.jdField_a_of_type_JavaLangObject, paramArrayOfString))) {
      return;
    }
    a();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangObject = paramArrayOfString;
    this.j = paramArrayOfString.length;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    return (!this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int >= 0);
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int >= 0)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.jdField_c_of_type_Int);
    }
    while ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_Agcf = new agcf(this, this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_Agcf.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.jdField_b_of_type_Int), Long.valueOf(this.jdField_a_of_type_Int) });
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == -1) {
      return;
    }
    Rect localRect2;
    int k;
    if (this.jdField_b_of_type_Int != -1)
    {
      localRect2 = super.getBounds();
      if (!this.jdField_c_of_type_Boolean) {
        break label192;
      }
      k = paramCanvas.save();
      paramCanvas.scale(-1.0F, 1.0F, localRect2.centerX(), localRect2.centerY());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 1) {}
      label100:
      while (((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 2)) || (this.jdField_a_of_type_Agce == null))
      {
        if (this.jdField_c_of_type_Boolean) {
          paramCanvas.restoreToCount(k);
        }
        if (this.f != 0) {
          break label182;
        }
        if ((102 != this.i) && (103 != this.i)) {
          break;
        }
        super.invalidateSelf();
        this.jdField_d_of_type_Boolean = true;
        return;
      }
      if (this.g > 0) {}
      for (Rect localRect1 = new Rect(0, 0, this.g, getIntrinsicHeight());; localRect1 = null)
      {
        this.jdField_a_of_type_Agce.a(paramCanvas, localRect1, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
        break;
        a();
        break label100;
        label182:
        b();
        return;
      }
      label192:
      k = 0;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.e;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Int = a(this.jdField_b_of_type_Int);
    } while ((this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_Agce.jdField_a_of_type_AndroidGraphicsBitmap == this.jdField_a_of_type_AndroidGraphicsBitmap));
    this.jdField_a_of_type_Agce.a();
    this.jdField_a_of_type_Agce.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    super.invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */