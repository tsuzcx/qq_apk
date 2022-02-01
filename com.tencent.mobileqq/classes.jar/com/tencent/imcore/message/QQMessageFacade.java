package com.tencent.imcore.message;

import abvu;
import abwe;
import abwp;
import abwq;
import abww;
import abwx;
import abwz;
import abxl;
import abya;
import acvz;
import afoa;
import afqy;
import agjp;
import ahux;
import aiku;
import ajje;
import akhg;
import akmb;
import akms;
import algh;
import amrb;
import amsw;
import amtm;
import amwl;
import amzp;
import anaj;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import ankz;
import anla;
import anlb;
import anlc;
import anlh;
import anlk;
import anme;
import anmq;
import anmw;
import anof;
import anux;
import anuz;
import anvc;
import anwp;
import apse;
import apyt;
import aquu;
import araq;
import asdg;
import asgz;
import aszt;
import atni;
import atyd;
import atym;
import atzd;
import avnb;
import avnu;
import avtd;
import awhm;
import awhn;
import aybg;
import ayby;
import aybz;
import azvi;
import bahm;
import bbko;
import bbli;
import bblk;
import bcdn;
import bcef;
import bckb;
import bcqk;
import bcqt;
import bcsz;
import bcvs;
import bdyi;
import bdzk;
import becw;
import bfdm;
import bfwr;
import bfxn;
import bgbo;
import bgga;
import bkwm;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSActivity.SyncTroopSummaryTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.Wording;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.FTSMessageDelete;
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
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Sqlite;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import nmq;
import nmy;
import ofe;
import ofx;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import uaw;
import uda;
import ynq;

