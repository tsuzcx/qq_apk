package com.tencent.luggage.wxa.an;

import android.util.SparseArray;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.b;
import com.tencent.luggage.wxa.ao.q;
import com.tencent.luggage.wxa.ao.x;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

class j
{
  private final HashMap<String, i> a;
  private final SparseArray<String> b;
  private final b c;
  private final Cipher d;
  private final SecretKeySpec e;
  private final boolean f;
  private boolean g;
  private q h;
  
  public j(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 16) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      a.a(paramBoolean);
      try
      {
        this.d = g();
        this.e = new SecretKeySpec(paramArrayOfByte, "AES");
      }
      catch (NoSuchPaddingException paramFile) {}catch (NoSuchAlgorithmException paramFile) {}
      throw new IllegalStateException(paramFile);
    }
    else
    {
      this.d = null;
      this.e = null;
    }
    this.a = new HashMap();
    this.b = new SparseArray();
    this.c = new b(new File(paramFile, "cached_content_index.exi"));
  }
  
  public static int a(SparseArray<String> paramSparseArray)
  {
    int k = paramSparseArray.size();
    int i;
    if (k == 0) {
      i = 0;
    } else {
      i = paramSparseArray.keyAt(k - 1) + 1;
    }
    int j = i;
    if (i < 0)
    {
      i = 0;
      for (;;)
      {
        j = i;
        if (i >= k) {
          break;
        }
        if (i != paramSparseArray.keyAt(i)) {
          return i;
        }
        i += 1;
      }
    }
    return j;
  }
  
  private i b(String paramString, long paramLong)
  {
    paramString = new i(a(this.b), paramString, paramLong);
    a(paramString);
    return paramString;
  }
  
  private void b(i parami)
  {
    this.a.put(parami.b, parami);
    this.b.put(parami.a, parami.b);
  }
  
  /* Error */
  private boolean e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 4
    //   11: astore 5
    //   13: aload 8
    //   15: astore 6
    //   17: aload 9
    //   19: astore 7
    //   21: new 127	java/io/BufferedInputStream
    //   24: dup
    //   25: aload_0
    //   26: getfield 80	com/tencent/luggage/wxa/an/j:c	Lcom/tencent/luggage/wxa/ao/b;
    //   29: invokevirtual 130	com/tencent/luggage/wxa/ao/b:c	()Ljava/io/InputStream;
    //   32: invokespecial 133	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore 10
    //   37: aload 4
    //   39: astore 5
    //   41: aload 8
    //   43: astore 6
    //   45: aload 9
    //   47: astore 7
    //   49: new 135	java/io/DataInputStream
    //   52: dup
    //   53: aload 10
    //   55: invokespecial 136	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   58: astore 4
    //   60: aload 4
    //   62: astore 5
    //   64: aload 4
    //   66: invokevirtual 139	java/io/DataInputStream:readInt	()I
    //   69: istore_1
    //   70: iload_1
    //   71: iconst_1
    //   72: if_icmpeq +10 -> 82
    //   75: aload 4
    //   77: invokestatic 144	com/tencent/luggage/wxa/ao/x:a	(Ljava/io/Closeable;)V
    //   80: iconst_0
    //   81: ireturn
    //   82: aload 4
    //   84: astore 5
    //   86: aload 4
    //   88: invokevirtual 139	java/io/DataInputStream:readInt	()I
    //   91: iconst_1
    //   92: iand
    //   93: ifeq +126 -> 219
    //   96: aload 4
    //   98: astore 5
    //   100: aload_0
    //   101: getfield 42	com/tencent/luggage/wxa/an/j:d	Ljavax/crypto/Cipher;
    //   104: astore 6
    //   106: aload 6
    //   108: ifnonnull +10 -> 118
    //   111: aload 4
    //   113: invokestatic 144	com/tencent/luggage/wxa/ao/x:a	(Ljava/io/Closeable;)V
    //   116: iconst_0
    //   117: ireturn
    //   118: aload 4
    //   120: astore 5
    //   122: bipush 16
    //   124: newarray byte
    //   126: astore 6
    //   128: aload 4
    //   130: astore 5
    //   132: aload 4
    //   134: aload 6
    //   136: invokevirtual 148	java/io/DataInputStream:readFully	([B)V
    //   139: aload 4
    //   141: astore 5
    //   143: new 150	javax/crypto/spec/IvParameterSpec
    //   146: dup
    //   147: aload 6
    //   149: invokespecial 152	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   152: astore 6
    //   154: aload 4
    //   156: astore 5
    //   158: aload_0
    //   159: getfield 42	com/tencent/luggage/wxa/an/j:d	Ljavax/crypto/Cipher;
    //   162: iconst_2
    //   163: aload_0
    //   164: getfield 51	com/tencent/luggage/wxa/an/j:e	Ljavax/crypto/spec/SecretKeySpec;
    //   167: aload 6
    //   169: invokevirtual 158	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   172: aload 4
    //   174: astore 5
    //   176: new 135	java/io/DataInputStream
    //   179: dup
    //   180: new 160	javax/crypto/CipherInputStream
    //   183: dup
    //   184: aload 10
    //   186: aload_0
    //   187: getfield 42	com/tencent/luggage/wxa/an/j:d	Ljavax/crypto/Cipher;
    //   190: invokespecial 163	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   193: invokespecial 136	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   196: astore 6
    //   198: aload 6
    //   200: astore 4
    //   202: goto +37 -> 239
    //   205: aload 4
    //   207: astore 5
    //   209: new 53	java/lang/IllegalStateException
    //   212: dup
    //   213: aload 6
    //   215: invokespecial 56	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   218: athrow
    //   219: aload 4
    //   221: astore 5
    //   223: aload_0
    //   224: getfield 42	com/tencent/luggage/wxa/an/j:d	Ljavax/crypto/Cipher;
    //   227: ifnull +12 -> 239
    //   230: aload 4
    //   232: astore 5
    //   234: aload_0
    //   235: iconst_1
    //   236: putfield 165	com/tencent/luggage/wxa/an/j:g	Z
    //   239: aload 4
    //   241: astore 5
    //   243: aload 4
    //   245: astore 6
    //   247: aload 4
    //   249: astore 7
    //   251: aload 4
    //   253: invokevirtual 139	java/io/DataInputStream:readInt	()I
    //   256: istore_3
    //   257: iconst_0
    //   258: istore_2
    //   259: iconst_0
    //   260: istore_1
    //   261: iload_2
    //   262: iload_3
    //   263: if_icmpge +71 -> 334
    //   266: aload 4
    //   268: astore 5
    //   270: aload 4
    //   272: astore 6
    //   274: aload 4
    //   276: astore 7
    //   278: new 95	com/tencent/luggage/wxa/an/i
    //   281: dup
    //   282: aload 4
    //   284: invokespecial 168	com/tencent/luggage/wxa/an/i:<init>	(Ljava/io/DataInputStream;)V
    //   287: astore 8
    //   289: aload 4
    //   291: astore 5
    //   293: aload 4
    //   295: astore 6
    //   297: aload 4
    //   299: astore 7
    //   301: aload_0
    //   302: aload 8
    //   304: invokespecial 170	com/tencent/luggage/wxa/an/j:b	(Lcom/tencent/luggage/wxa/an/i;)V
    //   307: aload 4
    //   309: astore 5
    //   311: aload 4
    //   313: astore 6
    //   315: aload 4
    //   317: astore 7
    //   319: iload_1
    //   320: aload 8
    //   322: invokevirtual 172	com/tencent/luggage/wxa/an/i:d	()I
    //   325: iadd
    //   326: istore_1
    //   327: iload_2
    //   328: iconst_1
    //   329: iadd
    //   330: istore_2
    //   331: goto -70 -> 261
    //   334: aload 4
    //   336: astore 5
    //   338: aload 4
    //   340: astore 6
    //   342: aload 4
    //   344: astore 7
    //   346: aload 4
    //   348: invokevirtual 139	java/io/DataInputStream:readInt	()I
    //   351: istore_2
    //   352: iload_2
    //   353: iload_1
    //   354: if_icmpeq +10 -> 364
    //   357: aload 4
    //   359: invokestatic 144	com/tencent/luggage/wxa/ao/x:a	(Ljava/io/Closeable;)V
    //   362: iconst_0
    //   363: ireturn
    //   364: aload 4
    //   366: invokestatic 144	com/tencent/luggage/wxa/ao/x:a	(Ljava/io/Closeable;)V
    //   369: iconst_1
    //   370: ireturn
    //   371: astore 6
    //   373: goto +21 -> 394
    //   376: goto +63 -> 439
    //   379: astore 4
    //   381: goto +41 -> 422
    //   384: astore 5
    //   386: aload 6
    //   388: astore 4
    //   390: aload 5
    //   392: astore 6
    //   394: aload 4
    //   396: astore 5
    //   398: ldc 174
    //   400: ldc 176
    //   402: aload 6
    //   404: invokestatic 181	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   407: pop
    //   408: aload 4
    //   410: ifnull +8 -> 418
    //   413: aload 4
    //   415: invokestatic 144	com/tencent/luggage/wxa/ao/x:a	(Ljava/io/Closeable;)V
    //   418: iconst_0
    //   419: ireturn
    //   420: astore 4
    //   422: aload 5
    //   424: ifnull +8 -> 432
    //   427: aload 5
    //   429: invokestatic 144	com/tencent/luggage/wxa/ao/x:a	(Ljava/io/Closeable;)V
    //   432: aload 4
    //   434: athrow
    //   435: aload 7
    //   437: astore 4
    //   439: aload 4
    //   441: ifnull +8 -> 449
    //   444: aload 4
    //   446: invokestatic 144	com/tencent/luggage/wxa/ao/x:a	(Ljava/io/Closeable;)V
    //   449: iconst_0
    //   450: ireturn
    //   451: astore 4
    //   453: goto -18 -> 435
    //   456: astore 5
    //   458: goto -82 -> 376
    //   461: astore 6
    //   463: goto -258 -> 205
    //   466: astore 6
    //   468: goto -263 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	j
    //   69	286	1	i	int
    //   258	97	2	j	int
    //   256	8	3	k	int
    //   7	358	4	localObject1	Object
    //   379	1	4	localObject2	Object
    //   388	26	4	localObject3	Object
    //   420	13	4	localObject4	Object
    //   437	8	4	localObject5	Object
    //   451	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   11	326	5	localObject6	Object
    //   384	7	5	localIOException1	java.io.IOException
    //   396	32	5	localObject7	Object
    //   456	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   15	326	6	localObject8	Object
    //   371	16	6	localIOException2	java.io.IOException
    //   392	11	6	localIOException3	java.io.IOException
    //   461	1	6	localInvalidAlgorithmParameterException	java.security.InvalidAlgorithmParameterException
    //   466	1	6	localInvalidKeyException	java.security.InvalidKeyException
    //   19	417	7	localObject9	Object
    //   1	320	8	locali	i
    //   4	42	9	localObject10	Object
    //   35	150	10	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   64	70	371	java/io/IOException
    //   86	96	371	java/io/IOException
    //   100	106	371	java/io/IOException
    //   122	128	371	java/io/IOException
    //   132	139	371	java/io/IOException
    //   143	154	371	java/io/IOException
    //   158	172	371	java/io/IOException
    //   176	198	371	java/io/IOException
    //   209	219	371	java/io/IOException
    //   223	230	371	java/io/IOException
    //   234	239	371	java/io/IOException
    //   21	37	379	finally
    //   49	60	379	finally
    //   251	257	379	finally
    //   278	289	379	finally
    //   301	307	379	finally
    //   319	327	379	finally
    //   346	352	379	finally
    //   21	37	384	java/io/IOException
    //   49	60	384	java/io/IOException
    //   251	257	384	java/io/IOException
    //   278	289	384	java/io/IOException
    //   301	307	384	java/io/IOException
    //   319	327	384	java/io/IOException
    //   346	352	384	java/io/IOException
    //   64	70	420	finally
    //   86	96	420	finally
    //   100	106	420	finally
    //   122	128	420	finally
    //   132	139	420	finally
    //   143	154	420	finally
    //   158	172	420	finally
    //   176	198	420	finally
    //   209	219	420	finally
    //   223	230	420	finally
    //   234	239	420	finally
    //   398	408	420	finally
    //   21	37	451	java/io/FileNotFoundException
    //   49	60	451	java/io/FileNotFoundException
    //   251	257	451	java/io/FileNotFoundException
    //   278	289	451	java/io/FileNotFoundException
    //   301	307	451	java/io/FileNotFoundException
    //   319	327	451	java/io/FileNotFoundException
    //   346	352	451	java/io/FileNotFoundException
    //   64	70	456	java/io/FileNotFoundException
    //   86	96	456	java/io/FileNotFoundException
    //   100	106	456	java/io/FileNotFoundException
    //   122	128	456	java/io/FileNotFoundException
    //   132	139	456	java/io/FileNotFoundException
    //   143	154	456	java/io/FileNotFoundException
    //   158	172	456	java/io/FileNotFoundException
    //   176	198	456	java/io/FileNotFoundException
    //   209	219	456	java/io/FileNotFoundException
    //   223	230	456	java/io/FileNotFoundException
    //   234	239	456	java/io/FileNotFoundException
    //   158	172	461	java/security/InvalidAlgorithmParameterException
    //   158	172	466	java/security/InvalidKeyException
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/tencent/luggage/wxa/an/j:c	Lcom/tencent/luggage/wxa/ao/b;
    //   4: invokevirtual 184	com/tencent/luggage/wxa/ao/b:b	()Ljava/io/OutputStream;
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 186	com/tencent/luggage/wxa/an/j:h	Lcom/tencent/luggage/wxa/ao/q;
    //   13: ifnonnull +19 -> 32
    //   16: aload_0
    //   17: new 188	com/tencent/luggage/wxa/ao/q
    //   20: dup
    //   21: aload 5
    //   23: invokespecial 191	com/tencent/luggage/wxa/ao/q:<init>	(Ljava/io/OutputStream;)V
    //   26: putfield 186	com/tencent/luggage/wxa/an/j:h	Lcom/tencent/luggage/wxa/ao/q;
    //   29: goto +12 -> 41
    //   32: aload_0
    //   33: getfield 186	com/tencent/luggage/wxa/an/j:h	Lcom/tencent/luggage/wxa/ao/q;
    //   36: aload 5
    //   38: invokevirtual 193	com/tencent/luggage/wxa/ao/q:a	(Ljava/io/OutputStream;)V
    //   41: new 195	java/io/DataOutputStream
    //   44: dup
    //   45: aload_0
    //   46: getfield 186	com/tencent/luggage/wxa/an/j:h	Lcom/tencent/luggage/wxa/ao/q;
    //   49: invokespecial 196	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore 8
    //   54: aload 8
    //   56: astore 7
    //   58: aload 8
    //   60: astore 5
    //   62: aload 8
    //   64: iconst_1
    //   65: invokevirtual 200	java/io/DataOutputStream:writeInt	(I)V
    //   68: aload 8
    //   70: astore 7
    //   72: aload 8
    //   74: astore 5
    //   76: aload_0
    //   77: getfield 32	com/tencent/luggage/wxa/an/j:f	Z
    //   80: istore 4
    //   82: iconst_0
    //   83: istore_3
    //   84: iload 4
    //   86: ifeq +409 -> 495
    //   89: aload 8
    //   91: astore 7
    //   93: aload 8
    //   95: astore 5
    //   97: aload_0
    //   98: getfield 42	com/tencent/luggage/wxa/an/j:d	Ljavax/crypto/Cipher;
    //   101: ifnull +394 -> 495
    //   104: iconst_1
    //   105: istore_1
    //   106: goto +391 -> 497
    //   109: aload 8
    //   111: astore 7
    //   113: aload 8
    //   115: astore 5
    //   117: aload 8
    //   119: iload_2
    //   120: invokevirtual 200	java/io/DataOutputStream:writeInt	(I)V
    //   123: aload 8
    //   125: astore 6
    //   127: iload_1
    //   128: ifeq +159 -> 287
    //   131: aload 8
    //   133: astore 7
    //   135: aload 8
    //   137: astore 5
    //   139: bipush 16
    //   141: newarray byte
    //   143: astore 6
    //   145: aload 8
    //   147: astore 7
    //   149: aload 8
    //   151: astore 5
    //   153: new 202	java/util/Random
    //   156: dup
    //   157: invokespecial 203	java/util/Random:<init>	()V
    //   160: aload 6
    //   162: invokevirtual 206	java/util/Random:nextBytes	([B)V
    //   165: aload 8
    //   167: astore 7
    //   169: aload 8
    //   171: astore 5
    //   173: aload 8
    //   175: aload 6
    //   177: invokevirtual 209	java/io/DataOutputStream:write	([B)V
    //   180: aload 8
    //   182: astore 7
    //   184: aload 8
    //   186: astore 5
    //   188: new 150	javax/crypto/spec/IvParameterSpec
    //   191: dup
    //   192: aload 6
    //   194: invokespecial 152	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   197: astore 6
    //   199: aload 8
    //   201: astore 7
    //   203: aload 8
    //   205: astore 5
    //   207: aload_0
    //   208: getfield 42	com/tencent/luggage/wxa/an/j:d	Ljavax/crypto/Cipher;
    //   211: iconst_1
    //   212: aload_0
    //   213: getfield 51	com/tencent/luggage/wxa/an/j:e	Ljavax/crypto/spec/SecretKeySpec;
    //   216: aload 6
    //   218: invokevirtual 158	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   221: aload 8
    //   223: astore 7
    //   225: aload 8
    //   227: astore 5
    //   229: aload 8
    //   231: invokevirtual 212	java/io/DataOutputStream:flush	()V
    //   234: aload 8
    //   236: astore 7
    //   238: aload 8
    //   240: astore 5
    //   242: new 195	java/io/DataOutputStream
    //   245: dup
    //   246: new 214	javax/crypto/CipherOutputStream
    //   249: dup
    //   250: aload_0
    //   251: getfield 186	com/tencent/luggage/wxa/an/j:h	Lcom/tencent/luggage/wxa/ao/q;
    //   254: aload_0
    //   255: getfield 42	com/tencent/luggage/wxa/an/j:d	Ljavax/crypto/Cipher;
    //   258: invokespecial 217	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   261: invokespecial 196	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   264: astore 6
    //   266: goto +21 -> 287
    //   269: aload 8
    //   271: astore 7
    //   273: aload 8
    //   275: astore 5
    //   277: new 53	java/lang/IllegalStateException
    //   280: dup
    //   281: aload 6
    //   283: invokespecial 56	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   286: athrow
    //   287: aload 6
    //   289: astore 7
    //   291: aload 6
    //   293: astore 5
    //   295: aload 6
    //   297: aload_0
    //   298: getfield 61	com/tencent/luggage/wxa/an/j:a	Ljava/util/HashMap;
    //   301: invokevirtual 218	java/util/HashMap:size	()I
    //   304: invokevirtual 200	java/io/DataOutputStream:writeInt	(I)V
    //   307: aload 6
    //   309: astore 7
    //   311: aload 6
    //   313: astore 5
    //   315: aload_0
    //   316: getfield 61	com/tencent/luggage/wxa/an/j:a	Ljava/util/HashMap;
    //   319: invokevirtual 222	java/util/HashMap:values	()Ljava/util/Collection;
    //   322: invokeinterface 228 1 0
    //   327: astore 8
    //   329: iload_3
    //   330: istore_1
    //   331: aload 6
    //   333: astore 7
    //   335: aload 6
    //   337: astore 5
    //   339: aload 8
    //   341: invokeinterface 233 1 0
    //   346: ifeq +57 -> 403
    //   349: aload 6
    //   351: astore 7
    //   353: aload 6
    //   355: astore 5
    //   357: aload 8
    //   359: invokeinterface 237 1 0
    //   364: checkcast 95	com/tencent/luggage/wxa/an/i
    //   367: astore 9
    //   369: aload 6
    //   371: astore 7
    //   373: aload 6
    //   375: astore 5
    //   377: aload 9
    //   379: aload 6
    //   381: invokevirtual 240	com/tencent/luggage/wxa/an/i:a	(Ljava/io/DataOutputStream;)V
    //   384: aload 6
    //   386: astore 7
    //   388: aload 6
    //   390: astore 5
    //   392: iload_1
    //   393: aload 9
    //   395: invokevirtual 172	com/tencent/luggage/wxa/an/i:d	()I
    //   398: iadd
    //   399: istore_1
    //   400: goto -69 -> 331
    //   403: aload 6
    //   405: astore 7
    //   407: aload 6
    //   409: astore 5
    //   411: aload 6
    //   413: iload_1
    //   414: invokevirtual 200	java/io/DataOutputStream:writeInt	(I)V
    //   417: aload 6
    //   419: astore 7
    //   421: aload 6
    //   423: astore 5
    //   425: aload_0
    //   426: getfield 80	com/tencent/luggage/wxa/an/j:c	Lcom/tencent/luggage/wxa/ao/b;
    //   429: aload 6
    //   431: invokevirtual 241	com/tencent/luggage/wxa/ao/b:a	(Ljava/io/OutputStream;)V
    //   434: aconst_null
    //   435: invokestatic 144	com/tencent/luggage/wxa/ao/x:a	(Ljava/io/Closeable;)V
    //   438: return
    //   439: astore 6
    //   441: aload 7
    //   443: astore 5
    //   445: goto +16 -> 461
    //   448: astore 5
    //   450: aconst_null
    //   451: astore 6
    //   453: goto +28 -> 481
    //   456: astore 6
    //   458: aconst_null
    //   459: astore 5
    //   461: new 243	com/tencent/luggage/wxa/an/a$a
    //   464: dup
    //   465: aload 6
    //   467: invokespecial 246	com/tencent/luggage/wxa/an/a$a:<init>	(Ljava/io/IOException;)V
    //   470: athrow
    //   471: astore 7
    //   473: aload 5
    //   475: astore 6
    //   477: aload 7
    //   479: astore 5
    //   481: aload 6
    //   483: invokestatic 144	com/tencent/luggage/wxa/ao/x:a	(Ljava/io/Closeable;)V
    //   486: goto +6 -> 492
    //   489: aload 5
    //   491: athrow
    //   492: goto -3 -> 489
    //   495: iconst_0
    //   496: istore_1
    //   497: iload_1
    //   498: ifeq +8 -> 506
    //   501: iconst_1
    //   502: istore_2
    //   503: goto -394 -> 109
    //   506: iconst_0
    //   507: istore_2
    //   508: goto -399 -> 109
    //   511: astore 6
    //   513: goto -244 -> 269
    //   516: astore 6
    //   518: goto -249 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	j
    //   105	393	1	i	int
    //   119	389	2	j	int
    //   83	247	3	k	int
    //   80	5	4	bool	boolean
    //   7	437	5	localObject1	Object
    //   448	1	5	localObject2	Object
    //   459	31	5	localObject3	Object
    //   125	305	6	localObject4	Object
    //   439	1	6	localIOException1	java.io.IOException
    //   451	1	6	localObject5	Object
    //   456	10	6	localIOException2	java.io.IOException
    //   475	7	6	localObject6	Object
    //   511	1	6	localInvalidAlgorithmParameterException	java.security.InvalidAlgorithmParameterException
    //   516	1	6	localInvalidKeyException	java.security.InvalidKeyException
    //   56	386	7	localObject7	Object
    //   471	7	7	localObject8	Object
    //   52	306	8	localObject9	Object
    //   367	27	9	locali	i
    // Exception table:
    //   from	to	target	type
    //   62	68	439	java/io/IOException
    //   76	82	439	java/io/IOException
    //   97	104	439	java/io/IOException
    //   117	123	439	java/io/IOException
    //   139	145	439	java/io/IOException
    //   153	165	439	java/io/IOException
    //   173	180	439	java/io/IOException
    //   188	199	439	java/io/IOException
    //   207	221	439	java/io/IOException
    //   229	234	439	java/io/IOException
    //   242	266	439	java/io/IOException
    //   277	287	439	java/io/IOException
    //   295	307	439	java/io/IOException
    //   315	329	439	java/io/IOException
    //   339	349	439	java/io/IOException
    //   357	369	439	java/io/IOException
    //   377	384	439	java/io/IOException
    //   392	400	439	java/io/IOException
    //   411	417	439	java/io/IOException
    //   425	434	439	java/io/IOException
    //   0	29	448	finally
    //   32	41	448	finally
    //   41	54	448	finally
    //   0	29	456	java/io/IOException
    //   32	41	456	java/io/IOException
    //   41	54	456	java/io/IOException
    //   62	68	471	finally
    //   76	82	471	finally
    //   97	104	471	finally
    //   117	123	471	finally
    //   139	145	471	finally
    //   153	165	471	finally
    //   173	180	471	finally
    //   188	199	471	finally
    //   207	221	471	finally
    //   229	234	471	finally
    //   242	266	471	finally
    //   277	287	471	finally
    //   295	307	471	finally
    //   315	329	471	finally
    //   339	349	471	finally
    //   357	369	471	finally
    //   377	384	471	finally
    //   392	400	471	finally
    //   411	417	471	finally
    //   425	434	471	finally
    //   461	471	471	finally
    //   207	221	511	java/security/InvalidAlgorithmParameterException
    //   207	221	516	java/security/InvalidKeyException
  }
  
  private static Cipher g()
  {
    if (x.a == 18) {}
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
      return localCipher;
    }
    catch (Throwable localThrowable)
    {
      label18:
      break label18;
    }
    return Cipher.getInstance("AES/CBC/PKCS5PADDING");
  }
  
  public i a(String paramString)
  {
    i locali2 = (i)this.a.get(paramString);
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = b(paramString, -1L);
    }
    return locali1;
  }
  
  public String a(int paramInt)
  {
    return (String)this.b.get(paramInt);
  }
  
  public void a()
  {
    a.b(this.g ^ true);
    if (!e())
    {
      this.c.a();
      this.a.clear();
      this.b.clear();
    }
  }
  
  void a(i parami)
  {
    b(parami);
    this.g = true;
  }
  
  public void a(String paramString, long paramLong)
  {
    i locali = b(paramString);
    if (locali != null)
    {
      if (locali.a() != paramLong)
      {
        locali.a(paramLong);
        this.g = true;
      }
    }
    else {
      b(paramString, paramLong);
    }
  }
  
  public i b(String paramString)
  {
    return (i)this.a.get(paramString);
  }
  
  public void b()
  {
    if (!this.g) {
      return;
    }
    f();
    this.g = false;
  }
  
  public int c(String paramString)
  {
    return a(paramString).a;
  }
  
  public Collection<i> c()
  {
    return this.a.values();
  }
  
  public void d()
  {
    Object localObject = new LinkedList();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.c()) {
        ((LinkedList)localObject).add(locali.b);
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      d((String)((Iterator)localObject).next());
    }
  }
  
  public void d(String paramString)
  {
    paramString = (i)this.a.remove(paramString);
    if (paramString != null)
    {
      a.b(paramString.c());
      this.b.remove(paramString.a);
      this.g = true;
    }
  }
  
  public long e(String paramString)
  {
    paramString = b(paramString);
    if (paramString == null) {
      return -1L;
    }
    return paramString.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.an.j
 * JD-Core Version:    0.7.0.1
 */