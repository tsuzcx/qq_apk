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
  public static final Object a;
  int jdField_a_of_type_Int = -1;
  public final QQMessageFacadeRefresher a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TinyIdCache jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyIdCache;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  String jdField_a_of_type_JavaLangString = null;
  List<ChatMessage> jdField_a_of_type_JavaUtilList;
  private final Map<String, IMessageManager> c = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public QQMessageFacade(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentImcoreMessageFacadeQQMessageFacadeRefresher = new QQMessageFacadeRefresher(this, paramQQAppInterface);
    e();
  }
  
  QQMessageFacade(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentImcoreMessageFacadeQQMessageFacadeRefresher = new QQMessageFacadeRefresher(this, paramQQAppInterface);
  }
  
  private void a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List paramList)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentImcoreMessageRegistry.e().iterator();
    while (localIterator.hasNext()) {
      ((GetAioListCallback)localIterator.next()).a(paramString, paramInt1, paramLong, paramInt2, paramBoolean, paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      int k = paramMessage.istroop;
      int j = 1;
      int i = j;
      if (k != 0)
      {
        i = j;
        if (paramMessage.istroop != 1) {
          if (paramMessage.istroop == 3000) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
      if (i != 0)
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
          int k = localMsgBackupMsgUserData.uinType;
          int j = 1;
          int i = j;
          if (k != 0)
          {
            i = j;
            if (localMsgBackupMsgUserData.uinType != 1) {
              if (localMsgBackupMsgUserData.uinType == 3000) {
                i = j;
              } else {
                i = 0;
              }
            }
          }
          if (i != 0) {
            paramList.add(localMsgBackupMsgUserData);
          }
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
    ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
    if (localConversationFacade != null) {
      return localConversationFacade.a(paramString, paramInt);
    }
    return 0;
  }
  
  public int a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReadableDatabase();
    int i = 0;
    if (localSQLiteDatabase != null)
    {
      if (paramBoolean) {
        i = -1000;
      } else {
        i = 0;
      }
      i = localSQLiteDatabase.getCount(paramString, paramLong1, paramLong2, i, -1000);
    }
    return i;
  }
  
  public C2CMessageManager a()
  {
    return (C2CMessageManager)a(0);
  }
  
  public Message a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager.a();
  }
  
  public DatalineMessageManager a(int paramInt)
  {
    String str;
    if (paramInt != 1) {
      str = "dataline_manager_pc";
    } else {
      str = "dataline_manager_ipad";
    }
    return (DatalineMessageManager)a(str);
  }
  
  public DiscMessageManager a()
  {
    return (DiscMessageManager)a(3000);
  }
  
  public IMessageManager a(String paramString)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return null;
    }
    if (!((Map)localObject).containsKey(paramString)) {}
    for (;;)
    {
      synchronized (this.c)
      {
        if (!this.c.containsKey(paramString))
        {
          if ("dataline_manager_pc".equals(paramString))
          {
            localObject = new DatalineMessagePcManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          else
          {
            if (!"dataline_manager_ipad".equals(paramString)) {
              break label135;
            }
            localObject = new DatalineMessageIpadManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          if (localObject == null) {
            return null;
          }
          this.c.put(paramString, localObject);
        }
      }
      return (IMessageManager)this.c.get(paramString);
      label135:
      localObject = null;
    }
  }
  
  public MessageRecord a(String paramString, int paramInt)
  {
    List localList = a(paramInt).b(paramString, paramInt);
    MessageRecord localMessageRecord = null;
    if (localList != null)
    {
      int i = localList.size() - 1;
      while (i >= 0)
      {
        localMessageRecord = (MessageRecord)localList.get(i);
        if ((localMessageRecord.isValid) && (!MsgProxyUtils.b(localMessageRecord.msgtype)))
        {
          if (localMessageRecord.isLongMsg())
          {
            localMessageRecord = a(localMessageRecord);
            break label98;
          }
          break label98;
        }
        i -= 1;
      }
      localMessageRecord = null;
      label98:
      if (localMessageRecord == null) {
        return a(paramInt).a(paramString, paramInt, null);
      }
    }
    return localMessageRecord;
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
  
  public TinyIdCache a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyIdCache == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyIdCache == null) {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyIdCache = new TinyIdCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCacheManager().getDBDelayManager());
        }
      }
      finally {}
    }
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyIdCache;
  }
  
  public TroopMessageManager a()
  {
    return (TroopMessageManager)a(1);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString1, String paramString2, long paramLong)
  {
    int j = 0;
    List localList = a(0).a(paramString1, 0, 0, false);
    if (localList != null)
    {
      int i = localList.size() - 1;
      paramString1 = null;
      Object localObject;
      for (;;)
      {
        localObject = paramString1;
        if (i < 0) {
          break;
        }
        localObject = (MessageRecord)localList.get(i);
        if (((MessageRecord)localObject).uniseq == paramLong) {
          j = 1;
        }
        if ((localObject instanceof MessageForPic))
        {
          localObject = (MessageForPic)localObject;
          paramString1 = (String)localObject;
          if (j != 0) {
            break;
          }
        }
        i -= 1;
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
  
  public List<ChatMessage> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
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
      paramInt3 = 0;
      Iterator localIterator = paramString.iterator();
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
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong)
  {
    return a(paramString, paramInt, paramLong, false);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    List localList = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramBoolean);
    a(paramString, paramInt1, paramLong, paramInt2, paramBoolean, localList);
    return localList;
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramLong, 0, paramBoolean);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, -1L, paramBoolean);
  }
  
  /* Error */
  public List<MessageRecord> a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 417	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   7: astore_3
    //   8: new 419	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 420	java/util/ArrayList:<init>	()V
    //   15: astore 5
    //   17: new 422	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 425	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 428	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   32: astore 6
    //   34: aload 4
    //   36: aload_3
    //   37: invokevirtual 432	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   40: invokevirtual 437	com/tencent/mobileqq/app/SQLiteOpenHelper:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
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
    //   56: invokevirtual 441	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore_1
    //   60: aload_1
    //   61: astore 4
    //   63: aload_1
    //   64: astore_3
    //   65: aload 6
    //   67: ldc 243
    //   69: aload_2
    //   70: aload_1
    //   71: invokevirtual 447	com/tencent/mobileqq/persistence/EntityManager:cursor2List	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Ljava/util/List;
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +29 -> 105
    //   79: aload_1
    //   80: astore 4
    //   82: aload_1
    //   83: astore_3
    //   84: aload_2
    //   85: invokeinterface 136 1 0
    //   90: ifle +15 -> 105
    //   93: aload_1
    //   94: astore 4
    //   96: aload_1
    //   97: astore_3
    //   98: aload 5
    //   100: aload_2
    //   101: invokevirtual 451	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   104: pop
    //   105: aload_1
    //   106: ifnull +30 -> 136
    //   109: goto +21 -> 130
    //   112: astore_1
    //   113: goto +26 -> 139
    //   116: astore_1
    //   117: aload_3
    //   118: astore 4
    //   120: aload_1
    //   121: invokevirtual 454	java/lang/Exception:printStackTrace	()V
    //   124: aload_3
    //   125: ifnull +11 -> 136
    //   128: aload_3
    //   129: astore_1
    //   130: aload_1
    //   131: invokeinterface 459 1 0
    //   136: aload 5
    //   138: areturn
    //   139: aload 4
    //   141: ifnull +10 -> 151
    //   144: aload 4
    //   146: invokeinterface 459 1 0
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	QQMessageFacade
    //   0	153	1	paramString1	String
    //   0	153	2	paramString2	String
    //   7	122	3	str	String
    //   25	120	4	localObject	Object
    //   15	122	5	localArrayList	ArrayList
    //   32	34	6	localEntityManager	EntityManager
    //   43	8	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   50	60	112	finally
    //   65	75	112	finally
    //   84	93	112	finally
    //   98	105	112	finally
    //   120	124	112	finally
    //   50	60	116	java/lang/Exception
    //   65	75	116	java/lang/Exception
    //   84	93	116	java/lang/Exception
    //   98	105	116	java/lang/Exception
  }
  
  public Set<ConversationInfo> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a();
  }
  
  public void a()
  {
    super.a();
    i();
    a(0).c();
    a(0).b();
    a(3000).c();
    a(3000).b();
    a(1).c();
    a(1).b();
    IFTSDBRuntimeService localIFTSDBRuntimeService = (IFTSDBRuntimeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "");
    if ((localIFTSDBRuntimeService.getEnable()) && (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      ((IFTSMsgInterface)localIFTSDBRuntimeService.getOperator(1)).a();
      return;
    }
    QLog.e("Q.msg.QQMessageFacade", 1, "not support fts");
  }
  
  public void a(int paramInt, String paramString)
  {
    if (((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).isSessionOrderSending(paramString))
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
      a(paramInt).a(paramInt, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageFacadeQQMessageFacadeRefresher.a(paramInt, paramBoolean);
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = (ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
    if (!AnonymousChatHelper.a(paramMessageRecord)) {
      paramQQAppInterface.a(paramMessageRecord);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList<String> paramArrayList, ChatActivityFacade.HongbaoParams paramHongbaoParams)
  {
    ThreadManager.post(new QQMessageFacade.3(this, paramQQAppInterface, paramMessageRecord, paramArrayList, paramHongbaoParams), 8, null, false);
  }
  
  public void a(MessageForFile paramMessageForFile)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    if (localObject != null)
    {
      if ((paramMessageForFile.isSend()) && ((((FileManagerEntity)localObject).status == 1) || (((FileManagerEntity)localObject).status == -1) || (((FileManagerEntity)localObject).status == 3)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg, msgForFile");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramMessageForFile, (FileManagerEntity)localObject, new QQMessageFacade.2(this, paramMessageForFile, (FileManagerEntity)localObject));
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doMsgRevokeReqForFileMsg uniseq[");
      ((StringBuilder)localObject).append(paramMessageForFile.uniseq);
      ((StringBuilder)localObject).append("], sendUin[");
      ((StringBuilder)localObject).append(FileManagerUtil.d(paramMessageForFile.senderuin));
      ((StringBuilder)localObject).append("], type[");
      ((StringBuilder)localObject).append(paramMessageForFile.istroop);
      ((StringBuilder)localObject).append("], Entity is Null, return");
      QLog.e("MsgRevert<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
    super.a(paramMessageRecord, paramInt);
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramRecentUser, false);
    a(paramRecentUser.uin, paramRecentUser.getType(), true, true);
    if (paramRecentUser.getType() == 1) {
      ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).setReadedForHCTopic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin);
    }
  }
  
  public void a(EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageFacadeQQMessageFacadeRefresher.a(paramEntityManager);
  }
  
  public void a(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
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
    Object localObject2 = a(paramInt);
    Object localObject1 = null;
    if ((paramInt == 1) || (paramInt == 3000) || (paramInt == 1026))
    {
      localObject1 = ((BaseMsgProxy)localObject2).a(paramString, paramInt, paramLong1, paramLong2, paramLong3);
      ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(paramLong1, paramLong2);
    }
    localObject2 = a(paramInt);
    ((BaseMessageManager)localObject2).a(paramString, paramInt, (MessageRecord)localObject1, 3);
    a(paramString, paramInt, paramLong2);
    setChanged();
    notifyObservers(localObject1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(8047, true, localObject1);
    if (localObject1 == null) {
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache();
    if (((localObject2 instanceof BaseMessageManagerForTroopAndDisc)) && (paramString.e()) && ((((BaseMessageManagerForTroopAndDisc)localObject2).c((MessageRecord)localObject1)) || (paramString.a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "updateGroupMsgSeqAndTimeByUniseq, in revoking cache");
      }
      paramString.d(null);
      ((BaseMessageManager)localObject2).b();
    }
  }
  
  public void a(String paramString, int paramInt, RefreshMessageContext paramRefreshMessageContext)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageFacadeQQMessageFacadeRefresher.a(paramString, paramInt, paramRefreshMessageContext);
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
    long l;
    if (QLog.isColorLevel()) {
      l = System.currentTimeMillis();
    } else {
      l = 0L;
    }
    if (TextUtils.isEmpty(paramString3)) {
      paramLong = 0L;
    }
    a(paramInt).a(paramString1, paramInt, paramString2, paramString3, paramLong);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("notifyDraftUpdated| ");
      paramString1.append(System.currentTimeMillis() - l);
      paramString1.append(" drafttime = ");
      paramString1.append(paramLong);
      QLog.i("notification", 2, paramString1.toString());
    }
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      a(((MessageRecord)paramList.get(0)).istroop).a(paramString, paramInt, paramList);
      setChanged();
      notifyObservers(paramList.get(0));
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    a(((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_Int).a(paramArrayList);
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      String str = ((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_JavaLangString;
      int i = ((RevokeMsgInfo)paramArrayList.get(0)).jdField_a_of_type_Int;
      a(i).a(paramArrayList, paramBoolean);
      ((MiniMsgHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).a(str, i, -1);
      if ((paramBoolean) && ((i == 1) || (i == 3000))) {
        a(str, i, a().a(str, i));
      }
    }
  }
  
  protected void a(List<MessageRecord> paramList, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramList = ForwardOptionUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
    if (paramList.isEmpty())
    {
      QLog.d("Q.msg.QQMessageFacade", 1, "addMultiMessagesInner all fake messages");
      return;
    }
    FaceScoreGrayMsgUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
    super.a(paramList, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Int >= 0);
  }
  
  public boolean a(String paramString)
  {
    return d(paramString, 0);
  }
  
  public int b()
  {
    return UnreadCountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
  }
  
  public int b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localObject = new QSlowTableEntityManagerFactory((String)localObject).build((String)localObject).getReadableDatabase();
    int i = 0;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = -1000;
      } else {
        i = 0;
      }
      i = ((SQLiteDatabase)localObject).getCount(paramString, paramLong1, paramLong2, i, -1000);
      ((SQLiteDatabase)localObject).close();
    }
    return i;
  }
  
  public Message b(String paramString, int paramInt)
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
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramString, paramInt);
    Object localObject = a(l, a(paramString, paramInt));
    if (localObject != null) {
      return localObject;
    }
    localObject = a(l, a(paramString, paramInt, l, 3, String.format("time>=%d", new Object[] { Long.valueOf(l) })));
    if (localObject != null) {
      return localObject;
    }
    localObject = new Message();
    ((Message)localObject).frienduin = paramString;
    ((Message)localObject).istroop = paramInt;
    return localObject;
  }
  
  public MessageRecord b(String paramString, int paramInt)
  {
    Object localObject2 = a(paramInt).c(paramString, paramInt);
    if (localObject2 != null)
    {
      int i = ((List)localObject2).size() - 1;
      while (i >= 0)
      {
        localObject1 = (MessageRecord)((List)localObject2).get(i);
        if ((((MessageRecord)localObject1).isValid) && (!MsgProxyUtils.b(((MessageRecord)localObject1).msgtype)))
        {
          if (((MessageRecord)localObject1).isLongMsg())
          {
            localObject1 = a((MessageRecord)localObject1);
            break label95;
          }
          break label95;
        }
        i -= 1;
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
          localObject2 = a(localMessage);
        }
        localMessage.lastMsg = ((MessageRecord)localObject2);
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a(paramInt).a(paramString, paramInt, null);
    }
    return localObject1;
  }
  
  public List<RecentBaseData> b()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    ArrayList localArrayList = null;
    Object localObject3 = localEntityManager.rawQuery(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    Object localObject1 = localArrayList;
    if (localObject3 != null)
    {
      localObject1 = localArrayList;
      if (((List)localObject3).size() > 0)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(true);
        HashMap localHashMap = new HashMap();
        localObject3 = ((List)localObject3).iterator();
        int i;
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
            i = MsgProxyUtils.a((String)localObject1);
            localObject4 = a(i).a((String)localObject1, localEntityManager);
            if ((localObject4 != null) && (((Message)localObject4).frienduin != null))
            {
              String str = ((Message)localObject4).frienduin;
              if (((String)localObject1).startsWith("mr_friend_"))
              {
                localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, false);
                bool1 = true;
              }
              else if (((String)localObject1).startsWith("mr_troop_"))
              {
                localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, false);
                bool1 = true;
                i = 1;
              }
              else if (((String)localObject1).startsWith("mr_discusssion_"))
              {
                localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
                bool1 = true;
                i = 3000;
              }
              else
              {
                localObject1 = null;
              }
              a(localHashMap, bool1, i, (Message)localObject4, str, (String)localObject1);
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
              i = 0;
            } else {
              i = 1;
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
            if ((i != 0) && (!localArrayList.contains(localObject1)) && (l1 > 10000L)) {
              localArrayList.add(localObject1);
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public List<ChatMessage> b(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1L);
  }
  
  public List<ChatMessage> b(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramString = b(paramString, paramInt1);
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = paramString.size();
      }
      paramInt2 = 0;
      Iterator localIterator = paramString.iterator();
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
    for (;;)
    {
      throw paramString;
    }
  }
  
  /* Error */
  public List<MessageRecord> b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 173	com/tencent/mobileqq/app/QQAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   7: astore 7
    //   9: new 419	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 420	java/util/ArrayList:<init>	()V
    //   16: astore 5
    //   18: aload_0
    //   19: getfield 44	com/tencent/imcore/message/QQMessageFacade:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: invokevirtual 662	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   25: invokevirtual 975	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
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
    //   41: invokevirtual 441	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_1
    //   45: aload_1
    //   46: astore 4
    //   48: aload_1
    //   49: astore_3
    //   50: aload 6
    //   52: ldc 243
    //   54: aload_2
    //   55: aload_1
    //   56: invokevirtual 447	com/tencent/mobileqq/persistence/EntityManager:cursor2List	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Ljava/util/List;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +29 -> 90
    //   64: aload_1
    //   65: astore 4
    //   67: aload_1
    //   68: astore_3
    //   69: aload_2
    //   70: invokeinterface 136 1 0
    //   75: ifle +15 -> 90
    //   78: aload_1
    //   79: astore 4
    //   81: aload_1
    //   82: astore_3
    //   83: aload 5
    //   85: aload_2
    //   86: invokevirtual 451	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   89: pop
    //   90: aload_1
    //   91: ifnull +30 -> 121
    //   94: goto +21 -> 115
    //   97: astore_1
    //   98: goto +26 -> 124
    //   101: astore_1
    //   102: aload_3
    //   103: astore 4
    //   105: aload_1
    //   106: invokevirtual 454	java/lang/Exception:printStackTrace	()V
    //   109: aload_3
    //   110: ifnull +11 -> 121
    //   113: aload_3
    //   114: astore_1
    //   115: aload_1
    //   116: invokeinterface 459 1 0
    //   121: aload 5
    //   123: areturn
    //   124: aload 4
    //   126: ifnull +10 -> 136
    //   129: aload 4
    //   131: invokeinterface 459 1 0
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	QQMessageFacade
    //   0	138	1	paramString1	String
    //   0	138	2	paramString2	String
    //   31	83	3	str1	String
    //   33	97	4	str2	String
    //   16	106	5	localArrayList	ArrayList
    //   28	23	6	localEntityManager	EntityManager
    //   7	29	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   35	45	97	finally
    //   50	60	97	finally
    //   69	78	97	finally
    //   83	90	97	finally
    //   105	109	97	finally
    //   35	45	101	java/lang/Exception
    //   50	60	101	java/lang/Exception
    //   69	78	101	java/lang/Exception
    //   83	90	101	java/lang/Exception
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(4001).b(String.valueOf(AppConstants.RECOMMEND_TROOP_UIN), 4001);
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt);
      if (a(4001).a(paramInt) > 0)
      {
        setChanged();
        localObject = new RecentUser();
        ((RecentUser)localObject).uin = String.valueOf(AppConstants.TROOP_NOTIFICATION_UIN);
        notifyObservers(localObject);
      }
    }
  }
  
  public void b(Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMsgnotifyMsgNotifyManager.a(paramMessage);
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
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1052);
    localMessageRecord.msg = paramString;
    localMessageRecord.frienduin = AppConstants.BABY_Q_UIN;
    localMessageRecord.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageRecord.time = MessageCache.a();
    localMessageRecord.msgseq = ((int)localMessageRecord.time);
    localMessageRecord.msgUid = MessageUtils.a(MessageUtils.a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(localMessageRecord, null, true);
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    b(paramString, paramInt, paramLong, true);
  }
  
  public void b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = b(paramString, paramInt, paramLong);
    ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.b((MessageRecord)localObject);
    if (a(paramInt).b(paramString, paramInt, paramLong) == 2) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, paramInt, (MessageRecord)localObject);
    }
    if (!paramBoolean) {
      return;
    }
    if (localObject != null)
    {
      if (!a().b(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop)) {
        return;
      }
      paramBoolean = false;
      if ((localObject instanceof MessageForLongMsg)) {
        paramBoolean = UinTypeUtil.a((MessageRecord)localObject, getLastMessage(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop));
      } else if (a((MessageRecord)localObject)) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        if (UinTypeUtil.h(((MessageRecord)localObject).istroop))
        {
          a(((MessageRecord)localObject).istroop).c((MessageRecord)localObject);
          return;
        }
        a(((MessageRecord)localObject).istroop).d((MessageRecord)localObject);
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
    return HiddenChatHelper.a(paramConversationInfo.uin, paramConversationInfo.type, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public int c()
  {
    int i = UnreadCountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 10);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unread count = ");
      localStringBuilder.append(i);
      QLog.d("MiniUnreadMsgsNum", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      localObject1 = (MessageForShortVideo)paramMessageRecord;
      if (!((MessageForShortVideo)localObject1).isSendFromLocal()) {
        AioVideoTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
      } else {
        AioVideoTransFileController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
      }
      ShortVideoUtils.deleteCacheFileByMsg((MessageForShortVideo)localObject1);
    }
    if (!paramMessageRecord.isSendFromLocal()) {
      return;
    }
    Object localObject1 = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    ArrayList localArrayList = new ArrayList();
    boolean bool = paramMessageRecord instanceof MessageForMixedMsg;
    int k = 0;
    int j;
    int i;
    Object localObject2;
    if (bool)
    {
      paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
      j = paramMessageRecord.msgElemList.size();
      i = 0;
      while (i < j)
      {
        localObject2 = (MessageRecord)paramMessageRecord.msgElemList.get(i);
        if ((localObject2 instanceof MessageForPic)) {
          localArrayList.add((MessageForPic)localObject2);
        }
        i += 1;
      }
    }
    if ((paramMessageRecord instanceof MessageForLongMsg))
    {
      paramMessageRecord = (MessageForLongMsg)paramMessageRecord;
      int m = paramMessageRecord.longMsgFragmentList.size();
      i = 0;
      while (i < m)
      {
        localObject2 = (MessageRecord)paramMessageRecord.longMsgFragmentList.get(i);
        if ((localObject2 instanceof MessageForPic))
        {
          localArrayList.add((MessageForPic)localObject2);
        }
        else if ((localObject2 instanceof MessageForMixedMsg))
        {
          localObject2 = (MessageForMixedMsg)localObject2;
          int n = ((MessageForMixedMsg)localObject2).msgElemList.size();
          j = 0;
          while (j < n)
          {
            MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject2).msgElemList.get(j);
            if ((localMessageRecord instanceof MessageForPic)) {
              localArrayList.add((MessageForPic)localMessageRecord);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    if ((paramMessageRecord instanceof MessageForPic))
    {
      localArrayList.add((MessageForPic)paramMessageRecord);
      j = localArrayList.size();
      i = k;
      while (i < j)
      {
        paramMessageRecord = (MessageForPic)localArrayList.get(i);
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
        i += 1;
      }
    }
  }
  
  public void c(List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "setChatMsgList");
    }
  }
  
  public boolean c(ConversationInfo paramConversationInfo)
  {
    return FriendsStatusUtil.a(paramConversationInfo.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public int d()
  {
    return UnreadCountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 7);
  }
  
  public void d(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (!a(paramMessageRecord.istroop).b(paramMessageRecord))
    {
      if (paramMessageRecord.msgtype == -2005)
      {
        a((MessageForFile)paramMessageRecord);
        return;
      }
      if ((paramMessageRecord.msgtype == -2057) && (paramMessageRecord.istroop == 1)) {
        ((TroopStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_STORY_MANAGER)).a(paramMessageRecord);
      }
      a(paramMessageRecord.istroop).e(paramMessageRecord);
    }
  }
  
  public void d(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void d(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
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
        a((MessageRecord)paramList.get(paramList.size() - 1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        return;
      }
      finally
      {
        localEntityTransaction.end();
      }
    }
  }
  
  public boolean d(String paramString, int paramInt)
  {
    return e(paramString, paramInt);
  }
  
  public int e()
  {
    return UnreadCountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 9);
  }
  
  public void e()
  {
    ThreadManager.post(new QQMessageFacade.1(this), 10, null, false);
  }
  
  public void e(MessageRecord paramMessageRecord)
  {
    a(paramMessageRecord.istroop).a(paramMessageRecord);
  }
  
  public void e(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramString.length() < 5) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager != null) && (paramString != null) && (paramString.length() >= 5)) {
        this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
      }
    }
  }
  
  public boolean e(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().b(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public boolean f(String paramString, int paramInt)
  {
    List localList = a(paramString, paramInt);
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
          if (((MessageRecord)localObject).shmsgseq > Math.max(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramString, paramInt)) + 1L) {
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
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramString));
            localStringBuilder.append(", delLastSeq = ");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramString, paramInt));
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
  
  public void g()
  {
    a(0).a();
    a(3000).a();
    a(1).a();
    a(1026).a();
  }
  
  public boolean g(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      DraftTextManager localDraftTextManager = this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
      if (localDraftTextManager != null) {
        return localDraftTextManager.a(paramString, paramInt);
      }
    }
    return false;
  }
  
  public DraftSummaryInfo getDraftSummaryInfo(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      DraftTextManager localDraftTextManager = this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
      if (localDraftTextManager != null) {
        return localDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
      }
    }
    return null;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentImcoreMessageFacadeQQMessageFacadeRefresher.a();
  }
  
  public void i()
  {
    List localList = a(1032).a(AppConstants.CONFESS_UIN, 1032);
    HashSet localHashSet = new HashSet(localList.size());
    int i = 0;
    while (i < localList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      int j;
      if (localMessageRecord.isSelfConfessor()) {
        j = 1033;
      } else {
        j = 1034;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(localMessageRecord.senderuin);
      localObject = ((StringBuilder)localObject).toString();
      if (!localHashSet.contains(localObject))
      {
        localHashSet.add(localObject);
        a(localMessageRecord.senderuin, j, true, true);
      }
      i += 1;
    }
    ConfessMsgUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
  }
  
  public void j()
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    Object localObject = new RecentUser().getTableName();
    String str1 = new TroopAssistantData().getTableName();
    String str2 = new PubAccountAssistantData().getTableName();
    String str3 = new TroopBarData().getTableName();
    String str4 = new NeedHandleUserData().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.delete((String)localObject, null, null);
    localSQLiteDatabase.delete(str1, null, null);
    localSQLiteDatabase.delete(str2, null, null);
    localSQLiteDatabase.delete(str4, null, null);
    localSQLiteDatabase.delete(str3, null, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsg();
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    localObject = (IRecommendTroopService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRecommendTroopService.class, "");
    if (localObject != null)
    {
      ((IRecommendTroopService)localObject).clearRecommendTroop();
      ((IRecommendTroopService)localObject).updateDBStatsus(1);
    }
    TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    c();
    localRecentUserProxy.a();
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentImcoreMessageFacadeQQMessageFacadeRefresher.b();
  }
  
  public void l()
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().f();
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
          if (((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(((RevokeMsgInfo)localArrayList.get(0)).jdField_a_of_type_JavaLangString) != null) {}
        }
        else if (i == 0)
        {
          RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)localArrayList.get(0);
          String str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          String str2 = localRevokeMsgInfo.b;
          String str1 = str2;
          if (TextUtils.equals(str3, str2)) {
            str1 = localRevokeMsgInfo.jdField_a_of_type_JavaLangString;
          }
          if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str1)) {
            continue;
          }
        }
        a(localArrayList, true);
      }
    }
    localConcurrentHashMap.clear();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
    if (localObject != null) {
      ((DraftTextManager)localObject).a();
    }
    this.jdField_a_of_type_ComTencentImcoreMessageFacadeQQMessageFacadeRefresher.d();
    localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageTinyIdCache;
    if (localObject != null) {
      ((TinyIdCache)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade
 * JD-Core Version:    0.7.0.1
 */