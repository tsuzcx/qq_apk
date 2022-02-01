package com.etrump.mixlayout;

import android.graphics.Typeface;
import com.etrump.mixlayout.api.IETFont;

public class ETFont
  implements IETFont
{
  public static final int ET_COLOR_BLACK = -16777216;
  public static final int ET_FONT_STYLE_BOLD = 1;
  public static final int ET_FONT_STYLE_CROCHET = 8;
  public static final int ET_FONT_STYLE_SHADOW = 128;
  public long mAnimationId;
  public int mBackgroundId;
  public int mComboIndex = 0;
  public String mContactId;
  public String mContactName;
  private int mCrochetColor;
  private int mCrochetWidth;
  private String mDIYConfigString;
  private boolean mDisableBackground = false;
  private boolean mDisableCrochet = true;
  private boolean mDisableShadow = true;
  public String mDiyFontImageId = "";
  public long mDiyHandle;
  public int mFontColor;
  public int mFontId;
  public String mFontPath;
  public int mFontSize;
  public final int mFontSizeMin = 8;
  private int mFontStyle;
  public int mFontType;
  public int mHeightGap;
  private int mShadowBlurRadius;
  private int mShadowColor;
  private int mShadowOffsetX;
  private int mShadowOffsetY;
  public boolean mShouldDisplayAnimation;
  public long mSubstitution = 0L;
  public CharSequence mText;
  public Typeface mTypeface;
  public int mWidthGap;
  
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
    this.mDiyHandle = 0L;
    this.mWidthGap = 0;
    this.mHeightGap = 0;
    this.mSubstitution = 0L;
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
    this.mDiyHandle = 0L;
    this.mWidthGap = 0;
    this.mHeightGap = 0;
    this.mSubstitution = 0L;
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
  
  public void copy(IETFont paramIETFont)
  {
    paramIETFont = (ETFont)paramIETFont;
    if (paramIETFont != null)
    {
      this.mFontId = paramIETFont.mFontId;
      this.mFontPath = paramIETFont.mFontPath;
      this.mFontSize = paramIETFont.mFontSize;
      this.mFontColor = paramIETFont.mFontColor;
      this.mFontStyle = paramIETFont.mFontStyle;
      this.mShadowColor = paramIETFont.mShadowColor;
      this.mShadowOffsetX = paramIETFont.mShadowOffsetX;
      this.mShadowOffsetY = paramIETFont.mShadowOffsetY;
      this.mShadowBlurRadius = paramIETFont.mShadowBlurRadius;
      this.mCrochetColor = paramIETFont.mCrochetColor;
      this.mCrochetWidth = paramIETFont.mCrochetWidth;
      this.mDisableBackground = paramIETFont.mDisableBackground;
      this.mDisableShadow = paramIETFont.mDisableShadow;
      this.mDisableCrochet = paramIETFont.mDisableCrochet;
      this.mBackgroundId = paramIETFont.mBackgroundId;
      this.mFontType = paramIETFont.mFontType;
      this.mText = paramIETFont.mText;
      this.mAnimationId = paramIETFont.mAnimationId;
      this.mContactId = paramIETFont.mContactId;
      this.mContactName = paramIETFont.mContactName;
      setDIYConfigHandle(paramIETFont.getDIYConfigHandle());
      this.mComboIndex = paramIETFont.mComboIndex;
      this.mWidthGap = paramIETFont.mWidthGap;
      this.mHeightGap = paramIETFont.mHeightGap;
      this.mSubstitution = ETSubstitutionConfig.b(paramIETFont.mSubstitution);
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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (ETFont)paramObject;
    boolean bool1 = bool2;
    if (this.mFontId == paramObject.mFontId)
    {
      bool1 = bool2;
      if (this.mFontSize == paramObject.mFontSize)
      {
        bool1 = bool2;
        if (this.mFontStyle == paramObject.mFontStyle)
        {
          bool1 = bool2;
          if (this.mDiyHandle == paramObject.mDiyHandle) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int getColor()
  {
    return this.mFontColor;
  }
  
  public long getDIYConfigHandle()
  {
    return this.mDiyHandle;
  }
  
  public int getFontType()
  {
    return this.mFontType;
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
  
  public long get_substitution()
  {
    return this.mSubstitution;
  }
  
  public boolean isBold()
  {
    return (this.mFontStyle & 0x1) != 0;
  }
  
  public void onDestroy()
  {
    long l = this.mDiyHandle;
    if (0L != l) {
      ETDIYConfig.a(l);
    }
    l = this.mSubstitution;
    if (l != 0L)
    {
      ETSubstitutionConfig.a(l);
      this.mDiyFontImageId = "";
    }
  }
  
  public void parseDIYJsonString(String paramString)
  {
    if (paramString.length() == 0) {
      return;
    }
    this.mDIYConfigString = paramString;
    this.mDiyHandle = ETDIYConfig.a(this, paramString);
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
    this.mDiyHandle = paramLong;
  }
  
  public void setFontType(int paramInt)
  {
    this.mFontType = paramInt;
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
    int j = (int)paramFloat;
    int i = j;
    if (j < 8) {
      i = 8;
    }
    this.mFontSize = i;
  }
  
  public void set_substitution(long paramLong)
  {
    long l = this.mSubstitution;
    if (l != 0L)
    {
      ETSubstitutionConfig.a(l);
      this.mSubstitution = 0L;
    }
    this.mSubstitution = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ETFont{mFontId=");
    localStringBuilder.append(this.mFontId);
    localStringBuilder.append(", mFontPath='");
    localStringBuilder.append(this.mFontPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mText=");
    localStringBuilder.append(this.mText);
    localStringBuilder.append(", color = ");
    localStringBuilder.append(this.mFontColor);
    localStringBuilder.append(", style = ");
    localStringBuilder.append(this.mFontStyle);
    localStringBuilder.append(", size = ");
    localStringBuilder.append(this.mFontSize);
    localStringBuilder.append(", diyHandle = ");
    localStringBuilder.append(this.mDiyHandle);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETFont
 * JD-Core Version:    0.7.0.1
 */