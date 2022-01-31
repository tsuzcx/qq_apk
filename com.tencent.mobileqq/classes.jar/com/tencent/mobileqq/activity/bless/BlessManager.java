package com.tencent.mobileqq.activity.bless;

import android.annotation.TargetApi;
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
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import wbt;
import wbu;
import wbv;

public class BlessManager
  implements Manager
{
  private static int jdField_a_of_type_Int;
  public static final String a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private BlessTask jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
  private BlessUinList jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean jdField_a_of_type_Boolean;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private BlessUinList jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList;
  public String b;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  public String c;
  private ArrayList jdField_c_of_type_JavaUtilArrayList;
  private volatile boolean jdField_c_of_type_Boolean;
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "bless" + File.separator;
  }
  
  public BlessManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = AppConstants.aJ + jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface;
    BlessPtvModule.path = paramQQAppInterface;
    this.jdField_c_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + File.separator + "history" + File.separator + "ptvHistory");
    h();
    g();
  }
  
  public static Date a(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void a(BlessTask paramBlessTask)
  {
    if (paramBlessTask == null) {}
    String[] arrayOfString;
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfString = new String[9];
      arrayOfString[0] = paramBlessTask.mainBanner;
      arrayOfString[1] = paramBlessTask.mainCenter;
      arrayOfString[2] = paramBlessTask.typeBanner;
      arrayOfString[3] = paramBlessTask.succeededBanner;
      arrayOfString[4] = paramBlessTask.defaultVoice;
      arrayOfString[5] = paramBlessTask.starAvator;
      arrayOfString[6] = paramBlessTask.starVideo;
      arrayOfString[7] = paramBlessTask.recentHeadImgUrl;
      arrayOfString[8] = paramBlessTask.ptvAnimationUrl;
      arrayOfFile = new File(this.jdField_b_of_type_JavaLangString).listFiles();
    } while (arrayOfFile == null);
    int k = 0;
    label111:
    if (k < arrayOfFile.length) {
      if ((!arrayOfFile[k].getName().endsWith(".zip")) && (!arrayOfFile[k].isDirectory())) {
        break label155;
      }
    }
    label155:
    label181:
    label228:
    label491:
    label507:
    for (;;)
    {
      k += 1;
      break label111;
      break;
      int m = 0;
      int i = 0;
      int j = 0;
      Object localObject;
      int n;
      for (;;)
      {
        if (m < arrayOfString.length) {
          if (TextUtils.isEmpty(arrayOfString[m]))
          {
            m += 1;
          }
          else
          {
            localObject = a(arrayOfString[m]);
            if (arrayOfString[m].equals(paramBlessTask.starVideo))
            {
              localObject = MD5Utils.b(arrayOfString[m]);
              j = 1;
              if (!arrayOfFile[k].getName().equals(localObject)) {
                break label491;
              }
              n = 0;
              m = i;
            }
          }
        }
      }
      for (i = n;; i = n)
      {
        if (i == 0) {
          break label507;
        }
        arrayOfFile[k].delete();
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "deleteOldBanner=" + arrayOfFile[k].getName());
        }
        if (j != 0)
        {
          localObject = this.jdField_b_of_type_JavaLangString + paramBlessTask.starVideoCoverFolderName + File.separator;
          localObject = new File((String)localObject + paramBlessTask.starVideoCoverFileName);
          if ((((File)localObject).exists()) && (((File)localObject).isFile()))
          {
            ((File)localObject).delete();
            if (QLog.isColorLevel()) {
              QLog.d("BlessManager", 2, "deleteOldCover=" + ((File)localObject).getName());
            }
          }
        }
        if (m == 0) {
          break;
        }
        localObject = new File(k());
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          break;
        }
        ((File)localObject).delete();
        break;
        if (arrayOfString[m].equals(paramBlessTask.ptvAnimationUrl))
        {
          i = 1;
          break label228;
          break label181;
        }
        break label228;
        n = 1;
        m = i;
      }
    }
  }
  
  private void a(BlessTask paramBlessTask, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        localEntityManager.a(BlessTask.class);
        if (paramBlessTask != null) {
          localEntityManager.b(paramBlessTask);
        }
        localEntityManager.a(BlessPtvModule.class);
        if (paramArrayList1 != null)
        {
          paramBlessTask = paramArrayList1.iterator();
          if (paramBlessTask.hasNext())
          {
            localEntityManager.b((BlessPtvModule)paramBlessTask.next());
            continue;
          }
        }
      }
      catch (Exception paramBlessTask)
      {
        paramBlessTask.printStackTrace();
        localEntityTransaction.b();
        return;
        localEntityManager.a(BlessWording.class);
        if (paramArrayList2 != null)
        {
          paramBlessTask = paramArrayList2.iterator();
          if (paramBlessTask.hasNext())
          {
            localEntityManager.b((BlessWording)paramBlessTask.next());
            continue;
          }
        }
      }
      finally
      {
        localEntityTransaction.b();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("BlessManager", 4, "save task and modules to db");
      }
      localEntityTransaction.b();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "refresh recent");
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendEmptyMessage(1009);
  }
  
  private void a(RecentUserProxy paramRecentUserProxy)
  {
    RecentUser localRecentUser = paramRecentUserProxy.a(AppConstants.am, 9003);
    long l = NetConnInfoCenter.getServerTime();
    localRecentUser.uin = AppConstants.am;
    localRecentUser.type = 9003;
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    paramRecentUserProxy.a(localRecentUser);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(RecentUserProxy paramRecentUserProxy, RecentUser paramRecentUser)
  {
    paramRecentUserProxy.b(paramRecentUser);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (NetworkUtil.a(BaseApplicationImpl.getApplication()) == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download 2g give up " + paramString2);
      }
    }
    do
    {
      return;
      localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
      if (localDownloadTask == null) {
        break label144;
      }
      if ((localDownloadTask.a() != 2) && (localDownloadTask.a() != 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BlessManager", 2, "download duplicated " + paramString2);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "download task status error, cancel it " + paramString2);
    }
    localDownloadTask.a(true);
    label144:
    DownloadTask localDownloadTask = new DownloadTask(paramString1, new File(paramString2));
    localDownloadTask.l = true;
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "startDownload: " + paramString1 + " path=" + paramString2);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, localDownloadTask);
    localDownloaderInterface.a(localDownloadTask, new wbt(this, paramString2, paramString1), null);
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = new File(this.jdField_b_of_type_JavaLangString).listFiles();
    } while (arrayOfFile == null);
    int j = 0;
    label28:
    if (j < arrayOfFile.length) {
      if ((arrayOfFile[j].getName().endsWith(".zip")) && (!arrayOfFile[j].isDirectory())) {
        break label67;
      }
    }
    label67:
    label76:
    label250:
    for (;;)
    {
      j += 1;
      break label28;
      break;
      String str1 = null;
      Iterator localIterator = paramArrayList.iterator();
      int i;
      if (localIterator.hasNext())
      {
        BlessPtvModule localBlessPtvModule = (BlessPtvModule)localIterator.next();
        str1 = localBlessPtvModule.id;
        String str2 = localBlessPtvModule.id + ".zip";
        if (arrayOfFile[j].getName().equals(str2)) {
          if (localBlessPtvModule.broken)
          {
            localBlessPtvModule.broken = false;
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label250;
        }
        arrayOfFile[j].delete();
        FileUtils.a(this.jdField_b_of_type_JavaLangString + str1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BlessManager", 2, "deleteOldModules=" + arrayOfFile[j].getName());
        break;
        i = 0;
        continue;
        break label76;
        i = 1;
      }
    }
  }
  
  private boolean a(BlessTask paramBlessTask, boolean paramBoolean)
  {
    if (paramBlessTask == null) {
      return false;
    }
    Object localObject1;
    label40:
    Object localObject2;
    String str;
    if (paramBoolean)
    {
      localObject1 = new ArrayList(Arrays.asList(new String[] { paramBlessTask.starAvator, paramBlessTask.starVideo }));
      localObject2 = ((ArrayList)localObject1).iterator();
      paramBoolean = true;
      if (!((Iterator)localObject2).hasNext()) {
        break label447;
      }
      str = (String)((Iterator)localObject2).next();
      localObject1 = a(str);
      if ((TextUtils.isEmpty(str)) || (!str.equals(paramBlessTask.starVideo))) {
        break label452;
      }
      localObject1 = MD5Utils.b(str);
      paramBlessTask.ex1 = ((String)localObject1);
    }
    label442:
    label447:
    label452:
    for (int i = 1;; i = 0)
    {
      if (localObject1 == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BlessManager", 2, "checkBannersReady error banner: " + str);
        return false;
        localObject2 = new ArrayList(Arrays.asList(new String[] { paramBlessTask.mainBanner, paramBlessTask.mainCenter, paramBlessTask.typeBanner, paramBlessTask.succeededBanner, paramBlessTask.defaultVoice }));
        if (!TextUtils.isEmpty(paramBlessTask.recentHeadImgUrl)) {
          ((ArrayList)localObject2).add(paramBlessTask.recentHeadImgUrl);
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty(paramBlessTask.ptvAnimationUrl)) {
          break label40;
        }
        ((ArrayList)localObject2).add(paramBlessTask.ptvAnimationUrl);
        localObject1 = localObject2;
        break label40;
      }
      localObject1 = this.jdField_b_of_type_JavaLangString + (String)localObject1;
      if (!new File((String)localObject1).exists())
      {
        a(str, (String)localObject1);
        if (!QLog.isColorLevel()) {
          break label442;
        }
        QLog.d("BlessManager", 2, "checkBannersReady no banner: " + (String)localObject1);
        paramBoolean = false;
      }
      for (;;)
      {
        break;
        if (i != 0)
        {
          str = this.jdField_b_of_type_JavaLangString + paramBlessTask.starVideoCoverFolderName + File.separator + paramBlessTask.starVideoCoverFileName;
          if ((VersionUtils.d()) && (!new File(str).exists()))
          {
            j();
            if (QLog.isColorLevel()) {
              QLog.d("BlessManager", 2, "checkAllDownloaded no cover: " + (String)localObject1);
            }
            paramBoolean = false;
            continue;
            return paramBoolean;
          }
        }
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Date localDate1 = a(paramString1);
    Date localDate2 = a(paramString2);
    if ((localDate1 == null) || (localDate2 == null)) {}
    do
    {
      return false;
      if ((l > localDate1.getTime()) && (l < localDate2.getTime())) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BlessManager", 2, "not in time" + paramString1 + " " + paramString2);
    return false;
  }
  
  private void d(boolean paramBoolean)
  {
    boolean bool = true;
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.am, 9003);
    int i;
    label78:
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      i = 1;
      if ((i == 0) || (!c()) || (!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted)) {
        break label189;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("initEntrance show=").append(bool).append(" hasConfig=").append(paramBoolean).append(" task=").append(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask).append(" isDeleted=");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) {
          break label194;
        }
        localObject = "";
        label144:
        QLog.d("BlessManager", 2, localObject);
      }
      if (!bool) {
        break label236;
      }
      if (localRecentUser != null) {
        break label209;
      }
      a(localRecentUserProxy);
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew = false;
    }
    label189:
    label194:
    label209:
    label236:
    while (localRecentUser == null) {
      for (;;)
      {
        return;
        i = 0;
        break;
        bool = false;
        break label78;
        localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted);
        break label144;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isNew)
        {
          a(localRecentUserProxy, localRecentUser);
          a(localRecentUserProxy);
        }
      }
    }
    a(localRecentUserProxy, localRecentUser);
  }
  
  public static int g()
  {
    if (jdField_a_of_type_Int <= 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation != 2) {
        break label41;
      }
    }
    label41:
    for (jdField_a_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;; jdField_a_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels) {
      return jdField_a_of_type_Int;
    }
  }
  
  private void g()
  {
    Object localObject2 = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList = BlessUinList.a((SharedPreferences)localObject1, 1);
    this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList = BlessUinList.a((SharedPreferences)localObject1, 2);
    Object localObject3 = SharedPreferencesHandler.a((SharedPreferences)localObject1, "bless_uin_to_send", null);
    if (localObject3 != null)
    {
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList((Collection)localObject3);
      this.d = ((SharedPreferences)localObject1).getString("bless_send_wording", null);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("initUinSendRecordFromSp sendWording=").append(this.d).append(" uinListToSend=");
        if (this.jdField_c_of_type_JavaUtilArrayList != null) {
          break label183;
        }
        localObject1 = this.jdField_c_of_type_JavaUtilArrayList;
        label112:
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" blessUinList=");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList != null) {
          break label197;
        }
        localObject1 = null;
        label133:
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" webUinList=");
        if (this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList != null) {
          break label211;
        }
      }
    }
    label183:
    label197:
    label211:
    for (localObject1 = localObject2;; localObject1 = Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.a()))
    {
      QLog.d("BlessManager", 2, localObject1);
      return;
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
      break;
      localObject1 = Integer.valueOf(this.jdField_c_of_type_JavaUtilArrayList.size());
      break label112;
      localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a());
      break label133;
    }
  }
  
  private void h()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = (ArrayList)((EntityManager)localObject1).a(BlessTask.class, new BlessTask().getTableName(), false, null, null, null, null, null, null);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask = ((BlessTask)((ArrayList)localObject2).get(0));
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)((EntityManager)localObject1).a(BlessPtvModule.class, new BlessPtvModule().getTableName(), false, null, null, null, null, null, null));
    this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)((EntityManager)localObject1).a(BlessWording.class, new BlessWording().getTableName(), false, null, null, null, null, null, null));
    ((EntityManager)localObject1).a();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("initTaskAndModuleFromDB task=");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) {
        break label248;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" blessWordings=").append(this.jdField_b_of_type_JavaUtilArrayList).append(" module=");
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label259;
      }
    }
    label259:
    for (localObject1 = this.jdField_a_of_type_JavaUtilArrayList;; localObject1 = Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      QLog.d("BlessManager", 2, localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
        break label273;
      }
      this.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, false);
      d(this.jdField_c_of_type_Boolean);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, true);
      return;
      label248:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.toString();
      break;
    }
    label273:
    d(false);
  }
  
  private void i()
  {
    Object localObject;
    label128:
    String str;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      localObject = new ArrayList(Arrays.asList(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainBanner, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainCenter, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.typeBanner, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.succeededBanner, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.defaultVoice }));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl != null) {
        ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl != null) {
        ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl);
      }
      Iterator localIterator = ((ArrayList)localObject).iterator();
      break label195;
      if (!localIterator.hasNext()) {
        break label444;
      }
      str = (String)localIterator.next();
      localObject = a(str);
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideo))) {
        break label439;
      }
      localObject = MD5Utils.b(str);
      i = 1;
      label186:
      if (localObject != null) {
        break label196;
      }
      d(false);
    }
    label434:
    label439:
    label444:
    label447:
    for (;;)
    {
      label195:
      return;
      label196:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label128;
      }
      localObject = this.jdField_b_of_type_JavaLangString + (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label128;
      }
      if (!new File((String)localObject).exists())
      {
        if (!QLog.isColorLevel()) {
          break label434;
        }
        QLog.d("BlessManager", 2, "checkAllDownloaded no banner: " + (String)localObject);
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label447;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "check Modules and banners all ready");
        }
        if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        this.jdField_c_of_type_Boolean = true;
        d(true);
        return;
        if (i == 0) {
          break label128;
        }
        str = this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFolderName + File.separator + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFileName;
        if ((!VersionUtils.d()) || (new File(str).exists())) {
          break label128;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("BlessManager", 2, "checkAllDownloaded no cover: " + (String)localObject);
          i = 0;
        }
        else
        {
          i = 0;
          continue;
          i = 0;
          break label186;
          i = 1;
        }
      }
    }
  }
  
  @TargetApi(10)
  private void j()
  {
    if ((VersionUtils.d()) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.post(new wbu(this), 5, null, false);
    }
  }
  
  private boolean o()
  {
    String str1 = d();
    String str2 = c();
    if ((str1 == null) || (str2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "isStarVideoFileReady() videoCoverPath=" + str1 + ", videoPath=" + str2);
      }
      return false;
    }
    return true;
  }
  
  public int a()
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      i = -1;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread > 1) {
      return i;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread;
  }
  
  public Drawable a()
  {
    Object localObject2 = BaseApplication.getContext().getResources().getDrawable(2130838242);
    Object localObject1 = localObject2;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl != null)
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.recentHeadImgUrl);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = this.jdField_b_of_type_JavaLangString + (String)localObject1;
            localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            i = AIOUtils.a(50.0F, BaseApplication.getContext().getResources());
            localURLDrawableOptions.mRequestHeight = i;
            localURLDrawableOptions.mRequestWidth = i;
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = URLDrawable.getDrawable(new File((String)localObject1), localURLDrawableOptions);
          }
        }
        localObject1 = localObject2;
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
          localObject1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        }
      }
    }
    localObject2 = localObject1;
    if (h())
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvator);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = this.jdField_b_of_type_JavaLangString + (String)localObject2;
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          i = AIOUtils.a(50.0F, BaseApplication.getContext().getResources());
          localURLDrawableOptions.mRequestHeight = i;
          localURLDrawableOptions.mRequestWidth = i;
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawable.getDrawable(new File((String)localObject2), localURLDrawableOptions);
        }
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
    }
    for (;;)
    {
      localHongbaoParams.jdField_b_of_type_Long = paramInt2;
      return localHongbaoParams;
      if (paramInt1 == 3) {
        localHongbaoParams.jdField_b_of_type_Int = 4;
      } else {
        localHongbaoParams.jdField_b_of_type_Int = 0;
      }
    }
  }
  
  public BlessTask a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask;
  }
  
  public MessageForShortVideo a()
  {
    MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "getPtvMessage: " + localMessageForShortVideo);
    }
    return localMessageForShortVideo;
  }
  
  public Boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationSwtich);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainCenter);
    } while (str == null);
    return this.jdField_b_of_type_JavaLangString + File.separator + str;
  }
  
  public String a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return null;
    }
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
    }
    while (str != null)
    {
      return this.jdField_b_of_type_JavaLangString + File.separator + str;
      str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.mainBanner);
      continue;
      str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.succeededBanner);
    }
  }
  
  public String a(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (paramString.startsWith("http://"))
      {
        str1 = paramString.substring("http://".length(), paramString.length());
        int i = str1.lastIndexOf('/');
        if (i == -1) {
          return null;
        }
        str1 = str1.substring(i + 1);
        return str1;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "getFileNameFromUrl failed: " + paramString, localThrowable);
      }
      String str2 = null;
      return str2;
    }
  }
  
  public String a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return "";
    }
    if (paramBoolean) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareQzoneTitle;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareWeixinTitle;
  }
  
  public ArrayList a()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    SharedPreferencesHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit(), "bless_uin_to_send", new String[0]).commit();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {}
    int i;
    do
    {
      return;
      i = paramInt1;
      if (paramInt2 == this.jdField_b_of_type_JavaUtilArrayList.size() + 1) {
        i = paramInt1 - 1;
      }
    } while ((i < 0) || (i >= this.jdField_b_of_type_JavaUtilArrayList.size()));
    ((BlessWording)this.jdField_b_of_type_JavaUtilArrayList.get(i)).setEditingWording(paramString);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "setPtvMessage: " + paramMessageForShortVideo);
    }
  }
  
  public void a(String paramString)
  {
    BlessTask localBlessTask = new BlessTask();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    boolean bool = BlessTask.parse(paramString, localBlessTask, localArrayList1, localArrayList2);
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "onNewConfigReceived newTask=" + localBlessTask + " newBlessWordings=" + localArrayList2.size() + " module=" + localArrayList1.size() + " result=" + bool);
    }
    if (!bool)
    {
      a(null, null, null);
      d(false);
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramString = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label241;
        }
        localObject = (BlessPtvModule)paramString.next();
        Iterator localIterator = localArrayList1.iterator();
        if (localIterator.hasNext())
        {
          BlessPtvModule localBlessPtvModule = (BlessPtvModule)localIterator.next();
          if (!((BlessPtvModule)localObject).id.equals(localBlessPtvModule.id)) {
            break;
          }
          if (((BlessPtvModule)localObject).data.equals(localBlessPtvModule.data)) {
            localBlessPtvModule.broken = ((BlessPtvModule)localObject).broken;
          } else {
            localBlessPtvModule.broken = true;
          }
        }
      }
    }
    label241:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null)
    {
      paramString = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideo);
      localObject = a(localBlessTask.starVideo);
      if ((paramString != null) && (paramString.equals(localObject))) {
        localBlessTask.videoPlayed = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed;
      }
    }
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (!TextUtils.isEmpty(localBlessTask.starAvator)) && (!localBlessTask.starAvator.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starAvator))) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask = localBlessTask;
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
    this.jdField_b_of_type_JavaUtilArrayList = localArrayList2;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
    a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, false);
    d(this.jdField_c_of_type_Boolean);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.b();
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    BlessUinList.a(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList, 1);
    a(localBlessTask, localArrayList1, localArrayList2);
    paramString.edit().remove("bless_send_wording").commit();
    this.d = null;
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
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
    }
    while (paramInt != 2) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      str = (String)paramArrayList.next();
      this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.a(str);
    }
    BlessUinList.a(localSharedPreferences, this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList, 2);
  }
  
  public void a(List paramList)
  {
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.addAll(paramList);
    SharedPreferencesHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit(), "bless_uin_to_send", paramList.toArray()).commit();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(AppConstants.am, 9003) != null;
  }
  
  public boolean a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a(paramString);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread < 1) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "getUnreadNum=1");
    }
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceHint;
  }
  
  public ArrayList b()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.d)) {
      localArrayList.add(this.d);
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        BlessWording localBlessWording = (BlessWording)localIterator.next();
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
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((BlessWording)localIterator.next()).setEditingWording(null);
      }
    }
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {}
    String str;
    do
    {
      return;
      str = paramString;
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        str = paramString;
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
        {
          str = paramString;
          if (paramString.equals(((BlessWording)this.jdField_b_of_type_JavaUtilArrayList.get(0)).wording)) {
            str = "";
          }
        }
      }
    } while ((this.d != null) && (this.d.equals(str)));
    this.d = str;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    paramString.putString("bless_send_wording", str);
    paramString.commit();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread == 0) {}
      }
      else {
        while ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread != -1) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("BlessManager", 4, "update task to db read=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread + " videoPlayed=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unread = -1;
          EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          localEntityTransaction = localEntityManager.a();
          try
          {
            localEntityTransaction.a();
            localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
            localEntityTransaction.c();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              localEntityTransaction.b();
            }
          }
          finally
          {
            localEntityTransaction.b();
          }
          localEntityManager.a();
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed = true;
        }
      }
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {}
    for (int i = 1; (i != 0) && (c()) && (this.jdField_c_of_type_Boolean); i = 0) {
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    return this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.a(paramString);
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 100;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.uinTotalLimit;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = this.jdField_b_of_type_JavaLangString + a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ex1);
      File localFile = new File(str);
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "getStarVideoPath: " + str);
      }
      if (localFile.exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BlessManager", 2, "getStarVideoPath: " + str + " not exist");
    return null;
    return str;
  }
  
  public void c()
  {
    EntityManager localEntityManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BlessManager", 4, "update task to db isDeleted");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted = true;
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localEntityTransaction = localEntityManager.a();
    }
    try
    {
      localEntityTransaction.a();
      localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
      localEntityTransaction.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localEntityTransaction.b();
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityManager.a();
    d(false);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "onPushCmd: " + paramBoolean);
    }
    if (paramBoolean)
    {
      c();
      return;
    }
    d();
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    if ((a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceBegin, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnd)) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.entranceEnabled == 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    return c() - this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    String str;
    do
    {
      return null;
      str = this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFolderName + File.separator + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starVideoCoverFileName;
      if (new File(str).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BlessManager", 2, "getStartVideoCoverPath: " + str + " not exist");
    return null;
    return str;
  }
  
  public void d()
  {
    EntityManager localEntityManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BlessManager", 4, "update task to db isDeleted false");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.isDeleted = false;
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localEntityTransaction = localEntityManager.a();
    }
    try
    {
      localEntityTransaction.a();
      localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask);
      localEntityTransaction.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localEntityTransaction.b();
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityManager.a();
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starBegin, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.starEnd);
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 100;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.sendTotalLimit;
  }
  
  public String e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareUrl))) {
      return "https://wa.qq.com/qfzf/index.html?_wv=16777217&adtag=main";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.shareUrl;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "check entrance.");
    }
    if (!c())
    {
      RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.am, 9003);
      if (localRecentUser != null) {
        a(localRecentUserProxy, localRecentUser);
      }
    }
  }
  
  public boolean e()
  {
    boolean bool1 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    boolean bool2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.BlessPTVEnable.name()).equals("1");
    boolean bool3 = VideoEnvironment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool4 = VideoEnvironment.c();
    boolean bool5 = VcSystemInfo.e();
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "isPTVEnabled task=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled + " ptvRecord=" + bool3 + " isX86=" + bool4 + " frontCamera=" + true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled == 1) && (bool3) && (!bool4) && (bool5) && (!bool2)) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.pendantCategory;
  }
  
  public void f()
  {
    ThreadManager.post(new wbv(this), 5, null, true);
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvEnabled != 1) {
      return true;
    }
    return false;
  }
  
  public String g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.pendantId;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.filterCategory;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while ((!VersionUtils.d()) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.videoPlayed) || (!d()) || (!o())) {
      return false;
    }
    return true;
  }
  
  public int i()
  {
    return 30;
  }
  
  public String i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.filterId;
  }
  
  public boolean i()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.supportVideo == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int j()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
    return i() - this.jdField_b_of_type_ComTencentMobileqqActivityBlessBlessUinList.a();
  }
  
  public String j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl))) {
      return "";
    }
    String str = a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl);
    if (str == null) {
      return "";
    }
    return this.jdField_b_of_type_JavaLangString + File.separator + str;
  }
  
  public boolean j()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.supportPhoto == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
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
  
  public String k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationUrl))) {}
    String str;
    do
    {
      return "";
      str = j();
    } while (!str.endsWith(".zip"));
    return str.substring(0, str.length() - 4) + File.separator;
  }
  
  public boolean k()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.supportPendant == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.cameraMode != 1) {
      return 1;
    }
    return 2;
  }
  
  public boolean l()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.supportFilter == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationCount;
  }
  
  public boolean m()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unfoldPendant == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return 2000;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.ptvAnimationCost;
  }
  
  public boolean n()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTask.unfoldFilter == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    Object localObject = (DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    if (localObject != null)
    {
      localObject = ((DownloaderFactory)localObject).a(1);
      if (localObject != null) {
        ((DownloaderInterface)localObject).a(true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager
 * JD-Core Version:    0.7.0.1
 */