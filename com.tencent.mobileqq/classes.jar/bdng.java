import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;

public class bdng
{
  private static int jdField_a_of_type_Int;
  static String jdField_a_of_type_JavaLangString = null;
  private static String b = "QQUtils";
  
  /* Error */
  public static String a(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 27	bdng:a	(Landroid/content/Context;)Z
    //   6: ifne +7 -> 13
    //   9: aconst_null
    //   10: astore_1
    //   11: aload_1
    //   12: areturn
    //   13: getstatic 16	bdng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: astore 4
    //   18: aload_0
    //   19: invokevirtual 33	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   22: astore 5
    //   24: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +78 -> 105
    //   30: ldc 41
    //   32: astore_3
    //   33: aload_3
    //   34: astore_0
    //   35: aload_1
    //   36: ifnull +33 -> 69
    //   39: aload_3
    //   40: astore_0
    //   41: aload_1
    //   42: arraylength
    //   43: iconst_1
    //   44: if_icmplt +25 -> 69
    //   47: new 43	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   54: ldc 41
    //   56: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: iconst_0
    //   61: aaload
    //   62: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore_0
    //   69: getstatic 14	bdng:b	Ljava/lang/String;
    //   72: iconst_2
    //   73: new 43	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   80: ldc 55
    //   82: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload 4
    //   87: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 57
    //   92: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload 5
    //   107: aload 4
    //   109: invokestatic 67	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   112: aconst_null
    //   113: ldc 69
    //   115: aload_1
    //   116: aconst_null
    //   117: invokevirtual 75	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   120: astore_0
    //   121: aload_0
    //   122: ifnull +43 -> 165
    //   125: aload_0
    //   126: astore_1
    //   127: aload_0
    //   128: invokeinterface 80 1 0
    //   133: pop
    //   134: aload_0
    //   135: astore_1
    //   136: aload_0
    //   137: aload_0
    //   138: ldc 82
    //   140: invokeinterface 86 2 0
    //   145: invokeinterface 90 2 0
    //   150: astore_2
    //   151: aload_2
    //   152: astore_1
    //   153: aload_0
    //   154: ifnull -143 -> 11
    //   157: aload_0
    //   158: invokeinterface 93 1 0
    //   163: aload_2
    //   164: areturn
    //   165: aload_0
    //   166: ifnull +9 -> 175
    //   169: aload_0
    //   170: invokeinterface 93 1 0
    //   175: aconst_null
    //   176: areturn
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_0
    //   180: aload_0
    //   181: astore_1
    //   182: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +34 -> 219
    //   188: aload_0
    //   189: astore_1
    //   190: getstatic 14	bdng:b	Ljava/lang/String;
    //   193: iconst_2
    //   194: new 43	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   201: ldc 95
    //   203: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_2
    //   207: invokevirtual 96	java/lang/Exception:toString	()Ljava/lang/String;
    //   210: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_0
    //   220: ifnull -45 -> 175
    //   223: aload_0
    //   224: invokeinterface 93 1 0
    //   229: goto -54 -> 175
    //   232: astore_0
    //   233: aload_2
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull +9 -> 245
    //   239: aload_1
    //   240: invokeinterface 93 1 0
    //   245: aload_0
    //   246: athrow
    //   247: astore_0
    //   248: goto -13 -> 235
    //   251: astore_2
    //   252: goto -72 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramContext	Context
    //   0	255	1	paramArrayOfString	String[]
    //   1	163	2	str1	String
    //   177	57	2	localException1	java.lang.Exception
    //   251	1	2	localException2	java.lang.Exception
    //   32	8	3	str2	String
    //   16	92	4	str3	String
    //   22	84	5	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   24	30	177	java/lang/Exception
    //   41	69	177	java/lang/Exception
    //   69	105	177	java/lang/Exception
    //   105	121	177	java/lang/Exception
    //   24	30	232	finally
    //   41	69	232	finally
    //   69	105	232	finally
    //   105	121	232	finally
    //   127	134	247	finally
    //   136	151	247	finally
    //   182	188	247	finally
    //   190	219	247	finally
    //   127	134	251	java/lang/Exception
    //   136	151	251	java/lang/Exception
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.setClassName(paramActivity, paramString);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.addFlags(268435456);
      localIntent.addFlags(2097152);
      paramString = new Intent();
      paramString.putExtra("android.intent.extra.shortcut.INTENT", localIntent);
      paramString.putExtra("android.intent.extra.shortcut.NAME", paramActivity.getResources().getString(2131690192));
      paramString.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramActivity.getApplicationContext(), 2130840158));
      paramString.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
      paramActivity.sendOrderedBroadcast(paramString, null);
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.d("mqq", 1, "remvoShortcut Exception: ", paramActivity);
    }
  }
  
  static boolean a(Context paramContext)
  {
    if (jdField_a_of_type_JavaLangString == null) {
      jdField_a_of_type_JavaLangString = bdmg.a(paramContext);
    }
    if ("empty".equals(jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "cannot find authority");
      }
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 27	bdng:a	(Landroid/content/Context;)Z
    //   7: ifne +7 -> 14
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: ireturn
    //   14: getstatic 16	bdng:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: astore 6
    //   19: aload_0
    //   20: invokevirtual 33	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   23: astore 7
    //   25: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +81 -> 109
    //   31: ldc 41
    //   33: astore 5
    //   35: aload 5
    //   37: astore_0
    //   38: aload_1
    //   39: ifnull +34 -> 73
    //   42: aload 5
    //   44: astore_0
    //   45: aload_1
    //   46: arraylength
    //   47: iconst_1
    //   48: if_icmplt +25 -> 73
    //   51: new 43	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   58: ldc 41
    //   60: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: iconst_0
    //   65: aaload
    //   66: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_0
    //   73: getstatic 14	bdng:b	Ljava/lang/String;
    //   76: iconst_2
    //   77: new 43	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   84: ldc 55
    //   86: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 6
    //   91: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 57
    //   96: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload 7
    //   111: aload 6
    //   113: invokestatic 67	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   116: aconst_null
    //   117: ldc 69
    //   119: aload_1
    //   120: aconst_null
    //   121: invokevirtual 75	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   124: astore_1
    //   125: aload_1
    //   126: ifnull +26 -> 152
    //   129: aload_1
    //   130: astore_0
    //   131: aload_1
    //   132: invokeinterface 80 1 0
    //   137: istore_3
    //   138: iload_3
    //   139: istore_2
    //   140: aload_1
    //   141: ifnull -129 -> 12
    //   144: aload_1
    //   145: invokeinterface 93 1 0
    //   150: iload_3
    //   151: ireturn
    //   152: aload_1
    //   153: ifnull +9 -> 162
    //   156: aload_1
    //   157: invokeinterface 93 1 0
    //   162: iconst_0
    //   163: ireturn
    //   164: astore 4
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_1
    //   169: astore_0
    //   170: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +35 -> 208
    //   176: aload_1
    //   177: astore_0
    //   178: getstatic 14	bdng:b	Ljava/lang/String;
    //   181: iconst_2
    //   182: new 43	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   189: ldc 95
    //   191: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 4
    //   196: invokevirtual 96	java/lang/Exception:toString	()Ljava/lang/String;
    //   199: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload_1
    //   209: ifnull -47 -> 162
    //   212: aload_1
    //   213: invokeinterface 93 1 0
    //   218: goto -56 -> 162
    //   221: astore_0
    //   222: aload 4
    //   224: astore_1
    //   225: aload_1
    //   226: ifnull +9 -> 235
    //   229: aload_1
    //   230: invokeinterface 93 1 0
    //   235: aload_0
    //   236: athrow
    //   237: astore 4
    //   239: aload_0
    //   240: astore_1
    //   241: aload 4
    //   243: astore_0
    //   244: goto -19 -> 225
    //   247: astore 4
    //   249: goto -81 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramContext	Context
    //   0	252	1	paramArrayOfString	String[]
    //   11	129	2	bool1	boolean
    //   137	14	3	bool2	boolean
    //   1	1	4	localObject1	Object
    //   164	59	4	localException1	java.lang.Exception
    //   237	5	4	localObject2	Object
    //   247	1	4	localException2	java.lang.Exception
    //   33	10	5	str1	String
    //   17	95	6	str2	String
    //   23	87	7	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   25	31	164	java/lang/Exception
    //   45	73	164	java/lang/Exception
    //   73	109	164	java/lang/Exception
    //   109	125	164	java/lang/Exception
    //   25	31	221	finally
    //   45	73	221	finally
    //   73	109	221	finally
    //   109	125	221	finally
    //   131	138	237	finally
    //   170	176	237	finally
    //   178	208	237	finally
    //   131	138	247	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdng
 * JD-Core Version:    0.7.0.1
 */