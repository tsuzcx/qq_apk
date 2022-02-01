package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.etrump.mixlayout.api.IETSegment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IETFontAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ETDecoration
  implements IETDecoration
{
  public static final int DECORATION_SCENE = 2;
  public static final int DECORATION_TEMPLATE = 1;
  private ETEngine mEngine = null;
  private int mFrameDelay;
  public int mFrameIndex = -1;
  private int mFrameNum = 0;
  public Rect mMargins = null;
  private long mNativeDescriptorHandle = 0L;
  private Object[] mSpans = null;
  private String mText = null;
  
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
      if (paramFloat3 > paramFloat2) {
        paramFloat2 = paramFloat3;
      }
    }
    return (int)paramFloat2;
  }
  
  public static void callbackDrawImage(Object[] paramArrayOfObject, int paramInt1, Canvas paramCanvas, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean, int paramInt2)
  {
    if (paramCanvas == null) {
      return;
    }
    if ((paramArrayOfObject != null) && (paramInt1 >= 0))
    {
      if (paramInt1 >= paramArrayOfObject.length) {
        return;
      }
      paramCanvas.save();
      paramCanvas.setMatrix(paramMatrix);
      paramArrayOfObject = paramArrayOfObject[paramInt1];
      if (paramArrayOfObject != null)
      {
        paramMatrix = new Paint(1);
        paramMatrix.setTextSize(paramFloat4);
        paramMatrix.setColor(paramInt2);
        paramMatrix.setAlpha((int)(paramFloat5 * 255.0F));
        drawImage(paramCanvas, paramFloat2, paramFloat3, paramArrayOfObject, paramMatrix);
      }
      paramCanvas.restore();
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
    paramInt1 = (int)(255.0F * paramFloat5);
    localPaint.setAlpha(paramInt1);
    if (!paramBoolean1) {
      localPaint.setStyle(Paint.Style.STROKE);
    }
    paramCanvas.save();
    paramCanvas.setMatrix(paramMatrix);
    if ((paramBoolean2) && (paramBoolean1))
    {
      if (0.0F == paramFloat8) {
        paramFloat5 = 0.1F;
      } else {
        paramFloat5 = paramFloat8;
      }
      Object localObject2 = new float[9];
      paramMatrix.getValues((float[])localObject2);
      localObject2[2] = 0.0F;
      localObject2[5] = 0.0F;
      paramMatrix = new Matrix();
      paramMatrix.setValues((float[])localObject2);
      localObject2 = new Matrix();
      if (paramMatrix.invert((Matrix)localObject2))
      {
        paramMatrix = new float[2];
        ((Matrix)localObject2).mapPoints(paramMatrix, new float[] { paramFloat6, paramFloat7 });
        paramFloat6 = paramMatrix[0];
        paramFloat7 = paramMatrix[1];
      }
      localPaint.setShadowLayer(paramFloat5, paramFloat6, paramFloat7, paramInt3);
    }
    if (paramBoolean3)
    {
      paramMatrix = new Paint(1);
      paramMatrix.setStyle(Paint.Style.STROKE);
      paramMatrix.setColor(paramInt4);
      paramMatrix.setStrokeWidth(paramFloat9);
      paramMatrix.setTextSize(paramFloat4);
      paramMatrix.setAlpha(paramInt1);
      paramCanvas.drawText((String)localObject1, 0.0F, paramFloat1, paramMatrix);
    }
    paramCanvas.drawText((String)localObject1, paramFloat2, paramFloat3 + paramFloat1, localPaint);
    paramCanvas.restore();
  }
  
  private static void checkDescriptorList(ETEngine paramETEngine)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramETEngine.mDescriptorMap.entrySet().iterator();
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
      paramETEngine.mDescriptorMap.remove(localObject2);
    }
  }
  
  private static ETSegment[] convertToETSegmentArray(IETSegment[] paramArrayOfIETSegment)
  {
    if (paramArrayOfIETSegment == null) {
      return null;
    }
    ETSegment[] arrayOfETSegment = new ETSegment[paramArrayOfIETSegment.length];
    int i = 0;
    while (i < arrayOfETSegment.length)
    {
      arrayOfETSegment[i] = ((ETSegment)paramArrayOfIETSegment[i]);
      i += 1;
    }
    return arrayOfETSegment;
  }
  
  public static IETDecoration createDecoration(IETEngine paramIETEngine, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, IETSegment[] paramArrayOfIETSegment, Object[] paramArrayOfObject, boolean paramBoolean1, int paramInt5, IETFont paramIETFont, boolean paramBoolean2)
  {
    paramIETEngine = (ETEngine)paramIETEngine;
    if ((paramIETEngine != null) && (paramString != null) && (paramIETFont != null))
    {
      if (paramArrayOfIETSegment == null) {
        return null;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        if (paramInt4 <= 0) {
          return null;
        }
        long l = paramIETEngine.native_decorationCreateDescriptor(paramString, convertToETSegmentArray(paramArrayOfIETSegment), paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramInt5, (ETFont)paramIETFont);
        if (l != 0L)
        {
          paramInt3 = paramIETEngine.native_decorationGetFrameNum(l);
          if (paramInt3 == 0)
          {
            paramIETEngine.native_decorationDeleteDescriptor(l);
            return null;
          }
          paramArrayOfIETSegment = new ETDecoration();
          paramArrayOfIETSegment.mNativeDescriptorHandle = l;
          paramInt2 = paramIETEngine.native_decorationGetFrameDelay(l, 0);
          paramInt1 = paramInt2;
          if (paramInt2 < 50) {
            paramInt1 = 50;
          }
          paramArrayOfIETSegment.mFrameDelay = paramInt1;
          paramArrayOfIETSegment.mFrameNum = paramInt3;
          paramArrayOfIETSegment.mText = paramString;
          paramArrayOfIETSegment.mEngine = paramIETEngine;
          paramArrayOfIETSegment.mSpans = paramArrayOfObject;
          paramArrayOfIETSegment.mMargins = paramIETEngine.native_getMargins(l);
          if (paramBoolean2)
          {
            checkDescriptorList(paramIETEngine);
            paramIETEngine.mDescriptorMap.put(Long.valueOf(l), new WeakReference(paramArrayOfIETSegment));
          }
          return paramArrayOfIETSegment;
        }
      }
    }
    return null;
  }
  
  public static IETDecoration createDecorationSpace(IETEngine paramIETEngine, String paramString, int paramInt1, int paramInt2, Point paramPoint, int paramInt3, Point[] paramArrayOfPoint, int paramInt4, IETSegment[] paramArrayOfIETSegment, Object[] paramArrayOfObject, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, IETFont paramIETFont, boolean paramBoolean3)
  {
    paramIETEngine = (ETEngine)paramIETEngine;
    if ((paramIETEngine != null) && (paramString != null))
    {
      if (paramIETFont == null) {
        return null;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        if (paramInt4 <= 0) {
          return null;
        }
        paramIETFont = (ETFont)paramIETFont;
        paramIETEngine.native_isColorVariantFont(paramIETFont);
        long l = paramIETEngine.native_space_decorationCreateDescriptor(paramString, convertToETSegmentArray(paramArrayOfIETSegment), paramInt1, paramInt2, paramPoint, paramInt3, paramArrayOfPoint, paramInt4, paramBoolean1, paramInt5, paramBoolean2, paramIETFont);
        if (l != 0L)
        {
          paramInt3 = paramIETEngine.native_space_decorationGetFrameNum(l);
          if (paramInt3 == 0)
          {
            paramIETEngine.native_space_decorationDeleteDescriptor(l);
            return null;
          }
          paramPoint = new ETDecoration();
          paramPoint.mNativeDescriptorHandle = l;
          paramInt2 = paramIETEngine.native_space_decorationGetFrameDelay(l, 0);
          paramInt1 = paramInt2;
          if (paramInt2 < 50) {
            paramInt1 = 50;
          }
          paramPoint.mFrameDelay = paramInt1;
          paramPoint.mFrameNum = paramInt3;
          paramPoint.mText = paramString;
          paramPoint.mEngine = paramIETEngine;
          paramPoint.mSpans = paramArrayOfObject;
          paramPoint.mMargins = paramIETEngine.native_space_getMargins(l);
          if (paramBoolean3) {
            checkDescriptorList(paramIETEngine);
          }
          return paramPoint;
        }
      }
    }
    return null;
  }
  
  private static void drawImage(Canvas paramCanvas, float paramFloat1, float paramFloat2, Object paramObject, Paint paramPaint)
  {
    ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).drawImage(paramCanvas, paramFloat1, paramFloat2, paramObject, paramPaint);
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
      this.mEngine.mDescriptorMap.remove(Long.valueOf(this.mNativeDescriptorHandle));
      this.mEngine.native_decorationDeleteDescriptor(this.mNativeDescriptorHandle);
      this.mNativeDescriptorHandle = 0L;
    }
  }
  
  public void deleteDescriptor(IETEngine paramIETEngine)
  {
    long l = this.mNativeDescriptorHandle;
    if ((l != 0L) && (paramIETEngine != null))
    {
      paramIETEngine.nativeDecorationDeleteDescriptor(l);
      this.mNativeDescriptorHandle = 0L;
    }
  }
  
  void deleteDescriptorSpace()
  {
    long l = this.mNativeDescriptorHandle;
    if (0L != l)
    {
      this.mEngine.native_space_decorationDeleteDescriptor(l);
      this.mNativeDescriptorHandle = 0L;
    }
  }
  
  public void drawBackground(Bitmap paramBitmap, IETFont paramIETFont)
  {
    int i = currentFrameIndex();
    ETEngine localETEngine = this.mEngine;
    if (localETEngine != null)
    {
      long l = this.mNativeDescriptorHandle;
      if ((0L != l) && (i >= 0) && (i < this.mFrameNum)) {
        localETEngine.native_decorationDrawBackground(l, i, (ETFont)paramIETFont, paramBitmap);
      }
    }
  }
  
  public void drawBackgroundSpace(Bitmap paramBitmap, IETFont paramIETFont, int paramInt1, int paramInt2)
  {
    int i = currentFrameIndex();
    ETEngine localETEngine = this.mEngine;
    if (localETEngine != null)
    {
      long l = this.mNativeDescriptorHandle;
      if ((0L != l) && (i >= 0) && (i < this.mFrameNum)) {
        localETEngine.native_space_decorationDrawBackground(l, i, (ETFont)paramIETFont, paramBitmap, paramInt1, paramInt2);
      }
    }
  }
  
  public void drawForeground(Bitmap paramBitmap, IETFont paramIETFont)
  {
    int i = currentFrameIndex();
    ETEngine localETEngine = this.mEngine;
    if (localETEngine != null)
    {
      long l = this.mNativeDescriptorHandle;
      if ((0L != l) && (i >= 0) && (i < this.mFrameNum)) {
        localETEngine.native_decorationDrawForeground(l, i, (ETFont)paramIETFont, paramBitmap);
      }
    }
  }
  
  public void drawFrameText(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4, IETFont paramIETFont)
  {
    int i = currentFrameIndex();
    ETEngine localETEngine = this.mEngine;
    if (localETEngine != null)
    {
      long l = this.mNativeDescriptorHandle;
      if ((0L != l) && (i >= 0) && (i < this.mFrameNum)) {
        localETEngine.native_decorationDrawText(l, i, paramInt1, paramInt2, (ETFont)paramIETFont, paramBitmap, paramInt3, paramInt4);
      }
    }
  }
  
  void drawScene(Bitmap paramBitmap, int paramInt1, int paramInt2, IETFont paramIETFont)
  {
    int i = currentFrameIndex();
    ETEngine localETEngine = this.mEngine;
    if (localETEngine != null)
    {
      long l = this.mNativeDescriptorHandle;
      if ((0L != l) && (i >= 0) && (i < this.mFrameNum)) {
        localETEngine.native_decorationDrawScene(l, i, (ETFont)paramIETFont, this.mSpans, paramBitmap, paramInt1, paramInt2);
      }
    }
  }
  
  public void drawSceneSpace(Bitmap paramBitmap, int paramInt1, int paramInt2, IETFont paramIETFont)
  {
    int i = currentFrameIndex();
    ETEngine localETEngine = this.mEngine;
    if (localETEngine != null)
    {
      long l = this.mNativeDescriptorHandle;
      if ((0L != l) && (i >= 0) && (i < this.mFrameNum)) {
        localETEngine.native_space_decorationDrawScene(l, i, (ETFont)paramIETFont, this.mSpans, paramBitmap, paramInt1, paramInt2);
      }
    }
  }
  
  int getDecorationType()
  {
    ETEngine localETEngine = this.mEngine;
    if (localETEngine != null) {
      return localETEngine.native_decorationGetType(this.mNativeDescriptorHandle);
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
    if (paramInt >= 0)
    {
      if (paramInt >= this.mFrameNum) {
        return;
      }
      this.mFrameIndex = paramInt;
    }
  }
  
  public void gotoLastFrame()
  {
    this.mFrameIndex = -1;
  }
  
  public boolean isLastFrame()
  {
    int i = this.mFrameIndex;
    return (i < 0) || (i >= this.mFrameNum);
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
  
  public void setNativeDescriptorHandle(long paramLong)
  {
    this.mNativeDescriptorHandle = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETDecoration
 * JD-Core Version:    0.7.0.1
 */