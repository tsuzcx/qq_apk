package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.campuscircle.CampusLebaEntryChecker;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.wholepeople.WholePeopleLebaEntryChecker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;
import zmx;
import zmy;

public class LebaHelper
{
  private static final String jdField_a_of_type_JavaLangString = "mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=" + Base64Util.encodeToString("https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&sonic=1".getBytes(), 0);
  int jdField_a_of_type_Int = 0;
  public QQAppInterface a;
  public CampusLebaEntryChecker a;
  public WholePeopleLebaEntryChecker a;
  List jdField_a_of_type_JavaUtilList;
  private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver = new zmx(this);
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  List b;
  public boolean b;
  public List c;
  
  public LebaHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
  }
  
  private void a(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 5, null, true);
  }
  
  private void g()
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
  
  private void h()
  {
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "qzone_feedlist";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433926);
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
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433917);
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_neighbour";
    localResourcePluginInfo.strResDesc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435189);
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
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433936);
    localResourcePluginInfo.strResURL = "qb_leba_xingqu_buluo";
    localResourcePluginInfo.strResDesc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433936);
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
  private void i()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 67	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 67	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   16: ifne +19 -> 35
    //   19: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +12 -> 34
    //   25: ldc 130
    //   27: iconst_2
    //   28: ldc_w 279
    //   31: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: return
    //   35: aload_0
    //   36: getfield 74	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   39: astore 4
    //   41: aload 4
    //   43: monitorenter
    //   44: aload_0
    //   45: getfield 74	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   48: invokeinterface 282 1 0
    //   53: aload 4
    //   55: monitorexit
    //   56: aload_0
    //   57: invokespecial 284	com/tencent/mobileqq/app/LebaHelper:h	()V
    //   60: aload_0
    //   61: invokespecial 287	com/tencent/mobileqq/app/LebaHelper:j	()V
    //   64: aload_0
    //   65: getfield 54	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ArrayOfByte	[B
    //   68: astore 6
    //   70: aload 6
    //   72: monitorenter
    //   73: aload_0
    //   74: getfield 72	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   77: invokeinterface 282 1 0
    //   82: aload_0
    //   83: getfield 72	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   86: aload_0
    //   87: getfield 74	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   90: invokeinterface 291 2 0
    //   95: pop
    //   96: aload_0
    //   97: getfield 72	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   100: invokeinterface 158 1 0
    //   105: ifle +140 -> 245
    //   108: iload_1
    //   109: aload_0
    //   110: getfield 72	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   113: invokeinterface 158 1 0
    //   118: if_icmpge +127 -> 245
    //   121: aload_0
    //   122: getfield 72	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   125: iload_1
    //   126: invokeinterface 162 2 0
    //   131: checkcast 148	com/tencent/mobileqq/data/ResourcePluginInfo
    //   134: astore 4
    //   136: aload 4
    //   138: ifnull +17 -> 155
    //   141: aload 4
    //   143: getfield 236	com/tencent/mobileqq/data/ResourcePluginInfo:uiResId	J
    //   146: lstore_2
    //   147: lload_2
    //   148: ldc2_w 292
    //   151: lcmp
    //   152: ifeq +51 -> 203
    //   155: iload_1
    //   156: iconst_1
    //   157: iadd
    //   158: istore_1
    //   159: goto -51 -> 108
    //   162: astore 5
    //   164: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq -114 -> 53
    //   170: ldc 130
    //   172: iconst_2
    //   173: aload 5
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   182: goto -129 -> 53
    //   185: astore 5
    //   187: aload 4
    //   189: monitorexit
    //   190: aload 5
    //   192: athrow
    //   193: astore 4
    //   195: aload 4
    //   197: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   200: goto -140 -> 60
    //   203: aload 4
    //   205: getfield 208	com/tencent/mobileqq/data/ResourcePluginInfo:strResName	Ljava/lang/String;
    //   208: astore 5
    //   210: aload 5
    //   212: astore 4
    //   214: aload 5
    //   216: ifnonnull +8 -> 224
    //   219: ldc_w 299
    //   222: astore 4
    //   224: aload_0
    //   225: getfield 67	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   228: invokevirtual 302	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   231: ldc_w 304
    //   234: aload 4
    //   236: invokestatic 309	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   239: pop
    //   240: goto -85 -> 155
    //   243: astore 4
    //   245: aload 6
    //   247: monitorexit
    //   248: aload_0
    //   249: iconst_1
    //   250: putfield 311	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_Boolean	Z
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
  private void j()
  {
    // Byte code:
    //   0: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 130
    //   8: iconst_2
    //   9: ldc_w 315
    //   12: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 67	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 140	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   22: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: astore 5
    //   27: aload 5
    //   29: bipush 64
    //   31: iconst_0
    //   32: invokestatic 152	com/tencent/mobileqq/data/ResourcePluginInfo:getAll	(Lcom/tencent/mobileqq/persistence/EntityManager;IZ)Ljava/util/List;
    //   35: astore 4
    //   37: aload 5
    //   39: invokevirtual 180	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   42: aload 4
    //   44: ifnull +274 -> 318
    //   47: aload 4
    //   49: invokeinterface 158 1 0
    //   54: ifle +264 -> 318
    //   57: iconst_0
    //   58: istore_1
    //   59: iload_1
    //   60: aload 4
    //   62: invokeinterface 158 1 0
    //   67: if_icmpge +251 -> 318
    //   70: aload 4
    //   72: iload_1
    //   73: invokeinterface 162 2 0
    //   78: checkcast 148	com/tencent/mobileqq/data/ResourcePluginInfo
    //   81: astore 6
    //   83: aload 6
    //   85: ifnull +239 -> 324
    //   88: aload 6
    //   90: getfield 172	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   93: ifnull +231 -> 324
    //   96: aload 6
    //   98: getfield 247	com/tencent/mobileqq/data/ResourcePluginInfo:strGotoUrl	Ljava/lang/String;
    //   101: ifnull +33 -> 134
    //   104: aload 6
    //   106: getfield 247	com/tencent/mobileqq/data/ResourcePluginInfo:strGotoUrl	Ljava/lang/String;
    //   109: invokestatic 321	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: ifne +22 -> 134
    //   115: aload 6
    //   117: aload 6
    //   119: getfield 247	com/tencent/mobileqq/data/ResourcePluginInfo:strGotoUrl	Ljava/lang/String;
    //   122: ldc_w 323
    //   125: ldc_w 325
    //   128: invokevirtual 329	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   131: putfield 247	com/tencent/mobileqq/data/ResourcePluginInfo:strGotoUrl	Ljava/lang/String;
    //   134: aload_0
    //   135: getfield 74	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   138: astore 5
    //   140: aload 5
    //   142: monitorenter
    //   143: iconst_0
    //   144: istore_2
    //   145: aload_0
    //   146: getfield 74	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   149: invokeinterface 158 1 0
    //   154: istore_3
    //   155: iload_2
    //   156: iload_3
    //   157: if_icmpge +162 -> 319
    //   160: aload_0
    //   161: getfield 74	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   164: iload_2
    //   165: invokeinterface 162 2 0
    //   170: checkcast 148	com/tencent/mobileqq/data/ResourcePluginInfo
    //   173: astore 7
    //   175: aload 7
    //   177: ifnull +154 -> 331
    //   180: aload 7
    //   182: getfield 172	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   185: ifnull +146 -> 331
    //   188: aload 7
    //   190: getfield 172	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   193: aload 6
    //   195: getfield 172	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   198: invokevirtual 333	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   201: istore_3
    //   202: iload_3
    //   203: ifne +128 -> 331
    //   206: iconst_1
    //   207: istore_2
    //   208: iload_2
    //   209: ifne +48 -> 257
    //   212: aload_0
    //   213: getfield 74	com/tencent/mobileqq/app/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   216: aload 6
    //   218: invokeinterface 254 2 0
    //   223: pop
    //   224: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +30 -> 257
    //   230: ldc 130
    //   232: iconst_2
    //   233: new 20	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 335
    //   243: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 6
    //   248: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload 5
    //   259: monitorexit
    //   260: goto +64 -> 324
    //   263: astore 7
    //   265: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +63 -> 331
    //   271: ldc 130
    //   273: iconst_2
    //   274: aload 7
    //   276: iconst_0
    //   277: anewarray 4	java/lang/Object
    //   280: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   283: goto +48 -> 331
    //   286: astore 7
    //   288: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq -67 -> 224
    //   294: ldc 130
    //   296: iconst_2
    //   297: aload 7
    //   299: invokevirtual 341	java/lang/IndexOutOfBoundsException:getMessage	()Ljava/lang/String;
    //   302: aload 7
    //   304: invokestatic 344	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
  
  private void k()
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
    a(new zmy(this));
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
      i();
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
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 431	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker	Lcom/tencent/mobileqq/campuscircle/CampusLebaEntryChecker;
    //   6: ifnull +38 -> 44
    //   9: aload_0
    //   10: getfield 431	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker	Lcom/tencent/mobileqq/campuscircle/CampusLebaEntryChecker;
    //   13: getfield 434	com/tencent/mobileqq/campuscircle/CampusLebaEntryChecker:jdField_b_of_type_Boolean	Z
    //   16: ifeq +25 -> 41
    //   19: aload_0
    //   20: getfield 67	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: iconst_2
    //   24: invokevirtual 437	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   27: checkcast 439	com/tencent/mobileqq/app/CardHandler
    //   30: invokevirtual 442	com/tencent/mobileqq/app/CardHandler:s	()V
    //   33: aload_0
    //   34: getfield 431	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker	Lcom/tencent/mobileqq/campuscircle/CampusLebaEntryChecker;
    //   37: iconst_0
    //   38: putfield 434	com/tencent/mobileqq/campuscircle/CampusLebaEntryChecker:jdField_b_of_type_Boolean	Z
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq -6 -> 41
    //   50: ldc 130
    //   52: iconst_2
    //   53: ldc_w 444
    //   56: invokestatic 378	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public void e()
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
  
  public void f()
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