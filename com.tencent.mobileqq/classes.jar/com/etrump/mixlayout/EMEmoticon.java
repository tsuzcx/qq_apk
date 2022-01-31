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
  private ETEngine mEngine;
  public ETFont mFont;
  private int mFrameDelay;
  private int mFrameIndex = -1;
  private int mFrameNum;
  private int mHeight;
  private long mNativeDescriptorHandle;
  public String mText;
  private int mWidth;
  
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
    localPaint.setAlpha((int)(255.0F * paramFloat5));
    if (!paramBoolean1) {
      localPaint.setStyle(Paint.Style.STROKE);
    }
    paramCanvas.save();
    paramCanvas.setMatrix(paramMatrix);
    if ((paramBoolean2) && (paramBoolean1))
    {
      paramFloat1 = paramFloat8;
      if (0.0F == paramFloat8) {
        paramFloat1 = 0.1F;
      }
      Object localObject = new float[9];
      paramMatrix.getValues((float[])localObject);
      localObject[2] = 0.0F;
      localObject[5] = 0.0F;
      paramMatrix = new Matrix();
      paramMatrix.setValues((float[])localObject);
      localObject = new Matrix();
      float f = paramFloat6;
      paramFloat8 = paramFloat7;
      if (paramMatrix.invert((Matrix)localObject))
      {
        paramMatrix = new float[2];
        ((Matrix)localObject).mapPoints(paramMatrix, new float[] { paramFloat6, paramFloat7 });
        f = paramMatrix[0];
        paramFloat8 = paramMatrix[1];
      }
      localPaint.setShadowLayer(paramFloat1, f, paramFloat8, paramInt3);
    }
    if (paramBoolean3)
    {
      paramMatrix = new Paint(1);
      paramMatrix.setStyle(Paint.Style.STROKE);
      paramMatrix.setColor(paramInt4);
      paramMatrix.setStrokeWidth(paramFloat9);
      paramMatrix.setTextSize(paramFloat4);
      paramMatrix.setAlpha((int)(255.0F * paramFloat5));
      paramCanvas.drawText(str, 0.0F, Math.abs(paramMatrix.getFontMetricsInt().ascent) + paramFloat3, paramMatrix);
    }
    paramCanvas.drawText(str, paramFloat2, Math.abs(localPaint.getFontMetricsInt().ascent) + paramFloat3, localPaint);
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
    if ((paramETEngine == null) || (TextUtils.isEmpty(paramString))) {
      paramETEngine = null;
    }
    EMEmoticon localEMEmoticon;
    do
    {
      return paramETEngine;
      long l = paramETEngine.native_emoticonCreateDescriptor(paramString, createSegments(paramString, paramETFont), paramInt, paramETFont, 0);
      if (0L == l) {
        return null;
      }
      localEMEmoticon = new EMEmoticon();
      localEMEmoticon.mEngine = paramETEngine;
      localEMEmoticon.mNativeDescriptorHandle = l;
      localEMEmoticon.mFrameNum = localEMEmoticon.mEngine.native_emoticonGetFrameNum(l);
      localEMEmoticon.mWidth = localEMEmoticon.mEngine.native_emoticonGetWidth(l);
      localEMEmoticon.mHeight = localEMEmoticon.mEngine.native_emoticonGetHeight(l);
      localEMEmoticon.mText = paramString;
      localEMEmoticon.mFont = paramETFont;
      localEMEmoticon.mFrameDelay = paramETEngine.native_emoticonGetFrameDelay(l, 0);
      paramETEngine = localEMEmoticon;
    } while (localEMEmoticon.mFrameDelay >= 50);
    localEMEmoticon.mFrameDelay = 50;
    return localEMEmoticon;
  }
  
  private static ETSegment[] createSegments(String paramString, ETFont paramETFont)
  {
    int i = 0;
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    int k = -1;
    ArrayList localArrayList = new ArrayList();
    int n = paramString.length();
    int j = 0;
    int m;
    ETSegment localETSegment;
    if (i < n)
    {
      char c1 = paramString.charAt(i);
      if ((Character.isHighSurrogate(c1)) && (i + 1 < n))
      {
        char c2 = paramString.charAt(i + 1);
        if (Character.isLowSurrogate(c2))
        {
          m = k + 1;
          k = j;
          if (i - m > 0)
          {
            k = i - m;
            localETSegment = createTextSegment(k, j);
            localETSegment.textSize = paramETFont.getSize();
            k = j + k;
            localArrayList.add(localETSegment);
          }
          localETSegment = createEmojiSegment(c1, c2);
          localETSegment.textSize = paramETFont.getSize();
          localArrayList.add(localETSegment);
          j = i + 1;
          i = j;
          m = k;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      m = j + 1;
      j = i;
      i = m;
      break;
      if (i + 1 == n)
      {
        m = n - (k + 1);
        localETSegment = createTextSegment(m, j);
        localETSegment.textSize = paramETFont.getSize();
        localArrayList.add(localETSegment);
        k = n;
        m = j + m;
        j = i;
        i = m;
        continue;
        return (ETSegment[])localArrayList.toArray(new ETSegment[localArrayList.size()]);
      }
      else
      {
        m = j;
        j = i;
        i = m;
      }
    }
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
    if (this.mNativeDescriptorHandle != 0L)
    {
      this.mEngine.native_emoticonDeleteDescriptor(this.mNativeDescriptorHandle);
      this.mNativeDescriptorHandle = 0L;
    }
  }
  
  public void drawFrame(Bitmap paramBitmap)
  {
    int i = currentFrameIndex();
    if ((this.mEngine != null) && (i >= 0) && (i < this.mFrameNum)) {
      this.mEngine.native_emoticonDrawFrame(this.mNativeDescriptorHandle, i, this.mFont, paramBitmap);
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
    int i = 0;
    if (this.mEngine != null) {
      i = this.mEngine.native_emoticonGetHeightByIndex(paramInt, paramETFont);
    }
    return i;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public int getWidthByIndex(int paramInt, ETFont paramETFont)
  {
    int i = 0;
    if (this.mEngine != null) {
      i = this.mEngine.native_emoticonGetWidthByIndex(paramInt, paramETFont);
    }
    return i;
  }
  
  public void gotoFirstFrame()
  {
    this.mFrameIndex = 0;
  }
  
  public void gotoFrame(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mFrameNum)) {
      return;
    }
    this.mFrameIndex = paramInt;
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
 * Qualified Name:     com.etrump.mixlayout.EMEmoticon
 * JD-Core Version:    0.7.0.1
 */