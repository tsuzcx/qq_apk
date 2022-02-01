package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.text.TextUtils;
import java.util.ArrayList;

public class EMEmoticon
{
  private static final int FLAG_LOAD_EMOTICON_CONCISE = 1;
  private static final int FLAG_LOAD_EMOTICON_DEFAULT = 0;
  private static final String TAG = "HiBoomFont.EMEmoticon";
  private ETEngine mEngine = null;
  public ETFont mFont = null;
  private int mFrameDelay;
  private int mFrameIndex = -1;
  private int mFrameNum = 0;
  private int mHeight = 0;
  private long mNativeDescriptorHandle = 0L;
  public String mText;
  private int mWidth = 0;
  
  public static void callbackDrawText(int paramInt1, Canvas paramCanvas, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3, float paramFloat6, float paramFloat7, float paramFloat8, boolean paramBoolean3, int paramInt4, float paramFloat9)
  {
    if (paramCanvas == null) {
      return;
    }
    String str = String.valueOf(Character.toChars(paramInt1));
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
        paramFloat1 = 0.1F;
      } else {
        paramFloat1 = paramFloat8;
      }
      Object localObject = new float[9];
      paramMatrix.getValues((float[])localObject);
      localObject[2] = 0.0F;
      localObject[5] = 0.0F;
      paramMatrix = new Matrix();
      paramMatrix.setValues((float[])localObject);
      localObject = new Matrix();
      if (paramMatrix.invert((Matrix)localObject))
      {
        paramMatrix = new float[2];
        ((Matrix)localObject).mapPoints(paramMatrix, new float[] { paramFloat6, paramFloat7 });
        paramFloat6 = paramMatrix[0];
        paramFloat5 = paramMatrix[1];
      }
      else
      {
        paramFloat5 = paramFloat7;
      }
      localPaint.setShadowLayer(paramFloat1, paramFloat6, paramFloat5, paramInt3);
    }
    if (paramBoolean3)
    {
      paramMatrix = new Paint(1);
      paramMatrix.setStyle(Paint.Style.STROKE);
      paramMatrix.setColor(paramInt4);
      paramMatrix.setStrokeWidth(paramFloat9);
      paramMatrix.setTextSize(paramFloat4);
      paramMatrix.setAlpha(paramInt1);
      paramCanvas.drawText(str, 0.0F, paramFloat3 + Math.abs(paramMatrix.getFontMetricsInt().ascent), paramMatrix);
    }
    paramCanvas.drawText(str, paramFloat2, paramFloat3 + Math.abs(localPaint.getFontMetricsInt().ascent), localPaint);
    paramCanvas.restore();
  }
  
  private static ETSegment createEmojiSegment(char paramChar1, char paramChar2)
  {
    ETSegment localETSegment = new ETSegment();
    localETSegment.type = 1;
    localETSegment.textLength = 0;
    localETSegment.textOffset = 0;
    localETSegment.codePoint = ((paramChar1 << '\n') + paramChar2 - 56613888);
    return localETSegment;
  }
  
  public static EMEmoticon createEmoticon(ETEngine paramETEngine, String paramString, int paramInt, ETFont paramETFont)
  {
    if (paramETEngine != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      long l = paramETEngine.native_emoticonCreateDescriptor(paramString, createSegments(paramString, paramETFont), paramInt, paramETFont, 0);
      if (0L == l) {
        return null;
      }
      EMEmoticon localEMEmoticon = new EMEmoticon();
      localEMEmoticon.mEngine = paramETEngine;
      localEMEmoticon.mNativeDescriptorHandle = l;
      localEMEmoticon.mFrameNum = localEMEmoticon.mEngine.native_emoticonGetFrameNum(l);
      localEMEmoticon.mWidth = localEMEmoticon.mEngine.native_emoticonGetWidth(l);
      localEMEmoticon.mHeight = localEMEmoticon.mEngine.native_emoticonGetHeight(l);
      localEMEmoticon.mText = paramString;
      localEMEmoticon.mFont = paramETFont;
      localEMEmoticon.mFrameDelay = paramETEngine.native_emoticonGetFrameDelay(l, 0);
      if (localEMEmoticon.mFrameDelay < 50) {
        localEMEmoticon.mFrameDelay = 50;
      }
      return localEMEmoticon;
    }
    return null;
  }
  
  private static ETSegment[] createSegments(String paramString, ETFont paramETFont)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i2 = paramString.length();
      int j = 0;
      int i = 0;
      int m;
      for (int n = -1; j < i2; n = m)
      {
        char c1 = paramString.charAt(j);
        ETSegment localETSegment;
        if (Character.isHighSurrogate(c1))
        {
          m = j + 1;
          if (m < i2)
          {
            char c2 = paramString.charAt(m);
            if (Character.isLowSurrogate(c2))
            {
              j -= n + 1;
              k = i;
              if (j > 0)
              {
                localETSegment = createTextSegment(j, i);
                localETSegment.textSize = paramETFont.getSize();
                k = i + j;
                localArrayList.add(localETSegment);
              }
              localETSegment = createEmojiSegment(c1, c2);
              localETSegment.textSize = paramETFont.getSize();
              localArrayList.add(localETSegment);
              i = m;
              m = i;
              i1 = i;
              break label247;
            }
          }
        }
        int k = i;
        int i1 = j;
        m = n;
        if (j + 1 == i2)
        {
          k = i2 - (n + 1);
          localETSegment = createTextSegment(k, i);
          localETSegment.textSize = paramETFont.getSize();
          k = i + k;
          localArrayList.add(localETSegment);
          m = i2;
          i1 = j;
        }
        label247:
        j = i1 + 1;
        i = k;
      }
      return (ETSegment[])localArrayList.toArray(new ETSegment[localArrayList.size()]);
    }
    return null;
  }
  
  private static ETSegment createTextSegment(int paramInt1, int paramInt2)
  {
    ETSegment localETSegment = new ETSegment();
    localETSegment.type = 0;
    localETSegment.textLength = paramInt1;
    localETSegment.textOffset = paramInt2;
    localETSegment.codePoint = -1;
    return localETSegment;
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
    long l = this.mNativeDescriptorHandle;
    if (l != 0L)
    {
      this.mEngine.native_emoticonDeleteDescriptor(l);
      this.mNativeDescriptorHandle = 0L;
    }
  }
  
  public void drawFrame(Bitmap paramBitmap)
  {
    int i = currentFrameIndex();
    ETEngine localETEngine = this.mEngine;
    if ((localETEngine != null) && (i >= 0) && (i < this.mFrameNum)) {
      localETEngine.native_emoticonDrawFrame(this.mNativeDescriptorHandle, i, this.mFont, paramBitmap);
    }
  }
  
  public int getFrameDelay()
  {
    return this.mFrameDelay;
  }
  
  public int getFrameNum()
  {
    return this.mFrameNum;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getHeightByIndex(int paramInt, ETFont paramETFont)
  {
    ETEngine localETEngine = this.mEngine;
    if (localETEngine != null) {
      return localETEngine.native_emoticonGetHeightByIndex(paramInt, paramETFont);
    }
    return 0;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public int getWidthByIndex(int paramInt, ETFont paramETFont)
  {
    ETEngine localETEngine = this.mEngine;
    if (localETEngine != null) {
      return localETEngine.native_emoticonGetWidthByIndex(paramInt, paramETFont);
    }
    return 0;
  }
  
  public void gotoFirstFrame()
  {
    this.mFrameIndex = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.EMEmoticon
 * JD-Core Version:    0.7.0.1
 */