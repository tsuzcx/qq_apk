package com.tencent.biz.videostory.config;

import NS_QQ_STORY_CONFIG.CONFIG.StIntConf;
import amtj;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bmbx;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.GetStoryConfigRequest;
import com.tencent.common.app.BaseApplicationImpl;
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
  public static final String ENABLE_CLICK_TAKE_PICTURE = "enable_click_take_picture";
  public static final String ENABLE_CLICK_TAKE_PICTURE_DEFVALUE = "1";
  public static final String ENABLE_ENTRANCE_SUBSCRIBE = "subscribe_entrance_enable";
  public static final String ENABLE_ENTRANCE_SUBSCRIBE_DEFVALUE = "1";
  public static final String ENABLE_ENTRANCE_SUBSCRIBE_OPEN_CERTIFIED_ACCOUNT = "1";
  public static final String ENABLE_NEW_STRUCTURE_MULTI = "KEY_VS_ENABLE_NEW_STRUCTURE_MULTI";
  public static final int ENABLE_NEW_STRUCTURE_MULTI_DEFAULT_VALUE = 1;
  public static final String ENABLE_SHOW_STORY_TRANS_TIPS_IN_FEEDS = "ShowStoryTransTipsInFeeds";
  public static final String ENABLE_SHOW_STORY_TRANS_TIPS_IN_PHOTOS = "ShowStoryTransTipsInPhotos";
  public static final String IS_OPEN_SHARING = "is_open_sharing";
  public static final String IS_OPEN_SHARING_DEFVALUE = "1";
  public static final String KEY_BOOLEAN_APPLY_STYLE_CONFIG = "KEY_BOOLEAN_APPLY_STYLE_CONFIG";
  public static final String KEY_BOOLEAN_APPLY_WIDGET_CONFIG = "KEY_BOOLEAN_APPLY_WIDGET_CONFIG";
  public static final String KEY_BOOLEAN_ENABLE_CQ_MODE = "KEY_BOOLEAN_ENABLE_CQ_MODE";
  public static final String KEY_HIT_FOR_VID_URLS = "KEY_HIT_FOR_VID_URLS";
  public static final String KEY_HIT_FOR_VID_URLS_VALUE = "http://qzvv.video.qq.com/qzone|https://qzvv.video.qq.com/qzone";
  public static final String KEY_NEED_HIGH_PROFILE = "KEY_NEED_HIGH_PROFILE";
  public static final String KEY_NOTIFY_DATA_SET_CHANGE_WAY_DEFTAUL = "KEY_NOTIFY_DATA_SET_CHANGE_WAY_DEFTAUL";
  public static final int KEY_NOTIFY_DATA_SET_CHANGE_WAY_DEFTAUL_VALUE = 1;
  public static final String KEY_SMART_MUSIC_ENTER_ANIM_DOWNLOAD_URL = "KEY_SMART_MUSIC_ENTER_ANIM_DOWNLOAD_URL";
  public static final String KEY_VS_ENTRANCE_STYLE_CONTENT = "KEY_VS_ENTRANCE_STYLE_CONTENT";
  public static final String KEY_VS_ENTRANCE_STYLE_MD5 = "KEY_VS_ENTRANCE_STYLE_MD5";
  public static final String KEY_VS_ENTRANCE_WIDGET_CONTENT = "KEY_VS_ENTRANCE_WIDGET_CONTENT";
  public static final String KEY_VS_ENTRANCE_WIDGET_MD5 = "KEY_VS_ENTRANCE_WIDGET_MD5";
  public static final String MINE_VIDEOSTORY_CHOUTI_ENTRANCE = "mine_videostory_drawer_entrance";
  public static String MINE_VIDEOSTORY_CHOUTI_ENTRANCE_DEFVALUE = "0";
  public static final String MINE_VIDEOSTORY_ENTRANCE = "mine_videostory_entrance";
  public static String MINE_VIDEOSTORY_ENTRANCE_DEFVALUE = "1";
  public static final String PREFERENCE_NAME = "videostory_config";
  public static final String SHOOTING_RESOLOTION = "ShootingResolution";
  public static final long SHOOTING_RESOLOTION_DEFVALUE = 720L;
  public static final String SMART_CUT_PIC_COUNT = "SmartCutPicCount";
  public static final long SMART_CUT_PIC_COUNT_DEFVALUE = 10L;
  public static final String SMART_CUT_PIC_INTERVAL = "SmartCutPicSpacing";
  public static final long SMART_CUT_PIC_INTERVAL_DEFVALUE = 500L;
  public static final String SMART_CUT_PIC_MAX_BYTE = "SmartCutPicMaxByte";
  public static final long SMART_CUT_PIC_MAX_BYTE_DEFVALUE = 90000L;
  public static final String SMART_CUT_PIC_QUALITY_AND = "SmartCutPicQuality_And";
  public static final long SMART_CUT_PIC_QUALITY_AND_DEFVALUE = 80L;
  public static final String SMART_CUT_PIC_WIDTH = "SmartCutPicWidth";
  public static final long SMART_CUT_PIC_WIDTH_DEFVALUE = 224L;
  public static final String SMART_MATCH_MUSIC_SWITCH = "SmartMatchMusicSwitch";
  public static final long SMART_MATCH_MUSIC_SWITCH_DEFVALUE = 0L;
  public static final String STICKY_NOTE_PUBLISH_ENTRANCE_CONFIG = "sticky_note_publish_entrance_config";
  public static final String SUBSCRIBE_ACCOUNT_NEW_FOLLOW_LIST_SWITCH = "newfollowlist";
  public static final String SUBSCRIBE_ACCOUNT_NEW_FOLLOW_LIST_SWITCH_DEFVALUE = "1";
  public static final String SUBSCRIBE_ACCOUNT_NEW_FOLLOW_LIST_SWITCH_OPEN = "1";
  public static final String SUBSCRIBE_ACCOUNT_PUBLISH_ENTRANCE_SWITCH = "subscribe_publish_entrance_enable";
  public static final String SUBSCRIBE_ACCOUNT_PUBLISH_ENTRANCE_SWITCH_DEFVALUE = "1";
  public static final String SUBSCRIBE_ACCOUNT_PUBLISH_ENTRANCE_SWITCH_OPEN = "1";
  public static final String SUBSCRIBE_ACCOUNT_TITLE = "subscribe_account_title";
  public static final String SUBSCRIBE_ACCOUNT_TITLE_DEFVALUE = amtj.a(2131715881);
  private static final String TAG = "Q.videostory.config.VSConfigManager";
  public static final String VS_HEALTH_IS_REDIRECT_AIO_TO_MAIN_PAGE = "is_redirect_aio_to_main_page";
  public static final String VS_HEALTH_MAIN_PAGE_JUMP_URL = "main_page_jump_url";
  public static final String VS_HEALTH_MAIN_PAGE_JUMP_URL_DEFVALUE = "https://web.yundong.qq.com/pushsport/index?_wv=18950115&asyncMode=1&crashFrom=40501&_wwv=265&ls=1&spec=1&ADTAG=gzh.menu_page.main";
  private static VSConfigManager instance;
  private ConcurrentHashMap<String, Object> mConfigMap = new ConcurrentHashMap();
  protected SharedPreferences mSharedPreferences;
  
  private VSConfigManager()
  {
    init();
  }
  
  private String getCurrentAccount()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public static VSConfigManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new VSConfigManager();
      }
      return instance;
    }
    finally {}
  }
  
  private <V> V getValueFromSP(@NonNull String paramString, @NonNull V paramV)
  {
    Object localObject;
    if (paramV.getClass() == Integer.class) {
      localObject = Integer.valueOf(this.mSharedPreferences.getInt(paramString, ((Integer)paramV).intValue()));
    }
    for (;;)
    {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "get value from sp success : K:" + paramString + ", V : " + localObject);
      if ((localObject == null) || (localObject.getClass() != paramV.getClass())) {
        return paramV;
      }
      this.mConfigMap.put(paramString, localObject);
      return localObject;
      if (paramV.getClass() == Long.class)
      {
        localObject = Long.valueOf(this.mSharedPreferences.getLong(paramString, ((Long)paramV).longValue()));
      }
      else if (paramV.getClass() == String.class)
      {
        localObject = this.mSharedPreferences.getString(paramString, (String)paramV);
      }
      else
      {
        if (paramV.getClass() != Boolean.class) {
          break;
        }
        localObject = Boolean.valueOf(this.mSharedPreferences.getBoolean(paramString, ((Boolean)paramV).booleanValue()));
      }
    }
    throw new IllegalArgumentException("defValue class is not support : " + paramV.getClass());
    return paramV;
  }
  
  private void init()
  {
    this.mSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("videostory_config", 4);
    ThreadManager.executeOnSubThread(new VSConfigManager.1(this));
  }
  
  private <V> void setValueIntoSP(String paramString, V paramV)
  {
    boolean bool;
    if (paramV.getClass() == Integer.class) {
      bool = this.mSharedPreferences.edit().putInt(paramString, ((Integer)paramV).intValue()).commit();
    }
    while (!bool)
    {
      QLog.e("Q.videostory.config.VSConfigManager", 2, "set value into sp error : K:" + paramString + ", V : " + paramV);
      return;
      if (paramV.getClass() == Long.class) {
        bool = this.mSharedPreferences.edit().putLong(paramString, ((Long)paramV).longValue()).commit();
      } else if (paramV.getClass() == String.class) {
        bool = this.mSharedPreferences.edit().putString(paramString, (String)paramV).commit();
      } else if (paramV.getClass() == Boolean.class) {
        bool = this.mSharedPreferences.edit().putBoolean(paramString, ((Boolean)paramV).booleanValue()).commit();
      } else {
        throw new IllegalArgumentException("value class is not support : " + paramV.getClass());
      }
    }
    QLog.i("Q.videostory.config.VSConfigManager", 2, "set value into sp success : K:" + paramString + ", V : " + paramV);
  }
  
  private void updateOnlineStoryConfig(List<CONFIG.StIntConf> paramList)
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
            setValue(str, Long.valueOf(localStIntConf.value.get()));
          }
        }
        i += 1;
      }
    }
  }
  
  public void getStoryConfigOnline()
  {
    VSNetworkHelper.getInstance().sendRequest(new GetStoryConfigRequest(), new VSConfigManager.2(this));
  }
  
  public <V> V getValue(@NonNull String paramString, @NonNull V paramV)
  {
    Object localObject = paramString + "_" + getCurrentAccount();
    if (!this.mConfigMap.containsKey(localObject))
    {
      localObject = getValueFromSP((String)localObject, paramV);
      return localObject;
    }
    if (paramV.getClass() == Integer.class) {
      paramString = (Integer)this.mConfigMap.get(localObject);
    }
    for (;;)
    {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "get value : K : " + (String)localObject + ", V : " + paramString);
      if (paramString != null)
      {
        localObject = paramString;
        if (paramString.getClass() == paramV.getClass()) {
          break;
        }
      }
      return paramV;
      if (paramV.getClass() == Long.class)
      {
        paramString = (Long)this.mConfigMap.get(localObject);
      }
      else if (paramV.getClass() == String.class)
      {
        paramString = (String)this.mConfigMap.get(localObject);
      }
      else
      {
        if (paramV.getClass() != Boolean.class) {
          break label210;
        }
        paramString = (Boolean)this.mConfigMap.get(localObject);
      }
    }
    label210:
    throw new IllegalArgumentException("defValue class is not support : " + paramV.getClass());
  }
  
  public boolean isApplyStyleConfig()
  {
    boolean bool = ((Boolean)getInstance().getValue("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(false))).booleanValue();
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "isApplyStyleConfig:" + bool);
    return bool;
  }
  
  public boolean isApplyWidgetConfig()
  {
    boolean bool = ((Boolean)getInstance().getValue("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(false))).booleanValue();
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "isApplyWidgetConfig:" + bool);
    return bool;
  }
  
  public boolean isCqBitrateModeEnable()
  {
    return (((Boolean)getInstance().getValue("KEY_BOOLEAN_ENABLE_CQ_MODE", Boolean.valueOf(true))).booleanValue()) && (Build.VERSION.SDK_INT < 27);
  }
  
  public boolean isNeedHighProfile()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return false;
    }
    return ((Boolean)getInstance().getValue("KEY_NEED_HIGH_PROFILE", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean isSubscribeEntranceOpen()
  {
    return ((String)getInstance().getValue("subscribe_entrance_enable", "1")).equals("1");
  }
  
  public boolean needShowGuideTips(String paramString)
  {
    boolean bool2 = ((Boolean)getInstance().getValue(paramString, Boolean.valueOf(true))).booleanValue();
    if (LocalMultiProcConfig.getLong4Uin("need_show_story_tips", 0L, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) == 1L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1 & bool2;
      QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "needShowGuideTips:" + bool2);
      return bool2;
    }
  }
  
  public void onDestroy()
  {
    QLog.i("Q.videostory.config.VSConfigManager", 2, "onDestory");
  }
  
  public void resetApplyWidgetConfig()
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "resetApplyWidgetConfig");
    getInstance().setValue("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(false));
  }
  
  public <V> void setValue(String paramString, V paramV)
  {
    paramString = paramString + "_" + getCurrentAccount();
    if (paramV.getClass() == Integer.class) {
      this.mConfigMap.put(paramString, (Integer)paramV);
    }
    for (;;)
    {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "set value into map success :  K:" + paramString + ", V : " + paramV);
      bmbx.b("Q.videostory.config.VSConfigManager", "set value into map success :  K:" + paramString + ", V : " + paramV);
      setValueIntoSP(paramString, paramV);
      return;
      if (paramV.getClass() == Long.class)
      {
        this.mConfigMap.put(paramString, (Long)paramV);
      }
      else if (paramV.getClass() == String.class)
      {
        this.mConfigMap.put(paramString, (String)paramV);
      }
      else
      {
        if (paramV.getClass() != Boolean.class) {
          break;
        }
        this.mConfigMap.put(paramString, (Boolean)paramV);
      }
    }
    QLog.e("Q.videostory.config.VSConfigManager", 2, "set value into map error : K:" + paramString + ", V : " + paramV);
    throw new IllegalArgumentException("value class is not support : " + paramV.getClass());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager
 * JD-Core Version:    0.7.0.1
 */