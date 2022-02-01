package com.tencent.biz.qqstory.model;

import android.content.Intent;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.GetBlackStatusRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.SharedPreUtils;
import mqq.app.AppRuntime;

public class StoryConfigManager
  extends ConfigManager
{
  public static String a = "key_get_video_source_tag_config_time";
  public static String b;
  public static String c = "key_last_get_config_time";
  private long a;
  public QQStoryConfigServletHandler a;
  private long b;
  
  static
  {
    jdField_b_of_type_JavaLangString = a(-128);
  }
  
  public StoryConfigManager()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelQQStoryConfigServletHandler = ((QQStoryConfigServletHandler)StoryApi.a(QQStoryConfigServletHandler.class, new Object[0]));
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    super.a(BaseApplicationImpl.getApplication());
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqstory_config_version_of_type__");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String b()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public static int c()
  {
    return ((Integer)((StoryConfigManager)SuperManager.a(10)).b("int_upload_video_size_limit", Integer.valueOf(5120))).intValue() * 1024;
  }
  
  public static void c(String paramString)
  {
    ((StoryConfigManager)SuperManager.a(10)).b("key_take_video_node_config", paramString);
  }
  
  public static void c(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean c()
  {
    return ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_enable_cq_mode", Boolean.valueOf(true))).booleanValue();
  }
  
  public static int d()
  {
    return ((Integer)((StoryConfigManager)SuperManager.a(10)).b("int_high_bitrate", Integer.valueOf(3000))).intValue() * 1000;
  }
  
  public static String d()
  {
    return (String)((StoryConfigManager)SuperManager.a(10)).b("key_take_video_node_config", "");
  }
  
  public static void d(String paramString)
  {
    ((StoryConfigManager)SuperManager.a(10)).b("key_story_album_config", paramString);
  }
  
  public static void d(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean d()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return false;
    }
    return ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_need_high_profile", Boolean.valueOf(false))).booleanValue();
  }
  
  public static String e()
  {
    return (String)((StoryConfigManager)SuperManager.a(10)).b("key_story_album_config", "");
  }
  
  public static void e(String paramString)
  {
    ((StoryConfigManager)SuperManager.a(10)).b("key_story_home_album_entra_confg", paramString);
  }
  
  public static void e(boolean paramBoolean)
  {
    ((StoryConfigManager)SuperManager.a(10)).b("key_take_video_node_config_clicked", Boolean.valueOf(paramBoolean));
  }
  
  public static boolean e()
  {
    return ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("key_take_video_node_config_clicked", Boolean.valueOf(false))).booleanValue();
  }
  
  public static String f()
  {
    return (String)((StoryConfigManager)SuperManager.a(10)).b("key_story_home_album_entra_confg", "");
  }
  
  public static void f(String paramString)
  {
    ((StoryConfigManager)SuperManager.a(10)).c("thumbnail_config", paramString);
  }
  
  public static String g()
  {
    return (String)((StoryConfigManager)SuperManager.a(10)).c("thumbnail_config", "");
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
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    b("qqstory_retry_proto_list", paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    b("has_show_play_guide_vertical", Boolean.valueOf(paramBoolean));
  }
  
  public boolean a()
  {
    return ((Boolean)b("has_show_play_guide_vertical", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean a(int paramInt, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryModelQQStoryConfigServletHandler.a(paramInt, paramIntent, paramConfig);
  }
  
  public int b()
  {
    return SharedPreUtils.a(QQStoryContext.a().a(), jdField_b_of_type_JavaLangString, QQStoryContext.a().a());
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public <V> V b(@NonNull String paramString, @NonNull V paramV)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(b());
    return super.a(localStringBuilder.toString(), paramV);
  }
  
  public void b(long paramLong)
  {
    c(c, Long.valueOf(paramLong));
  }
  
  public void b(String paramString)
  {
    b("key_video_source_tag_info_config", paramString);
  }
  
  public <V> void b(@NonNull String paramString, @NonNull V paramV)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(b());
    super.a(localStringBuilder.toString(), paramV);
  }
  
  public void b(boolean paramBoolean)
  {
    b("has_show_play_guide_horizontal", Boolean.valueOf(paramBoolean));
  }
  
  public boolean b()
  {
    return ((Boolean)b("has_show_play_guide_horizontal", Boolean.valueOf(false))).booleanValue();
  }
  
  public long c()
  {
    return ((Long)c(c, Long.valueOf(0L))).longValue();
  }
  
  public <V> V c(@NonNull String paramString, @NonNull V paramV)
  {
    return super.a(paramString, paramV);
  }
  
  public String c()
  {
    return (String)b("key_video_source_tag_info_config", "");
  }
  
  public void c()
  {
    SLog.b("Q.qqstory.config.StoryConfigManager", "getBlackStatus");
    int i = ((Integer)b("qqstory_black_status_last_update_time", Integer.valueOf(0))).intValue();
    int j = ((Integer)b("qqstory_black_status_update_interval", Integer.valueOf(14400))).intValue();
    long l = NetConnInfoCenter.getServerTime();
    if (l > i + j)
    {
      GetBlackStatusRequest localGetBlackStatusRequest = new GetBlackStatusRequest();
      localGetBlackStatusRequest.jdField_b_of_type_JavaLangString = QQStoryContext.a().b();
      CmdTaskManger.a().a(localGetBlackStatusRequest, new StoryConfigManager.2(this, l));
    }
  }
  
  public void c(long paramLong)
  {
    c(jdField_a_of_type_JavaLangString, Long.valueOf(paramLong));
  }
  
  public <V> void c(@NonNull String paramString, @NonNull V paramV)
  {
    super.a(paramString, paramV);
  }
  
  public long d()
  {
    return ((Long)c(jdField_a_of_type_JavaLangString, Long.valueOf(0L))).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryConfigManager
 * JD-Core Version:    0.7.0.1
 */