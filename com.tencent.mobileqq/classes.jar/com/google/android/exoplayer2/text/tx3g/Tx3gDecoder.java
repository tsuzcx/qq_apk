package com.google.android.exoplayer2.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.charset.Charset;
import java.util.List;

public final class Tx3gDecoder
  extends SimpleSubtitleDecoder
{
  private static final char BOM_UTF16_BE = '﻿';
  private static final char BOM_UTF16_LE = '￾';
  private static final int DEFAULT_COLOR = -1;
  private static final int DEFAULT_FONT_FACE = 0;
  private static final String DEFAULT_FONT_FAMILY = "sans-serif";
  private static final float DEFAULT_VERTICAL_PLACEMENT = 0.85F;
  private static final int FONT_FACE_BOLD = 1;
  private static final int FONT_FACE_ITALIC = 2;
  private static final int FONT_FACE_UNDERLINE = 4;
  private static final int SIZE_ATOM_HEADER = 8;
  private static final int SIZE_BOM_UTF16 = 2;
  private static final int SIZE_SHORT = 2;
  private static final int SIZE_STYLE_RECORD = 12;
  private static final int SPAN_PRIORITY_HIGH = 0;
  private static final int SPAN_PRIORITY_LOW = 16711680;
  private static final String TX3G_SERIF = "Serif";
  private static final int TYPE_STYL = Util.getIntegerCodeForString("styl");
  private static final int TYPE_TBOX = Util.getIntegerCodeForString("tbox");
  private int calculatedVideoTrackHeight;
  private boolean customVerticalPlacement;
  private int defaultColorRgba;
  private int defaultFontFace;
  private String defaultFontFamily;
  private float defaultVerticalPlacement;
  private final ParsableByteArray parsableByteArray = new ParsableByteArray();
  
  public Tx3gDecoder(List<byte[]> paramList)
  {
    super("Tx3gDecoder");
    decodeInitializationData(paramList);
  }
  
  private void applyStyleRecord(ParsableByteArray paramParsableByteArray, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramParsableByteArray.bytesLeft() >= 12) {}
    for (boolean bool = true;; bool = false)
    {
      assertTrue(bool);
      int i = paramParsableByteArray.readUnsignedShort();
      int j = paramParsableByteArray.readUnsignedShort();
      paramParsableByteArray.skipBytes(2);
      int k = paramParsableByteArray.readUnsignedByte();
      paramParsableByteArray.skipBytes(1);
      int m = paramParsableByteArray.readInt();
      attachFontFace(paramSpannableStringBuilder, k, this.defaultFontFace, i, j, 0);
      attachColor(paramSpannableStringBuilder, m, this.defaultColorRgba, i, j, 0);
      return;
    }
  }
  
  private static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new SubtitleDecoderException("Unexpected subtitle format.");
    }
  }
  
  private static void attachColor(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 != paramInt2) {
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan((paramInt1 & 0xFF) << 24 | paramInt1 >>> 8), paramInt3, paramInt4, paramInt5 | 0x21);
    }
  }
  
  private static void attachFontFace(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = 1;
    int j;
    if (paramInt1 != paramInt2)
    {
      j = paramInt5 | 0x21;
      if ((paramInt1 & 0x1) == 0) {
        break label118;
      }
      paramInt2 = 1;
      if ((paramInt1 & 0x2) == 0) {
        break label123;
      }
      paramInt5 = 1;
      label32:
      if (paramInt2 == 0) {
        break label149;
      }
      if (paramInt5 == 0) {
        break label129;
      }
      paramSpannableStringBuilder.setSpan(new StyleSpan(3), paramInt3, paramInt4, j);
      label58:
      if ((paramInt1 & 0x4) == 0) {
        break label174;
      }
    }
    label129:
    label149:
    label174:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt3, paramInt4, j);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt5 == 0)) {
        paramSpannableStringBuilder.setSpan(new StyleSpan(0), paramInt3, paramInt4, j);
      }
      return;
      label118:
      paramInt2 = 0;
      break;
      label123:
      paramInt5 = 0;
      break label32;
      paramSpannableStringBuilder.setSpan(new StyleSpan(1), paramInt3, paramInt4, j);
      break label58;
      if (paramInt5 == 0) {
        break label58;
      }
      paramSpannableStringBuilder.setSpan(new StyleSpan(2), paramInt3, paramInt4, j);
      break label58;
    }
  }
  
  private static void attachFontFamily(SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString1 != paramString2) {
      paramSpannableStringBuilder.setSpan(new TypefaceSpan(paramString1), paramInt1, paramInt2, paramInt3 | 0x21);
    }
  }
  
  private void decodeInitializationData(List<byte[]> paramList)
  {
    if ((paramList != null) && (paramList.size() == 1) && ((((byte[])paramList.get(0)).length == 48) || (((byte[])paramList.get(0)).length == 53)))
    {
      byte[] arrayOfByte = (byte[])paramList.get(0);
      this.defaultFontFace = arrayOfByte[24];
      this.defaultColorRgba = ((arrayOfByte[26] & 0xFF) << 24 | (arrayOfByte[27] & 0xFF) << 16 | (arrayOfByte[28] & 0xFF) << 8 | arrayOfByte[29] & 0xFF);
      if ("Serif".equals(new String(arrayOfByte, 43, arrayOfByte.length - 43)))
      {
        paramList = "serif";
        this.defaultFontFamily = paramList;
        this.calculatedVideoTrackHeight = (arrayOfByte[25] * 20);
        if ((arrayOfByte[0] & 0x20) == 0) {
          break label244;
        }
      }
      label244:
      for (boolean bool = true;; bool = false)
      {
        this.customVerticalPlacement = bool;
        if (!this.customVerticalPlacement) {
          break label249;
        }
        int i = arrayOfByte[10];
        this.defaultVerticalPlacement = ((arrayOfByte[11] & 0xFF | (i & 0xFF) << 8) / this.calculatedVideoTrackHeight);
        this.defaultVerticalPlacement = Util.constrainValue(this.defaultVerticalPlacement, 0.0F, 0.95F);
        return;
        paramList = "sans-serif";
        break;
      }
      label249:
      this.defaultVerticalPlacement = 0.85F;
      return;
    }
    this.defaultFontFace = 0;
    this.defaultColorRgba = -1;
    this.defaultFontFamily = "sans-serif";
    this.customVerticalPlacement = false;
    this.defaultVerticalPlacement = 0.85F;
  }
  
  private static String readSubtitleText(ParsableByteArray paramParsableByteArray)
  {
    if (paramParsableByteArray.bytesLeft() >= 2) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      assertTrue(bool);
      i = paramParsableByteArray.readUnsignedShort();
      if (i != 0) {
        break;
      }
      return "";
    }
    if (paramParsableByteArray.bytesLeft() >= 2)
    {
      int j = paramParsableByteArray.peekChar();
      if ((j == 65279) || (j == 65534)) {
        return paramParsableByteArray.readString(i, Charset.forName("UTF-16"));
      }
    }
    return paramParsableByteArray.readString(i, Charset.forName("UTF-8"));
  }
  
  public Subtitle decode(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.parsableByteArray.reset(paramArrayOfByte, paramInt);
    paramArrayOfByte = readSubtitleText(this.parsableByteArray);
    if (paramArrayOfByte.isEmpty()) {
      return Tx3gSubtitle.EMPTY;
    }
    paramArrayOfByte = new SpannableStringBuilder(paramArrayOfByte);
    attachFontFace(paramArrayOfByte, this.defaultFontFace, 0, 0, paramArrayOfByte.length(), 16711680);
    attachColor(paramArrayOfByte, this.defaultColorRgba, -1, 0, paramArrayOfByte.length(), 16711680);
    attachFontFamily(paramArrayOfByte, this.defaultFontFamily, "sans-serif", 0, paramArrayOfByte.length(), 16711680);
    float f1 = this.defaultVerticalPlacement;
    if (this.parsableByteArray.bytesLeft() >= 8)
    {
      int i = this.parsableByteArray.getPosition();
      int j = this.parsableByteArray.readInt();
      paramInt = this.parsableByteArray.readInt();
      if (paramInt == TYPE_STYL)
      {
        if (this.parsableByteArray.bytesLeft() >= 2) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          assertTrue(paramBoolean);
          int k = this.parsableByteArray.readUnsignedShort();
          paramInt = 0;
          for (;;)
          {
            f2 = f1;
            if (paramInt >= k) {
              break;
            }
            applyStyleRecord(this.parsableByteArray, paramArrayOfByte);
            paramInt += 1;
          }
        }
      }
      float f2 = f1;
      if (paramInt == TYPE_TBOX)
      {
        f2 = f1;
        if (this.customVerticalPlacement) {
          if (this.parsableByteArray.bytesLeft() < 2) {
            break label276;
          }
        }
      }
      label276:
      for (paramBoolean = true;; paramBoolean = false)
      {
        assertTrue(paramBoolean);
        f2 = Util.constrainValue(this.parsableByteArray.readUnsignedShort() / this.calculatedVideoTrackHeight, 0.0F, 0.95F);
        this.parsableByteArray.setPosition(i + j);
        f1 = f2;
        break;
      }
    }
    return new Tx3gSubtitle(new Cue(paramArrayOfByte, null, f1, 0, 0, 1.4E-45F, -2147483648, 1.4E-45F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.text.tx3g.Tx3gDecoder
 * JD-Core Version:    0.7.0.1
 */