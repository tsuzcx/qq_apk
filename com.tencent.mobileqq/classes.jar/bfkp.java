import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Arrays;
import java.util.List;

public class bfkp
  extends SQLiteOpenHelper
{
  private static volatile bfkp jdField_a_of_type_Bfkp;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "ticket", "open_appid", "download_url", "package_name", "push_title", "send_time", "uin", "trigger_time", "via", "patch_url", "update_type", "appid", "apkid", "version", "download_type", "filepath", "source", "last_download_size", "is_apk", "yyb_download_from", "icon_url", "is_show_notification", "apk_write_code_state", "extra_info", "is_autoInstall_by_sdk", "download_file_md5", "download_file_size", "download_state", "download_progress", "total_length", "recommend_id", "source_from_server", "channel_id", "page_id", "module_id", "position_id", "process_flag_id", "unique_id", "ext_param_id" };
  private long jdField_a_of_type_Long;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  
  private bfkp(Context paramContext)
  {
    super(paramContext, "open_appstore_db_DownloadInfoDB.db", null, 5);
  }
  
  private static int a(Cursor paramCursor, String paramString)
  {
    if ((paramCursor == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    return paramCursor.getColumnIndex(paramString);
  }
  
  public static bfkp a()
  {
    if (jdField_a_of_type_Bfkp == null) {}
    try
    {
      if (jdField_a_of_type_Bfkp == null)
      {
        jdField_a_of_type_Bfkp = new bfkp(bfbm.a().a());
        jdField_a_of_type_Bfkp.a();
      }
      return jdField_a_of_type_Bfkp;
    }
    finally {}
  }
  
  private DownloadInfo a(Cursor paramCursor)
  {
    boolean bool2 = true;
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_b_of_type_JavaLangString = paramCursor.getString(a(paramCursor, "ticket"));
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramCursor.getString(a(paramCursor, "open_appid"));
    localDownloadInfo.jdField_d_of_type_JavaLangString = paramCursor.getString(a(paramCursor, "download_url"));
    localDownloadInfo.e = paramCursor.getString(a(paramCursor, "package_name"));
    localDownloadInfo.jdField_f_of_type_JavaLangString = paramCursor.getString(a(paramCursor, "push_title"));
    localDownloadInfo.g = paramCursor.getString(a(paramCursor, "send_time"));
    localDownloadInfo.jdField_a_of_type_Long = paramCursor.getLong(a(paramCursor, "trigger_time"));
    localDownloadInfo.jdField_h_of_type_JavaLangString = paramCursor.getString(a(paramCursor, "via"));
    localDownloadInfo.jdField_i_of_type_JavaLangString = paramCursor.getString(a(paramCursor, "patch_url"));
    localDownloadInfo.jdField_a_of_type_Int = paramCursor.getInt(a(paramCursor, "update_type"));
    localDownloadInfo.jdField_j_of_type_JavaLangString = paramCursor.getString(a(paramCursor, "appid"));
    localDownloadInfo.k = paramCursor.getString(a(paramCursor, "apkid"));
    localDownloadInfo.jdField_b_of_type_Int = paramCursor.getInt(a(paramCursor, "version"));
    localDownloadInfo.jdField_c_of_type_Int = paramCursor.getInt(a(paramCursor, "download_type"));
    localDownloadInfo.l = paramCursor.getString(a(paramCursor, "filepath"));
    localDownloadInfo.m = paramCursor.getString(a(paramCursor, "source"));
    localDownloadInfo.jdField_b_of_type_Long = paramCursor.getLong(a(paramCursor, "last_download_size"));
    if (paramCursor.getInt(a(paramCursor, "is_apk")) == 1)
    {
      bool1 = true;
      localDownloadInfo.jdField_c_of_type_Boolean = bool1;
      localDownloadInfo.jdField_h_of_type_Int = paramCursor.getInt(a(paramCursor, "yyb_download_from"));
      localDownloadInfo.n = paramCursor.getString(a(paramCursor, "icon_url"));
      localDownloadInfo.jdField_i_of_type_Int = paramCursor.getInt(a(paramCursor, "is_show_notification"));
      localDownloadInfo.jdField_j_of_type_Int = paramCursor.getInt(a(paramCursor, "apk_write_code_state"));
      if (localDownloadInfo.jdField_j_of_type_Int == 1) {
        localDownloadInfo.jdField_j_of_type_Int = 0;
      }
      localDownloadInfo.o = paramCursor.getString(a(paramCursor, "extra_info"));
      if (paramCursor.getInt(a(paramCursor, "is_autoInstall_by_sdk")) != 1) {
        break label694;
      }
    }
    label694:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localDownloadInfo.jdField_d_of_type_Boolean = bool1;
      localDownloadInfo.p = paramCursor.getString(a(paramCursor, "download_file_md5"));
      localDownloadInfo.jdField_d_of_type_Long = paramCursor.getLong(a(paramCursor, "download_file_size"));
      localDownloadInfo.a(paramCursor.getInt(a(paramCursor, "download_state")));
      localDownloadInfo.jdField_f_of_type_Int = paramCursor.getInt(a(paramCursor, "download_progress"));
      localDownloadInfo.jdField_c_of_type_Long = paramCursor.getLong(a(paramCursor, "total_length"));
      localDownloadInfo.q = paramCursor.getString(a(paramCursor, "recommend_id"));
      localDownloadInfo.r = paramCursor.getString(a(paramCursor, "source_from_server"));
      localDownloadInfo.s = paramCursor.getString(a(paramCursor, "channel_id"));
      localDownloadInfo.t = paramCursor.getString(a(paramCursor, "page_id"));
      localDownloadInfo.u = paramCursor.getString(a(paramCursor, "module_id"));
      localDownloadInfo.v = paramCursor.getString(a(paramCursor, "position_id"));
      localDownloadInfo.w = paramCursor.getString(a(paramCursor, "process_flag_id"));
      localDownloadInfo.x = paramCursor.getString(a(paramCursor, "unique_id"));
      localDownloadInfo.y = paramCursor.getString(a(paramCursor, "ext_param_id"));
      return localDownloadInfo;
      bool1 = false;
      break;
    }
  }
  
  /* Error */
  private DownloadInfo a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 107	bfkp:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   13: astore 7
    //   15: aload 7
    //   17: monitorenter
    //   18: aload_0
    //   19: invokevirtual 264	bfkp:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore_3
    //   23: aload_3
    //   24: ldc_w 266
    //   27: getstatic 93	bfkp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   30: aload_1
    //   31: aload_2
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 272	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_2
    //   39: aload 6
    //   41: astore_1
    //   42: aload_2
    //   43: invokeinterface 276 1 0
    //   48: ifle +16 -> 64
    //   51: aload_2
    //   52: invokeinterface 280 1 0
    //   57: pop
    //   58: aload_0
    //   59: aload_2
    //   60: invokespecial 282	bfkp:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +9 -> 74
    //   68: aload_2
    //   69: invokeinterface 285 1 0
    //   74: aload_1
    //   75: astore_2
    //   76: aload_3
    //   77: ifnull +9 -> 86
    //   80: aload_3
    //   81: invokevirtual 286	android/database/sqlite/SQLiteDatabase:close	()V
    //   84: aload_1
    //   85: astore_2
    //   86: aload 7
    //   88: monitorexit
    //   89: aload_2
    //   90: areturn
    //   91: astore_3
    //   92: aconst_null
    //   93: astore_2
    //   94: aconst_null
    //   95: astore_1
    //   96: ldc_w 288
    //   99: ldc_w 290
    //   102: aload_3
    //   103: invokestatic 295	bflp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_2
    //   107: ifnull +9 -> 116
    //   110: aload_2
    //   111: invokeinterface 285 1 0
    //   116: aload 4
    //   118: astore_2
    //   119: aload_1
    //   120: ifnull -34 -> 86
    //   123: aload_1
    //   124: invokevirtual 286	android/database/sqlite/SQLiteDatabase:close	()V
    //   127: aload 4
    //   129: astore_2
    //   130: goto -44 -> 86
    //   133: astore_1
    //   134: aload 7
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_1
    //   142: aload 5
    //   144: astore_3
    //   145: aload_3
    //   146: ifnull +9 -> 155
    //   149: aload_3
    //   150: invokeinterface 285 1 0
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 286	android/database/sqlite/SQLiteDatabase:close	()V
    //   163: aload_2
    //   164: athrow
    //   165: astore_2
    //   166: aload_3
    //   167: astore_1
    //   168: aload 5
    //   170: astore_3
    //   171: goto -26 -> 145
    //   174: astore 5
    //   176: aload_2
    //   177: astore 4
    //   179: aload_3
    //   180: astore_1
    //   181: aload 5
    //   183: astore_2
    //   184: aload 4
    //   186: astore_3
    //   187: goto -42 -> 145
    //   190: astore 4
    //   192: aload_2
    //   193: astore_3
    //   194: aload 4
    //   196: astore_2
    //   197: goto -52 -> 145
    //   200: astore_2
    //   201: aload_3
    //   202: astore_1
    //   203: aload_2
    //   204: astore_3
    //   205: aconst_null
    //   206: astore_2
    //   207: goto -111 -> 96
    //   210: astore 5
    //   212: aload_3
    //   213: astore_1
    //   214: aload 5
    //   216: astore_3
    //   217: goto -121 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	bfkp
    //   0	220	1	paramString	String
    //   0	220	2	paramArrayOfString	String[]
    //   22	59	3	localSQLiteDatabase	SQLiteDatabase
    //   91	12	3	localException1	Exception
    //   144	73	3	localObject1	Object
    //   1	184	4	arrayOfString	String[]
    //   190	5	4	localObject2	Object
    //   4	165	5	localObject3	Object
    //   174	8	5	localObject4	Object
    //   210	5	5	localException2	Exception
    //   7	33	6	localObject5	Object
    //   13	122	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   18	23	91	java/lang/Exception
    //   68	74	133	finally
    //   80	84	133	finally
    //   86	89	133	finally
    //   110	116	133	finally
    //   123	127	133	finally
    //   134	137	133	finally
    //   149	155	133	finally
    //   159	163	133	finally
    //   163	165	133	finally
    //   18	23	139	finally
    //   23	39	165	finally
    //   42	64	174	finally
    //   96	106	190	finally
    //   23	39	200	java/lang/Exception
    //   42	64	210	java/lang/Exception
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = bfbm.a().a();
      if (this.jdField_a_of_type_Long == 0L) {
        bflp.e("DownloadInfoDB", "getUin() is empty!");
      }
    }
    return String.valueOf(this.jdField_a_of_type_Long);
  }
  
  /* Error */
  private List<DownloadInfo> a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 312	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 313	java/util/ArrayList:<init>	()V
    //   13: astore 8
    //   15: aload_0
    //   16: getfield 107	bfkp:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   19: astore 7
    //   21: aload 7
    //   23: monitorenter
    //   24: aload_0
    //   25: invokevirtual 264	bfkp:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   28: astore 4
    //   30: aload 4
    //   32: ldc_w 266
    //   35: getstatic 93	bfkp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   38: aload_1
    //   39: aload_2
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 272	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: aload_1
    //   48: invokeinterface 276 1 0
    //   53: ifle +34 -> 87
    //   56: aload_1
    //   57: invokeinterface 280 1 0
    //   62: pop
    //   63: aload 8
    //   65: aload_0
    //   66: aload_1
    //   67: invokespecial 282	bfkp:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   70: invokeinterface 319 2 0
    //   75: pop
    //   76: aload_1
    //   77: invokeinterface 322 1 0
    //   82: istore_3
    //   83: iload_3
    //   84: ifne -21 -> 63
    //   87: aload_1
    //   88: ifnull +9 -> 97
    //   91: aload_1
    //   92: invokeinterface 285 1 0
    //   97: aload 4
    //   99: ifnull +8 -> 107
    //   102: aload 4
    //   104: invokevirtual 286	android/database/sqlite/SQLiteDatabase:close	()V
    //   107: aload 7
    //   109: monitorexit
    //   110: ldc_w 288
    //   113: new 324	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 327
    //   123: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 8
    //   128: invokeinterface 334 1 0
    //   133: invokevirtual 337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 342	bflp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload 8
    //   144: areturn
    //   145: astore 4
    //   147: aconst_null
    //   148: astore_2
    //   149: aload 5
    //   151: astore_1
    //   152: ldc_w 288
    //   155: ldc_w 344
    //   158: aload 4
    //   160: invokestatic 295	bflp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload_2
    //   164: ifnull +9 -> 173
    //   167: aload_2
    //   168: invokeinterface 285 1 0
    //   173: aload_1
    //   174: ifnull -67 -> 107
    //   177: aload_1
    //   178: invokevirtual 286	android/database/sqlite/SQLiteDatabase:close	()V
    //   181: goto -74 -> 107
    //   184: astore_1
    //   185: aload 7
    //   187: monitorexit
    //   188: aload_1
    //   189: athrow
    //   190: astore_2
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 6
    //   196: astore_1
    //   197: aload 4
    //   199: ifnull +10 -> 209
    //   202: aload 4
    //   204: invokeinterface 285 1 0
    //   209: aload_1
    //   210: ifnull +7 -> 217
    //   213: aload_1
    //   214: invokevirtual 286	android/database/sqlite/SQLiteDatabase:close	()V
    //   217: aload_2
    //   218: athrow
    //   219: astore_2
    //   220: aconst_null
    //   221: astore 5
    //   223: aload 4
    //   225: astore_1
    //   226: aload 5
    //   228: astore 4
    //   230: goto -33 -> 197
    //   233: astore_2
    //   234: aload 4
    //   236: astore 5
    //   238: aload_1
    //   239: astore 4
    //   241: aload 5
    //   243: astore_1
    //   244: goto -47 -> 197
    //   247: astore 5
    //   249: aload_2
    //   250: astore 4
    //   252: aload 5
    //   254: astore_2
    //   255: goto -58 -> 197
    //   258: astore 5
    //   260: aconst_null
    //   261: astore_2
    //   262: aload 4
    //   264: astore_1
    //   265: aload 5
    //   267: astore 4
    //   269: goto -117 -> 152
    //   272: astore_2
    //   273: aload 4
    //   275: astore 5
    //   277: aload_2
    //   278: astore 4
    //   280: aload_1
    //   281: astore_2
    //   282: aload 5
    //   284: astore_1
    //   285: goto -133 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	bfkp
    //   0	288	1	paramString	String
    //   0	288	2	paramArrayOfString	String[]
    //   82	2	3	bool	boolean
    //   28	75	4	localSQLiteDatabase	SQLiteDatabase
    //   145	14	4	localException1	Exception
    //   192	87	4	localObject1	Object
    //   4	238	5	localObject2	Object
    //   247	6	5	localObject3	Object
    //   258	8	5	localException2	Exception
    //   275	8	5	localObject4	Object
    //   1	194	6	localObject5	Object
    //   19	167	7	localObject6	Object
    //   13	130	8	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   24	30	145	java/lang/Exception
    //   91	97	184	finally
    //   102	107	184	finally
    //   107	110	184	finally
    //   167	173	184	finally
    //   177	181	184	finally
    //   185	188	184	finally
    //   202	209	184	finally
    //   213	217	184	finally
    //   217	219	184	finally
    //   24	30	190	finally
    //   30	47	219	finally
    //   47	63	233	finally
    //   63	83	233	finally
    //   152	163	247	finally
    //   30	47	258	java/lang/Exception
    //   47	63	272	java/lang/Exception
    //   63	83	272	java/lang/Exception
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = bfbm.a().a();
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = bfbm.a().b();
      }
    }
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
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
  
  public DownloadInfo a(String paramString)
  {
    return a("ticket = ?", new String[] { paramString });
  }
  
  public List<DownloadInfo> a(String paramString)
  {
    return a("package_name = ?", new String[] { paramString });
  }
  
  /* Error */
  public java.util.concurrent.ConcurrentHashMap<String, DownloadInfo> a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: ldc_w 288
    //   8: ldc_w 382
    //   11: invokestatic 384	bflp:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 386	java/util/concurrent/ConcurrentHashMap
    //   17: dup
    //   18: invokespecial 387	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   21: astore 7
    //   23: aload_0
    //   24: getfield 107	bfkp:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   27: astore 6
    //   29: aload 6
    //   31: monitorenter
    //   32: aload_0
    //   33: invokevirtual 264	bfkp:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore_2
    //   37: aload_2
    //   38: ldc_w 266
    //   41: getstatic 93	bfkp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual 272	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore 4
    //   54: aload 4
    //   56: invokeinterface 276 1 0
    //   61: ifle +111 -> 172
    //   64: aload 4
    //   66: invokeinterface 280 1 0
    //   71: pop
    //   72: aload 4
    //   74: aload 4
    //   76: ldc 15
    //   78: invokestatic 141	bfkp:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   81: invokeinterface 145 2 0
    //   86: astore_3
    //   87: ldc_w 288
    //   90: new 324	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 389
    //   100: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_3
    //   104: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 384	bflp:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: aload 4
    //   116: invokespecial 282	bfkp:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   119: astore 5
    //   121: ldc_w 288
    //   124: new 324	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 391
    //   134: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 5
    //   139: invokevirtual 392	com/tencent/open/downloadnew/DownloadInfo:toString	()Ljava/lang/String;
    //   142: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 384	bflp:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload 7
    //   153: aload_3
    //   154: aload 5
    //   156: invokevirtual 396	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   159: pop
    //   160: aload 4
    //   162: invokeinterface 322 1 0
    //   167: istore_1
    //   168: iload_1
    //   169: ifne -97 -> 72
    //   172: aload 4
    //   174: ifnull +10 -> 184
    //   177: aload 4
    //   179: invokeinterface 285 1 0
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 286	android/database/sqlite/SQLiteDatabase:close	()V
    //   192: aload 6
    //   194: monitorexit
    //   195: aload 7
    //   197: areturn
    //   198: astore 4
    //   200: aconst_null
    //   201: astore 5
    //   203: aload_3
    //   204: astore_2
    //   205: aload 5
    //   207: astore_3
    //   208: ldc_w 288
    //   211: ldc_w 398
    //   214: aload 4
    //   216: invokestatic 295	bflp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload_3
    //   220: ifnull +9 -> 229
    //   223: aload_3
    //   224: invokeinterface 285 1 0
    //   229: aload_2
    //   230: ifnull -38 -> 192
    //   233: aload_2
    //   234: invokevirtual 286	android/database/sqlite/SQLiteDatabase:close	()V
    //   237: goto -45 -> 192
    //   240: astore_2
    //   241: aload 6
    //   243: monitorexit
    //   244: aload_2
    //   245: athrow
    //   246: astore_3
    //   247: aconst_null
    //   248: astore 5
    //   250: aload 4
    //   252: astore_2
    //   253: aload 5
    //   255: astore 4
    //   257: aload 4
    //   259: ifnull +10 -> 269
    //   262: aload 4
    //   264: invokeinterface 285 1 0
    //   269: aload_2
    //   270: ifnull +7 -> 277
    //   273: aload_2
    //   274: invokevirtual 286	android/database/sqlite/SQLiteDatabase:close	()V
    //   277: aload_3
    //   278: athrow
    //   279: astore_3
    //   280: aconst_null
    //   281: astore 4
    //   283: goto -26 -> 257
    //   286: astore_3
    //   287: goto -30 -> 257
    //   290: astore 5
    //   292: aload_3
    //   293: astore 4
    //   295: aload 5
    //   297: astore_3
    //   298: goto -41 -> 257
    //   301: astore 4
    //   303: aconst_null
    //   304: astore_3
    //   305: goto -97 -> 208
    //   308: astore_3
    //   309: aload 4
    //   311: astore 5
    //   313: aload_3
    //   314: astore 4
    //   316: aload 5
    //   318: astore_3
    //   319: goto -111 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	bfkp
    //   167	2	1	bool	boolean
    //   36	198	2	localObject1	Object
    //   240	5	2	localObject2	Object
    //   252	22	2	localException1	Exception
    //   4	220	3	localObject3	Object
    //   246	32	3	localObject4	Object
    //   279	1	3	localObject5	Object
    //   286	7	3	localObject6	Object
    //   297	8	3	localObject7	Object
    //   308	6	3	localException2	Exception
    //   318	1	3	localObject8	Object
    //   1	177	4	localCursor	Cursor
    //   198	53	4	localException3	Exception
    //   255	39	4	localObject9	Object
    //   301	9	4	localException4	Exception
    //   314	1	4	localObject10	Object
    //   119	135	5	localDownloadInfo	DownloadInfo
    //   290	6	5	localObject11	Object
    //   311	6	5	localException5	Exception
    //   27	215	6	localObject12	Object
    //   21	175	7	localConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   32	37	198	java/lang/Exception
    //   177	184	240	finally
    //   188	192	240	finally
    //   192	195	240	finally
    //   223	229	240	finally
    //   233	237	240	finally
    //   241	244	240	finally
    //   262	269	240	finally
    //   273	277	240	finally
    //   277	279	240	finally
    //   32	37	246	finally
    //   37	54	279	finally
    //   54	72	286	finally
    //   72	168	286	finally
    //   208	219	290	finally
    //   37	54	301	java/lang/Exception
    //   54	72	308	java/lang/Exception
    //   72	168	308	java/lang/Exception
  }
  
  public void a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 1;
    Object localObject3 = this.jdField_a_of_type_JavaLangObject;
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
        localContentValues.put("ticket", paramDownloadInfo.jdField_b_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("open_appid", paramDownloadInfo.jdField_c_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("download_url", paramDownloadInfo.jdField_d_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("package_name", paramDownloadInfo.e);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("push_title", paramDownloadInfo.jdField_f_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("send_time", paramDownloadInfo.g);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("uin", a());
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("trigger_time", Long.valueOf(paramDownloadInfo.jdField_a_of_type_Long));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("via", paramDownloadInfo.jdField_h_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("patch_url", paramDownloadInfo.jdField_i_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("update_type", Integer.valueOf(paramDownloadInfo.jdField_a_of_type_Int));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("appid", paramDownloadInfo.jdField_j_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("apkid", paramDownloadInfo.k);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("version", Integer.valueOf(paramDownloadInfo.jdField_b_of_type_Int));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("download_type", Integer.valueOf(paramDownloadInfo.jdField_c_of_type_Int));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("filepath", paramDownloadInfo.l);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("source", paramDownloadInfo.m);
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
          localContentValues.put("yyb_download_from", Integer.valueOf(paramDownloadInfo.jdField_h_of_type_Int));
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
          localContentValues.put("apk_write_code_state", Integer.valueOf(i));
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
          localContentValues.put("download_state", Integer.valueOf(paramDownloadInfo.a()));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("download_progress", Integer.valueOf(paramDownloadInfo.jdField_f_of_type_Int));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("total_length", Long.valueOf(paramDownloadInfo.jdField_c_of_type_Long));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("recommend_id", paramDownloadInfo.q);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("source_from_server", paramDownloadInfo.r);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("channel_id", paramDownloadInfo.s);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("page_id", paramDownloadInfo.t);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("module_id", paramDownloadInfo.u);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("position_id", paramDownloadInfo.v);
          if (paramBoolean)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            localContentValues.put("process_flag_id", paramDownloadInfo.w);
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("unique_id", paramDownloadInfo.x);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("ext_param_id", paramDownloadInfo.y);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          i = localSQLiteDatabase.update("download_info", localContentValues, "ticket = ?", new String[] { paramDownloadInfo.jdField_b_of_type_JavaLangString });
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          bflp.a("DownloadInfoDB", "addDownloadInfo>>>update affected rowNum=" + i);
          if (i == 0)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            localContentValues.put("process_flag_id", paramDownloadInfo.w);
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            long l = localSQLiteDatabase.insert("download_info", null, localContentValues);
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            bflp.a("DownloadInfoDB", "addDownloadInfo>>>insert rowID = " + l);
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
        bflp.c("DownloadInfoDB", "addDownloadExceptionInfo>>>", paramDownloadInfo);
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
          bflp.c("DownloadInfoDB", "addDownloadExceptionInfo>>>", paramDownloadInfo);
        }
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          break label1171;
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
        bflp.c("DownloadInfoDB", "addDownloadExceptionInfo>>>", paramDownloadInfo);
      }
      finally {}
    }
    try
    {
      localObject2.endTransaction();
      localObject2.close();
      label1171:
      throw paramDownloadInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bflp.c("DownloadInfoDB", "addDownloadExceptionInfo>>>", localException);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bflp.e("DownloadInfoDB", "[deleteInfoByTicket] ticket is empty");
      return;
    }
    Object localObject3 = this.jdField_a_of_type_JavaLangObject;
    localObject2 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        bflp.c("DownloadInfoDB", "[deleteInfoByTicket]ticket = ?" + Arrays.toString(new String[] { paramString }));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.delete("download_info", "ticket = ?", new String[] { paramString });
        if (localSQLiteDatabase == null) {}
      }
      catch (Exception paramString)
      {
        SQLiteDatabase localSQLiteDatabase;
        localObject2 = localObject1;
        bflp.c("DownloadInfoDB", "[deleteInfoByTicket]>>>", paramString);
        if (localObject1 == null) {
          continue;
        }
        localObject1.close();
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        localObject2.close();
      }
      try
      {
        localSQLiteDatabase.close();
        return;
      }
      finally {}
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE download_info (ticket TEXT PRIMARY KEY,open_appid TEXT,download_url TEXT,package_name TEXT,push_title TEXT,send_time TEXT,uin TEXT,trigger_time INTEGER,via TEXT,patch_url TEXT,update_type INTEGER,appid TEXT,apkid TEXT,version INTEGER,download_type INTEGER,filepath TEXT,source TEXT,last_download_size INTEGER,is_apk INTEGER,yyb_download_from INTEGER,icon_url TEXT,is_show_notification INTEGER,apk_write_code_state INTEGER,extra_info TEXT,is_autoInstall_by_sdk INTEGER,download_file_md5 TEXT,download_file_size INTEGER,download_state INTEGER,download_progress INTEGER,total_length INTEGER,recommend_id TEXT,source_from_server TEXT,channel_id TEXT,page_id TEXT,module_id TEXT,position_id TEXT,process_flag_id TEXT,unique_id TEXT,ext_param_id TEXT); ");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    bflp.b("DownloadInfoDB", "onDowngrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    bflp.b("DownloadInfoDB", "onUpgrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfkp
 * JD-Core Version:    0.7.0.1
 */