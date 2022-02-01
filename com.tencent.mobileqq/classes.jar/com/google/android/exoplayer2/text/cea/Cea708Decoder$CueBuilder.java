package com.google.android.exoplayer2.text.cea;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedList;
import java.util.List;

final class Cea708Decoder$CueBuilder
{
  private static final int BORDER_AND_EDGE_TYPE_NONE = 0;
  private static final int BORDER_AND_EDGE_TYPE_UNIFORM = 3;
  public static final int COLOR_SOLID_BLACK;
  public static final int COLOR_SOLID_WHITE = getArgbColorFromCeaColor(2, 2, 2, 0);
  public static final int COLOR_TRANSPARENT;
  private static final int DEFAULT_PRIORITY = 4;
  private static final int DIRECTION_BOTTOM_TO_TOP = 3;
  private static final int DIRECTION_LEFT_TO_RIGHT = 0;
  private static final int DIRECTION_RIGHT_TO_LEFT = 1;
  private static final int DIRECTION_TOP_TO_BOTTOM = 2;
  private static final int HORIZONTAL_SIZE = 209;
  private static final int JUSTIFICATION_CENTER = 2;
  private static final int JUSTIFICATION_FULL = 3;
  private static final int JUSTIFICATION_LEFT = 0;
  private static final int JUSTIFICATION_RIGHT = 1;
  private static final int MAXIMUM_ROW_COUNT = 15;
  private static final int PEN_FONT_STYLE_DEFAULT = 0;
  private static final int PEN_FONT_STYLE_MONOSPACED_WITHOUT_SERIFS = 3;
  private static final int PEN_FONT_STYLE_MONOSPACED_WITH_SERIFS = 1;
  private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITHOUT_SERIFS = 4;
  private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITH_SERIFS = 2;
  private static final int PEN_OFFSET_NORMAL = 1;
  private static final int PEN_SIZE_STANDARD = 1;
  private static final int[] PEN_STYLE_BACKGROUND = { COLOR_SOLID_BLACK, COLOR_SOLID_BLACK, COLOR_SOLID_BLACK, COLOR_SOLID_BLACK, COLOR_SOLID_BLACK, COLOR_TRANSPARENT, COLOR_TRANSPARENT };
  private static final int[] PEN_STYLE_EDGE_TYPE;
  private static final int[] PEN_STYLE_FONT_STYLE;
  private static final int RELATIVE_CUE_SIZE = 99;
  private static final int VERTICAL_SIZE = 74;
  private static final int[] WINDOW_STYLE_FILL;
  private static final int[] WINDOW_STYLE_JUSTIFICATION;
  private static final int[] WINDOW_STYLE_PRINT_DIRECTION;
  private static final int[] WINDOW_STYLE_SCROLL_DIRECTION;
  private static final boolean[] WINDOW_STYLE_WORD_WRAP;
  private int anchorId;
  private int backgroundColor;
  private int backgroundColorStartPosition;
  private final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();
  private boolean defined;
  private int foregroundColor;
  private int foregroundColorStartPosition;
  private int horizontalAnchor;
  private int italicsStartPosition;
  private int justification;
  private int penStyleId;
  private int priority;
  private boolean relativePositioning;
  private final List<SpannableString> rolledUpCaptions = new LinkedList();
  private int row;
  private int rowCount;
  private boolean rowLock;
  private int underlineStartPosition;
  private int verticalAnchor;
  private boolean visible;
  private int windowFillColor;
  private int windowStyleId;
  
  static
  {
    COLOR_SOLID_BLACK = getArgbColorFromCeaColor(0, 0, 0, 0);
    COLOR_TRANSPARENT = getArgbColorFromCeaColor(0, 0, 0, 3);
    WINDOW_STYLE_JUSTIFICATION = new int[] { 0, 0, 0, 0, 0, 2, 0 };
    WINDOW_STYLE_PRINT_DIRECTION = new int[] { 0, 0, 0, 0, 0, 0, 2 };
    WINDOW_STYLE_SCROLL_DIRECTION = new int[] { 3, 3, 3, 3, 3, 3, 1 };
    WINDOW_STYLE_WORD_WRAP = new boolean[] { 0, 0, 0, 1, 1, 1, 0 };
    WINDOW_STYLE_FILL = new int[] { COLOR_SOLID_BLACK, COLOR_TRANSPARENT, COLOR_SOLID_BLACK, COLOR_SOLID_BLACK, COLOR_TRANSPARENT, COLOR_SOLID_BLACK, COLOR_SOLID_BLACK };
    PEN_STYLE_FONT_STYLE = new int[] { 0, 1, 2, 3, 4, 3, 4 };
    PEN_STYLE_EDGE_TYPE = new int[] { 0, 0, 0, 0, 0, 3, 3 };
  }
  
  public Cea708Decoder$CueBuilder()
  {
    reset();
  }
  
