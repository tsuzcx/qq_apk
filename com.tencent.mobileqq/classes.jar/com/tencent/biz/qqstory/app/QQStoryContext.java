package com.tencent.biz.qqstory.app;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import mqq.app.AppRuntime;

@TargetApi(14)
public class QQStoryContext
{
  protected static BaseApplicationImpl a;
  public static String a;
  public static boolean a;
  public static String b;
  public static boolean b;
  public static String c;
  protected QQStoryContext.StoryBroadcastReceiver a;
  protected QQStoryCmdHandler a;
  protected EntityManagerFactory a;
  private String d = "0_1000";
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";
    jdField_b_of_type_JavaLangString = "testserver";
    c = "last_env";
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
  }
  
  public static QQStoryContext a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQStoryManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QQSTORY_MANAGER)).a;
    }
    if ((localAppRuntime instanceof ToolAppRuntime))
    {
      localAppRuntime = ((ToolAppRuntime)localAppRuntime).onGetSubRuntime("peak");
      ((PeakAppInterface)localAppRuntime).a();
      return ((PeakAppInterface)localAppRuntime).a();
    }
    return ((PeakAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak")).a();
  }
  
  public static AppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return (PeakAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
  }
  
  public static QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public static boolean a()
  {
    a();
    return ThemeUtil.isNowThemeIsNight(a(), false, null);
  }
  
  public long a()
  {
    return a().getLongAccountUin();
  }
  
  public QQStoryCmdHandler a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler;
  }
  
  public BaseApplicationImpl a()
  {
    return jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public EntityManagerFactory a()
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null)
      {
        localObject1 = new QQStoryEntityManagerFactory((String)localObject1);
        ((QQStoryEntityManagerFactory)localObject1).verifyAuthentication();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject1);
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    }
    finally {}
  }
  
  public String a()
  {
    return a().getAccount();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 137	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: ifnonnull +65 -> 71
    //   9: iconst_1
    //   10: istore_1
    //   11: iload_1
    //   12: putstatic 61	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_Boolean	Z
    //   15: invokestatic 76	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   18: putstatic 137	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: getstatic 61	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_Boolean	Z
    //   24: ifeq +25 -> 49
    //   27: getstatic 137	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   30: new 160	com/tencent/biz/qqstory/base/StoryBoss
    //   33: dup
    //   34: getstatic 137	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   37: invokespecial 163	com/tencent/biz/qqstory/base/StoryBoss:<init>	(Landroid/content/Context;)V
    //   40: invokestatic 169	com/tribe/async/async/Bosses:initWithBoss	(Landroid/content/Context;Lcom/tribe/async/async/Boss;)V
    //   43: invokestatic 174	com/tencent/biz/qqstory/support/logging/QQStoryLoggingDelegate:a	()Lcom/tencent/biz/qqstory/support/logging/QQStoryLoggingDelegate;
    //   46: invokestatic 179	com/tencent/biz/qqstory/support/logging/SLog:a	(Lcom/tencent/biz/qqstory/support/logging/LoggingDelegate;)V
    //   49: ldc 2
    //   51: monitorexit
    //   52: ldc 181
    //   54: ldc 183
    //   56: invokestatic 186	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: new 188	com/tencent/biz/qqstory/channel/QQStoryCmdHandler
    //   63: dup
    //   64: invokespecial 189	com/tencent/biz/qqstory/channel/QQStoryCmdHandler:<init>	()V
    //   67: putfield 135	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler	Lcom/tencent/biz/qqstory/channel/QQStoryCmdHandler;
    //   70: return
    //   71: iconst_0
    //   72: istore_1
    //   73: goto -62 -> 11
    //   76: astore_2
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	QQStoryContext
    //   10	63	1	bool	boolean
    //   76	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	9	76	finally
    //   11	49	76	finally
    //   49	52	76	finally
    //   77	80	76	finally
  }
  
  public void a(String paramString)
  {
    SLog.d("Q.qqstory.user.QQStoryRuntime", "update current unionId %s", new Object[] { paramString });
    if ((!this.d.equals(paramString)) && (!"0_1000".equals(paramString)) && (!TextUtils.isEmpty(paramString)))
    {
      this.d = paramString;
      ((StoryConfigManager)SuperManager.a(10)).b("qqstory_my_union_id", this.d);
    }
  }
  
  public boolean a(String paramString)
  {
    return b().equals(paramString);
  }
  
  public String b()
  {
    if (this.d.equals("0_1000"))
    {
      this.d = ((String)((StoryConfigManager)SuperManager.a(10)).b("qqstory_my_union_id", "0_1000"));
      SLog.d("Q.qqstory.user.QQStoryRuntime", "get current unionId from sp %s", new Object[] { this.d });
    }
    return this.d;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver = new QQStoryContext.StoryBroadcastReceiver();
      this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver.a(jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    }
  }
  
  public boolean b(String paramString)
  {
    return a().equals(paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver.b(jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.app.QQStoryContext
 * JD-Core Version:    0.7.0.1
 */