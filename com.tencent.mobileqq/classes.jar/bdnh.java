import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class bdnh
  extends SQLiteOpenHelper
{
  public static final Uri a = Uri.parse("content://open.pcpush/pcpush_package_info");
  public static final Uri b = Uri.parse("content://open.pcpush/pcpush_package_info/");
  public static final Uri c = Uri.parse("content://open.pcpush/pcpush_package_info//#");
  
  public bdnh()
  {
    super(bcxm.a().a(), "pcdb", null, 2);
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS pcpush_package_info;");
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      onCreate(paramSQLiteDatabase);
    }
  }
  
  public void a(bdnk parambdnk)
  {
    bdht.b("PCPushDBHelper", "addPkgEntry>>>insert entry = " + parambdnk.toString());
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localSQLiteDatabase.beginTransaction();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      ContentValues localContentValues = new ContentValues();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("key", parambdnk.jdField_a_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appid", parambdnk.jdField_b_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appname", parambdnk.e);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appsize", parambdnk.h);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appurl", parambdnk.f);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("downloadtype", Integer.valueOf(parambdnk.jdField_d_of_type_Int));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("filetype", Integer.valueOf(parambdnk.jdField_b_of_type_Int));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("iconurl", parambdnk.g);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("pkgname", parambdnk.jdField_d_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("source", parambdnk.i);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("srciconurl", parambdnk.j);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("versioncode", Integer.valueOf(parambdnk.jdField_a_of_type_Int));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("via", parambdnk.jdField_c_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("key", parambdnk.jdField_a_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("installstate", Integer.valueOf(parambdnk.jdField_c_of_type_Int));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      int i = localSQLiteDatabase.update("pcpush_package_info", localContentValues, "key = ?", new String[] { parambdnk.jdField_a_of_type_JavaLangString });
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      bdht.a("PCPushDBHelper", "addPkgEntry>>>update affected rowNum=" + i);
      if (i == 0)
      {
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        long l = localSQLiteDatabase.insert("pcpush_package_info", "pkgname", localContentValues);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        bdht.a("PCPushDBHelper", "addPkgEntry>>>insert rowID = " + l);
      }
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception parambdnk)
    {
      localObject2 = localObject1;
      bdht.c("PCPushDBHelper", "addPkgEntry error", parambdnk);
      return;
    }
    finally
    {
      if (localObject2 != null)
      {
        localObject2.endTransaction();
        localObject2.close();
      }
    }
  }
  
  public void a(String paramString)
  {
    bdht.a("PCPushDBHelper", "--> delete key = " + paramString);
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localSQLiteDatabase.delete("pcpush_package_info", "key = ?", new String[] { paramString });
      localSQLiteDatabase.close();
      return;
    }
    catch (Exception paramString)
    {
      bdht.c("PCPushDBHelper", "deletePkgEntry error", paramString);
    }
  }
  
  /* Error */
  public void a(java.util.concurrent.ConcurrentHashMap<String, bdnk> paramConcurrentHashMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_0
    //   12: invokevirtual 240	bdnh:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 5
    //   17: aload 7
    //   19: astore_3
    //   20: aload 6
    //   22: astore 4
    //   24: aload 5
    //   26: ldc 196
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 244	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore 6
    //   39: aload 6
    //   41: ifnull +481 -> 522
    //   44: aload 6
    //   46: astore_3
    //   47: aload 6
    //   49: astore 4
    //   51: aload 6
    //   53: invokeinterface 250 1 0
    //   58: ifle +464 -> 522
    //   61: aload 6
    //   63: astore_3
    //   64: aload 6
    //   66: astore 4
    //   68: aload 6
    //   70: invokeinterface 254 1 0
    //   75: pop
    //   76: aload 6
    //   78: astore_3
    //   79: aload 6
    //   81: astore 4
    //   83: new 103	bdnk
    //   86: dup
    //   87: invokespecial 255	bdnk:<init>	()V
    //   90: astore 7
    //   92: aload 6
    //   94: astore_3
    //   95: aload 6
    //   97: astore 4
    //   99: aload 7
    //   101: aload 6
    //   103: aload 6
    //   105: ldc 111
    //   107: invokeinterface 259 2 0
    //   112: invokeinterface 263 2 0
    //   117: putfield 113	bdnk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   120: aload 6
    //   122: astore_3
    //   123: aload 6
    //   125: astore 4
    //   127: aload 7
    //   129: aload 6
    //   131: aload 6
    //   133: ldc 115
    //   135: invokeinterface 259 2 0
    //   140: invokeinterface 263 2 0
    //   145: putfield 118	bdnk:e	Ljava/lang/String;
    //   148: aload 6
    //   150: astore_3
    //   151: aload 6
    //   153: astore 4
    //   155: aload 7
    //   157: aload 6
    //   159: aload 6
    //   161: ldc 120
    //   163: invokeinterface 259 2 0
    //   168: invokeinterface 263 2 0
    //   173: putfield 123	bdnk:h	Ljava/lang/String;
    //   176: aload 6
    //   178: astore_3
    //   179: aload 6
    //   181: astore 4
    //   183: aload 7
    //   185: aload 6
    //   187: aload 6
    //   189: ldc 125
    //   191: invokeinterface 259 2 0
    //   196: invokeinterface 263 2 0
    //   201: putfield 128	bdnk:f	Ljava/lang/String;
    //   204: aload 6
    //   206: astore_3
    //   207: aload 6
    //   209: astore 4
    //   211: aload 7
    //   213: aload 6
    //   215: aload 6
    //   217: ldc 145
    //   219: invokeinterface 259 2 0
    //   224: invokeinterface 267 2 0
    //   229: putfield 147	bdnk:jdField_b_of_type_Int	I
    //   232: aload 6
    //   234: astore_3
    //   235: aload 6
    //   237: astore 4
    //   239: aload 7
    //   241: aload 6
    //   243: aload 6
    //   245: ldc 149
    //   247: invokeinterface 259 2 0
    //   252: invokeinterface 263 2 0
    //   257: putfield 152	bdnk:g	Ljava/lang/String;
    //   260: aload 6
    //   262: astore_3
    //   263: aload 6
    //   265: astore 4
    //   267: aload 7
    //   269: aload 6
    //   271: aload 6
    //   273: ldc 154
    //   275: invokeinterface 259 2 0
    //   280: invokeinterface 263 2 0
    //   285: putfield 156	bdnk:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   288: aload 6
    //   290: astore_3
    //   291: aload 6
    //   293: astore 4
    //   295: aload 7
    //   297: aload 6
    //   299: aload 6
    //   301: ldc 158
    //   303: invokeinterface 259 2 0
    //   308: invokeinterface 263 2 0
    //   313: putfield 161	bdnk:i	Ljava/lang/String;
    //   316: aload 6
    //   318: astore_3
    //   319: aload 6
    //   321: astore 4
    //   323: aload 7
    //   325: aload 6
    //   327: aload 6
    //   329: ldc 163
    //   331: invokeinterface 259 2 0
    //   336: invokeinterface 263 2 0
    //   341: putfield 166	bdnk:j	Ljava/lang/String;
    //   344: aload 6
    //   346: astore_3
    //   347: aload 6
    //   349: astore 4
    //   351: aload 7
    //   353: aload 6
    //   355: aload 6
    //   357: ldc 168
    //   359: invokeinterface 259 2 0
    //   364: invokeinterface 267 2 0
    //   369: putfield 170	bdnk:jdField_a_of_type_Int	I
    //   372: aload 6
    //   374: astore_3
    //   375: aload 6
    //   377: astore 4
    //   379: aload 7
    //   381: aload 6
    //   383: aload 6
    //   385: ldc 172
    //   387: invokeinterface 259 2 0
    //   392: invokeinterface 263 2 0
    //   397: putfield 174	bdnk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   400: aload 6
    //   402: astore_3
    //   403: aload 6
    //   405: astore 4
    //   407: aload 7
    //   409: aload 6
    //   411: aload 6
    //   413: ldc 130
    //   415: invokeinterface 259 2 0
    //   420: invokeinterface 267 2 0
    //   425: putfield 134	bdnk:jdField_d_of_type_Int	I
    //   428: aload 6
    //   430: astore_3
    //   431: aload 6
    //   433: astore 4
    //   435: aload 7
    //   437: aload 6
    //   439: aload 6
    //   441: ldc 101
    //   443: invokeinterface 259 2 0
    //   448: invokeinterface 263 2 0
    //   453: putfield 106	bdnk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   456: aload 6
    //   458: astore_3
    //   459: aload 6
    //   461: astore 4
    //   463: aload 7
    //   465: aload 6
    //   467: aload 6
    //   469: ldc 176
    //   471: invokeinterface 259 2 0
    //   476: invokeinterface 267 2 0
    //   481: putfield 178	bdnk:jdField_c_of_type_Int	I
    //   484: aload 6
    //   486: astore_3
    //   487: aload 6
    //   489: astore 4
    //   491: aload_1
    //   492: aload 7
    //   494: getfield 106	bdnk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   497: aload 7
    //   499: invokevirtual 272	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   502: pop
    //   503: aload 6
    //   505: astore_3
    //   506: aload 6
    //   508: astore 4
    //   510: aload 6
    //   512: invokeinterface 275 1 0
    //   517: istore_2
    //   518: iload_2
    //   519: ifne -443 -> 76
    //   522: aload 6
    //   524: ifnull +10 -> 534
    //   527: aload 6
    //   529: invokeinterface 276 1 0
    //   534: aload 5
    //   536: ifnull +8 -> 544
    //   539: aload 5
    //   541: invokevirtual 223	android/database/sqlite/SQLiteDatabase:close	()V
    //   544: return
    //   545: astore_3
    //   546: aconst_null
    //   547: astore_1
    //   548: ldc 70
    //   550: ldc_w 278
    //   553: aload_3
    //   554: invokestatic 228	bdht:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   557: aload 4
    //   559: ifnull +10 -> 569
    //   562: aload 4
    //   564: invokeinterface 276 1 0
    //   569: aload_1
    //   570: ifnull -26 -> 544
    //   573: aload_1
    //   574: invokevirtual 223	android/database/sqlite/SQLiteDatabase:close	()V
    //   577: return
    //   578: astore 5
    //   580: aconst_null
    //   581: astore_1
    //   582: aload_3
    //   583: ifnull +9 -> 592
    //   586: aload_3
    //   587: invokeinterface 276 1 0
    //   592: aload_1
    //   593: ifnull +7 -> 600
    //   596: aload_1
    //   597: invokevirtual 223	android/database/sqlite/SQLiteDatabase:close	()V
    //   600: aload 5
    //   602: athrow
    //   603: astore 4
    //   605: aload 5
    //   607: astore_1
    //   608: aload 4
    //   610: astore 5
    //   612: goto -30 -> 582
    //   615: astore 5
    //   617: aload 4
    //   619: astore_3
    //   620: goto -38 -> 582
    //   623: astore_3
    //   624: aload 5
    //   626: astore_1
    //   627: goto -79 -> 548
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	this	bdnh
    //   0	630	1	paramConcurrentHashMap	java.util.concurrent.ConcurrentHashMap<String, bdnk>
    //   517	2	2	bool	boolean
    //   1	505	3	localObject1	Object
    //   545	42	3	localException1	Exception
    //   619	1	3	localObject2	Object
    //   623	1	3	localException2	Exception
    //   9	554	4	localCursor1	android.database.Cursor
    //   603	15	4	localObject3	Object
    //   15	525	5	localSQLiteDatabase	SQLiteDatabase
    //   578	28	5	localObject4	Object
    //   610	1	5	localObject5	Object
    //   615	10	5	localObject6	Object
    //   6	522	6	localCursor2	android.database.Cursor
    //   3	495	7	localbdnk	bdnk
    // Exception table:
    //   from	to	target	type
    //   11	17	545	java/lang/Exception
    //   11	17	578	finally
    //   24	39	603	finally
    //   51	61	603	finally
    //   68	76	603	finally
    //   83	92	603	finally
    //   99	120	603	finally
    //   127	148	603	finally
    //   155	176	603	finally
    //   183	204	603	finally
    //   211	232	603	finally
    //   239	260	603	finally
    //   267	288	603	finally
    //   295	316	603	finally
    //   323	344	603	finally
    //   351	372	603	finally
    //   379	400	603	finally
    //   407	428	603	finally
    //   435	456	603	finally
    //   463	484	603	finally
    //   491	503	603	finally
    //   510	518	603	finally
    //   548	557	615	finally
    //   24	39	623	java/lang/Exception
    //   51	61	623	java/lang/Exception
    //   68	76	623	java/lang/Exception
    //   83	92	623	java/lang/Exception
    //   99	120	623	java/lang/Exception
    //   127	148	623	java/lang/Exception
    //   155	176	623	java/lang/Exception
    //   183	204	623	java/lang/Exception
    //   211	232	623	java/lang/Exception
    //   239	260	623	java/lang/Exception
    //   267	288	623	java/lang/Exception
    //   295	316	623	java/lang/Exception
    //   323	344	623	java/lang/Exception
    //   351	372	623	java/lang/Exception
    //   379	400	623	java/lang/Exception
    //   407	428	623	java/lang/Exception
    //   435	456	623	java/lang/Exception
    //   463	484	623	java/lang/Exception
    //   491	503	623	java/lang/Exception
    //   510	518	623	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    bdht.a("PCPushDBHelper", "--> start--DatabaseHelper onCreate<<<<");
    paramSQLiteDatabase.execSQL("CREATE TABLE pcpush_package_info (key TEXT PRIMARY KEY,appid TEXT,via TEXT,pkgname TEXT,versioncode INTEGER,appname TEXT,appurl TEXT,iconurl TEXT,appsize TEXT,filetype TEXT,source TEXT,srciconurl TEXT,timestamp INTEGER,installstate INTEGER,downloadtype INTEGER);");
    bdht.a("PCPushDBHelper", "--> end--DatabaseHelper onCreate<<<<");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    bdht.c("PCPushDBHelper", "onDowngrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    bdht.c("PCPushDBHelper", "onUpgrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdnh
 * JD-Core Version:    0.7.0.1
 */