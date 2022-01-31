package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import aykp;
import gz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ETDecoration
{
  public static final int DECORATION_SCENE = 2;
  public static final int DECORATION_TEMPLATE = 1;
  private ETEngine mEngine;
  private int mFrameDelay;
  public int mFrameIndex = -1;
  private int mFrameNum;
  public Rect mMargins;
  private long mNativeDescriptorHandle;
  private Object[] mSpans;
  private String mText;
  
  public static int callbackCharWidth(int paramInt, float paramFloat1, boolean paramBoolean1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean2, float paramFloat5)
  {
    Object localObject = new StringBuilder("");
    ((StringBuilder)localObject).appendCodePoint(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    Paint localPaint = new Paint();
    localPaint.reset();
    localPaint.setTextSize(paramFloat1);
    if (paramBoolean1) {
      localPaint.setShadowLayer(paramFloat4, paramFloat2, paramFloat3, -16777216);
    }
    paramFloat3 = localPaint.measureText((String)localObject);
    paramFloat2 = paramFloat3;
    if (paramBoolean2)
    {
      localPaint = new Paint(1);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16776961);
      localPaint.setStrokeWidth(paramFloat5);
      localPaint.setTextSize(paramFloat1);
      paramFloat2 = localPaint.measureText((String)localObject);
      if (paramFloat3 <= paramFloat2) {
        break label137;
      }
      paramFloat2 = paramFloat3;
    }
    label137:
    for (;;)
    {
      return (int)paramFloat2;
    }
  }
  
  public static void callbackDrawImage(Object[] paramArrayOfObject, int paramInt1, Canvas paramCanvas, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean, int paramInt2)
  {
    if (paramCanvas == null) {}
    while ((paramArrayOfObject == null) || (paramInt1 < 0) || (paramInt1 >= paramArrayOfObject.length)) {
      return;
    }
    paramCanvas.save();
    paramCanvas.setMatrix(paramMatrix);
    paramMatrix = paramArrayOfObject[paramInt1];
    if (paramMatrix != null)
    {
      paramArrayOfObject = new Paint(1);
      paramArrayOfObject.setTextSize(paramFloat4);
      paramArrayOfObject.setColor(paramInt2);
      paramArrayOfObject.setAlpha((int)(255.0F * paramFloat5));
      if (!(paramMatrix instanceof aykp)) {
        break label114;
      }
      paramArrayOfObject = (aykp)paramMatrix;
      paramInt1 = (int)paramFloat3 + paramArrayOfObject.a().getBounds().height();
      paramArrayOfObject.draw(paramCanvas, null, 0, 0, paramFloat2, 0, paramInt1, paramInt1, null);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      label114:
      if ((paramMatrix instanceof gz))
      {
        paramMatrix = (gz)paramMatrix;
        paramMatrix.draw(paramCanvas, null, 0, 0, paramFloat2, 0, 0, (int)(paramMatrix.getDrawable().getBounds().height() + paramFloat3), paramArrayOfObject);
      }
    }
  }
  
  public static void callbackDrawText(int paramInt1, Canvas paramCanvas, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3, float paramFloat6, float paramFloat7, float paramFloat8, boolean paramBoolean3, int paramInt4, float paramFloat9)
  {
    if (paramCanvas == null) {
      return;
    }
    Object localObject1 = new StringBuilder("");
    ((StringBuilder)localObject1).appendCodePoint(paramInt1);
    localObject1 = ((StringBuilder)localObject1).toString();
    Paint localPaint = new Paint();
    localPaint.reset();
    localPaint.setColor(paramInt2);
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setTextSize(paramFloat4);
    localPaint.setAlpha((int)(255.0F * paramFloat5));
    if (!paramBoolean1) {
      localPaint.setStyle(Paint.Style.STROKE);
    }
    paramCanvas.save();
    paramCanvas.setMatrix(paramMatrix);
    if ((paramBoolean2) && (paramBoolean1))
    {
      float f1 = paramFloat8;
      if (0.0F == paramFloat8) {
        f1 = 0.1F;
      }
      Object localObject2 = new float[9];
      paramMatrix.getValues((float[])localObject2);
      localObject2[2] = 0.0F;
      localObject2[5] = 0.0F;
      paramMatrix = new Matrix();
      paramMatrix.setValues((float[])localObject2);
      localObject2 = new Matrix();
      float f2 = paramFloat6;
      paramFloat8 = paramFloat7;
      if (paramMatrix.invert((Matrix)localObject2))
      {
        paramMatrix = new float[2];
        ((Matrix)localObject2).mapPoints(paramMatrix, new float[] { paramFloat6, paramFloat7 });
        f2 = paramMatrix[0];
        paramFloat8 = paramMatrix[1];
      }
      localPaint.setShadowLayer(f1, f2, paramFloat8, paramInt3);
    }
    if (paramBoolean3)
    {
      paramMatrix = new Paint(1);
      paramMatrix.setStyle(Paint.Style.STROKE);
      paramMatrix.setColor(paramInt4);
      paramMatrix.setStrokeWidth(paramFloat9);
      paramMatrix.setTextSize(paramFloat4);
      paramMatrix.setAlpha((int)(255.0F * paramFloat5));
      paramCanvas.drawText((String)localObject1, 0.0F, paramFloat1, paramMatrix);
    }
    paramCanvas.drawText((String)localObject1, paramFloat2, paramFloat3 + paramFloat1, localPaint);
    paramCanvas.restore();
  }
  
  private static void checkDescriptorList(ETEngine paramETEngine)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramETEngine.DescriptorMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (((WeakReference)localEntry.getValue()).get() == null) {
        ((ArrayList)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      if (((Long)localObject2).longValue() != 0L) {
        paramETEngine.native_decorationDeleteDescriptor(((Long)localObject2).longValue());
      }
      paramETEngine.DescriptorMap.remove(localObject2);
    }
  }
  
  public static void clearMap(ETEngine paramETEngine)
  {
    Iterator localIterator = paramETEngine.DescriptorMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      paramETEngine.native_decorationDeleteDescriptor(((Long)((Map.Entry)localObject).getKey()).longValue());
      if (((WeakReference)((Map.Entry)localObject).getValue()).get() != null)
      {
        localObject = (ETDecoration)((WeakReference)((Map.Entry)localObject).getValue()).get();
        if (localObject != null) {
          ((ETDecoration)localObject).mNativeDescriptorHandle = 0L;
        }
      }
    }
    paramETEngine.DescriptorMap.clear();
  }
  
  public static ETDecoration createDecoration(ETEngine paramETEngine, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ETSegment[] paramArrayOfETSegment, Object[] paramArrayOfObject, boolean paramBoolean1, int paramInt5, ETFont paramETFont, boolean paramBoolean2)
  {
    if ((paramETEngine == null) || (paramString == null) || (paramETFont == null) || (paramArrayOfETSegment == null)) {
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt4 <= 0)) {
      return null;
    }
    long l = paramETEngine.native_decorationCreateDescriptor(paramString, paramArrayOfETSegment, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramInt5, paramETFont);
    if (l != 0L)
    {
      paramInt3 = paramETEngine.native_decorationGetFrameNum(l);
      if (paramInt3 == 0)
      {
        paramETEngine.native_decorationDeleteDescriptor(l);
        return null;
      }
      paramArrayOfETSegment = new ETDecoration();
      paramArrayOfETSegment.mNativeDescriptorHandle = l;
      paramInt2 = paramETEngine.native_decorationGetFrameDelay(l, 0);
      paramInt1 = paramInt2;
      if (paramInt2 < 50) {
        paramInt1 = 50;
      }
      paramArrayOfETSegment.mFrameDelay = paramInt1;
      paramArrayOfETSegment.mFrameNum = paramInt3;
      paramArrayOfETSegment.mText = paramString;
      paramArrayOfETSegment.mEngine = paramETEngine;
      paramArrayOfETSegment.mSpans = paramArrayOfObject;
      paramArrayOfETSegment.mMargins = paramETEngine.native_getMargins(l);
      if (paramBoolean2)
      {
        checkDescriptorList(paramETEngine);
        paramETEngine.DescriptorMap.put(Long.valueOf(l), new WeakReference(paramArrayOfETSegment));
      }
      return paramArrayOfETSegment;
    }
    return null;
  }
  
  public static ETDecoration createDecorationSpace(ETEngine paramETEngine, String paramString, int paramInt1, int paramInt2, Point paramPoint, int paramInt3, Point[] paramArrayOfPoint, int paramInt4, ETSegment[] paramArrayOfETSegment, Object[] paramArrayOfObject, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, ETFont paramETFont, boolean paramBoolean3)
  {
    if ((paramETEngine == null) || (paramString == null) || (paramETFont == null)) {
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt4 <= 0)) {
      return null;
    }
    paramETEngine.native_isColorVariantFont(paramETFont);
    long l = paramETEngine.native_space_decorationCreateDescriptor(paramString, paramArrayOfETSegment, paramInt1, paramInt2, paramPoint, paramInt3, paramArrayOfPoint, paramInt4, paramBoolean1, paramInt5, paramBoolean2, paramETFont);
    if (l != 0L)
    {
      paramInt3 = paramETEngine.native_space_decorationGetFrameNum(l);
      if (paramInt3 == 0)
      {
        paramETEngine.native_space_decorationDeleteDescriptor(l);
        return null;
      }
      paramPoint = new ETDecoration();
      paramPoint.mNativeDescriptorHandle = l;
      paramInt2 = paramETEngine.native_space_decorationGetFrameDelay(l, 0);
      paramInt1 = paramInt2;
      if (paramInt2 < 50) {
        paramInt1 = 50;
      }
      paramPoint.mFrameDelay = paramInt1;
      paramPoint.mFrameNum = paramInt3;
      paramPoint.mText = paramString;
      paramPoint.mEngine = paramETEngine;
      paramPoint.mSpans = paramArrayOfObject;
      paramPoint.mMargins = paramETEngine.native_space_getMargins(l);
      if (paramBoolean3) {
        checkDescriptorList(paramETEngine);
      }
      return paramPoint;
    }
    return null;
  }
  
  public int currentFrameIndex()
  {
    int j = this.mFrameIndex;
    int i;
    if (j >= 0)
    {
      i = j;
      if (j < this.mFrameNum) {}
    }
    else
    {
      i = this.mFrameNum - 1;
    }
    return i;
  }
  
  public void deleteDescriptor()
  {
    if (0L != this.mNativeDescriptorHandle)
    {
      this.mEngine.DescriptorMap.remove(Long.valueOf(this.mNativeDescriptorHandle));
      this.mEngine.native_decorationDeleteDescriptor(this.mNativeDescriptorHandle);
      this.mNativeDescriptorHandle = 0L;
    }
  }
  
  public void deleteDescriptor(ETEngine paramETEngine)
  {
    if ((this.mNativeDescriptorHandle != 0L) && (paramETEngine != null))
    {
      paramETEngine.native_decorationDeleteDescriptor(this.mNativeDescriptorHandle);
      this.mNativeDescriptorHandle = 0L;
    }
  }
  
  void deleteDescriptorSpace()
  {
    if (0L != this.mNativeDescriptorHandle)
    {
      this.mEngine.native_space_decorationDeleteDescriptor(this.mNativeDescriptorHandle);
      this.mNativeDescriptorHandle = 0L;
    }
  }
  
  public void drawBackground(Bitmap paramBitmap, ETFont paramETFont)
  {
    int i = currentFrameIndex();
    if ((this.mEngine != null) && (0L != this.mNativeDescriptorHandle) && (i >= 0) && (i < this.mFrameNum)) {
      this.mEngine.native_decorationDrawBackground(this.mNativeDescriptorHandle, i, paramETFont, paramBitmap);
    }
  }
  
  public void drawBackgroundSpace(Bitmap paramBitmap, ETFont paramETFont, int paramInt1, int paramInt2)
  {
    int i = currentFrameIndex();
    if ((this.mEngine != null) && (0L != this.mNativeDescriptorHandle) && (i >= 0) && (i < this.mFrameNum)) {
      this.mEngine.native_space_decorationDrawBackground(this.mNativeDescriptorHandle, i, paramETFont, paramBitmap, paramInt1, paramInt2);
    }
  }
  
  public void drawForeground(Bitmap paramBitmap, ETFont paramETFont)
  {
    int i = currentFrameIndex();
    if ((this.mEngine != null) && (0L != this.mNativeDescriptorHandle) && (i >= 0) && (i < this.mFrameNum)) {
      this.mEngine.native_decorationDrawForeground(this.mNativeDescriptorHandle, i, paramETFont, paramBitmap);
    }
  }
  
  public void drawFrameText(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4, ETFont paramETFont)
  {
    int i = currentFrameIndex();
    if ((this.mEngine != null) && (0L != this.mNativeDescriptorHandle) && (i >= 0) && (i < this.mFrameNum)) {
      this.mEngine.native_decorationDrawText(this.mNativeDescriptorHandle, i, paramInt1, paramInt2, paramETFont, paramBitmap, paramInt3, paramInt4);
    }
  }
  
  public void drawScene(Bitmap paramBitmap, int paramInt1, int paramInt2, ETFont paramETFont)
  {
    int i = currentFrameIndex();
    if ((this.mEngine != null) && (0L != this.mNativeDescriptorHandle) && (i >= 0) && (i < this.mFrameNum)) {
      this.mEngine.native_decorationDrawScene(this.mNativeDescriptorHandle, i, paramETFont, this.mSpans, paramBitmap, paramInt1, paramInt2);
    }
  }
  
  public void drawSceneSpace(Bitmap paramBitmap, int paramInt1, int paramInt2, ETFont paramETFont)
  {
    int i = currentFrameIndex();
    if ((this.mEngine != null) && (0L != this.mNativeDescriptorHandle) && (i >= 0) && (i < this.mFrameNum)) {
      this.mEngine.native_space_decorationDrawScene(this.mNativeDescriptorHandle, i, paramETFont, this.mSpans, paramBitmap, paramInt1, paramInt2);
    }
  }
  
  public int getDecorationType()
  {
    if (this.mEngine != null) {
      return this.mEngine.native_decorationGetType(this.mNativeDescriptorHandle);
    }
    return 0;
  }
  
  public int getFrameDelay()
  {
    return this.mFrameDelay;
  }
  
  public int getFrameNum()
  {
    return this.mFrameNum;
  }
  
  public Rect getMargins()
  {
    return this.mMargins;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  public void gotoFrame(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFrameNum)) {
      return;
    }
    this.mFrameIndex = paramInt;
  }
  
  public void gotoLastFrame()
  {
    this.mFrameIndex = -1;
  }
  
  public boolean isLastFrame()
  {
    return (this.mFrameIndex < 0) || (this.mFrameIndex >= this.mFrameNum);
  }
  
  public boolean nextFrame()
  {
    this.mFrameIndex += 1;
    if (this.mFrameIndex >= this.mFrameNum)
    {
      this.mFrameIndex = -1;
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.etrump.mixlayout.ETDecoration
 * JD-Core Version:    0.7.0.1
 */