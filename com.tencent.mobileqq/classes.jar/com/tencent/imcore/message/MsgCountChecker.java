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
    //   4: invokevirtual 33	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   7: iconst_1
    //   8: invokeinterface 38 2 0
    //   13: invokeinterface 44 1 0
    //   18: astore 10
    //   20: iconst_0
    //   21: istore 7
    //   23: iconst_0
    //   24: istore 5
    //   26: aload 10
    //   28: invokeinterface 50 1 0
    //   33: ifeq +469 -> 502
    //   36: aload 10
    //   38: invokeinterface 54 1 0
    //   43: checkcast 56	com/tencent/mobileqq/data/RecentUser
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
    //   64: getfield 60	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   67: lload_3
    //   68: lcmp
    //   69: ifle +418 -> 487
    //   72: aload 11
    //   74: getfield 64	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   77: getstatic 69	com/tencent/mobileqq/app/AppConstants:TROOP_ASSISTANT_UIN	Ljava/lang/String;
    //   80: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifeq +105 -> 188
    //   86: iload 9
    //   88: iconst_1
    //   89: isub
    //   90: istore 7
    //   92: aload_0
    //   93: aload_1
    //   94: invokevirtual 78	com/tencent/imcore/message/MsgCountChecker:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   97: invokeinterface 44 1 0
    //   102: astore 11
    //   104: iload 5
    //   106: istore 6
    //   108: iload 7
    //   110: istore 8
    //   112: aload 11
    //   114: invokeinterface 50 1 0
    //   119: ifeq +368 -> 487
    //   122: aload 11
    //   124: invokeinterface 54 1 0
    //   129: checkcast 80	com/tencent/mobileqq/data/TroopAssistantData
    //   132: astore 12
    //   134: iload 7
    //   136: iconst_1
    //   137: iadd
    //   138: istore 6
    //   140: iload 6
    //   142: istore 7
    //   144: aload 12
    //   146: getfield 81	com/tencent/mobileqq/data/TroopAssistantData:lastmsgtime	J
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
    //   166: getfield 84	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   169: iconst_1
    //   170: invokestatic 90	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   173: iconst_1
    //   174: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: invokevirtual 100	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: pop
    //   181: iload 6
    //   183: istore 7
    //   185: goto -81 -> 104
    //   188: aload_0
    //   189: aload 11
    //   191: getfield 64	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   194: aload 11
    //   196: invokevirtual 104	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   199: invokevirtual 107	com/tencent/imcore/message/MsgCountChecker:a	(Ljava/lang/String;I)Z
    //   202: ifeq +126 -> 328
    //   205: iload 9
    //   207: iconst_1
    //   208: isub
    //   209: istore 7
    //   211: aload_2
    //   212: aload 11
    //   214: getfield 64	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   217: aload 11
    //   219: invokevirtual 104	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   222: invokevirtual 112	com/tencent/imcore/message/BaseQQMessageFacade:a	(Ljava/lang/String;I)Ljava/util/List;
    //   225: invokeinterface 44 1 0
    //   230: astore 11
    //   232: iload 5
    //   234: istore 8
    //   236: iload 8
    //   238: istore 6
    //   240: iload 7
    //   242: istore 5
    //   244: aload 11
    //   246: invokeinterface 50 1 0
    //   251: ifeq +240 -> 491
    //   254: aload 11
    //   256: invokeinterface 54 1 0
    //   261: checkcast 86	com/tencent/mobileqq/data/MessageRecord
    //   264: astore 12
    //   266: iload 7
    //   268: iconst_1
    //   269: iadd
    //   270: istore 5
    //   272: iload 5
    //   274: istore 7
    //   276: aload 12
    //   278: getfield 115	com/tencent/mobileqq/data/MessageRecord:time	J
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
    //   298: getfield 118	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   301: aload 12
    //   303: getfield 122	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   306: invokestatic 90	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   309: aload 12
    //   311: getfield 122	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   314: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: invokevirtual 100	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   320: pop
    //   321: iload 5
    //   323: istore 7
    //   325: goto -89 -> 236
    //   328: iload 5
    //   330: istore 7
    //   332: aload 11
    //   334: getfield 64	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   337: invokestatic 127	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   340: invokevirtual 131	java/lang/Long:longValue	()J
    //   343: ldc2_w 132
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
    //   366: getfield 64	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   369: aload 11
    //   371: invokevirtual 104	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   374: invokestatic 90	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   377: aload 11
    //   379: invokevirtual 104	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   382: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   385: invokevirtual 100	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   423: invokevirtual 136	java/lang/NumberFormatException:printStackTrace	()V
    //   426: iload 7
    //   428: istore 6
    //   430: iload 8
    //   432: istore 5
    //   434: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +54 -> 491
    //   440: new 143	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   447: astore 12
    //   449: aload 12
    //   451: ldc 146
    //   453: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 12
    //   459: aload 11
    //   461: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: ldc 155
    //   467: iconst_2
    //   468: aload 12
    //   470: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   513: invokevirtual 167	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   516: astore 11
    //   518: aload_1
    //   519: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   522: astore 10
    //   524: aconst_null
    //   525: astore_1
    //   526: aconst_null
    //   527: astore_2
    //   528: aload 10
    //   530: ldc 173
    //   532: aconst_null
    //   533: invokevirtual 179	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   536: astore 10
    //   538: aload 10
    //   540: ifnull +83 -> 623
    //   543: aload 10
    //   545: astore_2
    //   546: aload 10
    //   548: astore_1
    //   549: aload 10
    //   551: invokeinterface 184 1 0
    //   556: ifeq +67 -> 623
    //   559: aload 10
    //   561: astore_2
    //   562: aload 10
    //   564: astore_1
    //   565: aload 10
    //   567: iconst_0
    //   568: invokeinterface 188 2 0
    //   573: invokestatic 194	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   576: astore 12
    //   578: aload 10
    //   580: astore_2
    //   581: aload 10
    //   583: astore_1
    //   584: aload 11
    //   586: aload 12
    //   588: invokeinterface 199 2 0
    //   593: ifne -50 -> 543
    //   596: aload 10
    //   598: astore_2
    //   599: aload 10
    //   601: astore_1
    //   602: aload_0
    //   603: getfield 16	com/tencent/imcore/message/MsgCountChecker:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   606: aload 12
    //   608: aload 12
    //   610: invokestatic 203	com/tencent/mobileqq/data/MessageRecord:getTypeByTableName	(Ljava/lang/String;)I
    //   613: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   616: invokevirtual 100	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   619: pop
    //   620: goto -77 -> 543
    //   623: aload 10
    //   625: ifnull +97 -> 722
    //   628: aload 10
    //   630: astore_1
    //   631: aload_1
    //   632: invokeinterface 206 1 0
    //   637: return
    //   638: astore_1
    //   639: goto +71 -> 710
    //   642: astore 10
    //   644: aload_1
    //   645: astore_2
    //   646: aload 10
    //   648: invokevirtual 207	java/lang/Exception:printStackTrace	()V
    //   651: aload_1
    //   652: astore_2
    //   653: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   656: ifeq +47 -> 703
    //   659: aload_1
    //   660: astore_2
    //   661: new 143	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   668: astore 11
    //   670: aload_1
    //   671: astore_2
    //   672: aload 11
    //   674: ldc 146
    //   676: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload_1
    //   681: astore_2
    //   682: aload 11
    //   684: aload 10
    //   686: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   689: pop
    //   690: aload_1
    //   691: astore_2
    //   692: ldc 155
    //   694: iconst_2
    //   695: aload 11
    //   697: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: aload_1
    //   704: ifnull +18 -> 722
    //   707: goto -76 -> 631
    //   710: aload_2
    //   711: ifnull +9 -> 720
    //   714: aload_2
    //   715: invokeinterface 206 1 0
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
        localObject = FTSMessageCodec.a((FTSMessage)localObject);
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
  
  List<TroopAssistantData> a(QQAppInterface paramQQAppInterface)
  {
    return TroopAssistantManager.a().b(paramQQAppInterface);
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
    //   1: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   4: astore 15
    //   6: aload 15
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aload 15
    //   14: aload_2
    //   15: invokevirtual 372	com/tencent/mobileqq/app/SQLiteDatabase:getCount	(Ljava/lang/String;)I
    //   18: istore 4
    //   20: iload 4
    //   22: sipush 6000
    //   25: if_icmple +621 -> 646
    //   28: iload 4
    //   30: sipush 5000
    //   33: isub
    //   34: sipush 1200
    //   37: invokestatic 378	java/lang/Math:max	(II)I
    //   40: istore 6
    //   42: aload_1
    //   43: invokevirtual 382	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   46: invokevirtual 387	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   49: checkcast 246	com/tencent/mobileqq/persistence/MessageRecordEntityManager
    //   52: astore 16
    //   54: aload 16
    //   56: invokevirtual 391	com/tencent/mobileqq/persistence/MessageRecordEntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
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
    //   88: if_icmpge +552 -> 640
    //   91: iload 5
    //   93: ifne +62 -> 155
    //   96: ldc_w 393
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
    //   115: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: invokestatic 397	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   122: astore 12
    //   124: ldc_w 399
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
    //   143: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: invokestatic 397	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   150: astore 11
    //   152: goto +143 -> 295
    //   155: iload 5
    //   157: iconst_1
    //   158: if_icmpeq +81 -> 239
    //   161: iload 5
    //   163: sipush 3000
    //   166: if_icmpeq +73 -> 239
    //   169: iload 5
    //   171: sipush 1026
    //   174: if_icmpne +6 -> 180
    //   177: goto +62 -> 239
    //   180: ldc_w 401
    //   183: iconst_3
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_2
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: aload_2
    //   194: aastore
    //   195: dup
    //   196: iconst_2
    //   197: iload 8
    //   199: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: aastore
    //   203: invokestatic 397	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   206: astore 12
    //   208: ldc_w 403
    //   211: iconst_3
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload_2
    //   218: aastore
    //   219: dup
    //   220: iconst_1
    //   221: aload_2
    //   222: aastore
    //   223: dup
    //   224: iconst_2
    //   225: iload 8
    //   227: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: aastore
    //   231: invokestatic 397	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   234: astore 11
    //   236: goto +59 -> 295
    //   239: ldc_w 405
    //   242: iconst_3
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload_2
    //   249: aastore
    //   250: dup
    //   251: iconst_1
    //   252: aload_2
    //   253: aastore
    //   254: dup
    //   255: iconst_2
    //   256: iload 8
    //   258: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   261: aastore
    //   262: invokestatic 397	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   265: astore 12
    //   267: ldc_w 407
    //   270: iconst_3
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload_2
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: aload_2
    //   281: aastore
    //   282: dup
    //   283: iconst_2
    //   284: iload 8
    //   286: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: aastore
    //   290: invokestatic 397	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   293: astore 11
    //   295: invokestatic 322	java/lang/System:currentTimeMillis	()J
    //   298: lstore 9
    //   300: aconst_null
    //   301: astore 13
    //   303: aload 14
    //   305: ifnull +8 -> 313
    //   308: aload 14
    //   310: invokevirtual 412	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   313: aload 16
    //   315: aload 11
    //   317: aconst_null
    //   318: invokevirtual 415	com/tencent/mobileqq/persistence/MessageRecordEntityManager:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   321: astore 11
    //   323: aload 11
    //   325: ifnull +322 -> 647
    //   328: aload_0
    //   329: aload 16
    //   331: aload 11
    //   333: invokespecial 417	com/tencent/imcore/message/MsgCountChecker:a	(Lcom/tencent/mobileqq/persistence/MessageRecordEntityManager;Ljava/util/List;)V
    //   336: goto +3 -> 339
    //   339: aload 15
    //   341: aload 12
    //   343: invokevirtual 421	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   346: pop
    //   347: aload 14
    //   349: ifnull +8 -> 357
    //   352: aload 14
    //   354: invokevirtual 423	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   357: aload 14
    //   359: ifnull +8 -> 367
    //   362: aload 14
    //   364: invokevirtual 426	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   367: aload 11
    //   369: astore 12
    //   371: goto +77 -> 448
    //   374: astore_1
    //   375: goto +253 -> 628
    //   378: astore 12
    //   380: goto +13 -> 393
    //   383: astore_1
    //   384: goto +244 -> 628
    //   387: astore 12
    //   389: aload 13
    //   391: astore 11
    //   393: new 143	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   400: astore 13
    //   402: aload 13
    //   404: ldc_w 428
    //   407: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 13
    //   413: aload 12
    //   415: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: ldc 155
    //   421: iconst_1
    //   422: aload 13
    //   424: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: aload 11
    //   432: astore 12
    //   434: aload 14
    //   436: ifnull +12 -> 448
    //   439: aload 14
    //   441: invokevirtual 426	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   444: aload 11
    //   446: astore 12
    //   448: aload 12
    //   450: ifnull +169 -> 619
    //   453: aload 12
    //   455: invokeinterface 431 1 0
    //   460: ifle +159 -> 619
    //   463: aload_1
    //   464: getstatic 436	com/tencent/mobileqq/app/QQManagerFactory:SLOW_TABLE_MANAGER	I
    //   467: invokevirtual 440	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   470: checkcast 442	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager
    //   473: astore 11
    //   475: aload 11
    //   477: ifnull +25 -> 502
    //   480: aload 11
    //   482: invokevirtual 445	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager:a	()Lcom/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory;
    //   485: invokevirtual 450	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory:isOpen	()Z
    //   488: ifne +6 -> 494
    //   491: goto +149 -> 640
    //   494: aload 11
    //   496: aload_2
    //   497: aload 12
    //   499: invokevirtual 453	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager:a	(Ljava/lang/String;Ljava/util/List;)V
    //   502: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   505: ifeq +114 -> 619
    //   508: new 143	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   515: astore 11
    //   517: aload 11
    //   519: ldc_w 455
    //   522: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload 11
    //   528: aload_2
    //   529: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 11
    //   535: ldc_w 457
    //   538: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 11
    //   544: iload 8
    //   546: invokevirtual 460	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload 11
    //   552: ldc_w 462
    //   555: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload 11
    //   561: iload 4
    //   563: invokevirtual 460	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload 11
    //   569: ldc_w 462
    //   572: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload 11
    //   578: iload 6
    //   580: invokevirtual 460	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 11
    //   586: ldc_w 464
    //   589: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload 11
    //   595: invokestatic 322	java/lang/System:currentTimeMillis	()J
    //   598: lload 9
    //   600: lsub
    //   601: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: ldc 155
    //   607: iconst_2
    //   608: aload 11
    //   610: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: goto +3 -> 619
    //   619: iload 4
    //   621: iconst_1
    //   622: iadd
    //   623: istore 4
    //   625: goto -544 -> 81
    //   628: aload 14
    //   630: ifnull +8 -> 638
    //   633: aload 14
    //   635: invokevirtual 426	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   638: aload_1
    //   639: athrow
    //   640: aload 16
    //   642: invokevirtual 468	com/tencent/mobileqq/persistence/MessageRecordEntityManager:close	()V
    //   645: return
    //   646: return
    //   647: goto -308 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	MsgCountChecker
    //   0	650	1	paramQQAppInterface	QQAppInterface
    //   0	650	2	paramString	String
    //   0	650	3	paramInt	int
    //   18	606	4	i	int
    //   82	93	5	j	int
    //   40	539	6	k	int
    //   69	20	7	m	int
    //   76	469	8	n	int
    //   298	301	9	l	long
    //   150	459	11	localObject1	Object
    //   122	248	12	localObject2	Object
    //   378	1	12	localException1	Exception
    //   387	27	12	localException2	Exception
    //   432	66	12	localObject3	Object
    //   301	122	13	localStringBuilder	StringBuilder
    //   59	575	14	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   4	336	15	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   52	589	16	localMessageRecordEntityManager	MessageRecordEntityManager
    // Exception table:
    //   from	to	target	type
    //   328	336	374	finally
    //   339	347	374	finally
    //   352	357	374	finally
    //   393	430	374	finally
    //   328	336	378	java/lang/Exception
    //   339	347	378	java/lang/Exception
    //   352	357	378	java/lang/Exception
    //   308	313	383	finally
    //   313	323	383	finally
    //   308	313	387	java/lang/Exception
    //   313	323	387	java/lang/Exception
  }
  
  boolean a(String paramString, int paramInt)
  {
    return UinTypeUtil.a(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.MsgCountChecker
 * JD-Core Version:    0.7.0.1
 */