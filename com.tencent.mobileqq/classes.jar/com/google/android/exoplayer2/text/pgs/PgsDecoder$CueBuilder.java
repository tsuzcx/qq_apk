package com.google.android.exoplayer2.text.pgs;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

final class PgsDecoder$CueBuilder
{
  private final ParsableByteArray bitmapData = new ParsableByteArray();
  private int bitmapHeight;
  private int bitmapWidth;
  private int bitmapX;
  private int bitmapY;
  private final int[] colors = new int[256];
  private boolean colorsSet;
  private int planeHeight;
  private int planeWidth;
  
  private void parseBitmapSection(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    if (paramInt < 4) {
      return;
    }
    paramParsableByteArray.skipBytes(3);
    if ((paramParsableByteArray.readUnsignedByte() & 0x80) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramInt - 4;
    paramInt = j;
    if (i != 0)
    {
      if (j < 7) {
        return;
      }
      paramInt = paramParsableByteArray.readUnsignedInt24();
      if (paramInt < 4) {
        return;
      }
      this.bitmapWidth = paramParsableByteArray.readUnsignedShort();
      this.bitmapHeight = paramParsableByteArray.readUnsignedShort();
      this.bitmapData.reset(paramInt - 4);
      paramInt = j - 7;
    }
    int i = this.bitmapData.getPosition();
    j = this.bitmapData.limit();
    if ((i < j) && (paramInt > 0))
    {
      paramInt = Math.min(paramInt, j - i);
      paramParsableByteArray.readBytes(this.bitmapData.data, i, paramInt);
      this.bitmapData.setPosition(i + paramInt);
    }
  }
  
  private void parseIdentifierSection(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    if (paramInt < 19) {
      return;
    }
    this.planeWidth = paramParsableByteArray.readUnsignedShort();
    this.planeHeight = paramParsableByteArray.readUnsignedShort();
    paramParsableByteArray.skipBytes(11);
    this.bitmapX = paramParsableByteArray.readUnsignedShort();
    this.bitmapY = paramParsableByteArray.readUnsignedShort();
  }
  
  private void parsePaletteSection(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    if (paramInt % 5 != 2) {
      return;
    }
    paramParsableByteArray.skipBytes(2);
    Arrays.fill(this.colors, 0);
    int i = paramInt / 5;
    paramInt = 0;
    while (paramInt < i)
    {
      int j = paramParsableByteArray.readUnsignedByte();
      int n = paramParsableByteArray.readUnsignedByte();
      int i1 = paramParsableByteArray.readUnsignedByte();
      int m = paramParsableByteArray.readUnsignedByte();
      int k = paramParsableByteArray.readUnsignedByte();
      double d1 = n;
      double d2 = i1 - 128;
      Double.isNaN(d2);
      Double.isNaN(d1);
      n = (int)(1.402D * d2 + d1);
      double d3 = m - 128;
      Double.isNaN(d3);
      Double.isNaN(d1);
      Double.isNaN(d2);
      i1 = (int)(d1 - 0.34414D * d3 - d2 * 0.71414D);
      Double.isNaN(d3);
      Double.isNaN(d1);
      m = (int)(d1 + d3 * 1.772D);
      int[] arrayOfInt = this.colors;
      n = Util.constrainValue(n, 0, 255);
      i1 = Util.constrainValue(i1, 0, 255);
      arrayOfInt[j] = (Util.constrainValue(m, 0, 255) | i1 << 8 | k << 24 | n << 16);
      paramInt += 1;
    }
    this.colorsSet = true;
  }
  
  public Cue build()
  {
    if ((this.planeWidth != 0) && (this.planeHeight != 0) && (this.bitmapWidth != 0) && (this.bitmapHeight != 0) && (this.bitmapData.limit() != 0) && (this.bitmapData.getPosition() == this.bitmapData.limit()) && (this.colorsSet))
    {
      this.bitmapData.setPosition(0);
      Object localObject = new int[this.bitmapWidth * this.bitmapHeight];
      int i = 0;
      if (i < localObject.length)
      {
        int k = this.bitmapData.readUnsignedByte();
        if (k != 0)
        {
          j = i + 1;
          localObject[i] = this.colors[k];
        }
        for (i = j;; i = j)
        {
          break;
          k = this.bitmapData.readUnsignedByte();
          if (k == 0) {
            break;
          }
          if ((k & 0x40) == 0) {
            j = k & 0x3F;
          } else {
            j = (k & 0x3F) << 8 | this.bitmapData.readUnsignedByte();
          }
          if ((k & 0x80) == 0) {
            k = 0;
          } else {
            k = this.colors[this.bitmapData.readUnsignedByte()];
          }
          j += i;
          Arrays.fill((int[])localObject, i, j, k);
        }
      }
      localObject = Bitmap.createBitmap((int[])localObject, this.bitmapWidth, this.bitmapHeight, Bitmap.Config.ARGB_8888);
      float f1 = this.bitmapX;
      i = this.planeWidth;
      f1 /= i;
      float f2 = this.bitmapY;
      int j = this.planeHeight;
      return new Cue((Bitmap)localObject, f1, 0, f2 / j, 0, this.bitmapWidth / i, this.bitmapHeight / j);
    }
    return null;
  }
  
  public void reset()
  {
    this.planeWidth = 0;
    this.planeHeight = 0;
    this.bitmapX = 0;
    this.bitmapY = 0;
    this.bitmapWidth = 0;
    this.bitmapHeight = 0;
    this.bitmapData.reset(0);
    this.colorsSet = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.pgs.PgsDecoder.CueBuilder
 * JD-Core Version:    0.7.0.1
 */