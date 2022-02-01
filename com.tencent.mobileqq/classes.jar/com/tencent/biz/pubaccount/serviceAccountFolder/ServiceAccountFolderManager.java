package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.repo.feeds.api.IRIJSubscriptionFeeds;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeedItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ServiceAccountFolderManager
{
  private static ServiceAccountFolderManager a = new ServiceAccountFolderManager();
  private static Set<String> b = new HashSet();
  private static Set<String> c = new HashSet();
  private static boolean d = false;
  private String e;
  private final Object f = new Object();
  private List<ServiceAccountFolderFeed> g = new ArrayList();
  private List<ServiceAccountFolderFeed> h = new ArrayList();
  private HashMap<String, ServiceAccountFolderFeed> i = new HashMap();
  private final HashMap<String, Integer> j = new HashMap();
  private ServiceAccountFolderManager.FeedComparator k = new ServiceAccountFolderManager.FeedComparator(this);
  private boolean l = false;
  private long m = 0L;
  private String n = "";
  private long o = 0L;
  private int p = 0;
  private CharSequence q = "";
  private String r = "";
  private boolean s = false;
  private long t = 0L;
  private long u = 0L;
  private long v = 0L;
  private boolean w = false;
  private String x;
  private final MessageObserver y = new ServiceAccountFolderManager.1(this);
  
  static
  {
    b.add(new String("2171946401"));
  }
  
  private int a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountBelongInfo->empty puin!");
      }
      return 0;
    }
    synchronized (this.j)
    {
      Integer localInteger = Integer.valueOf((paramInt1 << 2) + paramInt2);
      if (this.j.containsKey(paramString))
      {
        if ((this.j.get(paramString) != null) && (localInteger.equals(this.j.get(paramString)))) {
          return 0;
        }
        this.j.put(paramString, localInteger);
        return 2;
      }
      this.j.put(paramString, localInteger);
      return 1;
    }
  }
  
  private static int a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    IPublicAccountDetail localIPublicAccountDetail;
    Object localObject2;
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIPublicAccountDetail = null;
      try
      {
        localObject2 = (IPublicAccountDataManager)paramAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all");
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        localObject2 = null;
      }
      if ((localObject2 != null) && ((!RecentParcelUtil.a((BaseQQAppInterface)paramAppRuntime)) || (Thread.currentThread() != ThreadManager.getRecentThreadLooper().getThread()))) {}
    }
    try
    {
      localObject1 = (PublicAccountInfo)((IPublicAccountDataManager)localObject2).findPublicAccountInfo(paramString, true);
    }
    catch (Throwable localThrowable2)
    {
      Object localObject1;
      label87:
      Object localObject3;
      int i1;
      long l1;
      int i2;
      int i3;
      break label87;
    }
    localObject1 = (PublicAccountInfo)((IPublicAccountDataManager)localObject2).findPublicAccountInfoCache(paramString);
    break label116;
    localObject1 = (PublicAccountInfo)((IPublicAccountDataManager)localObject2).findPublicAccountInfoCache(paramString);
    label116:
    localObject3 = localObject1;
    if (localObject1 == null)
    {
      localIPublicAccountDetail = ((IPublicAccountDataManager)localObject2).findAccountDetailInfoCache(paramString);
      localObject3 = localObject1;
      break label145;
      localObject3 = null;
    }
    label145:
    if ((localObject3 == null) && (localIPublicAccountDetail == null))
    {
      if (b(paramString)) {
        return 0;
      }
      if ((paramAppRuntime != null) && (a(paramAppRuntime, paramString, (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)))) {
        return 0;
      }
      localObject1 = ((IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, "")).getLastMessage(paramString, 1008);
      if (localObject1 != null)
      {
        if (((MessageRecord)localObject1).istroop != 1008)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" getPublicAccountFolderType error, not UIN_TYPE_PUBLIC_ACCOUNT, msg info is ");
          ((StringBuilder)localObject2).append(((MessageRecord)localObject1).toString());
          ((StringBuilder)localObject2).append(" puin = ");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d("ServiceAccountFolderManager", 1, ((StringBuilder)localObject2).toString());
          localObject2 = new HashMap();
          if (paramAppRuntime != null) {
            ((HashMap)localObject2).put("self_uin", paramAppRuntime.getCurrentAccountUin());
          }
          ((HashMap)localObject2).put("inValid_uin", paramString);
          ((HashMap)localObject2).put("inValid_msg_troop", String.valueOf(((MessageRecord)localObject1).istroop));
          ((HashMap)localObject2).put("inValid_msg_content", ((MessageRecord)localObject1).toString());
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString, "ServiceAccountFolderManager_InValid_Msg", false, 1L, 0L, (HashMap)localObject2, null);
          return 0;
        }
        if (PublicAccountAdUtil.a((MessageRecord)localObject1)) {
          return 0;
        }
        paramAppRuntime = ((MessageRecord)localObject1).getExtInfoFromExtStr("inter_num");
        if ((!TextUtils.isEmpty(paramAppRuntime)) && (paramAppRuntime.equals("1")))
        {
          i1 = a().a(paramString, 2, 2);
          if (i1 > 0)
          {
            paramAppRuntime = new StringBuilder(128);
            paramAppRuntime.append("updateServiceAccountBelongInfo(");
            paramAppRuntime.append(i1);
            paramAppRuntime.append(")->getPublicAccountFolderType->puin:");
            paramAppRuntime.append(paramString);
            paramAppRuntime.append(", folder type:");
            paramAppRuntime.append(2);
            paramAppRuntime.append(", inter_num:1");
            QLog.d("ServiceAccountFolderManager", 1, paramAppRuntime.toString());
          }
          return 2;
        }
        if ((!TextUtils.isEmpty(paramAppRuntime)) && (paramAppRuntime.equals("2")))
        {
          i1 = a().a(paramString, 3, 2);
          if (i1 > 0)
          {
            paramAppRuntime = new StringBuilder(128);
            paramAppRuntime.append("updateServiceAccountBelongInfo(");
            paramAppRuntime.append(i1);
            paramAppRuntime.append(")->getPublicAccountFolderType->puin:");
            paramAppRuntime.append(paramString);
            paramAppRuntime.append(", folder type:");
            paramAppRuntime.append(3);
            paramAppRuntime.append(", inter_num:2");
            QLog.d("ServiceAccountFolderManager", 1, paramAppRuntime.toString());
          }
          return 3;
        }
      }
      i1 = a().a(paramString, 1, 2);
      if (i1 > 0)
      {
        paramAppRuntime = new StringBuilder(150);
        paramAppRuntime.append("updateServiceAccountBelongInfo(");
        paramAppRuntime.append(i1);
        paramAppRuntime.append(")->getPublicAccountFolderType->puin:");
        paramAppRuntime.append(paramString);
        paramAppRuntime.append(", folder type:");
        paramAppRuntime.append(1);
        paramAppRuntime.append(", no info to judge, default service folder!");
        QLog.d("ServiceAccountFolderManager", 1, paramAppRuntime.toString());
      }
      return 1;
    }
    if (localObject3 != null) {
      l1 = localObject3.accountFlag2;
    } else {
      l1 = localIPublicAccountDetail.getAccountFlag2();
    }
    i1 = (int)((0x7800 & l1) >> 11);
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            i1 = -1;
          } else {
            i1 = 3;
          }
        }
        else {
          i1 = 0;
        }
      }
      else {
        i1 = 1;
      }
    }
    else {
      i1 = 2;
    }
    if (localObject3 != null) {
      i2 = localObject3.accountFlag;
    } else {
      i2 = localIPublicAccountDetail.getAccountFlag();
    }
    i3 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(i2);
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isSubscript(i2, l1)) {
      i2 = 2;
    } else if (i3 == -5) {
      i2 = 3;
    } else {
      i2 = 1;
    }
    if ((i1 == 0) && (i2 == 2)) {}
    while ((i1 == 2) && (i2 == 1))
    {
      i3 = 1;
      break;
    }
    i3 = i1;
    if (i1 == -1) {
      i3 = i2;
    }
    i1 = a().a(paramString, i3, 1);
    if (i1 > 0)
    {
      paramAppRuntime = new StringBuilder(256);
      paramAppRuntime.append("updateServiceAccountBelongInfo(");
      paramAppRuntime.append(i1);
      paramAppRuntime.append(")->getPublicAccountFolderType->puin:");
      paramAppRuntime.append(paramString);
      paramAppRuntime.append(", folder type:");
      paramAppRuntime.append(i3);
      if (localObject3 != null)
      {
        paramAppRuntime.append(", info accountFlag:");
        paramAppRuntime.append(localObject3.accountFlag);
        paramAppRuntime.append(", info accountFlag2:");
        paramAppRuntime.append(localObject3.accountFlag2);
      }
      if (localIPublicAccountDetail != null)
      {
        paramAppRuntime.append(", detail accountFlag:");
        paramAppRuntime.append(localIPublicAccountDetail.getAccountData());
        paramAppRuntime.append(", detail accountFlag2:");
        paramAppRuntime.append(localIPublicAccountDetail.getAccountFlag2());
      }
      QLog.d("ServiceAccountFolderManager", 1, paramAppRuntime.toString());
    }
    return i3;
    i1 = a().a(paramString, 1, 0);
    if (i1 > 0)
    {
      paramAppRuntime = new StringBuilder(150);
      paramAppRuntime.append("updateServiceAccountBelongInfo(");
      paramAppRuntime.append(i1);
      paramAppRuntime.append(")->getPublicAccountFolderType->");
      paramAppRuntime.append(", folder type:");
      paramAppRuntime.append(1);
      paramAppRuntime.append(", error param, default service folder!");
      QLog.d("ServiceAccountFolderManager", 1, paramAppRuntime.toString());
    }
    return 1;
  }
  
  public static ServiceAccountFolderManager a()
  {
    if (a == null) {
      try
      {
        a = new ServiceAccountFolderManager();
      }
      finally {}
    }
    return a;
  }
  
  public static String a(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", String.valueOf(paramInt));
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static void a(Set<String> paramSet)
  {
    c = paramSet;
  }
  
  public static void a(boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString)
  {
    boolean bool = false;
    if (a(paramAppInterface, paramString, false) == 2) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramQQAppInterface, paramString, true) == 0;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    if (b(paramString)) {
      return false;
    }
    return a(paramAppRuntime, paramString, false) == 1;
  }
  
  private static boolean a(AppRuntime paramAppRuntime, String paramString, FriendsManager paramFriendsManager)
  {
    boolean bool2 = false;
    if (paramFriendsManager == null) {
      return false;
    }
    paramFriendsManager = paramFriendsManager.c(paramString);
    boolean bool1 = bool2;
    if (paramFriendsManager != null)
    {
      bool1 = bool2;
      if (paramFriendsManager.isFriend())
      {
        paramFriendsManager = new StringBuilder();
        paramFriendsManager.append(" getPublicAccountFolderType error, is UIN_TYPE_PUBLIC_ACCOUNT, but is friend relation  puin = ");
        paramFriendsManager.append(paramString);
        paramFriendsManager = paramFriendsManager.toString();
        bool1 = true;
        QLog.d("ServiceAccountFolderManager", 1, paramFriendsManager);
        paramFriendsManager = new HashMap();
        paramFriendsManager.put("self_uin", paramAppRuntime.getCurrentAccountUin());
        paramFriendsManager.put("inValid_uin", paramString);
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString, "ServiceAccountFolderManager_InValid_puin", false, 1L, 0L, paramFriendsManager, null);
      }
    }
    return bool1;
  }
  
  public static String b(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getMessages(paramString, 1008, 15);
    if ((paramAppInterface != null) && (paramAppInterface.size() != 0))
    {
      int i1 = paramAppInterface.size() - 1;
      while (i1 >= 0)
      {
        Object localObject = (MessageRecord)paramAppInterface.get(i1);
        if (!((MessageRecord)localObject).isread)
        {
          localObject = ((MessageRecord)localObject).getExtInfoFromExtStr("public_account_msg_extra_info_type");
          if (("1".equals(localObject)) || ("2".equals(localObject))) {
            break;
          }
        }
        i1 -= 1;
      }
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("getLastExtraInfo->puin:");
        paramAppInterface.append(paramString);
        paramAppInterface.append(", extraInfo:");
        paramAppInterface.append("");
        QLog.d("ServiceAccountFolderManager", 2, paramAppInterface.toString());
      }
      return "";
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("getLastExtraInfo->puin:");
      paramAppInterface.append(paramString);
      paramAppInterface.append(" no message list");
      QLog.d("ServiceAccountFolderManager", 2, paramAppInterface.toString());
    }
    return "";
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (b(paramString))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("isBelongServiceAccountFolder->puin:");
        paramQQAppInterface.append(paramString);
        paramQQAppInterface.append(", inOutFolderWhiteList!");
        QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
      }
      return false;
    }
    int i1 = a(paramQQAppInterface, paramString, true);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("isBelongServiceAccountFolder->puin:");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append(", type:");
      paramQQAppInterface.append(i1);
      QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
    }
    return i1 == 1;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return b.contains(paramString);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    int i1 = a(paramQQAppInterface, paramString, false);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("isBelongEcShopFolder->puin:");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append(", type:");
      paramQQAppInterface.append(i1);
      QLog.d("EcShopAssistantManager", 2, paramQQAppInterface.toString());
    }
    if (i1 == 3) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean c(String paramString)
  {
    return (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) && (d(paramString));
  }
  
  public static boolean d(String paramString)
  {
    Set localSet = c;
    return (localSet == null) || (!localSet.contains(paramString));
  }
  
  private void e(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateMsgState->puin:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" begin update");
      QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (IPublicAccountDataManager)((QQAppInterface)localObject1).getRuntimeService(IPublicAccountDataManager.class, "all");
    if ((localObject2 != null) && ((PublicAccountInfo)((IPublicAccountDataManager)localObject2).findPublicAccountInfoCache(paramString) == null) && (((IPublicAccountDataManager)localObject2).findAccountDetailInfoCache(paramString) == null)) {
      return;
    }
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType((AppInterface)localObject1, paramString) == -7)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateMsgState->puin:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" is EQQ, return!");
        QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateMsgState->puin:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" do update");
      QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject2).toString());
    }
    c((AppInterface)localObject1, paramString);
  }
  
  public static Drawable f()
  {
    Drawable localDrawable = BaseApplicationImpl.sApplication.getResources().getDrawable(g());
    Object localObject = localDrawable;
    if (!TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon())) {
      localObject = URLDrawable.getDrawable(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon(), localDrawable, localDrawable);
    }
    return localObject;
  }
  
  public static int g()
  {
    return 2130841182;
  }
  
  public static String h(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName())) {
      return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountTitle();
    }
    return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName();
  }
  
  public static boolean n()
  {
    return d;
  }
  
  public long a(ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    long l2 = 0L;
    if (paramServiceAccountFolderFeed == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFeedMsgId->empty feed");
      }
      return 0L;
    }
    paramServiceAccountFolderFeed = paramServiceAccountFolderFeed.j;
    long l1 = l2;
    if (paramServiceAccountFolderFeed != null)
    {
      l1 = l2;
      if ((paramServiceAccountFolderFeed instanceof MessageForStructing))
      {
        MessageForStructing localMessageForStructing = (MessageForStructing)paramServiceAccountFolderFeed;
        AbsStructMsg localAbsStructMsg = localMessageForStructing.structingMsg;
        paramServiceAccountFolderFeed = localAbsStructMsg;
        if (localAbsStructMsg == null) {
          paramServiceAccountFolderFeed = StructMsgFactory.a(localMessageForStructing.msgData);
        }
        l1 = l2;
        if (paramServiceAccountFolderFeed != null) {
          l1 = paramServiceAccountFolderFeed.msgId;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramServiceAccountFolderFeed = new StringBuilder();
      paramServiceAccountFolderFeed.append("getFeedMsgId->msgId:");
      paramServiceAccountFolderFeed.append(l1);
      QLog.d("ServiceAccountFolderManager", 2, paramServiceAccountFolderFeed.toString());
    }
    return l1;
  }
  
  public CharSequence a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Message localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).decodeMsg(localMessage);
    paramMessageRecord = new MsgSummary();
    MsgUtils.a(paramAppInterface.getApplication(), paramAppInterface, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
    return paramMessageRecord.a(paramAppInterface.getApplication());
  }
  
  public void a(AppInterface paramAppInterface, IPublicAccountDetail paramIPublicAccountDetail)
  {
    paramIPublicAccountDetail = paramIPublicAccountDetail.getUin();
    if (TextUtils.isEmpty(paramIPublicAccountDetail))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "handleAccountDetailChange->empty uin");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "handleAccountDetailChange->update feed");
    }
    c(paramAppInterface, paramIPublicAccountDetail);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.e)) || (!this.e.equals(paramQQAppInterface.getAccount())))
    {
      Object localObject = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_public_account_with_cuin_");
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      if (localObject != null)
      {
        this.t = ((SharedPreferences)localObject).getLong("service_account_folder_last_read_time", 0L);
        this.u = ((SharedPreferences)localObject).getLong("service_account_folder_last_enter_time", 0L);
        ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderRedCleanAfterEnter(((SharedPreferences)localObject).getBoolean("service_folder_redclean_after_enter", false));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initManager->mFolderLastReadTime:");
          ((StringBuilder)localObject).append(this.t);
          ((StringBuilder)localObject).append(", mFolderLastEnterTime:");
          ((StringBuilder)localObject).append(this.u);
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      this.e = paramQQAppInterface.getAccount();
      this.l = false;
      b(paramQQAppInterface);
      paramQQAppInterface.addObserver(this.y, true);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("initManager->cuin:");
        paramQQAppInterface.append(this.e);
        QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.u = paramLong;
    ThreadManager.executeOnFileThread(new ServiceAccountFolderManager.6(this, paramQQAppInterface));
  }
  
  public void a(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed, boolean paramBoolean)
  {
    if (paramServiceAccountFolderFeed == null) {
      return;
    }
    String str = paramServiceAccountFolderFeed.b;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("deleteServiceAccountFolderFeed->puin:");
      ((StringBuilder)???).append(str);
      ((StringBuilder)???).append(", needRefresh:");
      ((StringBuilder)???).append(paramBoolean);
      QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.f)
    {
      if (this.i.containsKey(str))
      {
        ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)this.i.get(str);
        if (localServiceAccountFolderFeed != null)
        {
          this.g.remove(localServiceAccountFolderFeed);
          this.i.remove(str);
        }
      }
      if (paramServiceAccountFolderFeed.a)
      {
        paramServiceAccountFolderFeed = paramQQAppInterface.getProxyManager().g().c(paramServiceAccountFolderFeed.b, 1008);
        if (paramServiceAccountFolderFeed != null) {
          RecentUtil.a(paramQQAppInterface, paramServiceAccountFolderFeed, -1);
        }
      }
      else
      {
        TroopBarAssistantManager.a().a(str, paramQQAppInterface);
        RecentUtil.b(paramQQAppInterface, str, ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(paramQQAppInterface, str));
        paramQQAppInterface.getMessageFacade().a(str, 1008);
      }
      if (paramBoolean)
      {
        o(paramQQAppInterface);
        q(paramQQAppInterface);
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addMessageToServiceAccountFolder->friend uin:");
        localStringBuilder.append(paramObject.frienduin);
        localStringBuilder.append(", istroop:");
        localStringBuilder.append(paramObject.istroop);
        QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
      }
      if ((paramObject.istroop == 1008) && (b(paramQQAppInterface, paramObject.frienduin)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "addMessageToServiceAccountFolder->go to update feed");
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
          ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.3(this, paramQQAppInterface, paramObject));
        } else {
          c(paramQQAppInterface, paramObject.frienduin);
        }
        if (!paramObject.isSendFromLocal()) {
          b(paramQQAppInterface, 0L);
        }
      }
      else
      {
        paramQQAppInterface = paramQQAppInterface.getHandler(ServiceAccountFolderActivity.class);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.sendEmptyMessage(102);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "addMessageToServiceAccountFolder->msg not belong serviceAccountFolder");
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("updateDraft->puin:");
      paramString2.append(paramString1);
      QLog.d("ServiceAccountFolderManager", 2, paramString2.toString());
    }
    c(paramQQAppInterface, paramString1);
  }
  
  public void a(List<ServiceAccountFolderFeed> paramList)
  {
    synchronized (this.f)
    {
      this.h.clear();
      if (paramList != null) {
        this.h.addAll(paramList);
      }
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "containsFeedWithUin->empty uin, return false");
      }
      return false;
    }
    synchronized (this.f)
    {
      boolean bool = this.i.containsKey(paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("containsFeedWithUin->uin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", return ");
        localStringBuilder.append(bool);
        QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
      }
      return bool;
    }
  }
  
  public List<ServiceAccountFolderFeed> b()
  {
    synchronized (this.f)
    {
      if (this.g == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getDataList->empty DataList");
        }
        return null;
      }
      try
      {
        List localList = (List)((ArrayList)this.g).clone();
        if (QLog.isColorLevel())
        {
          int i1 = localList.size();
          localStringBuilder = new StringBuilder("getDataList->");
          localStringBuilder.append("size:");
          localStringBuilder.append(i1);
          localStringBuilder.append(", content:[");
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            localStringBuilder.append(((ServiceAccountFolderFeed)localIterator.next()).b);
            localStringBuilder.append(",");
          }
          if (i1 > 0) {
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          }
          localStringBuilder.append("]");
          QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
        }
        return localList;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getDataList->exception:");
          localStringBuilder.append(localException.getStackTrace());
          QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
        }
        return null;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.2(this, paramQQAppInterface));
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("refreshAndUpdate->cuin:");
        paramQQAppInterface.append(this.e);
        paramQQAppInterface.append(", throw to sub thread!");
        QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshAndUpdate->cuin:");
        localStringBuilder.append(this.e);
        QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
      }
      c(paramQQAppInterface);
      q(paramQQAppInterface);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.t = paramLong;
    this.u = paramLong;
    ThreadManager.executeOnFileThread(new ServiceAccountFolderManager.7(this, paramQQAppInterface));
  }
  
  public void b(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed, boolean paramBoolean)
  {
    if (paramServiceAccountFolderFeed == null) {
      return;
    }
    this.p -= paramServiceAccountFolderFeed.d;
    if (this.p < 0) {
      this.p = 0;
    }
    paramServiceAccountFolderFeed.d = 0;
    paramServiceAccountFolderFeed = paramServiceAccountFolderFeed.b;
    RecentUtil.b(paramQQAppInterface, paramServiceAccountFolderFeed, 1008);
    paramQQAppInterface.getMessageFacade().a(paramServiceAccountFolderFeed, 1008);
    paramQQAppInterface.getConversationFacade().a(paramServiceAccountFolderFeed, 1008, true);
    c(paramQQAppInterface, paramServiceAccountFolderFeed);
    if (paramBoolean) {
      p(paramQQAppInterface);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("clearServiceAccountFolderFeedUnreadNum->uin:");
      paramQQAppInterface.append(paramServiceAccountFolderFeed);
      paramQQAppInterface.append(", needRefresh:");
      paramQQAppInterface.append(paramBoolean);
      QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
    }
  }
  
  public String c()
  {
    synchronized (this.f)
    {
      if ((this.g != null) && (this.g.size() > 0))
      {
        Object localObject2 = (ServiceAccountFolderFeed)this.g.get(0);
        if (localObject2 != null)
        {
          localObject2 = ((ServiceAccountFolderFeed)localObject2).j;
          if (localObject2 != null)
          {
            localObject2 = ((MessageRecord)localObject2).frienduin;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getFolderLastMsgUin->msgUin:");
              localStringBuilder.append((String)localObject2);
              QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
            }
            return localObject2;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderLastMsgUin->msgUin:0");
      }
      return "0";
    }
  }
  
  public List<ServiceAccountFolderFeed> c(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "refreshDataList!");
    }
    if (paramQQAppInterface == null) {
      return this.g;
    }
    Object localObject1;
    if (!paramQQAppInterface.getAccount().equals(this.e))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("refreshDataList->new cuin:");
        ((StringBuilder)localObject1).append(paramQQAppInterface.getAccount());
        ((StringBuilder)localObject1).append(", old cuin:");
        ((StringBuilder)localObject1).append(this.e);
        QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
      }
      a(paramQQAppInterface);
    }
    label893:
    synchronized (this.f)
    {
      this.g.clear();
      this.i.clear();
      localObject1 = TroopBarAssistantManager.a().h(paramQQAppInterface);
      Object localObject4 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      Object localObject5;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopBarData)((Iterator)localObject1).next();
        if (b(paramQQAppInterface, ((TroopBarData)localObject2).mUin))
        {
          localObject2 = ((IRIJSubscriptionFeeds)QRoute.api(IRIJSubscriptionFeeds.class)).convertMsgToSubscriptionFeed(paramQQAppInterface.getApplicationContext(), ((TroopBarData)localObject2).mLatestMessage, ((TroopBarData)localObject2).mUin, ((TroopBarData)localObject2).mLastMsgTime, ((TroopBarData)localObject2).mLastDraftTime);
          if (localObject2 != null)
          {
            if ((((SubscriptionFeed)localObject2).e != null) && (((SubscriptionFeed)localObject2).e.size() > 0))
            {
              localObject5 = (SubscriptionFeedItem)((SubscriptionFeed)localObject2).e.get(0);
              if ((TextUtils.isEmpty(((SubscriptionFeedItem)localObject5).c)) && (!TextUtils.isEmpty(((SubscriptionFeedItem)localObject5).d))) {
                ((SubscriptionFeedItem)localObject5).c = ((SubscriptionFeedItem)localObject5).d;
              }
            }
            ((List)localObject4).add(localObject2);
          }
        }
      }
      else
      {
        int i1 = ((List)localObject4).size();
        localObject2 = null;
        if (i1 > 0)
        {
          localObject5 = ((List)localObject4).iterator();
          if (!QLog.isColorLevel()) {
            break label893;
          }
          localObject1 = new StringBuilder("refreshDataList->SubscriptionFeedList size:");
          ((StringBuilder)localObject1).append(((List)localObject4).size());
          ((StringBuilder)localObject1).append(", content:{");
          while (((Iterator)localObject5).hasNext())
          {
            localObject4 = (SubscriptionFeed)((Iterator)localObject5).next();
            if ((QLog.isColorLevel()) && (localObject1 != null))
            {
              ((StringBuilder)localObject1).append("[");
              ((StringBuilder)localObject1).append(((SubscriptionFeed)localObject4).c);
              ((StringBuilder)localObject1).append(", ");
              ((StringBuilder)localObject1).append(((SubscriptionFeed)localObject4).a);
              ((StringBuilder)localObject1).append("]");
            }
            if (!this.i.containsKey(((SubscriptionFeed)localObject4).c))
            {
              ServiceAccountFolderFeed localServiceAccountFolderFeed = ServiceAccountFolderFeed.a(paramQQAppInterface, (SubscriptionFeed)localObject4);
              if (localServiceAccountFolderFeed.m)
              {
                this.g.add(localServiceAccountFolderFeed);
                this.i.put(((SubscriptionFeed)localObject4).c, localServiceAccountFolderFeed);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            ((StringBuilder)localObject1).append("}");
            QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ServiceAccountFolderManager", 2, "refreshDataList->empty SubscriptionFeedList!");
        }
        localObject5 = paramQQAppInterface.getProxyManager().g().a(false, false);
        if ((localObject5 != null) && (((List)localObject5).size() > 0))
        {
          localObject4 = ((List)localObject5).iterator();
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder("refreshDataList->RecentList size:");
            ((StringBuilder)localObject1).append(((List)localObject5).size());
            ((StringBuilder)localObject1).append(", content:{");
          }
          while (((Iterator)localObject4).hasNext())
          {
            localObject2 = (RecentUser)((Iterator)localObject4).next();
            if ((QLog.isColorLevel()) && (localObject1 != null))
            {
              ((StringBuilder)localObject1).append("[");
              ((StringBuilder)localObject1).append(((RecentUser)localObject2).uin);
              ((StringBuilder)localObject1).append(", ");
              ((StringBuilder)localObject1).append(((RecentUser)localObject2).getType());
              ((StringBuilder)localObject1).append("]");
            }
            if ((((RecentUser)localObject2).getType() == 1008) && (b(paramQQAppInterface, ((RecentUser)localObject2).uin)) && (!this.i.containsKey(((RecentUser)localObject2).uin)))
            {
              localObject5 = ServiceAccountFolderFeed.a(paramQQAppInterface, (RecentUser)localObject2);
              if ((((ServiceAccountFolderFeed)localObject5).m) && ((!n()) || (!c(((RecentUser)localObject2).uin))))
              {
                this.g.add(localObject5);
                this.i.put(((RecentUser)localObject2).uin, localObject5);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            ((StringBuilder)localObject1).append("}");
            QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ServiceAccountFolderManager", 2, "refreshDataList->empty RecentList!");
        }
        o(paramQQAppInterface);
        return this.g;
      }
    }
  }
  
  public void c(AppInterface paramAppInterface, String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.9(this, paramAppInterface, paramString));
      return;
    }
    for (;;)
    {
      synchronized (this.f)
      {
        ServiceAccountFolderFeed localServiceAccountFolderFeed;
        if (this.i.containsKey(paramString))
        {
          localServiceAccountFolderFeed = (ServiceAccountFolderFeed)this.i.get(paramString);
        }
        else
        {
          localServiceAccountFolderFeed = new ServiceAccountFolderFeed();
          this.g.add(localServiceAccountFolderFeed);
          this.i.put(paramString, localServiceAccountFolderFeed);
        }
        localServiceAccountFolderFeed.b = paramString;
        Object localObject2 = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        int i3 = 1;
        if (localObject2 != null)
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((IPublicAccountDataManager)localObject2).findPublicAccountInfoCache(paramString);
          if (localPublicAccountInfo != null)
          {
            localServiceAccountFolderFeed.h = localPublicAccountInfo.name;
            localServiceAccountFolderFeed.m = localPublicAccountInfo.isVisible();
            localServiceAccountFolderFeed.e = 0;
          }
          else
          {
            localObject2 = ((IPublicAccountDataManager)localObject2).findAccountDetailInfoCache(paramString);
            if (localObject2 != null)
            {
              localServiceAccountFolderFeed.h = ((IPublicAccountDetail)localObject2).getName();
              if (1 != ((IPublicAccountDetail)localObject2).getShowFlag()) {
                break label1110;
              }
              bool = true;
              localServiceAccountFolderFeed.m = bool;
              localServiceAccountFolderFeed.e = 0;
            }
          }
        }
        localServiceAccountFolderFeed.d = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getReadUnreadCount(paramString, 1008);
        i1 = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getPublicAccountConversationRedMask(paramString, 1008);
        if (localServiceAccountFolderFeed.d > 0)
        {
          if ((localServiceAccountFolderFeed.d == 1) && (i1 > 0))
          {
            localServiceAccountFolderFeed.c = 2;
          }
          else
          {
            localServiceAccountFolderFeed.c = 1;
            if (i1 > 0) {
              localServiceAccountFolderFeed.d -= 1;
            }
          }
        }
        else {
          localServiceAccountFolderFeed.c = 0;
        }
        localObject2 = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
        if (localObject2 == null) {
          break label1116;
        }
        localServiceAccountFolderFeed.o = null;
        localServiceAccountFolderFeed.j = ((IMessageFacade)localObject2).getLastMsgForMsgTab(paramString, 1008);
        localObject2 = ((IMessageFacade)localObject2).getDraftSummaryInfo(paramString, 1008);
        if ((localObject2 != null) && (!TextUtils.isEmpty(((DraftSummaryInfo)localObject2).getSummary())))
        {
          if ((localServiceAccountFolderFeed.j != null) && (((DraftSummaryInfo)localObject2).getTime() <= localServiceAccountFolderFeed.j.time))
          {
            localServiceAccountFolderFeed.p = 0;
            localServiceAccountFolderFeed.f = localServiceAccountFolderFeed.j.time;
            localServiceAccountFolderFeed.g = TimeManager.a().a(paramString, localServiceAccountFolderFeed.f);
            localServiceAccountFolderFeed.i = a(paramAppInterface, localServiceAccountFolderFeed.j, false);
            break label1116;
          }
          localServiceAccountFolderFeed.p = 4;
          localServiceAccountFolderFeed.f = ((DraftSummaryInfo)localObject2).getTime();
          localServiceAccountFolderFeed.g = TimeManager.a().a(localServiceAccountFolderFeed.b, ((DraftSummaryInfo)localObject2).getTime());
          localServiceAccountFolderFeed.i = ((DraftSummaryInfo)localObject2).getSummary();
          break label1116;
        }
        if ((localServiceAccountFolderFeed.j != null) && (localServiceAccountFolderFeed.j.time > 0L))
        {
          localServiceAccountFolderFeed.p = 0;
          localServiceAccountFolderFeed.f = localServiceAccountFolderFeed.j.time;
          localServiceAccountFolderFeed.g = TimeManager.a().a(paramString, localServiceAccountFolderFeed.f);
          localServiceAccountFolderFeed.i = a(paramAppInterface, localServiceAccountFolderFeed.j, false);
          break label1116;
        }
        localServiceAccountFolderFeed.p = 0;
        localServiceAccountFolderFeed.f = 0L;
        localServiceAccountFolderFeed.g = null;
        localServiceAccountFolderFeed.i = null;
        i1 = 1;
        localServiceAccountFolderFeed.l = b(paramAppInterface, localServiceAccountFolderFeed.b);
        localServiceAccountFolderFeed.a = true;
        if (TroopBarAssistantManager.a().a((QQAppInterface)paramAppInterface, paramString, 1008)) {
          localServiceAccountFolderFeed.a = false;
        } else if ((localServiceAccountFolderFeed.j != null) && ("1".equals(localServiceAccountFolderFeed.j.getExtInfoFromExtStr("inter_num")))) {
          localServiceAccountFolderFeed.a = false;
        }
        int i2 = i1;
        if (((QQAppInterface)paramAppInterface).getProxyManager() != null)
        {
          i2 = i1;
          if (((QQAppInterface)paramAppInterface).getProxyManager().g() != null)
          {
            localObject2 = ((QQAppInterface)paramAppInterface).getProxyManager().g().b(paramString, 1008);
            i2 = i1;
            if (localObject2 != null)
            {
              localServiceAccountFolderFeed.n = ((RecentUser)localObject2).lastmsgtime;
              i2 = i1;
              if (i1 != 0)
              {
                i2 = i1;
                if (localServiceAccountFolderFeed.n > 0L)
                {
                  localServiceAccountFolderFeed.f = localServiceAccountFolderFeed.n;
                  localServiceAccountFolderFeed.g = TimeManager.a().a(paramString, localServiceAccountFolderFeed.f);
                  localServiceAccountFolderFeed.i = "";
                  i2 = 0;
                }
              }
            }
          }
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateServiceAccountFolderFeed->");
          ((StringBuilder)localObject2).append(localServiceAccountFolderFeed.toString());
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject2).toString());
        }
        if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(paramAppInterface, paramString) != -7) {
          break label1121;
        }
        i1 = i3;
        if ((QLog.isColorLevel()) && (i1 != 0))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateServiceAccountFolderFeed->puin:");
          ((StringBuilder)localObject2).append(localServiceAccountFolderFeed.b);
          ((StringBuilder)localObject2).append(" is Eqq!");
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject2).toString());
        }
        if ((!localServiceAccountFolderFeed.m) || (i2 != 0) || (i1 != 0) || (!a((QQAppInterface)paramAppInterface, paramString)))
        {
          this.i.remove(paramString);
          this.g.remove(localServiceAccountFolderFeed);
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("updateServiceAccountFolderFeed->remove feed puin:");
            paramString.append(localServiceAccountFolderFeed.b);
            paramString.append(", title:");
            paramString.append(localServiceAccountFolderFeed.h);
            QLog.d("ServiceAccountFolderManager", 2, paramString.toString());
          }
        }
        o((QQAppInterface)paramAppInterface);
        q((QQAppInterface)paramAppInterface);
        return;
      }
      label1110:
      boolean bool = false;
      continue;
      label1116:
      int i1 = 0;
      continue;
      label1121:
      i1 = 0;
    }
  }
  
  public long d()
  {
    int i1;
    label178:
    synchronized (this.f)
    {
      if ((this.g != null) && (this.g.size() > 0))
      {
        Object localObject3 = null;
        i1 = 0;
        Object localObject1 = localObject3;
        if (i1 < this.g.size())
        {
          if (TextUtils.isEmpty(((ServiceAccountFolderFeed)this.g.get(i1)).i)) {
            break label178;
          }
          localObject1 = (ServiceAccountFolderFeed)this.g.get(i1);
        }
        long l1 = a((ServiceAccountFolderFeed)localObject1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getFolderLastShowMsgId->msgId:");
          ((StringBuilder)localObject1).append(l1);
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
        }
        return l1;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getFolderLastShowMsgId->msgId:0");
        }
        return 0L;
      }
    }
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "handleFollowListChange");
    }
    b(paramQQAppInterface);
  }
  
  public long e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFolderLastEnterTime->mFolderLastEnterTime:");
      localStringBuilder.append(this.u);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    return this.u;
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    long l1 = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteServiceAccountFolder->time:");
      localStringBuilder.append(l1);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.4(this, paramQQAppInterface, l1));
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "clearServiceAccountFolderUnreadNum");
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.f)
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)localIterator.next();
        localServiceAccountFolderFeed.d = 0;
        localArrayList.add(localServiceAccountFolderFeed.b);
      }
      this.p = 0;
      if (localArrayList.size() > 0) {
        ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.5(this, localArrayList, paramQQAppInterface));
      }
      return;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public int g(QQAppInterface paramQQAppInterface)
  {
    if (h() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadType->type:1");
      }
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadType->type:0");
    }
    if ((i()) && (i(paramQQAppInterface) > e())) {
      return 2;
    }
    return 0;
  }
  
  public int h()
  {
    if (this.v > this.t)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFolderUnreadNum->mFolderUnreadNum:");
        localStringBuilder.append(this.p);
        QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
      }
      if ((((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isClearAllPublicAccountFolderRedNumber()) && (this.u >= this.v))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("enter time:");
          localStringBuilder.append(this.u);
          localStringBuilder.append("  Last msgtime=");
          localStringBuilder.append(this.v);
          QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
        }
        return 0;
      }
      return this.p;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadNum->0");
    }
    return 0;
  }
  
  public long i(QQAppInterface paramQQAppInterface)
  {
    if ((this.m == 0L) && (!this.l))
    {
      m(paramQQAppInterface);
      this.l = true;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFolderDisplayTime->mFolderDisplayTime:");
      paramQQAppInterface.append(this.m);
      QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
    }
    return this.m;
  }
  
  public boolean i()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFolderHasLittleRedDot->mFolderHasLittleRedDot:");
      localStringBuilder.append(this.w);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    return this.w;
  }
  
  public String j()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFolderReportKeyBytesOacMsgxtend->mReportKeyBytesOacMsgxtend:");
      localStringBuilder.append(this.x);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    return this.x;
  }
  
  public String j(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.n)) && (!this.l))
    {
      m(paramQQAppInterface);
      this.l = true;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFolderShowTime->mFolderShowTime:");
      paramQQAppInterface.append(this.n);
      QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
    }
    return this.n;
  }
  
  public long k(QQAppInterface paramQQAppInterface)
  {
    if ((this.o == 0L) && (!this.l))
    {
      m(paramQQAppInterface);
      this.l = true;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFolderOperationTime->mFolderOperationTime:");
      paramQQAppInterface.append(this.o);
      QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
    }
    return this.o;
  }
  
  public String k()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFolderExtraInfo->mFolderExtraInfo:");
      localStringBuilder.append(this.r);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    return this.r;
  }
  
  public CharSequence l(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.q)) && (!this.l))
    {
      m(paramQQAppInterface);
      this.l = true;
      return new QQText(this.q, 3, 16);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFolderMsgBrief->mFolderMsgBrief:");
      paramQQAppInterface.append(this.q);
      QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
    }
    return this.q;
  }
  
  public boolean l()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isLastDraftMsg->lastDraft:");
      localStringBuilder.append(this.s);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    return this.s;
  }
  
  public List<ServiceAccountFolderFeed> m()
  {
    synchronized (this.f)
    {
      List localList = this.h;
      return localList;
    }
  }
  
  public void m(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramQQAppInterface != null)
    {
      this.m = paramQQAppInterface.getLong("service_account_folder_display_time", 0L);
      this.n = paramQQAppInterface.getString("service_account_folder_time", "");
      this.o = paramQQAppInterface.getLong("service_account_folder_operation_time", 0L);
      this.q = paramQQAppInterface.getString("service_account_folder_brief", "");
      this.v = paramQQAppInterface.getLong("service_account_folder_maxunreadtime", 0L);
      this.p = paramQQAppInterface.getInt("service_account_folder_unreadnum", 0);
      this.x = paramQQAppInterface.getString("service_account_folder_extend", "");
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getFolderLocalData->mFolderDisplayTime:");
        paramQQAppInterface.append(this.m);
        paramQQAppInterface.append(", mFolderShowTime:");
        paramQQAppInterface.append(this.n);
        paramQQAppInterface.append(", mFolderOperationTime:");
        paramQQAppInterface.append(this.o);
        paramQQAppInterface.append(", mFolderMsgBrief:");
        paramQQAppInterface.append(this.q);
        paramQQAppInterface.append(", mFolderReportKeyBytesOacMsgxtend:");
        paramQQAppInterface.append(this.x);
        QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void n(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new ServiceAccountFolderManager.8(this, paramQQAppInterface));
  }
  
  public void o(QQAppInterface paramQQAppInterface)
  {
    long l5;
    long l1;
    int i2;
    Object localObject4;
    int i5;
    boolean bool1;
    boolean bool2;
    int i3;
    long l2;
    long l4;
    Object localObject3;
    int i4;
    label1015:
    synchronized (this.f)
    {
      RecentUtil.a(this.g);
      Collections.sort(this.g, this.k);
      if ((n()) && (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()))
      {
        localObject1 = this.g.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (c(((ServiceAccountFolderFeed)((Iterator)localObject1).next()).b)) {
            ((Iterator)localObject1).remove();
          }
        }
      }
      Iterator localIterator = this.g.iterator();
      l5 = 0L;
      String str1 = "";
      String str2 = "";
      Object localObject1 = "";
      Object localObject2 = "";
      long l3 = 0L;
      l1 = l3;
      i2 = 0;
      int i1 = 0;
      localObject4 = "";
      String str3 = "";
      i5 = 0;
      bool1 = false;
      if (localIterator.hasNext())
      {
        ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)localIterator.next();
        if (localServiceAccountFolderFeed.c == 2)
        {
          bool2 = true;
          i3 = i5;
        }
        else
        {
          i3 = i5;
          bool2 = bool1;
          if (localServiceAccountFolderFeed.c == 1)
          {
            i3 = i5 + localServiceAccountFolderFeed.d;
            bool2 = bool1;
          }
        }
        if (localServiceAccountFolderFeed.d > 0)
        {
          l2 = l5;
          if (localServiceAccountFolderFeed.f >= l5) {
            l2 = localServiceAccountFolderFeed.f;
          }
          l4 = l1;
          if (localServiceAccountFolderFeed.n > l1) {
            l4 = localServiceAccountFolderFeed.n;
          }
          localObject3 = localObject4;
          i4 = i2;
          if (localServiceAccountFolderFeed.d > 0)
          {
            localObject3 = localObject4;
            i4 = i2;
            if (i2 == 0)
            {
              localObject3 = localObject4;
              i4 = i2;
              if (!TextUtils.isEmpty(localServiceAccountFolderFeed.l))
              {
                localObject3 = localServiceAccountFolderFeed.l;
                i4 = 1;
              }
            }
          }
          if ((i1 != 0) || (TextUtils.isEmpty(localServiceAccountFolderFeed.i))) {
            break label1015;
          }
          l3 = localServiceAccountFolderFeed.f;
          str3 = localServiceAccountFolderFeed.g;
          str1 = localServiceAccountFolderFeed.h;
          str2 = localServiceAccountFolderFeed.b;
          localObject1 = localServiceAccountFolderFeed.i;
          localObject2 = localServiceAccountFolderFeed.q;
          i1 = 1;
          break label1015;
        }
      }
      else
      {
        this.p = i5;
        this.w = bool1;
        this.v = l5;
        this.r = ((String)localObject4);
        this.m = l3;
        this.n = str3;
        this.o = l1;
        this.x = ((String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (!TextUtils.isEmpty(str1))
          {
            localObject1 = new QQText((CharSequence)localObject1, 3, 16);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).append(": ");
            this.q = ((QQText)localObject1).append(((StringBuilder)localObject2).toString(), true, new int[0]);
          }
          else if (!TextUtils.isEmpty(str2))
          {
            localObject1 = new QQText((CharSequence)localObject1, 3, 16);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(str2);
            ((StringBuilder)localObject2).append(": ");
            this.q = ((QQText)localObject1).append(((StringBuilder)localObject2).toString(), true, new int[0]);
          }
          else
          {
            this.q = ((CharSequence)localObject1);
            if (this.q == null) {
              this.q = "";
            }
          }
        }
        else if (this.g.size() > 0)
        {
          this.m = ((ServiceAccountFolderFeed)this.g.get(0)).f;
          this.n = ((ServiceAccountFolderFeed)this.g.get(0)).g;
          this.q = ((ServiceAccountFolderFeed)this.g.get(0)).i;
          this.x = ((ServiceAccountFolderFeed)this.g.get(0)).q;
          if (this.q == null) {
            this.q = "";
          }
        }
        bool1 = true;
        if (this.g.size() > 0)
        {
          if (((ServiceAccountFolderFeed)this.g.get(0)).p != 4) {
            break label1041;
          }
          this.s = bool1;
        }
        else
        {
          this.s = false;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("generateFolderDescription->mFolderDisplayTime:");
          ((StringBuilder)localObject1).append(this.m);
          ((StringBuilder)localObject1).append(", mFolderShowTime:");
          ((StringBuilder)localObject1).append(this.n);
          ((StringBuilder)localObject1).append(", mFolderExtraInfo:");
          ((StringBuilder)localObject1).append(this.r);
          ((StringBuilder)localObject1).append(", mFolderMsgBrief:");
          ((StringBuilder)localObject1).append(this.q);
          ((StringBuilder)localObject1).append(", mFolderUnreadNum:");
          ((StringBuilder)localObject1).append(this.p);
          ((StringBuilder)localObject1).append(", maxUnreadDisplayTime:");
          ((StringBuilder)localObject1).append(this.v);
          ((StringBuilder)localObject1).append(", mFolderLastReadTime:");
          ((StringBuilder)localObject1).append(this.t);
          ((StringBuilder)localObject1).append(", mFolderLastEnterTime:");
          ((StringBuilder)localObject1).append(this.u);
          ((StringBuilder)localObject1).append(", mFolderHasLittleRedDot:");
          ((StringBuilder)localObject1).append(this.w);
          ((StringBuilder)localObject1).append(", lastDraft:");
          ((StringBuilder)localObject1).append(this.s);
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
        }
        n(paramQQAppInterface);
        return;
      }
    }
  }
  
  public void p(QQAppInterface paramQQAppInterface)
  {
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
    Object localObject2 = localRecentUserProxy.c(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230);
    synchronized (this.f)
    {
      if ((n()) && (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()))
      {
        Iterator localIterator = this.g.iterator();
        while (localIterator.hasNext()) {
          if (c(((ServiceAccountFolderFeed)localIterator.next()).b)) {
            localIterator.remove();
          }
        }
      }
      if ((this.g != null) && (this.g.size() != 0))
      {
        ??? = localObject2;
        if (localObject2 == null)
        {
          localObject2 = new RecentUser(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230);
          ((RecentUser)localObject2).displayName = h(paramQQAppInterface);
          ??? = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderInMsgTab->新增folder节点");
            ??? = localObject2;
          }
        }
        long l1 = i(paramQQAppInterface);
        long l2 = k(paramQQAppInterface);
        ???.lastmsgtime = Math.max(l1, l2);
        localRecentUserProxy.b(???);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateServiceAccountFolderInMsgTab->更新folder节点:tempFolderDisplayTime:");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append(", tempFolderOperationTime:");
          ((StringBuilder)localObject2).append(l2);
          ((StringBuilder)localObject2).append(", ru.lastmsgtime:");
          ((StringBuilder)localObject2).append(???.lastmsgtime);
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject2).toString());
        }
        paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.sendEmptyMessage(1009);
        }
        return;
      }
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderInMsgTab->删除folder节点");
        }
        localRecentUserProxy.a((RecentUser)localObject2);
      }
      return;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public void q(QQAppInterface paramQQAppInterface)
  {
    p(paramQQAppInterface);
    MqqHandler localMqqHandler = paramQQAppInterface.getHandler(ServiceAccountFolderActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(100);
    }
    localMqqHandler = paramQQAppInterface.getHandler(FolderFollowTabFragment.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(100);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(FolderRecommendTabFragment.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(100);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "refreshFolderAndActivityUI");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager
 * JD-Core Version:    0.7.0.1
 */