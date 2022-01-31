package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeedItem;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
import mqp;
import mqq;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqr;
import mqs;
import mqt;
import mqu;
import mqv;
import mqw;
import org.json.JSONException;
import org.json.JSONObject;

public class ServiceAccountFolderManager
{
  private static ServiceAccountFolderManager jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager = new ServiceAccountFolderManager();
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ServiceAccountFolderManager.FeedComparator jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager$FeedComparator = new ServiceAccountFolderManager.FeedComparator(this);
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new mqp(this);
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString = "";
  private final HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private long d;
  private long e;
  
  static
  {
    jdField_a_of_type_JavaUtilSet.add(new String("2171946401"));
  }
  
  public static int a()
  {
    return 2130839201;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      i = a().a(paramString, 1, 0);
      if (i > 0)
      {
        paramQQAppInterface = new StringBuilder(150);
        paramQQAppInterface.append("updateServiceAccountBelongInfo(");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
        paramQQAppInterface.append(paramString);
        paramQQAppInterface.append(", folder type:");
        paramQQAppInterface.append(1);
        paramQQAppInterface.append(", error param, default service folder!");
        QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
      }
      return 1;
    }
    Object localObject2 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    Object localObject1;
    AccountDetail localAccountDetail;
    if (localObject2 != null)
    {
      localObject1 = ((PublicAccountDataManager)localObject2).c(paramString);
      if (localObject1 == null)
      {
        localAccountDetail = ((PublicAccountDataManager)localObject2).b(paramString);
        localObject2 = localObject1;
        localObject1 = localAccountDetail;
      }
    }
    for (;;)
    {
      if ((localObject2 != null) || (localObject1 != null))
      {
        long l;
        label206:
        int j;
        label217:
        int k;
        if (localObject2 != null)
        {
          l = ((PublicAccountInfo)localObject2).accountFlag2;
          switch ((int)((0x7800 & l) >> 11))
          {
          default: 
            i = -1;
          case 3: 
            if (localObject2 != null)
            {
              j = ((PublicAccountInfo)localObject2).accountFlag;
              k = PublicAccountUtil.a(j);
              if (!PublicAccountUtil.a(j, l)) {
                break label433;
              }
              j = 2;
              label234:
              if ((i != 0) || (j != 2)) {
                break label450;
              }
              j = 1;
            }
            break;
          }
        }
        for (;;)
        {
          i = a().a(paramString, j, 1);
          if (i > 0)
          {
            paramQQAppInterface = new StringBuilder(256);
            paramQQAppInterface.append("updateServiceAccountBelongInfo(");
            paramQQAppInterface.append(i);
            paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
            paramQQAppInterface.append(paramString);
            paramQQAppInterface.append(", folder type:");
            paramQQAppInterface.append(j);
            if (localObject2 != null)
            {
              paramQQAppInterface.append(", info accountFlag:");
              paramQQAppInterface.append(((PublicAccountInfo)localObject2).accountFlag);
              paramQQAppInterface.append(", info accountFlag2:");
              paramQQAppInterface.append(((PublicAccountInfo)localObject2).accountFlag2);
            }
            if (localObject1 != null)
            {
              paramQQAppInterface.append(", detail accountFlag:");
              paramQQAppInterface.append(((AccountDetail)localObject1).accountFlag);
              paramQQAppInterface.append(", detail accountFlag2:");
              paramQQAppInterface.append(((AccountDetail)localObject1).accountFlag2);
            }
            QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
          }
          return j;
          l = ((AccountDetail)localObject1).accountFlag2;
          break;
          i = 2;
          break label206;
          i = 1;
          break label206;
          i = 3;
          break label206;
          j = ((AccountDetail)localObject1).accountFlag;
          break label217;
          label433:
          if (k == -5)
          {
            j = 3;
            break label234;
          }
          j = 1;
          break label234;
          label450:
          if ((i == 2) && (j == 1)) {
            j = 1;
          } else if (i != -1) {
            j = i;
          }
        }
      }
      paramQQAppInterface = paramQQAppInterface.a().a(paramString, 1008);
      if (paramQQAppInterface != null)
      {
        if (PublicAccountAdUtil.a(paramQQAppInterface)) {
          return 0;
        }
        paramQQAppInterface = paramQQAppInterface.getExtInfoFromExtStr("inter_num");
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramQQAppInterface.equals("1")))
        {
          i = a().a(paramString, 2, 2);
          if (i > 0)
          {
            paramQQAppInterface = new StringBuilder(128);
            paramQQAppInterface.append("updateServiceAccountBelongInfo(");
            paramQQAppInterface.append(i);
            paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
            paramQQAppInterface.append(paramString);
            paramQQAppInterface.append(", folder type:");
            paramQQAppInterface.append(2);
            paramQQAppInterface.append(", inter_num:1");
            QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
          }
          return 2;
        }
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramQQAppInterface.equals("2")))
        {
          i = a().a(paramString, 3, 2);
          if (i > 0)
          {
            paramQQAppInterface = new StringBuilder(128);
            paramQQAppInterface.append("updateServiceAccountBelongInfo(");
            paramQQAppInterface.append(i);
            paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
            paramQQAppInterface.append(paramString);
            paramQQAppInterface.append(", folder type:");
            paramQQAppInterface.append(3);
            paramQQAppInterface.append(", inter_num:2");
            QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
          }
          return 3;
        }
      }
      i = a().a(paramString, 1, 2);
      if (i <= 0) {
        break;
      }
      paramQQAppInterface = new StringBuilder(150);
      paramQQAppInterface.append("updateServiceAccountBelongInfo(");
      paramQQAppInterface.append(i);
      paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append(", folder type:");
      paramQQAppInterface.append(1);
      paramQQAppInterface.append(", no info to judge, default service folder!");
      QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
      return 1;
      localAccountDetail = null;
      localObject2 = localObject1;
      localObject1 = localAccountDetail;
      continue;
      localObject1 = null;
      localObject2 = null;
    }
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
        if ((this.jdField_b_of_type_JavaUtilHashMap.get(paramString) == null) || (!localInteger.equals(this.jdField_b_of_type_JavaUtilHashMap.get(paramString))))
        {
          this.jdField_b_of_type_JavaUtilHashMap.put(paramString, localInteger);
          return 2;
        }
      }
      else
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, localInteger);
        return 1;
      }
    }
    return 0;
  }
  
  public static Drawable a()
  {
    Drawable localDrawable = BaseApplicationImpl.sApplication.getResources().getDrawable(a());
    Object localObject = localDrawable;
    if (!TextUtils.isEmpty(PublicAccountConfigUtil.g)) {
      localObject = URLDrawable.getDrawable(PublicAccountConfigUtil.g, localDrawable, localDrawable);
    }
    return localObject;
  }
  
  public static ServiceAccountFolderManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager == null) {}
    try
    {
      jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager = new ServiceAccountFolderManager();
      return jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager;
    }
    finally {}
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
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(PublicAccountConfigUtil.f)) {
      return paramQQAppInterface.getApplication().getString(2131438439);
    }
    return PublicAccountConfigUtil.f;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = paramQQAppInterface.a().a(paramString, 1008, 15);
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getLastExtraInfo->puin:" + paramString + " no message list");
      }
      localObject1 = "";
      return localObject1;
    }
    int i = ((List)localObject1).size() - 1;
    label79:
    Object localObject2;
    if (i >= 0)
    {
      localObject2 = (MessageRecord)((List)localObject1).get(i);
      if (!((MessageRecord)localObject2).isread)
      {
        localObject2 = ((MessageRecord)localObject2).getExtInfoFromExtStr("public_account_msg_extra_info_type");
        if ("1".equals(localObject2)) {
          paramQQAppInterface = paramQQAppInterface.getApplication().getString(2131438441);
        }
      }
    }
    for (;;)
    {
      localObject1 = paramQQAppInterface;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ServiceAccountFolderManager", 2, "getLastExtraInfo->puin:" + paramString + ", extraInfo:" + paramQQAppInterface);
      return paramQQAppInterface;
      if ("2".equals(localObject2))
      {
        paramQQAppInterface = paramQQAppInterface.getApplication().getString(2131438442);
      }
      else
      {
        i -= 1;
        break label79;
        paramQQAppInterface = "";
      }
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "updateMsgState->puin:" + paramString + " begin update");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {}
    do
    {
      PublicAccountDataManager localPublicAccountDataManager;
      do
      {
        return;
        localPublicAccountDataManager = (PublicAccountDataManager)localQQAppInterface.getManager(55);
      } while ((localPublicAccountDataManager != null) && (localPublicAccountDataManager.c(paramString) == null) && (localPublicAccountDataManager.b(paramString) == null));
      if (PublicAccountUtil.a(localQQAppInterface, paramString) != -7) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ServiceAccountFolderManager", 2, "updateMsgState->puin:" + paramString + " is EQQ, return!");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "updateMsgState->puin:" + paramString + " do update");
    }
    a(localQQAppInterface, paramString);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramQQAppInterface, paramString) == 0;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    if (b(paramString)) {
      return false;
    }
    if (a(paramQQAppInterface, paramString) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
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
    return a(paramQQAppInterface, paramString) == 2;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = a(paramQQAppInterface, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("EcShopAssistantManager", 2, "isBelongEcShopFolder->puin:" + paramString + ", type:" + i);
    }
    return i == 3;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    int i = 2;
    if (b() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadType->type:1");
      }
      i = 1;
    }
    do
    {
      return i;
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadType->type:0");
      }
    } while ((a()) && (a(paramQQAppInterface) > b()));
    return 0;
  }
  
  public long a()
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          i = 0;
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            if (TextUtils.isEmpty(((ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangCharSequence)) {
              break label158;
            }
            ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(i);
            long l = a(localServiceAccountFolderFeed);
            if (QLog.isColorLevel()) {
              QLog.d("ServiceAccountFolderManager", 2, "getFolderLastShowMsgId->msgId:" + l);
            }
            return l;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "getFolderLastShowMsgId->msgId:0");
          }
          return 0L;
        }
      }
      Object localObject2 = null;
      continue;
      label158:
      i += 1;
    }
  }
  
  public long a(ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    if (paramServiceAccountFolderFeed == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFeedMsgId->empty feed");
      }
      return 0L;
    }
    paramServiceAccountFolderFeed = paramServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((paramServiceAccountFolderFeed != null) && ((paramServiceAccountFolderFeed instanceof MessageForStructing)))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramServiceAccountFolderFeed;
      paramServiceAccountFolderFeed = localMessageForStructing.structingMsg;
      if (paramServiceAccountFolderFeed != null) {
        break label110;
      }
      paramServiceAccountFolderFeed = StructMsgFactory.a(localMessageForStructing.msgData);
    }
    label110:
    for (;;)
    {
      if (paramServiceAccountFolderFeed != null) {}
      for (long l = paramServiceAccountFolderFeed.msgId;; l = 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getFeedMsgId->msgId:" + l);
        }
        return l;
      }
    }
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Long == 0L) && (!this.jdField_a_of_type_Boolean))
    {
      f(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderDisplayTime->mFolderDisplayTime:" + this.jdField_a_of_type_Long);
    }
    return this.jdField_a_of_type_Long;
  }
  
  public CharSequence a(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) && (!this.jdField_a_of_type_Boolean))
    {
      f(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
      return new QQText(this.jdField_a_of_type_JavaLangCharSequence, 3, 16);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderMsgBrief->mFolderMsgBrief:" + this.jdField_a_of_type_JavaLangCharSequence);
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public CharSequence a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    paramQQAppInterface.a().a(localMessage);
    paramMessageRecord = new MsgSummary();
    MsgUtils.a(paramQQAppInterface.getApplication(), paramQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
    return paramMessageRecord.a(paramQQAppInterface.getApplication());
  }
  
  public String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderExtraInfo->mFolderExtraInfo:" + this.jdField_c_of_type_JavaLangString);
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public List a()
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
      StringBuilder localStringBuilder;
      try
      {
        List localList = (List)((ArrayList)this.jdField_a_of_type_JavaUtilList).clone();
        if (!QLog.isColorLevel()) {
          break label214;
        }
        int i = localList.size();
        localStringBuilder = new StringBuilder("getDataList->");
        localStringBuilder.append("size:").append(i).append(", content:[");
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          localStringBuilder.append(((ServiceAccountFolderFeed)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
        }
        if (i <= 0) {
          break label194;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getDataList->exception:" + localException.getStackTrace());
        }
        return null;
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      label194:
      localStringBuilder.append("]");
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
      label214:
      return localException;
    }
  }
  
  public List a(QQAppInterface paramQQAppInterface)
  {
    RecentUser localRecentUser = null;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "refreshDataList!");
    }
    if (paramQQAppInterface == null) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (!paramQQAppInterface.getAccount().equals(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "refreshDataList->new cuin:" + paramQQAppInterface.getAccount() + ", old cuin:" + this.jdField_a_of_type_JavaLangString);
      }
      a(paramQQAppInterface);
    }
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      localObject1 = TroopBarAssistantManager.a().a(paramQQAppInterface);
      localObject3 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (TroopBarData)((Iterator)localObject1).next();
        if (b(paramQQAppInterface, ((TroopBarData)localObject4).mUin))
        {
          localObject4 = SubscriptionFeed.a(paramQQAppInterface, paramQQAppInterface.getApplication(), (TroopBarData)localObject4);
          if (localObject4 != null)
          {
            if ((((SubscriptionFeed)localObject4).jdField_a_of_type_JavaUtilList != null) && (((SubscriptionFeed)localObject4).jdField_a_of_type_JavaUtilList.size() > 0))
            {
              localObject5 = (SubscriptionFeedItem)((SubscriptionFeed)localObject4).jdField_a_of_type_JavaUtilList.get(0);
              if ((TextUtils.isEmpty(((SubscriptionFeedItem)localObject5).jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(((SubscriptionFeedItem)localObject5).jdField_c_of_type_JavaLangString))) {
                ((SubscriptionFeedItem)localObject5).jdField_b_of_type_JavaLangString = ((SubscriptionFeedItem)localObject5).jdField_c_of_type_JavaLangString;
              }
            }
            ((List)localObject3).add(localObject4);
          }
        }
      }
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject4 = ((List)localObject3).iterator();
      if (!QLog.isColorLevel()) {
        break label790;
      }
      localObject1 = new StringBuilder("refreshDataList->SubscriptionFeedList size:");
      ((StringBuilder)localObject1).append(((List)localObject3).size()).append(", content:{");
    }
    for (;;)
    {
      if (((Iterator)localObject4).hasNext())
      {
        localObject3 = (SubscriptionFeed)((Iterator)localObject4).next();
        if ((QLog.isColorLevel()) && (localObject1 != null)) {
          ((StringBuilder)localObject1).append("[").append(((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString).append(", ").append(((SubscriptionFeed)localObject3).jdField_a_of_type_Int).append("]");
        }
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString))
        {
          localObject5 = ServiceAccountFolderFeed.a(paramQQAppInterface, (SubscriptionFeed)localObject3);
          if (((ServiceAccountFolderFeed)localObject5).jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_JavaUtilList.add(localObject5);
            this.jdField_a_of_type_JavaUtilHashMap.put(((SubscriptionFeed)localObject3).jdField_a_of_type_JavaLangString, localObject5);
          }
        }
      }
      else
      {
        if ((QLog.isColorLevel()) && (localObject1 != null))
        {
          ((StringBuilder)localObject1).append("}");
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
        }
        for (;;)
        {
          localObject4 = paramQQAppInterface.a().a().a(false);
          if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
            break label772;
          }
          localObject3 = ((List)localObject4).iterator();
          localObject1 = localRecentUser;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder("refreshDataList->RecentList size:");
            ((StringBuilder)localObject1).append(((List)localObject4).size()).append(", content:{");
          }
          while (((Iterator)localObject3).hasNext())
          {
            localRecentUser = (RecentUser)((Iterator)localObject3).next();
            if ((QLog.isColorLevel()) && (localObject1 != null)) {
              ((StringBuilder)localObject1).append("[").append(localRecentUser.uin).append(", ").append(localRecentUser.type).append("]");
            }
            if ((localRecentUser.type == 1008) && (b(paramQQAppInterface, localRecentUser.uin)) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localRecentUser.uin)))
            {
              localObject4 = ServiceAccountFolderFeed.a(paramQQAppInterface, localRecentUser);
              if (((ServiceAccountFolderFeed)localObject4).jdField_b_of_type_Boolean)
              {
                this.jdField_a_of_type_JavaUtilList.add(localObject4);
                this.jdField_a_of_type_JavaUtilHashMap.put(localRecentUser.uin, localObject4);
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "refreshDataList->empty SubscriptionFeedList!");
          }
        }
        if ((QLog.isColorLevel()) && (localObject1 != null))
        {
          ((StringBuilder)localObject1).append("}");
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
        }
        for (;;)
        {
          h(paramQQAppInterface);
          return this.jdField_a_of_type_JavaUtilList;
          label772:
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "refreshDataList->empty RecentList!");
          }
        }
        label790:
        localObject1 = null;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getAccount())))
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
      if (localSharedPreferences != null)
      {
        this.jdField_c_of_type_Long = localSharedPreferences.getLong("service_account_folder_last_read_time", 0L);
        this.d = localSharedPreferences.getLong("service_account_folder_last_enter_time", 0L);
        PublicAccountConfigUtil.p = localSharedPreferences.getBoolean("service_folder_redclean_after_enter", false);
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "initManager->mFolderLastReadTime:" + this.jdField_c_of_type_Long + ", mFolderLastEnterTime:" + this.d);
        }
      }
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
      this.jdField_a_of_type_Boolean = false;
      b(paramQQAppInterface);
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, true);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "initManager->cuin:" + this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.d = paramLong;
    ThreadManager.executeOnFileThread(new mqt(this, paramQQAppInterface));
  }
  
  public void a(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed, boolean paramBoolean)
  {
    String str = paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "deleteServiceAccountFolderFeed->puin:" + str + ", needRefresh:" + paramBoolean);
    }
    for (;;)
    {
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
          paramServiceAccountFolderFeed = paramQQAppInterface.a().a().b(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, 1008);
          if (paramServiceAccountFolderFeed != null) {
            RecentUtil.a(paramQQAppInterface, paramServiceAccountFolderFeed, -1);
          }
          if (paramBoolean)
          {
            h(paramQQAppInterface);
            j(paramQQAppInterface);
          }
          return;
        }
      }
      TroopBarAssistantManager.a().a(str, paramQQAppInterface);
      RecentUtil.b(paramQQAppInterface, str, PublicAccountUtil.b(paramQQAppInterface, str));
      paramQQAppInterface.a().c(str, 1008);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, AccountDetail paramAccountDetail)
  {
    paramAccountDetail = paramAccountDetail.uin;
    if (TextUtils.isEmpty(paramAccountDetail))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "handleAccountDetailChange->empty uin");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "handleAccountDetailChange->update feed");
    }
    a(paramQQAppInterface, paramAccountDetail);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "addMessageToServiceAccountFolder->friend uin:" + paramObject.frienduin + ", istroop:" + paramObject.istroop);
      }
      if ((paramObject.istroop == 1008) && (b(paramQQAppInterface, paramObject.frienduin))) {
        break label116;
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(ServiceAccountFolderActivity.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(102);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "addMessageToServiceAccountFolder->msg not belong serviceAccountFolder");
      }
    }
    for (;;)
    {
      return;
      label116:
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "addMessageToServiceAccountFolder->go to update feed");
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        ThreadManager.executeOnSubThread(new mqr(this, paramQQAppInterface, paramObject));
      }
      while (!paramObject.isSendFromLocal())
      {
        b(paramQQAppInterface, 0L);
        return;
        a(paramQQAppInterface, paramObject.frienduin);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnSubThread(new mqw(this, paramQQAppInterface, paramString));
      return;
    }
    ServiceAccountFolderFeed localServiceAccountFolderFeed;
    Object localObject2;
    int i;
    label184:
    label316:
    label356:
    int j;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localServiceAccountFolderFeed = (ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString = paramString;
          localObject2 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
          if (localObject2 != null)
          {
            PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)localObject2).c(paramString);
            if (localPublicAccountInfo == null) {
              break label710;
            }
            localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
            localServiceAccountFolderFeed.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
            if (localPublicAccountInfo.certifiedGrade > 0L) {
              localServiceAccountFolderFeed.jdField_c_of_type_Int = 2130839745;
            }
          }
          else
          {
            localServiceAccountFolderFeed.jdField_b_of_type_Int = paramQQAppInterface.a().b(paramString, 1008);
            i = paramQQAppInterface.a().f(paramString, 1008);
            if (localServiceAccountFolderFeed.jdField_b_of_type_Int <= 0) {
              break label805;
            }
            if ((localServiceAccountFolderFeed.jdField_b_of_type_Int != 1) || (i <= 0)) {
              break;
            }
            localServiceAccountFolderFeed.jdField_a_of_type_Int = 2;
            localObject2 = paramQQAppInterface.a();
            if (localObject2 == null) {
              break label1009;
            }
            localServiceAccountFolderFeed.jdField_b_of_type_JavaLangCharSequence = null;
            localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((QQMessageFacade)localObject2).b(paramString, 1008);
            localObject2 = ((QQMessageFacade)localObject2).a(paramString, 1008);
            if ((localObject2 == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject2).getSummary()))) {
              break label871;
            }
            if ((localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((DraftSummaryInfo)localObject2).getTime() <= localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
              break label814;
            }
            localServiceAccountFolderFeed.e = 4;
            localServiceAccountFolderFeed.jdField_a_of_type_Long = ((DraftSummaryInfo)localObject2).getTime();
            localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = TimeManager.a().a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, ((DraftSummaryInfo)localObject2).getTime());
            localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = ((DraftSummaryInfo)localObject2).getSummary();
            i = 0;
            localServiceAccountFolderFeed.d = a(paramQQAppInterface, localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
            localServiceAccountFolderFeed.jdField_a_of_type_Boolean = true;
            if (!TroopBarAssistantManager.a().a(paramQQAppInterface, paramString, 1008)) {
              break label965;
            }
            localServiceAccountFolderFeed.jdField_a_of_type_Boolean = false;
            if ((paramQQAppInterface.a() == null) || (paramQQAppInterface.a().a() == null)) {
              break label1006;
            }
            localObject2 = paramQQAppInterface.a().a().a(paramString, 1008);
            if (localObject2 == null) {
              break label1006;
            }
            localServiceAccountFolderFeed.jdField_b_of_type_Long = ((RecentUser)localObject2).lastmsgtime;
            if ((i == 0) || (localServiceAccountFolderFeed.jdField_b_of_type_Long <= 0L)) {
              break label1006;
            }
            localServiceAccountFolderFeed.jdField_a_of_type_Long = localServiceAccountFolderFeed.jdField_b_of_type_Long;
            localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = TimeManager.a().a(paramString, localServiceAccountFolderFeed.jdField_a_of_type_Long);
            localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = "";
            i = 0;
            label454:
            if (QLog.isColorLevel()) {
              QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderFeed->" + localServiceAccountFolderFeed.toString());
            }
            if (PublicAccountUtil.a(paramQQAppInterface, paramString) != -7) {
              break label1000;
            }
            j = 1;
            label503:
            if ((QLog.isColorLevel()) && (j != 0)) {
              QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderFeed->puin:" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + " is Eqq!");
            }
            if ((!localServiceAccountFolderFeed.jdField_b_of_type_Boolean) || (i != 0) || (j != 0) || (!b(paramQQAppInterface, paramString)))
            {
              this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
              this.jdField_a_of_type_JavaUtilList.remove(localServiceAccountFolderFeed);
              if (QLog.isColorLevel()) {
                QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderFeed->remove feed puin:" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + ", title:" + localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
              }
            }
            h(paramQQAppInterface);
            j(paramQQAppInterface);
          }
        }
        else
        {
          localServiceAccountFolderFeed = new ServiceAccountFolderFeed();
          this.jdField_a_of_type_JavaUtilList.add(localServiceAccountFolderFeed);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localServiceAccountFolderFeed);
          continue;
        }
        localServiceAccountFolderFeed.jdField_c_of_type_Int = 0;
      }
      label710:
      localObject2 = ((PublicAccountDataManager)localObject2).b(paramString);
      if (localObject2 != null)
      {
        localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString = ((AccountDetail)localObject2).name;
        if (1 != ((AccountDetail)localObject2).showFlag) {
          break label1014;
        }
      }
    }
    label805:
    label814:
    label871:
    label1000:
    label1006:
    label1009:
    label1014:
    for (boolean bool = true;; bool = false)
    {
      localServiceAccountFolderFeed.jdField_b_of_type_Boolean = bool;
      if (((AccountDetail)localObject2).certifiedGrade > 0)
      {
        localServiceAccountFolderFeed.jdField_c_of_type_Int = 2130839745;
        break;
      }
      localServiceAccountFolderFeed.jdField_c_of_type_Int = 0;
      break;
      localServiceAccountFolderFeed.jdField_a_of_type_Int = 1;
      if (i <= 0) {
        break label184;
      }
      localServiceAccountFolderFeed.jdField_b_of_type_Int -= 1;
      break label184;
      localServiceAccountFolderFeed.jdField_a_of_type_Int = 0;
      break label184;
      localServiceAccountFolderFeed.e = 0;
      localServiceAccountFolderFeed.jdField_a_of_type_Long = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
      localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = TimeManager.a().a(paramString, localServiceAccountFolderFeed.jdField_a_of_type_Long);
      localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = a(paramQQAppInterface, localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
      i = 0;
      break label316;
      if (localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localServiceAccountFolderFeed.e = 0;
        localServiceAccountFolderFeed.jdField_a_of_type_Long = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = TimeManager.a().a(paramString, localServiceAccountFolderFeed.jdField_a_of_type_Long);
        localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = a(paramQQAppInterface, localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
        i = 0;
        break label316;
      }
      localServiceAccountFolderFeed.e = 0;
      localServiceAccountFolderFeed.jdField_a_of_type_Long = 0L;
      localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString = null;
      localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence = null;
      i = 1;
      break label316;
      if ((localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!"1".equals(localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("inter_num")))) {
        break label356;
      }
      localServiceAccountFolderFeed.jdField_a_of_type_Boolean = false;
      break label356;
      j = 0;
      break label503;
      break label454;
      i = 0;
      break label316;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "updateDraft->puin:" + paramString1);
    }
    a(paramQQAppInterface, paramString1);
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderHasLittleRedDot->mFolderHasLittleRedDot:" + this.jdField_c_of_type_Boolean);
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
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "containsFeedWithUin->uin:" + paramString + ", return " + bool);
      }
      return bool;
    }
  }
  
  public int b()
  {
    if (this.e > this.jdField_c_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadNum->mFolderUnreadNum:" + this.jdField_a_of_type_Int);
      }
      if ((PublicAccountConfigUtil.a()) && (this.d >= this.e)) {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "enter time:" + this.d + "  Last msgtime=" + this.e);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return 0;
      return this.jdField_a_of_type_Int;
    }
    QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadNum->0");
    return 0;
  }
  
  public long b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderLastEnterTime->mFolderLastEnterTime:" + this.d);
    }
    return this.d;
  }
  
  public long b(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_b_of_type_Long == 0L) && (!this.jdField_a_of_type_Boolean))
    {
      f(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderOperationTime->mFolderOperationTime:" + this.jdField_b_of_type_Long);
    }
    return this.jdField_b_of_type_Long;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_Boolean))
    {
      f(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderShowTime->mFolderShowTime:" + this.jdField_b_of_type_JavaLangString);
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnSubThread(new mqq(this, paramQQAppInterface));
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "refreshAndUpdate->cuin:" + this.jdField_a_of_type_JavaLangString + ", throw to sub thread!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "refreshAndUpdate->cuin:" + this.jdField_a_of_type_JavaLangString);
    }
    a(paramQQAppInterface);
    j(paramQQAppInterface);
  }
  
  public void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    this.d = paramLong;
    ThreadManager.executeOnFileThread(new mqu(this, paramQQAppInterface));
  }
  
  public void b(QQAppInterface paramQQAppInterface, ServiceAccountFolderFeed paramServiceAccountFolderFeed, boolean paramBoolean)
  {
    if (paramServiceAccountFolderFeed == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int -= paramServiceAccountFolderFeed.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Int = 0;
      }
      paramServiceAccountFolderFeed.jdField_b_of_type_Int = 0;
      paramServiceAccountFolderFeed = paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
      RecentUtil.b(paramQQAppInterface, paramServiceAccountFolderFeed, 1008);
      paramQQAppInterface.a().c(paramServiceAccountFolderFeed, 1008);
      paramQQAppInterface.a().a(paramServiceAccountFolderFeed, 1008, true);
      a(paramQQAppInterface, paramServiceAccountFolderFeed);
      if (paramBoolean) {
        i(paramQQAppInterface);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ServiceAccountFolderManager", 2, "clearServiceAccountFolderFeedUnreadNum->uin:" + paramServiceAccountFolderFeed + ", needRefresh:" + paramBoolean);
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "isLastDraftMsg->lastDraft:" + this.jdField_b_of_type_Boolean);
    }
    return this.jdField_b_of_type_Boolean;
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
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "deleteServiceAccountFolder->time:" + l);
    }
    ThreadManager.executeOnSubThread(new mqs(this, paramQQAppInterface, l));
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "clearServiceAccountFolderUnreadNum");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = (ServiceAccountFolderFeed)localIterator.next();
        ((ServiceAccountFolderFeed)localObject2).jdField_b_of_type_Int = 0;
        localObject2 = ((ServiceAccountFolderFeed)localObject2).jdField_a_of_type_JavaLangString;
        RecentUtil.b(paramQQAppInterface, (String)localObject2, 1008);
        paramQQAppInterface.a().c((String)localObject2, 1008);
        paramQQAppInterface.a().a((String)localObject2, 1008, true);
      }
    }
    this.jdField_a_of_type_Int = 0;
    b(paramQQAppInterface);
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_Long = paramQQAppInterface.getLong("service_account_folder_display_time", 0L);
      this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getString("service_account_folder_time", "");
      this.jdField_b_of_type_Long = paramQQAppInterface.getLong("service_account_folder_operation_time", 0L);
      this.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getString("service_account_folder_brief", "");
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderLocalData->mFolderDisplayTime:" + this.jdField_a_of_type_Long + ", mFolderShowTime:" + this.jdField_b_of_type_JavaLangString + ", mFolderOperationTime:" + this.jdField_b_of_type_Long + ", mFolderMsgBrief:" + this.jdField_a_of_type_JavaLangCharSequence);
      }
    }
  }
  
  public void g(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new mqv(this, paramQQAppInterface));
  }
  
  public void h(QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      int k;
      long l4;
      Object localObject6;
      int m;
      Object localObject1;
      long l3;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      boolean bool1;
      Object localObject7;
      boolean bool2;
      int j;
      long l1;
      Object localObject5;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        RecentUtil.a(this.jdField_a_of_type_JavaUtilList);
        Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderManager$FeedComparator);
        k = 0;
        l4 = 0L;
        localObject6 = "";
        m = 0;
        long l2 = 0L;
        localObject1 = "";
        l3 = 0L;
        localObject2 = "";
        localObject3 = "";
        localObject4 = "";
        int i = 0;
        bool1 = false;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          localObject7 = (ServiceAccountFolderFeed)localIterator.next();
          if (((ServiceAccountFolderFeed)localObject7).jdField_a_of_type_Int == 2)
          {
            bool2 = true;
            j = k;
            l1 = l4;
            if (((ServiceAccountFolderFeed)localObject7).jdField_b_of_type_Int > 0)
            {
              l1 = l4;
              if (((ServiceAccountFolderFeed)localObject7).jdField_a_of_type_Long >= l4) {
                l1 = ((ServiceAccountFolderFeed)localObject7).jdField_a_of_type_Long;
              }
            }
            l4 = l3;
            if (((ServiceAccountFolderFeed)localObject7).jdField_b_of_type_Long > l3) {
              l4 = ((ServiceAccountFolderFeed)localObject7).jdField_b_of_type_Long;
            }
            k = m;
            localObject5 = localObject6;
            if (((ServiceAccountFolderFeed)localObject7).jdField_b_of_type_Int > 0)
            {
              k = m;
              localObject5 = localObject6;
              if (m == 0)
              {
                k = m;
                localObject5 = localObject6;
                if (!TextUtils.isEmpty(((ServiceAccountFolderFeed)localObject7).d))
                {
                  localObject5 = ((ServiceAccountFolderFeed)localObject7).d;
                  k = 1;
                }
              }
            }
            if ((i != 0) || (TextUtils.isEmpty(((ServiceAccountFolderFeed)localObject7).jdField_a_of_type_JavaLangCharSequence))) {
              break label799;
            }
            l2 = ((ServiceAccountFolderFeed)localObject7).jdField_a_of_type_Long;
            localObject4 = ((ServiceAccountFolderFeed)localObject7).jdField_b_of_type_JavaLangString;
            localObject3 = ((ServiceAccountFolderFeed)localObject7).jdField_c_of_type_JavaLangString;
            localObject2 = ((ServiceAccountFolderFeed)localObject7).jdField_a_of_type_JavaLangString;
            localObject1 = ((ServiceAccountFolderFeed)localObject7).jdField_a_of_type_JavaLangCharSequence;
            i = 1;
            break label823;
          }
          bool2 = bool1;
          j = k;
          if (((ServiceAccountFolderFeed)localObject7).jdField_a_of_type_Int != 1) {
            continue;
          }
          j = k + ((ServiceAccountFolderFeed)localObject7).jdField_b_of_type_Int;
          bool2 = bool1;
          continue;
        }
        this.jdField_a_of_type_Int = k;
        this.jdField_c_of_type_Boolean = bool1;
        this.e = l4;
        this.jdField_c_of_type_JavaLangString = ((String)localObject6);
        this.jdField_a_of_type_Long = l2;
        this.jdField_b_of_type_JavaLangString = ((String)localObject1);
        this.jdField_b_of_type_Long = l3;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label703;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.jdField_a_of_type_JavaLangCharSequence = new QQText((CharSequence)localObject4, 3, 16).a((String)localObject2 + "：", true, new int[0]);
          if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
            break label791;
          }
          if (((ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(0)).e != 4) {
            break label873;
          }
          bool1 = true;
          this.jdField_b_of_type_Boolean = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "generateFolderDescription->mFolderDisplayTime:" + this.jdField_a_of_type_Long + ", mFolderShowTime:" + this.jdField_b_of_type_JavaLangString + ", mFolderExtraInfo:" + this.jdField_c_of_type_JavaLangString + ", mFolderMsgBrief:" + this.jdField_a_of_type_JavaLangCharSequence + ", mFolderUnreadNum:" + this.jdField_a_of_type_Int + ", maxUnreadDisplayTime:" + this.e + ", mFolderLastReadTime:" + this.jdField_c_of_type_Long + ", mFolderLastEnterTime:" + this.d + ", mFolderHasLittleRedDot:" + this.jdField_c_of_type_Boolean + ", lastDraft:" + this.jdField_b_of_type_Boolean);
          }
          g(paramQQAppInterface);
          return;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          this.jdField_a_of_type_JavaLangCharSequence = new QQText((CharSequence)localObject4, 3, 16).a((String)localObject3 + "：", true, new int[0]);
        }
      }
      this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject4);
      label791:
      label799:
      label823:
      if (this.jdField_a_of_type_JavaLangCharSequence == null)
      {
        this.jdField_a_of_type_JavaLangCharSequence = "";
        continue;
        label703:
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          this.jdField_a_of_type_Long = ((ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long;
          this.jdField_b_of_type_JavaLangString = ((ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangCharSequence = ((ServiceAccountFolderFeed)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangCharSequence;
          if (this.jdField_a_of_type_JavaLangCharSequence == null)
          {
            this.jdField_a_of_type_JavaLangCharSequence = "";
            continue;
            this.jdField_b_of_type_Boolean = false;
            continue;
            localObject6 = localObject4;
            localObject7 = localObject3;
            localObject4 = localObject1;
            localObject3 = localObject2;
            localObject2 = localObject7;
            localObject1 = localObject6;
            localObject6 = localObject4;
            localObject7 = localObject3;
            localObject4 = localObject1;
            localObject3 = localObject2;
            localObject2 = localObject7;
            localObject1 = localObject6;
            m = k;
            localObject6 = localObject5;
            l3 = l4;
            l4 = l1;
            bool1 = bool2;
            k = j;
            continue;
            label873:
            bool1 = false;
          }
        }
      }
    }
  }
  
  public void i(QQAppInterface paramQQAppInterface)
  {
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.at, 7230);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        if (localRecentUser != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderInMsgTab->删除folder节点");
          }
          localRecentUserProxy.b(localRecentUser);
        }
        return;
      }
      ??? = localRecentUser;
      if (localRecentUser == null)
      {
        localRecentUser = new RecentUser();
        localRecentUser.uin = AppConstants.at;
        localRecentUser.type = 7230;
        localRecentUser.displayName = a(paramQQAppInterface);
        ??? = localRecentUser;
        if (QLog.isColorLevel())
        {
          QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderInMsgTab->新增folder节点");
          ??? = localRecentUser;
        }
      }
      long l1 = a(paramQQAppInterface);
      long l2 = b(paramQQAppInterface);
      ((RecentUser)???).lastmsgtime = Math.max(l1, l2);
      localRecentUserProxy.a((RecentUser)???);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderInMsgTab->更新folder节点:tempFolderDisplayTime:" + l1 + ", tempFolderOperationTime:" + l2 + ", ru.lastmsgtime:" + ((RecentUser)???).lastmsgtime);
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.sendEmptyMessage(1009);
        return;
      }
    }
  }
  
  public void j(QQAppInterface paramQQAppInterface)
  {
    i(paramQQAppInterface);
    paramQQAppInterface = paramQQAppInterface.getHandler(ServiceAccountFolderActivity.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(100);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "refreshFolderAndActivityUI");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager
 * JD-Core Version:    0.7.0.1
 */