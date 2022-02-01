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
  public static final String a;
  private static int y;
  public String b;
  public String c;
  protected Runnable d = new BlessManager.1(this);
  private QQAppInterface e;
  private BlessTask f;
  private ArrayList<BlessPtvModule> g;
  private ArrayList<BlessWording> h;
  private BlessTask i;
  private ConcurrentHashMap<String, DownloadTask> j = new ConcurrentHashMap();
  private volatile boolean k = false;
  private BlessUinList l;
  private BlessUinList m;
  private ArrayList<String> n;
  private boolean o = false;
  private volatile boolean p = false;
  private AtomicBoolean q = new AtomicBoolean(false);
  private String r;
  private MessageForShortVideo s;
  private Drawable t = null;
  private Drawable u = null;
  private long v = 0L;
  private boolean w = false;
  private boolean x = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bless");
    localStringBuilder.append(File.separator);
    a = localStringBuilder.toString();
  }
  
  public BlessManager(QQAppInterface paramQQAppInterface)
  {
    this.e = paramQQAppInterface;
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(AppConstants.SDCARD_PATH);
    paramQQAppInterface.append(a);
    paramQQAppInterface = paramQQAppInterface.toString();
    this.b = paramQQAppInterface;
    BlessPtvModule.path = paramQQAppInterface;
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(this.b);
    paramQQAppInterface.append(File.separator);
    paramQQAppInterface.append("history");
    paramQQAppInterface.append(File.separator);
    paramQQAppInterface.append("ptvHistory");
    this.c = paramQQAppInterface.toString();
    S();
    R();
    ThreadManager.getSubThreadHandler().post(this.d);
  }
  
  public static int D()
  {
    if (y <= 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
        y = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
      } else {
        y = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
      }
    }
    return y;
  }
  
  public static String Q()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("bless_config", 4).getString("config_content", "");
  }
  
  private void R()
  {
    Object localObject1 = this.e.getPreferences();
    this.l = BlessUinList.a((SharedPreferences)localObject1, 1);
    this.m = BlessUinList.a((SharedPreferences)localObject1, 2);
    Object localObject2 = null;
    Object localObject3 = SharedPreferencesHandler.a((SharedPreferences)localObject1, "bless_uin_to_send", null);
    if (localObject3 != null) {
      this.n = new ArrayList((Collection)localObject3);
    } else {
      this.n = new ArrayList();
    }
    this.r = ((SharedPreferences)localObject1).getString("bless_send_wording", null);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("initUinSendRecordFromSp sendWording=");
      ((StringBuilder)localObject3).append(this.r);
      ((StringBuilder)localObject3).append(" uinListToSend=");
      localObject1 = this.n;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      }
      ((StringBuilder)localObject3).append(localObject1);
      ((StringBuilder)localObject3).append(" blessUinList=");
      localObject1 = this.l;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = Integer.valueOf(((BlessUinList)localObject1).b());
      }
      ((StringBuilder)localObject3).append(localObject1);
      ((StringBuilder)localObject3).append(" webUinList=");
      localObject1 = this.m;
      if (localObject1 == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = Integer.valueOf(((BlessUinList)localObject1).b());
      }
      ((StringBuilder)localObject3).append(localObject1);
      QLog.d("BlessManager", 2, ((StringBuilder)localObject3).toString());
    }
  }
  
  private void S()
  {
    Object localObject1 = this.e.getEntityManagerFactory().createEntityManager();
    Object localObject2 = (ArrayList)((EntityManager)localObject1).query(BlessTask.class, new BlessTask().getTableName(), false, null, null, null, null, null, null);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
      this.f = ((BlessTask)((ArrayList)localObject2).get(0));
    }
    this.g = ((ArrayList)((EntityManager)localObject1).query(BlessPtvModule.class, new BlessPtvModule().getTableName(), false, null, null, null, null, null, null));
    this.h = ((ArrayList)((EntityManager)localObject1).query(BlessWording.class, new BlessWording().getTableName(), false, null, null, null, null, null, null));
    ((EntityManager)localObject1).close();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initTaskAndModuleFromDB task=");
      localObject1 = this.f;
      if (localObject1 != null) {
        localObject1 = ((BlessTask)localObject1).toString();
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(" blessWordings=");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append(" module=");
      localObject1 = this.g;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      }
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("BlessManager", 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = this.f;
    if (localObject1 != null)
    {
      this.p = a((BlessTask)localObject1, false);
      e(this.p);
      a(this.f, true);
      return;
    }
    e(false);
  }
  
  private Set<String> T()
  {
    return this.e.getApp().getSharedPreferences("bless_config", 4).getStringSet("config_list", null);
  }
  
  private void U()
  {
    Object localObject1 = this.f;
    if ((localObject1 != null) && (this.g != null))
    {
      localObject1 = ((BlessTask)localObject1).mainBanner;
      int i2 = 0;
      localObject1 = new ArrayList(Arrays.asList(new String[] { localObject1, this.f.mainCenter, this.f.typeBanner, this.f.succeededBanner, this.f.defaultVoice }));
      if (this.f.recentHeadImgUrl != null) {
        ((ArrayList)localObject1).add(this.f.recentHeadImgUrl);
      }
      if (this.f.recentHeadImgUrlSimple != null) {
        ((ArrayList)localObject1).add(this.f.recentHeadImgUrlSimple);
      }
      if (this.f.ptvAnimationUrl != null) {
        ((ArrayList)localObject1).add(this.f.ptvAnimationUrl);
      }
      Object localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject2).next();
        localObject1 = d((String)localObject3);
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(this.f.starVideo)))
        {
          localObject1 = MD5Utils.encodeHexStr((String)localObject3);
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
        if (localObject1 == null)
        {
          e(false);
          return;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.b);
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject3).toString();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (!new File((String)localObject1).exists())
            {
              i1 = i2;
              if (!QLog.isColorLevel()) {
                break label477;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("checkAllDownloaded no banner: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("BlessManager", 2, ((StringBuilder)localObject2).toString());
              i1 = i2;
              break label477;
            }
            if (i1 != 0)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(this.b);
              ((StringBuilder)localObject3).append(this.f.starVideoCoverFolderName);
              ((StringBuilder)localObject3).append(File.separator);
              ((StringBuilder)localObject3).append(this.f.starVideoCoverFileName);
              localObject3 = ((StringBuilder)localObject3).toString();
              if ((VersionUtils.d()) && (!new File((String)localObject3).exists()))
              {
                i1 = i2;
                if (!QLog.isColorLevel()) {
                  break label477;
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("checkAllDownloaded no cover: ");
                ((StringBuilder)localObject2).append((String)localObject1);
                QLog.d("BlessManager", 2, ((StringBuilder)localObject2).toString());
                i1 = i2;
                break label477;
              }
            }
          }
        }
      }
      int i1 = 1;
      label477:
      if (i1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "check Modules and banners all ready");
        }
        localObject1 = this.h;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.p = true;
          e(true);
        }
      }
    }
  }
  
  @TargetApi(10)
  private void V()
  {
    if ((VersionUtils.d()) && (!this.k)) {
      ThreadManager.post(new BlessManager.4(this), 5, null, false);
    }
  }
  
  private boolean W()
  {
    String str1 = C();
    String str2 = B();
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
    File[] arrayOfFile = new File(this.b).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int i4 = 0;
    while (i4 < arrayOfFile.length)
    {
      if ((!arrayOfFile[i4].getName().endsWith(".zip")) && (!arrayOfFile[i4].isDirectory()))
      {
        int i5 = 0;
        int i1 = 0;
        int i6;
        Object localObject2;
        Object localObject1;
        for (int i2 = 0; i5 < arrayOfString.length; i2 = i6)
        {
          if (TextUtils.isEmpty(arrayOfString[i5]))
          {
            i6 = i2;
          }
          else
          {
            localObject2 = d(arrayOfString[i5]);
            if (arrayOfString[i5].equals(paramBlessTask.starVideo))
            {
              localObject1 = MD5Utils.encodeHexStr(arrayOfString[i5]);
              i3 = 1;
            }
            else
            {
              i3 = i1;
              localObject1 = localObject2;
              if (arrayOfString[i5].equals(paramBlessTask.ptvAnimationUrl))
              {
                i2 = 1;
                localObject1 = localObject2;
                i3 = i1;
              }
            }
            i1 = i3;
            i6 = i2;
            if (arrayOfFile[i4].getName().equals(localObject1))
            {
              i1 = 0;
              break label322;
            }
          }
          i5 += 1;
        }
        i5 = 1;
        int i3 = i1;
        i1 = i5;
        label322:
        if (i1 != 0)
        {
          arrayOfFile[i4].delete();
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("deleteOldBanner=");
            ((StringBuilder)localObject1).append(arrayOfFile[i4].getName());
            QLog.d("BlessManager", 2, ((StringBuilder)localObject1).toString());
          }
          if (i3 != 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.b);
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
          if (i2 != 0)
          {
            localObject1 = new File(M());
            if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory())) {
              ((File)localObject1).delete();
            }
          }
        }
      }
      i4 += 1;
    }
  }
  
  /* Error */
  private void a(BlessTask paramBlessTask, ArrayList<BlessPtvModule> paramArrayList, ArrayList<BlessWording> paramArrayList1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 112	com/tencent/mobileqq/activity/bless/BlessManager:e	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 279	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   7: invokevirtual 285	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore 5
    //   12: aload 5
    //   14: invokevirtual 502	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   24: aload 5
    //   26: ldc_w 287
    //   29: invokevirtual 511	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   32: pop
    //   33: aload_1
    //   34: ifnull +9 -> 43
    //   37: aload 5
    //   39: aload_1
    //   40: invokevirtual 515	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   43: aload 5
    //   45: ldc 121
    //   47: invokevirtual 511	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   50: pop
    //   51: aload_2
    //   52: ifnull +34 -> 86
    //   55: aload_2
    //   56: invokevirtual 383	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   59: astore_1
    //   60: aload_1
    //   61: invokeinterface 388 1 0
    //   66: ifeq +20 -> 86
    //   69: aload 5
    //   71: aload_1
    //   72: invokeinterface 392 1 0
    //   77: checkcast 121	com/tencent/mobileqq/activity/bless/BlessPtvModule
    //   80: invokevirtual 515	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   83: goto -23 -> 60
    //   86: aload 5
    //   88: ldc_w 309
    //   91: invokevirtual 511	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   94: pop
    //   95: aload_3
    //   96: ifnull +34 -> 130
    //   99: aload_3
    //   100: invokevirtual 383	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   103: astore_1
    //   104: aload_1
    //   105: invokeinterface 388 1 0
    //   110: ifeq +20 -> 130
    //   113: aload 5
    //   115: aload_1
    //   116: invokeinterface 392 1 0
    //   121: checkcast 309	com/tencent/mobileqq/activity/bless/BlessWording
    //   124: invokevirtual 515	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   127: goto -23 -> 104
    //   130: aload 4
    //   132: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   135: invokestatic 521	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   138: ifeq +25 -> 163
    //   141: ldc_w 272
    //   144: iconst_4
    //   145: ldc_w 523
    //   148: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: goto +12 -> 163
    //   154: astore_1
    //   155: goto +19 -> 174
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 526	java/lang/Exception:printStackTrace	()V
    //   163: aload 4
    //   165: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   168: aload 5
    //   170: invokevirtual 316	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   173: return
    //   174: aload 4
    //   176: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   179: goto +5 -> 184
    //   182: aload_1
    //   183: athrow
    //   184: goto -2 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	BlessManager
    //   0	187	1	paramBlessTask	BlessTask
    //   0	187	2	paramArrayList	ArrayList<BlessPtvModule>
    //   0	187	3	paramArrayList1	ArrayList<BlessWording>
    //   17	158	4	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   10	159	5	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   19	33	154	finally
    //   37	43	154	finally
    //   43	51	154	finally
    //   55	60	154	finally
    //   60	83	154	finally
    //   86	95	154	finally
    //   99	104	154	finally
    //   104	127	154	finally
    //   130	151	154	finally
    //   159	163	154	finally
    //   19	33	158	java/lang/Exception
    //   37	43	158	java/lang/Exception
    //   43	51	158	java/lang/Exception
    //   55	60	158	java/lang/Exception
    //   60	83	158	java/lang/Exception
    //   86	95	158	java/lang/Exception
    //   99	104	158	java/lang/Exception
    //   104	127	158	java/lang/Exception
    //   130	151	158	java/lang/Exception
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
    RecentUser localRecentUser = paramRecentUserProxy.b(AppConstants.SEND_BLESS_UIN, 9003);
    long l1 = NetConnInfoCenter.getServerTime();
    localRecentUser.uin = AppConstants.SEND_BLESS_UIN;
    localRecentUser.setType(9003);
    if (localRecentUser.lastmsgtime < l1) {
      localRecentUser.lastmsgtime = l1;
    }
    paramRecentUserProxy.b(localRecentUser);
    a(this.e);
  }
  
  private void a(RecentUserProxy paramRecentUserProxy, RecentUser paramRecentUser)
  {
    paramRecentUserProxy.a(paramRecentUser);
    a(this.e);
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
    Object localObject1 = this.g;
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
    localObject1 = this.f;
    if (localObject1 != null)
    {
      localObject1 = d(((BlessTask)localObject1).starVideo);
      localObject2 = d(paramBlessTask.starVideo);
      if ((localObject1 != null) && (((String)localObject1).equals(localObject2))) {
        paramBlessTask.videoPlayed = this.f.videoPlayed;
      }
    }
    if ((this.t != null) && (this.f != null) && (!TextUtils.isEmpty(paramBlessTask.starAvator)) && (!paramBlessTask.starAvator.equals(this.f.starAvator))) {
      this.t = null;
    }
    if ((this.f != null) && (paramBlessTask.festival_id == this.f.festival_id) && (paramBlessTask.task_id == this.f.task_id))
    {
      paramBlessTask.isNew = this.f.isNew;
      paramBlessTask.isDeleted = this.f.isDeleted;
    }
    this.f = paramBlessTask;
    this.g = paramArrayList;
    this.h = paramArrayList1;
    a(this.f);
    a(this.g);
    this.p = a(this.f, false);
    e(this.p);
    a(this.f, true);
    this.l.d();
    localObject1 = this.e.getPreferences();
    BlessUinList.a((SharedPreferences)localObject1, this.l, 1);
    a(paramBlessTask, paramArrayList, paramArrayList1);
    ((SharedPreferences)localObject1).edit().remove("bless_send_wording").commit();
    this.r = null;
    f(paramString);
  }
  
  private void a(ArrayList<BlessPtvModule> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    File[] arrayOfFile = new File(this.b).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int i1 = 0;
    while (i1 < arrayOfFile.length)
    {
      if ((arrayOfFile[i1].getName().endsWith(".zip")) && (!arrayOfFile[i1].isDirectory()))
      {
        Object localObject1 = null;
        Object localObject2 = paramArrayList.iterator();
        int i2;
        for (;;)
        {
          boolean bool = ((Iterator)localObject2).hasNext();
          i2 = 1;
          if (!bool) {
            break;
          }
          BlessPtvModule localBlessPtvModule = (BlessPtvModule)((Iterator)localObject2).next();
          localObject1 = localBlessPtvModule.id;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(localBlessPtvModule.id);
          ((StringBuilder)localObject3).append(".zip");
          localObject3 = ((StringBuilder)localObject3).toString();
          if (arrayOfFile[i1].getName().equals(localObject3))
          {
            if (localBlessPtvModule.broken)
            {
              localBlessPtvModule.broken = false;
              break;
            }
            i2 = 0;
            break;
          }
        }
        if (i2 != 0)
        {
          arrayOfFile[i1].delete();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.b);
          ((StringBuilder)localObject2).append((String)localObject1);
          FileUtils.deleteDirectory(((StringBuilder)localObject2).toString());
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("deleteOldModules=");
            ((StringBuilder)localObject1).append(arrayOfFile[i1].getName());
            QLog.d("BlessManager", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      i1 += 1;
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
      localObject1 = d(str);
      int i1;
      if ((!TextUtils.isEmpty(str)) && (str.equals(paramBlessTask.starVideo)))
      {
        localObject1 = MD5Utils.encodeHexStr(str);
        paramBlessTask.ex1 = ((String)localObject1);
        i1 = 1;
      }
      else
      {
        i1 = 0;
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
      ((StringBuilder)localObject3).append(this.b);
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
        c(str, (String)localObject3);
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
        if (i1 == 0) {
          break;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(paramBlessTask.starVideoCoverFolderName);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(paramBlessTask.starVideoCoverFileName);
        localObject1 = ((StringBuilder)localObject1).toString();
        if ((!VersionUtils.d()) || (new File((String)localObject1).exists())) {
          break;
        }
        V();
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
  
  public static Date b(String paramString)
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
  
  private void b(Set<String> paramSet)
  {
    SharedPreferences.Editor localEditor = this.e.getApp().getSharedPreferences("bless_config", 4).edit();
    if (paramSet == null) {
      localEditor.remove("config_list");
    } else {
      localEditor.putStringSet("config_list", paramSet);
    }
    localEditor.commit();
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = b(paramString1);
    Date localDate = b(paramString2);
    if (localObject != null)
    {
      if (localDate == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isInTime now=");
        localStringBuilder.append(l1);
        localStringBuilder.append("  beginDate.getTime():");
        localStringBuilder.append(((Date)localObject).getTime());
        localStringBuilder.append("  endDate.getTime():");
        localStringBuilder.append(localDate.getTime());
        QLog.d("BlessManager", 2, localStringBuilder.toString());
      }
      if ((l1 > ((Date)localObject).getTime()) && (l1 < localDate.getTime())) {
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
  
  private void c(String paramString1, String paramString2)
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
    DownloadTask localDownloadTask = (DownloadTask)this.j.get(paramString2);
    if (localDownloadTask != null) {
      if ((localDownloadTask.e() != 2) && (localDownloadTask.e() != 3))
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
    localDownloadTask.J = true;
    Object localObject = ((DownloaderFactory)this.e.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownload: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" path=");
      localStringBuilder.append(paramString2);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
    this.j.put(paramString2, localDownloadTask);
    ((DownloaderInterface)localObject).startDownload(localDownloadTask, new BlessManager.3(this, paramString2, paramString1), null);
  }
  
  private void e(boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = this.e.getProxyManager().g();
    RecentUser localRecentUser = localRecentUserProxy.c(AppConstants.SEND_BLESS_UIN, 9003);
    Object localObject = this.f;
    boolean bool = true;
    if (localObject != null)
    {
      localObject = this.h;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        i1 = 1;
        break label66;
      }
    }
    int i1 = 0;
    label66:
    if ((i1 == 0) || (!d()) || (!paramBoolean) || (this.f.isDeleted)) {
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
      localStringBuilder.append(this.f);
      localStringBuilder.append(" isDeleted=");
      localObject = this.f;
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
      else if (this.f.isNew)
      {
        a(localRecentUserProxy, localRecentUser);
        a(localRecentUserProxy);
      }
      this.f.isNew = false;
      return;
    }
    if (localRecentUser != null) {
      a(localRecentUserProxy, localRecentUser);
    }
  }
  
  private void f(String paramString)
  {
    SharedPreferences.Editor localEditor = this.e.getApp().getSharedPreferences("bless_config", 4).edit();
    localEditor.putString("config_content", paramString);
    localEditor.commit();
  }
  
  public Drawable A()
  {
    Object localObject2 = BaseApplication.getContext().getResources().getDrawable(2130838982);
    boolean bool = QQTheme.isNowSimpleUI();
    Object localObject3 = this.f;
    Object localObject1 = localObject2;
    int i1;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((BlessTask)localObject3).recentHeadImgUrl != null)
      {
        if ((this.u == null) || (this.w != bool))
        {
          localObject3 = this.f.recentHeadImgUrl;
          localObject1 = localObject3;
          if (bool)
          {
            localObject1 = localObject3;
            if (!TextUtils.isEmpty(this.f.recentHeadImgUrlSimple)) {
              localObject1 = this.f.recentHeadImgUrlSimple;
            }
          }
          localObject1 = d((String)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(this.b);
            ((StringBuilder)localObject3).append((String)localObject1);
            localObject1 = ((StringBuilder)localObject3).toString();
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            i1 = AIOUtils.b(50.0F, BaseApplication.getContext().getResources());
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i1;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i1;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
            this.u = URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject3);
          }
        }
        localObject3 = this.u;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          this.w = bool;
          localObject1 = localObject3;
        }
      }
    }
    localObject2 = localObject1;
    if (x())
    {
      if ((this.t == null) || (this.w != bool))
      {
        localObject3 = this.f.starAvator;
        localObject2 = localObject3;
        if (bool)
        {
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(this.f.starAvatorSimple)) {
            localObject2 = this.f.starAvatorSimple;
          }
        }
        localObject2 = d((String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.b);
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject2 = ((StringBuilder)localObject3).toString();
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          i1 = AIOUtils.b(50.0F, BaseApplication.getContext().getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = i1;
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i1;
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
          this.t = URLDrawable.getDrawable(new File((String)localObject2), (URLDrawable.URLDrawableOptions)localObject3);
        }
      }
      localObject3 = this.t;
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        this.w = bool;
        localObject2 = localObject3;
      }
    }
    return localObject2;
  }
  
  public String B()
  {
    if (this.f == null) {
      return null;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(d(this.f.ex1));
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
  
  public String C()
  {
    if (this.f == null) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(this.f.starVideoCoverFolderName);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.f.starVideoCoverFileName);
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
  
  public void E()
  {
    ThreadManager.post(new BlessManager.5(this), 5, null, true);
  }
  
  public int F()
  {
    return 100;
  }
  
  public int G()
  {
    return 30;
  }
  
  public int H()
  {
    this.m.a();
    return G() - this.m.b();
  }
  
  public int I()
  {
    this.m.a();
    int i2 = F();
    int i1 = i2;
    if (i2 > 0) {
      i1 = i2 - this.m.c();
    }
    return i1;
  }
  
  public String J()
  {
    BlessTask localBlessTask = this.f;
    if ((localBlessTask != null) && (!TextUtils.isEmpty(localBlessTask.shareUrl))) {
      return this.f.shareUrl;
    }
    return "https://wa.qq.com/qfzf/index.html?_wv=16777217&adtag=main";
  }
  
  public Boolean K()
  {
    BlessTask localBlessTask = this.f;
    if (localBlessTask == null) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(localBlessTask.ptvAnimationSwtich);
  }
  
  public String L()
  {
    Object localObject = this.f;
    String str = "";
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((BlessTask)localObject).ptvAnimationUrl)) {
        return "";
      }
      str = d(this.f.ptvAnimationUrl);
      if (str == null) {
        return "";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(str);
      str = ((StringBuilder)localObject).toString();
    }
    return str;
  }
  
  public String M()
  {
    Object localObject2 = this.f;
    String str = "";
    Object localObject1 = str;
    if (localObject2 != null)
    {
      if (TextUtils.isEmpty(((BlessTask)localObject2).ptvAnimationUrl)) {
        return "";
      }
      localObject2 = L();
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
  
  public int N()
  {
    BlessTask localBlessTask = this.f;
    if (localBlessTask == null) {
      return 1;
    }
    return localBlessTask.ptvAnimationCount;
  }
  
  public int O()
  {
    BlessTask localBlessTask = this.f;
    if (localBlessTask == null) {
      return 2000;
    }
    return localBlessTask.ptvAnimationCost;
  }
  
  public String P()
  {
    BlessTask localBlessTask = this.f;
    if ((localBlessTask != null) && (!TextUtils.isEmpty(localBlessTask.webBlessUrl))) {
      return this.f.webBlessUrl;
    }
    return "https://ti.qq.com/mass-blessing/index.html?_wv=16777223";
  }
  
  public ChatActivityFacade.HongbaoParams a(int paramInt1, int paramInt2)
  {
    ChatActivityFacade.HongbaoParams localHongbaoParams = new ChatActivityFacade.HongbaoParams();
    localHongbaoParams.e = 0;
    if (paramInt1 == 2) {
      localHongbaoParams.f = 1;
    } else if (paramInt1 == 3) {
      localHongbaoParams.f = 4;
    } else {
      localHongbaoParams.f = 0;
    }
    localHongbaoParams.b = paramInt2;
    return localHongbaoParams;
  }
  
  public String a(int paramInt)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return null;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        localObject = null;
      } else {
        localObject = d(((BlessTask)localObject).succeededBanner);
      }
    }
    else {
      localObject = d(((BlessTask)localObject).mainBanner);
    }
    if (localObject == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(J());
    localStringBuilder.append("&uuid=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&md5=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&nick=");
    paramString1 = localStringBuilder.toString();
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(Base64Util.encodeToString(this.e.getCurrentNickname().getBytes(), 2));
    return paramString2.toString();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    ArrayList localArrayList = this.h;
    if (localArrayList == null) {
      return;
    }
    int i1 = paramInt1;
    if (paramInt2 == localArrayList.size() + 1) {
      i1 = paramInt1 - 1;
    }
    if ((i1 >= 0) && (i1 < this.h.size())) {
      ((BlessWording)this.h.get(i1)).setEditingWording(paramString);
    }
  }
  
  public void a(Context paramContext)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.v < 3000L) {
      return;
    }
    this.v = l1;
    String str = P();
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
    localStringBuilder.append(this.b);
    localStringBuilder.append(paramBlessPtvModule.id);
    FileUtils.deleteDirectory(localStringBuilder.toString());
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(paramBlessPtvModule.id);
      localStringBuilder.append(".zip");
      FileUtils.deleteFile(localStringBuilder.toString());
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.s = paramMessageForShortVideo;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPtvMessage: ");
      localStringBuilder.append(paramMessageForShortVideo);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
  }
  
  public void a(ArrayList<String> paramArrayList, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.e.getPreferences();
    String str;
    if (paramInt == 1)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        str = (String)paramArrayList.next();
        this.l.a(str);
      }
      BlessUinList.a(localSharedPreferences, this.l, 1);
      return;
    }
    if (paramInt == 2)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        str = (String)paramArrayList.next();
        this.m.a(str);
      }
      BlessUinList.a(localSharedPreferences, this.m, 2);
    }
  }
  
  public void a(List<String> paramList)
  {
    this.n.clear();
    this.n.addAll(paramList);
    SharedPreferencesHandler.a(this.e.getPreferences().edit(), "bless_uin_to_send", paramList.toArray()).commit();
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
        Date localDate1 = b(localBlessTask.entranceBegin);
        Date localDate2 = b(localBlessTask.entranceEnd);
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
      c();
    }
    if (localArrayList3.size() > 1)
    {
      if (localObject2 != null)
      {
        localObject4 = b(localObject2.entranceBegin);
        l1 = 9223372036854775807L;
        localObject5 = localArrayList3.iterator();
        localObject1 = null;
        while (((Iterator)localObject5).hasNext())
        {
          localObject3 = (BlessTask)((Iterator)localObject5).next();
          if (localObject3 != localObject2)
          {
            localObject6 = b(((BlessTask)localObject3).entranceBegin);
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
    this.i = ((BlessTask)localObject1);
    if (QLog.isColorLevel())
    {
      paramSet = new StringBuilder();
      paramSet.append("onNewConfigReceived validCount=");
      paramSet.append(localArrayList3.size());
      paramSet.append("  nextTask:");
      paramSet.append(this.i);
      QLog.d("BlessManager", 2, paramSet.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public boolean a()
  {
    return this.e.getProxyManager().g().c(AppConstants.SEND_BLESS_UIN, 9003) != null;
  }
  
  public boolean a(BlessPtvModule paramBlessPtvModule)
  {
    if (paramBlessPtvModule == null) {
      return false;
    }
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(paramBlessPtvModule.id);
      ((StringBuilder)localObject).append(".zip");
      localObject = ((StringBuilder)localObject).toString();
      a(paramBlessPtvModule, false);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
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
    this.l.a();
    return this.l.b(paramString);
  }
  
  /* Error */
  public void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: iload_1
    //   11: ifeq +11 -> 22
    //   14: aload_2
    //   15: getfield 1063	com/tencent/mobileqq/activity/bless/BlessTask:unread	I
    //   18: ifne +9 -> 27
    //   21: return
    //   22: aload_2
    //   23: iconst_1
    //   24: putfield 592	com/tencent/mobileqq/activity/bless/BlessTask:videoPlayed	Z
    //   27: aload_0
    //   28: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   31: getfield 1063	com/tencent/mobileqq/activity/bless/BlessTask:unread	I
    //   34: iconst_m1
    //   35: if_icmpne +13 -> 48
    //   38: aload_0
    //   39: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   42: getfield 592	com/tencent/mobileqq/activity/bless/BlessTask:videoPlayed	Z
    //   45: ifeq +131 -> 176
    //   48: invokestatic 521	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   51: ifeq +62 -> 113
    //   54: new 52	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   61: astore_2
    //   62: aload_2
    //   63: ldc_w 1065
    //   66: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_2
    //   71: aload_0
    //   72: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   75: getfield 1063	com/tencent/mobileqq/activity/bless/BlessTask:unread	I
    //   78: invokevirtual 1017	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: ldc_w 1067
    //   86: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_2
    //   91: aload_0
    //   92: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   95: getfield 592	com/tencent/mobileqq/activity/bless/BlessTask:videoPlayed	Z
    //   98: invokevirtual 782	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: ldc_w 272
    //   105: iconst_4
    //   106: aload_2
    //   107: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_0
    //   114: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   117: iconst_m1
    //   118: putfield 1063	com/tencent/mobileqq/activity/bless/BlessTask:unread	I
    //   121: aload_0
    //   122: getfield 112	com/tencent/mobileqq/activity/bless/BlessManager:e	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   125: invokevirtual 279	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   128: invokevirtual 285	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   131: astore_3
    //   132: aload_3
    //   133: invokevirtual 502	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   136: astore_2
    //   137: aload_2
    //   138: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   141: aload_3
    //   142: aload_0
    //   143: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   146: invokevirtual 1071	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   149: pop
    //   150: aload_2
    //   151: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   154: goto +14 -> 168
    //   157: astore_3
    //   158: goto +19 -> 177
    //   161: astore 4
    //   163: aload 4
    //   165: invokevirtual 526	java/lang/Exception:printStackTrace	()V
    //   168: aload_2
    //   169: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   172: aload_3
    //   173: invokevirtual 316	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   176: return
    //   177: aload_2
    //   178: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
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
    if (this.f != null)
    {
      ArrayList localArrayList = this.g;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        localArrayList = this.h;
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          i1 = 1;
          break label46;
        }
      }
    }
    int i1 = 0;
    label46:
    return (i1 != 0) && (d()) && (this.p);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "clearBlessConfigs");
    }
    b(null);
    a(null, null, null);
    e(false);
  }
  
  public void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = this.h;
    String str = paramString;
    if (localArrayList != null)
    {
      str = paramString;
      if (localArrayList.size() > 0)
      {
        str = paramString;
        if (paramString.equals(((BlessWording)this.h.get(0)).wording)) {
          str = "";
        }
      }
    }
    paramString = this.r;
    if ((paramString != null) && (paramString.equals(str))) {
      return;
    }
    this.r = str;
    paramString = this.e.getPreferences().edit();
    paramString.putString("bless_send_wording", str);
    paramString.commit();
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
      v();
      return;
    }
    w();
  }
  
  public String d(String paramString)
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
        int i1 = str.lastIndexOf('/');
        if (i1 == -1) {
          return null;
        }
        int i2 = str.substring(0, i1).lastIndexOf('/');
        if (i2 != -1)
        {
          i1 = i2;
          i2 = str.lastIndexOf("?");
          if (i2 > i1) {
            return str.substring(i1 + 1, i2);
          }
          str = str.substring(i1 + 1);
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
  
  public String d(boolean paramBoolean)
  {
    BlessTask localBlessTask = this.f;
    if (localBlessTask == null) {
      return "";
    }
    if (paramBoolean) {
      return localBlessTask.shareQzoneTitle;
    }
    return localBlessTask.shareWeixinTitle;
  }
  
  public boolean d()
  {
    BlessTask localBlessTask = this.f;
    boolean bool2 = false;
    if (localBlessTask == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "isEntranceTime");
    }
    boolean bool1 = bool2;
    if (b(this.f.entranceBegin, this.f.entranceEnd))
    {
      bool1 = bool2;
      if (this.f.entranceEnabled == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean e()
  {
    if (this.f == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "isStarTime");
    }
    return b(this.f.starBegin, this.f.starEnd);
  }
  
  public boolean e(String paramString)
  {
    this.m.a();
    return this.m.b(paramString);
  }
  
  public boolean f()
  {
    Object localObject = this.f;
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
      ((StringBuilder)localObject).append(this.f.ptvEnabled);
      ((StringBuilder)localObject).append(" ptvRecord=");
      ((StringBuilder)localObject).append(bool4);
      ((StringBuilder)localObject).append(" isX86=");
      ((StringBuilder)localObject).append(bool5);
      ((StringBuilder)localObject).append(" frontCamera=");
      ((StringBuilder)localObject).append(true);
      QLog.d("BlessManager", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = bool2;
    if (this.f.ptvEnabled == 1)
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
  
  public boolean g()
  {
    BlessTask localBlessTask = this.f;
    if (localBlessTask == null) {
      return true;
    }
    return localBlessTask.ptvEnabled != 1;
  }
  
  public int h()
  {
    BlessTask localBlessTask = this.f;
    if (localBlessTask == null) {
      return -1;
    }
    if (localBlessTask.unread > 1) {
      return 1;
    }
    return this.f.unread;
  }
  
  public int i()
  {
    BlessTask localBlessTask = this.f;
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
  
  public String j()
  {
    Object localObject = this.f;
    if (localObject == null) {
      return null;
    }
    localObject = d(((BlessTask)localObject).mainCenter);
    if (localObject == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public void k()
  {
    this.n.clear();
    SharedPreferencesHandler.a(this.e.getPreferences().edit(), "bless_uin_to_send", new String[0]).commit();
  }
  
  public ArrayList<String> l()
  {
    return this.n;
  }
  
  public boolean m()
  {
    return this.o;
  }
  
  public int n()
  {
    BlessTask localBlessTask = this.f;
    if (localBlessTask == null) {
      return 100;
    }
    return localBlessTask.uinTotalLimit;
  }
  
  public int o()
  {
    this.l.a();
    return n() - this.l.b();
  }
  
  public void onDestroy()
  {
    Object localObject = (DownloaderFactory)this.e.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
    if (localObject != null)
    {
      localObject = ((DownloaderFactory)localObject).a(1);
      if (localObject != null) {
        ((DownloaderInterface)localObject).cancelTask(true, null);
      }
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.d);
  }
  
  public int p()
  {
    BlessTask localBlessTask = this.f;
    if (localBlessTask == null) {
      return 100;
    }
    return localBlessTask.sendTotalLimit;
  }
  
  public int q()
  {
    this.l.a();
    int i2 = p();
    int i1 = i2;
    if (i2 > 0) {
      i1 = i2 - this.l.c();
    }
    return i1;
  }
  
  public String r()
  {
    BlessTask localBlessTask = this.f;
    if (localBlessTask == null) {
      return "";
    }
    return localBlessTask.entranceHint;
  }
  
  public BlessTask s()
  {
    return this.f;
  }
  
  public ArrayList<String> t()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.r)) {
      localArrayList.add(this.r);
    }
    Object localObject = this.h;
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
  
  public void u()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BlessWording)((Iterator)localObject).next()).setEditingWording(null);
      }
    }
  }
  
  /* Error */
  public void v()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +99 -> 105
    //   9: aload_1
    //   10: getfield 604	com/tencent/mobileqq/activity/bless/BlessTask:isDeleted	Z
    //   13: ifne +92 -> 105
    //   16: invokestatic 521	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   19: ifeq +13 -> 32
    //   22: ldc_w 272
    //   25: iconst_4
    //   26: ldc_w 1207
    //   29: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   36: iconst_1
    //   37: putfield 604	com/tencent/mobileqq/activity/bless/BlessTask:isDeleted	Z
    //   40: aload_0
    //   41: getfield 112	com/tencent/mobileqq/activity/bless/BlessManager:e	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   44: invokevirtual 279	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   47: invokevirtual 285	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 502	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   60: aload_2
    //   61: aload_0
    //   62: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   65: invokevirtual 1071	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   68: pop
    //   69: aload_1
    //   70: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   73: goto +12 -> 85
    //   76: astore_2
    //   77: goto +22 -> 99
    //   80: astore_3
    //   81: aload_3
    //   82: invokevirtual 526	java/lang/Exception:printStackTrace	()V
    //   85: aload_1
    //   86: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   89: aload_2
    //   90: invokevirtual 316	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   93: aload_0
    //   94: iconst_0
    //   95: invokespecial 328	com/tencent/mobileqq/activity/bless/BlessManager:e	(Z)V
    //   98: return
    //   99: aload_1
    //   100: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
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
  
  /* Error */
  public void w()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +94 -> 100
    //   9: aload_1
    //   10: getfield 604	com/tencent/mobileqq/activity/bless/BlessTask:isDeleted	Z
    //   13: ifeq +87 -> 100
    //   16: invokestatic 521	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   19: ifeq +13 -> 32
    //   22: ldc_w 272
    //   25: iconst_4
    //   26: ldc_w 1209
    //   29: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   36: iconst_0
    //   37: putfield 604	com/tencent/mobileqq/activity/bless/BlessTask:isDeleted	Z
    //   40: aload_0
    //   41: getfield 112	com/tencent/mobileqq/activity/bless/BlessManager:e	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   44: invokevirtual 279	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   47: invokevirtual 285	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 502	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   60: aload_2
    //   61: aload_0
    //   62: getfield 303	com/tencent/mobileqq/activity/bless/BlessManager:f	Lcom/tencent/mobileqq/activity/bless/BlessTask;
    //   65: invokevirtual 1071	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   68: pop
    //   69: aload_1
    //   70: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   73: goto +12 -> 85
    //   76: astore_2
    //   77: goto +17 -> 94
    //   80: astore_3
    //   81: aload_3
    //   82: invokevirtual 526	java/lang/Exception:printStackTrace	()V
    //   85: aload_1
    //   86: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   89: aload_2
    //   90: invokevirtual 316	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   93: return
    //   94: aload_1
    //   95: invokevirtual 529	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
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
  
  public boolean x()
  {
    BlessTask localBlessTask = this.f;
    boolean bool2 = false;
    if (localBlessTask == null) {
      return false;
    }
    if (!VersionUtils.d()) {
      return false;
    }
    boolean bool1 = bool2;
    if (!this.f.videoPlayed)
    {
      bool1 = bool2;
      if (e())
      {
        bool1 = bool2;
        if (W()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void y()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("check entrance.  nextTask:");
      ((StringBuilder)localObject).append(this.i);
      QLog.d("BlessManager", 2, ((StringBuilder)localObject).toString());
    }
    if (!d())
    {
      localObject = this.e.getProxyManager().g();
      RecentUser localRecentUser = ((RecentUserProxy)localObject).c(AppConstants.SEND_BLESS_UIN, 9003);
      if (localRecentUser != null) {
        a((RecentUserProxy)localObject, localRecentUser);
      }
    }
    Object localObject = this.i;
    if ((localObject != null) && (b(((BlessTask)localObject).entranceBegin, this.i.entranceEnd)) && (this.i.entranceEnabled == 1) && (!this.x))
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.d);
      ThreadManager.getSubThreadHandler().post(this.d);
    }
  }
  
  public MessageForShortVideo z()
  {
    MessageForShortVideo localMessageForShortVideo = this.s;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPtvMessage: ");
      localStringBuilder.append(localMessageForShortVideo);
      QLog.d("BlessManager", 2, localStringBuilder.toString());
    }
    return localMessageForShortVideo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager
 * JD-Core Version:    0.7.0.1
 */