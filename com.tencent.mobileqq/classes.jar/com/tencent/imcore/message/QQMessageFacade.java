package com.tencent.imcore.message;

import abnt;
import abnu;
import abod;
import abol;
import abom;
import aboq;
import abor;
import abot;
import abpa;
import abpb;
import abpc;
import abpd;
import abph;
import abpi;
import abpk;
import abpl;
import abpn;
import abpo;
import abpp;
import abpq;
import acfb;
import aeyf;
import afai;
import afsb;
import agyc;
import ahla;
import aieo;
import ajbg;
import ajfw;
import ajgm;
import akce;
import aljq;
import almv;
import aloz;
import alpr;
import alsi;
import alws;
import alxk;
import alxl;
import amfx;
import amfy;
import amfz;
import amga;
import amgf;
import amgi;
import amgz;
import amhl;
import amih;
import amjf;
import amjk;
import amjn;
import ammg;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import aoep;
import aokd;
import aped;
import apju;
import aqns;
import aqsc;
import arni;
import asil;
import asiu;
import asjd;
import atvk;
import atwd;
import aubr;
import aupt;
import aupu;
import awbw;
import awbx;
import awdh;
import axho;
import axso;
import ayvc;
import ayvw;
import ayvy;
import azlr;
import azmj;
import azto;
import azyl;
import azyu;
import baba;
import badt;
import bamw;
import batw;
import bbku;
import bblz;
import bbpk;
import bckx;
import bdbt;
import bdec;
import bdfe;
import bdli;
import bdqa;
import bhof;
import bjxj;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSActivity.SyncTroopSummaryTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.Wording;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NeedHandleUserData;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Sqlite;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import nan;
import nav;
import ntd;
import ntw;
import ssp;
import suv;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import xlf;

