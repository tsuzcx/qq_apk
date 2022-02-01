package com.tencent.mobileqq.apollo.aio;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.bubble.ApolloAioBubblePush;
import com.tencent.mobileqq.apollo.bubble.ApolloBubbleLogic;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.apollo.listener.ApolloStatusUpdateListener;
import com.tencent.mobileqq.apollo.model.App3DConfig;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;

public class BubbleProducer
  implements ApolloStatusUpdateListener
{
  public boolean a;
  public boolean b;
  private final ApolloManagerServiceImpl c;
  private boolean d;
  private boolean e;
  private int f;
  private boolean g;
  private AppRuntime h;
  
  public BubbleProducer(ApolloManagerServiceImpl paramApolloManagerServiceImpl, AppRuntime paramAppRuntime)
  {
    this.c = paramApolloManagerServiceImpl;
    this.h = paramAppRuntime;
    c();
    boolean bool2 = false;
    Object localObject;
    if (paramAppRuntime != null)
    {
      localObject = paramAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_sp");
      localStringBuilder.append(paramAppRuntime.getCurrentUin());
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    }
    else
    {
      localObject = null;
    }
    if ((localObject != null) && (((SharedPreferences)localObject).getInt("key_panel_meet_3d_action", 0) == 1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.a = bool1;
    if ((localObject != null) && (((SharedPreferences)localObject).getInt("key_panel_shown_guide_for_action", 0) == 1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.d = bool1;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((SharedPreferences)localObject).getInt("key_panel_shown_guide_for_json", 0) == 1) {
        bool1 = true;
      }
    }
    this.e = bool1;
    paramApolloManagerServiceImpl.addApolloStatusUpdateListener(this);
    ApolloBubbleLogic.a(paramAppRuntime);
  }
  
  private void c()
  {
    this.b = this.c.is3dAvailable();
    this.f = this.c.getApolloUserStatus();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      c();
      return;
    }
    finally {}
  }
  
  public void a(Map<String, String> paramMap, int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        if (!App3DConfig.sShow)
        {
          QLog.d("[cmshow]ApolloManager", 1, new Object[] { "parseGuide3DBubbleAdv show: ", Boolean.valueOf(App3DConfig.sShow) });
          return;
        }
        try
        {
          AppRuntime localAppRuntime = this.h;
          localObject1 = localAppRuntime.getCurrentUin();
          if (localAppRuntime == null) {
            break label477;
          }
          Object localObject2 = localAppRuntime.getApp();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("apollo_sp");
          localStringBuilder.append((String)localObject1);
          localObject1 = ((BaseApplication)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
          if (localObject1 == null) {
            break label483;
          }
          i = ((SharedPreferences)localObject1).getInt("key_3d_bubble_ad_id", 0);
          QLog.d("[cmshow]ApolloManager", 1, new Object[] { "parseGuide3DBubbleAdv oldAdId=", Integer.valueOf(i), ", newAdId=", Integer.valueOf(paramInt) });
          if (paramInt == i) {
            return;
          }
          localObject2 = new DrawerPushItem();
          ((DrawerPushItem)localObject2).is_reddot = 0;
          ((DrawerPushItem)localObject2).msg_id = "aio_panel_bubble_guide3d_push";
          ((DrawerPushItem)localObject2).msg_type = 10;
          ((DrawerPushItem)localObject2).priority = 900;
          i = (int)Long.parseLong((String)paramMap.get("startTime")) / 1000;
          ((DrawerPushItem)localObject2).start_ts = i;
          ((DrawerPushItem)localObject2).end_ts = ((int)NetConnInfoCenter.getServerTime() + ((int)Long.parseLong((String)paramMap.get("endTime")) / 1000 - i));
          ((DrawerPushItem)localObject2).send_time = i;
          ((DrawerPushItem)localObject2).content = ((String)paramMap.get("bubbleText"));
          ((DrawerPushItem)localObject2).tianshuAdId = paramInt;
          ((DrawerPushItem)localObject2).tianshuTraceInfo = paramString;
          ((DrawerPushItem)localObject2).show_counts = Integer.parseInt((String)paramMap.get("showCount"));
          if (((DrawerPushItem)localObject2).show_counts == 0) {
            ((DrawerPushItem)localObject2).show_counts = 1;
          }
          ((ApolloDaoManagerServiceImpl)localAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all")).addPushItem((DrawerPushItem)localObject2);
          ((SharedPreferences)localObject1).edit().putInt("key_3d_bubble_ad_id", paramInt).commit();
          b(true);
          if ((this.g) && (localAppRuntime != null)) {
            ((ApolloGameManagerImpl)localAppRuntime.getRuntimeService(IApolloGameManager.class, "all")).mBubblePush.a(localAppRuntime);
          }
          paramInt = Integer.parseInt((String)paramMap.get("packageId"));
          QLog.d("[cmshow]ApolloManager", 1, new Object[] { "parseGuide3DBubbleAdv push bubble:", ((DrawerPushItem)localObject2).toString(), " ,packageId", Integer.valueOf(paramInt) });
        }
        catch (Exception paramMap)
        {
          QLog.e("[cmshow]ApolloManager", 1, "parseGuide3DBubbleAdv Exception:", paramMap);
        }
        return;
      }
      finally {}
      label477:
      Object localObject1 = null;
      continue;
      label483:
      int i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.d = paramBoolean;
      Object localObject3 = this.h;
      if (localObject3 != null)
      {
        Object localObject1 = ((AppRuntime)localObject3).getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo_sp");
        localStringBuilder.append(((AppRuntime)localObject3).getCurrentUin());
        localObject3 = localStringBuilder.toString();
        int i = 0;
        localObject1 = ((BaseApplication)localObject1).getSharedPreferences((String)localObject3, 0).edit();
        if (paramBoolean) {
          i = 1;
        }
        ((SharedPreferences.Editor)localObject1).putInt("key_panel_shown_guide_for_action", i).commit();
      }
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.e = paramBoolean;
      Object localObject3 = this.h;
      if (localObject3 != null)
      {
        Object localObject1 = ((AppRuntime)localObject3).getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo_sp");
        localStringBuilder.append(((AppRuntime)localObject3).getCurrentUin());
        localObject3 = localStringBuilder.toString();
        int i = 0;
        localObject1 = ((BaseApplication)localObject1).getSharedPreferences((String)localObject3, 0).edit();
        if (paramBoolean) {
          i = 1;
        }
        ((SharedPreferences.Editor)localObject1).putInt("key_panel_shown_guide_for_json", i).commit();
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    try
    {
      if (this.e)
      {
        bool = ApolloBubbleLogic.b;
        if (!bool)
        {
          bool = true;
          break label24;
        }
      }
      boolean bool = false;
      label24:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.BubbleProducer
 * JD-Core Version:    0.7.0.1
 */