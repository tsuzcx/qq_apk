import android.graphics.Bitmap;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QbarAiModelParam;
import com.tencent.qphone.base.util.QLog;

public class bdsg
{
  private static int jdField_a_of_type_Int = -1;
  public static QbarNative a;
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean;
  private static int[] jdField_a_of_type_ArrayOfInt;
  public static final String[] a;
  private static int jdField_b_of_type_Int = -1;
  public static QbarNative b;
  private static String jdField_b_of_type_JavaLangString;
  private static int c;
  private static int d;
  private static int e;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "detect_model.bin", "detect_model.param", "srnet.bin", "srnet.param" };
  }
  
  public static int a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "ReleaseForFile.");
      }
      int i = a(1);
      return i;
    }
    finally {}
  }
  
  /* Error */
  private static int a(int paramInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +63 -> 71
    //   11: ldc 43
    //   13: iconst_2
    //   14: new 53	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   21: ldc 58
    //   23: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: getstatic 19	bdsg:jdField_a_of_type_Int	I
    //   29: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc 67
    //   34: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   40: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc 74
    //   45: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: getstatic 21	bdsg:jdField_b_of_type_Int	I
    //   51: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc 76
    //   56: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   62: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iload_0
    //   72: iconst_1
    //   73: if_icmpne +97 -> 170
    //   76: iload_1
    //   77: istore_0
    //   78: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   81: ifnull +18 -> 99
    //   84: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   87: invokevirtual 86	com/tencent/qbar/QbarNative:a	()I
    //   90: istore_0
    //   91: aconst_null
    //   92: putstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   95: iconst_m1
    //   96: putstatic 19	bdsg:jdField_a_of_type_Int	I
    //   99: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +63 -> 165
    //   105: ldc 43
    //   107: iconst_2
    //   108: new 53	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   115: ldc 88
    //   117: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: getstatic 19	bdsg:jdField_a_of_type_Int	I
    //   123: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc 67
    //   128: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   134: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: ldc 74
    //   139: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: getstatic 21	bdsg:jdField_b_of_type_Int	I
    //   145: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: ldc 76
    //   150: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   156: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: ldc 2
    //   167: monitorexit
    //   168: iload_0
    //   169: ireturn
    //   170: iload_1
    //   171: istore_0
    //   172: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   175: ifnull -76 -> 99
    //   178: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   181: invokevirtual 86	com/tencent/qbar/QbarNative:a	()I
    //   184: istore_1
    //   185: aconst_null
    //   186: putstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   189: iconst_m1
    //   190: putstatic 21	bdsg:jdField_b_of_type_Int	I
    //   193: iload_1
    //   194: istore_0
    //   195: getstatic 90	bdsg:jdField_a_of_type_Boolean	Z
    //   198: ifne -99 -> 99
    //   201: iconst_m1
    //   202: putstatic 92	bdsg:c	I
    //   205: aconst_null
    //   206: putstatic 94	bdsg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   209: aconst_null
    //   210: putstatic 96	bdsg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   213: aconst_null
    //   214: putstatic 98	bdsg:jdField_a_of_type_ArrayOfInt	[I
    //   217: iconst_m1
    //   218: putstatic 100	bdsg:d	I
    //   221: iconst_0
    //   222: putstatic 102	bdsg:e	I
    //   225: iload_1
    //   226: istore_0
    //   227: goto -128 -> 99
    //   230: astore_2
    //   231: ldc 2
    //   233: monitorexit
    //   234: aload_2
    //   235: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramInt	int
    //   1	225	1	i	int
    //   230	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	71	230	finally
    //   78	99	230	finally
    //   99	165	230	finally
    //   172	193	230	finally
    //   195	225	230	finally
  }
  
  public static int a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QbarNativeImpl", 2, String.format("Init searchMode=%s scanMode=%s inputCharset=%s outputCharset=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 }));
        }
        int i = -1;
        boolean bool = asjl.a();
        if (bool)
        {
          paramInt2 = i;
          return paramInt2;
        }
        if (paramInt2 == 1)
        {
          if (jdField_b_of_type_ComTencentQbarQbarNative != null)
          {
            jdField_a_of_type_Boolean = true;
            e = 0;
            b();
          }
          if ((jdField_a_of_type_ComTencentQbarQbarNative == null) || (jdField_a_of_type_Int < 0))
          {
            jdField_a_of_type_ComTencentQbarQbarNative = new QbarNative();
            jdField_a_of_type_Int = jdField_a_of_type_ComTencentQbarQbarNative.a(paramInt1, 1, paramString1, paramString2, a(paramInt2));
          }
          paramInt1 = jdField_a_of_type_Int;
          paramInt2 = paramInt1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QbarNativeImpl", 2, String.format("Init result=%s ", new Object[] { Integer.valueOf(paramInt1) }));
          paramInt2 = paramInt1;
          continue;
        }
        if (jdField_b_of_type_ComTencentQbarQbarNative == null) {
          break label186;
        }
      }
      finally {}
      if (jdField_b_of_type_Int < 0)
      {
        label186:
        jdField_b_of_type_ComTencentQbarQbarNative = new QbarNative();
        jdField_b_of_type_Int = jdField_b_of_type_ComTencentQbarQbarNative.a(paramInt1, 0, paramString1, paramString2, a(paramInt2));
        c = paramInt1;
        jdField_a_of_type_JavaLangString = paramString1;
        jdField_b_of_type_JavaLangString = paramString2;
        jdField_a_of_type_Boolean = false;
      }
      paramInt1 = jdField_b_of_type_Int;
    }
  }
  
  public static int a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "InitForFile.");
      }
      paramInt = a(paramInt, 1, paramString1, paramString2);
      return paramInt;
    }
    finally {}
  }
  
  public static int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "GetOneResultForFile.");
      }
      int i = a(paramStringBuilder1, paramStringBuilder2, 1);
      return i;
    }
    finally {}
  }
  
  /* Error */
  private static int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +72 -> 78
    //   9: ldc 43
    //   11: iconst_2
    //   12: new 53	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   19: ldc 145
    //   21: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 19	bdsg:jdField_a_of_type_Int	I
    //   27: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 67
    //   32: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   38: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc 74
    //   43: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 21	bdsg:jdField_b_of_type_Int	I
    //   49: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 76
    //   54: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   60: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: ldc 147
    //   65: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_2
    //   69: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iload_2
    //   79: iconst_1
    //   80: if_icmpne +18 -> 98
    //   83: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   86: ifnonnull +25 -> 111
    //   89: getstatic 19	bdsg:jdField_a_of_type_Int	I
    //   92: istore_2
    //   93: ldc 2
    //   95: monitorexit
    //   96: iload_2
    //   97: ireturn
    //   98: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   101: ifnonnull +10 -> 111
    //   104: getstatic 21	bdsg:jdField_b_of_type_Int	I
    //   107: istore_2
    //   108: goto -15 -> 93
    //   111: new 53	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   118: astore_3
    //   119: new 53	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   126: astore 4
    //   128: iconst_2
    //   129: newarray int
    //   131: astore 5
    //   133: iload_2
    //   134: iconst_1
    //   135: if_icmpne +20 -> 155
    //   138: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   141: aload_0
    //   142: aload_1
    //   143: aload_3
    //   144: aload 4
    //   146: aload 5
    //   148: invokevirtual 150	com/tencent/qbar/QbarNative:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;[I)I
    //   151: istore_2
    //   152: goto -59 -> 93
    //   155: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   158: aload_0
    //   159: aload_1
    //   160: aload_3
    //   161: aload 4
    //   163: aload 5
    //   165: invokevirtual 150	com/tencent/qbar/QbarNative:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;[I)I
    //   168: istore_2
    //   169: goto -76 -> 93
    //   172: astore_3
    //   173: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +38 -> 214
    //   179: ldc 43
    //   181: iconst_2
    //   182: new 53	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   189: ldc 152
    //   191: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_0
    //   195: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: ldc 154
    //   200: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_1
    //   204: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: aload_3
    //   211: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: iconst_0
    //   215: istore_2
    //   216: goto -123 -> 93
    //   219: astore_0
    //   220: ldc 2
    //   222: monitorexit
    //   223: aload_0
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramStringBuilder1	StringBuilder
    //   0	225	1	paramStringBuilder2	StringBuilder
    //   0	225	2	paramInt	int
    //   118	43	3	localStringBuilder1	StringBuilder
    //   172	39	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   126	36	4	localStringBuilder2	StringBuilder
    //   131	33	5	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   111	133	172	java/lang/UnsatisfiedLinkError
    //   138	152	172	java/lang/UnsatisfiedLinkError
    //   155	169	172	java/lang/UnsatisfiedLinkError
    //   3	78	219	finally
    //   83	93	219	finally
    //   98	108	219	finally
    //   111	133	219	finally
    //   138	152	219	finally
    //   155	169	219	finally
    //   173	214	219	finally
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "ScanImageForFile.");
      }
      paramInt1 = a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, 1);
      return paramInt1;
    }
    finally {}
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QbarNativeImpl", 2, "ScanImage. sInitResult=" + jdField_a_of_type_Int + " sQbarNative=" + jdField_a_of_type_ComTencentQbarQbarNative + " sInitResultForCamera=" + jdField_b_of_type_Int + " sQbarNativeForCamera=" + jdField_b_of_type_ComTencentQbarQbarNative + " scanMode=" + paramInt4);
        }
        if (paramInt4 == 1)
        {
          if (jdField_a_of_type_ComTencentQbarQbarNative == null)
          {
            paramInt1 = jdField_a_of_type_Int;
            return paramInt1;
          }
          paramInt2 = jdField_a_of_type_ComTencentQbarQbarNative.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        }
        else
        {
          if (jdField_b_of_type_ComTencentQbarQbarNative == null)
          {
            paramInt1 = jdField_b_of_type_Int;
            continue;
          }
          paramInt2 = jdField_b_of_type_ComTencentQbarQbarNative.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
        }
      }
      finally {}
      paramInt1 = i;
      if (paramInt2 < 0) {
        paramInt1 = -1;
      }
    }
  }
  
  public static int a(int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "SetReadersForFile.");
      }
      paramInt = a(paramArrayOfInt, paramInt, 1);
      return paramInt;
    }
    finally {}
  }
  
  /* Error */
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +72 -> 78
    //   9: ldc 43
    //   11: iconst_2
    //   12: new 53	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   19: ldc 175
    //   21: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 19	bdsg:jdField_a_of_type_Int	I
    //   27: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 67
    //   32: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   38: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc 74
    //   43: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 21	bdsg:jdField_b_of_type_Int	I
    //   49: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 76
    //   54: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   60: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: ldc 147
    //   65: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_2
    //   69: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iload_2
    //   79: iconst_1
    //   80: if_icmpne +30 -> 110
    //   83: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   86: ifnonnull +12 -> 98
    //   89: getstatic 19	bdsg:jdField_a_of_type_Int	I
    //   92: istore_1
    //   93: ldc 2
    //   95: monitorexit
    //   96: iload_1
    //   97: ireturn
    //   98: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   101: aload_0
    //   102: iload_1
    //   103: invokevirtual 177	com/tencent/qbar/QbarNative:a	([II)I
    //   106: istore_1
    //   107: goto -14 -> 93
    //   110: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   113: ifnonnull +10 -> 123
    //   116: getstatic 21	bdsg:jdField_b_of_type_Int	I
    //   119: istore_1
    //   120: goto -27 -> 93
    //   123: aload_0
    //   124: putstatic 98	bdsg:jdField_a_of_type_ArrayOfInt	[I
    //   127: iload_1
    //   128: putstatic 100	bdsg:d	I
    //   131: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   134: aload_0
    //   135: iload_1
    //   136: invokevirtual 177	com/tencent/qbar/QbarNative:a	([II)I
    //   139: istore_1
    //   140: goto -47 -> 93
    //   143: astore_0
    //   144: ldc 2
    //   146: monitorexit
    //   147: aload_0
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramArrayOfInt	int[]
    //   0	149	1	paramInt1	int
    //   0	149	2	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   3	78	143	finally
    //   83	93	143	finally
    //   98	107	143	finally
    //   110	120	143	finally
    //   123	140	143	finally
  }
  
  public static Bitmap a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    return QbarNative.a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, paramInt5);
  }
  
  private static QbarNative.QbarAiModelParam a(int paramInt)
  {
    QbarNative.QbarAiModelParam localQbarAiModelParam = new QbarNative.QbarAiModelParam();
    localQbarAiModelParam.detect_model_bin_path_ = "";
    localQbarAiModelParam.detect_model_param_path_ = "";
    localQbarAiModelParam.superresolution_model_bin_path_ = "";
    localQbarAiModelParam.superresolution_model_param_path_ = "";
    if (QLog.isColorLevel()) {
      QLog.i("QbarNativeImpl", 2, "getQbarAiModelParam has AI model : " + false);
    }
    return localQbarAiModelParam;
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +63 -> 69
    //   9: ldc 43
    //   11: iconst_2
    //   12: new 53	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   19: ldc 207
    //   21: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 19	bdsg:jdField_a_of_type_Int	I
    //   27: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 67
    //   32: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   38: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc 74
    //   43: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 21	bdsg:jdField_b_of_type_Int	I
    //   49: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 76
    //   54: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   60: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   72: ifnull +16 -> 88
    //   75: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   78: astore_0
    //   79: invokestatic 209	com/tencent/qbar/QbarNative:a	()Ljava/lang/String;
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_0
    //   87: areturn
    //   88: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   91: ifnull +14 -> 105
    //   94: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   97: astore_0
    //   98: invokestatic 209	com/tencent/qbar/QbarNative:a	()Ljava/lang/String;
    //   101: astore_0
    //   102: goto -19 -> 83
    //   105: ldc 185
    //   107: astore_0
    //   108: goto -25 -> 83
    //   111: astore_0
    //   112: ldc 2
    //   114: monitorexit
    //   115: aload_0
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   78	30	0	localObject1	Object
    //   111	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	69	111	finally
    //   69	83	111	finally
    //   88	102	111	finally
  }
  
  public static int b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "ReleaseForCamera.");
      }
      int i = a(0);
      return i;
    }
    finally {}
  }
  
  public static int b(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "InitForCamera.");
      }
      paramInt = a(paramInt, 0, paramString1, paramString2);
      return paramInt;
    }
    finally {}
  }
  
  public static int b(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "GetOneResultForCamera.");
      }
      int i = a(paramStringBuilder1, paramStringBuilder2, 0);
      return i;
    }
    finally {}
  }
  
  /* Error */
  public static int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 43
    //   11: iconst_2
    //   12: ldc 217
    //   14: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: getstatic 90	bdsg:jdField_a_of_type_Boolean	Z
    //   20: ifeq +184 -> 204
    //   23: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +74 -> 100
    //   29: ldc 43
    //   31: iconst_2
    //   32: new 53	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   39: ldc 219
    //   41: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: getstatic 19	bdsg:jdField_a_of_type_Int	I
    //   47: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc 67
    //   52: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   58: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: ldc 74
    //   63: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: getstatic 21	bdsg:jdField_b_of_type_Int	I
    //   69: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc 76
    //   74: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   80: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: ldc 221
    //   85: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: getstatic 102	bdsg:e	I
    //   91: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   103: ifnonnull +24 -> 127
    //   106: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   109: ifnull +109 -> 218
    //   112: getstatic 102	bdsg:e	I
    //   115: iconst_3
    //   116: if_icmpge +102 -> 218
    //   119: getstatic 102	bdsg:e	I
    //   122: iconst_1
    //   123: iadd
    //   124: putstatic 102	bdsg:e	I
    //   127: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +74 -> 204
    //   133: ldc 43
    //   135: iconst_2
    //   136: new 53	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   143: ldc 223
    //   145: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: getstatic 19	bdsg:jdField_a_of_type_Int	I
    //   151: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc 67
    //   156: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: getstatic 69	bdsg:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   162: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: ldc 74
    //   167: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: getstatic 21	bdsg:jdField_b_of_type_Int	I
    //   173: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc 76
    //   178: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: getstatic 78	bdsg:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   184: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: ldc 221
    //   189: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: getstatic 102	bdsg:e	I
    //   195: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_0
    //   205: iload_1
    //   206: iload_2
    //   207: iload_3
    //   208: iconst_0
    //   209: invokestatic 163	bdsg:a	([BIIII)I
    //   212: istore_1
    //   213: ldc 2
    //   215: monitorexit
    //   216: iload_1
    //   217: ireturn
    //   218: getstatic 96	bdsg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   221: ifnull -94 -> 127
    //   224: getstatic 96	bdsg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   227: ifnull -100 -> 127
    //   230: getstatic 98	bdsg:jdField_a_of_type_ArrayOfInt	[I
    //   233: ifnull -106 -> 127
    //   236: getstatic 92	bdsg:c	I
    //   239: getstatic 94	bdsg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   242: getstatic 96	bdsg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   245: invokestatic 225	bdsg:b	(ILjava/lang/String;Ljava/lang/String;)I
    //   248: pop
    //   249: getstatic 98	bdsg:jdField_a_of_type_ArrayOfInt	[I
    //   252: getstatic 100	bdsg:d	I
    //   255: invokestatic 227	bdsg:b	([II)I
    //   258: pop
    //   259: goto -132 -> 127
    //   262: astore_0
    //   263: ldc 2
    //   265: monitorexit
    //   266: aload_0
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	paramArrayOfByte	byte[]
    //   0	268	1	paramInt1	int
    //   0	268	2	paramInt2	int
    //   0	268	3	paramInt3	int
    // Exception table:
    //   from	to	target	type
    //   3	17	262	finally
    //   17	100	262	finally
    //   100	127	262	finally
    //   127	204	262	finally
    //   204	213	262	finally
    //   218	259	262	finally
  }
  
  public static int b(int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "SetReadersForCamera.");
      }
      paramInt = a(paramArrayOfInt, paramInt, 0);
      return paramInt;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsg
 * JD-Core Version:    0.7.0.1
 */