public class QQMessageFacade
  extends Observable
  implements Manager
{
  public static final Object a;
  private int jdField_a_of_type_Int = -1;
  private abph jdField_a_of_type_Abph;
  private abpk jdField_a_of_type_Abpk;
  private abpn jdField_a_of_type_Abpn;
  private abpp jdField_a_of_type_Abpp;
  public amih a;
  public Handler a;
  private SparseArray<abnt> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private atvk jdField_a_of_type_Atvk;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private List<ChatMessage> jdField_a_of_type_JavaUtilList;
  public final Map<String, QQMessageFacade.Message> a;
  public final ConcurrentHashMap<Integer, List<MessageRecord>> a;
  public final AtomicInteger a;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int = -1;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private String jdField_b_of_type_JavaLangString;
  public Map<String, Boolean> b;
  public final ConcurrentHashMap<String, Boolean> b;
  private final String jdField_c_of_type_JavaLangString = "Q.msg.QQMessageFacade";
  private Map<String, amgi> jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public QQMessageFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilMap = new QQConcurrentHashMap(1017, 0, 1200);
    this.jdField_b_of_type_JavaUtilMap = new QQConcurrentHashMap(1018, 0);
    this.jdField_a_of_type_Amih = new amih(paramQQAppInterface);
    a();
    this.jdField_a_of_type_Abph = new abpi();
    this.jdField_a_of_type_Abpp = new abpq();
    this.jdField_a_of_type_Abpn = new abpo();
    this.jdField_a_of_type_Abpk = new abpl();
  }
  
  private int a(int paramInt)
  {
    int k = 0;
    int i = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    int j = i;
    if (localObject != null)
    {
      if (((Set)localObject).isEmpty()) {
        j = i;
      }
    }
    else {
      return j;
    }
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("getUnreadMsgsNum type=" + paramInt + "{");; localStringBuilder = null)
    {
      localObject = ((Set)localObject).iterator();
      i = k;
      while (((Iterator)localObject).hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject).next();
        if (!a(localConversationInfo))
        {
          j = a(localConversationInfo.type).a(paramInt, localConversationInfo);
          if ((QLog.isColorLevel()) && (localStringBuilder != null) && (j > 0)) {
            localStringBuilder.append("[" + localConversationInfo.uin + "," + localConversationInfo.type + "," + j + "]");
          }
          i = a(localConversationInfo, j) + i;
        }
      }
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      j = i;
      if (localStringBuilder == null) {
        break;
      }
      j = i;
      if (i <= 0) {
        break;
      }
      localStringBuilder.append("}");
      QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
      return i;
    }
  }
  
  private int a(ConversationInfo paramConversationInfo, int paramInt)
  {
    int i = paramInt;
    if (paramConversationInfo.type == 1008)
    {
      i = paramInt;
      if (paramInt > 0)
      {
        int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(paramConversationInfo.uin, 1008);
        i = paramInt;
        if (j > 0) {
          i = paramInt - 1;
        }
        paramInt = i;
        if (aljq.aR.equals(paramConversationInfo.uin))
        {
          paramInt = i;
          if (j > 0) {
            paramInt = 0;
          }
        }
        i = paramInt;
        if (aljq.aS.equals(paramConversationInfo.uin)) {
          if (j <= 0)
          {
            i = paramInt;
            if (bjxj.k()) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    return i;
  }
  
  private abor a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt);
  }
  
  private QQMessageFacade.Message a(String paramString, int paramInt, awbw paramawbw)
  {
    return a(paramString, paramInt, paramawbw, 0);
  }
  
  private QQMessageFacade.Message a(String paramString, int paramInt1, awbw paramawbw, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramawbw, paramInt2);
  }
  
  private String a(String paramString, int paramInt)
  {
    return abot.a(paramString, paramInt);
  }
  
  /* Error */
  private void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 140	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   7: invokevirtual 282	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lamjk;
    //   10: iconst_1
    //   11: invokevirtual 287	amjk:a	(Z)Ljava/util/List;
    //   14: invokeinterface 290 1 0
    //   19: astore 8
    //   21: iconst_0
    //   22: istore_3
    //   23: iconst_0
    //   24: istore 4
    //   26: aload 8
    //   28: invokeinterface 191 1 0
    //   33: ifeq +422 -> 455
    //   36: aload 8
    //   38: invokeinterface 195 1 0
    //   43: checkcast 292	com/tencent/mobileqq/data/RecentUser
    //   46: astore 9
    //   48: iload 4
    //   50: iconst_1
    //   51: iadd
    //   52: istore 7
    //   54: iload_3
    //   55: istore 6
    //   57: iload 7
    //   59: istore 5
    //   61: aload 9
    //   63: getfield 296	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   66: lload_1
    //   67: lcmp
    //   68: ifle +377 -> 445
    //   71: aload 9
    //   73: getfield 297	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   76: getstatic 300	aljq:C	Ljava/lang/String;
    //   79: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +103 -> 185
    //   85: invokestatic 305	atwd:a	()Latwd;
    //   88: aload_0
    //   89: getfield 81	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   92: invokevirtual 308	atwd:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   95: invokeinterface 290 1 0
    //   100: astore 9
    //   102: iload 7
    //   104: iconst_1
    //   105: isub
    //   106: istore 4
    //   108: aload 9
    //   110: invokeinterface 191 1 0
    //   115: ifeq +67 -> 182
    //   118: aload 9
    //   120: invokeinterface 195 1 0
    //   125: checkcast 310	com/tencent/mobileqq/data/TroopAssistantData
    //   128: astore 10
    //   130: iload 4
    //   132: iconst_1
    //   133: iadd
    //   134: istore 5
    //   136: iload 5
    //   138: istore 4
    //   140: aload 10
    //   142: getfield 311	com/tencent/mobileqq/data/TroopAssistantData:lastmsgtime	J
    //   145: lload_1
    //   146: lcmp
    //   147: ifle -39 -> 108
    //   150: iload_3
    //   151: iconst_1
    //   152: iadd
    //   153: istore_3
    //   154: aload_0
    //   155: getfield 53	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   158: aload 10
    //   160: getfield 314	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   163: iconst_1
    //   164: invokestatic 319	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   167: iconst_1
    //   168: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: invokevirtual 329	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: iload 5
    //   177: istore 4
    //   179: goto -71 -> 108
    //   182: goto -156 -> 26
    //   185: aload 9
    //   187: getfield 297	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   190: aload 9
    //   192: invokevirtual 333	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   195: invokestatic 336	abot:b	(Ljava/lang/String;I)Z
    //   198: ifeq +115 -> 313
    //   201: iload 7
    //   203: iconst_1
    //   204: isub
    //   205: istore 4
    //   207: aload_0
    //   208: aload 9
    //   210: getfield 297	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   213: aload 9
    //   215: invokevirtual 333	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   218: invokevirtual 339	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)Ljava/util/List;
    //   221: invokeinterface 290 1 0
    //   226: astore 9
    //   228: aload 9
    //   230: invokeinterface 191 1 0
    //   235: ifeq +75 -> 310
    //   238: aload 9
    //   240: invokeinterface 195 1 0
    //   245: checkcast 316	com/tencent/mobileqq/data/MessageRecord
    //   248: astore 10
    //   250: iload 4
    //   252: iconst_1
    //   253: iadd
    //   254: istore 5
    //   256: iload 5
    //   258: istore 4
    //   260: aload 10
    //   262: getfield 342	com/tencent/mobileqq/data/MessageRecord:time	J
    //   265: lload_1
    //   266: lcmp
    //   267: ifle -39 -> 228
    //   270: iload_3
    //   271: iconst_1
    //   272: iadd
    //   273: istore_3
    //   274: aload_0
    //   275: getfield 53	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   278: aload 10
    //   280: getfield 345	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   283: aload 10
    //   285: getfield 348	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   288: invokestatic 319	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   291: aload 10
    //   293: getfield 348	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   296: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   299: invokevirtual 329	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   302: pop
    //   303: iload 5
    //   305: istore 4
    //   307: goto -79 -> 228
    //   310: goto -128 -> 182
    //   313: iload_3
    //   314: istore 4
    //   316: aload 9
    //   318: getfield 297	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   321: invokestatic 353	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   324: invokevirtual 357	java/lang/Long:longValue	()J
    //   327: ldc2_w 358
    //   330: lcmp
    //   331: ifle +46 -> 377
    //   334: iload_3
    //   335: iconst_1
    //   336: iadd
    //   337: istore_3
    //   338: iload_3
    //   339: istore 4
    //   341: aload_0
    //   342: getfield 53	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   345: aload 9
    //   347: getfield 297	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   350: aload 9
    //   352: invokevirtual 333	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   355: invokestatic 319	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   358: aload 9
    //   360: invokevirtual 333	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   363: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: invokevirtual 329	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   369: pop
    //   370: iload 7
    //   372: istore 4
    //   374: goto -192 -> 182
    //   377: iload 7
    //   379: iconst_1
    //   380: isub
    //   381: istore 4
    //   383: goto -9 -> 374
    //   386: astore 9
    //   388: iload 7
    //   390: iconst_1
    //   391: isub
    //   392: istore_3
    //   393: aload 9
    //   395: invokevirtual 362	java/lang/NumberFormatException:printStackTrace	()V
    //   398: iload 4
    //   400: istore 6
    //   402: iload_3
    //   403: istore 5
    //   405: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +37 -> 445
    //   411: ldc 66
    //   413: iconst_2
    //   414: new 163	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 364
    //   424: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 9
    //   429: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: iload_3
    //   439: istore 5
    //   441: iload 4
    //   443: istore 6
    //   445: iload 6
    //   447: istore_3
    //   448: iload 5
    //   450: istore 4
    //   452: goto -270 -> 182
    //   455: iload_3
    //   456: iload 4
    //   458: if_icmpne +173 -> 631
    //   461: aload_0
    //   462: getfield 53	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   465: invokevirtual 370	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   468: astore 10
    //   470: aload_0
    //   471: getfield 81	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   474: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   477: astore 8
    //   479: aload 8
    //   481: ldc_w 375
    //   484: aconst_null
    //   485: invokevirtual 380	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   488: astore 9
    //   490: aload 9
    //   492: ifnull +140 -> 632
    //   495: aload 9
    //   497: astore 8
    //   499: aload 9
    //   501: invokeinterface 385 1 0
    //   506: ifeq +126 -> 632
    //   509: aload 9
    //   511: astore 8
    //   513: aload 9
    //   515: iconst_0
    //   516: invokeinterface 389 2 0
    //   521: invokestatic 394	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   524: astore 11
    //   526: aload 9
    //   528: astore 8
    //   530: aload 10
    //   532: aload 11
    //   534: invokeinterface 397 2 0
    //   539: ifne -44 -> 495
    //   542: aload 9
    //   544: astore 8
    //   546: aload_0
    //   547: getfield 53	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   550: aload 11
    //   552: aload 11
    //   554: invokestatic 401	com/tencent/mobileqq/data/MessageRecord:getTypeByTableName	(Ljava/lang/String;)I
    //   557: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   560: invokevirtual 329	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   563: pop
    //   564: goto -69 -> 495
    //   567: astore 10
    //   569: aload 9
    //   571: astore 8
    //   573: aload 10
    //   575: invokevirtual 402	java/lang/Exception:printStackTrace	()V
    //   578: aload 9
    //   580: astore 8
    //   582: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   585: ifeq +34 -> 619
    //   588: aload 9
    //   590: astore 8
    //   592: ldc 66
    //   594: iconst_2
    //   595: new 163	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 364
    //   605: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 10
    //   610: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: aload 9
    //   621: ifnull +10 -> 631
    //   624: aload 9
    //   626: invokeinterface 405 1 0
    //   631: return
    //   632: aload 9
    //   634: ifnull -3 -> 631
    //   637: aload 9
    //   639: invokeinterface 405 1 0
    //   644: return
    //   645: astore 9
    //   647: aconst_null
    //   648: astore 8
    //   650: aload 8
    //   652: ifnull +10 -> 662
    //   655: aload 8
    //   657: invokeinterface 405 1 0
    //   662: aload 9
    //   664: athrow
    //   665: astore 9
    //   667: goto -17 -> 650
    //   670: astore 10
    //   672: aconst_null
    //   673: astore 9
    //   675: goto -106 -> 569
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	678	0	this	QQMessageFacade
    //   0	678	1	paramLong	long
    //   22	437	3	i	int
    //   24	435	4	j	int
    //   59	390	5	k	int
    //   55	391	6	m	int
    //   52	340	7	n	int
    //   19	637	8	localObject1	Object
    //   46	313	9	localObject2	Object
    //   386	42	9	localNumberFormatException	java.lang.NumberFormatException
    //   488	150	9	localCursor	Cursor
    //   645	18	9	localObject3	Object
    //   665	1	9	localObject4	Object
    //   673	1	9	localObject5	Object
    //   128	403	10	localObject6	Object
    //   567	42	10	localException1	Exception
    //   670	1	10	localException2	Exception
    //   524	29	11	str	String
    // Exception table:
    //   from	to	target	type
    //   316	334	386	java/lang/NumberFormatException
    //   341	370	386	java/lang/NumberFormatException
    //   499	509	567	java/lang/Exception
    //   513	526	567	java/lang/Exception
    //   530	542	567	java/lang/Exception
    //   546	564	567	java/lang/Exception
    //   479	490	645	finally
    //   499	509	665	finally
    //   513	526	665	finally
    //   530	542	665	finally
    //   546	564	665	finally
    //   573	578	665	finally
    //   582	588	665	finally
    //   592	619	665	finally
    //   479	490	670	java/lang/Exception
  }
  
  private void a(String paramString, MessageRecord paramMessageRecord)
  {
    paramString = (alxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
    if (!nav.a(paramMessageRecord)) {
      paramString.a(paramMessageRecord);
    }
  }
  
  private void a(List<MessageRecord> paramList, awbw paramawbw, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    long l1 = System.currentTimeMillis();
    int i;
    if (QLog.isColorLevel())
    {
      if (paramList != null) {
        break label297;
      }
      i = 0;
    }
    long l2;
    label120:
    Object localObject3;
    for (;;)
    {
      a(String.format("addMultiMessagesInner size = %s, sync = %s, saveToDB = %s, needUpdateUnread = %s, needAddAIO = %s ", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) }), null);
      if ((paramList != null) && (paramList.isEmpty())) {}
      localObject1 = new abnu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      l2 = paramList.size();
      d(paramList);
      localObject2 = paramList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        i = FlashChatManager.a((MessageRecord)localObject3);
        if (i != -1) {}
        try
        {
          ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(i, (MessageRecord)localObject3);
          if (((MessageRecord)localObject3).msgtype == -2029) {
            QLog.d("VideoRedBag", 1, new Object[] { "onReceiveGrapTips, uniseq:", Long.valueOf(((MessageRecord)localObject3).uniseq), " uin:", ((MessageRecord)localObject3).frienduin, " type:", Integer.valueOf(((MessageRecord)localObject3).istroop) });
          }
          a(((MessageRecord)localObject3).istroop).a((MessageRecord)localObject3, paramawbw, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, (abnu)localObject1);
          if (!afsb.a(((MessageRecord)localObject3).frienduin)) {
            break label120;
          }
          akce.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3);
          break label120;
          label297:
          i = paramList.size();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.QQMessageFacade", 2, "addMultiMessagesInner type " + i, localException2);
            }
          }
        }
      }
    }
    paramawbw = ((abnu)localObject1).g.keySet().iterator();
    while (paramawbw.hasNext())
    {
      localObject3 = (String)paramawbw.next();
      localObject2 = (ntw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      localObject3 = ((List)((abnu)localObject1).g.get(localObject3)).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((ntw)localObject2).a((MessageRecord)((Iterator)localObject3).next(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    ((abnu)localObject1).g.clear();
    paramawbw = a();
    int j;
    if (paramawbw != null)
    {
      j = 0;
      if (paramawbw.istroop == 1)
      {
        localObject2 = ((abnu)localObject1).jdField_a_of_type_Aubr.a(paramawbw.frienduin);
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (((bbku)localObject2).b() == paramawbw.shmsgseq) {
            i = ((bbku)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, paramawbw.frienduin);
          }
        }
        paramawbw.bizType = i;
      }
    }
    else
    {
      if (paramBoolean3) {
        ((abnu)localObject1).jdField_a_of_type_Abol.a(paramList);
      }
      localObject2 = ((abnu)localObject1).jdField_a_of_type_JavaUtilMap.keySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label869;
      }
      localObject3 = (String)((Iterator)localObject2).next();
      localObject3 = (RecentUser)((abnu)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject3);
      try
      {
        aupu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject3);
        ajgm.a((RecentUser)localObject3, this);
        ((abnu)localObject1).jdField_a_of_type_Amjk.a((RecentUser)localObject3);
        if (((RecentUser)localObject3).getType() == 1038) {
          ((ajbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(315)).a((RecentUser)localObject3);
        }
        if (paramawbw == null) {
          continue;
        }
        if (paramawbw.istroop != 3000) {
          break label852;
        }
        ((abnu)localObject1).jdField_a_of_type_Aubr.b(((RecentUser)localObject3).uin + "&" + 3000);
      }
      catch (Exception localException1) {}
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.QQMessageFacade", 2, "addMultiMessagesInner --> Catch Exception .Info = " + localException1);
        continue;
        i = j;
        if (paramawbw.istroop != 3000) {
          break;
        }
        localObject2 = ((abnu)localObject1).jdField_a_of_type_Aubr.a(paramawbw.frienduin + "&" + 3000);
        i = j;
        if (localObject2 == null) {
          break;
        }
        i = j;
        if (((bbku)localObject2).b() != paramawbw.shmsgseq) {
          break;
        }
        i = ((bbku)localObject2).a();
        break;
        label852:
        ((abnu)localObject1).jdField_a_of_type_Aubr.b(localException1.uin);
      }
    }
    label869:
    paramawbw = ((abnu)localObject1).jdField_b_of_type_JavaUtilMap.keySet().iterator();
    while (paramawbw.hasNext())
    {
      localObject2 = (String)paramawbw.next();
      atwd.a().a((MessageRecord)((abnu)localObject1).jdField_b_of_type_JavaUtilMap.get(localObject2), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    paramawbw = (alpr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255);
    Object localObject2 = ((abnu)localObject1).jdField_c_of_type_JavaUtilMap.keySet().iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      paramawbw.a((MessageRecord)((abnu)localObject1).jdField_c_of_type_JavaUtilMap.get(localObject4));
    }
    paramawbw = ((abnu)localObject1).d.keySet().iterator();
    while (paramawbw.hasNext())
    {
      localObject2 = (String)paramawbw.next();
      localObject4 = (MessageRecord)((abnu)localObject1).d.get(localObject2);
      localObject2 = a(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop);
      a((QQMessageFacade.Message)localObject2);
      if ((localObject4 instanceof MessageForPic))
      {
        localObject4 = bdec.a((MessageForPic)localObject4);
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          ((QQMessageFacade.Message)localObject2).msg = ((String)localObject4);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "addMessage decodeMsg uin = " + ((QQMessageFacade.Message)localObject2).frienduin + " , type = " + ((QQMessageFacade.Message)localObject2).istroop + " ,msgType:" + ((QQMessageFacade.Message)localObject2).msgtype + ", con = " + ((QQMessageFacade.Message)localObject2).getLogColorContent());
      }
    }
    paramawbw = ((abnu)localObject1).f.keySet().iterator();
    while (paramawbw.hasNext())
    {
      localObject2 = (String)paramawbw.next();
      localObject2 = ((List)((abnu)localObject1).f.get(localObject2)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject2).next();
        suv.a().a((MessageRecord)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    ((abnu)localObject1).f.clear();
    bhof.a().a(System.currentTimeMillis() - l1, l2);
    paramawbw = ssp.a();
    Object localObject1 = (ammg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(199);
    localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (MessageRecord)((Iterator)localObject2).next();
      paramawbw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject4);
      ntd.a((MessageRecord)localObject4);
      if ((localObject1 != null) && (((ammg)localObject1).a())) {
        ((ammg)localObject1).b(((MessageRecord)localObject4).senderuin);
      }
      if (((localObject4 instanceof MessageForShortVideo)) && (((MessageForShortVideo)localObject4).redBagType == LocalMediaInfo.REDBAG_TYPE_GET))
      {
        localObject4 = (MessageForShortVideo)localObject4;
        VideoRedbagData.insertData(((MessageForShortVideo)localObject4).shortVideoId, ((MessageForShortVideo)localObject4).uniseq, ((MessageForShortVideo)localObject4).redBagStat);
      }
    }
    aeyf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
  }
  
  private abnt b(int paramInt)
  {
    aboq localaboq = a(paramInt).a();
    switch (paramInt)
    {
    default: 
      return new abod(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localaboq);
    case 1: 
      return new bbpk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localaboq);
    case 3000: 
      return new amga(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localaboq);
    case 7000: 
      return new amgz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localaboq);
    case 1026: 
      return new amgf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localaboq);
    }
    return new amhl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localaboq);
  }
  
  private void b(awbw paramawbw)
  {
    Object localObject = paramawbw.a(TroopAssistantData.class, false, null, null, null, null, "lastmsgtime desc", null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopAssistantData)((Iterator)localObject).next()).troopUin, 1, paramawbw);
      }
    }
  }
  
  private void d(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.frienduin != null) && (paramMessage.frienduin.equals(aljq.w)) && (paramMessage.istroop == 1009))
    {
      paramMessage.unReadNum = 0;
      Object localObject = a(paramMessage.istroop).a(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          int i = paramMessage.unReadNum;
          paramMessage.unReadNum = (a(paramMessage.istroop).a(localMessageRecord.senderuin, localMessageRecord.istroop, 0L) + i);
        }
        localawbw.a();
      }
    }
  }
  
  private void g(String paramString, int paramInt)
  {
    Object localObject = a(paramInt).a(paramString, paramInt);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (abot.c(localMessageRecord.senderuin))
        {
          g(localMessageRecord.senderuin, localMessageRecord.istroop);
        }
        else if (((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(localMessageRecord.senderuin))
        {
          a().a(paramString, paramInt, localMessageRecord.frienduin, localMessageRecord.istroop);
          a(paramString, paramInt, localMessageRecord.senderuin, localMessageRecord.selfuin);
          QQMessageFacade.Message localMessage = a(localMessageRecord.senderuin, paramInt);
          amjk localamjk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          RecentUser localRecentUser = localamjk.a(localMessage.frienduin, localMessage.istroop);
          localRecentUser.lastmsgtime = localMessage.time;
          ajgm.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localamjk.a(localRecentUser);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "refreshMsgBox uin=" + paramString + ",type=" + paramInt + ",move " + localMessageRecord.senderuin + " from box to recentlist");
          }
          setChanged();
          notifyObservers(localRecentUser);
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt, String paramString)
  {
    abol localabol = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localabol != null) {
      return localabol.a(paramString, paramInt);
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true, true);
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return a(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public int a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    if (localSQLiteDatabase != null)
    {
      i = j;
      if (paramBoolean) {
        i = -1000;
      }
      i = localSQLiteDatabase.a(paramString, paramLong1, paramLong2, i);
    }
    return i;
  }
  
  public long a(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(paramString, 0);
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size() - 1;
      if (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ((((MessageRecord)localObject2).senderuin != null) && (((MessageRecord)localObject2).senderuin.equals(paramString)))
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel()) {
            QLog.i("vip", 2, "getLastC2CBubleID find in cache");
          }
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a(paramString, 0, 9223372036854775807L, 1, String.format("issend<>%d and issend<>%d", new Object[] { Integer.valueOf(1), Integer.valueOf(2) }));
        paramString = (String)localObject1;
        if (localObject2 != null)
        {
          paramString = (String)localObject1;
          if (!((List)localObject2).isEmpty()) {
            paramString = (MessageRecord)((List)localObject2).get(0);
          }
        }
        localObject2 = paramString;
        if (QLog.isColorLevel())
        {
          QLog.d("vip", 2, "getLastC2CBubleID find in db");
          localObject2 = paramString;
        }
      }
      if (localObject2 == null)
      {
        return 0L;
        i -= 1;
        break;
      }
      return ((MessageRecord)localObject2).vipBubbleID;
    }
  }
  
  public long a(String paramString, int paramInt)
  {
    long l2 = -1L;
    Object localObject;
    long l1;
    if ((paramInt == 1) || (paramInt == 3000) || (paramInt == 1026))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
      l2 = ((QQMessageFacade.Message)localObject).shmsgseq;
      l1 = l2;
      if (((QQMessageFacade.Message)localObject).isLongMsg())
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt);
        l1 = l2;
        if (paramString != null)
        {
          l1 = l2;
          if (paramString.size() > 0) {
            return Math.max(l2, ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq);
          }
        }
      }
    }
    else
    {
      l1 = l2;
      if (abot.d(paramInt))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(paramString, paramInt);
        l1 = l2;
        if (paramString != null)
        {
          l1 = l2;
          if (!paramString.isEmpty())
          {
            paramInt = paramString.size() - 1;
            for (;;)
            {
              l1 = l2;
              if (paramInt < 0) {
                break;
              }
              localObject = (MessageRecord)paramString.get(paramInt);
              if (!bdec.b(((MessageRecord)localObject).issend)) {
                return ((MessageRecord)localObject).time;
              }
              paramInt -= 1;
            }
          }
        }
      }
    }
    return l1;
  }
  
  public long a(String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(paramString1, 0);
    int i;
    MessageRecord localMessageRecord;
    if (paramString1 != null)
    {
      i = paramString1.size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)paramString1.get(i);
        if (localMessageRecord.senderuin.equals(paramString2))
        {
          paramString1 = localMessageRecord;
          if (QLog.isColorLevel()) {
            QLog.i("vip", 2, "getLastC2CBubleID find in cache");
          }
        }
      }
    }
    for (paramString1 = localMessageRecord;; paramString1 = null)
    {
      if (paramString1 == null)
      {
        return 0L;
        i -= 1;
        break;
      }
      return paramString1.vipBubbleID;
    }
  }
  
  public abnt a(int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      abnt localabnt2 = (abnt)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      abnt localabnt1 = localabnt2;
      if (localabnt2 == null)
      {
        localabnt1 = b(paramInt);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localabnt1);
      }
      return localabnt1;
    }
  }
  
  public abod a()
  {
    return (abod)a(0);
  }
  
  public abol a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  public abph a()
  {
    return this.jdField_a_of_type_Abph;
  }
  
  public abpk a()
  {
    return this.jdField_a_of_type_Abpk;
  }
  
  public abpn a()
  {
    return this.jdField_a_of_type_Abpn;
  }
  
  public abpp a()
  {
    return this.jdField_a_of_type_Abpp;
  }
  
  public amfy a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (String str = "dataline_manager_pc";; str = "dataline_manager_ipad") {
      return (amfy)a(str);
    }
  }
  
  public amga a()
  {
    return (amga)a(3000);
  }
  
  public amgi a(String paramString)
  {
    if (this.jdField_c_of_type_JavaUtilMap == null) {
      return null;
    }
    if (!this.jdField_c_of_type_JavaUtilMap.containsKey(paramString)) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.jdField_c_of_type_JavaUtilMap)
      {
        if (this.jdField_c_of_type_JavaUtilMap.containsKey(paramString)) {
          break label116;
        }
        if ("dataline_manager_pc".equals(paramString))
        {
          localObject = new amfz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          if (localObject != null) {
            break label104;
          }
          return null;
        }
      }
      if ("dataline_manager_ipad".equals(paramString))
      {
        localObject = new amfx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        continue;
        label104:
        this.jdField_c_of_type_JavaUtilMap.put(paramString, localObject);
        label116:
        return (amgi)this.jdField_c_of_type_JavaUtilMap.get(paramString);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public bbpk a()
  {
    return (bbpk)a(1);
  }
  
  public QQMessageFacade.Message a()
  {
    return this.jdField_a_of_type_Amih.a();
  }
  
  @Nullable
  protected QQMessageFacade.Message a(long paramLong, List<MessageRecord> paramList)
  {
    int i = 0;
    while ((paramList != null) && (i < paramList.size()))
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if ((localMessageRecord != null) && (localMessageRecord.uniseq > paramLong))
      {
        paramList = new QQMessageFacade.Message();
        paramList.frienduin = localMessageRecord.frienduin;
        paramList.istroop = localMessageRecord.istroop;
        paramList.time = localMessageRecord.time;
        paramList.isread = localMessageRecord.isread;
        a(paramList);
        return paramList;
      }
      i += 1;
    }
    return null;
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, false);
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1033) || (paramInt1 == 1034)) {}
    for (int i = 1; i != 0; i = 0) {
      return b(paramString, paramInt1, paramInt2);
    }
    return a(paramString, paramInt1);
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null)
    {
      paramString = new QQMessageFacade.Message();
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder("Case:");
    String str1 = a(paramString, paramInt);
    QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(str1);
    Object localObject1;
    if (localMessage != null)
    {
      localObject1 = localMessage;
      if (localMessage.isCacheValid) {}
    }
    else
    {
      if (this.jdField_b_of_type_Int != 0) {
        break label206;
      }
      localObject1 = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject1).frienduin = paramString;
      ((QQMessageFacade.Message)localObject1).istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
      localStringBuilder.append("All-In");
    }
    for (;;)
    {
      if ((localObject1 != null) && (abot.b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop))) {
        ((QQMessageFacade.Message)localObject1).istroop = abot.a(((QQMessageFacade.Message)localObject1).istroop);
      }
      paramString = (String)localObject1;
      if (((QQMessageFacade.Message)localObject1).istroop != 1) {
        break;
      }
      paramString = (String)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.QQMessageFacade", 2, "getLastMessage " + ((QQMessageFacade.Message)localObject1).getBaseInfoString());
      return localObject1;
      label206:
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject1 = localMessage;
        if (localMessage == null)
        {
          if ((!ajfw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || ((!paramBoolean) && (Looper.getMainLooper() == Looper.myLooper()))) {
            break label369;
          }
          localObject2 = MessageRecord.getTableName(paramString, paramInt);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (((awbw)localObject1).d((String)localObject2))
          {
            localMessage = a(paramString, paramInt, (awbw)localObject1);
            localStringBuilder.append("Not-Finish-Yet，force Check DB");
          }
          ((awbw)localObject1).a();
          localObject1 = localMessage;
          if (localMessage == null)
          {
            localObject1 = new QQMessageFacade.Message();
            ((QQMessageFacade.Message)localObject1).frienduin = paramString;
            ((QQMessageFacade.Message)localObject1).istroop = paramInt;
            ((QQMessageFacade.Message)localObject1).isCacheValid = false;
            this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
            localStringBuilder.append("Not-Finish-Yet，force Check DB But Null");
          }
        }
        for (;;)
        {
          localStringBuilder.append("Not-Finish-Yet");
          break;
          label369:
          localObject1 = new QQMessageFacade.Message();
          ((QQMessageFacade.Message)localObject1).frienduin = paramString;
          ((QQMessageFacade.Message)localObject1).istroop = paramInt;
          ((QQMessageFacade.Message)localObject1).isCacheValid = false;
          this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
        }
      }
      localObject1 = MessageRecord.getTableName(paramString, paramInt);
      String str2 = MessageRecord.getOldTableName(paramString, paramInt);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if ((!((awbw)localObject2).d((String)localObject1)) && (!((awbw)localObject2).d(str2))) {
        break label530;
      }
      localMessage = a(paramString, paramInt, (awbw)localObject2);
      localStringBuilder.append("Check-DB");
      localObject1 = localMessage;
      if (localMessage == null)
      {
        localObject1 = new QQMessageFacade.Message();
        ((QQMessageFacade.Message)localObject1).frienduin = paramString;
        ((QQMessageFacade.Message)localObject1).istroop = paramInt;
        this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
      }
      ((awbw)localObject2).a();
    }
    label530:
    if (localMessage == null)
    {
      localObject1 = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject1).frienduin = paramString;
      ((QQMessageFacade.Message)localObject1).istroop = paramInt;
      this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
    }
    for (;;)
    {
      localStringBuilder.append("Not-In-TableCache");
      break;
      localMessage.isCacheValid = true;
      localObject1 = localMessage;
    }
  }
  
  public MsgSummary a(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    for (;;)
    {
      try
      {
        if (!(a(localMessage.istroop) instanceof bbpk)) {
          continue;
        }
        if (!TextUtils.isEmpty(bdbt.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage.frienduin, localMessage.senderuin))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "getMsgSummaryStrForTroop nickname is null");
        }
        b(localMessage);
        ThreadManager.getSubThreadHandler().post(new QQLSActivity.SyncTroopSummaryTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((QQLSActivity)paramContext).a, localMessage.senderuin, localMessage.frienduin));
      }
      catch (Throwable paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        continue;
        a(localMessage);
        continue;
      }
      paramMessageRecord = new MsgSummary();
      bdec.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
      return paramMessageRecord;
      a(localMessage);
    }
  }
  
  public ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    return a(paramSessionInfo.jdField_a_of_type_Int).a(paramSessionInfo, paramString);
  }
  
  public ChatHistorySearchData a(String paramString, int paramInt, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    ChatHistorySearchData localChatHistorySearchData = new ChatHistorySearchData();
    localChatHistorySearchData.mSearchData1 = a(paramInt).c(paramString, paramInt, paramList);
    return localChatHistorySearchData;
  }
  
  public DraftSummaryInfo a(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_Atvk != null)) {
      return this.jdField_a_of_type_Atvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
    }
    return null;
  }
  
  public MessageRecord a(QQMessageFacade.Message paramMessage)
  {
    MessageRecord localMessageRecord = ayvw.a(paramMessage.msgtype, paramMessage.msgData, paramMessage.extLong, paramMessage.extStr, paramMessage.istroop);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessage);
    if ((localMessageRecord instanceof ChatMessage)) {
      ((ChatMessage)localMessageRecord).parse();
    }
    return localMessageRecord;
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.longMsgIndex == 0) {}
    List localList;
    do
    {
      return paramMessageRecord;
      localList = a(paramMessageRecord.istroop).b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    } while ((localList == null) || (localList.isEmpty()));
    int i = localList.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      if (abot.a(localMessageRecord, paramMessageRecord))
      {
        if (localMessageRecord.longMsgIndex == 0) {
          return localMessageRecord;
        }
        if (localMessageRecord.longMsgIndex < paramMessageRecord.longMsgIndex) {
          paramMessageRecord = localMessageRecord;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
      }
    }
    return paramMessageRecord;
  }
  
  public MessageRecord a(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).b(paramString, paramInt);
    if (localObject1 != null)
    {
      int i = ((List)localObject1).size() - 1;
      Object localObject2;
      if (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ((((MessageRecord)localObject2).isValid) && (!abot.h(((MessageRecord)localObject2).msgtype)))
        {
          localObject1 = localObject2;
          if (!((MessageRecord)localObject2).isLongMsg()) {}
        }
      }
      for (localObject1 = a((MessageRecord)localObject2);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramInt).b(paramString, paramInt, null);
        }
        return localObject2;
        i -= 1;
        break;
      }
    }
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).a(paramString, paramInt, paramLong);
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public MessageRecord a(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    return a(paramInt1).a(paramString1, paramInt1, paramLong1, paramString2, paramString3, paramLong2, paramInt2);
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    abor localabor = a(paramInt);
    if ((localabor instanceof bblz)) {
      return ((bblz)localabor).a(paramString, paramInt, paramMessageRecord);
    }
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    abor localabor = a(paramInt);
    if ((localabor instanceof bblz)) {
      return ((bblz)localabor).a(paramString, paramInt, paramMessageRecord, paramList);
    }
    return null;
  }
  
  public MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramInt).a(paramString1, paramInt, paramString2);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return a(paramContext, paramMessageRecord, paramBoolean).a(paramContext).toString();
  }
  
  public String a(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean)
  {
    String str4 = "select * from " + paramString;
    String str1 = null;
    String str2 = null;
    if (paramLong1 >= 0L) {}
    for (paramString = String.format(" time >= %d and time <= %d ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });; paramString = null)
    {
      if (paramLong3 >= 0L) {}
      for (String str3 = String.format(" _id >= %d ", new Object[] { Long.valueOf(paramLong3) });; str3 = null)
      {
        int i;
        if (paramBoolean)
        {
          i = -1000;
          if (i == -1000) {
            str2 = " msgtype = " + i;
          }
          if (paramString != null) {
            str1 = " where " + paramString;
          }
          paramString = str1;
          if (str3 != null)
          {
            if (str1 == null) {
              break label323;
            }
            paramString = str1 + " and " + str3;
          }
          label194:
          str1 = paramString;
          if (str2 != null) {
            if (paramString == null) {
              break label348;
            }
          }
        }
        label323:
        label348:
        for (str1 = paramString + " and " + str2;; str1 = " where " + str2)
        {
          paramString = str4;
          if (str1 != null) {
            paramString = str4 + str1;
          }
          str1 = paramString;
          if (paramInt > 0)
          {
            str1 = " order by _id limit " + paramInt;
            str1 = paramString + str1;
          }
          return str1;
          i = 0;
          break;
          paramString = " where " + str3;
          break label194;
        }
      }
    }
  }
  
  public String a(String paramString1, String paramString2, long paramLong)
  {
    int j = 0;
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a(paramString1, 0, false, false);
    paramString1 = null;
    int i;
    Object localObject;
    if (localList != null)
    {
      i = localList.size() - 1;
      if (i < 0) {
        break label128;
      }
      localObject = (MessageRecord)localList.get(i);
      if (((MessageRecord)localObject).uniseq == paramLong) {
        j = 1;
      }
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        paramString1 = (String)localObject;
        if (j == 0) {}
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "chatthumb";
        }
        return ((MessageForPic)localObject).getFilePath(paramString1);
        i -= 1;
        break;
      }
      return "";
      label128:
      localObject = paramString1;
    }
  }
  
  public List<ChatMessage> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<ChatMessage> a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1L);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramInt2, null);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramString = a(paramString, paramInt1, -1L, paramInt2, false);
      paramInt1 = paramInt3;
      if (paramInt3 == -1) {
        paramInt1 = paramString.size();
      }
      Iterator localIterator = paramString.iterator();
      paramInt3 = 0;
      int i;
      do
      {
        ChatMessage localChatMessage;
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localChatMessage = (ChatMessage)localIterator.next();
          } while (localChatMessage.getConfessTopicId() != paramInt2);
          i = paramInt3 + 1;
          paramInt3 = i;
        } while (!(localChatMessage instanceof MessageForText));
        localChatMessage.parse();
        paramInt3 = i;
      } while (i < paramInt1);
      return paramString;
    }
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong)
  {
    return a(paramString, paramInt, paramLong, false);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).d(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int[] paramArrayOfInt, int paramInt3)
  {
    return a(paramInt1).a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString1, paramInt1, paramLong, paramInt2, paramString2);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    int i = 0;
    paramString = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramBoolean);
    ChatMessage localChatMessage;
    if ((paramInt1 == 1001) || (paramInt1 == 10002) || (abot.a(paramInt1) == 1032))
    {
      if (paramString == null) {}
      for (paramInt2 = 0;; paramInt2 = paramString.size())
      {
        paramInt2 -= 1;
        while (paramInt2 >= 0)
        {
          localChatMessage = (ChatMessage)paramString.get(paramInt2);
          if ((localChatMessage != null) && (localChatMessage.msgtype == -4011)) {
            paramString.remove(localChatMessage);
          }
          paramInt2 -= 1;
        }
      }
    }
    if (paramInt1 == 1008)
    {
      if (paramString == null) {}
      for (paramInt1 = i;; paramInt1 = paramString.size())
      {
        paramInt1 -= 1;
        for (;;)
        {
          if (paramInt1 < 0) {
            break label330;
          }
          localChatMessage = (ChatMessage)paramString.get(paramInt1);
          if (localChatMessage != null) {
            break;
          }
          paramInt1 -= 1;
        }
      }
      if (afsb.a(localChatMessage.senderuin))
      {
        if (!(localChatMessage instanceof MessageForText)) {
          break label302;
        }
        if (!((MessageForText)localChatMessage).msg.startsWith(" ")) {
          paramString.remove(localChatMessage);
        }
      }
      for (;;)
      {
        if ((localChatMessage.msgtype == -5008) && (ArkAppCenter.b())) {
          paramString.remove(localChatMessage);
        }
        if ((localChatMessage.msgtype != -2011) || (!(localChatMessage instanceof MessageForStructing))) {
          break;
        }
        AbsStructMsg localAbsStructMsg = ((MessageForStructing)localChatMessage).structingMsg;
        if ((localAbsStructMsg == null) || (localAbsStructMsg.mMsgServiceID != 85)) {
          break;
        }
        paramString.remove(localChatMessage);
        break;
        label302:
        if ((!(localChatMessage instanceof MessageForArkApp)) && (!(localChatMessage instanceof MessageForStructing))) {
          paramString.remove(localChatMessage);
        }
      }
    }
    try
    {
      label330:
      Collections.sort(paramString, new abpa(this));
      return paramString;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.msg.QQMessageFacade", 2, "Collections sort exception ! ", localException);
    }
    return paramString;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramInt).a(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramLong, 0, paramBoolean);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, List<Long> paramList)
  {
    return a(paramInt).a(paramString, paramInt, paramList);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, -1L, paramBoolean);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    return a(paramInt).a(paramString, paramInt, 5000, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return a(paramInt1).a(paramString, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString1, String paramString2)
  {
    localObject1 = null;
    str = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    localArrayList = new ArrayList();
    awdh localawdh = new awdh((String)localObject2);
    awbw localawbw = localawdh.createMessageRecordEntityManager();
    localObject2 = localawdh.build((String)localObject2).a();
    try
    {
      paramString1 = ((SQLiteDatabase)localObject2).a(paramString1, paramString2, null, null);
      str = paramString1;
      localObject1 = paramString1;
      paramString2 = localawbw.a(MessageRecord.class, paramString2, paramString1);
      if (paramString2 != null)
      {
        str = paramString1;
        localObject1 = paramString1;
        if (paramString2.size() > 0)
        {
          str = paramString1;
          localObject1 = paramString1;
          localArrayList.addAll(paramString2);
        }
      }
      if (paramString1 != null) {
        paramString1.close();
      }
    }
    catch (Exception paramString1)
    {
      do
      {
        localObject1 = str;
        paramString1.printStackTrace();
      } while (str == null);
      str.close();
      return localArrayList;
    }
    finally
    {
      if (localObject1 == null) {
        break label156;
      }
      ((Cursor)localObject1).close();
    }
    return localArrayList;
  }
  
  public msg_svc.PbMsgReadedReportReq a(String paramString, int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq;
    Object localObject2;
    Object localObject1;
    label156:
    Object localObject3;
    if (abot.b(paramString, paramInt))
    {
      d(paramString, paramInt);
      List localList = b(paramString, paramInt);
      if (localList == null) {
        return null;
      }
      localStringBuilder = new StringBuilder();
      paramString = null;
      localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      paramInt = localList.size() - 1;
      if (paramInt >= 0)
      {
        localObject2 = (MessageRecord)localList.get(paramInt);
        if (localObject2 == null) {
          localObject1 = paramString;
        }
        do
        {
          do
          {
            paramInt -= 1;
            paramString = (String)localObject1;
            break;
            if (!abot.c(((MessageRecord)localObject2).senderuin)) {
              break label291;
            }
            localObject2 = b(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
            localObject1 = paramString;
          } while (localObject2 == null);
          localObject1 = paramString;
        } while (((List)localObject2).isEmpty());
        localObject2 = ((List)localObject2).iterator();
        do
        {
          localObject1 = paramString;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
        } while (localObject3 == null);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop) <= 0) {
          break label628;
        }
        a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop, false, paramBoolean);
        localObject1 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).peer_uin.set(Long.valueOf(((MessageRecord)localObject3).senderuin).longValue());
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).last_read_time.set((int)((MessageRecord)localObject3).time);
        if (paramString != null) {
          break label625;
        }
        paramString = new msg_svc.PbC2CReadedReportReq();
        label279:
        paramString.pair_info.add((MessageMicro)localObject1);
      }
    }
    label291:
    label625:
    label628:
    for (;;)
    {
      break label156;
      if (abot.d(((MessageRecord)localObject2).senderuin))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) > 0) {
          c(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        }
        aped.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, null);
        aped.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, null);
        localObject1 = paramString;
        break;
      }
      localObject1 = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0) {
        break;
      }
      a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop, false, paramBoolean);
      localObject3 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject3).peer_uin.set(Long.valueOf(((MessageRecord)localObject2).senderuin).longValue());
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject3).last_read_time.set((int)((MessageRecord)localObject2).time);
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = new msg_svc.PbC2CReadedReportReq();
      }
      ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject3);
      localStringBuilder.append("{MSGBOX:").append(((MessageRecord)localObject2).senderuin).append("}");
      break;
      if (paramString != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
        if (localObject1 != null) {
          paramString.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject1));
        }
        localPbMsgReadedReportReq.c2c_read_report.set(paramString);
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_LBS>setLbsFriendReaded: " + localStringBuilder.toString());
          long l2 = System.currentTimeMillis();
          QLog.d("Q.msg_box", 2, "setBoxMsgReaded[cost:" + (l2 - l1) + "]");
        }
        return localPbMsgReadedReportReq;
      }
      return null;
      break label279;
    }
  }
  
  public msg_svc.PbMsgReadedReportReq a(boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    if ((localObject2 == null) || (((Set)localObject2).isEmpty())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = null;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    Iterator localIterator = ((Set)localObject2).iterator();
    Object localObject3;
    int i;
    label170:
    Object localObject4;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject3 = (ConversationInfo)localIterator.next();
        if ((abol.a((ConversationInfo)localObject3) > 0) && (a().b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))) {
          if (abot.b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))
          {
            if (1044 == ((ConversationInfo)localObject3).type) {
              continue;
            }
            localObject3 = b(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
            if (localObject3 == null) {
              continue;
            }
            i = ((List)localObject3).size() - 1;
            if (i >= 0)
            {
              localObject4 = (MessageRecord)((List)localObject3).get(i);
              if (localObject4 == null) {
                localObject2 = localObject1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label196:
      i -= 1;
      localObject1 = localObject2;
      break label170;
      label266:
      Object localObject5;
      if (abot.c(((MessageRecord)localObject4).senderuin))
      {
        localObject4 = b(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop);
        localObject2 = localObject1;
        if (localObject4 == null) {
          continue;
        }
        localObject2 = localObject1;
        if (((List)localObject4).isEmpty()) {
          continue;
        }
        localObject2 = ((List)localObject4).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label1296;
        }
        localObject5 = (MessageRecord)((Iterator)localObject2).next();
        a(((MessageRecord)localObject5).senderuin, ((MessageRecord)localObject5).istroop, true, paramBoolean);
        localObject4 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).peer_uin.set(Long.valueOf(((MessageRecord)localObject5).senderuin).longValue());
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).last_read_time.set((int)((MessageRecord)localObject5).time);
        if (localObject1 != null) {
          break label1293;
        }
        localObject1 = new msg_svc.PbC2CReadedReportReq();
      }
      label1290:
      label1293:
      for (;;)
      {
        ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject4);
        break label266;
        a(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop, ((MessageRecord)localObject4).getConfessTopicId(), true, paramBoolean);
        localObject5 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject5).peer_uin.set(Long.valueOf(((MessageRecord)localObject4).senderuin).longValue());
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject5).last_read_time.set((int)((MessageRecord)localObject4).time);
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new msg_svc.PbC2CReadedReportReq();
        }
        ((msg_svc.PbC2CReadedReportReq)localObject2).pair_info.add((MessageMicro)localObject5);
        localStringBuilder.append("{MSGBOX:").append(((MessageRecord)localObject4).frienduin).append("}");
        break label196;
        break;
        if (7000 == ((ConversationInfo)localObject3).type)
        {
          if (aljq.x.equals(((ConversationInfo)localObject3).uin)) {
            break;
          }
          localObject2 = (azyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
          if (localObject2 == null) {
            break;
          }
          ((azyu)localObject2).b(((ConversationInfo)localObject3).uin);
          localObject2 = ((azyu)localObject2).a(((ConversationInfo)localObject3).uin);
          if (localObject2 == null) {
            break;
          }
          localObject3 = new msg_svc.PbBindUinMsgReadedConfirmReq();
          ((msg_svc.PbBindUinMsgReadedConfirmReq)localObject3).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
          localPbMsgReadedReportReq.bind_uin_read_report.set((MessageMicro)localObject3);
          localStringBuilder.append("{SUBUIN}");
          break;
        }
        if ((!paramBoolean) && (((ConversationInfo)localObject3).type == 1008) && (b((ConversationInfo)localObject3))) {
          break;
        }
        long l;
        if ((1006 == ((ConversationInfo)localObject3).type) || ((abot.d(((ConversationInfo)localObject3).type)) && (Long.valueOf(((ConversationInfo)localObject3).uin).longValue() > 10000L))) {
          if (10007 == ((ConversationInfo)localObject3).type)
          {
            if (!paramBoolean) {
              break;
            }
            a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
            l = a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
            if (localObject1 != null) {
              break label1290;
            }
            localObject1 = new msg_svc.PbC2CReadedReportReq();
          }
        }
        for (;;)
        {
          asiu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (msg_svc.PbC2CReadedReportReq)localObject1, l, (ConversationInfo)localObject3);
          if (asil.a()) {
            ((asil)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358)).a(0);
          }
          break;
          if (((ConversationInfo)localObject3).type == 1036) {
            break;
          }
          a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
          l = a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
          if (l == -1L) {}
          label1146:
          do
          {
            do
            {
              if (localObject1 != null)
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
                if (localObject2 != null) {
                  ((msg_svc.PbC2CReadedReportReq)localObject1).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
                }
                localPbMsgReadedReportReq.c2c_read_report.set((MessageMicro)localObject1);
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_All>setAllReaded: " + localStringBuilder.toString());
              }
              return localPbMsgReadedReportReq;
              localObject4 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
              localObject2 = ((ConversationInfo)localObject3).uin;
              if (1006 == ((ConversationInfo)localObject3).type) {
                localObject2 = bdbt.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject3).uin);
              }
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break;
              }
              ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).peer_uin.set(Long.valueOf((String)localObject2).longValue());
              localStringBuilder.append("{C2C:").append(Long.valueOf((String)localObject2)).append(((ConversationInfo)localObject3).type).append("}");
              ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).last_read_time.set((int)l);
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new msg_svc.PbC2CReadedReportReq();
              }
              ((msg_svc.PbC2CReadedReportReq)localObject2).pair_info.add((MessageMicro)localObject4);
              localObject1 = localObject2;
              break;
              if (3000 != ((ConversationInfo)localObject3).type) {
                break label1146;
              }
              a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
              l = a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
            } while (l == -1L);
            localObject2 = new msg_svc.PbDiscussReadedReportReq();
            ((msg_svc.PbDiscussReadedReportReq)localObject2).conf_uin.set(Long.valueOf(((ConversationInfo)localObject3).uin).longValue());
            ((msg_svc.PbDiscussReadedReportReq)localObject2).last_read_seq.set(l);
            localPbMsgReadedReportReq.dis_read_report.add((MessageMicro)localObject2);
            break;
            if ((1 != ((ConversationInfo)localObject3).type) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))) {
              break;
            }
            a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
            aupu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ConversationInfo)localObject3).uin);
            l = a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
          } while (l == -1L);
          if (!((ConversationInfo)localObject3).uin.matches("^\\d+$")) {
            break;
          }
          localObject2 = new msg_svc.PbGroupReadedReportReq();
          ((msg_svc.PbGroupReadedReportReq)localObject2).group_code.set(Long.valueOf(((ConversationInfo)localObject3).uin).longValue());
          ((msg_svc.PbGroupReadedReportReq)localObject2).last_read_seq.set(l);
          localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject2);
          break;
        }
      }
      label1296:
      localObject2 = localObject1;
    }
  }
  
  public void a()
  {
    ThreadManager.post(new QQMessageFacade.1(this), 10, null, false);
  }
  
  public void a(int paramInt)
  {
    String str = String.valueOf(aljq.Y);
    if (a().a(str, 4001) <= 0) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "setRecommendMsgReaded return : unread=0");
      }
    }
    do
    {
      return;
      QQMessageFacade.Message localMessage = a(str, 4001);
      paramInt = a(4001).a(paramInt, localMessage);
      a().d(str, 4001, -paramInt);
    } while (paramInt == 0);
    setChanged();
    notifyObservers(a(str, 4001));
  }
  
  public void a(int paramInt, String paramString)
  {
    if (((axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "orderMediaMsgSending in chat:" + paramString);
      }
      return;
    }
    a(paramInt).a(paramInt, paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    int k = 0;
    if ((paramInt == 0) && (this.jdField_a_of_type_Boolean)) {
      return;
    }
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int i;
    if (this.jdField_b_of_type_Int == -1)
    {
      if (localawbw.d(ConversationInfo.getConversationInfoTableName()))
      {
        i = 1;
        this.jdField_b_of_type_Int = i;
      }
    }
    else
    {
      localObject = ((amjk)localObject).a(true);
      i = j;
      if (localObject == null) {
        break label316;
      }
      i = j;
      if (((List)localObject).size() <= 0) {
        break label316;
      }
      i = ((List)localObject).size();
      if (paramInt <= 0) {
        break label372;
      }
      if (i <= paramInt) {
        break label257;
      }
      j = paramInt;
    }
    for (;;)
    {
      label117:
      if (k < j)
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject).get(k);
        a(localRecentUser.uin, localRecentUser.getType(), localawbw);
        if (k == 10)
        {
          setChanged();
          notifyObservers(new RecentUser());
        }
        if (abot.b(localRecentUser.uin, localRecentUser.getType()))
        {
          if (!aljq.H.equals(localRecentUser.uin)) {
            break label263;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(aljq.aj, localRecentUser.getType())) {
            a(aljq.aj, localRecentUser.getType(), localawbw);
          }
        }
        for (;;)
        {
          k += 1;
          break label117;
          i = 0;
          break;
          j = i;
          break label117;
          if ((aljq.ab.equals(localRecentUser.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(aljq.ak, localRecentUser.getType()))) {
            a(aljq.ak, localRecentUser.getType(), localawbw);
          }
        }
      }
      label257:
      label263:
      label316:
      if (paramBoolean) {
        b(localawbw);
      }
      if ((paramBoolean) || (((List)localObject).size() > 10))
      {
        setChanged();
        notifyObservers(new RecentUser());
      }
      if ((paramInt != 0) && (paramInt < i)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      return;
      label372:
      j = i;
    }
  }
  
  public void a(awbw paramawbw)
  {
    Object localObject = paramawbw.a(PubAccountAssistantData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)((Iterator)localObject).next();
        a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType, paramawbw);
      }
    }
    localObject = paramawbw.a(TroopBarData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopBarData)((Iterator)localObject).next()).mUin, 1008, paramawbw);
      }
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    try
    {
      a(paramMessage.istroop).a(paramMessage);
      return;
    }
    catch (Throwable paramMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.QQMessageFacade", 2, "decodeMsg ERROR", paramMessage);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList<String> paramArrayList, acfb paramacfb)
  {
    ThreadManager.post(new QQMessageFacade.5(this, paramQQAppInterface, paramMessageRecord, paramArrayList, paramacfb), 8, null, false);
  }
  
  public void a(MessageForFile paramMessageForFile)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    if (localFileManagerEntity != null) {
      if ((paramMessageForFile.isSend()) && ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || (localFileManagerEntity.status == 3)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg, msgForFile");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForFile, localFileManagerEntity, new abpb(this, paramMessageForFile, localFileManagerEntity));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg uniseq[" + paramMessageForFile.uniseq + "], sendUin[" + arni.e(paramMessageForFile.senderuin) + "], type[" + paramMessageForFile.istroop + "], Entity is Null, return");
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    Object localObject2;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      localObject1 = (MessageForShortVideo)paramMessageRecord;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (!((MessageForShortVideo)localObject1).isSendFromLocal())
      {
        ((batw)localObject2).a(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
        ShortVideoUtils.a((MessageForShortVideo)localObject1);
      }
    }
    else
    {
      if (paramMessageRecord.isSendFromLocal()) {
        break label78;
      }
    }
    for (;;)
    {
      return;
      ((batw)localObject2).b(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
      break;
      label78:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject2 = new ArrayList();
      Object localObject3;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        j = paramMessageRecord.msgElemList.size();
        i = 0;
        while (i < j)
        {
          localObject3 = (MessageRecord)paramMessageRecord.msgElemList.get(i);
          if ((localObject3 instanceof MessageForPic)) {
            ((List)localObject2).add((MessageForPic)localObject3);
          }
          i += 1;
        }
      }
      if ((paramMessageRecord instanceof MessageForLongMsg))
      {
        paramMessageRecord = (MessageForLongMsg)paramMessageRecord;
        int k = paramMessageRecord.longMsgFragmentList.size();
        i = 0;
        if (i < k)
        {
          localObject3 = (MessageRecord)paramMessageRecord.longMsgFragmentList.get(i);
          if ((localObject3 instanceof MessageForPic)) {
            ((List)localObject2).add((MessageForPic)localObject3);
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject3 instanceof MessageForMixedMsg))
            {
              localObject3 = (MessageForMixedMsg)localObject3;
              int m = ((MessageForMixedMsg)localObject3).msgElemList.size();
              j = 0;
              while (j < m)
              {
                MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(j);
                if ((localMessageRecord instanceof MessageForPic)) {
                  ((List)localObject2).add((MessageForPic)localMessageRecord);
                }
                j += 1;
              }
            }
          }
        }
      }
      else
      {
        if (!(paramMessageRecord instanceof MessageForPic)) {
          continue;
        }
        ((List)localObject2).add((MessageForPic)paramMessageRecord);
      }
      int j = ((List)localObject2).size();
      int i = 0;
      while (i < j)
      {
        paramMessageRecord = (MessageForPic)((List)localObject2).get(i);
        paramMessageRecord = paramMessageRecord.frienduin + paramMessageRecord.uniseq + "_" + paramMessageRecord.subMsgId;
        localObject3 = ((batw)localObject1).a(paramMessageRecord);
        if ((localObject3 != null) && ((localObject3 instanceof bamw)))
        {
          ((bamw)localObject3).j();
          ((batw)localObject1).a(paramMessageRecord);
        }
        i += 1;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      a(paramMessageRecord.frienduin, paramMessageRecord);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, localawbw, false, true, true, true);
      if (QLog.isColorLevel()) {
        QLog.d("sendmsg", 2, String.format("addSendMessage key = %d %s %d", new Object[] { Long.valueOf(paramMessageRecord.uniseq), paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop) }));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, paramInt);
      setChanged();
      notifyObservers(paramMessageRecord);
      return;
    }
    finally
    {
      localawbw.a();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, alsi paramalsi)
  {
    a(paramMessageRecord, paramalsi, false);
  }
  
  public void a(MessageRecord paramMessageRecord, alsi paramalsi, boolean paramBoolean)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.frienduin == null) || (paramMessageRecord.frienduin.length() < 2)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage start currenttime:" + System.currentTimeMillis());
      }
      if ((paramMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      b(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
      }
      b(paramMessageRecord, paramalsi, paramBoolean);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " addAndSendMessage sendMessage end currenttime:" + System.currentTimeMillis());
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, false, true, true, true);
      setChanged();
      if (((paramMessageRecord instanceof ChatMessage)) && (paramMessageRecord.isSend())) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      notifyObservers(paramMessageRecord);
      e(localArrayList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      setChanged();
      if (((paramMessageRecord instanceof ChatMessage)) && (paramMessageRecord.isSend())) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      notifyObservers(paramMessageRecord);
      e(localArrayList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    a(paramMessageRecord.istroop).a(paramMessageRecord, true, paramBoolean);
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramRecentUser, false);
    a(paramRecentUser.uin, paramRecentUser.getType(), true, true);
    if (paramRecentUser.getType() == 1) {
      aupu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin);
    }
  }
  
  public void a(Object paramObject)
  {
    setChanged();
    notifyObservers(paramObject);
  }
  
  public void a(String paramString)
  {
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (ArrayList)localawbw.a(TransFileInfo.class, false, "friendUin = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        localawbw.b((TransFileInfo)paramString.next());
      }
    }
    localawbw.a();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, abpd paramabpd)
  {
    a(paramInt1).a(paramString, paramInt1, paramInt2, paramabpd);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt1).a(paramString, paramInt1, paramBoolean1, paramBoolean2, paramInt2);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(paramInt).a(paramString, paramInt, paramLong, false);
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgExtraFlagByuniseq: peerUin = " + paramString + " type = " + paramInt1 + " uniseq = " + paramLong);
    }
    MessageRecord localMessageRecord = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramInt3);
    a(paramInt1).a(paramString, paramInt1, localMessageRecord, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    a(paramString, paramInt, paramLong1, paramLong2, null);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateGroupMsgSeqAndTimeByUniseq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong1 + " shmsgseq = " + paramLong2 + " time = " + paramLong3);
    }
    abor localabor = a(paramInt);
    MessageRecord localMessageRecord = null;
    if ((localabor instanceof bblz))
    {
      localMessageRecord = ((bblz)localabor).b(paramString, paramInt, paramLong1, paramLong2, paramLong3);
      ((bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(paramLong1, paramLong2);
    }
    a(paramInt).a(paramString, paramInt, localMessageRecord, 3);
    a(paramString, paramInt, paramLong2);
    setChanged();
    notifyObservers(localMessageRecord);
    if (localMessageRecord == null) {}
    do
    {
      return;
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while ((!paramString.e()) || ((!paramString.e(localMessageRecord)) && (!paramString.b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq))));
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "updateGroupMsgSeqAndTimeByUniseq, in revoking cache");
    }
    paramString.f(null);
    a(paramInt).b();
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateC2CMsgTimeByUniseq: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong1 + " time = " + paramLong2);
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong1, paramLong2, paramString2);
    a(paramInt).a(paramString1, paramInt, paramString2, 3);
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContent: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong, paramString2);
    a(paramInt).a(paramString1, paramInt, paramString2, 2);
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldByUniseq: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong + " fieldName = " + paramString2 + " fieldValue = " + paramObject);
    }
    paramString2 = a(paramInt).a(paramString1, paramInt, paramLong, paramString2, paramObject);
    a(paramInt).a(paramString1, paramInt, paramString2, 3);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramInt).a(paramString, paramInt, paramLong, paramBoolean);
  }
  
  public void a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContentByUniSeq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramArrayOfByte = a(paramInt).a(paramString, paramInt, paramLong, paramArrayOfByte);
    a(paramInt).a(paramString, paramInt, paramArrayOfByte, 2);
  }
  
  public void a(String paramString, int paramInt, abpd paramabpd)
  {
    List localList = a(paramString, paramInt);
    if (localList == null) {}
    for (int i = 0;; i = localList.size())
    {
      i = 10 - i;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "refreshMessageListHeadByAIOBreak numTroopRefresh = " + paramabpd.i + ", count = " + i);
      }
      if (i <= 0) {
        break;
      }
      paramabpd.i = true;
      a(paramInt).a(paramString, paramInt, i, paramabpd);
      return;
    }
    paramabpd.jdField_d_of_type_Boolean = true;
    paramabpd.jdField_a_of_type_JavaLangString = paramString;
    paramabpd.jdField_d_of_type_Int = paramInt;
    paramabpd.e = i;
    a(paramabpd);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    a(paramInt).b(paramString, paramInt, paramMessageRecord);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramInt).a(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    a(paramInt1).a(paramString1, paramInt1, paramString2, paramString3, paramInt2, paramInt3, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if (QLog.isColorLevel()) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      if (TextUtils.isEmpty(paramString3)) {
        paramLong = 0L;
      }
      for (;;)
      {
        a(paramInt).a(paramString1, paramInt, paramString2, paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.i("notification", 2, "notifyDraftUpdated| " + (System.currentTimeMillis() - l) + " drafttime = " + paramLong);
        }
        return;
      }
    }
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      a(((MessageRecord)paramList.get(0)).istroop).b(paramString, paramInt, paramList);
      setChanged();
      notifyObservers(paramList.get(0));
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).createEntityManager();
    }
    try
    {
      a(paramList, paramString, true, true, false, false);
      paramString.a();
      e(paramList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    a(paramInt).a(paramString, paramInt, paramList1, paramList2, paramBundle);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, paramString1);
    }
  }
  
  public void a(String paramString, Collection<MessageRecord> paramCollection)
  {
    if (paramCollection != null)
    {
      a("------------" + paramString + "--------------" + paramCollection.size(), "");
      return;
    }
    a("------------" + paramString + "-------------- is null", "");
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    a(((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_Int).a(paramArrayList);
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean, bool, true, true);
        paramString.a();
        if ((paramBoolean) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        paramString = abot.a(paramArrayList);
        if (paramString != null)
        {
          setChanged();
          notifyObservers(paramString);
          bdfe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        }
        return;
      }
      finally
      {
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.a();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if (paramBoolean2)
        {
          paramString = abot.a(paramArrayList);
          if (paramString != null)
          {
            setChanged();
            notifyObservers(paramString);
          }
        }
        return;
      }
      finally
      {
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.a();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          a(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if ((paramBoolean2) || (paramBoolean3))
        {
          paramString = abot.a(paramArrayList);
          if (paramString != null)
          {
            setChanged();
            notifyObservers(paramString);
          }
        }
        return;
      }
      finally
      {
        paramString.a();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    String str;
    int i;
    do
    {
      return;
      str = ((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_JavaLangString;
      i = ((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_Int;
      a(i).a(paramArrayList, paramBoolean);
      ((aieo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(147)).a(str, i, -1);
    } while ((!paramBoolean) || ((i != 1) && (i != 3000)));
    a(str, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, i));
  }
  
  public void a(List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "setChatMsgList");
    }
  }
  
  public void a(List<MessageRecord> paramList, String paramString)
  {
    a(paramList, paramString, true);
  }
  
  public void a(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      a(paramList, paramString, false, true, true, paramBoolean);
      paramString.a();
      paramString = abot.a(paramList);
      if (paramString != null)
      {
        setChanged();
        if (paramBoolean) {
          notifyObservers(paramString);
        }
      }
      if (paramBoolean) {
        e(paramList);
      }
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void a(List<? extends MessageRecord> paramList, boolean paramBoolean)
  {
    if (paramList.size() != 0) {
      a(((MessageRecord)paramList.get(0)).istroop).a(paramList, true, paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Int >= 0);
  }
  
  protected boolean a(ConversationInfo paramConversationInfo)
  {
    if ((paramConversationInfo == null) || (paramConversationInfo.uin == null)) {}
    while ((aljq.W.equals(paramConversationInfo.uin)) || (d(paramConversationInfo)) || (c(paramConversationInfo)) || (TextUtils.equals(aljq.az, paramConversationInfo.uin)) || (TextUtils.equals(aljq.H, paramConversationInfo.uin)) || (TextUtils.equals(aljq.aA, paramConversationInfo.uin)) || ((paramConversationInfo.type == 1008) && (b(paramConversationInfo))) || (paramConversationInfo.type == 1033) || (paramConversationInfo.type == 1034) || (paramConversationInfo.type == 1037) || (paramConversationInfo.type == 1044) || (paramConversationInfo.type == 1045) || (paramConversationInfo.type == 1036) || ((paramConversationInfo.type == 1038) && (!b()))) {
      return true;
    }
    if (paramConversationInfo.type == 7000)
    {
      QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum subaccount info.uin=" + paramConversationInfo.uin + "  info.type=" + paramConversationInfo.type);
      return true;
    }
    Object localObject;
    if (paramConversationInfo.type == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramConversationInfo.uin, paramConversationInfo.type);
      if ((localObject == null) || ((((RecentUser)localObject).lFlag & 1L) == 0L)) {
        break label449;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
      if ((localObject == null) || (((HotChatManager)localObject).b(paramConversationInfo.uin))) {
        break label449;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum invalide hotchat!");
      }
    }
    label447:
    label449:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (paramConversationInfo.type == 1038)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramConversationInfo.uin, paramConversationInfo.type);
        QQMessageFacade.Message localMessage = a(paramConversationInfo.uin, paramConversationInfo.type);
        if (((ajbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(315)).a(localMessage, (RecentUser)localObject) != 1) {
          break label447;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum appletsaccount info.uin=" + paramConversationInfo.uin + "  info.type=" + paramConversationInfo.type);
        return true;
      }
      if (paramConversationInfo.type == 10007) {
        break;
      }
      return false;
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    QQMessageFacade.Message localMessage = a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (abot.d(paramMessageRecord.istroop)) {
      if ((paramMessageRecord.msgUid != localMessage.msgUid) || (paramMessageRecord.shmsgseq != localMessage.shmsgseq)) {}
    }
    while (paramMessageRecord.shmsgseq == localMessage.shmsgseq)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return c(paramString, 0);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = MessageRecord.getTableName(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("select count() as counter, 'x' as msgData from ").append(paramString).append(" where issend=0 and isValid=1 and msgtype ").append(abot.a());
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(QQMessageFacade.Message.class, localStringBuilder.toString(), null);
    if ((paramString != null) && (paramString.size() > 0)) {
      return ((QQMessageFacade.Message)paramString.get(0)).counter > 0;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (abot.o(paramInt2))
    {
      bool1 = bool2;
      if (abot.h(paramInt2))
      {
        bool1 = bool2;
        if (a(paramInt1).e(paramString, paramInt1, paramLong) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, List<MessageRecord> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.QQMessageFacade", 2, "refresh C2C autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
      }
    }
    do
    {
      return false;
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(paramString, paramInt), Boolean.valueOf(true));
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).f(paramString, paramInt);
    } while ((paramString == null) || (paramString.isEmpty()));
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).c();
    }
    a("refresh C2C autopull, size = " + paramString.size(), ", timestamp = " + System.currentTimeMillis());
    return true;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    paramBoolean = true;
    boolean bool = true;
    List localList = b(paramString, paramInt);
    if ((localList == null) || (localList.isEmpty()))
    {
      paramBoolean = false;
      return paramBoolean;
    }
    if (localList.size() == 1)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(0);
      if ((localMessageRecord.msgtype == -2006) || (!localMessageRecord.isValid)) {
        return false;
      }
      if (localMessageRecord.shmsgseq > Math.max(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt)) + 1L) {}
      for (;;)
      {
        paramBoolean = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool + "; cacheList size = " + localList.size() + "; msgseq = " + localMessageRecord.shmsgseq + ", expiredSeq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString) + ", delLastSeq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt));
        return bool;
        bool = false;
      }
    }
    if (localList.size() > 1)
    {
      paramString = (MessageRecord)localList.get(localList.size() - 1);
      if ((paramString.msgtype == -2006) || (!paramString.isValid)) {
        return false;
      }
      paramString = abot.a(localList, false);
      if (paramString.size() < 10) {}
      for (bool = paramBoolean;; bool = false)
      {
        paramBoolean = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool + "; cacheList size = " + localList.size() + "; continuedList size = " + paramString.size());
        return bool;
      }
    }
    return false;
  }
  
  public int b()
  {
    Object localObject1 = new StringBuilder(168);
    int j = a(2);
    if (j != 0) {
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j) }));
    }
    int i = j;
    int k;
    if (a().b(aljq.W, 9000))
    {
      k = ahla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((k != 0) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.QQMessageFacade", 2, "Recent TroopNotification Unread=" + k);
      }
      i = j + k;
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { aljq.W, Integer.valueOf(9000), Integer.valueOf(k) }));
    }
    j = i;
    Object localObject2;
    if (a().b(aljq.aB, 7230))
    {
      j = ssp.a().b();
      i += j;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (!(localObject2 instanceof axho)) {
        break label783;
      }
      k = ((axho)localObject2).a("104000.104001", 100);
      if (k <= 0) {
        break label783;
      }
      i = k + i;
    }
    label778:
    label783:
    for (;;)
    {
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { aljq.aB, Integer.valueOf(7230), Integer.valueOf(j) }));
      j = i;
      i = j;
      if (badt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        i = j;
        if (a().b(aljq.aP, 6004))
        {
          localObject2 = ((nan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).a(46, false);
          if ((localObject2 == null) || (!((oidb_0x791.RedDotInfo)localObject2).uint32_number.has()) || (!((oidb_0x791.RedDotInfo)localObject2).bool_display_reddot.get())) {
            break label778;
          }
        }
      }
      for (i = ((oidb_0x791.RedDotInfo)localObject2).uint32_number.get();; i = 0)
      {
        j += i;
        ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { aljq.aP, Integer.valueOf(6004), Integer.valueOf(i) }));
        i = j;
        j = i;
        if (a().b(aljq.au, 9003))
        {
          localObject2 = (agyc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(138);
          j = i;
          if (localObject2 != null)
          {
            k = ((agyc)localObject2).b();
            j = i + k;
            ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { aljq.au, Integer.valueOf(9003), Integer.valueOf(k) }));
          }
        }
        i = j;
        if (a().b(aljq.x, 7000))
        {
          k = azyl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          i = j + k;
          ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { aljq.x, Integer.valueOf(7000), Integer.valueOf(k) }));
        }
        j = i;
        if (asil.a())
        {
          k = ((asil)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358)).b();
          j = i + k;
          ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { "2747277822", Integer.valueOf(10007), Integer.valueOf(k) }));
        }
        i = j;
        if (aokd.a("MiniAppEcShopNumMsgEnable", 1) == 1)
        {
          i = j;
          if (a().b(aljq.ae, 7120))
          {
            k = ((ntw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            i = j + k;
            ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { aljq.aB, Integer.valueOf(7120), Integer.valueOf(k) }));
          }
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        if (!((String)localObject1).equals(this.jdField_b_of_type_JavaLangString))
        {
          QLog.d("Q.msg.QQMessageFacade_UnreadMonitor", 1, "Recent Msg Unread: " + (String)localObject1);
          this.jdField_b_of_type_JavaLangString = ((String)localObject1);
        }
        return i;
      }
    }
  }
  
  public int b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    localObject = new awdh((String)localObject).build((String)localObject).b();
    if (localObject != null)
    {
      i = j;
      if (paramBoolean) {
        i = -1000;
      }
      i = ((SQLiteDatabase)localObject).a(paramString, paramLong1, paramLong2, i);
      ((SQLiteDatabase)localObject).c();
    }
    return i;
  }
  
  public QQMessageFacade.Message b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "getFirstUnreadMessage() called with: uin = [" + paramString + "], type = [" + paramInt + "]");
    }
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, paramInt);
    Object localObject = a(l, b(paramString, paramInt));
    if (localObject != null) {}
    QQMessageFacade.Message localMessage;
    do
    {
      return localObject;
      localMessage = a(l, a(paramString, paramInt, l, 3, String.format("time>=%d", new Object[] { Long.valueOf(l) })));
      localObject = localMessage;
    } while (localMessage != null);
    localObject = new QQMessageFacade.Message();
    ((QQMessageFacade.Message)localObject).frienduin = paramString;
    ((QQMessageFacade.Message)localObject).istroop = paramInt;
    return localObject;
  }
  
  public QQMessageFacade.Message b(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      paramString = new QQMessageFacade.Message();
    }
    StringBuilder localStringBuilder;
    String str;
    QQMessageFacade.Message localMessage;
    Object localObject;
    do
    {
      do
      {
        return paramString;
        localStringBuilder = new StringBuilder("Case:");
        str = a(paramString, paramInt1);
        localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(str);
        if ((localMessage != null) && (localMessage.isCacheValid))
        {
          localObject = localMessage;
          if (localMessage.getConfessTopicId() == paramInt2) {}
        }
        else
        {
          localObject = MessageRecord.getTableName(paramString, paramInt1);
          awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (!localawbw.d((String)localObject)) {
            break;
          }
          localMessage = a(paramString, paramInt1, localawbw, paramInt2);
          localStringBuilder.append("Check-DB");
          localObject = localMessage;
          if (localMessage == null)
          {
            localObject = new QQMessageFacade.Message();
            ((QQMessageFacade.Message)localObject).frienduin = paramString;
            ((QQMessageFacade.Message)localObject).istroop = paramInt1;
            ((QQMessageFacade.Message)localObject).setConfessTopicId(paramInt2);
            this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
          }
          localawbw.a();
        }
        paramString = (String)localObject;
      } while (localObject == null);
      paramString = (String)localObject;
    } while (!abot.b(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop));
    ((QQMessageFacade.Message)localObject).istroop = abot.a(((QQMessageFacade.Message)localObject).istroop);
    return localObject;
    if (localMessage == null)
    {
      localObject = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject).frienduin = paramString;
      ((QQMessageFacade.Message)localObject).istroop = paramInt1;
      ((QQMessageFacade.Message)localObject).setConfessTopicId(paramInt2);
      this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
    }
    for (;;)
    {
      localStringBuilder.append("Not-In-TableCache");
      break;
      localMessage.isCacheValid = true;
      localObject = localMessage;
    }
  }
  
  public MessageRecord b(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).c(paramString, paramInt);
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size() - 1;
      if (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ((((MessageRecord)localObject2).isValid) && (!abot.h(((MessageRecord)localObject2).msgtype)))
        {
          localObject1 = localObject2;
          if (!((MessageRecord)localObject2).isLongMsg()) {}
        }
      }
    }
    for (localObject1 = a((MessageRecord)localObject2);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        return localObject1;
        i -= 1;
        break;
      }
      QQMessageFacade.Message localMessage = a(paramString, paramInt);
      localObject2 = localObject1;
      if (localMessage != null)
      {
        localObject2 = localObject1;
        if (localMessage.isCacheValid) {
          if (localMessage.lastMsg == null) {
            break label170;
          }
        }
      }
      label170:
      for (localObject2 = localMessage.lastMsg;; localObject2 = a(localMessage))
      {
        localMessage.lastMsg = ((MessageRecord)localObject2);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        return a(paramInt).b(paramString, paramInt, null);
      }
    }
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).b(paramString, paramInt, paramLong);
  }
  
  public MessageRecord b(String paramString1, int paramInt, String paramString2)
  {
    return a(paramInt).b(paramString1, paramInt, paramString2);
  }
  
  public String b(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    a(localMessage);
    paramMessageRecord = new MsgSummary();
    bdec.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
    return paramMessageRecord.a(paramContext).toString();
  }
  
  public List<RecentBaseData> b()
  {
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1 = localawbw.a(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    Object localObject4;
    HashMap localHashMap;
    Iterator localIterator;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true);
      localHashMap = new HashMap();
      localIterator = ((List)localObject1).iterator();
    }
    label651:
    label657:
    label660:
    for (;;)
    {
      Object localObject2;
      int i;
      QQMessageFacade.Message localMessage;
      Object localObject3;
      int j;
      if (localIterator.hasNext())
      {
        localObject1 = (Sqlite)localIterator.next();
        localObject2 = SecurityUtile.b(((Sqlite)localObject1).tbl_name);
        ((Sqlite)localObject1).tbl_name = ((String)localObject2);
        if (!((String)localObject2).endsWith("_New")) {
          continue;
        }
        i = abot.a((String)localObject2);
        localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(i).a((String)localObject2, localawbw);
        if ((localMessage == null) || ((localMessage != null) && (localMessage.frienduin == null))) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(i).a((String)localObject2, localawbw);
        localObject3 = localMessage.frienduin;
        localObject1 = null;
        if (((String)localObject2).startsWith("mr_friend_"))
        {
          localObject1 = bdbt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, false);
          j = 1;
        }
      }
      for (;;)
      {
        label208:
        if (j == 0) {
          break label660;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = localObject3;
        }
        if ((localMessage.istroop == 0) || (localMessage.istroop == 1) || (localMessage.istroop == 3000)) {}
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label365;
          }
          localObject1 = new MsgBackupMsgUserData();
          ((MsgBackupMsgUserData)localObject1).uin = ((String)localObject3);
          ((MsgBackupMsgUserData)localObject1).uinType = i;
          ((MsgBackupMsgUserData)localObject1).name = ((String)localObject2);
          ((MsgBackupMsgUserData)localObject1).mTitleName = ((String)localObject2);
          localHashMap.put(localObject3, localObject1);
          break;
          if (((String)localObject2).startsWith("mr_troop_"))
          {
            localObject1 = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, false);
            j = 1;
            i = 1;
            break label208;
          }
          if (!((String)localObject2).startsWith("mr_discusssion_")) {
            break label657;
          }
          localObject1 = bdbt.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3);
          j = 1;
          i = 3000;
          break label208;
        }
        label365:
        break;
        if (localHashMap.size() > 0)
        {
          localObject1 = new ArrayList();
          if ((localObject4 != null) && (((List)localObject4).size() > 0))
          {
            localObject2 = ((List)localObject4).iterator();
            label510:
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = ((RecentUser)((Iterator)localObject2).next()).uin;
              localObject4 = (MsgBackupMsgUserData)localHashMap.get(localObject3);
              if ((localObject4 != null) && (Long.parseLong((String)localObject3) > 10000L))
              {
                if ((((MsgBackupMsgUserData)localObject4).uinType == 0) || (((MsgBackupMsgUserData)localObject4).uinType == 1) || (((MsgBackupMsgUserData)localObject4).uinType == 3000)) {}
                for (i = 1;; i = 0)
                {
                  if (i == 0) {
                    break label510;
                  }
                  ((List)localObject1).add(localObject4);
                  break;
                }
              }
            }
          }
          localObject2 = localHashMap.keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MsgBackupMsgUserData)localHashMap.get((String)((Iterator)localObject2).next());
            if ((((MsgBackupMsgUserData)localObject3).uinType == 0) || (((MsgBackupMsgUserData)localObject3).uinType == 1) || (((MsgBackupMsgUserData)localObject3).uinType == 3000) || (((MsgBackupMsgUserData)localObject3).uinType == 1000) || (((MsgBackupMsgUserData)localObject3).uinType == 1004)) {}
            for (i = 1;; i = 0)
            {
              if ((i == 0) || (((List)localObject1).contains(localObject3)) || (Long.parseLong(((MsgBackupMsgUserData)localObject3).uin) <= 10000L)) {
                break label651;
              }
              ((List)localObject1).add(localObject3);
              break;
            }
          }
          return localObject1;
        }
        return null;
        j = 0;
      }
    }
  }
  
  public List<MessageRecord> b(String paramString, int paramInt)
  {
    return a(paramInt).b(paramString, paramInt);
  }
  
  public List<ChatMessage> b(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramString = a(paramString, paramInt1);
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = paramString.size();
      }
      Iterator localIterator = paramString.iterator();
      paramInt2 = 0;
      int i;
      do
      {
        ChatMessage localChatMessage;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localChatMessage = (ChatMessage)localIterator.next();
          i = paramInt2 + 1;
          paramInt2 = i;
        } while (!(localChatMessage instanceof MessageForText));
        localChatMessage.parse();
        paramInt2 = i;
      } while (i < paramInt1);
      return paramString;
    }
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).e(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramInt).b(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public List<MessageRecord> b(String paramString1, String paramString2)
  {
    localObject = null;
    str = null;
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    localArrayList = new ArrayList();
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createMessageRecordEntityManager();
    try
    {
      paramString1 = localSQLiteDatabase.a(paramString1, paramString2, null, null);
      str = paramString1;
      localObject = paramString1;
      paramString2 = localawbw.a(MessageRecord.class, paramString2, paramString1);
      if (paramString2 != null)
      {
        str = paramString1;
        localObject = paramString1;
        if (paramString2.size() > 0)
        {
          str = paramString1;
          localObject = paramString1;
          localArrayList.addAll(paramString2);
        }
      }
      if (paramString1 != null) {
        paramString1.close();
      }
    }
    catch (Exception paramString1)
    {
      do
      {
        localObject = str;
        paramString1.printStackTrace();
      } while (str == null);
      str.close();
      return localArrayList;
    }
    finally
    {
      if (localObject == null) {
        break label138;
      }
      ((Cursor)localObject).close();
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4001).b(String.valueOf(aljq.Y), 4001);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt);
    } while (a(4001).a(paramInt) <= 0);
    setChanged();
    localObject = new RecentUser();
    ((RecentUser)localObject).uin = String.valueOf(aljq.W);
    notifyObservers(localObject);
  }
  
  public void b(QQMessageFacade.Message paramMessage)
  {
    try
    {
      a(paramMessage.istroop).a(paramMessage, true);
      return;
    }
    catch (Throwable paramMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.QQMessageFacade", 2, "decodeMsg ERROR", paramMessage);
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.frienduin == null) || (paramMessageRecord.frienduin.length() < 2)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage start currenttime:" + System.currentTimeMillis());
      }
      if ((paramMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      b(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
  }
  
  public void b(MessageRecord paramMessageRecord, alsi paramalsi)
  {
    b(paramMessageRecord, paramalsi, false);
  }
  
  public void b(MessageRecord paramMessageRecord, alsi paramalsi, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread()) {
      ThreadManager.post(new QQMessageFacade.2(this, paramMessageRecord, paramalsi, paramBoolean), 10, null, false);
    }
    for (;;)
    {
      if (paramMessageRecord.msgtype == -2011) {
        azlr.a(paramMessageRecord);
      }
      return;
      c(paramMessageRecord, paramalsi, paramBoolean);
    }
  }
  
  public void b(MessageRecord paramMessageRecord, String paramString)
  {
    a(paramMessageRecord, MessageHandler.e);
  }
  
  public void b(String paramString)
  {
    MessageRecord localMessageRecord = ayvw.a(-1052);
    localMessageRecord.msg = paramString;
    localMessageRecord.frienduin = aljq.aC;
    localMessageRecord.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageRecord.time = ayvc.a();
    localMessageRecord.msgseq = ((int)localMessageRecord.time);
    localMessageRecord.msgUid = ayvy.a(ayvy.a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, null, true);
  }
  
  /* Error */
  public void b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   7: astore 14
    //   9: aload 14
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload 14
    //   17: aload_1
    //   18: invokevirtual 2164	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)I
    //   21: istore_3
    //   22: iload_3
    //   23: sipush 6000
    //   26: if_icmple -12 -> 14
    //   29: iload_3
    //   30: sipush 5000
    //   33: isub
    //   34: sipush 1200
    //   37: invokestatic 2167	java/lang/Math:max	(II)I
    //   40: istore 4
    //   42: aload_0
    //   43: getfield 81	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   46: invokevirtual 746	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawbx;
    //   49: invokevirtual 1233	awbx:createMessageRecordEntityManager	()Lawbw;
    //   52: checkcast 2169	awce
    //   55: astore 15
    //   57: aload 15
    //   59: invokevirtual 2172	awce:a	()Lawby;
    //   62: astore 13
    //   64: iload 4
    //   66: sipush 2500
    //   69: idiv
    //   70: iconst_1
    //   71: iadd
    //   72: istore 5
    //   74: iload 4
    //   76: iload 5
    //   78: idiv
    //   79: istore 6
    //   81: iconst_0
    //   82: istore_3
    //   83: iload_3
    //   84: iload 5
    //   86: if_icmpge +661 -> 747
    //   89: iload_2
    //   90: ifne +408 -> 498
    //   93: ldc_w 2174
    //   96: iconst_3
    //   97: anewarray 38	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_1
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: aload_1
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: iload 6
    //   112: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: invokestatic 440	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   119: astore 10
    //   121: ldc_w 2176
    //   124: iconst_3
    //   125: anewarray 38	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload_1
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: aload_1
    //   135: aastore
    //   136: dup
    //   137: iconst_2
    //   138: iload 6
    //   140: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: aastore
    //   144: invokestatic 440	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   147: astore 11
    //   149: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   152: lstore 7
    //   154: aload 13
    //   156: ifnull +8 -> 164
    //   159: aload 13
    //   161: invokevirtual 2179	awby:a	()V
    //   164: aload 15
    //   166: aload 11
    //   168: aconst_null
    //   169: aload_0
    //   170: getfield 81	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   173: invokevirtual 2182	awce:a	(Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   176: astore 11
    //   178: aload 11
    //   180: ifnull +536 -> 716
    //   183: new 2184	java/util/HashSet
    //   186: dup
    //   187: iconst_5
    //   188: invokespecial 2185	java/util/HashSet:<init>	(I)V
    //   191: astore 12
    //   193: aload 11
    //   195: invokeinterface 290 1 0
    //   200: astore 16
    //   202: aload 16
    //   204: invokeinterface 191 1 0
    //   209: ifeq +507 -> 716
    //   212: aload 16
    //   214: invokeinterface 195 1 0
    //   219: checkcast 316	com/tencent/mobileqq/data/MessageRecord
    //   222: astore 18
    //   224: aload 18
    //   226: invokevirtual 2188	com/tencent/mobileqq/data/MessageRecord:isSupportFTS	()Z
    //   229: ifeq -27 -> 202
    //   232: aload 18
    //   234: getfield 1060	com/tencent/mobileqq/data/MessageRecord:isValid	Z
    //   237: ifeq -35 -> 202
    //   240: aload 18
    //   242: getfield 468	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   245: sipush -2006
    //   248: if_icmpeq -46 -> 202
    //   251: aload 18
    //   253: invokestatic 2193	com/tencent/mobileqq/utils/fts/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/fts/FTSMessage;
    //   256: astore 17
    //   258: aload 17
    //   260: invokevirtual 2198	com/tencent/mobileqq/data/fts/FTSMessage:deleteOpt	()V
    //   263: aload 17
    //   265: invokestatic 2201	com/tencent/mobileqq/utils/fts/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/fts/FTSMessage;)Lcom/tencent/mobileqq/data/FTSMessageDelete;
    //   268: astore 17
    //   270: aload 18
    //   272: ldc_w 2203
    //   275: invokevirtual 2206	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 18
    //   280: aload 18
    //   282: invokestatic 616	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   285: ifeq +350 -> 635
    //   288: aload 17
    //   290: invokevirtual 2211	com/tencent/mobileqq/data/FTSMessageDelete:deleteOne	()V
    //   293: aload 15
    //   295: aload 17
    //   297: invokevirtual 2214	awce:b	(Lawbv;)V
    //   300: goto -98 -> 202
    //   303: astore 12
    //   305: aload 11
    //   307: astore 10
    //   309: aload 12
    //   311: astore 11
    //   313: aload 11
    //   315: invokevirtual 402	java/lang/Exception:printStackTrace	()V
    //   318: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +30 -> 351
    //   324: ldc 66
    //   326: iconst_2
    //   327: new 163	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   334: ldc_w 2216
    //   337: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload 11
    //   342: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload 10
    //   353: astore 11
    //   355: aload 13
    //   357: ifnull +12 -> 369
    //   360: aload 13
    //   362: invokevirtual 2217	awby:b	()V
    //   365: aload 10
    //   367: astore 11
    //   369: aload 11
    //   371: ifnull +120 -> 491
    //   374: aload 11
    //   376: invokeinterface 450 1 0
    //   381: ifle +110 -> 491
    //   384: aload_0
    //   385: getfield 81	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   388: sipush 201
    //   391: invokevirtual 462	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   394: checkcast 2219	awdi
    //   397: astore 10
    //   399: aload 10
    //   401: ifnull +11 -> 412
    //   404: aload 10
    //   406: aload_1
    //   407: aload 11
    //   409: invokevirtual 2222	awdi:a	(Ljava/lang/String;Ljava/util/List;)V
    //   412: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +76 -> 491
    //   418: ldc 66
    //   420: iconst_2
    //   421: new 163	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 2224
    //   431: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_1
    //   435: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc_w 1172
    //   441: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: iload 6
    //   446: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: ldc_w 2226
    //   452: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload_3
    //   456: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   459: ldc_w 2226
    //   462: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: iload 4
    //   467: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: ldc_w 2228
    //   473: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   479: lload 7
    //   481: lsub
    //   482: invokevirtual 1346	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   485: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: iload_3
    //   492: iconst_1
    //   493: iadd
    //   494: istore_3
    //   495: goto -412 -> 83
    //   498: iload_2
    //   499: iconst_1
    //   500: if_icmpeq +17 -> 517
    //   503: iload_2
    //   504: sipush 3000
    //   507: if_icmpeq +10 -> 517
    //   510: iload_2
    //   511: sipush 1026
    //   514: if_icmpne +62 -> 576
    //   517: ldc_w 2230
    //   520: iconst_3
    //   521: anewarray 38	java/lang/Object
    //   524: dup
    //   525: iconst_0
    //   526: aload_1
    //   527: aastore
    //   528: dup
    //   529: iconst_1
    //   530: aload_1
    //   531: aastore
    //   532: dup
    //   533: iconst_2
    //   534: iload 6
    //   536: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   539: aastore
    //   540: invokestatic 440	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   543: astore 10
    //   545: ldc_w 2232
    //   548: iconst_3
    //   549: anewarray 38	java/lang/Object
    //   552: dup
    //   553: iconst_0
    //   554: aload_1
    //   555: aastore
    //   556: dup
    //   557: iconst_1
    //   558: aload_1
    //   559: aastore
    //   560: dup
    //   561: iconst_2
    //   562: iload 6
    //   564: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   567: aastore
    //   568: invokestatic 440	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   571: astore 11
    //   573: goto -424 -> 149
    //   576: ldc_w 2234
    //   579: iconst_3
    //   580: anewarray 38	java/lang/Object
    //   583: dup
    //   584: iconst_0
    //   585: aload_1
    //   586: aastore
    //   587: dup
    //   588: iconst_1
    //   589: aload_1
    //   590: aastore
    //   591: dup
    //   592: iconst_2
    //   593: iload 6
    //   595: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   598: aastore
    //   599: invokestatic 440	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   602: astore 10
    //   604: ldc_w 2236
    //   607: iconst_3
    //   608: anewarray 38	java/lang/Object
    //   611: dup
    //   612: iconst_0
    //   613: aload_1
    //   614: aastore
    //   615: dup
    //   616: iconst_1
    //   617: aload_1
    //   618: aastore
    //   619: dup
    //   620: iconst_2
    //   621: iload 6
    //   623: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   626: aastore
    //   627: invokestatic 440	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   630: astore 11
    //   632: goto -483 -> 149
    //   635: aload 12
    //   637: aload 18
    //   639: invokevirtual 2237	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   642: istore 9
    //   644: iload 9
    //   646: ifne -444 -> 202
    //   649: aload 17
    //   651: aload 18
    //   653: invokestatic 2107	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   656: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   659: invokevirtual 357	java/lang/Long:longValue	()J
    //   662: putfield 2240	com/tencent/mobileqq/data/FTSMessageDelete:delCounter	J
    //   665: aload 17
    //   667: invokevirtual 2243	com/tencent/mobileqq/data/FTSMessageDelete:deletePatch	()V
    //   670: aload 12
    //   672: aload 18
    //   674: invokevirtual 2244	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   677: pop
    //   678: goto -385 -> 293
    //   681: astore 18
    //   683: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   686: ifeq -393 -> 293
    //   689: ldc 66
    //   691: iconst_2
    //   692: aload 18
    //   694: invokevirtual 2245	java/lang/Exception:toString	()Ljava/lang/String;
    //   697: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   700: goto -407 -> 293
    //   703: astore_1
    //   704: aload 13
    //   706: ifnull +8 -> 714
    //   709: aload 13
    //   711: invokevirtual 2217	awby:b	()V
    //   714: aload_1
    //   715: athrow
    //   716: aload 14
    //   718: aload 10
    //   720: invokevirtual 2246	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;)Z
    //   723: pop
    //   724: aload 13
    //   726: ifnull +8 -> 734
    //   729: aload 13
    //   731: invokevirtual 2247	awby:c	()V
    //   734: aload 13
    //   736: ifnull +25 -> 761
    //   739: aload 13
    //   741: invokevirtual 2217	awby:b	()V
    //   744: goto -375 -> 369
    //   747: aload 15
    //   749: invokevirtual 2248	awce:a	()V
    //   752: return
    //   753: astore 11
    //   755: aconst_null
    //   756: astore 10
    //   758: goto -445 -> 313
    //   761: goto -392 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	764	0	this	QQMessageFacade
    //   0	764	1	paramString	String
    //   0	764	2	paramInt	int
    //   21	474	3	i	int
    //   40	426	4	j	int
    //   72	15	5	k	int
    //   79	543	6	m	int
    //   152	328	7	l	long
    //   642	3	9	bool	boolean
    //   119	638	10	localObject1	Object
    //   147	484	11	localObject2	Object
    //   753	1	11	localException1	Exception
    //   191	1	12	localHashSet	HashSet
    //   303	368	12	localException2	Exception
    //   62	678	13	localawby	awby
    //   7	710	14	localSQLiteDatabase	SQLiteDatabase
    //   55	693	15	localawce	awce
    //   200	13	16	localIterator	Iterator
    //   256	410	17	localObject3	Object
    //   222	451	18	localObject4	Object
    //   681	12	18	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   183	202	303	java/lang/Exception
    //   202	293	303	java/lang/Exception
    //   293	300	303	java/lang/Exception
    //   635	644	303	java/lang/Exception
    //   683	700	303	java/lang/Exception
    //   716	724	303	java/lang/Exception
    //   729	734	303	java/lang/Exception
    //   649	678	681	java/lang/Exception
    //   159	164	703	finally
    //   164	178	703	finally
    //   183	202	703	finally
    //   202	293	703	finally
    //   293	300	703	finally
    //   313	351	703	finally
    //   635	644	703	finally
    //   649	678	703	finally
    //   683	700	703	finally
    //   716	724	703	finally
    //   729	734	703	finally
    //   159	164	753	java/lang/Exception
    //   164	178	753	java/lang/Exception
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong, true);
  }
  
  public void b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    MessageRecord localMessageRecord = b(paramString, paramInt, paramLong);
    ((bdqa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.b(localMessageRecord);
    if (a(paramInt).c(paramString, paramInt, paramLong) == 2) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, localMessageRecord);
    }
    if (!paramBoolean) {}
    label168:
    label183:
    do
    {
      for (;;)
      {
        return;
        if (localMessageRecord == null) {
          break label183;
        }
        if (a().b(localMessageRecord.frienduin, localMessageRecord.istroop))
        {
          paramInt = 0;
          if ((localMessageRecord instanceof MessageForLongMsg)) {
            if (abot.a(localMessageRecord, a(localMessageRecord.frienduin, localMessageRecord.istroop))) {
              paramInt = 1;
            }
          }
          while (paramInt != 0)
          {
            if (!abot.t(localMessageRecord.istroop)) {
              break label168;
            }
            a(localMessageRecord.istroop).a(localMessageRecord);
            return;
            if (a(localMessageRecord)) {
              paramInt = 1;
            }
          }
        }
      }
      a(localMessageRecord.istroop).b(localMessageRecord);
      return;
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.QQMessageFacade", 2, "removeMsgByUniseq error: message not found. uin=" + paramString + ",type=" + paramInt + ",uniseq=" + paramLong);
  }
  
  public void b(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    a(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public void b(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localawbw.b((MessageRecord)localIterator.next());
      }
    }
    finally
    {
      localawbw.a();
    }
    a((MessageRecord)paramList.get(paramList.size() - 1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
  }
  
  public void b(List<MessageRecord> paramList, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, true, false, true, true);
      paramString.a();
      paramString = abot.a(paramList);
      if (paramString != null)
      {
        setChanged();
        notifyObservers(paramString);
      }
      e(paramList);
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  public void b(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, false, false, true, false);
      paramString.a();
      paramString = abot.a(paramList);
      if (paramString != null)
      {
        setChanged();
        if (paramBoolean) {
          notifyObservers(paramString);
        }
      }
      if (paramBoolean) {
        e(paramList);
      }
      return;
    }
    finally
    {
      paramString.a();
    }
  }
  
  protected boolean b()
  {
    return ajbg.a(false);
  }
  
  protected boolean b(ConversationInfo paramConversationInfo)
  {
    return ssp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramConversationInfo.uin);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      paramString = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString.time > 0L) && (paramString.senderuin != null)) {
        return true;
      }
    }
    return false;
  }
  
  public int c()
  {
    int i = a(10);
    if (QLog.isColorLevel()) {
      QLog.d("MiniUnreadMsgsNum", 2, "unread count = " + i);
    }
    return i;
  }
  
  public QQMessageFacade.Message c(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    String str1 = a(paramString, paramInt);
    QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilMap.get(str1);
    Object localObject = localMessage;
    awbw localawbw;
    if (localMessage == null)
    {
      localObject = MessageRecord.getTableName(paramString, paramInt);
      String str2 = MessageRecord.getOldTableName(paramString, paramInt);
      localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if ((!localawbw.d((String)localObject)) && (!localawbw.d(str2))) {
        break label135;
      }
      paramString = a(paramString, paramInt, localawbw);
    }
    for (;;)
    {
      localawbw.a();
      localObject = paramString;
      paramString = (String)localObject;
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
      if (!abot.b(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop)) {
        break;
      }
      ((QQMessageFacade.Message)localObject).istroop = abot.a(((QQMessageFacade.Message)localObject).istroop);
      return localObject;
      label135:
      if (localMessage == null)
      {
        localObject = new QQMessageFacade.Message();
        ((QQMessageFacade.Message)localObject).frienduin = paramString;
        ((QQMessageFacade.Message)localObject).istroop = paramInt;
        this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
        paramString = (String)localObject;
      }
      else
      {
        localMessage.isCacheValid = true;
        paramString = localMessage;
      }
    }
  }
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).c(paramString, paramInt, paramLong);
  }
  
  public String c(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    a(localMessage);
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info");
    ConfessInfo localConfessInfo = new ConfessInfo();
    localConfessInfo.parseFromJsonStr((String)localObject);
    paramMessageRecord = aoep.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localConfessInfo, paramMessageRecord.senderuin);
    localObject = new MsgSummary();
    bdec.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage, localMessage.istroop, (MsgSummary)localObject, paramMessageRecord, false, paramBoolean);
    return ((MsgSummary)localObject).a(paramContext).toString();
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return a(paramInt1).c(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public void c()
  {
    a(0).c();
    a(3000).c();
    a(1).c();
    a(1026).c();
  }
  
  public void c(QQMessageFacade.Message paramMessage)
  {
    this.jdField_a_of_type_Amih.a(paramMessage);
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (a(paramMessageRecord.istroop).a(paramMessageRecord)) {
      return;
    }
    if (paramMessageRecord.msgtype == -2005)
    {
      a((MessageForFile)paramMessageRecord);
      return;
    }
    if ((paramMessageRecord.msgtype == -2057) && (paramMessageRecord.istroop == 1)) {
      ((xlf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(208)).a(paramMessageRecord);
    }
    a(paramMessageRecord.istroop).c(paramMessageRecord);
  }
  
  public void c(MessageRecord paramMessageRecord, alsi paramalsi, boolean paramBoolean)
  {
    aeyf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "sendMessage: mr_uinType:" + paramMessageRecord.istroop + " mr_msgType:" + paramMessageRecord.msgtype);
    }
    try
    {
      if (paramMessageRecord.msgUid == 0L) {
        paramMessageRecord.msgUid = ayvy.a(ayvy.a());
      }
      if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -1049))
      {
        if (paramMessageRecord.istroop == 1001) {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.frienduin)) {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.msgtype), String.valueOf(paramMessageRecord.istroop), "");
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, null, paramBoolean);
          return;
          if (paramMessageRecord.istroop == 1003) {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.msgtype), String.valueOf(paramMessageRecord.istroop), "");
          }
        }
      }
      return;
    }
    catch (Exception paramMessageRecord)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.QQMessageFacade", 2, "sendMessage ERROR:" + paramMessageRecord.getMessage(), paramMessageRecord);
        return;
        if ((paramMessageRecord.msgtype == -2011) || (paramMessageRecord.msgtype == -2007) || (paramMessageRecord.msgtype == -2002) || (paramMessageRecord.msgtype == -2000) || (paramMessageRecord.msgtype == -2010) || (paramMessageRecord.msgtype == -2020) || (paramMessageRecord.msgtype == -2022) || (paramMessageRecord.msgtype == -2039) || (paramMessageRecord.msgtype == -5008) || (paramMessageRecord.msgtype == -5012) || (paramMessageRecord.msgtype == -5018) || (paramMessageRecord.msgtype == -1051) || (paramMessageRecord.msgtype == -2051) || (paramMessageRecord.msgtype == -1035) || (paramMessageRecord.msgtype == -2056) || (paramMessageRecord.msgtype == -2057) || (paramMessageRecord.msgtype == -2058) || (paramMessageRecord.msgtype == -7001) || (paramMessageRecord.msgtype == -5013) || (paramMessageRecord.msgtype == -5014) || (paramMessageRecord.msgtype == -5016) || (paramMessageRecord.msgtype == -5017) || (paramMessageRecord.msgtype == -7002) || (paramMessageRecord.msgtype == -7005))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, paramalsi, paramBoolean);
          return;
        }
        if (paramMessageRecord.msgtype == -2071)
        {
          if (paramMessageRecord.istroop == 1) {
            nav.a().a(paramMessageRecord);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, paramalsi, paramBoolean);
        }
      }
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    a(paramString, paramInt, true, false);
  }
  
  public void c(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        a(localMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord, null, false, true, true);
      }
    }
    e(paramList);
  }
  
  protected boolean c(ConversationInfo paramConversationInfo)
  {
    return afai.a(paramConversationInfo.uin, paramConversationInfo.type, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean c(String paramString, int paramInt)
  {
    return d(paramString, paramInt);
  }
  
  public int d()
  {
    return a(7);
  }
  
  public MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).d(paramString, paramInt, paramLong);
  }
  
  public String d(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramContext = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(paramContext, paramMessageRecord);
    paramContext.emoRecentMsg = null;
    paramContext.fileType = -1;
    a(paramContext);
    return bdec.a(paramContext.nickName, 0.4F);
  }
  
  public void d()
  {
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    boolean bool;
    int i;
    if (this.jdField_b_of_type_Int == -1)
    {
      bool = localawbw.d(ConversationInfo.getConversationInfoTableName());
      if (bool)
      {
        i = 1;
        this.jdField_b_of_type_Int = i;
      }
    }
    for (;;)
    {
      localawbw.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache start : Lazy : " + bool);
      }
      long l = System.currentTimeMillis();
      if (bool) {
        a(90, true);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache finish : TimeSpend:" + (System.currentTimeMillis() - l));
        }
        return;
        i = 0;
        break;
        e();
      }
      bool = true;
    }
  }
  
  public void d(String paramString, int paramInt)
  {
    a(paramInt).b(paramString, paramInt, false, false);
  }
  
  public void d(List<MessageRecord> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord instanceof MessageForStructing))
      {
        paramList = (MessageForStructing)localMessageRecord;
        if ((paramList.structingMsg != null) && (paramList.structingMsg.mMsgServiceID == 98))
        {
          abot.a(paramList, false);
          Object localObject = (NearbyGrayTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(93);
          if (QLog.isColorLevel()) {
            QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner will insert a face score message, msg = " + paramList);
          }
          boolean bool2 = aupt.a(paramList, "isFaceScoreSecondMember");
          localObject = ((NearbyGrayTipsManager)localObject).b(1, 2, localMessageRecord.time);
          if (QLog.isColorLevel()) {
            QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner  getValidConfigForFaceScore, flag = " + bool2 + ", configForFaceScore = " + localObject);
          }
          if (localObject != null)
          {
            int i = azto.a(paramList.structingMsg.mExtraData);
            paramList = new Random();
            paramList.setSeed(localMessageRecord.time);
            boolean bool1;
            if ((i & 0x4) != 0)
            {
              bool1 = true;
              label224:
              if (!bool1) {
                break label464;
              }
              if (!bool2) {
                break label454;
              }
              paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject).getFavoriteGrayTipWording1(paramList);
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner  getGrayTipWording, wording = " + paramList);
              }
              if ((paramList == null) || (TextUtils.isEmpty(paramList.text))) {
                break;
              }
              paramList = MessageForNearbyMarketGrayTips.makeGrayTipMsg(((NearbyGrayTipsManager.GrayTipsConfig)localObject).id, paramList.text, paramList.highlightText, 16, ((NearbyGrayTipsManager.GrayTipsConfig)localObject).url, 1);
              localObject = ayvw.a(-2027);
              ((MessageRecord)localObject).init(localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.selfuin, paramList, localMessageRecord.time - 1L, -2027, 1001, localMessageRecord.time - 1L);
              ((MessageRecord)localObject).isread = true;
              aupt.a((MessageRecord)localObject, "isFaceScoreGrayTips", true);
              aupt.a((MessageRecord)localObject, "isFaceScoreSecondMember", bool2);
              aupt.a((MessageRecord)localObject, "isFaceScoreSpecialLike", bool1);
              abot.a((MessageRecord)localObject, false);
              a((MessageRecord)localObject, localMessageRecord.selfuin);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner insert faceScore gray tips., msg = " + localObject);
              break;
              bool1 = false;
              break label224;
              label454:
              paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject).getFavoriteGrayTipWording2(paramList);
              continue;
              label464:
              paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject).getGrayTipWording(paramList);
            }
          }
        }
      }
    }
  }
  
  protected boolean d(ConversationInfo paramConversationInfo)
  {
    return FriendsStatusUtil.a(paramConversationInfo.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean d(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  public int e()
  {
    return a(9);
  }
  
  public MessageRecord e(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).j(paramString, paramInt, paramLong);
  }
  
  public void e()
  {
    a("refreshCache", "");
    System.currentTimeMillis();
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1 = localawbw.a(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    boolean bool1;
    abol localabol;
    StringBuilder localStringBuilder;
    int i;
    int j;
    boolean bool2;
    Object localObject2;
    if (localObject1 != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true);
      bool1 = localawbw.d(ConversationInfo.getConversationInfoTableName());
      localabol = a();
      localStringBuilder = new StringBuilder(128);
      Iterator localIterator = ((List)localObject1).iterator();
      i = 0;
      Object localObject3;
      do
      {
        do
        {
          do
          {
            j = i;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject3 = (Sqlite)localIterator.next();
            ((Sqlite)localObject3).tbl_name = SecurityUtile.b(((Sqlite)localObject3).tbl_name);
          } while ((((Sqlite)localObject3).tbl_name.equals("mr_fileManager")) || (((Sqlite)localObject3).tbl_name.startsWith("mr_confess_a")) || (((Sqlite)localObject3).tbl_name.startsWith("mr_confess_b")));
          bool2 = ((Sqlite)localObject3).tbl_name.endsWith("_New");
          localObject2 = a(abot.a(((Sqlite)localObject3).tbl_name)).a(((Sqlite)localObject3).tbl_name, localawbw);
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 4, "getMsgProxy().queryLastMessage = " + localObject2);
          }
        } while ((localObject2 == null) || ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).frienduin == null)));
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((QQMessageFacade.Message)localObject2).uniseq == 0L)
          {
            a(((QQMessageFacade.Message)localObject2).istroop).b(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
            localObject2 = a(((QQMessageFacade.Message)localObject2).istroop).a(((Sqlite)localObject3).tbl_name, localawbw);
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject2);
              localObject1 = localObject2;
            }
          }
        }
        if (localObject1 == null) {
          break label1081;
        }
      } while (((aljq.z.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (!((Sqlite)localObject3).tbl_name.equals(DataLineMsgRecord.tableName()))) || ((aljq.A.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (!((Sqlite)localObject3).tbl_name.equals(DataLineMsgRecord.tableName(1)))));
      if (((!aljq.H.equals(((QQMessageFacade.Message)localObject1).frienduin)) && ((abot.a(((QQMessageFacade.Message)localObject1).istroop) == 10002) || (abot.a(((QQMessageFacade.Message)localObject1).istroop) == 1001))) || ((!aljq.ab.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (abot.a(((QQMessageFacade.Message)localObject1).istroop) == 1010)))
      {
        localObject2 = a(((QQMessageFacade.Message)localObject1).istroop).b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MessageRecord)((Iterator)localObject2).next();
            if ((((MessageRecord)localObject3).senderuin != null) && (((MessageRecord)localObject3).senderuin.equals(((MessageRecord)localObject3).frienduin)) && (!ayvy.a(((MessageRecord)localObject3).msgtype)))
            {
              ((QQMessageFacade.Message)localObject1).hasReply = true;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject1 + ",hasReply=" + ((QQMessageFacade.Message)localObject1).hasReply);
              }
            }
          }
        }
      }
      a((QQMessageFacade.Message)localObject1);
      if (!bool1)
      {
        d((QQMessageFacade.Message)localObject1);
        if (localList != null)
        {
          j = 0;
          label687:
          if (j < localList.size())
          {
            localObject2 = (RecentUser)localList.get(j);
            if ((localObject2 == null) || (((RecentUser)localObject2).uin == null) || (!((RecentUser)localObject2).uin.equals(((QQMessageFacade.Message)localObject1).frienduin))) {
              break label1037;
            }
            if ((abot.t(((QQMessageFacade.Message)localObject1).istroop)) && (a().a(((QQMessageFacade.Message)localObject1).frienduin, abot.a(((QQMessageFacade.Message)localObject1).istroop))))
            {
              if (((QQMessageFacade.Message)localObject1).istroop != 1009) {
                a(aljq.w, 1009, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              }
              if (((QQMessageFacade.Message)localObject1).istroop == 1001) {
                break label1001;
              }
              a(aljq.H, 1001, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
          }
        }
      }
    }
    label1037:
    label1081:
    label1082:
    for (;;)
    {
      label840:
      localStringBuilder.setLength(0);
      localStringBuilder.append("refreshCache message uin = ").append(((QQMessageFacade.Message)localObject1).frienduin).append(", type = ").append(((QQMessageFacade.Message)localObject1).istroop).append(", unread = ").append(((QQMessageFacade.Message)localObject1).unReadNum).append(", time = ").append(((QQMessageFacade.Message)localObject1).time);
      a(localStringBuilder.toString(), "");
      localObject2 = a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
      if ((!bool2) && (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject2))) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.put(localObject2, localObject1);
      j = i + 1;
      i = j;
      if (!bool1)
      {
        localabol.c(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, ((QQMessageFacade.Message)localObject1).unReadNum);
        i = j;
      }
      for (;;)
      {
        break;
        label1001:
        if (((QQMessageFacade.Message)localObject1).istroop == 10002) {
          break label1082;
        }
        a(aljq.H, 10002, ((QQMessageFacade.Message)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        break label840;
        j += 1;
        break label687;
        j = 0;
        localawbw.a();
        bhof.a().a("MSG_TableNum", j + "");
        return;
      }
    }
  }
  
  public void e(String paramString, int paramInt)
  {
    paramString = new abpc(paramString, paramInt, 0, null);
    setChanged();
    notifyObservers(paramString);
  }
  
  public void e(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(8020, true, paramList);
    }
    asjd.a(paramList);
  }
  
  public boolean e(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_Atvk != null)) {
      return this.jdField_a_of_type_Atvk.a(paramString, paramInt);
    }
    return false;
  }
  
  public MessageRecord f(String paramString, int paramInt, long paramLong)
  {
    return a(paramInt).g(paramString, paramInt, paramLong);
  }
  
  public void f()
  {
    Object localObject1 = new RecentUser().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    localObject1 = localSQLiteDatabase.a((String)localObject1, new String[] { "uin", "type" }, null, null, null, null);
    if (localObject1 != null) {}
    try
    {
      ((Cursor)localObject1).moveToFirst();
      int i = 0;
      while (i < ((Cursor)localObject1).getCount())
      {
        a(((Cursor)localObject1).getString(0), ((Cursor)localObject1).getInt(1), false, true);
        ((Cursor)localObject1).moveToNext();
        i += 1;
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      g();
      a(0).e();
      a(0).d();
      a(3000).e();
      a(3000).d();
      a(1).e();
      a(1).d();
      if ((amjf.jdField_a_of_type_Boolean) && (bdli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().f();
        return;
      }
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
    QLog.e("Q.msg.QQMessageFacade", 1, "not support fts");
  }
  
  public void f(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() < 5)) {}
    while ((this.jdField_a_of_type_Atvk == null) || (paramString == null) || (paramString.length() < 5)) {
      return;
    }
    this.jdField_a_of_type_Atvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
  }
  
  public void g()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1032).a(aljq.aN, 1032);
    HashSet localHashSet = new HashSet(localList.size());
    int i = 0;
    if (i < localList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      int j;
      label71:
      String str;
      if (localMessageRecord.isSelfConfessor())
      {
        j = 1033;
        str = j + "&" + localMessageRecord.senderuin;
        if (!localHashSet.contains(str)) {
          break label127;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 1034;
        break label71;
        label127:
        localHashSet.add(str);
        a(localMessageRecord.senderuin, j, true, true);
      }
    }
    aoep.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    aoep.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
  }
  
  public void h()
  {
    amjk localamjk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    Object localObject = new RecentUser().getTableName();
    String str1 = new TroopAssistantData().getTableName();
    String str2 = new PubAccountAssistantData().getTableName();
    String str3 = new TroopBarData().getTableName();
    String str4 = new NeedHandleUserData().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.a((String)localObject, null, null);
    localSQLiteDatabase.a(str1, null, null);
    localSQLiteDatabase.a(str2, null, null);
    localSQLiteDatabase.a(str4, null, null);
    localSQLiteDatabase.a(str3, null, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v();
    baba.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    localObject = (alws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22);
    if (localObject != null)
    {
      ((alws)localObject).c();
      ((alws)localObject).a(1);
    }
    atwd.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    j();
    localamjk.c();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, true);
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, true);
  }
  
  public void k()
  {
    g(aljq.w, 1009);
    g(aljq.H, 1001);
    g(aljq.H, 10002);
    g(aljq.ab, 1010);
    g(aljq.aU, 1044);
  }
  
  /* Error */
  public void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 2632	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7: aload_0
    //   8: getfield 81	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 1630	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   14: iconst_0
    //   15: invokevirtual 2638	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   18: astore 4
    //   20: aload 4
    //   22: ldc_w 2640
    //   25: lconst_0
    //   26: invokeinterface 2646 4 0
    //   31: lstore_2
    //   32: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   35: ldc2_w 2647
    //   38: ldiv
    //   39: lload_2
    //   40: lsub
    //   41: ldc2_w 2649
    //   44: lcmp
    //   45: ifge +4 -> 49
    //   48: return
    //   49: aload_0
    //   50: lload_2
    //   51: invokespecial 2652	com/tencent/imcore/message/QQMessageFacade:a	(J)V
    //   54: new 163	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 2654
    //   61: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: astore 5
    //   66: aload_0
    //   67: getfield 53	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   70: astore 7
    //   72: aload 7
    //   74: monitorenter
    //   75: new 50	java/util/concurrent/ConcurrentHashMap
    //   78: dup
    //   79: aload_0
    //   80: getfield 53	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   83: invokespecial 2657	java/util/concurrent/ConcurrentHashMap:<init>	(Ljava/util/Map;)V
    //   86: astore 6
    //   88: aload_0
    //   89: getfield 53	com/tencent/imcore/message/QQMessageFacade:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   92: invokevirtual 2658	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   95: aload 7
    //   97: monitorexit
    //   98: aload 6
    //   100: invokevirtual 370	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   103: invokeinterface 186 1 0
    //   108: astore 7
    //   110: aload 7
    //   112: invokeinterface 191 1 0
    //   117: ifeq +114 -> 231
    //   120: aload 7
    //   122: invokeinterface 195 1 0
    //   127: checkcast 245	java/lang/String
    //   130: astore 8
    //   132: aload 6
    //   134: aload 8
    //   136: invokevirtual 2659	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 321	java/lang/Integer
    //   142: invokevirtual 2662	java/lang/Integer:intValue	()I
    //   145: istore_1
    //   146: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +23 -> 172
    //   152: aload 5
    //   154: ldc_w 2664
    //   157: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 8
    //   162: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 2666
    //   168: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_0
    //   173: aload 8
    //   175: iload_1
    //   176: invokevirtual 2668	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;I)V
    //   179: goto -69 -> 110
    //   182: astore 4
    //   184: aload 4
    //   186: invokevirtual 402	java/lang/Exception:printStackTrace	()V
    //   189: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -144 -> 48
    //   195: ldc 66
    //   197: iconst_2
    //   198: new 163	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 2670
    //   208: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 4
    //   213: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: return
    //   223: astore 4
    //   225: aload 7
    //   227: monitorexit
    //   228: aload 4
    //   230: athrow
    //   231: aload 4
    //   233: invokeinterface 2674 1 0
    //   238: ldc_w 2640
    //   241: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   244: ldc2_w 2647
    //   247: ldiv
    //   248: invokeinterface 2680 4 0
    //   253: invokeinterface 2683 1 0
    //   258: pop
    //   259: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq -214 -> 48
    //   265: ldc 66
    //   267: iconst_2
    //   268: aload 5
    //   270: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	QQMessageFacade
    //   145	31	1	i	int
    //   31	20	2	l	long
    //   18	3	4	localSharedPreferences	android.content.SharedPreferences
    //   182	30	4	localException	Exception
    //   223	9	4	localObject1	Object
    //   64	205	5	localStringBuilder	StringBuilder
    //   86	47	6	localConcurrentHashMap	ConcurrentHashMap
    //   130	44	8	str	String
    // Exception table:
    //   from	to	target	type
    //   49	54	182	java/lang/Exception
    //   75	98	223	finally
    //   225	228	223	finally
  }
  
  public void m()
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
    if (localConcurrentHashMap.isEmpty()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "handleRevokeNotifyAfterSyncMsg");
    }
    Iterator localIterator = localConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      ArrayList localArrayList = (ArrayList)localConcurrentHashMap.get(localIterator.next());
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        int i = ((RevokeMsgInfo)localArrayList.get(0)).jdField_a_of_type_Int;
        if (i == 3000)
        {
          if (((almv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(((RevokeMsgInfo)localArrayList.get(0)).jdField_a_of_type_JavaLangString) == null) {}
        }
        else
        {
          String str1;
          do
          {
            do
            {
              a(localArrayList, true);
              break;
            } while (i != 0);
            RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)localArrayList.get(0);
            String str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            String str2 = localRevokeMsgInfo.jdField_b_of_type_JavaLangString;
            str1 = str2;
            if (TextUtils.equals(str3, str2)) {
              str1 = localRevokeMsgInfo.jdField_a_of_type_JavaLangString;
            }
          } while (!((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(str1));
        }
      }
    }
    localConcurrentHashMap.clear();
  }
  
  public void notifyObservers(Object paramObject)
  {
    long l = System.currentTimeMillis();
    super.notifyObservers(paramObject);
    paramObject = bhof.a();
    if (paramObject != null)
    {
      paramObject.c(System.currentTimeMillis() - l);
      paramObject.c();
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Atvk != null) {
      this.jdField_a_of_type_Atvk.a();
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    this.jdField_a_of_type_Amih.a();
    this.jdField_a_of_type_Boolean = false;
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade
 * JD-Core Version:    0.7.0.1
 */