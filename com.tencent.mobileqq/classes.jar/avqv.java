import OnlinePushPack.MsgInfo;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager.3;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager.4;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager.5;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager.6;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager.7;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager.8;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.AdInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xfd.submsgtype0xfd.AdInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xfd.submsgtype0xfd.MsgBody;

public class avqv
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.tencent.mobileqq/cache/public_account_ad_download/";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "mp4", "fhd", "shd", "hd", "sd", "msd" };
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private avqy jdField_a_of_type_Avqy;
  private PAAdPreloadTask jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_UserInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<PAAdPreloadTask> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public avqv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApplication().getApplicationContext();
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      File localFile = new File(a(paramString));
      if ((localFile.exists()) && (localFile.length() > 0L)) {
        return 2;
      }
      paramString = new File(b(paramString));
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return 1;
  }
  
  private static MessageRecord a(String paramString, oeq paramoeq)
  {
    MessageRecord localMessageRecord = new MessageRecord();
    localMessageRecord.selfuin = paramString;
    localMessageRecord.frienduin = paramoeq.jdField_a_of_type_JavaLangString;
    localMessageRecord.senderuin = paramoeq.jdField_a_of_type_JavaLangString;
    localMessageRecord.msgtype = -1000;
    localMessageRecord.msg = paramoeq.f;
    localMessageRecord.time = paramoeq.jdField_c_of_type_Long;
    localMessageRecord.shmsgseq = paramoeq.jdField_a_of_type_Short;
    localMessageRecord.msgUid = paramoeq.d;
    localMessageRecord.istroop = 10005;
    localMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "1");
    return localMessageRecord;
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentUin();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(jdField_a_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      str1 = str2;
      if (localFile.exists())
      {
        str1 = str2;
        if (localFile.isDirectory()) {
          str1 = jdField_a_of_type_JavaLangString + String.valueOf(20170807) + "_" + paramString;
        }
      }
    }
    return str1;
  }
  
  private void a()
  {
    avqu.b("installTVKSdk");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo(a(), "");
    this.jdField_a_of_type_Avqy = new avqy(this, this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Avqy);
    try
    {
      TVK_SDKMgr.setOnLogListener(new avqw(this));
      TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidContentContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", a());
      if (!TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
      {
        TVK_SDKMgr.installPlugin(this.jdField_a_of_type_AndroidContentContext, new avqx(this));
        return;
      }
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ImaxAdvertisement", 2, "installTVKSdk ", localThrowable);
    }
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      avqu.b("startVideoDownload queueType:" + paramInt);
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null)
      {
        avqu.b("startVideoDownload cache manager not init!");
        c();
        return;
      }
      if (paramInt <= this.jdField_a_of_type_Int)
      {
        avqu.b("startVideoDownload queue(" + this.jdField_a_of_type_Int + ") already run!");
        return;
      }
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      avqu.b("startVideoDownload break current queue(" + this.jdField_a_of_type_Int + ")!");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
      c();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask == null)
      {
        avqu.b("startVideoDownload no task to download");
        c();
        return;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = ((PAAdPreloadTask)this.jdField_a_of_type_JavaUtilArrayList.remove(0));
        }
      }
      else
      {
        this.jdField_a_of_type_Int = paramInt;
        String str1 = this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid;
        int i;
        String str2;
        Object localObject3;
        if (!TextUtils.isEmpty(str1)) {
          if (!this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isExpire())
          {
            i = a(str1);
            avqu.b("startVideoDownload vid:" + str1 + ", cacheState:" + i);
            if (i != 2) {
              if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isNetworkValid())
              {
                str2 = b(str1);
                localObject3 = new File(str2);
                boolean bool = ((File)localObject3).exists();
                if (bool) {}
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            ((File)localObject3).createNewFile();
            localObject3 = new TVK_PlayerVideoInfo(2, str1, "");
            HashMap localHashMap = new HashMap();
            localHashMap.put("shouq_bus_type", "bus_type_pa_advertisement");
            ((TVK_PlayerVideoInfo)localObject3).setReportInfoMap(localHashMap);
            ((TVK_PlayerVideoInfo)localObject3).setConfigMap("cache_duration", String.valueOf(-1));
            ((TVK_PlayerVideoInfo)localObject3).setConfigMap("cache_servers_type", String.valueOf(20170807));
            ((TVK_PlayerVideoInfo)localObject3).setConfigMap("file_dir", str2);
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.preLoadVideoById(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, (TVK_PlayerVideoInfo)localObject3, "");
            avqu.b("startVideoDownload vid:" + str1);
            return;
          }
          catch (IOException localIOException)
          {
            avqu.b("startVideoDownload create tmp file failed for vid:" + str1);
            continue;
          }
          i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
          avqu.b("startVideoDownload vid:" + str1 + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", curNetType:" + i + ", no valid network, skip to next task");
          b(paramInt);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "vid:" + str1 + ", full cached, skip to next task");
          }
          c(str1);
          b(paramInt);
          continue;
          avqu.b("startVideoDownload vid:" + str1 + ", expireTime:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mExpireTime + ", task expired, clean cache and skip to next task");
          b(paramInt);
          if (a(str1) != 0)
          {
            ThreadManager.executeOnFileThread(new ImaxAdVideoPreloadManager.7(this, str1));
            continue;
            avqu.b("startVideoDownload empty vid, skip to next task");
            b(paramInt);
          }
        }
        switch (paramInt)
        {
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, EntityManager paramEntityManager, aoxz paramaoxz)
  {
    Object localObject1 = paramMessageRecord.advertisementItem;
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((oeq)localObject1).jdField_a_of_type_Oes.jdField_a_of_type_JavaLangString)))
    {
      avqs.a().a(((oeq)localObject1).jdField_a_of_type_JavaLangString);
      avqs.a().a((oeq)localObject1);
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_uin", ((oeq)localObject1).jdField_a_of_type_Oes.jdField_a_of_type_JavaLangString);
      if (((oeq)localObject1).jdField_a_of_type_Oes.b != null) {
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_name", ((oeq)localObject1).jdField_a_of_type_Oes.b);
      }
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "false");
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "false");
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_uin_head_url", ((oeq)localObject1).e);
      localObject2 = paramEntityManager.query(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
      localObject1 = new ArrayList();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if (paramMessageRecord.frienduin.equals(((MessageRecord)localObject3).frienduin)) {
            ((List)localObject1).add(localObject3);
          }
        }
        localObject1 = ((List)localObject1).iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        paramEntityManager.remove((Entity)localObject2);
        alik.b(paramQQAppInterface, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
        localObject3 = (RecentUser)paramaoxz.findRecentUserByUin(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (localObject3 != null)
        {
          algs.a().a(paramMessageRecord.frienduin + "-" + paramMessageRecord.istroop);
          paramaoxz.delRecentUser((BaseRecentUser)localObject3);
        }
        paramQQAppInterface.getMessageFacade().setReaded(((MessageRecord)localObject2).frienduin, 10005, true, true);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "isImaxAdMessage: 0");
        }
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "0");
      }
    }
  }
  
  private void a(List<PAAdPreloadTask> paramList, oeq paramoeq, oer paramoer)
  {
    PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
    oes localoes = paramoeq.jdField_a_of_type_Oes;
    localPAAdPreloadTask.mUserUin = a();
    localPAAdPreloadTask.mVideoVid = paramoer.b;
    localPAAdPreloadTask.mMsgId = paramoeq.jdField_c_of_type_JavaLangString;
    localPAAdPreloadTask.mSource = 2;
    if (paramoeq.jdField_a_of_type_Long > 0L) {}
    for (long l = paramoeq.jdField_a_of_type_Long;; l = NetConnInfoCenter.getServerTimeMillis())
    {
      localPAAdPreloadTask.mReceiveTime = l;
      localPAAdPreloadTask.mExpireTime = paramoeq.b;
      localPAAdPreloadTask.mPreloadState = 1;
      localPAAdPreloadTask.mNetworkType = localoes.e;
      paramList.add(localPAAdPreloadTask);
      return;
    }
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString) == 2;
  }
  
  public static String b(String paramString)
  {
    String str = a(paramString);
    paramString = str;
    if (!TextUtils.isEmpty(str)) {
      paramString = str + ".tmp";
    }
    return paramString;
  }
  
  private void b()
  {
    avqu.b("initCacheManager");
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = localTVK_IProxyFactory.getCacheMgr(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(new avqz(this, null));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setOnPreLoadCompleteCallback(new avra(this, null));
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(int paramInt)
  {
    avqu.b("continueDownload queueType:" + paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
    ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.8(this, paramInt));
  }
  
  public static void b(String paramString)
  {
    avqu.b("clearCacheVideo vid:" + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(b(paramString));
      if (localFile.exists()) {
        localFile.delete();
      }
      paramString = new File(a(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  private void b(oeq paramoeq)
  {
    if (paramoeq == null)
    {
      QLog.e("ImaxAdvertisement", 1, "insertToMsgSystem 0xf9 advertisementItem == null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "insertToMsgSystem 0xf9 advertisementItem:" + paramoeq.jdField_a_of_type_JavaLangString);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      QLog.e("ImaxAdvertisement", 1, "insertToMsgSystem 0xf9 QQAppInterface == null");
      return;
    }
    String str = localQQAppInterface.getCurrentAccountUin();
    MessageRecord localMessageRecord = a(str, paramoeq);
    localMessageRecord.advertisementItem = paramoeq;
    paramoeq = new ArrayList();
    paramoeq.add(localMessageRecord);
    localQQAppInterface.getMessageFacade().addMessage(paramoeq, str, false, true, true);
    localQQAppInterface.getConversationFacade().a(localMessageRecord.frienduin, localMessageRecord.istroop).isImax = true;
    a(localQQAppInterface);
  }
  
  private void c()
  {
    avqu.b("resetDownload");
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
  }
  
  private void c(String paramString)
  {
    paramString = avqs.a().a(paramString).iterator();
    while (paramString.hasNext())
    {
      oeq localoeq = (oeq)paramString.next();
      b(localoeq);
      localoeq.jdField_a_of_type_Int = 1;
      avqu.b(a(), localoeq.jdField_a_of_type_JavaLangString, localoeq.a());
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask != null)
    {
      bdla.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mSource));
      return;
    }
    bdla.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", "", "");
  }
  
  private void d(String paramString)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {}
    for (localObject = ((QQAppInterface)localObject).getCurrentAccountUin();; localObject = "")
    {
      ofa.b((String)localObject, paramString);
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int == 0) {
      avqu.b("onNetworkChange, no queue is working");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask == null)
      {
        avqu.b("onNetworkChange, no valid task");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isNetworkValid())
      {
        avqu.b("onNetworkChange, vid:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", valid network, going on");
        return;
      }
      avqu.b("onNetworkChange, vid:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", invalid network, skip to next task");
    } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
    b(this.jdField_a_of_type_Int);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ImaxAdVideoPreloadManager.4(this, paramQQAppInterface), 300L);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    avqu.b("loadLocalConfigTaskForImax uin:" + paramString);
    Object localObject3 = avqu.a(paramString);
    ??? = new ArrayList();
    Object localObject2 = new ArrayList();
    paramString = a();
    avqp.a().b(avqu.a(paramString, "delete_uin_list"));
    Object localObject5;
    if (localObject3 != null)
    {
      avqu.b("loadLocalConfigTaskForImax sp size:" + ((Map)localObject3).size());
      localObject4 = ((Map)localObject3).keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = oeq.a((String)((Map)localObject3).get((String)((Iterator)localObject4).next()));
        if (localObject5 != null)
        {
          avqs.a().a((oeq)localObject5);
          ((List)???).add(localObject5);
          if ((((oeq)localObject5).c()) || (avqp.a().a(paramString, ((oeq)localObject5).jdField_a_of_type_JavaLangString)))
          {
            ((List)localObject2).add(localObject5);
            if ((((oeq)localObject5).jdField_a_of_type_JavaUtilArrayList != null) && (((oeq)localObject5).jdField_a_of_type_JavaUtilArrayList.size() > 0))
            {
              localObject5 = ((oeq)localObject5).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject5).hasNext()) {
                b(((oer)((Iterator)localObject5).next()).b);
              }
            }
          }
        }
      }
    }
    localObject3 = new ArrayList();
    Object localObject4 = ((ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).a();
    if (localObject4 != null)
    {
      localObject5 = ((aoxz)localObject4).getRecentList(true);
      int i = 0;
      while (i < ((List)localObject5).size())
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject5).get(i);
        oeq localoeq = avqs.a().b(localRecentUser.uin);
        if ((localRecentUser.getType() == 10005) && (localoeq != null))
        {
          ((List)localObject3).add(localoeq);
          if ((localoeq.c()) || (avqp.a().a(paramString, localoeq.jdField_a_of_type_JavaLangString)))
          {
            algs.a().a(localRecentUser.uin + "-" + localRecentUser.getType());
            ((aoxz)localObject4).delRecentUser(localRecentUser);
            alik.b(paramQQAppInterface, localRecentUser.uin, 10005);
            paramQQAppInterface.getMessageFacade().setReaded(localRecentUser.uin, 10005);
          }
        }
        i += 1;
      }
    }
    if (((List)localObject3).size() > 0) {
      a(paramQQAppInterface);
    }
    ((List)???).removeAll((Collection)localObject2);
    avqs.a().a();
    avqu.a(paramString);
    paramQQAppInterface = ((List)???).iterator();
    while (paramQQAppInterface.hasNext())
    {
      localObject4 = (oeq)paramQQAppInterface.next();
      avqs.a().a((oeq)localObject4);
      avqu.b(paramString, ((oeq)localObject4).jdField_a_of_type_JavaLangString, ((oeq)localObject4).a());
    }
    avqu.b("loadLocalConfigTaskForImax recentImaxAdList:" + ((List)localObject3).size() + " expiredImaxAdList:" + ((List)localObject2).size() + " imaxAdList:" + ((List)???).size());
    paramQQAppInterface = new ArrayList();
    ??? = ((List)???).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (oeq)((Iterator)???).next();
      if ((((oeq)localObject2).jdField_a_of_type_JavaUtilArrayList != null) && (((oeq)localObject2).jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject4 = (oer)((oeq)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0);
        if (!((List)localObject3).contains(localObject2)) {
          a(paramQQAppInterface, (oeq)localObject2, (oer)localObject4);
        } else if (a(((oer)localObject4).b) != 2) {
          a(paramQQAppInterface, (oeq)localObject2, (oer)localObject4);
        }
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramQQAppInterface.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramQQAppInterface);
        avqu.b("loadLocalConfigTaskForImax taskSize:" + paramQQAppInterface.size());
        ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.3(this));
        avqp.a().c(paramString);
        return;
      }
      avqu.b("loadLocalConfigTaskForImax tasklist null");
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "handlePreloadTaskFromGdtAd() called with: tencentVideoId = [" + paramString + "]");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
      localPAAdPreloadTask.mUserUin = a();
      localPAAdPreloadTask.mVideoVid = paramString;
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localPAAdPreloadTask))
      {
        localPAAdPreloadTask.mMsgId = MD5Utils.toMD5(localPAAdPreloadTask.mVideoVid);
        localPAAdPreloadTask.mSource = 2;
        localPAAdPreloadTask.mReceiveTime = NetConnInfoCenter.getServerTimeMillis();
        localPAAdPreloadTask.mExpireTime = (localPAAdPreloadTask.mReceiveTime + 86400000L);
        localPAAdPreloadTask.mPreloadState = 1;
        this.jdField_a_of_type_JavaUtilArrayList.add(localPAAdPreloadTask);
        ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.6(this));
        avqu.b("handlePreloadTaskFromMessage msgid:" + localPAAdPreloadTask.mMsgId + ", vid:" + localPAAdPreloadTask.mVideoVid + ", add to queue");
        return;
      }
      avqu.b("handlePreloadTaskFromMessage msgid:" + localPAAdPreloadTask.mMsgId + ", vid:" + localPAAdPreloadTask.mVideoVid + ", exist in queue, ignore");
    }
  }
  
  public void a(oeq paramoeq)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramoeq != null) {}
    for (;;)
    {
      oer localoer;
      try
      {
        if ((paramoeq.jdField_a_of_type_Oes == null) || (paramoeq.jdField_a_of_type_JavaUtilArrayList == null) || (paramoeq.jdField_a_of_type_JavaUtilArrayList.size() <= 0))
        {
          avqu.b("handlePreloadTaskFromMessage invalid item");
          return;
        }
        avqu.b("handlePreloadTaskFromMessage adItem " + paramoeq.jdField_a_of_type_JavaLangString);
        oes localoes = paramoeq.jdField_a_of_type_Oes;
        localoer = (oer)paramoeq.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (!TextUtils.isEmpty(localoer.b))
        {
          PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
          localPAAdPreloadTask.mUserUin = a();
          localPAAdPreloadTask.mVideoVid = localoer.b;
          if (this.jdField_a_of_type_JavaUtilArrayList.contains(localPAAdPreloadTask)) {
            break label287;
          }
          localPAAdPreloadTask.mMsgId = paramoeq.jdField_c_of_type_JavaLangString;
          localPAAdPreloadTask.mSource = 2;
          if (paramoeq.jdField_a_of_type_Long > 0L)
          {
            l = paramoeq.jdField_a_of_type_Long;
            localPAAdPreloadTask.mReceiveTime = l;
            localPAAdPreloadTask.mExpireTime = paramoeq.b;
            localPAAdPreloadTask.mPreloadState = 1;
            localPAAdPreloadTask.mNetworkType = localoes.e;
            this.jdField_a_of_type_JavaUtilArrayList.add(localPAAdPreloadTask);
            ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.5(this));
            avqu.b("handlePreloadTaskFromMessage msgid:" + paramoeq.jdField_c_of_type_JavaLangString + ", vid:" + localoer.b + ", add to queue");
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      long l = NetConnInfoCenter.getServerTimeMillis();
      continue;
      label287:
      avqu.b("handlePreloadTaskFromMessage msgid:" + paramoeq.jdField_c_of_type_JavaLangString + ", vid:" + localoer.b + ", exist in queue, ignore");
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    avqu.b("processMsg0x210Sub0xfd " + paramInt);
    if (paramArrayOfByte == null) {
      QLog.e("ImaxAdvertisement", 1, "processMsg0x210Sub0xfd pbData == null " + paramInt + " threadName" + Thread.currentThread().getName());
    }
    for (;;)
    {
      return;
      try
      {
        paramArrayOfByte = String.valueOf(((submsgtype0xfd.MsgBody)new submsgtype0xfd.MsgBody().mergeFrom(paramArrayOfByte)).msg_AdInfo.uint64_from_uin.get());
        avqp.a().a(paramArrayOfByte);
        avqu.a(a(), "delete_uin_list", avqp.a().a());
        avqu.a(a(), "delete_st_" + paramArrayOfByte, String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
        {
          avqp.a().a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramArrayOfByte);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("ImaxAdvertisement", 1, "processMsg0x210Sub0xfd error", paramArrayOfByte);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, MsgInfo paramMsgInfo)
  {
    avqu.b("processMsg0x210Sub0xf9 " + paramInt);
    if (paramArrayOfByte == null)
    {
      QLog.e("ImaxAdvertisement", 1, "processMsg0x210Sub0xf9 pbData == null " + paramInt);
      return;
    }
    Object localObject = new submsgtype0xf9.MsgBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (submsgtype0xf9.MsgBody)((submsgtype0xf9.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (!paramArrayOfByte.bytes_zip_AdInfo.has()) {
          break label329;
        }
        paramArrayOfByte = avqu.a(paramArrayOfByte.bytes_zip_AdInfo.get().toByteArray());
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          avqu.b("output == null " + paramInt);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("ImaxAdvertisement", 1, "processMsg0x210Sub 0xf9 error", paramArrayOfByte);
        return;
      }
      localObject = new submsgtype0xf9.AdInfo();
      ((submsgtype0xf9.AdInfo)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = oeq.a((submsgtype0xf9.AdInfo)localObject, paramMsgInfo);
      if (avqp.a().a(a(), paramArrayOfByte.jdField_a_of_type_JavaLangString))
      {
        avqu.b("processMsg0x210Sub0xf9 InDeleteFilter mSenderUin " + paramArrayOfByte.jdField_a_of_type_JavaLangString);
        return;
      }
      avqs.a().a(paramArrayOfByte.jdField_a_of_type_JavaLangString);
      avqs.a().a(paramArrayOfByte);
      avqu.b("processMsg0x210Sub0xf9 sp :advertisementItem " + paramArrayOfByte.jdField_a_of_type_JavaLangString);
      avqu.b(a(), paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte.a());
      if ((paramArrayOfByte.jdField_a_of_type_JavaUtilArrayList == null) || (paramArrayOfByte.jdField_a_of_type_JavaUtilArrayList.size() == 0))
      {
        QLog.e("ImaxAdvertisement", 1, "no any video resources 0xf9 error" + paramArrayOfByte.jdField_a_of_type_JavaLangString);
        b(paramArrayOfByte);
        return;
      }
      a(paramArrayOfByte);
      return;
      label329:
      paramArrayOfByte = null;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.removePreloadCallback();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setOnPreLoadCompleteCallback(null);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.releasePreload(20170807);
    }
    if (this.jdField_a_of_type_Avqy != null)
    {
      this.jdField_a_of_type_Avqy.a();
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Avqy);
      this.jdField_a_of_type_Avqy = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqv
 * JD-Core Version:    0.7.0.1
 */