package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.qphone.base.util.QLog;

public class RegionView
  extends View
{
  int jdField_a_of_type_Int;
  final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private PortraitImageview jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview;
  boolean jdField_a_of_type_Boolean;
  Rect[] jdField_a_of_type_ArrayOfAndroidGraphicsRect;
  int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect;
  int c;
  int d;
  int e;
  
  public RegionView(Context paramContext, PortraitImageview paramPortraitImageview, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramContext);
    paramPortraitImageview.setRegionView(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview = paramPortraitImageview;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public Bitmap a()
  {
    Matrix localMatrix = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
    localMatrix.postTranslate(-((RectF)localObject).left, -((RectF)localObject).top);
    localMatrix.postScale(this.c / ((RectF)localObject).width(), this.d / ((RectF)localObject).height(), 0.0F, 0.0F);
    int i = this.c;
    int j = this.d;
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
      if ((localObject != null) && (localBitmap != null)) {
        new Canvas((Bitmap)localObject).drawBitmap(localBitmap, localMatrix, new Paint(6));
      }
      return localObject;
    }
  }
  
  public Rect a()
  {
    int j = 0;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
    Matrix localMatrix = new Matrix();
    ((Matrix)localObject2).invert(localMatrix);
    localObject2 = new RectF();
    localMatrix.mapRect((RectF)localObject2, (RectF)localObject1);
    if (QLog.isColorLevel()) {
      QLog.i("RegionView", 2, String.format("getClipInfo src=[%.0f,%.0f,%.0f,%.0f],dst=[%.0f,%.0f,%.0f,%.0f],[tW,tH]=[%d,%d]", new Object[] { Float.valueOf(((RectF)localObject1).left), Float.valueOf(((RectF)localObject1).top), Float.valueOf(((RectF)localObject1).right), Float.valueOf(((RectF)localObject1).bottom), Float.valueOf(((RectF)localObject2).left), Float.valueOf(((RectF)localObject2).top), Float.valueOf(((RectF)localObject2).right), Float.valueOf(((RectF)localObject2).bottom), Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) }));
    }
    localObject1 = new Rect();
    ((RectF)localObject2).round((Rect)localObject1);
    if (((Rect)localObject1).left < 0)
    {
      i = 0;
      ((Rect)localObject1).left = i;
      if (((Rect)localObject1).top >= 0) {
        break label304;
      }
      i = j;
      label240:
      ((Rect)localObject1).top = i;
      if (((Rect)localObject1).right <= localBitmap.getWidth()) {
        break label313;
      }
      i = localBitmap.getWidth();
      label263:
      ((Rect)localObject1).right = i;
      if (((Rect)localObject1).bottom <= localBitmap.getHeight()) {
        break label322;
      }
    }
    label304:
    label313:
    label322:
    for (int i = localBitmap.getHeight();; i = ((Rect)localObject1).bottom)
    {
      ((Rect)localObject1).bottom = i;
      return localObject1;
      i = ((Rect)localObject1).left;
      break;
      i = ((Rect)localObject1).top;
      break label240;
      i = ((Rect)localObject1).right;
      break label263;
    }
  }
  
  public Bitmap b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.b();
    }
    this.jdField_a_of_type_AndroidGraphicsRect.left = ((getWidth() - this.jdField_a_of_type_Int) / 2);
    this.jdField_a_of_type_AndroidGraphicsRect.right = ((getWidth() + this.jdField_a_of_type_Int) / 2);
    this.jdField_a_of_type_AndroidGraphicsRect.top = ((getHeight() - this.jdField_b_of_type_Int) / 2);
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = ((getHeight() + this.jdField_b_of_type_Int) / 2);
    if (this.e == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1711276032);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      localObject = new Path();
      float f = this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.height() * 0.5F;
      ((Path)localObject).moveTo(getWidth(), f);
      ((Path)localObject).addArc(new RectF(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom), 0.0F, -360.0F);
      ((Path)localObject).moveTo(getWidth(), f);
      ((Path)localObject).lineTo(getWidth(), getHeight());
      ((Path)localObject).lineTo(0.0F, getHeight());
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(getWidth(), 0.0F);
      ((Path)localObject).moveTo(getWidth(), f);
      ((Path)localObject).close();
      paramCanvas.drawPath((Path)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1291845632);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(5.0F);
      paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() * 0.5F, f, this.jdField_a_of_type_AndroidGraphicsRect.width() * 0.5F, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
      paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() * 0.5F, f, this.jdField_a_of_type_AndroidGraphicsRect.width() * 0.5F, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    this.jdField_a_of_type_ArrayOfAndroidGraphicsRect = new Rect[] { new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top), new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left, 0, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top), new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right, 0, getWidth(), this.jdField_a_of_type_AndroidGraphicsRect.top), new Rect(0, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom), new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, getWidth(), this.jdField_a_of_type_AndroidGraphicsRect.bottom), new Rect(0, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.left, getHeight()), new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.right, getHeight()), new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom, getWidth(), getHeight()) };
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect);
    Object localObject = this.jdField_b_of_type_AndroidGraphicsRect;
    ((Rect)localObject).left -= 2;
    localObject = this.jdField_b_of_type_AndroidGraphicsRect;
    ((Rect)localObject).right += 2;
    localObject = this.jdField_b_of_type_AndroidGraphicsRect;
    ((Rect)localObject).top -= 2;
    localObject = this.jdField_b_of_type_AndroidGraphicsRect;
    ((Rect)localObject).bottom += 2;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1711276032);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAndroidGraphicsRect.length)
    {
      paramCanvas.drawRect(this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[i], this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(5.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1291845632);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.RegionView
 * JD-Core Version:    0.7.0.1
 */