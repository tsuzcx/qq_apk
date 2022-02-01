package com.etrump.mixlayout;

import android.graphics.Typeface;
import fl;

public class ETFont
{
  public static final int ET_COLOR_BLACK = -16777216;
  public static final int ET_FONT_STYLE_BOLD = 1;
  public static final int ET_FONT_STYLE_CROCHET = 8;
  public static final int ET_FONT_STYLE_SHADOW = 128;
  public long mAnimationId;
  public int mBackgroundId;
  public String mContactId;
  public String mContactName;
  private int mCrochetColor;
  private int mCrochetWidth;
  private String mDIYConfigString;
  private boolean mDisableBackground;
  private boolean mDisableCrochet = true;
  private boolean mDisableShadow = true;
  public int mFontColor;
  public int mFontId;
  public String mFontPath;
  public int mFontSize;
  public final int mFontSizeMin = 8;
  private int mFontStyle;
  public int mFontType;
  private int mShadowBlurRadius;
  private int mShadowColor;
  private int mShadowOffsetX;
  private int mShadowOffsetY;
  public boolean mShouldDisplayAnimation;
  public CharSequence mText;
  public Typeface mTypeface;
  public int m_comboIndex;
  public long m_diyHandle;
  
  public ETFont()
  {
    this.mFontId = 0;
    this.mFontPath = "";
    setSize(48.0F);
  }
  
  public ETFont(int paramInt, String paramString, float paramFloat)
  {
    this.mFontId = paramInt;
    this.mFontPath = paramString;
    setSize(paramFloat);
    this.mFontColor = -16777216;
    this.mFontStyle = 0;
    this.m_diyHandle = 0L;
  }
  
  public ETFont(int paramInt1, String paramString, float paramFloat, int paramInt2, Typeface paramTypeface)
  {
    this.mFontId = paramInt1;
    this.mFontPath = paramString;
    setSize(paramFloat);
    this.mFontColor = -16777216;
    this.mFontStyle = 0;
    this.mFontType = paramInt2;
    this.mTypeface = paramTypeface;
    this.m_diyHandle = 0L;
  }
  
  public static ETFont createFont(ETFont paramETFont)
  {
    if (paramETFont == null) {
      return null;
    }
    ETFont localETFont = new ETFont();
    localETFont.copy(paramETFont);
    return localETFont;
  }
  
  public void copy(ETFont paramETFont)
  {
    if (paramETFont != null)
    {
      this.mFontId = paramETFont.mFontId;
      this.mFontPath = paramETFont.mFontPath;
      this.mFontSize = paramETFont.mFontSize;
      this.mFontColor = paramETFont.mFontColor;
      this.mFontStyle = paramETFont.mFontStyle;
      this.mShadowColor = paramETFont.mShadowColor;
      this.mShadowOffsetX = paramETFont.mShadowOffsetX;
      this.mShadowOffsetY = paramETFont.mShadowOffsetY;
      this.mShadowBlurRadius = paramETFont.mShadowBlurRadius;
      this.mCrochetColor = paramETFont.mCrochetColor;
      this.mCrochetWidth = paramETFont.mCrochetWidth;
      this.mDisableBackground = paramETFont.mDisableBackground;
      this.mDisableShadow = paramETFont.mDisableShadow;
      this.mDisableCrochet = paramETFont.mDisableCrochet;
      this.mBackgroundId = paramETFont.mBackgroundId;
      this.mFontType = paramETFont.mFontType;
      this.mText = paramETFont.mText;
      this.mAnimationId = paramETFont.mAnimationId;
      this.mContactId = paramETFont.mContactId;
      this.mContactName = paramETFont.mContactName;
      setDIYConfigHandle(paramETFont.getDIYConfigHandle());
      this.m_comboIndex = paramETFont.m_comboIndex;
    }
  }
  
  public void disableEffects(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mDisableBackground = paramBoolean1;
    this.mDisableShadow = paramBoolean2;
    this.mDisableCrochet = paramBoolean3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ETFont)paramObject;
    } while ((this.mFontId != paramObject.mFontId) || (this.mFontSize != paramObject.mFontSize) || (this.mFontStyle != paramObject.mFontStyle) || (this.m_diyHandle != paramObject.m_diyHandle));
    return true;
  }
  
  public int getColor()
  {
    return this.mFontColor;
  }
  
  public long getDIYConfigHandle()
  {
    return this.m_diyHandle;
  }
  
  public int getId()
  {
    return this.mFontId;
  }
  
  public String getPath()
  {
    return this.mFontPath;
  }
  
  public int getSize()
  {
    return this.mFontSize;
  }
  
  public boolean isBold()
  {
    return (this.mFontStyle & 0x1) != 0;
  }
  
  public void onDestroy()
  {
    if (0L != this.m_diyHandle) {
      fl.a(this.m_diyHandle);
    }
  }
  
  public void parseDIYJsonString(String paramString)
  {
    if (paramString.length() == 0) {
      return;
    }
    this.mDIYConfigString = paramString;
    this.m_diyHandle = fl.a(this, paramString);
  }
  
  public void setBold(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFontStyle |= 0x1;
      return;
    }
    this.mFontStyle &= 0xFFFFFFFE;
  }
  
  public void setColor(int paramInt)
  {
    this.mFontColor = paramInt;
  }
  
  public void setCrochet(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      this.mCrochetColor = paramInt1;
      this.mCrochetWidth = paramInt2;
      this.mFontStyle |= 0x8;
      return;
    }
    this.mFontStyle &= 0xFFFFFFF7;
  }
  
  public void setDIYConfigHandle(long paramLong)
  {
    this.m_diyHandle = paramLong;
  }
  
  public void setId(int paramInt)
  {
    this.mFontId = paramInt;
  }
  
  public void setPath(String paramString)
  {
    this.mFontPath = paramString;
  }
  
  public void setShadow(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      this.mShadowColor = paramInt1;
      this.mShadowOffsetX = paramInt2;
      this.mShadowOffsetY = paramInt3;
      this.mShadowBlurRadius = paramInt4;
      this.mFontStyle |= 0x80;
      return;
    }
    this.mFontStyle &= 0xFFFFFF7F;
  }
  
  public void setSize(float paramFloat)
  {
    int i = 8;
    int j = (int)paramFloat;
    if (j < 8) {}
    for (;;)
    {
      this.mFontSize = i;
      return;
      i = j;
    }
  }
  
  public String toString()
  {
    return "ETFont{mFontId=" + this.mFontId + ", mFontPath='" + this.mFontPath + '\'' + ", mText=" + this.mText + ", color = " + this.mFontColor + ", style = " + this.mFontStyle + ", size = " + this.mFontSize + ", diyHandle = " + this.m_diyHandle + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.ETFont
 * JD-Core Version:    0.7.0.1
 */