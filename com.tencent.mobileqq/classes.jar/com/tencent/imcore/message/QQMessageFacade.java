package com.tencent.imcore.message;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.imcore.message.facade.QQMessageFacadeRefresher;
import com.tencent.imcore.message.facade.add.inner.FaceScoreGrayMsgUtils;
import com.tencent.imcore.message.facade.unread.count.UnreadCountUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade.HongbaoParams;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.miniaio.MiniMsgHandler;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.DatalineMessageIpadManager;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.DatalineMessagePcManager;
import com.tencent.mobileqq.app.message.DiscMessageManager;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NeedHandleUserData;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Sqlite;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardOptionUtils;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.interfaces.IFTSMsgInterface;
import com.tencent.mobileqq.gamecenter.message.TinyIdCache;
import com.tencent.mobileqq.guild.message.BaseGuildMessageManager;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableEntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.FightReporter;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.video.AioVideoTransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QQMessageFacade
  extends BaseQQMessageFacade
  implements QQMessageFacadeStub
{
  public static final Object l = new Object();
  String i = null;
  int j = -1;
  List<ChatMessage> k;
  public final QQMessageFacadeRefresher m;
  private final QQAppInterface n;
  private DraftTextManager o;
  private final Map<String, IMessageManager> p = new ConcurrentHashMap();
  private TinyIdCache q;
  
  public QQMessageFacade(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.n = paramQQAppInterface;
    this.m = new QQMessageFacadeRefresher(this, paramQQAppInterface);
    i();
  }
  
  QQMessageFacade(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramBoolean);
    this.n = paramQQAppInterface;
    this.m = new QQMessageFacadeRefresher(this, paramQQAppInterface);
  }
  
  private void a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List paramList)
  {
    Iterator localIterator = this.e.m().iterator();
    while (localIterator.hasNext()) {
      ((GetAioListCallback)localIterator.next()).a(paramString, paramInt1, paramLong, paramInt2, paramBoolean, paramList, this.n);
    }
  }
  
  private void a(HashMap<String, MsgBackupMsgUserData> paramHashMap, boolean paramBoolean, int paramInt, Message paramMessage, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = paramString1;
      }
      int i3 = paramMessage.istroop;
      int i2 = 1;
      int i1 = i2;
      if (i3 != 0)
      {
        i1 = i2;
        if (paramMessage.istroop != 1) {
          if (paramMessage.istroop == 3000) {
            i1 = i2;
          } else {
            i1 = 0;
          }
        }
      }
      if (i1 != 0)
      {
        paramMessage = new MsgBackupMsgUserData();
        paramMessage.uin = paramString1;
        paramMessage.uinType = paramInt;
        paramMessage.name = str;
        paramMessage.mTitleName = str;
        paramHashMap.put(paramString1, paramMessage);
      }
    }
  }
  
  private void a(List<RecentBaseData> paramList, List<RecentUser> paramList1, HashMap<String, MsgBackupMsgUserData> paramHashMap)
  {
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = ((RecentUser)paramList1.next()).uin;
        MsgBackupMsgUserData localMsgBackupMsgUserData = (MsgBackupMsgUserData)paramHashMap.get(str);
        if ((localMsgBackupMsgUserData != null) && (Long.parseLong(str) > 10000L))
        {
          int i3 = localMsgBackupMsgUserData.uinType;
          int i2 = 1;
          int i1 = i2;
          if (i3 != 0)
          {
            i1 = i2;
            if (localMsgBackupMsgUserData.uinType != 1) {
              if (localMsgBackupMsgUserData.uinType == 3000) {
                i1 = i2;
              } else {
                i1 = 0;
              }
            }
          }
          if (i1 != 0) {
            paramList.add(localMsgBackupMsgUserData);
          }
        }
      }
    }
  }
  
  public int A()
  {
    return UnreadCountUtil.a(this.n, this, 9);
  }
  
  public Message B()
  {
    return this.d.b();
  }
  
  public void C()
  {
    this.m.d();
  }
  
  public void D()
  {
    ConcurrentHashMap localConcurrentHashMap = this.n.getMsgCache().E();
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
        int i1 = ((RevokeMsgInfo)localArrayList.get(0)).a;
        if (i1 == 3000)
        {
          if (((DiscussionManager)this.n.getManager(QQManagerFactory.DISCUSSION_MANAGER)).d(((RevokeMsgInfo)localArrayList.get(0)).c) != null) {}
        }
        else if (i1 == 0)
        {
          RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)localArrayList.get(0);
          String str3 = this.n.getCurrentAccountUin();
          String str2 = localRevokeMsgInfo.d;
          String str1 = str2;
          if (TextUtils.equals(str3, str2)) {
            str1 = localRevokeMsgInfo.c;
          }
          if (((FriendsManager)this.n.getManager(QQManagerFactory.FRIENDS_MANAGER)).w(str1)) {
            continue;
          }
        }
        a(localArrayList, true);
      }
    }
    localConcurrentHashMap.clear();
  }
  
  public List<RecentBaseData> E()
  {
    EntityManager localEntityManager = this.n.getEntityManagerFactory().createEntityManager();
    ArrayList localArrayList = null;
    Object localObject3 = localEntityManager.rawQuery(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    Object localObject1 = localArrayList;
    if (localObject3 != null)
    {
      localObject1 = localArrayList;
      if (((List)localObject3).size() > 0)
      {
        Object localObject2 = this.n.getProxyManager().g().a(true);
        HashMap localHashMap = new HashMap();
        localObject3 = ((List)localObject3).iterator();
        int i1;
        for (;;)
        {
          boolean bool2 = ((Iterator)localObject3).hasNext();
          boolean bool1 = false;
          if (!bool2) {
            break;
          }
          Object localObject4 = (Sqlite)((Iterator)localObject3).next();
          localObject1 = SecurityUtile.decode(((Sqlite)localObject4).tbl_name);
          ((Sqlite)localObject4).tbl_name = ((String)localObject1);
          if (((String)localObject1).endsWith("_New"))
          {
            i1 = MsgProxyUtils.a((String)localObject1);
            localObject4 = b(i1).a((String)localObject1, localEntityManager);
            if ((localObject4 != null) && (((Message)localObject4).frienduin != null))
            {
              String str = ((Message)localObject4).frienduin;
              if (((String)localObject1).startsWith("mr_friend_"))
              {
                localObject1 = ContactUtils.a(this.n, str, false);
                bool1 = true;
              }
              else if (((String)localObject1).startsWith("mr_troop_"))
              {
                localObject1 = ContactUtils.a(this.n, str, false);
                bool1 = true;
                i1 = 1;
              }
              else if (((String)localObject1).startsWith("mr_discusssion_"))
              {
                localObject1 = ContactUtils.a(this.n, str);
                bool1 = true;
                i1 = 3000;
              }
              else
              {
                localObject1 = null;
              }
              a(localHashMap, bool1, i1, (Message)localObject4, str, (String)localObject1);
            }
          }
        }
        localObject1 = localArrayList;
        if (localHashMap.size() > 0)
        {
          localArrayList = new ArrayList();
          a(localArrayList, (List)localObject2, localHashMap);
          localObject2 = localHashMap.keySet().iterator();
          for (;;)
          {
            localObject1 = localArrayList;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = (MsgBackupMsgUserData)localHashMap.get((String)((Iterator)localObject2).next());
            if ((((MsgBackupMsgUserData)localObject1).uinType != 0) && (((MsgBackupMsgUserData)localObject1).uinType != 1) && (((MsgBackupMsgUserData)localObject1).uinType != 3000) && (((MsgBackupMsgUserData)localObject1).uinType != 1000) && (((MsgBackupMsgUserData)localObject1).uinType != 1004) && (((MsgBackupMsgUserData)localObject1).uinType != 10010)) {
              i1 = 0;
            } else {
              i1 = 1;
            }
            long l1 = 0L;
            try
            {
              long l2 = Long.parseLong(((MsgBackupMsgUserData)localObject1).uin);
              l1 = l2;
            }
            catch (Exception localException)
            {
              QLog.d("Q.msg.QQMessageFacade", 1, "msgbackup.getAllMsgTableData error:", localException);
            }
            if ((i1 != 0) && (!localArrayList.contains(localObject1)) && (l1 > 10000L)) {
              localArrayList.add(localObject1);
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public int a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    SQLiteDatabase localSQLiteDatabase = this.n.getReadableDatabase();
    int i1 = 0;
    if (localSQLiteDatabase != null)
    {
      if (paramBoolean) {
        i1 = -1000;
      } else {
        i1 = 0;
      }
      i1 = localSQLiteDatabase.getCount(paramString, paramLong1, paramLong2, i1, -1000);
    }
    return i1;
  }
  
  public IMessageManager a(String paramString)
  {
    Object localObject = this.p;
    if (localObject == null) {
      return null;
    }
    if (!((Map)localObject).containsKey(paramString)) {}
    for (;;)
    {
      synchronized (this.p)
      {
        if (!this.p.containsKey(paramString))
        {
          if ("dataline_manager_pc".equals(paramString))
          {
            localObject = new DatalineMessagePcManager(this.n, this);
          }
          else
          {
            if (!"dataline_manager_ipad".equals(paramString)) {
              break label137;
            }
            localObject = new DatalineMessageIpadManager(this.n, this);
          }
          if (localObject == null) {
            return null;
          }
          this.p.put(paramString, localObject);
        }
      }
      return (IMessageManager)this.p.get(paramString);
      label137:
      localObject = null;
    }
  }
  
  public MessageRecord a(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    MessageRecord localMessageRecord = a(paramString1, paramInt1, paramLong1);
    if (localMessageRecord == null) {
      return null;
    }
    paramString3 = TransfileUtile.getForwardMsgContent(localMessageRecord.msg, paramString2, paramString3, paramLong2, paramInt2);
    localMessageRecord.msg = paramString3;
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("updateMsgContentToForward: set msg =");
      paramString2.append(localMessageRecord.getBaseInfoString());
      QLog.d("Q.msg.QQMessageFacade", 2, paramString2.toString());
    }
    paramString2 = new ContentValues();
    if (localMessageRecord.versionCode > 0)
    {
      try
      {
        paramString2.put("msgData", paramString3.getBytes("UTF-8"));
      }
      catch (UnsupportedEncodingException paramString3)
      {
        if (!QLog.isColorLevel()) {
          break label183;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMsgContentToForward fail!");
      localStringBuilder.append(paramString3);
      QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
    }
    else
    {
      paramString2.put("msg", paramString3);
    }
    label183:
    a(paramString1, paramInt1, localMessageRecord, paramString2, null);
    if ((localMessageRecord instanceof ChatMessage)) {
      ((ChatMessage)localMessageRecord).reParse();
    }
    return localMessageRecord;
  }
  
  public String a(String paramString1, String paramString2, long paramLong)
  {
    int i2 = 0;
    List localList = b(0).a(paramString1, 0, 0, false);
    if (localList != null)
    {
      int i1 = localList.size() - 1;
      paramString1 = null;
      Object localObject;
      for (;;)
      {
        localObject = paramString1;
        if (i1 < 0) {
          break;
        }
        localObject = (MessageRecord)localList.get(i1);
        if (((MessageRecord)localObject).uniseq == paramLong) {
          i2 = 1;
        }
        if ((localObject instanceof MessageForPic))
        {
          localObject = (MessageForPic)localObject;
          paramString1 = (String)localObject;
          if (i2 != 0) {
            break;
          }
        }
        i1 -= 1;
      }
      if (localObject != null)
      {
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "chatthumb";
        }
        return ((MessageForPic)localObject).getFilePath(paramString1);
      }
    }
    return "";
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (l)
    {
      paramString = a(paramString, paramInt1, -1L, paramInt2, false);
      paramInt1 = paramInt3;
      if (paramInt3 == -1) {
        paramInt1 = paramString.size();
      }
      paramInt3 = 0;
      Iterator localIterator = paramString.iterator();
      int i1;
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
          i1 = paramInt3 + 1;
          paramInt3 = i1;
        } while (!(localChatMessage instanceof MessageForText));
        localChatMessage.parse();
        paramInt3 = i1;
      } while (i1 < paramInt1);
      return paramString;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    List localList = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramBoolean);
    a(paramString, paramInt1, paramLong, paramInt2, paramBoolean, localList);
    return localList;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (((IOrderMediaMsgService)this.n.getRuntimeService(IOrderMediaMsgService.class)).isSessionOrderSending(paramString))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("orderMediaMsgSending in chat:");
        localStringBuilder.append(paramString);
        QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
      }
    }
    else {
      b(paramInt).a(paramInt, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.m.a(paramInt, paramBoolean);
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = (ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
    if (!AnonymousChatHelper.c(paramMessageRecord)) {
      paramQQAppInterface.a(paramMessageRecord);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList<String> paramArrayList, ChatActivityFacade.HongbaoParams paramHongbaoParams)
  {
    ThreadManager.post(new QQMessageFacade.3(this, paramQQAppInterface, paramMessageRecord, paramArrayList, paramHongbaoParams), 8, null, false);
  }
  
  public void a(MessageForFile paramMessageForFile)
  {
    Object localObject = this.n.getFileManagerDataCenter().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    if (localObject != null)
    {
      if ((paramMessageForFile.isSend()) && ((((FileManagerEntity)localObject).status == 1) || (((FileManagerEntity)localObject).status == -1) || (((FileManagerEntity)localObject).status == 3)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg, msgForFile");
        }
        this.n.getFileManagerEngine().a(paramMessageForFile, (FileManagerEntity)localObject, new QQMessageFacade.2(this, paramMessageForFile, (FileManagerEntity)localObject));
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doMsgRevokeReqForFileMsg uniseq[");
      ((StringBuilder)localObject).append(paramMessageForFile.uniseq);
      ((StringBuilder)localObject).append("], sendUin[");
      ((StringBuilder)localObject).append(FileManagerUtil.k(paramMessageForFile.senderuin));
      ((StringBuilder)localObject).append("], type[");
      ((StringBuilder)localObject).append(paramMessageForFile.istroop);
      ((StringBuilder)localObject).append("], Entity is Null, return");
      QLog.e("MsgRevert<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    a(this.n, paramMessageRecord);
    super.a(paramMessageRecord, paramInt);
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.n.getProxyManager().g().a(paramRecentUser, false);
    a(paramRecentUser.uin, paramRecentUser.getType(), true, true);
    if (paramRecentUser.getType() == 1) {
      ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).setReadedForHCTopic(this.n, paramRecentUser.uin);
    }
  }
  
  public void a(EntityManager paramEntityManager)
  {
    this.m.a(paramEntityManager);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext)
  {
    a(paramInt1).a(paramString, paramInt1, paramInt2, paramRefreshMessageContext);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateGroupMsgSeqAndTimeByUniseq: peerUin = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" type = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" uniseq = ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" shmsgseq = ");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(" time = ");
      ((StringBuilder)localObject1).append(paramLong3);
      QLog.d("Q.msg.QQMessageFacade", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = b(paramInt);
    Object localObject1 = null;
    if ((paramInt == 1) || (paramInt == 3000) || (paramInt == 1026))
    {
      localObject1 = ((BaseMsgProxy)localObject2).a(paramString, paramInt, paramLong1, paramLong2, paramLong3);
      ((TroopRobotManager)this.n.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(paramLong1, paramLong2);
    }
    localObject2 = a(paramInt);
    ((BaseMessageManager)localObject2).a(paramString, paramInt, (MessageRecord)localObject1, 3);
    f(paramString, paramInt, paramLong2);
    setChanged();
    notifyObservers(localObject1);
    this.n.getMsgHandler().notifyUI(8047, true, localObject1);
    if (localObject1 == null) {
      return;
    }
    paramString = this.n.getMsgCache();
    if (((localObject2 instanceof BaseMessageManagerForTroopAndDisc)) && (paramString.D()) && ((((BaseMessageManagerForTroopAndDisc)localObject2).m((MessageRecord)localObject1)) || (paramString.d(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "updateGroupMsgSeqAndTimeByUniseq, in revoking cache");
      }
      paramString.i(null);
      ((BaseMessageManager)localObject2).b();
    }
  }
  
  public void a(String paramString, int paramInt, RefreshMessageContext paramRefreshMessageContext)
  {
    this.m.a(paramString, paramInt, paramRefreshMessageContext);
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
    long l1;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    } else {
      l1 = 0L;
    }
    if (TextUtils.isEmpty(paramString3)) {
      paramLong = 0L;
    }
    a(paramInt).a(paramString1, paramInt, paramString2, paramString3, paramLong);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("notifyDraftUpdated| ");
      paramString1.append(System.currentTimeMillis() - l1);
      paramString1.append(" drafttime = ");
      paramString1.append(paramLong);
      QLog.i("notification", 2, paramString1.toString());
    }
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    a(((RevokeMsgInfo)paramArrayList.get(0)).a).a(paramArrayList);
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      String str = ((RevokeMsgInfo)paramArrayList.get(0)).c;
      int i1 = ((RevokeMsgInfo)paramArrayList.get(0)).a;
      a(i1).a(paramArrayList, paramBoolean);
      ((MiniMsgHandler)this.n.getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).a(str, i1, -1);
      if ((paramBoolean) && ((i1 == 1) || (i1 == 3000))) {
        f(str, i1, a().e(str, i1));
      }
    }
  }
  
  protected void a(List<MessageRecord> paramList, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramList = ForwardOptionUtils.a(this.n, paramList);
    if (paramList.isEmpty())
    {
      QLog.d("Q.msg.QQMessageFacade", 1, "addMultiMessagesInner all fake messages");
      return;
    }
    FaceScoreGrayMsgUtils.a(this, this.n, paramList);
    super.a(paramList, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  public int b(int paramInt, String paramString)
  {
    ConversationFacade localConversationFacade = this.n.getConversationFacade();
    if (localConversationFacade != null) {
      return localConversationFacade.a(paramString, paramInt);
    }
    return 0;
  }
  
  public int b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject = this.n.getCurrentUin();
    localObject = new QSlowTableEntityManagerFactory((String)localObject).build((String)localObject).getReadableDatabase();
    int i1 = 0;
    if (localObject != null)
    {
      if (paramBoolean) {
        i1 = -1000;
      } else {
        i1 = 0;
      }
      i1 = ((SQLiteDatabase)localObject).getCount(paramString, paramLong1, paramLong2, i1, -1000);
      ((SQLiteDatabase)localObject).close();
    }
    return i1;
  }
  
  public List<ChatMessage> b(String paramString, int paramInt, boolean paramBoolean)
  {
    return c(paramString, paramInt, -1L, paramBoolean);
  }
  
  /* Error */
  public List<MessageRecord> b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/imcore/message/QQMessageFacade:n	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 805	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   7: astore_3
    //   8: new 221	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 365	java/util/ArrayList:<init>	()V
    //   15: astore 5
    //   17: new 807	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 810	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 830	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   32: astore 6
    //   34: aload 4
    //   36: aload_3
    //   37: invokevirtual 831	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   40: invokevirtual 834	com/tencent/mobileqq/app/SQLiteOpenHelper:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   43: astore 7
    //   45: aconst_null
    //   46: astore_3
    //   47: aconst_null
    //   48: astore 4
    //   50: aload 7
    //   52: aload_1
    //   53: aload_2
    //   54: aconst_null
    //   55: aconst_null
    //   56: invokevirtual 837	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore_1
    //   60: aload_1
    //   61: astore 4
    //   63: aload_1
    //   64: astore_3
    //   65: aload 6
    //   67: ldc_w 422
    //   70: aload_2
    //   71: aload_1
    //   72: invokevirtual 841	com/tencent/mobileqq/persistence/EntityManager:cursor2List	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Ljava/util/List;
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +29 -> 106
    //   80: aload_1
    //   81: astore 4
    //   83: aload_1
    //   84: astore_3
    //   85: aload_2
    //   86: invokeinterface 140 1 0
    //   91: ifle +15 -> 106
    //   94: aload_1
    //   95: astore 4
    //   97: aload_1
    //   98: astore_3
    //   99: aload 5
    //   101: aload_2
    //   102: invokevirtual 845	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   105: pop
    //   106: aload_1
    //   107: ifnull +30 -> 137
    //   110: goto +21 -> 131
    //   113: astore_1
    //   114: goto +26 -> 140
    //   117: astore_1
    //   118: aload_3
    //   119: astore 4
    //   121: aload_1
    //   122: invokevirtual 848	java/lang/Exception:printStackTrace	()V
    //   125: aload_3
    //   126: ifnull +11 -> 137
    //   129: aload_3
    //   130: astore_1
    //   131: aload_1
    //   132: invokeinterface 851 1 0
    //   137: aload 5
    //   139: areturn
    //   140: aload 4
    //   142: ifnull +10 -> 152
    //   145: aload 4
    //   147: invokeinterface 851 1 0
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	QQMessageFacade
    //   0	154	1	paramString1	String
    //   0	154	2	paramString2	String
    //   7	123	3	str	String
    //   25	121	4	localObject	Object
    //   15	123	5	localArrayList	ArrayList
    //   32	34	6	localEntityManager	EntityManager
    //   43	8	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   50	60	113	finally
    //   65	76	113	finally
    //   85	94	113	finally
    //   99	106	113	finally
    //   121	125	113	finally
    //   50	60	117	java/lang/Exception
    //   65	76	117	java/lang/Exception
    //   85	94	117	java/lang/Exception
    //   99	106	117	java/lang/Exception
  }
  
  public void b()
  {
    super.b();
    u();
    b(0).g();
    b(0).f();
    b(3000).g();
    b(3000).f();
    b(1).g();
    b(1).f();
    IFTSDBRuntimeService localIFTSDBRuntimeService = (IFTSDBRuntimeService)this.n.getRuntimeService(IFTSDBRuntimeService.class, "");
    if ((localIFTSDBRuntimeService.getEnable()) && (SQLiteFTSUtils.a(this.n)))
    {
      ((IFTSMsgInterface)localIFTSDBRuntimeService.getOperator(1)).a();
      return;
    }
    QLog.e("Q.msg.QQMessageFacade", 1, "not support fts");
  }
  
  public void b(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    super.b(paramMessageRecord, paramBusinessObserver, paramBoolean);
    if (paramMessageRecord.msgtype == -2011) {
      FightReporter.a(paramMessageRecord);
    }
  }
  
  public void b(String paramString)
  {
    EntityManager localEntityManager = this.n.getEntityManagerFactory().createEntityManager();
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
  
  public void b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = b(paramString, paramInt, paramLong);
    ((VasExtensionManager)this.n.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).d.c((MessageRecord)localObject);
    if (b(paramInt).i(paramString, paramInt, paramLong) == 2) {
      this.n.getConversationFacade().a(paramString, paramInt, (MessageRecord)localObject);
    }
    if (!paramBoolean) {
      return;
    }
    if (localObject != null)
    {
      if (!a().o(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop)) {
        return;
      }
      paramBoolean = false;
      if ((localObject instanceof MessageForLongMsg)) {
        paramBoolean = UinTypeUtil.a((MessageRecord)localObject, getLastMessage(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop));
      } else if (b((MessageRecord)localObject)) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        if (UinTypeUtil.j(((MessageRecord)localObject).istroop))
        {
          a(((MessageRecord)localObject).istroop).e((MessageRecord)localObject);
          return;
        }
        a(((MessageRecord)localObject).istroop).f((MessageRecord)localObject);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeMsgByUniseq error: message not found. uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",type=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",uniseq=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.w("Q.msg.QQMessageFacade", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean b(ConversationInfo paramConversationInfo)
  {
    return HiddenChatHelper.a(paramConversationInfo.uin, paramConversationInfo.type, this.n);
  }
  
  public List<ChatMessage> c(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (l)
    {
      paramString = o(paramString, paramInt1);
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = paramString.size();
      }
      paramInt2 = 0;
      Iterator localIterator = paramString.iterator();
      int i1;
      do
      {
        ChatMessage localChatMessage;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localChatMessage = (ChatMessage)localIterator.next();
          i1 = paramInt2 + 1;
          paramInt2 = i1;
        } while (!(localChatMessage instanceof MessageForText));
        localChatMessage.parse();
        paramInt2 = i1;
      } while (i1 < paramInt1);
      return paramString;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<ChatMessage> c(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramLong, 0, paramBoolean);
  }
  
  /* Error */
  public List<MessageRecord> c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/imcore/message/QQMessageFacade:n	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 384	com/tencent/mobileqq/app/QQAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   7: astore 7
    //   9: new 221	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 365	java/util/ArrayList:<init>	()V
    //   16: astore 5
    //   18: aload_0
    //   19: getfield 51	com/tencent/imcore/message/QQMessageFacade:n	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: invokevirtual 277	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   25: invokevirtual 978	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:b	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   28: astore 6
    //   30: aconst_null
    //   31: astore_3
    //   32: aconst_null
    //   33: astore 4
    //   35: aload 7
    //   37: aload_1
    //   38: aload_2
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 837	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_1
    //   45: aload_1
    //   46: astore 4
    //   48: aload_1
    //   49: astore_3
    //   50: aload 6
    //   52: ldc_w 422
    //   55: aload_2
    //   56: aload_1
    //   57: invokevirtual 841	com/tencent/mobileqq/persistence/EntityManager:cursor2List	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Ljava/util/List;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +29 -> 91
    //   65: aload_1
    //   66: astore 4
    //   68: aload_1
    //   69: astore_3
    //   70: aload_2
    //   71: invokeinterface 140 1 0
    //   76: ifle +15 -> 91
    //   79: aload_1
    //   80: astore 4
    //   82: aload_1
    //   83: astore_3
    //   84: aload 5
    //   86: aload_2
    //   87: invokevirtual 845	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   90: pop
    //   91: aload_1
    //   92: ifnull +30 -> 122
    //   95: goto +21 -> 116
    //   98: astore_1
    //   99: goto +26 -> 125
    //   102: astore_1
    //   103: aload_3
    //   104: astore 4
    //   106: aload_1
    //   107: invokevirtual 848	java/lang/Exception:printStackTrace	()V
    //   110: aload_3
    //   111: ifnull +11 -> 122
    //   114: aload_3
    //   115: astore_1
    //   116: aload_1
    //   117: invokeinterface 851 1 0
    //   122: aload 5
    //   124: areturn
    //   125: aload 4
    //   127: ifnull +10 -> 137
    //   130: aload 4
    //   132: invokeinterface 851 1 0
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	QQMessageFacade
    //   0	139	1	paramString1	String
    //   0	139	2	paramString2	String
    //   31	84	3	str1	String
    //   33	98	4	str2	String
    //   16	107	5	localArrayList	ArrayList
    //   28	23	6	localEntityManager	EntityManager
    //   7	29	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   35	45	98	finally
    //   50	61	98	finally
    //   70	79	98	finally
    //   84	91	98	finally
    //   106	110	98	finally
    //   35	45	102	java/lang/Exception
    //   50	61	102	java/lang/Exception
    //   70	79	102	java/lang/Exception
    //   84	91	102	java/lang/Exception
  }
  
  public void c(Message paramMessage)
  {
    this.d.a(paramMessage);
  }
  
  public void c(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      b(((MessageRecord)paramList.get(0)).istroop).b(paramString, paramInt, paramList);
      setChanged();
      notifyObservers(paramList.get(0));
      paramString = this.n;
      paramString = paramString.getEntityManagerFactory(paramString.getCurrentAccountUin()).createEntityManager();
      try
      {
        a(paramList, paramString, true, true, false, false);
        paramString.close();
        b(paramList);
        return;
      }
      finally
      {
        paramString.close();
      }
    }
  }
  
  public void c(List<ChatMessage> paramList)
  {
    this.k = paramList;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "setChatMsgList");
    }
  }
  
  public boolean c(ConversationInfo paramConversationInfo)
  {
    return FriendsStatusUtil.a(paramConversationInfo.uin, this.n);
  }
  
  public boolean c(String paramString)
  {
    return m(paramString, 0);
  }
  
  public DatalineMessageManager d(int paramInt)
  {
    String str;
    if (paramInt != 1) {
      str = "dataline_manager_pc";
    } else {
      str = "dataline_manager_ipad";
    }
    return (DatalineMessageManager)a(str);
  }
  
  public void d(String paramString)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1052);
    localMessageRecord.msg = paramString;
    localMessageRecord.frienduin = AppConstants.BABY_Q_UIN;
    localMessageRecord.senderuin = this.n.getCurrentAccountUin();
    localMessageRecord.time = MessageCache.c();
    localMessageRecord.msgseq = ((int)localMessageRecord.time);
    localMessageRecord.msgUid = MessageUtils.a(MessageUtils.a());
    this.n.getMsgHandler().a(localMessageRecord, null, true);
  }
  
  public void d(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      BaseMsgProxy localBaseMsgProxy = b(((MessageRecord)paramList.get(0)).istroop);
      if (localBaseMsgProxy != null)
      {
        localBaseMsgProxy.b(paramString, paramInt, paramList);
        paramString = paramList.iterator();
        while (paramString.hasNext())
        {
          paramList = (MessageRecord)paramString.next();
          localBaseMsgProxy.a(paramList.frienduin, paramList.istroop, paramList, null, false, true, false);
        }
      }
    }
  }
  
  public void d(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      EntityManager localEntityManager = this.n.getEntityManagerFactory().createEntityManager();
      EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
      try
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          localEntityManager.persistOrReplace((MessageRecord)localIterator.next());
        }
        localEntityTransaction.commit();
        localEntityTransaction.end();
        a((MessageRecord)paramList.get(paramList.size() - 1), this.n.getCurrentUin());
        return;
      }
      finally
      {
        localEntityTransaction.end();
      }
    }
  }
  
  public void e(int paramInt)
  {
    Object localObject = this.n.getMessageProxy(4001).c(String.valueOf(AppConstants.RECOMMEND_TROOP_UIN), 4001);
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      this.n.getMessageFacade().c(paramInt);
      if (b(4001).a(paramInt) > 0)
      {
        setChanged();
        localObject = new RecentUser();
        ((RecentUser)localObject).uin = String.valueOf(AppConstants.TROOP_NOTIFICATION_UIN);
        notifyObservers(localObject);
      }
    }
  }
  
  public void e(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      localObject1 = (MessageForShortVideo)paramMessageRecord;
      if (!((MessageForShortVideo)localObject1).isSendFromLocal()) {
        AioVideoTransFileController.a(this.n, ((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
      } else {
        AioVideoTransFileController.b(this.n, ((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
      }
      ShortVideoUtils.deleteCacheFileByMsg((MessageForShortVideo)localObject1);
    }
    if (!paramMessageRecord.isSendFromLocal()) {
      return;
    }
    Object localObject1 = (ITransFileController)this.n.getRuntimeService(ITransFileController.class);
    ArrayList localArrayList = new ArrayList();
    boolean bool = paramMessageRecord instanceof MessageForMixedMsg;
    int i3 = 0;
    int i2;
    int i1;
    Object localObject2;
    if (bool)
    {
      paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
      i2 = paramMessageRecord.msgElemList.size();
      i1 = 0;
      while (i1 < i2)
      {
        localObject2 = (MessageRecord)paramMessageRecord.msgElemList.get(i1);
        if ((localObject2 instanceof MessageForPic)) {
          localArrayList.add((MessageForPic)localObject2);
        }
        i1 += 1;
      }
    }
    if ((paramMessageRecord instanceof MessageForLongMsg))
    {
      paramMessageRecord = (MessageForLongMsg)paramMessageRecord;
      int i4 = paramMessageRecord.longMsgFragmentList.size();
      i1 = 0;
      while (i1 < i4)
      {
        localObject2 = (MessageRecord)paramMessageRecord.longMsgFragmentList.get(i1);
        if ((localObject2 instanceof MessageForPic))
        {
          localArrayList.add((MessageForPic)localObject2);
        }
        else if ((localObject2 instanceof MessageForMixedMsg))
        {
          localObject2 = (MessageForMixedMsg)localObject2;
          int i5 = ((MessageForMixedMsg)localObject2).msgElemList.size();
          i2 = 0;
          while (i2 < i5)
          {
            MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject2).msgElemList.get(i2);
            if ((localMessageRecord instanceof MessageForPic)) {
              localArrayList.add((MessageForPic)localMessageRecord);
            }
            i2 += 1;
          }
        }
        i1 += 1;
      }
    }
    if ((paramMessageRecord instanceof MessageForPic))
    {
      localArrayList.add((MessageForPic)paramMessageRecord);
      i2 = localArrayList.size();
      i1 = i3;
      while (i1 < i2)
      {
        paramMessageRecord = (MessageForPic)localArrayList.get(i1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramMessageRecord.frienduin);
        ((StringBuilder)localObject2).append(paramMessageRecord.uniseq);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(paramMessageRecord.subMsgId);
        paramMessageRecord = ((StringBuilder)localObject2).toString();
        localObject2 = ((ITransFileController)localObject1).findProcessor(paramMessageRecord);
        if ((localObject2 != null) && ((localObject2 instanceof BaseTransProcessor)))
        {
          ((BaseTransProcessor)localObject2).stop();
          ((ITransFileController)localObject1).removeProcessor(paramMessageRecord);
        }
        i1 += 1;
      }
    }
  }
  
  public void f(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (!a(paramMessageRecord.istroop).h(paramMessageRecord))
    {
      if (paramMessageRecord.msgtype == -2005)
      {
        a((MessageForFile)paramMessageRecord);
        return;
      }
      if ((paramMessageRecord.msgtype == -2057) && (paramMessageRecord.istroop == 1)) {
        ((TroopStoryManager)this.n.getManager(QQManagerFactory.TROOP_STORY_MANAGER)).a(paramMessageRecord);
      }
      a(paramMessageRecord.istroop).g(paramMessageRecord);
    }
  }
  
  public void g(MessageRecord paramMessageRecord)
  {
    a(paramMessageRecord.istroop).b(paramMessageRecord);
  }
  
  public DraftSummaryInfo getDraftSummaryInfo(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      DraftTextManager localDraftTextManager = this.o;
      if (localDraftTextManager != null) {
        return localDraftTextManager.b(this.n, paramString, paramInt);
      }
    }
    return null;
  }
  
  public TinyIdCache h()
  {
    if (this.q == null) {
      try
      {
        if (this.q == null) {
          this.q = new TinyIdCache(this.n, this.n.getCacheManager().getDBDelayManager());
        }
      }
      finally {}
    }
    return this.q;
  }
  
  public void h(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong, true);
  }
  
  public List<ChatMessage> i(String paramString, int paramInt, long paramLong)
  {
    return c(paramString, paramInt, paramLong, false);
  }
  
  public void i()
  {
    ThreadManager.post(new QQMessageFacade.1(this), 10, null, false);
  }
  
  public void j()
  {
    this.i = null;
    this.j = -1;
    this.k = null;
  }
  
  public void k()
  {
    b(0).e();
    b(3000).e();
    b(1).e();
    b(1026).e();
  }
  
  public void k(String paramString, int paramInt)
  {
    this.i = paramString;
    this.j = paramInt;
  }
  
  public Message l(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFirstUnreadMessage() called with: uin = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], type = [");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.d("Q.msg.QQMessageFacade", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = this.n.getProxyManager().h().g(paramString, paramInt);
    Object localObject = a(l1, h(paramString, paramInt));
    if (localObject != null) {
      return localObject;
    }
    localObject = a(l1, a(paramString, paramInt, l1, 3, String.format("time>=%d", new Object[] { Long.valueOf(l1) })));
    if (localObject != null) {
      return localObject;
    }
    localObject = new Message();
    ((Message)localObject).frienduin = paramString;
    ((Message)localObject).istroop = paramInt;
    return localObject;
  }
  
  public String l()
  {
    return this.i;
  }
  
  public int m()
  {
    return this.j;
  }
  
  public boolean m(String paramString, int paramInt)
  {
    return n(paramString, paramInt);
  }
  
  public boolean n()
  {
    return (this.i != null) && (this.j >= 0);
  }
  
  public boolean n(String paramString, int paramInt)
  {
    if (this.n.mAutomator.h())
    {
      this.n.getMsgHandler().c(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  public List<ChatMessage> o()
  {
    return this.k;
  }
  
  public List<ChatMessage> o(String paramString, int paramInt)
  {
    return i(paramString, paramInt, -1L);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.o;
    if (localObject != null) {
      ((DraftTextManager)localObject).a();
    }
    this.m.f();
    localObject = this.q;
    if (localObject != null) {
      ((TinyIdCache)localObject).a();
    }
  }
  
  public TroopMessageManager p()
  {
    return (TroopMessageManager)a(1);
  }
  
  public boolean p(String paramString, int paramInt)
  {
    List localList = h(paramString, paramInt);
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool1 = bool4;
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return false;
      }
      Object localObject;
      if (localList.size() == 1)
      {
        localObject = (MessageRecord)localList.get(0);
        bool1 = bool4;
        if (((MessageRecord)localObject).msgtype != -2006)
        {
          if (!((MessageRecord)localObject).isValid) {
            return false;
          }
          if (((MessageRecord)localObject).shmsgseq > Math.max(this.n.getMsgCache().w(paramString), this.n.getMsgCache().b(paramString, paramInt)) + 1L) {
            bool2 = true;
          }
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isAIOBreak = ");
            localStringBuilder.append(bool2);
            localStringBuilder.append("; cacheList size = ");
            localStringBuilder.append(localList.size());
            localStringBuilder.append("; msgseq = ");
            localStringBuilder.append(((MessageRecord)localObject).shmsgseq);
            localStringBuilder.append(", expiredSeq = ");
            localStringBuilder.append(this.n.getMsgCache().w(paramString));
            localStringBuilder.append(", delLastSeq = ");
            localStringBuilder.append(this.n.getMsgCache().b(paramString, paramInt));
            QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
            return bool2;
          }
        }
      }
      else
      {
        bool1 = bool4;
        if (localList.size() > 1)
        {
          paramString = (MessageRecord)localList.get(localList.size() - 1);
          bool1 = bool4;
          if (paramString.msgtype != -2006)
          {
            if (!paramString.isValid) {
              return false;
            }
            paramString = MsgProxyUtils.a(localList, false);
            bool2 = bool3;
            if (paramString.size() < 10) {
              bool2 = true;
            }
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("isAIOBreak = ");
              ((StringBuilder)localObject).append(bool2);
              ((StringBuilder)localObject).append("; cacheList size = ");
              ((StringBuilder)localObject).append(localList.size());
              ((StringBuilder)localObject).append("; continuedList size = ");
              ((StringBuilder)localObject).append(paramString.size());
              QLog.d("Q.msg.QQMessageFacade", 2, ((StringBuilder)localObject).toString());
              bool1 = bool2;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public DiscMessageManager q()
  {
    return (DiscMessageManager)a(3000);
  }
  
  public MessageRecord q(String paramString, int paramInt)
  {
    List localList = b(paramInt).c(paramString, paramInt);
    MessageRecord localMessageRecord = null;
    if (localList != null)
    {
      int i1 = localList.size() - 1;
      while (i1 >= 0)
      {
        localMessageRecord = (MessageRecord)localList.get(i1);
        if ((localMessageRecord.isValid) && (!MsgProxyUtils.b(localMessageRecord.msgtype)))
        {
          if (localMessageRecord.isLongMsg())
          {
            localMessageRecord = d(localMessageRecord);
            break label98;
          }
          break label98;
        }
        i1 -= 1;
      }
      localMessageRecord = null;
      label98:
      if (localMessageRecord == null) {
        return b(paramInt).a(paramString, paramInt, null);
      }
    }
    return localMessageRecord;
  }
  
  public C2CMessageManager r()
  {
    return (C2CMessageManager)a(0);
  }
  
  public MessageRecord r(String paramString, int paramInt)
  {
    Object localObject2 = b(paramInt).d(paramString, paramInt);
    if (localObject2 != null)
    {
      int i1 = ((List)localObject2).size() - 1;
      while (i1 >= 0)
      {
        localObject1 = (MessageRecord)((List)localObject2).get(i1);
        if ((((MessageRecord)localObject1).isValid) && (!MsgProxyUtils.b(((MessageRecord)localObject1).msgtype)))
        {
          if (((MessageRecord)localObject1).isLongMsg())
          {
            localObject1 = d((MessageRecord)localObject1);
            break label95;
          }
          break label95;
        }
        i1 -= 1;
      }
    }
    Object localObject1 = null;
    label95:
    if (localObject1 != null) {
      return localObject1;
    }
    Message localMessage = getLastMessage(paramString, paramInt);
    localObject2 = localObject1;
    if (localMessage != null)
    {
      localObject2 = localObject1;
      if (localMessage.isCacheValid)
      {
        if (localMessage.lastMsg != null) {
          localObject2 = localMessage.lastMsg;
        } else {
          localObject2 = b(localMessage);
        }
        localMessage.lastMsg = ((MessageRecord)localObject2);
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = b(paramInt).a(paramString, paramInt, null);
    }
    return localObject1;
  }
  
  public BaseGuildMessageManager s()
  {
    return (BaseGuildMessageManager)a(10014);
  }
  
  public void s(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramString.length() < 5) {
        return;
      }
      if ((this.o != null) && (paramString != null) && (paramString.length() >= 5)) {
        this.o.c(this.n, paramString, paramInt);
      }
    }
  }
  
  public void t()
  {
    this.m.c();
  }
  
  public boolean t(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      DraftTextManager localDraftTextManager = this.o;
      if (localDraftTextManager != null) {
        return localDraftTextManager.a(paramString, paramInt);
      }
    }
    return false;
  }
  
  public void u()
  {
    List localList = b(1032).b(AppConstants.CONFESS_UIN, 1032);
    HashSet localHashSet = new HashSet(localList.size());
    int i1 = 0;
    while (i1 < localList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i1);
      int i2;
      if (localMessageRecord.isSelfConfessor()) {
        i2 = 1033;
      } else {
        i2 = 1034;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(localMessageRecord.senderuin);
      localObject = ((StringBuilder)localObject).toString();
      if (!localHashSet.contains(localObject))
      {
        localHashSet.add(localObject);
        b(localMessageRecord.senderuin, i2, true, true);
      }
      i1 += 1;
    }
    ConfessMsgUtil.b(this.n, true);
    ConfessMsgUtil.a(this.n, true);
  }
  
  public void v()
  {
    RecentUserProxy localRecentUserProxy = this.n.getProxyManager().g();
    Object localObject = new RecentUser().getTableName();
    String str1 = new TroopAssistantData().getTableName();
    String str2 = new PubAccountAssistantData().getTableName();
    String str3 = new TroopBarData().getTableName();
    String str4 = new NeedHandleUserData().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.n.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.delete((String)localObject, null, null);
    localSQLiteDatabase.delete(str1, null, null);
    localSQLiteDatabase.delete(str2, null, null);
    localSQLiteDatabase.delete(str4, null, null);
    localSQLiteDatabase.delete(str3, null, null);
    this.n.clearGroupSystemMsg();
    GroupSystemMsgController.a().a(this.n, 0);
    localObject = (IRecommendTroopService)this.n.getRuntimeService(IRecommendTroopService.class, "");
    if (localObject != null)
    {
      ((IRecommendTroopService)localObject).clearRecommendTroop();
      ((IRecommendTroopService)localObject).updateDBStatsus(1);
    }
    TroopAssistantManager.a().c(this.n, true);
    e();
    localRecentUserProxy.a();
  }
  
  public int w()
  {
    return UnreadCountUtil.a(this.n, this);
  }
  
  public Set<ConversationInfo> x()
  {
    return this.n.getProxyManager().h().b();
  }
  
  public int y()
  {
    int i1 = UnreadCountUtil.a(this.n, this, 10);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unread count = ");
      localStringBuilder.append(i1);
      QLog.d("MiniUnreadMsgsNum", 2, localStringBuilder.toString());
    }
    return i1;
  }
  
  public int z()
  {
    return UnreadCountUtil.a(this.n, this, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade
 * JD-Core Version:    0.7.0.1
 */