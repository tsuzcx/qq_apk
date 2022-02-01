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
    if (this.hasBackgroundColor) {
      return this.backgroundColor;
    }
    throw new IllegalStateException("Background color has not been defined.");
  }
  
  public int getFontColor()
  {
    if (this.hasFontColor) {
      return this.fontColor;
    }
    throw new IllegalStateException("Font color has not been defined.");
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
    if ((this.bold == -1) && (this.italic == -1)) {
      return -1;
    }
    int i = this.bold;
    int j = 0;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.italic == 1) {
      j = 2;
    }
    return i | j;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public TtmlStyle setFontColor(int paramInt)
  {
    boolean bool;
    if (this.inheritableStyle == null) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    this.fontColor = paramInt;
    this.hasFontColor = true;
    return this;
  }
  
  public TtmlStyle setFontFamily(String paramString)
  {
    boolean bool;
    if (this.inheritableStyle == null) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    this.fontFamily = paramString;
    return this;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public TtmlStyle setLinethrough(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public TtmlStyle setTextAlign(Layout.Alignment paramAlignment)
  {
    this.textAlign = paramAlignment;
    return this;
  }
  
  public TtmlStyle setUnderline(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.ttml.TtmlStyle
 * JD-Core Version:    0.7.0.1
 */