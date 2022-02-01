package com.google.zxing.qrcode;

import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

public final class QRCodeWriter
{
  private static BitMatrix a(QRCode paramQRCode, int paramInt1, int paramInt2, int paramInt3)
  {
    paramQRCode = paramQRCode.a();
    if (paramQRCode != null)
    {
      int k = paramQRCode.b();
      int m = paramQRCode.a();
      paramInt3 <<= 1;
      int i = k + paramInt3;
      int j = paramInt3 + m;
      paramInt3 = Math.max(paramInt1, i);
      paramInt2 = Math.max(paramInt2, j);
      int n = Math.min(paramInt3 / i, paramInt2 / j);
      j = (paramInt3 - k * n) / 2;
      paramInt1 = (paramInt2 - m * n) / 2;
      BitMatrix localBitMatrix = new BitMatrix(paramInt3, paramInt2);
      paramInt2 = 0;
      while (paramInt2 < m)
      {
        paramInt3 = j;
        i = 0;
        while (i < k)
        {
          if (paramQRCode.a(i, paramInt2) == 1) {
            localBitMatrix.a(paramInt3, paramInt1, n, n);
          }
          i += 1;
          paramInt3 += n;
        }
        paramInt2 += 1;
        paramInt1 += n;
      }
      return localBitMatrix;
    }
    paramQRCode = new IllegalStateException();
    for (;;)
    {
      throw paramQRCode;
    }
  }
  
  public BitMatrix a(String paramString, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramString.length() != 0)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0))
      {
        Object localObject1 = ErrorCorrectionLevel.L;
        int j = 4;
        Object localObject2 = localObject1;
        int i = j;
        if (paramMap != null)
        {
          localObject2 = (ErrorCorrectionLevel)paramMap.get(EncodeHintType.ERROR_CORRECTION);
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
          Integer localInteger = (Integer)paramMap.get(EncodeHintType.MARGIN);
          localObject2 = localObject1;
          i = j;
          if (localInteger != null)
          {
            i = localInteger.intValue();
            localObject2 = localObject1;
          }
        }
        return a(Encoder.a(paramString, (ErrorCorrectionLevel)localObject2, paramMap), paramInt1, paramInt2, i);
      }
      paramString = new StringBuilder();
      paramString.append("Requested dimensions are too small: ");
      paramString.append(paramInt1);
      paramString.append('x');
      paramString.append(paramInt2);
      throw new IllegalArgumentException(paramString.toString());
    }
    throw new IllegalArgumentException("Found empty contents");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.qrcode.QRCodeWriter
 * JD-Core Version:    0.7.0.1
 */