package com.google.android.exoplayer2.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region.Op;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class DvbParser
{
  private static final int DATA_TYPE_24_TABLE_DATA = 32;
  private static final int DATA_TYPE_28_TABLE_DATA = 33;
  private static final int DATA_TYPE_2BP_CODE_STRING = 16;
  private static final int DATA_TYPE_48_TABLE_DATA = 34;
  private static final int DATA_TYPE_4BP_CODE_STRING = 17;
  private static final int DATA_TYPE_8BP_CODE_STRING = 18;
  private static final int DATA_TYPE_END_LINE = 240;
  private static final int OBJECT_CODING_PIXELS = 0;
  private static final int OBJECT_CODING_STRING = 1;
  private static final int PAGE_STATE_NORMAL = 0;
  private static final int REGION_DEPTH_4_BIT = 2;
  private static final int REGION_DEPTH_8_BIT = 3;
  private static final int SEGMENT_TYPE_CLUT_DEFINITION = 18;
  private static final int SEGMENT_TYPE_DISPLAY_DEFINITION = 20;
  private static final int SEGMENT_TYPE_OBJECT_DATA = 19;
  private static final int SEGMENT_TYPE_PAGE_COMPOSITION = 16;
  private static final int SEGMENT_TYPE_REGION_COMPOSITION = 17;
  private static final String TAG = "DvbParser";
  private static final byte[] defaultMap2To4 = { 0, 7, 8, 15 };
  private static final byte[] defaultMap2To8 = { 0, 119, -120, -1 };
  private static final byte[] defaultMap4To8 = { 0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1 };
  private Bitmap bitmap;
  private final Canvas canvas;
  private final DvbParser.ClutDefinition defaultClutDefinition;
  private final DvbParser.DisplayDefinition defaultDisplayDefinition;
  private final Paint defaultPaint = new Paint();
  private final Paint fillRegionPaint;
  private final DvbParser.SubtitleService subtitleService;
  
  public DvbParser(int paramInt1, int paramInt2)
  {
    this.defaultPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.defaultPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    this.defaultPaint.setPathEffect(null);
    this.fillRegionPaint = new Paint();
    this.fillRegionPaint.setStyle(Paint.Style.FILL);
    this.fillRegionPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
    this.fillRegionPaint.setPathEffect(null);
    this.canvas = new Canvas();
    this.defaultDisplayDefinition = new DvbParser.DisplayDefinition(719, 575, 0, 719, 0, 575);
    this.defaultClutDefinition = new DvbParser.ClutDefinition(0, generateDefault2BitClutEntries(), generateDefault4BitClutEntries(), generateDefault8BitClutEntries());
    this.subtitleService = new DvbParser.SubtitleService(paramInt1, paramInt2);
  }
  
  private static byte[] buildClutMapTable(int paramInt1, int paramInt2, ParsableBitArray paramParsableBitArray)
  {
    byte[] arrayOfByte = new byte[paramInt1];
    int i = 0;
    while (i < paramInt1)
    {
      arrayOfByte[i] = ((byte)paramParsableBitArray.readBits(paramInt2));
      i += 1;
    }
    return arrayOfByte;
  }
  
  private static int[] generateDefault2BitClutEntries()
  {
    return new int[] { 0, -1, -16777216, -8421505 };
  }
  
  private static int[] generateDefault4BitClutEntries()
  {
    int[] arrayOfInt = new int[16];
    arrayOfInt[0] = 0;
    int i = 1;
    while (i < arrayOfInt.length)
    {
      int j;
      int k;
      int m;
      if (i < 8)
      {
        if ((i & 0x1) != 0) {
          j = 255;
        } else {
          j = 0;
        }
        if ((i & 0x2) != 0) {
          k = 255;
        } else {
          k = 0;
        }
        if ((i & 0x4) != 0) {
          m = 255;
        } else {
          m = 0;
        }
        arrayOfInt[i] = getColor(255, j, k, m);
      }
      else
      {
        m = 127;
        if ((i & 0x1) != 0) {
          j = 127;
        } else {
          j = 0;
        }
        if ((i & 0x2) != 0) {
          k = 127;
        } else {
          k = 0;
        }
        if ((i & 0x4) == 0) {
          m = 0;
        }
        arrayOfInt[i] = getColor(255, j, k, m);
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static int[] generateDefault8BitClutEntries()
  {
    int[] arrayOfInt = new int[256];
    arrayOfInt[0] = 0;
    int j = 0;
    while (j < arrayOfInt.length)
    {
      int m = 255;
      int i;
      int k;
      if (j < 8)
      {
        if ((j & 0x1) != 0) {
          i = 255;
        } else {
          i = 0;
        }
        if ((j & 0x2) != 0) {
          k = 255;
        } else {
          k = 0;
        }
        if ((j & 0x4) == 0) {
          m = 0;
        }
        arrayOfInt[j] = getColor(63, i, k, m);
      }
      else
      {
        m = j & 0x88;
        k = 170;
        i = 85;
        int n;
        int i1;
        int i2;
        if (m != 0)
        {
          if (m != 8)
          {
            k = 43;
            if (m != 128)
            {
              if (m == 136)
              {
                if ((j & 0x1) != 0) {
                  m = 43;
                } else {
                  m = 0;
                }
                if ((j & 0x10) != 0) {
                  n = 85;
                } else {
                  n = 0;
                }
                if ((j & 0x2) != 0) {
                  i1 = 43;
                } else {
                  i1 = 0;
                }
                if ((j & 0x20) != 0) {
                  i2 = 85;
                } else {
                  i2 = 0;
                }
                if ((j & 0x4) == 0) {
                  k = 0;
                }
                if ((j & 0x40) == 0) {
                  i = 0;
                }
                arrayOfInt[j] = getColor(255, m + n, i1 + i2, k + i);
              }
            }
            else
            {
              if ((j & 0x1) != 0) {
                m = 43;
              } else {
                m = 0;
              }
              if ((j & 0x10) != 0) {
                n = 85;
              } else {
                n = 0;
              }
              if ((j & 0x2) != 0) {
                i1 = 43;
              } else {
                i1 = 0;
              }
              if ((j & 0x20) != 0) {
                i2 = 85;
              } else {
                i2 = 0;
              }
              if ((j & 0x4) == 0) {
                k = 0;
              }
              if ((j & 0x40) == 0) {
                i = 0;
              }
              arrayOfInt[j] = getColor(255, m + 127 + n, i1 + 127 + i2, k + 127 + i);
            }
          }
          else
          {
            if ((j & 0x1) != 0) {
              m = 85;
            } else {
              m = 0;
            }
            if ((j & 0x10) != 0) {
              n = 170;
            } else {
              n = 0;
            }
            if ((j & 0x2) != 0) {
              i1 = 85;
            } else {
              i1 = 0;
            }
            if ((j & 0x20) != 0) {
              i2 = 170;
            } else {
              i2 = 0;
            }
            if ((j & 0x4) == 0) {
              i = 0;
            }
            if ((j & 0x40) == 0) {
              k = 0;
            }
            arrayOfInt[j] = getColor(127, m + n, i1 + i2, i + k);
          }
        }
        else
        {
          if ((j & 0x1) != 0) {
            m = 85;
          } else {
            m = 0;
          }
          if ((j & 0x10) != 0) {
            n = 170;
          } else {
            n = 0;
          }
          if ((j & 0x2) != 0) {
            i1 = 85;
          } else {
            i1 = 0;
          }
          if ((j & 0x20) != 0) {
            i2 = 170;
          } else {
            i2 = 0;
          }
          if ((j & 0x4) == 0) {
            i = 0;
          }
          if ((j & 0x40) == 0) {
            k = 0;
          }
          arrayOfInt[j] = getColor(255, m + n, i1 + i2, i + k);
        }
      }
      j += 1;
    }
    return arrayOfInt;
  }
  
  private static int getColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  private static int paint2BitPixelCodeString(ParsableBitArray paramParsableBitArray, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, Paint paramPaint, Canvas paramCanvas)
  {
    int i = 0;
    int k = paramInt1;
    for (paramInt1 = i;; paramInt1 = i)
    {
      i = paramParsableBitArray.readBits(2);
      int m;
      int j;
      if (i != 0)
      {
        m = paramInt1;
        j = 1;
        paramInt1 = i;
        i = m;
      }
      else
      {
        if (paramParsableBitArray.readBit())
        {
          j = paramParsableBitArray.readBits(3) + 3;
          i = paramParsableBitArray.readBits(2);
        }
        for (;;)
        {
          m = paramInt1;
          paramInt1 = i;
          i = m;
          break label187;
          if (paramParsableBitArray.readBit())
          {
            i = 0;
            break;
          }
          i = paramParsableBitArray.readBits(2);
          if (i == 0) {
            break label179;
          }
          if (i == 1) {
            break label168;
          }
          if (i != 2)
          {
            if (i != 3)
            {
              i = paramInt1;
              paramInt1 = 0;
              j = 0;
              break label187;
            }
            j = paramParsableBitArray.readBits(8) + 29;
            i = paramParsableBitArray.readBits(2);
          }
          else
          {
            j = paramParsableBitArray.readBits(4) + 12;
            i = paramParsableBitArray.readBits(2);
          }
        }
        label168:
        i = paramInt1;
        paramInt1 = 0;
        j = 2;
        break label187;
        label179:
        paramInt1 = 0;
        j = 0;
        i = 1;
      }
      label187:
      if ((j != 0) && (paramPaint != null))
      {
        m = paramInt1;
        if (paramArrayOfByte != null) {
          m = paramArrayOfByte[paramInt1];
        }
        paramPaint.setColor(paramArrayOfInt[m]);
        paramCanvas.drawRect(k, paramInt2, k + j, paramInt2 + 1, paramPaint);
      }
      k += j;
      if (i != 0) {
        return k;
      }
    }
  }
  
  private static int paint4BitPixelCodeString(ParsableBitArray paramParsableBitArray, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, Paint paramPaint, Canvas paramCanvas)
  {
    int i = 0;
    int k = paramInt1;
    for (paramInt1 = i;; paramInt1 = i)
    {
      i = paramParsableBitArray.readBits(4);
      if (i != 0) {}
      int m;
      int j;
      for (;;)
      {
        m = paramInt1;
        j = 1;
        paramInt1 = i;
        i = m;
        break;
        if (!paramParsableBitArray.readBit())
        {
          j = paramParsableBitArray.readBits(3);
          if (j != 0)
          {
            i = paramInt1;
            j += 2;
            paramInt1 = 0;
            break;
          }
          paramInt1 = 0;
          j = 0;
          i = 1;
          break;
        }
        if (!paramParsableBitArray.readBit())
        {
          j = paramParsableBitArray.readBits(2) + 4;
          i = paramParsableBitArray.readBits(4);
        }
        for (;;)
        {
          m = paramInt1;
          paramInt1 = i;
          i = m;
          break label216;
          i = paramParsableBitArray.readBits(2);
          if (i == 0) {
            break label210;
          }
          if (i == 1) {
            break;
          }
          if (i != 2)
          {
            if (i != 3)
            {
              i = paramInt1;
              paramInt1 = 0;
              j = 0;
              break label216;
            }
            j = paramParsableBitArray.readBits(8) + 25;
            i = paramParsableBitArray.readBits(4);
          }
          else
          {
            j = paramParsableBitArray.readBits(4) + 9;
            i = paramParsableBitArray.readBits(4);
          }
        }
        i = paramInt1;
        paramInt1 = 0;
        j = 2;
        break;
        label210:
        i = 0;
      }
      label216:
      if ((j != 0) && (paramPaint != null))
      {
        m = paramInt1;
        if (paramArrayOfByte != null) {
          m = paramArrayOfByte[paramInt1];
        }
        paramPaint.setColor(paramArrayOfInt[m]);
        paramCanvas.drawRect(k, paramInt2, k + j, paramInt2 + 1, paramPaint);
      }
      k += j;
      if (i != 0) {
        return k;
      }
    }
  }
  
  private static int paint8BitPixelCodeString(ParsableBitArray paramParsableBitArray, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, Paint paramPaint, Canvas paramCanvas)
  {
    int i = 0;
    int k = paramInt1;
    for (paramInt1 = i;; paramInt1 = i)
    {
      int j = paramParsableBitArray.readBits(8);
      int m;
      if (j != 0)
      {
        i = paramInt1;
        paramInt1 = j;
        j = 1;
      }
      else if (!paramParsableBitArray.readBit())
      {
        j = paramParsableBitArray.readBits(7);
        if (j != 0)
        {
          i = paramInt1;
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = 0;
          j = 0;
          i = 1;
        }
      }
      else
      {
        j = paramParsableBitArray.readBits(7);
        m = paramParsableBitArray.readBits(8);
        i = paramInt1;
        paramInt1 = m;
      }
      if ((j != 0) && (paramPaint != null))
      {
        m = paramInt1;
        if (paramArrayOfByte != null) {
          m = paramArrayOfByte[paramInt1];
        }
        paramPaint.setColor(paramArrayOfInt[m]);
        paramCanvas.drawRect(k, paramInt2, k + j, paramInt2 + 1, paramPaint);
      }
      k += j;
      if (i != 0) {
        return k;
      }
    }
  }
  
  private static void paintPixelDataSubBlock(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, Canvas paramCanvas)
  {
    ParsableBitArray localParsableBitArray = new ParsableBitArray(paramArrayOfByte);
    int j = paramInt2;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = arrayOfByte2;
    int i = paramInt3;
    paramInt3 = j;
    while (localParsableBitArray.bitsLeft() != 0)
    {
      j = localParsableBitArray.readBits(8);
      if (j != 240)
      {
        switch (j)
        {
        default: 
          switch (j)
          {
          default: 
            break;
          case 34: 
            paramArrayOfByte = buildClutMapTable(16, 8, localParsableBitArray);
            break;
          case 33: 
            paramArrayOfByte = buildClutMapTable(4, 8, localParsableBitArray);
            arrayOfByte2 = paramArrayOfByte;
            break;
          case 32: 
            arrayOfByte1 = buildClutMapTable(4, 4, localParsableBitArray);
          }
          break;
        case 18: 
          paramInt3 = paint8BitPixelCodeString(localParsableBitArray, paramArrayOfInt, null, paramInt3, i, paramPaint, paramCanvas);
        case 17: 
        case 16: 
          for (;;)
          {
            break;
            if (paramInt1 == 3) {
              paramArrayOfByte = defaultMap4To8;
            } else {
              paramArrayOfByte = null;
            }
            paramInt3 = paint4BitPixelCodeString(localParsableBitArray, paramArrayOfInt, paramArrayOfByte, paramInt3, i, paramPaint, paramCanvas);
            localParsableBitArray.byteAlign();
            continue;
            if (paramInt1 == 3) {
              if (arrayOfByte2 == null) {
                paramArrayOfByte = defaultMap2To8;
              } else {
                paramArrayOfByte = arrayOfByte2;
              }
            }
            for (;;)
            {
              break;
              if (paramInt1 == 2)
              {
                if (arrayOfByte1 == null) {
                  paramArrayOfByte = defaultMap2To4;
                } else {
                  paramArrayOfByte = arrayOfByte1;
                }
              }
              else {
                paramArrayOfByte = null;
              }
            }
            paramInt3 = paint2BitPixelCodeString(localParsableBitArray, paramArrayOfInt, paramArrayOfByte, paramInt3, i, paramPaint, paramCanvas);
            localParsableBitArray.byteAlign();
          }
        }
      }
      else
      {
        i += 2;
        paramInt3 = paramInt2;
      }
    }
  }
  
  private static void paintPixelDataSubBlocks(DvbParser.ObjectData paramObjectData, DvbParser.ClutDefinition paramClutDefinition, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramInt1 == 3) {
      paramClutDefinition = paramClutDefinition.clutEntries8Bit;
    } else if (paramInt1 == 2) {
      paramClutDefinition = paramClutDefinition.clutEntries4Bit;
    } else {
      paramClutDefinition = paramClutDefinition.clutEntries2Bit;
    }
    paintPixelDataSubBlock(paramObjectData.topFieldData, paramClutDefinition, paramInt1, paramInt2, paramInt3, paramPaint, paramCanvas);
    paintPixelDataSubBlock(paramObjectData.bottomFieldData, paramClutDefinition, paramInt1, paramInt2, paramInt3 + 1, paramPaint, paramCanvas);
  }
  
  private static DvbParser.ClutDefinition parseClutDefinition(ParsableBitArray paramParsableBitArray, int paramInt)
  {
    int m = paramParsableBitArray.readBits(8);
    paramParsableBitArray.skipBits(8);
    paramInt -= 2;
    int[] arrayOfInt2 = generateDefault2BitClutEntries();
    int[] arrayOfInt3 = generateDefault4BitClutEntries();
    int[] arrayOfInt4 = generateDefault8BitClutEntries();
    while (paramInt > 0)
    {
      int i1 = paramParsableBitArray.readBits(8);
      int i = paramParsableBitArray.readBits(8);
      paramInt -= 2;
      int[] arrayOfInt1;
      if ((i & 0x80) != 0) {
        arrayOfInt1 = arrayOfInt2;
      } else if ((i & 0x40) != 0) {
        arrayOfInt1 = arrayOfInt3;
      } else {
        arrayOfInt1 = arrayOfInt4;
      }
      if ((i & 0x1) != 0)
      {
        n = paramParsableBitArray.readBits(8);
        k = paramParsableBitArray.readBits(8);
        j = paramParsableBitArray.readBits(8);
        i = paramParsableBitArray.readBits(8);
        paramInt -= 4;
      }
      else
      {
        n = paramParsableBitArray.readBits(6);
        k = paramParsableBitArray.readBits(4);
        j = paramParsableBitArray.readBits(4) << 4;
        i = paramParsableBitArray.readBits(2);
        paramInt -= 2;
        i <<= 6;
        n <<= 2;
        k <<= 4;
      }
      if (n == 0)
      {
        k = 0;
        j = 0;
        i = 255;
      }
      i = (byte)(255 - (i & 0xFF));
      double d1 = n;
      double d2 = k - 128;
      Double.isNaN(d2);
      Double.isNaN(d1);
      int k = (int)(d1 + 1.402D * d2);
      double d3 = j - 128;
      Double.isNaN(d3);
      Double.isNaN(d1);
      Double.isNaN(d2);
      int j = (int)(d1 - 0.34414D * d3 - d2 * 0.71414D);
      Double.isNaN(d3);
      Double.isNaN(d1);
      int n = (int)(d1 + d3 * 1.772D);
      arrayOfInt1[i1] = getColor(i, Util.constrainValue(k, 0, 255), Util.constrainValue(j, 0, 255), Util.constrainValue(n, 0, 255));
    }
    return new DvbParser.ClutDefinition(m, arrayOfInt2, arrayOfInt3, arrayOfInt4);
  }
  
  private static DvbParser.DisplayDefinition parseDisplayDefinition(ParsableBitArray paramParsableBitArray)
  {
    paramParsableBitArray.skipBits(4);
    boolean bool = paramParsableBitArray.readBit();
    paramParsableBitArray.skipBits(3);
    int n = paramParsableBitArray.readBits(16);
    int i1 = paramParsableBitArray.readBits(16);
    int k;
    int i;
    int j;
    int m;
    if (bool)
    {
      k = paramParsableBitArray.readBits(16);
      i = paramParsableBitArray.readBits(16);
      j = paramParsableBitArray.readBits(16);
      m = paramParsableBitArray.readBits(16);
    }
    else
    {
      i = n;
      m = i1;
      k = 0;
      j = 0;
    }
    return new DvbParser.DisplayDefinition(n, i1, k, i, j, m);
  }
  
  private static DvbParser.ObjectData parseObjectData(ParsableBitArray paramParsableBitArray)
  {
    int i = paramParsableBitArray.readBits(16);
    paramParsableBitArray.skipBits(4);
    int j = paramParsableBitArray.readBits(2);
    boolean bool = paramParsableBitArray.readBit();
    paramParsableBitArray.skipBits(1);
    Object localObject2 = null;
    Object localObject1 = null;
    if (j == 1)
    {
      paramParsableBitArray.skipBits(paramParsableBitArray.readBits(8) * 16);
    }
    else if (j == 0)
    {
      j = paramParsableBitArray.readBits(16);
      int k = paramParsableBitArray.readBits(16);
      if (j > 0)
      {
        localObject1 = new byte[j];
        paramParsableBitArray.readBytes((byte[])localObject1, 0, j);
      }
      localObject2 = localObject1;
      if (k > 0)
      {
        localObject2 = new byte[k];
        paramParsableBitArray.readBytes((byte[])localObject2, 0, k);
        paramParsableBitArray = (ParsableBitArray)localObject2;
        break label125;
      }
    }
    paramParsableBitArray = (ParsableBitArray)localObject2;
    localObject1 = localObject2;
    label125:
    return new DvbParser.ObjectData(i, bool, (byte[])localObject1, paramParsableBitArray);
  }
  
  private static DvbParser.PageComposition parsePageComposition(ParsableBitArray paramParsableBitArray, int paramInt)
  {
    int i = paramParsableBitArray.readBits(8);
    int j = paramParsableBitArray.readBits(4);
    int k = paramParsableBitArray.readBits(2);
    paramParsableBitArray.skipBits(2);
    paramInt -= 2;
    SparseArray localSparseArray = new SparseArray();
    while (paramInt > 0)
    {
      int m = paramParsableBitArray.readBits(8);
      paramParsableBitArray.skipBits(8);
      int n = paramParsableBitArray.readBits(16);
      int i1 = paramParsableBitArray.readBits(16);
      paramInt -= 6;
      localSparseArray.put(m, new DvbParser.PageRegion(n, i1));
    }
    return new DvbParser.PageComposition(i, j, k, localSparseArray);
  }
  
  private static DvbParser.RegionComposition parseRegionComposition(ParsableBitArray paramParsableBitArray, int paramInt)
  {
    int n = paramParsableBitArray.readBits(8);
    paramParsableBitArray.skipBits(4);
    boolean bool = paramParsableBitArray.readBit();
    paramParsableBitArray.skipBits(3);
    int i1 = paramParsableBitArray.readBits(16);
    int i2 = paramParsableBitArray.readBits(16);
    int i3 = paramParsableBitArray.readBits(3);
    int i4 = paramParsableBitArray.readBits(3);
    paramParsableBitArray.skipBits(2);
    int i5 = paramParsableBitArray.readBits(8);
    int i6 = paramParsableBitArray.readBits(8);
    int i7 = paramParsableBitArray.readBits(4);
    int i = paramParsableBitArray.readBits(2);
    paramParsableBitArray.skipBits(2);
    paramInt -= 10;
    SparseArray localSparseArray = new SparseArray();
    while (paramInt > 0)
    {
      int i8 = paramParsableBitArray.readBits(16);
      int i9 = paramParsableBitArray.readBits(2);
      int i10 = paramParsableBitArray.readBits(2);
      int i11 = paramParsableBitArray.readBits(12);
      paramParsableBitArray.skipBits(4);
      int i12 = paramParsableBitArray.readBits(12);
      paramInt -= 6;
      int j;
      int k;
      if ((i9 != 1) && (i9 != 2))
      {
        j = 0;
        k = 0;
      }
      else
      {
        j = paramParsableBitArray.readBits(8);
        k = paramParsableBitArray.readBits(8);
        int m = paramInt - 2;
        paramInt = j;
        j = paramInt;
        paramInt = m;
      }
      localSparseArray.put(i8, new DvbParser.RegionObject(i9, i10, i11, i12, j, k));
    }
    return new DvbParser.RegionComposition(n, bool, i1, i2, i3, i4, i5, i6, i7, i, localSparseArray);
  }
  
  private static void parseSubtitlingSegment(ParsableBitArray paramParsableBitArray, DvbParser.SubtitleService paramSubtitleService)
  {
    int i = paramParsableBitArray.readBits(8);
    int j = paramParsableBitArray.readBits(16);
    int k = paramParsableBitArray.readBits(16);
    int m = paramParsableBitArray.getBytePosition();
    if (k * 8 > paramParsableBitArray.bitsLeft())
    {
      Log.w("DvbParser", "Data field length exceeds limit");
      paramParsableBitArray.skipBits(paramParsableBitArray.bitsLeft());
      return;
    }
    Object localObject1;
    Object localObject2;
    switch (i)
    {
    default: 
      break;
    case 20: 
      if (j == paramSubtitleService.subtitlePageId) {
        paramSubtitleService.displayDefinition = parseDisplayDefinition(paramParsableBitArray);
      }
      break;
    case 19: 
      if (j == paramSubtitleService.subtitlePageId)
      {
        localObject1 = parseObjectData(paramParsableBitArray);
        paramSubtitleService.objects.put(((DvbParser.ObjectData)localObject1).id, localObject1);
      }
      else if (j == paramSubtitleService.ancillaryPageId)
      {
        localObject1 = parseObjectData(paramParsableBitArray);
        paramSubtitleService.ancillaryObjects.put(((DvbParser.ObjectData)localObject1).id, localObject1);
      }
      break;
    case 18: 
      if (j == paramSubtitleService.subtitlePageId)
      {
        localObject1 = parseClutDefinition(paramParsableBitArray, k);
        paramSubtitleService.cluts.put(((DvbParser.ClutDefinition)localObject1).id, localObject1);
      }
      else if (j == paramSubtitleService.ancillaryPageId)
      {
        localObject1 = parseClutDefinition(paramParsableBitArray, k);
        paramSubtitleService.ancillaryCluts.put(((DvbParser.ClutDefinition)localObject1).id, localObject1);
      }
      break;
    case 17: 
      localObject1 = paramSubtitleService.pageComposition;
      if ((j == paramSubtitleService.subtitlePageId) && (localObject1 != null))
      {
        localObject2 = parseRegionComposition(paramParsableBitArray, k);
        if (((DvbParser.PageComposition)localObject1).state == 0) {
          ((DvbParser.RegionComposition)localObject2).mergeFrom((DvbParser.RegionComposition)paramSubtitleService.regions.get(((DvbParser.RegionComposition)localObject2).id));
        }
        paramSubtitleService.regions.put(((DvbParser.RegionComposition)localObject2).id, localObject2);
      }
      break;
    case 16: 
      if (j == paramSubtitleService.subtitlePageId)
      {
        localObject1 = paramSubtitleService.pageComposition;
        localObject2 = parsePageComposition(paramParsableBitArray, k);
        if (((DvbParser.PageComposition)localObject2).state != 0)
        {
          paramSubtitleService.pageComposition = ((DvbParser.PageComposition)localObject2);
          paramSubtitleService.regions.clear();
          paramSubtitleService.cluts.clear();
          paramSubtitleService.objects.clear();
        }
        else if ((localObject1 != null) && (((DvbParser.PageComposition)localObject1).version != ((DvbParser.PageComposition)localObject2).version))
        {
          paramSubtitleService.pageComposition = ((DvbParser.PageComposition)localObject2);
        }
      }
      break;
    }
    paramParsableBitArray.skipBytes(m + k - paramParsableBitArray.getBytePosition());
  }
  
  public List<Cue> decode(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new ParsableBitArray(paramArrayOfByte, paramInt);
    while ((paramArrayOfByte.bitsLeft() >= 48) && (paramArrayOfByte.readBits(8) == 15)) {
      parseSubtitlingSegment(paramArrayOfByte, this.subtitleService);
    }
    if (this.subtitleService.pageComposition == null) {
      return Collections.emptyList();
    }
    DvbParser.DisplayDefinition localDisplayDefinition;
    if (this.subtitleService.displayDefinition != null) {
      localDisplayDefinition = this.subtitleService.displayDefinition;
    } else {
      localDisplayDefinition = this.defaultDisplayDefinition;
    }
    if ((this.bitmap == null) || (localDisplayDefinition.width + 1 != this.bitmap.getWidth()) || (localDisplayDefinition.height + 1 != this.bitmap.getHeight()))
    {
      this.bitmap = Bitmap.createBitmap(localDisplayDefinition.width + 1, localDisplayDefinition.height + 1, Bitmap.Config.ARGB_8888);
      this.canvas.setBitmap(this.bitmap);
    }
    ArrayList localArrayList = new ArrayList();
    SparseArray localSparseArray = this.subtitleService.pageComposition.regions;
    int i = 0;
    while (i < localSparseArray.size())
    {
      paramArrayOfByte = (DvbParser.PageRegion)localSparseArray.valueAt(i);
      paramInt = localSparseArray.keyAt(i);
      DvbParser.RegionComposition localRegionComposition = (DvbParser.RegionComposition)this.subtitleService.regions.get(paramInt);
      int j = paramArrayOfByte.horizontalAddress + localDisplayDefinition.horizontalPositionMinimum;
      int k = paramArrayOfByte.verticalAddress + localDisplayDefinition.verticalPositionMinimum;
      paramInt = Math.min(localRegionComposition.width + j, localDisplayDefinition.horizontalPositionMaximum);
      int m = Math.min(localRegionComposition.height + k, localDisplayDefinition.verticalPositionMaximum);
      paramArrayOfByte = this.canvas;
      float f1 = j;
      float f2 = k;
      paramArrayOfByte.clipRect(f1, f2, paramInt, m, Region.Op.REPLACE);
      Object localObject = (DvbParser.ClutDefinition)this.subtitleService.cluts.get(localRegionComposition.clutId);
      paramArrayOfByte = (byte[])localObject;
      if (localObject == null)
      {
        localObject = (DvbParser.ClutDefinition)this.subtitleService.ancillaryCluts.get(localRegionComposition.clutId);
        paramArrayOfByte = (byte[])localObject;
        if (localObject == null) {
          paramArrayOfByte = this.defaultClutDefinition;
        }
      }
      localObject = localRegionComposition.regionObjects;
      paramInt = 0;
      while (paramInt < ((SparseArray)localObject).size())
      {
        m = ((SparseArray)localObject).keyAt(paramInt);
        DvbParser.RegionObject localRegionObject = (DvbParser.RegionObject)((SparseArray)localObject).valueAt(paramInt);
        DvbParser.ObjectData localObjectData = (DvbParser.ObjectData)this.subtitleService.objects.get(m);
        if (localObjectData == null) {
          localObjectData = (DvbParser.ObjectData)this.subtitleService.ancillaryObjects.get(m);
        }
        if (localObjectData != null)
        {
          Paint localPaint;
          if (localObjectData.nonModifyingColorFlag) {
            localPaint = null;
          } else {
            localPaint = this.defaultPaint;
          }
          paintPixelDataSubBlocks(localObjectData, paramArrayOfByte, localRegionComposition.depth, localRegionObject.horizontalPosition + j, k + localRegionObject.verticalPosition, localPaint, this.canvas);
        }
        paramInt += 1;
      }
      if (localRegionComposition.fillFlag)
      {
        if (localRegionComposition.depth == 3) {
          paramInt = paramArrayOfByte.clutEntries8Bit[localRegionComposition.pixelCode8Bit];
        } else if (localRegionComposition.depth == 2) {
          paramInt = paramArrayOfByte.clutEntries4Bit[localRegionComposition.pixelCode4Bit];
        } else {
          paramInt = paramArrayOfByte.clutEntries2Bit[localRegionComposition.pixelCode2Bit];
        }
        this.fillRegionPaint.setColor(paramInt);
        this.canvas.drawRect(f1, f2, localRegionComposition.width + j, localRegionComposition.height + k, this.fillRegionPaint);
      }
      localArrayList.add(new Cue(Bitmap.createBitmap(this.bitmap, j, k, localRegionComposition.width, localRegionComposition.height), f1 / localDisplayDefinition.width, 0, f2 / localDisplayDefinition.height, 0, localRegionComposition.width / localDisplayDefinition.width, localRegionComposition.height / localDisplayDefinition.height));
      this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
      i += 1;
    }
    return localArrayList;
  }
  
  public void reset()
  {
    this.subtitleService.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.dvb.DvbParser
 * JD-Core Version:    0.7.0.1
 */