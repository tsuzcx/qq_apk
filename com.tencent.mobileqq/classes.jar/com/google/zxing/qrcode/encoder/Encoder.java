package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.decoder.Version.ECBlocks;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class Encoder
{
  private static final int[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };
  
  static int a(int paramInt)
  {
    int[] arrayOfInt = a;
    if (paramInt < arrayOfInt.length) {
      return arrayOfInt[paramInt];
    }
    return -1;
  }
  
  private static int a(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, Version paramVersion, ByteMatrix paramByteMatrix)
  {
    int j = 2147483647;
    int k = -1;
    int i = 0;
    while (i < 8)
    {
      MatrixUtil.a(paramBitArray, paramErrorCorrectionLevel, paramVersion, i, paramByteMatrix);
      int n = a(paramByteMatrix);
      int m = j;
      if (n < j)
      {
        k = i;
        m = n;
      }
      i += 1;
      j = m;
    }
    return k;
  }
  
  private static int a(ByteMatrix paramByteMatrix)
  {
    return MaskUtil.a(paramByteMatrix) + MaskUtil.b(paramByteMatrix) + MaskUtil.c(paramByteMatrix) + MaskUtil.d(paramByteMatrix);
  }
  
  static BitArray a(BitArray paramBitArray, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBitArray.b() == paramInt2)
    {
      Object localObject1 = new ArrayList(paramInt3);
      int n = 0;
      int k = 0;
      int m = 0;
      int j = 0;
      int i = 0;
      Object localObject2;
      byte[] arrayOfByte;
      while (k < paramInt3)
      {
        localObject2 = new int[1];
        Object localObject3 = new int[1];
        a(paramInt1, paramInt2, paramInt3, k, (int[])localObject2, (int[])localObject3);
        int i1 = localObject2[0];
        arrayOfByte = new byte[i1];
        paramBitArray.a(m * 8, arrayOfByte, 0, i1);
        localObject3 = a(arrayOfByte, localObject3[0]);
        ((Collection)localObject1).add(new BlockPair(arrayOfByte, (byte[])localObject3));
        j = Math.max(j, i1);
        i = Math.max(i, localObject3.length);
        m += localObject2[0];
        k += 1;
      }
      if (paramInt2 == m)
      {
        paramBitArray = new BitArray();
        paramInt2 = 0;
        for (;;)
        {
          paramInt3 = n;
          if (paramInt2 >= j) {
            break;
          }
          localObject2 = ((Collection)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfByte = ((BlockPair)((Iterator)localObject2).next()).a();
            if (paramInt2 < arrayOfByte.length) {
              paramBitArray.a(arrayOfByte[paramInt2], 8);
            }
          }
          paramInt2 += 1;
        }
        while (paramInt3 < i)
        {
          localObject2 = ((Collection)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfByte = ((BlockPair)((Iterator)localObject2).next()).b();
            if (paramInt3 < arrayOfByte.length) {
              paramBitArray.a(arrayOfByte[paramInt3], 8);
            }
          }
          paramInt3 += 1;
        }
        if (paramInt1 == paramBitArray.b()) {
          return paramBitArray;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Interleaving error: ");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" and ");
        ((StringBuilder)localObject1).append(paramBitArray.b());
        ((StringBuilder)localObject1).append(" differ.");
        throw new WriterException(((StringBuilder)localObject1).toString());
      }
      throw new WriterException("Data bytes does not match offset");
    }
    paramBitArray = new WriterException("Number of bits and data bytes does not match");
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  private static Mode a(String paramString1, String paramString2)
  {
    if ("Shift_JIS".equals(paramString2))
    {
      if (a(paramString1)) {
        return Mode.KANJI;
      }
      return Mode.BYTE;
    }
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < paramString1.length())
    {
      int m = paramString1.charAt(i);
      if ((m >= 48) && (m <= 57))
      {
        k = 1;
      }
      else
      {
        if (a(m) == -1) {
          break label84;
        }
        j = 1;
      }
      i += 1;
      continue;
      label84:
      return Mode.BYTE;
    }
    if (j != 0) {
      return Mode.ALPHANUMERIC;
    }
    if (k != 0) {
      return Mode.NUMERIC;
    }
    return Mode.BYTE;
  }
  
  private static Version a(int paramInt, ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    int i = 1;
    while (i <= 40)
    {
      Version localVersion = Version.a(i);
      if (localVersion.b() - localVersion.a(paramErrorCorrectionLevel).c() >= (paramInt + 7) / 8) {
        return localVersion;
      }
      i += 1;
    }
    paramErrorCorrectionLevel = new WriterException("Data too big");
    for (;;)
    {
      throw paramErrorCorrectionLevel;
    }
  }
  
  public static QRCode a(String paramString, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<EncodeHintType, ?> paramMap)
  {
    if (paramMap == null) {
      localObject1 = null;
    } else {
      localObject1 = (String)paramMap.get(EncodeHintType.CHARACTER_SET);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "ISO-8859-1";
    }
    Object localObject1 = a(paramString, (String)localObject2);
    BitArray localBitArray = new BitArray();
    if ((localObject1 == Mode.BYTE) && (!"ISO-8859-1".equals(localObject2)))
    {
      localObject3 = CharacterSetECI.getCharacterSetECIByName((String)localObject2);
      if (localObject3 != null) {
        a((CharacterSetECI)localObject3, localBitArray);
      }
    }
    a((Mode)localObject1, localBitArray);
    Object localObject3 = new BitArray();
    a(paramString, (Mode)localObject1, (BitArray)localObject3, (String)localObject2);
    int j = 0;
    int i = j;
    if (paramMap != null)
    {
      i = j;
      if (paramMap.containsKey(EncodeHintType.QRCODE_VERSION)) {
        i = ((Integer)paramMap.get(EncodeHintType.QRCODE_VERSION)).intValue();
      }
    }
    int k = localBitArray.a();
    if (i == 0) {
      j = 40;
    } else {
      j = i;
    }
    paramMap = a(k + ((Mode)localObject1).getCharacterCountBits(Version.a(j)) + ((BitArray)localObject3).a(), paramErrorCorrectionLevel);
    if (i != 0)
    {
      if (i >= paramMap.a()) {
        paramMap = Version.a(i);
      }
    }
    else
    {
      localObject2 = new BitArray();
      ((BitArray)localObject2).a(localBitArray);
      if (localObject1 == Mode.BYTE) {
        i = ((BitArray)localObject3).b();
      } else {
        i = paramString.length();
      }
      a(i, paramMap, (Mode)localObject1, (BitArray)localObject2);
      ((BitArray)localObject2).a((BitArray)localObject3);
      paramString = paramMap.a(paramErrorCorrectionLevel);
      i = paramMap.b() - paramString.c();
      a(i, (BitArray)localObject2);
      paramString = a((BitArray)localObject2, paramMap.b(), i, paramString.b());
      localObject2 = new QRCode();
      ((QRCode)localObject2).a(paramErrorCorrectionLevel);
      ((QRCode)localObject2).a((Mode)localObject1);
      ((QRCode)localObject2).a(paramMap);
      i = paramMap.c();
      localObject1 = new ByteMatrix(i, i);
      i = a(paramString, paramErrorCorrectionLevel, paramMap, (ByteMatrix)localObject1);
      ((QRCode)localObject2).a(i);
      MatrixUtil.a(paramString, paramErrorCorrectionLevel, paramMap, i, (ByteMatrix)localObject1);
      ((QRCode)localObject2).a((ByteMatrix)localObject1);
      return localObject2;
    }
    paramString = new StringBuilder();
    paramString.append("Requested version is too small: ");
    paramString.append(i);
    throw new WriterException(paramString.toString());
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramInt4 < paramInt3)
    {
      int i = paramInt1 % paramInt3;
      int j = paramInt3 - i;
      int k = paramInt1 / paramInt3;
      paramInt2 /= paramInt3;
      int m = paramInt2 + 1;
      int n = k - paramInt2;
      k = k + 1 - m;
      if (n == k)
      {
        if (paramInt3 == j + i)
        {
          if (paramInt1 == (paramInt2 + n) * j + (m + k) * i)
          {
            if (paramInt4 < j)
            {
              paramArrayOfInt1[0] = paramInt2;
              paramArrayOfInt2[0] = n;
              return;
            }
            paramArrayOfInt1[0] = m;
            paramArrayOfInt2[0] = k;
            return;
          }
          throw new WriterException("Total bytes mismatch");
        }
        throw new WriterException("RS blocks mismatch");
      }
      throw new WriterException("EC bytes mismatch");
    }
    throw new WriterException("Block ID too large");
  }
  
  static void a(int paramInt, BitArray paramBitArray)
  {
    int k = paramInt << 3;
    if (paramBitArray.a() <= k)
    {
      int j = 0;
      int i = 0;
      while ((i < 4) && (paramBitArray.a() < k))
      {
        paramBitArray.a(false);
        i += 1;
      }
      i = paramBitArray.a() & 0x7;
      if (i > 0) {
        while (i < 8)
        {
          paramBitArray.a(false);
          i += 1;
        }
      }
      int m = paramBitArray.b();
      i = j;
      while (i < paramInt - m)
      {
        if ((i & 0x1) == 0) {
          j = 236;
        } else {
          j = 17;
        }
        paramBitArray.a(j, 8);
        i += 1;
      }
      if (paramBitArray.a() == k) {
        return;
      }
      throw new WriterException("Bits size does not equal capacity");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("data bits cannot fit in the QR Code");
    localStringBuilder.append(paramBitArray.a());
    localStringBuilder.append(" > ");
    localStringBuilder.append(k);
    paramBitArray = new WriterException(localStringBuilder.toString());
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  static void a(int paramInt, Version paramVersion, Mode paramMode, BitArray paramBitArray)
  {
    int i = paramMode.getCharacterCountBits(paramVersion);
    int j = 1 << i;
    if (paramInt < j)
    {
      paramBitArray.a(paramInt, i);
      return;
    }
    paramVersion = new StringBuilder();
    paramVersion.append(paramInt);
    paramVersion.append(" is bigger than ");
    paramVersion.append(j - 1);
    throw new WriterException(paramVersion.toString());
  }
  
  private static void a(CharacterSetECI paramCharacterSetECI, BitArray paramBitArray)
  {
    paramBitArray.a(Mode.ECI.getBits(), 4);
    paramBitArray.a(paramCharacterSetECI.getValue(), 8);
  }
  
  static void a(Mode paramMode, BitArray paramBitArray)
  {
    paramBitArray.a(paramMode.getBits(), 4);
  }
  
  static void a(CharSequence paramCharSequence, BitArray paramBitArray)
  {
    int k = paramCharSequence.length();
    int i = 0;
    while (i < k)
    {
      int m = paramCharSequence.charAt(i) - '0';
      int j = i + 2;
      if (j < k)
      {
        paramBitArray.a(m * 100 + (paramCharSequence.charAt(i + 1) - '0') * 10 + (paramCharSequence.charAt(j) - '0'), 10);
        i += 3;
      }
      else
      {
        i += 1;
        if (i < k)
        {
          paramBitArray.a(m * 10 + (paramCharSequence.charAt(i) - '0'), 7);
          i = j;
        }
        else
        {
          paramBitArray.a(m, 4);
        }
      }
    }
  }
  
  static void a(String paramString, BitArray paramBitArray)
  {
    try
    {
      paramString = paramString.getBytes("Shift_JIS");
      int k = paramString.length;
      int i = 0;
      while (i < k)
      {
        int m = (paramString[i] & 0xFF) << 8 | paramString[(i + 1)] & 0xFF;
        int j = 33088;
        if ((m >= 33088) && (m <= 40956)) {}
        for (;;)
        {
          j = m - j;
          break label94;
          if ((m < 57408) || (m > 60351)) {
            break;
          }
          j = 49472;
        }
        j = -1;
        label94:
        if (j != -1)
        {
          paramBitArray.a((j >> 8) * 192 + (j & 0xFF), 13);
          i += 2;
        }
        else
        {
          throw new WriterException("Invalid byte sequence");
        }
      }
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new WriterException(paramString);
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  static void a(String paramString1, BitArray paramBitArray, String paramString2)
  {
    try
    {
      paramString1 = paramString1.getBytes(paramString2);
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        paramBitArray.a(paramString1[i], 8);
        i += 1;
      }
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1 = new WriterException(paramString1);
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  static void a(String paramString1, Mode paramMode, BitArray paramBitArray, String paramString2)
  {
    int i = Encoder.1.a[paramMode.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4)
          {
            a(paramString1, paramBitArray);
            return;
          }
          paramString1 = new StringBuilder();
          paramString1.append("Invalid mode: ");
          paramString1.append(paramMode);
          throw new WriterException(paramString1.toString());
        }
        a(paramString1, paramBitArray, paramString2);
        return;
      }
      b(paramString1, paramBitArray);
      return;
    }
    a(paramString1, paramBitArray);
  }
  
  private static boolean a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("Shift_JIS");
      int j = paramString.length;
      if (j % 2 != 0) {
        return false;
      }
      int i = 0;
      while (i < j)
      {
        int k = paramString[i] & 0xFF;
        if ((k < 129) || (k > 159))
        {
          if (k < 224) {
            break label70;
          }
          if (k > 235) {
            return false;
          }
        }
        i += 2;
        continue;
        label70:
        return false;
      }
      return true;
    }
    catch (UnsupportedEncodingException paramString) {}
    return false;
  }
  
  static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int k = paramArrayOfByte.length;
    int[] arrayOfInt = new int[k + paramInt];
    int j = 0;
    int i = 0;
    while (i < k)
    {
      paramArrayOfByte[i] &= 0xFF;
      i += 1;
    }
    new ReedSolomonEncoder(GenericGF.a).a(arrayOfInt, paramInt);
    paramArrayOfByte = new byte[paramInt];
    i = j;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)arrayOfInt[(k + i)]);
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  static void b(CharSequence paramCharSequence, BitArray paramBitArray)
  {
    int k = paramCharSequence.length();
    int i = 0;
    while (i < k)
    {
      int m = a(paramCharSequence.charAt(i));
      if (m != -1)
      {
        int j = i + 1;
        if (j < k)
        {
          j = a(paramCharSequence.charAt(j));
          if (j != -1)
          {
            paramBitArray.a(m * 45 + j, 11);
            i += 2;
          }
          else
          {
            throw new WriterException();
          }
        }
        else
        {
          paramBitArray.a(m, 6);
          i = j;
        }
      }
      else
      {
        throw new WriterException();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.Encoder
 * JD-Core Version:    0.7.0.1
 */