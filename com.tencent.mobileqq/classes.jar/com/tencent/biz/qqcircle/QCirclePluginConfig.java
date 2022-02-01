package com.tencent.biz.qqcircle;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;
import qqcircle.QQCircleFeedBase.StBusiInfoData;

public class QCirclePluginConfig
{
  public static String a = "sp_qqcirlce_business";
  public static String b = "show_top_auth_banner_switch";
  public static String c = "tab_busi_info_data";
  public static String d = "show_first_guide";
  public static String e = "close_banner_time";
  public static String f = "qcircle_auth_tip_action_url";
  public static String g = "qcircle_is_authenticated";
  public static String h = "qcircle_feed_mute";
  public static String i = "qcircle_medal_guide_bubble_status";
  public static String j = "qcircle_edit_data_guide_bubble_status";
  public static String k = "qcircle_is_show_push_guide";
  public static String l = "qcircle_publish_share_qzone_status";
  public static String m = "qcircle_polymerize_detail_scroll_guide";
  public static String n = "qcircle_polymerize_detail_go_home_button_guide";
  public static String o = "qcircle_nearby_tab_show_new_tips";
  public static String p = "qcircle_support_async_layout_inflater";
  public static String q = "qcircle_publish_guide_flag";
  private static volatile QCirclePluginConfig r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  
  private QCirclePluginConfig()
  {
    O();
  }
  
  public static boolean G()
  {
    return (QCircleConfigHelper.a("qqcircle", "qqcircle_global_feed_center", Integer.valueOf(1)).intValue() == 1) && (b().getBoolean("SP_KEY_GLOBAL_FEED_CENTER", true));
  }
  
  public static boolean H()
  {
    return (J()) || (K());
  }
  
