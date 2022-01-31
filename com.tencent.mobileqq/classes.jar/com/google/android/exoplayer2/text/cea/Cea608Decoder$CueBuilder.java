package com.google.android.exoplayer2.text.cea;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import java.util.ArrayList;
import java.util.List;

class Cea608Decoder$CueBuilder
{
  private static final int BASE_ROW = 15;
  private static final int POSITION_UNSET = -1;
  private static final int SCREEN_CHARWIDTH = 32;
  private int captionMode;
  private int captionRowCount;
  private final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();
  private int indent;
  private final List<Cea608Decoder.CueBuilder.CueStyle> midrowStyles = new ArrayList();
  private final List<CharacterStyle> preambleStyles = new ArrayList();
  private final List<SpannableString> rolledUpCaptions = new ArrayList();
  private int row;
  private int tabOffset;
  private int underlineStartPosition;
  
  public Cea608Decoder$CueBuilder(int paramInt1, int paramInt2)
  {
    reset(paramInt1);
    setCaptionRowCount(paramInt2);
  }
  
  public void append(char paramChar)
  {
    this.captionStringBuilder.append(paramChar);
  }
  
  public void backspace()
  {
    int i = this.captionStringBuilder.length();
    if (i > 0) {
      this.captionStringBuilder.delete(i - 1, i);
    }
  }
  
  public Cue build()
  {
    int k = 2;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < this.rolledUpCaptions.size())
    {
      localSpannableStringBuilder.append((CharSequence)this.rolledUpCaptions.get(i));
      localSpannableStringBuilder.append('\n');
      i += 1;
    }
    localSpannableStringBuilder.append(buildSpannableString());
    if (localSpannableStringBuilder.length() == 0) {
      return null;
    }
    i = this.indent + this.tabOffset;
    int j = 32 - i - localSpannableStringBuilder.length();
    int m = i - j;
    float f;
    if ((this.captionMode == 2) && ((Math.abs(m) < 3) || (j < 0)))
    {
      f = 0.5F;
      i = 1;
      if ((this.captionMode != 1) && (this.row <= 7)) {
        break label232;
      }
      j = this.row - 15 - 2;
    }
    for (;;)
    {
      return new Cue(localSpannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, j, 1, k, f, i, 1.4E-45F);
      if ((this.captionMode == 2) && (m > 0))
      {
        f = (32 - j) / 32.0F * 0.8F + 0.1F;
        i = 2;
        break;
      }
      f = i / 32.0F * 0.8F + 0.1F;
      i = 0;
      break;
      label232:
      j = this.row;
      k = 0;
    }
  }
  
  public SpannableString buildSpannableString()
  {
    int k = this.captionStringBuilder.length();
    int i = 0;
    while (i < this.preambleStyles.size())
    {
      this.captionStringBuilder.setSpan(this.preambleStyles.get(i), 0, k, 33);
      i += 1;
    }
    i = 0;
    if (i < this.midrowStyles.size())
    {
      Cea608Decoder.CueBuilder.CueStyle localCueStyle = (Cea608Decoder.CueBuilder.CueStyle)this.midrowStyles.get(i);
      if (i < this.midrowStyles.size() - localCueStyle.nextStyleIncrement) {}
      for (int j = ((Cea608Decoder.CueBuilder.CueStyle)this.midrowStyles.get(localCueStyle.nextStyleIncrement + i)).start;; j = k)
      {
        this.captionStringBuilder.setSpan(localCueStyle.style, localCueStyle.start, j, 33);
        i += 1;
        break;
      }
    }
    if (this.underlineStartPosition != -1) {
      this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, k, 33);
    }
    return new SpannableString(this.captionStringBuilder);
  }
  
  public int getRow()
  {
    return this.row;
  }
  
  public boolean isEmpty()
  {
    return (this.preambleStyles.isEmpty()) && (this.midrowStyles.isEmpty()) && (this.rolledUpCaptions.isEmpty()) && (this.captionStringBuilder.length() == 0);
  }
  
  public void reset(int paramInt)
  {
    this.captionMode = paramInt;
    this.preambleStyles.clear();
    this.midrowStyles.clear();
    this.rolledUpCaptions.clear();
    this.captionStringBuilder.clear();
    this.row = 15;
    this.indent = 0;
    this.tabOffset = 0;
    this.underlineStartPosition = -1;
  }
  
  public void rollUp()
  {
    this.rolledUpCaptions.add(buildSpannableString());
    this.captionStringBuilder.clear();
    this.preambleStyles.clear();
    this.midrowStyles.clear();
    this.underlineStartPosition = -1;
    int i = Math.min(this.captionRowCount, this.row);
    while (this.rolledUpCaptions.size() >= i) {
      this.rolledUpCaptions.remove(0);
    }
  }
  
  public void setCaptionRowCount(int paramInt)
  {
    this.captionRowCount = paramInt;
  }
  
  public void setIndent(int paramInt)
  {
    this.indent = paramInt;
  }
  
  public void setMidrowStyle(CharacterStyle paramCharacterStyle, int paramInt)
  {
    this.midrowStyles.add(new Cea608Decoder.CueBuilder.CueStyle(paramCharacterStyle, this.captionStringBuilder.length(), paramInt));
  }
  
  public void setPreambleStyle(CharacterStyle paramCharacterStyle)
  {
    this.preambleStyles.add(paramCharacterStyle);
  }
  
  public void setRow(int paramInt)
  {
    this.row = paramInt;
  }
  
  public void setTab(int paramInt)
  {
    this.tabOffset = paramInt;
  }
  
  public void setUnderline(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.underlineStartPosition = this.captionStringBuilder.length();
    }
    while (this.underlineStartPosition == -1) {
      return;
    }
    this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
    this.underlineStartPosition = -1;
  }
  
  public String toString()
  {
    return this.captionStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.cea.Cea608Decoder.CueBuilder
 * JD-Core Version:    0.7.0.1
 */