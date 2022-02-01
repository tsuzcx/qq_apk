package com.tencent.biz.pubaccount.readinjoy.engine;

import adab;
import adak;
import adan;
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
import antf;
import anyu;
import anzj;
import apaw;
import apcf;
import ayxl;
import bbav;
import bcry;
import bdow;
import bhvd;
import bnrf;
import bnro;
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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
import ocd;
import ocj;
import ohp;
import oml;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import oxz;
import oyh;
import ozm;
import ozq;
import ozs;
import paa;
import pam;
import pas;
import pbd;
import pdl;
import pei;
import pej;
import pek;
import pel;
import pem;
import pen;
import peo;
import pep;
import peq;
import per;
import pes;
import pet;
import peu;
import pfa;
import pfd;
import pfg;
import pfs;
import phb;
import pra;
import qhq;
import qid;
import qie;
import qvm;
import qwh;
import qwi;
import sna;
import sup;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.BiuBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.NotifyBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.StyleSheet;
import tug;
import twk;
import tzq;
import ubn;
import uby;

public class KandianMergeManager
  implements Manager
{
  public static String b;
  public int a;
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new pep(this);
  private anyu jdField_a_of_type_Anyu = new pem(this);
  private ayxl jdField_a_of_type_Ayxl = new pej(this);
  AladdinListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigAladdinListener = new KandianMergeManager.9(this);
  private KandianMergeManager.KandianSetTopInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo;
  private volatile Kandian210Msg0xeeInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo;
  private KandianMsgBoxRedPntInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo;
  private KandianRedDotInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MiniAppNotify.IMiniAppNotifyListener jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener = new peo(this);
  private Long jdField_a_of_type_JavaLangLong;
  public String a;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<peq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Long, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
  per jdField_a_of_type_Per = new per();
  private qwh jdField_a_of_type_Qwh;
  private qwi jdField_a_of_type_Qwi;
  private sup jdField_a_of_type_Sup = new sup();
  private ubn jdField_a_of_type_Ubn;
  public boolean a;
  private int jdField_b_of_type_Int;
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new pei(this);
  private KandianRedDotInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  private List<peu> jdField_b_of_type_JavaUtilList;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicLong jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong;
  private qwh jdField_b_of_type_Qwh;
  private KandianRedDotInfo jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  private String jdField_c_of_type_JavaLangString;
  private List<pet> jdField_c_of_type_JavaUtilList;
  private AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private qwh jdField_c_of_type_Qwh;
  private String jdField_d_of_type_JavaLangString;
  private List<pes> jdField_d_of_type_JavaUtilList;
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
    v();
    x();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    ozm.a();
    pas.a();
    A();
    pdl.a();
    pfs.g();
    if (Aladdin.getConfig(258).getIntegerFromString("load_resources_after_login", 1) == 0)
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        break label375;
      }
      t();
    }
    for (;;)
    {
      QLog.d("KandianMergeManager", 1, "do method[someInitInSubThread] in manager init ");
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
      ThreadManager.executeOnSubThread(new KandianMergeManager.2(this));
      bnro.a().a(this.jdField_a_of_type_Per);
      pam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigAladdinListener);
      oxz.a();
      uby.a();
      qvm.a();
      oml.a();
      paramQQAppInterface.registObserver(this.jdField_a_of_type_Ayxl);
      u();
      phb.i();
      return;
      label375:
      ThreadManager.executeOnSubThread(new KandianMergeManager.1(this));
    }
  }
  
  private void A()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.h = localSharedPreferences.getString("kandian_red_touch_pnt_article_id", "");
    QLog.d("KandianMergeManager", 1, "initCache mLastRedTouchInfoArticleId : " + this.h);
    Object localObject = localSharedPreferences.getString("kandian_push_msg_xml", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = bdow.a(bhvd.a((String)localObject));
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
    this.jdField_a_of_type_Qwi = qwi.a();
    this.jdField_a_of_type_Qwh = qwh.b();
    this.jdField_b_of_type_Qwh = qwh.c();
    this.jdField_c_of_type_Qwh = qwh.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo = KandianMsgBoxRedPntInfo.getRedPntInfoFromSp();
    QLog.d("KandianMergeManager", 1, "init msgbox info from sp. " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo = Kandian210Msg0xeeInfo.getKandian210Msg0xeeInfoFromSp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QLog.d("KandianAppInPush", 2, "init app push info from cache : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo);
    if (this.jdField_b_of_type_Qwh != null)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_b_of_type_Qwh.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Qwh.jdField_b_of_type_JavaLangString)) {
        this.jdField_e_of_type_JavaLangString = this.jdField_b_of_type_Qwh.jdField_b_of_type_JavaLangString;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo = ((KandianMergeManager.KandianSetTopInfo)ozs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_msgtab_settop", true));
    QLog.d("KandianMergeManager.SETTOP", 2, "get from cache : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo);
    B();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.getRedDotFromDisk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_video_tab_reddot_info", true);
    QLog.d("KandianMergeManager", 1, "init mianVideoTabRed : " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.getRedDotFromDisk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "kandian_red_pnt_lock_screen", true);
    QLog.d("KandianMergeManager", 2, "lock screen push info : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo);
    ThreadManager.executeOnSubThread(new KandianMergeManager.11(this));
  }
  
  private void B()
  {
    ThreadManager.post(new KandianMergeManager.13(this), 8, null, false);
  }
  
  private void C()
  {
    boolean bool2 = false;
    Object localObject1 = null;
    Object localObject2;
    if (this.jdField_a_of_type_Qwh.jdField_e_of_type_Int == 1)
    {
      localObject1 = this.jdField_a_of_type_Qwh.jdField_b_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_Qwh.jdField_a_of_type_JavaLangString;
      long l = this.jdField_a_of_type_Qwh.jdField_d_of_type_Long;
      if (this.jdField_a_of_type_Qwh.g == 0)
      {
        bool1 = true;
        localObject1 = a((String)localObject1, (String)localObject2, l, bool1, true, String.valueOf(this.jdField_a_of_type_Qwh.jdField_e_of_type_Long));
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_a_of_type_Qwh.jdField_a_of_type_Long);
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Qwh.jdField_b_of_type_JavaLangString;
        a((MessageRecord)localObject1, true);
        this.jdField_b_of_type_Qwh = this.jdField_a_of_type_Qwh;
        this.jdField_b_of_type_Qwh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("has 0x210 follow msg push , brief : ").append(this.jdField_a_of_type_Qwh.jdField_b_of_type_JavaLangString).append(", showInFolder : ");
      if (this.jdField_a_of_type_Qwh.jdField_e_of_type_Int != 1) {
        break label322;
      }
    }
    label322:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = ((StringBuilder)localObject2).append(bool1).append(", showLockScreen : ");
      bool1 = bool2;
      if (this.jdField_a_of_type_Qwh.f == 1) {
        bool1 = true;
      }
      QLog.d("KandianMergeManager", 1, bool1 + ", redType : " + this.jdField_a_of_type_Qwh.g + ", msgSeq : " + this.jdField_a_of_type_Qwh.jdField_b_of_type_Long + ", orangeWord : " + this.jdField_a_of_type_Qwh.jdField_a_of_type_JavaLangString + ", msgCount : " + this.jdField_a_of_type_Qwh.jdField_a_of_type_Int);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("BID_TYPE", 2);
      a((MessageRecord)localObject1, qwh.l, (Bundle)localObject2);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void D()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((peu)localIterator.next()).ar_();
      }
    }
  }
  
  private void E()
  {
    try
    {
      this.jdField_a_of_type_Ubn = new ubn(BaseApplicationImpl.getContext(), 0, 0);
      this.jdField_a_of_type_Ubn.a(new pen(this));
      return;
    }
    catch (SecurityException localSecurityException)
    {
      QLog.e("KandianMergeManager", 1, localSecurityException, new Object[0]);
    }
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_Ubn != null)
    {
      this.jdField_a_of_type_Ubn.a();
      this.jdField_a_of_type_Ubn = null;
    }
  }
  
  private void G()
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
      } while (((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.frienduin, antf.aA)));
      if ((paramMessageRecord.extInt == 1) && (TextUtils.equals(paramMessageRecord.frienduin, antf.aA))) {
        return 0;
      }
      if ((paramMessageRecord.extInt == 2) && (TextUtils.equals(paramMessageRecord.frienduin, antf.aA))) {
        return 1;
      }
      if (TextUtils.equals(paramMessageRecord.frienduin, antf.az)) {
        return 0;
      }
    } while ((paramMessageRecord.istroop != 1008) || (!tug.d(paramQQAppInterface, paramMessageRecord.frienduin)));
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
    MessageRecord localMessageRecord = bcry.a(-1000);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.msgtype = -1000;
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, long paramLong, String paramString2)
  {
    MessageRecord localMessageRecord = bcry.a(-1000);
    localMessageRecord.frienduin = antf.Q;
    localMessageRecord.senderuin = antf.Q;
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
    MessageRecord localMessageRecord = bcry.a(-1000);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    MessageRecord localMessageRecord = bcry.a(-1000);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    localMessageRecord.frienduin = antf.aA;
    localMessageRecord.senderuin = antf.az;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 6;
    if (bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
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
          ozs.a(localMessageRecord);
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
    MessageRecord localMessageRecord = bcry.a(-1000);
    boolean bool = bnrf.m();
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    localMessageRecord.frienduin = antf.aA;
    localMessageRecord.senderuin = antf.az;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 5;
    if (bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        localMessageRecord.extInt = 2;
        bool = bnrf.c(paramString3);
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
          if (sna.a().a(2000002)) {
            break label387;
          }
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          ozs.a(localMessageRecord);
          paramString1.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
      MessageForStructing localMessageForStructing = (MessageForStructing)bcry.a(-2011);
      localMessageForStructing.msgtype = -2011;
      localMessageForStructing.structingMsg = bdow.a();
      localMessageForStructing.structingMsg.mMsgServiceID = 142;
      localMessageForStructing.structingMsg.mMsgBrief = str2;
      localMessageForStructing.structingMsg.mOrangeWord = str1;
      localMessageForStructing.structingMsg.mArticleIds = str3;
      localMessageForStructing.structingMsg.mStrategyIds = str5;
      localMessageForStructing.structingMsg.mAlgorithmIds = str4;
      localMessageForStructing.structingMsg.reportEventFolderStatusValue = paramNamedNodeMap;
      localMessageForStructing.structingMsg.mMsgActionData = str6;
      localMessageForStructing.extInt = 1;
      localMessageForStructing.frienduin = antf.aA;
      localMessageForStructing.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localMessageForStructing.senderuin = antf.az;
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
      String str = new paa().c(paramLong).a();
      ocd.a(null, "", "0X8009A8A", "0X8009A8A", 0, 0, "", "", "", str, false);
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
        ((pes)localIterator.next()).a(paramMessageRecord, paramInt, paramBundle);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = antf.aA;
    paramMessageRecord.senderuin = antf.aA;
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
  
  private void a(qwh paramqwh, long paramLong)
  {
    boolean bool = false;
    qwh localqwh = this.jdField_c_of_type_Qwh;
    if (localqwh != null)
    {
      if (localqwh != null) {
        QLog.d("KandianMergeManager", 1, "0x210Msg reached, oldSeq = " + localqwh.jdField_b_of_type_Long + ", newSeq = " + paramqwh.jdField_b_of_type_Long);
      }
      if (localqwh.jdField_b_of_type_Long >= paramqwh.jdField_b_of_type_Long)
      {
        if (localqwh.jdField_b_of_type_Long != paramqwh.jdField_b_of_type_Long) {
          bool = true;
        }
        if (bool) {
          localqwh.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "0x210msg delay reach , has a latest msg , no cover! needAddCount : " + bool);
        }
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_c_of_type_Qwh != null) {
        paramqwh.jdField_a_of_type_Int += this.jdField_c_of_type_Qwh.jdField_a_of_type_Int;
      }
      this.jdField_c_of_type_Qwh = paramqwh;
      this.jdField_c_of_type_Qwh.jdField_d_of_type_Long = paramLong;
      this.jdField_c_of_type_Qwh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i = 0;
      while (i < paramqwh.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a((MySelfNormalItemRedPointInfo)paramqwh.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if ((ReadinjoyTabFrame.d_()) && (!ohp.b())) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("KandianMergeManager", 1, new Object[] { "isNeedToBlockPushRedPoint, ret = ", Boolean.valueOf(bool), ", tag = ", paramString });
      return bool;
    }
  }
  
  private MessageRecord c()
  {
    Object localObject1 = null;
    bbav localbbav = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localbbav == null)
    {
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | RedTouchManager is null ");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = localbbav.a("1130");
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject2 = localbbav.b(7, "1130");
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
              Object localObject6 = localbbav.a(1130);
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
                  localbbav.a((long[])localObject6, "kandian_num_red_pnt_buffer", new pek(this));
                  QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | numRedPoint num: " + (String)localObject5 + ", extraNum : " + localbbav.a(1130) + ", lastMsgID : " + localObject6[(localObject6.length - 1)]);
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
                          break label991;
                        }
                        localObject2 = ((Node)localObject2).getAttributes();
                        if (localObject2 == null) {
                          break label991;
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
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
                            localObject3 = localObject1;
                            break;
                          }
                          QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify end !");
                          return localObject1;
                        }
                        catch (Exception localException2) {}
                      }
                      label991:
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
    if (this.jdField_d_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((pes)localIterator.next()).a(paramMessageRecord);
      }
    }
  }
  
  private void t()
  {
    Object localObject = (pfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
    ((pfg)localObject).a().b(0, 20, 9223372036854775807L, true);
    ((pfg)localObject).a().b(56, 20, 9223372036854775807L, true);
    ((pfg)localObject).a().b(70, 20, 9223372036854775807L, true);
    ((pfg)localObject).a().b(pbd.b(), 20, 9223372036854775807L, true);
    ((pfg)localObject).a().c(0);
    ((pfg)localObject).a().m();
    ((pfg)localObject).a().r();
    ((pfg)localObject).a().b();
    E();
    localObject = oyh.a.a();
    oyh.a.a((List)localObject);
    QLog.d("KandianMergeManager", 1, "preload pts card, rules : " + localObject);
  }
  
  private void u()
  {
    ThreadManager.getFileThreadHandler().post(new KandianMergeManager.4(this));
  }
  
  private void v()
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.5(this));
  }
  
  private void w()
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.6(this));
  }
  
  private void x()
  {
    MiniAppNotify.g.register(this.jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener);
  }
  
  private void y()
  {
    MiniAppNotify.g.remove(this.jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener);
  }
  
  private void z()
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
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (!bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
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
    if (this.jdField_a_of_type_Qwh != null) {
      return this.jdField_a_of_type_Qwh.c;
    }
    return 0L;
  }
  
  public Pair<Object, String> a()
  {
    if ((!bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3)) || ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2))) {}
    do
    {
      return null;
      c(2);
      QLog.d("KandianMergeManager", 1, "mSubscribePushMsgTitle : " + ozs.d(this.jdField_e_of_type_JavaLangString) + " mSubscribePushMsgArticleID : " + this.jdField_a_of_type_JavaLangLong + " mInnerUniqId : " + this.f + " seedUIN :  " + this.jdField_d_of_type_JavaLangString + ", isInterestedAccount : " + tzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    } while ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || ((TextUtils.isEmpty(this.f)) && (this.jdField_a_of_type_JavaLangLong.longValue() == -1L)));
    if ((bnrf.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!TextUtils.isEmpty(this.f))) {
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
    Object localObject1 = bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true).getString("kandian_myself_red_point" + paramInt, "");
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(antf.aA, 7220);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4)) {}
        while ((!localMessageRecord.isValid) || (adak.h(localMessageRecord.msgtype)))
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(antf.aA, 7220, "extInt=1 OR extInt=3");
      }
      return localObject;
      localMessageRecord = null;
    }
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      localObject1 = null;
      return localObject1;
    }
    if ((a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) && (ozs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      return null;
    }
    if (sna.a().a(2000002))
    {
      QLog.d("KandianMergeManager", 2, "app in push is showing, abandon the new msg !");
      return null;
    }
    if ((ozs.a(paramMessageRecord)) && (ozs.c(paramMessageRecord)))
    {
      QLog.d("KandianMergeManager", 1, "receive daily lock screen red point push ! mr : " + paramMessageRecord);
      ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(296)).a(paramMessageRecord);
      return null;
    }
    if (!a(paramMessageRecord)) {
      return null;
    }
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localQQMessageFacade != null) {}
    label559:
    label595:
    label610:
    Object localObject2;
    label680:
    label958:
    for (Object localObject1 = localQQMessageFacade.b(antf.aA, 7220);; localObject2 = null)
    {
      Object localObject4;
      Object localObject3;
      if ((localObject1 != null) && (a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) && (((MessageRecord)localObject1).extInt == 2) && (!((MessageRecord)localObject1).isread)) {
        if (QLog.isColorLevel())
        {
          localObject4 = "lastMr_info 【" + "msg: " + ozs.d(((MessageRecord)localObject1).msg) + ", msguid : " + ((MessageRecord)localObject1).msgUid;
          localObject3 = localObject4;
          if ((localObject1 instanceof MessageForStructing))
          {
            localMessageForStructing = (MessageForStructing)localObject1;
            localMessageForStructing.parse();
            localObject3 = localObject4;
            if (localMessageForStructing.structingMsg != null) {
              localObject3 = (String)localObject4 + ", title : " + ozs.d(localMessageForStructing.structingMsg.mMsgBrief) + " 】";
            }
          }
          localObject4 = "newMr_info 【" + "msg: " + ozs.d(paramMessageRecord.msg) + ", senderUin : " + paramMessageRecord.senderuin + " , msguid : " + paramMessageRecord.msgUid;
          if (!(paramMessageRecord instanceof MessageForStructing)) {
            break label990;
          }
          MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
          localMessageForStructing.parse();
          if (localMessageForStructing.structingMsg == null) {
            break label990;
          }
          localObject4 = (String)localObject4 + ", title : " + ozs.d(localMessageForStructing.structingMsg.mMsgBrief) + " 】";
        }
      }
      int i;
      label833:
      label985:
      label990:
      for (;;)
      {
        QLog.i("KandianMergeManager", 2, "subscribe push msg cover ! \n" + (String)localObject3 + "\n" + (String)localObject4);
        localQQMessageFacade.a((MessageRecord)localObject1, false);
        localObject4 = bcry.a(paramMessageRecord.msgtype);
        MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject4, paramMessageRecord);
        ((MessageRecord)localObject4).frienduin = antf.aA;
        ((MessageRecord)localObject4).istroop = 7220;
        i = a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (i == 0)
        {
          ((MessageRecord)localObject4).extInt = 1;
          a((MessageRecord)localObject4, 0);
          if (!bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label900;
          }
          ((MessageRecord)localObject4).extLong |= 0x20000000;
          ((MessageRecord)localObject4).extLong |= 0x1;
          if (!f()) {
            break label915;
          }
          ((MessageRecord)localObject4).vipBubbleID = -1000L;
        }
        try
        {
          if (!(localObject4 instanceof MessageForStructing)) {
            break label833;
          }
          localObject1 = (MessageForStructing)localObject4;
          ((MessageForStructing)localObject1).parse();
          if (((MessageForStructing)localObject1).structingMsg == null) {
            break label833;
          }
          localObject1 = new JSONObject(((MessageForStructing)localObject1).structingMsg.mMsgActionData);
          if (!((JSONObject)localObject1).has("showMergedAvatar")) {
            break label985;
          }
          if (((JSONObject)localObject1).getInt("showMergedAvatar") != 1) {
            break label926;
          }
          bool = true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            boolean bool;
            localException.printStackTrace();
            continue;
            if (i == 1)
            {
              b((MessageRecord)localObject4);
              l();
              continue;
              localObject2 = null;
              continue;
              continue;
              bool = false;
            }
          }
        }
        if (((JSONObject)localObject1).has("uin")) {
          this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).getString("uin");
        }
        if (((JSONObject)localObject1).has("biuUin"))
        {
          this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).getString("biuUin");
          bool = bnrf.l();
          if (((JSONObject)localObject1).has("defaultAvatarUrl"))
          {
            localObject1 = ((JSONObject)localObject1).getString("defaultAvatarUrl");
            if (TextUtils.isEmpty(((MessageRecord)localObject4).extStr)) {}
            for (localObject3 = new JSONObject();; localObject3 = new JSONObject(((MessageRecord)localObject4).extStr))
            {
              if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
                ((JSONObject)localObject3).put("kdUin", this.jdField_c_of_type_JavaLangString);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                ((JSONObject)localObject3).put("kdDefaultSourceAvatarUrl", localObject1);
              }
              ((JSONObject)localObject3).put("kdShouldShowMergedAvatar", bool);
              ((MessageRecord)localObject4).extStr = ((JSONObject)localObject3).toString();
              if (i != 0) {
                break label958;
              }
              c((MessageRecord)localObject4);
              ozs.a((MessageRecord)localObject4);
              localObject1 = localObject4;
              if (!ozs.a(paramMessageRecord)) {
                break;
              }
              ThreadManager.post(new KandianMergeManager.19(this), 8, null, false);
              return localObject4;
              if (i == 1)
              {
                ((MessageRecord)localObject4).extInt = 2;
                break label559;
              }
              ((MessageRecord)localObject4).extInt = 0;
              break label559;
              ((MessageRecord)localObject4).extLong |= 0x2;
              break label595;
              ((MessageRecord)localObject4).vipBubbleID = -999L;
              break label610;
              bool = false;
              break label680;
            }
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
    MessageForStructing localMessageForStructing = (MessageForStructing)bcry.a(-2011);
    localMessageForStructing.istroop = 7220;
    localMessageForStructing.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    localMessageForStructing.frienduin = antf.aA;
    localMessageForStructing.senderuin = antf.az;
    localMessageForStructing.time = ozs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localMessageForStructing.isread = false;
    localMessageForStructing.issend = 0;
    localMessageForStructing.extInt = 1;
    localMessageForStructing.extLong |= 0x20000000;
    localMessageForStructing.extLong |= 0x1;
    localMessageForStructing.structingMsg = bdow.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing.istroop, Long.valueOf(localMessageForStructing.senderuin).longValue(), paramString.getBytes(), 0);
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
    ozs.a(localMessageForStructing);
    paramString.a(localMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    return localMessageForStructing;
  }
  
  public MessageRecord a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    Object localObject = new qie();
    paramArrayOfByte = ((qie)localObject).a(new String(paramArrayOfByte));
    JSONObject localJSONObject = ((qie)localObject).a(new String(paramArrayOfByte.jdField_a_of_type_ArrayOfByte));
    localObject = ((qie)localObject).a(new String(paramArrayOfByte.jdField_a_of_type_ArrayOfByte), paramString);
    paramString = (MessageForStructing)bcry.a(-2011);
    paramString.msgtype = -2011;
    paramString.structingMsg = bdow.a();
    paramString.structingMsg.mMsgServiceID = 142;
    paramString.structingMsg.mArticleIds = paramArrayOfByte.jdField_a_of_type_JavaLangString;
    paramString.structingMsg.mStrategyIds = paramArrayOfByte.jdField_d_of_type_JavaLangString;
    paramString.structingMsg.mAlgorithmIds = paramArrayOfByte.jdField_c_of_type_JavaLangString;
    paramString.structingMsg.reportEventFolderStatusValue = paramArrayOfByte.jdField_b_of_type_JavaLangString;
    paramString.structingMsg.mMsgActionData = localJSONObject.toString();
    paramString.structingMsg.mExtraData = new String(paramArrayOfByte.jdField_a_of_type_ArrayOfByte);
    paramString.structingMsg.mMsgBrief = ((JSONObject)localObject).optString("brief", "");
    paramString.structingMsg.mOrangeWord = ((JSONObject)localObject).optString("orangeWord", "");
    paramString.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    paramString.frienduin = antf.aA;
    paramString.senderuin = antf.az;
    paramString.istroop = 7220;
    paramString.extInt = 1;
    paramString.time = NetConnInfoCenter.getServerTime();
    paramString.isread = false;
    paramString.issend = 0;
    if (bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      paramString.extLong |= 0x20000000;
    }
    for (paramString.extLong |= 0x1;; paramString.extLong |= 0x2)
    {
      QLog.d("KandianMergeManager", 1, "createFakeMsgFrom0x135XmlBuffer fakeMr.structingMsg: " + paramString.structingMsg);
      paramString.msg = paramString.structingMsg.mMsgBrief;
      paramString.msgData = paramString.structingMsg.getBytes();
      a(paramString, 0);
      if (!ozs.c(paramString)) {
        break;
      }
      QLog.d("KandianMergeManager", 1, "createFakeMsgFrom0x135XmlBuffer receive daily push ! mr : " + paramString);
      ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(296)).a(paramString);
      return paramString;
    }
    c(paramString);
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ozs.a(paramString);
    paramArrayOfByte.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
    if (!bnrf.i()) {
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
    if (!bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
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
    qhq.a();
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
    ozs.a("kandian_msgtab_settop", localKandianSetTopInfo, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo = localKandianSetTopInfo;
    QLog.d("KandianMergeManager.SETTOP", 2, "update kandian push msg setTop info : " + localKandianSetTopInfo);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.g = paramString;
    if (!this.g.isEmpty()) {
      pfa.a().b(paramInt, this.g);
    }
  }
  
  public void a(apcf paramapcf)
  {
    a(paramapcf);
    a(paramapcf);
    a(paramapcf);
    pfd.a().a(paramapcf);
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
      a(paramKandianMsgBoxRedPntInfo, qwh.k, null);
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
        MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(antf.aA, 7220);
        if ((localMessageRecord != null) && (localMessageRecord.extInt == 2) && (TextUtils.equals(localMessageRecord.senderuin, paramString)))
        {
          paramString = a();
          if (paramString != null)
          {
            ozs.a(paramString);
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
    ThreadManager.post(new KandianMergeManager.14(this, localQQMessageFacade, paramString1, paramString2, paramInt, paramBoolean), 10, null, false);
  }
  
  public void a(peq parampeq)
  {
    if (parampeq == null) {}
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_JavaUtilList.add(parampeq);
      }
      finally {}
    }
  }
  
  public void a(pes parampes)
  {
    if (parampes == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_d_of_type_JavaUtilList == null) {
          this.jdField_d_of_type_JavaUtilList = new ArrayList();
        }
        QLog.d("KandianMergeManager", 2, "add MsgObserver " + parampes.getClass().getSimpleName() + ", " + parampes);
        if (this.jdField_d_of_type_JavaUtilList.contains(parampes)) {
          continue;
        }
        this.jdField_d_of_type_JavaUtilList.add(parampes);
      }
      finally {}
    }
  }
  
  public void a(pet parampet)
  {
    if (parampet == null) {}
    do
    {
      return;
      if (this.jdField_c_of_type_JavaUtilList == null) {
        this.jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
      }
      QLog.d("KandianMergeManager", 2, "add tabRedNumChangeObserver " + parampet.getClass().getSimpleName() + ", " + parampet);
    } while (this.jdField_c_of_type_JavaUtilList.contains(parampet));
    this.jdField_c_of_type_JavaUtilList.add(parampet);
  }
  
  public void a(peu parampeu)
  {
    if (parampeu == null) {}
    do
    {
      return;
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
      }
      QLog.d("KandianMergeManager", 2, "add tabRedNumChangeObserver " + parampeu.getClass().getSimpleName() + ", " + parampeu);
    } while (this.jdField_b_of_type_JavaUtilList.contains(parampeu));
    this.jdField_b_of_type_JavaUtilList.add(parampeu);
  }
  
  public void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ozs.a(localQQAppInterface, paramBoolean);
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
    sna.a().a(false);
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
    apaw localapaw;
    RecentUser localRecentUser;
    do
    {
      return;
      i = 0;
      break;
      localapaw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = (RecentUser)localapaw.findRecentUser(antf.aA, 7220);
    } while ((localRecentUser == null) && (!paramBoolean1) && (paramBoolean2 == true));
    Object localObject = localRecentUser;
    if (localRecentUser == null)
    {
      localObject = new RecentUser(antf.aA, 7220);
      ((RecentUser)localObject).lastmsgtime = NetConnInfoCenter.getServerTime();
    }
    if (paramBoolean1) {}
    for (((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);; ((RecentUser)localObject).showUpTime = 0L)
    {
      localapaw.saveRecentUser((BaseRecentUser)localObject);
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
      long l2 = this.jdField_a_of_type_Qwi.jdField_a_of_type_Long;
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
        this.jdField_a_of_type_Qwi.jdField_a_of_type_Long = l1;
        this.jdField_a_of_type_Qwi.jdField_b_of_type_Long = l2;
        this.jdField_a_of_type_Qwi.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Qwi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        QLog.d("KandianMergeManager", 1, "has biu 0x210 msg push, seq = " + l1 + ", uin = " + l2);
        a(null, qwh.l, null);
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
    if ((localKandian210Msg0xeeInfo == null) || (sna.a().a())) {
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
      this.jdField_a_of_type_JavaLangString = ozq.a(((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).extCookie, 0);
      localObject = ((Kandian210Msg0xeeInfo.NotifyInfo)localKandian210Msg0xeeInfo.notifyInfos.get(0)).orangeWord;
      paramArrayOfByte = (byte[])localObject;
      if (localObject == null) {
        paramArrayOfByte = anzj.a(2131704815);
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
        if (!bnrf.i())
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
  
  public void a(byte[] paramArrayOfByte, long paramLong, adan paramadan)
  {
    int i = qwh.c(paramArrayOfByte);
    QLog.i("KandianMergeManager", 1, "processMsg0x210Sub0xc5, receiveMsg bidType= " + i);
    if (i == 2)
    {
      paramArrayOfByte = qwh.a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "process 0x210 follow msg fail!");
        }
      }
    }
    Object localObject;
    boolean bool1;
    label360:
    label489:
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
              paramadan = this.jdField_a_of_type_Qwh;
              if ((paramadan == null) || (paramadan.jdField_b_of_type_Long <= paramArrayOfByte.jdField_b_of_type_Long)) {
                break label597;
              }
              if (paramArrayOfByte.jdField_e_of_type_Int != 1) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("KandianMergeManager", 2, "0x210msgc5 delay reach showFolder, has a latest msg , no cover! + oldMsg.msgSeq" + paramadan.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long + "brief : " + paramArrayOfByte.jdField_b_of_type_JavaLangString);
              }
              if ((this.jdField_b_of_type_Qwh == null) || (paramArrayOfByte.jdField_b_of_type_Long > this.jdField_b_of_type_Qwh.jdField_b_of_type_Long))
              {
                if ((this.jdField_b_of_type_Qwh != null) && (QLog.isColorLevel())) {
                  QLog.d("KandianMergeManager", 2, "upDate ox210ShowInFolderFollowPushMsg.msgSeq" + this.jdField_b_of_type_Qwh.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
                }
                paramadan = paramArrayOfByte.jdField_b_of_type_JavaLangString;
                localObject = paramArrayOfByte.jdField_a_of_type_JavaLangString;
                paramLong = paramArrayOfByte.jdField_d_of_type_Long;
                if (paramArrayOfByte.g == 0)
                {
                  bool1 = true;
                  paramadan = a(paramadan, (String)localObject, paramLong, bool1, true, String.valueOf(paramArrayOfByte.jdField_e_of_type_Long));
                  a(paramadan, true);
                  this.jdField_b_of_type_Qwh = paramArrayOfByte;
                  this.jdField_b_of_type_Qwh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  if (QLog.isColorLevel())
                  {
                    paramArrayOfByte = new StringBuilder().append("has 0x210 follow msg push , brief : ").append(this.jdField_a_of_type_Qwh.jdField_b_of_type_JavaLangString).append(", showInFolder : ");
                    if (this.jdField_a_of_type_Qwh.jdField_e_of_type_Int != 1) {
                      break label483;
                    }
                    bool1 = true;
                    paramArrayOfByte = paramArrayOfByte.append(bool1).append(", showLockScreen : ");
                    if (this.jdField_a_of_type_Qwh.f != 1) {
                      break label489;
                    }
                  }
                }
                for (bool1 = true;; bool1 = false)
                {
                  QLog.d("KandianMergeManager", 1, bool1 + ", redType : " + this.jdField_a_of_type_Qwh.g + ", msgSeq : " + this.jdField_a_of_type_Qwh.jdField_b_of_type_Long + ", orangeWord : " + this.jdField_a_of_type_Qwh.jdField_a_of_type_JavaLangString + ", msgCount : " + this.jdField_a_of_type_Qwh.jdField_a_of_type_Int);
                  a(paramadan, qwh.l, null);
                  return;
                  bool1 = false;
                  break;
                  bool1 = false;
                  break label360;
                }
              }
            } while (!QLog.isColorLevel());
            QLog.d("KandianMergeManager", 2, "no upDate ox210ShowInFolderFollowPushMsg.msgSeq" + this.jdField_b_of_type_Qwh.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
            return;
          } while (!QLog.isColorLevel());
          QLog.d("KandianMergeManager", 2, "0x210msgc5 delay reach discarded,  + oldMsg.msgSeq" + paramadan.jdField_b_of_type_Long + "msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("KandianMergeManager", 2, "0x210msgc5 nomel , msg.msgSeq:" + paramArrayOfByte.jdField_b_of_type_Long);
          }
          this.jdField_a_of_type_Qwh = paramArrayOfByte;
          this.jdField_a_of_type_Qwh.jdField_d_of_type_Long = paramLong;
          this.jdField_a_of_type_Qwh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          C();
          return;
          i = qwh.a(paramArrayOfByte);
        } while (i == qwh.j);
        if (i == qwh.l)
        {
          a(paramArrayOfByte);
          return;
        }
        localObject = qwh.a(paramArrayOfByte);
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("KandianMergeManager", 2, "process 0x210 msg fail!");
      return;
      i = qwh.b(paramArrayOfByte);
    } while (i == qwh.m);
    label483:
    boolean bool2;
    label597:
    boolean bool3;
    if ((i == qwh.n) || (i == qwh.o))
    {
      pfa.a().b(0, "");
      bool2 = ozs.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bool3 = ozs.v();
      if (((!bool2) && (!bool3)) || (((qwh)localObject).f != 1) || (!((Boolean)bnrf.a("sp_msg_box_80a_enable_receive", Boolean.valueOf(true))).booleanValue())) {
        break label1019;
      }
      bool1 = true;
      label810:
      if (bool1)
      {
        paramArrayOfByte = a(((qwh)localObject).jdField_b_of_type_JavaLangString, ((qwh)localObject).jdField_d_of_type_Long, ((qwh)localObject).h);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false, false, true, false);
        paramadan.a("handleGetKandian210Message", true, 1, true, false);
        if ((ozs.m() != 1) && (ozs.k() == 2)) {
          break label1025;
        }
      }
    }
    label1025:
    for (i = 3;; i = 1)
    {
      ocd.a("0X80081DC", new paa().a("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).a("load_mode", Integer.valueOf(i)).a("push_type", Integer.valueOf(9)).a());
      QLog.i("KandianMergeManager", 1, "isAppBackground=" + bool2 + ",needNotificationForeground" + bool3 + ",showLockScreen=" + ((qwh)localObject).f + ",needShow=" + bool1);
      return;
      if (i != qwh.p) {
        break;
      }
      a((qwh)localObject, paramLong);
      break;
      label1019:
      bool1 = false;
      break label810;
    }
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
          paramMessageRecord = (pfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
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
            if (tzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramMessageRecord.msgtype))
            {
              bool = true;
              localObject1 = "";
              this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.set(l);
              this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
              this.jdField_d_of_type_JavaLangString = str;
              this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
              this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(j);
              if ((paramBoolean) || (!bnrf.j())) {
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
              localObject1 = bhvd.a(((MessageForStructing)localObject3).structingMsg.getBytes());
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
    if (this.jdField_a_of_type_Qwh != null) {
      return this.jdField_a_of_type_Qwh.jdField_d_of_type_Int;
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
      if (this.jdField_a_of_type_Qwh == null) {
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(antf.aA, 7220);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4) || (localMessageRecord.extInt == 3)) {}
        while (((localMessageRecord.extInt == 5) && (!e())) || (!localMessageRecord.isValid) || (adak.h(localMessageRecord.msgtype)))
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(antf.aA, 7220, "extInt=1");
      }
      return localObject;
      localMessageRecord = null;
    }
  }
  
  public List<peq> b()
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
    bbav localbbav = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbav.a("1130");
    if (localAppInfo != null) {
      localbbav.b(localAppInfo, "");
    }
    localAppInfo = localbbav.b(7, "1130");
    if (localAppInfo != null) {
      localbbav.b(localAppInfo, "");
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
  
  public void b(apcf paramapcf)
  {
    b(paramapcf);
    b(paramapcf);
    b(paramapcf);
    pfd.a().b(paramapcf);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (this.jdField_d_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((pes)localIterator.next()).b(paramMessageRecord);
      }
    }
  }
  
  public void b(pes parampes)
  {
    if (parampes == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.isEmpty())) {
          continue;
        }
        QLog.d("KandianMergeManager", 2, "remove MsgObserver " + parampes.getClass().getSimpleName() + ", " + parampes);
        this.jdField_d_of_type_JavaUtilList.remove(parampes);
      }
      finally {}
    }
  }
  
  public void b(pet parampet)
  {
    if ((parampet == null) || (this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    QLog.d("KandianMergeManager", 2, "remove tabRedNumChangeObserver " + parampet.getClass().getSimpleName() + ", " + parampet);
    this.jdField_c_of_type_JavaUtilList.remove(parampet);
  }
  
  public void b(peu parampeu)
  {
    if (parampeu == null) {}
    while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    QLog.d("KandianMergeManager", 2, "remove tabRedNumChangeObserver " + parampeu.getClass().getSimpleName() + ", " + parampeu);
    this.jdField_b_of_type_JavaUtilList.remove(parampeu);
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public boolean b()
  {
    if (!bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    do
    {
      return false;
      QLog.d("KandianMergeManager", 1, "SubUnread : " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", SubStatus : " + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", mSubTitle : " + ozs.d(this.jdField_e_of_type_JavaLangString) + ", KDUnread : " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    } while ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1)) && ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3) || ((!bnrf.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (tzq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)))));
    if ((bnrf.j()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 0) && (this.jdField_a_of_type_JavaLangLong.longValue() <= 0L) && (TextUtils.isEmpty(this.f)))
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
      localAbsStructMsg = bdow.a();
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
    paramMessageRecord = bhvd.a(localAbsStructMsg.getBytes());
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
    if (bnrf.j()) {
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
        if (!tzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())) {
          break;
        }
        e();
        i = 1;
        localObject1 = twk.a();
        if (localObject1 != null) {
          ((twk)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      } while (i == 0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(antf.aA, 7220);
      if (localObject1 == null) {
        break label286;
      }
    } while ((((MessageRecord)localObject1).extInt == 1) || (((MessageRecord)localObject1).extInt == 3));
    long l = ((MessageRecord)localObject1).time;
    label123:
    Object localObject1 = a();
    if (localObject1 == null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131694670);
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131694670);
      }
      localObject1 = a((String)localObject2, String.valueOf(l), 0);
      ozs.a((MessageRecord)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
    //   11: invokevirtual 392	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   14: iconst_2
    //   15: if_icmpne +10 -> 25
    //   18: aload_0
    //   19: invokevirtual 1635	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:e	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 156	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   29: iconst_0
    //   30: invokevirtual 358	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   33: aload_0
    //   34: getfield 162	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   37: iload_1
    //   38: invokevirtual 358	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   41: invokestatic 870	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   44: new 2129	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager$23
    //   47: dup
    //   48: aload_0
    //   49: iload_1
    //   50: invokespecial 2130	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager$23:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager;I)V
    //   53: invokevirtual 878	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
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
      pra localpra = pfa.a().a();
      if (localpra != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        i = j;
        if (paramBoolean) {
          i = 2;
        }
        localpra.a(str, i);
      }
      return;
    }
  }
  
  public boolean c()
  {
    return !ozs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
          if (ozs.a(paramMessageRecord)) {
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
        localObject1 = bhvd.a(((MessageForStructing)paramMessageRecord).structingMsg.getBytes());
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
      if ((ozs.a(paramMessageRecord)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
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
        QLog.d("KandianMergeManager", 1, "kandian push, ids: " + this.jdField_a_of_type_JavaUtilArrayList + ", msgUid : " + paramMessageRecord.msgUid + ", isLockScreenMsg : " + ozs.a(paramMessageRecord) + ", pushContent : " + this.jdField_a_of_type_JavaLangString);
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
    return pfa.a().a();
  }
  
  public void d()
  {
    ozs.e();
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(antf.aA, 7220);
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
      pfa.a().o();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    bbav localbbav = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (paramBoolean)
    {
      localAppInfo = localbbav.b(7, "1130");
      if (localAppInfo != null) {
        localbbav.a(localAppInfo, "");
      }
    }
    for (;;)
    {
      QLog.d("KandianMergeManager", 1, "reportRedPntClick, isNumRedPnt : " + paramBoolean);
      return;
      localAppInfo = localbbav.a("1130");
      if (localAppInfo != null) {
        localbbav.a(localAppInfo, "");
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
    SharedPreferences.Editor localEditor = bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false).edit();
    localEditor.remove("kandian_myself_red_point" + paramInt);
    bnrf.a(localEditor, true);
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
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(antf.aA, 7220);
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
    ozs.e();
    adab localadab = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    String str;
    if (bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      str = antf.aA;
    }
    for (int i = 7220;; i = 1008)
    {
      if ((localadab != null) && (localadab.a(str, i) > 0)) {
        ThreadManager.post(new KandianMergeManager.28(this, str, i), 8, null, false);
      }
      return;
      str = antf.az;
    }
  }
  
  public boolean h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("SplashActivity");
    if ((BaseActivity.sTopActivity != null) && ((ozs.a() instanceof QQAppInterface)) && (!FrameHelperActivity.i))
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ocj.class);
    localNewIntent.putExtra("cmd", "get_message_configuration");
    mobileqq_mp.GetMessageConfigurationRequest localGetMessageConfigurationRequest = new mobileqq_mp.GetMessageConfigurationRequest();
    localGetMessageConfigurationRequest.uin.set(2171946401L);
    localGetMessageConfigurationRequest.versionInfo.set(tzq.a());
    localNewIntent.putExtra("data", localGetMessageConfigurationRequest.toByteArray());
    localNewIntent.setObserver(new pel(this));
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
    //   6: invokeinterface 1056 1 0
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(antf.aA, 7220);
    apaw localapaw;
    RecentUser localRecentUser;
    if ((localObject != null) && (!((MessageRecord)localObject).isread))
    {
      localapaw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = (RecentUser)localapaw.findRecentUser(antf.aA, 7220);
      if (localRecentUser != null) {}
    }
    else
    {
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    localRecentUser.lastmsgtime = l;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(antf.aA, 7220, ((MessageRecord)localObject).uniseq, "time", Long.valueOf(l));
    localapaw.saveRecentUser(localRecentUser);
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
      D();
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
    if (a("showKandianTabRedDot")) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    l();
  }
  
  public void onDestroy()
  {
    bnrf.b();
    F();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayxl);
    }
    bnro.a().a(null);
    TaskManager.getInstance().stopAllTasks();
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    if (this.jdField_d_of_type_JavaUtilList != null) {
      this.jdField_d_of_type_JavaUtilList.clear();
    }
    uby.b();
    pam.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigAladdinListener);
    w();
    y();
  }
  
  public void p()
  {
    ThreadManager.executeOnSubThread(new KandianMergeManager.35(this));
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.canDoAnimation = true;
    }
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.asyncWriteToSP();
      l();
      QLog.d("KandianMergeManager", 1, "clear msg box redPnt info, " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
    }
  }
  
  public void s()
  {
    try
    {
      boolean bool = b();
      QLog.d("KandianMergeManager", 1, new Object[] { "switch to sub channel, clear kandian red point, hasRedPoint = ", Boolean.valueOf(bool) });
      if (bool)
      {
        G();
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