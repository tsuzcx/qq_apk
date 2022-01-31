package com.tencent.biz.qqstory.app;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;
import mqq.app.AppRuntime;

@TargetApi(14)
public class QQStoryContext
  implements IHttpCommunicatorFlowCount
{
  protected static BaseApplicationImpl a;
  public static String a;
  public static boolean a;
  public static String b;
  public static boolean b;
  public static String c;
  protected QQStoryCmdHandler a;
  protected EntityManagerFactory a;
  private String d = "0_1000";
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aI + "/Tencent/com/tencent/mobileqq/";
    jdField_b_of_type_JavaLangString = "testserver";
    c = "last_env";
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
  }
  
  public static QQStoryContext a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return ((QQStoryManager)BaseApplicationImpl.getApplication().getRuntime().getManager(180)).a;
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
  
  public String a(@NonNull String paramString)
  {
    return "";
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 107	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: ifnonnull +79 -> 85
    //   9: iconst_1
    //   10: istore_1
    //   11: iload_1
    //   12: putstatic 52	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_Boolean	Z
    //   15: invokestatic 67	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   18: putstatic 107	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: getstatic 52	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_Boolean	Z
    //   24: ifeq +39 -> 63
    //   27: new 136	com/tencent/biz/qqstory/support/QLogAdapter
    //   30: dup
    //   31: invokespecial 137	com/tencent/biz/qqstory/support/QLogAdapter:<init>	()V
    //   34: invokestatic 143	com/tribe/async/log/SLog:init	(Lcom/tribe/async/log/IQLog;)V
    //   37: getstatic 107	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   40: new 145	com/tencent/biz/qqstory/base/StoryBoss
    //   43: dup
    //   44: getstatic 107	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   47: invokespecial 148	com/tencent/biz/qqstory/base/StoryBoss:<init>	(Landroid/content/Context;)V
    //   50: invokestatic 154	com/tribe/async/async/Bosses:initWithBoss	(Landroid/content/Context;Lcom/tribe/async/async/Boss;)V
    //   53: invokestatic 159	com/tencent/biz/qqstory/support/logging/QQStoryLoggingDelegate:a	()Lcom/tencent/biz/qqstory/support/logging/QQStoryLoggingDelegate;
    //   56: invokestatic 164	com/tencent/biz/qqstory/support/logging/SLog:a	(Lcom/tencent/biz/qqstory/support/logging/LoggingDelegate;)V
    //   59: invokestatic 99	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/common/app/AppInterface;
    //   62: pop
    //   63: ldc 2
    //   65: monitorexit
    //   66: ldc 166
    //   68: ldc 168
    //   70: invokestatic 171	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: new 173	com/tencent/biz/qqstory/channel/QQStoryCmdHandler
    //   77: dup
    //   78: invokespecial 174	com/tencent/biz/qqstory/channel/QQStoryCmdHandler:<init>	()V
    //   81: putfield 105	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler	Lcom/tencent/biz/qqstory/channel/QQStoryCmdHandler;
    //   84: return
    //   85: iconst_0
    //   86: istore_1
    //   87: goto -76 -> 11
    //   90: astore_2
    //   91: ldc 2
    //   93: monitorexit
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	QQStoryContext
    //   10	77	1	bool	boolean
    //   90	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	9	90	finally
    //   11	63	90	finally
    //   63	66	90	finally
    //   91	94	90	finally
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
  
  public boolean b(String paramString)
  {
    return a().equals(paramString);
  }
  
  public void countFlow(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    a().sendAppDataIncerment(a(), paramBoolean, paramInt1, paramInt2, paramInt3, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.app.QQStoryContext
 * JD-Core Version:    0.7.0.1
 */