public class QQMessageFacade
  extends Observable
  implements QQMessageFacadeStub, Manager
{
  public static final Object AIO_LOCK = new Object();
  public static final boolean DUMP = true;
  public static final String MANAGER_KEY_DATALINE_IPAD = "dataline_manager_ipad";
  public static final String MANAGER_KEY_DATALINE_PC = "dataline_manager_pc";
  private static final int MSG_RECORD_MAX_COUNT = 5000;
  private static final int MSG_RECORD_NUM_PER_TIME = 2500;
  private static final int RECENT_LAST_MSG_COUNT_PART1 = 10;
  private static final String TABLE_LAST_CLIP_TIME = "table_last_clip_time";
  private static final String TAG = "Q.msg.QQMessageFacade";
  public static final int UNREAD_CONTACTS_NUM_DATE = 8;
  public static final int UNREAD_CONTACTS_NUM_LBS = 6;
  public static final int UNREAD_CONTACTS_NUM_MINI_MSG_TAB = 10;
  public static final int UNREAD_CONTACTS_NUM_NOT_TA = 2;
  public static final int UNREAD_CONTACTS_NUM_PUBLICACCOUNT = 9;
  public static final int UNREAD_CONTACTS_NUM_SAMESTATE = 7;
  public static final int UPDATE_MSG_TAB_REASON_ADD = 1;
  public static final int UPDATE_MSG_TAB_REASON_DELETE = 4;
  public static final int UPDATE_MSG_TAB_REASON_UPDATE_CONTENT = 2;
  public static final int UPDATE_MSG_TAB_REASON_UPDATE_OTHER = 3;
  private final QQAppInterface app;
  public final ConcurrentHashMap<String, Boolean> autoPullCache = new ConcurrentHashMap();
  public final Map<String, QQMessageFacade.Message> cachedMsg;
  private List<ChatMessage> curChatMsgList;
  private int currChatType = -1;
  private String currChatUin;
  private volatile boolean isLastMsgCacheLoaded;
  private volatile int isLastmsgCacheLazyLoad = -1;
  private String lastUnreadLog;
  private Map<String, Map<String, Object>> mClassFields = new HashMap();
  private avnb mDraftManager;
  private SparseArray<BaseMessageManager> mManagers = new SparseArray();
  private ArrayList<Integer> mMsgTypeList = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(-2011), Integer.valueOf(-2007), Integer.valueOf(-2002), Integer.valueOf(-2000), Integer.valueOf(-2010), Integer.valueOf(-2020), Integer.valueOf(-2022), Integer.valueOf(-2039), Integer.valueOf(-5008), Integer.valueOf(-5012), Integer.valueOf(-5018), Integer.valueOf(-1051), Integer.valueOf(-2051), Integer.valueOf(-1035), Integer.valueOf(-2056), Integer.valueOf(-2057), Integer.valueOf(-2058), Integer.valueOf(-7001), Integer.valueOf(-5013), Integer.valueOf(-5014), Integer.valueOf(-5016), Integer.valueOf(-5017), Integer.valueOf(-7002), Integer.valueOf(-7005) }));
  private abxl mRegistry;
  public Handler mUIHandler;
  private Object managerLock = new Object();
  private Map<String, anlk> managerMap = new ConcurrentHashMap();
  public anof msgNotifyManager;
  public final ConcurrentHashMap<Integer, List<MessageRecord>> pullCache = new ConcurrentHashMap();
  public final AtomicInteger pullCounter = new AtomicInteger(0);
  public Map<String, Boolean> refreshActionMap;
  private ConcurrentHashMap<String, Integer> tableToCheck = new ConcurrentHashMap();
  
  public QQMessageFacade(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mUIHandler = new Handler(Looper.getMainLooper());
    this.cachedMsg = new QQConcurrentHashMap(1017, 0, 1200);
    this.refreshActionMap = new QQConcurrentHashMap(1018, 0);
    this.msgNotifyManager = new anof(paramQQAppInterface);
    this.mRegistry = new abxl();
    init();
  }
  
  QQMessageFacade(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.app = paramQQAppInterface;
    this.mUIHandler = new Handler(Looper.getMainLooper());
    this.cachedMsg = new QQConcurrentHashMap(1017, 0, 1200);
    this.mRegistry = new abxl();
  }
  
  private void addMessageDecodeMsg(abvu paramabvu)
  {
    Iterator localIterator = paramabvu.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = (MessageRecord)paramabvu.d.get(localObject1);
      localObject1 = getLastMessage(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
      decodeMsg((QQMessageFacade.Message)localObject1);
      if ((localObject2 instanceof MessageForPic))
      {
        localObject2 = bfwr.a((MessageForPic)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((QQMessageFacade.Message)localObject1).msg = ((String)localObject2);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "addMessage decodeMsg uin = " + ((QQMessageFacade.Message)localObject1).frienduin + " , type = " + ((QQMessageFacade.Message)localObject1).istroop + " ,msgType:" + ((QQMessageFacade.Message)localObject1).msgtype + ", con = " + ((QQMessageFacade.Message)localObject1).getLogColorContent());
      }
    }
  }
  
  private void addMsgTypeExtForQim(MessageRecord paramMessageRecord)
  {
    int i = FlashChatManager.a(paramMessageRecord);
    if (i != -1) {}
    try
    {
      ((FlashChatManager)this.app.getManager(217)).a(i, paramMessageRecord);
      return;
    }
    catch (Exception paramMessageRecord)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.QQMessageFacade", 2, "addMultiMessagesInner type " + i, paramMessageRecord);
    }
  }
  
  private void addMultiMessagesInner(List<MessageRecord> paramList, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      qLogColor(String.format("addMultiMessagesInner size = %s, sync = %s, saveToDB = %s, needUpdateUnread = %s, needAddAIO = %s ", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) }), null);
    }
    paramList = atni.a(this.app, paramList);
    if (paramList.isEmpty())
    {
      QLog.d("Q.msg.QQMessageFacade", 1, "addMultiMessagesInner all fake messages");
      return;
    }
    Object localObject1 = new abvu(this.app);
    long l2 = paramList.size();
    handleFaceScoreGrayMsg(paramList);
    Object localObject2 = paramList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      addMsgTypeExtForQim((MessageRecord)localObject3);
      if (((MessageRecord)localObject3).msgtype == -2029) {
        QLog.d("VideoRedBag", 1, new Object[] { "onReceiveGrapTips, uniseq:", Long.valueOf(((MessageRecord)localObject3).uniseq), " uin:", ((MessageRecord)localObject3).frienduin, " type:", Integer.valueOf(((MessageRecord)localObject3).istroop) });
      }
      getBaseMessageManager(((MessageRecord)localObject3).istroop).a((MessageRecord)localObject3, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, (abvu)localObject1);
      if (agjp.a(((MessageRecord)localObject3).frienduin)) {
        algh.a().a(this.app, (MessageRecord)localObject3);
      }
    }
    paramEntityManager = ((abvu)localObject1).g.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject3 = (String)paramEntityManager.next();
      localObject2 = (ofx)this.app.getManager(88);
      localObject3 = ((List)((abvu)localObject1).g.get(localObject3)).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((ofx)localObject2).a((MessageRecord)((Iterator)localObject3).next(), this.app);
      }
    }
    ((abvu)localObject1).g.clear();
    paramEntityManager = getIncomingMsg();
    handleLockScreenMark((abvu)localObject1, paramEntityManager);
    if (paramBoolean3) {
      ((abvu)localObject1).jdField_a_of_type_Abwp.a(paramList);
    }
    localObject2 = ((abvu)localObject1).jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject3 = (RecentUser)((abvu)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject3);
      try
      {
        removeTroopMultiMsgInfo((abvu)localObject1, paramEntityManager, (RecentUser)localObject3);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.QQMessageFacade", 2, "addMultiMessagesInner --> Catch Exception .Info = " + localException);
      }
    }
    paramEntityManager = ((abvu)localObject1).b.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject2 = (String)paramEntityManager.next();
      avnu.a().a((MessageRecord)((abvu)localObject1).b.get(localObject2), this.app);
    }
    paramEntityManager = (amtm)this.app.getManager(255);
    localObject2 = ((abvu)localObject1).c.keySet().iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      paramEntityManager.a((MessageRecord)((abvu)localObject1).c.get(localObject4));
    }
    addMessageDecodeMsg((abvu)localObject1);
    paramEntityManager = ((abvu)localObject1).f.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject2 = (String)paramEntityManager.next();
      localObject2 = ((List)((abvu)localObject1).f.get(localObject2)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject2).next();
        uda.a().a((MessageRecord)localObject4, this.app);
      }
    }
    ((abvu)localObject1).f.clear();
    MsgAutoMonitorUtil.getInstance().addAddMsgTime(System.currentTimeMillis() - l1, l2);
    paramEntityManager = uaw.a();
    localObject1 = (anwp)this.app.getManager(199);
    localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (MessageRecord)((Iterator)localObject2).next();
      paramEntityManager.a(this.app, localObject4);
      ofe.a((MessageRecord)localObject4);
      if ((localObject1 != null) && (((anwp)localObject1).a())) {
        ((anwp)localObject1).b(((MessageRecord)localObject4).senderuin);
      }
      if (((localObject4 instanceof MessageForShortVideo)) && (((MessageForShortVideo)localObject4).redBagType == LocalMediaInfo.REDBAG_TYPE_GET))
      {
        localObject4 = (MessageForShortVideo)localObject4;
        VideoRedbagData.insertData(((MessageForShortVideo)localObject4).shortVideoId, ((MessageForShortVideo)localObject4).uniseq, ((MessageForShortVideo)localObject4).redBagStat);
      }
    }
    afoa.a().a(this.app, paramList);
  }
  
  private void beforeMessageSend(String paramString, MessageRecord paramMessageRecord)
  {
    paramString = (anaj)this.app.getBusinessHandler(13);
    if (!nmy.a(paramMessageRecord)) {
      paramString.a(paramMessageRecord);
    }
  }
  
  private void calculateMsgBoxUnreadCount(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.frienduin != null) && (paramMessage.frienduin.equals(AppConstants.SAME_STATE_BOX_UIN)) && (paramMessage.istroop == 1009))
    {
      paramMessage.unReadNum = 0;
      Object localObject = getMsgProxy(paramMessage.istroop).a(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          int i = paramMessage.unReadNum;
          paramMessage.unReadNum = (getMsgProxy(paramMessage.istroop).a(localMessageRecord.senderuin, localMessageRecord.istroop, 0L) + i);
        }
        localEntityManager.close();
      }
    }
  }
  
  private BaseMessageManager createMessageManagerLocked(int paramInt)
  {
    abww localabww = getMsgProxy(paramInt).a();
    switch (paramInt)
    {
    default: 
      return new abwe(this.app, this, localabww);
    case 1: 
      return new becw(this.app, this, localabww);
    case 3000: 
      return new anlc(this.app, this, localabww);
    case 7000: 
      return new anme(this.app, this, localabww);
    case 1026: 
      return new anlh(this.app, this, localabww);
    }
    return new anmq(this.app, this, localabww);
  }
  
  private boolean dispatchFilterUnreadMsgNum(ConversationInfo paramConversationInfo, boolean[] paramArrayOfBoolean)
  {
    Iterator localIterator = this.mRegistry.e().iterator();
    while (localIterator.hasNext()) {
      if (((abya)localIterator.next()).a(paramConversationInfo, paramArrayOfBoolean)) {
        return true;
      }
    }
    return false;
  }
  
  private void dispatchGetAioList(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List<ChatMessage> paramList)
  {
    Iterator localIterator = this.mRegistry.f().iterator();
    while (localIterator.hasNext()) {
      ((QQMessageFacade.GetAioListCallback)localIterator.next()).onGetAioList(paramString, paramInt1, paramLong, paramInt2, paramBoolean, paramList, this);
    }
  }
  
  private int dispatchGetUnreadMsgNum(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this.mRegistry.e().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((abya)localIterator.next()).a(paramStringBuilder) + i) {}
    return i;
  }
  
  private boolean dispatchSetRead(ConversationInfo paramConversationInfo)
  {
    Iterator localIterator = this.mRegistry.e().iterator();
    while (localIterator.hasNext()) {
      if (((abya)localIterator.next()).a(paramConversationInfo)) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private void filterClipTable(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 160	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 678	com/tencent/mobileqq/app/QQAppInterface:getProxyManager	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   7: invokevirtual 683	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lanuz;
    //   10: iconst_1
    //   11: invokevirtual 689	anuz:getRecentList	(Z)Ljava/util/List;
    //   14: invokeinterface 387 1 0
    //   19: astore 8
    //   21: iconst_0
    //   22: istore_3
    //   23: iconst_0
    //   24: istore 4
    //   26: aload 8
    //   28: invokeinterface 236 1 0
    //   33: ifeq +422 -> 455
    //   36: aload 8
    //   38: invokeinterface 240 1 0
    //   43: checkcast 462	com/tencent/mobileqq/data/RecentUser
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
    //   63: getfield 692	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   66: lload_1
    //   67: lcmp
    //   68: ifle +377 -> 445
    //   71: aload 9
    //   73: getfield 695	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   76: getstatic 698	com/tencent/mobileqq/app/AppConstants:TROOP_ASSISTANT_UIN	Ljava/lang/String;
    //   79: invokevirtual 588	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +103 -> 185
    //   85: invokestatic 481	avnu:a	()Lavnu;
    //   88: aload_0
    //   89: getfield 160	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   92: invokevirtual 701	avnu:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   95: invokeinterface 387 1 0
    //   100: astore 9
    //   102: iload 7
    //   104: iconst_1
    //   105: isub
    //   106: istore 4
    //   108: aload 9
    //   110: invokeinterface 236 1 0
    //   115: ifeq +67 -> 182
    //   118: aload 9
    //   120: invokeinterface 240 1 0
    //   125: checkcast 703	com/tencent/mobileqq/data/TroopAssistantData
    //   128: astore 10
    //   130: iload 4
    //   132: iconst_1
    //   133: iadd
    //   134: istore 5
    //   136: iload 5
    //   138: istore 4
    //   140: aload 10
    //   142: getfield 704	com/tencent/mobileqq/data/TroopAssistantData:lastmsgtime	J
    //   145: lload_1
    //   146: lcmp
    //   147: ifle -39 -> 108
    //   150: iload_3
    //   151: iconst_1
    //   152: iadd
    //   153: istore_3
    //   154: aload_0
    //   155: getfield 112	com/tencent/imcore/message/QQMessageFacade:tableToCheck	Ljava/util/concurrent/ConcurrentHashMap;
    //   158: aload 10
    //   160: getfield 707	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   163: iconst_1
    //   164: invokestatic 711	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   167: iconst_1
    //   168: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: invokevirtual 715	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: iload 5
    //   177: istore 4
    //   179: goto -71 -> 108
    //   182: goto -156 -> 26
    //   185: aload 9
    //   187: getfield 695	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   190: aload 9
    //   192: invokevirtual 718	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   195: invokestatic 723	abwz:b	(Ljava/lang/String;I)Z
    //   198: ifeq +115 -> 313
    //   201: iload 7
    //   203: iconst_1
    //   204: isub
    //   205: istore 4
    //   207: aload_0
    //   208: aload 9
    //   210: getfield 695	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   213: aload 9
    //   215: invokevirtual 718	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   218: invokevirtual 726	com/tencent/imcore/message/QQMessageFacade:getMsgList	(Ljava/lang/String;I)Ljava/util/List;
    //   221: invokeinterface 387 1 0
    //   226: astore 9
    //   228: aload 9
    //   230: invokeinterface 236 1 0
    //   235: ifeq +75 -> 310
    //   238: aload 9
    //   240: invokeinterface 240 1 0
    //   245: checkcast 248	com/tencent/mobileqq/data/MessageRecord
    //   248: astore 10
    //   250: iload 4
    //   252: iconst_1
    //   253: iadd
    //   254: istore 5
    //   256: iload 5
    //   258: istore 4
    //   260: aload 10
    //   262: getfield 729	com/tencent/mobileqq/data/MessageRecord:time	J
    //   265: lload_1
    //   266: lcmp
    //   267: ifle -39 -> 228
    //   270: iload_3
    //   271: iconst_1
    //   272: iadd
    //   273: istore_3
    //   274: aload_0
    //   275: getfield 112	com/tencent/imcore/message/QQMessageFacade:tableToCheck	Ljava/util/concurrent/ConcurrentHashMap;
    //   278: aload 10
    //   280: getfield 528	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   283: aload 10
    //   285: getfield 254	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   288: invokestatic 711	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   291: aload 10
    //   293: getfield 254	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   296: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   299: invokevirtual 715	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   302: pop
    //   303: iload 5
    //   305: istore 4
    //   307: goto -79 -> 228
    //   310: goto -128 -> 182
    //   313: iload_3
    //   314: istore 4
    //   316: aload 9
    //   318: getfield 695	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   321: invokestatic 732	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   324: invokevirtual 735	java/lang/Long:longValue	()J
    //   327: ldc2_w 736
    //   330: lcmp
    //   331: ifle +46 -> 377
    //   334: iload_3
    //   335: iconst_1
    //   336: iadd
    //   337: istore_3
    //   338: iload_3
    //   339: istore 4
    //   341: aload_0
    //   342: getfield 112	com/tencent/imcore/message/QQMessageFacade:tableToCheck	Ljava/util/concurrent/ConcurrentHashMap;
    //   345: aload 9
    //   347: getfield 695	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   350: aload 9
    //   352: invokevirtual 718	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   355: invokestatic 711	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   358: aload 9
    //   360: invokevirtual 718	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   363: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: invokevirtual 715	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   395: invokevirtual 740	java/lang/NumberFormatException:printStackTrace	()V
    //   398: iload 4
    //   400: istore 6
    //   402: iload_3
    //   403: istore 5
    //   405: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +37 -> 445
    //   411: ldc 33
    //   413: iconst_2
    //   414: new 288	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 742
    //   424: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 9
    //   429: invokevirtual 471	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 319	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   462: getfield 112	com/tencent/imcore/message/QQMessageFacade:tableToCheck	Ljava/util/concurrent/ConcurrentHashMap;
    //   465: invokevirtual 743	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   468: astore 10
    //   470: aload_0
    //   471: getfield 160	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   474: invokevirtual 747	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   477: astore 8
    //   479: aload 8
    //   481: ldc_w 749
    //   484: aconst_null
    //   485: invokevirtual 755	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   488: astore 9
    //   490: aload 9
    //   492: ifnull +140 -> 632
    //   495: aload 9
    //   497: astore 8
    //   499: aload 9
    //   501: invokeinterface 760 1 0
    //   506: ifeq +126 -> 632
    //   509: aload 9
    //   511: astore 8
    //   513: aload 9
    //   515: iconst_0
    //   516: invokeinterface 764 2 0
    //   521: invokestatic 770	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   524: astore 11
    //   526: aload 9
    //   528: astore 8
    //   530: aload 10
    //   532: aload 11
    //   534: invokeinterface 773 2 0
    //   539: ifne -44 -> 495
    //   542: aload 9
    //   544: astore 8
    //   546: aload_0
    //   547: getfield 112	com/tencent/imcore/message/QQMessageFacade:tableToCheck	Ljava/util/concurrent/ConcurrentHashMap;
    //   550: aload 11
    //   552: aload 11
    //   554: invokestatic 777	com/tencent/mobileqq/data/MessageRecord:getTypeByTableName	(Ljava/lang/String;)I
    //   557: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   560: invokevirtual 715	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   563: pop
    //   564: goto -69 -> 495
    //   567: astore 10
    //   569: aload 9
    //   571: astore 8
    //   573: aload 10
    //   575: invokevirtual 778	java/lang/Exception:printStackTrace	()V
    //   578: aload 9
    //   580: astore 8
    //   582: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   585: ifeq +34 -> 619
    //   588: aload 9
    //   590: astore 8
    //   592: ldc 33
    //   594: iconst_2
    //   595: new 288	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 742
    //   605: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 10
    //   610: invokevirtual 471	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 319	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: aload 9
    //   621: ifnull +10 -> 631
    //   624: aload 9
    //   626: invokeinterface 779 1 0
    //   631: return
    //   632: aload 9
    //   634: ifnull -3 -> 631
    //   637: aload 9
    //   639: invokeinterface 779 1 0
    //   644: return
    //   645: astore 9
    //   647: aconst_null
    //   648: astore 8
    //   650: aload 8
    //   652: ifnull +10 -> 662
    //   655: aload 8
    //   657: invokeinterface 779 1 0
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
  
  private int filterUnreadMsgsNumForPA(ConversationInfo paramConversationInfo, int paramInt)
  {
    int i = paramInt;
    if (paramConversationInfo.type == 1008)
    {
      i = paramInt;
      if (paramInt > 0)
      {
        int j = this.app.getConversationFacade().g(paramConversationInfo.uin, 1008);
        i = paramInt;
        if (j > 0) {
          i = paramInt - 1;
        }
        paramInt = i;
        if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramConversationInfo.uin))
        {
          paramInt = i;
          if (j > 0) {
            paramInt = 0;
          }
        }
        i = paramInt;
        if (AppConstants.KANDIAN_DAILY_UIN.equals(paramConversationInfo.uin)) {
          if (j <= 0)
          {
            i = paramInt;
            if (bkwm.k()) {}
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
  
  private void getBackupMsgUserDataList(List<RecentBaseData> paramList, List<RecentUser> paramList1, HashMap<String, MsgBackupMsgUserData> paramHashMap)
  {
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList1 = paramList1.iterator();
      label123:
      while (paramList1.hasNext())
      {
        String str = ((RecentUser)paramList1.next()).uin;
        MsgBackupMsgUserData localMsgBackupMsgUserData = (MsgBackupMsgUserData)paramHashMap.get(str);
        if ((localMsgBackupMsgUserData != null) && (Long.parseLong(str) > 10000L))
        {
          if ((localMsgBackupMsgUserData.uinType == 0) || (localMsgBackupMsgUserData.uinType == 1) || (localMsgBackupMsgUserData.uinType == 3000)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label123;
            }
            paramList.add(localMsgBackupMsgUserData);
            break;
          }
        }
      }
    }
  }
  
  private String getKey(String paramString, int paramInt)
  {
    return abwz.a(paramString, paramInt);
  }
  
  private abwx getMsgProxy(int paramInt)
  {
    return this.app.getMessageProxy(paramInt);
  }
  
  @NotNull
  private msg_svc.PbC2CReadedReportReq getStrangerFriendUnreadList(StringBuilder paramStringBuilder, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, ConversationInfo paramConversationInfo, int paramInt)
  {
    msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
    String str = paramConversationInfo.uin;
    if (1006 == paramConversationInfo.type) {
      str = ContactUtils.getUinByPhoneNum(this.app, paramConversationInfo.uin);
    }
    if (TextUtils.isEmpty(str)) {
      return paramPbC2CReadedReportReq;
    }
    localUinPairReadInfo.peer_uin.set(Long.valueOf(str).longValue());
    paramStringBuilder.append("{C2C:").append(Long.valueOf(str)).append(paramConversationInfo.type).append("}");
    localUinPairReadInfo.last_read_time.set(paramInt);
    paramStringBuilder = paramPbC2CReadedReportReq;
    if (paramPbC2CReadedReportReq == null) {
      paramStringBuilder = new msg_svc.PbC2CReadedReportReq();
    }
    paramStringBuilder.pair_info.add(localUinPairReadInfo);
    return paramStringBuilder;
  }
  
  private msg_svc.PbC2CReadedReportReq getUinPairUnreadList(boolean paramBoolean, StringBuilder paramStringBuilder, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, MessageRecord paramMessageRecord)
  {
    Object localObject;
    if (abwz.b(paramMessageRecord.senderuin))
    {
      paramStringBuilder = getMsgList(paramMessageRecord.senderuin, paramMessageRecord.istroop);
      localObject = paramPbC2CReadedReportReq;
      if (paramStringBuilder != null)
      {
        localObject = paramPbC2CReadedReportReq;
        if (!paramStringBuilder.isEmpty())
        {
          paramMessageRecord = paramStringBuilder.iterator();
          for (;;)
          {
            localObject = paramPbC2CReadedReportReq;
            if (!paramMessageRecord.hasNext()) {
              break;
            }
            paramStringBuilder = (MessageRecord)paramMessageRecord.next();
            setReaded(paramStringBuilder.senderuin, paramStringBuilder.istroop, true, paramBoolean);
            localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
            ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(Long.valueOf(paramStringBuilder.senderuin).longValue());
            ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)paramStringBuilder.time);
            paramStringBuilder = paramPbC2CReadedReportReq;
            if (paramPbC2CReadedReportReq == null) {
              paramStringBuilder = new msg_svc.PbC2CReadedReportReq();
            }
            paramStringBuilder.pair_info.add((MessageMicro)localObject);
            paramPbC2CReadedReportReq = paramStringBuilder;
          }
        }
      }
    }
    else
    {
      setReaded(paramMessageRecord.senderuin, paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), true, paramBoolean);
      msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      localUinPairReadInfo.peer_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      localUinPairReadInfo.last_read_time.set((int)paramMessageRecord.time);
      localObject = paramPbC2CReadedReportReq;
      if (paramPbC2CReadedReportReq == null) {
        localObject = new msg_svc.PbC2CReadedReportReq();
      }
      ((msg_svc.PbC2CReadedReportReq)localObject).pair_info.add(localUinPairReadInfo);
      paramStringBuilder.append("{MSGBOX:").append(paramMessageRecord.frienduin).append("}");
    }
    return localObject;
  }
  
  private msg_svc.PbC2CReadedReportReq getUinPairUnreadListFromMessageBox(boolean paramBoolean, StringBuilder paramStringBuilder, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, ConversationInfo paramConversationInfo)
  {
    if (1044 == paramConversationInfo.type) {}
    do
    {
      return paramPbC2CReadedReportReq;
      paramConversationInfo = getMsgList(paramConversationInfo.uin, paramConversationInfo.type);
    } while (paramConversationInfo == null);
    int i = paramConversationInfo.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramConversationInfo.get(i);
      if (localMessageRecord == null) {}
      for (;;)
      {
        i -= 1;
        break;
        paramPbC2CReadedReportReq = getUinPairUnreadList(paramBoolean, paramStringBuilder, paramPbC2CReadedReportReq, localMessageRecord);
      }
    }
    return paramPbC2CReadedReportReq;
  }
  
  private int getUnreadMsgsNum(int paramInt)
  {
    int k = 0;
    int i = 0;
    Object localObject = this.app.getProxyManager().a().a();
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
        if (!filterUnreadMsgsNum(localConversationInfo))
        {
          j = getBaseMessageManager(localConversationInfo.type).a(paramInt, localConversationInfo);
          if ((QLog.isColorLevel()) && (localStringBuilder != null) && (j > 0)) {
            localStringBuilder.append("[" + localConversationInfo.uin + "," + localConversationInfo.type + "," + j + "]");
          }
          i = filterUnreadMsgsNumForPA(localConversationInfo, j) + i;
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
  
  private boolean handleFTSMsgCounter(HashSet<String> paramHashSet, FTSMessageDelete paramFTSMessageDelete, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramFTSMessageDelete.deleteOne();
    }
    for (;;)
    {
      return false;
      if (paramHashSet.contains(paramString)) {
        return true;
      }
      try
      {
        paramFTSMessageDelete.delCounter = Long.valueOf(Long.parseLong(paramString)).longValue();
        paramFTSMessageDelete.deletePatch();
        paramHashSet.add(paramString);
      }
      catch (Exception paramHashSet) {}
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, paramHashSet.toString());
      }
    }
  }
  
  private void handleLockScreenMark(abvu paramabvu, QQMessageFacade.Message paramMessage)
  {
    int j;
    int i;
    if (paramMessage != null)
    {
      j = 0;
      if (paramMessage.istroop != 1) {
        break label69;
      }
      paramabvu = paramabvu.jdField_a_of_type_Avtd.a(paramMessage.frienduin);
      i = j;
      if (paramabvu != null)
      {
        i = j;
        if (paramabvu.a() == paramMessage.shmsgseq) {
          i = paramabvu.b(this.app, true, paramMessage.frienduin);
        }
      }
    }
    for (;;)
    {
      paramMessage.bizType = i;
      return;
      label69:
      i = j;
      if (paramMessage.istroop == 3000)
      {
        paramabvu = paramabvu.jdField_a_of_type_Avtd.a(paramMessage.frienduin + "&" + 3000);
        i = j;
        if (paramabvu != null)
        {
          i = j;
          if (paramabvu.a() == paramMessage.shmsgseq) {
            i = paramabvu.a();
          }
        }
      }
    }
  }
  
  private void putFriendTroopDiscussionMsgUserDataIntoMap(HashMap<String, MsgBackupMsgUserData> paramHashMap, boolean paramBoolean, int paramInt, QQMessageFacade.Message paramMessage, String paramString1, String paramString2)
  {
    int j = 1;
    String str;
    if (paramBoolean)
    {
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = paramString1;
      }
      i = j;
      if (paramMessage.istroop != 0)
      {
        i = j;
        if (paramMessage.istroop != 1) {
          if (paramMessage.istroop != 3000) {
            break label114;
          }
        }
      }
    }
    label114:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        paramMessage = new MsgBackupMsgUserData();
        paramMessage.uin = paramString1;
        paramMessage.uinType = paramInt;
        paramMessage.name = str;
        paramMessage.mTitleName = str;
        paramHashMap.put(paramString1, paramMessage);
      }
      return;
    }
  }
  
  private void recordC2CReportMsg(msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq)
  {
    if (paramPbC2CReadedReportReq != null)
    {
      byte[] arrayOfByte = this.app.getMsgHandler().a().a();
      if (arrayOfByte != null) {
        paramPbC2CReadedReportReq.sync_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      paramPbMsgReadedReportReq.c2c_read_report.set(paramPbC2CReadedReportReq);
    }
  }
  
  private void recordMR(MessageRecord paramMessageRecord)
  {
    this.app.getParcelHooker().a(paramMessageRecord);
  }
  
  private void refreshMsgBox(String paramString, int paramInt)
  {
    Object localObject = getMsgProxy(paramInt).a(paramString, paramInt);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (abwz.b(localMessageRecord.senderuin))
        {
          refreshMsgBox(localMessageRecord.senderuin, localMessageRecord.istroop);
        }
        else if (((amsw)this.app.getManager(51)).b(localMessageRecord.senderuin))
        {
          getConversationFacade().a(paramString, paramInt, localMessageRecord.frienduin, localMessageRecord.istroop);
          removeMsgFromMsgBox(paramString, paramInt, localMessageRecord.senderuin, localMessageRecord.selfuin);
          QQMessageFacade.Message localMessage = getLastMessage(localMessageRecord.senderuin, paramInt);
          anuz localanuz = this.app.getProxyManager().a();
          RecentUser localRecentUser = (RecentUser)localanuz.findRecentUserByUin(localMessage.frienduin, localMessage.istroop);
          localRecentUser.lastmsgtime = localMessage.time;
          akms.a(localRecentUser, this.app.getMessageFacade());
          localanuz.saveRecentUser(localRecentUser);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "refreshMsgBox uin=" + paramString + ",type=" + paramInt + ",move " + localMessageRecord.senderuin + " from box to recentlist");
          }
          setChanged();
          notifyObservers(localRecentUser);
        }
      }
    }
  }
  
  private void refreshMsgBoxCache(List<RecentUser> paramList, QQMessageFacade.Message paramMessage)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        RecentUser localRecentUser = (RecentUser)paramList.get(i);
        if ((localRecentUser == null) || (localRecentUser.uin == null) || (!localRecentUser.uin.equals(paramMessage.frienduin))) {
          break label89;
        }
        if ((abwz.t(paramMessage.istroop)) && (getConversationFacade().a(paramMessage.frienduin, abwz.a(paramMessage.istroop)))) {
          removeMsgFromMsgBoxByType(paramMessage);
        }
      }
      return;
      label89:
      i += 1;
    }
  }
  
  private QQMessageFacade.Message refreshSingleLastMsg(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    return refreshSingleLastMsg(paramString, paramInt, paramEntityManager, 0);
  }
  
  private QQMessageFacade.Message refreshSingleLastMsg(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    paramEntityManager = getBaseMessageManager(paramInt1).a(paramString, paramInt1, paramEntityManager, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "refreshSingleLastMsg() called with: uin = [" + paramString + "], uinType = [" + paramInt1 + "], topicId = [" + paramInt2 + "], cost = [" + (SystemClock.uptimeMillis() - l) + "]ms");
    }
    return paramEntityManager;
  }
  
  private void refreshTribeTempCache(QQMessageFacade.Message paramMessage)
  {
    if (((!AppConstants.LBS_HELLO_UIN.equals(paramMessage.frienduin)) && ((abwz.a(paramMessage.istroop) == 10002) || (abwz.a(paramMessage.istroop) == 1001))) || (abwz.a(paramMessage.istroop) == 10010) || ((!AppConstants.DATE_UIN.equals(paramMessage.frienduin)) && (abwz.a(paramMessage.istroop) == 1010)))
    {
      Object localObject = getMsgProxy(paramMessage.istroop).b(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equals(localMessageRecord.frienduin)) && (!bblk.a(localMessageRecord.msgtype)))
          {
            paramMessage.hasReply = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + paramMessage + ",hasReply=" + paramMessage.hasReply);
            }
          }
        }
      }
    }
  }
  
  private void refreshTroopAssistCache_Lazy(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.query(TroopAssistantData.class, false, null, null, null, null, "lastmsgtime desc", null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        refreshSingleLastMsg(((TroopAssistantData)((Iterator)localObject).next()).troopUin, 1, paramEntityManager);
      }
    }
  }
  
  private void removeMsgFromMsgBoxByType(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.istroop != 1009) {
      removeMsgFromMsgBox(AppConstants.SAME_STATE_BOX_UIN, 1009, paramMessage.frienduin, this.app.getCurrentAccountUin());
    }
    if (paramMessage.istroop != 1001)
    {
      removeMsgFromMsgBox(AppConstants.LBS_HELLO_UIN, 1001, paramMessage.frienduin, this.app.getCurrentAccountUin());
      return;
    }
    removeMsgFromMsgBox(AppConstants.LBS_HELLO_UIN, 10002, paramMessage.frienduin, this.app.getCurrentAccountUin());
  }
  
  private void removeTroopMultiMsgInfo(abvu paramabvu, QQMessageFacade.Message paramMessage, RecentUser paramRecentUser)
  {
    awhn.a(this.app, paramRecentUser);
    akms.a(paramRecentUser, this);
    paramabvu.jdField_a_of_type_Anuz.saveRecentUser(paramRecentUser);
    if (paramRecentUser.getType() == 1038) {
      ((akhg)this.app.getManager(315)).a(paramRecentUser);
    }
    if (paramMessage != null)
    {
      if (paramMessage.istroop == 3000) {
        paramabvu.jdField_a_of_type_Avtd.b(paramRecentUser.uin + "&" + 3000);
      }
    }
    else {
      return;
    }
    paramabvu.jdField_a_of_type_Avtd.b(paramRecentUser.uin);
  }
  
  private void reportTroopReportMsg(msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, ConversationInfo paramConversationInfo, long paramLong)
  {
    if (!paramConversationInfo.uin.matches("^\\d+$")) {
      return;
    }
    msg_svc.PbGroupReadedReportReq localPbGroupReadedReportReq = new msg_svc.PbGroupReadedReportReq();
    localPbGroupReadedReportReq.group_code.set(Long.valueOf(paramConversationInfo.uin).longValue());
    localPbGroupReadedReportReq.last_read_seq.set(paramLong);
    paramPbMsgReadedReportReq.grp_read_report.add(localPbGroupReadedReportReq);
  }
  
  private void setSubaccountAssistantReaded(StringBuilder paramStringBuilder, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, ConversationInfo paramConversationInfo)
  {
    if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramConversationInfo.uin)) {}
    do
    {
      do
      {
        return;
        localObject = (bcqt)this.app.getManager(61);
      } while (localObject == null);
      ((bcqt)localObject).b(paramConversationInfo.uin);
      paramConversationInfo = ((bcqt)localObject).a(paramConversationInfo.uin);
    } while (paramConversationInfo == null);
    Object localObject = new msg_svc.PbBindUinMsgReadedConfirmReq();
    ((msg_svc.PbBindUinMsgReadedConfirmReq)localObject).sync_cookie.set(ByteStringMicro.copyFrom(paramConversationInfo));
    paramPbMsgReadedReportReq.bind_uin_read_report.set((MessageMicro)localObject);
    paramStringBuilder.append("{SUBUIN}");
  }
  
  private msg_svc.PbC2CReadedReportReq setTempGameMsgReaded(boolean paramBoolean, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, ConversationInfo paramConversationInfo)
  {
    Object localObject = paramPbC2CReadedReportReq;
    if (paramBoolean)
    {
      setReaded(paramConversationInfo.uin, paramConversationInfo.type, true, paramBoolean);
      long l = getReadConfirmStamp(paramConversationInfo.uin, paramConversationInfo.type);
      msg_svc.PbC2CReadedReportReq localPbC2CReadedReportReq = paramPbC2CReadedReportReq;
      if (paramPbC2CReadedReportReq == null) {
        localPbC2CReadedReportReq = new msg_svc.PbC2CReadedReportReq();
      }
      atym.a(this.app, localPbC2CReadedReportReq, l, paramConversationInfo);
      localObject = localPbC2CReadedReportReq;
      if (atyd.a())
      {
        ((atyd)this.app.getManager(358)).c(0);
        localObject = localPbC2CReadedReportReq;
      }
    }
    return localObject;
  }
  
  private void writeSynchronousLogTable(aybg paramaybg, List<MessageRecord> paramList)
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
        if (!handleFTSMsgCounter(localHashSet, (FTSMessageDelete)localObject, localMessageRecord.getExtInfoFromExtStr("ExtraFTSMsgCounter"))) {
          paramaybg.persistOrReplace((Entity)localObject);
        }
      }
    }
  }
  
  public void addAIOHeadMessage(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      getMsgProxy(((MessageRecord)paramList.get(0)).istroop).b(paramString, paramInt, paramList);
      setChanged();
      notifyObservers(paramList.get(0));
      paramString = this.app.getEntityManagerFactory(this.app.getCurrentAccountUin()).createEntityManager();
    }
    try
    {
      addMultiMessagesInner(paramList, paramString, true, true, false, false);
      paramString.close();
      notifyMessageObserver(paramList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void addAndSendMessage(MessageRecord paramMessageRecord, amwl paramamwl)
  {
    addAndSendMessage(paramMessageRecord, paramamwl, false);
  }
  
  public void addAndSendMessage(MessageRecord paramMessageRecord, amwl paramamwl, boolean paramBoolean)
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
      addSendMessage(paramMessageRecord);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
      }
      sendMessage(paramMessageRecord, paramamwl, paramBoolean);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " addAndSendMessage sendMessage end currenttime:" + System.currentTimeMillis());
  }
  
  public void addMessage(MessageRecord paramMessageRecord, String paramString)
  {
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      addMultiMessagesInner(localArrayList, paramString, false, true, true, true);
      setChanged();
      if (((paramMessageRecord instanceof ChatMessage)) && (paramMessageRecord.isSend())) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      notifyObservers(paramMessageRecord);
      notifyMessageObserver(localArrayList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void addMessage(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      addMultiMessagesInner(localArrayList, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      setChanged();
      if (((paramMessageRecord instanceof ChatMessage)) && (paramMessageRecord.isSend())) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      notifyObservers(paramMessageRecord);
      notifyMessageObserver(localArrayList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void addMessage(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        addMultiMessagesInner(paramArrayList, paramString, paramBoolean, bool, true, true);
        paramString.close();
        if ((paramBoolean) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          getMsgProxy(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        paramString = abwz.a(paramArrayList);
        if (paramString != null)
        {
          setChanged();
          notifyObservers(paramString);
          bfxn.a(this.app, paramString);
        }
        return;
      }
      finally
      {
        paramString.close();
      }
      bool = false;
    }
  }
  
  public void addMessage(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        addMultiMessagesInner(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.close();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          getMsgProxy(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if (paramBoolean2)
        {
          paramString = abwz.a(paramArrayList);
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
        paramString.close();
      }
      bool = false;
    }
  }
  
  public void addMessage(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        addMultiMessagesInner(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.close();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          getMsgProxy(((MessageRecord)paramArrayList.get(0)).istroop).a(paramArrayList, null);
        }
        if ((paramBoolean2) || (paramBoolean3))
        {
          paramString = abwz.a(paramArrayList);
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
        paramString.close();
      }
      bool = false;
    }
  }
  
  public void addMessage(List<MessageRecord> paramList, String paramString)
  {
    addMessage(paramList, paramString, true);
  }
  
  public void addMessage(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    paramString = this.app.getEntityManagerFactory().createEntityManager();
    try
    {
      addMultiMessagesInner(paramList, paramString, false, true, true, paramBoolean);
      paramString.close();
      paramString = abwz.a(paramList);
      if (paramString != null)
      {
        setChanged();
        if (paramBoolean) {
          notifyObservers(paramString);
        }
      }
      if (paramBoolean) {
        notifyMessageObserver(paramList);
      }
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void addMessageCacheOnly(List<MessageRecord> paramList, String paramString)
  {
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      addMultiMessagesInner(paramList, paramString, true, false, true, true);
      paramString.close();
      paramString = abwz.a(paramList);
      if (paramString != null)
      {
        setChanged();
        notifyObservers(paramString);
      }
      notifyMessageObserver(paramList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void addMessageDBOnly(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      getMsgProxy(((MessageRecord)paramList.get(0)).istroop).a(paramList, null);
    }
    notifyMessageObserver(paramList);
  }
  
  public void addMessageForMsgBackup(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localEntityManager.persistOrReplace((MessageRecord)localIterator.next());
      }
    }
    finally
    {
      localEntityManager.close();
    }
    addMessage((MessageRecord)paramList.get(paramList.size() - 1), this.app.getCurrentUin());
  }
  
  public void addMessagePoolOnly(List<MessageRecord> paramList, String paramString)
  {
    addMessagePoolOnly(paramList, paramString, true);
  }
  
  public void addMessagePoolOnly(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      addMultiMessagesInner(paramList, paramString, false, false, true, false);
      paramString.close();
      paramString = abwz.a(paramList);
      if (paramString != null)
      {
        setChanged();
        if (paramBoolean) {
          notifyObservers(paramString);
        }
      }
      if (paramBoolean) {
        notifyMessageObserver(paramList);
      }
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void addMessageStore(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        getMsgProxy(localMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord, null, false, true, true);
      }
    }
    notifyMessageObserver(paramList);
  }
  
  public void addMsgForForward(MessageRecord paramMessageRecord)
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
      addSendMessage(paramMessageRecord);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
  }
  
  public void addSendMessage(MessageRecord paramMessageRecord)
  {
    addSendMessage(paramMessageRecord, MessageHandler.e);
  }
  
  public void addSendMessage(MessageRecord paramMessageRecord, int paramInt)
  {
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    try
    {
      beforeMessageSend(paramMessageRecord.frienduin, paramMessageRecord);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      addMultiMessagesInner(localArrayList, localEntityManager, false, true, true, true);
      if (QLog.isColorLevel()) {
        QLog.d("sendmsg", 2, String.format("addSendMessage key = %d %s %d", new Object[] { Long.valueOf(paramMessageRecord.uniseq), paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop) }));
      }
      this.app.getMsgCache().a(paramMessageRecord, paramInt);
      setChanged();
      notifyObservers(paramMessageRecord);
      return;
    }
    finally
    {
      localEntityManager.close();
    }
  }
  
  /* Error */
  public void checkMsgCounts()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 160	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 1372	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7: aload_0
    //   8: getfield 160	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 1152	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   14: iconst_0
    //   15: invokevirtual 1378	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   18: astore 4
    //   20: aload 4
    //   22: ldc 30
    //   24: lconst_0
    //   25: invokeinterface 1384 4 0
    //   30: lstore_2
    //   31: invokestatic 351	java/lang/System:currentTimeMillis	()J
    //   34: ldc2_w 1385
    //   37: ldiv
    //   38: lload_2
    //   39: lsub
    //   40: ldc2_w 1387
    //   43: lcmp
    //   44: ifge +4 -> 48
    //   47: return
    //   48: aload_0
    //   49: lload_2
    //   50: invokespecial 1390	com/tencent/imcore/message/QQMessageFacade:filterClipTable	(J)V
    //   53: new 288	java/lang/StringBuilder
    //   56: dup
    //   57: ldc_w 1392
    //   60: invokespecial 912	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: astore 5
    //   65: aload_0
    //   66: getfield 112	com/tencent/imcore/message/QQMessageFacade:tableToCheck	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: astore 7
    //   71: aload 7
    //   73: monitorenter
    //   74: new 109	java/util/concurrent/ConcurrentHashMap
    //   77: dup
    //   78: aload_0
    //   79: getfield 112	com/tencent/imcore/message/QQMessageFacade:tableToCheck	Ljava/util/concurrent/ConcurrentHashMap;
    //   82: invokespecial 1395	java/util/concurrent/ConcurrentHashMap:<init>	(Ljava/util/Map;)V
    //   85: astore 6
    //   87: aload_0
    //   88: getfield 112	com/tencent/imcore/message/QQMessageFacade:tableToCheck	Ljava/util/concurrent/ConcurrentHashMap;
    //   91: invokevirtual 1396	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   94: aload 7
    //   96: monitorexit
    //   97: aload 6
    //   99: invokevirtual 743	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   102: invokeinterface 230 1 0
    //   107: astore 7
    //   109: aload 7
    //   111: invokeinterface 236 1 0
    //   116: ifeq +114 -> 230
    //   119: aload 7
    //   121: invokeinterface 240 1 0
    //   126: checkcast 242	java/lang/String
    //   129: astore 8
    //   131: aload 6
    //   133: aload 8
    //   135: invokevirtual 1397	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: checkcast 132	java/lang/Integer
    //   141: invokevirtual 1400	java/lang/Integer:intValue	()I
    //   144: istore_1
    //   145: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +23 -> 171
    //   151: aload 5
    //   153: ldc_w 1402
    //   156: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 8
    //   161: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 1404
    //   167: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_0
    //   172: aload 8
    //   174: iload_1
    //   175: invokevirtual 1407	com/tencent/imcore/message/QQMessageFacade:checkRecordCount	(Ljava/lang/String;I)V
    //   178: goto -69 -> 109
    //   181: astore 4
    //   183: aload 4
    //   185: invokevirtual 778	java/lang/Exception:printStackTrace	()V
    //   188: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq -144 -> 47
    //   194: ldc 33
    //   196: iconst_2
    //   197: new 288	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 1409
    //   207: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 4
    //   212: invokevirtual 471	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 319	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: return
    //   222: astore 4
    //   224: aload 7
    //   226: monitorexit
    //   227: aload 4
    //   229: athrow
    //   230: aload 4
    //   232: invokeinterface 1413 1 0
    //   237: ldc 30
    //   239: invokestatic 351	java/lang/System:currentTimeMillis	()J
    //   242: ldc2_w 1385
    //   245: ldiv
    //   246: invokeinterface 1419 4 0
    //   251: invokeinterface 1422 1 0
    //   256: pop
    //   257: invokestatic 286	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq -213 -> 47
    //   263: ldc 33
    //   265: iconst_2
    //   266: aload 5
    //   268: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 319	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	QQMessageFacade
    //   144	31	1	i	int
    //   30	20	2	l	long
    //   18	3	4	localSharedPreferences	android.content.SharedPreferences
    //   181	30	4	localException	Exception
    //   222	9	4	localObject1	Object
    //   63	204	5	localStringBuilder	StringBuilder
    //   85	47	6	localConcurrentHashMap	ConcurrentHashMap
    //   129	44	8	str	String
    // Exception table:
    //   from	to	target	type
    //   48	53	181	java/lang/Exception
    //   74	97	222	finally
    //   224	227	222	finally
  }
  
  public void checkRecordCount(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.getWritableDatabase();
    if (localSQLiteDatabase == null) {}
    do
    {
      return;
      i = localSQLiteDatabase.getCount(paramString);
    } while (i <= 6000);
    int j = Math.max(i - 5000, 1200);
    aybg localaybg = (aybg)this.app.getEntityManagerFactory().createMessageRecordEntityManager();
    EntityTransaction localEntityTransaction = localaybg.getTransaction();
    int k = j / 2500 + 1;
    int m = j / k;
    int i = 0;
    if (i < k)
    {
      Object localObject2;
      if (paramInt == 0)
      {
        localObject2 = String.format("delete from %s where time in (select time from %s order by time limit %s)", new Object[] { paramString, paramString, Integer.valueOf(m) });
        localObject1 = String.format("SELECT * FROM %s WHERE time IN (SELECT time FROM %s ORDER BY time LIMIT %s)", new Object[] { paramString, paramString, Integer.valueOf(m) });
      }
      for (;;)
      {
        long l = System.currentTimeMillis();
        if (localEntityTransaction != null) {}
        try
        {
          localEntityTransaction.begin();
          localObject1 = localaybg.a((String)localObject1, null, this.app);
          if (localObject1 == null) {}
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            label223:
            localObject1 = null;
            localException1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.QQMessageFacade", 2, "checkRecordCount " + localException1);
            }
            Object localObject3 = localObject1;
            if (localEntityTransaction != null)
            {
              localEntityTransaction.end();
              localObject3 = localObject1;
            }
          }
        }
        finally
        {
          if (localEntityTransaction != null) {
            localEntityTransaction.end();
          }
        }
        try
        {
          writeSynchronousLogTable(localaybg, (List)localObject1);
          localSQLiteDatabase.execSQL((String)localObject2);
          if (localEntityTransaction != null) {
            localEntityTransaction.commit();
          }
          if (localEntityTransaction == null) {
            break label577;
          }
          localEntityTransaction.end();
          localObject2 = localObject1;
        }
        catch (Exception localException2)
        {
          break label494;
          Object localObject4 = localObject1;
          break label223;
        }
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = (aybz)this.app.getManager(201);
          if (localObject1 != null) {
            ((aybz)localObject1).a(paramString, (List)localObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "transfer " + paramString + " " + m + "|" + i + "|" + j + " rows cost " + (System.currentTimeMillis() - l));
          }
        }
        i += 1;
        break;
        if ((paramInt == 1) || (paramInt == 3000) || (paramInt == 1026))
        {
          localObject2 = String.format("delete from %s where shmsgseq in (select shmsgseq from %s order by shmsgseq limit %s)", new Object[] { paramString, paramString, Integer.valueOf(m) });
          localObject1 = String.format("SELECT * FROM %s WHERE shmsgseq IN (SELECT shmsgseq FROM %s ORDER BY shmsgseq LIMIT %s)", new Object[] { paramString, paramString, Integer.valueOf(m) });
        }
        else
        {
          localObject2 = String.format("delete from %s where _id in (select _id from %s order by _id limit %s)", new Object[] { paramString, paramString, Integer.valueOf(m) });
          localObject1 = String.format("SELECT * FROM %s WHERE _id IN (SELECT _id FROM %s ORDER BY _id LIMIT %s)", new Object[] { paramString, paramString, Integer.valueOf(m) });
        }
      }
    }
    label494:
    localaybg.close();
  }
  
  public void cleanAllConfessHistory()
  {
    List localList = this.app.getMessageProxy(1032).a(AppConstants.CONFESS_UIN, 1032);
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
        clearHistory(localMessageRecord.senderuin, j, true, true);
      }
    }
    apse.b(this.app, true);
    apse.a(this.app, true);
  }
  
  public void clearAllHistory()
  {
    Object localObject1 = new RecentUser().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.app.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    localObject1 = localSQLiteDatabase.query((String)localObject1, new String[] { "uin", "type" }, null, null, null, null);
    if (localObject1 != null) {}
    try
    {
      ((Cursor)localObject1).moveToFirst();
      int i = 0;
      while (i < ((Cursor)localObject1).getCount())
      {
        clearHistory(((Cursor)localObject1).getString(0), ((Cursor)localObject1).getInt(1), false, true);
        ((Cursor)localObject1).moveToNext();
        i += 1;
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      cleanAllConfessHistory();
      getMsgProxy(0).e();
      getMsgProxy(0).d();
      getMsgProxy(3000).e();
      getMsgProxy(3000).d();
      getMsgProxy(1).e();
      getMsgProxy(1).d();
      if ((anux.a) && (bgbo.a(this.app)))
      {
        this.app.getFTSDBManager().a().g();
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
  
  public void clearDraftText(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() < 5)) {}
    while ((this.mDraftManager == null) || (paramString == null) || (paramString.length() < 5)) {
      return;
    }
    this.mDraftManager.a(this.app, paramString, paramInt);
  }
  
  public int clearHistory(String paramString, int paramInt)
  {
    return clearHistory(paramString, paramInt, true, true);
  }
  
  public int clearHistory(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return getBaseMessageManager(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void clearMessageCache()
  {
    this.app.getConversationFacade().a(false, true);
  }
  
  public void clearRecentUserList()
  {
    anuz localanuz = this.app.getProxyManager().a();
    Object localObject = new RecentUser().getTableName();
    String str1 = new TroopAssistantData().getTableName();
    String str2 = new PubAccountAssistantData().getTableName();
    String str3 = new TroopBarData().getTableName();
    String str4 = new NeedHandleUserData().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.app.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.delete((String)localObject, null, null);
    localSQLiteDatabase.delete(str1, null, null);
    localSQLiteDatabase.delete(str2, null, null);
    localSQLiteDatabase.delete(str4, null, null);
    localSQLiteDatabase.delete(str3, null, null);
    this.app.clearGroupSystemMsg();
    bcsz.a().a(this.app, 0);
    localObject = (amzp)this.app.getManager(22);
    if (localObject != null)
    {
      ((amzp)localObject).c();
      ((amzp)localObject).a(1);
    }
    avnu.a().a(this.app, true);
    clearUnreadMessages();
    localanuz.clearRecentUser();
  }
  
  public void clearRecommendTroopMsgByMsgType(int paramInt)
  {
    Object localObject = this.app.getMessageProxy(4001).b(String.valueOf(AppConstants.RECOMMEND_TROOP_UIN), 4001);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      return;
      this.app.getMessageFacade().setRecommendTroopMsgReaded(paramInt);
    } while (getMsgProxy(4001).a(paramInt) <= 0);
    setChanged();
    localObject = new RecentUser();
    ((RecentUser)localObject).uin = String.valueOf(AppConstants.TROOP_NOTIFICATION_UIN);
    notifyObservers(localObject);
  }
  
  public void clearTransFileInfo(String paramString)
  {
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    paramString = (ArrayList)localEntityManager.query(TransFileInfo.class, false, "friendUin = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        localEntityManager.remove((TransFileInfo)paramString.next());
      }
    }
    localEntityManager.close();
  }
  
  public void clearUnreadMessages()
  {
    this.app.getConversationFacade().a(true, true);
  }
  
  public void decodeMsg(QQMessageFacade.Message paramMessage)
  {
    try
    {
      getBaseMessageManager(paramMessage.istroop).a(paramMessage);
      return;
    }
    catch (Throwable paramMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.QQMessageFacade", 2, "decodeMsg ERROR", paramMessage);
    }
  }
  
  public MessageRecord deleteSingleMsgFromPoolByUniseq(String paramString, int paramInt, long paramLong)
  {
    return getMsgProxy(paramInt).g(paramString, paramInt, paramLong);
  }
  
  public void destroyChatActivity()
  {
    getMsgProxy(0).c();
    getMsgProxy(3000).c();
    getMsgProxy(1).c();
    getMsgProxy(1026).c();
  }
  
  public void destroyChatActivity(int paramInt, String paramString)
  {
    if (((bahm)this.app.getManager(326)).a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "orderMediaMsgSending in chat:" + paramString);
      }
      return;
    }
    getMsgProxy(paramInt).a(paramInt, paramString);
  }
  
  public void dumpmsgs(String paramString, Collection<MessageRecord> paramCollection)
  {
    if (paramCollection != null)
    {
      qLogColor("------------" + paramString + "--------------" + paramCollection.size(), "");
      return;
    }
    qLogColor("------------" + paramString + "-------------- is null", "");
  }
  
  protected boolean filterUnreadMsgsNum(ConversationInfo paramConversationInfo)
  {
    if ((paramConversationInfo == null) || (paramConversationInfo.uin == null)) {}
    while ((AppConstants.TROOP_NOTIFICATION_UIN.equals(paramConversationInfo.uin)) || (isOpenDoNotDisturb(paramConversationInfo)) || (isHiddenChat(paramConversationInfo)) || (TextUtils.equals(AppConstants.NEW_KANDIAN_UIN, paramConversationInfo.uin)) || (TextUtils.equals(AppConstants.LBS_HELLO_UIN, paramConversationInfo.uin)) || (TextUtils.equals(AppConstants.KANDIAN_MERGE_UIN, paramConversationInfo.uin)) || ((paramConversationInfo.type == 1008) && (isBelongServiceAccountFolder(paramConversationInfo))) || (paramConversationInfo.type == 1033) || (paramConversationInfo.type == 1034) || (paramConversationInfo.type == 1037) || (paramConversationInfo.type == 1044) || (paramConversationInfo.type == 1045) || (paramConversationInfo.type == 1036) || ((paramConversationInfo.type == 1038) && (!isShowInTabMessage()))) {
      return true;
    }
    if (paramConversationInfo.type == 7000)
    {
      QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum subaccount info.uin=" + paramConversationInfo.uin + "  info.type=" + paramConversationInfo.type);
      return true;
    }
    Object localObject;
    if (paramConversationInfo.type == 1038)
    {
      localObject = (RecentUser)this.app.getProxyManager().a().findRecentUser(paramConversationInfo.uin, paramConversationInfo.type);
      QQMessageFacade.Message localMessage = getLastMessage(paramConversationInfo.uin, paramConversationInfo.type);
      if (((akhg)this.app.getManager(315)).a(localMessage, (RecentUser)localObject) != 1) {
        break label383;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum appletsaccount info.uin=" + paramConversationInfo.uin + "  info.type=" + paramConversationInfo.type);
      }
    }
    label383:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (paramConversationInfo.type == 10007) {
        break;
      }
      localObject = new boolean[1];
      if (dispatchFilterUnreadMsgNum(paramConversationInfo, (boolean[])localObject)) {
        return localObject[0];
      }
      return false;
    }
  }
  
  public MessageRecord findLongMsgHead(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.longMsgIndex == 0) {}
    List localList;
    do
    {
      return paramMessageRecord;
      localList = getMsgProxy(paramMessageRecord.istroop).b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    } while ((localList == null) || (localList.isEmpty()));
    int i = localList.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      if (abwz.a(localMessageRecord, paramMessageRecord))
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
  
  public boolean getAIOBreak(String paramString, int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    List localList = getMsgList(paramString, paramInt);
    if ((localList == null) || (localList.isEmpty()))
    {
      bool1 = false;
      return bool1;
    }
    if (localList.size() == 1)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(0);
      if ((localMessageRecord.msgtype == -2006) || (!localMessageRecord.isValid)) {
        return false;
      }
      if (localMessageRecord.shmsgseq > Math.max(this.app.getMsgCache().c(paramString), this.app.getMsgCache().a(paramString, paramInt)) + 1L) {}
      for (;;)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool2 + "; cacheList size = " + localList.size() + "; msgseq = " + localMessageRecord.shmsgseq + ", expiredSeq = " + this.app.getMsgCache().c(paramString) + ", delLastSeq = " + this.app.getMsgCache().a(paramString, paramInt));
        return bool2;
        bool2 = false;
      }
    }
    if (localList.size() > 1)
    {
      paramString = (MessageRecord)localList.get(localList.size() - 1);
      if ((paramString.msgtype == -2006) || (!paramString.isValid)) {
        return false;
      }
      paramString = abwz.a(localList, false);
      if (paramString.size() < 10) {}
      for (bool2 = bool1;; bool2 = false)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool2 + "; cacheList size = " + localList.size() + "; continuedList size = " + paramString.size());
        return bool2;
      }
    }
    return false;
  }
  
  public List<ChatMessage> getAIOList(String paramString, int paramInt)
  {
    return getAIOList(paramString, paramInt, -1L);
  }
  
  public List<ChatMessage> getAIOList(String paramString, int paramInt, long paramLong)
  {
    return getAIOList(paramString, paramInt, paramLong, false);
  }
  
  public List<ChatMessage> getAIOList(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    List localList = getBaseMessageManager(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramBoolean);
    dispatchGetAioList(paramString, paramInt1, paramLong, paramInt2, paramBoolean, localList);
    return localList;
  }
  
  public List<ChatMessage> getAIOList(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    return getAIOList(paramString, paramInt, paramLong, 0, paramBoolean);
  }
  
  public List<ChatMessage> getAIOList(String paramString, int paramInt, boolean paramBoolean)
  {
    return getAIOList(paramString, paramInt, -1L, paramBoolean);
  }
  
  public List<MessageRecord> getAllMessages(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    return getMsgProxy(paramInt).a(paramString, paramInt, 5000, paramArrayOfInt);
  }
  
  public List<MessageRecord> getAllMessages(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return getMsgProxy(paramInt1).a(paramString, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public List<RecentBaseData> getAllMsgTableData()
  {
    ArrayList localArrayList = null;
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    Object localObject3 = localEntityManager.rawQuery(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    Object localObject1 = localArrayList;
    Object localObject2;
    HashMap localHashMap;
    Object localObject4;
    int i;
    String str;
    boolean bool;
    if (localObject3 != null)
    {
      localObject1 = localArrayList;
      if (((List)localObject3).size() > 0)
      {
        localObject2 = this.app.getProxyManager().a().getRecentList(true);
        localHashMap = new HashMap();
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Sqlite)((Iterator)localObject3).next();
            localObject1 = SecurityUtile.decode(((Sqlite)localObject4).tbl_name);
            ((Sqlite)localObject4).tbl_name = ((String)localObject1);
            if (((String)localObject1).endsWith("_New"))
            {
              i = abwz.a((String)localObject1);
              localObject4 = this.app.getMessageProxy(i).a((String)localObject1, localEntityManager);
              if ((localObject4 != null) && (((QQMessageFacade.Message)localObject4).frienduin != null))
              {
                str = ((QQMessageFacade.Message)localObject4).frienduin;
                if (((String)localObject1).startsWith("mr_friend_"))
                {
                  localObject1 = ContactUtils.getBuddyName(this.app, str, false);
                  bool = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      putFriendTroopDiscussionMsgUserDataIntoMap(localHashMap, bool, i, (QQMessageFacade.Message)localObject4, str, (String)localObject1);
      break;
      if (((String)localObject1).startsWith("mr_troop_"))
      {
        localObject1 = ContactUtils.getTroopName(this.app, str, false);
        i = 1;
        bool = true;
      }
      else if (((String)localObject1).startsWith("mr_discusssion_"))
      {
        localObject1 = ContactUtils.getDiscussionNameDefaultUin(this.app, str);
        i = 3000;
        bool = true;
        continue;
        localObject1 = localArrayList;
        if (localHashMap.size() > 0)
        {
          localArrayList = new ArrayList();
          getBackupMsgUserDataList(localArrayList, (List)localObject2, localHashMap);
          localObject2 = localHashMap.keySet().iterator();
          label443:
          for (;;)
          {
            localObject1 = localArrayList;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = (MsgBackupMsgUserData)localHashMap.get((String)((Iterator)localObject2).next());
            if ((((MsgBackupMsgUserData)localObject1).uinType == 0) || (((MsgBackupMsgUserData)localObject1).uinType == 1) || (((MsgBackupMsgUserData)localObject1).uinType == 3000) || (((MsgBackupMsgUserData)localObject1).uinType == 1000) || (((MsgBackupMsgUserData)localObject1).uinType == 1004) || (((MsgBackupMsgUserData)localObject1).uinType == 10010)) {}
            for (i = 1;; i = 0)
            {
              if ((i == 0) || (localArrayList.contains(localObject1)) || (Long.parseLong(((MsgBackupMsgUserData)localObject1).uin) <= 10000L)) {
                break label443;
              }
              localArrayList.add(localObject1);
              break;
            }
          }
        }
        return localObject1;
      }
      else
      {
        localObject1 = null;
        bool = false;
      }
    }
  }
  
  public List<ChatMessage> getAndParseAIOList(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (AIO_LOCK)
    {
      paramString = getAIOList(paramString, paramInt1);
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
  
  public List<ChatMessage> getAndParseAIOList(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (AIO_LOCK)
    {
      paramString = getAIOList(paramString, paramInt1, -1L, paramInt2, false);
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
  
  public QQAppInterface getApp()
  {
    return this.app;
  }
  
  public BaseMessageManager getBaseMessageManager(int paramInt)
  {
    synchronized (this.managerLock)
    {
      BaseMessageManager localBaseMessageManager2 = (BaseMessageManager)this.mManagers.get(paramInt);
      BaseMessageManager localBaseMessageManager1 = localBaseMessageManager2;
      if (localBaseMessageManager2 == null)
      {
        localBaseMessageManager1 = createMessageManagerLocked(paramInt);
        this.mManagers.put(paramInt, localBaseMessageManager1);
      }
      return localBaseMessageManager1;
    }
  }
  
  public abwe getC2CMessageManager()
  {
    return (abwe)getBaseMessageManager(0);
  }
  
  public abwp getConversationFacade()
  {
    return this.app.getConversationFacade();
  }
  
  public List<ChatMessage> getCurChatMsgList()
  {
    return this.curChatMsgList;
  }
  
  public int getCurrChatType()
  {
    return this.currChatType;
  }
  
  public String getCurrChatUin()
  {
    return this.currChatUin;
  }
  
  public anla getDatalineMessageManager(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (String str = "dataline_manager_pc";; str = "dataline_manager_ipad") {
      return (anla)getMessageManager(str);
    }
  }
  
  public anlc getDiscMessageManager()
  {
    return (anlc)getBaseMessageManager(3000);
  }
  
  public DraftSummaryInfo getDraftSummaryInfo(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.mDraftManager != null)) {
      return this.mDraftManager.a(this.app, paramString, paramInt);
    }
    return null;
  }
  
  @Nullable
  protected QQMessageFacade.Message getFirstMessageFrom(long paramLong, List<MessageRecord> paramList)
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
        decodeMsg(paramList);
        return paramList;
      }
      i += 1;
    }
    return null;
  }
  
  public QQMessageFacade.Message getFirstUnreadMessage(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "getFirstUnreadMessage() called with: uin = [" + paramString + "], type = [" + paramInt + "]");
    }
    long l = this.app.getProxyManager().a().a(paramString, paramInt);
    Object localObject = getFirstMessageFrom(l, getMsgList(paramString, paramInt));
    if (localObject != null) {}
    QQMessageFacade.Message localMessage;
    do
    {
      return localObject;
      localMessage = getFirstMessageFrom(l, queryMessageByTimeOrSeq(paramString, paramInt, l, 3, String.format("time>=%d", new Object[] { Long.valueOf(l) })));
      localObject = localMessage;
    } while (localMessage != null);
    localObject = new QQMessageFacade.Message();
    ((QQMessageFacade.Message)localObject).frienduin = paramString;
    ((QQMessageFacade.Message)localObject).istroop = paramInt;
    return localObject;
  }
  
  public QQMessageFacade.Message getIncomingMsg()
  {
    return this.msgNotifyManager.a();
  }
  
  public long getLastC2CBubbleIDFromCache(String paramString1, String paramString2)
  {
    paramString1 = this.app.getMessageProxy(0).b(paramString1, 0);
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
  
  public long getLastC2CBubleID(String paramString)
  {
    Object localObject1 = this.app.getMessageProxy(0).b(paramString, 0);
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
        localObject2 = this.app.getMessageProxy(0).a(paramString, 0, 9223372036854775807L, 1, String.format("issend<>%d and issend<>%d", new Object[] { Integer.valueOf(1), Integer.valueOf(2) }));
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
  
  public String getLastC2CPicMsgPath(String paramString1, String paramString2, long paramLong)
  {
    int j = 0;
    List localList = this.app.getMessageProxy(0).a(paramString1, 0, false, false);
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
  
  public long getLastC2CReadMsgTime(String paramString, int paramInt)
  {
    List localList = getMsgProxy(paramInt).b(paramString, paramInt);
    if ((localList == null) || (localList.isEmpty())) {
      return bbko.a();
    }
    if ((isChatting()) && (getCurrChatUin().equals(paramString)) && (getCurrChatType() == paramInt)) {
      return ((MessageRecord)localList.get(localList.size() - 1)).time;
    }
    paramInt = localList.size() - 1;
    while (paramInt >= 0)
    {
      if (((MessageRecord)localList.get(paramInt)).isread) {
        return ((MessageRecord)localList.get(paramInt)).time;
      }
      paramInt -= 1;
    }
    return Math.max(((MessageRecord)localList.get(0)).time - 1L, 0L);
  }
  
  public QQMessageFacade.Message getLastMessage(String paramString, int paramInt)
  {
    return getLastMessage(paramString, paramInt, false);
  }
  
  public QQMessageFacade.Message getLastMessage(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1033) || (paramInt1 == 1034)) {}
    for (int i = 1; i != 0; i = 0) {
      return getLastMessage_confess(paramString, paramInt1, paramInt2);
    }
    return getLastMessage(paramString, paramInt1);
  }
  
  public QQMessageFacade.Message getLastMessage(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null)
    {
      paramString = new QQMessageFacade.Message();
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder("Case:");
    String str1 = getKey(paramString, paramInt);
    QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.cachedMsg.get(str1);
    Object localObject1;
    if (localMessage != null)
    {
      localObject1 = localMessage;
      if (localMessage.isCacheValid) {}
    }
    else
    {
      if (this.isLastmsgCacheLazyLoad != 0) {
        break label206;
      }
      localObject1 = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject1).frienduin = paramString;
      ((QQMessageFacade.Message)localObject1).istroop = paramInt;
      this.cachedMsg.put(str1, localObject1);
      localStringBuilder.append("All-In");
    }
    for (;;)
    {
      if ((localObject1 != null) && (abwz.b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop))) {
        ((QQMessageFacade.Message)localObject1).istroop = abwz.a(((QQMessageFacade.Message)localObject1).istroop);
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
      if (!this.isLastMsgCacheLoaded)
      {
        localObject1 = localMessage;
        if (localMessage == null)
        {
          if ((!akmb.a(this.app)) || ((!paramBoolean) && (Looper.getMainLooper() == Looper.myLooper()))) {
            break label369;
          }
          localObject2 = MessageRecord.getTableName(paramString, paramInt);
          localObject1 = this.app.getEntityManagerFactory().createEntityManager();
          if (((EntityManager)localObject1).tabbleIsExist((String)localObject2))
          {
            localMessage = refreshSingleLastMsg(paramString, paramInt, (EntityManager)localObject1);
            localStringBuilder.append("Not-Finish-Yet，force Check DB");
          }
          ((EntityManager)localObject1).close();
          localObject1 = localMessage;
          if (localMessage == null)
          {
            localObject1 = new QQMessageFacade.Message();
            ((QQMessageFacade.Message)localObject1).frienduin = paramString;
            ((QQMessageFacade.Message)localObject1).istroop = paramInt;
            ((QQMessageFacade.Message)localObject1).isCacheValid = false;
            this.cachedMsg.put(str1, localObject1);
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
          this.cachedMsg.put(str1, localObject1);
        }
      }
      localObject1 = MessageRecord.getTableName(paramString, paramInt);
      String str2 = MessageRecord.getOldTableName(paramString, paramInt);
      Object localObject2 = this.app.getEntityManagerFactory().createEntityManager();
      if ((!((EntityManager)localObject2).tabbleIsExist((String)localObject1)) && (!((EntityManager)localObject2).tabbleIsExist(str2))) {
        break label530;
      }
      localMessage = refreshSingleLastMsg(paramString, paramInt, (EntityManager)localObject2);
      localStringBuilder.append("Check-DB");
      localObject1 = localMessage;
      if (localMessage == null)
      {
        localObject1 = new QQMessageFacade.Message();
        ((QQMessageFacade.Message)localObject1).frienduin = paramString;
        ((QQMessageFacade.Message)localObject1).istroop = paramInt;
        this.cachedMsg.put(str1, localObject1);
      }
      ((EntityManager)localObject2).close();
    }
    label530:
    if (localMessage == null)
    {
      localObject1 = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject1).frienduin = paramString;
      ((QQMessageFacade.Message)localObject1).istroop = paramInt;
      this.cachedMsg.put(str1, localObject1);
    }
    for (;;)
    {
      localStringBuilder.append("Not-In-TableCache");
      break;
      localMessage.isCacheValid = true;
      localObject1 = localMessage;
    }
  }
  
  public QQMessageFacade.Message getLastMessageLoadIfInexist(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    String str1 = getKey(paramString, paramInt);
    QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.cachedMsg.get(str1);
    Object localObject = localMessage;
    EntityManager localEntityManager;
    if (localMessage == null)
    {
      localObject = MessageRecord.getTableName(paramString, paramInt);
      String str2 = MessageRecord.getOldTableName(paramString, paramInt);
      localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      if ((!localEntityManager.tabbleIsExist((String)localObject)) && (!localEntityManager.tabbleIsExist(str2))) {
        break label135;
      }
      paramString = refreshSingleLastMsg(paramString, paramInt, localEntityManager);
    }
    for (;;)
    {
      localEntityManager.close();
      localObject = paramString;
      paramString = (String)localObject;
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
      if (!abwz.b(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop)) {
        break;
      }
      ((QQMessageFacade.Message)localObject).istroop = abwz.a(((QQMessageFacade.Message)localObject).istroop);
      return localObject;
      label135:
      if (localMessage == null)
      {
        localObject = new QQMessageFacade.Message();
        ((QQMessageFacade.Message)localObject).frienduin = paramString;
        ((QQMessageFacade.Message)localObject).istroop = paramInt;
        this.cachedMsg.put(str1, localObject);
        paramString = (String)localObject;
      }
      else
      {
        localMessage.isCacheValid = true;
        paramString = localMessage;
      }
    }
  }
  
  public QQMessageFacade.Message getLastMessage_confess(String paramString, int paramInt1, int paramInt2)
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
        str = getKey(paramString, paramInt1);
        localMessage = (QQMessageFacade.Message)this.cachedMsg.get(str);
        if ((localMessage != null) && (localMessage.isCacheValid))
        {
          localObject = localMessage;
          if (localMessage.getConfessTopicId() == paramInt2) {}
        }
        else
        {
          localObject = MessageRecord.getTableName(paramString, paramInt1);
          EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
          if (!localEntityManager.tabbleIsExist((String)localObject)) {
            break;
          }
          localMessage = refreshSingleLastMsg(paramString, paramInt1, localEntityManager, paramInt2);
          localStringBuilder.append("Check-DB");
          localObject = localMessage;
          if (localMessage == null)
          {
            localObject = new QQMessageFacade.Message();
            ((QQMessageFacade.Message)localObject).frienduin = paramString;
            ((QQMessageFacade.Message)localObject).istroop = paramInt1;
            ((QQMessageFacade.Message)localObject).setConfessTopicId(paramInt2);
            this.cachedMsg.put(str, localObject);
          }
          localEntityManager.close();
        }
        paramString = (String)localObject;
      } while (localObject == null);
      paramString = (String)localObject;
    } while (!abwz.b(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop));
    ((QQMessageFacade.Message)localObject).istroop = abwz.a(((QQMessageFacade.Message)localObject).istroop);
    return localObject;
    if (localMessage == null)
    {
      localObject = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject).frienduin = paramString;
      ((QQMessageFacade.Message)localObject).istroop = paramInt1;
      ((QQMessageFacade.Message)localObject).setConfessTopicId(paramInt2);
      this.cachedMsg.put(str, localObject);
    }
    for (;;)
    {
      localStringBuilder.append("Not-In-TableCache");
      break;
      localMessage.isCacheValid = true;
      localObject = localMessage;
    }
  }
  
  public MessageRecord getLastMsgForMsgTab(String paramString, int paramInt)
  {
    Object localObject1 = getMsgProxy(paramInt).c(paramString, paramInt);
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size() - 1;
      if (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ((((MessageRecord)localObject2).isValid) && (!abwz.h(((MessageRecord)localObject2).msgtype)))
        {
          localObject1 = localObject2;
          if (!((MessageRecord)localObject2).isLongMsg()) {}
        }
      }
    }
    for (localObject1 = findLongMsgHead((MessageRecord)localObject2);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        return localObject1;
        i -= 1;
        break;
      }
      QQMessageFacade.Message localMessage = getLastMessage(paramString, paramInt);
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
      for (localObject2 = localMessage.lastMsg;; localObject2 = parseMessageRecordForMessage(localMessage))
      {
        localMessage.lastMsg = ((MessageRecord)localObject2);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        return getMsgProxy(paramInt).b(paramString, paramInt, null);
      }
    }
  }
  
  public MessageRecord getLastMsgForMsgTabWithAutoInit(String paramString, int paramInt)
  {
    Object localObject1 = getMsgProxy(paramInt).b(paramString, paramInt);
    if (localObject1 != null)
    {
      int i = ((List)localObject1).size() - 1;
      Object localObject2;
      if (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ((((MessageRecord)localObject2).isValid) && (!abwz.h(((MessageRecord)localObject2).msgtype)))
        {
          localObject1 = localObject2;
          if (!((MessageRecord)localObject2).isLongMsg()) {}
        }
      }
      for (localObject1 = findLongMsgHead((MessageRecord)localObject2);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = getMsgProxy(paramInt).b(paramString, paramInt, null);
        }
        return localObject2;
        i -= 1;
        break;
      }
    }
    return null;
  }
  
  public anlk getMessageManager(String paramString)
  {
    if (this.managerMap == null) {
      return null;
    }
    if (!this.managerMap.containsKey(paramString)) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.managerMap)
      {
        if (this.managerMap.containsKey(paramString)) {
          break label114;
        }
        if ("dataline_manager_pc".equals(paramString))
        {
          localObject = new anlb(this.app, this);
          if (localObject != null) {
            break label102;
          }
          return null;
        }
      }
      if ("dataline_manager_ipad".equals(paramString))
      {
        localObject = new ankz(this.app, this);
        continue;
        label102:
        this.managerMap.put(paramString, localObject);
        label114:
        return (anlk)this.managerMap.get(paramString);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public MessageRecord getMessageRecord(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return getMsgProxy(paramInt1).a(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> getMessageRecords(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return getMsgProxy(paramInt1).c(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> getMessages(String paramString, int paramInt1, int paramInt2)
  {
    return getMsgProxy(paramInt1).a(paramString, paramInt1, paramInt2, null);
  }
  
  public List<MessageRecord> getMessagesFromDB(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int[] paramArrayOfInt, int paramInt3)
  {
    return getMsgProxy(paramInt1).a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramArrayOfInt);
  }
  
  public int getMiniUnreadMsgsNum()
  {
    int i = getUnreadMsgsNum(10);
    if (QLog.isColorLevel()) {
      QLog.d("MiniUnreadMsgsNum", 2, "unread count = " + i);
    }
    return i;
  }
  
  public MessageRecord getMsgItemByUniseq(String paramString, int paramInt, long paramLong)
  {
    return getMsgProxy(paramInt).a(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> getMsgList(String paramString, int paramInt)
  {
    return getMsgProxy(paramInt).b(paramString, paramInt);
  }
  
  public String getMsgNickName(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramContext = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(paramContext, paramMessageRecord);
    paramContext.emoRecentMsg = null;
    paramContext.fileType = -1;
    decodeMsg(paramContext);
    return bfwr.a(paramContext.nickName, 0.4F);
  }
  
  public String getMsgSummary(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    decodeMsg(localMessage);
    paramMessageRecord = new MsgSummary();
    bfwr.a(paramContext, this.app, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
    return paramMessageRecord.parseMsg(paramContext).toString();
  }
  
  public MsgSummary getMsgSummaryForTroop(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    for (;;)
    {
      try
      {
        if (!(getBaseMessageManager(localMessage.istroop) instanceof becw)) {
          continue;
        }
        if (!TextUtils.isEmpty(ContactUtils.getTroopMemberNameInUI(this.app, localMessage.frienduin, localMessage.senderuin))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "getMsgSummaryStrForTroop nickname is null");
        }
        localMessage.isFromLS = true;
        decodeMsg(localMessage);
        localMessage.isFromLS = false;
        ThreadManager.getSubThreadHandler().post(new QQLSActivity.SyncTroopSummaryTask(this.app, ((QQLSActivity)paramContext).a, localMessage.senderuin, localMessage.frienduin));
      }
      catch (Throwable paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        continue;
        decodeMsg(localMessage);
        continue;
      }
      paramMessageRecord = new MsgSummary();
      bfwr.a(paramContext, this.app, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
      return paramMessageRecord;
      decodeMsg(localMessage);
    }
  }
  
  public String getMsgSummaryStrForTroop(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return getMsgSummaryForTroop(paramContext, paramMessageRecord, paramBoolean).parseMsg(paramContext).toString();
  }
  
  public String getMsgSummary_confess(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    decodeMsg(localMessage);
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info");
    ConfessInfo localConfessInfo = new ConfessInfo();
    localConfessInfo.parseFromJsonStr((String)localObject);
    paramMessageRecord = apse.a(this.app, localConfessInfo, paramMessageRecord.senderuin);
    localObject = new MsgSummary();
    bfwr.a(paramContext, this.app, localMessage, localMessage.istroop, (MsgSummary)localObject, paramMessageRecord, false, paramBoolean);
    return ((MsgSummary)localObject).parseMsg(paramContext).toString();
  }
  
  public int getQuickDBMsgCount(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    if (localSQLiteDatabase != null)
    {
      i = j;
      if (paramBoolean) {
        i = -1000;
      }
      i = localSQLiteDatabase.getCount(paramString, paramLong1, paramLong2, i, -1000);
    }
    return i;
  }
  
  public List<MessageRecord> getQuickDbMessage(String paramString1, String paramString2)
  {
    localObject = null;
    str = null;
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    localArrayList = new ArrayList();
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createMessageRecordEntityManager();
    try
    {
      paramString1 = localSQLiteDatabase.rawQuery(paramString1, paramString2, null, null);
      str = paramString1;
      localObject = paramString1;
      paramString2 = localEntityManager.cursor2List(MessageRecord.class, paramString2, paramString1);
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
        break label137;
      }
      ((Cursor)localObject).close();
    }
    return localArrayList;
  }
  
  public long getReadConfirmStamp(String paramString, int paramInt)
  {
    long l2 = -1L;
    Object localObject;
    long l1;
    if ((paramInt == 1) || (paramInt == 3000) || (paramInt == 1026))
    {
      localObject = this.app.getMessageFacade().getLastMessage(paramString, paramInt);
      l2 = ((QQMessageFacade.Message)localObject).shmsgseq;
      l1 = l2;
      if (((QQMessageFacade.Message)localObject).isLongMsg())
      {
        paramString = this.app.getMessageFacade().getMsgList(paramString, paramInt);
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
      if (abwz.d(paramInt))
      {
        paramString = this.app.getMessageProxy(paramInt).b(paramString, paramInt);
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
              if (!bfwr.b(((MessageRecord)localObject).issend)) {
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
  
  public abxl getRegistry()
  {
    return this.mRegistry;
  }
  
  public MessageRecord getSendingTroopMsgItem(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    abwx localabwx = getMsgProxy(paramInt);
    if ((localabwx instanceof bdzk)) {
      return ((bdzk)localabwx).a(paramString, paramInt, paramMessageRecord);
    }
    return null;
  }
  
  public MessageRecord getSendingTroopMsgItem(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    abwx localabwx = getMsgProxy(paramInt);
    if ((localabwx instanceof bdzk)) {
      return ((bdzk)localabwx).a(paramString, paramInt, paramMessageRecord, paramList);
    }
    return null;
  }
  
  public int getSingleConUnreadCount(int paramInt, String paramString)
  {
    abwp localabwp = this.app.getConversationFacade();
    if (localabwp != null) {
      return localabwp.a(paramString, paramInt);
    }
    return 0;
  }
  
  public int getSlowDBMsgCount(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    Object localObject = this.app.getCurrentUin();
    localObject = new ayby((String)localObject).build((String)localObject).getReadableDatabase();
    if (localObject != null)
    {
      i = j;
      if (paramBoolean) {
        i = -1000;
      }
      i = ((SQLiteDatabase)localObject).getCount(paramString, paramLong1, paramLong2, i, -1000);
      ((SQLiteDatabase)localObject).close();
    }
    return i;
  }
  
  public List<MessageRecord> getSlowDbMessage(String paramString1, String paramString2)
  {
    localObject1 = null;
    str = null;
    Object localObject2 = this.app.getCurrentUin();
    localArrayList = new ArrayList();
    ayby localayby = new ayby((String)localObject2);
    EntityManager localEntityManager = localayby.createMessageRecordEntityManager();
    localObject2 = localayby.build((String)localObject2).getWritableDatabase();
    try
    {
      paramString1 = ((SQLiteDatabase)localObject2).rawQuery(paramString1, paramString2, null, null);
      str = paramString1;
      localObject1 = paramString1;
      paramString2 = localEntityManager.cursor2List(MessageRecord.class, paramString2, paramString1);
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
        break label155;
      }
      ((Cursor)localObject1).close();
    }
    return localArrayList;
  }
  
  public String getSqlStr(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean)
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
  
  public ConcurrentHashMap<String, Integer> getTableToCheck()
  {
    return this.tableToCheck;
  }
  
  public becw getTroopMessageManager()
  {
    return (becw)getBaseMessageManager(1);
  }
  
  public int getUnreadMsgsNum()
  {
    Object localObject1 = new StringBuilder(168);
    int j = getUnreadMsgsNum(2);
    if (j != 0) {
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j) }));
    }
    int i = j;
    int k;
    if (getConversationFacade().b(AppConstants.TROOP_NOTIFICATION_UIN, 9000))
    {
      k = aiku.a(this.app);
      if ((k != 0) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.QQMessageFacade", 2, "Recent TroopNotification Unread=" + k);
      }
      i = j + k;
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.TROOP_NOTIFICATION_UIN, Integer.valueOf(9000), Integer.valueOf(k) }));
    }
    j = i;
    Object localObject2;
    if (getConversationFacade().b(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230))
    {
      j = uaw.a().b();
      i += j;
      localObject2 = this.app.getManager(36);
      if (!(localObject2 instanceof azvi)) {
        break label792;
      }
      k = ((azvi)localObject2).a("104000.104001", 100);
      if (k <= 0) {
        break label792;
      }
      i = k + i;
    }
    label787:
    label792:
    for (;;)
    {
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, Integer.valueOf(7230), Integer.valueOf(j) }));
      j = i;
      i = j;
      if (bcvs.a(this.app))
      {
        i = j;
        if (getConversationFacade().b(AppConstants.TENCENT_DOCS_ASSISTANT_UIN, 6004))
        {
          localObject2 = ((nmq)this.app.getManager(70)).a(46, false);
          if ((localObject2 == null) || (!((oidb_0x791.RedDotInfo)localObject2).uint32_number.has()) || (!((oidb_0x791.RedDotInfo)localObject2).bool_display_reddot.get())) {
            break label787;
          }
        }
      }
      for (i = ((oidb_0x791.RedDotInfo)localObject2).uint32_number.get();; i = 0)
      {
        j += i;
        ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.TENCENT_DOCS_ASSISTANT_UIN, Integer.valueOf(6004), Integer.valueOf(i) }));
        i = j;
        j = i;
        if (getConversationFacade().b(AppConstants.SEND_BLESS_UIN, 9003))
        {
          localObject2 = (ahux)this.app.getManager(138);
          j = i;
          if (localObject2 != null)
          {
            k = ((ahux)localObject2).b();
            j = i + k;
            ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.SEND_BLESS_UIN, Integer.valueOf(9003), Integer.valueOf(k) }));
          }
        }
        i = j;
        if (getConversationFacade().b(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000))
        {
          k = bcqk.a(this.app, getConversationFacade());
          i = j + k;
          ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, Integer.valueOf(7000), Integer.valueOf(k) }));
        }
        j = i;
        if (atyd.a())
        {
          k = ((atyd)this.app.getManager(358)).c();
          j = i + k;
          ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { "2747277822", Integer.valueOf(10007), Integer.valueOf(k) }));
        }
        i = j;
        if (apyt.a("MiniAppEcShopNumMsgEnable", 1) == 1)
        {
          i = j;
          if (getConversationFacade().b(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120))
          {
            k = ((ofx)this.app.getManager(88)).a(this.app);
            i = j + k;
            ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, Integer.valueOf(7120), Integer.valueOf(k) }));
          }
        }
        j = dispatchGetUnreadMsgNum((StringBuilder)localObject1);
        localObject1 = ((StringBuilder)localObject1).toString();
        if (!((String)localObject1).equals(this.lastUnreadLog))
        {
          QLog.d("Q.msg.QQMessageFacade_UnreadMonitor", 1, "Recent Msg Unread: " + (String)localObject1);
          this.lastUnreadLog = ((String)localObject1);
        }
        return j + i;
      }
    }
  }
  
  public int getUnreadMsgsNumForPublicAccount()
  {
    return getUnreadMsgsNum(9);
  }
  
  public int getUnreadMsgsNumForSameState()
  {
    return getUnreadMsgsNum(7);
  }
  
  public void handleFaceScoreGrayMsg(List<MessageRecord> paramList)
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
          abwz.a(paramList, false);
          Object localObject = (NearbyGrayTipsManager)this.app.getManager(93);
          if (QLog.isColorLevel()) {
            QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner will insert a face score message, msg = " + paramList);
          }
          boolean bool2 = awhm.a(paramList, "isFaceScoreSecondMember");
          localObject = ((NearbyGrayTipsManager)localObject).b(1, 2, localMessageRecord.time);
          if (QLog.isColorLevel()) {
            QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner  getValidConfigForFaceScore, flag = " + bool2 + ", configForFaceScore = " + localObject);
          }
          if (localObject != null)
          {
            int i = bckb.a(paramList.structingMsg.mExtraData);
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
              localObject = bbli.a(-2027);
              ((MessageRecord)localObject).init(localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.selfuin, paramList, localMessageRecord.time - 1L, -2027, 1001, localMessageRecord.time - 1L);
              ((MessageRecord)localObject).isread = true;
              awhm.a((MessageRecord)localObject, "isFaceScoreGrayTips", true);
              awhm.a((MessageRecord)localObject, "isFaceScoreSecondMember", bool2);
              awhm.a((MessageRecord)localObject, "isFaceScoreSpecialLike", bool1);
              abwz.a((MessageRecord)localObject, false);
              addMessage((MessageRecord)localObject, localMessageRecord.selfuin);
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
  
  public void handleRefreshMessagelistHeadResult(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    getBaseMessageManager(paramInt).a(paramString, paramInt, paramList1, paramList2, paramBundle);
  }
  
  public void handleRevokeNotifyAfterSyncMsg()
  {
    ConcurrentHashMap localConcurrentHashMap = this.app.getMsgCache().f();
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
          if (((amrb)this.app.getManager(53)).a(((RevokeMsgInfo)localArrayList.get(0)).jdField_a_of_type_JavaLangString) == null) {}
        }
        else
        {
          String str1;
          do
          {
            do
            {
              handleRevokedNotifyAndNotify(localArrayList, true);
              break;
            } while (i != 0);
            RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)localArrayList.get(0);
            String str3 = this.app.getCurrentAccountUin();
            String str2 = localRevokeMsgInfo.b;
            str1 = str2;
            if (TextUtils.equals(str3, str2)) {
              str1 = localRevokeMsgInfo.jdField_a_of_type_JavaLangString;
            }
          } while (!((amsw)this.app.getManager(51)).e(str1));
        }
      }
    }
    localConcurrentHashMap.clear();
  }
  
  public void handleRevokedNotifyAndNotify(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    String str;
    int i;
    do
    {
      return;
      str = ((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_JavaLangString;
      i = ((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_Int;
      getBaseMessageManager(i).a(paramArrayList, paramBoolean);
      ((ajje)this.app.getBusinessHandler(147)).a(str, i, -1);
    } while ((!paramBoolean) || ((i != 1) && (i != 3000)));
    setReadFrom(str, i, this.app.getConversationFacade().a(str, i));
  }
  
  public boolean hasCurFrinedMsg(String paramString, int paramInt)
  {
    paramString = getKey(paramString, paramInt);
    if (this.cachedMsg.containsKey(paramString))
    {
      paramString = (QQMessageFacade.Message)this.cachedMsg.get(paramString);
      if ((paramString.time > 0L) && (paramString.senderuin != null)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean hasDraftText(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.mDraftManager != null)) {
      return this.mDraftManager.a(paramString, paramInt);
    }
    return false;
  }
  
  public void init()
  {
    ThreadManager.post(new QQMessageFacade.1(this), 10, null, false);
  }
  
  public void insertSingleMsgToPool(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    getMsgProxy(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  protected boolean isBelongServiceAccountFolder(ConversationInfo paramConversationInfo)
  {
    return uaw.b(this.app, paramConversationInfo.uin);
  }
  
  public boolean isChatting()
  {
    return (this.currChatUin != null) && (this.currChatType >= 0);
  }
  
  protected boolean isHiddenChat(ConversationInfo paramConversationInfo)
  {
    return afqy.a(paramConversationInfo.uin, paramConversationInfo.type, this.app);
  }
  
  protected boolean isOpenDoNotDisturb(ConversationInfo paramConversationInfo)
  {
    return FriendsStatusUtil.a(paramConversationInfo.uin, this.app);
  }
  
  public boolean isReplyed(String paramString, int paramInt)
  {
    paramString = MessageRecord.getTableName(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("select count() as counter, 'x' as msgData from ").append(paramString).append(" where issend=0 and isValid=1 and msgtype ").append(abwz.a());
    paramString = this.app.getEntityManagerFactory().createEntityManager().rawQuery(QQMessageFacade.Message.class, localStringBuilder.toString(), null);
    if ((paramString != null) && (paramString.size() > 0)) {
      return ((QQMessageFacade.Message)paramString.get(0)).counter > 0;
    }
    return false;
  }
  
  protected boolean isShowInTabMessage()
  {
    return akhg.a(false);
  }
  
  public boolean isTheLastTabMsg(MessageRecord paramMessageRecord)
  {
    QQMessageFacade.Message localMessage = getLastMessage(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (abwz.d(paramMessageRecord.istroop)) {
      if ((paramMessageRecord.msgUid != localMessage.msgUid) || (paramMessageRecord.shmsgseq != localMessage.shmsgseq)) {}
    }
    while (paramMessageRecord.shmsgseq == localMessage.shmsgseq)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void notifyDraftUpdated(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if (QLog.isColorLevel()) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      if (TextUtils.isEmpty(paramString3)) {
        paramLong = 0L;
      }
      for (;;)
      {
        getBaseMessageManager(paramInt).a(paramString1, paramInt, paramString2, paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.i("notification", 2, "notifyDraftUpdated| " + (System.currentTimeMillis() - l) + " drafttime = " + paramLong);
        }
        return;
      }
    }
  }
  
  public void notifyMessageObserver(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.app.getMsgHandler().notifyUI(8020, true, paramList);
    }
    atzd.a(paramList);
  }
  
  public void notifyObservers(Object paramObject)
  {
    long l = System.currentTimeMillis();
    super.notifyObservers(paramObject);
    paramObject = MsgAutoMonitorUtil.getInstance();
    if (paramObject != null)
    {
      paramObject.addMsgObserverTime(System.currentTimeMillis() - l);
      paramObject.addMsgObserverNotifyNum();
    }
  }
  
  public void onCurrentMessageDeleted(String paramString, int paramInt)
  {
    paramString = new QQMessageFacade.MessageNotifyParam(paramString, paramInt, 0, null);
    setChanged();
    notifyObservers(paramString);
  }
  
  public void onDestroy()
  {
    if (this.mDraftManager != null) {
      this.mDraftManager.a();
    }
    if (this.cachedMsg != null) {
      this.cachedMsg.clear();
    }
    if (this.refreshActionMap != null) {
      this.refreshActionMap.clear();
    }
    this.msgNotifyManager.a();
    this.isLastMsgCacheLoaded = false;
    deleteObservers();
  }
  
  public MessageRecord parseMessageRecordForMessage(QQMessageFacade.Message paramMessage)
  {
    MessageRecord localMessageRecord = bbli.a(paramMessage.msgtype, paramMessage.msgData, paramMessage.extLong, paramMessage.extStr, paramMessage.istroop);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessage);
    if ((localMessageRecord instanceof ChatMessage)) {
      ((ChatMessage)localMessageRecord).parse();
    }
    return localMessageRecord;
  }
  
  public void pauseChatActivity()
  {
    this.currChatUin = null;
    this.currChatType = -1;
    this.curChatMsgList = null;
  }
  
  public boolean pullRecentGroupMsg(String paramString)
  {
    return pullRecentGroupMsg(paramString, 0);
  }
  
  public boolean pullRecentGroupMsg(String paramString, int paramInt)
  {
    return pullRecentGroupMsg_PB(paramString, paramInt);
  }
  
  public boolean pullRecentGroupMsg_PB(String paramString, int paramInt)
  {
    if (this.app.mAutomator.c())
    {
      this.app.getMsgHandler().c(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  public void qLogColor(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, paramString1);
    }
  }
  
  public ChatHistorySearchData queryAllHistroyByKey(SessionInfo paramSessionInfo, String paramString)
  {
    return getMsgProxy(paramSessionInfo.curType).a(paramSessionInfo, paramString);
  }
  
  public List<MessageRecord> queryBeforeHistoryByShmsgseq(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return getMsgProxy(paramInt1).d(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public MessageRecord queryLastMsgForMessageTabFromDB(String paramString1, int paramInt, String paramString2)
  {
    return getMsgProxy(paramInt).b(paramString1, paramInt, paramString2);
  }
  
  public List<MessageRecord> queryLaterHistoryByShmsgseq(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return getMsgProxy(paramInt1).e(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> queryMessageByTimeOrSeq(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    return this.app.getMessageProxy(paramInt1).a(paramString1, paramInt1, paramLong, paramInt2, paramString2);
  }
  
  public MessageRecord queryMsgItemByFilePath(String paramString1, int paramInt, String paramString2)
  {
    return getMsgProxy(paramInt).a(paramString1, paramInt, paramString2);
  }
  
  public MessageRecord queryMsgItemByShmsgseq(String paramString, int paramInt, long paramLong)
  {
    return getMsgProxy(paramInt).c(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> queryMsgItemByShmsgseq(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return getMsgProxy(paramInt).a(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public MessageRecord queryMsgItemByShmsgseq4Troop(String paramString, int paramInt, long paramLong)
  {
    return getMsgProxy(paramInt).d(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> queryMsgItemByTime(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return getMsgProxy(paramInt).b(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public MessageRecord queryMsgItemByUniseq(String paramString, int paramInt, long paramLong)
  {
    return getMsgProxy(paramInt).b(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> queryMsgItemByUniseq(String paramString, int paramInt, List<Long> paramList)
  {
    return getMsgProxy(paramInt).a(paramString, paramInt, paramList);
  }
  
  public MessageRecord queryMsgItemHistoryByShmsgseq(String paramString, int paramInt, long paramLong)
  {
    return getMsgProxy(paramInt).j(paramString, paramInt, paramLong);
  }
  
  public ChatHistorySearchData queryMsgListByID(String paramString, int paramInt, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    ChatHistorySearchData localChatHistorySearchData = new ChatHistorySearchData();
    localChatHistorySearchData.mSearchData1 = getMsgProxy(paramInt).c(paramString, paramInt, paramList);
    return localChatHistorySearchData;
  }
  
  public int queryMsgRecordIndex(String paramString, int paramInt, long paramLong, MessageRecord paramMessageRecord)
  {
    return getMsgProxy(paramInt).a(paramString, paramInt, paramLong, paramMessageRecord);
  }
  
  public int queryMsgRecordIndex(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return getMsgProxy(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public void refreshAllMsgBox()
  {
    refreshMsgBox(AppConstants.SAME_STATE_BOX_UIN, 1009);
    refreshMsgBox(AppConstants.LBS_HELLO_UIN, 1001);
    refreshMsgBox(AppConstants.LBS_HELLO_UIN, 10002);
    refreshMsgBox(AppConstants.DATE_UIN, 1010);
    refreshMsgBox(AppConstants.MATCH_CHAT_UIN, 1044);
    refreshMsgBox(AppConstants.QCIRCLE_CHAT_UIN, 10008);
  }
  
  public void refreshCache()
  {
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    boolean bool;
    int i;
    if (this.isLastmsgCacheLazyLoad == -1)
    {
      bool = localEntityManager.tabbleIsExist(ConversationInfo.getConversationInfoTableName());
      if (bool)
      {
        i = 1;
        this.isLastmsgCacheLazyLoad = i;
      }
    }
    for (;;)
    {
      localEntityManager.close();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache start : Lazy : " + bool);
      }
      long l = System.currentTimeMillis();
      if (bool) {
        refreshRecentCache_Lazy(90, true);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache finish : TimeSpend:" + (System.currentTimeMillis() - l));
        }
        return;
        i = 0;
        break;
        refreshCache_allIn();
      }
      bool = true;
    }
  }
  
  public void refreshCache_allIn()
  {
    qLogColor("refreshCache", "");
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    Object localObject1 = localEntityManager.rawQuery(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    int j;
    if (localObject1 != null)
    {
      List localList = this.app.getProxyManager().a().getRecentList(true);
      boolean bool1 = localEntityManager.tabbleIsExist(ConversationInfo.getConversationInfoTableName());
      abwp localabwp = getConversationFacade();
      StringBuilder localStringBuilder = new StringBuilder(128);
      Iterator localIterator = ((List)localObject1).iterator();
      int i = 0;
      boolean bool2;
      Object localObject2;
      do
      {
        Sqlite localSqlite;
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
              localSqlite = (Sqlite)localIterator.next();
              localSqlite.tbl_name = SecurityUtile.decode(localSqlite.tbl_name);
            } while ((localSqlite.tbl_name.equals("mr_fileManager")) || (localSqlite.tbl_name.startsWith("mr_confess_a")) || (localSqlite.tbl_name.startsWith("mr_confess_b")));
            bool2 = localSqlite.tbl_name.endsWith("_New");
            localObject2 = getMsgProxy(abwz.a(localSqlite.tbl_name)).a(localSqlite.tbl_name, localEntityManager);
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.msg.QQMessageFacade", 4, "getMsgProxy().queryLastMessage = " + localObject2);
            }
          } while ((localObject2 == null) || (((QQMessageFacade.Message)localObject2).frienduin == null));
          localObject1 = localObject2;
          if (((QQMessageFacade.Message)localObject2).uniseq == 0L)
          {
            getMsgProxy(((QQMessageFacade.Message)localObject2).istroop).b(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
            localObject2 = getMsgProxy(((QQMessageFacade.Message)localObject2).istroop).a(localSqlite.tbl_name, localEntityManager);
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject2);
              localObject1 = localObject2;
            }
          }
          if (localObject1 == null) {
            break label651;
          }
        } while (((AppConstants.DATALINE_PC_UIN.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (!localSqlite.tbl_name.equals(DataLineMsgRecord.tableName()))) || ((AppConstants.DATALINE_IPAD_UIN.equals(((QQMessageFacade.Message)localObject1).frienduin)) && (!localSqlite.tbl_name.equals(DataLineMsgRecord.tableName(1)))));
        refreshTribeTempCache((QQMessageFacade.Message)localObject1);
        decodeMsg((QQMessageFacade.Message)localObject1);
        if (!bool1)
        {
          calculateMsgBoxUnreadCount((QQMessageFacade.Message)localObject1);
          if (localList != null) {
            refreshMsgBoxCache(localList, (QQMessageFacade.Message)localObject1);
          }
          localStringBuilder.setLength(0);
          localStringBuilder.append("refreshCache message uin = ").append(((QQMessageFacade.Message)localObject1).frienduin).append(", type = ").append(((QQMessageFacade.Message)localObject1).istroop).append(", unread = ").append(((QQMessageFacade.Message)localObject1).unReadNum).append(", time = ").append(((QQMessageFacade.Message)localObject1).time);
          qLogColor(localStringBuilder.toString(), "");
        }
        localObject2 = getKey(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
      } while ((!bool2) && (this.cachedMsg.containsKey(localObject2)));
      this.cachedMsg.put(localObject2, localObject1);
      j = i + 1;
      i = j;
      if (!bool1)
      {
        localabwp.c(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, ((QQMessageFacade.Message)localObject1).unReadNum);
        i = j;
      }
    }
    label651:
    for (;;)
    {
      break;
      j = 0;
      localEntityManager.close();
      MsgAutoMonitorUtil.getInstance().printKeyAndValue("MSG_TableNum", j + "");
      return;
    }
  }
  
  public void refreshMessageListHead(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    getBaseMessageManager(paramInt1).a(paramString, paramInt1, paramInt2, paramRefreshMessageContext);
  }
  
  public void refreshMessageListHeadByAIOBreak(String paramString, int paramInt, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    List localList = getAIOList(paramString, paramInt);
    if (localList == null) {}
    for (int i = 0;; i = localList.size())
    {
      i = 10 - i;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "refreshMessageListHeadByAIOBreak numTroopRefresh = " + paramRefreshMessageContext.numTroopRefresh + ", count = " + i);
      }
      if (i <= 0) {
        break;
      }
      paramRefreshMessageContext.numTroopRefresh = true;
      getBaseMessageManager(paramInt).a(paramString, paramInt, i, paramRefreshMessageContext);
      return;
    }
    paramRefreshMessageContext.needRefreshAIO = true;
    paramRefreshMessageContext.uin = paramString;
    paramRefreshMessageContext.uinType = paramInt;
    paramRefreshMessageContext.count = i;
    setChangeAndNotify(paramRefreshMessageContext);
  }
  
  public void refreshPubAccountAssistCache_Lazy(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.query(PubAccountAssistantData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)((Iterator)localObject).next();
        refreshSingleLastMsg(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType, paramEntityManager);
      }
    }
    localObject = paramEntityManager.query(TroopBarData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        refreshSingleLastMsg(((TroopBarData)((Iterator)localObject).next()).mUin, 1008, paramEntityManager);
      }
    }
  }
  
  public void refreshRecentCache_Lazy(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "refreshRecentCache_Lazy() called with: refreshTopN = [" + paramInt + "], isLoadGrpAssist = [" + paramBoolean + "]");
    }
    if ((paramInt == 0) && (this.isLastMsgCacheLoaded)) {
      return;
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    Object localObject = this.app.getProxyManager().a();
    int i;
    int k;
    int j;
    if (this.isLastmsgCacheLazyLoad == -1)
    {
      if (localEntityManager.tabbleIsExist(ConversationInfo.getConversationInfoTableName()))
      {
        i = 1;
        this.isLastmsgCacheLazyLoad = i;
      }
    }
    else
    {
      localObject = ((anuz)localObject).getRecentList(true);
      i = 0;
      k = i;
      if (localObject == null) {
        break label425;
      }
      k = i;
      if (((List)localObject).size() <= 0) {
        break label425;
      }
      i = ((List)localObject).size();
      if (paramInt <= 0) {
        break label482;
      }
      if (i <= paramInt) {
        break label366;
      }
      j = paramInt;
    }
    for (;;)
    {
      label161:
      int m = 0;
      label164:
      k = i;
      if (m < j)
      {
        long l = SystemClock.uptimeMillis();
        RecentUser localRecentUser = (RecentUser)((List)localObject).get(m);
        refreshSingleLastMsg(localRecentUser.uin, localRecentUser.getType(), localEntityManager);
        if (m == 10)
        {
          setChanged();
          notifyObservers(new RecentUser());
        }
        if (abwz.b(localRecentUser.uin, localRecentUser.getType()))
        {
          if (!AppConstants.LBS_HELLO_UIN.equals(localRecentUser.uin)) {
            break label372;
          }
          if (this.app.getConversationFacade().a(AppConstants.LBS_SAY_HELLO_LIST_UIN, localRecentUser.getType())) {
            refreshSingleLastMsg(AppConstants.LBS_SAY_HELLO_LIST_UIN, localRecentUser.getType(), localEntityManager);
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "refreshRecentCache_Lazy() i = [" + m + "], cost = [" + (SystemClock.uptimeMillis() - l) + "]ms");
          }
          m += 1;
          break label164;
          i = 0;
          break;
          label366:
          j = i;
          break label161;
          label372:
          if ((AppConstants.DATE_UIN.equals(localRecentUser.uin)) && (this.app.getConversationFacade().a(AppConstants.DATE_SAY_HELLO_LIST_UIN, localRecentUser.getType()))) {
            refreshSingleLastMsg(AppConstants.DATE_SAY_HELLO_LIST_UIN, localRecentUser.getType(), localEntityManager);
          }
        }
      }
      label425:
      if (paramBoolean) {
        refreshTroopAssistCache_Lazy(localEntityManager);
      }
      if ((paramBoolean) || (((List)localObject).size() > 10))
      {
        setChanged();
        notifyObservers(new RecentUser());
      }
      if ((paramInt != 0) && (paramInt < k)) {
        break;
      }
      this.isLastMsgCacheLoaded = true;
      return;
      label482:
      j = i;
    }
  }
  
  public void removeMsgByMessageRecord(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    getBaseMessageManager(paramMessageRecord.istroop).a(paramMessageRecord, true, paramBoolean);
  }
  
  public void removeMsgByUniseq(String paramString, int paramInt, long paramLong)
  {
    removeMsgByUniseq(paramString, paramInt, paramLong, true);
  }
  
  public void removeMsgByUniseq(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    MessageRecord localMessageRecord = queryMsgItemByUniseq(paramString, paramInt, paramLong);
    ((bgga)this.app.getManager(235)).a.b(localMessageRecord);
    if (getMsgProxy(paramInt).c(paramString, paramInt, paramLong) == 2) {
      this.app.getConversationFacade().a(paramString, paramInt, localMessageRecord);
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
        if (getConversationFacade().b(localMessageRecord.frienduin, localMessageRecord.istroop))
        {
          paramInt = 0;
          if ((localMessageRecord instanceof MessageForLongMsg)) {
            if (abwz.a(localMessageRecord, getLastMessage(localMessageRecord.frienduin, localMessageRecord.istroop))) {
              paramInt = 1;
            }
          }
          while (paramInt != 0)
          {
            if (!abwz.t(localMessageRecord.istroop)) {
              break label168;
            }
            getBaseMessageManager(localMessageRecord.istroop).a(localMessageRecord);
            return;
            if (isTheLastTabMsg(localMessageRecord)) {
              paramInt = 1;
            }
          }
        }
      }
      getBaseMessageManager(localMessageRecord.istroop).b(localMessageRecord);
      return;
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.QQMessageFacade", 2, "removeMsgByUniseq error: message not found. uin=" + paramString + ",type=" + paramInt + ",uniseq=" + paramLong);
  }
  
  public boolean removeMsgFromCacheByUniseq(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (abwz.o(paramInt2))
    {
      bool1 = bool2;
      if (abwz.h(paramInt2))
      {
        bool1 = bool2;
        if (getMsgProxy(paramInt1).e(paramString, paramInt1, paramLong) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void removeMsgFromMsgBox(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    getBaseMessageManager(paramInt).a(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void removeMsgFromMsgBox(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    getBaseMessageManager(paramInt1).a(paramString1, paramInt1, paramString2, paramString3, paramInt2, paramInt3, true);
  }
  
  public void removeMultiMsgByMessageRecord(List<? extends MessageRecord> paramList, boolean paramBoolean)
  {
    if (paramList.size() != 0) {
      getBaseMessageManager(((MessageRecord)paramList.get(0)).istroop).a(paramList, true, paramBoolean);
    }
  }
  
  public void removeRecentUser(RecentUser paramRecentUser)
  {
    this.app.getProxyManager().a().delRecentUser(paramRecentUser, false);
    setReaded(paramRecentUser.uin, paramRecentUser.getType(), true, true);
    if (paramRecentUser.getType() == 1) {
      awhn.a(this.app, paramRecentUser.uin);
    }
  }
  
  public void replaceRevokedMsgAndNotify(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    getBaseMessageManager(((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_Int).a(paramArrayList);
  }
  
  public void resumeChatActivity(String paramString, int paramInt)
  {
    this.currChatUin = paramString;
    this.currChatType = paramInt;
  }
  
  public void revokeMsgByMessageRecord(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (getBaseMessageManager(paramMessageRecord.istroop).a(paramMessageRecord)) {
      return;
    }
    if (paramMessageRecord.msgtype == -2005)
    {
      revokeMsgForFile((MessageForFile)paramMessageRecord);
      return;
    }
    if ((paramMessageRecord.msgtype == -2057) && (paramMessageRecord.istroop == 1)) {
      ((ynq)this.app.getManager(208)).a(paramMessageRecord);
    }
    getBaseMessageManager(paramMessageRecord.istroop).c(paramMessageRecord);
  }
  
  public void revokeMsgForFile(MessageForFile paramMessageForFile)
  {
    FileManagerEntity localFileManagerEntity = this.app.getFileManagerDataCenter().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    if (localFileManagerEntity != null) {
      if ((paramMessageForFile.isSend()) && ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || (localFileManagerEntity.status == 3)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg, msgForFile");
        }
        this.app.getFileManagerEngine().a(paramMessageForFile, localFileManagerEntity, new QQMessageFacade.3(this, paramMessageForFile, localFileManagerEntity));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg uniseq[" + paramMessageForFile.uniseq + "], sendUin[" + aszt.e(paramMessageForFile.senderuin) + "], type[" + paramMessageForFile.istroop + "], Entity is Null, return");
  }
  
  public void sendBlessMsg(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList<String> paramArrayList, acvz paramacvz)
  {
    ThreadManager.post(new QQMessageFacade.4(this, paramQQAppInterface, paramMessageRecord, paramArrayList, paramacvz), 8, null, false);
  }
  
  public void sendMessage(MessageRecord paramMessageRecord, amwl paramamwl)
  {
    sendMessage(paramMessageRecord, paramamwl, false);
  }
  
  public void sendMessage(MessageRecord paramMessageRecord, amwl paramamwl, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread()) {
      ThreadManager.post(new QQMessageFacade.2(this, paramMessageRecord, paramamwl, paramBoolean), 10, null, false);
    }
    for (;;)
    {
      if (paramMessageRecord.msgtype == -2011) {
        bcdn.a(paramMessageRecord);
      }
      return;
      sendMessageReal(paramMessageRecord, paramamwl, paramBoolean);
    }
  }
  
  public void sendMessageReal(MessageRecord paramMessageRecord, amwl paramamwl, boolean paramBoolean)
  {
    if (AppSetting.d()) {
      recordMR(paramMessageRecord);
    }
    afoa.a().a(this.app, paramMessageRecord);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "sendMessage: mr_uinType:" + paramMessageRecord.istroop + " mr_msgType:" + paramMessageRecord.msgtype);
    }
    try
    {
      if (paramMessageRecord.msgUid == 0L) {
        paramMessageRecord.msgUid = bblk.a(bblk.a());
      }
      if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -1049))
      {
        if (paramMessageRecord.istroop == 1001) {
          if (!this.app.isLBSFriendNewClient(paramMessageRecord.frienduin)) {
            bcef.b(this.app, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.msgtype), String.valueOf(paramMessageRecord.istroop), "");
          }
        }
        for (;;)
        {
          this.app.getMsgHandler().a(paramMessageRecord, null, paramBoolean);
          return;
          if (paramMessageRecord.istroop == 1003) {
            bcef.b(this.app, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.msgtype), String.valueOf(paramMessageRecord.istroop), "");
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
        if (this.mMsgTypeList.contains(Integer.valueOf(paramMessageRecord.msgtype)))
        {
          this.app.getMsgHandler().a(paramMessageRecord, paramamwl, paramBoolean);
          return;
        }
        if (paramMessageRecord.msgtype == -2071)
        {
          if (paramMessageRecord.istroop == 1) {
            nmy.a().a(paramMessageRecord);
          }
          this.app.getMsgHandler().a(paramMessageRecord, paramamwl, paramBoolean);
        }
      }
    }
  }
  
  public void sendSpecialMessage(String paramString)
  {
    MessageRecord localMessageRecord = bbli.a(-1052);
    localMessageRecord.msg = paramString;
    localMessageRecord.frienduin = AppConstants.BABY_Q_UIN;
    localMessageRecord.senderuin = this.app.getCurrentAccountUin();
    localMessageRecord.time = bbko.a();
    localMessageRecord.msgseq = ((int)localMessageRecord.time);
    localMessageRecord.msgUid = bblk.a(bblk.a());
    this.app.getMsgHandler().a(localMessageRecord, null, true);
  }
  
  public msg_svc.PbMsgReadedReportReq setAllReaded(boolean paramBoolean)
  {
    Object localObject = this.app.getProxyManager().a().a();
    if ((localObject == null) || (((Set)localObject).isEmpty())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    Iterator localIterator = ((Set)localObject).iterator();
    localObject = null;
    for (;;)
    {
      ConversationInfo localConversationInfo;
      long l;
      if (localIterator.hasNext())
      {
        localConversationInfo = (ConversationInfo)localIterator.next();
        if ((abwp.a(localConversationInfo) <= 0) || (!getConversationFacade().b(localConversationInfo.uin, localConversationInfo.type)) || (dispatchSetRead(localConversationInfo))) {
          continue;
        }
        if (abwz.b(localConversationInfo.uin, localConversationInfo.type))
        {
          localObject = getUinPairUnreadListFromMessageBox(paramBoolean, localStringBuilder, (msg_svc.PbC2CReadedReportReq)localObject, localConversationInfo);
          continue;
        }
        if (7000 == localConversationInfo.type)
        {
          setSubaccountAssistantReaded(localStringBuilder, localPbMsgReadedReportReq, localConversationInfo);
          continue;
        }
        if ((!paramBoolean) && (localConversationInfo.type == 1008) && (isBelongServiceAccountFolder(localConversationInfo))) {
          continue;
        }
        if ((1006 != localConversationInfo.type) && ((!abwz.d(localConversationInfo.type)) || (Long.valueOf(localConversationInfo.uin).longValue() <= 10000L))) {
          break label380;
        }
        if (10007 == localConversationInfo.type)
        {
          localObject = setTempGameMsgReaded(paramBoolean, (msg_svc.PbC2CReadedReportReq)localObject, localConversationInfo);
          continue;
        }
        if (localConversationInfo.type == 1036) {
          continue;
        }
        setReaded(localConversationInfo.uin, localConversationInfo.type, true, paramBoolean);
        l = getReadConfirmStamp(localConversationInfo.uin, localConversationInfo.type);
        if (l != -1L) {
          break label363;
        }
      }
      label363:
      label380:
      do
      {
        do
        {
          recordC2CReportMsg((msg_svc.PbC2CReadedReportReq)localObject, localPbMsgReadedReportReq);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_All>setAllReaded: " + localStringBuilder.toString());
          }
          return localPbMsgReadedReportReq;
          localObject = getStrangerFriendUnreadList(localStringBuilder, (msg_svc.PbC2CReadedReportReq)localObject, localConversationInfo, (int)l);
          break;
          if (3000 != localConversationInfo.type) {
            break label480;
          }
          setReaded(localConversationInfo.uin, localConversationInfo.type, true, paramBoolean);
          l = getReadConfirmStamp(localConversationInfo.uin, localConversationInfo.type);
        } while (l == -1L);
        msg_svc.PbDiscussReadedReportReq localPbDiscussReadedReportReq = new msg_svc.PbDiscussReadedReportReq();
        localPbDiscussReadedReportReq.conf_uin.set(Long.valueOf(localConversationInfo.uin).longValue());
        localPbDiscussReadedReportReq.last_read_seq.set(l);
        localPbMsgReadedReportReq.dis_read_report.add(localPbDiscussReadedReportReq);
        break;
        if ((1 != localConversationInfo.type) || (this.app.isTroopMark(localConversationInfo.uin, localConversationInfo.type))) {
          break;
        }
        setReaded(localConversationInfo.uin, localConversationInfo.type, true, paramBoolean);
        awhn.a(this.app, localConversationInfo.uin);
        l = getReadConfirmStamp(localConversationInfo.uin, localConversationInfo.type);
      } while (l == -1L);
      label480:
      reportTroopReportMsg(localPbMsgReadedReportReq, localConversationInfo, l);
    }
  }
  
  public boolean setAutoPullC2CMsgResult(String paramString, int paramInt, List<MessageRecord> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.QQMessageFacade", 2, "refresh C2C autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
      }
    }
    do
    {
      return false;
      this.autoPullCache.put(getKey(paramString, paramInt), Boolean.valueOf(true));
      paramString = this.app.getMessageProxy(paramInt).f(paramString, paramInt);
    } while ((paramString == null) || (paramString.isEmpty()));
    if (!paramBoolean) {
      this.app.getMessageProxy(paramInt).c();
    }
    qLogColor("refresh C2C autopull, size = " + paramString.size(), ", timestamp = " + System.currentTimeMillis());
    return true;
  }
  
  public msg_svc.PbMsgReadedReportReq setBoxMsgReaded(String paramString, int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq;
    Object localObject2;
    Object localObject1;
    label156:
    Object localObject3;
    if (abwz.b(paramString, paramInt))
    {
      setBoxReaded(paramString, paramInt);
      List localList = getMsgList(paramString, paramInt);
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
            if (!abwz.b(((MessageRecord)localObject2).senderuin)) {
              break label291;
            }
            localObject2 = getMsgList(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
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
        if (this.app.getConversationFacade().a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop) <= 0) {
          break label630;
        }
        setReaded(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop, false, paramBoolean);
        localObject1 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).peer_uin.set(Long.valueOf(((MessageRecord)localObject3).senderuin).longValue());
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).last_read_time.set((int)((MessageRecord)localObject3).time);
        if (paramString != null) {
          break label627;
        }
        paramString = new msg_svc.PbC2CReadedReportReq();
        label279:
        paramString.pair_info.add((MessageMicro)localObject1);
      }
    }
    label291:
    label627:
    label630:
    for (;;)
    {
      break label156;
      if (abwz.c(((MessageRecord)localObject2).senderuin))
      {
        if (this.app.getConversationFacade().a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) > 0) {
          setReaded(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        }
        aquu.a(this.app, 1, null);
        aquu.a(this.app, 2, null);
        localObject1 = paramString;
        break;
      }
      localObject1 = paramString;
      if (this.app.getConversationFacade().a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0) {
        break;
      }
      setReaded(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop, false, paramBoolean);
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
        localObject1 = this.app.getMsgHandler().a().a();
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
  
  public void setBoxReaded(String paramString, int paramInt)
  {
    getBaseMessageManager(paramInt).b(paramString, paramInt, false, false);
  }
  
  public void setChangeAndNotify(Object paramObject)
  {
    setChanged();
    notifyObservers(paramObject);
  }
  
  public void setChatMsgList(List<ChatMessage> paramList)
  {
    this.curChatMsgList = paramList;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "setChatMsgList");
    }
  }
  
  public void setIncomingMsg(QQMessageFacade.Message paramMessage)
  {
    this.msgNotifyManager.a(paramMessage);
  }
  
  public void setReadFrom(String paramString, int paramInt, long paramLong)
  {
    getBaseMessageManager(paramInt).a(paramString, paramInt, paramLong, false);
  }
  
  public void setReadFrom(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    getBaseMessageManager(paramInt).a(paramString, paramInt, paramLong, paramBoolean);
  }
  
  public void setReaded(String paramString, int paramInt)
  {
    setReaded(paramString, paramInt, true, false);
  }
  
  public void setReaded(String paramString, int paramInt1, int paramInt2)
  {
    setReaded(paramString, paramInt1, paramInt2, true, false);
  }
  
  public void setReaded(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    getBaseMessageManager(paramInt1).a(paramString, paramInt1, paramBoolean1, paramBoolean2, paramInt2);
  }
  
  public void setReaded(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    getBaseMessageManager(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setRecommendTroopMsgReaded(int paramInt)
  {
    String str = String.valueOf(AppConstants.RECOMMEND_TROOP_UIN);
    if (getConversationFacade().a(str, 4001) <= 0) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "setRecommendMsgReaded return : unread=0");
      }
    }
    do
    {
      return;
      QQMessageFacade.Message localMessage = getLastMessage(str, 4001);
      paramInt = getMsgProxy(4001).a(paramInt, localMessage);
      getConversationFacade().d(str, 4001, -paramInt);
    } while (paramInt == 0);
    setChanged();
    notifyObservers(getLastMessage(str, 4001));
  }
  
  public void stopHttpProcessorIfNeed(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    Object localObject2;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      localObject1 = (MessageForShortVideo)paramMessageRecord;
      localObject2 = this.app.getTransFileController();
      if (!((MessageForShortVideo)localObject1).isSendFromLocal())
      {
        ((TransFileController)localObject2).pauseReceivingShortVideo(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
        ShortVideoUtils.deleteCacheFileByMsg((MessageForShortVideo)localObject1);
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
      ((TransFileController)localObject2).pauseSendingShortVideo(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
      break;
      label78:
      localObject1 = this.app.getTransFileController();
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
        localObject3 = ((TransFileController)localObject1).findProcessor(paramMessageRecord);
        if ((localObject3 != null) && ((localObject3 instanceof BaseTransProcessor)))
        {
          ((BaseTransProcessor)localObject3).stop();
          ((TransFileController)localObject1).removeProcessor(paramMessageRecord);
        }
        i += 1;
      }
    }
  }
  
  public void tryUpdateUniseqByID(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    getMsgProxy(paramInt).b(paramString, paramInt, paramMessageRecord);
  }
  
  public void updateC2CMsgTimeByUniseq(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    updateC2CMsgTimeByUniseq(paramString, paramInt, paramLong1, paramLong2, null);
  }
  
  public void updateC2CMsgTimeByUniseq(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateC2CMsgTimeByUniseq: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong1 + " time = " + paramLong2);
    }
    paramString2 = getMsgProxy(paramInt).a(paramString1, paramInt, paramLong1, paramLong2, paramString2);
    getBaseMessageManager(paramInt).a(paramString1, paramInt, paramString2, 3);
  }
  
  public void updateGroupMsgSeqAndTimeByUniseq(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateGroupMsgSeqAndTimeByUniseq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong1 + " shmsgseq = " + paramLong2 + " time = " + paramLong3);
    }
    abwx localabwx = getMsgProxy(paramInt);
    MessageRecord localMessageRecord = null;
    if ((localabwx instanceof bdzk))
    {
      localMessageRecord = ((bdzk)localabwx).b(paramString, paramInt, paramLong1, paramLong2, paramLong3);
      ((bfdm)this.app.getManager(203)).a(paramLong1, paramLong2);
    }
    getBaseMessageManager(paramInt).a(paramString, paramInt, localMessageRecord, 3);
    setReadFrom(paramString, paramInt, paramLong2);
    setChanged();
    notifyObservers(localMessageRecord);
    if (localMessageRecord == null) {}
    do
    {
      return;
      paramString = this.app.getMsgCache();
    } while ((!paramString.e()) || ((!paramString.e(localMessageRecord)) && (!paramString.b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq))));
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "updateGroupMsgSeqAndTimeByUniseq, in revoking cache");
    }
    paramString.f(null);
    getBaseMessageManager(paramInt).b();
  }
  
  public void updateMsgContentByUniseq(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContent: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramString2 = getMsgProxy(paramInt).a(paramString1, paramInt, paramLong, paramString2);
    getBaseMessageManager(paramInt).a(paramString1, paramInt, paramString2, 2);
  }
  
  public void updateMsgContentByUniseq(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContentByUniSeq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramArrayOfByte = getMsgProxy(paramInt).a(paramString, paramInt, paramLong, paramArrayOfByte);
    getBaseMessageManager(paramInt).a(paramString, paramInt, paramArrayOfByte, 2);
  }
  
  public MessageRecord updateMsgContentToForwardByUniseq(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    return getMsgProxy(paramInt1).a(paramString1, paramInt1, paramLong1, paramString2, paramString3, paramLong2, paramInt2);
  }
  
  public void updateMsgExtraFlagByUniseq(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgExtraFlagByUniseq: peerUin = " + paramString + " type = " + paramInt1 + " uniseq = " + paramLong);
    }
    MessageRecord localMessageRecord = getMsgProxy(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramInt3);
    getBaseMessageManager(paramInt1).a(paramString, paramInt1, localMessageRecord, 3);
  }
  
  public void updateMsgFieldByUniseq(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldByUniseq: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong + " fieldName = " + paramString2 + " fieldValue = " + paramObject);
    }
    paramString2 = getMsgProxy(paramInt).a(paramString1, paramInt, paramLong, paramString2, paramObject);
    getBaseMessageManager(paramInt).a(paramString1, paramInt, paramString2, 3);
  }
  
  public void updateMsgFieldsByUniseq(String paramString, int paramInt, MessageRecord paramMessageRecord, ContentValues paramContentValues, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldsByUniseq mr=" + paramMessageRecord);
    }
    getMsgProxy(paramInt).a(paramString, paramInt, paramMessageRecord.uniseq, paramContentValues);
    if (paramArrayOfInt == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldsByUniseq null == reasons");
      }
    }
    for (;;)
    {
      return;
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldsByUniseq reason=" + k);
        }
        getBaseMessageManager(paramInt).a(paramString, paramInt, paramMessageRecord, k);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade
 * JD-Core Version:    0.7.0.1
 */