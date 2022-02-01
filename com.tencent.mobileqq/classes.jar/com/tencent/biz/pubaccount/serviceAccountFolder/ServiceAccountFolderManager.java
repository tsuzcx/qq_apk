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
  private static ServiceAccountFolderManager jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager = new ServiceAccountFolderManager();
  private static Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private ServiceAccountFolderManager.FeedComparator jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager$FeedComparator = new ServiceAccountFolderManager.FeedComparator(this);
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ServiceAccountFolderManager.1(this);
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, ServiceAccountFolderFeed> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<ServiceAccountFolderFeed> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString = "";
  private final HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private List<ServiceAccountFolderFeed> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long = 0L;
  private String jdField_d_of_type_JavaLangString;
  private long e = 0L;
  
  static
  {
    jdField_a_of_type_JavaUtilSet.add(new String("2171946401"));
  }
  
  public static int a()
  {
    return 2130840426;
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
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      Integer localInteger = Integer.valueOf((paramInt1 << 2) + paramInt2);
      if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        if ((this.jdField_b_of_type_JavaUtilHashMap.get(paramString) != null) && (localInteger.equals(this.jdField_b_of_type_JavaUtilHashMap.get(paramString)))) {
          return 0;
        }
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, localInteger);
        return 2;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, localInteger);
      return 1;
    }
  }
  
  private static int a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    int i = 0;
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
      label89:
      Object localObject3;
      long l;
      int j;
      int k;
      break label89;
    }
    localObject1 = (PublicAccountInfo)((IPublicAccountDataManager)localObject2).findPublicAccountInfoCache(paramString);
    break label118;
    localObject1 = (PublicAccountInfo)((IPublicAccountDataManager)localObject2).findPublicAccountInfoCache(paramString);
    label118:
    localObject3 = localObject1;
    if (localObject1 == null)
    {
      localIPublicAccountDetail = ((IPublicAccountDataManager)localObject2).findAccountDetailInfoCache(paramString);
      localObject3 = localObject1;
      break label147;
      localObject3 = null;
    }
    label147:
    if ((localObject3 == null) && (localIPublicAccountDetail == null))
    {
      if (b(paramString)) {
        return 0;
      }
      if (paramAppRuntime != null)
      {
        localObject1 = ((FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
        if ((localObject1 != null) && (((Friends)localObject1).isFriend()))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" getPublicAccountFolderType error, is UIN_TYPE_PUBLIC_ACCOUNT, but is friend relation  puin = ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("ServiceAccountFolderManager", 1, ((StringBuilder)localObject1).toString());
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("self_uin", paramAppRuntime.getCurrentAccountUin());
          ((HashMap)localObject1).put("inValid_uin", paramString);
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString, "ServiceAccountFolderManager_InValid_puin", false, 1L, 0L, (HashMap)localObject1, null);
          return 0;
        }
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
          i = a().a(paramString, 2, 2);
          if (i > 0)
          {
            paramAppRuntime = new StringBuilder(128);
            paramAppRuntime.append("updateServiceAccountBelongInfo(");
            paramAppRuntime.append(i);
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
          i = a().a(paramString, 3, 2);
          if (i > 0)
          {
            paramAppRuntime = new StringBuilder(128);
            paramAppRuntime.append("updateServiceAccountBelongInfo(");
            paramAppRuntime.append(i);
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
      i = a().a(paramString, 1, 2);
      if (i > 0)
      {
        paramAppRuntime = new StringBuilder(150);
        paramAppRuntime.append("updateServiceAccountBelongInfo(");
        paramAppRuntime.append(i);
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
      l = localObject3.accountFlag2;
    } else {
      l = localIPublicAccountDetail.getAccountFlag2();
    }
    j = (int)((0x7800 & l) >> 11);
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3) {
          if (j != 4) {
            i = -1;
          } else {
            i = 3;
          }
        }
      }
      else {
        i = 1;
      }
    }
    else {
      i = 2;
    }
    if (localObject3 != null) {
      j = localObject3.accountFlag;
    } else {
      j = localIPublicAccountDetail.getAccountFlag();
    }
    k = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(j);
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isSubscript(j, l)) {
      j = 2;
    } else if (k == -5) {
      j = 3;
    } else {
      j = 1;
    }
    if ((i == 0) && (j == 2)) {}
    while ((i == 2) && (j == 1))
    {
      j = 1;
      break;
    }
    if (i != -1) {
      j = i;
    }
    i = a().a(paramString, j, 1);
    if (i > 0)
    {
      paramAppRuntime = new StringBuilder(256);
      paramAppRuntime.append("updateServiceAccountBelongInfo(");
      paramAppRuntime.append(i);
      paramAppRuntime.append(")->getPublicAccountFolderType->puin:");
      paramAppRuntime.append(paramString);
      paramAppRuntime.append(", folder type:");
      paramAppRuntime.append(j);
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
    return j;
    i = a().a(paramString, 1, 0);
    if (i > 0)
    {
      paramAppRuntime = new StringBuilder(150);
      paramAppRuntime.append("updateServiceAccountBelongInfo(");
      paramAppRuntime.append(i);
      paramAppRuntime.append(")->getPublicAccountFolderType->puin:");
      paramAppRuntime.append(paramString);
      paramAppRuntime.append(", folder type:");
      paramAppRuntime.append(1);
      paramAppRuntime.append(", error param, default service folder!");
      QLog.d("ServiceAccountFolderManager", 1, paramAppRuntime.toString());
    }
    return 1;
  }
  
  public static Drawable a()
  {
    Drawable localDrawable = BaseApplicationImpl.sApplication.getResources().getDrawable(a());
    Object localObject = localDrawable;
    if (!TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon())) {
      localObject = URLDrawable.getDrawable(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon(), localDrawable, localDrawable);
    }
    return localObject;
  }
  
  public static ServiceAccountFolderManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager == null) {
      try
      {
        jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager = new ServiceAccountFolderManager();
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager;
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
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getMessages(paramString, 1008, 15);
    if ((paramAppInterface != null) && (paramAppInterface.size() != 0))
    {
      int i = paramAppInterface.size() - 1;
      while (i >= 0)
      {
        Object localObject = (MessageRecord)paramAppInterface.get(i);
        if (!((MessageRecord)localObject).isread)
        {
          localObject = ((MessageRecord)localObject).getExtInfoFromExtStr("public_account_msg_extra_info_type");
          if (("1".equals(localObject)) || ("2".equals(localObject))) {
            break;
          }
        }
        i -= 1;
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
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName())) {
      return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountTitle();
    }
    return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderName();
  }
  
  private void a(String paramString)
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
    a((AppInterface)localObject1, paramString);
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
    int i = a(paramQQAppInterface, paramString, true);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("isBelongServiceAccountFolder->puin:");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append(", type:");
      paramQQAppInterface.append(i);
      QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
    }
    return i == 1;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    int i = a(paramQQAppInterface, paramString, false);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("isBelongEcShopFolder->puin:");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append(", type:");
      paramQQAppInterface.append(i);
      QLog.d("EcShopAssistantManager", 2, paramQQAppInterface.toString());
    }
    if (i == 3) {
      bool = true;
    }
    return bool;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    if (b() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadType->type:1");
      }
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadType->type:0");
    }
    if ((a()) && (a(paramQQAppInterface) > b())) {
      return 2;
    }
    return 0;
  }
  
  public long a()
  {
    int i;
    label178:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        Object localObject3 = null;
        i = 0;
        Object localObject1 = localObject3;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (TextUtils.isEmpty(((ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangCharSequence)) {
            break label178;
          }
          localObject1 = (ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(i);
        }
        long l = a((ServiceAccountFolderFeed)localObject1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getFolderLastShowMsgId->msgId:");
          ((StringBuilder)localObject1).append(l);
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
        }
        return l;
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
    paramServiceAccountFolderFeed = paramServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Long == 0L) && (!this.jdField_a_of_type_Boolean))
    {
      f(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFolderDisplayTime->mFolderDisplayTime:");
      paramQQAppInterface.append(this.jdField_a_of_type_Long);
      QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
    }
    return this.jdField_a_of_type_Long;
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
  
  public CharSequence a(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) && (!this.jdField_a_of_type_Boolean))
    {
      f(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
      return new QQText(this.jdField_a_of_type_JavaLangCharSequence, 3, 16);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFolderMsgBrief->mFolderMsgBrief:");
      paramQQAppInterface.append(this.jdField_a_of_type_JavaLangCharSequence);
      QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        Object localObject2 = (ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(0);
        if (localObject2 != null)
        {
          localObject2 = ((ServiceAccountFolderFeed)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
  
  public List<ServiceAccountFolderFeed> a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getDataList->empty DataList");
        }
        return null;
      }
      try
      {
        List localList = (List)((ArrayList)this.jdField_a_of_type_JavaUtilList).clone();
        if (QLog.isColorLevel())
        {
          int i = localList.size();
          localStringBuilder = new StringBuilder("getDataList->");
          localStringBuilder.append("size:");
          localStringBuilder.append(i);
          localStringBuilder.append(", content:[");
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            localStringBuilder.append(((ServiceAccountFolderFeed)localIterator.next()).jdField_a_of_type_JavaLangString);
            localStringBuilder.append(",");
          }
          if (i > 0) {
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
  
  public List<ServiceAccountFolderFeed> a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "refreshDataList!");
    }
    if (paramQQAppInterface == null) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    Object localObject1;
    if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("refreshDataList->new cuin:");
        ((StringBuilder)localObject1).append(paramQQAppInterface.getAccount());
        ((StringBuilder)localObject1).append(", old cuin:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
      }
      a(paramQQAppInterface);
    }
    label873:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      localObject1 = TroopBarAssistantManager.a().a(paramQQAppInterface);
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
            if ((((SubscriptionFeed)localObject2).jdField_a_of_type_JavaUtilList != null) && (((SubscriptionFeed)localObject2).jdField_a_of_type_JavaUtilList.size() > 0))
            {
              localObject5 = (SubscriptionFeedItem)((SubscriptionFeed)localObject2).jdField_a_of_type_JavaUtilList.get(0);
              if ((TextUtils.isEmpty(((SubscriptionFeedItem)localObject5).jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(((SubscriptionFeedItem)localObject5).jdField_c_of_type_JavaLangString))) {
                ((SubscriptionFeedItem)localObject5).jdField_b_of_type_JavaLangString = ((SubscriptionFeedItem)localObject5).jdField_c_of_type_JavaLangString;
              }
            }
            ((List)localObject4).add(localObject2);
          }
        }
      }
      else
      {
        int i = ((List)localObject4).size();
        localObject2 = null;
        if (i > 0)
        {
          localObject5 = ((List)localObject4).iterator();
          if (!QLog.isColorLevel()) {
            break label873;
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
              ((StringBuilder)localObject1).append(((SubscriptionFeed)localObject4).jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject1).append(", ");
              ((StringBuilder)localObject1).append(((SubscriptionFeed)localObject4).jdField_a_of_type_Int);
              ((StringBuilder)localObject1).append("]");
            }
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(((SubscriptionFeed)localObject4).jdField_a_of_type_JavaLangString))
            {
              ServiceAccountFolderFeed localServiceAccountFolderFeed = ServiceAccountFolderFeed.a(paramQQAppInterface, (SubscriptionFeed)localObject4);
              if (localServiceAccountFolderFeed.jdField_b_of_type_Boolean)
              {
                this.jdField_a_of_type_JavaUtilList.add(localServiceAccountFolderFeed);
                this.jdField_a_of_type_JavaUtilHashMap.put(((SubscriptionFeed)localObject4).jdField_a_of_type_JavaLangString, localServiceAccountFolderFeed);
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
        localObject5 = paramQQAppInterface.getProxyManager().a().a(false, false);
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
            if ((((RecentUser)localObject2).getType() == 1008) && (b(paramQQAppInterface, ((RecentUser)localObject2).uin)) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(((RecentUser)localObject2).uin)))
            {
              localObject5 = ServiceAccountFolderFeed.a(paramQQAppInterface, (RecentUser)localObject2);
              if (((ServiceAccountFolderFeed)localObject5).jdField_b_of_type_Boolean)
              {
                this.jdField_a_of_type_JavaUtilList.add(localObject5);
                this.jdField_a_of_type_JavaUtilHashMap.put(((RecentUser)localObject2).uin, localObject5);
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
        h(paramQQAppInterface);
        return this.jdField_a_of_type_JavaUtilList;
      }
    }
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
    a(paramAppInterface, paramIPublicAccountDetail);
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.9(this, paramAppInterface, paramString));
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        ServiceAccountFolderFeed localServiceAccountFolderFeed;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localServiceAccountFolderFeed = (ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        }
        else
        {
          localServiceAccountFolderFeed = new ServiceAccountFolderFeed();
          this.jdField_a_of_type_JavaUtilList.add(localServiceAccountFolderFeed);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localServiceAccountFolderFeed);
        }
        localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString = paramString;
        Object localObject2 = (IPublicAccountDataManager)paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        int k = 1;
        if (localObject2 != null)
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((IPublicAccountDataManager)localObject2).findPublicAccountInfoCache(paramString);
          if (localPublicAccountInfo != null)
          {
            localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
            localServiceAccountFolderFeed.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
            localServiceAccountFolderFeed.jdField_c_of_type_Int = 0;
          }
          else
          {
            localObject2 = ((IPublicAccountDataManager)localObject2).findAccountDetailInfoCache(paramString);
            if (localObject2 != null)
            {
              localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString = ((IPublicAccountDetail)localObject2).getName();
              if (1 != ((IPublicAccountDetail)localObject2).getShowFlag()) {
                break label1111;
              }
              bool = true;
              localServiceAccountFolderFeed.jdField_b_of_type_Boolean = bool;
              localServiceAccountFolderFeed.jdField_c_of_type_Int = 0;
            }
          }
        }
        localServiceAccountFolderFeed.jdField_b_of_type_Int = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getReadUnreadCount(paramString, 1008);
        i = ((IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "")).getPublicAccountConversationRedMask(paramString, 1008);
        if (localServiceAccountFolderFeed.jdField_b_of_type_Int > 0)
        {
          if ((localServiceAccountFolderFeed.jdField_b_of_type_Int == 1) && (i > 0))
          {
            localServiceAccountFolderFeed.jdField_a_of_type_Int = 2;
          }
          else
          {
            localServiceAccountFolderFeed.jdField_a_of_type_Int = 1;
            if (i > 0) {
              localServiceAccountFolderFeed.jdField_b_of_type_Int -= 1;
            }
          }
        }
        else {
          localServiceAccountFolderFeed.jdField_a_of_type_Int = 0;
        }
        localObject2 = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
        if (localObject2 == null) {
          break label1117;
        }
        localServiceAccountFolderFeed.jdField_b_of_type_JavaLangCharSequence = null;
        localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((IMessageFacade)localObject2).getLastMsgForMsgTab(paramString, 1008);
        localObject2 = ((IMessageFacade)localObject2).getDraftSummaryInfo(paramString, 1008);
        if ((localObject2 != null) && (!TextUtils.isEmpty(((DraftSummaryInfo)localObject2).getSummary())))
        {
          if ((localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((DraftSummaryInfo)localObject2).getTime() <= localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time))
          {
            localServiceAccountFolderFeed.jdField_e_of_type_Int = 0;
            localServiceAccountFolderFeed.jdField_a_of_type_Long = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
            localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = TimeManager.a().a(paramString, localServiceAccountFolderFeed.jdField_a_of_type_Long);
            localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = a(paramAppInterface, localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
            break label1117;
          }
          localServiceAccountFolderFeed.jdField_e_of_type_Int = 4;
          localServiceAccountFolderFeed.jdField_a_of_type_Long = ((DraftSummaryInfo)localObject2).getTime();
          localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = TimeManager.a().a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, ((DraftSummaryInfo)localObject2).getTime());
          localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = ((DraftSummaryInfo)localObject2).getSummary();
          break label1117;
        }
        if ((localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time > 0L))
        {
          localServiceAccountFolderFeed.jdField_e_of_type_Int = 0;
          localServiceAccountFolderFeed.jdField_a_of_type_Long = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
          localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = TimeManager.a().a(paramString, localServiceAccountFolderFeed.jdField_a_of_type_Long);
          localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = a(paramAppInterface, localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
          break label1117;
        }
        localServiceAccountFolderFeed.jdField_e_of_type_Int = 0;
        localServiceAccountFolderFeed.jdField_a_of_type_Long = 0L;
        localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = null;
        localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = null;
        i = 1;
        localServiceAccountFolderFeed.jdField_d_of_type_JavaLangString = a(paramAppInterface, localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
        localServiceAccountFolderFeed.jdField_a_of_type_Boolean = true;
        if (TroopBarAssistantManager.a().a((QQAppInterface)paramAppInterface, paramString, 1008)) {
          localServiceAccountFolderFeed.jdField_a_of_type_Boolean = false;
        } else if ((localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ("1".equals(localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("inter_num")))) {
          localServiceAccountFolderFeed.jdField_a_of_type_Boolean = false;
        }
        int j = i;
        if (((QQAppInterface)paramAppInterface).getProxyManager() != null)
        {
          j = i;
          if (((QQAppInterface)paramAppInterface).getProxyManager().a() != null)
          {
            localObject2 = ((QQAppInterface)paramAppInterface).getProxyManager().a().a(paramString, 1008);
            j = i;
            if (localObject2 != null)
            {
              localServiceAccountFolderFeed.jdField_b_of_type_Long = ((RecentUser)localObject2).lastmsgtime;
              j = i;
              if (i != 0)
              {
                j = i;
                if (localServiceAccountFolderFeed.jdField_b_of_type_Long > 0L)
                {
                  localServiceAccountFolderFeed.jdField_a_of_type_Long = localServiceAccountFolderFeed.jdField_b_of_type_Long;
                  localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = TimeManager.a().a(paramString, localServiceAccountFolderFeed.jdField_a_of_type_Long);
                  localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = "";
                  j = 0;
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
          break label1122;
        }
        i = k;
        if ((QLog.isColorLevel()) && (i != 0))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateServiceAccountFolderFeed->puin:");
          ((StringBuilder)localObject2).append(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(" is Eqq!");
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject2).toString());
        }
        if ((!localServiceAccountFolderFeed.jdField_b_of_type_Boolean) || (j != 0) || (i != 0) || (!a((QQAppInterface)paramAppInterface, paramString)))
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
          this.jdField_a_of_type_JavaUtilList.remove(localServiceAccountFolderFeed);
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("updateServiceAccountFolderFeed->remove feed puin:");
            paramString.append(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
            paramString.append(", title:");
            paramString.append(localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
            QLog.d("ServiceAccountFolderManager", 2, paramString.toString());
          }
        }
        h((QQAppInterface)paramAppInterface);
        j((QQAppInterface)paramAppInterface);
        return;
      }
      label1111:
      boolean bool = false;
      continue;
      label1117:
      int i = 0;
      continue;
      label1122:
      i = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getAccount())))
    {
      Object localObject = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_public_account_with_cuin_");
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      if (localObject != null)
      {
        this.jdField_c_of_type_Long = ((SharedPreferences)localObject).getLong("service_account_folder_last_read_time", 0L);
        this.jdField_d_of_type_Long = ((SharedPreferences)localObject).getLong("service_account_folder_last_enter_time", 0L);
        ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).setServiceFolderRedCleanAfterEnter(((SharedPreferences)localObject).getBoolean("service_folder_redclean_after_enter", false));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initManager->mFolderLastReadTime:");
          ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
          ((StringBuilder)localObject).append(", mFolderLastEnterTime:");
          ((StringBuilder)localObject).append(this.jdField_d_of_type_Long);
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
      this.jdField_a_of_type_Boolean = false;
      b(paramQQAppInterface);
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, true);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("initManager->cuin:");
        paramQQAppInterface.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
    ThreadManager.executeOnFileThread(new ServiceAccountFolderManager.6(this, paramQQAppInterface));
  }
  
  public void a(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed, boolean paramBoolean)
  {
    String str = paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("deleteServiceAccountFolderFeed->puin:");
      ((StringBuilder)???).append(str);
      ((StringBuilder)???).append(", needRefresh:");
      ((StringBuilder)???).append(paramBoolean);
      QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
      {
        ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        if (localServiceAccountFolderFeed != null)
        {
          this.jdField_a_of_type_JavaUtilList.remove(localServiceAccountFolderFeed);
          this.jdField_a_of_type_JavaUtilHashMap.remove(str);
        }
      }
      if (paramServiceAccountFolderFeed.jdField_a_of_type_Boolean)
      {
        paramServiceAccountFolderFeed = paramQQAppInterface.getProxyManager().a().b(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, 1008);
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
        h(paramQQAppInterface);
        j(paramQQAppInterface);
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
          a(paramQQAppInterface, paramObject.frienduin);
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
    a(paramQQAppInterface, paramString1);
  }
  
  public void a(List<ServiceAccountFolderFeed> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      if (paramList != null) {
        this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      }
      return;
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFolderHasLittleRedDot->mFolderHasLittleRedDot:");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    return this.jdField_c_of_type_Boolean;
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
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
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
  
  public int b()
  {
    if (this.e > this.jdField_c_of_type_Long)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFolderUnreadNum->mFolderUnreadNum:");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
      }
      if ((((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isClearAllPublicAccountFolderRedNumber()) && (this.jdField_d_of_type_Long >= this.e))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("enter time:");
          localStringBuilder.append(this.jdField_d_of_type_Long);
          localStringBuilder.append("  Last msgtime=");
          localStringBuilder.append(this.e);
          QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
        }
        return 0;
      }
      return this.jdField_a_of_type_Int;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadNum->0");
    }
    return 0;
  }
  
  public long b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFolderLastEnterTime->mFolderLastEnterTime:");
      localStringBuilder.append(this.jdField_d_of_type_Long);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    return this.jdField_d_of_type_Long;
  }
  
  public long b(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_b_of_type_Long == 0L) && (!this.jdField_a_of_type_Boolean))
    {
      f(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFolderOperationTime->mFolderOperationTime:");
      paramQQAppInterface.append(this.jdField_b_of_type_Long);
      QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
    }
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFolderReportKeyBytesOacMsgxtend->mReportKeyBytesOacMsgxtend:");
      localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_Boolean))
    {
      f(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFolderShowTime->mFolderShowTime:");
      paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
      QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<ServiceAccountFolderFeed> b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      List localList = this.jdField_b_of_type_JavaUtilList;
      return localList;
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
        paramQQAppInterface.append(this.jdField_a_of_type_JavaLangString);
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
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
      }
      a(paramQQAppInterface);
      j(paramQQAppInterface);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_d_of_type_Long = paramLong;
    ThreadManager.executeOnFileThread(new ServiceAccountFolderManager.7(this, paramQQAppInterface));
  }
  
  public void b(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed, boolean paramBoolean)
  {
    if (paramServiceAccountFolderFeed == null) {
      return;
    }
    this.jdField_a_of_type_Int -= paramServiceAccountFolderFeed.jdField_b_of_type_Int;
    if (this.jdField_a_of_type_Int < 0) {
      this.jdField_a_of_type_Int = 0;
    }
    paramServiceAccountFolderFeed.jdField_b_of_type_Int = 0;
    paramServiceAccountFolderFeed = paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
    RecentUtil.b(paramQQAppInterface, paramServiceAccountFolderFeed, 1008);
    paramQQAppInterface.getMessageFacade().a(paramServiceAccountFolderFeed, 1008);
    paramQQAppInterface.getConversationFacade().a(paramServiceAccountFolderFeed, 1008, true);
    a(paramQQAppInterface, paramServiceAccountFolderFeed);
    if (paramBoolean) {
      i(paramQQAppInterface);
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
  
  public boolean b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isLastDraftMsg->lastDraft:");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public String c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFolderExtraInfo->mFolderExtraInfo:");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "handleFollowListChange");
    }
    b(paramQQAppInterface);
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteServiceAccountFolder->time:");
      localStringBuilder.append(l);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.4(this, paramQQAppInterface, l));
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "clearServiceAccountFolderUnreadNum");
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)localIterator.next();
        localServiceAccountFolderFeed.jdField_b_of_type_Int = 0;
        localArrayList.add(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Int = 0;
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
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_Long = paramQQAppInterface.getLong("service_account_folder_display_time", 0L);
      this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getString("service_account_folder_time", "");
      this.jdField_b_of_type_Long = paramQQAppInterface.getLong("service_account_folder_operation_time", 0L);
      this.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getString("service_account_folder_brief", "");
      this.e = paramQQAppInterface.getLong("service_account_folder_maxunreadtime", 0L);
      this.jdField_a_of_type_Int = paramQQAppInterface.getInt("service_account_folder_unreadnum", 0);
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface.getString("service_account_folder_extend", "");
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getFolderLocalData->mFolderDisplayTime:");
        paramQQAppInterface.append(this.jdField_a_of_type_Long);
        paramQQAppInterface.append(", mFolderShowTime:");
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
        paramQQAppInterface.append(", mFolderOperationTime:");
        paramQQAppInterface.append(this.jdField_b_of_type_Long);
        paramQQAppInterface.append(", mFolderMsgBrief:");
        paramQQAppInterface.append(this.jdField_a_of_type_JavaLangCharSequence);
        paramQQAppInterface.append(", mFolderReportKeyBytesOacMsgxtend:");
        paramQQAppInterface.append(this.jdField_d_of_type_JavaLangString);
        QLog.d("ServiceAccountFolderManager", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void g(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new ServiceAccountFolderManager.8(this, paramQQAppInterface));
  }
  
  public void h(QQAppInterface paramQQAppInterface)
  {
    long l5;
    long l1;
    int j;
    Object localObject4;
    int n;
    boolean bool1;
    boolean bool2;
    int k;
    long l2;
    long l4;
    Object localObject3;
    int m;
    label942:
    label968:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      RecentUtil.a(this.jdField_a_of_type_JavaUtilList);
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager$FeedComparator);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      l5 = 0L;
      String str1 = "";
      String str2 = "";
      Object localObject1 = "";
      Object localObject2 = "";
      long l3 = 0L;
      l1 = l3;
      j = 0;
      int i = 0;
      localObject4 = "";
      String str3 = "";
      n = 0;
      bool1 = false;
      if (localIterator.hasNext())
      {
        ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)localIterator.next();
        if (localServiceAccountFolderFeed.jdField_a_of_type_Int == 2)
        {
          bool2 = true;
          k = n;
        }
        else
        {
          k = n;
          bool2 = bool1;
          if (localServiceAccountFolderFeed.jdField_a_of_type_Int == 1)
          {
            k = n + localServiceAccountFolderFeed.jdField_b_of_type_Int;
            bool2 = bool1;
          }
        }
        if (localServiceAccountFolderFeed.jdField_b_of_type_Int > 0)
        {
          l2 = l5;
          if (localServiceAccountFolderFeed.jdField_a_of_type_Long >= l5) {
            l2 = localServiceAccountFolderFeed.jdField_a_of_type_Long;
          }
          l4 = l1;
          if (localServiceAccountFolderFeed.jdField_b_of_type_Long > l1) {
            l4 = localServiceAccountFolderFeed.jdField_b_of_type_Long;
          }
          localObject3 = localObject4;
          m = j;
          if (localServiceAccountFolderFeed.jdField_b_of_type_Int > 0)
          {
            localObject3 = localObject4;
            m = j;
            if (j == 0)
            {
              localObject3 = localObject4;
              m = j;
              if (!TextUtils.isEmpty(localServiceAccountFolderFeed.jdField_d_of_type_JavaLangString))
              {
                localObject3 = localServiceAccountFolderFeed.jdField_d_of_type_JavaLangString;
                m = 1;
              }
            }
          }
          if ((i != 0) || (TextUtils.isEmpty(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence))) {
            break label942;
          }
          l3 = localServiceAccountFolderFeed.jdField_a_of_type_Long;
          str3 = localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString;
          str1 = localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString;
          str2 = localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
          localObject1 = localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence;
          localObject2 = localServiceAccountFolderFeed.jdField_e_of_type_JavaLangString;
          i = 1;
          break label942;
        }
      }
      else
      {
        this.jdField_a_of_type_Int = n;
        this.jdField_c_of_type_Boolean = bool1;
        this.e = l5;
        this.jdField_c_of_type_JavaLangString = ((String)localObject4);
        this.jdField_a_of_type_Long = l3;
        this.jdField_b_of_type_JavaLangString = str3;
        this.jdField_b_of_type_Long = l1;
        this.jdField_d_of_type_JavaLangString = ((String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (!TextUtils.isEmpty(str1))
          {
            localObject1 = new QQText((CharSequence)localObject1, 3, 16);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).append(": ");
            this.jdField_a_of_type_JavaLangCharSequence = ((QQText)localObject1).append(((StringBuilder)localObject2).toString(), true, new int[0]);
          }
          else if (!TextUtils.isEmpty(str2))
          {
            localObject1 = new QQText((CharSequence)localObject1, 3, 16);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(str2);
            ((StringBuilder)localObject2).append(": ");
            this.jdField_a_of_type_JavaLangCharSequence = ((QQText)localObject1).append(((StringBuilder)localObject2).toString(), true, new int[0]);
          }
          else
          {
            this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
            if (this.jdField_a_of_type_JavaLangCharSequence == null) {
              this.jdField_a_of_type_JavaLangCharSequence = "";
            }
          }
        }
        else if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          this.jdField_a_of_type_Long = ((ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long;
          this.jdField_b_of_type_JavaLangString = ((ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangCharSequence = ((ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangCharSequence;
          this.jdField_d_of_type_JavaLangString = ((ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_e_of_type_JavaLangString;
          if (this.jdField_a_of_type_JavaLangCharSequence == null) {
            this.jdField_a_of_type_JavaLangCharSequence = "";
          }
        }
        bool1 = true;
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          if (((ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_e_of_type_Int != 4) {
            break label968;
          }
          this.jdField_b_of_type_Boolean = bool1;
        }
        else
        {
          this.jdField_b_of_type_Boolean = false;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("generateFolderDescription->mFolderDisplayTime:");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
          ((StringBuilder)localObject1).append(", mFolderShowTime:");
          ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(", mFolderExtraInfo:");
          ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(", mFolderMsgBrief:");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangCharSequence);
          ((StringBuilder)localObject1).append(", mFolderUnreadNum:");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject1).append(", maxUnreadDisplayTime:");
          ((StringBuilder)localObject1).append(this.e);
          ((StringBuilder)localObject1).append(", mFolderLastReadTime:");
          ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
          ((StringBuilder)localObject1).append(", mFolderLastEnterTime:");
          ((StringBuilder)localObject1).append(this.jdField_d_of_type_Long);
          ((StringBuilder)localObject1).append(", mFolderHasLittleRedDot:");
          ((StringBuilder)localObject1).append(this.jdField_c_of_type_Boolean);
          ((StringBuilder)localObject1).append(", lastDraft:");
          ((StringBuilder)localObject1).append(this.jdField_b_of_type_Boolean);
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
        }
        g(paramQQAppInterface);
        return;
      }
    }
  }
  
  public void i(QQAppInterface paramQQAppInterface)
  {
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().a();
    Object localObject2 = localRecentUserProxy.b(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
      {
        ??? = localObject2;
        if (localObject2 == null)
        {
          localObject2 = new RecentUser(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230);
          ((RecentUser)localObject2).displayName = a(paramQQAppInterface);
          ??? = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderInMsgTab->新增folder节点");
            ??? = localObject2;
          }
        }
        long l1 = a(paramQQAppInterface);
        long l2 = b(paramQQAppInterface);
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
  }
  
  public void j(QQAppInterface paramQQAppInterface)
  {
    i(paramQQAppInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager
 * JD-Core Version:    0.7.0.1
 */