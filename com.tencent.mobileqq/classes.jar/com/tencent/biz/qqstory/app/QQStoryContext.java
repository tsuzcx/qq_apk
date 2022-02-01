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
  public static String a;
  public static String b = "testserver";
  public static String c = "last_env";
  protected static BaseApplicationImpl e;
  public static boolean f = true;
  public static boolean g = true;
  protected QQStoryCmdHandler d;
  protected EntityManagerFactory h;
  protected QQStoryContext.StoryBroadcastReceiver i;
  private String j = "0_1000";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append("/testEnv/");
    a = localStringBuilder.toString();
  }
  
  public static QQStoryContext a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      return ((QQStoryManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QQSTORY_MANAGER)).j;
    }
    if ((localObject instanceof ToolAppRuntime))
    {
      localObject = (PeakAppInterface)((ToolAppRuntime)localObject).onGetSubRuntime("peak");
      ((PeakAppInterface)localObject).a();
      return ((PeakAppInterface)localObject).d();
    }
    return ((PeakAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak")).d();
  }
  
  public static boolean e()
  {
    a();
    return ThemeUtil.isNowThemeIsNight(k(), false, null);
  }
  
  public static QQAppInterface j()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public static AppInterface k()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return (PeakAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
  }
  
  public void a(String paramString)
  {
    SLog.d("Q.qqstory.user.QQStoryRuntime", "update current unionId %s", new Object[] { paramString });
    if ((!this.j.equals(paramString)) && (!"0_1000".equals(paramString)) && (!TextUtils.isEmpty(paramString)))
    {
      this.j = paramString;
      ((StoryConfigManager)SuperManager.a(10)).d("qqstory_my_union_id", this.j);
    }
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (e == null)
        {
          bool = true;
          f = bool;
          e = BaseApplicationImpl.getApplication();
          if (f)
          {
            Bosses.initWithBoss(e, new StoryBoss(e));
            SLog.a(QQStoryLoggingDelegate.a());
          }
          SLog.b("Q.qqstory.user.QQStoryRuntime", "on create");
          this.d = new QQStoryCmdHandler();
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public boolean b(String paramString)
  {
    return i().equals(paramString);
  }
  
  public BaseApplicationImpl c()
  {
    return e;
  }
  
  public boolean c(String paramString)
  {
    return g().equals(paramString);
  }
  
  public EntityManagerFactory d()
  {
    Object localObject1 = g();
    if (localObject1 != null) {
      try
      {
        if (this.h == null)
        {
          localObject1 = new QQStoryEntityManagerFactory((String)localObject1);
          ((QQStoryEntityManagerFactory)localObject1).verifyAuthentication();
          this.h = ((EntityManagerFactory)localObject1);
        }
        return this.h;
      }
      finally {}
    }
    throw new IllegalStateException("Can not create a entity factory, the account is null.");
  }
  
  public QQStoryCmdHandler f()
  {
    return this.d;
  }
  
  public String g()
  {
    return k().getAccount();
  }
  
  public long h()
  {
    return k().getLongAccountUin();
  }
  
  public String i()
  {
    if (this.j.equals("0_1000"))
    {
      this.j = ((String)((StoryConfigManager)SuperManager.a(10)).c("qqstory_my_union_id", "0_1000"));
      SLog.d("Q.qqstory.user.QQStoryRuntime", "get current unionId from sp %s", new Object[] { this.j });
    }
    return this.j;
  }
  
  public void l()
  {
    if (this.i == null)
    {
      this.i = new QQStoryContext.StoryBroadcastReceiver();
      this.i.a(e);
    }
  }
  
  public void m()
  {
    QQStoryContext.StoryBroadcastReceiver localStoryBroadcastReceiver = this.i;
    if (localStoryBroadcastReceiver != null)
    {
      localStoryBroadcastReceiver.b(e);
      this.i = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.app.QQStoryContext
 * JD-Core Version:    0.7.0.1
 */