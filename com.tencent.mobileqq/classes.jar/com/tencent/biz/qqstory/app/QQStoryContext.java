package com.tencent.biz.qqstory.app;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.StoryBoss;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.QQStoryLoggingDelegate;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.Bosses;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append("/testEnv/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_b_of_type_JavaLangString = "testserver";
    c = "last_env";
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
  }
  
  public static QQStoryContext a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      return ((QQStoryManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QQSTORY_MANAGER)).a;
    }
    if ((localObject instanceof ToolAppRuntime))
    {
      localObject = (PeakAppInterface)((ToolAppRuntime)localObject).onGetSubRuntime("peak");
      ((PeakAppInterface)localObject).a();
      return ((PeakAppInterface)localObject).a();
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
    if (localObject1 != null) {
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
    throw new IllegalStateException("Can not create a entity factory, the account is null.");
  }
  
  public String a()
  {
    return a().getAccount();
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl == null)
        {
          bool = true;
          jdField_a_of_type_Boolean = bool;
          jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.getApplication();
          if (jdField_a_of_type_Boolean)
          {
            Bosses.initWithBoss(jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, new StoryBoss(jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl));
            SLog.a(QQStoryLoggingDelegate.a());
          }
          SLog.b("Q.qqstory.user.QQStoryRuntime", "on create");
          this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler = new QQStoryCmdHandler();
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
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
    QQStoryContext.StoryBroadcastReceiver localStoryBroadcastReceiver = this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver;
    if (localStoryBroadcastReceiver != null)
    {
      localStoryBroadcastReceiver.b(jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.app.QQStoryContext
 * JD-Core Version:    0.7.0.1
 */