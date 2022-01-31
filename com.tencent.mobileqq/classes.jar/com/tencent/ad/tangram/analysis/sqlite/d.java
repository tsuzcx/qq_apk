package com.tencent.ad.tangram.analysis.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.ad.tangram.analysis.sqlite.b;>;

public class d
{
  private static final String TAG = "AdAnalysisSQLiteUtil";
  
  public static boolean delete(Context paramContext, List<b> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AdLog.e("AdAnalysisSQLiteUtil", "delete error");
      return false;
    }
    Object localObject = "";
    Iterator localIterator = paramList.iterator();
    paramList = (List<b>)localObject;
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((localb == null) || (!localb.isValid()))
      {
        AdLog.e("AdAnalysisSQLiteUtil", "delete error");
      }
      else
      {
        localObject = paramList;
        if (!TextUtils.isEmpty(paramList)) {
          localObject = paramList + ",";
        }
        paramList = (String)localObject + String.format("'%s'", new Object[] { localb.uuid });
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
    }
    return false;
  }
  
  public static void insert(Context paramContext, b paramb)
  {
    if ((paramb == null) || (!paramb.isValid())) {
      AdLog.e("AdAnalysisSQLiteUtil", "insert error");
    }
    do
    {
      return;
      try
      {
        paramContext = c.getInstance(paramContext);
        if (paramContext == null)
        {
          AdLog.e("AdAnalysisSQLiteUtil", "insert error, helper is null");
          return;
        }
      }
      catch (Throwable paramContext)
      {
        AdLog.e("AdAnalysisSQLiteUtil", "insert error");
        return;
      }
      paramContext = paramContext.getWritableDatabase();
      if (paramContext == null)
      {
        AdLog.e("AdAnalysisSQLiteUtil", "insert error, db is null");
        return;
      }
    } while (paramContext.insertOrThrow("gdt_analysis_table_v4", null, paramb.getContentValues()) != -1L);
    AdLog.e("AdAnalysisSQLiteUtil", "insert error, rowId is -1");
  }
  
  /* Error */
  public static List<b> query(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifgt +24 -> 25
    //   4: ldc 8
    //   6: ldc 134
    //   8: invokestatic 31	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: iconst_0
    //   12: ifeq +11 -> 23
    //   15: new 136	java/lang/NullPointerException
    //   18: dup
    //   19: invokespecial 137	java/lang/NullPointerException:<init>	()V
    //   22: athrow
    //   23: aconst_null
    //   24: areturn
    //   25: aload_0
    //   26: invokestatic 86	com/tencent/ad/tangram/analysis/sqlite/c:getInstance	(Landroid/content/Context;)Lcom/tencent/ad/tangram/analysis/sqlite/c;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnonnull +22 -> 53
    //   34: ldc 8
    //   36: ldc 139
    //   38: invokestatic 31	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iconst_0
    //   42: ifeq -19 -> 23
    //   45: new 136	java/lang/NullPointerException
    //   48: dup
    //   49: invokespecial 137	java/lang/NullPointerException:<init>	()V
    //   52: athrow
    //   53: aload_0
    //   54: invokevirtual 142	com/tencent/ad/tangram/analysis/sqlite/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   57: astore_0
    //   58: aload_0
    //   59: ifnonnull +22 -> 81
    //   62: ldc 8
    //   64: ldc 144
    //   66: invokestatic 31	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: iconst_0
    //   70: ifeq -47 -> 23
    //   73: new 136	java/lang/NullPointerException
    //   76: dup
    //   77: invokespecial 137	java/lang/NullPointerException:<init>	()V
    //   80: athrow
    //   81: aload_0
    //   82: ldc 146
    //   84: iconst_3
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: ldc 98
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: ldc 148
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: iload_1
    //   101: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: invokestatic 80	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   108: aconst_null
    //   109: invokevirtual 158	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   112: astore_3
    //   113: aload_3
    //   114: ifnonnull +24 -> 138
    //   117: aload_3
    //   118: astore_0
    //   119: ldc 8
    //   121: ldc 160
    //   123: invokestatic 31	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_3
    //   127: ifnull -104 -> 23
    //   130: aload_3
    //   131: invokeinterface 165 1 0
    //   136: aconst_null
    //   137: areturn
    //   138: aload_3
    //   139: astore_0
    //   140: aload_3
    //   141: invokeinterface 168 1 0
    //   146: istore_2
    //   147: iload_2
    //   148: ifne +15 -> 163
    //   151: aload_3
    //   152: ifnull -129 -> 23
    //   155: aload_3
    //   156: invokeinterface 165 1 0
    //   161: aconst_null
    //   162: areturn
    //   163: aload_3
    //   164: astore_0
    //   165: new 170	java/util/ArrayList
    //   168: dup
    //   169: invokespecial 171	java/util/ArrayList:<init>	()V
    //   172: astore 4
    //   174: aload_3
    //   175: astore_0
    //   176: new 48	com/tencent/ad/tangram/analysis/sqlite/b
    //   179: dup
    //   180: invokespecial 172	com/tencent/ad/tangram/analysis/sqlite/b:<init>	()V
    //   183: astore 5
    //   185: aload_3
    //   186: astore_0
    //   187: aload 5
    //   189: aload_3
    //   190: aload_3
    //   191: ldc 99
    //   193: invokeinterface 176 2 0
    //   198: invokeinterface 180 2 0
    //   203: putfield 74	com/tencent/ad/tangram/analysis/sqlite/b:uuid	Ljava/lang/String;
    //   206: aload_3
    //   207: astore_0
    //   208: aload 5
    //   210: aload_3
    //   211: aload_3
    //   212: ldc 182
    //   214: invokeinterface 176 2 0
    //   219: invokeinterface 186 2 0
    //   224: putfield 190	com/tencent/ad/tangram/analysis/sqlite/b:timeMillis	J
    //   227: aload_3
    //   228: astore_0
    //   229: aload 5
    //   231: aload_3
    //   232: aload_3
    //   233: ldc 148
    //   235: invokeinterface 176 2 0
    //   240: invokeinterface 194 2 0
    //   245: putfield 197	com/tencent/ad/tangram/analysis/sqlite/b:strategy	I
    //   248: aload_3
    //   249: astore_0
    //   250: aload 5
    //   252: aload_3
    //   253: aload_3
    //   254: ldc 199
    //   256: invokeinterface 176 2 0
    //   261: invokeinterface 180 2 0
    //   266: putfield 202	com/tencent/ad/tangram/analysis/sqlite/b:eventString	Ljava/lang/String;
    //   269: aload_3
    //   270: astore_0
    //   271: aload 4
    //   273: aload 5
    //   275: invokeinterface 206 2 0
    //   280: pop
    //   281: aload_3
    //   282: astore_0
    //   283: aload_3
    //   284: invokeinterface 209 1 0
    //   289: istore_2
    //   290: iload_2
    //   291: ifne -117 -> 174
    //   294: aload_3
    //   295: ifnull +9 -> 304
    //   298: aload_3
    //   299: invokeinterface 165 1 0
    //   304: aload 4
    //   306: areturn
    //   307: astore 4
    //   309: aconst_null
    //   310: astore_3
    //   311: aload_3
    //   312: astore_0
    //   313: ldc 8
    //   315: ldc 210
    //   317: aload 4
    //   319: invokestatic 108	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   322: aload_3
    //   323: ifnull -300 -> 23
    //   326: aload_3
    //   327: invokeinterface 165 1 0
    //   332: aconst_null
    //   333: areturn
    //   334: astore_3
    //   335: aconst_null
    //   336: astore_0
    //   337: aload_0
    //   338: ifnull +9 -> 347
    //   341: aload_0
    //   342: invokeinterface 165 1 0
    //   347: aload_3
    //   348: athrow
    //   349: astore_3
    //   350: goto -13 -> 337
    //   353: astore 4
    //   355: goto -44 -> 311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramContext	Context
    //   0	358	1	paramInt	int
    //   146	145	2	bool	boolean
    //   112	215	3	localCursor	android.database.Cursor
    //   334	14	3	localObject1	Object
    //   349	1	3	localObject2	Object
    //   172	133	4	localArrayList	java.util.ArrayList
    //   307	11	4	localThrowable1	Throwable
    //   353	1	4	localThrowable2	Throwable
    //   183	91	5	localb	b
    // Exception table:
    //   from	to	target	type
    //   4	11	307	java/lang/Throwable
    //   25	30	307	java/lang/Throwable
    //   34	41	307	java/lang/Throwable
    //   53	58	307	java/lang/Throwable
    //   62	69	307	java/lang/Throwable
    //   81	113	307	java/lang/Throwable
    //   4	11	334	finally
    //   25	30	334	finally
    //   34	41	334	finally
    //   53	58	334	finally
    //   62	69	334	finally
    //   81	113	334	finally
    //   119	126	349	finally
    //   140	147	349	finally
    //   165	174	349	finally
    //   176	185	349	finally
    //   187	206	349	finally
    //   208	227	349	finally
    //   229	248	349	finally
    //   250	269	349	finally
    //   271	281	349	finally
    //   283	290	349	finally
    //   313	322	349	finally
    //   119	126	353	java/lang/Throwable
    //   140	147	353	java/lang/Throwable
    //   165	174	353	java/lang/Throwable
    //   176	185	353	java/lang/Throwable
    //   187	206	353	java/lang/Throwable
    //   208	227	353	java/lang/Throwable
    //   229	248	353	java/lang/Throwable
    //   250	269	353	java/lang/Throwable
    //   271	281	353	java/lang/Throwable
    //   283	290	353	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.analysis.sqlite.d
 * JD-Core Version:    0.7.0.1
 */