import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.ResponseHandler.1;

public class bkjc
{
  private static volatile int jdField_a_of_type_Int;
  private static bkjd jdField_a_of_type_Bkjd = new bkjd(Looper.getMainLooper());
  private static volatile String jdField_a_of_type_JavaLangString;
  private static volatile int jdField_b_of_type_Int;
  private static volatile String jdField_b_of_type_JavaLangString;
  private static volatile int c;
  
  /* Error */
  public static String a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 39	bkjc:jdField_b_of_type_Int	I
    //   6: sipush 1127
    //   9: if_icmpne +15 -> 24
    //   12: aload_0
    //   13: ldc 40
    //   15: invokevirtual 46	android/content/Context:getString	(I)Ljava/lang/String;
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: getstatic 39	bkjc:jdField_b_of_type_Int	I
    //   27: sipush 22000
    //   30: if_icmpne +13 -> 43
    //   33: aload_0
    //   34: ldc 40
    //   36: invokevirtual 46	android/content/Context:getString	(I)Ljava/lang/String;
    //   39: astore_0
    //   40: goto -21 -> 19
    //   43: getstatic 39	bkjc:jdField_b_of_type_Int	I
    //   46: sipush 1053
    //   49: if_icmpeq +12 -> 61
    //   52: getstatic 39	bkjc:jdField_b_of_type_Int	I
    //   55: sipush -20001
    //   58: if_icmpne +13 -> 71
    //   61: aload_0
    //   62: ldc 47
    //   64: invokevirtual 46	android/content/Context:getString	(I)Ljava/lang/String;
    //   67: astore_0
    //   68: goto -49 -> 19
    //   71: getstatic 39	bkjc:jdField_b_of_type_Int	I
    //   74: sipush 22081
    //   77: if_icmpne +13 -> 90
    //   80: aload_0
    //   81: ldc 48
    //   83: invokevirtual 46	android/content/Context:getString	(I)Ljava/lang/String;
    //   86: astore_0
    //   87: goto -68 -> 19
    //   90: getstatic 39	bkjc:jdField_b_of_type_Int	I
    //   93: sipush 22121
    //   96: if_icmpne +13 -> 109
    //   99: aload_0
    //   100: ldc 49
    //   102: invokevirtual 46	android/content/Context:getString	(I)Ljava/lang/String;
    //   105: astore_0
    //   106: goto -87 -> 19
    //   109: aconst_null
    //   110: astore_0
    //   111: goto -92 -> 19
    //   114: astore_0
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   3	19	114	finally
    //   24	40	114	finally
    //   43	61	114	finally
    //   61	68	114	finally
    //   71	87	114	finally
    //   90	106	114	finally
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_Int += 1;
      QLog.d("ResponseHandler", 2, "start count=" + jdField_a_of_type_Int);
      jdField_a_of_type_Bkjd.removeMessages(0);
      jdField_a_of_type_Bkjd.sendEmptyMessageDelayed(0, 60000L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      QLog.d("ResponseHandler", 2, "sFriendUin =" + jdField_a_of_type_JavaLangString + ";  sSenderUin=" + jdField_b_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString))) {
        b(paramQQAppInterface);
      }
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    String str2;
    String str1;
    if (!TextUtils.isEmpty(paramString3))
    {
      str2 = "";
      str1 = "";
      if (paramInt2 != 1127) {
        break label55;
      }
      str2 = paramQQAppInterface.getApp().getString(2131693824);
      str1 = bkjs.b(paramQQAppInterface.getCurrentAccountUin(), "mvip.n.a.zcwy_xht");
      if (!TextUtils.isEmpty(str2)) {
        break label181;
      }
    }
    label55:
    do
    {
      return;
      if (paramInt2 == 22000)
      {
        str2 = paramQQAppInterface.getApp().getString(2131693824);
        str1 = bkjs.b(paramQQAppInterface.getCurrentAccountUin(), "mvip.n.a.zcwy_xht");
        break;
      }
      if (paramInt2 == 1053)
      {
        str2 = paramQQAppInterface.getApp().getString(2131693827);
        str1 = bkjs.a(paramQQAppInterface.getCurrentAccountUin(), "qq_aio_capacity_open_vip");
        break;
      }
      if (paramInt2 == 22081)
      {
        str2 = paramQQAppInterface.getApp().getString(2131693826);
        str1 = bkjs.a(paramQQAppInterface.getCurrentAccountUin(), "qq_aio_capacity_open_vip");
        break;
      }
      if (paramInt2 != 22121) {
        break;
      }
      str2 = paramQQAppInterface.getApp().getString(2131693825);
      str1 = bkjs.c();
      break;
      paramInt2 = paramString3.indexOf(str2);
    } while (paramInt2 == -1);
    label181:
    new Thread(new ResponseHandler.1(paramString1, paramString2, paramString3, paramInt1, str1, paramInt2, str2, paramQQAppInterface)).start();
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      jdField_a_of_type_JavaLangString = paramString1;
      jdField_b_of_type_JavaLangString = paramString2;
      c = paramInt;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 33	bkjc:jdField_a_of_type_Int	I
    //   6: istore_0
    //   7: iload_0
    //   8: ifne +10 -> 18
    //   11: iconst_1
    //   12: istore_1
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_1
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_1
    //   20: goto -7 -> 13
    //   23: astore_2
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_2
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	i	int
    //   12	8	1	bool	boolean
    //   23	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((d(paramInt)) && (!b(jdField_b_of_type_Int))) {
          jdField_b_of_type_Int = paramInt;
        }
        if (jdField_a_of_type_Int == 0)
        {
          jdField_a_of_type_Bkjd.removeMessages(0);
          return bool;
        }
        jdField_a_of_type_Int -= 1;
        QLog.d("ResponseHandler", 2, "end count=" + jdField_a_of_type_Int);
        if (jdField_a_of_type_Int <= 0)
        {
          jdField_a_of_type_Bkjd.removeMessages(0);
          jdField_a_of_type_Int = 0;
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  static void b()
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_JavaLangString = null;
    c = 0;
    jdField_b_of_type_Int = 0;
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    Message localMessage = jdField_a_of_type_Bkjd.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramQQAppInterface;
    jdField_a_of_type_Bkjd.sendMessageDelayed(localMessage, 1000L);
  }
  
  public static boolean b()
  {
    return d(jdField_b_of_type_Int);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 1053) || (paramInt == 22081) || (paramInt == 22121) || (jdField_b_of_type_Int == -20001);
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 1127) || (paramInt == 22000);
  }
  
  public static boolean d(int paramInt)
  {
    return (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) && ((c(paramInt)) || (b(paramInt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjc
 * JD-Core Version:    0.7.0.1
 */