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
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  protected int a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  public Drawable a;
  public QQStoryContext a;
  public TextFilterConfig a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public EntityManager a;
  public SoftReference<View> a;
  public List<QQStoryUserInfo> a;
  public ConcurrentHashMap<String, SoftReference<Bitmap>> a;
  public boolean a;
  public List<QQStoryUserInfo> b;
  public ConcurrentHashMap<String, QQStoryUserInfo> b;
  public boolean b;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  protected boolean f;
  protected boolean g = true;
  protected boolean h = false;
  protected boolean i = false;
  public boolean j = false;
  public boolean k = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.video_config_get");
    jdField_b_of_type_JavaLangString = StoryApi.a("StorySvc.video_config_set");
    jdField_c_of_type_JavaLangString = StoryApi.a("StorySvc.video_get_user_mask_list");
    jdField_d_of_type_JavaLangString = StoryApi.a("StorySvc.video_set_user_mask");
    jdField_e_of_type_JavaLangString = StoryApi.a("StorySvc.video_get_user_mask_states");
    jdField_f_of_type_JavaLangString = StoryApi.a("StorySvc.video_show_video_list");
  }
  
  public QQStoryManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(null);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    BaseApplication localBaseApplication = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQStory_Config_SP_");
    localStringBuilder.append(paramAppInterface.getAccount());
    this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext = new QQStoryContext();
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext.a();
    a();
  }
  
  public static String a()
  {
    return HardCodeUtil.a(2131710884);
  }
  
  public static void c(String paramString) {}
  
  public static boolean i()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_key_auto_play_type", 1001);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_key_msg_tab_active_next_check_time", 0L);
  }
  
  public QQStoryUserInfo a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    QQStoryUserInfo localQQStoryUserInfo = (QQStoryUserInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localQQStoryUserInfo != null) {
      return localQQStoryUserInfo;
    }
    localQQStoryUserInfo = (QQStoryUserInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(QQStoryUserInfo.class, paramString);
    if (localQQStoryUserInfo != null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localQQStoryUserInfo);
    }
    return localQQStoryUserInfo;
  }
  
  public List<QQStoryUserInfo> a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_JavaUtilList.size() != 0)
      {
        localList = this.jdField_b_of_type_JavaUtilList;
        break label46;
      }
    }
    else if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      localList = this.jdField_a_of_type_JavaUtilList;
      break label46;
    }
    List localList = null;
    label46:
    if (localList != null)
    {
      Bosses.get().postJob(new QQStoryManager.1(this, "QQStoryManager", paramBoolean));
      return localList;
    }
    return b(paramBoolean);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_my_notification", true);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_special_notification", true);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_show_allow_stranger_visit_mystory", false);
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_allow_stranger_visit_mystory", false);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_key_allow_stranger_day_num", 10);
    this.g = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_show_auto_post2discovery", true);
    this.h = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_auto_post2discovery", false);
    this.i = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_show_video_info", false);
    b(SharedPreUtils.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    this.jdField_a_of_type_ComTencentBizQqstoryConfigTextFilterConfig = new TextFilterConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_net_type", paramInt).commit();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_key_msg_tab_active_next_check_time", paramLong).commit();
  }
  
  public void a(String paramString)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
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
          this.jdField_a_of_type_Boolean = bool1;
          bool1 = bool2;
          if (paramString.getInt("isHideStory") == 1) {
            bool1 = true;
          }
          this.jdField_b_of_type_Boolean = bool1;
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
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_my_notification", paramBoolean).commit();
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List<QQStoryUserInfo> b(boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean) {
      localObject1 = " isAllowed=? ";
    } else {
      localObject1 = " isInterested=? ";
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(QQStoryUserInfo.class, true, (String)localObject1, new String[] { "1" }, null, null, null, null);
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      localObject1 = this.jdField_b_of_type_JavaUtilList;
    }
    else
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = this.jdField_a_of_type_JavaUtilList;
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
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((QQStoryUserInfo)localObject2).uin, localObject2);
      }
    }
    Object localObject2 = new ArrayList();
    return localObject2;
  }
  
  public void b()
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_pgc_media_has_subscribe");
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("has_subscribe", true).commit();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_auto_play_type", paramInt).commit();
  }
  
  public void b(String paramString)
  {
    boolean bool2 = false;
    this.j = false;
    this.k = true;
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
          this.j = bool1;
          bool1 = bool2;
          if (paramString.getInt("story_friend_steaming") == 1) {
            bool1 = true;
          }
          this.k = bool1;
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
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_special_notification", paramBoolean).commit();
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void c()
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_pgc_v_has_subscribe");
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("has_subscribe", true).commit();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_allow_stranger_day_num", paramInt).commit();
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_allow_stranger_visit_mystory", paramBoolean).commit();
  }
  
  public boolean c()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_show_allow_stranger_visit_mystory", paramBoolean).commit();
  }
  
  public boolean d()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public void e(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_show_auto_post2discovery", paramBoolean).commit();
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_open_myvideo", false);
  }
  
  public void f(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_auto_post2discovery", paramBoolean).commit();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_key_user_show_msg_tab_story_node", false);
  }
  
  public void g(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_show_video_info", paramBoolean).commit();
  }
  
  public boolean g()
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_pgc_v_has_subscribe");
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("has_subscribe", false);
  }
  
  public void h(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_open_myvideo", paramBoolean).commit();
  }
  
  public boolean h()
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_pgc_media_has_subscribe");
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("has_subscribe", false);
  }
  
  public void i(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_key_user_show_msg_tab_story_node", paramBoolean).commit();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    QQStoryContext localQQStoryContext = this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
    if (localQQStoryContext != null) {
      localQQStoryContext.c();
    }
    SuperManager.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.QQStoryManager
 * JD-Core Version:    0.7.0.1
 */