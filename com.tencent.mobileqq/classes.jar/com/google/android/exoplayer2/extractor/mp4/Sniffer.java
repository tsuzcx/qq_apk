package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class Sniffer
{
  private static final int[] COMPATIBLE_BRANDS = { Util.getIntegerCodeForString("isom"), Util.getIntegerCodeForString("iso2"), Util.getIntegerCodeForString("iso3"), Util.getIntegerCodeForString("iso4"), Util.getIntegerCodeForString("iso5"), Util.getIntegerCodeForString("iso6"), Util.getIntegerCodeForString("avc1"), Util.getIntegerCodeForString("hvc1"), Util.getIntegerCodeForString("hev1"), Util.getIntegerCodeForString("mp41"), Util.getIntegerCodeForString("mp42"), Util.getIntegerCodeForString("3g2a"), Util.getIntegerCodeForString("3g2b"), Util.getIntegerCodeForString("3gr6"), Util.getIntegerCodeForString("3gs6"), Util.getIntegerCodeForString("3ge6"), Util.getIntegerCodeForString("3gg6"), Util.getIntegerCodeForString("M4V "), Util.getIntegerCodeForString("M4A "), Util.getIntegerCodeForString("f4v "), Util.getIntegerCodeForString("kddi"), Util.getIntegerCodeForString("M4VP"), Util.getIntegerCodeForString("qt  "), Util.getIntegerCodeForString("MSNV") };
  private static final int SEARCH_LENGTH = 4096;
  
  private static boolean isCompatibleBrand(int paramInt)
  {
    if (paramInt >>> 8 == Util.getIntegerCodeForString("3gp")) {
      return true;
    }
    int[] arrayOfInt = COMPATIBLE_BRANDS;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean sniffFragmented(ExtractorInput paramExtractorInput)
  {
    return sniffInternal(paramExtractorInput, true);
  }
  
  private static boolean sniffInternal(ExtractorInput paramExtractorInput, boolean paramBoolean)
  {
    long l2 = paramExtractorInput.getLength();
    long l1;
    if (l2 != -1L)
    {
      l1 = l2;
      if (l2 <= 4096L) {}
    }
    else
    {
      l1 = 4096L;
    }
    int n = (int)l1;
    ParsableByteArray localParsableByteArray = new ParsableByteArray(64);
    boolean bool3 = false;
    int j = 0;
    int i = 0;
    while (j < n)
    {
      localParsableByteArray.reset(8);
      paramExtractorInput.peekFully(localParsableByteArray.data, 0, 8);
      l2 = localParsableByteArray.readUnsignedInt();
      int i1 = localParsableByteArray.readInt();
      int k = 16;
      if (l2 == 1L)
      {
        paramExtractorInput.peekFully(localParsableByteArray.data, 8, 8);
        localParsableByteArray.setLimit(16);
        l1 = localParsableByteArray.readUnsignedLongToLong();
      }
      else
      {
        l1 = l2;
        if (l2 == 0L)
        {
          long l3 = paramExtractorInput.getLength();
          l1 = l2;
          if (l3 != -1L)
          {
            l1 = paramExtractorInput.getPosition();
            l1 = 8 + (l3 - l1);
          }
        }
        k = 8;
      }
      l2 = k;
      if (l1 < l2) {
        return false;
      }
      j += k;
      if (i1 != Atom.TYPE_moov) {
        if ((i1 != Atom.TYPE_moof) && (i1 != Atom.TYPE_mvex))
        {
          if (j + l1 - l2 < n)
          {
            int i2 = (int)(l1 - l2);
            int m = j + i2;
            if (i1 == Atom.TYPE_ftyp)
            {
              if (i2 < 8) {
                return false;
              }
              localParsableByteArray.reset(i2);
              paramExtractorInput.peekFully(localParsableByteArray.data, 0, i2);
              i1 = i2 / 4;
              k = 0;
              for (;;)
              {
                j = i;
                if (k >= i1) {
                  break;
                }
                if (k == 1)
                {
                  localParsableByteArray.skipBytes(4);
                }
                else if (isCompatibleBrand(localParsableByteArray.readInt()))
                {
                  j = 1;
                  break;
                }
                k += 1;
              }
              k = j;
              if (j == 0) {
                return false;
              }
            }
            else
            {
              k = i;
              if (i2 != 0)
              {
                paramExtractorInput.advancePeekPosition(i2);
                k = i;
              }
            }
            j = m;
            i = k;
          }
        }
        else
        {
          bool1 = true;
          break label421;
        }
      }
    }
    boolean bool1 = false;
    label421:
    boolean bool2 = bool3;
    if (i != 0)
    {
      bool2 = bool3;
      if (paramBoolean == bool1) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static boolean sniffUnfragmented(ExtractorInput paramExtractorInput)
  {
    return sniffInternal(paramExtractorInput, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.Sniffer
 * JD-Core Version:    0.7.0.1
 */