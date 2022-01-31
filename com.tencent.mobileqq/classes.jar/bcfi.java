import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;

public class bcfi
{
  protected static final String a;
  protected SQLiteDatabase a;
  protected bcfj a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bcfi.class.getName();
  }
  
  public bcfi()
  {
    this.jdField_a_of_type_Bcfj = new bcfj(this, bbtm.a().a(), "agent_cgi_report.db", null, 4);
  }
  
  /* Error */
  private ArrayList<bcfl> a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 44
    //   4: ldc 46
    //   6: invokestatic 52	bcds:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: new 54	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 55	java/util/ArrayList:<init>	()V
    //   16: astore 5
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 39	bcfi:jdField_a_of_type_Bcfj	Lbcfj;
    //   23: invokevirtual 59	bcfj:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: putfield 61	bcfi:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   29: aconst_null
    //   30: astore 4
    //   32: aload_0
    //   33: getfield 61	bcfi:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   36: new 63	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   43: ldc 66
    //   45: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 72
    //   54: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc 74
    //   59: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 76
    //   64: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: iconst_1
    //   71: anewarray 81	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: aload_2
    //   77: aastore
    //   78: invokevirtual 87	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore_3
    //   82: aload_3
    //   83: ifnull +325 -> 408
    //   86: aload_3
    //   87: invokeinterface 93 1 0
    //   92: pop
    //   93: aload_3
    //   94: invokeinterface 96 1 0
    //   99: ifne +309 -> 408
    //   102: aload_3
    //   103: aload_3
    //   104: ldc 98
    //   106: invokeinterface 102 2 0
    //   111: invokeinterface 106 2 0
    //   116: astore 4
    //   118: aload_3
    //   119: aload_3
    //   120: ldc 108
    //   122: invokeinterface 102 2 0
    //   127: invokeinterface 106 2 0
    //   132: astore 6
    //   134: aload_3
    //   135: aload_3
    //   136: ldc 110
    //   138: invokeinterface 102 2 0
    //   143: invokeinterface 106 2 0
    //   148: astore 7
    //   150: aload_3
    //   151: aload_3
    //   152: ldc 112
    //   154: invokeinterface 102 2 0
    //   159: invokeinterface 106 2 0
    //   164: astore 8
    //   166: aload_3
    //   167: aload_3
    //   168: ldc 114
    //   170: invokeinterface 102 2 0
    //   175: invokeinterface 106 2 0
    //   180: astore 9
    //   182: aload_3
    //   183: aload_3
    //   184: ldc 116
    //   186: invokeinterface 102 2 0
    //   191: invokeinterface 106 2 0
    //   196: astore 10
    //   198: aload_3
    //   199: aload_3
    //   200: ldc 118
    //   202: invokeinterface 102 2 0
    //   207: invokeinterface 106 2 0
    //   212: astore 11
    //   214: aload_3
    //   215: aload_3
    //   216: ldc 120
    //   218: invokeinterface 102 2 0
    //   223: invokeinterface 106 2 0
    //   228: astore 12
    //   230: aload 5
    //   232: new 122	bcfl
    //   235: dup
    //   236: aload 4
    //   238: aload 6
    //   240: aload 7
    //   242: aload 8
    //   244: aload 9
    //   246: aload 10
    //   248: aload 11
    //   250: aload_3
    //   251: aload_3
    //   252: ldc 124
    //   254: invokeinterface 102 2 0
    //   259: invokeinterface 106 2 0
    //   264: aload_3
    //   265: aload_3
    //   266: ldc 126
    //   268: invokeinterface 102 2 0
    //   273: invokeinterface 106 2 0
    //   278: aload 12
    //   280: aload_2
    //   281: invokespecial 129	bcfl:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   284: invokevirtual 133	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   287: pop
    //   288: aload_3
    //   289: invokeinterface 136 1 0
    //   294: pop
    //   295: goto -202 -> 93
    //   298: astore 4
    //   300: aload_3
    //   301: astore_2
    //   302: aload 4
    //   304: astore_3
    //   305: getstatic 18	bcfi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   308: new 63	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   315: ldc 138
    //   317: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_1
    //   321: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 140
    //   326: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: aload_3
    //   333: invokestatic 143	bcds:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   336: aload_2
    //   337: ifnull +9 -> 346
    //   340: aload_2
    //   341: invokeinterface 146 1 0
    //   346: aload_0
    //   347: getfield 61	bcfi:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   350: invokevirtual 147	android/database/sqlite/SQLiteDatabase:close	()V
    //   353: ldc 44
    //   355: new 63	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   362: ldc 138
    //   364: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_1
    //   368: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: ldc 149
    //   373: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload 5
    //   378: invokevirtual 153	java/util/ArrayList:size	()I
    //   381: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 52	bcds:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: aload_0
    //   391: monitorexit
    //   392: aload 5
    //   394: areturn
    //   395: astore_1
    //   396: getstatic 18	bcfi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   399: ldc 158
    //   401: aload_1
    //   402: invokestatic 143	bcds:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   405: goto -15 -> 390
    //   408: aload_3
    //   409: ifnull -63 -> 346
    //   412: aload_3
    //   413: invokeinterface 146 1 0
    //   418: goto -72 -> 346
    //   421: astore_1
    //   422: aload_0
    //   423: monitorexit
    //   424: aload_1
    //   425: athrow
    //   426: astore_1
    //   427: aconst_null
    //   428: astore_3
    //   429: aload_3
    //   430: ifnull +9 -> 439
    //   433: aload_3
    //   434: invokeinterface 146 1 0
    //   439: aload_1
    //   440: athrow
    //   441: astore_1
    //   442: goto -13 -> 429
    //   445: astore_1
    //   446: aload_2
    //   447: astore_3
    //   448: goto -19 -> 429
    //   451: astore_3
    //   452: aload 4
    //   454: astore_2
    //   455: goto -150 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	this	bcfi
    //   0	458	1	paramString1	String
    //   0	458	2	paramString2	String
    //   81	367	3	localObject	Object
    //   451	1	3	localException1	Exception
    //   30	207	4	str1	String
    //   298	155	4	localException2	Exception
    //   16	377	5	localArrayList	ArrayList
    //   132	107	6	str2	String
    //   148	93	7	str3	String
    //   164	79	8	str4	String
    //   180	65	9	str5	String
    //   196	51	10	str6	String
    //   212	37	11	str7	String
    //   228	51	12	str8	String
    // Exception table:
    //   from	to	target	type
    //   86	93	298	java/lang/Exception
    //   93	295	298	java/lang/Exception
    //   18	29	395	java/lang/Exception
    //   2	18	421	finally
    //   18	29	421	finally
    //   340	346	421	finally
    //   346	390	421	finally
    //   396	405	421	finally
    //   412	418	421	finally
    //   433	439	421	finally
    //   439	441	421	finally
    //   32	82	426	finally
    //   86	93	441	finally
    //   93	295	441	finally
    //   305	336	445	finally
    //   32	82	451	java/lang/Exception
  }
  
  public int a(String paramString)
  {
    try
    {
      int i = 0 + a("newdata_report", paramString);
      bcds.b(jdField_a_of_type_JavaLangString, "new_table>>count=" + i);
      i += a("olddata_report", paramString);
      bcds.b(jdField_a_of_type_JavaLangString, "all_table>>>count=" + i);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: invokestatic 177	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +64 -> 73
    //   12: aconst_null
    //   13: astore 5
    //   15: aload_2
    //   16: invokestatic 177	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: istore 4
    //   21: iload 4
    //   23: ifeq +57 -> 80
    //   26: aload 6
    //   28: astore_2
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 39	bcfi:jdField_a_of_type_Bcfj	Lbcfj;
    //   34: invokevirtual 59	bcfj:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   37: putfield 61	bcfi:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   40: aload_0
    //   41: getfield 61	bcfi:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   44: aload_1
    //   45: aconst_null
    //   46: aload 5
    //   48: aload_2
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: invokevirtual 181	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore_1
    //   56: aload_1
    //   57: invokeinterface 184 1 0
    //   62: istore_3
    //   63: aload_1
    //   64: invokeinterface 146 1 0
    //   69: aload_0
    //   70: monitorexit
    //   71: iload_3
    //   72: ireturn
    //   73: ldc 186
    //   75: astore 5
    //   77: goto -62 -> 15
    //   80: iconst_1
    //   81: anewarray 81	java/lang/String
    //   84: astore 6
    //   86: aload 6
    //   88: iconst_0
    //   89: aload_2
    //   90: aastore
    //   91: aload 6
    //   93: astore_2
    //   94: goto -65 -> 29
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: getstatic 18	bcfi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: ldc 158
    //   108: aload_1
    //   109: invokestatic 143	bcds:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: iconst_0
    //   113: istore_3
    //   114: goto -45 -> 69
    //   117: astore_1
    //   118: getstatic 18	bcfi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: aload_1
    //   122: invokevirtual 189	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   125: aload_1
    //   126: invokestatic 192	bcds:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: iconst_0
    //   130: istore_3
    //   131: goto -62 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	bcfi
    //   0	134	1	paramString1	String
    //   0	134	2	paramString2	String
    //   62	69	3	i	int
    //   19	3	4	bool	boolean
    //   13	63	5	str	String
    //   1	91	6	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   5	12	97	finally
    //   15	21	97	finally
    //   29	40	97	finally
    //   40	69	97	finally
    //   80	86	97	finally
    //   103	112	97	finally
    //   118	129	97	finally
    //   29	40	102	java/lang/Exception
    //   40	69	117	java/lang/Exception
  }
  
  public int a(ArrayList<bcfl> paramArrayList)
  {
    int i;
    try
    {
      bcds.b("cgi_report_debug", "ReportDataModal backupOldItems count = " + paramArrayList.size());
      paramArrayList = new ArrayList(paramArrayList).iterator();
      i = 0;
      for (;;)
      {
        if (paramArrayList.hasNext())
        {
          bcfl localbcfl = (bcfl)paramArrayList.next();
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("apn", localbcfl.jdField_a_of_type_JavaLangString);
          localContentValues.put("frequency", localbcfl.b);
          localContentValues.put("commandid", localbcfl.c);
          localContentValues.put("resultcode", localbcfl.d);
          localContentValues.put("tmcost", localbcfl.e);
          localContentValues.put("reqsize", localbcfl.f);
          localContentValues.put("rspsize", localbcfl.g);
          localContentValues.put("touin", localbcfl.h);
          localContentValues.put("deviceinfo", localbcfl.i);
          localContentValues.put("detail", localbcfl.j);
          localContentValues.put("appid", localbcfl.k);
          try
          {
            this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_Bcfj.getWritableDatabase();
            this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insertOrThrow("olddata_report", null, localContentValues);
            this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              bcds.c(jdField_a_of_type_JavaLangString, "update>>>", localException);
            }
          }
        }
      }
      bcds.b("cgi_report_debug", "ReportDataModal backupOldItems succ_count = " + i);
    }
    finally {}
    return i;
  }
  
  public ArrayList<bcfl> a(String paramString)
  {
    try
    {
      paramString = a("newdata_report", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      bcds.b("cgi_report_debug", "ReportDataModal deleteOldItems start");
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_Bcfj.getWritableDatabase();
        paramString = "delete from olddata_report where appid=" + paramString + ";";
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label75:
          bcds.a(jdField_a_of_type_JavaLangString, "deleteOldItems>>>", paramString);
        }
      }
    }
    finally {}
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      bcds.b("cgi_report_debug", "ReportDataModal deleteOldItems success");
      bool = true;
    }
    catch (Exception paramString)
    {
      bcds.a(jdField_a_of_type_JavaLangString, "deleteOldItems>>>", paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      break label75;
    }
    return bool;
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: astore 13
    //   5: aload_3
    //   6: ldc_w 280
    //   9: invokevirtual 283	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +14 -> 26
    //   15: aload_3
    //   16: ldc_w 285
    //   19: invokevirtual 289	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   22: iconst_0
    //   23: aaload
    //   24: astore 13
    //   26: ldc 44
    //   28: new 63	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 291
    //   38: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc_w 293
    //   48: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_2
    //   52: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 295
    //   58: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload 13
    //   63: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 297
    //   69: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 4
    //   74: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc_w 299
    //   80: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 5
    //   85: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc_w 301
    //   91: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload 6
    //   96: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc_w 303
    //   102: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 7
    //   107: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 52	bcds:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: new 213	android/content/ContentValues
    //   119: dup
    //   120: invokespecial 214	android/content/ContentValues:<init>	()V
    //   123: astore_3
    //   124: aload_3
    //   125: ldc 98
    //   127: new 63	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   134: aload_1
    //   135: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 305
    //   141: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 218	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_3
    //   151: ldc 108
    //   153: new 63	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   160: aload_2
    //   161: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 305
    //   167: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 218	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_3
    //   177: ldc 110
    //   179: new 63	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   186: aload 13
    //   188: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 305
    //   194: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokevirtual 218	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_3
    //   204: ldc 112
    //   206: new 63	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   213: aload 4
    //   215: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 305
    //   221: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokevirtual 218	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload_3
    //   231: ldc 114
    //   233: new 63	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   240: aload 5
    //   242: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 305
    //   248: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokevirtual 218	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_3
    //   258: ldc 116
    //   260: new 63	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   267: aload 6
    //   269: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 305
    //   275: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokevirtual 218	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload_3
    //   285: ldc 118
    //   287: new 63	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   294: aload 7
    //   296: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc_w 305
    //   302: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokevirtual 218	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload_3
    //   312: ldc 124
    //   314: new 63	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   321: aload 8
    //   323: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 305
    //   329: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokevirtual 218	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: aload_3
    //   339: ldc 74
    //   341: new 63	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   348: aload 10
    //   350: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc_w 305
    //   356: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokevirtual 218	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: new 63	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   372: astore_2
    //   373: aload_2
    //   374: ldc_w 307
    //   377: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_1
    //   381: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: bipush 38
    //   386: invokevirtual 310	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload_2
    //   391: ldc_w 312
    //   394: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: astore_1
    //   398: invokestatic 317	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   401: ldc_w 319
    //   404: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   407: ifeq +172 -> 579
    //   410: iconst_1
    //   411: istore 11
    //   413: aload_1
    //   414: iload 11
    //   416: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   419: bipush 38
    //   421: invokevirtual 310	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_2
    //   426: ldc_w 324
    //   429: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokestatic 29	bbtm:a	()Lbbtm;
    //   435: invokevirtual 32	bbtm:a	()Landroid/content/Context;
    //   438: invokestatic 329	bcdn:e	(Landroid/content/Context;)Ljava/lang/String;
    //   441: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_3
    //   446: ldc 126
    //   448: aload_2
    //   449: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokevirtual 218	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: new 63	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   462: ldc_w 331
    //   465: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokestatic 29	bbtm:a	()Lbbtm;
    //   471: invokevirtual 334	bbtm:a	()J
    //   474: invokevirtual 337	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   477: ldc_w 305
    //   480: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: astore_2
    //   487: aload_2
    //   488: astore_1
    //   489: aload 9
    //   491: ifnull +35 -> 526
    //   494: new 63	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   501: aload_2
    //   502: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc_w 339
    //   508: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload 9
    //   513: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc_w 305
    //   519: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: astore_1
    //   526: aload_3
    //   527: ldc 120
    //   529: aload_1
    //   530: invokevirtual 218	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aload_0
    //   534: aload_0
    //   535: getfield 39	bcfi:jdField_a_of_type_Bcfj	Lbcfj;
    //   538: invokevirtual 249	bcfj:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   541: putfield 61	bcfi:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   544: aload_0
    //   545: getfield 61	bcfi:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   548: ldc 162
    //   550: aconst_null
    //   551: aload_3
    //   552: invokevirtual 253	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   555: pop2
    //   556: aload_0
    //   557: getfield 61	bcfi:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   560: invokevirtual 147	android/database/sqlite/SQLiteDatabase:close	()V
    //   563: ldc 44
    //   565: ldc_w 341
    //   568: invokestatic 52	bcds:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: iconst_1
    //   572: istore 12
    //   574: aload_0
    //   575: monitorexit
    //   576: iload 12
    //   578: ireturn
    //   579: iconst_0
    //   580: istore 11
    //   582: goto -169 -> 413
    //   585: astore_1
    //   586: ldc 44
    //   588: ldc_w 343
    //   591: invokestatic 345	bcds:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: iconst_0
    //   595: istore 12
    //   597: goto -23 -> 574
    //   600: astore_1
    //   601: aload_0
    //   602: monitorexit
    //   603: aload_1
    //   604: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	605	0	this	bcfi
    //   0	605	1	paramString1	String
    //   0	605	2	paramString2	String
    //   0	605	3	paramString3	String
    //   0	605	4	paramString4	String
    //   0	605	5	paramString5	String
    //   0	605	6	paramString6	String
    //   0	605	7	paramString7	String
    //   0	605	8	paramString8	String
    //   0	605	9	paramString9	String
    //   0	605	10	paramString10	String
    //   411	170	11	i	int
    //   572	24	12	bool	boolean
    //   3	184	13	str	String
    // Exception table:
    //   from	to	target	type
    //   533	571	585	java/lang/Exception
    //   5	26	600	finally
    //   26	410	600	finally
    //   413	487	600	finally
    //   494	526	600	finally
    //   526	533	600	finally
    //   533	571	600	finally
    //   586	594	600	finally
  }
  
  public ArrayList<bcfl> b(String paramString)
  {
    try
    {
      paramString = a("olddata_report", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool = false;
    try
    {
      bcds.b("cgi_report_debug", "ReportDataModal deleteNewItems start");
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_Bcfj.getWritableDatabase();
        paramString = "delete from newdata_report where appid=" + paramString + ";";
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label75:
          bcds.a(jdField_a_of_type_JavaLangString, "deleteNewItems>>>", paramString);
        }
      }
    }
    finally {}
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      bcds.b("cgi_report_debug", "ReportDataModal deleteNewItems success");
      bool = true;
    }
    catch (Exception paramString)
    {
      bcds.a(jdField_a_of_type_JavaLangString, "deleteNewItems>>>", paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      break label75;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcfi
 * JD-Core Version:    0.7.0.1
 */