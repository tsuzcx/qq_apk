import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;

public class awhr
  extends ContentObserver
{
  protected Context a;
  protected Handler a;
  protected String a;
  protected String b;
  
  public awhr(Handler paramHandler, Context paramContext, String paramString1, String paramString2)
  {
    super(paramHandler);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  protected void a(Cursor paramCursor)
  {
    try
    {
      paramCursor.close();
      return;
    }
    catch (Exception paramCursor) {}
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  /* Error */
  public void onChange(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 45	android/database/ContentObserver:onChange	(Z)V
    //   7: aload_0
    //   8: getfield 24	awhr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 16	awhr:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   18: ifnonnull +4 -> 22
    //   21: return
    //   22: ldc 47
    //   24: invokestatic 53	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 24	awhr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   32: invokevirtual 57	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   35: aload_2
    //   36: iconst_3
    //   37: anewarray 59	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc 61
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: ldc 63
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: ldc 65
    //   54: aastore
    //   55: aconst_null
    //   56: aconst_null
    //   57: ldc 67
    //   59: invokevirtual 73	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +255 -> 319
    //   67: aload_2
    //   68: invokeinterface 77 1 0
    //   73: ifeq +246 -> 319
    //   76: aload_2
    //   77: aload_2
    //   78: ldc 63
    //   80: invokeinterface 81 2 0
    //   85: invokeinterface 85 2 0
    //   90: astore 4
    //   92: aload_0
    //   93: getfield 26	awhr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   96: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifne +59 -> 158
    //   102: aload 4
    //   104: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifeq +18 -> 125
    //   110: aload_0
    //   111: aload_2
    //   112: invokevirtual 93	awhr:a	(Landroid/database/Cursor;)V
    //   115: aload_2
    //   116: ifnull -95 -> 21
    //   119: aload_0
    //   120: aload_2
    //   121: invokevirtual 93	awhr:a	(Landroid/database/Cursor;)V
    //   124: return
    //   125: aload_0
    //   126: getfield 26	awhr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   129: invokestatic 99	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   132: aload 4
    //   134: invokevirtual 103	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   137: invokevirtual 108	java/util/regex/Matcher:matches	()Z
    //   140: ifne +18 -> 158
    //   143: aload_0
    //   144: aload_2
    //   145: invokevirtual 93	awhr:a	(Landroid/database/Cursor;)V
    //   148: aload_2
    //   149: ifnull -128 -> 21
    //   152: aload_0
    //   153: aload_2
    //   154: invokevirtual 93	awhr:a	(Landroid/database/Cursor;)V
    //   157: return
    //   158: aload_0
    //   159: getfield 28	awhr:b	Ljava/lang/String;
    //   162: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifeq +18 -> 183
    //   168: aload_0
    //   169: aload_2
    //   170: invokevirtual 93	awhr:a	(Landroid/database/Cursor;)V
    //   173: aload_2
    //   174: ifnull -153 -> 21
    //   177: aload_0
    //   178: aload_2
    //   179: invokevirtual 93	awhr:a	(Landroid/database/Cursor;)V
    //   182: return
    //   183: aload_2
    //   184: aload_2
    //   185: ldc 65
    //   187: invokeinterface 81 2 0
    //   192: invokeinterface 85 2 0
    //   197: astore 5
    //   199: aload 5
    //   201: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifne +115 -> 319
    //   207: aload_0
    //   208: getfield 28	awhr:b	Ljava/lang/String;
    //   211: invokestatic 99	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   214: aload 5
    //   216: invokevirtual 103	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   219: astore 5
    //   221: aload 5
    //   223: invokevirtual 111	java/util/regex/Matcher:find	()Z
    //   226: ifne +18 -> 244
    //   229: aload_0
    //   230: aload_2
    //   231: invokevirtual 93	awhr:a	(Landroid/database/Cursor;)V
    //   234: aload_2
    //   235: ifnull -214 -> 21
    //   238: aload_0
    //   239: aload_2
    //   240: invokevirtual 93	awhr:a	(Landroid/database/Cursor;)V
    //   243: return
    //   244: aload 5
    //   246: invokevirtual 115	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   249: astore 5
    //   251: aload 5
    //   253: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   256: istore_1
    //   257: iload_1
    //   258: ifne +61 -> 319
    //   261: new 117	org/json/JSONObject
    //   264: dup
    //   265: invokespecial 119	org/json/JSONObject:<init>	()V
    //   268: astore 6
    //   270: aload 6
    //   272: ldc 121
    //   274: aload 4
    //   276: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload 6
    //   282: ldc 127
    //   284: aload 5
    //   286: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   289: pop
    //   290: aload 6
    //   292: invokevirtual 130	org/json/JSONObject:toString	()Ljava/lang/String;
    //   295: astore 4
    //   297: aload 4
    //   299: astore_3
    //   300: aload_3
    //   301: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   304: ifne +15 -> 319
    //   307: aload_0
    //   308: getfield 16	awhr:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   311: iconst_1
    //   312: aload_3
    //   313: invokevirtual 136	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   316: invokevirtual 141	android/os/Message:sendToTarget	()V
    //   319: aload_2
    //   320: ifnull -299 -> 21
    //   323: aload_0
    //   324: aload_2
    //   325: invokevirtual 93	awhr:a	(Landroid/database/Cursor;)V
    //   328: return
    //   329: astore 4
    //   331: aload 4
    //   333: invokevirtual 144	org/json/JSONException:printStackTrace	()V
    //   336: goto -36 -> 300
    //   339: astore_3
    //   340: aload_2
    //   341: ifnull +8 -> 349
    //   344: aload_0
    //   345: aload_2
    //   346: invokevirtual 93	awhr:a	(Landroid/database/Cursor;)V
    //   349: aload_2
    //   350: ifnull -329 -> 21
    //   353: aload_0
    //   354: aload_2
    //   355: invokevirtual 93	awhr:a	(Landroid/database/Cursor;)V
    //   358: return
    //   359: astore_3
    //   360: aconst_null
    //   361: astore_2
    //   362: aload_2
    //   363: ifnull +8 -> 371
    //   366: aload_0
    //   367: aload_2
    //   368: invokevirtual 93	awhr:a	(Landroid/database/Cursor;)V
    //   371: aload_3
    //   372: athrow
    //   373: astore_3
    //   374: goto -12 -> 362
    //   377: astore_3
    //   378: goto -16 -> 362
    //   381: astore_2
    //   382: aconst_null
    //   383: astore_2
    //   384: goto -44 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	awhr
    //   0	387	1	paramBoolean	boolean
    //   27	341	2	localObject1	java.lang.Object
    //   381	1	2	localException1	Exception
    //   383	1	2	localObject2	java.lang.Object
    //   1	312	3	localObject3	java.lang.Object
    //   339	1	3	localException2	Exception
    //   359	13	3	localObject4	java.lang.Object
    //   373	1	3	localObject5	java.lang.Object
    //   377	1	3	localObject6	java.lang.Object
    //   90	208	4	str	String
    //   329	3	4	localJSONException	org.json.JSONException
    //   197	88	5	localObject7	java.lang.Object
    //   268	23	6	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   261	297	329	org/json/JSONException
    //   67	115	339	java/lang/Exception
    //   125	148	339	java/lang/Exception
    //   158	173	339	java/lang/Exception
    //   183	234	339	java/lang/Exception
    //   244	257	339	java/lang/Exception
    //   261	297	339	java/lang/Exception
    //   300	319	339	java/lang/Exception
    //   331	336	339	java/lang/Exception
    //   28	63	359	finally
    //   67	115	373	finally
    //   125	148	373	finally
    //   158	173	373	finally
    //   183	234	373	finally
    //   244	257	373	finally
    //   261	297	373	finally
    //   300	319	373	finally
    //   331	336	373	finally
    //   344	349	377	finally
    //   28	63	381	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhr
 * JD-Core Version:    0.7.0.1
 */