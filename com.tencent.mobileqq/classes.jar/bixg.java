import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.downloadnew.DownloadInfo;

public class bixg
  extends SQLiteOpenHelper
{
  protected static volatile bixg a;
  protected static final String a;
  protected static final byte[] a;
  public static final String[] a;
  protected long a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bixg.class.getName();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "appid", "download_url", "package", "push_title", "sendtime_col", "uin_col", "triggertime_col", "via_col", "patch_url", "update_type", "myappid_col", "apkid_col", "version_col", "downloadtype_col", "filepath_col", "source_col", "last_download_size", "is_apk", "myapp_download_from", "icon_url", "is_show_notification", "apk_writecode_state", "extra_info", "is_autoInstall_by_sdk", "download_file_md5", "download_file_size", "ext_param_id" };
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected bixg(Context paramContext)
  {
    super(paramContext, "app_plugin_download.db", null, 18);
  }
  
  public static bixg a()
  {
    try
    {
      if (jdField_a_of_type_Bixg == null) {
        jdField_a_of_type_Bixg = new bixg(biip.a().a());
      }
      if (jdField_a_of_type_Bixg.jdField_a_of_type_Long == 0L)
      {
        jdField_a_of_type_Bixg.jdField_a_of_type_Long = biip.a().a();
        if (jdField_a_of_type_Bixg.jdField_a_of_type_Long == 0L) {
          jdField_a_of_type_Bixg.jdField_a_of_type_Long = biip.a().b();
        }
      }
      bixg localbixg = jdField_a_of_type_Bixg;
      return localbixg;
    }
    finally {}
  }
  
  protected DownloadInfo a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getString(0);
    String str1 = paramCursor.getString(1);
    String str2 = paramCursor.getString(2);
    String str3 = paramCursor.getString(3);
    String str4 = paramCursor.getString(4);
    long l1 = paramCursor.getLong(6);
    String str5 = paramCursor.getString(7);
    String str6 = paramCursor.getString(8);
    int j = paramCursor.getInt(9);
    String str7 = paramCursor.getString(10);
    String str8 = paramCursor.getString(11);
    int k = paramCursor.getInt(12);
    int m = paramCursor.getInt(13);
    String str9 = paramCursor.getString(14);
    String str10 = paramCursor.getString(15);
    long l2 = paramCursor.getLong(16);
    boolean bool1;
    int n;
    String str11;
    int i1;
    int i;
    label213:
    String str12;
    if (paramCursor.getInt(17) == 1)
    {
      bool1 = true;
      n = paramCursor.getInt(18);
      str11 = paramCursor.getString(19);
      i1 = paramCursor.getInt(20);
      if (paramCursor.getInt(21) != 1) {
        break label335;
      }
      i = 0;
      str12 = paramCursor.getString(22);
      if (paramCursor.getInt(23) != 1) {
        break label347;
      }
    }
    label335:
    label347:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject = new DownloadInfo((String)localObject, str1, str2, str3, str4, l1, str5, str6, j, str7, str8, k, m, str9, str10, l2, bool1, n, str11, i1, i, str12, bool2, paramCursor.getString(24), paramCursor.getLong(25));
      ((DownloadInfo)localObject).y = paramCursor.getString(paramCursor.getColumnIndex("ext_param_id"));
      return localObject;
      bool1 = false;
      break;
      i = paramCursor.getInt(21);
      break label213;
    }
  }
  
  public DownloadInfo a(String paramString)
  {
    return a("package = ?", new String[] { paramString });
  }
  
  /* Error */
  protected DownloadInfo a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: getstatic 80	bixg:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore 7
    //   14: aload 7
    //   16: monitorenter
    //   17: aload_0
    //   18: invokevirtual 148	bixg:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 150
    //   25: getstatic 78	bixg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   28: aload_1
    //   29: aload_2
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 156	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_2
    //   37: aload 6
    //   39: astore_1
    //   40: aload_2
    //   41: invokeinterface 160 1 0
    //   46: ifle +16 -> 62
    //   49: aload_2
    //   50: invokeinterface 164 1 0
    //   55: pop
    //   56: aload_0
    //   57: aload_2
    //   58: invokevirtual 166	bixg:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   61: astore_1
    //   62: aload_2
    //   63: ifnull +9 -> 72
    //   66: aload_2
    //   67: invokeinterface 169 1 0
    //   72: aload_1
    //   73: astore_2
    //   74: aload_3
    //   75: ifnull +9 -> 84
    //   78: aload_3
    //   79: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   82: aload_1
    //   83: astore_2
    //   84: aload 7
    //   86: monitorexit
    //   87: aload_2
    //   88: areturn
    //   89: astore_3
    //   90: aconst_null
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_1
    //   94: getstatic 20	bixg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: ldc 172
    //   99: aload_3
    //   100: invokestatic 178	bisy:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: ifnull +9 -> 113
    //   107: aload_2
    //   108: invokeinterface 169 1 0
    //   113: aload 4
    //   115: astore_2
    //   116: aload_1
    //   117: ifnull -33 -> 84
    //   120: aload_1
    //   121: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   124: aload 4
    //   126: astore_2
    //   127: goto -43 -> 84
    //   130: astore_1
    //   131: aload 7
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    //   136: astore_2
    //   137: aconst_null
    //   138: astore_1
    //   139: aload 5
    //   141: astore_3
    //   142: aload_3
    //   143: ifnull +9 -> 152
    //   146: aload_3
    //   147: invokeinterface 169 1 0
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   160: aload_2
    //   161: athrow
    //   162: astore_2
    //   163: aload_3
    //   164: astore_1
    //   165: aload 5
    //   167: astore_3
    //   168: goto -26 -> 142
    //   171: astore 5
    //   173: aload_2
    //   174: astore 4
    //   176: aload_3
    //   177: astore_1
    //   178: aload 5
    //   180: astore_2
    //   181: aload 4
    //   183: astore_3
    //   184: goto -42 -> 142
    //   187: astore 4
    //   189: aload_2
    //   190: astore_3
    //   191: aload 4
    //   193: astore_2
    //   194: goto -52 -> 142
    //   197: astore_2
    //   198: aload_3
    //   199: astore_1
    //   200: aload_2
    //   201: astore_3
    //   202: aconst_null
    //   203: astore_2
    //   204: goto -110 -> 94
    //   207: astore 5
    //   209: aload_3
    //   210: astore_1
    //   211: aload 5
    //   213: astore_3
    //   214: goto -120 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	bixg
    //   0	217	1	paramString	String
    //   0	217	2	paramArrayOfString	String[]
    //   21	58	3	localSQLiteDatabase	SQLiteDatabase
    //   89	11	3	localException1	Exception
    //   141	73	3	localObject1	Object
    //   1	181	4	arrayOfString	String[]
    //   187	5	4	localObject2	Object
    //   4	162	5	localObject3	Object
    //   171	8	5	localObject4	Object
    //   207	5	5	localException2	Exception
    //   7	31	6	localObject5	Object
    //   12	120	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	22	89	java/lang/Exception
    //   66	72	130	finally
    //   78	82	130	finally
    //   84	87	130	finally
    //   107	113	130	finally
    //   120	124	130	finally
    //   131	134	130	finally
    //   146	152	130	finally
    //   156	160	130	finally
    //   160	162	130	finally
    //   17	22	136	finally
    //   22	37	162	finally
    //   40	62	171	finally
    //   94	103	187	finally
    //   22	37	197	java/lang/Exception
    //   40	62	207	java/lang/Exception
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = biip.a().a();
      if (this.jdField_a_of_type_Long == 0L) {
        bisy.e(jdField_a_of_type_JavaLangString, "getUin() is empty!");
      }
    }
    return String.valueOf(this.jdField_a_of_type_Long);
  }
  
  /* Error */
  public java.util.Map<String, DownloadInfo> a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: getstatic 20	bixg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: ldc 191
    //   10: invokestatic 193	bisy:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: new 195	java/util/concurrent/ConcurrentHashMap
    //   16: dup
    //   17: invokespecial 197	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   20: astore 7
    //   22: getstatic 80	bixg:jdField_a_of_type_ArrayOfByte	[B
    //   25: astore 6
    //   27: aload 6
    //   29: monitorenter
    //   30: aload_0
    //   31: invokevirtual 148	bixg:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   34: astore_2
    //   35: aload_2
    //   36: ldc 150
    //   38: getstatic 78	bixg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 156	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 4
    //   51: aload 4
    //   53: invokeinterface 160 1 0
    //   58: ifle +105 -> 163
    //   61: aload 4
    //   63: invokeinterface 164 1 0
    //   68: pop
    //   69: aload 4
    //   71: iconst_0
    //   72: invokeinterface 116 2 0
    //   77: astore_3
    //   78: getstatic 20	bixg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   81: new 199	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   88: ldc 202
    //   90: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 193	bisy:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: aload 4
    //   106: invokevirtual 166	bixg:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   109: astore 5
    //   111: getstatic 20	bixg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   114: new 199	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   121: ldc 211
    //   123: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 5
    //   128: invokevirtual 212	com/tencent/open/downloadnew/DownloadInfo:toString	()Ljava/lang/String;
    //   131: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 193	bisy:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload 7
    //   142: aload_3
    //   143: aload 5
    //   145: invokeinterface 218 3 0
    //   150: pop
    //   151: aload 4
    //   153: invokeinterface 221 1 0
    //   158: istore_1
    //   159: iload_1
    //   160: ifne -91 -> 69
    //   163: aload 4
    //   165: ifnull +10 -> 175
    //   168: aload 4
    //   170: invokeinterface 169 1 0
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   183: aload 6
    //   185: monitorexit
    //   186: aload 7
    //   188: areturn
    //   189: astore 4
    //   191: aconst_null
    //   192: astore 5
    //   194: aload_3
    //   195: astore_2
    //   196: aload 5
    //   198: astore_3
    //   199: getstatic 20	bixg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   202: ldc 223
    //   204: aload 4
    //   206: invokestatic 178	bisy:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload_3
    //   210: ifnull +9 -> 219
    //   213: aload_3
    //   214: invokeinterface 169 1 0
    //   219: aload_2
    //   220: ifnull -37 -> 183
    //   223: aload_2
    //   224: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   227: goto -44 -> 183
    //   230: astore_2
    //   231: aload 6
    //   233: monitorexit
    //   234: aload_2
    //   235: athrow
    //   236: astore_3
    //   237: aconst_null
    //   238: astore 5
    //   240: aload 4
    //   242: astore_2
    //   243: aload 5
    //   245: astore 4
    //   247: aload 4
    //   249: ifnull +10 -> 259
    //   252: aload 4
    //   254: invokeinterface 169 1 0
    //   259: aload_2
    //   260: ifnull +7 -> 267
    //   263: aload_2
    //   264: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   267: aload_3
    //   268: athrow
    //   269: astore_3
    //   270: aconst_null
    //   271: astore 4
    //   273: goto -26 -> 247
    //   276: astore_3
    //   277: goto -30 -> 247
    //   280: astore 5
    //   282: aload_3
    //   283: astore 4
    //   285: aload 5
    //   287: astore_3
    //   288: goto -41 -> 247
    //   291: astore 4
    //   293: aconst_null
    //   294: astore_3
    //   295: goto -96 -> 199
    //   298: astore_3
    //   299: aload 4
    //   301: astore 5
    //   303: aload_3
    //   304: astore 4
    //   306: aload 5
    //   308: astore_3
    //   309: goto -110 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	bixg
    //   158	2	1	bool	boolean
    //   34	190	2	localObject1	Object
    //   230	5	2	localObject2	Object
    //   242	22	2	localException1	Exception
    //   4	210	3	localObject3	Object
    //   236	32	3	localObject4	Object
    //   269	1	3	localObject5	Object
    //   276	7	3	localObject6	Object
    //   287	8	3	localObject7	Object
    //   298	6	3	localException2	Exception
    //   308	1	3	localObject8	Object
    //   1	168	4	localCursor	Cursor
    //   189	52	4	localException3	Exception
    //   245	39	4	localObject9	Object
    //   291	9	4	localException4	Exception
    //   304	1	4	localObject10	Object
    //   109	135	5	localDownloadInfo	DownloadInfo
    //   280	6	5	localObject11	Object
    //   301	6	5	localException5	Exception
    //   25	207	6	arrayOfByte	byte[]
    //   20	167	7	localConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   30	35	189	java/lang/Exception
    //   168	175	230	finally
    //   179	183	230	finally
    //   183	186	230	finally
    //   213	219	230	finally
    //   223	227	230	finally
    //   231	234	230	finally
    //   252	259	230	finally
    //   263	267	230	finally
    //   267	269	230	finally
    //   30	35	236	finally
    //   35	51	269	finally
    //   51	69	276	finally
    //   69	159	276	finally
    //   199	209	280	finally
    //   35	51	291	java/lang/Exception
    //   51	69	298	java/lang/Exception
    //   69	159	298	java/lang/Exception
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_info;");
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      onCreate(paramSQLiteDatabase);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 1;
    byte[] arrayOfByte = jdField_a_of_type_ArrayOfByte;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("appid", paramDownloadInfo.jdField_c_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("download_url", paramDownloadInfo.jdField_d_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("package", paramDownloadInfo.e);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("push_title", paramDownloadInfo.f);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("sendtime_col", paramDownloadInfo.g);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("uin_col", a());
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("triggertime_col", Long.valueOf(paramDownloadInfo.jdField_a_of_type_Long));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("via_col", paramDownloadInfo.jdField_h_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("patch_url", paramDownloadInfo.jdField_i_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("update_type", Integer.valueOf(paramDownloadInfo.jdField_a_of_type_Int));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("myappid_col", paramDownloadInfo.jdField_j_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("apkid_col", paramDownloadInfo.k);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("version_col", Integer.valueOf(paramDownloadInfo.jdField_b_of_type_Int));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("downloadtype_col", Integer.valueOf(paramDownloadInfo.jdField_c_of_type_Int));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("filepath_col", paramDownloadInfo.l);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("source_col", paramDownloadInfo.m);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("last_download_size", Long.valueOf(paramDownloadInfo.jdField_b_of_type_Long));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (paramDownloadInfo.jdField_c_of_type_Boolean)
        {
          i = 1;
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("is_apk", Integer.valueOf(i));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("myapp_download_from", Integer.valueOf(paramDownloadInfo.jdField_h_of_type_Int));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("icon_url", paramDownloadInfo.n);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("is_show_notification", Integer.valueOf(paramDownloadInfo.jdField_i_of_type_Int));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (paramDownloadInfo.jdField_j_of_type_Int != 0) {
            continue;
          }
          i = 1;
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("apk_writecode_state", Integer.valueOf(i));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("extra_info", paramDownloadInfo.o);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (!paramDownloadInfo.jdField_d_of_type_Boolean) {
            continue;
          }
          i = j;
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("is_autoInstall_by_sdk", Integer.valueOf(i));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("download_file_md5", paramDownloadInfo.p);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("download_file_size", Long.valueOf(paramDownloadInfo.jdField_d_of_type_Long));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("ext_param_id", paramDownloadInfo.y);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          i = localSQLiteDatabase.update("download_info", localContentValues, "appid = ?", new String[] { paramDownloadInfo.jdField_c_of_type_JavaLangString });
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          bisy.a(jdField_a_of_type_JavaLangString, "addDownloadInfo>>>update affected rowNum=" + i);
          if (i == 0)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            long l = localSQLiteDatabase.insert("download_info", null, localContentValues);
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            bisy.a(jdField_a_of_type_JavaLangString, "addDownloadInfo>>>insert rowID = " + l);
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localSQLiteDatabase.setTransactionSuccessful();
        }
      }
      catch (Exception paramDownloadInfo)
      {
        SQLiteDatabase localSQLiteDatabase;
        int i;
        localObject2 = localObject1;
        bisy.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", paramDownloadInfo);
        if (localObject1 == null) {
          continue;
        }
        try
        {
          localObject1.endTransaction();
          localObject1.close();
        }
        catch (Exception paramDownloadInfo)
        {
          bisy.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", paramDownloadInfo);
        }
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          break label906;
        }
      }
      try
      {
        localSQLiteDatabase.endTransaction();
        localSQLiteDatabase.close();
        return;
        i = 0;
        continue;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        i = paramDownloadInfo.jdField_j_of_type_Int;
        continue;
        i = 0;
      }
      catch (Exception paramDownloadInfo)
      {
        bisy.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", paramDownloadInfo);
      }
      finally {}
    }
    try
    {
      localObject2.endTransaction();
      localObject2.close();
      label906:
      throw paramDownloadInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bisy.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", localException);
      }
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: getstatic 80	bixg:jdField_a_of_type_ArrayOfByte	[B
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore_2
    //   12: aload_0
    //   13: invokevirtual 249	bixg:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 4
    //   18: aload 4
    //   20: astore_2
    //   21: aload 4
    //   23: astore_3
    //   24: getstatic 20	bixg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: new 199	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 361
    //   37: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iconst_1
    //   41: anewarray 22	java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: aload_1
    //   47: aastore
    //   48: invokestatic 366	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   51: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 193	bisy:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload 4
    //   62: astore_2
    //   63: aload 4
    //   65: astore_3
    //   66: aload 4
    //   68: ldc 150
    //   70: ldc_w 337
    //   73: iconst_1
    //   74: anewarray 22	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: invokevirtual 370	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   84: pop
    //   85: aload 4
    //   87: ifnull +8 -> 95
    //   90: aload 4
    //   92: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   95: aload 5
    //   97: monitorexit
    //   98: return
    //   99: astore_1
    //   100: aload_2
    //   101: astore_3
    //   102: getstatic 20	bixg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   105: ldc_w 372
    //   108: aload_1
    //   109: invokestatic 178	bisy:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_2
    //   113: ifnull -18 -> 95
    //   116: aload_2
    //   117: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   120: goto -25 -> 95
    //   123: astore_1
    //   124: aload 5
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: aload_3
    //   131: ifnull +7 -> 138
    //   134: aload_3
    //   135: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	bixg
    //   0	140	1	paramString	String
    //   11	106	2	localObject1	Object
    //   9	126	3	localObject2	Object
    //   16	75	4	localSQLiteDatabase	SQLiteDatabase
    //   3	122	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	18	99	java/lang/Exception
    //   24	60	99	java/lang/Exception
    //   66	85	99	java/lang/Exception
    //   90	95	123	finally
    //   95	98	123	finally
    //   116	120	123	finally
    //   124	127	123	finally
    //   134	138	123	finally
    //   138	140	123	finally
    //   12	18	129	finally
    //   24	60	129	finally
    //   66	85	129	finally
    //   102	112	129	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE download_info (appid TEXT PRIMARY KEY,download_url TEXT,package TEXT,push_title TEXT,sendtime_col TEXT,uin_col TEXT,triggertime_col INTEGER,via_col TEXT,patch_url TEXT,update_type INTEGER,myappid_col TEXT,apkid_col TEXT,version_col INTEGER,downloadtype_col INTEGER,filepath_col TEXT,source_col TEXT,last_download_size INTEGER,is_apk INTEGER,myapp_download_from INTEGER,icon_url TEXT,is_show_notification INTEGER,apk_writecode_state INTEGER,extra_info TEXT,is_autoInstall_by_sdk INTEGER,download_file_md5 TEXT,download_file_size INTEGER,ext_param_id TEXT); ");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    bisy.c(jdField_a_of_type_JavaLangString, "onDowngrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    bisy.c(jdField_a_of_type_JavaLangString, "onUpgrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixg
 * JD-Core Version:    0.7.0.1
 */