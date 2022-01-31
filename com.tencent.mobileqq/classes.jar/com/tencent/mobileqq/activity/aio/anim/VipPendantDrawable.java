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
import usw;

public class VipPendantDrawable
  extends Drawable
{
  protected int a;
  Resources jdField_a_of_type_AndroidContentResResources;
  public Paint a;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  VipPendantDrawable.MutilePlayInfo jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPendantDrawable$MutilePlayInfo;
  protected Object a;
  protected int b = 50;
  
  public VipPendantDrawable(Resources paramResources)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.b = 50;
  }
  
  public void a(VipPendantDrawable.MutilePlayInfo paramMutilePlayInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPendantDrawable$MutilePlayInfo = paramMutilePlayInfo;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof usw)) && (((usw)this.jdField_a_of_type_JavaLangObject).a != null) && (this.jdField_a_of_type_Int == 1) && (((usw)this.jdField_a_of_type_JavaLangObject).a.equals(paramString))) {
      return;
    }
    a();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangObject = new usw(this, paramString);
  }
  
  public void a(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_JavaLangObject != null) && (!(this.jdField_a_of_type_JavaLangObject instanceof usw)))
        {
          boolean bool = Arrays.equals((String[])this.jdField_a_of_type_JavaLangObject, paramArrayOfString);
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("VipPendantDrawable", 1, "setPngPaths, exception=" + MsfSdkUtils.getStackTraceString(localException));
        }
      }
    }
    a();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangObject = paramArrayOfString;
    this.b = paramInt;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == -1) {}
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPendantDrawable$MutilePlayInfo == null);
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPendantDrawable$MutilePlayInfo.a();
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    paramCanvas.drawBitmap(localBitmap, null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable
 * JD-Core Version:    0.7.0.1
 */