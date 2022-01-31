package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.campuscircle.CampusLebaEntryChecker;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.wholepeople.WholePeopleLebaEntryChecker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;
import zfx;
import zfy;
import zfz;

public class LebaHelper
{
  private static final String jdField_a_of_type_JavaLangString = "mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=" + Base64Util.encodeToString("https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&sonic=1".getBytes(), 0);
  int jdField_a_of_type_Int = 0;
  public QQAppInterface a;
  public CampusLebaEntryChecker a;
  public WholePeopleLebaEntryChecker a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  List jdField_a_of_type_JavaUtilList;
  public Set a;
  private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver = new zfx(this);
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  List b;
  public boolean b;
  public List c;
  public List d;
  
  public LebaHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.d = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private Bitmap a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    if ((i > 300) && (j > 300)) {
      localOptions.inSampleSize = 3;
    }
    localOptions.inJustDecodeBounds = false;
    return SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
  }
  
  private void a(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 5, null, true);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "Download success icon key = " + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        if (localMap != null)
        {
          String str = (String)localMap.get("KEY");
          if ((str != null) && (str.equals(paramString))) {
            this.jdField_a_of_type_JavaUtilArrayList.remove(localMap);
          }
        }
      }
      return;
    }
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        Map localMap;
        if (localIterator.hasNext())
        {
          localMap = (Map)localIterator.next();
          if (localMap == null) {
            continue;
          }
          String str = (String)localMap.get("KEY");
          if ((str == null) || (!str.equals(paramString))) {
            continue;
          }
          if (!localMap.containsKey("TIME")) {
            break label194;
          }
          i = ((Integer)localMap.get("TIME")).intValue();
          if (i < 3) {
            continue;
          }
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "Download failed icon key = " + paramString + ",time=" + i);
          }
        }
        return;
        i += 1;
        localMap.put("TIME", Integer.valueOf(i));
        localMap.put("LOADING", Boolean.valueOf(false));
      }
      label194:
      int i = 0;
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mobileQQ", 0);
    } while (!localSharedPreferences.getBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true));
    if (QLog.isDevelopLevel()) {
      QLog.d("LebaHelper", 4, "clearLocalDBPlugin.local plugin.");
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      List localList = ResourcePluginInfo.getAll((EntityManager)localObject1, 64, false);
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)localList.get(i);
          if ((localResourcePluginInfo != null) && (localResourcePluginInfo.cDataType == 1) && (localResourcePluginInfo.iPluginType == 64)) {
            ResourcePluginInfo.remove((EntityManager)localObject1, localResourcePluginInfo.strPkgName);
          }
          i += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        ((EntityManager)localObject1).a();
      }
    }
    finally
    {
      ((EntityManager)localObject1).a();
    }
    localObject1 = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    ((SharedPreferences.Editor)localObject1).commit();
  }
  
  private void i()
  {
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "qzone_feedlist";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433910);
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_feeds";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "tab_qzone" });
    localResourcePluginInfo.iPluginType = 64;
    localResourcePluginInfo.sPriority = 860;
    this.jdField_b_of_type_JavaUtilList.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "nearby_friends";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433901);
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_neighbour";
    localResourcePluginInfo.strResDesc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435173);
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.mobileqq&cmp=com.tencent.mobileqq.activity.NearPeopleActivity";
    localResourcePluginInfo.iPluginType = 64;
    localResourcePluginInfo.sPriority = 270;
    this.jdField_b_of_type_JavaUtilList.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tx.xingqubuluo.android";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433920);
    localResourcePluginInfo.strResURL = "qb_leba_xingqu_buluo";
    localResourcePluginInfo.strResDesc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433920);
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 826L;
    localResourcePluginInfo.strGotoUrl = jdField_a_of_type_JavaLangString;
    localResourcePluginInfo.iPluginType = 64;
    localResourcePluginInfo.sPriority = 0;
    this.jdField_b_of_type_JavaUtilList.add(localResourcePluginInfo);
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 70	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 70	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: invokevirtual 223	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   16: ifne +19 -> 35
    //   19: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +12 -> 34
    //   25: ldc 140
    //   27: iconst_2
    //   28: ldc_w 387
    //   31: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: return
    //   35: aload_0
    //   36: getfield 77	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   39: astore 4
    //   41: aload 4
    //   43: monitorenter
    //   44: aload_0
    //   45: getfield 77	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   48: invokeinterface 390 1 0
    //   53: aload 4
    //   55: monitorexit
    //   56: aload_0
    //   57: invokespecial 392	com/tencent/mobileqq/app/LebaHelper:i	()V
    //   60: aload_0
    //   61: invokespecial 395	com/tencent/mobileqq/app/LebaHelper:k	()V
    //   64: aload_0
    //   65: getfield 57	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ArrayOfByte	[B
    //   68: astore 6
    //   70: aload 6
    //   72: monitorenter
    //   73: aload_0
    //   74: getfield 75	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   77: invokeinterface 390 1 0
    //   82: aload_0
    //   83: getfield 75	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   86: aload_0
    //   87: getfield 77	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   90: invokeinterface 399 2 0
    //   95: pop
    //   96: aload_0
    //   97: getfield 75	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   100: invokeinterface 272 1 0
    //   105: ifle +140 -> 245
    //   108: iload_1
    //   109: aload_0
    //   110: getfield 75	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   113: invokeinterface 272 1 0
    //   118: if_icmpge +127 -> 245
    //   121: aload_0
    //   122: getfield 75	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   125: iload_1
    //   126: invokeinterface 275 2 0
    //   131: checkcast 263	com/tencent/mobileqq/data/ResourcePluginInfo
    //   134: astore 4
    //   136: aload 4
    //   138: ifnull +17 -> 155
    //   141: aload 4
    //   143: getfield 348	com/tencent/mobileqq/data/ResourcePluginInfo:uiResId	J
    //   146: lstore_2
    //   147: lload_2
    //   148: ldc2_w 400
    //   151: lcmp
    //   152: ifeq +51 -> 203
    //   155: iload_1
    //   156: iconst_1
    //   157: iadd
    //   158: istore_1
    //   159: goto -51 -> 108
    //   162: astore 5
    //   164: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq -114 -> 53
    //   170: ldc 140
    //   172: iconst_2
    //   173: aload 5
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   182: goto -129 -> 53
    //   185: astore 5
    //   187: aload 4
    //   189: monitorexit
    //   190: aload 5
    //   192: athrow
    //   193: astore 4
    //   195: aload 4
    //   197: invokevirtual 308	java/lang/Exception:printStackTrace	()V
    //   200: goto -140 -> 60
    //   203: aload 4
    //   205: getfield 320	com/tencent/mobileqq/data/ResourcePluginInfo:strResName	Ljava/lang/String;
    //   208: astore 5
    //   210: aload 5
    //   212: astore 4
    //   214: aload 5
    //   216: ifnonnull +8 -> 224
    //   219: ldc_w 407
    //   222: astore 4
    //   224: aload_0
    //   225: getfield 70	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   228: invokevirtual 410	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   231: ldc_w 412
    //   234: aload 4
    //   236: invokestatic 417	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   239: pop
    //   240: goto -85 -> 155
    //   243: astore 4
    //   245: aload 6
    //   247: monitorexit
    //   248: aload_0
    //   249: iconst_1
    //   250: putfield 419	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_Boolean	Z
    //   253: return
    //   254: astore 4
    //   256: aload 6
    //   258: monitorexit
    //   259: aload 4
    //   261: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	LebaHelper
    //   1	158	1	i	int
    //   146	2	2	l	long
    //   39	149	4	localObject1	Object
    //   193	11	4	localException1	Exception
    //   212	23	4	localObject2	Object
    //   243	1	4	localThrowable	java.lang.Throwable
    //   254	6	4	localObject3	Object
    //   162	12	5	localException2	Exception
    //   185	6	5	localObject4	Object
    //   208	7	5	str	String
    // Exception table:
    //   from	to	target	type
    //   44	53	162	java/lang/Exception
    //   44	53	185	finally
    //   53	56	185	finally
    //   164	182	185	finally
    //   187	190	185	finally
    //   56	60	193	java/lang/Exception
    //   96	108	243	java/lang/Throwable
    //   108	136	243	java/lang/Throwable
    //   141	147	243	java/lang/Throwable
    //   203	210	243	java/lang/Throwable
    //   224	240	243	java/lang/Throwable
    //   73	96	254	finally
    //   96	108	254	finally
    //   108	136	254	finally
    //   141	147	254	finally
    //   203	210	254	finally
    //   224	240	254	finally
    //   245	248	254	finally
    //   256	259	254	finally
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 140
    //   8: iconst_2
    //   9: ldc_w 423
    //   12: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 70	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 255	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   22: invokevirtual 261	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: astore 5
    //   27: aload 5
    //   29: bipush 64
    //   31: iconst_0
    //   32: invokestatic 267	com/tencent/mobileqq/data/ResourcePluginInfo:getAll	(Lcom/tencent/mobileqq/persistence/EntityManager;IZ)Ljava/util/List;
    //   35: astore 4
    //   37: aload 5
    //   39: invokevirtual 292	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   42: aload 4
    //   44: ifnull +274 -> 318
    //   47: aload 4
    //   49: invokeinterface 272 1 0
    //   54: ifle +264 -> 318
    //   57: iconst_0
    //   58: istore_1
    //   59: iload_1
    //   60: aload 4
    //   62: invokeinterface 272 1 0
    //   67: if_icmpge +251 -> 318
    //   70: aload 4
    //   72: iload_1
    //   73: invokeinterface 275 2 0
    //   78: checkcast 263	com/tencent/mobileqq/data/ResourcePluginInfo
    //   81: astore 6
    //   83: aload 6
    //   85: ifnull +239 -> 324
    //   88: aload 6
    //   90: getfield 285	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   93: ifnull +231 -> 324
    //   96: aload 6
    //   98: getfield 359	com/tencent/mobileqq/data/ResourcePluginInfo:strGotoUrl	Ljava/lang/String;
    //   101: ifnull +33 -> 134
    //   104: aload 6
    //   106: getfield 359	com/tencent/mobileqq/data/ResourcePluginInfo:strGotoUrl	Ljava/lang/String;
    //   109: invokestatic 429	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: ifne +22 -> 134
    //   115: aload 6
    //   117: aload 6
    //   119: getfield 359	com/tencent/mobileqq/data/ResourcePluginInfo:strGotoUrl	Ljava/lang/String;
    //   122: ldc_w 431
    //   125: ldc_w 433
    //   128: invokevirtual 437	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   131: putfield 359	com/tencent/mobileqq/data/ResourcePluginInfo:strGotoUrl	Ljava/lang/String;
    //   134: aload_0
    //   135: getfield 77	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   138: astore 5
    //   140: aload 5
    //   142: monitorenter
    //   143: iconst_0
    //   144: istore_2
    //   145: aload_0
    //   146: getfield 77	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   149: invokeinterface 272 1 0
    //   154: istore_3
    //   155: iload_2
    //   156: iload_3
    //   157: if_icmpge +162 -> 319
    //   160: aload_0
    //   161: getfield 77	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   164: iload_2
    //   165: invokeinterface 275 2 0
    //   170: checkcast 263	com/tencent/mobileqq/data/ResourcePluginInfo
    //   173: astore 7
    //   175: aload 7
    //   177: ifnull +154 -> 331
    //   180: aload 7
    //   182: getfield 285	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   185: ifnull +146 -> 331
    //   188: aload 7
    //   190: getfield 285	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   193: aload 6
    //   195: getfield 285	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   198: invokevirtual 441	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   201: istore_3
    //   202: iload_3
    //   203: ifne +128 -> 331
    //   206: iconst_1
    //   207: istore_2
    //   208: iload_2
    //   209: ifne +48 -> 257
    //   212: aload_0
    //   213: getfield 77	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   216: aload 6
    //   218: invokeinterface 365 2 0
    //   223: pop
    //   224: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +30 -> 257
    //   230: ldc 140
    //   232: iconst_2
    //   233: new 23	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 443
    //   243: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 6
    //   248: invokevirtual 446	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload 5
    //   259: monitorexit
    //   260: goto +64 -> 324
    //   263: astore 7
    //   265: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +63 -> 331
    //   271: ldc 140
    //   273: iconst_2
    //   274: aload 7
    //   276: iconst_0
    //   277: anewarray 4	java/lang/Object
    //   280: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   283: goto +48 -> 331
    //   286: astore 7
    //   288: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq -67 -> 224
    //   294: ldc 140
    //   296: iconst_2
    //   297: aload 7
    //   299: invokevirtual 449	java/lang/IndexOutOfBoundsException:getMessage	()Ljava/lang/String;
    //   302: aload 7
    //   304: invokestatic 452	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   307: goto -83 -> 224
    //   310: astore 4
    //   312: aload 5
    //   314: monitorexit
    //   315: aload 4
    //   317: athrow
    //   318: return
    //   319: iconst_0
    //   320: istore_2
    //   321: goto -113 -> 208
    //   324: iload_1
    //   325: iconst_1
    //   326: iadd
    //   327: istore_1
    //   328: goto -269 -> 59
    //   331: iload_2
    //   332: iconst_1
    //   333: iadd
    //   334: istore_2
    //   335: goto -190 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	LebaHelper
    //   58	270	1	i	int
    //   144	191	2	j	int
    //   154	49	3	k	int
    //   35	36	4	localList	List
    //   310	6	4	localObject1	Object
    //   25	288	5	localObject2	Object
    //   81	166	6	localResourcePluginInfo1	ResourcePluginInfo
    //   173	16	7	localResourcePluginInfo2	ResourcePluginInfo
    //   263	12	7	localThrowable	java.lang.Throwable
    //   286	17	7	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    // Exception table:
    //   from	to	target	type
    //   160	175	263	java/lang/Throwable
    //   180	202	263	java/lang/Throwable
    //   212	224	286	java/lang/IndexOutOfBoundsException
    //   145	155	310	finally
    //   160	175	310	finally
    //   180	202	310	finally
    //   212	224	310	finally
    //   224	257	310	finally
    //   257	260	310	finally
    //   265	283	310	finally
    //   288	307	310	finally
    //   312	315	310	finally
  }
  
  private void l()
  {
    Iterator localIterator = new ArrayList(this.c).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 1);
    }
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "LebaHelper  init");
    }
    a(new zfy(this));
  }
  
  public void a(PluginConfigProxy paramPluginConfigProxy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "send to get leba config");
    }
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "sendLebaConfig, hasCallLoadPluginOnce=" + this.jdField_b_of_type_Boolean);
    }
    if (!this.jdField_b_of_type_Boolean) {
      j();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("LebaHelper", 2, "sendLebaConfig, mResourcePluginInfoList.size()=" + this.jdField_a_of_type_JavaUtilList.size());
          break label330;
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localResourcePluginInfo == null) || (localResourcePluginInfo.cDataType != 0)) {
              break label335;
            }
            GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
            localGetResourceReqInfoV2.cState = 0;
            localGetResourceReqInfoV2.sLanType = localResourcePluginInfo.sLanType;
            localGetResourceReqInfoV2.sResSubType = 0;
            localGetResourceReqInfoV2.strPkgName = localResourcePluginInfo.strPkgName;
            localGetResourceReqInfoV2.uiCurVer = localResourcePluginInfo.uiCurVer;
            localGetResourceReqInfoV2.uiResId = localResourcePluginInfo.uiResId;
            localArrayList.add(localGetResourceReqInfoV2);
            if (!QLog.isColorLevel()) {
              break label335;
            }
            QLog.d("LebaHelper", 2, "sendLebaConfig, add local info=" + localResourcePluginInfo);
            break label335;
          }
          HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "on Get Leba start send: " + localArrayList.size());
          }
          paramPluginConfigProxy.a(64, localArrayList, this.jdField_a_of_type_MqqObserverServerConfigObserver);
          return;
        }
      }
      label330:
      int i = 0;
      continue;
      label335:
      i += 1;
    }
  }
  
  public void a(DownloadIconsListener paramDownloadIconsListener)
  {
    synchronized (this.d)
    {
      if (!this.d.contains(paramDownloadIconsListener)) {
        this.d.add(paramDownloadIconsListener);
      }
      return;
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.c)
    {
      if (!this.c.contains(paramResourcePluginListener)) {
        this.c.add(paramResourcePluginListener);
      }
      return;
    }
  }
  
  public void a(String paramString, URL paramURL, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "Download icon for " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new zfz(this, paramURL, paramFile, paramString));
  }
  
  /* Error */
  public void a(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 88	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: astore_2
    //   14: aload_2
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 88	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   20: invokevirtual 529	java/util/ArrayList:clear	()V
    //   23: aload_0
    //   24: getfield 88	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   27: aload_1
    //   28: invokevirtual 530	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   31: pop
    //   32: aload_2
    //   33: monitorexit
    //   34: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +40 -> 77
    //   40: ldc 140
    //   42: iconst_2
    //   43: new 23	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 532
    //   53: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokeinterface 272 1 0
    //   62: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc_w 534
    //   68: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 474	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_1
    //   78: invokeinterface 456 1 0
    //   83: astore_3
    //   84: aload_3
    //   85: invokeinterface 154 1 0
    //   90: ifeq -84 -> 6
    //   93: aload_3
    //   94: invokeinterface 158 1 0
    //   99: checkcast 160	java/util/Map
    //   102: astore 4
    //   104: aload 4
    //   106: ldc 162
    //   108: invokeinterface 166 2 0
    //   113: checkcast 36	java/lang/String
    //   116: astore 5
    //   118: aload 4
    //   120: ldc_w 536
    //   123: invokeinterface 166 2 0
    //   128: checkcast 538	java/net/URL
    //   131: astore_1
    //   132: ldc_w 540
    //   135: aload_1
    //   136: invokevirtual 541	java/net/URL:toString	()Ljava/lang/String;
    //   139: invokestatic 547	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   142: astore_2
    //   143: new 538	java/net/URL
    //   146: dup
    //   147: aload_2
    //   148: invokespecial 549	java/net/URL:<init>	(Ljava/lang/String;)V
    //   151: astore_2
    //   152: aload_2
    //   153: astore_1
    //   154: aload 4
    //   156: ldc_w 551
    //   159: invokeinterface 166 2 0
    //   164: checkcast 100	java/io/File
    //   167: astore_2
    //   168: aload_0
    //   169: getfield 84	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   172: aload 5
    //   174: invokeinterface 554 2 0
    //   179: ifeq -95 -> 84
    //   182: aload_0
    //   183: aload 5
    //   185: aload_1
    //   186: aload_2
    //   187: invokevirtual 556	com/tencent/mobileqq/app/LebaHelper:a	(Ljava/lang/String;Ljava/net/URL;Ljava/io/File;)V
    //   190: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +30 -> 223
    //   196: ldc 140
    //   198: iconst_2
    //   199: new 23	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 558
    //   209: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 5
    //   214: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload 4
    //   225: ldc 208
    //   227: iconst_1
    //   228: invokestatic 213	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   231: invokeinterface 206 3 0
    //   236: pop
    //   237: goto -153 -> 84
    //   240: astore_1
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    //   245: astore_1
    //   246: aload_2
    //   247: monitorexit
    //   248: aload_1
    //   249: athrow
    //   250: astore_2
    //   251: ldc 140
    //   253: iconst_1
    //   254: new 23	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 560
    //   264: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_2
    //   268: invokevirtual 446	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: aload_2
    //   275: invokestatic 562	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   278: goto -124 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	LebaHelper
    //   0	281	1	paramList	List
    //   250	25	2	localMalformedURLException	MalformedURLException
    //   83	11	3	localIterator	Iterator
    //   102	122	4	localMap	Map
    //   116	97	5	str	String
    // Exception table:
    //   from	to	target	type
    //   9	16	240	finally
    //   34	77	240	finally
    //   77	84	240	finally
    //   84	143	240	finally
    //   143	152	240	finally
    //   154	223	240	finally
    //   223	237	240	finally
    //   248	250	240	finally
    //   251	278	240	finally
    //   16	34	245	finally
    //   246	248	245	finally
    //   143	152	250	java/net/MalformedURLException
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 3))
    {
      this.jdField_a_of_type_Boolean = false;
      PluginConfigProxy localPluginConfigProxy = new PluginConfigProxy();
      a(localPluginConfigProxy);
      localPluginConfigProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Int += 1;
    }
  }
  
  public void b(DownloadIconsListener paramDownloadIconsListener)
  {
    synchronized (this.d)
    {
      this.d.remove(paramDownloadIconsListener);
      return;
    }
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.c)
    {
      this.c.remove(paramResourcePluginListener);
      return;
    }
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        String str;
        Object localObject1;
        if (localMap != null)
        {
          str = (String)localMap.get("KEY");
          localObject1 = (URL)localMap.get("URL");
          localObject2 = MsfSdkUtils.insertMtype("Dynamic", ((URL)localObject1).toString());
        }
        try
        {
          localObject2 = new URL((String)localObject2);
          localObject1 = localObject2;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            Object localObject3;
            QLog.d("LebaHelper", 1, "add mType failed. " + localMalformedURLException, localMalformedURLException);
            continue;
            boolean bool = false;
          }
        }
        Object localObject2 = (File)localMap.get("FILE");
        localObject3 = localMap.get("LOADING");
        if ((localObject3 == null) || (!(localObject3 instanceof Boolean))) {
          break label273;
        }
        bool = ((Boolean)localObject3).booleanValue();
        if ((!TextUtils.isEmpty(str)) && (!bool) && (this.jdField_a_of_type_JavaUtilSet.add(str)))
        {
          a(str, (URL)localObject1, (File)localObject2);
          localMap.put("LOADING", Boolean.valueOf(true));
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "reDownload icon key = " + str);
          }
        }
      }
    }
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 575	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker	Lcom/tencent/mobileqq/campuscircle/CampusLebaEntryChecker;
    //   6: ifnull +38 -> 44
    //   9: aload_0
    //   10: getfield 575	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker	Lcom/tencent/mobileqq/campuscircle/CampusLebaEntryChecker;
    //   13: getfield 578	com/tencent/mobileqq/campuscircle/CampusLebaEntryChecker:jdField_b_of_type_Boolean	Z
    //   16: ifeq +25 -> 41
    //   19: aload_0
    //   20: getfield 70	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: iconst_2
    //   24: invokevirtual 581	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   27: checkcast 583	com/tencent/mobileqq/app/CardHandler
    //   30: invokevirtual 586	com/tencent/mobileqq/app/CardHandler:s	()V
    //   33: aload_0
    //   34: getfield 575	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker	Lcom/tencent/mobileqq/campuscircle/CampusLebaEntryChecker;
    //   37: iconst_0
    //   38: putfield 578	com/tencent/mobileqq/campuscircle/CampusLebaEntryChecker:jdField_b_of_type_Boolean	Z
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq -6 -> 41
    //   50: ldc 140
    //   52: iconst_2
    //   53: ldc_w 588
    //   56: invokestatic 474	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: goto -18 -> 41
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	LebaHelper
    //   62	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	41	62	finally
    //   44	59	62	finally
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker.jdField_a_of_type_Boolean)
      {
        localObject = LebaShowListManager.a().b();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
            if ((localLebaViewItem != null) && (localLebaViewItem.a != null) && (localLebaViewItem.a.uiResId == 4086L)) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008731", "0X8008731", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      LebaViewItem localLebaViewItem;
      return;
    }
    QLog.i("LebaHelper", 2, "reportCampusEntry mCampusEntryChecker is null");
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWholepeopleWholePeopleLebaEntryChecker != null) {
      this.jdField_a_of_type_ComTencentMobileqqWholepeopleWholePeopleLebaEntryChecker.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LebaHelper
 * JD-Core Version:    0.7.0.1
 */