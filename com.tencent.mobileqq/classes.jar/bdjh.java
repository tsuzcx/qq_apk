import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class bdjh
  extends SQLiteOpenHelper
{
  protected static String a;
  protected static final byte[] a;
  protected static final String[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "sys_image";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "key", "maxage", "updatetime", "modified", "local" };
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  public bdjh(Context paramContext)
  {
    super(paramContext, "appcenterImagedb.db", null, 4);
  }
  
  protected bdjk a(Cursor paramCursor)
  {
    bdjk localbdjk = new bdjk();
    localbdjk.jdField_a_of_type_JavaLangString = paramCursor.getString(0);
    localbdjk.jdField_a_of_type_Long = paramCursor.getLong(1);
    localbdjk.b = paramCursor.getLong(2);
    localbdjk.jdField_c_of_type_Long = paramCursor.getLong(3);
    localbdjk.jdField_c_of_type_JavaLangString = paramCursor.getString(4);
    return localbdjk;
  }
  
  /* Error */
  public bdjk a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: getstatic 30	bdjh:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore 7
    //   14: aload 7
    //   16: monitorenter
    //   17: aload_0
    //   18: invokevirtual 72	bdjh:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore_2
    //   22: aload_2
    //   23: getstatic 14	bdjh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   26: getstatic 28	bdjh:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   29: ldc 74
    //   31: iconst_1
    //   32: anewarray 16	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: aload_1
    //   38: aastore
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: invokevirtual 80	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_3
    //   46: aload 6
    //   48: astore_1
    //   49: aload_3
    //   50: invokeinterface 84 1 0
    //   55: ifle +16 -> 71
    //   58: aload_3
    //   59: invokeinterface 88 1 0
    //   64: pop
    //   65: aload_0
    //   66: aload_3
    //   67: invokevirtual 90	bdjh:a	(Landroid/database/Cursor;)Lbdjk;
    //   70: astore_1
    //   71: aload_3
    //   72: ifnull +9 -> 81
    //   75: aload_3
    //   76: invokeinterface 93 1 0
    //   81: aload_1
    //   82: astore_3
    //   83: aload_2
    //   84: ifnull +9 -> 93
    //   87: aload_2
    //   88: invokevirtual 94	android/database/sqlite/SQLiteDatabase:close	()V
    //   91: aload_1
    //   92: astore_3
    //   93: aload 7
    //   95: monitorexit
    //   96: aload_3
    //   97: areturn
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   107: aload_2
    //   108: ifnull +9 -> 117
    //   111: aload_2
    //   112: invokeinterface 93 1 0
    //   117: aload 5
    //   119: astore_3
    //   120: aload_1
    //   121: ifnull -28 -> 93
    //   124: aload_1
    //   125: invokevirtual 94	android/database/sqlite/SQLiteDatabase:close	()V
    //   128: aload 5
    //   130: astore_3
    //   131: goto -38 -> 93
    //   134: astore_1
    //   135: aload 7
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_1
    //   143: aload 4
    //   145: astore_3
    //   146: aload_3
    //   147: ifnull +9 -> 156
    //   150: aload_3
    //   151: invokeinterface 93 1 0
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 94	android/database/sqlite/SQLiteDatabase:close	()V
    //   164: aload_2
    //   165: athrow
    //   166: astore_3
    //   167: aload_2
    //   168: astore_1
    //   169: aload_3
    //   170: astore_2
    //   171: aload 4
    //   173: astore_3
    //   174: goto -28 -> 146
    //   177: astore 4
    //   179: aload_2
    //   180: astore_1
    //   181: aload 4
    //   183: astore_2
    //   184: goto -38 -> 146
    //   187: astore 4
    //   189: aload_2
    //   190: astore_3
    //   191: aload 4
    //   193: astore_2
    //   194: goto -48 -> 146
    //   197: astore_3
    //   198: aload_2
    //   199: astore_1
    //   200: aconst_null
    //   201: astore_2
    //   202: goto -99 -> 103
    //   205: astore 6
    //   207: aload_3
    //   208: astore_1
    //   209: aload_2
    //   210: astore 4
    //   212: aload 6
    //   214: astore_3
    //   215: aload_1
    //   216: astore_2
    //   217: aload 4
    //   219: astore_1
    //   220: goto -117 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	bdjh
    //   0	223	1	paramString	String
    //   21	91	2	localSQLiteDatabase	SQLiteDatabase
    //   140	28	2	localObject1	java.lang.Object
    //   170	47	2	localObject2	java.lang.Object
    //   45	52	3	localObject3	java.lang.Object
    //   98	6	3	localException1	Exception
    //   119	32	3	localObject4	java.lang.Object
    //   166	4	3	localObject5	java.lang.Object
    //   173	18	3	localObject6	java.lang.Object
    //   197	11	3	localException2	Exception
    //   214	1	3	localException3	Exception
    //   4	168	4	localObject7	java.lang.Object
    //   177	5	4	localObject8	java.lang.Object
    //   187	5	4	localObject9	java.lang.Object
    //   210	8	4	localObject10	java.lang.Object
    //   1	128	5	localObject11	java.lang.Object
    //   7	40	6	localObject12	java.lang.Object
    //   205	8	6	localException4	Exception
    //   12	124	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	22	98	java/lang/Exception
    //   75	81	134	finally
    //   87	91	134	finally
    //   93	96	134	finally
    //   111	117	134	finally
    //   124	128	134	finally
    //   135	138	134	finally
    //   150	156	134	finally
    //   160	164	134	finally
    //   164	166	134	finally
    //   17	22	140	finally
    //   22	46	166	finally
    //   49	71	177	finally
    //   103	107	187	finally
    //   22	46	197	java/lang/Exception
    //   49	71	205	java/lang/Exception
  }
  
  /* Error */
  public void a(bdjk parambdjk)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: getstatic 30	bdjh:jdField_a_of_type_ArrayOfByte	[B
    //   7: astore 6
    //   9: aload 6
    //   11: monitorenter
    //   12: aload_1
    //   13: ifnonnull +7 -> 20
    //   16: aload 6
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: invokevirtual 101	bdjh:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore 4
    //   26: aload 4
    //   28: astore_2
    //   29: aload 4
    //   31: astore_3
    //   32: new 103	android/content/ContentValues
    //   35: dup
    //   36: invokespecial 104	android/content/ContentValues:<init>	()V
    //   39: astore 7
    //   41: aload 4
    //   43: astore_2
    //   44: aload 4
    //   46: astore_3
    //   47: aload 7
    //   49: ldc 18
    //   51: aload_1
    //   52: getfield 50	bdjk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokevirtual 108	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload 4
    //   60: astore_2
    //   61: aload 4
    //   63: astore_3
    //   64: aload 7
    //   66: ldc 20
    //   68: aload_1
    //   69: getfield 57	bdjk:jdField_a_of_type_Long	J
    //   72: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   75: invokevirtual 117	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   78: aload 4
    //   80: astore_2
    //   81: aload 4
    //   83: astore_3
    //   84: aload 7
    //   86: ldc 22
    //   88: aload_1
    //   89: getfield 60	bdjk:b	J
    //   92: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   95: invokevirtual 117	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   98: aload 4
    //   100: astore_2
    //   101: aload 4
    //   103: astore_3
    //   104: aload 7
    //   106: ldc 24
    //   108: aload_1
    //   109: getfield 63	bdjk:jdField_c_of_type_Long	J
    //   112: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   115: invokevirtual 117	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   118: aload 4
    //   120: astore_2
    //   121: aload 4
    //   123: astore_3
    //   124: aload 7
    //   126: ldc 26
    //   128: aload_1
    //   129: getfield 65	bdjk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   132: invokevirtual 108	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 4
    //   137: astore_2
    //   138: aload 4
    //   140: astore_3
    //   141: new 119	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   148: ldc 122
    //   150: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: astore 8
    //   155: aload_1
    //   156: ifnonnull +106 -> 262
    //   159: ldc 128
    //   161: astore 5
    //   163: aload 4
    //   165: astore_2
    //   166: aload 4
    //   168: astore_3
    //   169: ldc 130
    //   171: aload 8
    //   173: aload 5
    //   175: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 138	bdii:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 4
    //   186: astore_3
    //   187: aload 4
    //   189: getstatic 14	bdjh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   192: new 119	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   199: ldc 140
    //   201: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_1
    //   205: getfield 50	bdjk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   208: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 142
    //   213: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: aconst_null
    //   220: invokevirtual 146	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   223: pop
    //   224: aload 4
    //   226: astore_2
    //   227: aload 4
    //   229: astore_3
    //   230: aload 4
    //   232: getstatic 14	bdjh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   235: aconst_null
    //   236: aload 7
    //   238: invokevirtual 150	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   241: pop2
    //   242: aload 4
    //   244: ifnull +8 -> 252
    //   247: aload 4
    //   249: invokevirtual 94	android/database/sqlite/SQLiteDatabase:close	()V
    //   252: aload 6
    //   254: monitorexit
    //   255: return
    //   256: astore_1
    //   257: aload 6
    //   259: monitorexit
    //   260: aload_1
    //   261: athrow
    //   262: aload 4
    //   264: astore_2
    //   265: aload 4
    //   267: astore_3
    //   268: aload_1
    //   269: getfield 50	bdjk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   272: astore 5
    //   274: goto -111 -> 163
    //   277: astore_1
    //   278: aload 4
    //   280: astore_2
    //   281: aload 4
    //   283: astore_3
    //   284: aload_1
    //   285: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   288: goto -64 -> 224
    //   291: astore_1
    //   292: aload_2
    //   293: astore_3
    //   294: ldc 130
    //   296: ldc 152
    //   298: aload_1
    //   299: invokestatic 155	bdii:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   302: aload_2
    //   303: ifnull -51 -> 252
    //   306: aload_2
    //   307: invokevirtual 94	android/database/sqlite/SQLiteDatabase:close	()V
    //   310: goto -58 -> 252
    //   313: astore_1
    //   314: aload_3
    //   315: ifnull +7 -> 322
    //   318: aload_3
    //   319: invokevirtual 94	android/database/sqlite/SQLiteDatabase:close	()V
    //   322: aload_1
    //   323: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	bdjh
    //   0	324	1	parambdjk	bdjk
    //   3	304	2	localObject1	java.lang.Object
    //   1	318	3	localObject2	java.lang.Object
    //   24	258	4	localSQLiteDatabase	SQLiteDatabase
    //   161	112	5	str	String
    //   7	251	6	arrayOfByte	byte[]
    //   39	198	7	localContentValues	android.content.ContentValues
    //   153	19	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   16	19	256	finally
    //   247	252	256	finally
    //   252	255	256	finally
    //   257	260	256	finally
    //   306	310	256	finally
    //   318	322	256	finally
    //   322	324	256	finally
    //   187	224	277	java/lang/Exception
    //   20	26	291	java/lang/Exception
    //   32	41	291	java/lang/Exception
    //   47	58	291	java/lang/Exception
    //   64	78	291	java/lang/Exception
    //   84	98	291	java/lang/Exception
    //   104	118	291	java/lang/Exception
    //   124	135	291	java/lang/Exception
    //   141	155	291	java/lang/Exception
    //   169	184	291	java/lang/Exception
    //   230	242	291	java/lang/Exception
    //   268	274	291	java/lang/Exception
    //   284	288	291	java/lang/Exception
    //   20	26	313	finally
    //   32	41	313	finally
    //   47	58	313	finally
    //   64	78	313	finally
    //   84	98	313	finally
    //   104	118	313	finally
    //   124	135	313	finally
    //   141	155	313	finally
    //   169	184	313	finally
    //   187	224	313	finally
    //   230	242	313	finally
    //   268	274	313	finally
    //   284	288	313	finally
    //   294	302	313	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + jdField_a_of_type_JavaLangString + " (" + "key" + " VARCHAR(50)," + "local" + " VARCHAR(50)," + "maxage" + " BIGINT," + "updatetime" + " BIGINT," + "modified" + " BIGINT,PRIMARY KEY(" + "key" + "))");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + jdField_a_of_type_JavaLangString + ";");
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdjh
 * JD-Core Version:    0.7.0.1
 */