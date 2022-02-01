package com.tencent.mobileqq.activity.bless;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade.HongbaoParams;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class BlessManager
  implements Manager
{
  private static int jdField_a_of_type_Int;
  public static final String a;
  private long jdField_a_of_type_Long = 0L;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private BlessTask jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
  private BlessUinList jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  protected Runnable a;
  private ArrayList<BlessPtvModule> jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<String, DownloadTask> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean jdField_a_of_type_Boolean = false;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  private BlessTask jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask;
  private BlessUinList jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList;
  public String b;
  private ArrayList<BlessWording> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean = false;
  public String c;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList;
  private volatile boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bless");
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public BlessManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRunnable = new BlessManager.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(AppConstants.SDCARD_PATH);
    paramQQAppInterface.append(jdField_a_of_type_JavaLangString);
    paramQQAppInterface = paramQQAppInterface.toString();
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface;
    BlessPtvModule.path = paramQQAppInterface;
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
    paramQQAppInterface.append(File.separator);
    paramQQAppInterface.append("history");
    paramQQAppInterface.append(File.separator);
    paramQQAppInterface.append("ptvHistory");
    this.jdField_c_of_type_JavaLangString = paramQQAppInterface.toString();
    i();
    h();
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public static Date a(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private Set<String> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("bless_config", 4).getStringSet("config_list", null);
  }
  
  private void a(BlessTask paramBlessTask)
  {
    if (paramBlessTask == null) {
      return;
    }
    String[] arrayOfString = new String[11];
    arrayOfString[0] = paramBlessTask.mainBanner;
    arrayOfString[1] = paramBlessTask.mainCenter;
    arrayOfString[2] = paramBlessTask.typeBanner;
    arrayOfString[3] = paramBlessTask.succeededBanner;
    arrayOfString[4] = paramBlessTask.defaultVoice;
    arrayOfString[5] = paramBlessTask.starAvator;
    arrayOfString[6] = paramBlessTask.starVideo;
    arrayOfString[7] = paramBlessTask.recentHeadImgUrl;
    arrayOfString[8] = paramBlessTask.ptvAnimationUrl;
    arrayOfString[9] = paramBlessTask.starAvatorSimple;
    arrayOfString[10] = paramBlessTask.recentHeadImgUrlSimple;
    File[] arrayOfFile = new File(this.jdField_b_of_type_JavaLangString).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int m = 0;
    while (m < arrayOfFile.length)
    {
      if ((!arrayOfFile[m].getName().endsWith(".zip")) && (!arrayOfFile[m].isDirectory()))
      {
        int n = 0;
        int i = 0;
        int i1;
        Object localObject2;
        Object localObject1;
        for (int j = 0; n < arrayOfString.length; j = i1)
        {
          if (TextUtils.isEmpty(arrayOfString[n]))
          {
            i1 = j;
          }
          else
          {
            localObject2 = a(arrayOfString[n]);
            if (arrayOfString[n].equals(paramBlessTask.starVideo))
            {
              localObject1 = MD5Utils.encodeHexStr(arrayOfString[n]);
              k = 1;
            }
            else
            {
              k = i;
              localObject1 = localObject2;
              if (arrayOfString[n].equals(paramBlessTask.ptvAnimationUrl))
              {
                j = 1;
                localObject1 = localObject2;
                k = i;
              }
            }
            i = k;
            i1 = j;
            if (arrayOfFile[m].getName().equals(localObject1))
            {
              i = 0;
              break label321;
            }
          }
          n += 1;
        }
        n = 1;
        int k = i;
        i = n;
        label321:
        if (i != 0)
        {
          arrayOfFile[m].delete();
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("deleteOldBanner=");
            ((StringBuilder)localObject1).append(arrayOfFile[m].getName());
            QLog.d("BlessManager", 2, ((StringBuilder)localObject1).toString());
          }
          if (k != 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
            ((StringBuilder)localObject1).append(paramBlessTask.starVideoCoverFolderName);
            ((StringBuilder)localObject1).append(File.separator);
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(paramBlessTask.starVideoCoverFileName);
            localObject1 = new File(((StringBuilder)localObject2).toString());
            if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
            {
              ((File)localObject1).delete();
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("deleteOldCover=");
                ((StringBuilder)localObject2).append(((File)localObject1).getName());
                QLog.d("BlessManager", 2, ((StringBuilder)localObject2).toString());
              }
            }
          }
          if (j != 0)
          {
            localObject1 = new File(g());
            if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory())) {
              ((File)localObject1).delete();
            }
          }
        }
      }
      m += 1;
    }
  }
  
  /* Error */
  private void a(BlessTask paramBlessTask, ArrayList<BlessPtvModule> paramArrayList, ArrayList<BlessWording> paramArrayList1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 296	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   7: invokevirtual 302	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore 5
    //   12: aload 5
    //   14: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 313	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   24: aload 5
    //   26: ldc 190
    //   28: invokevirtual 317	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   31: pop
    //   32: aload_1
    //   33: ifnull +9 -> 42
    //   36: aload 5
    //   38: aload_1
    //   39: invokevirtual 321	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   42: aload 5
    //   44: ldc 101
    //   46: invokevirtual 317	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   49: pop
    //   50: aload_2
    //   51: ifnull +34 -> 85
    //   54: aload_2
    //   55: invokevirtual 327	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface 332 1 0
    //   65: ifeq +20 -> 85
    //   68: aload 5
    //   70: aload_1
    //   71: invokeinterface 336 1 0
    //   76: checkcast 101	com/tencent/mobileqq/activity/bless/BlessPtvModule
    //   79: invokevirtual 321	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   82: goto -23 -> 59
    //   85: aload 5
    //   87: ldc_w 338
    //   90: invokevirtual 317	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   93: pop
    //   94: aload_3
    //   95: ifnull +34 -> 129
    //   98: aload_3
    //   99: invokevirtual 327	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   102: astore_1
    //   103: aload_1
    //   104: invokeinterface 332 1 0
    //   109: ifeq +20 -> 129
    //   112: aload 5
    //   114: aload_1
    //   115: invokeinterface 336 1 0
    //   120: checkcast 338	com/tencent/mobileqq/activity/bless/BlessWording
    //   123: invokevirtual 321	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   126: goto -23 -> 103
    //   129: aload 4
    //   131: invokevirtual 341	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   134: invokestatic 344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   137: ifeq +25 -> 162
    //   140: ldc_w 271
    //   143: iconst_4
    //   144: ldc_w 346
    //   147: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: goto +12 -> 162
    //   153: astore_1
    //   154: goto +19 -> 173
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   162: aload 4
    //   164: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   167: aload 5
    //   169: invokevirtual 352	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   172: return
    //   173: aload 4
    //   175: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   178: goto +5 -> 183
    //   181: aload_1
    //   182: athrow
    //   183: goto -2 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	BlessManager
    //   0	186	1	paramBlessTask	BlessTask
    //   0	186	2	paramArrayList	ArrayList<BlessPtvModule>
    //   0	186	3	paramArrayList1	ArrayList<BlessWording>
    //   17	157	4	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   10	158	5	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   19	32	153	finally
    //   36	42	153	finally
    //   42	50	153	finally
    //   54	59	153	finally
    //   59	82	153	finally
    //   85	94	153	finally
    //   98	103	153	finally
    //   103	126	153	finally
    //   129	150	153	finally
    //   158	162	153	finally
    //   19	32	157	java/lang/Exception
    //   36	42	157	java/lang/Exception
    //   42	50	157	java/lang/Exception
    //   54	59	157	java/lang/Exception
    //   59	82	157	java/lang/Exception
    //   85	94	157	java/lang/Exception
    //   98	103	157	java/lang/Exception
    //   103	126	157	java/lang/Exception
    //   129	150	157	java/lang/Exception
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "refresh recent");
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
  }
  
  private void a(RecentUserProxy paramRecentUserProxy)
  {
    RecentUser localRecentUser = paramRecentUserProxy.a(AppConstants.SEND_BLESS_UIN, 9003);
    long l = NetConnInfoCenter.getServerTime();
    localRecentUser.uin = AppConstants.SEND_BLESS_UIN;
    localRecentUser.setType(9003);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    paramRecentUserProxy.b(localRecentUser);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(RecentUserProxy paramRecentUserProxy, RecentUser paramRecentUser)
  {
    paramRecentUserProxy.a(paramRecentUser);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(String paramString, BlessTask paramBlessTask, ArrayList<BlessPtvModule> paramArrayList, ArrayList<BlessWording> paramArrayList1)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processReceivedConfig newTask=");
      ((StringBuilder)localObject1).append(paramBlessTask);
      QLog.d("BlessManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label165;
        }
        localObject2 = (BlessPtvModule)((Iterator)localObject1).next();
        Iterator localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          BlessPtvModule localBlessPtvModule = (BlessPtvModule)localIterator.next();
          if (!((BlessPtvModule)localObject2).id.equals(localBlessPtvModule.id)) {
            break;
          }
          if (((BlessPtvModule)localObject2).data.equals(localBlessPtvModule.data)) {
            localBlessPtvModule.broken = ((BlessPtvModule)localObject2).broken;
          } else {
            localBlessPtvModule.broken = true;
          }
        }
      }
    }
    label165:
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localObject1 != null)
    {
      localObject1 = a(((BlessTask)localObject1).starVideo);
      localObject2 = a(paramBlessTask.starVideo);
      if ((localObject1 != null) && (((String)localObject1).equals(localObject2))) {
        paramBlessTask.videoPlayed = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed;
      }
    }
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (!TextUtils.isEmpty(paramBlessTask.starAvator)) && (!paramBlessTask.starAvator.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvator))) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (paramBlessTask.festival_id == this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.festival_id) && (paramBlessTask.task_id == this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.task_id))
    {
      paramBlessTask.isNew = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew;
      paramBlessTask.isDeleted = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask = paramBlessTask;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList1;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
    a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, false);
    d(this.jdField_c_of_type_Boolean);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.b();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    BlessUinList.a((SharedPreferences)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList, 1);
    a(paramBlessTask, paramArrayList, paramArrayList1);
    ((SharedPreferences)localObject1).edit().remove("bless_send_wording").commit();
    this.jdField_d_of_type_JavaLangString = null;
    b(paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication()) == 0)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("download 2g give up ");
        paramString1.append(paramString2);
        QLog.d("BlessManager", 2, paramString1.toString());
      }
      return;
    }
    DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
    if (localDownloadTask != null) {
      if ((localDownloadTask.a() != 2) && (localDownloadTask.a() != 3))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("download task status error, cancel it ");
          ((StringBuilder)localObject).append(paramString2);
          QLog.d("BlessManager", 2, ((StringBuilder)localObject).toString());
        }
        localDownloadTask.a(true);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("download duplicated ");
          paramString1.append(paramString2);
          QLog.d("BlessManager", 2, paramString1.toString());
        }
        return;
      }
    }
    localDownloadTask = new DownloadTask(paramString1, new File(paramString2));
    localDownloadTask.n = true;
    Object localObject = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownload: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" path=");
      localStringBuilder.append(paramString2);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, localDownloadTask);
    ((DownloaderInterface)localObject).startDownload(localDownloadTask, new BlessManager.3(this, paramString2, paramString1), null);
  }
  
  private void a(ArrayList<BlessPtvModule> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    File[] arrayOfFile = new File(this.jdField_b_of_type_JavaLangString).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      if ((arrayOfFile[i].getName().endsWith(".zip")) && (!arrayOfFile[i].isDirectory()))
      {
        Object localObject1 = null;
        Object localObject2 = paramArrayList.iterator();
        int j;
        for (;;)
        {
          boolean bool = ((Iterator)localObject2).hasNext();
          j = 1;
          if (!bool) {
            break;
          }
          BlessPtvModule localBlessPtvModule = (BlessPtvModule)((Iterator)localObject2).next();
          localObject1 = localBlessPtvModule.id;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(localBlessPtvModule.id);
          ((StringBuilder)localObject3).append(".zip");
          localObject3 = ((StringBuilder)localObject3).toString();
          if (arrayOfFile[i].getName().equals(localObject3))
          {
            if (localBlessPtvModule.broken)
            {
              localBlessPtvModule.broken = false;
              break;
            }
            j = 0;
            break;
          }
        }
        if (j != 0)
        {
          arrayOfFile[i].delete();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject2).append((String)localObject1);
          FileUtils.deleteDirectory(((StringBuilder)localObject2).toString());
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("deleteOldModules=");
            ((StringBuilder)localObject1).append(arrayOfFile[i].getName());
            QLog.d("BlessManager", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      i += 1;
    }
  }
  
  private boolean a(BlessTask paramBlessTask, boolean paramBoolean)
  {
    if (paramBlessTask == null) {
      return false;
    }
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = new ArrayList(Arrays.asList(new String[] { paramBlessTask.starAvator, paramBlessTask.starVideo }));
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramBlessTask.starAvatorSimple))
      {
        ((ArrayList)localObject2).add(paramBlessTask.starAvatorSimple);
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject2 = new ArrayList(Arrays.asList(new String[] { paramBlessTask.mainBanner, paramBlessTask.mainCenter, paramBlessTask.typeBanner, paramBlessTask.succeededBanner, paramBlessTask.defaultVoice }));
      if (!TextUtils.isEmpty(paramBlessTask.recentHeadImgUrl)) {
        ((ArrayList)localObject2).add(paramBlessTask.recentHeadImgUrl);
      }
      if (!TextUtils.isEmpty(paramBlessTask.recentHeadImgUrlSimple)) {
        ((ArrayList)localObject2).add(paramBlessTask.recentHeadImgUrlSimple);
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramBlessTask.ptvAnimationUrl))
      {
        ((ArrayList)localObject2).add(paramBlessTask.ptvAnimationUrl);
        localObject1 = localObject2;
      }
    }
    Object localObject2 = ((ArrayList)localObject1).iterator();
    paramBoolean = true;
    if (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      localObject1 = a(str);
      int i;
      if ((!TextUtils.isEmpty(str)) && (str.equals(paramBlessTask.starVideo)))
      {
        localObject1 = MD5Utils.encodeHexStr(str);
        paramBlessTask.ex1 = ((String)localObject1);
        i = 1;
      }
      else
      {
        i = 0;
      }
      if (localObject1 == null)
      {
        if (QLog.isColorLevel())
        {
          paramBlessTask = new StringBuilder();
          paramBlessTask.append("checkBannersReady error banner: ");
          paramBlessTask.append(str);
          QLog.d("BlessManager", 2, paramBlessTask.toString());
        }
        return false;
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject3 = ((StringBuilder)localObject3).toString();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkBannersReady: ");
        localStringBuilder.append(str);
        localStringBuilder.append(" urlPath=");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append("  fileName=");
        localStringBuilder.append((String)localObject1);
        QLog.d("BlessManager", 2, localStringBuilder.toString());
      }
      if (!new File((String)localObject3).exists())
      {
        a(str, (String)localObject3);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("checkBannersReady no banner: ");
          ((StringBuilder)localObject1).append((String)localObject3);
          QLog.d("BlessManager", 2, ((StringBuilder)localObject1).toString());
        }
      }
      for (;;)
      {
        paramBoolean = false;
        break;
        if (i == 0) {
          break;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(paramBlessTask.starVideoCoverFolderName);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(paramBlessTask.starVideoCoverFileName);
        localObject1 = ((StringBuilder)localObject1).toString();
        if ((!VersionUtils.d()) || (new File((String)localObject1).exists())) {
          break;
        }
        k();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("checkAllDownloaded no cover: ");
          ((StringBuilder)localObject1).append((String)localObject3);
          QLog.d("BlessManager", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    return paramBoolean;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = a(paramString1);
    Date localDate = a(paramString2);
    if (localObject != null)
    {
      if (localDate == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isInTime now=");
        localStringBuilder.append(l);
        localStringBuilder.append("  beginDate.getTime():");
        localStringBuilder.append(((Date)localObject).getTime());
        localStringBuilder.append("  endDate.getTime():");
        localStringBuilder.append(localDate.getTime());
        QLog.d("BlessManager", 2, localStringBuilder.toString());
      }
      if ((l > ((Date)localObject).getTime()) && (l < localDate.getTime())) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("not in time");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("BlessManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  private void b(String paramString)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("bless_config", 4).edit();
    localEditor.putString("config_content", paramString);
    localEditor.commit();
  }
  
  private void b(Set<String> paramSet)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("bless_config", 4).edit();
    if (paramSet == null) {
      localEditor.remove("config_list");
    } else {
      localEditor.putStringSet("config_list", paramSet);
    }
    localEditor.commit();
  }
  
  private void d(boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.SEND_BLESS_UIN, 9003);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    boolean bool = true;
    if (localObject != null)
    {
      localObject = this.jdField_b_of_type_JavaUtilArrayList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        i = 1;
        break label66;
      }
    }
    int i = 0;
    label66:
    if ((i == 0) || (!c()) || (!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted)) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initEntrance show=");
      localStringBuilder.append(bool);
      localStringBuilder.append(" hasConfig=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" task=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
      localStringBuilder.append(" isDeleted=");
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = Boolean.valueOf(((BlessTask)localObject).isDeleted);
      }
      localStringBuilder.append(localObject);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      if (localRecentUser == null)
      {
        a(localRecentUserProxy);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew)
      {
        a(localRecentUserProxy, localRecentUser);
        a(localRecentUserProxy);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew = false;
      return;
    }
    if (localRecentUser != null) {
      a(localRecentUserProxy, localRecentUser);
    }
  }
  
  public static int g()
  {
    if (jdField_a_of_type_Int <= 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
        jdField_a_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
      } else {
        jdField_a_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
      }
    }
    return jdField_a_of_type_Int;
  }
  
  private void h()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList = BlessUinList.a((SharedPreferences)localObject1, 1);
    this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList = BlessUinList.a((SharedPreferences)localObject1, 2);
    Object localObject2 = null;
    Object localObject3 = SharedPreferencesHandler.a((SharedPreferences)localObject1, "bless_uin_to_send", null);
    if (localObject3 != null) {
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList((Collection)localObject3);
    } else {
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_d_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("bless_send_wording", null);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("initUinSendRecordFromSp sendWording=");
      ((StringBuilder)localObject3).append(this.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject3).append(" uinListToSend=");
      localObject1 = this.jdField_c_of_type_JavaUtilArrayList;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      }
      ((StringBuilder)localObject3).append(localObject1);
      ((StringBuilder)localObject3).append(" blessUinList=");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = Integer.valueOf(((BlessUinList)localObject1).a());
      }
      ((StringBuilder)localObject3).append(localObject1);
      ((StringBuilder)localObject3).append(" webUinList=");
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList;
      if (localObject1 == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = Integer.valueOf(((BlessUinList)localObject1).a());
      }
      ((StringBuilder)localObject3).append(localObject1);
      QLog.d("BlessManager", 2, ((StringBuilder)localObject3).toString());
    }
  }
  
  public static String i()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("bless_config", 4).getString("config_content", "");
  }
  
  private void i()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = (ArrayList)((EntityManager)localObject1).query(BlessTask.class, new BlessTask().getTableName(), false, null, null, null, null, null, null);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask = ((BlessTask)((ArrayList)localObject2).get(0));
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)((EntityManager)localObject1).query(BlessPtvModule.class, new BlessPtvModule().getTableName(), false, null, null, null, null, null, null));
    this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)((EntityManager)localObject1).query(BlessWording.class, new BlessWording().getTableName(), false, null, null, null, null, null, null));
    ((EntityManager)localObject1).close();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initTaskAndModuleFromDB task=");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
      if (localObject1 != null) {
        localObject1 = ((BlessTask)localObject1).toString();
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(" blessWordings=");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaUtilArrayList);
      ((StringBuilder)localObject2).append(" module=");
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      }
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("BlessManager", 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localObject1 != null)
    {
      this.jdField_c_of_type_Boolean = a((BlessTask)localObject1, false);
      d(this.jdField_c_of_type_Boolean);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, true);
      return;
    }
    d(false);
  }
  
  private boolean i()
  {
    String str1 = d();
    String str2 = c();
    if ((str1 != null) && (str2 != null)) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isStarVideoFileReady() videoCoverPath=");
      localStringBuilder.append(str1);
      localStringBuilder.append(", videoPath=");
      localStringBuilder.append(str2);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  private void j()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if ((localObject1 != null) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      localObject1 = ((BlessTask)localObject1).mainBanner;
      int j = 0;
      localObject1 = new ArrayList(Arrays.asList(new String[] { localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainCenter, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.typeBanner, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.succeededBanner, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.defaultVoice }));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl != null) {
        ((ArrayList)localObject1).add(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrlSimple != null) {
        ((ArrayList)localObject1).add(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrlSimple);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl != null) {
        ((ArrayList)localObject1).add(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl);
      }
      Object localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject2).next();
        localObject1 = a((String)localObject3);
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideo)))
        {
          localObject1 = MD5Utils.encodeHexStr((String)localObject3);
          i = 1;
        }
        else
        {
          i = 0;
        }
        if (localObject1 == null)
        {
          d(false);
          return;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject3).toString();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (!new File((String)localObject1).exists())
            {
              i = j;
              if (!QLog.isColorLevel()) {
                break label477;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("checkAllDownloaded no banner: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("BlessManager", 2, ((StringBuilder)localObject2).toString());
              i = j;
              break label477;
            }
            if (i != 0)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaLangString);
              ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFolderName);
              ((StringBuilder)localObject3).append(File.separator);
              ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFileName);
              localObject3 = ((StringBuilder)localObject3).toString();
              if ((VersionUtils.d()) && (!new File((String)localObject3).exists()))
              {
                i = j;
                if (!QLog.isColorLevel()) {
                  break label477;
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("checkAllDownloaded no cover: ");
                ((StringBuilder)localObject2).append((String)localObject1);
                QLog.d("BlessManager", 2, ((StringBuilder)localObject2).toString());
                i = j;
                break label477;
              }
            }
          }
        }
      }
      int i = 1;
      label477:
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "check Modules and banners all ready");
        }
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.jdField_c_of_type_Boolean = true;
          d(true);
        }
      }
    }
  }
  
  @TargetApi(10)
  private void k()
  {
    if ((VersionUtils.d()) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.post(new BlessManager.4(this), 5, null, false);
    }
  }
  
  public int a()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localBlessTask == null) {
      return -1;
    }
    if (localBlessTask.unread > 1) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread;
  }
  
  public Drawable a()
  {
    Object localObject2 = BaseApplication.getContext().getResources().getDrawable(2130838760);
    boolean bool = QQTheme.f();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    Object localObject1 = localObject2;
    int i;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((BlessTask)localObject3).recentHeadImgUrl != null)
      {
        if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_d_of_type_Boolean != bool))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl;
          localObject1 = localObject3;
          if (bool)
          {
            localObject1 = localObject3;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrlSimple)) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrlSimple;
            }
          }
          localObject1 = a((String)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaLangString);
            ((StringBuilder)localObject3).append((String)localObject1);
            localObject1 = ((StringBuilder)localObject3).toString();
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            i = AIOUtils.b(50.0F, BaseApplication.getContext().getResources());
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject3);
          }
        }
        localObject3 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          this.jdField_d_of_type_Boolean = bool;
          localObject1 = localObject3;
        }
      }
    }
    localObject2 = localObject1;
    if (h())
    {
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_d_of_type_Boolean != bool))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvator;
        localObject2 = localObject3;
        if (bool)
        {
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvatorSimple)) {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvatorSimple;
          }
        }
        localObject2 = a((String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject2 = ((StringBuilder)localObject3).toString();
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          i = AIOUtils.b(50.0F, BaseApplication.getContext().getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawable.getDrawable(new File((String)localObject2), (URLDrawable.URLDrawableOptions)localObject3);
        }
      }
      localObject3 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        this.jdField_d_of_type_Boolean = bool;
        localObject2 = localObject3;
      }
    }
    return localObject2;
  }
  
  public ChatActivityFacade.HongbaoParams a(int paramInt1, int paramInt2)
  {
    ChatActivityFacade.HongbaoParams localHongbaoParams = new ChatActivityFacade.HongbaoParams();
    localHongbaoParams.jdField_a_of_type_Int = 0;
    if (paramInt1 == 2) {
      localHongbaoParams.jdField_b_of_type_Int = 1;
    } else if (paramInt1 == 3) {
      localHongbaoParams.jdField_b_of_type_Int = 4;
    } else {
      localHongbaoParams.jdField_b_of_type_Int = 0;
    }
    localHongbaoParams.jdField_b_of_type_Long = paramInt2;
    return localHongbaoParams;
  }
  
  public BlessTask a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
  }
  
  public MessageForShortVideo a()
  {
    MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPtvMessage: ");
      localStringBuilder.append(localMessageForShortVideo);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
    return localMessageForShortVideo;
  }
  
  public Boolean a()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localBlessTask == null) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(localBlessTask.ptvAnimationSwtich);
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localObject == null) {
      return null;
    }
    localObject = a(((BlessTask)localObject).mainCenter);
    if (localObject == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public String a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localObject == null) {
      return null;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        localObject = null;
      } else {
        localObject = a(((BlessTask)localObject).succeededBanner);
      }
    }
    else {
      localObject = a(((BlessTask)localObject).mainBanner);
    }
    if (localObject == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public String a(String paramString)
  {
    for (;;)
    {
      try
      {
        String str;
        if (paramString.startsWith("http://"))
        {
          str = paramString.substring(7, paramString.length());
        }
        else
        {
          str = paramString;
          if (!paramString.startsWith("https://")) {
            continue;
          }
          str = paramString.substring(8, paramString.length());
        }
        int i = str.lastIndexOf('/');
        if (i == -1) {
          return null;
        }
        int j = str.substring(0, i).lastIndexOf('/');
        if (j != -1)
        {
          i = j;
          j = str.lastIndexOf("?");
          if (j > i) {
            return str.substring(i + 1, j);
          }
          str = str.substring(i + 1);
          return str;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFileNameFromUrl failed: ");
          localStringBuilder.append(paramString);
          QLog.d("BlessManager", 2, localStringBuilder.toString(), localThrowable);
        }
        return null;
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e());
    localStringBuilder.append("&uuid=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&md5=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&nick=");
    paramString1 = localStringBuilder.toString();
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(Base64Util.encodeToString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname().getBytes(), 2));
    return paramString2.toString();
  }
  
  public String a(boolean paramBoolean)
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localBlessTask == null) {
      return "";
    }
    if (paramBoolean) {
      return localBlessTask.shareQzoneTitle;
    }
    return localBlessTask.shareWeixinTitle;
  }
  
  public ArrayList<String> a()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "clearBlessConfigs");
    }
    b(null);
    a(null, null, null);
    d(false);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return;
    }
    int i = paramInt1;
    if (paramInt2 == localArrayList.size() + 1) {
      i = paramInt1 - 1;
    }
    if ((i >= 0) && (i < this.jdField_b_of_type_JavaUtilArrayList.size())) {
      ((BlessWording)this.jdField_b_of_type_JavaUtilArrayList.get(i)).setEditingWording(paramString);
    }
  }
  
  public void a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 3000L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    String str = h();
    Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    localIntent.putExtra("url", str);
    WebAccelerator.a(paramContext, localIntent, str);
  }
  
  public void a(BlessPtvModule paramBlessPtvModule, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteOneModuleFile ");
      localStringBuilder.append(paramBlessPtvModule.id);
      localStringBuilder.append(" del zip=");
      localStringBuilder.append(paramBoolean);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(paramBlessPtvModule.id);
    FileUtils.deleteDirectory(localStringBuilder.toString());
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(paramBlessPtvModule.id);
      localStringBuilder.append(".zip");
      FileUtils.deleteFile(localStringBuilder.toString());
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPtvMessage: ");
      localStringBuilder.append(paramMessageForShortVideo);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    String str = paramString;
    if (localArrayList != null)
    {
      str = paramString;
      if (localArrayList.size() > 0)
      {
        str = paramString;
        if (paramString.equals(((BlessWording)this.jdField_b_of_type_JavaUtilArrayList.get(0)).wording)) {
          str = "";
        }
      }
    }
    paramString = this.jdField_d_of_type_JavaLangString;
    if ((paramString != null) && (paramString.equals(str))) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = str;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    paramString.putString("bless_send_wording", str);
    paramString.commit();
  }
  
  public void a(ArrayList<String> paramArrayList, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str;
    if (paramInt == 1)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        str = (String)paramArrayList.next();
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a(str);
      }
      BlessUinList.a(localSharedPreferences, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList, 1);
      return;
    }
    if (paramInt == 2)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        str = (String)paramArrayList.next();
        this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.a(str);
      }
      BlessUinList.a(localSharedPreferences, this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList, 2);
    }
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.addAll(paramList);
    SharedPreferencesHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit(), "bless_uin_to_send", paramList.toArray()).commit();
  }
  
  public void a(Set<String> paramSet)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject1 = paramSet.iterator();
    Object localObject9 = null;
    Object localObject2 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject5;
    for (Object localObject3 = null; ((Iterator)localObject1).hasNext(); localObject3 = localObject5)
    {
      String str = (String)((Iterator)localObject1).next();
      BlessTask localBlessTask = new BlessTask();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      boolean bool = BlessTask.parse(str, localBlessTask, localArrayList2, localArrayList1);
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("onNewConfigReceived tmpNewTask=");
        ((StringBuilder)localObject5).append(localBlessTask);
        ((StringBuilder)localObject5).append(" tmpNewBlessWordings=");
        ((StringBuilder)localObject5).append(localArrayList1.size());
        ((StringBuilder)localObject5).append(" tmpNewPtvModules=");
        ((StringBuilder)localObject5).append(localArrayList2.size());
        ((StringBuilder)localObject5).append(" result=");
        ((StringBuilder)localObject5).append(bool);
        QLog.d("BlessManager", 2, ((StringBuilder)localObject5).toString());
      }
      Object localObject11 = localObject9;
      Object localObject10 = localObject2;
      Object localObject8 = localObject6;
      Object localObject7 = localObject4;
      localObject5 = localObject3;
      if (bool)
      {
        Date localDate1 = a(localBlessTask.entranceBegin);
        Date localDate2 = a(localBlessTask.entranceEnd);
        localObject11 = localObject9;
        localObject10 = localObject2;
        localObject8 = localObject6;
        localObject7 = localObject4;
        localObject5 = localObject3;
        if (localDate1 != null)
        {
          localObject11 = localObject9;
          localObject10 = localObject2;
          localObject8 = localObject6;
          localObject7 = localObject4;
          localObject5 = localObject3;
          if (localDate2 != null)
          {
            localObject11 = localObject9;
            localObject10 = localObject2;
            localObject8 = localObject6;
            localObject7 = localObject4;
            localObject5 = localObject3;
            if (localDate2.getTime() >= l1) {
              if (localBlessTask.entranceEnabled != 1)
              {
                localObject11 = localObject9;
                localObject10 = localObject2;
                localObject8 = localObject6;
                localObject7 = localObject4;
                localObject5 = localObject3;
              }
              else
              {
                localArrayList3.add(localBlessTask);
                if ((localObject2 != null) && (localObject3 != null))
                {
                  if (localDate1.getTime() > ((Date)localObject3).getTime())
                  {
                    localObject11 = localObject9;
                    localObject10 = localObject2;
                    localObject8 = localObject6;
                    localObject7 = localObject4;
                    localObject5 = localObject3;
                    if (localDate1.getTime() > l1) {
                      break label488;
                    }
                  }
                  if ((localDate1.getTime() < ((Date)localObject3).getTime()) && (((Date)localObject3).getTime() < l1))
                  {
                    localObject11 = localObject9;
                    localObject10 = localObject2;
                    localObject8 = localObject6;
                    localObject7 = localObject4;
                    localObject5 = localObject3;
                    break label488;
                  }
                }
                localObject5 = localDate1;
                localObject8 = localArrayList2;
                localObject7 = localArrayList1;
                localObject10 = localBlessTask;
                localObject11 = str;
              }
            }
          }
        }
      }
      label488:
      localObject9 = localObject11;
      localObject2 = localObject10;
      localObject6 = localObject8;
      localObject4 = localObject7;
    }
    if ((localObject9 != null) && (localObject2 != null)) {
      a(localObject9, localObject2, (ArrayList)localObject6, (ArrayList)localObject4);
    } else {
      a();
    }
    if (localArrayList3.size() > 1)
    {
      if (localObject2 != null)
      {
        localObject4 = a(localObject2.entranceBegin);
        l1 = 9223372036854775807L;
        localObject5 = localArrayList3.iterator();
        localObject1 = null;
        while (((Iterator)localObject5).hasNext())
        {
          localObject3 = (BlessTask)((Iterator)localObject5).next();
          if (localObject3 != localObject2)
          {
            localObject6 = a(((BlessTask)localObject3).entranceBegin);
            if ((localObject6 != null) && (localObject4 != null))
            {
              long l2 = ((Date)localObject6).getTime() - ((Date)localObject4).getTime();
              if ((l2 > 0L) && (l2 < l1))
              {
                localObject1 = localObject3;
                l1 = l2;
              }
            }
          }
        }
      }
      else
      {
        localObject1 = null;
      }
      b(paramSet);
    }
    else
    {
      localObject1 = null;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask = ((BlessTask)localObject1);
    if (QLog.isColorLevel())
    {
      paramSet = new StringBuilder();
      paramSet.append("onNewConfigReceived validCount=");
      paramSet.append(localArrayList3.size());
      paramSet.append("  nextTask:");
      paramSet.append(this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask);
      QLog.d("BlessManager", 2, paramSet.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().b(AppConstants.SEND_BLESS_UIN, 9003) != null;
  }
  
  public boolean a(BlessPtvModule paramBlessPtvModule)
  {
    if (paramBlessPtvModule == null) {
      return false;
    }
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(paramBlessPtvModule.id);
      ((StringBuilder)localObject).append(".zip");
      localObject = ((StringBuilder)localObject).toString();
      a(paramBlessPtvModule, false);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(paramBlessPtvModule.id);
      localStringBuilder.append(File.separator);
      FileUtils.uncompressZip((String)localObject, localStringBuilder.toString(), false);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("un compressZip success: ");
        localStringBuilder.append((String)localObject);
        QLog.d("BlessManager", 2, localStringBuilder.toString());
      }
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("un compressZip failed: ");
        localStringBuilder.append(localException.getMessage());
        QLog.d("BlessManager", 2, localStringBuilder.toString());
      }
      a(paramBlessPtvModule, true);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a(paramString);
  }
  
  public int b()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localBlessTask == null) {
      return 0;
    }
    if (localBlessTask.unread >= 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "getUnreadNum=1");
      }
      return 1;
    }
    return 0;
  }
  
  public String b()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localBlessTask == null) {
      return "";
    }
    return localBlessTask.entranceHint;
  }
  
  public ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      localArrayList.add(this.jdField_d_of_type_JavaLangString);
    }
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BlessWording localBlessWording = (BlessWording)((Iterator)localObject).next();
        if (localBlessWording.hasEditingWording()) {
          localArrayList.add(localBlessWording.getEditingWording());
        } else {
          localArrayList.add(localBlessWording.wording);
        }
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    SharedPreferencesHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit(), "bless_uin_to_send", new String[0]).commit();
  }
  
  /* Error */
  public void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: iload_1
    //   11: ifeq +11 -> 22
    //   14: aload_2
    //   15: getfield 780	com/tencent/mobileqq/activity/bless/BlessTask:unread	I
    //   18: ifne +9 -> 27
    //   21: return
    //   22: aload_2
    //   23: iconst_1
    //   24: putfield 420	com/tencent/mobileqq/activity/bless/BlessTask:videoPlayed	Z
    //   27: aload_0
    //   28: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   31: getfield 780	com/tencent/mobileqq/activity/bless/BlessTask:unread	I
    //   34: iconst_m1
    //   35: if_icmpne +13 -> 48
    //   38: aload_0
    //   39: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   42: getfield 420	com/tencent/mobileqq/activity/bless/BlessTask:videoPlayed	Z
    //   45: ifeq +131 -> 176
    //   48: invokestatic 344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   51: ifeq +62 -> 113
    //   54: new 32	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   61: astore_2
    //   62: aload_2
    //   63: ldc_w 1049
    //   66: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_2
    //   71: aload_0
    //   72: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   75: getfield 780	com/tencent/mobileqq/activity/bless/BlessTask:unread	I
    //   78: invokevirtual 994	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: ldc_w 1051
    //   86: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_2
    //   91: aload_0
    //   92: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   95: getfield 420	com/tencent/mobileqq/activity/bless/BlessTask:videoPlayed	Z
    //   98: invokevirtual 649	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: ldc_w 271
    //   105: iconst_4
    //   106: aload_2
    //   107: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_0
    //   114: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   117: iconst_m1
    //   118: putfield 780	com/tencent/mobileqq/activity/bless/BlessTask:unread	I
    //   121: aload_0
    //   122: getfield 92	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   125: invokevirtual 296	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   128: invokevirtual 302	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   131: astore_3
    //   132: aload_3
    //   133: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   136: astore_2
    //   137: aload_2
    //   138: invokevirtual 313	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   141: aload_3
    //   142: aload_0
    //   143: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   146: invokevirtual 1055	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   149: pop
    //   150: aload_2
    //   151: invokevirtual 341	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   154: goto +14 -> 168
    //   157: astore_3
    //   158: goto +19 -> 177
    //   161: astore 4
    //   163: aload 4
    //   165: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   168: aload_2
    //   169: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   172: aload_3
    //   173: invokevirtual 352	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   176: return
    //   177: aload_2
    //   178: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   181: aload_3
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	BlessManager
    //   0	183	1	paramBoolean	boolean
    //   4	174	2	localObject1	Object
    //   131	11	3	localEntityManager	EntityManager
    //   157	25	3	localObject2	Object
    //   161	3	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   137	154	157	finally
    //   163	168	157	finally
    //   137	154	161	java/lang/Exception
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          i = 1;
          break label46;
        }
      }
    }
    int i = 0;
    label46:
    return (i != 0) && (c()) && (this.jdField_c_of_type_Boolean);
  }
  
  public boolean b(String paramString)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    return this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.a(paramString);
  }
  
  public int c()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localBlessTask == null) {
      return 100;
    }
    return localBlessTask.uinTotalLimit;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return null;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ex1));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getStarVideoPath: ");
      localStringBuilder.append((String)localObject1);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
    if (!((File)localObject2).exists())
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getStarVideoPath: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" not exist");
        QLog.d("BlessManager", 2, ((StringBuilder)localObject2).toString());
      }
      return null;
    }
    return localObject1;
  }
  
  public void c()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BlessWording)((Iterator)localObject).next()).setEditingWording(null);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPushCmd: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      d();
      return;
    }
    e();
  }
  
  public boolean c()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    boolean bool2 = false;
    if (localBlessTask == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "isEntranceTime");
    }
    boolean bool1 = bool2;
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceBegin, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnd))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnabled == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    return c() - this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFolderName);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFileName);
    localObject = ((StringBuilder)localObject).toString();
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getStartVideoCoverPath: ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" not exist");
        QLog.d("BlessManager", 2, localStringBuilder.toString());
      }
      return null;
    }
    return localObject;
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +99 -> 105
    //   9: aload_1
    //   10: getfield 432	com/tencent/mobileqq/activity/bless/BlessTask:isDeleted	Z
    //   13: ifne +92 -> 105
    //   16: invokestatic 344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   19: ifeq +13 -> 32
    //   22: ldc_w 271
    //   25: iconst_4
    //   26: ldc_w 1078
    //   29: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   36: iconst_1
    //   37: putfield 432	com/tencent/mobileqq/activity/bless/BlessTask:isDeleted	Z
    //   40: aload_0
    //   41: getfield 92	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   44: invokevirtual 296	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   47: invokevirtual 302	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 313	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   60: aload_2
    //   61: aload_0
    //   62: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   65: invokevirtual 1055	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   68: pop
    //   69: aload_1
    //   70: invokevirtual 341	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   73: goto +12 -> 85
    //   76: astore_2
    //   77: goto +22 -> 99
    //   80: astore_3
    //   81: aload_3
    //   82: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   85: aload_1
    //   86: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   89: aload_2
    //   90: invokevirtual 352	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   93: aload_0
    //   94: iconst_0
    //   95: invokespecial 185	com/tencent/mobileqq/activity/bless/BlessManager:d	(Z)V
    //   98: return
    //   99: aload_1
    //   100: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   103: aload_2
    //   104: athrow
    //   105: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	BlessManager
    //   4	96	1	localObject1	Object
    //   50	11	2	localEntityManager	EntityManager
    //   76	28	2	localObject2	Object
    //   80	2	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   56	73	76	finally
    //   81	85	76	finally
    //   56	73	80	java/lang/Exception
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "isStarTime");
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starBegin, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starEnd);
  }
  
  public int e()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localBlessTask == null) {
      return 100;
    }
    return localBlessTask.sendTotalLimit;
  }
  
  public String e()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if ((localBlessTask != null) && (!TextUtils.isEmpty(localBlessTask.shareUrl))) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareUrl;
    }
    return "https://wa.qq.com/qfzf/index.html?_wv=16777217&adtag=main";
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +94 -> 100
    //   9: aload_1
    //   10: getfield 432	com/tencent/mobileqq/activity/bless/BlessTask:isDeleted	Z
    //   13: ifeq +87 -> 100
    //   16: invokestatic 344	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   19: ifeq +13 -> 32
    //   22: ldc_w 271
    //   25: iconst_4
    //   26: ldc_w 1096
    //   29: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   36: iconst_0
    //   37: putfield 432	com/tencent/mobileqq/activity/bless/BlessTask:isDeleted	Z
    //   40: aload_0
    //   41: getfield 92	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   44: invokevirtual 296	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   47: invokevirtual 302	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 313	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   60: aload_2
    //   61: aload_0
    //   62: getfield 131	com/tencent/mobileqq/activity/bless/BlessManager:jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   65: invokevirtual 1055	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   68: pop
    //   69: aload_1
    //   70: invokevirtual 341	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   73: goto +12 -> 85
    //   76: astore_2
    //   77: goto +17 -> 94
    //   80: astore_3
    //   81: aload_3
    //   82: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   85: aload_1
    //   86: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   89: aload_2
    //   90: invokevirtual 352	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   93: return
    //   94: aload_1
    //   95: invokevirtual 349	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   98: aload_2
    //   99: athrow
    //   100: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	BlessManager
    //   4	91	1	localObject1	Object
    //   50	11	2	localEntityManager	EntityManager
    //   76	23	2	localObject2	Object
    //   80	2	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   56	73	76	finally
    //   81	85	76	finally
    //   56	73	80	java/lang/Exception
  }
  
  public boolean e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    boolean bool3 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.BlessPTVEnable.name()).equals("1");
    boolean bool4 = VideoEnvironment.supportShortVideoRecordAndPlay();
    boolean bool5 = VideoEnvironment.isX86Platform();
    boolean bool6 = VcSystemInfo.isBeautySupported();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isPTVEnabled task=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled);
      ((StringBuilder)localObject).append(" ptvRecord=");
      ((StringBuilder)localObject).append(bool4);
      ((StringBuilder)localObject).append(" isX86=");
      ((StringBuilder)localObject).append(bool5);
      ((StringBuilder)localObject).append(" frontCamera=");
      ((StringBuilder)localObject).append(true);
      QLog.d("BlessManager", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled == 1)
    {
      bool1 = bool2;
      if (bool4)
      {
        bool1 = bool2;
        if (!bool5)
        {
          bool1 = bool2;
          if (bool6)
          {
            bool1 = bool2;
            if (!bool3) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    int j = e();
    int i = j;
    if (j > 0) {
      i = j - this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.b();
    }
    return i;
  }
  
  public String f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    String str = "";
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((BlessTask)localObject).ptvAnimationUrl)) {
        return "";
      }
      str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl);
      if (str == null) {
        return "";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(str);
      str = ((StringBuilder)localObject).toString();
    }
    return str;
  }
  
  public void f()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("check entrance.  nextTask:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask);
      QLog.d("BlessManager", 2, ((StringBuilder)localObject).toString());
    }
    if (!c())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      RecentUser localRecentUser = ((RecentUserProxy)localObject).b(AppConstants.SEND_BLESS_UIN, 9003);
      if (localRecentUser != null) {
        a((RecentUserProxy)localObject, localRecentUser);
      }
    }
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if ((localObject != null) && (a(((BlessTask)localObject).entranceBegin, this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnd)) && (this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnabled == 1) && (!this.e))
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean f()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localBlessTask == null) {
      return true;
    }
    return localBlessTask.ptvEnabled != 1;
  }
  
  public String g()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    String str = "";
    Object localObject1 = str;
    if (localObject2 != null)
    {
      if (TextUtils.isEmpty(((BlessTask)localObject2).ptvAnimationUrl)) {
        return "";
      }
      localObject2 = f();
      localObject1 = str;
      if (((String)localObject2).endsWith(".zip"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((String)localObject2).substring(0, ((String)localObject2).length() - 4));
        ((StringBuilder)localObject1).append(File.separator);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    return localObject1;
  }
  
  public void g()
  {
    ThreadManager.post(new BlessManager.5(this), 5, null, true);
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int h()
  {
    return 100;
  }
  
  public String h()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if ((localBlessTask != null) && (!TextUtils.isEmpty(localBlessTask.webBlessUrl))) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.webBlessUrl;
    }
    return "https://ti.qq.com/mass-blessing/index.html?_wv=16777223";
  }
  
  public boolean h()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    boolean bool2 = false;
    if (localBlessTask == null) {
      return false;
    }
    if (!VersionUtils.d()) {
      return false;
    }
    boolean bool1 = bool2;
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed)
    {
      bool1 = bool2;
      if (d())
      {
        bool1 = bool2;
        if (i()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int i()
  {
    return 30;
  }
  
  public int j()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    return i() - this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
  }
  
  public int k()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    int j = h();
    int i = j;
    if (j > 0) {
      i = j - this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.b();
    }
    return i;
  }
  
  public int l()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localBlessTask == null) {
      return 1;
    }
    return localBlessTask.ptvAnimationCount;
  }
  
  public int m()
  {
    BlessTask localBlessTask = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
    if (localBlessTask == null) {
      return 2000;
    }
    return localBlessTask.ptvAnimationCost;
  }
  
  public void onDestroy()
  {
    Object localObject = (DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
    if (localObject != null)
    {
      localObject = ((DownloaderFactory)localObject).a(1);
      if (localObject != null) {
        ((DownloaderInterface)localObject).cancelTask(true, null);
      }
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager
 * JD-Core Version:    0.7.0.1
 */