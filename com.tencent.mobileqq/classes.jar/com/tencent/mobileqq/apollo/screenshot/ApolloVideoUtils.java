package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.av.config.ByteBuffer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;

public class ApolloVideoUtils
{
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mUniseq = System.currentTimeMillis();
    localTransferRequest.mFileType = 48;
    ((ITransFileController)paramAppInterface.getRuntimeService(ITransFileController.class, "all")).transferAsync(localTransferRequest);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mUniseq = System.currentTimeMillis();
    localTransferRequest.mFileType = paramInt1;
    paramString = new ByteBuffer();
    paramString.a(paramInt2);
    paramString.a(paramInt3);
    localTransferRequest.mExtentionInfo = paramString.a();
    ((ITransFileController)paramAppInterface.getRuntimeService(ITransFileController.class, "all")).transferAsync(localTransferRequest);
  }
  
  public static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int k = paramInt1 * paramInt2;
    int i = 0;
    int j = 0;
    int n = 0;
    int i1;
    label23:
    int m;
    int i2;
    int i4;
    int i3;
    if (n < paramInt2)
    {
      i1 = 0;
      if (i1 < paramInt1)
      {
        m = paramArrayOfInt[j];
        m = (paramArrayOfInt[j] & 0xFF0000) >> 16;
        i2 = (paramArrayOfInt[j] & 0xFF00) >> 8;
        int i5 = (paramArrayOfInt[j] & 0xFF) >> 0;
        i4 = (m * 66 + i2 * 129 + i5 * 25 + 128 >> 8) + 16;
        i3 = (m * -38 - i2 * 74 + i5 * 112 + 128 >> 8) + 128;
        i2 = (m * 112 - i2 * 94 - i5 * 18 + 128 >> 8) + 128;
        if (i4 < 0)
        {
          m = 0;
          label169:
          paramArrayOfByte[i] = ((byte)m);
          if ((n % 2 != 0) || (j % 2 != 0)) {
            break label329;
          }
          i4 = k + 1;
          if (i3 >= 0) {
            break label273;
          }
          m = 0;
          label204:
          paramArrayOfByte[k] = ((byte)m);
          if (i2 >= 0) {
            break label296;
          }
          k = 0;
          label219:
          paramArrayOfByte[i4] = ((byte)k);
          k = i4 + 1;
        }
      }
    }
    label273:
    label296:
    label329:
    for (;;)
    {
      i1 += 1;
      j += 1;
      i += 1;
      break label23;
      m = i4;
      if (i4 <= 255) {
        break label169;
      }
      m = 255;
      break label169;
      if (i3 > 255)
      {
        m = 255;
        break label204;
      }
      m = i3;
      break label204;
      if (i2 > 255)
      {
        k = 255;
        break label219;
      }
      k = i2;
      break label219;
      n += 1;
      break;
      return;
    }
  }
  
  public static void b(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int k = paramInt1 * paramInt2;
    int i = 0;
    int m = k + paramInt1 * paramInt2 / 4;
    int j = 0;
    int i1 = 0;
    int i2;
    label33:
    int n;
    int i5;
    int i4;
    int i3;
    if (i1 < paramInt2)
    {
      i2 = 0;
      if (i2 < paramInt1)
      {
        n = paramArrayOfInt[j];
        n = (paramArrayOfInt[j] & 0xFF0000) >> 16;
        i5 = (paramArrayOfInt[j] & 0xFF00) >> 8;
        int i6 = (paramArrayOfInt[j] & 0xFF) >> 0;
        i4 = (n * 66 + i5 * 129 + i6 * 25 + 128 >> 8) + 16;
        i3 = (n * -38 - i5 * 74 + i6 * 112 + 128 >> 8) + 128;
        i5 = (n * 112 - i5 * 94 - i6 * 18 + 128 >> 8) + 128;
        if (i4 < 0)
        {
          n = 0;
          label179:
          paramArrayOfByte[i] = ((byte)n);
          if ((i1 % 2 != 0) || (j % 2 != 0)) {
            break label343;
          }
          if (i5 >= 0) {
            break label287;
          }
          n = 0;
          label208:
          paramArrayOfByte[m] = ((byte)n);
          i4 = k + 1;
          if (i3 >= 0) {
            break label310;
          }
          n = 0;
          label229:
          paramArrayOfByte[k] = ((byte)n);
          m += 1;
          k = i4;
        }
      }
    }
    label287:
    label310:
    label343:
    for (;;)
    {
      i2 += 1;
      j += 1;
      i += 1;
      break label33;
      n = i4;
      if (i4 <= 255) {
        break label179;
      }
      n = 255;
      break label179;
      if (i5 > 255)
      {
        n = 255;
        break label208;
      }
      n = i5;
      break label208;
      if (i3 > 255)
      {
        n = 255;
        break label229;
      }
      n = i3;
      break label229;
      i1 += 1;
      break;
      return;
    }
  }
  
  public static void c(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int m = 0;
    int j = 0;
    int i = 0;
    int n;
    int k;
    label30:
    int i1;
    int i2;
    int i4;
    int i3;
    if (m < paramInt2)
    {
      n = 0;
      k = j;
      j = i;
      i = k;
      if (n < paramInt1)
      {
        k = paramArrayOfInt[i];
        k = (paramArrayOfInt[i] & 0xFF0000) >> 16;
        i1 = (paramArrayOfInt[i] & 0xFF00) >> 8;
        i2 = (paramArrayOfInt[i] & 0xFF) >> 0;
        i4 = (k * 66 + i1 * 129 + i2 * 25 + 128 >> 8) + 16;
        i3 = (k * -38 - i1 * 74 + i2 * 112 + 128 >> 8) + 128;
        i2 = (k * 112 - i1 * 94 - i2 * 18 + 128 >> 8) + 128;
        i1 = j + 1;
        if (i4 < 0)
        {
          k = 0;
          label182:
          paramArrayOfByte[j] = ((byte)k);
          if ((m % 2 == 0) && (i % 2 == 0))
          {
            if (i3 >= 0) {
              break label285;
            }
            j = 0;
            label211:
            paramArrayOfByte[(i1 + 1)] = ((byte)j);
            if (i2 >= 0) {
              break label308;
            }
            j = 0;
            label228:
            paramArrayOfByte[(i1 + 3)] = ((byte)j);
          }
          if (i % 2 != 0) {
            break label353;
          }
        }
      }
    }
    label285:
    label308:
    label353:
    for (j = i1 + 1;; j = i1)
    {
      n += 1;
      i += 1;
      break label30;
      k = i4;
      if (i4 <= 255) {
        break label182;
      }
      k = 255;
      break label182;
      if (i3 > 255)
      {
        j = 255;
        break label211;
      }
      j = i3;
      break label211;
      if (i2 > 255)
      {
        j = 255;
        break label228;
      }
      j = i2;
      break label228;
      m += 1;
      k = j;
      j = i;
      i = k;
      break;
      return;
    }
  }
  
  public static void d(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = paramArrayOfByte.length / 2;
    int k = 0;
    int m = 0;
    int n;
    label24:
    int i1;
    int i4;
    int i3;
    if (m < paramInt2)
    {
      n = 0;
      if (n < paramInt1)
      {
        i1 = paramArrayOfInt[k];
        int i2 = (paramArrayOfInt[k] & 0xFF0000) >> 16;
        i4 = (paramArrayOfInt[k] & 0xFF00) >> 8;
        int i5 = (paramArrayOfInt[k] & 0xFF) >> 0;
        i1 = (i2 * 66 + i4 * 129 + i5 * 25 + 128 >> 8) + 16;
        i3 = (i2 * -38 - i4 * 74 + i5 * 112 + 128 >> 8) + 128;
        i4 = (i2 * 112 - i4 * 94 - i5 * 18 + 128 >> 8) + 128;
        if ((m % 2 == 0) && (k % 2 == 0))
        {
          i2 = j + 1;
          if (i1 < 0)
          {
            i1 = 0;
            label190:
            paramArrayOfByte[j] = ((byte)i1);
            if (i3 >= 0) {
              break label265;
            }
            j = 0;
            label205:
            paramArrayOfByte[(i2 + 1)] = ((byte)j);
            if (i4 >= 0) {
              break label278;
            }
            j = 0;
            label222:
            paramArrayOfByte[(i + 1)] = ((byte)j);
            j = i2 + 1;
          }
        }
      }
    }
    for (;;)
    {
      n += 1;
      k += 1;
      break label24;
      i1 = Math.min(i1, 255);
      break label190;
      label265:
      j = Math.min(i3, 255);
      break label205;
      label278:
      j = Math.min(i4, 255);
      break label222;
      if ((m % 2 == 0) && (k % 2 == 1))
      {
        if (i1 < 0) {}
        for (i1 = 0;; i1 = Math.min(i1, 255))
        {
          paramArrayOfByte[j] = ((byte)i1);
          j += 1;
          break;
        }
      }
      if ((m % 2 == 1) && (k % 2 == 0))
      {
        if (i1 < 0) {}
        for (i1 = 0;; i1 = Math.min(i1, 255))
        {
          paramArrayOfByte[i] = ((byte)i1);
          i = i + 1 + 1;
          break;
        }
      }
      if ((m % 2 == 1) && (k % 2 == 1))
      {
        if (i1 < 0) {}
        for (i1 = 0;; i1 = Math.min(i1, 255))
        {
          paramArrayOfByte[i] = ((byte)i1);
          i += 1;
          break;
        }
        m += 1;
        break;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloVideoUtils
 * JD-Core Version:    0.7.0.1
 */