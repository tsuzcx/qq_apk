package com.tencent.biz.pubaccount.readinjoy.engine;

import acmw;
import acnh;
import acnk;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.SparseIntArray;
import anvi;
import anvx;
import aoxz;
import aozi;
import ayqy;
import bbbq;
import bcsa;
import bdof;
import bmhv;
import bmie;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinListener;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MySelfNormalItemRedPointInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.utils.tkd.TKDCommentFragmentHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mini.notify.MiniAppNotify;
import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.mp.mobileqq_mp.GetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import olh;
import oln;
import oqy;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ovt;
import oxv;
import oyg;
import pik;
import pis;
import pje;
import pkb;
import pkf;
import pkh;
import pkt;
import pkz;
import plm;
import pqg;
import pqt;
import pqu;
import prd;
import pro;
import prp;
import prq;
import prr;
import prs;
import ptv;
import pus;
import put;
import puu;
import puv;
import puw;
import pux;
import puy;
import puz;
import pva;
import pvb;
import pvc;
import pvd;
import pvj;
import pvm;
import pvp;
import pwb;
import pwx;
import pxl;
import qia;
import qzw;
import ral;
import ram;
import roq;
import rpl;
import rpm;
import tem;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.BiuBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.NotifyBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.StyleSheet;
import tlx;
import udj;
import uot;
import uqx;
import uuc;
import uvz;
import uwd;
import uwl;

