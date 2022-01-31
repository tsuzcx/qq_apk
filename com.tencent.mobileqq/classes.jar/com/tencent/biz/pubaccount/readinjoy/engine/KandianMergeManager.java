package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyStringUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyTabObserver;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mp.mobileqq_mp.GetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import lnw;
import lnx;
import lny;
import lnz;
import loa;
import lob;
import loc;
import lod;
import loe;
import lof;
import log;
import loh;
import loi;
import loj;
import lok;
import lol;
import lom;
import loo;
import lop;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.BiuBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.NotifyBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.StyleSheet;

public class KandianMergeManager
  implements Manager
{
  public static String b;
  public static String c;
  public int a;
  public long a;
  private KandianMergeManager.KandianSetTopInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo;
  private volatile Kandian210Msg0xeeInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo;
  private KandianOx210MsgInfo.Biu0x210Msg jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg;
  private KandianOx210MsgInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
  private KandianRedDotInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new loi(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Long jdField_a_of_type_JavaLangLong;
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  public boolean a;
  private int jdField_b_of_type_Int;
  public long b;
  private KandianOx210MsgInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private List jdField_b_of_type_JavaUtilList;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicLong jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong;
  private KandianOx210MsgInfo jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
  private List jdField_c_of_type_JavaUtilList;
  private AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private KandianOx210MsgInfo jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
  private String jdField_d_of_type_JavaLangString;
  private AtomicInteger jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private String jdField_e_of_type_JavaLangString;
  private AtomicInteger jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private String f;
  private String g;
  
  static
  {
    jdField_b_of_type_JavaLangString = "PUSH_0X210_ORANGE_KEY";
    jdField_c_of_type_JavaLangString = "indepenttab_self_erasure_red";
  }
  
  public KandianMergeManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    q();
    KandianHBManager.a();
    ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)paramQQAppInterface.getManager(162);
    localReadInJoyLogicManager.a().a(0, 20, 9223372036854775807L, true);
    localReadInJoyLogicManager.a().a(56, 20, 9223372036854775807L, true);
    localReadInJoyLogicManager.a().a(70, 20, 9223372036854775807L, true);
    localReadInJoyLogicManager.a().b(0);
    localReadInJoyLogicManager.a().d(0);
    ReadinjoySPEventReport.g();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public static int a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        return -1;
      } while (((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.at)));
      if ((paramMessageRecord.extInt == 1) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.at))) {
        return 0;
      }
      if ((paramMessageRecord.extInt == 2) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.at))) {
        return 1;
      }
      if (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.as)) {
        return 0;
      }
    } while ((paramMessageRecord.istroop != 1008) || (!ServiceAccountFolderManager.c(paramQQAppInterface, paramMessageRecord.frienduin)));
    return 1;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {}
    while ((!paramBoolean) && ((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.msg, paramString1))) {
      return null;
    }
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.msgtype = -1000;
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, int paramInt)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    localMessageRecord.frienduin = AppConstants.at;
    localMessageRecord.senderuin = AppConstants.as;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 6;
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localMessageRecord.extLong |= 0x2;
      localMessageRecord.extLong |= 0x1;
    }
    for (;;)
    {
      localMessageRecord.isread = false;
      localMessageRecord.issend = 0;
      localMessageRecord.msg = paramString1;
      localMessageRecord.time = paramLong1;
      try
      {
        if (TextUtils.isEmpty(localMessageRecord.extStr))
        {
          paramString1 = new JSONObject();
          paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
          paramString1.put("strategy_id", paramLong2);
          paramString1.put("algorithm_id", paramLong3);
          paramString1.put("article_id", paramLong4);
          paramString1.put("folder_status", paramLong5);
        }
        for (localMessageRecord.extStr = paramString1.toString();; localMessageRecord.extStr = paramString1.toString())
        {
          localMessageRecord.vipBubbleID = -999L;
          ReadInJoyUtils.a(localMessageRecord);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          return localMessageRecord;
          localMessageRecord.extLong |= 0x2;
          break;
          paramString1 = new JSONObject(localMessageRecord.extStr);
          paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
          paramString1.put("strategy_id", paramLong2);
          paramString1.put("algorithm_id", paramLong3);
          paramString1.put("article_id", paramLong4);
          paramString1.put("folder_status", paramLong5);
        }
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          localMessageRecord.extStr = null;
        }
      }
    }
  }
  
  private MessageRecord a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    boolean bool = ReadInJoyHelper.k();
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    localMessageRecord.frienduin = AppConstants.at;
    localMessageRecord.senderuin = AppConstants.as;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 5;
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localMessageRecord.extLong |= 0x2;
      localMessageRecord.extLong |= 0x1;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        localMessageRecord.extInt = 2;
        bool = ReadInJoyHelper.b(paramString3);
      }
      localMessageRecord.issend = 0;
      localMessageRecord.isread = false;
      localMessageRecord.msg = paramString1;
      localMessageRecord.time = paramLong;
      try
      {
        this.jdField_d_of_type_JavaLangString = paramString3;
        if (TextUtils.isEmpty(localMessageRecord.extStr))
        {
          paramString1 = new JSONObject();
          paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
          paramString1.put("kdUin", this.jdField_d_of_type_JavaLangString);
          paramString1.put("kdShouldShowMergedAvatar", bool);
        }
        for (localMessageRecord.extStr = paramString1.toString();; localMessageRecord.extStr = paramString1.toString())
        {
          if (!g()) {
            break label360;
          }
          localMessageRecord.vipBubbleID = -1000L;
          if ((localMessageRecord.vipBubbleID == -1000L) && (!paramBoolean1)) {
            localMessageRecord.extStr = null;
          }
          if (KandianAppInPush.a().a(2000002)) {
            break label385;
          }
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          ReadInJoyUtils.a(localMessageRecord);
          paramString1.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          return localMessageRecord;
          localMessageRecord.extLong |= 0x2;
          break;
          paramString1 = new JSONObject(localMessageRecord.extStr);
          paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
          paramString1.put("kdUin", this.jdField_d_of_type_JavaLangString);
          paramString1.put("kdShouldShowMergedAvatar", bool);
        }
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          localMessageRecord.extStr = null;
        }
        label360:
        if (paramBoolean1) {}
        for (paramLong = -999L;; paramLong = -1000L)
        {
          localMessageRecord.vipBubbleID = paramLong;
          break;
        }
        label385:
        QLog.w("KandianMergeManager", 2, "app in push is showing, abandon 210 push update msg table!");
      }
    }
    return localMessageRecord;
  }
  
  private void a(KandianOx210MsgInfo paramKandianOx210MsgInfo, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
    if (localObject != null)
    {
      if (localObject != null) {
        QLog.d("KandianMergeManager", 1, "0x210Msg reached, oldSeq = " + ((KandianOx210MsgInfo)localObject).jdField_b_of_type_Long + ", newSeq = " + paramKandianOx210MsgInfo.jdField_b_of_type_Long);
      }
      if (((KandianOx210MsgInfo)localObject).jdField_b_of_type_Long >= paramKandianOx210MsgInfo.jdField_b_of_type_Long)
      {
        if (((KandianOx210MsgInfo)localObject).jdField_b_of_type_Long != paramKandianOx210MsgInfo.jdField_b_of_type_Long) {}
        for (;;)
        {
          if (bool1) {
            ((KandianOx210MsgInfo)localObject).jdField_a_of_type_Int += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("KandianMergeManager", 2, "0x210msg delay reach , has a latest msg , no cover! needAddCount : " + bool1);
          }
          return;
          bool1 = false;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null) {
      paramKandianOx210MsgInfo.jdField_a_of_type_Int += this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = paramKandianOx210MsgInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Int == 1)
    {
      paramKandianOx210MsgInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString;
      paramLong = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Long;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.g == 0) {
        bool1 = true;
      }
    }
    for (paramKandianOx210MsgInfo = a(paramKandianOx210MsgInfo, (String)localObject, paramLong, bool1, false, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Long));; paramKandianOx210MsgInfo = null)
    {
      localObject = new StringBuilder().append("has 0x210 msg push , brief : ").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString).append(", showInFolder : ");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Int == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject = ((StringBuilder)localObject).append(bool1).append(", showLockScreen : ");
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.f == 1) {
          bool1 = true;
        }
        QLog.d("KandianMergeManager", 1, bool1 + ", redType : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.g + ", msgSeq : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_Long + ", orangeWord : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString + ", msgCount : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int);
        t();
        a(paramKandianOx210MsgInfo, KandianOx210MsgInfo.k, null);
        l();
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((KandianMergeManager.MessageObserver)localIterator.next()).a(paramMessageRecord, paramInt, paramBundle);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = AppConstants.at;
    paramMessageRecord.senderuin = AppConstants.at;
    paramMessageRecord.istroop = 7220;
    paramMessageRecord.msg = paramString1;
    for (;;)
    {
      try
      {
        paramMessageRecord.time = Long.parseLong(paramString2);
        paramMessageRecord.createMessageUniseq();
        if (paramInt == 0)
        {
          paramMessageRecord.extInt = 3;
          paramMessageRecord.extLong = 0;
          return;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
      if (paramInt == 1) {
        paramMessageRecord.extInt = 4;
      } else if (paramInt == 5) {
        paramMessageRecord.extInt = paramInt;
      } else {
        paramMessageRecord.extInt = 0;
      }
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return (KandianOx210MsgInfo.c(paramArrayOfByte) != 2) && (KandianOx210MsgInfo.a(paramArrayOfByte) == KandianOx210MsgInfo.k) && (KandianOx210MsgInfo.b(paramArrayOfByte) == KandianOx210MsgInfo.n);
  }
  
  private void b(KandianOx210MsgInfo paramKandianOx210MsgInfo, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    Object localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
    if (localObject != null)
    {
      if (localObject != null) {
        QLog.d("KandianMergeManager", 1, "0x210MsgSys reached, oldSeq = " + ((KandianOx210MsgInfo)localObject).jdField_b_of_type_Long + ", newSeq = " + paramKandianOx210MsgInfo.jdField_b_of_type_Long);
      }
      if (((KandianOx210MsgInfo)localObject).jdField_b_of_type_Long >= paramKandianOx210MsgInfo.jdField_b_of_type_Long)
      {
        if (((KandianOx210MsgInfo)localObject).jdField_b_of_type_Long != paramKandianOx210MsgInfo.jdField_b_of_type_Long) {}
        for (;;)
        {
          if (bool1) {
            ((KandianOx210MsgInfo)localObject).jdField_a_of_type_Int += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("KandianMergeManager", 2, "0x210msgSys delay reach , has a latest msg , no cover! needAddCount : " + bool1);
          }
          return;
          bool1 = false;
        }
      }
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null) {
      paramKandianOx210MsgInfo.jdField_a_of_type_Int += this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = paramKandianOx210MsgInfo;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Long = paramLong;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Long = -1L;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Int == 1)
    {
      paramKandianOx210MsgInfo = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString;
      localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString;
      paramLong = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Long;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.g == 0) {
        bool1 = true;
      }
    }
    for (paramKandianOx210MsgInfo = a(paramKandianOx210MsgInfo, (String)localObject, paramLong, bool1, false, null);; paramKandianOx210MsgInfo = null)
    {
      localObject = new StringBuilder().append("has ox210PushMsgSys msg push , brief : ").append(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString).append(", showInFolder : ");
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Int == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject = ((StringBuilder)localObject).append(bool1).append(", showLockScreen : ");
        bool1 = bool2;
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.f == 1) {
          bool1 = true;
        }
        QLog.d("KandianMergeManager", 1, bool1 + ", redType : " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.g + ", msgSeq : " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_Long + ", orangeWord : " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString + ", msgCount : " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int);
        t();
        a(paramKandianOx210MsgInfo, KandianOx210MsgInfo.k, null);
        l();
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((KandianMergeManager.MessageObserver)localIterator.next()).a(paramMessageRecord);
      }
    }
  }
  
  private void q()
  {
    i = 0;
    Object localObject1 = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    Object localObject2 = ((SharedPreferences)localObject1).getString("kandian_push_msg_xml", "");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject2 = StructMsgFactory.a(PkgTools.a((String)localObject2));
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mArticleIds))
      {
        String[] arrayOfString = ((AbsStructMsg)localObject2).mArticleIds.split("\\|");
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < arrayOfString.length)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(arrayOfString[i]));
          i += 1;
        }
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mMsgActionData)) {
        this.jdField_a_of_type_JavaLangString = ((AbsStructMsg)localObject2).mMsgActionData;
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mAlgorithmIds)) {
        this.jdField_a_of_type_Long = Long.parseLong(localObject2.mAlgorithmIds.split("\\|")[0]);
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject2).mStrategyIds)) {
        this.jdField_b_of_type_Long = Long.parseLong(localObject2.mStrategyIds.split("\\|")[0]);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      l = ((SharedPreferences)localObject1).getLong("kandian_push_msg_time", 0L);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l;
        localException.printStackTrace();
        continue;
        i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int;
      }
    }
    this.f = "";
    this.g = "";
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(-1L);
    l = ((SharedPreferences)localObject1).getLong("subscribe_push_msg_time", 0L);
    if (l > 0L)
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
      this.jdField_e_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("subscribe_push_msg_uin", "");
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(((SharedPreferences)localObject1).getInt("subscribe_push_msg_status", -1));
      this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(((SharedPreferences)localObject1).getInt("subscribe_push_msg_msgtype", -1));
      if ((this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1)) {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = KandianOx210MsgInfo.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg = KandianOx210MsgInfo.Biu0x210Msg.a();
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = KandianOx210MsgInfo.b();
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = KandianOx210MsgInfo.c();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = KandianOx210MsgInfo.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo = Kandian210Msg0xeeInfo.getKandian210Msg0xeeInfoFromSp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QLog.d("KandianAppInPush", 2, "init app push info from cache : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo);
    if (this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString)) {
        this.f = this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo = ((KandianMergeManager.KandianSetTopInfo)ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_msgtab_settop", true));
    QLog.d("KandianMergeManager.SETTOP", 2, "get from cache : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("InitCache ox210PushMsg count:");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo == null)
      {
        i = -1;
        QLog.d("KandianMergeManager.SETTOP", 2, i);
      }
    }
    else
    {
      r();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.getRedDotFromDisk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_video_tab_reddot_info", true);
      QLog.d("KandianMergeManager", 1, "init mianVideoTabRed : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo);
      this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_lock_screen_push_info", true));
      QLog.d("KandianMergeManager", 2, "lock screen push info : " + this.jdField_b_of_type_JavaUtilArrayList);
      return;
    }
  }
  
  private void r()
  {
    ThreadManager.post(new loh(this), 8, null, false);
  }
  
  private void s()
  {
    boolean bool2 = false;
    Object localObject1 = null;
    Object localObject2;
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Int == 1)
    {
      localObject1 = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString;
      localObject2 = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString;
      long l = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Long;
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.g == 0)
      {
        bool1 = true;
        localObject1 = a((String)localObject1, (String)localObject2, l, bool1, true, String.valueOf(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Long));
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Long);
        this.f = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString;
        a((MessageRecord)localObject1, true);
        this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
        this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("has 0x210 follow msg push , brief : ").append(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString).append(", showInFolder : ");
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Int != 1) {
        break label323;
      }
    }
    label323:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = ((StringBuilder)localObject2).append(bool1).append(", showLockScreen : ");
      bool1 = bool2;
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.f == 1) {
        bool1 = true;
      }
      QLog.d("KandianMergeManager", 1, bool1 + ", redType : " + this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.g + ", msgSeq : " + this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_Long + ", orangeWord : " + this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString + ", msgCount : " + this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("BID_TYPE", 2);
      a((MessageRecord)localObject1, KandianOx210MsgInfo.l, (Bundle)localObject2);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void t()
  {
    Object localObject = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false);
    if (localObject == null)
    {
      QLog.d("KandianMergeManager", 2, "updateIndependentTabSelfRedInfo() failed");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).remove(jdField_c_of_type_JavaLangString);
    ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return 0;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    }
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    for (;;)
    {
      return -1;
      if (!TextUtils.isEmpty(paramMessageRecord.extStr)) {
        try
        {
          paramMessageRecord = new JSONObject(paramMessageRecord.extStr);
          if (paramMessageRecord.has("kandian_push_from"))
          {
            int i = Integer.parseInt(paramMessageRecord.getString("kandian_push_from"));
            return i;
          }
        }
        catch (Exception paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null) {
      return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.c;
    }
    return 0L;
  }
  
  public Pair a()
  {
    if ((!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3)) || ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2))) {}
    do
    {
      return null;
      c(2);
      QLog.d("KandianMergeManager", 1, "mSubscribePushMsgTitle : " + ReadInJoyUtils.d(this.f) + " mSubscribePushMsgArticleID : " + this.jdField_a_of_type_JavaLangLong + " mInnerUniqId : " + this.g + " seedUIN :  " + this.jdField_e_of_type_JavaLangString + ", isInterestedAccount : " + PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    } while ((TextUtils.isEmpty(this.f)) || ((TextUtils.isEmpty(this.g)) && (this.jdField_a_of_type_JavaLangLong.longValue() == -1L)));
    if ((ReadInJoyHelper.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(this.g))) {
      return new Pair(this.g, this.f);
    }
    return new Pair(this.jdField_a_of_type_JavaLangLong, this.f);
  }
  
  public SparseIntArray a()
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.append(0, b(0));
    localSparseIntArray.append(1, b(1));
    localSparseIntArray.append(2, b(2));
    localSparseIntArray.append(3, b(3));
    return localSparseIntArray;
  }
  
  public KandianOx210MsgInfo.Biu0x210Msg a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.a())) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg;
    }
    return null;
  }
  
  public KandianOx210MsgInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
  }
  
  public KandianRedDotInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  }
  
  public MessageRecord a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.at, 7220);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4)) {}
        while ((!localMessageRecord.isValid) || (MsgProxyUtils.g(localMessageRecord.msgtype)))
        {
          i -= 1;
          break;
        }
      }
    }
    for (;;)
    {
      localObject = localMessageRecord;
      if (localMessageRecord == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.at, 7220, "extInt=1 OR extInt=3");
      }
      return localObject;
      localMessageRecord = null;
    }
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    Object localObject3 = null;
    if ((paramMessageRecord == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return null;
    }
    if ((a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) && (ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      return null;
    }
    if (KandianAppInPush.a().a(2000002))
    {
      QLog.d("KandianMergeManager", 2, "app in push is showing, abandon the new msg !");
      return null;
    }
    if (!a(paramMessageRecord)) {
      return null;
    }
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localQQMessageFacade != null) {}
    label535:
    label550:
    label810:
    label825:
    label836:
    label866:
    for (Object localObject1 = localQQMessageFacade.b(AppConstants.at, 7220);; localObject1 = null)
    {
      String str;
      Object localObject2;
      if ((localObject1 != null) && (a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) && (((MessageRecord)localObject1).extInt == 2) && (!((MessageRecord)localObject1).isread)) {
        if (QLog.isColorLevel())
        {
          str = "lastMr_info 【" + "msg: " + ReadInJoyUtils.d(((MessageRecord)localObject1).msg) + ", msguid : " + ((MessageRecord)localObject1).msgUid;
          localObject2 = str;
          if ((localObject1 instanceof MessageForStructing))
          {
            localMessageForStructing = (MessageForStructing)localObject1;
            localMessageForStructing.parse();
            localObject2 = str;
            if (localMessageForStructing.structingMsg != null) {
              localObject2 = str + ", title : " + ReadInJoyUtils.d(localMessageForStructing.structingMsg.mMsgBrief) + " 】";
            }
          }
          str = "newMr_info 【" + "msg: " + ReadInJoyUtils.d(paramMessageRecord.msg) + ", senderUin : " + paramMessageRecord.senderuin + " , msguid : " + paramMessageRecord.msgUid;
          if (!(paramMessageRecord instanceof MessageForStructing)) {
            break label896;
          }
          MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
          localMessageForStructing.parse();
          if (localMessageForStructing.structingMsg == null) {
            break label896;
          }
          str = str + ", title : " + ReadInJoyUtils.d(localMessageForStructing.structingMsg.mMsgBrief) + " 】";
        }
      }
      int i;
      label616:
      label891:
      for (;;)
      {
        QLog.i("KandianMergeManager", 2, "subscribe push msg cover ! \n" + (String)localObject2 + "\n" + str);
        localQQMessageFacade.a((MessageRecord)localObject1, false);
        localObject2 = MessageRecordFactory.a(paramMessageRecord.msgtype);
        MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, paramMessageRecord);
        ((MessageRecord)localObject2).frienduin = AppConstants.at;
        ((MessageRecord)localObject2).istroop = 7220;
        i = a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (i == 0)
        {
          ((MessageRecord)localObject2).extInt = 1;
          a((MessageRecord)localObject2, 0);
          if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label810;
          }
          ((MessageRecord)localObject2).extLong |= 0x2;
          ((MessageRecord)localObject2).extLong |= 0x1;
          if (!g()) {
            break label825;
          }
          ((MessageRecord)localObject2).vipBubbleID = -1000L;
        }
        try
        {
          if (!(localObject2 instanceof MessageForStructing)) {
            break label769;
          }
          paramMessageRecord = (MessageForStructing)localObject2;
          paramMessageRecord.parse();
          if (paramMessageRecord.structingMsg == null) {
            break label769;
          }
          localObject1 = new JSONObject(paramMessageRecord.structingMsg.mMsgActionData);
          if (!((JSONObject)localObject1).has("showMergedAvatar")) {
            break label891;
          }
          if (((JSONObject)localObject1).getInt("showMergedAvatar") != 1) {
            break label836;
          }
          bool = true;
        }
        catch (Exception paramMessageRecord)
        {
          for (;;)
          {
            boolean bool;
            paramMessageRecord.printStackTrace();
            continue;
            if (i == 1)
            {
              t();
              b((MessageRecord)localObject2);
              l();
              continue;
              continue;
              bool = false;
            }
          }
        }
        if (((JSONObject)localObject1).has("uin")) {
          this.jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).getString("uin");
        }
        if (((JSONObject)localObject1).has("biuUin"))
        {
          this.jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).getString("biuUin");
          bool = ReadInJoyHelper.j();
          paramMessageRecord = localObject3;
          if (((JSONObject)localObject1).has("defaultAvatarUrl")) {
            paramMessageRecord = ((JSONObject)localObject1).getString("defaultAvatarUrl");
          }
          if (TextUtils.isEmpty(((MessageRecord)localObject2).extStr)) {}
          for (localObject1 = new JSONObject();; localObject1 = new JSONObject(((MessageRecord)localObject2).extStr))
          {
            if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
              ((JSONObject)localObject1).put("kdUin", this.jdField_d_of_type_JavaLangString);
            }
            if (!TextUtils.isEmpty(paramMessageRecord)) {
              ((JSONObject)localObject1).put("kdDefaultSourceAvatarUrl", paramMessageRecord);
            }
            ((JSONObject)localObject1).put("kdShouldShowMergedAvatar", bool);
            ((MessageRecord)localObject2).extStr = ((JSONObject)localObject1).toString();
            if (i != 0) {
              break label866;
            }
            c((MessageRecord)localObject2);
            ReadInJoyUtils.a((MessageRecord)localObject2);
            return localObject2;
            if (i == 1)
            {
              ((MessageRecord)localObject2).extInt = 2;
              break;
            }
            ((MessageRecord)localObject2).extInt = 0;
            break;
            ((MessageRecord)localObject2).extLong |= 0x2;
            break label535;
            ((MessageRecord)localObject2).vipBubbleID = -999L;
            break label550;
            bool = false;
            break label616;
          }
        }
      }
    }
  }
  
  public MessageRecord a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)MessageRecordFactory.a(-2011);
    localMessageForStructing.istroop = 7220;
    localMessageForStructing.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    localMessageForStructing.frienduin = AppConstants.at;
    localMessageForStructing.senderuin = AppConstants.as;
    localMessageForStructing.time = ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localMessageForStructing.isread = false;
    localMessageForStructing.issend = 0;
    localMessageForStructing.extInt = 1;
    localMessageForStructing.extLong |= 0x2;
    localMessageForStructing.extLong |= 0x1;
    localMessageForStructing.structingMsg = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing.istroop, Long.valueOf(localMessageForStructing.senderuin).longValue(), paramString.getBytes(), 0);
    if (localMessageForStructing.structingMsg == null) {
      return null;
    }
    localMessageForStructing.msg = localMessageForStructing.structingMsg.mMsgBrief;
    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
    a(localMessageForStructing, 1);
    if (!a(localMessageForStructing)) {
      return null;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ReadInJoyUtils.a(localMessageForStructing);
    paramString.a(localMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    return localMessageForStructing;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    int m = 1;
    int j = 0;
    int k = 0;
    int i;
    label46:
    String str;
    if (!ReadInJoyHelper.g()) {
      if (a())
      {
        j = 1;
        int n = f().jdField_a_of_type_Int;
        i = m;
        if (j <= 0)
        {
          if (n <= 0) {
            break label128;
          }
          i = m;
        }
        j = k;
        if (n > 0) {
          j = 5;
        }
        str = String.valueOf(n);
        if (n > 99) {
          str = String.valueOf("99+");
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        localRedTypeInfo.red_type.set(j);
        localRedTypeInfo.red_content.set(str);
        return localRedTypeInfo;
        j = 0;
        break;
        label128:
        i = 0;
        break label46;
        if (!h()) {
          break label151;
        }
        i = 1;
        str = "";
        continue;
      }
      return null;
      label151:
      str = "";
      i = 0;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (ReadInJoyHelper.h()) {
      QLog.d("KandianMergeManager", 2, "cleanKandianMergeSummary : isShowKandianTab give up clean !");
    }
    int i;
    label54:
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) {
          break label283;
        }
        if (!PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())) {
          break;
        }
        c();
        i = 1;
        localObject1 = TroopBarAssistantManager.a();
        if (localObject1 != null) {
          ((TroopBarAssistantManager)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      } while (i == 0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.at, 7220);
      if (localObject1 == null) {
        break label288;
      }
    } while ((((MessageRecord)localObject1).extInt == 1) || (((MessageRecord)localObject1).extInt == 3));
    long l = ((MessageRecord)localObject1).time;
    label124:
    Object localObject1 = a();
    if (localObject1 == null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131428464);
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131428464);
      }
      localObject1 = a((String)localObject2, String.valueOf(l), 0);
      ReadInJoyUtils.a((MessageRecord)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("KandianMergeManager", 2, "cleanKandianMergeSummary : last msg is interested account,replace by kandian. " + ((MessageRecord)localObject1).msg);
      return;
      if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        c();
        i = 0;
        break label54;
      }
      c(3);
      label283:
      i = 0;
      break label54;
      label288:
      l = NetConnInfoCenter.getServerTime();
      break label124;
      if ((((MessageRecord)localObject1).extInt == 1) && ((localObject1 instanceof MessageForStructing)))
      {
        localObject2 = (MessageForStructing)localObject1;
        ((MessageForStructing)localObject2).parse();
        if (((MessageForStructing)localObject2).structingMsg == null) {
          localObject1 = ((MessageRecord)localObject1).msg;
        } else {
          localObject1 = ((MessageForStructing)localObject2).structingMsg.mMsgBrief;
        }
      }
      else
      {
        localObject1 = ((MessageRecord)localObject1).msg;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("KandianMergeManager", 2, "followListLength" + paramInt);
    }
    this.jdField_b_of_type_Int = paramInt;
    ThreadManager.post(new lnw(this, paramInt), 8, null, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    KandianMergeManager.KandianSetTopInfo localKandianSetTopInfo = KandianMergeManager.KandianSetTopInfo.get(paramInt1, paramInt2);
    ReadInJoyUtils.a("kandian_msgtab_settop", localKandianSetTopInfo, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo = localKandianSetTopInfo;
    QLog.d("KandianMergeManager.SETTOP", 2, "update kandian push msg setTop info : " + localKandianSetTopInfo);
  }
  
  public void a(KandianMergeManager.MessageObserver paramMessageObserver)
  {
    if (paramMessageObserver == null) {}
    do
    {
      return;
      if (this.jdField_c_of_type_JavaUtilList == null) {
        this.jdField_c_of_type_JavaUtilList = new ArrayList();
      }
      QLog.d("KandianMergeManager", 2, "add MsgObserver " + paramMessageObserver.getClass().getSimpleName() + ", " + paramMessageObserver);
    } while (this.jdField_c_of_type_JavaUtilList.contains(paramMessageObserver));
    this.jdField_c_of_type_JavaUtilList.add(paramMessageObserver);
  }
  
  public void a(KandianMergeManager.OnTabRedNumsChangeListenner paramOnTabRedNumsChangeListenner)
  {
    if (paramOnTabRedNumsChangeListenner == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
      }
      QLog.d("KandianMergeManager", 2, "add tabRedNumChangeObserver " + paramOnTabRedNumsChangeListenner.getClass().getSimpleName() + ", " + paramOnTabRedNumsChangeListenner);
    } while (this.jdField_a_of_type_JavaUtilList.contains(paramOnTabRedNumsChangeListenner));
    this.jdField_a_of_type_JavaUtilList.add(paramOnTabRedNumsChangeListenner);
  }
  
  public void a(KandianMergeManager.onMainVideoTabRedChangeListener paramonMainVideoTabRedChangeListener)
  {
    if (paramonMainVideoTabRedChangeListener == null) {}
    do
    {
      return;
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
      }
      QLog.d("KandianMergeManager", 2, "add tabRedNumChangeObserver " + paramonMainVideoTabRedChangeListener.getClass().getSimpleName() + ", " + paramonMainVideoTabRedChangeListener);
    } while (this.jdField_b_of_type_JavaUtilList.contains(paramonMainVideoTabRedChangeListener));
    this.jdField_b_of_type_JavaUtilList.add(paramonMainVideoTabRedChangeListener);
  }
  
  public void a(KandianRedDotInfo paramKandianRedDotInfo)
  {
    if (paramKandianRedDotInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null) {
      if (!paramKandianRedDotInfo.hasArticleID()) {}
    }
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = paramKandianRedDotInfo;; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = paramKandianRedDotInfo)
    {
      QLog.d("KandianMergeManager", 1, "update mainVideoTab RedDot : " + paramKandianRedDotInfo);
      m();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.saveToDiskAsync(true);
      return;
      QLog.d("KandianMergeManager", 1, "main video tab fake red drop because of has reddot now!");
      return;
    }
  }
  
  public void a(ReadInJoyTabObserver paramReadInJoyTabObserver)
  {
    a(paramReadInJoyTabObserver);
    a(paramReadInJoyTabObserver);
    a(paramReadInJoyTabObserver);
    ReadInJoyLogicEngineEventDispatcher.a().a(paramReadInJoyTabObserver);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread))
    {
      paramMessageRecord.isread = true;
      ThreadManager.post(new lol(this, paramMessageRecord), 10, null, false);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramMessageRecord == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramMessageRecord.extStr))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("kandian_push_from", paramInt);
        paramMessageRecord.extStr = localJSONObject.toString();
        return;
      }
    }
    catch (JSONException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      return;
    }
    JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
    localJSONObject.put("kandian_push_from", paramInt);
    paramMessageRecord.extStr = localJSONObject.toString();
  }
  
  public void a(String paramString)
  {
    try
    {
      if (TextUtils.equals(paramString, this.jdField_e_of_type_JavaLangString))
      {
        c();
        MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.at, 7220);
        if ((localMessageRecord != null) && (localMessageRecord.extInt == 2) && (TextUtils.equals(localMessageRecord.senderuin, paramString)))
        {
          paramString = a();
          if (paramString != null)
          {
            ReadInJoyUtils.a(paramString);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || ((paramInt != 0) && (paramInt != 1))) {}
    QQMessageFacade localQQMessageFacade;
    do
    {
      do
      {
        return;
      } while (paramInt == 1);
      localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (localQQMessageFacade == null);
    ThreadManager.post(new loj(this, localQQMessageFacade, paramString1, paramString2, paramInt, paramBoolean), 10, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ReadInJoyUtils.a(localQQAppInterface, paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean, Class paramClass)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.getSimpleName(), Boolean.valueOf(paramBoolean));
    String str = paramClass.getSimpleName();
    if (BaseActivity.sTopActivity != null) {}
    for (paramClass = BaseActivity.sTopActivity.getClass().getSimpleName();; paramClass = "")
    {
      if (TextUtils.equals(str, paramClass))
      {
        if (!paramBoolean) {
          break;
        }
        p();
      }
      return;
    }
    KandianAppInPush.a().a(false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1)
    {
      i = 1;
      this.jdField_a_of_type_Int = i;
      if ((!paramBoolean2) || (!this.jdField_a_of_type_Boolean)) {
        break label28;
      }
    }
    label28:
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    do
    {
      return;
      i = 0;
      break;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = localRecentUserProxy.b(AppConstants.at, 7220);
    } while ((localRecentUser == null) && (!paramBoolean1) && (paramBoolean2 == true));
    Object localObject = localRecentUser;
    if (localRecentUser == null)
    {
      localObject = new RecentUser();
      ((RecentUser)localObject).uin = AppConstants.at;
      ((RecentUser)localObject).type = 7220;
      ((RecentUser)localObject).lastmsgtime = NetConnInfoCenter.getServerTime();
    }
    if (paramBoolean1) {}
    for (((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);; ((RecentUser)localObject).showUpTime = 0L)
    {
      localRecentUserProxy.a((RecentUser)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
      if (paramBoolean2) {
        break;
      }
      c(paramBoolean1);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      long l1 = localMsgBody.uint64_seq.get();
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.jdField_a_of_type_Long;
      QLog.d("KandianMergeManager", 1, "biu 0x210Msg reached, oldSeq = " + l2 + ", newSeq = " + l1);
      if (l2 >= l1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "biu 0x210Msg delay reached, no updated!");
        }
      }
      else if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.has()) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get() != null) && (((submsgtype0xc5.BiuBody)((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get()).uint64_biu_uin.has()))
      {
        l2 = ((submsgtype0xc5.BiuBody)((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get()).uint64_biu_uin.get();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.jdField_a_of_type_Long = l1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.jdField_b_of_type_Long = l2;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        QLog.d("KandianMergeManager", 1, "has biu 0x210 msg push, seq = " + l1 + ", uin = " + l2);
        a(null, KandianOx210MsgInfo.l, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    boolean bool2 = false;
    if (KandianOx210MsgInfo.c(paramArrayOfByte) == 2)
    {
      paramArrayOfByte = KandianOx210MsgInfo.a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "process 0x210 follow msg fail!");
        }
      }
    }
    Object localObject;
    label463:
    int i;
    label573:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
                if ((localObject == null) || (((KandianOx210MsgInfo)localObject).jdField_b_of_type_Long <= paramArrayOfByte.jdField_b_of_type_Long)) {
                  break label573;
                }
                if (paramArrayOfByte.jdField_e_of_type_Int != 1) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("KandianMergeManager", 2, "0x210msgc5 delay reach showFolder, has a latest msg , no cover! + oldMsg.msgSeq" + ((KandianOx210MsgInfo)localObject).jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long + "brief : " + paramArrayOfByte.jdField_b_of_type_JavaLangString);
                }
                if ((this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo == null) || (paramArrayOfByte.jdField_b_of_type_Long > this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_Long))
                {
                  if ((this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null) && (QLog.isColorLevel())) {
                    QLog.d("KandianMergeManager", 2, "upDate ox210ShowInFolderFollowPushMsg.msgSeq" + this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
                  }
                  localObject = paramArrayOfByte.jdField_b_of_type_JavaLangString;
                  String str = paramArrayOfByte.jdField_a_of_type_JavaLangString;
                  paramLong = paramArrayOfByte.jdField_d_of_type_Long;
                  if (paramArrayOfByte.g == 0)
                  {
                    bool1 = true;
                    localObject = a((String)localObject, str, paramLong, bool1, true, String.valueOf(paramArrayOfByte.jdField_e_of_type_Long));
                    a((MessageRecord)localObject, true);
                    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = paramArrayOfByte;
                    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    if (QLog.isColorLevel())
                    {
                      paramArrayOfByte = new StringBuilder().append("has 0x210 follow msg push , brief : ").append(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_JavaLangString).append(", showInFolder : ");
                      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Int != 1) {
                        break label463;
                      }
                    }
                  }
                  for (boolean bool1 = true;; bool1 = false)
                  {
                    paramArrayOfByte = paramArrayOfByte.append(bool1).append(", showLockScreen : ");
                    bool1 = bool2;
                    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.f == 1) {
                      bool1 = true;
                    }
                    QLog.d("KandianMergeManager", 1, bool1 + ", redType : " + this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.g + ", msgSeq : " + this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_Long + ", orangeWord : " + this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_JavaLangString + ", msgCount : " + this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int);
                    a((MessageRecord)localObject, KandianOx210MsgInfo.l, null);
                    return;
                    bool1 = false;
                    break;
                  }
                }
              } while (!QLog.isColorLevel());
              QLog.d("KandianMergeManager", 2, "no upDate ox210ShowInFolderFollowPushMsg.msgSeq" + this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
              return;
            } while (!QLog.isColorLevel());
            QLog.d("KandianMergeManager", 2, "0x210msgc5 delay reach discarded,  + oldMsg.msgSeq" + ((KandianOx210MsgInfo)localObject).jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("KandianMergeManager", 2, "0x210msgc5 nomel , msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
            }
            this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = paramArrayOfByte;
            this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Long = paramLong;
            this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            s();
            return;
            i = KandianOx210MsgInfo.a(paramArrayOfByte);
          } while (i == KandianOx210MsgInfo.j);
          if (i == KandianOx210MsgInfo.l)
          {
            a(paramArrayOfByte);
            return;
          }
          localObject = KandianOx210MsgInfo.a(paramArrayOfByte);
          if (localObject != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("KandianMergeManager", 2, "process 0x210 msg fail!");
        return;
        i = KandianOx210MsgInfo.b(paramArrayOfByte);
      } while (i == KandianOx210MsgInfo.m);
      if (i == KandianOx210MsgInfo.n)
      {
        a((KandianOx210MsgInfo)localObject, paramLong);
        return;
      }
    } while (i != KandianOx210MsgInfo.o);
    b((KandianOx210MsgInfo)localObject, paramLong);
  }
  
  public boolean a()
  {
    if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    do
    {
      return false;
      QLog.d("KandianMergeManager", 1, "SubUnread : " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", SubStatus : " + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", mSubTitle : " + ReadInJoyUtils.d(this.f) + ", KDUnread : " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    } while ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1)) && ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3) || ((!ReadInJoyHelper.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString)))));
    if ((ReadInJoyHelper.h()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_a_of_type_JavaLangLong.longValue() <= 0L) && (TextUtils.isEmpty(this.g)))
    {
      QLog.d("KandianMergeManager", 2, "subscribe push has not article id , give up auto refresh! only for kandian tab");
      return false;
    }
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KandianMergeManager", 2, "erasureTabRedWhenSwitchTab from: " + paramInt1 + ", to: " + paramInt2);
    }
    if ((paramInt1 != 0) && (paramInt2 == 0)) {}
    do
    {
      return false;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        return true;
      }
      if ((paramInt1 != 1) && (paramInt2 == 1))
      {
        if (b(1) > 0) {
          ThreadManager.getSubThreadHandler().post(new loc(this));
        }
        d(1);
        return true;
      }
      if ((paramInt1 == 1) && (paramInt2 == 1))
      {
        if (b(1) > 0) {
          ThreadManager.getSubThreadHandler().post(new lod(this));
        }
        d(1);
        return true;
      }
      if (paramInt2 == 2)
      {
        d(2);
        return true;
      }
    } while ((paramInt2 != 3) || (b(3) <= 0));
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    int i = a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 0) {
      bool = c(paramMessageRecord);
    }
    while (i != 1) {
      return bool;
    }
    return a(paramMessageRecord, false);
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        long l = paramMessageRecord.time;
        String str = paramMessageRecord.senderuin;
        int j = paramMessageRecord.msgtype;
        Object localObject2 = "";
        if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("kandian_replace_subscribe_msg")))
        {
          paramMessageRecord = (ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
          if (paramMessageRecord != null) {
            paramMessageRecord.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
          }
          paramBoolean = false;
          return paramBoolean;
        }
        if (l > this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.get())
        {
          if (!paramBoolean)
          {
            this.f = "";
            this.g = "";
            this.jdField_a_of_type_JavaLangLong = Long.valueOf(-1L);
            if (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramMessageRecord.msgtype))
            {
              bool = true;
              localObject1 = "";
              this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
              this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
              this.jdField_e_of_type_JavaLangString = str;
              this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
              this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(j);
              if ((paramBoolean) || (!ReadInJoyHelper.h())) {
                e();
              }
              ThreadManager.getSubThreadHandler().post(new lom(this, l, str, 1, (String)localObject1, j));
              QLog.d("KandianMergeManager", 1, "subscribe push, title : " + this.f + ", id : " + this.jdField_a_of_type_JavaLangLong + ", msguid : " + paramMessageRecord.msgUid + ", isInterestedAccount : " + bool);
              paramBoolean = true;
              continue;
            }
            if ((paramMessageRecord instanceof MessageForStructing))
            {
              Object localObject3 = (MessageForStructing)paramMessageRecord;
              ((MessageForStructing)localObject3).parse();
              if (((MessageForStructing)localObject3).structingMsg == null) {
                break label520;
              }
              localObject1 = PkgTools.a(((MessageForStructing)localObject3).structingMsg.getBytes());
              this.f = ((MessageForStructing)localObject3).structingMsg.mMsgBrief;
              if (!TextUtils.isEmpty(((MessageForStructing)localObject3).structingMsg.mInnerUniqIds))
              {
                localObject2 = ((MessageForStructing)localObject3).structingMsg.mInnerUniqIds.split("\\|");
                k = localObject2.length;
                i = 0;
                if (i >= k) {
                  break label527;
                }
                localObject3 = localObject2[i];
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label533;
                }
                this.g = ((String)localObject3);
                break label527;
              }
              localObject2 = localObject1;
              if (TextUtils.isEmpty(((MessageForStructing)localObject3).structingMsg.mArticleIds)) {
                break label520;
              }
              localObject3 = ((MessageForStructing)localObject3).structingMsg.mArticleIds.split("\\|");
              int k = localObject3.length;
              i = 0;
              localObject2 = localObject1;
              if (i >= k) {
                break label520;
              }
              localObject2 = localObject3[i];
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label540;
              }
              this.jdField_a_of_type_JavaLangLong = Long.valueOf((String)localObject2);
              break label527;
            }
            if (QLog.isColorLevel()) {
              QLog.d("KandianMergeManager", 2, "parse subscribe push struct msg fail !");
            }
          }
          bool = false;
          localObject1 = "";
          continue;
        }
        else
        {
          paramBoolean = false;
          continue;
        }
        Object localObject1 = localObject2;
      }
      finally {}
      label520:
      label527:
      boolean bool = false;
      continue;
      label533:
      i += 1;
      continue;
      label540:
      i += 1;
    }
  }
  
  public int b()
  {
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null) {
      return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Int;
    }
    return 0;
  }
  
  public int b(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "getTabRedNums tab: " + paramInt + ", nums: " + i);
      }
      return i;
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (i < 0) {
        break;
      }
      continue;
      i = this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (i <= 0) {
        break;
      }
      continue;
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo == null) {
        break;
      }
      i = 1;
      continue;
      i = f();
    }
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo != null) {
      return KandianMergeManager.KandianSetTopInfo.access$700(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo);
    }
    return 0L;
  }
  
  public KandianOx210MsgInfo b()
  {
    KandianOx210MsgInfo localKandianOx210MsgInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = null;
    if (localKandianOx210MsgInfo != null)
    {
      localKandianOx210MsgInfo.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QLog.d("KandianMergeManager", 1, "clear 0x210_Msg, msgSeq : " + localKandianOx210MsgInfo.jdField_b_of_type_Long + ", msgCount : " + localKandianOx210MsgInfo.jdField_a_of_type_Int);
    }
    return localKandianOx210MsgInfo;
  }
  
  public MessageRecord b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.at, 7220);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4) || (localMessageRecord.extInt == 3)) {}
        while (((localMessageRecord.extInt == 5) && (!d())) || (!localMessageRecord.isValid) || (MsgProxyUtils.g(localMessageRecord.msgtype)))
        {
          i -= 1;
          break;
        }
      }
    }
    for (;;)
    {
      localObject = localMessageRecord;
      if (localMessageRecord == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.at, 7220, "extInt=1");
      }
      return localObject;
      localMessageRecord = null;
    }
  }
  
  public List b()
  {
    ArrayList localArrayList = new ArrayList();
    if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) {
      return localArrayList;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_Long));
      localArrayList.add(Long.valueOf(this.jdField_b_of_type_Long));
    }
    QLog.i("KandianMergeManager", 1, "getKandianArticleIdsWhenRefreshKandian: " + localArrayList.toString());
    return localArrayList;
  }
  
  public void b()
  {
    ReadInJoyUtils.c();
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.at, 7220);
    if ((localMessageRecord != null) && (!localMessageRecord.isread))
    {
      localMessageRecord.isread = true;
      ThreadManager.post(new lok(this, localMessageRecord), 10, null, false);
    }
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0);
    c();
  }
  
  public void b(KandianMergeManager.MessageObserver paramMessageObserver)
  {
    if (paramMessageObserver == null) {}
    while ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    QLog.d("KandianMergeManager", 2, "remove MsgObserver " + paramMessageObserver.getClass().getSimpleName() + ", " + paramMessageObserver);
    this.jdField_c_of_type_JavaUtilList.remove(paramMessageObserver);
  }
  
  public void b(KandianMergeManager.OnTabRedNumsChangeListenner paramOnTabRedNumsChangeListenner)
  {
    if (paramOnTabRedNumsChangeListenner == null) {}
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    QLog.d("KandianMergeManager", 2, "remove tabRedNumChangeObserver " + paramOnTabRedNumsChangeListenner.getClass().getSimpleName() + ", " + paramOnTabRedNumsChangeListenner);
    this.jdField_a_of_type_JavaUtilList.remove(paramOnTabRedNumsChangeListenner);
  }
  
  public void b(KandianMergeManager.onMainVideoTabRedChangeListener paramonMainVideoTabRedChangeListener)
  {
    if ((paramonMainVideoTabRedChangeListener == null) || (this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    QLog.d("KandianMergeManager", 2, "remove tabRedNumChangeObserver " + paramonMainVideoTabRedChangeListener.getClass().getSimpleName() + ", " + paramonMainVideoTabRedChangeListener);
    this.jdField_b_of_type_JavaUtilList.remove(paramonMainVideoTabRedChangeListener);
  }
  
  public void b(ReadInJoyTabObserver paramReadInJoyTabObserver)
  {
    b(paramReadInJoyTabObserver);
    b(paramReadInJoyTabObserver);
    b(paramReadInJoyTabObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(paramReadInJoyTabObserver);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((KandianMergeManager.MessageObserver)localIterator.next()).b(paramMessageRecord);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    Kandian210Msg0xeeInfo localKandian210Msg0xeeInfo = Kandian210Msg0xeeInfo.decodeFromPbBytes(paramArrayOfByte);
    if ((localKandian210Msg0xeeInfo == null) || (KandianAppInPush.a().a())) {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "process 0x210 sub 0xee msg fail!");
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo != null) && (localKandian210Msg0xeeInfo.msgSeq < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo.msgSeq));
      if ((localKandian210Msg0xeeInfo.notifyInfos != null) && (!localKandian210Msg0xeeInfo.notifyInfos.isEmpty()) && (!TextUtils.isEmpty(((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).contextTitle))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("KandianMergeManager", 2, "0x210 sub 0xee msg title empty, just abandon " + localKandian210Msg0xeeInfo);
    return;
    boolean bool = false;
    Object localObject;
    Kandian210Msg0xeeInfo.NotifyInfo localNotifyInfo;
    if (localKandian210Msg0xeeInfo.isArticleAppInPush())
    {
      this.jdField_a_of_type_Long = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).algorithmID;
      this.jdField_b_of_type_Long = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).strategyID;
      this.jdField_a_of_type_JavaLangString = ReadInJoyStringUtils.a(((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).extCookie, 0);
      localObject = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).orangeWord;
      paramArrayOfByte = (byte[])localObject;
      if (localObject == null) {
        paramArrayOfByte = "精选";
      }
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject = localKandian210Msg0xeeInfo.notifyInfos.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localNotifyInfo = (Kandian210Msg0xeeInfo.NotifyInfo)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilArrayList.add(0, Long.valueOf(localNotifyInfo.contextId));
      }
      paramArrayOfByte = a(((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).contextTitle, paramArrayOfByte, paramLong, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(0)).longValue(), ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).folderStatus);
      if (paramArrayOfByte != null) {
        b(paramArrayOfByte);
      }
      c(paramArrayOfByte);
      bool = true;
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo = localKandian210Msg0xeeInfo;
        Kandian210Msg0xeeInfo.writeToSpAsync(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo);
        p();
      }
      QLog.d("KandianMergeManager", 2, "process Msg 210 0xee canHandle : " + bool + "\n InAppPush : " + localKandian210Msg0xeeInfo);
      return;
      if (localKandian210Msg0xeeInfo.isVideoAppInPush())
      {
        if (!ReadInJoyHelper.g())
        {
          QLog.d("KandianMergeManager", 2, "received video app in push , but user is not in video tab, drop it as wife");
          return;
        }
        paramArrayOfByte = new KandianRedDotInfo("kandian_video_tab_reddot_info");
        localObject = (Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0);
        paramArrayOfByte.algorithmID = ((Kandian210Msg0xeeInfo.NotifyInfo)localObject).algorithmID;
        paramArrayOfByte.cookie = Html.fromHtml(((Kandian210Msg0xeeInfo.NotifyInfo)localObject).extCookie).toString();
        localObject = localKandian210Msg0xeeInfo.notifyInfos.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localNotifyInfo = (Kandian210Msg0xeeInfo.NotifyInfo)((Iterator)localObject).next();
          paramArrayOfByte.articleIDList.add(0, Long.valueOf(localNotifyInfo.contextId));
        }
        a(paramArrayOfByte);
        m();
        bool = true;
      }
      else
      {
        QLog.d("KandianMergeManager", 2, "received unknow app in push, bid " + localKandian210Msg0xeeInfo.bid);
      }
    }
  }
  
  public boolean b()
  {
    return !ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    AbsStructMsg localAbsStructMsg;
    try
    {
      localAbsStructMsg = StructMsgFactory.a();
      localAbsStructMsg.uin = paramMessageRecord.frienduin;
      localAbsStructMsg.currentAccountUin = paramMessageRecord.selfuin;
      localAbsStructMsg.mMsgBrief = paramMessageRecord.msg;
      localAbsStructMsg.mMsgActionData = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(String.valueOf((Long)localIterator.next())).append("|");
      }
      localAbsStructMsg.mArticleIds = localStringBuilder.toString();
    }
    finally {}
    localAbsStructMsg.mAlgorithmIds = String.valueOf(this.jdField_a_of_type_Long);
    localAbsStructMsg.mStrategyIds = String.valueOf(this.jdField_b_of_type_Long);
    long l = paramMessageRecord.time;
    paramMessageRecord = PkgTools.a(localAbsStructMsg.getBytes());
    if (l > this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      ThreadManager.getSubThreadHandler().post(new lop(this, paramMessageRecord, l));
      if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2))
      {
        c(2);
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "0xee push, ids: " + this.jdField_a_of_type_JavaUtilArrayList);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3)) {
        break;
      }
      c();
      break;
    }
  }
  
  public int c()
  {
    int i = 0;
    if (e()) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int;
    }
    return i;
  }
  
  public KandianOx210MsgInfo c()
  {
    return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
  }
  
  public void c()
  {
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      this.jdField_e_of_type_JavaLangString = "";
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
      ThreadManager.getSubThreadHandler().post(new loo(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_3
    //   4: if_icmpne +29 -> 33
    //   7: aload_0
    //   8: getfield 87	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   11: invokevirtual 559	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   14: iconst_2
    //   15: if_icmpne +10 -> 25
    //   18: aload_0
    //   19: invokevirtual 900	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:c	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 79	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   29: iconst_0
    //   30: invokevirtual 526	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   33: aload_0
    //   34: getfield 87	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   37: iload_1
    //   38: invokevirtual 526	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   41: invokestatic 1213	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   44: new 1424	lon
    //   47: dup
    //   48: aload_0
    //   49: iload_1
    //   50: invokespecial 1425	lon:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager;I)V
    //   53: invokevirtual 1219	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   56: pop
    //   57: goto -35 -> 22
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	KandianMergeManager
    //   0	65	1	paramInt	int
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	22	60	finally
    //   25	33	60	finally
    //   33	57	60	finally
  }
  
  public void c(boolean paramBoolean)
  {
    int j = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
      if (localUserOperationModule != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        i = j;
        if (paramBoolean) {
          i = 2;
        }
        localUserOperationModule.a(str, i);
      }
      return;
    }
  }
  
  public boolean c()
  {
    RecentUser localRecentUser = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(AppConstants.at, 7220);
    if (localRecentUser == null) {
      if (this.jdField_a_of_type_Int != -1) {
        if (this.jdField_a_of_type_Int != 1) {}
      }
    }
    while (localRecentUser.showUpTime != 0L)
    {
      return true;
      return false;
      return false;
    }
    return false;
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          Object localObject = (MessageForStructing)paramMessageRecord;
          ((MessageForStructing)localObject).parse();
          if (((MessageForStructing)localObject).structingMsg == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("KandianMergeManager", 2, "kandian push msg : struct msg body is null");
            }
            bool = false;
            return bool;
          }
          localObject = PkgTools.a(((MessageForStructing)paramMessageRecord).structingMsg.getBytes());
          long l = paramMessageRecord.time;
          if (paramMessageRecord.time > this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get())
          {
            if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds))
            {
              String[] arrayOfString = ((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds.split("\\|");
              this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              if (i < arrayOfString.length)
              {
                this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(arrayOfString[i]));
                i += 1;
                continue;
              }
            }
            this.jdField_a_of_type_JavaLangString = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgActionData;
            if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds)) {
              this.jdField_a_of_type_Long = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds.split("\\|")[0]);
            }
            if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds)) {
              this.jdField_b_of_type_Long = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds.split("\\|")[0]);
            }
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramMessageRecord.time);
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
            if ((ReadInJoyUtils.a(paramMessageRecord)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
            {
              this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
              this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
            }
            ThreadManager.getSubThreadHandler().post(new lnx(this, (String)localObject, l));
            if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2))
            {
              c(2);
              if (!QLog.isColorLevel()) {
                break label449;
              }
              QLog.d("KandianMergeManager", 2, "kandian push, ids: " + this.jdField_a_of_type_JavaUtilArrayList + ", msgUid : " + paramMessageRecord.msgUid);
              break label449;
            }
            if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3)) {
              continue;
            }
            c();
            continue;
          }
        }
        bool = false;
      }
      finally {}
      continue;
      label449:
      boolean bool = true;
    }
  }
  
  public int d()
  {
    int i = 0;
    if (f()) {
      i = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int;
    }
    return i;
  }
  
  public KandianOx210MsgInfo d()
  {
    KandianOx210MsgInfo localKandianOx210MsgInfo = this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = null;
    if (localKandianOx210MsgInfo != null) {
      localKandianOx210MsgInfo.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    localKandianOx210MsgInfo = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = null;
    if (localKandianOx210MsgInfo != null) {
      localKandianOx210MsgInfo.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return localKandianOx210MsgInfo;
  }
  
  public void d()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo = null;
      Kandian210Msg0xeeInfo.removeKandian210Msg0xeeInfoFromSp();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("erasureTabRed index: " + paramInt);
    switch (paramInt)
    {
    case 0: 
    case 3: 
    default: 
    case 1: 
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
        }
        l();
        return;
        this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      }
    }
    if (b(paramInt) > 0) {}
    for (;;)
    {
      localStringBuilder.append(", subscribe msg successful");
      break;
      ReadInJoyLogicEngine.a().n();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_e_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.f == 1);
  }
  
  public int e()
  {
    return f() - c();
  }
  
  public KandianOx210MsgInfo e()
  {
    KandianOx210MsgInfo localKandianOx210MsgInfo = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = null;
    if (localKandianOx210MsgInfo != null)
    {
      localKandianOx210MsgInfo.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QLog.d("KandianMergeManager", 1, "clear 0x210_Msg, msgSeq : " + localKandianOx210MsgInfo.jdField_b_of_type_Long + ", msgCount : " + localKandianOx210MsgInfo.jdField_a_of_type_Int);
    }
    return localKandianOx210MsgInfo;
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_JavaUtilArrayList = null;
      ThreadManager.getSubThreadHandler().post(new lny(this));
      return;
    }
    finally {}
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null;
  }
  
  public int f()
  {
    int i = 0;
    if (e()) {
      i = 0 + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int;
    }
    int j = i;
    if (f()) {
      j = i + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_a_of_type_Int;
    }
    return j + ReadInJoyLogicEngine.a().a();
  }
  
  public KandianOx210MsgInfo f()
  {
    long l2 = 0L;
    KandianOx210MsgInfo localKandianOx210MsgInfo = new KandianOx210MsgInfo();
    localKandianOx210MsgInfo.jdField_a_of_type_Int = f();
    localKandianOx210MsgInfo.jdField_e_of_type_Long = 0L;
    Object localObject1 = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false);
    if ((localObject1 != null) && (((SharedPreferences)localObject1).getBoolean(jdField_c_of_type_JavaLangString, false)))
    {
      localKandianOx210MsgInfo.jdField_a_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "getIndependentTabSelfRedInfo has erase sp");
      }
      return localKandianOx210MsgInfo;
    }
    long l1;
    label97:
    label109:
    Object localObject2;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo == null)
    {
      l1 = 0L;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null) {
        break label187;
      }
      if (l1 <= l2) {
        break label198;
      }
      localObject1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
      localObject2 = ReadInJoyLogicEngine.a().a();
      if ((localObject2 != null) || (localObject1 != null)) {
        break label213;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("getIndependentTabSelfRedInfo ox210MsgInfo is null:");
        if (localObject1 != null) {
          break label207;
        }
      }
    }
    label187:
    label198:
    label207:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("KandianMergeManager", 2, bool);
      return localKandianOx210MsgInfo;
      l1 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Long;
      break;
      l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.jdField_d_of_type_Long;
      break label97;
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
      break label109;
    }
    label213:
    if ((localObject2 != null) && (localObject1 != null)) {
      if (((SubscriptionFeed)localObject2).jdField_a_of_type_Long > ((KandianOx210MsgInfo)localObject1).jdField_d_of_type_Long)
      {
        l1 = Long.valueOf(((SubscriptionFeed)localObject2).jdField_a_of_type_JavaLangString).longValue();
        localKandianOx210MsgInfo.jdField_e_of_type_Long = l1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "getIndependentTabSelfRedInfo info.msgCount:" + localKandianOx210MsgInfo.jdField_a_of_type_Int);
      }
      return localKandianOx210MsgInfo;
      l1 = ((KandianOx210MsgInfo)localObject1).jdField_e_of_type_Long;
      break;
      if (localObject2 == null) {
        localKandianOx210MsgInfo.jdField_e_of_type_Long = ((KandianOx210MsgInfo)localObject1).jdField_e_of_type_Long;
      } else {
        localKandianOx210MsgInfo.jdField_e_of_type_Long = Long.valueOf(((SubscriptionFeed)localObject2).jdField_a_of_type_JavaLangString).longValue();
      }
    }
  }
  
  public void f()
  {
    ReadInJoyUtils.c();
    ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    String str;
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      str = AppConstants.at;
    }
    for (int i = 7220;; i = 1008)
    {
      if ((localConversationFacade != null) && (localConversationFacade.a(str, i) > 0)) {
        ThreadManager.post(new lnz(this, str, i), 8, null, false);
      }
      return;
      str = AppConstants.as;
    }
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null;
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.a()))
    {
      QLog.d("KandianMergeManager", 1, "clear biu 0x210 msg, msgSeq = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.jdField_a_of_type_Long + ", biuUin = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public boolean g()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.at, 7220);
    if ((localMessageRecord == null) || (localMessageRecord.isread)) {}
    while (localMessageRecord.vipBubbleID != -1000L) {
      return false;
    }
    return true;
  }
  
  public void h()
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_message_configuration");
    mobileqq_mp.GetMessageConfigurationRequest localGetMessageConfigurationRequest = new mobileqq_mp.GetMessageConfigurationRequest();
    localGetMessageConfigurationRequest.uin.set(2171946401L);
    localGetMessageConfigurationRequest.versionInfo.set(PublicAccountUtil.a());
    localNewIntent.putExtra("data", localGetMessageConfigurationRequest.toByteArray());
    localNewIntent.setObserver(new loa(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo != null) {
      ThreadManager.executeOnSubThread(new lob(this));
    }
  }
  
  public boolean i()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("SplashActivity");
    if ((BaseActivity.sTopActivity != null) && ((ReadInJoyUtils.a() instanceof QQAppInterface)) && (!FrameHelperActivity.f))
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      String str = localBaseActivity.getClass().getSimpleName();
      if (localArrayList.contains(str))
      {
        if ("SplashActivity".equals(str))
        {
          if (SplashActivity.jdField_a_of_type_Int != 1) {
            return false;
          }
          if (((SplashActivity)localBaseActivity).a() == MainFragment.g) {
            return false;
          }
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str) != null) {
          return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(str)).booleanValue();
        }
        return true;
      }
    }
    return false;
  }
  
  public void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.at, 7220);
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    if ((localObject != null) && (!((MessageRecord)localObject).isread))
    {
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = localRecentUserProxy.b(AppConstants.at, 7220);
      if (localRecentUser != null) {}
    }
    else
    {
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    localRecentUser.lastmsgtime = l;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.at, 7220, ((MessageRecord)localObject).uniseq, "time", Long.valueOf(l));
    localRecentUserProxy.a(localRecentUser);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1009);
    }
    QLog.d("KandianMergeManager", 1, "stickKandianConversation successful! newTime : " + l);
  }
  
  public void k()
  {
    Object localObject = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false);
    if (localObject == null)
    {
      QLog.d("KandianMergeManager", 2, "erasureIndependentTabSelfRedInfo() failed");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(jdField_c_of_type_JavaLangString, true);
    ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
    l();
  }
  
  public void l()
  {
    ThreadManager.getUIHandler().post(new loe(this));
  }
  
  public void m()
  {
    ThreadManager.getUIHandler().post(new lof(this));
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.removeFromDiskAsync(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = null;
    m();
  }
  
  public void o()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    l();
  }
  
  public void onDestroy()
  {
    
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void p()
  {
    ThreadManager.executeOnSubThread(new log(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager
 * JD-Core Version:    0.7.0.1
 */