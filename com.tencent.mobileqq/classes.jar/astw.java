import OnlinePushPack.MsgInfo;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
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

public class astw
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.tencent.mobileqq/cache/public_account_ad_download/";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "mp4", "fhd", "shd", "hd", "sd", "msd" };
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private astz jdField_a_of_type_Astz;
  private PAAdPreloadTask jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_UserInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<PAAdPreloadTask> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public astw(QQAppInterface paramQQAppInterface)
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
  
  private static MessageRecord a(String paramString, nlo paramnlo)
  {
    MessageRecord localMessageRecord = new MessageRecord();
    localMessageRecord.selfuin = paramString;
    localMessageRecord.frienduin = paramnlo.jdField_a_of_type_JavaLangString;
    localMessageRecord.senderuin = paramnlo.jdField_a_of_type_JavaLangString;
    localMessageRecord.msgtype = -1000;
    localMessageRecord.msg = paramnlo.f;
    localMessageRecord.time = paramnlo.jdField_c_of_type_Long;
    localMessageRecord.shmsgseq = paramnlo.jdField_a_of_type_Short;
    localMessageRecord.msgUid = paramnlo.d;
    localMessageRecord.istroop = 10005;
    localMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "1");
    return localMessageRecord;
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      return ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c();
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
    astv.b("installTVKSdk");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo(a(), "");
    this.jdField_a_of_type_Astz = new astz(this, this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Astz);
    try
    {
      TVK_SDKMgr.setOnLogListener(new astx(this));
      TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidContentContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", a());
      if (!TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
      {
        TVK_SDKMgr.installPlugin(this.jdField_a_of_type_AndroidContentContext, new asty(this));
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
      astv.b("startVideoDownload queueType:" + paramInt);
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null)
      {
        astv.b("startVideoDownload cache manager not init!");
        c();
        return;
      }
      if (paramInt <= this.jdField_a_of_type_Int)
      {
        astv.b("startVideoDownload queue(" + this.jdField_a_of_type_Int + ") already run!");
        return;
      }
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      astv.b("startVideoDownload break current queue(" + this.jdField_a_of_type_Int + ")!");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20170807);
      c();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask == null)
      {
        astv.b("startVideoDownload no task to download");
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
            astv.b("startVideoDownload vid:" + str1 + ", cacheState:" + i);
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
            astv.b("startVideoDownload vid:" + str1);
            return;
          }
          catch (IOException localIOException)
          {
            astv.b("startVideoDownload create tmp file failed for vid:" + str1);
            continue;
          }
          i = bdee.a(BaseApplication.getContext());
          astv.b("startVideoDownload vid:" + str1 + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", curNetType:" + i + ", no valid network, skip to next task");
          b(paramInt);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "vid:" + str1 + ", full cached, skip to next task");
          }
          c(str1);
          b(paramInt);
          continue;
          astv.b("startVideoDownload vid:" + str1 + ", expireTime:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mExpireTime + ", task expired, clean cache and skip to next task");
          b(paramInt);
          if (a(str1) != 0)
          {
            ThreadManager.executeOnFileThread(new ImaxAdVideoPreloadManager.7(this, str1));
            continue;
            astv.b("startVideoDownload empty vid, skip to next task");
            b(paramInt);
          }
        }
        switch (paramInt)
        {
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, awbw paramawbw, amjk paramamjk)
  {
    Object localObject1 = paramMessageRecord.advertisementItem;
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((nlo)localObject1).jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString)))
    {
      astt.a().a(((nlo)localObject1).jdField_a_of_type_JavaLangString);
      astt.a().a((nlo)localObject1);
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_uin", ((nlo)localObject1).jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString);
      if (((nlo)localObject1).jdField_a_of_type_Nlq.b != null) {
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_name", ((nlo)localObject1).jdField_a_of_type_Nlq.b);
      }
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "false");
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "false");
      paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_uin_head_url", ((nlo)localObject1).e);
      localObject2 = paramawbw.a(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
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
        paramawbw.b((awbv)localObject2);
        ajgm.b(paramQQAppInterface, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
        localObject3 = paramamjk.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (localObject3 != null)
        {
          ajeu.a().a(paramMessageRecord.frienduin + "-" + paramMessageRecord.istroop);
          paramamjk.b((RecentUser)localObject3);
        }
        paramQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, 10005, true, true);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "isImaxAdMessage: 0");
        }
        paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "0");
      }
    }
  }
  
  private void a(List<PAAdPreloadTask> paramList, nlo paramnlo, nlp paramnlp)
  {
    PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
    nlq localnlq = paramnlo.jdField_a_of_type_Nlq;
    localPAAdPreloadTask.mUserUin = a();
    localPAAdPreloadTask.mVideoVid = paramnlp.b;
    localPAAdPreloadTask.mMsgId = paramnlo.jdField_c_of_type_JavaLangString;
    localPAAdPreloadTask.mSource = 2;
    if (paramnlo.jdField_a_of_type_Long > 0L) {}
    for (long l = paramnlo.jdField_a_of_type_Long;; l = NetConnInfoCenter.getServerTimeMillis())
    {
      localPAAdPreloadTask.mReceiveTime = l;
      localPAAdPreloadTask.mExpireTime = paramnlo.b;
      localPAAdPreloadTask.mPreloadState = 1;
      localPAAdPreloadTask.mNetworkType = localnlq.e;
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
    astv.b("initCacheManager");
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = localTVK_IProxyFactory.getCacheMgr(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(new asua(this, null));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setOnPreLoadCompleteCallback(new asub(this, null));
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(int paramInt)
  {
    astv.b("continueDownload queueType:" + paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
    ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.8(this, paramInt));
  }
  
  public static void b(String paramString)
  {
    astv.b("clearCacheVideo vid:" + paramString);
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
  
  private void b(nlo paramnlo)
  {
    if (paramnlo == null)
    {
      QLog.e("ImaxAdvertisement", 1, "insertToMsgSystem 0xf9 advertisementItem == null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "insertToMsgSystem 0xf9 advertisementItem:" + paramnlo.jdField_a_of_type_JavaLangString);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      QLog.e("ImaxAdvertisement", 1, "insertToMsgSystem 0xf9 QQAppInterface == null");
      return;
    }
    String str = localQQAppInterface.getCurrentAccountUin();
    MessageRecord localMessageRecord = a(str, paramnlo);
    localMessageRecord.advertisementItem = paramnlo;
    paramnlo = new ArrayList();
    paramnlo.add(localMessageRecord);
    localQQAppInterface.a().a(paramnlo, str, false, true, true);
    localQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop).isImax = true;
    a(localQQAppInterface);
  }
  
  private void c()
  {
    astv.b("resetDownload");
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask = null;
  }
  
  private void c(String paramString)
  {
    paramString = astt.a().a(paramString).iterator();
    while (paramString.hasNext())
    {
      nlo localnlo = (nlo)paramString.next();
      b(localnlo);
      localnlo.jdField_a_of_type_Int = 1;
      astv.b(a(), localnlo.jdField_a_of_type_JavaLangString, localnlo.a());
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask != null)
    {
      azmj.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mSource));
      return;
    }
    azmj.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", "", "");
  }
  
  private void d(String paramString)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {}
    for (localObject = ((QQAppInterface)localObject).getCurrentAccountUin();; localObject = "")
    {
      nly.b((String)localObject, paramString);
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int == 0) {
      astv.b("onNetworkChange, no queue is working");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask == null)
      {
        astv.b("onNetworkChange, no valid task");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.isNetworkValid())
      {
        astv.b("onNetworkChange, vid:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", valid network, going on");
        return;
      }
      astv.b("onNetworkChange, vid:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mVideoVid + ", networkType:" + this.jdField_a_of_type_ComTencentBizPubaccountPersistenceEntityPAAdPreloadTask.mNetworkType + ", invalid network, skip to next task");
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
    astv.b("loadLocalConfigTaskForImax uin:" + paramString);
    Object localObject3 = astv.a(paramString);
    ??? = new ArrayList();
    Object localObject2 = new ArrayList();
    paramString = a();
    astq.a().b(astv.a(paramString, "delete_uin_list"));
    Object localObject5;
    if (localObject3 != null)
    {
      astv.b("loadLocalConfigTaskForImax sp size:" + ((Map)localObject3).size());
      localObject4 = ((Map)localObject3).keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = nlo.a((String)((Map)localObject3).get((String)((Iterator)localObject4).next()));
        if (localObject5 != null)
        {
          astt.a().a((nlo)localObject5);
          ((List)???).add(localObject5);
          if ((((nlo)localObject5).c()) || (astq.a().a(paramString, ((nlo)localObject5).jdField_a_of_type_JavaLangString)))
          {
            ((List)localObject2).add(localObject5);
            if ((((nlo)localObject5).jdField_a_of_type_JavaUtilArrayList != null) && (((nlo)localObject5).jdField_a_of_type_JavaUtilArrayList.size() > 0))
            {
              localObject5 = ((nlo)localObject5).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject5).hasNext()) {
                b(((nlp)((Iterator)localObject5).next()).b);
              }
            }
          }
        }
      }
    }
    localObject3 = new ArrayList();
    Object localObject4 = ((ProxyManager)paramQQAppInterface.getManager(18)).a();
    if (localObject4 != null)
    {
      localObject5 = ((amjk)localObject4).a(true);
      int i = 0;
      while (i < ((List)localObject5).size())
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject5).get(i);
        nlo localnlo = astt.a().b(localRecentUser.uin);
        if ((localRecentUser.getType() == 10005) && (localnlo != null))
        {
          ((List)localObject3).add(localnlo);
          if ((localnlo.c()) || (astq.a().a(paramString, localnlo.jdField_a_of_type_JavaLangString)))
          {
            ajeu.a().a(localRecentUser.uin + "-" + localRecentUser.getType());
            ((amjk)localObject4).b(localRecentUser);
            ajgm.b(paramQQAppInterface, localRecentUser.uin, 10005);
            paramQQAppInterface.a().c(localRecentUser.uin, 10005);
          }
        }
        i += 1;
      }
    }
    if (((List)localObject3).size() > 0) {
      a(paramQQAppInterface);
    }
    ((List)???).removeAll((Collection)localObject2);
    astt.a().a();
    astv.a(paramString);
    paramQQAppInterface = ((List)???).iterator();
    while (paramQQAppInterface.hasNext())
    {
      localObject4 = (nlo)paramQQAppInterface.next();
      astt.a().a((nlo)localObject4);
      astv.b(paramString, ((nlo)localObject4).jdField_a_of_type_JavaLangString, ((nlo)localObject4).a());
    }
    astv.b("loadLocalConfigTaskForImax recentImaxAdList:" + ((List)localObject3).size() + " expiredImaxAdList:" + ((List)localObject2).size() + " imaxAdList:" + ((List)???).size());
    paramQQAppInterface = new ArrayList();
    ??? = ((List)???).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (nlo)((Iterator)???).next();
      if ((((nlo)localObject2).jdField_a_of_type_JavaUtilArrayList != null) && (((nlo)localObject2).jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject4 = (nlp)((nlo)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0);
        if (!((List)localObject3).contains(localObject2)) {
          a(paramQQAppInterface, (nlo)localObject2, (nlp)localObject4);
        } else if (a(((nlp)localObject4).b) != 2) {
          a(paramQQAppInterface, (nlo)localObject2, (nlp)localObject4);
        }
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramQQAppInterface.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramQQAppInterface);
        astv.b("loadLocalConfigTaskForImax taskSize:" + paramQQAppInterface.size());
        ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.3(this));
        astq.a().c(paramString);
        return;
      }
      astv.b("loadLocalConfigTaskForImax tasklist null");
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
        localPAAdPreloadTask.mMsgId = bfhi.d(localPAAdPreloadTask.mVideoVid);
        localPAAdPreloadTask.mSource = 2;
        localPAAdPreloadTask.mReceiveTime = NetConnInfoCenter.getServerTimeMillis();
        localPAAdPreloadTask.mExpireTime = (localPAAdPreloadTask.mReceiveTime + 86400000L);
        localPAAdPreloadTask.mPreloadState = 1;
        this.jdField_a_of_type_JavaUtilArrayList.add(localPAAdPreloadTask);
        ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.6(this));
        astv.b("handlePreloadTaskFromMessage msgid:" + localPAAdPreloadTask.mMsgId + ", vid:" + localPAAdPreloadTask.mVideoVid + ", add to queue");
        return;
      }
      astv.b("handlePreloadTaskFromMessage msgid:" + localPAAdPreloadTask.mMsgId + ", vid:" + localPAAdPreloadTask.mVideoVid + ", exist in queue, ignore");
    }
  }
  
  public void a(nlo paramnlo)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramnlo != null) {}
    for (;;)
    {
      nlp localnlp;
      try
      {
        if ((paramnlo.jdField_a_of_type_Nlq == null) || (paramnlo.jdField_a_of_type_JavaUtilArrayList == null) || (paramnlo.jdField_a_of_type_JavaUtilArrayList.size() <= 0))
        {
          astv.b("handlePreloadTaskFromMessage invalid item");
          return;
        }
        astv.b("handlePreloadTaskFromMessage adItem " + paramnlo.jdField_a_of_type_JavaLangString);
        nlq localnlq = paramnlo.jdField_a_of_type_Nlq;
        localnlp = (nlp)paramnlo.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (!TextUtils.isEmpty(localnlp.b))
        {
          PAAdPreloadTask localPAAdPreloadTask = new PAAdPreloadTask();
          localPAAdPreloadTask.mUserUin = a();
          localPAAdPreloadTask.mVideoVid = localnlp.b;
          if (this.jdField_a_of_type_JavaUtilArrayList.contains(localPAAdPreloadTask)) {
            break label287;
          }
          localPAAdPreloadTask.mMsgId = paramnlo.jdField_c_of_type_JavaLangString;
          localPAAdPreloadTask.mSource = 2;
          if (paramnlo.jdField_a_of_type_Long > 0L)
          {
            l = paramnlo.jdField_a_of_type_Long;
            localPAAdPreloadTask.mReceiveTime = l;
            localPAAdPreloadTask.mExpireTime = paramnlo.b;
            localPAAdPreloadTask.mPreloadState = 1;
            localPAAdPreloadTask.mNetworkType = localnlq.e;
            this.jdField_a_of_type_JavaUtilArrayList.add(localPAAdPreloadTask);
            ThreadManager.executeOnNetWorkThread(new ImaxAdVideoPreloadManager.5(this));
            astv.b("handlePreloadTaskFromMessage msgid:" + paramnlo.jdField_c_of_type_JavaLangString + ", vid:" + localnlp.b + ", add to queue");
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
      astv.b("handlePreloadTaskFromMessage msgid:" + paramnlo.jdField_c_of_type_JavaLangString + ", vid:" + localnlp.b + ", exist in queue, ignore");
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    astv.b("processMsg0x210Sub0xfd " + paramInt);
    if (paramArrayOfByte == null) {
      QLog.e("ImaxAdvertisement", 1, "processMsg0x210Sub0xfd pbData == null " + paramInt + " threadName" + Thread.currentThread().getName());
    }
    for (;;)
    {
      return;
      try
      {
        paramArrayOfByte = String.valueOf(((submsgtype0xfd.MsgBody)new submsgtype0xfd.MsgBody().mergeFrom(paramArrayOfByte)).msg_AdInfo.uint64_from_uin.get());
        astq.a().a(paramArrayOfByte);
        astv.a(a(), "delete_uin_list", astq.a().a());
        astv.a(a(), "delete_st_" + paramArrayOfByte, String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
        {
          astq.a().a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramArrayOfByte);
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
    astv.b("processMsg0x210Sub0xf9 " + paramInt);
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
        paramArrayOfByte = astv.a(paramArrayOfByte.bytes_zip_AdInfo.get().toByteArray());
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          astv.b("output == null " + paramInt);
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
      paramArrayOfByte = nlo.a((submsgtype0xf9.AdInfo)localObject, paramMsgInfo);
      if (astq.a().a(a(), paramArrayOfByte.jdField_a_of_type_JavaLangString))
      {
        astv.b("processMsg0x210Sub0xf9 InDeleteFilter mSenderUin " + paramArrayOfByte.jdField_a_of_type_JavaLangString);
        return;
      }
      astt.a().a(paramArrayOfByte.jdField_a_of_type_JavaLangString);
      astt.a().a(paramArrayOfByte);
      astv.b("processMsg0x210Sub0xf9 sp :advertisementItem " + paramArrayOfByte.jdField_a_of_type_JavaLangString);
      astv.b(a(), paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte.a());
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
    if (this.jdField_a_of_type_Astz != null)
    {
      this.jdField_a_of_type_Astz.a();
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Astz);
      this.jdField_a_of_type_Astz = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astw
 * JD-Core Version:    0.7.0.1
 */