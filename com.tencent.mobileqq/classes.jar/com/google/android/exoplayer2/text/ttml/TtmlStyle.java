package com.google.android.exoplayer2.text.ttml;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.util.Assertions;

final class TtmlStyle
{
  public static final int FONT_SIZE_UNIT_EM = 2;
  public static final int FONT_SIZE_UNIT_PERCENT = 3;
  public static final int FONT_SIZE_UNIT_PIXEL = 1;
  private static final int OFF = 0;
  private static final int ON = 1;
  public static final int STYLE_BOLD = 1;
  public static final int STYLE_BOLD_ITALIC = 3;
  public static final int STYLE_ITALIC = 2;
  public static final int STYLE_NORMAL = 0;
  public static final int UNSPECIFIED = -1;
  private int backgroundColor;
  private int bold = -1;
  private int fontColor;
  private String fontFamily;
  private float fontSize;
  private int fontSizeUnit = -1;
  private boolean hasBackgroundColor;
  private boolean hasFontColor;
  private String id;
  private TtmlStyle inheritableStyle;
  private int italic = -1;
  private int linethrough = -1;
  private Layout.Alignment textAlign;
  private int underline = -1;
  
  private TtmlStyle inherit(TtmlStyle paramTtmlStyle, boolean paramBoolean)
  {
    if (paramTtmlStyle != null)
    {
      if ((!this.hasFontColor) && (paramTtmlStyle.hasFontColor)) {
        setFontColor(paramTtmlStyle.fontColor);
      }
      if (this.bold == -1) {
        this.bold = paramTtmlStyle.bold;
      }
      if (this.italic == -1) {
        this.italic = paramTtmlStyle.italic;
      }
      if (this.fontFamily == null) {
        this.fontFamily = paramTtmlStyle.fontFamily;
      }
      if (this.linethrough == -1) {
        this.linethrough = paramTtmlStyle.linethrough;
      }
      if (this.underline == -1) {
        this.underline = paramTtmlStyle.underline;
      }
      if (this.textAlign == null) {
        this.textAlign = paramTtmlStyle.textAlign;
      }
      if (this.fontSizeUnit == -1)
      {
        this.fontSizeUnit = paramTtmlStyle.fontSizeUnit;
        this.fontSize = paramTtmlStyle.fontSize;
      }
      if ((paramBoolean) && (!this.hasBackgroundColor) && (paramTtmlStyle.hasBackgroundColor)) {
        setBackgroundColor(paramTtmlStyle.backgroundColor);
      }
    }
    return this;
  }
  
  public TtmlStyle chain(TtmlStyle paramTtmlStyle)
  {
    return inherit(paramTtmlStyle, true);
  }
  
  public int getBackgroundColor()
  {
    if (!this.hasBackgroundColor) {
      throw new IllegalStateException("Background color has not been defined.");
    }
    return this.backgroundColor;
  }
  
  public int getFontColor()
  {
    if (!this.hasFontColor) {
      throw new IllegalStateException("Font color has not been defined.");
    }
    return this.fontColor;
  }
  
  public String getFontFamily()
  {
    return this.fontFamily;
  }
  
  public float getFontSize()
  {
    return this.fontSize;
  }
  
  public int getFontSizeUnit()
  {
    return this.fontSizeUnit;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public int getStyle()
  {
    int j = 0;
    if ((this.bold == -1) && (this.italic == -1)) {
      return -1;
    }
    if (this.bold == 1) {}
    for (int i = 1;; i = 0)
    {
      if (this.italic == 1) {
        j = 2;
      }
      return i | j;
    }
  }
  
  public Layout.Alignment getTextAlign()
  {
    return this.textAlign;
  }
  
  public boolean hasBackgroundColor()
  {
    return this.hasBackgroundColor;
  }
  
  public boolean hasFontColor()
  {
    return this.hasFontColor;
  }
  
  public TtmlStyle inherit(TtmlStyle paramTtmlStyle)
  {
    return inherit(paramTtmlStyle, false);
  }
  
  public boolean isLinethrough()
  {
    return this.linethrough == 1;
  }
  
  public boolean isUnderline()
  {
    return this.underline == 1;
  }
  
  public TtmlStyle setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
    this.hasBackgroundColor = true;
    return this;
  }
  
  public TtmlStyle setBold(boolean paramBoolean)
  {
    int i = 1;
    boolean bool;
    if (this.inheritableStyle == null)
    {
      bool = true;
      Assertions.checkState(bool);
      if (!paramBoolean) {
        break label31;
      }
    }
    for (;;)
    {
      this.bold = i;
      return this;
      bool = false;
      break;
      label31:
      i = 0;
    }
  }
  
  public TtmlStyle setFontColor(int paramInt)
  {
    if (this.inheritableStyle == null) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.fontColor = paramInt;
      this.hasFontColor = true;
      return this;
    }
  }
  
  public TtmlStyle setFontFamily(String paramString)
  {
    if (this.inheritableStyle == null) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.fontFamily = paramString;
      return this;
    }
  }
  
  public TtmlStyle setFontSize(float paramFloat)
  {
    this.fontSize = paramFloat;
    return this;
  }
  
  public TtmlStyle setFontSizeUnit(int paramInt)
  {
    this.fontSizeUnit = paramInt;
    return this;
  }
  
  public TtmlStyle setId(String paramString)
  {
    this.id = paramString;
    return this;
  }
  
  public TtmlStyle setItalic(boolean paramBoolean)
  {
    int i = 1;
    boolean bool;
    if (this.inheritableStyle == null)
    {
      bool = true;
      Assertions.checkState(bool);
      if (!paramBoolean) {
        break label31;
      }
    }
    for (;;)
    {
      this.italic = i;
      return this;
      bool = false;
      break;
      label31:
      i = 0;
    }
  }
  
  public TtmlStyle setLinethrough(boolean paramBoolean)
  {
    int i = 1;
    boolean bool;
    if (this.inheritableStyle == null)
    {
      bool = true;
      Assertions.checkState(bool);
      if (!paramBoolean) {
        break label31;
      }
    }
    for (;;)
    {
      this.linethrough = i;
      return this;
      bool = false;
      break;
      label31:
      i = 0;
    }
  }
  
  public TtmlStyle setTextAlign(Layout.Alignment paramAlignment)
  {
    this.textAlign = paramAlignment;
    return this;
  }
  
  public TtmlStyle setUnderline(boolean paramBoolean)
  {
    int i = 1;
    boolean bool;
    if (this.inheritableStyle == null)
    {
      bool = true;
      Assertions.checkState(bool);
      if (!paramBoolean) {
        break label31;
      }
    }
    for (;;)
    {
      this.underline = i;
      return this;
      bool = false;
      break;
      label31:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.text.ttml.TtmlStyle
 * JD-Core Version:    0.7.0.1
 */