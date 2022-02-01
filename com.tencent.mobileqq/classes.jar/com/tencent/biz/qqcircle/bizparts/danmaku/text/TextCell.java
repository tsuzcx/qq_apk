package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import aadv;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.MotionEvent;
import anzj;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import vhx;
import vil;
import vwt;

public class TextCell
  implements Serializable, Cloneable
{
  protected static double FADE_LENGTH = vwt.b(10.0F);
  protected static double FADE_SCALE = 0.0D;
  protected static double FADE_START_INTERVAL = 100.0D;
  public static final int FLAG_EMO = 256;
  public static final int FLAG_EMO_MASK = 1044480;
  public static final int FLAG_EMO_SEQ = 4096;
  public static final int FLAG_LINEBREAK_MASK = 267386880;
  public static final int FLAG_LINEBREAK_SEQ = 1048576;
  public static final int FLAG_TYPE_MASK = 255;
  public static final int SIGN_ADV_SUMMARY = 17;
  public static final int SIGN_COLOR = 9;
  public static final int SIGN_COMMENT = 7;
  public static final int SIGN_ELLIPSIS = 20;
  public static final int SIGN_FEED_OWNER = 6;
  public static final int SIGN_GOTO_DETAIL = 5;
  public static final int SIGN_LIKE_NICKNAME = 19;
  public static final int SIGN_LINEBREAK = 16;
  public static final int SIGN_MORE = 10;
  public static final int SIGN_NORMAL = 0;
  public static final int SIGN_PACK_OR_UNPACK = 18;
  public static final int SIGN_REPLY = 8;
  public static final int SIGN_TOPIC = 1;
  public static final int SIGN_URL = 4;
  public static final int SIGN_USER = 3;
  public static final int SIGN_WALL = 2;
  private static Paint a;
  static final String ellipsis = "...";
  private static final long serialVersionUID = 5342730555874002105L;
  private boolean canCopy = true;
  public int cellIndex;
  public int commentSpanHeight;
  public float fontSize;
  public boolean isDrawableLoaded = true;
  public boolean isPresseding;
  public MotionEvent lastClickEvent;
  public int linebreak;
  public int linebreakSeq;
  protected int linkColor;
  protected float mAscent = -1.0F;
  protected float mDefaultAscent = -1.0F;
  protected float mDefaultDescent = -1.0F;
  protected float mDescent = -1.0F;
  protected String mFontFamilyUrl;
  protected int mShadowColor;
  protected int mShadowRadius;
  protected int mShadowX;
  protected int mShadowY;
  public int maxCommentHeight;
  public boolean needHighLight;
  private Pair<Integer, Integer> points;
  public String post;
  public transient Rect rect;
  public String text;
  protected int textColor;
  public int type;
  protected Long uin;
  private String url;
  public boolean useDefaultFont;
  protected boolean useHanyiColorFont = true;
  public boolean useSuperFont = true;
  
  static
  {
    FADE_SCALE = 200.0D;
  }
  
  public TextCell()
  {
    this.type = 0;
  }
  
  public TextCell(int paramInt)
  {
    this.type = paramInt;
  }
  
  public TextCell(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.text = paramString;
  }
  
  private float a(Paint paramPaint)
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (TextUtils.isEmpty(this.text)) {}
    Typeface localTypeface;
    Paint localPaint;
    do
    {
      return f2;
      localTypeface = initFontInfo(paramPaint);
      if (!this.useDefaultFont)
      {
        localPaint = paramPaint;
        if (this.useHanyiColorFont) {}
      }
      else
      {
        localPaint = paramPaint;
        if ((paramPaint instanceof vhx)) {
          localPaint = ((vhx)paramPaint).a();
        }
      }
      int j = this.text.length();
      int i = 0;
      while (i < j)
      {
        int k = Character.charCount(this.text.codePointAt(i));
        f2 = localPaint.measureText(this.text, i, i + k);
        i += k;
        f1 = f2 + f1;
      }
      f2 = f1;
    } while (localTypeface == null);
    localPaint.setTypeface(localTypeface);
    return f1;
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, int paramInt1, String paramString, Rect paramRect, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    paramPaint.setAlpha(paramInt3);
    if ((paramPaint instanceof vhx))
    {
      ((vhx)paramPaint).a(paramString, paramInt1, paramRect.left, paramRect.top, paramCanvas, paramBitmap);
      return;
    }
    paramCanvas.drawText(paramString, paramRect.left, paramInt2, paramPaint);
  }
  
  protected static Paint getShellDebugPaint()
  {
    if (a == null)
    {
      a = new Paint();
      a.setStyle(Paint.Style.STROKE);
      a.setColor(-6737203);
    }
    return a;
  }
  
  public boolean canBreak()
  {
    return true;
  }
  
  public boolean canCopy()
  {
    return this.canCopy;
  }
  
  public boolean clickable()
  {
    int i = this.type & 0xFF;
    return (i != 0) && (i != 16) && (i != 7) && (i != 8);
  }
  
  public TextCell copy()
  {
    try
    {
      TextCell localTextCell = (TextCell)clone();
      return localTextCell;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint, int paramInt1, Rect paramRect, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    Typeface localTypeface = initFontInfo(paramPaint);
    if (((this.useDefaultFont) || (!this.useHanyiColorFont)) && ((paramPaint instanceof vhx))) {}
    for (Paint localPaint = ((vhx)paramPaint).a();; localPaint = paramPaint)
    {
      Shader localShader;
      float f;
      if ((this.type & 0xFF) == 0)
      {
        localPaint.setColor(paramInt2);
        if (this.useSuperFont) {
          break label352;
        }
        localShader = localPaint.getShader();
        localPaint.setShader(null);
        localPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        f = localPaint.getTextSize();
        localPaint.setTextSize(this.fontSize);
      }
      for (;;)
      {
        for (;;)
        {
          paramInt2 = paramRect.top;
          paramInt3 = (int)((paramInt1 - getDescent(localPaint) - getAscent(localPaint)) / 2.0F);
          paramPaint = this.text;
          if (this.text.endsWith("\r\n"))
          {
            paramPaint = this.text.substring(0, this.text.length() - 2);
            label165:
            if (!TextUtils.isEmpty(this.mFontFamilyUrl)) {
              aadv.b(localPaint, this.mFontFamilyUrl);
            }
          }
          try
          {
            if ((localPaint instanceof vhx)) {
              ((vhx)localPaint).a(paramPaint, paramInt1, paramRect.left, paramRect.top, paramCanvas, paramBitmap);
            }
            for (;;)
            {
              localPaint.setTypeface(localTypeface);
              if (!this.useSuperFont)
              {
                localPaint.setTextSize(f);
                localPaint.setShader(localShader);
                localPaint.setShadowLayer(this.mShadowRadius, this.mShadowX, this.mShadowY, this.mShadowColor);
              }
              return;
              localPaint.setColor(paramInt3);
              break;
              if (!this.text.endsWith("\n")) {
                break label165;
              }
              paramPaint = this.text.substring(0, this.text.length() - 1);
              break label165;
              paramCanvas.drawText(paramPaint, paramRect.left, paramInt2 + paramInt3, localPaint);
            }
          }
          catch (Throwable paramCanvas)
          {
            for (;;)
            {
              QZLog.e("TextCell", "", paramCanvas);
            }
          }
        }
        label352:
        f = 0.0F;
        localShader = null;
      }
    }
  }
  
  public boolean fadedDraw(Canvas paramCanvas, Paint paramPaint, int paramInt1, Rect paramRect, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4, long paramLong)
  {
    Object localObject = initFontInfo(paramPaint);
    if (((this.useDefaultFont) || (!this.useHanyiColorFont)) && ((paramPaint instanceof vhx))) {}
    for (Paint localPaint = ((vhx)paramPaint).a();; localPaint = paramPaint)
    {
      int j;
      if ((this.type & 0xFF) == 0)
      {
        localPaint.setColor(paramInt2);
        j = paramRect.top + (int)((paramInt1 - getDescent(localPaint) - getAscent(localPaint)) / 2.0F);
        paramPaint = this.text;
        if (!this.text.endsWith("\r\n")) {
          break label299;
        }
        paramPaint = this.text.substring(0, this.text.length() - 2);
      }
      label165:
      label299:
      label468:
      label474:
      for (;;)
      {
        label118:
        if (localObject != null) {
          localPaint.setTypeface((Typeface)localObject);
        }
        paramInt2 = (int)Math.floor(paramLong / FADE_START_INTERVAL) - paramInt4;
        boolean bool;
        if (paramInt2 >= paramPaint.length())
        {
          paramInt2 = paramPaint.length();
          bool = false;
        }
        for (;;)
        {
          int k = localPaint.getAlpha();
          if (paramInt2 > 0) {
            a(paramCanvas, localPaint, paramInt1, paramPaint.substring(0, paramInt2), paramRect, j, paramBitmap, 255);
          }
          localObject = anzj.a(2131713654);
          double d1 = localPaint.measureText((String)localObject + (String)localObject) - localPaint.measureText((String)localObject) * 2.0F;
          for (;;)
          {
            if (paramInt2 < paramPaint.length())
            {
              d2 = paramLong - (paramInt2 + paramInt4) * FADE_START_INTERVAL;
              if (d2 > 0.0D) {}
            }
            else
            {
              localPaint.setAlpha(k);
              return bool;
              localPaint.setColor(paramInt3);
              break;
              if (!this.text.endsWith("\n")) {
                break label474;
              }
              paramPaint = this.text.substring(0, this.text.length() - 1);
              break label118;
              if (paramInt2 >= 0) {
                break label468;
              }
              bool = true;
              paramInt2 = 0;
              break label165;
            }
            double d2 = d2 % FADE_SCALE / FADE_SCALE;
            int m = (int)(255.0D * d2);
            int i = (int)((1.0D - d2) * FADE_LENGTH) + paramRect.left;
            paramInt3 = i;
            if (paramInt2 != 0) {
              paramInt3 = (int)(i + ((int)localPaint.measureText(paramPaint, 0, paramInt2) + d1));
            }
            localObject = new Rect(paramRect);
            ((Rect)localObject).left = paramInt3;
            a(paramCanvas, localPaint, paramInt1, paramPaint.substring(paramInt2, paramInt2 + 1), (Rect)localObject, j, paramBitmap, m);
            paramInt2 += 1;
          }
          bool = true;
        }
      }
    }
  }
  
  protected float getAscent(Paint paramPaint)
  {
    if ((this.useDefaultFont) || (!this.useHanyiColorFont) || (!this.useSuperFont))
    {
      if (this.mDefaultAscent <= 0.0F) {
        this.mDefaultAscent = paramPaint.ascent();
      }
      return this.mDefaultAscent;
    }
    if (this.mAscent <= 0.0F) {
      return paramPaint.ascent();
    }
    return this.mAscent;
  }
  
  protected float getDescent(Paint paramPaint)
  {
    if ((this.useDefaultFont) || (!this.useHanyiColorFont) || (!this.useSuperFont))
    {
      if (this.mDefaultDescent <= 0.0F) {
        this.mDefaultDescent = paramPaint.descent();
      }
      return this.mDefaultDescent;
    }
    if (this.mDescent <= 0.0F) {
      return paramPaint.descent();
    }
    return this.mDescent;
  }
  
  public int getDrawTextLength()
  {
    if (this.text.endsWith("\r\n")) {
      return this.text.length() - 2;
    }
    if (this.text.endsWith("\n")) {
      return this.text.length() - 1;
    }
    return this.text.length();
  }
  
  public int getHeight(Paint paramPaint)
  {
    Typeface localTypeface = initFontInfo(paramPaint);
    Paint localPaint;
    if (!this.useDefaultFont)
    {
      localPaint = paramPaint;
      if (this.useHanyiColorFont) {}
    }
    else
    {
      localPaint = paramPaint;
      if ((paramPaint instanceof vhx)) {
        localPaint = ((vhx)paramPaint).a();
      }
    }
    int i = (int)(getDescent(localPaint) - getAscent(localPaint));
    if (localTypeface != null) {
      localPaint.setTypeface(localTypeface);
    }
    return i;
  }
  
  public Intent getIntent()
  {
    return null;
  }
  
  public int getLength()
  {
    if (this.text != null) {
      return this.text.length();
    }
    return 0;
  }
  
  public Pair<Integer, Integer> getPoint()
  {
    return this.points;
  }
  
  public String getPost()
  {
    if (!TextUtils.isEmpty(this.post)) {
      return this.post;
    }
    return "";
  }
  
  public ClickableSpan getSpan()
  {
    return new vil(this);
  }
  
  public String getText()
  {
    if (this.text == null) {
      return "";
    }
    return this.text;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public Long getUin()
  {
    return this.uin;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public float getWidth(Paint paramPaint)
  {
    Typeface localTypeface = initFontInfo(paramPaint);
    Paint localPaint;
    if (!this.useDefaultFont)
    {
      localPaint = paramPaint;
      if (this.useHanyiColorFont) {}
    }
    else
    {
      localPaint = paramPaint;
      if ((paramPaint instanceof vhx)) {
        localPaint = ((vhx)paramPaint).a();
      }
    }
    float f = localPaint.measureText(this.text);
    if (f > 0.0F) {}
    for (;;)
    {
      if (localTypeface != null) {
        localPaint.setTypeface(localTypeface);
      }
      return f;
      f = a(localPaint);
    }
  }
  
  public int getWidths(Paint paramPaint, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    int i = 0;
    if (TextUtils.isEmpty(this.text)) {}
    Typeface localTypeface;
    Paint localPaint;
    do
    {
      do
      {
        return i;
        int j = paramInt1 + paramInt2;
        paramInt2 = j;
        if (j > this.text.length()) {
          paramInt2 = this.text.length();
        }
      } while (paramInt1 >= paramInt2);
      localTypeface = initFontInfo(paramPaint);
      if (!this.useDefaultFont)
      {
        localPaint = paramPaint;
        if (this.useHanyiColorFont) {}
      }
      else
      {
        localPaint = paramPaint;
        if ((paramPaint instanceof vhx)) {
          localPaint = ((vhx)paramPaint).a();
        }
      }
      paramInt1 = localPaint.getTextWidths(this.text, paramInt1, paramInt2, paramArrayOfFloat);
      i = paramInt1;
    } while (localTypeface == null);
    localPaint.setTypeface(localTypeface);
    return paramInt1;
  }
  
  protected Typeface initFontInfo(Paint paramPaint)
  {
    Paint localPaint1;
    int i;
    if ((!this.useHanyiColorFont) && ((paramPaint instanceof vhx)))
    {
      localPaint1 = ((vhx)paramPaint).a();
      paramPaint = localPaint1.getTypeface();
      localPaint1.setTypeface(null);
      i = 1;
    }
    for (;;)
    {
      Object localObject = paramPaint;
      if (this.useDefaultFont)
      {
        localPaint2 = localPaint1;
        if ((localPaint1 instanceof vhx)) {
          localPaint2 = ((vhx)localPaint1).a();
        }
        localObject = paramPaint;
        if (i == 0)
        {
          localObject = localPaint2.getTypeface();
          localPaint2.setTypeface(null);
        }
      }
      return localObject;
      i = 0;
      Paint localPaint2 = null;
      localPaint1 = paramPaint;
      paramPaint = localPaint2;
    }
  }
  
  public boolean isEmo()
  {
    return false;
  }
  
  public void setCanCopy(boolean paramBoolean)
  {
    this.canCopy = paramBoolean;
  }
  
  public void setDefaultShadowLayer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mShadowRadius = paramInt1;
    this.mShadowX = paramInt2;
    this.mShadowY = paramInt3;
    this.mShadowColor = paramInt4;
  }
  
  public void setFontFamilyUrl(String paramString)
  {
    this.mFontFamilyUrl = paramString;
  }
  
  public void setFontSize(Paint paramPaint, float paramFloat)
  {
    this.fontSize = paramFloat;
    this.mDescent = paramPaint.descent();
    this.mAscent = paramPaint.ascent();
    this.mDefaultDescent = -1.0F;
    this.mDefaultAscent = -1.0F;
  }
  
  public void setLinkColor(int paramInt)
  {
    this.linkColor = paramInt;
  }
  
  public void setPoint(int paramInt1, int paramInt2)
  {
    this.points = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void setPost(String paramString)
  {
    this.post = paramString;
  }
  
  public void setUin(Long paramLong)
  {
    this.uin = paramLong;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell
 * JD-Core Version:    0.7.0.1
 */