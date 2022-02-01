import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.contactsync.ReportUtil.1;
import com.tencent.qphone.base.util.QLog;

public class arqe
{
  /* Error */
  private static int a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 14	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6: invokevirtual 20	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   9: astore_0
    //   10: getstatic 26	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   13: astore 4
    //   15: iload_1
    //   16: invokestatic 32	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   19: astore 5
    //   21: aload_0
    //   22: aload 4
    //   24: iconst_1
    //   25: anewarray 34	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc 36
    //   32: aastore
    //   33: ldc 38
    //   35: iconst_1
    //   36: anewarray 34	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload 5
    //   43: aastore
    //   44: aconst_null
    //   45: invokevirtual 44	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore_0
    //   49: aload_0
    //   50: ifnull +26 -> 76
    //   53: aload_0
    //   54: invokeinterface 50 1 0
    //   59: istore_1
    //   60: iload_1
    //   61: istore_2
    //   62: aload_0
    //   63: ifnull +11 -> 74
    //   66: aload_0
    //   67: invokeinterface 54 1 0
    //   72: iload_1
    //   73: istore_2
    //   74: iload_2
    //   75: ireturn
    //   76: iconst_0
    //   77: istore_1
    //   78: goto -18 -> 60
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_0
    //   84: iconst_m1
    //   85: istore_2
    //   86: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +12 -> 101
    //   92: ldc 62
    //   94: iconst_2
    //   95: ldc 64
    //   97: aload_3
    //   98: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: aload_0
    //   102: ifnull -28 -> 74
    //   105: aload_0
    //   106: invokeinterface 54 1 0
    //   111: iconst_m1
    //   112: ireturn
    //   113: astore_0
    //   114: iconst_m1
    //   115: ireturn
    //   116: astore_0
    //   117: aload_3
    //   118: ifnull +9 -> 127
    //   121: aload_3
    //   122: invokeinterface 54 1 0
    //   127: aload_0
    //   128: athrow
    //   129: astore_0
    //   130: iload_1
    //   131: ireturn
    //   132: astore_3
    //   133: goto -6 -> 127
    //   136: astore 4
    //   138: aload_0
    //   139: astore_3
    //   140: aload 4
    //   142: astore_0
    //   143: goto -26 -> 117
    //   146: astore 4
    //   148: aload_0
    //   149: astore_3
    //   150: aload 4
    //   152: astore_0
    //   153: goto -36 -> 117
    //   156: astore_3
    //   157: goto -73 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramQQAppInterface	QQAppInterface
    //   0	160	1	paramInt	int
    //   61	25	2	i	int
    //   1	1	3	localObject1	Object
    //   81	41	3	localThrowable1	java.lang.Throwable
    //   132	1	3	localThrowable2	java.lang.Throwable
    //   139	11	3	localQQAppInterface	QQAppInterface
    //   156	1	3	localThrowable3	java.lang.Throwable
    //   13	10	4	localUri	android.net.Uri
    //   136	5	4	localObject2	Object
    //   146	5	4	localObject3	Object
    //   19	23	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   10	49	81	java/lang/Throwable
    //   105	111	113	java/lang/Throwable
    //   10	49	116	finally
    //   66	72	129	java/lang/Throwable
    //   121	127	132	java/lang/Throwable
    //   53	60	136	finally
    //   86	101	146	finally
    //   53	60	156	java/lang/Throwable
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int i;
    if (paramInt6 >= 3) {
      if (paramInt2 == 0) {
        i = 11;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return;
        if (paramInt3 == 0)
        {
          i = 12;
          continue;
        }
        i = 13;
        continue;
        if (paramInt4 >= 100)
        {
          if (paramInt2 == 0) {
            i = 21;
          }
          for (;;)
          {
            break;
            if (paramInt3 == 0) {
              i = 22;
            } else {
              i = 23;
            }
          }
        }
      }
      else
      {
        ThreadManager.post(new ReportUtil.1(paramInt1, i, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7), 5, null, false);
        return;
      }
      i = 0;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = true;
    if (paramQQAppInterface == null) {
      return false;
    }
    int i = a(paramQQAppInterface, paramInt);
    QLog.d("actContactSyncExReport", 1, new Object[] { "isDangerousDel contactId=", Integer.valueOf(paramInt), " rawContactCnt=", Integer.valueOf(i) });
    if (i <= 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqe
 * JD-Core Version:    0.7.0.1
 */