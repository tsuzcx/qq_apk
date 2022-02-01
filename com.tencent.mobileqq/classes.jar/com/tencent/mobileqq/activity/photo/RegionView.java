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
  final Rect a = new Rect();
  final Paint b = new Paint();
  int c;
  int d;
  int e;
  int f;
  int g;
  boolean h;
  Rect[] i;
  Rect j;
  private PortraitImageview k;
  
  public RegionView(Context paramContext, PortraitImageview paramPortraitImageview, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramContext);
    paramPortraitImageview.setRegionView(this);
    this.k = paramPortraitImageview;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramBoolean;
  }
  
  public Bitmap getBitmap()
  {
    Matrix localMatrix = this.k.getImageViewMatrix();
    Object localObject = this.k.getRestrictRect();
    localMatrix.postTranslate(-((RectF)localObject).left, -((RectF)localObject).top);
    localMatrix.postScale(this.e / ((RectF)localObject).width(), this.f / ((RectF)localObject).height(), 0.0F, 0.0F);
    int m = this.e;
    int n = this.f;
    if (this.h) {
      localObject = Bitmap.Config.ARGB_8888;
    } else {
      localObject = Bitmap.Config.RGB_565;
    }
    localObject = Bitmap.createBitmap(m, n, (Bitmap.Config)localObject);
    Bitmap localBitmap = this.k.getImageBitmap();
    if ((localObject != null) && (localBitmap != null)) {
      new Canvas((Bitmap)localObject).drawBitmap(localBitmap, localMatrix, new Paint(6));
    }
    return localObject;
  }
  
  public Rect getClipInfo()
  {
    Object localObject2 = this.k.getImageViewMatrix();
    Object localObject1 = this.k.getRestrictRect();
    Bitmap localBitmap = this.k.getImageBitmap();
    Matrix localMatrix = new Matrix();
    ((Matrix)localObject2).invert(localMatrix);
    localObject2 = new RectF();
    localMatrix.mapRect((RectF)localObject2, (RectF)localObject1);
    boolean bool = QLog.isColorLevel();
    int n = 0;
    if (bool) {
      QLog.i("RegionView", 2, String.format("getClipInfo src=[%.0f,%.0f,%.0f,%.0f],dst=[%.0f,%.0f,%.0f,%.0f],[tW,tH]=[%d,%d]", new Object[] { Float.valueOf(((RectF)localObject1).left), Float.valueOf(((RectF)localObject1).top), Float.valueOf(((RectF)localObject1).right), Float.valueOf(((RectF)localObject1).bottom), Float.valueOf(((RectF)localObject2).left), Float.valueOf(((RectF)localObject2).top), Float.valueOf(((RectF)localObject2).right), Float.valueOf(((RectF)localObject2).bottom), Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) }));
    }
    localObject1 = new Rect();
    ((RectF)localObject2).round((Rect)localObject1);
    int m;
    if (((Rect)localObject1).left < 0) {
      m = 0;
    } else {
      m = ((Rect)localObject1).left;
    }
    ((Rect)localObject1).left = m;
    if (((Rect)localObject1).top < 0) {
      m = n;
    } else {
      m = ((Rect)localObject1).top;
    }
    ((Rect)localObject1).top = m;
    if (((Rect)localObject1).right > localBitmap.getWidth()) {
      m = localBitmap.getWidth();
    } else {
      m = ((Rect)localObject1).right;
    }
    ((Rect)localObject1).right = m;
    if (((Rect)localObject1).bottom > localBitmap.getHeight()) {
      m = localBitmap.getHeight();
    } else {
      m = ((Rect)localObject1).bottom;
    }
    ((Rect)localObject1).bottom = m;
    return localObject1;
  }
  
  public Bitmap getDisplayBmp()
  {
    return this.k.getImageBitmap();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.k;
    if (localObject != null)
    {
      this.c = ((PortraitImageview)localObject).getClipWidth();
      this.d = this.k.getClipHeight();
    }
    this.a.left = ((getWidth() - this.c) / 2);
    this.a.right = ((getWidth() + this.c) / 2);
    this.a.top = ((getHeight() - this.d) / 2);
    this.a.bottom = ((getHeight() + this.d) / 2);
    if (this.g == 0)
    {
      this.b.setColor(1711276032);
      this.b.setStyle(Paint.Style.FILL);
      localObject = new Path();
      float f1 = this.a.top + this.a.height() * 0.5F;
      ((Path)localObject).moveTo(getWidth(), f1);
      ((Path)localObject).addArc(new RectF(this.a.left, this.a.top, this.a.right, this.a.bottom), 0.0F, -360.0F);
      ((Path)localObject).moveTo(getWidth(), f1);
      ((Path)localObject).lineTo(getWidth(), getHeight());
      ((Path)localObject).lineTo(0.0F, getHeight());
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(getWidth(), 0.0F);
      ((Path)localObject).moveTo(getWidth(), f1);
      ((Path)localObject).close();
      paramCanvas.drawPath((Path)localObject, this.b);
      this.b.setAntiAlias(true);
      this.b.setStyle(Paint.Style.STROKE);
      this.b.setColor(1291845632);
      this.b.setStrokeWidth(5.0F);
      paramCanvas.drawCircle(this.a.left + this.a.width() * 0.5F, f1, this.a.width() * 0.5F, this.b);
      this.b.setColor(-1);
      this.b.setStrokeWidth(3.0F);
      paramCanvas.drawCircle(this.a.left + this.a.width() * 0.5F, f1, this.a.width() * 0.5F, this.b);
      return;
    }
    this.i = new Rect[] { new Rect(0, 0, this.a.left, this.a.top), new Rect(this.a.left, 0, this.a.right, this.a.top), new Rect(this.a.right, 0, getWidth(), this.a.top), new Rect(0, this.a.top, this.a.left, this.a.bottom), new Rect(this.a.right, this.a.top, getWidth(), this.a.bottom), new Rect(0, this.a.bottom, this.a.left, getHeight()), new Rect(this.a.left, this.a.bottom, this.a.right, getHeight()), new Rect(this.a.right, this.a.bottom, getWidth(), getHeight()) };
    this.j = new Rect();
    this.j.set(this.a);
    localObject = this.j;
    ((Rect)localObject).left -= 2;
    localObject = this.j;
    ((Rect)localObject).right += 2;
    localObject = this.j;
    ((Rect)localObject).top -= 2;
    localObject = this.j;
    ((Rect)localObject).bottom += 2;
    this.b.setColor(1711276032);
    this.b.setStyle(Paint.Style.FILL);
    int m = 0;
    for (;;)
    {
      localObject = this.i;
      if (m >= localObject.length) {
        break;
      }
      paramCanvas.drawRect(localObject[m], this.b);
      m += 1;
    }
    this.b.setColor(0);
    paramCanvas.drawRect(this.j, this.b);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(5.0F);
    this.b.setColor(1291845632);
    paramCanvas.drawRect(this.j, this.b);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(3.0F);
    this.b.setColor(-1);
    paramCanvas.drawRect(this.j, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.RegionView
 * JD-Core Version:    0.7.0.1
 */