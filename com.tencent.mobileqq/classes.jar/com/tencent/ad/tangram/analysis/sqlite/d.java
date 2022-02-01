package com.tencent.ad.tangram.analysis.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import java.util.Iterator;
import java.util.List;

public class d
{
  private static final String TAG = "AdAnalysisSQLiteUtil";
  
  public static boolean delete(Context paramContext, List<b> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      paramList = "";
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((localb != null) && (localb.isValid()))
        {
          Object localObject = paramList;
          if (!TextUtils.isEmpty(paramList))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramList);
            ((StringBuilder)localObject).append(",");
            localObject = ((StringBuilder)localObject).toString();
          }
          paramList = new StringBuilder();
          paramList.append((String)localObject);
          paramList.append(String.format("'%s'", new Object[] { localb.uuid }));
          paramList = paramList.toString();
        }
        else
        {
          AdLog.e("AdAnalysisSQLiteUtil", "delete error");
        }
      }
      if (TextUtils.isEmpty(paramList))
      {
        AdLog.e("AdAnalysisSQLiteUtil", "delete error");
        return false;
      }
      try
      {
        paramContext = c.getInstance(paramContext);
        if (paramContext == null)
        {
          AdLog.e("AdAnalysisSQLiteUtil", "delete error, helper is null");
          return false;
        }
        paramContext = paramContext.getWritableDatabase();
        if (paramContext == null)
        {
          AdLog.e("AdAnalysisSQLiteUtil", "delete error, db is null");
          return false;
        }
        paramContext.execSQL(String.format("DELETE FROM %s WHERE %s IN (%s)", new Object[] { "gdt_analysis_table_v4", "uuid", paramList }));
        return true;
      }
      catch (Throwable paramContext)
      {
        AdLog.e("AdAnalysisSQLiteUtil", "delete error", paramContext);
        return false;
      }
    }
    AdLog.e("AdAnalysisSQLiteUtil", "delete error");
    return false;
  }
  
  public static void insert(Context paramContext, b paramb)
  {
    if ((paramb != null) && (paramb.isValid())) {}
    try
    {
      paramContext = c.getInstance(paramContext);
      if (paramContext == null)
      {
        AdLog.e("AdAnalysisSQLiteUtil", "insert error, helper is null");
        return;
      }
      paramContext = paramContext.getWritableDatabase();
      if (paramContext == null)
      {
        AdLog.e("AdAnalysisSQLiteUtil", "insert error, db is null");
        return;
      }
      if (paramContext.insertOrThrow("gdt_analysis_table_v4", null, paramb.getContentValues()) != -1L) {
        break label81;
      }
      AdLog.e("AdAnalysisSQLiteUtil", "insert error, rowId is -1");
      return;
    }
    catch (Throwable paramContext)
    {
      label74:
      break label74;
    }
    AdLog.e("AdAnalysisSQLiteUtil", "insert error");
    label81:
    return;
    AdLog.e("AdAnalysisSQLiteUtil", "insert error");
  }
  
  /* Error */
  public static List<b> query(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifgt +12 -> 13
    //   4: ldc 8
    //   6: ldc 134
    //   8: invokestatic 80	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aconst_null
    //   12: areturn
    //   13: aload_0
    //   14: invokestatic 86	com/tencent/ad/tangram/analysis/sqlite/c:getInstance	(Landroid/content/Context;)Lcom/tencent/ad/tangram/analysis/sqlite/c;
    //   17: astore_0
    //   18: aload_0
    //   19: ifnonnull +12 -> 31
    //   22: ldc 8
    //   24: ldc 136
    //   26: invokestatic 80	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aconst_null
    //   30: areturn
    //   31: aload_0
    //   32: invokevirtual 139	com/tencent/ad/tangram/analysis/sqlite/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnonnull +12 -> 49
    //   40: ldc 8
    //   42: ldc 141
    //   44: invokestatic 80	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aconst_null
    //   48: areturn
    //   49: aload_0
    //   50: ldc 143
    //   52: iconst_3
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: ldc 98
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: ldc 145
    //   65: aastore
    //   66: dup
    //   67: iconst_2
    //   68: iload_1
    //   69: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: aastore
    //   73: invokestatic 72	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   76: aconst_null
    //   77: invokevirtual 155	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore_3
    //   81: aload_3
    //   82: ifnonnull +24 -> 106
    //   85: aload_3
    //   86: astore_0
    //   87: ldc 8
    //   89: ldc 157
    //   91: invokestatic 80	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_3
    //   95: ifnull +9 -> 104
    //   98: aload_3
    //   99: invokeinterface 162 1 0
    //   104: aconst_null
    //   105: areturn
    //   106: aload_3
    //   107: astore_0
    //   108: aload_3
    //   109: invokeinterface 165 1 0
    //   114: istore_2
    //   115: iload_2
    //   116: ifne +15 -> 131
    //   119: aload_3
    //   120: ifnull +9 -> 129
    //   123: aload_3
    //   124: invokeinterface 162 1 0
    //   129: aconst_null
    //   130: areturn
    //   131: aload_3
    //   132: astore_0
    //   133: new 167	java/util/ArrayList
    //   136: dup
    //   137: invokespecial 168	java/util/ArrayList:<init>	()V
    //   140: astore 4
    //   142: aload_3
    //   143: astore_0
    //   144: new 40	com/tencent/ad/tangram/analysis/sqlite/b
    //   147: dup
    //   148: invokespecial 169	com/tencent/ad/tangram/analysis/sqlite/b:<init>	()V
    //   151: astore 5
    //   153: aload_3
    //   154: astore_0
    //   155: aload 5
    //   157: aload_3
    //   158: aload_3
    //   159: ldc 99
    //   161: invokeinterface 173 2 0
    //   166: invokeinterface 177 2 0
    //   171: putfield 66	com/tencent/ad/tangram/analysis/sqlite/b:uuid	Ljava/lang/String;
    //   174: aload_3
    //   175: astore_0
    //   176: aload 5
    //   178: aload_3
    //   179: aload_3
    //   180: ldc 179
    //   182: invokeinterface 173 2 0
    //   187: invokeinterface 183 2 0
    //   192: putfield 187	com/tencent/ad/tangram/analysis/sqlite/b:timeMillis	J
    //   195: aload_3
    //   196: astore_0
    //   197: aload 5
    //   199: aload_3
    //   200: aload_3
    //   201: ldc 145
    //   203: invokeinterface 173 2 0
    //   208: invokeinterface 191 2 0
    //   213: putfield 194	com/tencent/ad/tangram/analysis/sqlite/b:strategy	I
    //   216: aload_3
    //   217: astore_0
    //   218: aload 5
    //   220: aload_3
    //   221: aload_3
    //   222: ldc 196
    //   224: invokeinterface 173 2 0
    //   229: invokeinterface 177 2 0
    //   234: putfield 199	com/tencent/ad/tangram/analysis/sqlite/b:eventString	Ljava/lang/String;
    //   237: aload_3
    //   238: astore_0
    //   239: aload 4
    //   241: aload 5
    //   243: invokeinterface 203 2 0
    //   248: pop
    //   249: aload_3
    //   250: astore_0
    //   251: aload_3
    //   252: invokeinterface 206 1 0
    //   257: istore_2
    //   258: iload_2
    //   259: ifne -117 -> 142
    //   262: aload_3
    //   263: ifnull +9 -> 272
    //   266: aload_3
    //   267: invokeinterface 162 1 0
    //   272: aload 4
    //   274: areturn
    //   275: astore 4
    //   277: goto +16 -> 293
    //   280: astore_0
    //   281: aconst_null
    //   282: astore_3
    //   283: aload_0
    //   284: astore 4
    //   286: goto +34 -> 320
    //   289: astore 4
    //   291: aconst_null
    //   292: astore_3
    //   293: aload_3
    //   294: astore_0
    //   295: ldc 8
    //   297: ldc 207
    //   299: aload 4
    //   301: invokestatic 108	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   304: aload_3
    //   305: ifnull +9 -> 314
    //   308: aload_3
    //   309: invokeinterface 162 1 0
    //   314: aconst_null
    //   315: areturn
    //   316: astore 4
    //   318: aload_0
    //   319: astore_3
    //   320: aload_3
    //   321: ifnull +9 -> 330
    //   324: aload_3
    //   325: invokeinterface 162 1 0
    //   330: goto +6 -> 336
    //   333: aload 4
    //   335: athrow
    //   336: goto -3 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramContext	Context
    //   0	339	1	paramInt	int
    //   114	145	2	bool	boolean
    //   80	245	3	localObject1	Object
    //   140	133	4	localArrayList	java.util.ArrayList
    //   275	1	4	localThrowable1	Throwable
    //   284	1	4	localContext	Context
    //   289	11	4	localThrowable2	Throwable
    //   316	18	4	localObject2	Object
    //   151	91	5	localb	b
    // Exception table:
    //   from	to	target	type
    //   87	94	275	java/lang/Throwable
    //   108	115	275	java/lang/Throwable
    //   133	142	275	java/lang/Throwable
    //   144	153	275	java/lang/Throwable
    //   155	174	275	java/lang/Throwable
    //   176	195	275	java/lang/Throwable
    //   197	216	275	java/lang/Throwable
    //   218	237	275	java/lang/Throwable
    //   239	249	275	java/lang/Throwable
    //   251	258	275	java/lang/Throwable
    //   4	11	280	finally
    //   13	18	280	finally
    //   22	29	280	finally
    //   31	36	280	finally
    //   40	47	280	finally
    //   49	81	280	finally
    //   4	11	289	java/lang/Throwable
    //   13	18	289	java/lang/Throwable
    //   22	29	289	java/lang/Throwable
    //   31	36	289	java/lang/Throwable
    //   40	47	289	java/lang/Throwable
    //   49	81	289	java/lang/Throwable
    //   87	94	316	finally
    //   108	115	316	finally
    //   133	142	316	finally
    //   144	153	316	finally
    //   155	174	316	finally
    //   176	195	316	finally
    //   197	216	316	finally
    //   218	237	316	finally
    //   239	249	316	finally
    //   251	258	316	finally
    //   295	304	316	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.sqlite.d
 * JD-Core Version:    0.7.0.1
 */