  public static int getArgbColorFromCeaColor(int paramInt1, int paramInt2, int paramInt3)
  {
    return getArgbColorFromCeaColor(paramInt1, paramInt2, paramInt3, 0);
  }
  
  public static int getArgbColorFromCeaColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 255;
    Assertions.checkIndex(paramInt1, 0, 4);
    Assertions.checkIndex(paramInt2, 0, 4);
    Assertions.checkIndex(paramInt3, 0, 4);
    Assertions.checkIndex(paramInt4, 0, 4);
    switch (paramInt4)
    {
    default: 
      paramInt4 = 255;
      if (paramInt1 > 1)
      {
        paramInt1 = 255;
        label77:
        if (paramInt2 <= 1) {
          break label125;
        }
        paramInt2 = 255;
        label86:
        if (paramInt3 <= 1) {
          break label130;
        }
      }
      break;
    }
    label130:
    for (paramInt3 = i;; paramInt3 = 0)
    {
      return Color.argb(paramInt4, paramInt1, paramInt2, paramInt3);
      paramInt4 = 255;
      break;
      paramInt4 = 127;
      break;
      paramInt4 = 0;
      break;
      paramInt1 = 0;
      break label77;
      label125:
      paramInt2 = 0;
      break label86;
    }
  }
  
  public void append(char paramChar)
  {
    if (paramChar == '\n')
    {
      this.rolledUpCaptions.add(buildSpannableString());
      this.captionStringBuilder.clear();
      if (this.italicsStartPosition != -1) {
        this.italicsStartPosition = 0;
      }
      if (this.underlineStartPosition != -1) {
        this.underlineStartPosition = 0;
      }
      if (this.foregroundColorStartPosition != -1) {
        this.foregroundColorStartPosition = 0;
      }
      if (this.backgroundColorStartPosition != -1) {
        this.backgroundColorStartPosition = 0;
      }
      while (((this.rowLock) && (this.rolledUpCaptions.size() >= this.rowCount)) || (this.rolledUpCaptions.size() >= 15)) {
        this.rolledUpCaptions.remove(0);
      }
    }
    this.captionStringBuilder.append(paramChar);
  }
  
  public void backspace()
  {
    int i = this.captionStringBuilder.length();
    if (i > 0) {
      this.captionStringBuilder.delete(i - 1, i);
    }
  }
  
  public Cea708Cue build()
  {
    if (isEmpty()) {
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < this.rolledUpCaptions.size())
    {
      localSpannableStringBuilder.append((CharSequence)this.rolledUpCaptions.get(i));
      localSpannableStringBuilder.append('\n');
      i += 1;
    }
    localSpannableStringBuilder.append(buildSpannableString());
    Layout.Alignment localAlignment;
    float f2;
    float f1;
    label172:
    label183:
    int j;
    switch (this.justification)
    {
    default: 
      throw new IllegalArgumentException("Unexpected justification value: " + this.justification);
    case 0: 
    case 3: 
      localAlignment = Layout.Alignment.ALIGN_NORMAL;
      if (this.relativePositioning)
      {
        f2 = this.horizontalAnchor / 99.0F;
        f1 = this.verticalAnchor / 99.0F;
        if (this.anchorId % 3 != 0) {
          break label287;
        }
        i = 0;
        if (this.anchorId / 3 != 0) {
          break label307;
        }
        j = 0;
        label195:
        if (this.windowFillColor == COLOR_SOLID_BLACK) {
          break label329;
        }
      }
      break;
    }
    label287:
    label307:
    label329:
    for (boolean bool = true;; bool = false)
    {
      return new Cea708Cue(localSpannableStringBuilder, localAlignment, f1 * 0.9F + 0.05F, 0, i, f2 * 0.9F + 0.05F, j, 1.4E-45F, bool, this.windowFillColor, this.priority);
      localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
      break;
      localAlignment = Layout.Alignment.ALIGN_CENTER;
      break;
      f2 = this.horizontalAnchor / 209.0F;
      f1 = this.verticalAnchor / 74.0F;
      break label172;
      if (this.anchorId % 3 == 1)
      {
        i = 1;
        break label183;
      }
      i = 2;
      break label183;
      if (this.anchorId / 3 == 1)
      {
        j = 1;
        break label195;
      }
      j = 2;
      break label195;
    }
  }
  
  public SpannableString buildSpannableString()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
    int i = localSpannableStringBuilder.length();
    if (i > 0)
    {
      if (this.italicsStartPosition != -1) {
        localSpannableStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, i, 33);
      }
      if (this.underlineStartPosition != -1) {
        localSpannableStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, i, 33);
      }
      if (this.foregroundColorStartPosition != -1) {
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, i, 33);
      }
      if (this.backgroundColorStartPosition != -1) {
        localSpannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, i, 33);
      }
    }
    return new SpannableString(localSpannableStringBuilder);
  }
  
  public void clear()
  {
    this.rolledUpCaptions.clear();
    this.captionStringBuilder.clear();
    this.italicsStartPosition = -1;
    this.underlineStartPosition = -1;
    this.foregroundColorStartPosition = -1;
    this.backgroundColorStartPosition = -1;
    this.row = 0;
  }
  
  public void defineWindow(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, boolean paramBoolean4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.defined = true;
    this.visible = paramBoolean1;
    this.rowLock = paramBoolean2;
    this.priority = paramInt1;
    this.relativePositioning = paramBoolean4;
    this.verticalAnchor = paramInt2;
    this.horizontalAnchor = paramInt3;
    this.anchorId = paramInt6;
    if (this.rowCount != paramInt4 + 1)
    {
      this.rowCount = (paramInt4 + 1);
      while (((paramBoolean2) && (this.rolledUpCaptions.size() >= this.rowCount)) || (this.rolledUpCaptions.size() >= 15)) {
        this.rolledUpCaptions.remove(0);
      }
    }
    if ((paramInt7 != 0) && (this.windowStyleId != paramInt7))
    {
      this.windowStyleId = paramInt7;
      paramInt1 = paramInt7 - 1;
      setWindowAttributes(WINDOW_STYLE_FILL[paramInt1], COLOR_TRANSPARENT, WINDOW_STYLE_WORD_WRAP[paramInt1], 0, WINDOW_STYLE_PRINT_DIRECTION[paramInt1], WINDOW_STYLE_SCROLL_DIRECTION[paramInt1], WINDOW_STYLE_JUSTIFICATION[paramInt1]);
    }
    if ((paramInt8 != 0) && (this.penStyleId != paramInt8))
    {
      this.penStyleId = paramInt8;
      paramInt1 = paramInt8 - 1;
      setPenAttributes(0, 1, 1, false, false, PEN_STYLE_EDGE_TYPE[paramInt1], PEN_STYLE_FONT_STYLE[paramInt1]);
      setPenColor(COLOR_SOLID_WHITE, PEN_STYLE_BACKGROUND[paramInt1], COLOR_SOLID_BLACK);
    }
  }
  
  public boolean isDefined()
  {
    return this.defined;
  }
  
  public boolean isEmpty()
  {
    return (!isDefined()) || ((this.rolledUpCaptions.isEmpty()) && (this.captionStringBuilder.length() == 0));
  }
  
  public boolean isVisible()
  {
    return this.visible;
  }
  
  public void reset()
  {
    clear();
    this.defined = false;
    this.visible = false;
    this.priority = 4;
    this.relativePositioning = false;
    this.verticalAnchor = 0;
    this.horizontalAnchor = 0;
    this.anchorId = 0;
    this.rowCount = 15;
    this.rowLock = true;
    this.justification = 0;
    this.windowStyleId = 0;
    this.penStyleId = 0;
    this.windowFillColor = COLOR_SOLID_BLACK;
    this.foregroundColor = COLOR_SOLID_WHITE;
    this.backgroundColor = COLOR_SOLID_BLACK;
  }
  
  public void setPenAttributes(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, int paramInt5)
  {
    if (this.italicsStartPosition != -1) {
      if (!paramBoolean1)
      {
        this.captionStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, this.captionStringBuilder.length(), 33);
        this.italicsStartPosition = -1;
      }
    }
    do
    {
      while (this.underlineStartPosition != -1)
      {
        if (!paramBoolean2)
        {
          this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
          this.underlineStartPosition = -1;
        }
        return;
        if (paramBoolean1) {
          this.italicsStartPosition = this.captionStringBuilder.length();
        }
      }
    } while (!paramBoolean2);
    this.underlineStartPosition = this.captionStringBuilder.length();
  }
  
  public void setPenColor(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.foregroundColorStartPosition != -1) && (this.foregroundColor != paramInt1)) {
      this.captionStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, this.captionStringBuilder.length(), 33);
    }
    if (paramInt1 != COLOR_SOLID_WHITE)
    {
      this.foregroundColorStartPosition = this.captionStringBuilder.length();
      this.foregroundColor = paramInt1;
    }
    if ((this.backgroundColorStartPosition != -1) && (this.backgroundColor != paramInt2)) {
      this.captionStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, this.captionStringBuilder.length(), 33);
    }
    if (paramInt2 != COLOR_SOLID_BLACK)
    {
      this.backgroundColorStartPosition = this.captionStringBuilder.length();
      this.backgroundColor = paramInt2;
    }
  }
  
  public void setPenLocation(int paramInt1, int paramInt2)
  {
    if (this.row != paramInt1) {
      append('\n');
    }
    this.row = paramInt1;
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    this.visible = paramBoolean;
  }
  
  public void setWindowAttributes(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.windowFillColor = paramInt1;
    this.justification = paramInt6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.text.cea.Cea708Decoder.CueBuilder
 * JD-Core Version:    0.7.0.1
 */