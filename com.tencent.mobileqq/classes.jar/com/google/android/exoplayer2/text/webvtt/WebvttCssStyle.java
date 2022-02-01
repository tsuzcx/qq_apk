package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class WebvttCssStyle
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
  private int bold;
  private int fontColor;
  private String fontFamily;
  private float fontSize;
  private int fontSizeUnit;
  private boolean hasBackgroundColor;
  private boolean hasFontColor;
  private int italic;
  private int linethrough;
  private List<String> targetClasses;
  private String targetId;
  private String targetTag;
  private String targetVoice;
  private Layout.Alignment textAlign;
  private int underline;
  
  public WebvttCssStyle()
  {
    reset();
  }
  
  private static int updateScoreForMatch(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (!paramString1.isEmpty())
    {
      int i = -1;
      if (paramInt1 == -1) {
        return paramInt1;
      }
      if (paramString1.equals(paramString2)) {
        i = paramInt1 + paramInt2;
      }
      return i;
    }
    return paramInt1;
  }
  
  public void cascadeFrom(WebvttCssStyle paramWebvttCssStyle)
  {
    if (paramWebvttCssStyle.hasFontColor) {
      setFontColor(paramWebvttCssStyle.fontColor);
    }
    int i = paramWebvttCssStyle.bold;
    if (i != -1) {
      this.bold = i;
    }
    i = paramWebvttCssStyle.italic;
    if (i != -1) {
      this.italic = i;
    }
    String str = paramWebvttCssStyle.fontFamily;
    if (str != null) {
      this.fontFamily = str;
    }
    if (this.linethrough == -1) {
      this.linethrough = paramWebvttCssStyle.linethrough;
    }
    if (this.underline == -1) {
      this.underline = paramWebvttCssStyle.underline;
    }
    if (this.textAlign == null) {
      this.textAlign = paramWebvttCssStyle.textAlign;
    }
    if (this.fontSizeUnit == -1)
    {
      this.fontSizeUnit = paramWebvttCssStyle.fontSizeUnit;
      this.fontSize = paramWebvttCssStyle.fontSize;
    }
    if (paramWebvttCssStyle.hasBackgroundColor) {
      setBackgroundColor(paramWebvttCssStyle.backgroundColor);
    }
  }
  
  public int getBackgroundColor()
  {
    if (this.hasBackgroundColor) {
      return this.backgroundColor;
    }
    throw new IllegalStateException("Background color not defined.");
  }
  
  public int getFontColor()
  {
    if (this.hasFontColor) {
      return this.fontColor;
    }
    throw new IllegalStateException("Font color not defined");
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
  
  public int getSpecificityScore(String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
  
  public boolean isLinethrough()
  {
    return this.linethrough == 1;
  }
  
  public boolean isUnderline()
  {
    return this.underline == 1;
  }
  
  public void reset()
  {
    this.targetId = "";
    this.targetTag = "";
    this.targetClasses = Collections.emptyList();
    this.targetVoice = "";
    this.fontFamily = null;
    this.hasFontColor = false;
    this.hasBackgroundColor = false;
    this.linethrough = -1;
    this.underline = -1;
    this.bold = -1;
    this.italic = -1;
    this.fontSizeUnit = -1;
    this.textAlign = null;
  }
  
  public WebvttCssStyle setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
    this.hasBackgroundColor = true;
    return this;
  }
  
  public WebvttCssStyle setBold(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public WebvttCssStyle setFontColor(int paramInt)
  {
    this.fontColor = paramInt;
    this.hasFontColor = true;
    return this;
  }
  
  public WebvttCssStyle setFontFamily(String paramString)
  {
    this.fontFamily = Util.toLowerInvariant(paramString);
    return this;
  }
  
  public WebvttCssStyle setFontSize(float paramFloat)
  {
    this.fontSize = paramFloat;
    return this;
  }
  
  public WebvttCssStyle setFontSizeUnit(short paramShort)
  {
    this.fontSizeUnit = paramShort;
    return this;
  }
  
  public WebvttCssStyle setItalic(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public WebvttCssStyle setLinethrough(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setTargetClasses(String[] paramArrayOfString)
  {
    this.targetClasses = Arrays.asList(paramArrayOfString);
  }
  
  public void setTargetId(String paramString)
  {
    this.targetId = paramString;
  }
  
  public void setTargetTagName(String paramString)
  {
    this.targetTag = paramString;
  }
  
  public void setTargetVoice(String paramString)
  {
    this.targetVoice = paramString;
  }
  
  public WebvttCssStyle setTextAlign(Layout.Alignment paramAlignment)
  {
    this.textAlign = paramAlignment;
    return this;
  }
  
  public WebvttCssStyle setUnderline(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.WebvttCssStyle
 * JD-Core Version:    0.7.0.1
 */