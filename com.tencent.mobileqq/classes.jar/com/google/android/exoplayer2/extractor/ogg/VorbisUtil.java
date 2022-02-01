package com.google.android.exoplayer2.extractor.ogg;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

final class VorbisUtil
{
  private static final String TAG = "VorbisUtil";
  
  public static int iLog(int paramInt)
  {
    int i = 0;
    while (paramInt > 0)
    {
      i += 1;
      paramInt >>>= 1;
    }
    return i;
  }
  
  private static long mapType1QuantValues(long paramLong1, long paramLong2)
  {
    return Math.floor(Math.pow(paramLong1, 1.0D / paramLong2));
  }
  
  private static VorbisUtil.CodeBook readBook(VorbisBitArray paramVorbisBitArray)
  {
    int i = 0;
    if (paramVorbisBitArray.readBits(24) != 5653314) {
      throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + paramVorbisBitArray.getPosition());
    }
    int m = paramVorbisBitArray.readBits(16);
    int n = paramVorbisBitArray.readBits(24);
    long[] arrayOfLong = new long[n];
    boolean bool1 = paramVorbisBitArray.readBit();
    int j;
    if (!bool1)
    {
      boolean bool2 = paramVorbisBitArray.readBit();
      if (i < arrayOfLong.length)
      {
        if (bool2) {
          if (paramVorbisBitArray.readBit()) {
            arrayOfLong[i] = (paramVorbisBitArray.readBits(5) + 1);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfLong[i] = 0L;
          continue;
          arrayOfLong[i] = (paramVorbisBitArray.readBits(5) + 1);
        }
      }
    }
    else
    {
      i = paramVorbisBitArray.readBits(5) + 1;
      j = 0;
      while (j < arrayOfLong.length)
      {
        int i1 = paramVorbisBitArray.readBits(iLog(n - j));
        int k = 0;
        while ((k < i1) && (j < arrayOfLong.length))
        {
          arrayOfLong[j] = i;
          k += 1;
          j += 1;
        }
        i += 1;
      }
    }
    i = paramVorbisBitArray.readBits(4);
    if (i > 2) {
      throw new ParserException("lookup type greater than 2 not decodable: " + i);
    }
    long l;
    if ((i == 1) || (i == 2))
    {
      paramVorbisBitArray.skipBits(32);
      paramVorbisBitArray.skipBits(32);
      j = paramVorbisBitArray.readBits(4);
      paramVorbisBitArray.skipBits(1);
      if (i != 1) {
        break label339;
      }
      if (m == 0) {
        break label333;
      }
      l = mapType1QuantValues(n, m);
    }
    for (;;)
    {
      paramVorbisBitArray.skipBits((int)(l * (j + 1)));
      return new VorbisUtil.CodeBook(m, n, arrayOfLong, i, bool1);
      label333:
      l = 0L;
      continue;
      label339:
      l = n * m;
    }
  }
  
