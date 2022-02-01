package com.tencent.mobileqq.activity.aio;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.data.MessageForTimDouFuGuide;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.Manager;

public class AppGuideTipsManager
  implements Manager
{
  public static String a = "AppGuideTipsManager";
  private QQAppInterface b;
  private EntityManager c;
  private boolean d = false;
  private Map<String, AppGuideTipsConfig> e = new HashMap();
  private int f = 0;
  private AppGuideTipsConfig g = null;
  private boolean h = true;
  
  public AppGuideTipsManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.c = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private void a(MessageRecord paramMessageRecord, AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    String str = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    paramAppGuideTipsConfig = new MessageForTimDouFuGuide(paramAppGuideTipsConfig);
    paramAppGuideTipsConfig.frienduin = str;
    paramAppGuideTipsConfig.time = l;
    paramAppGuideTipsConfig.istroop = paramMessageRecord.istroop;
    this.b.getMessageFacade().a(paramAppGuideTipsConfig, this.b.getCurrentAccountUin(), false, false, true, true);
  }
  
  private void b(MessageRecord paramMessageRecord, AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    Object localObject = this.b.getCurrentAccountUin();
    String str = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    int i = paramAppGuideTipsConfig.tipsMsg.indexOf(paramAppGuideTipsConfig.tipsHighLight);
    int j = paramAppGuideTipsConfig.tipsHighLight.length();
    paramMessageRecord = new UniteGrayTipParam(str, (String)localObject, paramAppGuideTipsConfig.tipsMsg, paramMessageRecord.istroop, -5022, 2621441, l);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 1);
    ((Bundle)localObject).putString("key_action_DATA", paramAppGuideTipsConfig.tipsUrl);
    paramMessageRecord.a(i, i + j, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.b, paramMessageRecord);
    ((MessageForUniteGrayTip)localObject).appGuideTipsOpKey = paramAppGuideTipsConfig.opkey;
    UniteGrayTipMsgUtil.a(this.b, (MessageForUniteGrayTip)localObject);
  }
  
  private void g()
  {
    this.f = this.b.getPreferences().getInt("tim_is_office_user", 0);
  }
  
  public void a()
  {
    if (this.d) {
      return;
    }
    ThreadManager.post(new AppGuideTipsManager.1(this), 5, null, false);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveOfficeUserFlag: ");
      localStringBuilder.append(paramInt);
      QLog.d(str, 1, localStringBuilder.toString());
    }
    if (paramInt == this.f) {
      return;
    }
    this.f = paramInt;
    this.b.getPreferences().edit().putInt("tim_is_office_user", paramInt).apply();
  }
  
  public void a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, AppGuideTipsManager.TimTipsShower paramTimTipsShower)
  {
    if ((!this.h) && (this.f == 1))
    {
      if (this.g == null) {
        return;
      }
      if (ConfessMsgUtil.b(paramMessageRecord)) {
        return;
      }
      AppGuideTipsConfig localAppGuideTipsConfig = this.g;
      long l = NetConnInfoCenter.getServerTimeMillis();
      if ((!"0".equals(localAppGuideTipsConfig.switchKey)) && (l - localAppGuideTipsConfig.lastAddTime > localAppGuideTipsConfig.duration * 1000L) && (localAppGuideTipsConfig.addCount < localAppGuideTipsConfig.maxCount)) {
        localAppGuideTipsConfig.allow = true;
      } else {
        localAppGuideTipsConfig.allow = false;
      }
      if (localAppGuideTipsConfig.allow) {
        if (!localAppGuideTipsConfig.msgTypeMap.isEmpty())
        {
          paramMessageRecord = (Boolean)localAppGuideTipsConfig.msgTypeMap.get(Integer.valueOf(paramMessageRecord.msgtype));
          if ((paramMessageRecord == null) || (!paramMessageRecord.booleanValue())) {}
        }
        else
        {
          bool1 = true;
          break label166;
        }
      }
      boolean bool1 = false;
      label166:
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (!localAppGuideTipsConfig.aioTypes.isEmpty()) {
          bool2 = localAppGuideTipsConfig.aioTypes.contains(Integer.valueOf(paramAIOContext.O().a));
        }
      }
      if ((bool2) && (paramTimTipsShower.a(paramAIOContext)))
      {
        localAppGuideTipsConfig.allow = false;
        localAppGuideTipsConfig.addCount += 1;
        localAppGuideTipsConfig.lastAddTime = l;
        b(localAppGuideTipsConfig);
        ReportController.b(null, "dc00898", "", "", "0X8008947", "0X8008947", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tim_office_user_tips_bar_");
    localStringBuilder.append(this.b.getCurrentAccountUin());
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
    try
    {
      ((SharedPreferences.Editor)localObject).putString("tim_gray_tips_switch", paramAppGuideTipsConfig.switchKey);
      ((SharedPreferences.Editor)localObject).putInt("tim_gray_tips_total", paramAppGuideTipsConfig.maxCount);
      ((SharedPreferences.Editor)localObject).putLong("tim_gray_tips_duration", paramAppGuideTipsConfig.duration);
      ((SharedPreferences.Editor)localObject).putString("tim_gray_tips_url", paramAppGuideTipsConfig.tipsUrl);
      ((SharedPreferences.Editor)localObject).putString("tim_gray_tips_txt", paramAppGuideTipsConfig.tipsMsg);
      ((SharedPreferences.Editor)localObject).putString("tim_gray_tips_types", paramAppGuideTipsConfig.msgTypeStr);
      ((SharedPreferences.Editor)localObject).putString("tim_tips_bar_aio_types", paramAppGuideTipsConfig.aioTypeStr);
      ((SharedPreferences.Editor)localObject).apply();
      return;
    }
    catch (Exception paramAppGuideTipsConfig)
    {
      paramAppGuideTipsConfig.printStackTrace();
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("app_tail_id");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (ConfessMsgUtil.b(paramMessageRecord)) {
      return;
    }
    localObject = (AppGuideTipsConfig)this.e.get(localObject);
    if (localObject == null) {
      return;
    }
    if (((AppGuideTipsConfig)localObject).allow)
    {
      Boolean localBoolean = (Boolean)((AppGuideTipsConfig)localObject).msgTypeMap.get(Integer.valueOf(paramMessageRecord.msgtype));
      if ((localBoolean != null) && (localBoolean.booleanValue()))
      {
        i = 1;
        break label91;
      }
    }
    int i = 0;
    label91:
    if (i != 0)
    {
      ((AppGuideTipsConfig)localObject).allow = false;
      ((AppGuideTipsConfig)localObject).addCount += 1;
      ((AppGuideTipsConfig)localObject).lastAddTime = System.currentTimeMillis();
      a((Entity)localObject);
      if ("1".equals(((AppGuideTipsConfig)localObject).tipsType))
      {
        a(paramMessageRecord, (AppGuideTipsConfig)localObject);
        return;
      }
      b(paramMessageRecord, (AppGuideTipsConfig)localObject);
    }
  }
  
  /* Error */
  public void a(java.util.List<AppGuideTipsConfig> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +450 -> 451
    //   4: aload_1
    //   5: invokeinterface 406 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore 5
    //   20: aload_0
    //   21: getfield 60	com/tencent/mobileqq/activity/aio/AppGuideTipsManager:c	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   24: invokevirtual 412	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   27: astore 6
    //   29: aload 6
    //   31: astore 5
    //   33: aload 6
    //   35: astore 4
    //   37: aload 6
    //   39: invokevirtual 417	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   42: aload 6
    //   44: astore 5
    //   46: aload 6
    //   48: astore 4
    //   50: aload_0
    //   51: getfield 38	com/tencent/mobileqq/activity/aio/AppGuideTipsManager:e	Ljava/util/Map;
    //   54: invokeinterface 420 1 0
    //   59: iconst_0
    //   60: istore_3
    //   61: aload 6
    //   63: astore 5
    //   65: aload 6
    //   67: astore 4
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield 33	com/tencent/mobileqq/activity/aio/AppGuideTipsManager:d	Z
    //   74: iconst_0
    //   75: istore_2
    //   76: aload 6
    //   78: astore 5
    //   80: aload 6
    //   82: astore 4
    //   84: iload_2
    //   85: aload_1
    //   86: invokeinterface 406 1 0
    //   91: if_icmpge +99 -> 190
    //   94: aload 6
    //   96: astore 5
    //   98: aload 6
    //   100: astore 4
    //   102: aload_1
    //   103: iload_2
    //   104: invokeinterface 423 2 0
    //   109: checkcast 101	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   112: astore 7
    //   114: aload 7
    //   116: ifnull +336 -> 452
    //   119: aload 6
    //   121: astore 5
    //   123: aload 6
    //   125: astore 4
    //   127: aload_0
    //   128: getfield 60	com/tencent/mobileqq/activity/aio/AppGuideTipsManager:c	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   131: ldc 101
    //   133: aload 7
    //   135: getfield 396	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsType	Ljava/lang/String;
    //   138: invokevirtual 427	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   141: checkcast 101	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   144: astore 8
    //   146: aload 8
    //   148: ifnull +304 -> 452
    //   151: aload 6
    //   153: astore 5
    //   155: aload 6
    //   157: astore 4
    //   159: aload 7
    //   161: aload 8
    //   163: getfield 257	com/tencent/mobileqq/data/AppGuideTipsConfig:addCount	I
    //   166: putfield 257	com/tencent/mobileqq/data/AppGuideTipsConfig:addCount	I
    //   169: aload 6
    //   171: astore 5
    //   173: aload 6
    //   175: astore 4
    //   177: aload 7
    //   179: aload 8
    //   181: getfield 249	com/tencent/mobileqq/data/AppGuideTipsConfig:lastAddTime	J
    //   184: putfield 249	com/tencent/mobileqq/data/AppGuideTipsConfig:lastAddTime	J
    //   187: goto +265 -> 452
    //   190: aload 6
    //   192: astore 5
    //   194: aload 6
    //   196: astore 4
    //   198: new 101	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   201: dup
    //   202: invokespecial 428	com/tencent/mobileqq/data/AppGuideTipsConfig:<init>	()V
    //   205: astore 7
    //   207: aload 6
    //   209: astore 5
    //   211: aload 6
    //   213: astore 4
    //   215: aload 7
    //   217: sipush 1001
    //   220: invokevirtual 431	com/tencent/mobileqq/data/AppGuideTipsConfig:setStatus	(I)V
    //   223: aload 6
    //   225: astore 5
    //   227: aload 6
    //   229: astore 4
    //   231: aload_0
    //   232: getfield 60	com/tencent/mobileqq/activity/aio/AppGuideTipsManager:c	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   235: aload 7
    //   237: ldc_w 433
    //   240: iconst_1
    //   241: anewarray 109	java/lang/String
    //   244: dup
    //   245: iconst_0
    //   246: ldc 239
    //   248: aastore
    //   249: invokevirtual 437	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;Ljava/lang/String;[Ljava/lang/String;)Z
    //   252: pop
    //   253: iload_3
    //   254: istore_2
    //   255: aload 6
    //   257: astore 5
    //   259: aload 6
    //   261: astore 4
    //   263: iload_2
    //   264: aload_1
    //   265: invokeinterface 406 1 0
    //   270: if_icmpge +46 -> 316
    //   273: aload 6
    //   275: astore 5
    //   277: aload 6
    //   279: astore 4
    //   281: aload_1
    //   282: iload_2
    //   283: invokeinterface 423 2 0
    //   288: checkcast 101	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   291: astore 7
    //   293: aload 7
    //   295: ifnull +164 -> 459
    //   298: aload 6
    //   300: astore 5
    //   302: aload 6
    //   304: astore 4
    //   306: aload_0
    //   307: aload 7
    //   309: invokevirtual 391	com/tencent/mobileqq/activity/aio/AppGuideTipsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   312: pop
    //   313: goto +146 -> 459
    //   316: aload 6
    //   318: astore 5
    //   320: aload 6
    //   322: astore 4
    //   324: aload 6
    //   326: invokevirtual 440	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   329: aload 6
    //   331: ifnull +107 -> 438
    //   334: aload 6
    //   336: astore 4
    //   338: goto +95 -> 433
    //   341: astore_1
    //   342: goto +97 -> 439
    //   345: astore_1
    //   346: aload 4
    //   348: astore 5
    //   350: aload_1
    //   351: invokevirtual 371	java/lang/Exception:printStackTrace	()V
    //   354: aload 4
    //   356: astore 5
    //   358: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq +67 -> 428
    //   364: aload 4
    //   366: astore 5
    //   368: getstatic 195	com/tencent/mobileqq/activity/aio/AppGuideTipsManager:a	Ljava/lang/String;
    //   371: astore 6
    //   373: aload 4
    //   375: astore 5
    //   377: new 197	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   384: astore 7
    //   386: aload 4
    //   388: astore 5
    //   390: aload 7
    //   392: ldc_w 442
    //   395: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 4
    //   401: astore 5
    //   403: aload 7
    //   405: aload_1
    //   406: invokevirtual 445	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   409: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 4
    //   415: astore 5
    //   417: aload 6
    //   419: iconst_2
    //   420: aload 7
    //   422: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 448	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload 4
    //   430: ifnull +8 -> 438
    //   433: aload 4
    //   435: invokevirtual 451	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   438: return
    //   439: aload 5
    //   441: ifnull +8 -> 449
    //   444: aload 5
    //   446: invokevirtual 451	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   449: aload_1
    //   450: athrow
    //   451: return
    //   452: iload_2
    //   453: iconst_1
    //   454: iadd
    //   455: istore_2
    //   456: goto -380 -> 76
    //   459: iload_2
    //   460: iconst_1
    //   461: iadd
    //   462: istore_2
    //   463: goto -208 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	this	AppGuideTipsManager
    //   0	466	1	paramList	java.util.List<AppGuideTipsConfig>
    //   75	388	2	i	int
    //   60	194	3	j	int
    //   15	419	4	localObject1	Object
    //   18	427	5	localObject2	Object
    //   27	391	6	localObject3	Object
    //   112	309	7	localObject4	Object
    //   144	36	8	localAppGuideTipsConfig	AppGuideTipsConfig
    // Exception table:
    //   from	to	target	type
    //   20	29	341	finally
    //   37	42	341	finally
    //   50	59	341	finally
    //   69	74	341	finally
    //   84	94	341	finally
    //   102	114	341	finally
    //   127	146	341	finally
    //   159	169	341	finally
    //   177	187	341	finally
    //   198	207	341	finally
    //   215	223	341	finally
    //   231	253	341	finally
    //   263	273	341	finally
    //   281	293	341	finally
    //   306	313	341	finally
    //   324	329	341	finally
    //   350	354	341	finally
    //   358	364	341	finally
    //   368	373	341	finally
    //   377	386	341	finally
    //   390	399	341	finally
    //   403	413	341	finally
    //   417	428	341	finally
    //   20	29	345	java/lang/Exception
    //   37	42	345	java/lang/Exception
    //   50	59	345	java/lang/Exception
    //   69	74	345	java/lang/Exception
    //   84	94	345	java/lang/Exception
    //   102	114	345	java/lang/Exception
    //   127	146	345	java/lang/Exception
    //   159	169	345	java/lang/Exception
    //   177	187	345	java/lang/Exception
    //   198	207	345	java/lang/Exception
    //   215	223	345	java/lang/Exception
    //   231	253	345	java/lang/Exception
    //   263	273	345	java/lang/Exception
    //   281	293	345	java/lang/Exception
    //   306	313	345	java/lang/Exception
    //   324	329	345	java/lang/Exception
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool2 = this.c.isOpen();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (paramEntity.getStatus() == 1000)
    {
      this.c.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
      return bool1;
    }
    if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return false;
    }
    return this.c.update(paramEntity);
  }
  
  public void b()
  {
    if (!this.d) {
      a();
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      if (((Map)localObject).size() <= 0) {
        return;
      }
      long l = System.currentTimeMillis();
      localObject = this.e.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppGuideTipsConfig localAppGuideTipsConfig = (AppGuideTipsConfig)((Iterator)localObject).next();
        if (localAppGuideTipsConfig != null) {
          if ((!"0".equals(localAppGuideTipsConfig.switchKey)) && (l - localAppGuideTipsConfig.lastAddTime > localAppGuideTipsConfig.duration * 1000L) && (localAppGuideTipsConfig.addCount < localAppGuideTipsConfig.maxCount)) {
            localAppGuideTipsConfig.allow = true;
          } else {
            localAppGuideTipsConfig.allow = false;
          }
        }
      }
    }
  }
  
  public void b(AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "updateTimAIOTipsBarConfig, add count: ", Integer.valueOf(paramAppGuideTipsConfig.addCount) });
    }
    Object localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tim_office_user_tips_bar_");
    localStringBuilder.append(this.b.getCurrentAccountUin());
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("tim_gray_tips_count", paramAppGuideTipsConfig.addCount);
    ((SharedPreferences.Editor)localObject).putLong("tim_gray_tips_time", paramAppGuideTipsConfig.lastAddTime);
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  public void c()
  {
    AppGuideTipsConfig localAppGuideTipsConfig = new AppGuideTipsConfig();
    Object localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tim_office_user_tips_bar_");
    localStringBuilder.append(this.b.getCurrentAccountUin());
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    localAppGuideTipsConfig.switchKey = ((SharedPreferences)localObject).getString("tim_gray_tips_switch", "0");
    localAppGuideTipsConfig.maxCount = ((SharedPreferences)localObject).getInt("tim_gray_tips_total", 0);
    localAppGuideTipsConfig.duration = ((SharedPreferences)localObject).getLong("tim_gray_tips_duration", 0L);
    localAppGuideTipsConfig.tipsUrl = ((SharedPreferences)localObject).getString("tim_gray_tips_url", "");
    localAppGuideTipsConfig.tipsMsg = ((SharedPreferences)localObject).getString("tim_gray_tips_txt", "");
    localAppGuideTipsConfig.msgTypeStr = ((SharedPreferences)localObject).getString("tim_gray_tips_types", "");
    localAppGuideTipsConfig.aioTypeStr = ((SharedPreferences)localObject).getString("tim_tips_bar_aio_types", "");
    localAppGuideTipsConfig.addCount = ((SharedPreferences)localObject).getInt("tim_gray_tips_count", 0);
    localAppGuideTipsConfig.lastAddTime = ((SharedPreferences)localObject).getLong("tim_gray_tips_time", 0L);
    int i;
    int j;
    if (!TextUtils.isEmpty(localAppGuideTipsConfig.msgTypeStr))
    {
      localObject = localAppGuideTipsConfig.msgTypeStr.split("\\|");
      if (localObject != null)
      {
        i = 0;
        while (i < localObject.length)
        {
          try
          {
            j = Integer.valueOf(localObject[i]).intValue();
            localAppGuideTipsConfig.msgTypeMap.put(Integer.valueOf(j), Boolean.valueOf(true));
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
          i += 1;
        }
      }
    }
    if (!TextUtils.isEmpty(localAppGuideTipsConfig.aioTypeStr))
    {
      localObject = localAppGuideTipsConfig.aioTypeStr.split("\\|");
      if (localObject != null)
      {
        i = 0;
        while (i < localObject.length)
        {
          try
          {
            j = Integer.valueOf(localObject[i]).intValue();
            localAppGuideTipsConfig.aioTypes.add(Integer.valueOf(j));
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
          i += 1;
        }
      }
    }
    this.g = localAppGuideTipsConfig;
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "loadTimAIOTipsBarConfig, switch: ", localAppGuideTipsConfig.switchKey });
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "clearTimAIOGrayTipsBarConfig");
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tim_office_user_tips_bar_");
    localStringBuilder.append(this.b.getCurrentAccountUin());
    localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).edit().clear().apply();
  }
  
  public AppGuideTipsConfig e()
  {
    if (this.g == null) {
      c();
    }
    return this.g;
  }
  
  public void f()
  {
    ThreadManager.executeOnSubThread(new AppGuideTipsManager.2(this));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AppGuideTipsManager
 * JD-Core Version:    0.7.0.1
 */