public class KandianMergeManager
  implements Manager
{
  public static String b;
  public int a;
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new puy(this);
  private anvi jdField_a_of_type_Anvi = new puw(this);
  private ayqy jdField_a_of_type_Ayqy = new put(this);
  AladdinListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigAladdinListener = new KandianMergeManager.9(this);
  private KandianMergeManager.KandianSetTopInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo;
  private volatile Kandian210Msg0xeeInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo;
  private KandianMsgBoxRedPntInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo;
  private KandianRedDotInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MiniAppNotify.IMiniAppNotifyListener jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener = new pux(this);
  private Long jdField_a_of_type_JavaLangLong;
  public String a;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<puz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Long, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  pva jdField_a_of_type_Pva = new pva();
  private rpl jdField_a_of_type_Rpl;
  private rpm jdField_a_of_type_Rpm;
  private tlx jdField_a_of_type_Tlx = new tlx();
  private uvz jdField_a_of_type_Uvz;
  public boolean a;
  private int jdField_b_of_type_Int;
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new pus(this);
  private KandianRedDotInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  private List<pvd> jdField_b_of_type_JavaUtilList;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicLong jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong;
  private rpl jdField_b_of_type_Rpl;
  private KandianRedDotInfo jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  private String jdField_c_of_type_JavaLangString;
  private List<pvc> jdField_c_of_type_JavaUtilList;
  private AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private rpl jdField_c_of_type_Rpl;
  private String jdField_d_of_type_JavaLangString;
  private List<pvb> jdField_d_of_type_JavaUtilList;
  private AtomicInteger jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private String jdField_e_of_type_JavaLangString;
  private AtomicInteger jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private String f;
  private String g = "";
  private String h = "";
  
  static
  {
    jdField_b_of_type_JavaLangString = "PUSH_0X210_ORANGE_KEY";
  }
  
  public KandianMergeManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = -1;
    QLog.i("KandianMergeManager", 1, "[KandianMergeManager] constructed.");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    u();
    w();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    pkb.a();
    pkz.a();
    z();
    ptv.a();
    pwb.g();
    if (Aladdin.getConfig(258).getIntegerFromString("load_resources_after_login", 1) == 0)
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        break label375;
      }
      s();
    }
    for (;;)
    {
      QLog.d("KandianMergeManager", 1, "do method[someInitInSubThread] in manager init ");
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
      ThreadManager.executeOnSubThread(new KandianMergeManager.2(this));
      bmie.a().a(this.jdField_a_of_type_Pva);
      pkt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigAladdinListener);
      pik.a();
      uwl.a();
      roq.a();
      ovt.a();
      paramQQAppInterface.registObserver(this.jdField_a_of_type_Ayqy);
      t();
      pxl.i();
      return;
      label375:
      ThreadManager.executeOnSubThread(new KandianMergeManager.1(this));
    }
  }
  
  private void A()
  {
    ThreadManager.post(new KandianMergeManager.13(this), 8, null, false);
  }
  
  private void B()
  {
    boolean bool2 = false;
    Object localObject1 = null;
    Object localObject2;
    if (this.jdField_a_of_type_Rpl.jdField_e_of_type_Int == 1)
    {
      localObject1 = this.jdField_a_of_type_Rpl.jdField_b_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_Rpl.jdField_a_of_type_JavaLangString;
      long l = this.jdField_a_of_type_Rpl.jdField_d_of_type_Long;
      if (this.jdField_a_of_type_Rpl.g == 0)
      {
        bool1 = true;
        localObject1 = a((String)localObject1, (String)localObject2, l, bool1, true, String.valueOf(this.jdField_a_of_type_Rpl.jdField_e_of_type_Long));
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_a_of_type_Rpl.jdField_a_of_type_Long);
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Rpl.jdField_b_of_type_JavaLangString;
        a((MessageRecord)localObject1, true);
        this.jdField_b_of_type_Rpl = this.jdField_a_of_type_Rpl;
        this.jdField_b_of_type_Rpl.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("has 0x210 follow msg push , brief : ").append(this.jdField_a_of_type_Rpl.jdField_b_of_type_JavaLangString).append(", showInFolder : ");
      if (this.jdField_a_of_type_Rpl.jdField_e_of_type_Int != 1) {
        break label322;
      }
    }
    label322:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = ((StringBuilder)localObject2).append(bool1).append(", showLockScreen : ");
      bool1 = bool2;
      if (this.jdField_a_of_type_Rpl.f == 1) {
        bool1 = true;
      }
      QLog.d("KandianMergeManager", 1, bool1 + ", redType : " + this.jdField_a_of_type_Rpl.g + ", msgSeq : " + this.jdField_a_of_type_Rpl.jdField_b_of_type_Long + ", orangeWord : " + this.jdField_a_of_type_Rpl.jdField_a_of_type_JavaLangString + ", msgCount : " + this.jdField_a_of_type_Rpl.jdField_a_of_type_Int);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("BID_TYPE", 2);
      a((MessageRecord)localObject1, rpl.l, (Bundle)localObject2);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void C()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((pvd)localIterator.next()).E_();
      }
    }
  }
  
  private void D()
  {
    try
    {
      this.jdField_a_of_type_Uvz = new uvz(BaseApplicationImpl.getContext(), 0, 0);
      this.jdField_a_of_type_Uvz.a(new uwd());
      return;
    }
    catch (SecurityException localSecurityException)
    {
      QLog.e("KandianMergeManager", 1, localSecurityException, new Object[0]);
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_Uvz != null)
    {
      this.jdField_a_of_type_Uvz.a();
      this.jdField_a_of_type_Uvz = null;
    }
  }
  
  private void F()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {}
    for (long l = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(0)).longValue();; l = 0L)
    {
      a(l);
      return;
    }
  }
  
  public static int a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        return -1;
      } while (((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN)));
      if ((paramMessageRecord.extInt == 1) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))) {
        return 0;
      }
      if ((paramMessageRecord.extInt == 2) && (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))) {
        return 1;
      }
      if (TextUtils.equals(paramMessageRecord.frienduin, AppConstants.NEW_KANDIAN_UIN)) {
        return 0;
      }
    } while ((paramMessageRecord.istroop != 1008) || (!uot.d(paramQQAppInterface, paramMessageRecord.frienduin)));
    return 1;
  }
  
  private long a(Kandian210Msg0xeeInfo paramKandian210Msg0xeeInfo)
  {
    long l = 0L;
    paramKandian210Msg0xeeInfo = paramKandian210Msg0xeeInfo.notifyInfos.iterator();
    while (paramKandian210Msg0xeeInfo.hasNext()) {
      l = ((Kandian210Msg0xeeInfo.NotifyInfo)paramKandian210Msg0xeeInfo.next()).contextId;
    }
    return l;
  }
  
  private long a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      paramMessageRecord.parse();
      if (paramMessageRecord.structingMsg != null) {
        break label34;
      }
      QLog.d("KandianMergeManager", 1, "getArticleIDFromMessageRecord : struct msg body is null");
    }
    for (;;)
    {
      return 0L;
      label34:
      if ((paramMessageRecord.time >= this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get()) && (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mArticleIds)))
      {
        paramMessageRecord = paramMessageRecord.structingMsg.mArticleIds.split("\\|");
        if (paramMessageRecord.length > 0) {
          try
          {
            if (!TextUtils.isEmpty(paramMessageRecord[0]))
            {
              long l = new BigInteger(paramMessageRecord[0]).longValue();
              return l;
            }
          }
          catch (NumberFormatException paramMessageRecord)
          {
            QLog.e("KandianMergeManager", 1, "getArticleIDFromMessageRecord has num format error : " + paramMessageRecord);
          }
        }
      }
    }
    return 0L;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {}
    while ((!paramBoolean) && ((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.msg, paramString1))) {
      return null;
    }
    MessageRecord localMessageRecord = bcsa.a(-1000);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.msgtype = -1000;
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, long paramLong, String paramString2)
  {
    MessageRecord localMessageRecord = bcsa.a(-1000);
    localMessageRecord.frienduin = AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN;
    localMessageRecord.senderuin = AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN;
    localMessageRecord.istroop = 7225;
    localMessageRecord.msg = paramString1;
    localMessageRecord.time = paramLong;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msg_id", paramString2);
      localMessageRecord.extStr = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.i("KandianMergeManager", 2, "createLockScreenInteractMessage, msg=" + paramString1 + ", msg_id=" + paramString2);
      }
      return localMessageRecord;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("KandianMergeManager", 1, "put msgId error, e=" + localJSONException.toString());
      }
    }
  }
  
  private MessageRecord a(String paramString1, String paramString2, int paramInt)
  {
    MessageRecord localMessageRecord = bcsa.a(-1000);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    MessageRecord localMessageRecord = bcsa.a(-1000);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageRecord.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 6;
    if (bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localMessageRecord.extLong |= 0x20000000;
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
          prp.a(localMessageRecord);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
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
    MessageRecord localMessageRecord = bcsa.a(-1000);
    boolean bool = bmhv.q();
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageRecord.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 5;
    if (bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        localMessageRecord.extInt = 2;
        bool = bmhv.c(paramString3);
      }
      localMessageRecord.issend = 0;
      localMessageRecord.isread = false;
      localMessageRecord.msg = paramString1;
      localMessageRecord.time = paramLong;
      try
      {
        this.jdField_c_of_type_JavaLangString = paramString3;
        if (TextUtils.isEmpty(localMessageRecord.extStr))
        {
          paramString1 = new JSONObject();
          paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
          paramString1.put("kdUin", this.jdField_c_of_type_JavaLangString);
          paramString1.put("kdShouldShowMergedAvatar", bool);
        }
        for (localMessageRecord.extStr = paramString1.toString();; localMessageRecord.extStr = paramString1.toString())
        {
          if (!f()) {
            break label362;
          }
          localMessageRecord.vipBubbleID = -1000L;
          if ((localMessageRecord.vipBubbleID == -1000L) && (!paramBoolean1)) {
            localMessageRecord.extStr = null;
          }
          if (tem.a().a(2000002)) {
            break label387;
          }
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
          prp.a(localMessageRecord);
          paramString1.addMessage(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          return localMessageRecord;
          localMessageRecord.extLong |= 0x2;
          break;
          paramString1 = new JSONObject(localMessageRecord.extStr);
          paramString1.put(jdField_b_of_type_JavaLangString, paramString2);
          paramString1.put("kdUin", this.jdField_c_of_type_JavaLangString);
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
        label362:
        if (paramBoolean1) {}
        for (paramLong = -999L;; paramLong = -1000L)
        {
          localMessageRecord.vipBubbleID = paramLong;
          break;
        }
        label387:
        QLog.w("KandianMergeManager", 2, "app in push is showing, abandon 210 push update msg table!");
      }
    }
    return localMessageRecord;
  }
  
  private MessageRecord a(NamedNodeMap paramNamedNodeMap)
  {
    if (paramNamedNodeMap == null)
    {
      QLog.d("KandianMergeManager", 2, "parseRedPntInfoAndSave redInfoMap null ");
      return null;
    }
    String str1;
    String str2;
    label69:
    String str3;
    label97:
    String str4;
    label125:
    String str5;
    label153:
    String str6;
    if (paramNamedNodeMap.getNamedItem("orangeWord") != null)
    {
      str1 = paramNamedNodeMap.getNamedItem("orangeWord").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("brief") == null) {
        break label425;
      }
      str2 = paramNamedNodeMap.getNamedItem("brief").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("articleIds") == null) {
        break label431;
      }
      str3 = paramNamedNodeMap.getNamedItem("articleIds").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("algorithmIds") == null) {
        break label438;
      }
      str4 = paramNamedNodeMap.getNamedItem("algorithmIds").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("strategyIds") == null) {
        break label445;
      }
      str5 = paramNamedNodeMap.getNamedItem("strategyIds").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("actionData") == null) {
        break label452;
      }
      str6 = paramNamedNodeMap.getNamedItem("actionData").getNodeValue();
      label181:
      if (paramNamedNodeMap.getNamedItem("reportEventFolderStatusValue") == null) {
        break label459;
      }
    }
    label425:
    label431:
    label438:
    label445:
    label452:
    label459:
    for (paramNamedNodeMap = paramNamedNodeMap.getNamedItem("reportEventFolderStatusValue").getNodeValue();; paramNamedNodeMap = "")
    {
      this.h = str3;
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.18(this));
      MessageForStructing localMessageForStructing = (MessageForStructing)bcsa.a(-2011);
      localMessageForStructing.msgtype = -2011;
      localMessageForStructing.structingMsg = bdof.a();
      localMessageForStructing.structingMsg.mMsgServiceID = 142;
      localMessageForStructing.structingMsg.mMsgBrief = str2;
      localMessageForStructing.structingMsg.mOrangeWord = str1;
      localMessageForStructing.structingMsg.mArticleIds = str3;
      localMessageForStructing.structingMsg.mStrategyIds = str5;
      localMessageForStructing.structingMsg.mAlgorithmIds = str4;
      localMessageForStructing.structingMsg.reportEventFolderStatusValue = paramNamedNodeMap;
      localMessageForStructing.structingMsg.mMsgActionData = str6;
      localMessageForStructing.extInt = 1;
      localMessageForStructing.frienduin = AppConstants.KANDIAN_MERGE_UIN;
      localMessageForStructing.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      localMessageForStructing.senderuin = AppConstants.NEW_KANDIAN_UIN;
      localMessageForStructing.istroop = 7220;
      localMessageForStructing.issend = 0;
      localMessageForStructing.isread = false;
      localMessageForStructing.extLong = 0;
      localMessageForStructing.time = NetConnInfoCenter.getServerTime();
      localMessageForStructing.createMessageUniseq();
      localMessageForStructing.doPrewrite();
      return a(localMessageForStructing);
      str1 = "";
      break;
      str2 = "";
      break label69;
      str3 = "";
      break label97;
      str4 = "";
      break label125;
      str5 = "";
      break label153;
      str6 = "";
      break label181;
    }
  }
  
  private void a(long paramLong)
  {
    try
    {
      String str = new pqg().c(paramLong).a();
      olh.a(null, "", "0X8009A8A", "0X8009A8A", 0, 0, "", "", "", str, false);
      QLog.d("KandianMergeManager", 2, new Object[] { "reportAbandonPushRedPoint action = 0X8009A8A, r5 = ", str });
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("KandianMergeManager", 1, "reportAbandonPushRedPoint exception.");
    }
  }
  
  private void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_d_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((pvb)localIterator.next()).a(paramMessageRecord, paramInt, paramBundle);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    paramMessageRecord.senderuin = AppConstants.KANDIAN_MERGE_UIN;
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
  
  private void a(rpl paramrpl, long paramLong)
  {
    boolean bool = false;
    rpl localrpl = this.jdField_c_of_type_Rpl;
    if (localrpl != null)
    {
      if (localrpl != null) {
        QLog.d("KandianMergeManager", 1, "0x210Msg reached, oldSeq = " + localrpl.jdField_b_of_type_Long + ", newSeq = " + paramrpl.jdField_b_of_type_Long);
      }
      if (localrpl.jdField_b_of_type_Long >= paramrpl.jdField_b_of_type_Long)
      {
        if (localrpl.jdField_b_of_type_Long != paramrpl.jdField_b_of_type_Long) {
          bool = true;
        }
        if (bool) {
          localrpl.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "0x210msg delay reach , has a latest msg , no cover! needAddCount : " + bool);
        }
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_c_of_type_Rpl != null) {
        paramrpl.jdField_a_of_type_Int += this.jdField_c_of_type_Rpl.jdField_a_of_type_Int;
      }
      this.jdField_c_of_type_Rpl = paramrpl;
      this.jdField_c_of_type_Rpl.jdField_d_of_type_Long = paramLong;
      this.jdField_c_of_type_Rpl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i = 0;
      while (i < paramrpl.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a((MySelfNormalItemRedPointInfo)paramrpl.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if ((ReadinjoyTabFrame.d_()) && (!oqy.b())) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("KandianMergeManager", 1, new Object[] { "isNeedToBlockPushRedPoint, ret = ", Boolean.valueOf(bool), ", tag = ", paramString });
      return bool;
    }
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong, acnk paramacnk)
  {
    paramArrayOfByte = rpl.a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "process 0x210 follow msg fail!");
      }
    }
    label321:
    label450:
    do
    {
      do
      {
        return;
        paramacnk = this.jdField_a_of_type_Rpl;
        if ((paramacnk == null) || (paramacnk.jdField_b_of_type_Long <= paramArrayOfByte.jdField_b_of_type_Long)) {
          break label558;
        }
        if (paramArrayOfByte.jdField_e_of_type_Int != 1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "0x210msgc5 delay reach showFolder, has a latest msg , no cover! + oldMsg.msgSeq" + paramacnk.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long + "brief : " + paramArrayOfByte.jdField_b_of_type_JavaLangString);
        }
        if ((this.jdField_b_of_type_Rpl == null) || (paramArrayOfByte.jdField_b_of_type_Long > this.jdField_b_of_type_Rpl.jdField_b_of_type_Long))
        {
          if ((this.jdField_b_of_type_Rpl != null) && (QLog.isColorLevel())) {
            QLog.d("KandianMergeManager", 2, "upDate ox210ShowInFolderFollowPushMsg.msgSeq" + this.jdField_b_of_type_Rpl.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
          }
          paramacnk = paramArrayOfByte.jdField_b_of_type_JavaLangString;
          String str = paramArrayOfByte.jdField_a_of_type_JavaLangString;
          paramLong = paramArrayOfByte.jdField_d_of_type_Long;
          if (paramArrayOfByte.g == 0)
          {
            bool = true;
            paramacnk = a(paramacnk, str, paramLong, bool, true, String.valueOf(paramArrayOfByte.jdField_e_of_type_Long));
            a(paramacnk, true);
            this.jdField_b_of_type_Rpl = paramArrayOfByte;
            this.jdField_b_of_type_Rpl.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (QLog.isColorLevel())
            {
              paramArrayOfByte = new StringBuilder().append("has 0x210 follow msg push , brief : ").append(this.jdField_a_of_type_Rpl.jdField_b_of_type_JavaLangString).append(", showInFolder : ");
              if (this.jdField_a_of_type_Rpl.jdField_e_of_type_Int != 1) {
                break label444;
              }
              bool = true;
              paramArrayOfByte = paramArrayOfByte.append(bool).append(", showLockScreen : ");
              if (this.jdField_a_of_type_Rpl.f != 1) {
                break label450;
              }
            }
          }
          for (boolean bool = true;; bool = false)
          {
            QLog.d("KandianMergeManager", 1, bool + ", redType : " + this.jdField_a_of_type_Rpl.g + ", msgSeq : " + this.jdField_a_of_type_Rpl.jdField_b_of_type_Long + ", orangeWord : " + this.jdField_a_of_type_Rpl.jdField_a_of_type_JavaLangString + ", msgCount : " + this.jdField_a_of_type_Rpl.jdField_a_of_type_Int);
            a(paramacnk, rpl.l, null);
            return;
            bool = false;
            break;
            bool = false;
            break label321;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("KandianMergeManager", 2, "no upDate ox210ShowInFolderFollowPushMsg.msgSeq" + this.jdField_b_of_type_Rpl.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
      return;
    } while (!QLog.isColorLevel());
    label444:
    QLog.d("KandianMergeManager", 2, "0x210msgc5 delay reach discarded,  + oldMsg.msgSeq" + paramacnk.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
    return;
    label558:
    if (QLog.isColorLevel()) {
      QLog.d("KandianMergeManager", 2, "0x210msgc5 nomel , msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
    }
    this.jdField_a_of_type_Rpl = paramArrayOfByte;
    this.jdField_a_of_type_Rpl.jdField_d_of_type_Long = paramLong;
    this.jdField_a_of_type_Rpl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    B();
  }
  
  private MessageRecord c()
  {
    Object localObject1 = null;
    bbbq localbbbq = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if (localbbbq == null)
    {
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | RedTouchManager is null ");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = localbbbq.a("1130");
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject2 = localbbbq.b(7, "1130");
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | receive a red point push notify, size : " + localArrayList.size());
    int i = 0;
    Object localObject5;
    if (i < localArrayList.size())
    {
      localObject5 = (BusinessInfoCheckUpdate.AppInfo)localArrayList.get(i);
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | parse redPntInfo type :  " + ((BusinessInfoCheckUpdate.AppInfo)localObject5).type.get());
      localObject2 = Aladdin.getConfig(186);
      if (((BusinessInfoCheckUpdate.AppInfo)localObject5).type.get() == 5) {
        if (((AladdinConfig)localObject2).getIntegerFromString("use_new_route", 0) == 0)
        {
          QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | use old route, skip parse num push info");
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      i += 1;
      localObject1 = localObject2;
      break;
      localObject2 = localObject1;
      if (((BusinessInfoCheckUpdate.AppInfo)localObject5).red_display_info.get() != null)
      {
        localObject2 = localObject1;
        if (((BusinessInfoCheckUpdate.RedDisplayInfo)((BusinessInfoCheckUpdate.AppInfo)localObject5).red_display_info.get()).red_type_info.get() != null)
        {
          localObject5 = (BusinessInfoCheckUpdate.RedDisplayInfo)((BusinessInfoCheckUpdate.AppInfo)localObject5).red_display_info.get();
          localObject2 = localObject1;
          if (localObject5 != null)
          {
            localObject5 = (BusinessInfoCheckUpdate.RedTypeInfo)((BusinessInfoCheckUpdate.RedDisplayInfo)localObject5).tab_display_info.get();
            localObject2 = localObject1;
            if (localObject5 != null)
            {
              localObject5 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject5).red_content.get();
              Object localObject6 = localbbbq.a(1130);
              localObject2 = localObject1;
              if (localObject6 != null)
              {
                localObject2 = localObject1;
                if (!((List)localObject6).isEmpty())
                {
                  localObject2 = new ArrayList((Collection)localObject6);
                  int k = ((List)localObject2).size();
                  localObject6 = new long[k];
                  int j = 0;
                  if (j < k)
                  {
                    BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((List)localObject2).get(j);
                    if (localNumRedPath == null) {}
                    for (;;)
                    {
                      j += 1;
                      break;
                      localObject6[j] = localNumRedPath.uint64_msgid.get();
                    }
                  }
                  localbbbq.a((long[])localObject6, "kandian_num_red_pnt_buffer", new puu(this));
                  QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | numRedPoint num: " + (String)localObject5 + ", extraNum : " + localbbbq.a(1130) + ", lastMsgID : " + localObject6[(localObject6.length - 1)]);
                  localObject2 = localObject1;
                  continue;
                  localObject2 = localObject1;
                  if (((BusinessInfoCheckUpdate.AppInfo)localObject5).type.get() == 0)
                  {
                    localObject2 = localObject1;
                    if (((BusinessInfoCheckUpdate.AppInfo)localObject5).buffer.has())
                    {
                      localObject2 = ((BusinessInfoCheckUpdate.AppInfo)localObject5).buffer.get();
                      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | buffer jsonStr " + (String)localObject2);
                      try
                      {
                        localObject2 = new JSONObject((String)localObject2);
                        localObject5 = ((JSONObject)localObject2).optString("_show_mission");
                        localObject2 = new JSONObject(new JSONObject(((JSONObject)localObject2).optString("param")).optString((String)localObject5)).optString("_red_ext_kd_push_msg_xml");
                        QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | kandian redpoint xmlContent " + (String)localObject2);
                        localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject2).getBytes("utf-8"))).getElementsByTagName("msg").item(0);
                        if (localObject2 == null) {
                          break label992;
                        }
                        localObject2 = ((Node)localObject2).getAttributes();
                        if (localObject2 == null) {
                          break label992;
                        }
                        if ((((NamedNodeMap)localObject2).getNamedItem("articleIds") != null) && (!TextUtils.isEmpty(this.h)) && (this.h.equalsIgnoreCase(((NamedNodeMap)localObject2).getNamedItem("articleIds").getNodeValue())))
                        {
                          QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | duplicate redPntInfo | mLastRedTouchInfoArticleId " + this.h + " ; duplicateArticleId: " + ((NamedNodeMap)localObject2).getNamedItem("articleIds").getNodeValue());
                          localObject2 = localObject1;
                        }
                      }
                      catch (Exception localException1) {}
                      for (;;)
                      {
                        QLog.e("KandianMergeManager", 1, "handlerRedPntCenterNotify JSONException " + localException1);
                        Object localObject3 = localObject1;
                        break;
                        localObject3 = a((NamedNodeMap)localObject3);
                        localObject1 = localObject3;
                        try
                        {
                          localObject5 = new StringBuilder().append("handlerRedPntCenterNotify | parseRedPntInfoAndSave ");
                          if (localObject1 != null) {}
                          for (localObject3 = "succeed";; localObject3 = "failed")
                          {
                            QLog.d("KandianMergeManager", 1, (String)localObject3);
                            localObject3 = localObject1;
                            if (localObject1 == null) {
                              break;
                            }
                            localObject3 = localObject1;
                            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
                              break;
                            }
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
                            localObject3 = localObject1;
                            break;
                          }
                          QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify end !");
                          return localObject1;
                        }
                        catch (Exception localException2) {}
                      }
                      label992:
                      Object localObject4 = localObject1;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    MessageRecord localMessageRecord = null;
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localQQMessageFacade != null) {
      localMessageRecord = localQQMessageFacade.getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
    }
    String str1;
    Object localObject;
    if ((localMessageRecord != null) && (a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) && (localMessageRecord.extInt == 2) && (!localMessageRecord.isread)) {
      if (QLog.isColorLevel())
      {
        str1 = "lastMr_info 【" + "msg: " + pkh.a(localMessageRecord.msg) + ", msguid : " + localMessageRecord.msgUid;
        if (!(localMessageRecord instanceof MessageForStructing)) {
          break label356;
        }
        localObject = (MessageForStructing)localMessageRecord;
        ((MessageForStructing)localObject).parse();
        if (((MessageForStructing)localObject).structingMsg == null) {
          break label356;
        }
        str1 = str1 + ", title : " + pkh.a(((MessageForStructing)localObject).structingMsg.mMsgBrief) + " 】";
      }
    }
    label356:
    for (;;)
    {
      String str2 = "newMr_info 【" + "msg: " + pkh.a(paramMessageRecord.msg) + ", senderUin : " + paramMessageRecord.senderuin + " , msguid : " + paramMessageRecord.msgUid;
      localObject = str2;
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
        paramMessageRecord.parse();
        localObject = str2;
        if (paramMessageRecord.structingMsg != null) {
          localObject = str2 + ", title : " + pkh.a(paramMessageRecord.structingMsg.mMsgBrief) + " 】";
        }
      }
      QLog.i("KandianMergeManager", 2, "subscribe push msg cover ! \n" + str1 + "\n" + (String)localObject);
      localQQMessageFacade.removeMsgByMessageRecord(localMessageRecord, false);
      return;
    }
  }
  
  private void c(byte[] paramArrayOfByte, long paramLong, acnk paramacnk)
  {
    int i = rpl.a(paramArrayOfByte);
    if (i == rpl.j) {}
    rpl localrpl;
    do
    {
      do
      {
        return;
        if (i == rpl.l)
        {
          a(paramArrayOfByte);
          return;
        }
        localrpl = rpl.a(paramArrayOfByte);
        if (localrpl != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("KandianMergeManager", 2, "process 0x210 msg fail!");
      return;
      i = rpl.b(paramArrayOfByte);
    } while (i == rpl.m);
    boolean bool2;
    boolean bool3;
    boolean bool1;
    if ((i == rpl.n) || (i == rpl.o))
    {
      pvj.a().b(0, "");
      bool2 = pqu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bool3 = prs.a();
      if (((!bool2) && (!bool3)) || (localrpl.f != 1) || (!((Boolean)bmhv.a("sp_msg_box_80a_enable_receive", Boolean.valueOf(true))).booleanValue())) {
        break label359;
      }
      bool1 = true;
      label150:
      if (bool1)
      {
        paramArrayOfByte = a(localrpl.jdField_b_of_type_JavaLangString, localrpl.jdField_d_of_type_Long, localrpl.h);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false, false, true, false);
        paramacnk.a("handleGetKandian210Message", true, 1, true, false);
        if ((pqt.c() != 1) && (pro.b() == 2)) {
          break label365;
        }
      }
    }
    label359:
    label365:
    for (i = 3;; i = 1)
    {
      olh.a("0X80081DC", new pqg().a("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).a("load_mode", Integer.valueOf(i)).a("push_type", Integer.valueOf(9)).a());
      QLog.i("KandianMergeManager", 1, "isAppBackground=" + bool2 + ",needNotificationForeground" + bool3 + ",showLockScreen=" + localrpl.f + ",needShow=" + bool1);
      return;
      if (i != rpl.p) {
        break;
      }
      a(localrpl, paramLong);
      break;
      bool1 = false;
      break label150;
    }
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    for (;;)
    {
      try
      {
        if (!(paramMessageRecord instanceof MessageForStructing)) {
          break label239;
        }
        Object localObject = (MessageForStructing)paramMessageRecord;
        ((MessageForStructing)localObject).parse();
        if (((MessageForStructing)localObject).structingMsg == null) {
          break label239;
        }
        localObject = new JSONObject(((MessageForStructing)localObject).structingMsg.mMsgActionData);
        if (!((JSONObject)localObject).has("showMergedAvatar")) {
          break label234;
        }
        if (((JSONObject)localObject).getInt("showMergedAvatar") != 1) {
          break label240;
        }
        bool = true;
        if (((JSONObject)localObject).has("uin")) {
          this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).getString("uin");
        }
        if (!((JSONObject)localObject).has("biuUin")) {
          break label231;
        }
        this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).getString("biuUin");
        bool = bmhv.p();
        if (((JSONObject)localObject).has("defaultAvatarUrl"))
        {
          localObject = ((JSONObject)localObject).getString("defaultAvatarUrl");
          if (TextUtils.isEmpty(paramMessageRecord.extStr))
          {
            localJSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
              localJSONObject.put("kdUin", this.jdField_c_of_type_JavaLangString);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localJSONObject.put("kdDefaultSourceAvatarUrl", localObject);
            }
            localJSONObject.put("kdShouldShowMergedAvatar", bool);
            paramMessageRecord.extStr = localJSONObject.toString();
            return;
          }
          JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
          continue;
        }
        localObject = null;
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
      continue;
      label231:
      continue;
      label234:
      boolean bool = false;
      continue;
      label239:
      return;
      label240:
      bool = false;
    }
  }
  
  private boolean d(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return true;
    }
    if ((a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) && (pkh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      return true;
    }
    if (tem.a().a(2000002))
    {
      QLog.d("KandianMergeManager", 2, "app in push is showing, abandon the new msg !");
      return true;
    }
    if ((pkh.a(paramMessageRecord)) && (pkh.b(paramMessageRecord)))
    {
      QLog.d("KandianMergeManager", 1, "receive daily lock screen red point push ! mr : " + paramMessageRecord);
      ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(paramMessageRecord);
      return true;
    }
    return !a(paramMessageRecord);
  }
  
  private void e(MessageRecord paramMessageRecord)
  {
    if (this.jdField_d_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((pvb)localIterator.next()).a(paramMessageRecord);
      }
    }
  }
  
  private void s()
  {
    Object localObject = (pvp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ((pvp)localObject).a().b(0, 20, 9223372036854775807L, true);
    ((pvp)localObject).a().b(56, 20, 9223372036854775807L, true);
    ((pvp)localObject).a().b(70, 20, 9223372036854775807L, true);
    ((pvp)localObject).a().b(plm.b(), 20, 9223372036854775807L, true);
    ((pvp)localObject).a().c(0);
    ((pvp)localObject).a().m();
    ((pvp)localObject).a().r();
    ((pvp)localObject).a().b();
    D();
    localObject = pis.a.a();
    pis.a.a((List)localObject);
    QLog.d("KandianMergeManager", 1, "preload pts card, rules : " + localObject);
  }
  
  private void t()
  {
    ThreadManager.getFileThreadHandler().post(new KandianMergeManager.4(this));
  }
  
  private void u()
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.5(this));
  }
  
  private void v()
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.6(this));
  }
  
  private void w()
  {
    MiniAppNotify.g.register(this.jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener);
  }
  
  private void x()
  {
    MiniAppNotify.g.remove(this.jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener);
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void z()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.h = localSharedPreferences.getString("kandian_red_touch_pnt_article_id", "");
    QLog.d("KandianMergeManager", 1, "initCache mLastRedTouchInfoArticleId : " + this.h);
    Object localObject = localSharedPreferences.getString("kandian_push_msg_xml", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = bdof.a(PkgTools.hexToBytes((String)localObject));
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mArticleIds))
      {
        String[] arrayOfString = ((AbsStructMsg)localObject).mArticleIds.split("\\|");
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        while (i < arrayOfString.length)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(arrayOfString[i]));
          i += 1;
        }
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mMsgActionData)) {
        this.jdField_a_of_type_JavaLangString = ((AbsStructMsg)localObject).mMsgActionData;
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mAlgorithmIds)) {
        this.jdField_a_of_type_Long = Long.parseLong(localObject.mAlgorithmIds.split("\\|")[0]);
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mStrategyIds)) {
        this.jdField_b_of_type_Long = Long.parseLong(localObject.mStrategyIds.split("\\|")[0]);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      l = localSharedPreferences.getLong("kandian_push_msg_time", 0L);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l;
        localException.printStackTrace();
      }
    }
    this.jdField_e_of_type_JavaLangString = "";
    this.f = "";
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(-1L);
    l = localSharedPreferences.getLong("subscribe_push_msg_time", 0L);
    if (l > 0L)
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
      this.jdField_d_of_type_JavaLangString = localSharedPreferences.getString("subscribe_push_msg_uin", "");
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(localSharedPreferences.getInt("subscribe_push_msg_status", -1));
      this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(localSharedPreferences.getInt("subscribe_push_msg_msgtype", -1));
      if ((this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1)) {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      }
    }
    this.jdField_a_of_type_Rpm = rpm.a();
    this.jdField_a_of_type_Rpl = rpl.b();
    this.jdField_b_of_type_Rpl = rpl.c();
    this.jdField_c_of_type_Rpl = rpl.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo = KandianMsgBoxRedPntInfo.getRedPntInfoFromSp();
    QLog.d("KandianMergeManager", 1, "init msgbox info from sp. " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo = Kandian210Msg0xeeInfo.getKandian210Msg0xeeInfoFromSp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QLog.d("KandianAppInPush", 2, "init app push info from cache : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo);
    if (this.jdField_b_of_type_Rpl != null)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_b_of_type_Rpl.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Rpl.jdField_b_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_b_of_type_Rpl.jdField_b_of_type_JavaLangString;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo = ((KandianMergeManager.KandianSetTopInfo)prd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_msgtab_settop", true));
    QLog.d("KandianMergeManager.SETTOP", 2, "get from cache : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo);
    A();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.getRedDotFromDisk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_video_tab_reddot_info", true);
    QLog.d("KandianMergeManager", 1, "init mianVideoTabRed : " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.getRedDotFromDisk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_red_pnt_lock_screen", true);
    QLog.d("KandianMergeManager", 2, "lock screen push info : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo);
    ThreadManager.executeOnSubThread(new KandianMergeManager.11(this));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (!bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
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
    if (this.jdField_a_of_type_Rpl != null) {
      return this.jdField_a_of_type_Rpl.c;
    }
    return 0L;
  }
  
  public Pair<Object, String> a()
  {
    if ((!bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3)) || ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2))) {}
    do
    {
      return null;
      c(2);
      QLog.d("KandianMergeManager", 1, "mSubscribePushMsgTitle : " + pqu.a(this.jdField_e_of_type_JavaLangString) + " mSubscribePushMsgArticleID : " + this.jdField_a_of_type_JavaLangLong + " mInnerUniqId : " + this.f + " seedUIN :  " + this.jdField_d_of_type_JavaLangString + ", isInterestedAccount : " + uuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    } while ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || ((TextUtils.isEmpty(this.f)) && (this.jdField_a_of_type_JavaLangLong.longValue() == -1L)));
    if ((bmhv.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(this.f))) {
      return new Pair(this.f, this.jdField_e_of_type_JavaLangString);
    }
    return new Pair(this.jdField_a_of_type_JavaLangLong, this.jdField_e_of_type_JavaLangString);
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
  
  @Nullable
  public KandianMsgBoxRedPntInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo;
  }
  
  public KandianRedDotInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  }
  
  public MySelfNormalItemRedPointInfo a(int paramInt)
  {
    Object localObject1 = bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true).getString("kandian_myself_red_point" + paramInt, "");
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject3 = null;
    }
    Object localObject2;
    do
    {
      return localObject3;
      localObject1 = new ByteArrayInputStream(Base64.decode(((String)localObject1).getBytes(), 0));
      try
      {
        localObject1 = (MySelfNormalItemRedPointInfo)new ObjectInputStream((InputStream)localObject1).readObject();
        if (localObject1 == null) {
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("KandianMergeManager", 2, "getMySelfRedPointInfo:" + localException.toString());
          }
          localObject2 = null;
        }
        if (localObject2.failureTime < System.currentTimeMillis() / 1000L)
        {
          e(paramInt);
          return null;
        }
        localObject3 = localObject2;
      }
    } while (localObject2.effectTime <= System.currentTimeMillis() / 1000L);
    return null;
  }
  
  public MessageRecord a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(AppConstants.KANDIAN_MERGE_UIN, 7220);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4)) {}
        while ((!localMessageRecord.isValid) || (acnh.h(localMessageRecord.msgtype)))
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryLastMsgForMessageTabFromDB(AppConstants.KANDIAN_MERGE_UIN, 7220, "extInt=1 OR extInt=3");
      }
      return localObject;
      localMessageRecord = null;
    }
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (d(paramMessageRecord)) {
      return null;
    }
    c(paramMessageRecord);
    MessageRecord localMessageRecord = bcsa.a(paramMessageRecord.msgtype);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageRecord.istroop = 7220;
    int i = a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 0)
    {
      localMessageRecord.extInt = 1;
      a(localMessageRecord, 0);
      if (!bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label175;
      }
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
      label98:
      if (!f()) {
        break label188;
      }
      localMessageRecord.vipBubbleID = -1000L;
      label112:
      d(localMessageRecord);
      if (i != 0) {
        break label198;
      }
      e(localMessageRecord);
    }
    for (;;)
    {
      prp.a(localMessageRecord);
      if (pkh.a(paramMessageRecord)) {
        ThreadManager.post(new KandianMergeManager.19(this), 8, null, false);
      }
      return localMessageRecord;
      if (i == 1)
      {
        localMessageRecord.extInt = 2;
        break;
      }
      localMessageRecord.extInt = 0;
      break;
      label175:
      localMessageRecord.extLong |= 0x2;
      break label98;
      label188:
      localMessageRecord.vipBubbleID = -999L;
      break label112;
      label198:
      if (i == 1)
      {
        b(localMessageRecord);
        l();
      }
    }
  }
  
  public MessageRecord a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)bcsa.a(-2011);
    localMessageForStructing.istroop = 7220;
    localMessageForStructing.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localMessageForStructing.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    localMessageForStructing.senderuin = AppConstants.NEW_KANDIAN_UIN;
    localMessageForStructing.time = prr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localMessageForStructing.isread = false;
    localMessageForStructing.issend = 0;
    localMessageForStructing.extInt = 1;
    localMessageForStructing.extLong |= 0x20000000;
    localMessageForStructing.extLong |= 0x1;
    localMessageForStructing.structingMsg = bdof.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing.istroop, Long.valueOf(localMessageForStructing.senderuin).longValue(), paramString.getBytes(), 0);
    if (localMessageForStructing.structingMsg == null) {
      return null;
    }
    localMessageForStructing.msg = localMessageForStructing.structingMsg.mMsgBrief;
    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
    a(localMessageForStructing, 1);
    if (!a(localMessageForStructing)) {
      return null;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    prp.a(localMessageForStructing);
    paramString.addMessage(localMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    return localMessageForStructing;
  }
  
  public MessageRecord a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    Object localObject = new ram();
    paramArrayOfByte = ((ram)localObject).a(new String(paramArrayOfByte));
    JSONObject localJSONObject = ((ram)localObject).a(new String(paramArrayOfByte.jdField_a_of_type_ArrayOfByte));
    localObject = ((ram)localObject).a(new String(paramArrayOfByte.jdField_a_of_type_ArrayOfByte), paramString);
    paramString = (MessageForStructing)bcsa.a(-2011);
    paramString.msgtype = -2011;
    paramString.structingMsg = bdof.a();
    paramString.structingMsg.mMsgServiceID = 142;
    paramString.structingMsg.mArticleIds = paramArrayOfByte.jdField_a_of_type_JavaLangString;
    paramString.structingMsg.mStrategyIds = paramArrayOfByte.jdField_d_of_type_JavaLangString;
    paramString.structingMsg.mAlgorithmIds = paramArrayOfByte.jdField_c_of_type_JavaLangString;
    paramString.structingMsg.reportEventFolderStatusValue = paramArrayOfByte.jdField_b_of_type_JavaLangString;
    paramString.structingMsg.mMsgActionData = localJSONObject.toString();
    paramString.structingMsg.mExtraData = new String(paramArrayOfByte.jdField_a_of_type_ArrayOfByte);
    paramString.structingMsg.mMsgBrief = ((JSONObject)localObject).optString("brief", "");
    paramString.structingMsg.mOrangeWord = ((JSONObject)localObject).optString("orangeWord", "");
    paramString.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    paramString.frienduin = AppConstants.KANDIAN_MERGE_UIN;
    paramString.senderuin = AppConstants.NEW_KANDIAN_UIN;
    paramString.istroop = 7220;
    paramString.extInt = 1;
    paramString.time = NetConnInfoCenter.getServerTime();
    paramString.isread = false;
    paramString.issend = 0;
    if (bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      paramString.extLong |= 0x20000000;
    }
    for (paramString.extLong |= 0x1;; paramString.extLong |= 0x2)
    {
      QLog.d("KandianMergeManager", 1, "createFakeMsgFrom0x135XmlBuffer fakeMr.structingMsg: " + paramString.structingMsg);
      paramString.msg = paramString.structingMsg.mMsgBrief;
      paramString.msgData = paramString.structingMsg.getBytes();
      a(paramString, 0);
      if (!prq.a(paramString)) {
        break;
      }
      QLog.d("KandianMergeManager", 1, "createFakeMsgFrom0x135XmlBuffer receive daily push ! mr : " + paramString);
      ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(paramString);
      return paramString;
    }
    c(paramString);
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    prp.a(paramString);
    paramArrayOfByte.addMessage(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    return paramString;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    int i = 1;
    int k = 0;
    int j = 0;
    Object localObject2 = "";
    label42:
    Object localObject1;
    if (!bmhv.m()) {
      if (b())
      {
        k = 1;
        int m = f();
        if ((k <= 0) && (m <= 0)) {
          break label156;
        }
        i = 1;
        if (m > 0) {
          j = 5;
        }
        localObject1 = String.valueOf(m);
        if (m > 99) {
          localObject1 = "99+";
        }
        QLog.d("KandianMergeManager", 1, "getReadinjoyTabRedInfo, recommendRedNum : " + k + ", msgBoxRedNum : " + m);
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label185;
      }
      localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("{'cn':'#FF0000'}");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(j);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set((String)localObject1);
      return localObject2;
      k = 0;
      break;
      label156:
      i = 0;
      break label42;
      j = k;
      localObject1 = localObject2;
      if (!g())
      {
        i = 0;
        j = k;
        localObject1 = localObject2;
      }
    }
    label185:
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(Long paramLong)
  {
    if (paramLong.longValue() > 0L) {
      return (String)this.jdField_a_of_type_JavaUtilMap.get(paramLong);
    }
    return null;
  }
  
  public List<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (!bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
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
  
  public void a()
  {
    if (Aladdin.getConfig(258).getIntegerFromString("load_resources_after_login", 1) == 1) {
      ThreadManager.executeOnSubThread(new KandianMergeManager.3(this));
    }
    l();
    udj.a.a();
    qzw.a();
    oxv.a.b();
    oyg.a.a();
    pwx.a.a();
    pje.a.a();
    TKDCommentFragmentHelper.clearHippyCommentConfig();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("KandianMergeManager", 2, "followListLength" + paramInt);
    }
    this.jdField_b_of_type_Int = paramInt;
    ThreadManager.post(new KandianMergeManager.12(this, paramInt), 8, null, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    KandianMergeManager.KandianSetTopInfo localKandianSetTopInfo = KandianMergeManager.KandianSetTopInfo.get(paramInt1, paramInt2);
    prd.a("kandian_msgtab_settop", localKandianSetTopInfo, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo = localKandianSetTopInfo;
    QLog.d("KandianMergeManager.SETTOP", 2, "update kandian push msg setTop info : " + localKandianSetTopInfo);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.g = paramString;
    if (!this.g.isEmpty()) {
      pvj.a().b(paramInt, this.g);
    }
  }
  
  public void a(aozi paramaozi)
  {
    a(paramaozi);
    a(paramaozi);
    a(paramaozi);
    pvm.a().a(paramaozi);
  }
  
  public void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (paramKandianMsgBoxRedPntInfo.mSeq <= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mSeq) && ((this.g == null) || (this.g.isEmpty()))) {}
    for (int i = 1; (paramKandianMsgBoxRedPntInfo == null) || (paramKandianMsgBoxRedPntInfo.mMsgCnt <= 0) || (i != 0); i = 0)
    {
      QLog.d("KandianMergeManager", 1, new Object[] { "new msgbox red info has error, local : ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo, "new : ", paramKandianMsgBoxRedPntInfo });
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo = paramKandianMsgBoxRedPntInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.asyncWriteToSP();
    this.g = "";
    String str;
    long l;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mNeedShowInFolder)
    {
      paramKandianMsgBoxRedPntInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mSummary;
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mOrangeWord;
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgTime;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mRedType == 0) {
        bool = true;
      }
    }
    for (paramKandianMsgBoxRedPntInfo = a(paramKandianMsgBoxRedPntInfo, str, l, bool, false, null);; paramKandianMsgBoxRedPntInfo = null)
    {
      a(paramKandianMsgBoxRedPntInfo, rpl.k, null);
      l();
      QLog.d("KandianMergeManager", 1, "update msgbox redpnt info. " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
      return;
      bool = false;
      break;
    }
  }
  
  public void a(KandianRedDotInfo paramKandianRedDotInfo)
  {
    if (paramKandianRedDotInfo == null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null) {
      if (!paramKandianRedDotInfo.hasArticleID()) {}
    }
    for (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = paramKandianRedDotInfo;; this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = paramKandianRedDotInfo)
    {
      QLog.d("KandianMergeManager", 1, "update mainVideoTab RedDot : " + paramKandianRedDotInfo);
      m();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.saveToDiskAsync(true);
      return;
      QLog.d("KandianMergeManager", 1, "main video tab fake red drop because of has reddot now!");
      return;
    }
  }
  
  public void a(MySelfNormalItemRedPointInfo paramMySelfNormalItemRedPointInfo)
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.37(this, paramMySelfNormalItemRedPointInfo));
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread))
    {
      paramMessageRecord.isread = true;
      ThreadManager.post(new KandianMergeManager.21(this, paramMessageRecord), 10, null, false);
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
      if (TextUtils.equals(paramString, this.jdField_d_of_type_JavaLangString))
      {
        e();
        MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
        if ((localMessageRecord != null) && (localMessageRecord.extInt == 2) && (TextUtils.equals(localMessageRecord.senderuin, paramString)))
        {
          paramString = a();
          if (paramString != null)
          {
            prp.a(paramString);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
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
      localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    } while (localQQMessageFacade == null);
    ThreadManager.post(new KandianMergeManager.14(this, localQQMessageFacade, paramString1, paramString2, paramInt, paramBoolean), 10, null, false);
  }
  
  public void a(puz parampuz)
  {
    if (parampuz == null) {}
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_JavaUtilList.add(parampuz);
      }
      finally {}
    }
  }
  
  public void a(pvb parampvb)
  {
    if (parampvb == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_d_of_type_JavaUtilList == null) {
          this.jdField_d_of_type_JavaUtilList = new ArrayList();
        }
        QLog.d("KandianMergeManager", 2, "add MsgObserver " + parampvb.getClass().getSimpleName() + ", " + parampvb);
        if (this.jdField_d_of_type_JavaUtilList.contains(parampvb)) {
          continue;
        }
        this.jdField_d_of_type_JavaUtilList.add(parampvb);
      }
      finally {}
    }
  }
  
  public void a(pvc parampvc)
  {
    if (parampvc == null) {}
    do
    {
      return;
      if (this.jdField_c_of_type_JavaUtilList == null) {
        this.jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
      }
      QLog.d("KandianMergeManager", 2, "add tabRedNumChangeObserver " + parampvc.getClass().getSimpleName() + ", " + parampvc);
    } while (this.jdField_c_of_type_JavaUtilList.contains(parampvc));
    this.jdField_c_of_type_JavaUtilList.add(parampvc);
  }
  
  public void a(pvd parampvd)
  {
    if (parampvd == null) {}
    do
    {
      return;
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
      }
      QLog.d("KandianMergeManager", 2, "add tabRedNumChangeObserver " + parampvd.getClass().getSimpleName() + ", " + parampvd);
    } while (this.jdField_b_of_type_JavaUtilList.contains(parampvd));
    this.jdField_b_of_type_JavaUtilList.add(parampvd);
  }
  
  public void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      pqu.a(localQQAppInterface, paramBoolean);
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
        o();
      }
      return;
    }
    tem.a().a(false);
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
    aoxz localaoxz;
    RecentUser localRecentUser;
    do
    {
      return;
      i = 0;
      break;
      localaoxz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      localRecentUser = (RecentUser)localaoxz.findRecentUser(AppConstants.KANDIAN_MERGE_UIN, 7220);
    } while ((localRecentUser == null) && (!paramBoolean1) && (paramBoolean2 == true));
    Object localObject = localRecentUser;
    if (localRecentUser == null)
    {
      localObject = new RecentUser(AppConstants.KANDIAN_MERGE_UIN, 7220);
      ((RecentUser)localObject).lastmsgtime = NetConnInfoCenter.getServerTime();
    }
    if (paramBoolean1) {}
    for (((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);; ((RecentUser)localObject).showUpTime = 0L)
    {
      localaoxz.saveRecentUser((BaseRecentUser)localObject);
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
      long l2 = this.jdField_a_of_type_Rpm.jdField_a_of_type_Long;
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
        this.jdField_a_of_type_Rpm.jdField_a_of_type_Long = l1;
        this.jdField_a_of_type_Rpm.jdField_b_of_type_Long = l2;
        this.jdField_a_of_type_Rpm.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Rpm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        QLog.d("KandianMergeManager", 1, "has biu 0x210 msg push, seq = " + l1 + ", uin = " + l2);
        a(null, rpl.l, null);
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
    Kandian210Msg0xeeInfo localKandian210Msg0xeeInfo = Kandian210Msg0xeeInfo.decodeFromPbBytes(paramArrayOfByte);
    if ((localKandian210Msg0xeeInfo == null) || (tem.a().a())) {
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
    if (a("processMsg0x210Sub0xee"))
    {
      a(a(localKandian210Msg0xeeInfo));
      return;
    }
    boolean bool = false;
    Object localObject;
    Kandian210Msg0xeeInfo.NotifyInfo localNotifyInfo;
    if (localKandian210Msg0xeeInfo.isArticleAppInPush())
    {
      this.jdField_a_of_type_Long = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).algorithmID;
      this.jdField_b_of_type_Long = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).strategyID;
      this.jdField_a_of_type_JavaLangString = pkf.a(((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).extCookie, 0);
      localObject = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).orangeWord;
      paramArrayOfByte = (byte[])localObject;
      if (localObject == null) {
        paramArrayOfByte = anvx.a(2131705396);
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
      e(paramArrayOfByte);
      bool = true;
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo = localKandian210Msg0xeeInfo;
        Kandian210Msg0xeeInfo.writeToSpAsync(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo);
        o();
      }
      QLog.d("KandianMergeManager", 2, "process Msg 210 0xee canHandle : " + bool + "\n InAppPush : " + localKandian210Msg0xeeInfo);
      return;
      if (localKandian210Msg0xeeInfo.isVideoAppInPush())
      {
        if (!bmhv.m())
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
  
  public void a(byte[] paramArrayOfByte, long paramLong, acnk paramacnk)
  {
    int i = rpl.c(paramArrayOfByte);
    QLog.i("KandianMergeManager", 1, "processMsg0x210Sub0xc5, receiveMsg bidType= " + i);
    if (i == 2)
    {
      b(paramArrayOfByte, paramLong, paramacnk);
      return;
    }
    c(paramArrayOfByte, paramLong, paramacnk);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0;
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
          ThreadManager.getSubThreadHandler().post(new KandianMergeManager.31(this));
        }
        d(1);
        return true;
      }
      if ((paramInt1 == 1) && (paramInt2 == 1))
      {
        if (b(1) > 0) {
          ThreadManager.getSubThreadHandler().post(new KandianMergeManager.32(this));
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
          paramMessageRecord = (pvp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
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
            this.jdField_e_of_type_JavaLangString = "";
            this.f = "";
            this.jdField_a_of_type_JavaLangLong = Long.valueOf(-1L);
            if (uuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramMessageRecord.msgtype))
            {
              bool = true;
              localObject1 = "";
              this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
              this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
              this.jdField_d_of_type_JavaLangString = str;
              this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
              this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(j);
              if ((paramBoolean) || (!bmhv.n())) {
                g();
              }
              ThreadManager.getSubThreadHandler().post(new KandianMergeManager.22(this, l, str, 1, (String)localObject1, j));
              QLog.d("KandianMergeManager", 1, "subscribe push, title : " + this.jdField_e_of_type_JavaLangString + ", id : " + this.jdField_a_of_type_JavaLangLong + ", msguid : " + paramMessageRecord.msgUid + ", isInterestedAccount : " + bool);
              paramBoolean = true;
              continue;
            }
            if ((paramMessageRecord instanceof MessageForStructing))
            {
              Object localObject3 = (MessageForStructing)paramMessageRecord;
              ((MessageForStructing)localObject3).parse();
              if (((MessageForStructing)localObject3).structingMsg == null) {
                break label518;
              }
              localObject1 = PkgTools.toHexStr(((MessageForStructing)localObject3).structingMsg.getBytes());
              this.jdField_e_of_type_JavaLangString = ((MessageForStructing)localObject3).structingMsg.mMsgBrief;
              if (!TextUtils.isEmpty(((MessageForStructing)localObject3).structingMsg.mInnerUniqIds))
              {
                localObject2 = ((MessageForStructing)localObject3).structingMsg.mInnerUniqIds.split("\\|");
                k = localObject2.length;
                i = 0;
                if (i >= k) {
                  break label525;
                }
                localObject3 = localObject2[i];
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label531;
                }
                this.f = ((String)localObject3);
                break label525;
              }
              localObject2 = localObject1;
              if (TextUtils.isEmpty(((MessageForStructing)localObject3).structingMsg.mArticleIds)) {
                break label518;
              }
              localObject3 = ((MessageForStructing)localObject3).structingMsg.mArticleIds.split("\\|");
              int k = localObject3.length;
              i = 0;
              localObject2 = localObject1;
              if (i >= k) {
                break label518;
              }
              localObject2 = localObject3[i];
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label538;
              }
              this.jdField_a_of_type_JavaLangLong = Long.valueOf((String)localObject2);
              break label525;
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
      label518:
      label525:
      boolean bool = false;
      continue;
      label531:
      i += 1;
      continue;
      label538:
      i += 1;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Rpl != null) {
      return this.jdField_a_of_type_Rpl.jdField_d_of_type_Int;
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
      if (this.jdField_a_of_type_Rpl == null) {
        break;
      }
      i = 1;
      continue;
      i = e();
    }
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo != null) {
      return KandianMergeManager.KandianSetTopInfo.access$1300(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo);
    }
    return 0L;
  }
  
  public KandianRedDotInfo b()
  {
    return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  }
  
  public MessageRecord b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(AppConstants.KANDIAN_MERGE_UIN, 7220);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4) || (localMessageRecord.extInt == 3)) {}
        while (((localMessageRecord.extInt == 5) && (!e())) || (!localMessageRecord.isValid) || (acnh.h(localMessageRecord.msgtype)))
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryLastMsgForMessageTabFromDB(AppConstants.KANDIAN_MERGE_UIN, 7220, "extInt=1");
      }
      return localObject;
      localMessageRecord = null;
    }
  }
  
  public List<puz> b()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList.clear();
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    bbbq localbbbq = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbbq.a("1130");
    if (localAppInfo != null) {
      localbbbq.b(localAppInfo, "");
    }
    localAppInfo = localbbbq.b(7, "1130");
    if (localAppInfo != null) {
      localbbbq.b(localAppInfo, "");
    }
    QLog.d("KandianMergeManager", 1, "reportRedPntExposure");
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
    e();
  }
  
  public void b(aozi paramaozi)
  {
    b(paramaozi);
    b(paramaozi);
    b(paramaozi);
    pvm.a().b(paramaozi);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (this.jdField_d_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((pvb)localIterator.next()).b(paramMessageRecord);
      }
    }
  }
  
  public void b(pvb parampvb)
  {
    if (parampvb == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.isEmpty())) {
          continue;
        }
        QLog.d("KandianMergeManager", 2, "remove MsgObserver " + parampvb.getClass().getSimpleName() + ", " + parampvb);
        this.jdField_d_of_type_JavaUtilList.remove(parampvb);
      }
      finally {}
    }
  }
  
  public void b(pvc parampvc)
  {
    if ((parampvc == null) || (this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    QLog.d("KandianMergeManager", 2, "remove tabRedNumChangeObserver " + parampvc.getClass().getSimpleName() + ", " + parampvc);
    this.jdField_c_of_type_JavaUtilList.remove(parampvc);
  }
  
  public void b(pvd parampvd)
  {
    if (parampvd == null) {}
    while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    QLog.d("KandianMergeManager", 2, "remove tabRedNumChangeObserver " + parampvd.getClass().getSimpleName() + ", " + parampvd);
    this.jdField_b_of_type_JavaUtilList.remove(parampvd);
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public boolean b()
  {
    if (!bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    do
    {
      return false;
      QLog.d("KandianMergeManager", 1, "SubUnread : " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", SubStatus : " + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", mSubTitle : " + pqu.a(this.jdField_e_of_type_JavaLangString) + ", KDUnread : " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    } while ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1)) && ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3) || ((!bmhv.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (uuc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)))));
    if ((bmhv.n()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_a_of_type_JavaLangLong.longValue() <= 0L) && (TextUtils.isEmpty(this.f)))
    {
      QLog.d("KandianMergeManager", 2, "subscribe push has not article id , give up auto refresh! only for kandian tab");
      return false;
    }
    return true;
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    AbsStructMsg localAbsStructMsg;
    try
    {
      localAbsStructMsg = bdof.a();
      localAbsStructMsg.uin = paramMessageRecord.frienduin;
      localAbsStructMsg.currentAccountUin = paramMessageRecord.selfuin;
      localAbsStructMsg.mMsgBrief = paramMessageRecord.msg;
      localAbsStructMsg.mMsgActionData = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((Long)localIterator.next()).append("|");
      }
      localAbsStructMsg.mArticleIds = localStringBuilder.toString();
    }
    finally {}
    localAbsStructMsg.mAlgorithmIds = String.valueOf(this.jdField_a_of_type_Long);
    localAbsStructMsg.mStrategyIds = String.valueOf(this.jdField_b_of_type_Long);
    long l = paramMessageRecord.time;
    paramMessageRecord = PkgTools.toHexStr(localAbsStructMsg.getBytes());
    if (l > this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.25(this, paramMessageRecord, l));
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
      e();
      break;
    }
  }
  
  public int c()
  {
    int i = 0;
    if (i()) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgCnt;
    }
    return i;
  }
  
  public long c()
  {
    long l2 = -1L;
    long l1 = l2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null)
    {
      l1 = l2;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead) {
        l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mUin;
      }
    }
    return l1;
  }
  
  public KandianRedDotInfo c()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  }
  
  public void c()
  {
    if (bmhv.n()) {
      QLog.d("KandianMergeManager", 2, "cleanKandianMergeSummary : isShowKandianTab give up clean !");
    }
    int i;
    label53:
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) {
          break label281;
        }
        if (!uuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())) {
          break;
        }
        e();
        i = 1;
        localObject1 = uqx.a();
        if (localObject1 != null) {
          ((uqx)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      } while (i == 0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
      if (localObject1 == null) {
        break label286;
      }
    } while ((((MessageRecord)localObject1).extInt == 1) || (((MessageRecord)localObject1).extInt == 3));
    long l = ((MessageRecord)localObject1).time;
    label123:
    Object localObject1 = a();
    if (localObject1 == null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131694994);
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131694994);
      }
      localObject1 = a((String)localObject2, String.valueOf(l), 0);
      prp.a((MessageRecord)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("KandianMergeManager", 2, "cleanKandianMergeSummary : last msg is interested account,replace by kandian. " + ((MessageRecord)localObject1).msg);
      return;
      if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        e();
        i = 0;
        break label53;
      }
      c(3);
      label281:
      i = 0;
      break label53;
      label286:
      l = NetConnInfoCenter.getServerTime();
      break label123;
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
    //   8: getfield 162	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   11: invokevirtual 1394	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   14: iconst_2
    //   15: if_icmpne +10 -> 25
    //   18: aload_0
    //   19: invokevirtual 1817	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:e	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 156	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   29: iconst_0
    //   30: invokevirtual 1371	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   33: aload_0
    //   34: getfield 162	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   37: iload_1
    //   38: invokevirtual 1371	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   41: invokestatic 726	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   44: new 2212	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager$23
    //   47: dup
    //   48: aload_0
    //   49: iload_1
    //   50: invokespecial 2213	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager$23:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager;I)V
    //   53: invokevirtual 734	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
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
      qia localqia = pvj.a().a();
      if (localqia != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
        i = j;
        if (paramBoolean) {
          i = 2;
        }
        localqia.a(str, i);
      }
      return;
    }
  }
  
  public boolean c()
  {
    return !pkh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    int i = 0;
    for (;;)
    {
      Object localObject1;
      long l;
      Object localObject2;
      try
      {
        if (a("updateKandianPush2SP"))
        {
          a(a(paramMessageRecord));
          bool = false;
          return bool;
        }
        if (ReadInJoyLockScreenJumpDelegate.a(paramMessageRecord))
        {
          if (pkh.a(paramMessageRecord)) {
            this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_red_pnt_lock_screen");
          }
          QLog.i("KandianMergeManager", 1, "updateKandianPush2SP: block lock screen red dot.");
          bool = true;
          continue;
        }
        if (!(paramMessageRecord instanceof MessageForStructing)) {
          break label670;
        }
        localObject1 = (MessageForStructing)paramMessageRecord;
        ((MessageForStructing)localObject1).parse();
        if (((MessageForStructing)localObject1).structingMsg == null)
        {
          if (!QLog.isColorLevel()) {
            break label676;
          }
          QLog.d("KandianMergeManager", 2, "kandian push msg : struct msg body is null");
          break label676;
        }
        localObject1 = PkgTools.toHexStr(((MessageForStructing)paramMessageRecord).structingMsg.getBytes());
        l = paramMessageRecord.time;
        if (paramMessageRecord.time < this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get()) {
          break label670;
        }
        if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds))
        {
          localObject2 = ((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds.split("\\|");
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          int j = localObject2.length;
          if (i < j) {
            try
            {
              if (TextUtils.isEmpty(localObject2[i])) {
                break label682;
              }
              BigInteger localBigInteger = new BigInteger(localObject2[i]);
              this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(localBigInteger.longValue()));
            }
            catch (NumberFormatException localNumberFormatException)
            {
              QLog.e("KandianMergeManager", 1, "parse kandian push articleID has num format error : " + localNumberFormatException);
            }
          }
        }
        this.jdField_a_of_type_JavaLangString = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgActionData;
      }
      finally {}
      if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds)) {
        this.jdField_a_of_type_Long = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds.split("\\|")[0]);
      }
      if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds)) {
        this.jdField_b_of_type_Long = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds.split("\\|")[0]);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramMessageRecord.time);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      if ((pkh.a(paramMessageRecord)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_red_pnt_lock_screen");
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.saveToDiskAsync(true);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.hasArticleID())
          {
            localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.articleIDList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Long localLong = (Long)((Iterator)localObject2).next();
              this.jdField_a_of_type_JavaUtilMap.put(localLong, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.extInfo);
            }
          }
        }
      }
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_red_pnt_lock_screen");
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.26(this, (String)localObject1, l));
      if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2)) {
        c(2);
      }
      for (;;)
      {
        f();
        QLog.d("KandianMergeManager", 1, "kandian push, ids: " + this.jdField_a_of_type_JavaUtilArrayList + ", msgUid : " + paramMessageRecord.msgUid + ", isLockScreenMsg : " + pkh.a(paramMessageRecord) + ", pushContent : " + this.jdField_a_of_type_JavaLangString);
        bool = true;
        break;
        if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)) {
          e();
        }
      }
      label670:
      boolean bool = false;
      continue;
      label676:
      bool = false;
      continue;
      label682:
      i += 1;
    }
  }
  
  public int d()
  {
    return pvj.a().a();
  }
  
  public void d()
  {
    prp.b();
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if ((localMessageRecord != null) && (!localMessageRecord.isread))
    {
      localMessageRecord.isread = true;
      ThreadManager.post(new KandianMergeManager.20(this, localMessageRecord), 10, null, false);
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
      pvj.a().o();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    bbbq localbbbq = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (paramBoolean)
    {
      localAppInfo = localbbbq.b(7, "1130");
      if (localAppInfo != null) {
        localbbbq.a(localAppInfo, "");
      }
    }
    for (;;)
    {
      QLog.d("KandianMergeManager", 1, "reportRedPntClick, isNumRedPnt : " + paramBoolean);
      return;
      localAppInfo = localbbbq.a("1130");
      if (localAppInfo != null) {
        localbbbq.a(localAppInfo, "");
      }
    }
  }
  
  public boolean d()
  {
    return false;
  }
  
  public int e()
  {
    int i = 0;
    if (i()) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgCnt;
    }
    return i;
  }
  
  public void e()
  {
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      this.jdField_d_of_type_JavaLangString = "";
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.24(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e(int paramInt)
  {
    SharedPreferences.Editor localEditor = bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false).edit();
    localEditor.remove("kandian_myself_red_point" + paramInt);
    bmhv.a(localEditor, true);
  }
  
  public boolean e()
  {
    return false;
  }
  
  public int f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgCnt;
    }
    return 0;
  }
  
  public void f()
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
  
  public boolean f()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if ((localMessageRecord == null) || (localMessageRecord.isread)) {}
    while (localMessageRecord.vipBubbleID != -1000L) {
      return false;
    }
    return true;
  }
  
  public void g()
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
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.removeFromDiskAsync(true);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = null;
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.27(this));
      return;
    }
    finally {}
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null;
  }
  
  public void h()
  {
    prp.b();
    acmw localacmw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getConversationFacade();
    String str;
    if (bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      str = AppConstants.KANDIAN_MERGE_UIN;
    }
    for (int i = 7220;; i = 1008)
    {
      if ((localacmw != null) && (localacmw.a(str, i) > 0)) {
        ThreadManager.post(new KandianMergeManager.28(this, str, i), 8, null, false);
      }
      return;
      str = AppConstants.NEW_KANDIAN_UIN;
    }
  }
  
  public boolean h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("SplashActivity");
    if ((BaseActivity.sTopActivity != null) && ((pkh.a() instanceof QQAppInterface)) && (!FrameHelperActivity.i))
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
          if (((SplashActivity)localBaseActivity).a() == MainFragment.h) {
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
  
  public void i()
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), oln.class);
    localNewIntent.putExtra("cmd", "get_message_configuration");
    mobileqq_mp.GetMessageConfigurationRequest localGetMessageConfigurationRequest = new mobileqq_mp.GetMessageConfigurationRequest();
    localGetMessageConfigurationRequest.uin.set(2171946401L);
    localGetMessageConfigurationRequest.versionInfo.set(uuc.a());
    localNewIntent.putExtra("data", localGetMessageConfigurationRequest.toByteArray());
    localNewIntent.setObserver(new puv(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean i()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo != null) {
      ThreadManager.executeOnSubThread(new KandianMergeManager.30(this));
    }
  }
  
  /* Error */
  public boolean j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: invokeinterface 966 1 0
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +9 -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	KandianMergeManager
    //   11	13	1	bool	boolean
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	27	finally
  }
  
  public void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
    aoxz localaoxz;
    RecentUser localRecentUser;
    if ((localObject != null) && (!((MessageRecord)localObject).isread))
    {
      localaoxz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      localRecentUser = (RecentUser)localaoxz.findRecentUser(AppConstants.KANDIAN_MERGE_UIN, 7220);
      if (localRecentUser != null) {}
    }
    else
    {
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    localRecentUser.lastmsgtime = l;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgFieldByUniseq(AppConstants.KANDIAN_MERGE_UIN, 7220, ((MessageRecord)localObject).uniseq, "time", Long.valueOf(l));
    localaoxz.saveRecentUser(localRecentUser);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1009);
    }
    QLog.d("KandianMergeManager", 1, "stickKandianConversation successful! newTime : " + l);
  }
  
  public void l()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      C();
      return;
    }
    ThreadManager.getUIHandler().post(new KandianMergeManager.33(this));
  }
  
  public void m()
  {
    ThreadManager.getUIHandler().post(new KandianMergeManager.34(this));
  }
  
  public void n()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.removeFromDiskAsync(true);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = null;
    m();
  }
  
  public void o()
  {
    ThreadManager.executeOnSubThread(new KandianMergeManager.35(this));
  }
  
  public void onDestroy()
  {
    bmhv.b();
    E();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayqy);
    }
    bmie.a().a(null);
    TaskManager.getInstance().stopAllTasks();
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    if (this.jdField_d_of_type_JavaUtilList != null) {
      this.jdField_d_of_type_JavaUtilList.clear();
    }
    uwl.b();
    pkt.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigAladdinListener);
    v();
    x();
    pis.a.a();
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.canDoAnimation = true;
    }
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.asyncWriteToSP();
      l();
      QLog.d("KandianMergeManager", 1, "clear msg box redPnt info, " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
    }
  }
  
  public void r()
  {
    try
    {
      boolean bool = b();
      QLog.d("KandianMergeManager", 1, new Object[] { "switch to sub channel, clear kandian red point, hasRedPoint = ", Boolean.valueOf(bool) });
      if (bool)
      {
        F();
        g();
        f();
        l();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager
 * JD-Core Version:    0.7.0.1
 */