  private static void readFloors(VorbisBitArray paramVorbisBitArray)
  {
    int n = paramVorbisBitArray.readBits(6);
    int i = 0;
    while (i < n + 1)
    {
      int j = paramVorbisBitArray.readBits(16);
      int k;
      switch (j)
      {
      default: 
        throw new ParserException("floor type greater than 1 not decodable: " + j);
      case 0: 
        paramVorbisBitArray.skipBits(8);
        paramVorbisBitArray.skipBits(16);
        paramVorbisBitArray.skipBits(16);
        paramVorbisBitArray.skipBits(6);
        paramVorbisBitArray.skipBits(8);
        k = paramVorbisBitArray.readBits(4);
        j = 0;
      }
      while (j < k + 1)
      {
        paramVorbisBitArray.skipBits(8);
        j += 1;
        continue;
        int i1 = paramVorbisBitArray.readBits(5);
        k = -1;
        int[] arrayOfInt1 = new int[i1];
        j = 0;
        while (j < i1)
        {
          arrayOfInt1[j] = paramVorbisBitArray.readBits(4);
          m = k;
          if (arrayOfInt1[j] > k) {
            m = arrayOfInt1[j];
          }
          j += 1;
          k = m;
        }
        int[] arrayOfInt2 = new int[k + 1];
        j = 0;
        while (j < arrayOfInt2.length)
        {
          arrayOfInt2[j] = (paramVorbisBitArray.readBits(3) + 1);
          m = paramVorbisBitArray.readBits(2);
          if (m > 0) {
            paramVorbisBitArray.skipBits(8);
          }
          k = 0;
          while (k < 1 << m)
          {
            paramVorbisBitArray.skipBits(8);
            k += 1;
          }
          j += 1;
        }
        paramVorbisBitArray.skipBits(2);
        int i2 = paramVorbisBitArray.readBits(4);
        k = 0;
        j = 0;
        int m = 0;
        while (j < i1)
        {
          m += arrayOfInt2[arrayOfInt1[j]];
          while (k < m)
          {
            paramVorbisBitArray.skipBits(i2);
            k += 1;
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  private static void readMappings(int paramInt, VorbisBitArray paramVorbisBitArray)
  {
    int m = paramVorbisBitArray.readBits(6);
    int i = 0;
    if (i < m + 1)
    {
      int j = paramVorbisBitArray.readBits(16);
      switch (j)
      {
      default: 
        Log.e("VorbisUtil", "mapping type other than 0 not supported: " + j);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramVorbisBitArray.readBit()) {}
        for (j = paramVorbisBitArray.readBits(4) + 1; paramVorbisBitArray.readBit(); j = 1)
        {
          int n = paramVorbisBitArray.readBits(8);
          k = 0;
          while (k < n + 1)
          {
            paramVorbisBitArray.skipBits(iLog(paramInt - 1));
            paramVorbisBitArray.skipBits(iLog(paramInt - 1));
            k += 1;
          }
        }
        if (paramVorbisBitArray.readBits(2) != 0) {
          throw new ParserException("to reserved bits must be zero after mapping coupling steps");
        }
        if (j > 1)
        {
          k = 0;
          while (k < paramInt)
          {
            paramVorbisBitArray.skipBits(4);
            k += 1;
          }
        }
        int k = 0;
        while (k < j)
        {
          paramVorbisBitArray.skipBits(8);
          paramVorbisBitArray.skipBits(8);
          paramVorbisBitArray.skipBits(8);
          k += 1;
        }
      }
    }
  }
  
  private static VorbisUtil.Mode[] readModes(VorbisBitArray paramVorbisBitArray)
  {
    int j = paramVorbisBitArray.readBits(6) + 1;
    VorbisUtil.Mode[] arrayOfMode = new VorbisUtil.Mode[j];
    int i = 0;
    while (i < j)
    {
      arrayOfMode[i] = new VorbisUtil.Mode(paramVorbisBitArray.readBit(), paramVorbisBitArray.readBits(16), paramVorbisBitArray.readBits(16), paramVorbisBitArray.readBits(8));
      i += 1;
    }
    return arrayOfMode;
  }
  
  private static void readResidues(VorbisBitArray paramVorbisBitArray)
  {
    int m = paramVorbisBitArray.readBits(6);
    int i = 0;
    int n;
    int[] arrayOfInt;
    int j;
    label80:
    int i1;
    if (i < m + 1)
    {
      if (paramVorbisBitArray.readBits(16) > 2) {
        throw new ParserException("residueType greater than 2 is not decodable");
      }
      paramVorbisBitArray.skipBits(24);
      paramVorbisBitArray.skipBits(24);
      paramVorbisBitArray.skipBits(24);
      n = paramVorbisBitArray.readBits(6) + 1;
      paramVorbisBitArray.skipBits(8);
      arrayOfInt = new int[n];
      j = 0;
      if (j < n)
      {
        i1 = paramVorbisBitArray.readBits(3);
        if (!paramVorbisBitArray.readBit()) {
          break label179;
        }
      }
    }
    label179:
    for (int k = paramVorbisBitArray.readBits(5);; k = 0)
    {
      arrayOfInt[j] = (k * 8 + i1);
      j += 1;
      break label80;
      j = 0;
      while (j < n)
      {
        k = 0;
        while (k < 8)
        {
          if ((arrayOfInt[j] & 1 << k) != 0) {
            paramVorbisBitArray.skipBits(8);
          }
          k += 1;
        }
        j += 1;
      }
      i += 1;
      break;
      return;
    }
  }
  
  public static VorbisUtil.CommentHeader readVorbisCommentHeader(ParsableByteArray paramParsableByteArray)
  {
    int i = 0;
    verifyVorbisHeaderCapturePattern(3, paramParsableByteArray, false);
    String str = paramParsableByteArray.readString((int)paramParsableByteArray.readLittleEndianUnsignedInt());
    int j = str.length();
    long l = paramParsableByteArray.readLittleEndianUnsignedInt();
    String[] arrayOfString = new String[(int)l];
    j = j + 11 + 4;
    while (i < l)
    {
      arrayOfString[i] = paramParsableByteArray.readString((int)paramParsableByteArray.readLittleEndianUnsignedInt());
      j = j + 4 + arrayOfString[i].length();
      i += 1;
    }
    if ((paramParsableByteArray.readUnsignedByte() & 0x1) == 0) {
      throw new ParserException("framing bit expected to be set");
    }
    return new VorbisUtil.CommentHeader(str, arrayOfString, j + 1);
  }
  
  public static VorbisUtil.VorbisIdHeader readVorbisIdentificationHeader(ParsableByteArray paramParsableByteArray)
  {
    verifyVorbisHeaderCapturePattern(1, paramParsableByteArray, false);
    long l1 = paramParsableByteArray.readLittleEndianUnsignedInt();
    int i = paramParsableByteArray.readUnsignedByte();
    long l2 = paramParsableByteArray.readLittleEndianUnsignedInt();
    int j = paramParsableByteArray.readLittleEndianInt();
    int k = paramParsableByteArray.readLittleEndianInt();
    int m = paramParsableByteArray.readLittleEndianInt();
    int i1 = paramParsableByteArray.readUnsignedByte();
    int n = (int)Math.pow(2.0D, i1 & 0xF);
    i1 = (int)Math.pow(2.0D, (i1 & 0xF0) >> 4);
    if ((paramParsableByteArray.readUnsignedByte() & 0x1) > 0) {}
    for (boolean bool = true;; bool = false) {
      return new VorbisUtil.VorbisIdHeader(l1, i, l2, j, k, m, n, i1, bool, Arrays.copyOf(paramParsableByteArray.data, paramParsableByteArray.limit()));
    }
  }
  
  public static VorbisUtil.Mode[] readVorbisModes(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    int j = 0;
    verifyVorbisHeaderCapturePattern(5, paramParsableByteArray, false);
    int k = paramParsableByteArray.readUnsignedByte();
    VorbisBitArray localVorbisBitArray = new VorbisBitArray(paramParsableByteArray.data);
    localVorbisBitArray.skipBits(paramParsableByteArray.getPosition() * 8);
    int i = 0;
    while (i < k + 1)
    {
      readBook(localVorbisBitArray);
      i += 1;
    }
    k = localVorbisBitArray.readBits(6);
    i = j;
    while (i < k + 1)
    {
      if (localVorbisBitArray.readBits(16) != 0) {
        throw new ParserException("placeholder of time domain transforms not zeroed out");
      }
      i += 1;
    }
    readFloors(localVorbisBitArray);
    readResidues(localVorbisBitArray);
    readMappings(paramInt, localVorbisBitArray);
    paramParsableByteArray = readModes(localVorbisBitArray);
    if (!localVorbisBitArray.readBit()) {
      throw new ParserException("framing bit after modes not set as expected");
    }
    return paramParsableByteArray;
  }
  
  public static boolean verifyVorbisHeaderCapturePattern(int paramInt, ParsableByteArray paramParsableByteArray, boolean paramBoolean)
  {
    if (paramParsableByteArray.bytesLeft() < 7) {
      if (!paramBoolean) {}
    }
    do
    {
      do
      {
        return false;
        throw new ParserException("too short header: " + paramParsableByteArray.bytesLeft());
        if (paramParsableByteArray.readUnsignedByte() == paramInt) {
          break;
        }
      } while (paramBoolean);
      throw new ParserException("expected header type " + Integer.toHexString(paramInt));
      if ((paramParsableByteArray.readUnsignedByte() == 118) && (paramParsableByteArray.readUnsignedByte() == 111) && (paramParsableByteArray.readUnsignedByte() == 114) && (paramParsableByteArray.readUnsignedByte() == 98) && (paramParsableByteArray.readUnsignedByte() == 105) && (paramParsableByteArray.readUnsignedByte() == 115)) {
        break;
      }
    } while (paramBoolean);
    throw new ParserException("expected characters 'vorbis'");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.VorbisUtil
 * JD-Core Version:    0.7.0.1
 */