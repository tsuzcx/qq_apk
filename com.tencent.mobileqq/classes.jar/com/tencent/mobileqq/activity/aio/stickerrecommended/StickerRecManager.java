package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.util.Base64;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.ad.StickerRecAdEmotionHandlerListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecReportData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendItem;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.apollo.api.script.ISpriteUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmotionRoamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.emosm.PicSearchSvr.EmotionInfo;
import com.tencent.pb.emosm.PicSearchSvr.ImgInfo;
import com.tencent.pb.emosm.PicSearchSvr.ReqBody;
import com.tencent.pb.emosm.PicSearchSvr.RspBody;
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
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class StickerRecManager
  implements Manager
{
  private static Boolean jdField_a_of_type_JavaLangBoolean = null;
  private static Integer jdField_a_of_type_JavaLangInteger = null;
  private int jdField_a_of_type_Int = 6;
  private BloomFilter jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter = null;
  private StickerRecCameraEmoticonHandleListener jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecCameraEmoticonHandleListener;
  private StickerRecFavoriteEmoHandleListener jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecFavoriteEmoHandleListener;
  private StickerRecManager.ImgUpdateListener jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager$ImgUpdateListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard = null;
  private EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = null;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  private File jdField_a_of_type_JavaIoFile;
  private volatile String jdField_a_of_type_JavaLangString = "";
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = null;
  public List<IStickerRecEmoticon> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getFileThreadHandler();
  private volatile boolean jdField_a_of_type_Boolean = false;
  private final StickerRecManager.ImgUpdateListener jdField_b_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager$ImgUpdateListener = new StickerRecManager.1(this);
  private File jdField_b_of_type_JavaIoFile;
  private List<IStickerRecLocalEmoticonHandleListener> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = true;
  private File c;
  private File d;
  
  public StickerRecManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER));
    a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    d();
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    a(new StickerRecLocalEmoticonHandleListener(paramQQAppInterface));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecCameraEmoticonHandleListener = new StickerRecCameraEmoticonHandleListener(paramQQAppInterface);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecCameraEmoticonHandleListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecFavoriteEmoHandleListener = new StickerRecFavoriteEmoHandleListener(paramQQAppInterface);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecFavoriteEmoHandleListener);
    a(new StickerRecAdEmotionHandlerListener(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  private int a()
  {
    boolean bool = ((ISpriteUtil)QRoute.api(ISpriteUtil.class)).isCmShowKeywordAssociationActive(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "getcmShowIsEnable iscmsEnable : " + bool);
    }
    if (bool) {
      return 1;
    }
    return 0;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  public static int a(Context paramContext, String paramString, int paramInt)
  {
    if (jdField_a_of_type_JavaLangInteger == null) {
      jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getInt("RECOMMENDED_STICKER_MAX_MATCH_LENGTH" + paramString, paramInt));
    }
    return 6;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getInt("RECOMMENDED_STICKER_VERSION" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static StickerRecManager a(QQAppInterface paramQQAppInterface)
  {
    return (StickerRecManager)paramQQAppInterface.getManager(QQManagerFactory.STICKER_RECOMMEND_MANAGER);
  }
  
  private PicSearchSvr.ReqBody a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, List<String> paramList)
  {
    PicSearchSvr.ReqBody localReqBody;
    try
    {
      localReqBody = new PicSearchSvr.ReqBody();
      localReqBody.setHasFlag(true);
      int i = a();
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
    }
    finally {}
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      localReqBody.uint32_age.set(this.jdField_a_of_type_ComTencentMobileqqDataCard.age);
    }
    for (;;)
    {
      return localReqBody;
      localReqBody.uint32_age.set(0);
    }
  }
  
  public static File a(String paramString)
  {
    try
    {
      paramString = Utils.Crc64String(paramString);
      paramString = new File(StickerRecConstants.jdField_a_of_type_JavaLangString + paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  private Object a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +8 -> 15
    //   10: aload 6
    //   12: astore_3
    //   13: aload_3
    //   14: areturn
    //   15: new 372	java/io/ObjectInputStream
    //   18: dup
    //   19: new 374	java/io/BufferedInputStream
    //   22: dup
    //   23: new 376	java/io/FileInputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 377	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 380	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 381	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore 4
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokevirtual 384	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   47: astore 5
    //   49: aload 5
    //   51: astore_1
    //   52: aload_1
    //   53: astore_3
    //   54: aload 4
    //   56: ifnull -43 -> 13
    //   59: aload 4
    //   61: invokevirtual 387	java/io/ObjectInputStream:close	()V
    //   64: aload_1
    //   65: areturn
    //   66: astore_3
    //   67: aload_1
    //   68: areturn
    //   69: astore 5
    //   71: aconst_null
    //   72: astore 4
    //   74: aload 4
    //   76: astore_3
    //   77: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +46 -> 126
    //   83: aload 4
    //   85: astore_3
    //   86: ldc 167
    //   88: iconst_2
    //   89: new 169	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 389
    //   99: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 391
    //   109: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 5
    //   114: invokevirtual 392	java/lang/Exception:toString	()Ljava/lang/String;
    //   117: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 395	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload 4
    //   128: astore_3
    //   129: aload 5
    //   131: instanceof 397
    //   134: istore_2
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 387	java/io/ObjectInputStream:close	()V
    //   145: aload 6
    //   147: astore_3
    //   148: iload_2
    //   149: ifeq -136 -> 13
    //   152: aload_1
    //   153: invokestatic 402	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   156: pop
    //   157: aconst_null
    //   158: areturn
    //   159: astore_1
    //   160: aconst_null
    //   161: astore 4
    //   163: aload 4
    //   165: astore_3
    //   166: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +15 -> 184
    //   172: aload 4
    //   174: astore_3
    //   175: ldc 167
    //   177: iconst_2
    //   178: ldc_w 404
    //   181: invokestatic 395	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 6
    //   186: astore_3
    //   187: aload 4
    //   189: ifnull -176 -> 13
    //   192: aload 4
    //   194: invokevirtual 387	java/io/ObjectInputStream:close	()V
    //   197: aconst_null
    //   198: areturn
    //   199: astore_1
    //   200: aconst_null
    //   201: areturn
    //   202: astore_1
    //   203: aconst_null
    //   204: astore_3
    //   205: aload_3
    //   206: ifnull +7 -> 213
    //   209: aload_3
    //   210: invokevirtual 387	java/io/ObjectInputStream:close	()V
    //   213: aload_1
    //   214: athrow
    //   215: astore_3
    //   216: goto -71 -> 145
    //   219: astore_3
    //   220: goto -7 -> 213
    //   223: astore_1
    //   224: goto -19 -> 205
    //   227: astore_1
    //   228: goto -65 -> 163
    //   231: astore 5
    //   233: goto -159 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	StickerRecManager
    //   0	236	1	paramString	String
    //   134	15	2	bool	boolean
    //   12	42	3	localObject1	Object
    //   66	1	3	localIOException1	java.io.IOException
    //   76	134	3	localObject2	Object
    //   215	1	3	localIOException2	java.io.IOException
    //   219	1	3	localIOException3	java.io.IOException
    //   37	156	4	localObjectInputStream	java.io.ObjectInputStream
    //   47	3	5	localObject3	Object
    //   69	61	5	localException1	Exception
    //   231	1	5	localException2	Exception
    //   1	184	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   59	64	66	java/io/IOException
    //   15	39	69	java/lang/Exception
    //   15	39	159	java/lang/OutOfMemoryError
    //   192	197	199	java/io/IOException
    //   15	39	202	finally
    //   140	145	215	java/io/IOException
    //   209	213	219	java/io/IOException
    //   42	49	223	finally
    //   77	83	223	finally
    //   86	126	223	finally
    //   129	135	223	finally
    //   166	172	223	finally
    //   175	184	223	finally
    //   42	49	227	java/lang/OutOfMemoryError
    //   42	49	231	java/lang/Exception
  }
  
  private List<IStickerRecEmoticon> a(List<IStickerRecEmoticon> paramList, StickerRecommendSortEntity paramStickerRecommendSortEntity)
  {
    int i2 = 0;
    int j;
    int m;
    label104:
    int k;
    label122:
    int i;
    int n;
    label203:
    int i1;
    if (paramStickerRecommendSortEntity != null)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("StickerRecManager", 2, "updateSort clicked=" + paramStickerRecommendSortEntity.clicked + " exposed=" + paramStickerRecommendSortEntity.exposed + " noExpose=" + paramStickerRecommendSortEntity.noExpose);
        }
        if (paramStickerRecommendSortEntity.clickedList == null) {
          break label438;
        }
        j = paramStickerRecommendSortEntity.clickedList.size();
        if (paramStickerRecommendSortEntity.noExposeList == null) {
          break label432;
        }
        m = paramStickerRecommendSortEntity.noExposeList.size();
        if (paramStickerRecommendSortEntity.exposedList == null) {
          break label426;
        }
        k = paramStickerRecommendSortEntity.exposedList.size();
        i3 = paramList.size();
        i = j + m + k;
        if (i3 != i)
        {
          if (!QLog.isColorLevel()) {
            break label444;
          }
          QLog.i("StickerRecManager", 2, "sort data:length is not equals. size=" + i3 + " sortSize=" + i);
          break label444;
        }
        arrayOfIStickerRecEmoticon = new IStickerRecEmoticon[i3];
        n = 0;
        i = 0;
        if (n >= j) {
          break label455;
        }
        i1 = ((Integer)paramStickerRecommendSortEntity.clickedList.get(n)).intValue();
        if ((i1 >= i3) || (i >= i3)) {
          break label423;
        }
        arrayOfIStickerRecEmoticon[i] = ((IStickerRecEmoticon)paramList.get(i1));
        i += 1;
      }
      catch (Throwable paramList)
      {
        int i3;
        IStickerRecEmoticon[] arrayOfIStickerRecEmoticon;
        label264:
        QLog.e("StickerRecManager", 1, "sortData:", paramList);
      }
      j = i;
      i1 = i2;
      if (n < m)
      {
        j = ((Integer)paramStickerRecommendSortEntity.noExposeList.get(n)).intValue();
        if ((j >= i3) || (i >= i3)) {
          break label420;
        }
        arrayOfIStickerRecEmoticon[i] = ((IStickerRecEmoticon)paramList.get(j));
        i += 1;
        break label461;
      }
    }
    for (;;)
    {
      if (i1 < k)
      {
        i = ((Integer)paramStickerRecommendSortEntity.exposedList.get(i1)).intValue();
        if ((i < i3) && (j < i3))
        {
          arrayOfIStickerRecEmoticon[j] = ((IStickerRecEmoticon)paramList.get(i));
          i = j + 1;
          break label470;
        }
      }
      else
      {
        paramList = Arrays.asList(arrayOfIStickerRecEmoticon);
        return paramList;
        return null;
      }
      i = j;
      break label470;
      label420:
      break label461;
      label423:
      break label446;
      label426:
      k = 0;
      break label122;
      label432:
      m = 0;
      break label104;
      label438:
      j = 0;
      break;
      label444:
      return null;
      label446:
      n += 1;
      break label203;
      label455:
      n = 0;
      break label264;
      label461:
      n += 1;
      break label264;
      label470:
      i1 += 1;
      j = i;
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putInt("RECOMMENDED_STICKER_MAX_MATCH_LENGTH" + paramString, paramInt).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface.getApp().getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putInt("RECOMMENDED_STICKER_VERSION" + paramQQAppInterface.getCurrentAccountUin(), paramInt).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.getCurrentUin();
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
    if (jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      a(paramQQAppInterface).c();
    }
    localBaseApplication.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putBoolean("RECOMMENDED_STICKER_SWITCH" + str, paramBoolean).apply();
  }
  
  private void a(File paramFile1, File paramFile2)
  {
    if (paramFile2.exists()) {
      paramFile2.delete();
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      FileUtils.a(paramFile1, paramFile2);
      paramFile1.delete();
    }
  }
  
  /* Error */
  private void a(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 370	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 525	java/io/ObjectOutputStream
    //   11: dup
    //   12: new 527	java/io/BufferedOutputStream
    //   15: dup
    //   16: new 529	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 530	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 533	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: invokespecial 534	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore 4
    //   32: aload 4
    //   34: astore_3
    //   35: aload 4
    //   37: aload_2
    //   38: invokevirtual 538	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: invokevirtual 541	java/io/ObjectOutputStream:flush	()V
    //   49: aload 4
    //   51: ifnull -44 -> 7
    //   54: aload 4
    //   56: invokevirtual 542	java/io/ObjectOutputStream:close	()V
    //   59: return
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 543	java/io/IOException:printStackTrace	()V
    //   65: return
    //   66: astore 5
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: astore_3
    //   72: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +45 -> 120
    //   78: aload_2
    //   79: astore_3
    //   80: ldc 167
    //   82: iconst_2
    //   83: new 169	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 545
    //   93: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 391
    //   103: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload 5
    //   108: invokevirtual 392	java/lang/Exception:toString	()Ljava/lang/String;
    //   111: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 395	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_2
    //   121: ifnull -114 -> 7
    //   124: aload_2
    //   125: invokevirtual 542	java/io/ObjectOutputStream:close	()V
    //   128: return
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 543	java/io/IOException:printStackTrace	()V
    //   134: return
    //   135: astore_1
    //   136: aconst_null
    //   137: astore_3
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 542	java/io/ObjectOutputStream:close	()V
    //   146: aload_1
    //   147: athrow
    //   148: astore_2
    //   149: aload_2
    //   150: invokevirtual 543	java/io/IOException:printStackTrace	()V
    //   153: goto -7 -> 146
    //   156: astore_1
    //   157: goto -19 -> 138
    //   160: astore 5
    //   162: aload 4
    //   164: astore_2
    //   165: goto -95 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	StickerRecManager
    //   0	168	1	paramString	String
    //   0	168	2	paramObject	Object
    //   34	109	3	localObject	Object
    //   30	133	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   66	41	5	localException1	Exception
    //   160	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   54	59	60	java/io/IOException
    //   8	32	66	java/lang/Exception
    //   124	128	129	java/io/IOException
    //   8	32	135	finally
    //   142	146	148	java/io/IOException
    //   35	41	156	finally
    //   44	49	156	finally
    //   72	78	156	finally
    //   80	120	156	finally
    //   35	41	160	java/lang/Exception
    //   44	49	160	java/lang/Exception
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3)
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
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        Object localObject = this.jdField_a_of_type_JavaIoFile.getParentFile();
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = new HttpNetReq();
        ((HttpNetReq)localObject).mCallback = new StickerRecManager.8(this, paramString2, bool, paramString3);
        ((HttpNetReq)localObject).mReqUrl = paramString1;
        ((HttpNetReq)localObject).mHttpMethod = 0;
        ((HttpNetReq)localObject).mOutPath = this.d.getAbsolutePath();
        ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
        try
        {
          paramString2 = BaseApplicationImpl.getApplication().getRuntime();
          if (!QQAppInterface.class.isInstance(paramString2)) {
            break;
          }
          ((IHttpEngineService)((QQAppInterface)paramString2).getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("StickerRecManager", 2, "start download words, url: " + paramString1);
          return;
        }
        catch (Exception paramString1)
        {
          QLog.e("StickerRecManager", 1, "download follow words error", paramString1);
          return;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_succ_flag", str);
      localHashMap.put("initTimeCost", paramLong + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecInitCost", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    ArrayList localArrayList = new ArrayList();
    if ((paramBoolean) && (this.jdField_b_of_type_JavaUtilList != null))
    {
      long l = System.currentTimeMillis();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IStickerRecLocalEmoticonHandleListener)localIterator.next();
        if (((IStickerRecLocalEmoticonHandleListener)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString))
        {
          localObject = ((IStickerRecLocalEmoticonHandleListener)localObject).a(paramString, paramSessionInfo);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            localArrayList.addAll((Collection)localObject);
          }
        }
      }
      paramString = SearchStickerRecEmoticonUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if ((paramString != null) && (!paramString.isEmpty())) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramString);
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((IStickerRecEmoticon)this.jdField_a_of_type_JavaUtilList.get(i)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "handleLocalEmoticon time = " + (System.currentTimeMillis() - l));
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    try
    {
      localObject = new PicSearchWordsSvr.RspBody();
      ((PicSearchWordsSvr.RspBody)localObject).mergeFrom(paramArrayOfByte);
      if (((PicSearchWordsSvr.RspBody)localObject).int32_result.get() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "handlePullWords response code error,result:" + ((PicSearchWordsSvr.RspBody)localObject).int32_result.get() + " message : " + ((PicSearchWordsSvr.RspBody)localObject).bytes_fail_msg.get());
        }
      }
      else
      {
        paramArrayOfByte = ((PicSearchWordsSvr.RspBody)localObject).words_msg.bytes_words_version.get().toStringUtf8();
        String str1 = ((PicSearchWordsSvr.RspBody)localObject).words_msg.bytes_words_md5.get().toStringUtf8();
        String str2 = ((PicSearchWordsSvr.RspBody)localObject).words_msg.bytes_words_url.get().toStringUtf8();
        int i = ((PicSearchWordsSvr.RspBody)localObject).words_msg.uint32_words_type.get();
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "pull words resp:version=" + paramArrayOfByte + " wordsMd5=" + str1 + " wordsUrl=" + str2 + " wordsType=" + i);
        }
        localObject = SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "words_version_key805_gray_one", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        if ((!((String)localObject).equals(paramArrayOfByte)) || (!this.c.exists()))
        {
          a(str2, str1, i, paramArrayOfByte);
          return;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("StickerRecManager", 2, ThrowablesUtils.a(paramArrayOfByte));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "not need pull words: localVersion=" + (String)localObject + " server version=" + paramArrayOfByte);
        }
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "cache pics in DB");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
    {
      StickerRecommendEntity localStickerRecommendEntity = new StickerRecommendEntity();
      localStickerRecommendEntity.usrMessage = paramString;
      localStickerRecommendEntity.recList = Base64.encodeToString(paramArrayOfByte, 0);
      localStickerRecommendEntity.cachedTime = System.currentTimeMillis();
      localStickerRecommendEntity.recommendType = paramInt;
      this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.6(this, localStickerRecommendEntity));
    }
  }
  
  private void a(byte[] paramArrayOfByte, String paramString1, String paramString2, boolean paramBoolean, StickerRecommendSortEntity paramStickerRecommendSortEntity, int paramInt1, int paramInt2)
  {
    Object localObject1;
    List localList;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "handlePullPics from : " + paramString2 + " | RecType=" + paramInt1 + " | aiotype = " + paramInt2);
      }
      localObject1 = new PicSearchSvr.RspBody();
      ((PicSearchSvr.RspBody)localObject1).mergeFrom(paramArrayOfByte);
      if (((PicSearchSvr.RspBody)localObject1).int32_result.get() != 0)
      {
        if (!QLog.isColorLevel()) {
          break label934;
        }
        QLog.d("StickerRecManager", 2, "handleResponse response code error,result:" + ((PicSearchSvr.RspBody)localObject1).int32_result.get() + " message : " + ((PicSearchSvr.RspBody)localObject1).bytes_fail_msg.get());
        return;
      }
      localList = ((PicSearchSvr.RspBody)localObject1).rpt_msg_img_info.get();
      if ((localList != null) && (!localList.isEmpty())) {
        break label237;
      }
      if ("network".equals(paramString2)) {
        i();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.7(this, paramInt1, paramString1));
      }
      if (!QLog.isColorLevel()) {
        break label934;
      }
      QLog.d("StickerRecManager", 2, "handleResponse imgInfos is null or empty");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (!QLog.isColorLevel()) {
        break label934;
      }
    }
    QLog.d("StickerRecManager", 2, ThrowablesUtils.a(paramArrayOfByte));
    return;
    label237:
    ArrayList localArrayList;
    if (((PicSearchSvr.RspBody)localObject1).bytes_rsp_other.has())
    {
      paramArrayOfByte = ((PicSearchSvr.RspBody)localObject1).bytes_rsp_other.get().toStringUtf8();
      localArrayList = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        Object localObject2 = (PicSearchSvr.ImgInfo)localList.get(i);
        StickerRecData localStickerRecData = new StickerRecData();
        localStickerRecData.f(i);
        localStickerRecData.c(((PicSearchSvr.ImgInfo)localObject2).uint64_img_size.get());
        localStickerRecData.a(((PicSearchSvr.ImgInfo)localObject2).uint32_img_width.get());
        localStickerRecData.b(((PicSearchSvr.ImgInfo)localObject2).uint32_img_height.get());
        localStickerRecData.e(((PicSearchSvr.ImgInfo)localObject2).bytes_img_md5.get().toStringUtf8());
        localStickerRecData.c(((PicSearchSvr.ImgInfo)localObject2).bytes_img_down_url.get().toStringUtf8());
        localStickerRecData.d(((PicSearchSvr.ImgInfo)localObject2).uint64_thumb_size.get());
        localStickerRecData.d(((PicSearchSvr.ImgInfo)localObject2).uint32_thumb_img_height.get());
        localStickerRecData.c(((PicSearchSvr.ImgInfo)localObject2).uint32_thumb_img_width.get());
        localStickerRecData.d(((PicSearchSvr.ImgInfo)localObject2).bytes_thumb_down_url.get().toStringUtf8());
        localStickerRecData.f(((PicSearchSvr.ImgInfo)localObject2).bytes_thumb_img_md5.get().toStringUtf8());
        localStickerRecData.g(((PicSearchSvr.ImgInfo)localObject2).uint32_src_type.get());
        localStickerRecData.g(((PicSearchSvr.ImgInfo)localObject2).bytes_src_desc.get().toStringUtf8());
        localStickerRecData.h(((PicSearchSvr.ImgInfo)localObject2).bytes_web_url.get().toStringUtf8());
        localStickerRecData.i("");
        localStickerRecData.j(((PicSearchSvr.ImgInfo)localObject2).bytes_pack_name.get().toStringUtf8());
        localStickerRecData.h(((PicSearchSvr.ImgInfo)localObject2).uint32_pack_id.get());
        if (((PicSearchSvr.ImgInfo)localObject2).bytes_img_other.has()) {
          localStickerRecData.k(((PicSearchSvr.ImgInfo)localObject2).bytes_img_other.get().toStringUtf8());
        }
        localStickerRecData.l(paramArrayOfByte);
        localStickerRecData.e(paramInt1);
        if (((PicSearchSvr.ImgInfo)localObject2).msg_emotion_info.has())
        {
          localObject2 = ((PicSearchSvr.ImgInfo)localObject2).msg_emotion_info;
          if (((PicSearchSvr.EmotionInfo)localObject2).bytes_url.has()) {
            localStickerRecData.a(((PicSearchSvr.EmotionInfo)localObject2).bytes_url.get().toStringUtf8());
          }
        }
        if ((localStickerRecData.e() == 3) && (QLog.isColorLevel())) {
          QLog.i("StickerRecManager", 2, "reveice cmsEmo  from:" + localStickerRecData.e() + ", CmShowinfo:" + localStickerRecData.e());
        }
        localArrayList.add(localStickerRecData);
        i += 1;
      }
      paramArrayOfByte = a(localArrayList, paramStickerRecommendSortEntity);
      if (paramArrayOfByte != null)
      {
        label713:
        paramStickerRecommendSortEntity = a(paramArrayOfByte, paramInt2, paramBoolean, ((ISpriteUtil)QRoute.api(ISpriteUtil.class)).isCmShowKeywordAssociationActive(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        label798:
        if (paramStickerRecommendSortEntity != null)
        {
          paramArrayOfByte = paramStickerRecommendSortEntity;
          label749:
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            paramArrayOfByte = new ArrayList(paramArrayOfByte);
            paramArrayOfByte.addAll(0, this.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilList.clear();
            if (!"network".equals(paramString2)) {
              break label935;
            }
          }
        }
      }
    }
    label934:
    label935:
    for (paramString2 = ((PicSearchSvr.RspBody)localObject1).bytes_rsp_other.get().toStringUtf8();; paramString2 = "999")
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager$ImgUpdateListener.a(paramArrayOfByte, paramString1, paramString2, 0, null);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager$ImgUpdateListener != null)
      {
        localArrayList = null;
        paramStickerRecommendSortEntity = localArrayList;
        if (paramInt1 == 1)
        {
          paramStickerRecommendSortEntity = localArrayList;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localObject1 = ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramString1);
            paramStickerRecommendSortEntity = localArrayList;
            if (localObject1 != null) {
              paramStickerRecommendSortEntity = ((ScenesRecommendItem)localObject1).b();
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager$ImgUpdateListener.a(paramArrayOfByte, paramString1, paramString2, paramInt1, paramStickerRecommendSortEntity);
        return;
        break label798;
        break label749;
        paramArrayOfByte = localArrayList;
        break label713;
        paramArrayOfByte = null;
        break;
      }
      return;
    }
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaLangBoolean == null) {
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getBoolean("RECOMMENDED_STICKER_SWITCH" + paramString, paramBoolean));
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static boolean a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    return paramIStickerRecEmoticon.a();
  }
  
  public static boolean a(MessageForPic paramMessageForPic)
  {
    return (paramMessageForPic != null) && (paramMessageForPic.picExtraData != null) && ((paramMessageForPic.picExtraData.isStickerPics()) || (paramMessageForPic.picExtraData.isStickerAdPic()));
  }
  
  private boolean a(File paramFile1, File paramFile2)
  {
    boolean bool = false;
    try
    {
      File localFile = new File(paramFile2.getParent() + File.separator + "temp");
      ZipUtils.unZipFile(paramFile1, localFile.getAbsolutePath() + File.separator);
      paramFile1 = localFile.listFiles();
      int j = paramFile1.length;
      int i = 0;
      while (i < j)
      {
        localFile = paramFile1[i];
        String str = localFile.getName();
        if ((localFile.isFile()) && (str.endsWith("json"))) {
          a(localFile, paramFile2);
        }
        i += 1;
      }
      bool = true;
    }
    catch (Exception paramFile1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("StickerRecManager", 2, "uncompress template zip file error", paramFile1);
    }
    return bool;
    return false;
  }
  
  private boolean a(File paramFile1, File paramFile2, String paramString, boolean paramBoolean)
  {
    if (a(paramFile1, paramString))
    {
      if (paramBoolean)
      {
        if (a(paramFile1, paramFile2))
        {
          paramFile1.delete();
          return true;
        }
      }
      else
      {
        a(paramFile1, paramFile2);
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
  
  private boolean a(File paramFile, String paramString)
  {
    boolean bool = true;
    if (!paramFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w("StickerRecManager", 2, "downloadFile zip file not exists");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        paramFile = FileUtils.c(paramFile.getPath());
        if ((android.text.TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramFile))) {
          break label70;
        }
        return bool;
      }
      catch (UnsatisfiedLinkError paramFile) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("StickerRecManager", 1, "calculate follow capture template zip md5 error", paramFile);
      return false;
      label70:
      bool = false;
    }
  }
  
  private String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getFilesDir().getAbsolutePath() + File.separator + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + File.separator + "qstorage" + File.separator + "objs" + File.separator + "sticker_recommend";
  }
  
  public static boolean b(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    return !a(paramIStickerRecEmoticon);
  }
  
  public static String c(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      localStringBuffer.append("\\u" + Integer.toHexString(j));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String d(String paramString)
  {
    try
    {
      paramString = Utils.Crc64String(paramString);
      paramString = StickerRecConstants.jdField_a_of_type_JavaLangString + paramString;
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void f()
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
  
  private void i()
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecEmptyImg", false, 0L, 0L, null, "");
  }
  
  public String a()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a(String paramString)
  {
    return com.tencent.mobileqq.text.TextUtils.cToe(StringUtil.c(com.tencent.mobileqq.text.TextUtils.emoticonToTextWithoutSysEmotion(paramString)).toLowerCase());
  }
  
  public Collection<String> a()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = ((CameraEmotionRoamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER)).a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
        if (("normal".equals(localCameraEmotionData.RomaingType)) && (!android.text.TextUtils.isEmpty(localCameraEmotionData.strContext))) {
          localHashSet.add(b(localCameraEmotionData.strContext));
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "loadKeywordForCameraEmotion size: " + localHashSet.size());
    }
    return localHashSet;
  }
  
  public List<IStickerRecEmoticon> a(List<IStickerRecEmoticon> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() != 0)
        {
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
      }
      catch (Exception paramList)
      {
        QLog.e("StickerRecManager", 1, "perkData has exception:", paramList);
        return null;
      }
    }
    return null;
  }
  
  public void a()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "init has executed");
      }
      return;
    }
    try
    {
      l1 = SystemClock.elapsedRealtime();
      try
      {
        if (FileUtils.a(this.c.getAbsolutePath())) {
          break label116;
        }
        throw new IllegalStateException("words file not exist");
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        long l2;
        Object localObject1;
        Object localObject2;
        List localList;
        long l1 = 0L;
      }
    }
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      QLog.d("StickerRecManager", 2, ThrowablesUtils.a(localException1));
      QLog.d("StickerRecManager", 2, "StickerRecManager error init time cost : " + (SystemClock.elapsedRealtime() - l1));
    }
    a(false, SystemClock.elapsedRealtime() - l1);
    return;
    label116:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter = ((BloomFilter)a(this.c.getAbsolutePath()));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter == null) {
      throw new IllegalStateException("words file read error");
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "init bloomFilter, version : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter.version);
    }
    l2 = SharedPreUtils.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    if ((!FileUtils.a(this.jdField_b_of_type_JavaIoFile.getAbsolutePath())) || ((l2 != 0L) && (System.currentTimeMillis() - l2 >= 86400000L)))
    {
      SharedPreUtils.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0L);
      localObject1 = new HashSet();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b();
      localList = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_JavaUtilList;
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
        FileUtil.c(this.jdField_b_of_type_JavaIoFile.getAbsolutePath());
        a(this.jdField_b_of_type_JavaIoFile.getAbsolutePath(), localObject1);
      }
      this.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject1);
    }
    for (;;)
    {
      g();
      h();
      this.jdField_a_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 6);
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataCard = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      this.jdField_a_of_type_Boolean = true;
      l2 = SystemClock.elapsedRealtime() - l1;
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "StickerRecManager init time cost : " + l2);
      }
      a(true, l2);
      return;
      this.jdField_a_of_type_JavaUtilHashSet = ((HashSet)a(this.jdField_b_of_type_JavaIoFile.getAbsolutePath()));
      if (this.jdField_a_of_type_JavaUtilHashSet == null) {
        FileUtil.c(this.jdField_b_of_type_JavaIoFile.getAbsolutePath());
      }
    }
  }
  
  protected void a(Context paramContext, String paramString)
  {
    try
    {
      this.jdField_b_of_type_Boolean = SharedPreUtils.B(paramContext, paramString);
      return;
    }
    catch (NullPointerException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {}
    for (;;)
    {
      return;
      int i;
      Object localObject;
      String str;
      try
      {
        if (paramFromServiceMsg.getResultCode() != 1000) {
          break label248;
        }
        i = paramFromServiceMsg.getWupBuffer().length - 4;
        localObject = new byte[i];
        PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
        paramFromServiceMsg.putWupBuffer((byte[])localObject);
        localObject = paramFromServiceMsg.getServiceCmd();
        str = paramIntent.getStringExtra("USER_KEYWORD");
        i = paramIntent.getIntExtra("request_aio_type", 4);
        try
        {
          paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
          if (paramFromServiceMsg == null) {
            continue;
          }
          if (!"PicSearchWordsSvr.PullWords".equals(localObject)) {
            break label131;
          }
          a(paramFromServiceMsg);
        }
        catch (Exception paramIntent) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StickerRecManager", 2, ThrowablesUtils.a(paramIntent));
        continue;
      }
      finally {}
      label131:
      if ("PicSearchSvr.PullPics".equals(localObject))
      {
        a(paramFromServiceMsg, str, 0);
        a(paramFromServiceMsg, str, "network", paramIntent.getBooleanExtra("fromQzone", false), null, 0, i);
      }
      else if ("BreakIceSvr.Pull".equals(localObject))
      {
        ((IceBreakingMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).a(paramFromServiceMsg);
      }
      else if ("SceneFaceRec.PullFaces".equals(localObject))
      {
        a(paramFromServiceMsg, str, 1);
        a(paramFromServiceMsg, str, "network", paramIntent.getBooleanExtra("fromQzone", false), null, 1, i);
        continue;
        label248:
        QLog.d("StickerRecManager", 1, String.format("result_code = %s, cmd = %s", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()), paramFromServiceMsg.getServiceCmd() }));
      }
    }
  }
  
  public void a(IStickerRecLocalEmoticonHandleListener paramIStickerRecLocalEmoticonHandleListener)
  {
    if (paramIStickerRecLocalEmoticonHandleListener == null) {}
    do
    {
      return;
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
    } while (this.jdField_b_of_type_JavaUtilList.contains(paramIStickerRecLocalEmoticonHandleListener));
    this.jdField_b_of_type_JavaUtilList.add(paramIStickerRecLocalEmoticonHandleListener);
  }
  
  public void a(StickerRecManager.ImgUpdateListener paramImgUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager$ImgUpdateListener = paramImgUpdateListener;
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/tencent/mobileqq/activity/aio/stickerrecommended/StickerRecManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new 1319	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody
    //   19: dup
    //   20: invokespecial 1320	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: iconst_1
    //   28: invokevirtual 1321	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:setHasFlag	(Z)V
    //   31: new 169	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   38: aload_1
    //   39: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokestatic 1324	android/os/SystemClock:uptimeMillis	()J
    //   45: invokevirtual 646	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 6
    //   53: invokestatic 1325	com/tencent/common/config/AppSetting:a	()I
    //   56: invokestatic 1327	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   59: astore 7
    //   61: aload_0
    //   62: getfield 83	com/tencent/mobileqq/activity/aio/stickerrecommended/StickerRecManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 110	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   68: invokestatic 1332	com/tencent/mobileqq/cooperation/ApkUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   71: astore 8
    //   73: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +82 -> 158
    //   79: ldc 167
    //   81: iconst_2
    //   82: new 169	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 1334
    //   92: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload 6
    //   97: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 1336
    //   103: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc_w 1338
    //   113: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload_2
    //   117: invokevirtual 441	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: ldc_w 1340
    //   123: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 7
    //   128: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 1342
    //   134: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 8
    //   139: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 1344
    //   145: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload_3
    //   149: invokevirtual 441	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload 5
    //   160: getfield 1345	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:bytes_session_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   163: aload 6
    //   165: invokestatic 244	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   168: invokevirtual 250	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   171: aload 5
    //   173: getfield 1346	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   176: aload_1
    //   177: invokestatic 260	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   180: invokevirtual 265	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   183: aload 5
    //   185: getfield 1347	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uint32_src_term	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   188: iload_2
    //   189: invokevirtual 274	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   192: aload 5
    //   194: getfield 1350	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:bytes_appid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   197: aload 7
    //   199: invokestatic 244	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   202: invokevirtual 250	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   205: aload 5
    //   207: getfield 1353	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:bytes_version	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   210: aload 8
    //   212: invokestatic 244	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   215: invokevirtual 250	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   218: aload 5
    //   220: getfield 1356	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uin32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   223: iload_3
    //   224: invokevirtual 274	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   227: aload 5
    //   229: getfield 1357	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: iload 4
    //   234: invokevirtual 274	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   237: aload 5
    //   239: invokevirtual 1360	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:toByteArray	()[B
    //   242: astore_1
    //   243: aload_1
    //   244: arraylength
    //   245: iconst_4
    //   246: iadd
    //   247: invokestatic 1366	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   250: astore 5
    //   252: aload 5
    //   254: aload_1
    //   255: arraylength
    //   256: iconst_4
    //   257: iadd
    //   258: invokevirtual 1368	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   261: aload_1
    //   262: invokevirtual 1371	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   265: pop
    //   266: aload 5
    //   268: invokevirtual 1374	java/nio/ByteBuffer:array	()[B
    //   271: astore_1
    //   272: new 1376	mqq/app/NewIntent
    //   275: dup
    //   276: aload_0
    //   277: getfield 83	com/tencent/mobileqq/activity/aio/stickerrecommended/StickerRecManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   280: invokevirtual 110	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   283: ldc_w 1378
    //   286: invokespecial 1381	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   289: astore 5
    //   291: aload 5
    //   293: ldc_w 1383
    //   296: aload_1
    //   297: invokevirtual 1387	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   300: pop
    //   301: aload 5
    //   303: ldc_w 1389
    //   306: ldc_w 1288
    //   309: invokevirtual 1392	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   312: pop
    //   313: aload_0
    //   314: getfield 83	com/tencent/mobileqq/activity/aio/stickerrecommended/StickerRecManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   317: aload 5
    //   319: invokevirtual 1396	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   322: goto -309 -> 13
    //   325: astore_1
    //   326: aload_0
    //   327: monitorexit
    //   328: aload_1
    //   329: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	StickerRecManager
    //   0	330	1	paramString	String
    //   0	330	2	paramInt1	int
    //   0	330	3	paramInt2	int
    //   0	330	4	paramInt3	int
    //   6	312	5	localObject	Object
    //   51	113	6	str1	String
    //   59	139	7	str2	String
    //   71	140	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   2	8	325	finally
    //   16	158	325	finally
    //   158	322	325	finally
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, ScenesRecommendItem paramScenesRecommendItem)
  {
    if (paramScenesRecommendItem != null) {}
    for (;;)
    {
      try
      {
        String str = paramScenesRecommendItem.a();
        if (str == null) {
          return;
        }
        str = paramString1 + SystemClock.uptimeMillis();
        Object localObject1 = a(str, paramString1, paramInt1, paramInt2, paramString2, paramScenesRecommendItem.a()).toByteArray();
        Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
        ((ByteBuffer)localObject2).putInt(localObject1.length + 4).put((byte[])localObject1);
        localObject2 = ((ByteBuffer)localObject2).array();
        localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), StickerRecServlet.class);
        ((NewIntent)localObject1).putExtra("key_body", (byte[])localObject2);
        ((NewIntent)localObject1).putExtra("key_cmd", "SceneFaceRec.PullFaces");
        paramScenesRecommendItem = paramScenesRecommendItem.a();
        ((NewIntent)localObject1).putExtra("REQUEST_SCENES_ID", paramScenesRecommendItem);
        ((NewIntent)localObject1).putExtra("USER_KEYWORD", paramScenesRecommendItem);
        boolean bool;
        if (paramInt1 == 4)
        {
          bool = true;
          ((NewIntent)localObject1).putExtra("fromQzone", bool);
          ((NewIntent)localObject1).putExtra("request_aio_type", paramInt2);
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "send pull pics args:sessionId = " + str + " uin=" + paramString1 + " termType=" + paramInt1 + " aioType : " + paramInt2 + " toUin : " + paramString2 + "  scenesID: " + paramScenesRecommendItem);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 169	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: invokestatic 1324	android/os/SystemClock:uptimeMillis	()J
    //   16: invokevirtual 646	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 7
    //   24: aload_0
    //   25: aload 7
    //   27: aload_1
    //   28: iload_2
    //   29: iload_3
    //   30: aload 4
    //   32: aload 5
    //   34: invokespecial 1402	com/tencent/mobileqq/activity/aio/stickerrecommended/StickerRecManager:a	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)Lcom/tencent/pb/emosm/PicSearchSvr$ReqBody;
    //   37: invokevirtual 1403	com/tencent/pb/emosm/PicSearchSvr$ReqBody:toByteArray	()[B
    //   40: astore 8
    //   42: aload 8
    //   44: arraylength
    //   45: iconst_4
    //   46: iadd
    //   47: invokestatic 1366	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   50: astore 9
    //   52: aload 9
    //   54: aload 8
    //   56: arraylength
    //   57: iconst_4
    //   58: iadd
    //   59: invokevirtual 1368	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   62: aload 8
    //   64: invokevirtual 1371	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   67: pop
    //   68: aload 9
    //   70: invokevirtual 1374	java/nio/ByteBuffer:array	()[B
    //   73: astore 9
    //   75: new 1376	mqq/app/NewIntent
    //   78: dup
    //   79: aload_0
    //   80: getfield 83	com/tencent/mobileqq/activity/aio/stickerrecommended/StickerRecManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   83: invokevirtual 110	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   86: ldc_w 1378
    //   89: invokespecial 1381	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   92: astore 8
    //   94: aload 8
    //   96: ldc_w 1383
    //   99: aload 9
    //   101: invokevirtual 1387	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   104: pop
    //   105: aload 8
    //   107: ldc_w 1389
    //   110: ldc_w 1292
    //   113: invokevirtual 1392	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   116: pop
    //   117: aload 5
    //   119: iconst_0
    //   120: invokeinterface 449 2 0
    //   125: checkcast 312	java/lang/String
    //   128: astore 5
    //   130: aload 8
    //   132: ldc_w 1276
    //   135: aload 5
    //   137: invokevirtual 1392	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   140: pop
    //   141: iload_2
    //   142: iconst_4
    //   143: if_icmpne +127 -> 270
    //   146: iconst_1
    //   147: istore 6
    //   149: aload 8
    //   151: ldc_w 1296
    //   154: iload 6
    //   156: invokevirtual 1408	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   159: pop
    //   160: aload 8
    //   162: ldc_w 1283
    //   165: iload_3
    //   166: invokevirtual 1411	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   169: pop
    //   170: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +85 -> 258
    //   176: ldc 167
    //   178: iconst_2
    //   179: new 169	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 1413
    //   189: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 7
    //   194: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 1336
    //   200: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_1
    //   204: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 1338
    //   210: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: iload_2
    //   214: invokevirtual 441	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: ldc_w 1415
    //   220: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: iload_3
    //   224: invokevirtual 441	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: ldc_w 1417
    //   230: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload 4
    //   235: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc_w 1422
    //   241: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 5
    //   246: invokestatic 1423	com/tencent/mobileqq/activity/aio/stickerrecommended/StickerRecManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   249: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: aload_0
    //   259: getfield 83	com/tencent/mobileqq/activity/aio/stickerrecommended/StickerRecManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   262: aload 8
    //   264: invokevirtual 1396	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   267: aload_0
    //   268: monitorexit
    //   269: return
    //   270: iconst_0
    //   271: istore 6
    //   273: goto -124 -> 149
    //   276: astore_1
    //   277: aload_0
    //   278: monitorexit
    //   279: aload_1
    //   280: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	StickerRecManager
    //   0	281	1	paramString1	String
    //   0	281	2	paramInt1	int
    //   0	281	3	paramInt2	int
    //   0	281	4	paramString2	String
    //   0	281	5	paramList	List<String>
    //   147	125	6	bool	boolean
    //   22	171	7	str	String
    //   40	223	8	localObject1	Object
    //   50	50	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	141	276	finally
    //   149	258	276	finally
    //   258	267	276	finally
  }
  
  public void a(String paramString, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    paramString = b(paramString);
    a(paramBoolean, paramString, paramSessionInfo);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager$ImgUpdateListener != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager$ImgUpdateListener.a(this.jdField_a_of_type_JavaUtilList, paramString, "999", 0, null);
    }
  }
  
  public void a(Collection<String> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()) || (this.jdField_a_of_type_JavaUtilHashSet == null)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaUtilHashSet.addAll(paramCollection);
      a(this.jdField_b_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_JavaUtilHashSet);
      return;
    }
    finally {}
  }
  
  public void a(List<StickerRecCacheEntity> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.9(this, paramList));
  }
  
  public void a(List<StickerReportItem> paramList, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Iterator localIterator1 = paramList.iterator();
    label22:
    Object localObject4;
    String str;
    Object localObject2;
    Object localObject6;
    Object localObject5;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        localObject4 = (StickerReportItem)localIterator1.next();
        if (localObject4 != null)
        {
          str = ((StickerReportItem)localObject4).jdField_a_of_type_JavaLangString;
          localObject2 = ((StickerReportItem)localObject4).jdField_a_of_type_JavaUtilList;
          localObject6 = new StringBuilder();
          localObject5 = new StringBuilder();
          if (!paramBoolean) {
            break label715;
          }
          if (paramInt == 0) {
            paramList = "c2c";
          }
        }
      }
    }
    for (;;)
    {
      Object localObject1 = null;
      Iterator localIterator2 = ((List)localObject2).iterator();
      Object localObject3;
      for (;;)
      {
        if (localIterator2.hasNext())
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
              continue;
              if (paramInt == 1)
              {
                paramList = "group";
                break;
              }
              if (paramInt == 3000)
              {
                paramList = "discuss";
                break;
              }
              if (paramInt == 11000)
              {
                paramList = "qzone";
                break;
              }
              paramList = "other";
              break;
            }
          }
        }
      }
      localObject6 = ((StringBuilder)localObject6).toString();
      localObject5 = ((StringBuilder)localObject5).toString();
      long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
      if (((StickerReportItem)localObject4).jdField_a_of_type_Int == 1)
      {
        localObject2 = new ScenesRecReportData();
        ((ScenesRecReportData)localObject2).l = "dc05550";
        ((ScenesRecReportData)localObject2).c = str;
        ((ScenesRecReportData)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l);
        ((ScenesRecReportData)localObject2).jdField_b_of_type_JavaLangString = paramString;
        ((ScenesRecReportData)localObject2).d = paramList;
      }
      for (paramList = (List<StickerReportItem>)localObject2;; paramList = (List<StickerReportItem>)localObject2)
      {
        paramList.k = ((StickerReportItem)localObject4).jdField_b_of_type_JavaLangString;
        paramList.e = String.valueOf(AppSetting.a());
        if (localObject1 != null)
        {
          localObject3 = ((IStickerRecEmoticon)localObject1).c();
          localObject4 = ((IStickerRecEmoticon)localObject1).d();
          localObject2 = localObject3;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject2 = (String)localObject4 + (String)localObject3;
          }
          paramList.h = ((String)localObject2);
          paramList.i = ((IStickerRecEmoticon)localObject1).a();
          StickerRecReport.a(false, str, paramInt, paramString, (IStickerRecEmoticon)localObject1);
        }
        paramList.f = ((String)localObject6);
        paramList.g = ((String)localObject5);
        paramList.j = "android";
        localObject1 = paramList.a();
        localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), StickerRecServlet.class);
        ((NewIntent)localObject2).putExtra("key_cmd", "MQInference.CommonReport");
        ((NewIntent)localObject2).putExtra("key_body", WupUtil.a(((JSONObject)localObject1).toString().getBytes()));
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "report StickerRecReport content:" + paramList.a().toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
        break label22;
        break;
        localObject2 = new StickerRecReportData();
        ((StickerRecReportData)localObject2).l = "dc04577";
        ((StickerRecReportData)localObject2).jdField_b_of_type_JavaLangString = str;
        if (QLog.isColorLevel()) {
          ((StickerRecReportData)localObject2).jdField_b_of_type_JavaLangString = c(((StickerRecReportData)localObject2).jdField_b_of_type_JavaLangString);
        }
        ((StickerRecReportData)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l);
        ((StickerRecReportData)localObject2).d = paramString;
        ((StickerRecReportData)localObject2).c = paramList;
      }
      label715:
      paramList = "";
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    SharedPreUtils.u(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramBoolean);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(ScenesRecommendItem paramScenesRecommendItem, int paramInt, String paramString)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "can't analyze, has not init");
      }
    }
    for (;;)
    {
      return false;
      if (paramScenesRecommendItem != null) {}
      try
      {
        if ((paramScenesRecommendItem.a() == null) || (StringUtil.a(paramScenesRecommendItem.a())))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("StickerRecManager", 2, "analyzeForScenesMode data is empty");
          return false;
        }
      }
      catch (Exception paramScenesRecommendItem)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, ThrowablesUtils.a(paramScenesRecommendItem));
        }
      }
    }
    for (;;)
    {
      return true;
      String str = paramScenesRecommendItem.a();
      this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.4(this, str, paramInt, paramString, paramScenesRecommendItem));
    }
  }
  
  public boolean a(String paramString)
  {
    if ((paramString == null) || (this.jdField_a_of_type_JavaUtilHashSet == null)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilHashSet.contains(paramString);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt, paramString2, true, false, null);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2, SessionInfo paramSessionInfo)
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "can't analyze, has not init");
      }
      return false;
    }
    try
    {
      String str1 = a(paramString1);
      if ((android.text.TextUtils.isEmpty(str1)) || (str1.length() > this.jdField_a_of_type_Int))
      {
        if (!QLog.isColorLevel()) {
          break label253;
        }
        QLog.d("StickerRecManager", 2, "userTxt over maxMatchLength or empty");
        break label253;
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter.contains(str1);
      String str2 = c(str1);
      if (!bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "word : " + str2 + " miss dict");
        }
        if ((!paramBoolean2) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager$ImgUpdateListener == null)) {
          break label255;
        }
        ThreadManager.getSubThreadHandler().post(new StickerRecManager.2(this, paramString1, paramBoolean2, paramSessionInfo));
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "word : " + str2 + " in dict");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.3(this, paramString1, paramBoolean2, paramSessionInfo, str1, paramInt, paramBoolean1, paramString2));
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, ThrowablesUtils.a(paramString1));
        }
      }
    }
    return true;
    label253:
    return false;
    label255:
    return false;
  }
  
  public boolean a(String paramString, SessionInfo paramSessionInfo)
  {
    boolean bool = false;
    if (paramSessionInfo != null) {
      bool = a(paramString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, false, true, paramSessionInfo);
    }
    return bool;
  }
  
  public String b(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return com.tencent.mobileqq.text.TextUtils.cToe(StringUtil.c(com.tencent.mobileqq.text.TextUtils.emoticonToTextWithoutSysEmotion(paramString)));
  }
  
  public Collection<String> b()
  {
    HashSet localHashSet = new HashSet();
    EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
    Object localObject1 = ((FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).a();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (CustomEmotionData)((Iterator)localObject1).next();
        if (("isUpdate".equals(((CustomEmotionData)localObject2).RomaingType)) || ("needDownload".equals(((CustomEmotionData)localObject2).RomaingType)) || ("overflow".equals(((CustomEmotionData)localObject2).RomaingType)) || ("overflow_downloaded".equals(((CustomEmotionData)localObject2).RomaingType))) {
          if (!android.text.TextUtils.isEmpty(((CustomEmotionData)localObject2).modifyWord))
          {
            localHashSet.add(b(((CustomEmotionData)localObject2).modifyWord));
          }
          else if (!android.text.TextUtils.isEmpty(((CustomEmotionData)localObject2).ocrWord))
          {
            localHashSet.add(b(((CustomEmotionData)localObject2).ocrWord));
          }
          else if (((CustomEmotionData)localObject2).isMarkFace)
          {
            localObject2 = localEmoticonManager.a(((CustomEmotionData)localObject2).emoPath, ((CustomEmotionData)localObject2).eId);
            if ((localObject2 != null) && (!android.text.TextUtils.isEmpty(((Emoticon)localObject2).name))) {
              localHashSet.add(((Emoticon)localObject2).name);
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "loadKeywordForFavEmotion size: " + localHashSet.size());
    }
    return localHashSet;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "unInit executed");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter = null;
    this.jdField_a_of_type_Int = 6;
    this.jdField_a_of_type_ComTencentMobileqqDataCard = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = null;
  }
  
  public void b(List<StickerReportItem> paramList)
  {
    Iterator localIterator = new ArrayList(paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (StickerReportItem)localIterator.next();
      if (localObject1 != null)
      {
        Object localObject2 = ((StickerReportItem)localObject1).jdField_a_of_type_JavaLangString;
        int i = ((StickerReportItem)localObject1).jdField_a_of_type_Int;
        label103:
        Object localObject3;
        if (i == 1)
        {
          paramList = (StickerRecommendSortEntity)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[] { localObject2 });
          if (paramList == null) {
            break label382;
          }
          paramList.convertToList();
          localObject1 = ((StickerReportItem)localObject1).jdField_a_of_type_JavaUtilList.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (IStickerRecEmoticon)((Iterator)localObject1).next();
          } while (((IStickerRecEmoticon)localObject2).a());
          localObject2 = (StickerRecData)localObject2;
          localObject3 = Integer.valueOf(((StickerRecData)localObject2).d());
          if (!((StickerRecData)localObject2).b()) {
            break label224;
          }
          if (paramList.clickedList.contains(localObject3)) {
            paramList.removeClicked((Integer)localObject3);
          }
          paramList.addClicked((Integer)localObject3);
        }
        for (;;)
        {
          paramList.removeNoExpose((Integer)localObject3);
          break label103;
          paramList = (StickerRecommendSortEntity)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[] { localObject2 });
          break;
          label224:
          if (!paramList.exposedList.contains(localObject3)) {
            paramList.addExposed((Integer)localObject3);
          }
        }
        paramList.exposedList.removeAll(paramList.clickedList);
        if ((paramList.noExposeList != null) && (paramList.noExposeList.size() == 0))
        {
          localObject1 = paramList.noExposeList;
          paramList.noExposeList = paramList.exposedList;
          paramList.exposedList = ((List)localObject1);
        }
        paramList.convertToString();
        if (QLog.isColorLevel()) {
          QLog.i("StickerRecManager", 2, "updateSort clicked=" + paramList.clicked + " exposed=" + paramList.exposed + " noExpose=" + paramList.noExpose);
        }
        paramList.recommendType = i;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramList);
        continue;
        label382:
        paramList = new StickerRecommendSortEntity((String)localObject2);
        localObject2 = ((StickerReportItem)localObject1).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (IStickerRecEmoticon)((Iterator)localObject2).next();
          if (!((IStickerRecEmoticon)localObject3).a())
          {
            localObject3 = (StickerRecData)localObject3;
            if (((StickerRecData)localObject3).b()) {
              paramList.addClicked(Integer.valueOf(((StickerRecData)localObject3).d()));
            } else {
              paramList.addExposed(Integer.valueOf(((StickerRecData)localObject3).d()));
            }
          }
        }
        localObject1 = ((StickerReportItem)localObject1).jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (IStickerRecEmoticon)((Iterator)localObject1).next();
          if (!((IStickerRecEmoticon)localObject2).a()) {
            paramList.addNoExpose(Integer.valueOf(((StickerRecData)localObject2).d()));
          }
        }
        if ((paramList.noExposeList != null) && (paramList.noExposeList.size() == 0))
        {
          localObject1 = paramList.noExposeList;
          paramList.noExposeList = paramList.exposedList;
          paramList.exposedList = ((List)localObject1);
        }
        paramList.convertToString();
        if (QLog.isColorLevel()) {
          QLog.i("StickerRecManager", 2, "updateSort new SortEntity clicked=" + paramList.clicked + " exposed=" + paramList.exposed + " noExpose=" + paramList.noExpose);
        }
        paramList.recommendType = i;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramList);
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false)) {
      return;
    }
    d();
    ThreadManager.excute(new StickerRecManager.5(this), 128, null, true);
  }
  
  public void d()
  {
    try
    {
      File localFile = new File(b(), "words");
      this.d = new File(b(), "words.zip");
      this.jdField_a_of_type_JavaIoFile = new File(localFile, "words.json");
      this.c = new File(localFile, "encodedBloom.bin");
      this.jdField_b_of_type_JavaIoFile = new File(localFile, "local_words.bin");
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "clearOverdueStickerCache");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new StickerRecManager.10(this));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecCameraEmoticonHandleListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecCameraEmoticonHandleListener.a();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecFavoriteEmoHandleListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecFavoriteEmoHandleListener.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager
 * JD-Core Version:    0.7.0.1
 */