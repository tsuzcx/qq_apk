package com.tencent.imcore.message;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.data.msg.FTSMessageDelete;
import com.tencent.mobileqq.fts.v1.utils.FTSMessageCodec;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class MsgCountChecker
{
  final ConcurrentHashMap<String, Integer> a = new ConcurrentHashMap();
  
  /* Error */
  private void a(QQAppInterface paramQQAppInterface, BaseQQMessageFacade paramBaseQQMessageFacade, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 28	com/tencent/mobileqq/app/QQAppInterface:getProxyManager	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   4: invokevirtual 34	com/tencent/mobileqq/app/proxy/ProxyManager:g	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   7: iconst_1
    //   8: invokeinterface 39 2 0
    //   13: invokeinterface 45 1 0
    //   18: astore 10
    //   20: iconst_0
    //   21: istore 7
    //   23: iconst_0
    //   24: istore 5
    //   26: aload 10
    //   28: invokeinterface 51 1 0
    //   33: ifeq +469 -> 502
    //   36: aload 10
    //   38: invokeinterface 55 1 0
    //   43: checkcast 57	com/tencent/mobileqq/data/RecentUser
    //   46: astore 11
    //   48: iload 7
    //   50: iconst_1
    //   51: iadd
    //   52: istore 9
    //   54: iload 5
    //   56: istore 6
    //   58: iload 9
    //   60: istore 8
    //   62: aload 11
    //   64: getfield 61	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   67: lload_3
    //   68: lcmp
    //   69: ifle +418 -> 487
    //   72: aload 11
    //   74: getfield 65	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   77: getstatic 70	com/tencent/mobileqq/app/AppConstants:TROOP_ASSISTANT_UIN	Ljava/lang/String;
    //   80: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifeq +105 -> 188
    //   86: iload 9
    //   88: iconst_1
    //   89: isub
    //   90: istore 7
    //   92: aload_0
    //   93: aload_1
    //   94: invokevirtual 80	com/tencent/imcore/message/MsgCountChecker:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   97: invokeinterface 45 1 0
    //   102: astore 11
    //   104: iload 5
    //   106: istore 6
    //   108: iload 7
    //   110: istore 8
    //   112: aload 11
    //   114: invokeinterface 51 1 0
    //   119: ifeq +368 -> 487
    //   122: aload 11
    //   124: invokeinterface 55 1 0
    //   129: checkcast 82	com/tencent/mobileqq/data/TroopAssistantData
    //   132: astore 12
    //   134: iload 7
    //   136: iconst_1
    //   137: iadd
    //   138: istore 6
    //   140: iload 6
    //   142: istore 7
    //   144: aload 12
    //   146: getfield 83	com/tencent/mobileqq/data/TroopAssistantData:lastmsgtime	J
    //   149: lload_3
    //   150: lcmp
    //   151: ifle -47 -> 104
    //   154: iload 5
    //   156: iconst_1
    //   157: iadd
    //   158: istore 5
    //   160: aload_0
    //   161: getfield 16	com/tencent/imcore/message/MsgCountChecker:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   164: aload 12
    //   166: getfield 86	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   169: iconst_1
    //   170: invokestatic 92	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   173: iconst_1
    //   174: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: invokevirtual 102	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: pop
    //   181: iload 6
    //   183: istore 7
    //   185: goto -81 -> 104
    //   188: aload_0
    //   189: aload 11
    //   191: getfield 65	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   194: aload 11
    //   196: invokevirtual 106	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   199: invokevirtual 109	com/tencent/imcore/message/MsgCountChecker:a	(Ljava/lang/String;I)Z
    //   202: ifeq +126 -> 328
    //   205: iload 9
    //   207: iconst_1
    //   208: isub
    //   209: istore 7
    //   211: aload_2
    //   212: aload 11
    //   214: getfield 65	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   217: aload 11
    //   219: invokevirtual 106	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   222: invokevirtual 115	com/tencent/imcore/message/BaseQQMessageFacade:h	(Ljava/lang/String;I)Ljava/util/List;
    //   225: invokeinterface 45 1 0
    //   230: astore 11
    //   232: iload 5
    //   234: istore 8
    //   236: iload 8
    //   238: istore 6
    //   240: iload 7
    //   242: istore 5
    //   244: aload 11
    //   246: invokeinterface 51 1 0
    //   251: ifeq +240 -> 491
    //   254: aload 11
    //   256: invokeinterface 55 1 0
    //   261: checkcast 88	com/tencent/mobileqq/data/MessageRecord
    //   264: astore 12
    //   266: iload 7
    //   268: iconst_1
    //   269: iadd
    //   270: istore 5
    //   272: iload 5
    //   274: istore 7
    //   276: aload 12
    //   278: getfield 118	com/tencent/mobileqq/data/MessageRecord:time	J
    //   281: lload_3
    //   282: lcmp
    //   283: ifle -47 -> 236
    //   286: iload 8
    //   288: iconst_1
    //   289: iadd
    //   290: istore 8
    //   292: aload_0
    //   293: getfield 16	com/tencent/imcore/message/MsgCountChecker:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   296: aload 12
    //   298: getfield 121	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   301: aload 12
    //   303: getfield 125	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   306: invokestatic 92	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   309: aload 12
    //   311: getfield 125	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   314: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: invokevirtual 102	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   320: pop
    //   321: iload 5
    //   323: istore 7
    //   325: goto -89 -> 236
    //   328: iload 5
    //   330: istore 7
    //   332: aload 11
    //   334: getfield 65	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   337: invokestatic 130	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   340: invokevirtual 134	java/lang/Long:longValue	()J
    //   343: ldc2_w 135
    //   346: lcmp
    //   347: ifle +49 -> 396
    //   350: iload 5
    //   352: iconst_1
    //   353: iadd
    //   354: istore 6
    //   356: iload 6
    //   358: istore 7
    //   360: aload_0
    //   361: getfield 16	com/tencent/imcore/message/MsgCountChecker:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   364: aload 11
    //   366: getfield 65	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   369: aload 11
    //   371: invokevirtual 106	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   374: invokestatic 92	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   377: aload 11
    //   379: invokevirtual 106	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   382: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   385: invokevirtual 102	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   388: pop
    //   389: iload 9
    //   391: istore 5
    //   393: goto +98 -> 491
    //   396: iload 9
    //   398: iconst_1
    //   399: isub
    //   400: istore 7
    //   402: iload 5
    //   404: istore 6
    //   406: iload 7
    //   408: istore 5
    //   410: goto +81 -> 491
    //   413: astore 11
    //   415: iload 9
    //   417: iconst_1
    //   418: isub
    //   419: istore 8
    //   421: aload 11
    //   423: invokevirtual 139	java/lang/NumberFormatException:printStackTrace	()V
    //   426: iload 7
    //   428: istore 6
    //   430: iload 8
    //   432: istore 5
    //   434: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +54 -> 491
    //   440: new 146	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   447: astore 12
    //   449: aload 12
    //   451: ldc 149
    //   453: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 12
    //   459: aload 11
    //   461: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: ldc 158
    //   467: iconst_2
    //   468: aload 12
    //   470: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: iload 7
    //   478: istore 6
    //   480: iload 8
    //   482: istore 5
    //   484: goto +7 -> 491
    //   487: iload 8
    //   489: istore 5
    //   491: iload 5
    //   493: istore 7
    //   495: iload 6
    //   497: istore 5
    //   499: goto -473 -> 26
    //   502: iload 5
    //   504: iload 7
    //   506: if_icmpne +216 -> 722
    //   509: aload_0
    //   510: getfield 16	com/tencent/imcore/message/MsgCountChecker:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   513: invokevirtual 170	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   516: astore 11
    //   518: aload_1
    //   519: invokevirtual 174	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   522: astore 10
    //   524: aconst_null
    //   525: astore_1
    //   526: aconst_null
    //   527: astore_2
    //   528: aload 10
    //   530: ldc 176
    //   532: aconst_null
    //   533: invokevirtual 182	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   536: astore 10
    //   538: aload 10
    //   540: ifnull +83 -> 623
    //   543: aload 10
    //   545: astore_2
    //   546: aload 10
    //   548: astore_1
    //   549: aload 10
    //   551: invokeinterface 187 1 0
    //   556: ifeq +67 -> 623
    //   559: aload 10
    //   561: astore_2
    //   562: aload 10
    //   564: astore_1
    //   565: aload 10
    //   567: iconst_0
    //   568: invokeinterface 191 2 0
    //   573: invokestatic 197	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   576: astore 12
    //   578: aload 10
    //   580: astore_2
    //   581: aload 10
    //   583: astore_1
    //   584: aload 11
    //   586: aload 12
    //   588: invokeinterface 202 2 0
    //   593: ifne -50 -> 543
    //   596: aload 10
    //   598: astore_2
    //   599: aload 10
    //   601: astore_1
    //   602: aload_0
    //   603: getfield 16	com/tencent/imcore/message/MsgCountChecker:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   606: aload 12
    //   608: aload 12
    //   610: invokestatic 206	com/tencent/mobileqq/data/MessageRecord:getTypeByTableName	(Ljava/lang/String;)I
    //   613: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   616: invokevirtual 102	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   619: pop
    //   620: goto -77 -> 543
    //   623: aload 10
    //   625: ifnull +97 -> 722
    //   628: aload 10
    //   630: astore_1
    //   631: aload_1
    //   632: invokeinterface 209 1 0
    //   637: return
    //   638: astore_1
    //   639: goto +71 -> 710
    //   642: astore 10
    //   644: aload_1
    //   645: astore_2
    //   646: aload 10
    //   648: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   651: aload_1
    //   652: astore_2
    //   653: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   656: ifeq +47 -> 703
    //   659: aload_1
    //   660: astore_2
    //   661: new 146	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   668: astore 11
    //   670: aload_1
    //   671: astore_2
    //   672: aload 11
    //   674: ldc 149
    //   676: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload_1
    //   681: astore_2
    //   682: aload 11
    //   684: aload 10
    //   686: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   689: pop
    //   690: aload_1
    //   691: astore_2
    //   692: ldc 158
    //   694: iconst_2
    //   695: aload 11
    //   697: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: aload_1
    //   704: ifnull +18 -> 722
    //   707: goto -76 -> 631
    //   710: aload_2
    //   711: ifnull +9 -> 720
    //   714: aload_2
    //   715: invokeinterface 209 1 0
    //   720: aload_1
    //   721: athrow
    //   722: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	723	0	this	MsgCountChecker
    //   0	723	1	paramQQAppInterface	QQAppInterface
    //   0	723	2	paramBaseQQMessageFacade	BaseQQMessageFacade
    //   0	723	3	paramLong	long
    //   24	483	5	i	int
    //   56	440	6	j	int
    //   21	486	7	k	int
    //   60	428	8	m	int
    //   52	367	9	n	int
    //   18	611	10	localObject1	Object
    //   642	43	10	localException	Exception
    //   46	332	11	localObject2	Object
    //   413	47	11	localNumberFormatException	java.lang.NumberFormatException
    //   516	180	11	localObject3	Object
    //   132	477	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   332	350	413	java/lang/NumberFormatException
    //   360	389	413	java/lang/NumberFormatException
    //   528	538	638	finally
    //   549	559	638	finally
    //   565	578	638	finally
    //   584	596	638	finally
    //   602	620	638	finally
    //   646	651	638	finally
    //   653	659	638	finally
    //   661	670	638	finally
    //   672	680	638	finally
    //   682	690	638	finally
    //   692	703	638	finally
    //   528	538	642	java/lang/Exception
    //   549	559	642	java/lang/Exception
    //   565	578	642	java/lang/Exception
    //   584	596	642	java/lang/Exception
    //   602	620	642	java/lang/Exception
  }
  
  private void a(MessageRecordEntityManager paramMessageRecordEntityManager, List<MessageRecord> paramList)
  {
    HashSet localHashSet = new HashSet(5);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord.isSupportFTS()) && (localMessageRecord.isValid) && (localMessageRecord.msgtype != -2006))
      {
        Object localObject = FTSMessageCodec.a(localMessageRecord);
        ((FTSMessage)localObject).deleteOpt();
        localObject = FTSMessageCodec.b((FTSMessage)localObject);
        if (!a(localHashSet, (FTSMessageDelete)localObject, localMessageRecord.getExtInfoFromExtStr("ExtraFTSMsgCounter"))) {
          paramMessageRecordEntityManager.persistOrReplace((Entity)localObject);
        }
      }
    }
  }
  
  private boolean a(HashSet<String> paramHashSet, FTSMessageDelete paramFTSMessageDelete, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramFTSMessageDelete.deleteOne();
    }
    else
    {
      if (paramHashSet.contains(paramString)) {
        return true;
      }
      try
      {
        paramFTSMessageDelete.delCounter = Long.valueOf(Long.parseLong(paramString)).longValue();
        paramFTSMessageDelete.deletePatch();
        paramHashSet.add(paramString);
      }
      catch (Exception paramHashSet)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgCountChecker", 2, paramHashSet.toString());
        }
      }
    }
    return false;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = paramQQAppInterface.getMessageFacade();
    Object localObject1 = paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    long l = ((SharedPreferences)localObject1).getLong("table_last_clip_time", 0L);
    if (System.currentTimeMillis() / 1000L - l < 86400L) {
      return;
    }
    try
    {
      a(paramQQAppInterface, (BaseQQMessageFacade)localObject2, l);
      localObject2 = new StringBuilder("MessageFacade : checkMsgCounts:");
      synchronized (this.a)
      {
        ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(this.a);
        this.a.clear();
        ??? = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)???).hasNext())
        {
          String str = (String)((Iterator)???).next();
          int i = ((Integer)localConcurrentHashMap.get(str)).intValue();
          if (QLog.isColorLevel())
          {
            ((StringBuilder)localObject2).append(" tableName:");
            ((StringBuilder)localObject2).append(str);
            ((StringBuilder)localObject2).append(";");
          }
          a(paramQQAppInterface, str, i);
        }
        ((SharedPreferences)localObject1).edit().putLong("table_last_clip_time", System.currentTimeMillis() / 1000L).commit();
        if (QLog.isColorLevel()) {
          QLog.d("MsgCountChecker", 2, ((StringBuilder)localObject2).toString());
        }
        return;
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkMsgCounts ");
        ((StringBuilder)localObject1).append(paramQQAppInterface);
        QLog.d("MsgCountChecker", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 174	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   4: astore 15
    //   6: aload 15
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aload 15
    //   14: aload_2
    //   15: invokevirtual 366	com/tencent/mobileqq/app/SQLiteDatabase:getCount	(Ljava/lang/String;)I
    //   18: istore 4
    //   20: iload 4
    //   22: sipush 6000
    //   25: if_icmple +629 -> 654
    //   28: iload 4
    //   30: sipush 5000
    //   33: isub
    //   34: sipush 1200
    //   37: invokestatic 372	java/lang/Math:max	(II)I
    //   40: istore 6
    //   42: aload_1
    //   43: invokevirtual 376	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   46: invokevirtual 381	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:b	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   49: checkcast 249	com/tencent/mobileqq/persistence/MessageRecordEntityManager
    //   52: astore 16
    //   54: aload 16
    //   56: invokevirtual 385	com/tencent/mobileqq/persistence/MessageRecordEntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   59: astore 14
    //   61: iload 6
    //   63: sipush 2500
    //   66: idiv
    //   67: iconst_1
    //   68: iadd
    //   69: istore 7
    //   71: iload 6
    //   73: iload 7
    //   75: idiv
    //   76: istore 8
    //   78: iconst_0
    //   79: istore 4
    //   81: iload_3
    //   82: istore 5
    //   84: iload 4
    //   86: iload 7
    //   88: if_icmpge +560 -> 648
    //   91: iload 5
    //   93: ifne +62 -> 155
    //   96: ldc_w 387
    //   99: iconst_3
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_2
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: aload_2
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: iload 8
    //   115: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: invokestatic 391	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   122: astore 12
    //   124: ldc_w 393
    //   127: iconst_3
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: aload_2
    //   134: aastore
    //   135: dup
    //   136: iconst_1
    //   137: aload_2
    //   138: aastore
    //   139: dup
    //   140: iconst_2
    //   141: iload 8
    //   143: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: invokestatic 391	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   150: astore 11
    //   152: goto +151 -> 303
    //   155: iload 5
    //   157: iconst_1
    //   158: if_icmpeq +89 -> 247
    //   161: iload 5
    //   163: sipush 3000
    //   166: if_icmpeq +81 -> 247
    //   169: iload 5
    //   171: sipush 10014
    //   174: if_icmpeq +73 -> 247
    //   177: iload 5
    //   179: sipush 1026
    //   182: if_icmpne +6 -> 188
    //   185: goto +62 -> 247
    //   188: ldc_w 395
    //   191: iconst_3
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload_2
    //   198: aastore
    //   199: dup
    //   200: iconst_1
    //   201: aload_2
    //   202: aastore
    //   203: dup
    //   204: iconst_2
    //   205: iload 8
    //   207: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: aastore
    //   211: invokestatic 391	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   214: astore 12
    //   216: ldc_w 397
    //   219: iconst_3
    //   220: anewarray 4	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: aload_2
    //   226: aastore
    //   227: dup
    //   228: iconst_1
    //   229: aload_2
    //   230: aastore
    //   231: dup
    //   232: iconst_2
    //   233: iload 8
    //   235: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: invokestatic 391	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   242: astore 11
    //   244: goto +59 -> 303
    //   247: ldc_w 399
    //   250: iconst_3
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload_2
    //   257: aastore
    //   258: dup
    //   259: iconst_1
    //   260: aload_2
    //   261: aastore
    //   262: dup
    //   263: iconst_2
    //   264: iload 8
    //   266: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: aastore
    //   270: invokestatic 391	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   273: astore 12
    //   275: ldc_w 401
    //   278: iconst_3
    //   279: anewarray 4	java/lang/Object
    //   282: dup
    //   283: iconst_0
    //   284: aload_2
    //   285: aastore
    //   286: dup
    //   287: iconst_1
    //   288: aload_2
    //   289: aastore
    //   290: dup
    //   291: iconst_2
    //   292: iload 8
    //   294: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: aastore
    //   298: invokestatic 391	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   301: astore 11
    //   303: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   306: lstore 9
    //   308: aconst_null
    //   309: astore 13
    //   311: aload 14
    //   313: ifnull +8 -> 321
    //   316: aload 14
    //   318: invokevirtual 406	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   321: aload 16
    //   323: aload 11
    //   325: aconst_null
    //   326: invokevirtual 409	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   329: astore 11
    //   331: aload 11
    //   333: ifnull +322 -> 655
    //   336: aload_0
    //   337: aload 16
    //   339: aload 11
    //   341: invokespecial 411	com/tencent/imcore/message/MsgCountChecker:a	(Lcom/tencent/mobileqq/persistence/MessageRecordEntityManager;Ljava/util/List;)V
    //   344: goto +3 -> 347
    //   347: aload 15
    //   349: aload 12
    //   351: invokevirtual 415	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   354: pop
    //   355: aload 14
    //   357: ifnull +8 -> 365
    //   360: aload 14
    //   362: invokevirtual 417	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   365: aload 14
    //   367: ifnull +8 -> 375
    //   370: aload 14
    //   372: invokevirtual 420	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   375: aload 11
    //   377: astore 12
    //   379: goto +77 -> 456
    //   382: astore_1
    //   383: goto +253 -> 636
    //   386: astore 12
    //   388: goto +13 -> 401
    //   391: astore_1
    //   392: goto +244 -> 636
    //   395: astore 12
    //   397: aload 13
    //   399: astore 11
    //   401: new 146	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   408: astore 13
    //   410: aload 13
    //   412: ldc_w 422
    //   415: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 13
    //   421: aload 12
    //   423: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: ldc 158
    //   429: iconst_1
    //   430: aload 13
    //   432: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: aload 11
    //   440: astore 12
    //   442: aload 14
    //   444: ifnull +12 -> 456
    //   447: aload 14
    //   449: invokevirtual 420	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   452: aload 11
    //   454: astore 12
    //   456: aload 12
    //   458: ifnull +169 -> 627
    //   461: aload 12
    //   463: invokeinterface 425 1 0
    //   468: ifle +159 -> 627
    //   471: aload_1
    //   472: getstatic 430	com/tencent/mobileqq/app/QQManagerFactory:SLOW_TABLE_MANAGER	I
    //   475: invokevirtual 434	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   478: checkcast 436	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager
    //   481: astore 11
    //   483: aload 11
    //   485: ifnull +25 -> 510
    //   488: aload 11
    //   490: invokevirtual 439	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager:a	()Lcom/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory;
    //   493: invokevirtual 444	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory:isOpen	()Z
    //   496: ifne +6 -> 502
    //   499: goto +149 -> 648
    //   502: aload 11
    //   504: aload_2
    //   505: aload 12
    //   507: invokevirtual 447	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager:a	(Ljava/lang/String;Ljava/util/List;)V
    //   510: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq +114 -> 627
    //   516: new 146	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   523: astore 11
    //   525: aload 11
    //   527: ldc_w 449
    //   530: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 11
    //   536: aload_2
    //   537: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 11
    //   543: ldc_w 451
    //   546: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload 11
    //   552: iload 8
    //   554: invokevirtual 454	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 11
    //   560: ldc_w 456
    //   563: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload 11
    //   569: iload 4
    //   571: invokevirtual 454	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload 11
    //   577: ldc_w 456
    //   580: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 11
    //   586: iload 6
    //   588: invokevirtual 454	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 11
    //   594: ldc_w 458
    //   597: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload 11
    //   603: invokestatic 316	java/lang/System:currentTimeMillis	()J
    //   606: lload 9
    //   608: lsub
    //   609: invokevirtual 461	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: ldc 158
    //   615: iconst_2
    //   616: aload 11
    //   618: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   624: goto +3 -> 627
    //   627: iload 4
    //   629: iconst_1
    //   630: iadd
    //   631: istore 4
    //   633: goto -552 -> 81
    //   636: aload 14
    //   638: ifnull +8 -> 646
    //   641: aload 14
    //   643: invokevirtual 420	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   646: aload_1
    //   647: athrow
    //   648: aload 16
    //   650: invokevirtual 462	com/tencent/mobileqq/persistence/MessageRecordEntityManager:close	()V
    //   653: return
    //   654: return
    //   655: goto -308 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	658	0	this	MsgCountChecker
    //   0	658	1	paramQQAppInterface	QQAppInterface
    //   0	658	2	paramString	String
    //   0	658	3	paramInt	int
    //   18	614	4	i	int
    //   82	101	5	j	int
    //   40	547	6	k	int
    //   69	20	7	m	int
    //   76	477	8	n	int
    //   306	301	9	l	long
    //   150	467	11	localObject1	Object
    //   122	256	12	localObject2	Object
    //   386	1	12	localException1	Exception
    //   395	27	12	localException2	Exception
    //   440	66	12	localObject3	Object
    //   309	122	13	localStringBuilder	StringBuilder
    //   59	583	14	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   4	344	15	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   52	597	16	localMessageRecordEntityManager	MessageRecordEntityManager
    // Exception table:
    //   from	to	target	type
    //   336	344	382	finally
    //   347	355	382	finally
    //   360	365	382	finally
    //   401	438	382	finally
    //   336	344	386	java/lang/Exception
    //   347	355	386	java/lang/Exception
    //   360	365	386	java/lang/Exception
    //   316	321	391	finally
    //   321	331	391	finally
    //   316	321	395	java/lang/Exception
    //   321	331	395	java/lang/Exception
  }
  
  boolean a(String paramString, int paramInt)
  {
    return UinTypeUtil.c(paramString, paramInt);
  }
  
  List<TroopAssistantData> b(QQAppInterface paramQQAppInterface)
  {
    return TroopAssistantManager.a().n(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MsgCountChecker
 * JD-Core Version:    0.7.0.1
 */