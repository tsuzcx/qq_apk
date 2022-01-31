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
    if ((paramParsableByteArray.readUnsignedByte() & 0x80) != 0) {}
    for (int i = 1;; i = 0)
    {
      int j = paramInt - 4;
      paramInt = j;
      if (i != 0)
      {
        if (j < 7) {
          break;
        }
        paramInt = paramParsableByteArray.readUnsignedInt24();
        if (paramInt < 4) {
          break;
        }
        this.bitmapWidth = paramParsableByteArray.readUnsignedShort();
        this.bitmapHeight = paramParsableByteArray.readUnsignedShort();
        this.bitmapData.reset(paramInt - 4);
        paramInt = j - 7;
      }
      i = this.bitmapData.getPosition();
      j = this.bitmapData.limit();
      if ((i >= j) || (paramInt <= 0)) {
        break;
      }
      paramInt = Math.min(paramInt, j - i);
      paramParsableByteArray.readBytes(this.bitmapData.data, i, paramInt);
      this.bitmapData.setPosition(paramInt + i);
      return;
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
      int i1 = paramParsableByteArray.readUnsignedByte();
      int n = paramParsableByteArray.readUnsignedByte();
      int i2 = paramParsableByteArray.readUnsignedByte();
      int k = paramParsableByteArray.readUnsignedByte();
      int m = (int)(i1 + 1.402D * (n - 128));
      n = (int)(i1 - 0.34414D * (i2 - 128) - 0.71414D * (n - 128));
      i1 = (int)(i1 + 1.772D * (i2 - 128));
      int[] arrayOfInt = this.colors;
      m = Util.constrainValue(m, 0, 255);
      n = Util.constrainValue(n, 0, 255);
      arrayOfInt[j] = (Util.constrainValue(i1, 0, 255) | n << 8 | k << 24 | m << 16);
      paramInt += 1;
    }
    this.colorsSet = true;
  }
  
  public Cue build()
  {
    if ((this.planeWidth == 0) || (this.planeHeight == 0) || (this.bitmapWidth == 0) || (this.bitmapHeight == 0) || (this.bitmapData.limit() == 0) || (this.bitmapData.getPosition() != this.bitmapData.limit()) || (!this.colorsSet)) {
      return null;
    }
    this.bitmapData.setPosition(0);
    int[] arrayOfInt = new int[this.bitmapWidth * this.bitmapHeight];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      int j = this.bitmapData.readUnsignedByte();
      if (j != 0)
      {
        arrayOfInt[i] = this.colors[j];
        i += 1;
      }
      else
      {
        int k = this.bitmapData.readUnsignedByte();
        if (k != 0)
        {
          if ((k & 0x40) == 0)
          {
            j = k & 0x3F;
            label147:
            if ((k & 0x80) != 0) {
              break label193;
            }
          }
          label193:
          for (k = 0;; k = this.colors[this.bitmapData.readUnsignedByte()])
          {
            Arrays.fill(arrayOfInt, i, i + j, k);
            i += j;
            break;
            j = (k & 0x3F) << 8 | this.bitmapData.readUnsignedByte();
            break label147;
          }
        }
      }
    }
    return new Cue(Bitmap.createBitmap(arrayOfInt, this.bitmapWidth, this.bitmapHeight, Bitmap.Config.ARGB_8888), this.bitmapX / this.planeWidth, 0, this.bitmapY / this.planeHeight, 0, this.bitmapWidth / this.planeWidth, this.bitmapHeight / this.planeHeight);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.pgs.PgsDecoder.CueBuilder
 * JD-Core Version:    0.7.0.1
 */