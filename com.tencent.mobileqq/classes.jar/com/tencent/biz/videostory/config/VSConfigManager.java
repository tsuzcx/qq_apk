package com.tencent.biz.videostory.config;

import NS_QQ_STORY_CONFIG.CONFIG.StIntConf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.GetStoryConfigRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class VSConfigManager
  implements Manager
{
  private static VSConfigManager jdField_a_of_type_ComTencentBizVideostoryConfigVSConfigManager = null;
  public static String a = "0";
  public static String b = "1";
  public static final String c = HardCodeUtil.a(2131716346);
  protected SharedPreferences a;
  private ConcurrentHashMap<String, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private VSConfigManager()
  {
    c();
  }
  
  public static VSConfigManager a()
  {
    if (jdField_a_of_type_ComTencentBizVideostoryConfigVSConfigManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizVideostoryConfigVSConfigManager == null) {
          jdField_a_of_type_ComTencentBizVideostoryConfigVSConfigManager = new VSConfigManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizVideostoryConfigVSConfigManager;
  }
  
  private String a()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  private void a(List<CONFIG.StIntConf> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        CONFIG.StIntConf localStIntConf = (CONFIG.StIntConf)paramList.get(i);
        if ((localStIntConf != null) && (localStIntConf.key != null))
        {
          String str = localStIntConf.key.get();
          if ((!TextUtils.isEmpty(str)) && (("SmartMatchMusicSwitch".equals(str)) || ("SmartCutPicSpacing".equals(str)) || ("SmartCutPicWidth".equals(str)) || ("SmartCutPicMaxByte".equals(str)) || ("ShootingResolution".equals(str)) || ("SmartCutPicCount".equals(str)) || ("SmartCutPicQuality_And".equals(str)))) {
            a(str, Long.valueOf(localStIntConf.value.get()));
          }
        }
        i += 1;
      }
    }
  }
  
  private <V> V b(@NonNull String paramString, @NonNull V paramV)
  {
    Object localObject;
    if (paramV.getClass() == Integer.class)
    {
      localObject = Integer.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, ((Integer)paramV).intValue()));
    }
    else if (paramV.getClass() == Long.class)
    {
      localObject = Long.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramString, ((Long)paramV).longValue()));
    }
    else if (paramV.getClass() == String.class)
    {
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, (String)paramV);
    }
    else
    {
      if (paramV.getClass() != Boolean.class) {
        break label202;
      }
      localObject = Boolean.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramString, ((Boolean)paramV).booleanValue()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get value from sp success : K:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", V : ");
    localStringBuilder.append(localObject);
    QLog.i("Q.videostory.config.VSConfigManager", 2, localStringBuilder.toString());
    if ((localObject != null) && (localObject.getClass() == paramV.getClass()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
      return localObject;
    }
    return paramV;
    label202:
    paramString = new StringBuilder();
    paramString.append("defValue class is not support : ");
    paramString.append(paramV.getClass());
    throw new IllegalArgumentException(paramString.toString());
  }
  
  private <V> void b(String paramString, V paramV)
  {
    boolean bool;
    if (paramV.getClass() == Integer.class)
    {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramString, ((Integer)paramV).intValue()).commit();
    }
    else if (paramV.getClass() == Long.class)
    {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong(paramString, ((Long)paramV).longValue()).commit();
    }
    else if (paramV.getClass() == String.class)
    {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString, (String)paramV).commit();
    }
    else
    {
      if (paramV.getClass() != Boolean.class) {
        break label260;
      }
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(paramString, ((Boolean)paramV).booleanValue()).commit();
    }
    if (!bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("set value into sp error : K:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", V : ");
      localStringBuilder.append(paramV);
      QLog.e("Q.videostory.config.VSConfigManager", 2, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set value into sp success : K:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", V : ");
    localStringBuilder.append(paramV);
    QLog.i("Q.videostory.config.VSConfigManager", 2, localStringBuilder.toString());
    return;
    label260:
    paramString = new StringBuilder();
    paramString.append("value class is not support : ");
    paramString.append(paramV.getClass());
    throw new IllegalArgumentException(paramString.toString());
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("videostory_config", 4);
    ThreadManager.executeOnSubThread(new VSConfigManager.1(this));
  }
  
  public <V> V a(@NonNull String paramString, @NonNull V paramV)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(a());
    localObject = ((StringBuilder)localObject).toString();
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject)) {
      return b((String)localObject, paramV);
    }
    if (paramV.getClass() == Integer.class)
    {
      paramString = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    }
    else if (paramV.getClass() == Long.class)
    {
      paramString = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    }
    else if (paramV.getClass() == String.class)
    {
      paramString = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    }
    else
    {
      if (paramV.getClass() != Boolean.class) {
        break label229;
      }
      paramString = (Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get value : K : ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", V : ");
    localStringBuilder.append(paramString);
    QLog.i("Q.videostory.config.VSConfigManager", 2, localStringBuilder.toString());
    if ((paramString != null) && (paramString.getClass() == paramV.getClass())) {
      return paramString;
    }
    return paramV;
    label229:
    paramString = new StringBuilder();
    paramString.append("defValue class is not support : ");
    paramString.append(paramV.getClass());
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public void a()
  {
    VSNetworkHelper.getInstance().sendRequest(new GetStoryConfigRequest(), new VSConfigManager.2(this));
  }
  
  public <V> void a(String paramString, V paramV)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(a());
    paramString = localStringBuilder.toString();
    if (paramV.getClass() == Integer.class)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, (Integer)paramV);
    }
    else if (paramV.getClass() == Long.class)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, (Long)paramV);
    }
    else if (paramV.getClass() == String.class)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, (String)paramV);
    }
    else
    {
      if (paramV.getClass() != Boolean.class) {
        break label229;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, (Boolean)paramV);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("set value into map success :  K:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", V : ");
    localStringBuilder.append(paramV);
    QLog.i("Q.videostory.config.VSConfigManager", 2, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("set value into map success :  K:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", V : ");
    localStringBuilder.append(paramV);
    AEQLog.b("Q.videostory.config.VSConfigManager", localStringBuilder.toString());
    b(paramString, paramV);
    return;
    label229:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("set value into map error : K:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", V : ");
    localStringBuilder.append(paramV);
    QLog.e("Q.videostory.config.VSConfigManager", 2, localStringBuilder.toString());
    paramString = new StringBuilder();
    paramString.append("value class is not support : ");
    paramString.append(paramV.getClass());
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public boolean a()
  {
    boolean bool = ((Boolean)a().a("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(false))).booleanValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isApplyStyleConfig:");
    localStringBuilder.append(bool);
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, localStringBuilder.toString());
    return bool;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = ((Boolean)a().a(paramString, Boolean.valueOf(true))).booleanValue();
    boolean bool1;
    if (LocalMultiProcConfig.getLong4Uin("need_show_story_tips", 0L, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) == 1L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    bool2 &= bool1;
    paramString = new StringBuilder();
    paramString.append("needShowGuideTips:");
    paramString.append(bool2);
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, paramString.toString());
    return bool2;
  }
  
  public void b()
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "resetApplyWidgetConfig");
    a().a("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(false));
  }
  
  public boolean b()
  {
    boolean bool = ((Boolean)a().a("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(false))).booleanValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isApplyWidgetConfig:");
    localStringBuilder.append(bool);
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void onDestroy()
  {
    QLog.i("Q.videostory.config.VSConfigManager", 2, "onDestory");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager
 * JD-Core Version:    0.7.0.1
 */