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
  public static String a = "0";
  public static String b = "1";
  public static final String c = HardCodeUtil.a(2131913788);
  private static VSConfigManager f = null;
  protected SharedPreferences d;
  private ConcurrentHashMap<String, Object> e = new ConcurrentHashMap();
  
  private VSConfigManager()
  {
    f();
  }
  
  public static VSConfigManager a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new VSConfigManager();
        }
      }
      finally {}
    }
    return f;
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
            b(str, Long.valueOf(localStIntConf.value.get()));
          }
        }
        i += 1;
      }
    }
  }
  
  private <V> V c(@NonNull String paramString, @NonNull V paramV)
  {
    Object localObject;
    if (paramV.getClass() == Integer.class)
    {
      localObject = Integer.valueOf(this.d.getInt(paramString, ((Integer)paramV).intValue()));
    }
    else if (paramV.getClass() == Long.class)
    {
      localObject = Long.valueOf(this.d.getLong(paramString, ((Long)paramV).longValue()));
    }
    else if (paramV.getClass() == String.class)
    {
      localObject = this.d.getString(paramString, (String)paramV);
    }
    else
    {
      if (paramV.getClass() != Boolean.class) {
        break label202;
      }
      localObject = Boolean.valueOf(this.d.getBoolean(paramString, ((Boolean)paramV).booleanValue()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get value from sp success : K:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", V : ");
    localStringBuilder.append(localObject);
    QLog.i("Q.videostory.config.VSConfigManager", 2, localStringBuilder.toString());
    if ((localObject != null) && (localObject.getClass() == paramV.getClass()))
    {
      this.e.put(paramString, localObject);
      return localObject;
    }
    return paramV;
    label202:
    paramString = new StringBuilder();
    paramString.append("defValue class is not support : ");
    paramString.append(paramV.getClass());
    throw new IllegalArgumentException(paramString.toString());
  }
  
  private <V> void d(String paramString, V paramV)
  {
    boolean bool;
    if (paramV.getClass() == Integer.class)
    {
      bool = this.d.edit().putInt(paramString, ((Integer)paramV).intValue()).commit();
    }
    else if (paramV.getClass() == Long.class)
    {
      bool = this.d.edit().putLong(paramString, ((Long)paramV).longValue()).commit();
    }
    else if (paramV.getClass() == String.class)
    {
      bool = this.d.edit().putString(paramString, (String)paramV).commit();
    }
    else
    {
      if (paramV.getClass() != Boolean.class) {
        break label260;
      }
      bool = this.d.edit().putBoolean(paramString, ((Boolean)paramV).booleanValue()).commit();
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
  
  private void f()
  {
    this.d = BaseApplicationImpl.getApplication().getSharedPreferences("videostory_config", 4);
    ThreadManager.executeOnSubThread(new VSConfigManager.1(this));
  }
  
  private String g()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public <V> V a(@NonNull String paramString, @NonNull V paramV)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(g());
    localObject = ((StringBuilder)localObject).toString();
    if (!this.e.containsKey(localObject)) {
      return c((String)localObject, paramV);
    }
    if (paramV.getClass() == Integer.class)
    {
      paramString = (Integer)this.e.get(localObject);
    }
    else if (paramV.getClass() == Long.class)
    {
      paramString = (Long)this.e.get(localObject);
    }
    else if (paramV.getClass() == String.class)
    {
      paramString = (String)this.e.get(localObject);
    }
    else
    {
      if (paramV.getClass() != Boolean.class) {
        break label229;
      }
      paramString = (Boolean)this.e.get(localObject);
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
    VSNetworkHelper.getInstance().sendRequest(new GetStoryConfigRequest(), new VSConfigManager.2(this));
  }
  
  public <V> void b(String paramString, V paramV)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(g());
    paramString = localStringBuilder.toString();
    if (paramV.getClass() == Integer.class)
    {
      this.e.put(paramString, (Integer)paramV);
    }
    else if (paramV.getClass() == Long.class)
    {
      this.e.put(paramString, (Long)paramV);
    }
    else if (paramV.getClass() == String.class)
    {
      this.e.put(paramString, (String)paramV);
    }
    else
    {
      if (paramV.getClass() != Boolean.class) {
        break label229;
      }
      this.e.put(paramString, (Boolean)paramV);
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
    d(paramString, paramV);
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
  
  public boolean c()
  {
    boolean bool = ((Boolean)a().a("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(false))).booleanValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isApplyStyleConfig:");
    localStringBuilder.append(bool);
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, localStringBuilder.toString());
    return bool;
  }
  
  public boolean d()
  {
    boolean bool = ((Boolean)a().a("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(false))).booleanValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isApplyWidgetConfig:");
    localStringBuilder.append(bool);
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void e()
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "resetApplyWidgetConfig");
    a().b("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(false));
  }
  
  public void onDestroy()
  {
    QLog.i("Q.videostory.config.VSConfigManager", 2, "onDestory");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager
 * JD-Core Version:    0.7.0.1
 */