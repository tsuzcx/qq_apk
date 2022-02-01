package com.tencent.biz.qqstory.base;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.KeepConstructor;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.config.TextFilterConfig;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class QQStoryManager
  implements KeepConstructor, Manager
{
  public static final String b = StoryApi.a("StorySvc.video_config_get");
  public static final String c = StoryApi.a("StorySvc.video_config_set");
  public static final String d = StoryApi.a("StorySvc.video_get_user_mask_list");
  public static final String e = StoryApi.a("StorySvc.video_set_user_mask");
  public static final String f = StoryApi.a("StorySvc.video_get_user_mask_states");
  public static final String g = StoryApi.a("StorySvc.video_show_video_list");
  public ConcurrentHashMap<String, QQStoryUserInfo> A = new ConcurrentHashMap();
  public boolean B = false;
  public boolean C = true;
  AppInterface a;
  SharedPreferences h = null;
  public EntityManager i;
  public QQStoryContext j;
  public ConcurrentHashMap<String, SoftReference<Bitmap>> k = new ConcurrentHashMap();
  public SoftReference<View> l = new SoftReference(null);
  public Drawable m;
  public boolean n = false;
  public boolean o = false;
  protected boolean p = true;
  protected boolean q = true;
  protected boolean r = false;
  protected boolean s = false;
  protected int t = 10;
  protected boolean u = true;
  protected boolean v = false;
  protected boolean w = false;
  public TextFilterConfig x;
  public List<QQStoryUserInfo> y = new ArrayList();
  public List<QQStoryUserInfo> z = new ArrayList();
  
  public QQStoryManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    BaseApplication localBaseApplication = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQStory_Config_SP_");
    localStringBuilder.append(paramAppInterface.getAccount());
    this.h = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4);
    this.i = paramAppInterface.getEntityManagerFactory().createEntityManager();
    this.j = new QQStoryContext();
    this.j.b();
    b();
  }
  
  public static void d(String paramString) {}
  
  public static boolean o()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static String p()
  {
    return HardCodeUtil.a(2131908555);
  }
  
  public int a()
  {
    return this.h.getInt("sp_key_auto_play_type", 1001);
  }
  
  public QQStoryUserInfo a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    QQStoryUserInfo localQQStoryUserInfo = (QQStoryUserInfo)this.A.get(paramString);
    if (localQQStoryUserInfo != null) {
      return localQQStoryUserInfo;
    }
    localQQStoryUserInfo = (QQStoryUserInfo)this.i.find(QQStoryUserInfo.class, paramString);
    if (localQQStoryUserInfo != null) {
      this.A.put(paramString, localQQStoryUserInfo);
    }
    return localQQStoryUserInfo;
  }
  
  public void a(int paramInt)
  {
    this.h.edit().putInt("sp_key_net_type", paramInt).commit();
  }
  
  public void a(long paramLong)
  {
    this.h.edit().putLong("sp_key_msg_tab_active_next_check_time", paramLong).commit();
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
    this.h.edit().putBoolean("sp_key_my_notification", paramBoolean).commit();
  }
  
  public void b()
  {
    this.p = this.h.getBoolean("sp_key_my_notification", true);
    this.q = this.h.getBoolean("sp_key_special_notification", true);
    this.r = this.h.getBoolean("sp_key_show_allow_stranger_visit_mystory", false);
    this.s = this.h.getBoolean("sp_key_allow_stranger_visit_mystory", false);
    this.t = this.h.getInt("sp_key_allow_stranger_day_num", 10);
    this.u = this.h.getBoolean("sp_key_show_auto_post2discovery", true);
    this.v = this.h.getBoolean("sp_key_auto_post2discovery", false);
    this.w = this.h.getBoolean("sp_key_show_video_info", false);
    c(SharedPreUtils.ao(this.a.getApp(), this.a.getCurrentAccountUin()));
    this.x = new TextFilterConfig(this.a.getApp(), this.a.getCurrentAccountUin());
  }
  
  public void b(int paramInt)
  {
    this.h.edit().putInt("sp_key_auto_play_type", paramInt).commit();
  }
  
  public void b(String paramString)
  {
    boolean bool2 = false;
    this.n = false;
    this.o = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.getInt("isHideQZone") == 1)
        {
          bool1 = true;
          this.n = bool1;
          bool1 = bool2;
          if (paramString.getInt("isHideStory") == 1) {
            bool1 = true;
          }
          this.o = bool1;
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("readQuickShotShareToStoryConfig", 2, paramString.getMessage());
        }
        return;
      }
      boolean bool1 = false;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.q = paramBoolean;
    this.h.edit().putBoolean("sp_key_special_notification", paramBoolean).commit();
  }
  
  public void c(int paramInt)
  {
    this.t = paramInt;
    this.h.edit().putInt("sp_key_allow_stranger_day_num", paramInt).commit();
  }
  
  public void c(String paramString)
  {
    boolean bool2 = false;
    this.B = false;
    this.C = true;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.getInt("story_PGC_steaming") == 1)
        {
          bool1 = true;
          this.B = bool1;
          bool1 = bool2;
          if (paramString.getInt("story_friend_steaming") == 1) {
            bool1 = true;
          }
          this.C = bool1;
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("readStoryPlayerProxyConfig", 2, paramString.getMessage());
        }
        return;
      }
      boolean bool1 = false;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.s = paramBoolean;
    this.h.edit().putBoolean("sp_key_allow_stranger_visit_mystory", paramBoolean).commit();
  }
  
  public boolean c()
  {
    return this.p;
  }
  
  public void d(boolean paramBoolean)
  {
    this.r = paramBoolean;
    this.h.edit().putBoolean("sp_key_show_allow_stranger_visit_mystory", paramBoolean).commit();
  }
  
  public boolean d()
  {
    return this.q;
  }
  
  public void e(boolean paramBoolean)
  {
    this.u = paramBoolean;
    this.h.edit().putBoolean("sp_key_show_auto_post2discovery", paramBoolean).commit();
  }
  
  public boolean e()
  {
    return this.s;
  }
  
  public void f(boolean paramBoolean)
  {
    this.v = paramBoolean;
    this.h.edit().putBoolean("sp_key_auto_post2discovery", paramBoolean).commit();
  }
  
  public boolean f()
  {
    return this.r;
  }
  
  public int g()
  {
    return this.t;
  }
  
  public void g(boolean paramBoolean)
  {
    this.w = paramBoolean;
    this.h.edit().putBoolean("sp_key_show_video_info", paramBoolean).commit();
  }
  
  public void h(boolean paramBoolean)
  {
    this.h.edit().putBoolean("sp_key_open_myvideo", paramBoolean).commit();
  }
  
  public boolean h()
  {
    return this.h.getBoolean("sp_key_open_myvideo", false);
  }
  
  public void i(boolean paramBoolean)
  {
    this.h.edit().putBoolean("sp_key_user_show_msg_tab_story_node", paramBoolean).commit();
  }
  
  public boolean i()
  {
    return this.h.getBoolean("sp_key_user_show_msg_tab_story_node", false);
  }
  
  public long j()
  {
    return this.h.getLong("sp_key_msg_tab_active_next_check_time", 0L);
  }
  
  public List<QQStoryUserInfo> j(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.z.size() != 0)
      {
        localList = this.z;
        break label46;
      }
    }
    else if (this.y.size() != 0)
    {
      localList = this.y;
      break label46;
    }
    List localList = null;
    label46:
    if (localList != null)
    {
      Bosses.get().postJob(new QQStoryManager.1(this, "QQStoryManager", paramBoolean));
      return localList;
    }
    return k(paramBoolean);
  }
  
  public List<QQStoryUserInfo> k(boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean) {
      localObject1 = " isAllowed=? ";
    } else {
      localObject1 = " isInterested=? ";
    }
    List localList = this.i.query(QQStoryUserInfo.class, true, (String)localObject1, new String[] { "1" }, null, null, null, null);
    if (paramBoolean)
    {
      this.z = new ArrayList();
      localObject1 = this.z;
    }
    else
    {
      this.y = new ArrayList();
      localObject1 = this.y;
    }
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      for (;;)
      {
        localObject2 = localList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (QQStoryUserInfo)localIterator.next();
        ((List)localObject1).add(localObject2);
        this.A.put(((QQStoryUserInfo)localObject2).uin, localObject2);
      }
    }
    Object localObject2 = new ArrayList();
    return localObject2;
  }
  
  public void k()
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_pgc_media_has_subscribe");
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("has_subscribe", true).commit();
  }
  
  public void l()
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_pgc_v_has_subscribe");
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("has_subscribe", true).commit();
  }
  
  public boolean m()
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_pgc_v_has_subscribe");
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("has_subscribe", false);
  }
  
  public boolean n()
  {
    BaseApplication localBaseApplication = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_pgc_media_has_subscribe");
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("has_subscribe", false);
  }
  
  public void onDestroy()
  {
    this.i.close();
    QQStoryContext localQQStoryContext = this.j;
    if (localQQStoryContext != null) {
      localQQStoryContext.m();
    }
    SuperManager.c().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.QQStoryManager
 * JD-Core Version:    0.7.0.1
 */