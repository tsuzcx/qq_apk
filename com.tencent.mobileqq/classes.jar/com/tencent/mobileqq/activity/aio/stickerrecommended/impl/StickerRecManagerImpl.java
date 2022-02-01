package com.tencent.mobileqq.activity.aio.stickerrecommended.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecLocalEmoticonHandleListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager.ImgUpdateListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.SearchStickerRecEmoticonUtil;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCameraEmoticonHandleListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecConstants;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecFavoriteEmoHandleListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecLocalEmoticonHandleListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecReport;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecReportData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecReportDataBase;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecServlet;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerReportItem;
import com.tencent.mobileqq.activity.aio.stickerrecommended.ad.StickerRecAdEmotionHandlerListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecReportData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendItem;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.ScenesRecommendManagerImpl;
import com.tencent.mobileqq.apollo.script.api.ISpriteUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.core.util.EmotionSharedPreUtils;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IIceBreakingMsg;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.emosm.PicSearchSvr.EmotionInfo;
import com.tencent.pb.emosm.PicSearchSvr.ImgInfo;
import com.tencent.pb.emosm.PicSearchSvr.ReqBody;
import com.tencent.pb.emosm.PicSearchSvr.RspBody;
import com.tencent.pb.emosm.PicSearchWordsSvr.ReqBody;
import com.tencent.pb.emosm.PicSearchWordsSvr.RspBody;
import com.tencent.pb.emosm.PicSearchWordsSvr.WordsMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.activity.aio.stickerrecommended.StickerReportItem;>;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class StickerRecManagerImpl
  implements IStickerRecManager
{
  private static final String CMD_PULL_PICS = "PicSearchSvr.PullPics";
  private static final String CMD_PULL_WORDS = "PicSearchWordsSvr.PullWords";
  private static final String CMD_SCENES_PULL_PICS = "SceneFaceRec.PullFaces";
  private static final String ENCODED_BLOOM_NAME = "encodedBloom.bin";
  private static final String LOCAL_WORDS_FILE_NAME = "local_words.bin";
  public static final String MOBILEQQ_RECOMMENDED_STICKER_CONFIG = "MOBILEQQ_RECOMMENDED_STICKER_CONFIG";
  public static final String RECOMMENDED_STICKER_MAX_MATCH_LENGTH = "RECOMMENDED_STICKER_MAX_MATCH_LENGTH";
  public static final String RECOMMENDED_STICKER_SWITCH = "RECOMMENDED_STICKER_SWITCH";
  public static final String RECOMMENDED_STICKER_VERSION = "RECOMMENDED_STICKER_VERSION";
  public static final String REPORT_TAG_SUCC = "param_succ_flag";
  private static final String REQUEST_AIO_TYPE = "request_aio_type";
  private static final String REQUEST_SCENES_ID_KEY = "REQUEST_SCENES_ID";
  private static final String SSO_CMD_REPORT_NEW = "MQInference.CommonReport";
  public static final String TAG = "StickerRecManager";
  private static final String USER_KEYWORD_KEY = "USER_KEYWORD";
  private static final String WORDS_FILE_NAME = "words.json";
  private static final String WORDS_VERSION_KEY = "words_version_key805_gray_one";
  private static final String WORDS_ZIP_FILE_NAME = "words.zip";
  private static Integer sMaxMatchLength;
  private static Boolean sRecStickerSwitch;
  private BloomFilter bloomFilter = null;
  private IEmoticonManagerService emoticonManager = null;
  private boolean emotionRecSettingSwitch = true;
  private EntityManager entityManager = null;
  private volatile boolean hasInit = false;
  private IStickerRecManager.ImgUpdateListener imgUpdateListener;
  private BaseQQAppInterface mApp;
  private StickerRecCameraEmoticonHandleListener mCameraEmoticonHandleListener;
  private Card mCard = null;
  private volatile String mCurrentText = "";
  private MqqHandler mDbHandler = ThreadManager.getFileThreadHandler();
  private File mDownloadFile;
  private File mEncodedBloomFile;
  private StickerRecFavoriteEmoHandleListener mFavEmoticonHandleListener;
  private HashSet<String> mLocalKeywordsSet = null;
  private File mLocalWordsFile;
  private List<IStickerRecLocalEmoticonHandleListener> mStickerRecLocalEmoticonChangeListeners;
  private List<StickerReportItem> mStickerReportItems = new ArrayList();
  private File mWordsFile;
  private int maxMatchLength = 6;
  public List<IStickerRecEmoticon> stickerRecDataLocalList = new CopyOnWriteArrayList();
  
  private void cacheResInDb(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "cache pics in DB");
    }
    if (this.entityManager != null)
    {
      StickerRecommendEntity localStickerRecommendEntity = new StickerRecommendEntity();
      localStickerRecommendEntity.usrMessage = paramString;
      localStickerRecommendEntity.recList = Base64.encodeToString(paramArrayOfByte, 0);
      localStickerRecommendEntity.cachedTime = System.currentTimeMillis();
      localStickerRecommendEntity.recommendType = paramInt;
      this.mDbHandler.post(new StickerRecManagerImpl.5(this, localStickerRecommendEntity));
    }
  }
  
  private int convertAIOType(int paramInt)
  {
    int i = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000) {
          return 4;
        }
        return 3;
      }
      i = 2;
    }
    return i;
  }
  
  @NotNull
  private List<IStickerRecEmoticon> fillData(int paramInt, PicSearchSvr.RspBody paramRspBody, List<PicSearchSvr.ImgInfo> paramList)
  {
    if (paramRspBody.bytes_rsp_other.has()) {
      paramRspBody = paramRspBody.bytes_rsp_other.get().toStringUtf8();
    } else {
      paramRspBody = null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (PicSearchSvr.ImgInfo)paramList.get(i);
      StickerRecData localStickerRecData = new StickerRecData();
      localStickerRecData.f(i);
      localStickerRecData.c(((PicSearchSvr.ImgInfo)localObject).uint64_img_size.get());
      localStickerRecData.a(((PicSearchSvr.ImgInfo)localObject).uint32_img_width.get());
      localStickerRecData.b(((PicSearchSvr.ImgInfo)localObject).uint32_img_height.get());
      localStickerRecData.e(((PicSearchSvr.ImgInfo)localObject).bytes_img_md5.get().toStringUtf8());
      localStickerRecData.c(((PicSearchSvr.ImgInfo)localObject).bytes_img_down_url.get().toStringUtf8());
      localStickerRecData.d(((PicSearchSvr.ImgInfo)localObject).uint64_thumb_size.get());
      localStickerRecData.d(((PicSearchSvr.ImgInfo)localObject).uint32_thumb_img_height.get());
      localStickerRecData.c(((PicSearchSvr.ImgInfo)localObject).uint32_thumb_img_width.get());
      localStickerRecData.d(((PicSearchSvr.ImgInfo)localObject).bytes_thumb_down_url.get().toStringUtf8());
      localStickerRecData.f(((PicSearchSvr.ImgInfo)localObject).bytes_thumb_img_md5.get().toStringUtf8());
      localStickerRecData.g(((PicSearchSvr.ImgInfo)localObject).uint32_src_type.get());
      localStickerRecData.g(((PicSearchSvr.ImgInfo)localObject).bytes_src_desc.get().toStringUtf8());
      localStickerRecData.h(((PicSearchSvr.ImgInfo)localObject).bytes_web_url.get().toStringUtf8());
      localStickerRecData.i("");
      localStickerRecData.j(((PicSearchSvr.ImgInfo)localObject).bytes_pack_name.get().toStringUtf8());
      localStickerRecData.h(((PicSearchSvr.ImgInfo)localObject).uint32_pack_id.get());
      if (((PicSearchSvr.ImgInfo)localObject).bytes_img_other.has()) {
        localStickerRecData.k(((PicSearchSvr.ImgInfo)localObject).bytes_img_other.get().toStringUtf8());
      }
      localStickerRecData.l(paramRspBody);
      localStickerRecData.e(paramInt);
      if (((PicSearchSvr.ImgInfo)localObject).msg_emotion_info.has())
      {
        localObject = ((PicSearchSvr.ImgInfo)localObject).msg_emotion_info;
        if (((PicSearchSvr.EmotionInfo)localObject).bytes_url.has()) {
          localStickerRecData.a(((PicSearchSvr.EmotionInfo)localObject).bytes_url.get().toStringUtf8());
        }
      }
      if ((localStickerRecData.e() == 3) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reveice cmsEmo  from:");
        ((StringBuilder)localObject).append(localStickerRecData.e());
        ((StringBuilder)localObject).append(", CmShowinfo:");
        ((StringBuilder)localObject).append(localStickerRecData.e());
        QLog.i("StickerRecManager", 2, ((StringBuilder)localObject).toString());
      }
      localArrayList.add(localStickerRecData);
      i += 1;
    }
    return localArrayList;
  }
  
  public static StickerRecManagerImpl get(AppInterface paramAppInterface)
  {
    return (StickerRecManagerImpl)paramAppInterface.getRuntimeService(IStickerRecManager.class, "");
  }
  
  private String getDataDir()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getApp().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.mApp.getCurrentUin());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qstorage");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("objs");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("sticker_recommend");
    return localStringBuilder.toString();
  }
  
  public static File getDiskFile(String paramString)
  {
    try
    {
      paramString = Utils.Crc64String(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(StickerRecConstants.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramString);
      paramString = new File(localStringBuilder.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean getEmotionRecSettingSwitch(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emotion_rec_setting_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), true);
  }
  
  public static long getLastTimeRemoveEmoticonPackage(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sticker_remove_emoticon_package_time_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static int getMaxMatchLength(Context paramContext, String paramString, int paramInt)
  {
    if (sMaxMatchLength == null)
    {
      paramContext = paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RECOMMENDED_STICKER_MAX_MATCH_LENGTH");
      localStringBuilder.append(paramString);
      sMaxMatchLength = Integer.valueOf(paramContext.getInt(localStringBuilder.toString(), paramInt));
    }
    return 6;
  }
  
  private PicSearchSvr.ReqBody getPullPicsRequestBody(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, List<String> paramList)
  {
    try
    {
      PicSearchSvr.ReqBody localReqBody = new PicSearchSvr.ReqBody();
      localReqBody.setHasFlag(true);
      int i = getcmShowIsEnable();
      localReqBody.bytes_session_id.set(ByteStringMicro.copyFromUtf8(paramString1));
      localReqBody.uint64_src_uin.set(Long.parseLong(paramString2));
      localReqBody.uint32_src_term.set(paramInt1);
      localReqBody.uint32_aio_type.set(paramInt2);
      localReqBody.uint64_to_uin.set(Long.parseLong(paramString3));
      localReqBody.uint32_open_emotion.set(i);
      localReqBody.bytes_app_qua.set(ByteStringMicro.copyFromUtf8(AppSetting.e()));
      localReqBody.uint32_support_emotion.set(1);
      if (paramList != null)
      {
        paramString1 = new ArrayList();
        paramString2 = paramList.iterator();
        while (paramString2.hasNext()) {
          paramString1.add(ByteStringMicro.copyFromUtf8((String)paramString2.next()));
        }
        localReqBody.bytes_key_word.set(paramString1);
      }
      if (this.mCard != null) {
        localReqBody.uint32_age.set(this.mCard.age);
      } else {
        localReqBody.uint32_age.set(0);
      }
      return localReqBody;
    }
    finally {}
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public static boolean getRecStickerSwitch(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (sRecStickerSwitch == null)
    {
      paramContext = paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RECOMMENDED_STICKER_SWITCH");
      localStringBuilder.append(paramString);
      sRecStickerSwitch = Boolean.valueOf(paramContext.getBoolean(localStringBuilder.toString(), paramBoolean));
    }
    return sRecStickerSwitch.booleanValue();
  }
  
  public static String getStickerRecVersion(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  private int getcmShowIsEnable()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:806)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void handleLocalEmoticon(boolean paramBoolean, String paramString, BaseSessionInfo paramBaseSessionInfo)
  {
    this.stickerRecDataLocalList.clear();
    ArrayList localArrayList = new ArrayList();
    if ((paramBoolean) && (this.mStickerRecLocalEmoticonChangeListeners != null))
    {
      long l = System.currentTimeMillis();
      Iterator localIterator = this.mStickerRecLocalEmoticonChangeListeners.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IStickerRecLocalEmoticonHandleListener)localIterator.next();
        if (((IStickerRecLocalEmoticonHandleListener)localObject).a(this.mApp, paramString))
        {
          localObject = ((IStickerRecLocalEmoticonHandleListener)localObject).a(paramString, paramBaseSessionInfo);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            localArrayList.addAll((Collection)localObject);
          }
        }
      }
      paramString = SearchStickerRecEmoticonUtil.a(this.mApp, localArrayList);
      if ((paramString != null) && (!paramString.isEmpty())) {
        this.stickerRecDataLocalList.addAll(paramString);
      }
      int i = 0;
      while (i < this.stickerRecDataLocalList.size())
      {
        ((IStickerRecEmoticon)this.stickerRecDataLocalList.get(i)).a(this.mApp, i);
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("handleLocalEmoticon time = ");
        paramString.append(System.currentTimeMillis() - l);
        QLog.d("StickerRecManager", 2, paramString.toString());
      }
    }
  }
  
  private void handlePullPics(byte[] paramArrayOfByte, String paramString1, String paramString2, boolean paramBoolean, StickerRecommendSortEntity paramStickerRecommendSortEntity, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handlePullPics from : ");
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append(" | RecType=");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(" | aiotype = ");
          ((StringBuilder)localObject).append(paramInt2);
          QLog.d("StickerRecManager", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = new PicSearchSvr.RspBody();
        ((PicSearchSvr.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if (((PicSearchSvr.RspBody)localObject).int32_result.get() != 0)
        {
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("handleResponse response code error,result:");
            paramArrayOfByte.append(((PicSearchSvr.RspBody)localObject).int32_result.get());
            paramArrayOfByte.append(" message : ");
            paramArrayOfByte.append(((PicSearchSvr.RspBody)localObject).bytes_fail_msg.get().toStringUtf8());
            QLog.d("StickerRecManager", 2, paramArrayOfByte.toString());
          }
        }
        else
        {
          paramArrayOfByte = handleSearchEmptyImg(paramString1, paramString2, paramInt1, (PicSearchSvr.RspBody)localObject);
          if (paramArrayOfByte == null) {
            return;
          }
          paramArrayOfByte = fillData(paramInt1, (PicSearchSvr.RspBody)localObject, paramArrayOfByte);
          paramStickerRecommendSortEntity = sortData(paramArrayOfByte, paramStickerRecommendSortEntity);
          if (paramStickerRecommendSortEntity != null) {
            paramArrayOfByte = paramStickerRecommendSortEntity;
          }
          paramStickerRecommendSortEntity = perkData(paramArrayOfByte, paramInt2, paramBoolean, ((ISpriteUtil)QRoute.api(ISpriteUtil.class)).isCmShowKeywordAssociationActive(this.mApp));
          if (paramStickerRecommendSortEntity != null) {
            paramArrayOfByte = paramStickerRecommendSortEntity;
          }
          if ((this.stickerRecDataLocalList == null) || (this.stickerRecDataLocalList.isEmpty())) {
            break label361;
          }
          paramArrayOfByte = new ArrayList(paramArrayOfByte);
          paramArrayOfByte.addAll(0, this.stickerRecDataLocalList);
          this.stickerRecDataLocalList.clear();
          if (!"network".equals(paramString2)) {
            break label364;
          }
          paramString2 = ((PicSearchSvr.RspBody)localObject).bytes_rsp_other.get().toStringUtf8();
          onImgUpdated(paramString1, paramBoolean, paramInt1, paramArrayOfByte, paramString2);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, ThrowablesUtils.a(paramArrayOfByte));
        }
        return;
      }
      return;
      label361:
      continue;
      label364:
      paramString2 = "999";
    }
  }
  
  private void handlePullWords(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject1 = new PicSearchWordsSvr.RspBody();
      ((PicSearchWordsSvr.RspBody)localObject1).mergeFrom(paramArrayOfByte);
      if (((PicSearchWordsSvr.RspBody)localObject1).int32_result.get() != 0)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("handlePullWords response code error,result:");
        paramArrayOfByte.append(((PicSearchWordsSvr.RspBody)localObject1).int32_result.get());
        paramArrayOfByte.append(" message : ");
        paramArrayOfByte.append(((PicSearchWordsSvr.RspBody)localObject1).bytes_fail_msg.get());
        QLog.d("StickerRecManager", 2, paramArrayOfByte.toString());
        return;
      }
      paramArrayOfByte = ((PicSearchWordsSvr.RspBody)localObject1).words_msg.bytes_words_version.get().toStringUtf8();
      Object localObject2 = ((PicSearchWordsSvr.RspBody)localObject1).words_msg.bytes_words_md5.get().toStringUtf8();
      String str = ((PicSearchWordsSvr.RspBody)localObject1).words_msg.bytes_words_url.get().toStringUtf8();
      int i = ((PicSearchWordsSvr.RspBody)localObject1).words_msg.uint32_words_type.get();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("pull words resp:version=");
        ((StringBuilder)localObject1).append(paramArrayOfByte);
        ((StringBuilder)localObject1).append(" wordsMd5=");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" wordsUrl=");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(" wordsType=");
        ((StringBuilder)localObject1).append(i);
        QLog.d("StickerRecManager", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = getStickerRecVersion(this.mApp.getApp(), "words_version_key805_gray_one", this.mApp.getCurrentUin());
      if ((((String)localObject1).equals(paramArrayOfByte)) && (this.mEncodedBloomFile.exists()))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("not need pull words: localVersion=");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" server version=");
          ((StringBuilder)localObject2).append(paramArrayOfByte);
          QLog.d("StickerRecManager", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        updateWords(str, (String)localObject2, i, paramArrayOfByte);
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, ThrowablesUtils.a(paramArrayOfByte));
      }
    }
    return;
  }
  
  @Nullable
  private List<PicSearchSvr.ImgInfo> handleSearchEmptyImg(String paramString1, String paramString2, int paramInt, PicSearchSvr.RspBody paramRspBody)
  {
    paramRspBody = paramRspBody.rpt_msg_img_info.get();
    if ((paramRspBody != null) && (!paramRspBody.isEmpty())) {
      return paramRspBody;
    }
    if ("network".equals(paramString2)) {
      reportEmptyImg();
    }
    if (this.entityManager != null) {
      this.mDbHandler.post(new StickerRecManagerImpl.6(this, paramInt, paramString1));
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "handleResponse imgInfos is null or empty");
    }
    return null;
  }
  
  public static boolean isStickerPics(MessageForPic paramMessageForPic)
  {
    return (paramMessageForPic != null) && (paramMessageForPic.picExtraData != null) && ((paramMessageForPic.picExtraData.isStickerPics()) || (paramMessageForPic.picExtraData.isStickerAdPic()));
  }
  
  public static boolean isStickerRecFromLocal(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    return paramIStickerRecEmoticon.a();
  }
  
  public static boolean isStickerRecFromRemote(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    return isStickerRecFromLocal(paramIStickerRecEmoticon) ^ true;
  }
  
  private void onImgUpdated(String paramString1, boolean paramBoolean, int paramInt, List<IStickerRecEmoticon> paramList, String paramString2)
  {
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = this.imgUpdateListener;
      if (localObject1 != null)
      {
        ((IStickerRecManager.ImgUpdateListener)localObject1).onImgUpdated(paramList, paramString1, paramString2, 0, null);
        return;
      }
    }
    if (this.imgUpdateListener != null)
    {
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramInt == 1)
      {
        Object localObject3 = this.mApp;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ScenesRecommendManagerImpl.get((AppInterface)localObject3).findScenesRecItemByID(paramString1);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((ScenesRecommendItem)localObject3).b();
          }
        }
      }
      this.imgUpdateListener.onImgUpdated(paramList, paramString1, paramString2, paramInt, (String)localObject1);
    }
  }
  
  /* Error */
  private Object readObjectAbsPath(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 885	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 887	java/io/ObjectInputStream
    //   12: dup
    //   13: new 889	java/io/BufferedInputStream
    //   16: dup
    //   17: new 891	java/io/FileInputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 892	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 895	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: invokespecial 896	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: aload 4
    //   38: invokevirtual 899	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   41: astore 5
    //   43: aload 4
    //   45: invokevirtual 902	java/io/ObjectInputStream:close	()V
    //   48: aload 5
    //   50: areturn
    //   51: astore 5
    //   53: goto +50 -> 103
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_3
    //   59: goto +158 -> 217
    //   62: aconst_null
    //   63: astore 4
    //   65: aload 4
    //   67: astore_3
    //   68: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +15 -> 86
    //   74: aload 4
    //   76: astore_3
    //   77: ldc 45
    //   79: iconst_2
    //   80: ldc_w 904
    //   83: invokestatic 422	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload 4
    //   88: ifnull +126 -> 214
    //   91: aload 4
    //   93: invokevirtual 902	java/io/ObjectInputStream:close	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore 5
    //   100: aconst_null
    //   101: astore 4
    //   103: aload 4
    //   105: astore_3
    //   106: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +77 -> 186
    //   112: aload 4
    //   114: astore_3
    //   115: new 403	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   122: astore 6
    //   124: aload 4
    //   126: astore_3
    //   127: aload 6
    //   129: ldc_w 906
    //   132: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 4
    //   138: astore_3
    //   139: aload 6
    //   141: aload_1
    //   142: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 4
    //   148: astore_3
    //   149: aload 6
    //   151: ldc_w 908
    //   154: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 4
    //   160: astore_3
    //   161: aload 6
    //   163: aload 5
    //   165: invokevirtual 909	java/lang/Exception:toString	()Ljava/lang/String;
    //   168: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 4
    //   174: astore_3
    //   175: ldc 45
    //   177: iconst_2
    //   178: aload 6
    //   180: invokevirtual 420	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 422	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload 4
    //   188: astore_3
    //   189: aload 5
    //   191: instanceof 911
    //   194: istore_2
    //   195: aload 4
    //   197: ifnull +8 -> 205
    //   200: aload 4
    //   202: invokevirtual 902	java/io/ObjectInputStream:close	()V
    //   205: iload_2
    //   206: ifeq +8 -> 214
    //   209: aload_1
    //   210: invokestatic 917	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   213: pop
    //   214: aconst_null
    //   215: areturn
    //   216: astore_1
    //   217: aload_3
    //   218: ifnull +7 -> 225
    //   221: aload_3
    //   222: invokevirtual 902	java/io/ObjectInputStream:close	()V
    //   225: aload_1
    //   226: athrow
    //   227: astore_1
    //   228: goto -166 -> 62
    //   231: astore_1
    //   232: goto -167 -> 65
    //   235: astore_1
    //   236: aload 5
    //   238: areturn
    //   239: astore_1
    //   240: aconst_null
    //   241: areturn
    //   242: astore_3
    //   243: goto -38 -> 205
    //   246: astore_3
    //   247: goto -22 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	StickerRecManagerImpl
    //   0	250	1	paramString	String
    //   194	12	2	bool	boolean
    //   35	187	3	localObjectInputStream1	java.io.ObjectInputStream
    //   242	1	3	localIOException1	java.io.IOException
    //   246	1	3	localIOException2	java.io.IOException
    //   31	170	4	localObjectInputStream2	java.io.ObjectInputStream
    //   41	8	5	localObject	Object
    //   51	1	5	localException1	Exception
    //   98	139	5	localException2	Exception
    //   122	57	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   36	43	51	java/lang/Exception
    //   9	33	56	finally
    //   9	33	98	java/lang/Exception
    //   36	43	216	finally
    //   68	74	216	finally
    //   77	86	216	finally
    //   106	112	216	finally
    //   115	124	216	finally
    //   127	136	216	finally
    //   139	146	216	finally
    //   149	158	216	finally
    //   161	172	216	finally
    //   175	186	216	finally
    //   189	195	216	finally
    //   9	33	227	java/lang/OutOfMemoryError
    //   36	43	231	java/lang/OutOfMemoryError
    //   43	48	235	java/io/IOException
    //   91	96	239	java/io/IOException
    //   200	205	242	java/io/IOException
    //   221	225	246	java/io/IOException
  }
  
  private void renameFile(File paramFile1, File paramFile2)
  {
    if (paramFile2.exists()) {
      paramFile2.delete();
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      FileUtils.copyFile(paramFile1, paramFile2);
      paramFile1.delete();
    }
  }
  
  private void reportEmptyImg()
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecEmptyImg", false, 0L, 0L, null, "");
  }
  
  private void reportInitCost(boolean paramBoolean, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("param_succ_flag", localObject);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("");
    localHashMap.put("initTimeCost", ((StringBuilder)localObject).toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecInitCost", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public static void setMaxMatchLength(Context paramContext, String paramString, int paramInt)
  {
    sMaxMatchLength = Integer.valueOf(paramInt);
    paramContext = paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RECOMMENDED_STICKER_MAX_MATCH_LENGTH");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt).apply();
  }
  
  public static void setRecStickerSwitch(AppInterface paramAppInterface, boolean paramBoolean)
  {
    Object localObject = paramAppInterface.getApp();
    String str = paramAppInterface.getCurrentUin();
    sRecStickerSwitch = Boolean.valueOf(paramBoolean);
    if (sRecStickerSwitch.booleanValue()) {
      get(paramAppInterface).pullWords();
    }
    paramAppInterface = ((Context)localObject).getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RECOMMENDED_STICKER_SWITCH");
    ((StringBuilder)localObject).append(str);
    paramAppInterface.putBoolean(((StringBuilder)localObject).toString(), paramBoolean).apply();
  }
  
  public static void setUserConfigVersion(AppInterface paramAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramAppInterface.getApp().getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RECOMMENDED_STICKER_VERSION");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt).apply();
  }
  
  private List<IStickerRecEmoticon> sortData(List<IStickerRecEmoticon> paramList, StickerRecommendSortEntity paramStickerRecommendSortEntity)
  {
    int m;
    int k;
    label136:
    int j;
    label157:
    int i;
    int n;
    label247:
    int i1;
    if (paramStickerRecommendSortEntity != null)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateSort clicked=");
          ((StringBuilder)localObject).append(paramStickerRecommendSortEntity.clicked);
          ((StringBuilder)localObject).append(" exposed=");
          ((StringBuilder)localObject).append(paramStickerRecommendSortEntity.exposed);
          ((StringBuilder)localObject).append(" noExpose=");
          ((StringBuilder)localObject).append(paramStickerRecommendSortEntity.noExpose);
          QLog.i("StickerRecManager", 2, ((StringBuilder)localObject).toString());
        }
        localObject = paramStickerRecommendSortEntity.clickedList;
        i2 = 0;
        if (localObject == null) {
          break label481;
        }
        m = paramStickerRecommendSortEntity.clickedList.size();
        if (paramStickerRecommendSortEntity.noExposeList == null) {
          break label487;
        }
        k = paramStickerRecommendSortEntity.noExposeList.size();
        if (paramStickerRecommendSortEntity.exposedList == null) {
          break label493;
        }
        j = paramStickerRecommendSortEntity.exposedList.size();
        i3 = paramList.size();
        i = m + k + j;
        if (i3 != i)
        {
          if (!QLog.isColorLevel()) {
            break label499;
          }
          paramList = new StringBuilder();
          paramList.append("sort data:length is not equals. size=");
          paramList.append(i3);
          paramList.append(" sortSize=");
          paramList.append(i);
          QLog.i("StickerRecManager", 2, paramList.toString());
          return null;
        }
        localObject = new IStickerRecEmoticon[i3];
        n = 0;
        i = 0;
        if (n >= m) {
          break label513;
        }
        int i4 = ((Integer)paramStickerRecommendSortEntity.clickedList.get(n)).intValue();
        i1 = i;
        if (i4 >= i3) {
          break label501;
        }
        i1 = i;
        if (i >= i3) {
          break label501;
        }
        localObject[i] = ((IStickerRecEmoticon)paramList.get(i4));
        i1 = i + 1;
      }
      catch (Throwable paramList)
      {
        Object localObject;
        int i2;
        int i3;
        label315:
        QLog.e("StickerRecManager", 1, "sortData:", paramList);
      }
      n = i2;
      i1 = i;
      if (m < k)
      {
        i1 = ((Integer)paramStickerRecommendSortEntity.noExposeList.get(m)).intValue();
        n = i;
        if (i1 >= i3) {
          break label519;
        }
        n = i;
        if (i >= i3) {
          break label519;
        }
        localObject[i] = ((IStickerRecEmoticon)paramList.get(i1));
        n = i + 1;
        break label519;
      }
    }
    for (;;)
    {
      if (n < j)
      {
        k = ((Integer)paramStickerRecommendSortEntity.exposedList.get(n)).intValue();
        i = i1;
        if (k < i3)
        {
          i = i1;
          if (i1 < i3)
          {
            localObject[i1] = ((IStickerRecEmoticon)paramList.get(k));
            i = i1 + 1;
          }
        }
      }
      else
      {
        paramList = Arrays.asList((Object[])localObject);
        return paramList;
        return null;
        label481:
        m = 0;
        break;
        label487:
        k = 0;
        break label136;
        label493:
        j = 0;
        break label157;
        label499:
        return null;
        label501:
        n += 1;
        i = i1;
        break label247;
        label513:
        m = 0;
        break label315;
        label519:
        m += 1;
        i = n;
        break label315;
      }
      n += 1;
      i1 = i;
    }
  }
  
  public static String stringToUnicode(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\u");
      localStringBuilder.append(Integer.toHexString(j));
      localStringBuffer.append(localStringBuilder.toString());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private boolean unzip(File paramFile1, File paramFile2)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramFile2.getParent());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("temp");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      ((StringBuilder)localObject2).append(File.separator);
      ZipUtils.unZipFile(paramFile1, ((StringBuilder)localObject2).toString());
      paramFile1 = ((File)localObject1).listFiles();
      int j = paramFile1.length;
      int i = 0;
      while (i < j)
      {
        localObject1 = paramFile1[i];
        localObject2 = ((File)localObject1).getName();
        if ((((File)localObject1).isFile()) && (((String)localObject2).endsWith("json"))) {
          renameFile((File)localObject1, paramFile2);
        }
        i += 1;
      }
      return true;
    }
    catch (Exception paramFile1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("StickerRecManager", 2, "uncompress template zip file error", paramFile1);
      }
    }
    return false;
  }
  
  public static void updateEmotionRecSettingSwitch(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emotion_rec_setting_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public static void updateStickerRecVersion(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    paramContext.putString(localStringBuilder.toString(), paramString3);
    paramContext.commit();
  }
  
  private void updateWords(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (android.text.TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "updateWords fail: url is null.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "start download words");
    }
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = this.mWordsFile.getParentFile();
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new StickerRecManagerImpl.7(this, paramString2, bool, paramString3);
    ((HttpNetReq)localObject).mReqUrl = paramString1;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = this.mDownloadFile.getAbsolutePath();
    ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    try
    {
      paramString2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (AppInterface.class.isInstance(paramString2))
      {
        ((IHttpEngineService)((AppInterface)paramString2).getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("start download words, url: ");
          paramString2.append(paramString1);
          QLog.i("StickerRecManager", 2, paramString2.toString());
          return;
        }
      }
    }
    catch (Exception paramString1)
    {
      QLog.e("StickerRecManager", 1, "download follow words error", paramString1);
    }
  }
  
  private boolean validateAndUnzip(File paramFile1, File paramFile2, String paramString, boolean paramBoolean)
  {
    if (validateDownloadFile(paramFile1, paramString))
    {
      if (paramBoolean)
      {
        if (unzip(paramFile1, paramFile2))
        {
          paramFile1.delete();
          return true;
        }
      }
      else
      {
        renameFile(paramFile1, paramFile2);
        return true;
      }
    }
    else
    {
      paramFile1.delete();
      if (QLog.isColorLevel()) {
        QLog.e("StickerRecManager", 2, "downloadFile zip md5 is wrong");
      }
    }
    return false;
  }
  
  private boolean validateDownloadFile(File paramFile, String paramString)
  {
    if (!paramFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w("StickerRecManager", 2, "downloadFile zip file not exists");
      }
      return false;
    }
    try
    {
      paramFile = FileUtils.calcMd5(paramFile.getPath());
      return (!android.text.TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(paramFile));
    }
    catch (UnsatisfiedLinkError paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("StickerRecManager", 1, "calculate follow capture template zip md5 error", paramFile);
      }
    }
    return false;
  }
  
  /* Error */
  private void writeObjectAbsPath(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 885	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore_3
    //   13: new 1210	java/io/ObjectOutputStream
    //   16: dup
    //   17: new 1212	java/io/BufferedOutputStream
    //   20: dup
    //   21: new 1214	java/io/FileOutputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 1215	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   29: invokespecial 1218	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: invokespecial 1219	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore 4
    //   37: aload 4
    //   39: aload_2
    //   40: invokevirtual 1223	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   43: aload 4
    //   45: invokevirtual 1226	java/io/ObjectOutputStream:flush	()V
    //   48: aload 4
    //   50: invokevirtual 1227	java/io/ObjectOutputStream:close	()V
    //   53: return
    //   54: astore_1
    //   55: aload 4
    //   57: astore_3
    //   58: goto +113 -> 171
    //   61: astore_3
    //   62: aload 4
    //   64: astore_2
    //   65: aload_3
    //   66: astore 4
    //   68: goto +12 -> 80
    //   71: astore_1
    //   72: goto +99 -> 171
    //   75: astore 4
    //   77: aload 5
    //   79: astore_2
    //   80: aload_2
    //   81: astore_3
    //   82: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +71 -> 156
    //   88: aload_2
    //   89: astore_3
    //   90: new 403	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   97: astore 5
    //   99: aload_2
    //   100: astore_3
    //   101: aload 5
    //   103: ldc_w 1229
    //   106: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_2
    //   111: astore_3
    //   112: aload 5
    //   114: aload_1
    //   115: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_2
    //   120: astore_3
    //   121: aload 5
    //   123: ldc_w 908
    //   126: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_2
    //   131: astore_3
    //   132: aload 5
    //   134: aload 4
    //   136: invokevirtual 909	java/lang/Exception:toString	()Ljava/lang/String;
    //   139: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_2
    //   144: astore_3
    //   145: ldc 45
    //   147: iconst_2
    //   148: aload 5
    //   150: invokevirtual 420	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 422	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_2
    //   157: ifnull +13 -> 170
    //   160: aload_2
    //   161: invokevirtual 1227	java/io/ObjectOutputStream:close	()V
    //   164: return
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 1230	java/io/IOException:printStackTrace	()V
    //   170: return
    //   171: aload_3
    //   172: ifnull +15 -> 187
    //   175: aload_3
    //   176: invokevirtual 1227	java/io/ObjectOutputStream:close	()V
    //   179: goto +8 -> 187
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 1230	java/io/IOException:printStackTrace	()V
    //   187: aload_1
    //   188: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	StickerRecManagerImpl
    //   0	189	1	paramString	String
    //   0	189	2	paramObject	Object
    //   12	46	3	localObject1	Object
    //   61	5	3	localException1	Exception
    //   81	95	3	localObject2	Object
    //   35	32	4	localObject3	Object
    //   75	60	4	localException2	Exception
    //   9	140	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	48	54	finally
    //   37	48	61	java/lang/Exception
    //   13	37	71	finally
    //   82	88	71	finally
    //   90	99	71	finally
    //   101	110	71	finally
    //   112	119	71	finally
    //   121	130	71	finally
    //   132	143	71	finally
    //   145	156	71	finally
    //   13	37	75	java/lang/Exception
    //   48	53	165	java/io/IOException
    //   160	164	165	java/io/IOException
    //   175	179	182	java/io/IOException
  }
  
  public void addStickerRecLocalEmoticonChangeListener(IStickerRecLocalEmoticonHandleListener paramIStickerRecLocalEmoticonHandleListener)
  {
    if (paramIStickerRecLocalEmoticonHandleListener == null) {
      return;
    }
    if (this.mStickerRecLocalEmoticonChangeListeners == null) {
      this.mStickerRecLocalEmoticonChangeListeners = new ArrayList();
    }
    if (!this.mStickerRecLocalEmoticonChangeListeners.contains(paramIStickerRecLocalEmoticonHandleListener)) {
      this.mStickerRecLocalEmoticonChangeListeners.add(paramIStickerRecLocalEmoticonHandleListener);
    }
  }
  
  public boolean analyze(String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2, BaseSessionInfo paramBaseSessionInfo)
  {
    if (!hasInit())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "can't analyze, has not init");
      }
      return false;
    }
    try
    {
      String str2 = preProcessUsrText(paramString1);
      if ((!android.text.TextUtils.isEmpty(str2)) && (str2.length() <= this.maxMatchLength))
      {
        boolean bool = this.bloomFilter.contains(str2);
        String str1 = stringToUnicode(str2);
        if (!bool)
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("word : ");
            paramString2.append(str1);
            paramString2.append(" miss dict");
            QLog.d("StickerRecManager", 2, paramString2.toString());
          }
          if ((paramBoolean2) && (this.imgUpdateListener != null))
          {
            ThreadManager.getSubThreadHandler().post(new StickerRecManagerImpl.1(this, paramString1, paramBoolean2, paramBaseSessionInfo));
            return true;
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("word : ");
            localStringBuilder.append(str1);
            localStringBuilder.append(" in dict");
            QLog.d("StickerRecManager", 2, localStringBuilder.toString());
          }
          this.mDbHandler.post(new StickerRecManagerImpl.2(this, paramString1, paramBoolean2, paramBaseSessionInfo, str2, paramInt, paramBoolean1, paramString2));
          return true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "userTxt over maxMatchLength or empty");
        }
        return false;
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, ThrowablesUtils.a(paramString1));
      }
      return true;
    }
    return false;
  }
  
  public boolean analyze(String paramString, BaseSessionInfo paramBaseSessionInfo)
  {
    if (paramBaseSessionInfo != null) {
      return analyze(paramString, paramBaseSessionInfo.jdField_a_of_type_Int, paramBaseSessionInfo.jdField_a_of_type_JavaLangString, false, true, paramBaseSessionInfo);
    }
    return false;
  }
  
  public boolean analyzeForScenesMode(ScenesRecommendItem paramScenesRecommendItem, int paramInt, String paramString)
  {
    if (!hasInit())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "can't analyzeForScenesMode, has not init");
      }
      return false;
    }
    if (paramScenesRecommendItem != null) {}
    try
    {
      if ((paramScenesRecommendItem.a() != null) && (!StringUtil.a(paramScenesRecommendItem.a())))
      {
        String str = paramScenesRecommendItem.a();
        this.mDbHandler.post(new StickerRecManagerImpl.3(this, str, paramInt, paramString, paramScenesRecommendItem));
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "analyzeForScenesMode data is empty");
        }
        return false;
      }
    }
    catch (Exception paramScenesRecommendItem)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, ThrowablesUtils.a(paramScenesRecommendItem));
      }
    }
    return true;
  }
  
  public boolean analyzeFromQzone(String paramString1, int paramInt, String paramString2)
  {
    return analyze(paramString1, paramInt, paramString2, true, false, null);
  }
  
  public void clearOverdueStickerCache()
  {
    if (this.entityManager == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "clearOverdueStickerCache");
    }
    this.mDbHandler.post(new StickerRecManagerImpl.9(this));
  }
  
  public void collectReportData(List<IStickerRecEmoticon> paramList, String paramString1, String paramString2, int paramInt)
  {
    if (paramList.size() > 0)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)paramList.next();
        if (localIStickerRecEmoticon != null) {
          if (localIStickerRecEmoticon.c()) {
            localArrayList1.add(localIStickerRecEmoticon);
          } else {
            localArrayList2.add(localIStickerRecEmoticon);
          }
        }
      }
      paramList = new StickerReportItem();
      paramList.jdField_a_of_type_JavaLangString = paramString1;
      paramList.jdField_b_of_type_JavaLangString = paramString2;
      paramList.jdField_a_of_type_JavaUtilList = localArrayList1;
      paramList.jdField_b_of_type_JavaUtilList = localArrayList2;
      paramList.jdField_a_of_type_Int = paramInt;
      this.mStickerReportItems.add(paramList);
    }
  }
  
  public void deletePicCache()
  {
    Object localObject = new File(StickerRecConstants.jdField_a_of_type_JavaLangString);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].delete();
          i += 1;
        }
      }
    }
  }
  
  public String getCurrentText()
  {
    try
    {
      String str = this.mCurrentText;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getUserConfigVersion(AppInterface paramAppInterface)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RECOMMENDED_STICKER_VERSION");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public void handleDebugDataResponse(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    try
    {
      cacheResInDb(paramArrayOfByte, paramString, paramInt);
      handlePullPics(paramArrayOfByte, paramString, "network", false, null, paramInt, 1);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void handleRecommendedStickerConfig(AppInterface paramAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    int i = paramConfig.version.get();
    BaseApplication localBaseApplication = paramAppInterface.getApp();
    String str = paramAppInterface.getCurrentUin();
    int j = getUserConfigVersion(paramAppInterface);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecommendedSticker received Config remote version:");
      localStringBuilder.append(i);
      localStringBuilder.append(" localVersion= ");
      localStringBuilder.append(j);
      QLog.d("StickerRecManager", 2, localStringBuilder.toString());
    }
    if (i != j)
    {
      paramConfig = QConfigServlet.a(paramConfig, j, paramInt);
      if (!android.text.TextUtils.isEmpty(paramConfig)) {
        try
        {
          paramConfig = new JSONObject(paramConfig);
          if ((paramConfig.has("useRecommendedSticker")) && (paramConfig.has("maxMatchLength")))
          {
            setRecStickerSwitch(paramAppInterface, paramConfig.getBoolean("useRecommendedSticker"));
            setMaxMatchLength(localBaseApplication, str, paramConfig.getInt("maxMatchLength"));
          }
          else
          {
            setRecStickerSwitch(paramAppInterface, false);
          }
        }
        catch (Exception paramConfig)
        {
          setRecStickerSwitch(paramAppInterface, false);
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, paramConfig.getMessage());
          }
        }
      }
      setUserConfigVersion(paramAppInterface, i);
    }
  }
  
  public void handleResponse(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null)) {
      try
      {
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          int i = paramFromServiceMsg.getWupBuffer().length - 4;
          Object localObject = new byte[i];
          PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramFromServiceMsg.putWupBuffer((byte[])localObject);
          localObject = paramFromServiceMsg.getServiceCmd();
          String str = paramIntent.getStringExtra("USER_KEYWORD");
          i = paramIntent.getIntExtra("request_aio_type", 4);
          try
          {
            paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
            if (paramFromServiceMsg == null) {
              return;
            }
            if ("PicSearchWordsSvr.PullWords".equals(localObject))
            {
              handlePullWords(paramFromServiceMsg);
            }
            else if ("PicSearchSvr.PullPics".equals(localObject))
            {
              cacheResInDb(paramFromServiceMsg, str, 0);
              handlePullPics(paramFromServiceMsg, str, "network", paramIntent.getBooleanExtra("fromQzone", false), null, 0, i);
            }
            else if ("SceneFaceRec.PullFaces".equals(localObject))
            {
              cacheResInDb(paramFromServiceMsg, str, 1);
              handlePullPics(paramFromServiceMsg, str, "network", paramIntent.getBooleanExtra("fromQzone", false), null, 1, i);
            }
            else
            {
              ((IIceBreakingMsg)QRoute.api(IIceBreakingMsg.class)).handleGetIceBreakHotPicResponse(this.mApp, paramFromServiceMsg, (String)localObject);
            }
          }
          catch (Exception paramIntent)
          {
            if (!QLog.isColorLevel()) {
              break label267;
            }
          }
          QLog.d("StickerRecManager", 2, ThrowablesUtils.a(paramIntent));
        }
        else
        {
          QLog.d("StickerRecManager", 1, String.format("result_code = %s, cmd = %s", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()), paramFromServiceMsg.getServiceCmd() }));
        }
        label267:
        return;
      }
      finally {}
    }
  }
  
  public boolean hasInit()
  {
    try
    {
      boolean bool = this.hasInit;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void init()
  {
    if (hasInit())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "init has executed");
      }
      return;
    }
    long l1;
    try
    {
      l1 = SystemClock.elapsedRealtime();
      try
      {
        if (FileUtils.fileExists(this.mEncodedBloomFile.getAbsolutePath()))
        {
          this.bloomFilter = ((BloomFilter)readObjectAbsPath(this.mEncodedBloomFile.getAbsolutePath()));
          if (this.bloomFilter != null)
          {
            Object localObject1;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("init bloomFilter, version : ");
              ((StringBuilder)localObject1).append(this.bloomFilter.version);
              QLog.d("StickerRecManager", 2, ((StringBuilder)localObject1).toString());
            }
            long l2 = getLastTimeRemoveEmoticonPackage(this.mApp.getApp(), this.mApp.getCurrentUin());
            if ((FileUtils.fileExists(this.mLocalWordsFile.getAbsolutePath())) && ((l2 == 0L) || (System.currentTimeMillis() - l2 < 86400000L)))
            {
              this.mLocalKeywordsSet = ((HashSet)readObjectAbsPath(this.mLocalWordsFile.getAbsolutePath()));
              if (this.mLocalKeywordsSet == null) {
                FileUtil.c(this.mLocalWordsFile.getAbsolutePath());
              }
            }
            else
            {
              EmotionSharedPreUtils.a(this.mApp.getApp(), this.mApp.getCurrentUin(), 0L);
              localObject1 = new HashSet();
              Object localObject2 = this.emoticonManager.queryBigEmoticonsFromDB();
              List localList = this.emoticonManager.getTabCache();
              if (localObject2 != null)
              {
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  Emoticon localEmoticon = (Emoticon)((Iterator)localObject2).next();
                  if (localList.isEmpty()) {
                    ((HashSet)localObject1).add(localEmoticon.name);
                  } else if (localList.contains(localEmoticon.epId)) {
                    ((HashSet)localObject1).add(localEmoticon.name);
                  }
                }
              }
              if (!((HashSet)localObject1).isEmpty())
              {
                FileUtil.c(this.mLocalWordsFile.getAbsolutePath());
                writeObjectAbsPath(this.mLocalWordsFile.getAbsolutePath(), localObject1);
              }
              this.mLocalKeywordsSet = ((HashSet)localObject1);
            }
            updateKeywordForCameraEmotion();
            updateKeywordForFavEmotion();
            this.maxMatchLength = getMaxMatchLength(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), 6);
            this.mCard = ((IProfileCardUtil)QRoute.api(IProfileCardUtil.class)).findFriendCardByUin(this.mApp);
            this.hasInit = true;
            l2 = SystemClock.elapsedRealtime() - l1;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("StickerRecManager init time cost : ");
              ((StringBuilder)localObject1).append(l2);
              QLog.d("StickerRecManager", 2, ((StringBuilder)localObject1).toString());
            }
            reportInitCost(true, l2);
            return;
          }
          throw new IllegalStateException("words file read error");
        }
        throw new IllegalStateException("words file not exist");
      }
      catch (Exception localException1) {}
      this.hasInit = false;
    }
    catch (Exception localException2)
    {
      l1 = 0L;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("StickerRecManager", 2, ThrowablesUtils.a(localException2));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StickerRecManager error init time cost : ");
      localStringBuilder.append(SystemClock.elapsedRealtime() - l1);
      QLog.d("StickerRecManager", 2, localStringBuilder.toString());
    }
    reportInitCost(false, SystemClock.elapsedRealtime() - l1);
  }
  
  public void initDir()
  {
    try
    {
      File localFile = new File(getDataDir(), "words");
      this.mDownloadFile = new File(getDataDir(), "words.zip");
      this.mWordsFile = new File(localFile, "words.json");
      this.mEncodedBloomFile = new File(localFile, "encodedBloom.bin");
      this.mLocalWordsFile = new File(localFile, "local_words.bin");
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  protected void initRecSwitch(Context paramContext, String paramString)
  {
    try
    {
      this.emotionRecSettingSwitch = getEmotionRecSettingSwitch(paramContext, paramString);
      return;
    }
    catch (NullPointerException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public boolean isEmotionRecSettingOpen()
  {
    return this.emotionRecSettingSwitch;
  }
  
  public boolean isHandleKeyword(String paramString)
  {
    if (paramString != null)
    {
      HashSet localHashSet = this.mLocalKeywordsSet;
      if (localHashSet != null) {
        return localHashSet.contains(paramString);
      }
    }
    return false;
  }
  
  public Collection<String> loadKeywordForCameraEmotion()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = ((ICameraEmotionRoamingDBManagerService)this.mApp.getRuntimeService(ICameraEmotionRoamingDBManagerService.class, "")).getEmoticonDataList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
        if (("normal".equals(localCameraEmotionData.RomaingType)) && (!android.text.TextUtils.isEmpty(localCameraEmotionData.strContext))) {
          localHashSet.add(preProcessUsrTextUseLocalSearch(localCameraEmotionData.strContext));
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadKeywordForCameraEmotion size: ");
      ((StringBuilder)localObject).append(localHashSet.size());
      QLog.d("StickerRecManager", 2, ((StringBuilder)localObject).toString());
    }
    return localHashSet;
  }
  
  public Collection<String> loadKeywordForFavEmotion()
  {
    HashSet localHashSet = new HashSet();
    Object localObject1 = (IEmoticonManagerService)this.mApp.getRuntimeService(IEmoticonManagerService.class, "");
    Object localObject2 = ((IFavroamingDBManagerService)this.mApp.getRuntimeService(IFavroamingDBManagerService.class, "")).getEmoticonDataList();
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (CustomEmotionData)((Iterator)localObject2).next();
        if (("isUpdate".equals(((CustomEmotionData)localObject3).RomaingType)) || ("needDownload".equals(((CustomEmotionData)localObject3).RomaingType)) || ("overflow".equals(((CustomEmotionData)localObject3).RomaingType)) || ("overflow_downloaded".equals(((CustomEmotionData)localObject3).RomaingType))) {
          if (!android.text.TextUtils.isEmpty(((CustomEmotionData)localObject3).modifyWord))
          {
            localHashSet.add(preProcessUsrTextUseLocalSearch(((CustomEmotionData)localObject3).modifyWord));
          }
          else if (!android.text.TextUtils.isEmpty(((CustomEmotionData)localObject3).ocrWord))
          {
            localHashSet.add(preProcessUsrTextUseLocalSearch(((CustomEmotionData)localObject3).ocrWord));
          }
          else if (((CustomEmotionData)localObject3).isMarkFace)
          {
            localObject3 = ((IEmoticonManagerService)localObject1).syncFindEmoticonById(((CustomEmotionData)localObject3).emoPath, ((CustomEmotionData)localObject3).eId);
            if ((localObject3 != null) && (!android.text.TextUtils.isEmpty(((Emoticon)localObject3).name))) {
              localHashSet.add(((Emoticon)localObject3).name);
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadKeywordForFavEmotion size: ");
      ((StringBuilder)localObject1).append(localHashSet.size());
      QLog.d("StickerRecManager", 2, ((StringBuilder)localObject1).toString());
    }
    return localHashSet;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((BaseQQAppInterface)paramAppRuntime);
    this.entityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    this.emoticonManager = ((IEmoticonManagerService)this.mApp.getRuntimeService(IEmoticonManagerService.class, ""));
    initRecSwitch(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    initDir();
    paramAppRuntime = this.mStickerRecLocalEmoticonChangeListeners;
    if (paramAppRuntime != null) {
      paramAppRuntime.clear();
    }
    addStickerRecLocalEmoticonChangeListener(new StickerRecLocalEmoticonHandleListener(this.mApp));
    this.mCameraEmoticonHandleListener = new StickerRecCameraEmoticonHandleListener(this.mApp);
    addStickerRecLocalEmoticonChangeListener(this.mCameraEmoticonHandleListener);
    this.mFavEmoticonHandleListener = new StickerRecFavoriteEmoHandleListener(this.mApp);
    addStickerRecLocalEmoticonChangeListener(this.mFavEmoticonHandleListener);
    addStickerRecLocalEmoticonChangeListener(new StickerRecAdEmotionHandlerListener(this.mApp));
  }
  
  public void onDestroy() {}
  
  public List<IStickerRecEmoticon> perkData(List<IStickerRecEmoticon> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() == 0) {
          return null;
        }
        paramList.size();
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          IStickerRecEmoticon localIStickerRecEmoticon = (IStickerRecEmoticon)paramList.next();
          if ((!(localIStickerRecEmoticon instanceof StickerRecData)) || (((StickerRecData)localIStickerRecEmoticon).e() != 3) || ((paramBoolean2) && (!paramBoolean1) && (paramInt != 4))) {
            localArrayList.add(localIStickerRecEmoticon);
          }
        }
        return localArrayList;
      }
      catch (Exception paramList)
      {
        QLog.e("StickerRecManager", 1, "perkData has exception:", paramList);
      }
    }
    return null;
  }
  
  public String preProcessUsrText(String paramString)
  {
    return com.tencent.mobileqq.text.TextUtils.cToe(StringUtil.c(com.tencent.mobileqq.text.TextUtils.emoticonToTextWithoutSysEmotion(paramString)).toLowerCase());
  }
  
  public String preProcessUsrTextUseLocalSearch(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return com.tencent.mobileqq.text.TextUtils.cToe(StringUtil.c(com.tencent.mobileqq.text.TextUtils.emoticonToTextWithoutSysEmotion(paramString)));
  }
  
  public void pullWords()
  {
    initDir();
    ThreadManager.excute(new StickerRecManagerImpl.4(this), 128, null, true);
  }
  
  public void reportEvent(List<StickerReportItem> paramList, boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        Object localObject4 = (StickerReportItem)localIterator1.next();
        if (localObject4 != null)
        {
          String str = ((StickerReportItem)localObject4).jdField_a_of_type_JavaLangString;
          Object localObject2 = ((StickerReportItem)localObject4).jdField_a_of_type_JavaUtilList;
          Object localObject6 = new StringBuilder();
          Object localObject5 = new StringBuilder();
          if (paramBoolean)
          {
            if (paramInt == 0) {
              paramList = "c2c";
            } else if (paramInt == 1) {
              paramList = "group";
            } else if (paramInt == 3000) {
              paramList = "discuss";
            } else if (paramInt == 11000) {
              paramList = "qzone";
            } else {
              paramList = "other";
            }
          }
          else {
            paramList = "";
          }
          Object localObject1 = null;
          Iterator localIterator2 = ((List)localObject2).iterator();
          Object localObject3;
          while (localIterator2.hasNext())
          {
            localObject3 = (IStickerRecEmoticon)localIterator2.next();
            ((IStickerRecEmoticon)localObject3).b(System.currentTimeMillis());
            if (((IStickerRecEmoticon)localObject3).c() != null)
            {
              localObject2 = ((IStickerRecEmoticon)localObject3).d();
              if (!android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
                ((StringBuilder)localObject6).append((String)localObject2);
              }
              ((StringBuilder)localObject6).append(((IStickerRecEmoticon)localObject3).c());
              ((StringBuilder)localObject6).append(";");
              if (((IStickerRecEmoticon)localObject3).a() != null)
              {
                ((StringBuilder)localObject5).append(((IStickerRecEmoticon)localObject3).a());
                ((StringBuilder)localObject5).append(";");
              }
              localObject2 = localObject1;
              if (((IStickerRecEmoticon)localObject3).b()) {
                localObject2 = localObject3;
              }
              localObject1 = localObject2;
              if (((IStickerRecEmoticon)localObject3).a() != 0L)
              {
                StickerRecReport.a(true, str, paramInt, paramString, (IStickerRecEmoticon)localObject3);
                localObject1 = localObject2;
              }
            }
          }
          localObject6 = ((StringBuilder)localObject6).toString();
          localObject5 = ((StringBuilder)localObject5).toString();
          long l = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
          if (((StickerReportItem)localObject4).jdField_a_of_type_Int == 1)
          {
            localObject2 = new ScenesRecReportData();
            ((ScenesRecReportData)localObject2).l = "dc05550";
            ((ScenesRecReportData)localObject2).c = str;
            ((ScenesRecReportData)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l);
            ((ScenesRecReportData)localObject2).jdField_b_of_type_JavaLangString = paramString;
            ((ScenesRecReportData)localObject2).d = paramList;
            paramList = (List<StickerReportItem>)localObject2;
          }
          else
          {
            localObject2 = new StickerRecReportData();
            ((StickerRecReportData)localObject2).l = "dc04577";
            ((StickerRecReportData)localObject2).jdField_b_of_type_JavaLangString = str;
            if (QLog.isColorLevel()) {
              ((StickerRecReportData)localObject2).jdField_b_of_type_JavaLangString = stringToUnicode(((StickerRecReportData)localObject2).jdField_b_of_type_JavaLangString);
            }
            ((StickerRecReportData)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l);
            ((StickerRecReportData)localObject2).d = paramString;
            ((StickerRecReportData)localObject2).c = paramList;
            paramList = (List<StickerReportItem>)localObject2;
          }
          paramList.k = ((StickerReportItem)localObject4).jdField_b_of_type_JavaLangString;
          paramList.e = String.valueOf(AppSetting.a());
          if (localObject1 != null)
          {
            localObject3 = ((IStickerRecEmoticon)localObject1).c();
            localObject4 = ((IStickerRecEmoticon)localObject1).d();
            localObject2 = localObject3;
            if (!android.text.TextUtils.isEmpty((CharSequence)localObject4))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject4);
              ((StringBuilder)localObject2).append((String)localObject3);
              localObject2 = ((StringBuilder)localObject2).toString();
            }
            paramList.h = ((String)localObject2);
            paramList.i = ((IStickerRecEmoticon)localObject1).a();
            StickerRecReport.a(false, str, paramInt, paramString, (IStickerRecEmoticon)localObject1);
          }
          paramList.f = ((String)localObject6);
          paramList.g = ((String)localObject5);
          paramList.j = "android";
          localObject2 = paramList.a();
          localObject1 = new NewIntent(this.mApp.getApp(), StickerRecServlet.class);
          ((NewIntent)localObject1).putExtra("key_cmd", "MQInference.CommonReport");
          ((NewIntent)localObject1).putExtra("key_body", WupUtil.a(((JSONObject)localObject2).toString().getBytes()));
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("report StickerRecReport content:");
            ((StringBuilder)localObject2).append(paramList.a().toString());
            QLog.d("StickerRecManager", 2, ((StringBuilder)localObject2).toString());
          }
          this.mApp.startServlet((NewIntent)localObject1);
        }
      }
    }
  }
  
  public void sendPullPicsRequest(String paramString1, int paramInt1, int paramInt2, String paramString2, List<String> paramList)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(SystemClock.uptimeMillis());
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = getPullPicsRequestBody((String)localObject1, paramString1, paramInt1, paramInt2, paramString2, paramList).toByteArray();
      Object localObject3 = ByteBuffer.allocate(localObject2.length + 4);
      ((ByteBuffer)localObject3).putInt(localObject2.length + 4).put((byte[])localObject2);
      localObject3 = ((ByteBuffer)localObject3).array();
      localObject2 = new NewIntent(this.mApp.getApp(), StickerRecServlet.class);
      ((NewIntent)localObject2).putExtra("key_body", (byte[])localObject3);
      ((NewIntent)localObject2).putExtra("key_cmd", "PicSearchSvr.PullPics");
      boolean bool = false;
      paramList = (String)paramList.get(0);
      ((NewIntent)localObject2).putExtra("USER_KEYWORD", paramList);
      if (paramInt1 == 4) {
        bool = true;
      }
      ((NewIntent)localObject2).putExtra("fromQzone", bool);
      ((NewIntent)localObject2).putExtra("request_aio_type", paramInt2);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("send pull pics args:sessionId = ");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" uin=");
        ((StringBuilder)localObject3).append(paramString1);
        ((StringBuilder)localObject3).append(" termType=");
        ((StringBuilder)localObject3).append(paramInt1);
        ((StringBuilder)localObject3).append(" aioType : ");
        ((StringBuilder)localObject3).append(paramInt2);
        ((StringBuilder)localObject3).append(" toUin : ");
        ((StringBuilder)localObject3).append(paramString2);
        ((StringBuilder)localObject3).append("  keyword: ");
        ((StringBuilder)localObject3).append(stringToUnicode(paramList));
        QLog.d("StickerRecManager", 2, ((StringBuilder)localObject3).toString());
      }
      this.mApp.startServlet((NewIntent)localObject2);
      return;
    }
    finally {}
  }
  
  public void sendPullWordsRequest(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject1 = this.mApp;
      if (localObject1 == null) {
        return;
      }
      if (!StringUtil.c(paramString))
      {
        QLog.e("StickerRecManager", 2, " fromUin is invalid!!");
        return;
      }
      localObject1 = new PicSearchWordsSvr.ReqBody();
      ((PicSearchWordsSvr.ReqBody)localObject1).setHasFlag(true);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(SystemClock.uptimeMillis());
      localObject2 = ((StringBuilder)localObject2).toString();
      String str1 = String.valueOf(AppSetting.a());
      String str2 = ApkUtils.a(this.mApp.getApp());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pull words args:sessionId = ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" uin=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" termType=");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" appId=");
        localStringBuilder.append(str1);
        localStringBuilder.append(" appVersion=");
        localStringBuilder.append(str2);
        localStringBuilder.append(" gender=");
        localStringBuilder.append(paramInt2);
        QLog.d("StickerRecManager", 2, localStringBuilder.toString());
      }
      ((PicSearchWordsSvr.ReqBody)localObject1).bytes_session_id.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      ((PicSearchWordsSvr.ReqBody)localObject1).uint64_src_uin.set(Long.parseLong(paramString));
      ((PicSearchWordsSvr.ReqBody)localObject1).uint32_src_term.set(paramInt1);
      ((PicSearchWordsSvr.ReqBody)localObject1).bytes_appid.set(ByteStringMicro.copyFromUtf8(str1));
      ((PicSearchWordsSvr.ReqBody)localObject1).bytes_version.set(ByteStringMicro.copyFromUtf8(str2));
      ((PicSearchWordsSvr.ReqBody)localObject1).uin32_gender.set(paramInt2);
      ((PicSearchWordsSvr.ReqBody)localObject1).uint32_age.set(paramInt3);
      paramString = ((PicSearchWordsSvr.ReqBody)localObject1).toByteArray();
      localObject1 = ByteBuffer.allocate(paramString.length + 4);
      ((ByteBuffer)localObject1).putInt(paramString.length + 4).put(paramString);
      paramString = ((ByteBuffer)localObject1).array();
      localObject1 = new NewIntent(this.mApp.getApp(), StickerRecServlet.class);
      ((NewIntent)localObject1).putExtra("key_body", paramString);
      ((NewIntent)localObject1).putExtra("key_cmd", "PicSearchWordsSvr.PullWords");
      this.mApp.startServlet((NewIntent)localObject1);
      return;
    }
    finally {}
  }
  
  public void sendScenesPullPicsRequest(String paramString1, int paramInt1, int paramInt2, String paramString2, ScenesRecommendItem paramScenesRecommendItem)
  {
    if (paramScenesRecommendItem != null) {}
    for (;;)
    {
      try
      {
        if (paramScenesRecommendItem.a() != null)
        {
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append(SystemClock.uptimeMillis());
          localObject1 = ((StringBuilder)localObject1).toString();
          Object localObject2 = getPullPicsRequestBody((String)localObject1, paramString1, paramInt1, paramInt2, paramString2, paramScenesRecommendItem.a()).toByteArray();
          Object localObject3 = ByteBuffer.allocate(localObject2.length + 4);
          ((ByteBuffer)localObject3).putInt(localObject2.length + 4).put((byte[])localObject2);
          localObject3 = ((ByteBuffer)localObject3).array();
          localObject2 = new NewIntent(this.mApp.getApp(), StickerRecServlet.class);
          ((NewIntent)localObject2).putExtra("key_body", (byte[])localObject3);
          ((NewIntent)localObject2).putExtra("key_cmd", "SceneFaceRec.PullFaces");
          paramScenesRecommendItem = paramScenesRecommendItem.a();
          ((NewIntent)localObject2).putExtra("REQUEST_SCENES_ID", paramScenesRecommendItem);
          ((NewIntent)localObject2).putExtra("USER_KEYWORD", paramScenesRecommendItem);
          if (paramInt1 != 4) {
            break label348;
          }
          bool = true;
          ((NewIntent)localObject2).putExtra("fromQzone", bool);
          ((NewIntent)localObject2).putExtra("request_aio_type", paramInt2);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("send pull scenes pics args:sessionId = ");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(" uin=");
            ((StringBuilder)localObject3).append(paramString1);
            ((StringBuilder)localObject3).append(" termType=");
            ((StringBuilder)localObject3).append(paramInt1);
            ((StringBuilder)localObject3).append(" aioType : ");
            ((StringBuilder)localObject3).append(paramInt2);
            ((StringBuilder)localObject3).append(" toUin : ");
            ((StringBuilder)localObject3).append(paramString2);
            ((StringBuilder)localObject3).append("  scenesID: ");
            ((StringBuilder)localObject3).append(paramScenesRecommendItem);
            QLog.d("StickerRecManager", 2, ((StringBuilder)localObject3).toString());
          }
          this.mApp.startServlet((NewIntent)localObject2);
          return;
        }
      }
      finally {}
      return;
      label348:
      boolean bool = false;
    }
  }
  
  public void setCurrentText(String paramString)
  {
    try
    {
      this.mCurrentText = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setImgUpdateListener(IStickerRecManager.ImgUpdateListener paramImgUpdateListener)
  {
    this.imgUpdateListener = paramImgUpdateListener;
  }
  
  public void showLocalEmo(String paramString, boolean paramBoolean, BaseSessionInfo paramBaseSessionInfo)
  {
    paramString = preProcessUsrTextUseLocalSearch(paramString);
    handleLocalEmoticon(paramBoolean, paramString, paramBaseSessionInfo);
    if ((this.imgUpdateListener != null) && (!this.stickerRecDataLocalList.isEmpty())) {
      this.imgUpdateListener.onImgUpdated(this.stickerRecDataLocalList, paramString, "999", 0, null);
    }
  }
  
  public void syncAddLocalEmoticonKeywords(Collection<String> paramCollection)
  {
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      if (this.mLocalKeywordsSet == null) {
        return;
      }
      try
      {
        this.mLocalKeywordsSet.addAll(paramCollection);
        writeObjectAbsPath(this.mLocalWordsFile.getAbsolutePath(), this.mLocalKeywordsSet);
        return;
      }
      finally {}
    }
  }
  
  public void unInit()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "unInit executed");
    }
    this.bloomFilter = null;
    this.maxMatchLength = 6;
    this.mCard = null;
    this.hasInit = false;
    this.mLocalKeywordsSet = null;
  }
  
  public void updateEmotionRecSetting(boolean paramBoolean)
  {
    this.emotionRecSettingSwitch = paramBoolean;
    updateEmotionRecSettingSwitch(BaseApplication.getContext(), this.mApp.getCurrentUin(), paramBoolean);
  }
  
  public void updateKeywordForCameraEmotion()
  {
    StickerRecCameraEmoticonHandleListener localStickerRecCameraEmoticonHandleListener = this.mCameraEmoticonHandleListener;
    if (localStickerRecCameraEmoticonHandleListener == null) {
      return;
    }
    localStickerRecCameraEmoticonHandleListener.a();
  }
  
  public void updateKeywordForFavEmotion()
  {
    StickerRecFavoriteEmoHandleListener localStickerRecFavoriteEmoHandleListener = this.mFavEmoticonHandleListener;
    if (localStickerRecFavoriteEmoHandleListener == null) {
      return;
    }
    localStickerRecFavoriteEmoHandleListener.a();
  }
  
  public void updateSort(BaseSessionInfo paramBaseSessionInfo)
  {
    Object localObject1 = new ArrayList(this.mStickerReportItems);
    if (paramBaseSessionInfo == null) {
      reportEvent((List)localObject1, false, 0, null);
    } else {
      reportEvent((List)localObject1, true, paramBaseSessionInfo.jdField_a_of_type_Int, paramBaseSessionInfo.jdField_a_of_type_JavaLangString);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (StickerReportItem)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        Object localObject3 = ((StickerReportItem)localObject2).jdField_a_of_type_JavaLangString;
        int i = ((StickerReportItem)localObject2).jdField_a_of_type_Int;
        if (i == 1) {
          paramBaseSessionInfo = (StickerRecommendSortEntity)this.entityManager.find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[] { localObject3 });
        } else {
          paramBaseSessionInfo = (StickerRecommendSortEntity)this.entityManager.find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[] { localObject3 });
        }
        Object localObject4;
        if (paramBaseSessionInfo != null)
        {
          paramBaseSessionInfo.convertToList();
          localObject2 = ((StickerReportItem)localObject2).jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (IStickerRecEmoticon)((Iterator)localObject2).next();
            if (!((IStickerRecEmoticon)localObject3).a())
            {
              localObject3 = (StickerRecData)localObject3;
              localObject4 = Integer.valueOf(((StickerRecData)localObject3).d());
              if (((StickerRecData)localObject3).b())
              {
                if (paramBaseSessionInfo.clickedList.contains(localObject4)) {
                  paramBaseSessionInfo.removeClicked((Integer)localObject4);
                }
                paramBaseSessionInfo.addClicked((Integer)localObject4);
              }
              else if (!paramBaseSessionInfo.exposedList.contains(localObject4))
              {
                paramBaseSessionInfo.addExposed((Integer)localObject4);
              }
              paramBaseSessionInfo.removeNoExpose((Integer)localObject4);
            }
          }
          paramBaseSessionInfo.exposedList.removeAll(paramBaseSessionInfo.clickedList);
          if ((paramBaseSessionInfo.noExposeList != null) && (paramBaseSessionInfo.noExposeList.size() == 0))
          {
            localObject2 = paramBaseSessionInfo.noExposeList;
            paramBaseSessionInfo.noExposeList = paramBaseSessionInfo.exposedList;
            paramBaseSessionInfo.exposedList = ((List)localObject2);
          }
          paramBaseSessionInfo.convertToString();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("updateSort clicked=");
            ((StringBuilder)localObject2).append(paramBaseSessionInfo.clicked);
            ((StringBuilder)localObject2).append(" exposed=");
            ((StringBuilder)localObject2).append(paramBaseSessionInfo.exposed);
            ((StringBuilder)localObject2).append(" noExpose=");
            ((StringBuilder)localObject2).append(paramBaseSessionInfo.noExpose);
            QLog.i("StickerRecManager", 2, ((StringBuilder)localObject2).toString());
          }
          paramBaseSessionInfo.recommendType = i;
          this.entityManager.update(paramBaseSessionInfo);
        }
        else
        {
          paramBaseSessionInfo = new StickerRecommendSortEntity((String)localObject3);
          localObject3 = ((StickerReportItem)localObject2).jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (IStickerRecEmoticon)((Iterator)localObject3).next();
            if (!((IStickerRecEmoticon)localObject4).a())
            {
              localObject4 = (StickerRecData)localObject4;
              if (((StickerRecData)localObject4).b()) {
                paramBaseSessionInfo.addClicked(Integer.valueOf(((StickerRecData)localObject4).d()));
              } else {
                paramBaseSessionInfo.addExposed(Integer.valueOf(((StickerRecData)localObject4).d()));
              }
            }
          }
          localObject2 = ((StickerReportItem)localObject2).jdField_b_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (IStickerRecEmoticon)((Iterator)localObject2).next();
            if (!((IStickerRecEmoticon)localObject3).a()) {
              paramBaseSessionInfo.addNoExpose(Integer.valueOf(((StickerRecData)localObject3).d()));
            }
          }
          if ((paramBaseSessionInfo.noExposeList != null) && (paramBaseSessionInfo.noExposeList.size() == 0))
          {
            localObject2 = paramBaseSessionInfo.noExposeList;
            paramBaseSessionInfo.noExposeList = paramBaseSessionInfo.exposedList;
            paramBaseSessionInfo.exposedList = ((List)localObject2);
          }
          paramBaseSessionInfo.convertToString();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("updateSort new SortEntity clicked=");
            ((StringBuilder)localObject2).append(paramBaseSessionInfo.clicked);
            ((StringBuilder)localObject2).append(" exposed=");
            ((StringBuilder)localObject2).append(paramBaseSessionInfo.exposed);
            ((StringBuilder)localObject2).append(" noExpose=");
            ((StringBuilder)localObject2).append(paramBaseSessionInfo.noExpose);
            QLog.i("StickerRecManager", 2, ((StringBuilder)localObject2).toString());
          }
          paramBaseSessionInfo.recommendType = i;
          this.entityManager.persistOrReplace(paramBaseSessionInfo);
        }
      }
    }
    this.mStickerReportItems.clear();
  }
  
  public void updateStickerLastTime(List<StickerRecCacheEntity> paramList)
  {
    if (this.entityManager == null) {
      return;
    }
    this.mDbHandler.post(new StickerRecManagerImpl.8(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl
 * JD-Core Version:    0.7.0.1
 */