package com.tencent.mobileqq.activity.aio.anim;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class VipPendantDrawable
  extends Drawable
{
  protected int a = -1;
  protected Object b;
  protected Paint c = new Paint(6);
  protected int d = 50;
  Handler e = new Handler(Looper.getMainLooper());
  Resources f;
  VipPendantDrawable.MutilePlayInfo g;
  
  public VipPendantDrawable(Resources paramResources)
  {
    this.f = paramResources;
  }
  
  public void a()
  {
    this.a = -1;
    this.d = 50;
  }
  
  public void a(VipPendantDrawable.MutilePlayInfo paramMutilePlayInfo)
  {
    this.g = paramMutilePlayInfo;
  }
  
  public void a(String paramString)
  {
    Object localObject = this.b;
    if ((localObject != null) && ((localObject instanceof VipPendantDrawable.SourcesBigPng)) && (((VipPendantDrawable.SourcesBigPng)localObject).a != null) && (this.a == 1) && (((VipPendantDrawable.SourcesBigPng)this.b).a.equals(paramString))) {
      return;
    }
    a();
    this.a = 1;
    this.b = new VipPendantDrawable.SourcesBigPng(this, paramString);
  }
  
  public void a(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString == null) {
      return;
    }
    try
    {
      if ((this.a == 0) && (this.b != null) && (!(this.b instanceof VipPendantDrawable.SourcesBigPng)))
      {
        boolean bool = Arrays.equals((String[])this.b, paramArrayOfString);
        if (bool) {
          return;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPngPaths, exception=");
      localStringBuilder.append(MsfSdkUtils.getStackTraceString(localException));
      QLog.e("VipPendantDrawable", 1, localStringBuilder.toString());
      a();
      this.a = 0;
      this.b = paramArrayOfString;
      this.d = paramInt;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a == -1) {
      return;
    }
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((VipPendantDrawable.MutilePlayInfo)localObject).a();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramCanvas.drawBitmap((Bitmap)localObject, null, getBounds(), this.c);
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.c.getAlpha())
    {
      this.c.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.c.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.c.setDither(paramBoolean);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable
 * JD-Core Version:    0.7.0.1
 */