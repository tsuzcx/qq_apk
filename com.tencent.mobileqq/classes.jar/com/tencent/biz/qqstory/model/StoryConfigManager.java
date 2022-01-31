package com.tencent.biz.qqstory.model;

import android.content.Intent;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.GetBlackStatusRequest;
import com.tencent.biz.qqstory.network.request.PublishConfigRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.SharedPreUtils;
import mqq.app.AppRuntime;
import ncu;
import ncv;

public class StoryConfigManager
  extends ConfigManager
{
  public static String a;
  private long a;
  public QQStoryConfigServletHandler a;
  private long b;
  
  static
  {
    jdField_a_of_type_JavaLangString = a(-128);
  }
  
  public StoryConfigManager()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelQQStoryConfigServletHandler = ((QQStoryConfigServletHandler)StoryApi.a(QQStoryConfigServletHandler.class, new Object[0]));
    super.a(BaseApplicationImpl.getApplication());
  }
  
  public static String a(int paramInt)
  {
    return "qqstory_config_version_of_type__" + paramInt;
  }
  
  public static String b()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public static void b(boolean paramBoolean)
  {
    SLog.a("StoryConfigManager", "setShowSyncToQzone :%s", Boolean.valueOf(paramBoolean));
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localStoryConfigManager.b("integer_show_sync_to_qzone_btn", Integer.valueOf(i));
      if (!paramBoolean) {
        localStoryConfigManager.b("integer_enable_sync_to_qzone", Integer.valueOf(-1));
      }
      return;
    }
  }
  
  public static boolean b()
  {
    return ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_enable_cq_mode", Boolean.valueOf(true))).booleanValue();
  }
  
  public static int c()
  {
    return ((Integer)((StoryConfigManager)SuperManager.a(10)).b("int_upload_video_size_limit", Integer.valueOf(5120))).intValue() * 1024;
  }
  
  public static void c(boolean paramBoolean)
  {
    SLog.a("StoryConfigManager", "setSyncToQzone :%s", Boolean.valueOf(paramBoolean));
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((StoryConfigManager)SuperManager.a(10)).b("integer_enable_sync_to_qzone", Integer.valueOf(i));
      return;
    }
  }
  
  public static boolean c()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return false;
    }
    return ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_need_high_profile", Boolean.valueOf(false))).booleanValue();
  }
  
  public static int d()
  {
    return ((Integer)((StoryConfigManager)SuperManager.a(10)).b("int_high_bitrate", Integer.valueOf(3000))).intValue() * 1000;
  }
  
  public static void d(boolean paramBoolean)
  {
    SLog.a("StoryConfigManager", "setSyncToQzoneDefaultValue :%s", Boolean.valueOf(paramBoolean));
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    if (((Integer)localStoryConfigManager.b("integer_enable_sync_to_qzone", Integer.valueOf(-1))).intValue() == -1)
    {
      SLog.b("StoryConfigManager", "setSyncToQzoneDefaultValue work");
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      localStoryConfigManager.b("integer_enable_sync_to_qzone", Integer.valueOf(i));
      return;
    }
  }
  
  public static boolean d()
  {
    return false;
  }
  
  public static void e()
  {
    ((StoryConfigManager)SuperManager.a(10)).b("integer_show_sync_to_qzone_tip", Integer.valueOf(1));
  }
  
  public static boolean e()
  {
    int i = ((Integer)((StoryConfigManager)SuperManager.a(10)).b("integer_show_sync_to_qzone_btn", Integer.valueOf(0))).intValue();
    SLog.a("StoryConfigManager", "isShowSyncToQzone :%d", Integer.valueOf(i));
    return i == 1;
  }
  
  public static boolean f()
  {
    int i = ((Integer)((StoryConfigManager)SuperManager.a(10)).b("integer_enable_sync_to_qzone", Integer.valueOf(-1))).intValue();
    SLog.a("StoryConfigManager", "isSyncToQzone :%s", Integer.valueOf(i));
    return i == 1;
  }
  
  public static boolean g()
  {
    return ((Integer)((StoryConfigManager)SuperManager.a(10)).b("integer_show_sync_to_qzone_tip", Integer.valueOf(0))).intValue() == 0;
  }
  
  public int a()
  {
    return ((Integer)b("qqstory_black_status", Integer.valueOf(0))).intValue();
  }
  
  public long a()
  {
    return ((Long)b("recent_story_refresh_time", Long.valueOf(0L))).longValue();
  }
  
  public String a()
  {
    return (String)b("qqstory_retry_proto_list", "");
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(String paramString)
  {
    b("qqstory_retry_proto_list", paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    b("has_show_play_guide", Boolean.valueOf(paramBoolean));
  }
  
  public boolean a()
  {
    return ((Boolean)b("has_show_play_guide", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean a(int paramInt, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryModelQQStoryConfigServletHandler.a(paramInt, paramIntent, paramConfig);
  }
  
  public int b()
  {
    return SharedPreUtils.a(QQStoryContext.a().a(), jdField_a_of_type_JavaLangString, QQStoryContext.a().a());
  }
  
  public long b()
  {
    return this.b;
  }
  
  public Object b(@NonNull String paramString, @NonNull Object paramObject)
  {
    return super.a(paramString + "_" + b(), paramObject);
  }
  
  public void b(@NonNull String paramString, @NonNull Object paramObject)
  {
    super.a(paramString + "_" + b(), paramObject);
  }
  
  public void c()
  {
    SLog.b("StoryConfigManager", "fireSyncServer");
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 7200000L)
    {
      SLog.b("StoryConfigManager", "need update story publish config from server.");
      PublishConfigRequest localPublishConfigRequest = new PublishConfigRequest();
      CmdTaskManger.a().a(localPublishConfigRequest, new ncu(this));
    }
  }
  
  public void d()
  {
    SLog.b("StoryConfigManager", "getBlackStatus");
    int i = ((Integer)b("qqstory_black_status_last_update_time", Integer.valueOf(0))).intValue();
    int j = ((Integer)b("qqstory_black_status_update_interval", Integer.valueOf(14400))).intValue();
    long l = NetConnInfoCenter.getServerTime();
    if (l > j + i)
    {
      GetBlackStatusRequest localGetBlackStatusRequest = new GetBlackStatusRequest();
      localGetBlackStatusRequest.b = QQStoryContext.a().b();
      CmdTaskManger.a().a(localGetBlackStatusRequest, new ncv(this, l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryConfigManager
 * JD-Core Version:    0.7.0.1
 */