  public static boolean I()
  {
    String str = QCircleConfigHelper.a("qqcircle", "full_screen_view_layout", "");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(Build.MANUFACTURER)))
    {
      if (TextUtils.isEmpty(Build.BRAND)) {
        return false;
      }
      return (str.contains(Build.MANUFACTURER.toLowerCase())) || (str.contains(Build.BRAND.toLowerCase()));
    }
    return false;
  }
  
  public static boolean J()
  {
    return b().getBoolean("SP_KEY_OPEN_RE_RANK", false);
  }
  
  public static boolean K()
  {
    boolean bool2 = false;
    Integer localInteger = Integer.valueOf(0);
    int i1 = QCircleConfigHelper.a("qqcircle", "qqcircle_rank_global_enable", localInteger).intValue();
    if (i1 == 2) {
      return true;
    }
    boolean bool1 = bool2;
    if (i1 == 1)
    {
      bool1 = bool2;
      if (QCircleConfigHelper.a("qqcircle", "qqcircle_rank_gray_enable", localInteger).intValue() == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String M()
  {
    return QCircleConfigHelper.a("qqcircle", "qqcircle_local_default_tab_type_order", "4,1,6");
  }
  
  private void O()
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null)
    {
      String str = d;
      boolean bool = true;
      this.s = localSharedPreferences.getBoolean(str, true);
      this.t = localSharedPreferences.getBoolean(k, false);
      this.u = localSharedPreferences.getBoolean(n, false);
      if ((!localSharedPreferences.getBoolean(p, true)) || (L() <= 0)) {
        bool = false;
      }
      this.v = bool;
    }
  }
  
  public static QCirclePluginConfig a()
  {
    if (r == null) {
      try
      {
        if (r == null) {
          r = new QCirclePluginConfig();
        }
      }
      finally {}
    }
    return r;
  }
  
  public static SharedPreferences b()
  {
    return RFApplication.getApplication().getSharedPreferences("QCIRCLE_PLUGIN_SHARE", 0);
  }
  
  public static SharedPreferences c()
  {
    String str = HostDataTransUtils.getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    return RFApplication.getApplication().getSharedPreferences(str, 0);
  }
  
  public static void d()
  {
    QLog.d("QCirclePluginConfig", 4, "release");
    r = null;
  }
  
  public static RFWDownloadStrategy e()
  {
    return QCircleDownloadConfig.a();
  }
  
  public boolean A()
  {
    return this.t;
  }
  
  public boolean B()
  {
    return this.u;
  }
  
  public boolean C()
  {
    return QCircleConfig.getInstance().isNeedShowPublishGuideBubble();
  }
  
  public int D()
  {
    return QCircleConfig.getInstance().getFuleCount();
  }
  
  public boolean E()
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean(o, true);
    }
    return true;
  }
  
  public void F()
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean(o, false).apply();
    }
  }
  
  public int L()
  {
    return QCircleConfigHelper.a("qqcircle", "qqcircle_suport_async_layout_inflater", Integer.valueOf(0)).intValue();
  }
  
  public boolean N()
  {
    return c().getBoolean(q, false);
  }
  
  public void a(int paramInt)
  {
    Object localObject = c();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(g);
      localStringBuilder.append("_");
      localStringBuilder.append(HostDataTransUtils.getAccount());
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt).apply();
    }
  }
  
  public void a(String paramString)
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString(f, paramString).apply();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.v = paramBoolean;
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean(p, paramBoolean).apply();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null)
    {
      paramArrayOfByte = new String(Base64.encode(paramArrayOfByte, 0));
      localSharedPreferences.edit().putString(c, paramArrayOfByte).apply();
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = c();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("_");
      localStringBuilder.append(HostDataTransUtils.getAccount());
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt).apply();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = c();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      String str = h;
      int i1;
      if (paramBoolean) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ((SharedPreferences.Editor)localObject).putInt(str, i1).apply();
    }
  }
  
  public void c(int paramInt)
  {
    QCircleConfig.getInstance().saveFuleCount(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = c();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append("_");
      localStringBuilder.append(HostDataTransUtils.getAccount());
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).apply();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    Object localObject = c();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l);
      localStringBuilder.append("_");
      localStringBuilder.append(HostDataTransUtils.getAccount());
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).apply();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.t = paramBoolean;
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean(k, paramBoolean).apply();
    }
  }
  
  public void f()
  {
    QCircleConfig.getInstance().preloadSplash();
  }
  
  public void f(boolean paramBoolean)
  {
    QCircleConfig.getInstance().setNeedShowPublishGuideBubble(paramBoolean);
  }
  
  public void g(boolean paramBoolean)
  {
    QCircleConfig.getInstance().setNeedShowPublishLabelGuideBubble(paramBoolean);
  }
  
  public boolean g()
  {
    return QCircleConfig.getInstance().getNeedShowSplash();
  }
  
  public void h()
  {
    QCircleConfig.getInstance().tryGetSplashVideoAsync();
  }
  
  public void h(boolean paramBoolean)
  {
    c().edit().putBoolean(q, paramBoolean).commit();
  }
  
  public void i()
  {
    QCircleConfig.getInstance().setSplashNotShowAgain();
  }
  
  public void j()
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean(b, false).apply();
    }
  }
  
  public boolean k()
  {
    return this.v;
  }
  
  public long l()
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getLong(e, 0L);
    }
    return 0L;
  }
  
  public void m()
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong(e, System.currentTimeMillis()).apply();
    }
  }
  
  public boolean n()
  {
    return this.s;
  }
  
  public Uri o()
  {
    return QCircleConfig.getInstance().getSplashVideoPath();
  }
  
  public int p()
  {
    return QCircleConfig.getInstance().getShowJumpDelayTime();
  }
  
  public String q()
  {
    return QCircleConfig.getInstance().getSlashLogoUrl();
  }
  
  public String r()
  {
    return QCircleConfig.getInstance().getSlashLogoTextUrl();
  }
  
  public void s()
  {
    this.s = false;
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean(d, false).apply();
    }
  }
  
  public QQCircleFeedBase.StBusiInfoData t()
  {
    Object localObject = c();
    if (localObject != null) {}
    try
    {
      localObject = ((SharedPreferences)localObject).getString(c, "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
        QQCircleFeedBase.StBusiInfoData localStBusiInfoData = new QQCircleFeedBase.StBusiInfoData();
        localStBusiInfoData.mergeFrom((byte[])localObject);
        QLog.d("QCirclePluginConfig", 2, "getBusiInfoData() success!");
        return localStBusiInfoData;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int u()
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(g);
      localStringBuilder.append("_");
      localStringBuilder.append(HostDataTransUtils.getAccount());
      return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    }
    return 0;
  }
  
  public String v()
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(f, "");
    }
    return "";
  }
  
  public boolean w()
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences == null) {
      return QCircleConfigHelper.A();
    }
    int i1 = localSharedPreferences.getInt(h, 0);
    if (i1 == 0)
    {
      b(QCircleConfigHelper.A());
      return QCircleConfigHelper.A();
    }
    return i1 == 1;
  }
  
  public boolean x()
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append("_");
      localStringBuilder.append(HostDataTransUtils.getAccount());
      return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  public int y()
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("_");
      localStringBuilder.append(HostDataTransUtils.getAccount());
      return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    }
    return 0;
  }
  
  public boolean z()
  {
    SharedPreferences localSharedPreferences = c();
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l);
      localStringBuilder.append("_");
      localStringBuilder.append(HostDataTransUtils.getAccount());
      return localSharedPreferences.getBoolean(localStringBuilder.toString(), QCircleConfigHelper.a("qqcircle", "qqcircle_sync_to_qzone_when_publish", Boolean.valueOf(false)).booleanValue());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCirclePluginConfig
 * JD-Core Version:    0.7.0.1
 */