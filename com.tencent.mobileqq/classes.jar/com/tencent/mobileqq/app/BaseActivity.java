package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.guild.api.IGuildContextApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

@Deprecated
public class BaseActivity
  extends QBaseActivity
{
  public static int CHAT_FRAGMENT_TYPE = 1;
  public static int GUILDCHAT_FRAGMENT_TYPE = 2;
  public static int GUILD_LIVE_CHAT_FRAGMENT_TYPE = 3;
  public static final String TAG = "qqBaseActivity";
  public static BaseActivity sTopActivity;
  public QQAppInterface app;
  private int chatFragmentType = CHAT_FRAGMENT_TYPE;
  private String className = getClass().getSimpleName();
  QBaseFragment.IFragmentAttachCallback mIFragmentAttachCallback;
  
  private ChatFragment getGuildChatFragmentByTagName(String paramString)
  {
    paramString = (ChatFragment)((IGuildContextApi)QRoute.api(IGuildContextApi.class)).getChildFragmentManager(this).findFragmentByTag(paramString);
    if (paramString == null) {
      QLog.e("qqBaseActivity", 1, "getChatFragment() return null!");
    }
    return paramString;
  }
  
  protected void beforeDoOnCreate()
  {
    super.beforeDoOnCreate();
    updateAppRuntime();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (sTopActivity == this) {
      sTopActivity = null;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    sTopActivity = this;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
  }
  
  public String getActivityName()
  {
    return this.className;
  }
  
  public AppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  @Nullable
  public ChatFragment getChatFragment()
  {
    Object localObject = ChatFragment.class.getName();
    int i = this.chatFragmentType;
    if (i == CHAT_FRAGMENT_TYPE)
    {
      localObject = ChatFragment.class.getName();
    }
    else
    {
      String str;
      if (i == GUILDCHAT_FRAGMENT_TYPE)
      {
        str = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildChatFragmentClassName();
        localObject = str;
        if ((this instanceof SplashActivity)) {
          return getGuildChatFragmentByTagName(str);
        }
      }
      else if (i == GUILD_LIVE_CHAT_FRAGMENT_TYPE)
      {
        str = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildLiveChannelChatFragmentClassName();
        localObject = str;
        if ((this instanceof SplashActivity)) {
          return getGuildChatFragmentByTagName(str);
        }
      }
    }
    localObject = (QBaseFragment)getSupportFragmentManager().findFragmentByTag((String)localObject);
    if (localObject != null) {
      return (ChatFragment)localObject;
    }
    return null;
  }
  
  public String getCurrentAccountUin()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if (localAppRuntime == null) {
      return "";
    }
    if ((localAppRuntime instanceof AppInterface)) {
      return ((AppInterface)localAppRuntime).getCurrentAccountUin();
    }
    return localAppRuntime.getAccount();
  }
  
  public String getPreProcess()
  {
    return null;
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299920);
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAccountChanged ");
      boolean bool;
      if (getAppRuntime() == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
    }
    updateAppRuntime();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void setChatFragmentType(int paramInt)
  {
    this.chatFragmentType = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setChatFragmentType type=");
    localStringBuilder.append(this.chatFragmentType);
    QLog.i("qqBaseActivity", 1, localStringBuilder.toString());
  }
  
  public void setFragmentAttachListener(QBaseFragment.IFragmentAttachCallback paramIFragmentAttachCallback)
  {
    this.mIFragmentAttachCallback = paramIFragmentAttachCallback;
  }
  
  public void updateAppRuntime()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAppRuntime, ");
      localStringBuilder.append(localAppRuntime);
      QLog.i("qqBaseActivity", 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity
 * JD-Core Version:    0.7.0.1
 */