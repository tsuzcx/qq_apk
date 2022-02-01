package com.tencent.featuretoggle.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.models.FeatureTriggerEvent;
import com.tencent.featuretoggle.utils.AESHelper;
import com.tencent.featuretoggle.utils.LogUtils;
import com.tencent.featuretoggle.utils.TimeUtil;
import com.tencent.featuretoggle.utils.Utils;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.featuretoggle.models.FeatureTriggerEvent;>;

public class DBManager
{
  private static volatile DBManager b;
  private DBOpenHelper a = null;
  
  private DBManager()
  {
    if (ToggleSetting.j() == null) {
      return;
    }
    this.a = new DBOpenHelper(ToggleSetting.j());
  }
  
  public static DBManager a()
  {
    try
    {
      if (b == null) {
        try
        {
          if (b == null) {
            b = new DBManager();
          }
        }
        finally {}
      }
      DBManager localDBManager = b;
      return localDBManager;
    }
    finally {}
  }
  
  private ContentValues b(FeatureTriggerEvent paramFeatureTriggerEvent)
  {
    if (paramFeatureTriggerEvent != null)
    {
      if (Utils.a(paramFeatureTriggerEvent.sn)) {
        return null;
      }
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("_sn", AESHelper.a(paramFeatureTriggerEvent.getSn()));
        localContentValues.put("_vid", AESHelper.a(paramFeatureTriggerEvent.getFeatureVersionId()));
        localContentValues.put("_fn", AESHelper.a(paramFeatureTriggerEvent.getFeatureName()));
        localContentValues.put("_fv", AESHelper.a(paramFeatureTriggerEvent.getFeatureValue()));
        localContentValues.put("_uid", AESHelper.a(paramFeatureTriggerEvent.getUserId()));
        localContentValues.put("_abt", AESHelper.a(paramFeatureTriggerEvent.getAbTestId()));
        localContentValues.put("_dsid", AESHelper.a(paramFeatureTriggerEvent.getDatasetID()));
        localContentValues.put("_dsvid", AESHelper.a(paramFeatureTriggerEvent.getVersionID()));
        localContentValues.put("ct", AESHelper.a(TimeUtil.a()));
        return localContentValues;
      }
      catch (Throwable paramFeatureTriggerEvent)
      {
        if (!LogUtils.a(paramFeatureTriggerEvent)) {
          paramFeatureTriggerEvent.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public int a(List<FeatureTriggerEvent> paramList)
  {
    if (paramList != null) {
      try
      {
        if ((!paramList.isEmpty()) && (this.a != null))
        {
          SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
          if (localSQLiteDatabase == null) {
            return -1;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject = (FeatureTriggerEvent)paramList.next();
            localStringBuilder.append(" or ");
            localStringBuilder.append("( ");
            localStringBuilder.append("_vid");
            localStringBuilder.append("='");
            localStringBuilder.append(AESHelper.a(((FeatureTriggerEvent)localObject).getFeatureVersionId()));
            localStringBuilder.append("' and ");
            localStringBuilder.append("_fn");
            localStringBuilder.append("='");
            localStringBuilder.append(AESHelper.a(((FeatureTriggerEvent)localObject).getFeatureName()));
            localStringBuilder.append("' and ");
            localStringBuilder.append("_fv");
            localStringBuilder.append("='");
            localStringBuilder.append(AESHelper.a(((FeatureTriggerEvent)localObject).getFeatureValue()));
            localStringBuilder.append("' and ");
            localStringBuilder.append("_uid");
            localStringBuilder.append("='");
            localStringBuilder.append(AESHelper.a(((FeatureTriggerEvent)localObject).getUserId()));
            localStringBuilder.append("' and ");
            localStringBuilder.append("_abt");
            localStringBuilder.append("='");
            localStringBuilder.append(AESHelper.a(((FeatureTriggerEvent)localObject).getAbTestId()));
            localStringBuilder.append("' )");
          }
          Object localObject = localStringBuilder.toString();
          paramList = (List<FeatureTriggerEvent>)localObject;
          if (((String)localObject).length() > 0) {
            paramList = ((String)localObject).substring(4);
          }
          localStringBuilder.setLength(0);
          try
          {
            int i = localSQLiteDatabase.delete("t_f_e", paramList, null);
            LogUtils.e("[Database] deleted table %s data ,count %d", new Object[] { "t_f_e", Integer.valueOf(i) });
            return i;
          }
          catch (Throwable paramList)
          {
            if (!LogUtils.a(paramList)) {
              paramList.printStackTrace();
            }
            return -1;
          }
        }
      }
      finally {}
    }
    return -1;
  }
  
  public boolean a(FeatureTriggerEvent paramFeatureTriggerEvent)
  {
    if (paramFeatureTriggerEvent != null) {
      try
      {
        if (this.a != null)
        {
          SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
          if (localSQLiteDatabase == null) {
            return false;
          }
          paramFeatureTriggerEvent = b(paramFeatureTriggerEvent);
          if (paramFeatureTriggerEvent != null)
          {
            if (localSQLiteDatabase.replace("t_f_e", "_sn", paramFeatureTriggerEvent) >= 0L)
            {
              LogUtils.e("Insert table %s success!", new Object[] { "t_f_e" });
              return true;
            }
            return false;
          }
          return false;
        }
      }
      finally {}
    }
    return false;
  }
  
  /* Error */
  public java.util.ArrayList<FeatureTriggerEvent> b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/tencent/featuretoggle/db/DBManager:a	Lcom/tencent/featuretoggle/db/DBOpenHelper;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 16	com/tencent/featuretoggle/db/DBManager:a	Lcom/tencent/featuretoggle/db/DBOpenHelper;
    //   19: invokevirtual 123	com/tencent/featuretoggle/db/DBOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnonnull +7 -> 31
    //   27: aload_0
    //   28: monitorexit
    //   29: aconst_null
    //   30: areturn
    //   31: aload_3
    //   32: ldc 204
    //   34: aconst_null
    //   35: invokevirtual 208	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnonnull +26 -> 66
    //   43: aload_2
    //   44: ifnull +18 -> 62
    //   47: aload_2
    //   48: invokeinterface 213 1 0
    //   53: ifne +9 -> 62
    //   56: aload_2
    //   57: invokeinterface 216 1 0
    //   62: aload_0
    //   63: monitorexit
    //   64: aconst_null
    //   65: areturn
    //   66: aload_2
    //   67: astore_1
    //   68: new 125	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   75: astore 5
    //   77: aload_2
    //   78: astore_1
    //   79: new 218	java/util/ArrayList
    //   82: dup
    //   83: invokespecial 219	java/util/ArrayList:<init>	()V
    //   86: astore 4
    //   88: aload_2
    //   89: astore_1
    //   90: aload_2
    //   91: invokeinterface 222 1 0
    //   96: ifeq +604 -> 700
    //   99: aload_2
    //   100: astore_1
    //   101: new 36	com/tencent/featuretoggle/models/FeatureTriggerEvent
    //   104: dup
    //   105: invokespecial 223	com/tencent/featuretoggle/models/FeatureTriggerEvent:<init>	()V
    //   108: astore 6
    //   110: aload_2
    //   111: astore_1
    //   112: aload 6
    //   114: aload_2
    //   115: aload_2
    //   116: ldc 50
    //   118: invokeinterface 227 2 0
    //   123: invokeinterface 230 2 0
    //   128: invokestatic 232	com/tencent/featuretoggle/utils/AESHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   131: invokevirtual 236	com/tencent/featuretoggle/models/FeatureTriggerEvent:setSn	(Ljava/lang/String;)V
    //   134: aload_2
    //   135: astore_1
    //   136: aload 6
    //   138: aload_2
    //   139: aload_2
    //   140: ldc 65
    //   142: invokeinterface 227 2 0
    //   147: invokeinterface 230 2 0
    //   152: invokestatic 232	com/tencent/featuretoggle/utils/AESHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokevirtual 239	com/tencent/featuretoggle/models/FeatureTriggerEvent:setFeatureVersionId	(Ljava/lang/String;)V
    //   158: aload_2
    //   159: astore_1
    //   160: aload 6
    //   162: aload_2
    //   163: aload_2
    //   164: ldc 70
    //   166: invokeinterface 227 2 0
    //   171: invokeinterface 230 2 0
    //   176: invokestatic 232	com/tencent/featuretoggle/utils/AESHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   179: invokevirtual 242	com/tencent/featuretoggle/models/FeatureTriggerEvent:setFeatureName	(Ljava/lang/String;)V
    //   182: aload_2
    //   183: astore_1
    //   184: aload 6
    //   186: aload_2
    //   187: aload_2
    //   188: ldc 75
    //   190: invokeinterface 227 2 0
    //   195: invokeinterface 230 2 0
    //   200: invokestatic 232	com/tencent/featuretoggle/utils/AESHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokevirtual 245	com/tencent/featuretoggle/models/FeatureTriggerEvent:setFeatureValue	(Ljava/lang/String;)V
    //   206: aload_2
    //   207: astore_1
    //   208: aload 6
    //   210: aload_2
    //   211: aload_2
    //   212: ldc 80
    //   214: invokeinterface 227 2 0
    //   219: invokeinterface 230 2 0
    //   224: invokestatic 232	com/tencent/featuretoggle/utils/AESHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   227: invokevirtual 248	com/tencent/featuretoggle/models/FeatureTriggerEvent:setUserId	(Ljava/lang/String;)V
    //   230: aload_2
    //   231: astore_1
    //   232: aload 6
    //   234: aload_2
    //   235: aload_2
    //   236: ldc 85
    //   238: invokeinterface 227 2 0
    //   243: invokeinterface 230 2 0
    //   248: invokestatic 232	com/tencent/featuretoggle/utils/AESHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   251: invokevirtual 251	com/tencent/featuretoggle/models/FeatureTriggerEvent:setAbTestId	(Ljava/lang/String;)V
    //   254: aload_2
    //   255: astore_1
    //   256: aload 6
    //   258: aload_2
    //   259: aload_2
    //   260: ldc 90
    //   262: invokeinterface 227 2 0
    //   267: invokeinterface 230 2 0
    //   272: invokestatic 232	com/tencent/featuretoggle/utils/AESHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   275: invokevirtual 254	com/tencent/featuretoggle/models/FeatureTriggerEvent:setDatasetID	(Ljava/lang/String;)V
    //   278: aload_2
    //   279: astore_1
    //   280: aload 6
    //   282: aload_2
    //   283: aload_2
    //   284: ldc 95
    //   286: invokeinterface 227 2 0
    //   291: invokeinterface 230 2 0
    //   296: invokestatic 232	com/tencent/featuretoggle/utils/AESHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   299: invokevirtual 257	com/tencent/featuretoggle/models/FeatureTriggerEvent:setVersionID	(Ljava/lang/String;)V
    //   302: aload_2
    //   303: astore_1
    //   304: aload 6
    //   306: aload_2
    //   307: iconst_0
    //   308: invokeinterface 261 2 0
    //   313: i2l
    //   314: invokevirtual 265	com/tencent/featuretoggle/models/FeatureTriggerEvent:setEventCount	(J)V
    //   317: aload_2
    //   318: astore_1
    //   319: aload 6
    //   321: invokevirtual 88	com/tencent/featuretoggle/models/FeatureTriggerEvent:getAbTestId	()Ljava/lang/String;
    //   324: invokestatic 45	com/tencent/featuretoggle/utils/Utils:a	(Ljava/lang/String;)Z
    //   327: ifeq +13 -> 340
    //   330: aload_2
    //   331: astore_1
    //   332: aload 6
    //   334: ldc_w 267
    //   337: invokevirtual 251	com/tencent/featuretoggle/models/FeatureTriggerEvent:setAbTestId	(Ljava/lang/String;)V
    //   340: aload_2
    //   341: astore_1
    //   342: aload 4
    //   344: aload 6
    //   346: invokevirtual 271	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   349: pop
    //   350: goto -262 -> 88
    //   353: astore 6
    //   355: aload_2
    //   356: astore_1
    //   357: aload_2
    //   358: aload_2
    //   359: ldc 65
    //   361: invokeinterface 227 2 0
    //   366: invokeinterface 230 2 0
    //   371: astore 7
    //   373: aload_2
    //   374: astore_1
    //   375: aload_2
    //   376: aload_2
    //   377: ldc 70
    //   379: invokeinterface 227 2 0
    //   384: invokeinterface 230 2 0
    //   389: astore 8
    //   391: aload_2
    //   392: astore_1
    //   393: aload_2
    //   394: aload_2
    //   395: ldc 75
    //   397: invokeinterface 227 2 0
    //   402: invokeinterface 230 2 0
    //   407: astore 9
    //   409: aload_2
    //   410: astore_1
    //   411: aload_2
    //   412: aload_2
    //   413: ldc 80
    //   415: invokeinterface 227 2 0
    //   420: invokeinterface 230 2 0
    //   425: astore 10
    //   427: aload_2
    //   428: astore_1
    //   429: aload_2
    //   430: aload_2
    //   431: ldc 85
    //   433: invokeinterface 227 2 0
    //   438: invokeinterface 230 2 0
    //   443: astore 11
    //   445: aload_2
    //   446: astore_1
    //   447: aload 5
    //   449: ldc 141
    //   451: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload_2
    //   456: astore_1
    //   457: aload 5
    //   459: ldc 147
    //   461: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload_2
    //   466: astore_1
    //   467: aload 5
    //   469: ldc 65
    //   471: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload_2
    //   476: astore_1
    //   477: aload 5
    //   479: ldc 149
    //   481: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload_2
    //   486: astore_1
    //   487: aload 5
    //   489: aload 7
    //   491: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload_2
    //   496: astore_1
    //   497: aload 5
    //   499: ldc 151
    //   501: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload_2
    //   506: astore_1
    //   507: aload 5
    //   509: ldc 70
    //   511: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_2
    //   516: astore_1
    //   517: aload 5
    //   519: ldc 149
    //   521: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload_2
    //   526: astore_1
    //   527: aload 5
    //   529: aload 8
    //   531: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload_2
    //   536: astore_1
    //   537: aload 5
    //   539: ldc 151
    //   541: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload_2
    //   546: astore_1
    //   547: aload 5
    //   549: ldc 75
    //   551: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload_2
    //   556: astore_1
    //   557: aload 5
    //   559: ldc 149
    //   561: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload_2
    //   566: astore_1
    //   567: aload 5
    //   569: aload 9
    //   571: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload_2
    //   576: astore_1
    //   577: aload 5
    //   579: ldc 151
    //   581: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload_2
    //   586: astore_1
    //   587: aload 5
    //   589: ldc 80
    //   591: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload_2
    //   596: astore_1
    //   597: aload 5
    //   599: ldc 149
    //   601: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload_2
    //   606: astore_1
    //   607: aload 5
    //   609: aload 10
    //   611: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload_2
    //   616: astore_1
    //   617: aload 5
    //   619: ldc 151
    //   621: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload_2
    //   626: astore_1
    //   627: aload 5
    //   629: ldc 85
    //   631: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload_2
    //   636: astore_1
    //   637: aload 5
    //   639: ldc 149
    //   641: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: aload_2
    //   646: astore_1
    //   647: aload 5
    //   649: aload 11
    //   651: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload_2
    //   656: astore_1
    //   657: aload 5
    //   659: ldc 153
    //   661: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: pop
    //   665: goto +15 -> 680
    //   668: aload_2
    //   669: astore_1
    //   670: ldc_w 273
    //   673: iconst_0
    //   674: anewarray 4	java/lang/Object
    //   677: invokestatic 190	com/tencent/featuretoggle/utils/LogUtils:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   680: aload_2
    //   681: astore_1
    //   682: aload 6
    //   684: invokestatic 109	com/tencent/featuretoggle/utils/LogUtils:a	(Ljava/lang/Throwable;)Z
    //   687: ifne -599 -> 88
    //   690: aload_2
    //   691: astore_1
    //   692: aload 6
    //   694: invokevirtual 112	java/lang/Throwable:printStackTrace	()V
    //   697: goto -609 -> 88
    //   700: aload_2
    //   701: astore_1
    //   702: aload 5
    //   704: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: astore 5
    //   709: aload_2
    //   710: astore_1
    //   711: aload 5
    //   713: invokevirtual 162	java/lang/String:length	()I
    //   716: ifle +39 -> 755
    //   719: aload_2
    //   720: astore_1
    //   721: ldc_w 275
    //   724: iconst_2
    //   725: anewarray 4	java/lang/Object
    //   728: dup
    //   729: iconst_0
    //   730: ldc 172
    //   732: aastore
    //   733: dup
    //   734: iconst_1
    //   735: aload_3
    //   736: ldc 172
    //   738: aload 5
    //   740: iconst_4
    //   741: invokevirtual 166	java/lang/String:substring	(I)Ljava/lang/String;
    //   744: aconst_null
    //   745: invokevirtual 178	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   748: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   751: aastore
    //   752: invokestatic 190	com/tencent/featuretoggle/utils/LogUtils:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   755: aload_2
    //   756: ifnull +18 -> 774
    //   759: aload_2
    //   760: invokeinterface 213 1 0
    //   765: ifne +9 -> 774
    //   768: aload_2
    //   769: invokeinterface 216 1 0
    //   774: aload_0
    //   775: monitorexit
    //   776: aload 4
    //   778: areturn
    //   779: astore_3
    //   780: goto +12 -> 792
    //   783: astore_1
    //   784: aconst_null
    //   785: astore_2
    //   786: goto +49 -> 835
    //   789: astore_3
    //   790: aconst_null
    //   791: astore_2
    //   792: aload_2
    //   793: astore_1
    //   794: aload_3
    //   795: invokestatic 109	com/tencent/featuretoggle/utils/LogUtils:a	(Ljava/lang/Throwable;)Z
    //   798: ifne +9 -> 807
    //   801: aload_2
    //   802: astore_1
    //   803: aload_3
    //   804: invokevirtual 112	java/lang/Throwable:printStackTrace	()V
    //   807: aload_2
    //   808: ifnull +18 -> 826
    //   811: aload_2
    //   812: invokeinterface 213 1 0
    //   817: ifne +9 -> 826
    //   820: aload_2
    //   821: invokeinterface 216 1 0
    //   826: aload_0
    //   827: monitorexit
    //   828: aconst_null
    //   829: areturn
    //   830: astore_3
    //   831: aload_1
    //   832: astore_2
    //   833: aload_3
    //   834: astore_1
    //   835: aload_2
    //   836: ifnull +18 -> 854
    //   839: aload_2
    //   840: invokeinterface 213 1 0
    //   845: ifne +9 -> 854
    //   848: aload_2
    //   849: invokeinterface 216 1 0
    //   854: aload_1
    //   855: athrow
    //   856: astore_1
    //   857: aload_0
    //   858: monitorexit
    //   859: goto +5 -> 864
    //   862: aload_1
    //   863: athrow
    //   864: goto -2 -> 862
    //   867: astore_1
    //   868: goto -200 -> 668
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	871	0	this	DBManager
    //   6	715	1	localObject1	Object
    //   783	1	1	localObject2	Object
    //   793	62	1	localObject3	Object
    //   856	7	1	localObject4	Object
    //   867	1	1	localThrowable1	Throwable
    //   38	811	2	localObject5	Object
    //   22	714	3	localSQLiteDatabase	SQLiteDatabase
    //   779	1	3	localThrowable2	Throwable
    //   789	15	3	localThrowable3	Throwable
    //   830	4	3	localObject6	Object
    //   86	691	4	localArrayList	java.util.ArrayList
    //   75	664	5	localObject7	Object
    //   108	237	6	localFeatureTriggerEvent	FeatureTriggerEvent
    //   353	340	6	localThrowable4	Throwable
    //   371	119	7	str1	String
    //   389	141	8	str2	String
    //   407	163	9	str3	String
    //   425	185	10	str4	String
    //   443	207	11	str5	String
    // Exception table:
    //   from	to	target	type
    //   112	134	353	java/lang/Throwable
    //   136	158	353	java/lang/Throwable
    //   160	182	353	java/lang/Throwable
    //   184	206	353	java/lang/Throwable
    //   208	230	353	java/lang/Throwable
    //   232	254	353	java/lang/Throwable
    //   256	278	353	java/lang/Throwable
    //   280	302	353	java/lang/Throwable
    //   304	317	353	java/lang/Throwable
    //   319	330	353	java/lang/Throwable
    //   332	340	353	java/lang/Throwable
    //   342	350	353	java/lang/Throwable
    //   68	77	779	java/lang/Throwable
    //   79	88	779	java/lang/Throwable
    //   90	99	779	java/lang/Throwable
    //   101	110	779	java/lang/Throwable
    //   670	680	779	java/lang/Throwable
    //   682	690	779	java/lang/Throwable
    //   692	697	779	java/lang/Throwable
    //   702	709	779	java/lang/Throwable
    //   711	719	779	java/lang/Throwable
    //   721	755	779	java/lang/Throwable
    //   31	39	783	finally
    //   31	39	789	java/lang/Throwable
    //   68	77	830	finally
    //   79	88	830	finally
    //   90	99	830	finally
    //   101	110	830	finally
    //   112	134	830	finally
    //   136	158	830	finally
    //   160	182	830	finally
    //   184	206	830	finally
    //   208	230	830	finally
    //   232	254	830	finally
    //   256	278	830	finally
    //   280	302	830	finally
    //   304	317	830	finally
    //   319	330	830	finally
    //   332	340	830	finally
    //   342	350	830	finally
    //   357	373	830	finally
    //   375	391	830	finally
    //   393	409	830	finally
    //   411	427	830	finally
    //   429	445	830	finally
    //   447	455	830	finally
    //   457	465	830	finally
    //   467	475	830	finally
    //   477	485	830	finally
    //   487	495	830	finally
    //   497	505	830	finally
    //   507	515	830	finally
    //   517	525	830	finally
    //   527	535	830	finally
    //   537	545	830	finally
    //   547	555	830	finally
    //   557	565	830	finally
    //   567	575	830	finally
    //   577	585	830	finally
    //   587	595	830	finally
    //   597	605	830	finally
    //   607	615	830	finally
    //   617	625	830	finally
    //   627	635	830	finally
    //   637	645	830	finally
    //   647	655	830	finally
    //   657	665	830	finally
    //   670	680	830	finally
    //   682	690	830	finally
    //   692	697	830	finally
    //   702	709	830	finally
    //   711	719	830	finally
    //   721	755	830	finally
    //   794	801	830	finally
    //   803	807	830	finally
    //   2	7	856	finally
    //   15	23	856	finally
    //   47	62	856	finally
    //   759	774	856	finally
    //   811	826	856	finally
    //   839	854	856	finally
    //   854	856	856	finally
    //   357	373	867	java/lang/Throwable
    //   375	391	867	java/lang/Throwable
    //   393	409	867	java/lang/Throwable
    //   411	427	867	java/lang/Throwable
    //   429	445	867	java/lang/Throwable
    //   447	455	867	java/lang/Throwable
    //   457	465	867	java/lang/Throwable
    //   467	475	867	java/lang/Throwable
    //   477	485	867	java/lang/Throwable
    //   487	495	867	java/lang/Throwable
    //   497	505	867	java/lang/Throwable
    //   507	515	867	java/lang/Throwable
    //   517	525	867	java/lang/Throwable
    //   527	535	867	java/lang/Throwable
    //   537	545	867	java/lang/Throwable
    //   547	555	867	java/lang/Throwable
    //   557	565	867	java/lang/Throwable
    //   567	575	867	java/lang/Throwable
    //   577	585	867	java/lang/Throwable
    //   587	595	867	java/lang/Throwable
    //   597	605	867	java/lang/Throwable
    //   607	615	867	java/lang/Throwable
    //   617	625	867	java/lang/Throwable
    //   627	635	867	java/lang/Throwable
    //   637	645	867	java/lang/Throwable
    //   647	655	867	java/lang/Throwable
    //   657	665	867	java/lang/Throwable
  }
  
  /* Error */
  public long c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/tencent/featuretoggle/db/DBManager:a	Lcom/tencent/featuretoggle/db/DBOpenHelper;
    //   6: astore 8
    //   8: lconst_0
    //   9: lstore_3
    //   10: aload 8
    //   12: ifnonnull +7 -> 19
    //   15: aload_0
    //   16: monitorexit
    //   17: lconst_0
    //   18: lreturn
    //   19: aload_0
    //   20: getfield 16	com/tencent/featuretoggle/db/DBManager:a	Lcom/tencent/featuretoggle/db/DBOpenHelper;
    //   23: invokevirtual 123	com/tencent/featuretoggle/db/DBOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore 10
    //   28: aload 10
    //   30: ifnonnull +7 -> 37
    //   33: aload_0
    //   34: monitorexit
    //   35: lconst_0
    //   36: lreturn
    //   37: aconst_null
    //   38: astore 8
    //   40: aconst_null
    //   41: astore 9
    //   43: aload 10
    //   45: ldc_w 280
    //   48: aconst_null
    //   49: invokevirtual 208	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore 10
    //   54: aload 10
    //   56: astore 9
    //   58: aload 10
    //   60: astore 8
    //   62: aload 10
    //   64: invokeinterface 283 1 0
    //   69: pop
    //   70: aload 10
    //   72: astore 9
    //   74: aload 10
    //   76: astore 8
    //   78: aload 10
    //   80: iconst_0
    //   81: invokeinterface 287 2 0
    //   86: lstore 5
    //   88: lload 5
    //   90: lstore_1
    //   91: aload 10
    //   93: ifnull +89 -> 182
    //   96: lload 5
    //   98: lstore_1
    //   99: aload 10
    //   101: invokeinterface 213 1 0
    //   106: ifne +76 -> 182
    //   109: aload 10
    //   111: astore 8
    //   113: lload 5
    //   115: lstore_1
    //   116: aload 8
    //   118: invokeinterface 216 1 0
    //   123: goto +59 -> 182
    //   126: astore 8
    //   128: goto +58 -> 186
    //   131: astore 10
    //   133: aload 8
    //   135: astore 9
    //   137: aload 10
    //   139: invokestatic 109	com/tencent/featuretoggle/utils/LogUtils:a	(Ljava/lang/Throwable;)Z
    //   142: ifne +12 -> 154
    //   145: aload 8
    //   147: astore 9
    //   149: aload 10
    //   151: invokevirtual 112	java/lang/Throwable:printStackTrace	()V
    //   154: lload_3
    //   155: lstore_1
    //   156: aload 8
    //   158: ifnull +24 -> 182
    //   161: aload 8
    //   163: invokeinterface 213 1 0
    //   168: istore 7
    //   170: lload_3
    //   171: lstore_1
    //   172: iload 7
    //   174: ifne +8 -> 182
    //   177: lload_3
    //   178: lstore_1
    //   179: goto -63 -> 116
    //   182: aload_0
    //   183: monitorexit
    //   184: lload_1
    //   185: lreturn
    //   186: aload 9
    //   188: ifnull +20 -> 208
    //   191: aload 9
    //   193: invokeinterface 213 1 0
    //   198: ifne +10 -> 208
    //   201: aload 9
    //   203: invokeinterface 216 1 0
    //   208: aload 8
    //   210: athrow
    //   211: astore 8
    //   213: aload_0
    //   214: monitorexit
    //   215: goto +6 -> 221
    //   218: aload 8
    //   220: athrow
    //   221: goto -3 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	DBManager
    //   90	95	1	l1	long
    //   9	169	3	l2	long
    //   86	28	5	l3	long
    //   168	5	7	bool	boolean
    //   6	111	8	localObject1	Object
    //   126	83	8	localObject2	Object
    //   211	8	8	localObject3	Object
    //   41	161	9	localObject4	Object
    //   26	84	10	localObject5	Object
    //   131	19	10	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   43	54	126	finally
    //   62	70	126	finally
    //   78	88	126	finally
    //   137	145	126	finally
    //   149	154	126	finally
    //   43	54	131	java/lang/Throwable
    //   62	70	131	java/lang/Throwable
    //   78	88	131	java/lang/Throwable
    //   2	8	211	finally
    //   19	28	211	finally
    //   99	109	211	finally
    //   116	123	211	finally
    //   161	170	211	finally
    //   191	208	211	finally
    //   208	211	211	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.db.DBManager
 * JD-Core Version:    0.7.0.1
 */