import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QbarPossibleInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class bcof
{
  private static int jdField_a_of_type_Int;
  public static QbarNative.QbarPossibleInfo a;
  public static QbarNative a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static boolean jdField_a_of_type_Boolean;
  public static byte[] a;
  public static int[] a;
  private static int b;
  public static QbarNative b;
  public static byte[] b;
  public static byte[] c;
  
  static
  {
    SoLoadUtil.a(BaseApplicationImpl.getContext(), "stlport_shared", 0, false);
    jdField_a_of_type_ArrayOfByte = new byte[100];
    jdField_b_of_type_ArrayOfByte = new byte[3000];
    c = new byte[100];
    jdField_a_of_type_ArrayOfInt = new int[3];
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_ComTencentQbarQbarNative$QbarPossibleInfo = new QbarNative.QbarPossibleInfo();
  }
  
  public static int a()
  {
    try
    {
      int i = a(1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private static int a(int paramInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +63 -> 71
    //   11: ldc 64
    //   13: iconst_2
    //   14: new 66	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   21: ldc 69
    //   23: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: getstatic 39	bcof:jdField_a_of_type_Int	I
    //   29: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc 78
    //   34: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   40: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc 85
    //   45: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: getstatic 41	bcof:jdField_b_of_type_Int	I
    //   51: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc 87
    //   56: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   62: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iload_0
    //   72: iconst_1
    //   73: if_icmpne +100 -> 173
    //   76: iload_1
    //   77: istore_0
    //   78: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   81: ifnull +21 -> 102
    //   84: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   87: getstatic 39	bcof:jdField_a_of_type_Int	I
    //   90: invokevirtual 102	com/tencent/qbar/QbarNative:Release	(I)I
    //   93: istore_0
    //   94: aconst_null
    //   95: putstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   98: iconst_m1
    //   99: putstatic 39	bcof:jdField_a_of_type_Int	I
    //   102: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +63 -> 168
    //   108: ldc 64
    //   110: iconst_2
    //   111: new 66	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   118: ldc 104
    //   120: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: getstatic 39	bcof:jdField_a_of_type_Int	I
    //   126: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc 78
    //   131: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   137: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: ldc 85
    //   142: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: getstatic 41	bcof:jdField_b_of_type_Int	I
    //   148: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: ldc 87
    //   153: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   159: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: ldc 2
    //   170: monitorexit
    //   171: iload_0
    //   172: ireturn
    //   173: iload_1
    //   174: istore_0
    //   175: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   178: ifnull -76 -> 102
    //   181: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   184: getstatic 41	bcof:jdField_b_of_type_Int	I
    //   187: invokevirtual 102	com/tencent/qbar/QbarNative:Release	(I)I
    //   190: istore_0
    //   191: aconst_null
    //   192: putstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   195: iconst_m1
    //   196: putstatic 41	bcof:jdField_b_of_type_Int	I
    //   199: goto -97 -> 102
    //   202: astore_2
    //   203: ldc 2
    //   205: monitorexit
    //   206: aload_2
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramInt	int
    //   1	173	1	i	int
    //   202	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	71	202	finally
    //   78	102	202	finally
    //   102	168	202	finally
    //   175	199	202	finally
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q..qbar", 2, String.format("Init speedMode=%s searchMode=%s scanMode=%s inputCharset=%s outputCharset=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString1, paramString2 }));
        }
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          if (!jdField_a_of_type_Boolean)
          {
            jdField_a_of_type_Boolean = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "QrMod");
            if (!jdField_a_of_type_Boolean) {
              QLog.e("Q..qbar", 1, "Init load QrMod fail, try system load.");
            }
          }
          try
          {
            System.loadLibrary("QrMod");
            jdField_a_of_type_Boolean = true;
            akpc.a().a(jdField_a_of_type_Boolean);
            if (paramInt3 == 1)
            {
              if ((jdField_a_of_type_ComTencentQbarQbarNative == null) || (jdField_a_of_type_Int < 0))
              {
                jdField_a_of_type_ComTencentQbarQbarNative = new QbarNative();
                jdField_a_of_type_Int = jdField_a_of_type_ComTencentQbarQbarNative.Init(paramInt1, paramInt2, 1, paramString1, paramString2);
              }
              paramInt1 = jdField_a_of_type_Int;
              if (QLog.isColorLevel()) {
                QLog.d("Q..qbar", 2, String.format("Init result=%s ", new Object[] { Integer.valueOf(paramInt1) }));
              }
              return paramInt1;
            }
          }
          catch (Exception localException)
          {
            QLog.e("Q..qbar", 1, "Init system load QrMod fail!", localException);
            jdField_a_of_type_Boolean = false;
            continue;
          }
        }
        if (jdField_b_of_type_ComTencentQbarQbarNative == null) {
          break label236;
        }
      }
      finally {}
      if (jdField_b_of_type_Int < 0)
      {
        label236:
        jdField_b_of_type_ComTencentQbarQbarNative = new QbarNative();
        jdField_b_of_type_Int = jdField_b_of_type_ComTencentQbarQbarNative.Init(paramInt1, paramInt2, 0, paramString1, paramString2);
      }
      paramInt1 = jdField_b_of_type_Int;
    }
  }
  
  public static int a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      paramInt1 = a(paramInt1, paramInt2, 1, paramString1, paramString2);
      return paramInt1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    try
    {
      int i = a(paramStringBuilder1, paramStringBuilder2, 1);
      return i;
    }
    finally
    {
      paramStringBuilder1 = finally;
      throw paramStringBuilder1;
    }
  }
  
  private static int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q..qbar", 2, "GetOneResult. sInitResult=" + jdField_a_of_type_Int + " sQbarNative=" + jdField_a_of_type_ComTencentQbarQbarNative + " sInitResultForCamera=" + jdField_b_of_type_Int + " sQbarNativeForCamera=" + jdField_b_of_type_ComTencentQbarQbarNative + " scanMode=" + paramInt);
        }
        if (paramInt != 1) {
          continue;
        }
        if (jdField_a_of_type_ComTencentQbarQbarNative != null) {
          continue;
        }
        paramInt = jdField_a_of_type_Int;
      }
      finally
      {
        try
        {
          i = jdField_a_of_type_ComTencentQbarQbarNative.GetOneResult(jdField_a_of_type_ArrayOfByte, jdField_b_of_type_ArrayOfByte, c, jdField_a_of_type_ArrayOfInt, jdField_a_of_type_Int);
          try
          {
            str = new String(c, 0, jdField_a_of_type_ArrayOfInt[2], "UTF-8");
            if (!str.equals("ANY")) {
              break label455;
            }
            paramStringBuilder1.append(new String(jdField_a_of_type_ArrayOfByte, 0, jdField_a_of_type_ArrayOfInt[0], "UTF-8"));
            paramStringBuilder2.append(new String(jdField_b_of_type_ArrayOfByte, 0, jdField_a_of_type_ArrayOfInt[1], "UTF-8"));
            if (paramStringBuilder2.length() == 0)
            {
              paramStringBuilder1.append(new String(jdField_a_of_type_ArrayOfByte, 0, jdField_a_of_type_ArrayOfInt[0], "ASCII"));
              paramStringBuilder2.append(new String(jdField_b_of_type_ArrayOfByte, 0, jdField_a_of_type_ArrayOfInt[1], "ASCII"));
            }
            paramInt = i;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q..qbar", 2, "GetOneResult. type:" + paramStringBuilder1 + " data:" + paramStringBuilder2 + " charset:" + str);
            paramInt = i;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            paramInt = i;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q..qbar", 2, "GetOneResult. type:" + paramStringBuilder1 + " data:" + paramStringBuilder2, localUnsupportedEncodingException);
          paramInt = i;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          if (!QLog.isColorLevel()) {
            break label450;
          }
          QLog.d("Q..qbar", 2, "GetOneResult. type:" + paramStringBuilder1 + " data:" + paramStringBuilder2, localUnsatisfiedLinkError);
          paramInt = 0;
        }
        paramStringBuilder1 = finally;
      }
      return paramInt;
      if (jdField_b_of_type_ComTencentQbarQbarNative == null) {
        paramInt = jdField_b_of_type_Int;
      } else if (paramInt != 1) {}
    }
    for (;;)
    {
      String str;
      int i = jdField_b_of_type_ComTencentQbarQbarNative.GetOneResult(jdField_a_of_type_ArrayOfByte, jdField_b_of_type_ArrayOfByte, c, jdField_a_of_type_ArrayOfInt, jdField_b_of_type_Int);
      continue;
      label450:
      break;
      label455:
      paramStringBuilder1.append(new String(jdField_a_of_type_ArrayOfByte, 0, jdField_a_of_type_ArrayOfInt[0], localUnsatisfiedLinkError));
      paramStringBuilder2.append(new String(jdField_b_of_type_ArrayOfByte, 0, jdField_a_of_type_ArrayOfInt[1], localUnsatisfiedLinkError));
    }
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramInt1 = a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, 1);
      return paramInt1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  /* Error */
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +73 -> 79
    //   9: ldc 64
    //   11: iconst_2
    //   12: new 66	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   19: ldc 210
    //   21: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 39	bcof:jdField_a_of_type_Int	I
    //   27: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 78
    //   32: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   38: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc 85
    //   43: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 41	bcof:jdField_b_of_type_Int	I
    //   49: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 87
    //   54: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   60: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: ldc 176
    //   65: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload 4
    //   70: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: iload 4
    //   81: iconst_1
    //   82: if_icmpne +35 -> 117
    //   85: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   88: ifnonnull +12 -> 100
    //   91: getstatic 39	bcof:jdField_a_of_type_Int	I
    //   94: istore_1
    //   95: ldc 2
    //   97: monitorexit
    //   98: iload_1
    //   99: ireturn
    //   100: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   103: aload_0
    //   104: iload_1
    //   105: iload_2
    //   106: iload_3
    //   107: getstatic 39	bcof:jdField_a_of_type_Int	I
    //   110: invokevirtual 213	com/tencent/qbar/QbarNative:ScanImage	([BIIII)I
    //   113: istore_1
    //   114: goto -19 -> 95
    //   117: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   120: ifnonnull +10 -> 130
    //   123: getstatic 41	bcof:jdField_b_of_type_Int	I
    //   126: istore_1
    //   127: goto -32 -> 95
    //   130: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   133: aload_0
    //   134: iload_1
    //   135: iload_2
    //   136: iload_3
    //   137: getstatic 41	bcof:jdField_b_of_type_Int	I
    //   140: invokevirtual 213	com/tencent/qbar/QbarNative:ScanImage	([BIIII)I
    //   143: istore_1
    //   144: goto -49 -> 95
    //   147: astore_0
    //   148: ldc 2
    //   150: monitorexit
    //   151: aload_0
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramArrayOfByte	byte[]
    //   0	153	1	paramInt1	int
    //   0	153	2	paramInt2	int
    //   0	153	3	paramInt3	int
    //   0	153	4	paramInt4	int
    // Exception table:
    //   from	to	target	type
    //   3	79	147	finally
    //   85	95	147	finally
    //   100	114	147	finally
    //   117	127	147	finally
    //   130	144	147	finally
  }
  
  public static int a(int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      paramInt = a(paramArrayOfInt, paramInt, 1);
      return paramInt;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  /* Error */
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +72 -> 78
    //   9: ldc 64
    //   11: iconst_2
    //   12: new 66	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   19: ldc 219
    //   21: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 39	bcof:jdField_a_of_type_Int	I
    //   27: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 78
    //   32: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   38: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc 85
    //   43: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 41	bcof:jdField_b_of_type_Int	I
    //   49: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 87
    //   54: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   60: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: ldc 176
    //   65: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_2
    //   69: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iload_2
    //   79: iconst_1
    //   80: if_icmpne +33 -> 113
    //   83: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   86: ifnonnull +12 -> 98
    //   89: getstatic 39	bcof:jdField_a_of_type_Int	I
    //   92: istore_1
    //   93: ldc 2
    //   95: monitorexit
    //   96: iload_1
    //   97: ireturn
    //   98: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   101: aload_0
    //   102: iload_1
    //   103: getstatic 39	bcof:jdField_a_of_type_Int	I
    //   106: invokevirtual 222	com/tencent/qbar/QbarNative:SetReaders	([III)I
    //   109: istore_1
    //   110: goto -17 -> 93
    //   113: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   116: ifnonnull +10 -> 126
    //   119: getstatic 41	bcof:jdField_b_of_type_Int	I
    //   122: istore_1
    //   123: goto -30 -> 93
    //   126: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   129: aload_0
    //   130: iload_1
    //   131: getstatic 41	bcof:jdField_b_of_type_Int	I
    //   134: invokevirtual 222	com/tencent/qbar/QbarNative:SetReaders	([III)I
    //   137: istore_1
    //   138: goto -45 -> 93
    //   141: astore_0
    //   142: ldc 2
    //   144: monitorexit
    //   145: aload_0
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramArrayOfInt	int[]
    //   0	147	1	paramInt1	int
    //   0	147	2	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   3	78	141	finally
    //   83	93	141	finally
    //   98	110	141	finally
    //   113	123	141	finally
    //   126	138	141	finally
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +63 -> 69
    //   9: ldc 64
    //   11: iconst_2
    //   12: new 66	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   19: ldc 224
    //   21: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 39	bcof:jdField_a_of_type_Int	I
    //   27: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 78
    //   32: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   38: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc 85
    //   43: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 41	bcof:jdField_b_of_type_Int	I
    //   49: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 87
    //   54: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   60: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   72: ifnull +16 -> 88
    //   75: getstatic 80	bcof:jdField_a_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   78: astore_0
    //   79: invokestatic 227	com/tencent/qbar/QbarNative:GetVersion	()Ljava/lang/String;
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_0
    //   87: areturn
    //   88: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   91: ifnull +14 -> 105
    //   94: getstatic 89	bcof:jdField_b_of_type_ComTencentQbarQbarNative	Lcom/tencent/qbar/QbarNative;
    //   97: astore_0
    //   98: invokestatic 227	com/tencent/qbar/QbarNative:GetVersion	()Ljava/lang/String;
    //   101: astore_0
    //   102: goto -19 -> 83
    //   105: ldc 229
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
      int i = a(0);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      paramInt1 = a(paramInt1, paramInt2, 0, paramString1, paramString2);
      return paramInt1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static int b(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    try
    {
      int i = a(paramStringBuilder1, paramStringBuilder2, 0);
      return i;
    }
    finally
    {
      paramStringBuilder1 = finally;
      throw paramStringBuilder1;
    }
  }
  
  public static int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramInt1 = a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, 0);
      return paramInt1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public static int b(int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      paramInt = a(paramArrayOfInt, paramInt, 0);
      return paramInt;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  public static int c()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        QbarNative localQbarNative = jdField_b_of_type_ComTencentQbarQbarNative;
        if (localQbarNative != null) {
          continue;
        }
      }
      finally
      {
        try
        {
          int j = jdField_b_of_type_ComTencentQbarQbarNative.GetPossibleInfo(jdField_a_of_type_ComTencentQbarQbarNative$QbarPossibleInfo, jdField_b_of_type_Int);
          i = j;
        }
        catch (Throwable localThrowable) {}
        localObject = finally;
      }
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcof
 * JD-Core Version:    0.7.0.1
 */