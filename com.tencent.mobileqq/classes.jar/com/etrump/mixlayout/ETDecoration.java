package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
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
  private static HashMap DescriptorMap = new HashMap();
  private ETEngine mEngine;
  private int[] mFrameDelay;
  public int mFrameIndex = -1;
  private int mFrameNum;
  private long mNativeDescritptorHandle;
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
    paramArrayOfObject = paramArrayOfObject[paramInt1];
    if ((paramArrayOfObject != null) && ((paramArrayOfObject instanceof QQText.EmoticonSpan)))
    {
      paramArrayOfObject = (QQText.EmoticonSpan)paramArrayOfObject;
      paramMatrix = new Paint(1);
      paramMatrix.setTextSize(paramFloat4);
      paramMatrix.setColor(paramInt2);
      paramMatrix.setAlpha((int)(255.0F * paramFloat5));
      paramInt1 = (int)paramFloat3 + paramArrayOfObject.a().getBounds().height();
      paramArrayOfObject.draw(paramCanvas, null, 0, 0, paramFloat2, 0, paramInt1, paramInt1, null);
    }
    paramCanvas.restore();
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
    Object localObject2 = DescriptorMap.entrySet().iterator();
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
      DescriptorMap.remove(localObject2);
    }
  }
  
  public static void clearMap(ETEngine paramETEngine)
  {
    checkDescriptorList(paramETEngine);
    DescriptorMap.clear();
  }
  
  public static ETDecoration createDecoration(ETEngine paramETEngine, String paramString, ETSegment[] paramArrayOfETSegment, Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ETFont paramETFont)
  {
    if ((paramETEngine == null) || (paramString == null) || (paramETFont == null)) {
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt4 <= 0)) {
      return null;
    }
    long l = paramETEngine.native_decorationCreateDescriptor(paramString, paramArrayOfETSegment, paramInt1, paramInt2, paramInt3, paramInt4, paramETFont);
    if (l != 0L)
    {
      paramInt2 = paramETEngine.native_decorationGetFrameNum(l);
      if (paramInt2 == 0)
      {
        paramETEngine.native_decorationDeleteDescriptor(l);
        return null;
      }
      paramArrayOfETSegment = new int[paramInt2];
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramArrayOfETSegment[paramInt1] = paramETEngine.native_decorationGetFrameDelay(l, paramInt1);
        paramInt1 += 1;
      }
      paramETFont = new ETDecoration();
      paramETFont.mNativeDescritptorHandle = l;
      paramETFont.mFrameDelay = paramArrayOfETSegment;
      paramETFont.mFrameNum = paramInt2;
      paramETFont.mText = paramString;
      paramETFont.mEngine = paramETEngine;
      paramETFont.mSpans = paramArrayOfObject;
      checkDescriptorList(paramETEngine);
      DescriptorMap.put(Long.valueOf(l), new WeakReference(paramETFont));
      return paramETFont;
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
    if (0L != this.mNativeDescritptorHandle)
    {
      DescriptorMap.remove(Long.valueOf(this.mNativeDescritptorHandle));
      this.mEngine.native_decorationDeleteDescriptor(this.mNativeDescritptorHandle);
      this.mNativeDescritptorHandle = 0L;
    }
  }
  
  public void drawBackground(Bitmap paramBitmap, ETFont paramETFont)
  {
    int i = currentFrameIndex();
    if ((this.mEngine != null) && (0L != this.mNativeDescritptorHandle) && (i >= 0) && (i < this.mFrameNum)) {
      this.mEngine.native_decorationDrawBackground(this.mNativeDescritptorHandle, i, paramETFont, paramBitmap);
    }
  }
  
  public void drawForeground(Bitmap paramBitmap, ETFont paramETFont)
  {
    int i = currentFrameIndex();
    if ((this.mEngine != null) && (0L != this.mNativeDescritptorHandle) && (i >= 0) && (i < this.mFrameNum)) {
      this.mEngine.native_decorationDrawForeground(this.mNativeDescritptorHandle, i, paramETFont, paramBitmap);
    }
  }
  
  public void drawFrameText(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4, ETFont paramETFont)
  {
    int i = currentFrameIndex();
    if ((this.mEngine != null) && (0L != this.mNativeDescritptorHandle) && (i >= 0) && (i < this.mFrameNum)) {
      this.mEngine.native_decorationDrawText(this.mNativeDescritptorHandle, i, paramInt1, paramInt2, paramETFont, paramBitmap, paramInt3, paramInt4);
    }
  }
  
  void drawScene(Bitmap paramBitmap, int paramInt1, int paramInt2, ETFont paramETFont)
  {
    int i = currentFrameIndex();
    if ((this.mEngine != null) && (0L != this.mNativeDescritptorHandle) && (i >= 0) && (i < this.mFrameNum)) {
      this.mEngine.native_decorationDrawScene(this.mNativeDescritptorHandle, i, paramETFont, this.mSpans, paramBitmap, paramInt1, paramInt2);
    }
  }
  
  int getDecorationType()
  {
    if (this.mEngine != null) {
      return this.mEngine.native_decorationGetType(this.mNativeDescritptorHandle);
    }
    return 0;
  }
  
  public int getFrameDelay()
  {
    int i = currentFrameIndex();
    if ((this.mFrameDelay != null) && (i >= 0) && (i < this.mFrameDelay.length)) {
      return this.mFrameDelay[i];
    }
    return 0;
  }
  
  public int getFrameNum()
  {
    return this.mFrameNum;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  public void gotoLastFrame()
  {
    this.mFrameIndex = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.ETDecoration
 * JD-Core Version:    0.7.0.1
 */