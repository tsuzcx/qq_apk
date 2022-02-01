package com.tencent.ilive.base.page;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.ilive.base.page.config.ActivityConfig;
import com.tencent.ilive.base.page.config.FragmentConfig;
import com.tencent.ilive.base.page.fragment.LiveFragment;
import java.util.Map;

public class PageFactory
{
  private static final String TAG = "PageFactory";
  private static ActivityConfig sActivityConfig = new ActivityConfig();
  private static FragmentConfig sFragmentConfig = new FragmentConfig();
  
  public static void addFragmentConfig(FragmentConfig paramFragmentConfig)
  {
    sFragmentConfig.merge(paramFragmentConfig);
  }
  
  public static LiveFragment createFragment(int paramInt, PageFactory.FragmentActionCallback paramFragmentActionCallback)
  {
    if (!getFragmentConfig().get().containsKey(Integer.valueOf(paramInt)))
    {
      Log.d("PageFactory", "createFragment failed, page is not exist!");
      return null;
    }
    try
    {
      LiveFragment localLiveFragment1 = (LiveFragment)((Class)getFragmentConfig().get().get(Integer.valueOf(paramInt))).newInstance();
      if (localLiveFragment1 == null)
      {
        Log.d("PageFactory", "fragment newInstance failed!");
        return null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
        Object localObject = null;
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      LiveFragment localLiveFragment2;
      for (;;)
      {
        localInstantiationException.printStackTrace();
        localLiveFragment2 = null;
      }
      localLiveFragment2.init(paramInt, new PageFactory.1(paramFragmentActionCallback));
      return localLiveFragment2;
    }
  }
  
  public static ActivityConfig getActivityConfig()
  {
    return sActivityConfig;
  }
  
  public static FragmentConfig getFragmentConfig()
  {
    return sFragmentConfig;
  }
  
  public static void initPageConfig(ActivityConfig paramActivityConfig, FragmentConfig paramFragmentConfig)
  {
    sActivityConfig.merge(paramActivityConfig);
    sFragmentConfig.merge(paramFragmentConfig);
  }
  
  public static void startActivity(Intent paramIntent, Context paramContext, int paramInt)
  {
    if ((paramContext == null) || (!getActivityConfig().contains(paramInt))) {
      throw new RuntimeException("has not activity to start!");
    }
    paramIntent.setClass(paramContext, (Class)getActivityConfig().get().get(Integer.valueOf(paramInt)));
    paramContext.startActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.page.PageFactory
 * JD-Core Version:    0.7.0.1
 */