package com.tencent.luggage.wxa.pn;

import com.tencent.luggage.wxa.qz.o;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class a
{
  private static final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] b = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
  private static final byte[] c = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] d = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
  private static final byte[] e = { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
  private static final byte[] f = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      label11:
      break label11;
    }
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramArrayOfByte = b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    try
    {
      String str = new String(paramArrayOfByte, "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label23:
      break label23;
    }
    return new String(paramArrayOfByte);
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = b(paramInt4);
    int j = 0;
    if (paramInt2 > 0) {
      paramInt4 = paramArrayOfByte1[paramInt1] << 24 >>> 8;
    } else {
      paramInt4 = 0;
    }
    int i;
    if (paramInt2 > 1) {
      i = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;
    } else {
      i = 0;
    }
    if (paramInt2 > 2) {
      j = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
    }
    paramInt1 = paramInt4 | i | j;
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 3) {
          return paramArrayOfByte2;
        }
        paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
        paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
        paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
        paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(paramInt1 & 0x3F)];
        return paramArrayOfByte2;
      }
      paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
      paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
      paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
      paramArrayOfByte2[(paramInt3 + 3)] = 61;
      return paramArrayOfByte2;
    }
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
  
  private static int b(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte1 == null)
    {
      o.d("MicroMsg.AppBrandNetWork.Base64", "Source array was null.");
      return 0;
    }
    if (paramArrayOfByte2 == null)
    {
      o.d("MicroMsg.AppBrandNetWork.Base64", "Destination array was null.");
      return 0;
    }
    if (paramInt1 >= 0)
    {
      int j = paramInt1 + 3;
      if (j < paramArrayOfByte1.length)
      {
        if (paramInt2 >= 0)
        {
          int i = paramInt2 + 2;
          if (i < paramArrayOfByte2.length)
          {
            byte[] arrayOfByte = c(paramInt3);
            paramInt3 = paramInt1 + 2;
            if (paramArrayOfByte1[paramInt3] == 61)
            {
              paramInt3 = arrayOfByte[paramArrayOfByte1[paramInt1]];
              paramArrayOfByte2[paramInt2] = ((byte)(((arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (paramInt3 & 0xFF) << 18) >>> 16));
              return 1;
            }
            if (paramArrayOfByte1[j] == 61)
            {
              i = arrayOfByte[paramArrayOfByte1[paramInt1]];
              paramInt1 = arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]];
              paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt3]] & 0xFF) << 6 | (paramInt1 & 0xFF) << 12 | (i & 0xFF) << 18;
              paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >>> 16));
              paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
              return 2;
            }
            int k = arrayOfByte[paramArrayOfByte1[paramInt1]];
            paramInt1 = arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]];
            paramInt3 = arrayOfByte[paramArrayOfByte1[paramInt3]];
            paramInt1 = arrayOfByte[paramArrayOfByte1[j]] & 0xFF | (paramInt1 & 0xFF) << 12 | (k & 0xFF) << 18 | (paramInt3 & 0xFF) << 6;
            paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >> 16));
            paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8));
            paramArrayOfByte2[i] = ((byte)paramInt1);
            return 3;
          }
        }
        o.d("MicroMsg.AppBrandNetWork.Base64", "Destination array with length cannot have offset of and still store three bytes.");
        return 0;
      }
    }
    o.d("MicroMsg.AppBrandNetWork.Base64", "srcOffset < 0 || srcOffset + 3 >= source.length");
    return 0;
  }
  
  private static final byte[] b(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return c;
    }
    if ((paramInt & 0x20) == 32) {
      return e;
    }
    return a;
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +14 -> 15
    //   4: ldc 182
    //   6: ldc 199
    //   8: invokestatic 189	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: iconst_0
    //   12: newarray byte
    //   14: areturn
    //   15: iload_1
    //   16: ifge +37 -> 53
    //   19: new 201	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   26: astore_0
    //   27: aload_0
    //   28: ldc 205
    //   30: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_0
    //   35: iload_1
    //   36: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc 182
    //   42: aload_0
    //   43: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 189	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: iconst_0
    //   50: newarray byte
    //   52: areturn
    //   53: iload_2
    //   54: ifge +37 -> 91
    //   57: new 201	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   64: astore_0
    //   65: aload_0
    //   66: ldc 218
    //   68: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_0
    //   73: iload_2
    //   74: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: ldc 182
    //   80: aload_0
    //   81: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 189	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: iconst_0
    //   88: newarray byte
    //   90: areturn
    //   91: iload_1
    //   92: iload_2
    //   93: iadd
    //   94: aload_0
    //   95: arraylength
    //   96: if_icmple +14 -> 110
    //   99: ldc 182
    //   101: ldc 220
    //   103: invokestatic 189	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: iconst_0
    //   107: newarray byte
    //   109: areturn
    //   110: iload_3
    //   111: iconst_2
    //   112: iand
    //   113: ifeq +205 -> 318
    //   116: aconst_null
    //   117: astore 12
    //   119: aconst_null
    //   120: astore 8
    //   122: new 222	java/io/ByteArrayOutputStream
    //   125: dup
    //   126: invokespecial 223	java/io/ByteArrayOutputStream:<init>	()V
    //   129: astore 9
    //   131: new 225	com/tencent/luggage/wxa/pn/a$a
    //   134: dup
    //   135: aload 9
    //   137: iload_3
    //   138: iconst_1
    //   139: ior
    //   140: invokespecial 228	com/tencent/luggage/wxa/pn/a$a:<init>	(Ljava/io/OutputStream;I)V
    //   143: astore 10
    //   145: new 230	java/util/zip/GZIPOutputStream
    //   148: dup
    //   149: aload 10
    //   151: invokespecial 233	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   154: astore 11
    //   156: aload 11
    //   158: aload_0
    //   159: iload_1
    //   160: iload_2
    //   161: invokevirtual 237	java/util/zip/GZIPOutputStream:write	([BII)V
    //   164: aload 11
    //   166: invokevirtual 240	java/util/zip/GZIPOutputStream:close	()V
    //   169: aload 11
    //   171: invokevirtual 240	java/util/zip/GZIPOutputStream:close	()V
    //   174: aload 10
    //   176: invokevirtual 241	com/tencent/luggage/wxa/pn/a$a:close	()V
    //   179: aload 9
    //   181: invokevirtual 242	java/io/ByteArrayOutputStream:close	()V
    //   184: aload 9
    //   186: invokevirtual 246	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   189: areturn
    //   190: astore_0
    //   191: aload 10
    //   193: astore 8
    //   195: goto +106 -> 301
    //   198: astore 8
    //   200: aload 11
    //   202: astore_0
    //   203: goto +41 -> 244
    //   206: astore_0
    //   207: aload 12
    //   209: astore 11
    //   211: aload 10
    //   213: astore 8
    //   215: goto +86 -> 301
    //   218: astore 8
    //   220: aconst_null
    //   221: astore_0
    //   222: goto +22 -> 244
    //   225: astore_0
    //   226: aconst_null
    //   227: astore 8
    //   229: aload 12
    //   231: astore 11
    //   233: goto +68 -> 301
    //   236: astore 8
    //   238: aconst_null
    //   239: astore 10
    //   241: aload 10
    //   243: astore_0
    //   244: aload 9
    //   246: astore 11
    //   248: aload 8
    //   250: astore 9
    //   252: aload 11
    //   254: astore 8
    //   256: goto +26 -> 282
    //   259: astore_0
    //   260: aconst_null
    //   261: astore 9
    //   263: aload 9
    //   265: astore 8
    //   267: aload 12
    //   269: astore 11
    //   271: goto +30 -> 301
    //   274: astore 9
    //   276: aconst_null
    //   277: astore 10
    //   279: aload 10
    //   281: astore_0
    //   282: aload 9
    //   284: athrow
    //   285: astore 12
    //   287: aload 8
    //   289: astore 9
    //   291: aload_0
    //   292: astore 11
    //   294: aload 10
    //   296: astore 8
    //   298: aload 12
    //   300: astore_0
    //   301: aload 11
    //   303: invokevirtual 240	java/util/zip/GZIPOutputStream:close	()V
    //   306: aload 8
    //   308: invokevirtual 241	com/tencent/luggage/wxa/pn/a$a:close	()V
    //   311: aload 9
    //   313: invokevirtual 242	java/io/ByteArrayOutputStream:close	()V
    //   316: aload_0
    //   317: athrow
    //   318: iload_3
    //   319: bipush 8
    //   321: iand
    //   322: ifeq +9 -> 331
    //   325: iconst_1
    //   326: istore 6
    //   328: goto +6 -> 334
    //   331: iconst_0
    //   332: istore 6
    //   334: iload_2
    //   335: iconst_3
    //   336: idiv
    //   337: istore 5
    //   339: iload_2
    //   340: iconst_3
    //   341: irem
    //   342: ifle +9 -> 351
    //   345: iconst_4
    //   346: istore 4
    //   348: goto +6 -> 354
    //   351: iconst_0
    //   352: istore 4
    //   354: iload 5
    //   356: iconst_4
    //   357: imul
    //   358: iload 4
    //   360: iadd
    //   361: istore 5
    //   363: iload 5
    //   365: istore 4
    //   367: iload 6
    //   369: ifeq +13 -> 382
    //   372: iload 5
    //   374: iload 5
    //   376: bipush 76
    //   378: idiv
    //   379: iadd
    //   380: istore 4
    //   382: iload 4
    //   384: newarray byte
    //   386: astore 8
    //   388: iconst_0
    //   389: istore 7
    //   391: iconst_0
    //   392: istore 4
    //   394: iconst_0
    //   395: istore 5
    //   397: iload 7
    //   399: iload_2
    //   400: iconst_2
    //   401: isub
    //   402: if_icmpge +72 -> 474
    //   405: aload_0
    //   406: iload 7
    //   408: iload_1
    //   409: iadd
    //   410: iconst_3
    //   411: aload 8
    //   413: iload 4
    //   415: iload_3
    //   416: invokestatic 248	com/tencent/luggage/wxa/pn/a:a	([BII[BII)[B
    //   419: pop
    //   420: iload 5
    //   422: iconst_4
    //   423: iadd
    //   424: istore 5
    //   426: iload 6
    //   428: ifeq +31 -> 459
    //   431: iload 5
    //   433: bipush 76
    //   435: if_icmplt +24 -> 459
    //   438: aload 8
    //   440: iload 4
    //   442: iconst_4
    //   443: iadd
    //   444: bipush 10
    //   446: bastore
    //   447: iload 4
    //   449: iconst_1
    //   450: iadd
    //   451: istore 4
    //   453: iconst_0
    //   454: istore 5
    //   456: goto +3 -> 459
    //   459: iload 7
    //   461: iconst_3
    //   462: iadd
    //   463: istore 7
    //   465: iload 4
    //   467: iconst_4
    //   468: iadd
    //   469: istore 4
    //   471: goto -74 -> 397
    //   474: iload 4
    //   476: istore 5
    //   478: iload 7
    //   480: iload_2
    //   481: if_icmpge +27 -> 508
    //   484: aload_0
    //   485: iload 7
    //   487: iload_1
    //   488: iadd
    //   489: iload_2
    //   490: iload 7
    //   492: isub
    //   493: aload 8
    //   495: iload 4
    //   497: iload_3
    //   498: invokestatic 248	com/tencent/luggage/wxa/pn/a:a	([BII[BII)[B
    //   501: pop
    //   502: iload 4
    //   504: iconst_4
    //   505: iadd
    //   506: istore 5
    //   508: iload 5
    //   510: aload 8
    //   512: arraylength
    //   513: iconst_1
    //   514: isub
    //   515: if_icmpgt +20 -> 535
    //   518: iload 5
    //   520: newarray byte
    //   522: astore_0
    //   523: aload 8
    //   525: iconst_0
    //   526: aload_0
    //   527: iconst_0
    //   528: iload 5
    //   530: invokestatic 254	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   533: aload_0
    //   534: areturn
    //   535: aload 8
    //   537: areturn
    //   538: astore_0
    //   539: goto -365 -> 174
    //   542: astore_0
    //   543: goto -364 -> 179
    //   546: astore_0
    //   547: goto -363 -> 184
    //   550: astore 10
    //   552: goto -246 -> 306
    //   555: astore 8
    //   557: goto -246 -> 311
    //   560: astore 8
    //   562: goto -246 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	paramArrayOfByte	byte[]
    //   0	565	1	paramInt1	int
    //   0	565	2	paramInt2	int
    //   0	565	3	paramInt3	int
    //   346	160	4	i	int
    //   337	192	5	j	int
    //   326	101	6	k	int
    //   389	104	7	m	int
    //   120	74	8	localObject1	Object
    //   198	1	8	localIOException1	IOException
    //   213	1	8	localObject2	Object
    //   218	1	8	localIOException2	IOException
    //   227	1	8	localObject3	Object
    //   236	13	8	localIOException3	IOException
    //   254	282	8	localObject4	Object
    //   555	1	8	localException1	java.lang.Exception
    //   560	1	8	localException2	java.lang.Exception
    //   129	135	9	localObject5	Object
    //   274	9	9	localIOException4	IOException
    //   289	23	9	localObject6	Object
    //   143	152	10	locala	a.a
    //   550	1	10	localException3	java.lang.Exception
    //   154	148	11	localObject7	Object
    //   117	151	12	localObject8	Object
    //   285	14	12	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   156	169	190	finally
    //   156	169	198	java/io/IOException
    //   145	156	206	finally
    //   145	156	218	java/io/IOException
    //   131	145	225	finally
    //   131	145	236	java/io/IOException
    //   122	131	259	finally
    //   122	131	274	java/io/IOException
    //   282	285	285	finally
    //   169	174	538	java/lang/Exception
    //   174	179	542	java/lang/Exception
    //   179	184	546	java/lang/Exception
    //   301	306	550	java/lang/Exception
    //   306	311	555	java/lang/Exception
    //   311	316	560	java/lang/Exception
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte2, 0, paramInt1, paramArrayOfByte1, 0, paramInt2);
    return paramArrayOfByte1;
  }
  
  private static final byte[] c(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return d;
    }
    if ((paramInt & 0x20) == 32) {
      return f;
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pn.a
 * JD-Core Version:    0.7.0.1
 */