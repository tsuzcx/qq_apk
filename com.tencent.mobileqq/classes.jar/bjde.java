import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QbarAiModelParam;
import com.tencent.qphone.base.util.QLog;

public class bjde
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
    //   26: getstatic 19	bjde:jdField_a_of_type_Int	I
    //   29: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc 67
    //   34: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   40: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc 74
    //   45: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: getstatic 21	bjde:jdField_b_of_type_Int	I
    //   51: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc 76
    //   56: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   62: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iload_0
    //   72: iconst_1
    //   73: if_icmpne +97 -> 170
    //   76: iload_1
    //   77: istore_0
    //   78: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   81: ifnull +18 -> 99
    //   84: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   87: invokevirtual 86	com/tencent/qbar/QbarNative:a	()I
    //   90: istore_0
    //   91: aconst_null
    //   92: putstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   95: iconst_m1
    //   96: putstatic 19	bjde:jdField_a_of_type_Int	I
    //   99: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +63 -> 165
    //   105: ldc 43
    //   107: iconst_2
    //   108: new 53	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   115: ldc 88
    //   117: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: getstatic 19	bjde:jdField_a_of_type_Int	I
    //   123: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc 67
    //   128: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   134: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: ldc 74
    //   139: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: getstatic 21	bjde:jdField_b_of_type_Int	I
    //   145: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: ldc 76
    //   150: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   156: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: ldc 2
    //   167: monitorexit
    //   168: iload_0
    //   169: ireturn
    //   170: iload_1
    //   171: istore_0
    //   172: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   175: ifnull -76 -> 99
    //   178: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   181: invokevirtual 86	com/tencent/qbar/QbarNative:a	()I
    //   184: istore_1
    //   185: aconst_null
    //   186: putstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   189: iconst_m1
    //   190: putstatic 21	bjde:jdField_b_of_type_Int	I
    //   193: iload_1
    //   194: istore_0
    //   195: getstatic 90	bjde:jdField_a_of_type_Boolean	Z
    //   198: ifne -99 -> 99
    //   201: iconst_m1
    //   202: putstatic 92	bjde:c	I
    //   205: aconst_null
    //   206: putstatic 94	bjde:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   209: aconst_null
    //   210: putstatic 96	bjde:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   213: aconst_null
    //   214: putstatic 98	bjde:jdField_a_of_type_ArrayOfInt	[I
    //   217: iconst_m1
    //   218: putstatic 100	bjde:d	I
    //   221: iconst_0
    //   222: putstatic 102	bjde:e	I
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
        boolean bool = RecogUtil.isX86VM();
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
    //   19: ldc 146
    //   21: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 19	bjde:jdField_a_of_type_Int	I
    //   27: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 67
    //   32: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   38: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc 74
    //   43: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 21	bjde:jdField_b_of_type_Int	I
    //   49: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 76
    //   54: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   60: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: ldc 148
    //   65: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_2
    //   69: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iload_2
    //   79: iconst_1
    //   80: if_icmpne +18 -> 98
    //   83: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   86: ifnonnull +25 -> 111
    //   89: getstatic 19	bjde:jdField_a_of_type_Int	I
    //   92: istore_2
    //   93: ldc 2
    //   95: monitorexit
    //   96: iload_2
    //   97: ireturn
    //   98: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   101: ifnonnull +10 -> 111
    //   104: getstatic 21	bjde:jdField_b_of_type_Int	I
    //   107: istore_2
    //   108: goto -15 -> 93
    //   111: iload_2
    //   112: iconst_1
    //   113: if_icmpne +15 -> 128
    //   116: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   119: aload_0
    //   120: aload_1
    //   121: invokevirtual 150	com/tencent/qbar/QbarNative:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   124: istore_2
    //   125: goto -32 -> 93
    //   128: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 150	com/tencent/qbar/QbarNative:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   136: istore_2
    //   137: goto -44 -> 93
    //   140: astore_3
    //   141: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +38 -> 182
    //   147: ldc 43
    //   149: iconst_2
    //   150: new 53	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   157: ldc 152
    //   159: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   166: ldc 154
    //   168: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: aload_3
    //   179: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   182: iconst_0
    //   183: istore_2
    //   184: goto -91 -> 93
    //   187: astore_0
    //   188: ldc 2
    //   190: monitorexit
    //   191: aload_0
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramStringBuilder1	StringBuilder
    //   0	193	1	paramStringBuilder2	StringBuilder
    //   0	193	2	paramInt	int
    //   140	39	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   116	125	140	java/lang/UnsatisfiedLinkError
    //   128	137	140	java/lang/UnsatisfiedLinkError
    //   3	78	187	finally
    //   83	93	187	finally
    //   98	108	187	finally
    //   116	125	187	finally
    //   128	137	187	finally
    //   141	182	187	finally
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QbarNativeImpl", 2, "ScanImageForFile.");
      }
      paramInt1 = c(paramArrayOfByte, paramInt1, paramInt2, 1);
      return paramInt1;
    }
    finally {}
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
    //   19: ldc 170
    //   21: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 19	bjde:jdField_a_of_type_Int	I
    //   27: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 67
    //   32: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   38: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc 74
    //   43: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 21	bjde:jdField_b_of_type_Int	I
    //   49: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 76
    //   54: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   60: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: ldc 148
    //   65: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_2
    //   69: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iload_2
    //   79: iconst_1
    //   80: if_icmpne +30 -> 110
    //   83: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   86: ifnonnull +12 -> 98
    //   89: getstatic 19	bjde:jdField_a_of_type_Int	I
    //   92: istore_1
    //   93: ldc 2
    //   95: monitorexit
    //   96: iload_1
    //   97: ireturn
    //   98: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   101: aload_0
    //   102: iload_1
    //   103: invokevirtual 172	com/tencent/qbar/QbarNative:a	([II)I
    //   106: istore_1
    //   107: goto -14 -> 93
    //   110: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   113: ifnonnull +10 -> 123
    //   116: getstatic 21	bjde:jdField_b_of_type_Int	I
    //   119: istore_1
    //   120: goto -27 -> 93
    //   123: aload_0
    //   124: putstatic 98	bjde:jdField_a_of_type_ArrayOfInt	[I
    //   127: iload_1
    //   128: putstatic 100	bjde:d	I
    //   131: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   134: aload_0
    //   135: iload_1
    //   136: invokevirtual 172	com/tencent/qbar/QbarNative:a	([II)I
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
  
  private static QbarNative.QbarAiModelParam a(int paramInt)
  {
    QbarNative.QbarAiModelParam localQbarAiModelParam = new QbarNative.QbarAiModelParam();
    localQbarAiModelParam.detect_model_bin_path_ = "";
    localQbarAiModelParam.detect_model_param_path_ = "";
    localQbarAiModelParam.superresolution_model_bin_path_ = "";
    localQbarAiModelParam.superresolution_model_param_path_ = "";
    boolean bool = false;
    if (axad.a("https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", jdField_a_of_type_ArrayOfJavaLangString))
    {
      String str = axad.a("https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e");
      localQbarAiModelParam.detect_model_bin_path_ = (str + "/detect_model.bin");
      localQbarAiModelParam.detect_model_param_path_ = (str + "/detect_model.param");
      localQbarAiModelParam.superresolution_model_bin_path_ = (str + "/srnet.bin");
      localQbarAiModelParam.superresolution_model_param_path_ = (str + "/srnet.param");
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QbarNativeImpl", 2, "getQbarAiModelParam has AI model : " + bool);
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
    //   19: ldc 219
    //   21: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 19	bjde:jdField_a_of_type_Int	I
    //   27: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 67
    //   32: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   38: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc 74
    //   43: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 21	bjde:jdField_b_of_type_Int	I
    //   49: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 76
    //   54: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   60: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   72: ifnull +16 -> 88
    //   75: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   78: astore_0
    //   79: invokestatic 221	com/tencent/qbar/QbarNative:a	()Ljava/lang/String;
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_0
    //   87: areturn
    //   88: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   91: ifnull +14 -> 105
    //   94: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   97: astore_0
    //   98: invokestatic 221	com/tencent/qbar/QbarNative:a	()Ljava/lang/String;
    //   101: astore_0
    //   102: goto -19 -> 83
    //   105: ldc 177
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
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt1 >= 20) && (paramInt2 >= 20))
    {
      bool1 = bool2;
      if (paramInt1 < 32)
      {
        bool1 = bool2;
        if (paramInt2 >= 32) {}
      }
    }
    else
    {
      QLog.i("QbarNativeImpl", 1, "isValidScanImageSize false, in limit size. width=" + paramInt1 + " height=" + paramInt2);
      bool1 = false;
    }
    return bool1;
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
    //   12: ldc 234
    //   14: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: getstatic 90	bjde:jdField_a_of_type_Boolean	Z
    //   20: ifeq +184 -> 204
    //   23: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +74 -> 100
    //   29: ldc 43
    //   31: iconst_2
    //   32: new 53	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   39: ldc 236
    //   41: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: getstatic 19	bjde:jdField_a_of_type_Int	I
    //   47: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc 67
    //   52: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   58: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: ldc 74
    //   63: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: getstatic 21	bjde:jdField_b_of_type_Int	I
    //   69: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc 76
    //   74: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   80: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: ldc 238
    //   85: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: getstatic 102	bjde:e	I
    //   91: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   103: ifnonnull +24 -> 127
    //   106: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   109: ifnull +108 -> 217
    //   112: getstatic 102	bjde:e	I
    //   115: iconst_3
    //   116: if_icmpge +101 -> 217
    //   119: getstatic 102	bjde:e	I
    //   122: iconst_1
    //   123: iadd
    //   124: putstatic 102	bjde:e	I
    //   127: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +74 -> 204
    //   133: ldc 43
    //   135: iconst_2
    //   136: new 53	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   143: ldc 240
    //   145: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: getstatic 19	bjde:jdField_a_of_type_Int	I
    //   151: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc 67
    //   156: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: getstatic 69	bjde:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   162: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: ldc 74
    //   167: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: getstatic 21	bjde:jdField_b_of_type_Int	I
    //   173: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc 76
    //   178: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: getstatic 78	bjde:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   184: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: ldc 238
    //   189: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: getstatic 102	bjde:e	I
    //   195: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_0
    //   205: iload_1
    //   206: iload_2
    //   207: iconst_0
    //   208: invokestatic 162	bjde:c	([BIII)I
    //   211: istore_1
    //   212: ldc 2
    //   214: monitorexit
    //   215: iload_1
    //   216: ireturn
    //   217: getstatic 96	bjde:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   220: ifnull -93 -> 127
    //   223: getstatic 96	bjde:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   226: ifnull -99 -> 127
    //   229: getstatic 98	bjde:jdField_a_of_type_ArrayOfInt	[I
    //   232: ifnull -105 -> 127
    //   235: getstatic 92	bjde:c	I
    //   238: getstatic 94	bjde:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   241: getstatic 96	bjde:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   244: invokestatic 242	bjde:b	(ILjava/lang/String;Ljava/lang/String;)I
    //   247: pop
    //   248: getstatic 98	bjde:jdField_a_of_type_ArrayOfInt	[I
    //   251: getstatic 100	bjde:d	I
    //   254: invokestatic 244	bjde:b	([II)I
    //   257: pop
    //   258: goto -131 -> 127
    //   261: astore_0
    //   262: ldc 2
    //   264: monitorexit
    //   265: aload_0
    //   266: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramArrayOfByte	byte[]
    //   0	267	1	paramInt1	int
    //   0	267	2	paramInt2	int
    //   0	267	3	paramInt3	int
    // Exception table:
    //   from	to	target	type
    //   3	17	261	finally
    //   17	100	261	finally
    //   100	127	261	finally
    //   127	204	261	finally
    //   204	212	261	finally
    //   217	258	261	finally
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
  
  private static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = -1;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QbarNativeImpl", 2, "ScanImage. sInitResult=" + jdField_a_of_type_Int + " sQbarNative=" + jdField_a_of_type_ComTencentQbarQbarNative + " sInitResultForCamera=" + jdField_b_of_type_Int + " sQbarNativeForCamera=" + jdField_b_of_type_ComTencentQbarQbarNative + " scanMode=" + paramInt3);
        }
        if (!a(paramInt1, paramInt2))
        {
          QLog.i("QbarNativeImpl", 1, "ScanImage in limit size, return. width=" + paramInt1 + " height=" + paramInt2);
          paramInt1 = i;
          return paramInt1;
        }
        if (paramInt3 == 1)
        {
          if (jdField_a_of_type_ComTencentQbarQbarNative == null)
          {
            paramInt1 = jdField_a_of_type_Int;
            continue;
          }
          paramInt2 = jdField_a_of_type_ComTencentQbarQbarNative.a(paramArrayOfByte, paramInt1, paramInt2);
        }
        else
        {
          if (jdField_b_of_type_ComTencentQbarQbarNative == null)
          {
            paramInt1 = jdField_b_of_type_Int;
            continue;
          }
          paramInt2 = jdField_b_of_type_ComTencentQbarQbarNative.a(paramArrayOfByte, paramInt1, paramInt2);
        }
      }
      finally {}
      paramInt1 = i;
      if (paramInt2 >= 0) {
        paramInt1 = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjde
 * JD-Core Version:    0.7.0.1
 */