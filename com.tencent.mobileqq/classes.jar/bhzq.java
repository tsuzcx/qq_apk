import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

public class bhzq
{
  protected long a;
  protected bhzs a;
  protected WtloginManager a;
  protected SSOAccountObserver a;
  
  public bhzq()
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new bhzr(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhzs = null;
  }
  
  public void a(bhzs parambhzs)
  {
    this.jdField_a_of_type_Bhzs = parambhzs;
  }
  
  public void a(AppRuntime paramAppRuntime, long paramLong, String paramString)
  {
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)paramAppRuntime.getManager(1));
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
    {
      byte[] arrayOfByte = this.jdField_a_of_type_MqqManagerWtloginManager.getPkgSigFromApkName(bhpc.a().a(), paramString);
      this.jdField_a_of_type_Long = paramLong;
      paramAppRuntime.ssoGetA1WithA1(bhpc.a().a() + "", paramString.getBytes(), 16L, paramLong, 1L, "5.0".getBytes(), arrayOfByte, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
    }
  }
  
  /* Error */
  public byte[] a(android.content.Context paramContext, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 87
    //   5: invokevirtual 91	java/lang/Object:getClass	()Ljava/lang/Class;
    //   8: ldc 93
    //   10: iconst_3
    //   11: anewarray 95	java/lang/Class
    //   14: dup
    //   15: iconst_0
    //   16: ldc 97
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: getstatic 103	java/lang/Long:TYPE	Ljava/lang/Class;
    //   24: aastore
    //   25: dup
    //   26: iconst_2
    //   27: getstatic 103	java/lang/Long:TYPE	Ljava/lang/Class;
    //   30: aastore
    //   31: invokevirtual 107	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   34: aload_0
    //   35: iconst_3
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: lload_2
    //   46: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: lload 4
    //   54: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   57: aastore
    //   58: invokevirtual 117	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   61: astore 7
    //   63: aload 7
    //   65: instanceof 119
    //   68: ifeq +27 -> 95
    //   71: aload 7
    //   73: checkcast 119	[B
    //   76: checkcast 119	[B
    //   79: astore 7
    //   81: aload 7
    //   83: astore 6
    //   85: aload 6
    //   87: areturn
    //   88: astore 7
    //   90: aload 7
    //   92: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   95: aload_1
    //   96: ifnonnull +7 -> 103
    //   99: iconst_0
    //   100: newarray byte
    //   102: areturn
    //   103: aload_1
    //   104: invokevirtual 126	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   107: astore_1
    //   108: new 51	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   115: ldc 128
    //   117: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 130
    //   122: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 132
    //   127: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 138	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   136: astore 7
    //   138: new 51	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   145: lload_2
    //   146: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   149: ldc 61
    //   151: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: astore 8
    //   159: new 51	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   166: lload 4
    //   168: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   171: ldc 61
    //   173: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: astore 9
    //   181: aload_1
    //   182: aload 7
    //   184: iconst_5
    //   185: anewarray 70	java/lang/String
    //   188: dup
    //   189: iconst_0
    //   190: ldc 140
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: ldc 142
    //   197: aastore
    //   198: dup
    //   199: iconst_2
    //   200: ldc 144
    //   202: aastore
    //   203: dup
    //   204: iconst_3
    //   205: ldc 146
    //   207: aastore
    //   208: dup
    //   209: iconst_4
    //   210: ldc 148
    //   212: aastore
    //   213: ldc 150
    //   215: iconst_2
    //   216: anewarray 70	java/lang/String
    //   219: dup
    //   220: iconst_0
    //   221: aload 8
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: aload 9
    //   228: aastore
    //   229: aconst_null
    //   230: invokevirtual 156	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   233: astore_1
    //   234: aload_1
    //   235: ifnull +114 -> 349
    //   238: aload_1
    //   239: astore 6
    //   241: aload_1
    //   242: invokeinterface 162 1 0
    //   247: ifeq +102 -> 349
    //   250: aload_1
    //   251: astore 6
    //   253: aload_1
    //   254: aload_1
    //   255: ldc 140
    //   257: invokeinterface 166 2 0
    //   262: invokeinterface 170 2 0
    //   267: pop
    //   268: aload_1
    //   269: astore 6
    //   271: aload_1
    //   272: aload_1
    //   273: ldc 146
    //   275: invokeinterface 166 2 0
    //   280: invokeinterface 174 2 0
    //   285: astore 7
    //   287: aload_1
    //   288: astore 6
    //   290: aload_1
    //   291: aload_1
    //   292: ldc 148
    //   294: invokeinterface 166 2 0
    //   299: invokeinterface 174 2 0
    //   304: astore 8
    //   306: aload_1
    //   307: astore 6
    //   309: aload 7
    //   311: invokestatic 180	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   314: aload 8
    //   316: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   319: ifeq +30 -> 349
    //   322: aload_1
    //   323: astore 6
    //   325: aload 7
    //   327: invokestatic 188	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   330: astore 7
    //   332: aload 7
    //   334: astore 6
    //   336: aload_1
    //   337: ifnull -252 -> 85
    //   340: aload_1
    //   341: invokeinterface 191 1 0
    //   346: aload 7
    //   348: areturn
    //   349: aload_1
    //   350: ifnull +9 -> 359
    //   353: aload_1
    //   354: invokeinterface 191 1 0
    //   359: ldc 193
    //   361: invokestatic 188	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   364: areturn
    //   365: astore 7
    //   367: aconst_null
    //   368: astore_1
    //   369: aload_1
    //   370: astore 6
    //   372: ldc 195
    //   374: aload 7
    //   376: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   379: aload 7
    //   381: invokestatic 204	bhzm:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   384: aload_1
    //   385: ifnull -26 -> 359
    //   388: aload_1
    //   389: invokeinterface 191 1 0
    //   394: goto -35 -> 359
    //   397: astore_1
    //   398: aload 6
    //   400: ifnull +10 -> 410
    //   403: aload 6
    //   405: invokeinterface 191 1 0
    //   410: aload_1
    //   411: athrow
    //   412: astore_1
    //   413: goto -15 -> 398
    //   416: astore 7
    //   418: goto -49 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	bhzq
    //   0	421	1	paramContext	android.content.Context
    //   0	421	2	paramLong1	long
    //   0	421	4	paramLong2	long
    //   1	403	6	localObject1	Object
    //   61	21	7	localObject2	Object
    //   88	3	7	localException1	java.lang.Exception
    //   136	211	7	localObject3	Object
    //   365	15	7	localException2	java.lang.Exception
    //   416	1	7	localException3	java.lang.Exception
    //   157	158	8	str1	String
    //   179	48	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	81	88	java/lang/Exception
    //   138	234	365	java/lang/Exception
    //   138	234	397	finally
    //   241	250	412	finally
    //   253	268	412	finally
    //   271	287	412	finally
    //   290	306	412	finally
    //   309	322	412	finally
    //   325	332	412	finally
    //   372	384	412	finally
    //   241	250	416	java/lang/Exception
    //   253	268	416	java/lang/Exception
    //   271	287	416	java/lang/Exception
    //   290	306	416	java/lang/Exception
    //   309	322	416	java/lang/Exception
    //   325	332	416	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzq
 * JD-Core Version:    0.7.0.1
 */