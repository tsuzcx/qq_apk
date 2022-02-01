package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class HireDrawerStrategy
  extends ApolloDrawerStrategy
{
  private int e;
  private String f;
  private long g;
  private long h;
  private boolean i;
  
  public HireDrawerStrategy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_sp");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    paramQQAppInterface = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    this.a = paramQQAppInterface.getInt("hire_priority", 1);
    this.e = paramQQAppInterface.getInt("hire_action", 0);
    this.f = paramQQAppInterface.getString("hire_word", "");
    this.g = paramQQAppInterface.getLong("hire_for", 0L);
    this.h = paramQQAppInterface.getLong("hire_end", 0L);
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if ((NetConnInfoCenter.getServerTime() <= this.h) && (!this.i) && (this.d))
    {
      if (this.e > 0)
      {
        localObject = ApolloResManagerFacade.a.a(Scene.DRAWER);
        if (((IApolloResManager)localObject).f(5, this.e))
        {
          paramContext = new ApolloActionData();
          paramContext.actionId = this.e;
          paramContext.actionType = 0;
          SpriteUtil.a(paramSpriteDrawerInfoManager, 6, paramContext);
          this.i = true;
          paramSpriteDrawerInfoManager = paramAppInterface.getApp();
          paramContext = new StringBuilder();
          paramContext.append("apollo_sp");
          paramContext.append(paramAppInterface.getCurrentAccountUin());
          paramSpriteDrawerInfoManager.getSharedPreferences(paramContext.toString(), 0).edit().putLong("hire_end", NetConnInfoCenter.getServerTime()).commit();
          return 0;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("HireDrawerStatus resource is not ready, actionId:");
        localStringBuilder.append(this.e);
        QLog.w("[cmshow]HireDrawerStrategy", 2, localStringBuilder.toString());
        super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
        paramSpriteDrawerInfoManager = ((IApolloResManager)localObject).a();
        paramContext = new StringBuilder();
        paramContext.append(((IApolloResManager)localObject).e(this.e));
        paramContext.append("/d.zip");
        paramSpriteDrawerInfoManager.a(paramAppInterface, paramContext.toString(), ((IApolloResManager)localObject).f(this.e));
        return 0;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("HireDrawerStatus action is not correct, actionId:");
      ((StringBuilder)localObject).append(this.e);
      QLog.w("[cmshow]HireDrawerStrategy", 2, ((StringBuilder)localObject).toString());
      super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
      paramSpriteDrawerInfoManager = paramAppInterface.getApp();
      paramContext = new StringBuilder();
      paramContext.append("apollo_sp");
      paramContext.append(paramAppInterface.getCurrentAccountUin());
      paramSpriteDrawerInfoManager.getSharedPreferences(paramContext.toString(), 0).edit().putLong("hire_end", NetConnInfoCenter.getServerTime()).commit();
      return 0;
    }
    return super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramSpriteDrawerInfoManager = new Intent();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&tab=interactive&suin=");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramSpriteDrawerInfoManager.putExtra("extra_key_url_append", localStringBuilder.toString());
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramContext, paramSpriteDrawerInfoManager, "drawer", ApolloConstant.I, null);
    a(paramQQAppInterface);
    VipUtils.a(null, "cmshow", "Apollo", "0X80065F002", 0, 0, new String[] { String.valueOf(this.e) });
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!a()) {
      return;
    }
    paramContext = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_sp");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    boolean bool = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("hire_bubble_click", false);
    if (NetConnInfoCenter.getServerTime() <= this.h)
    {
      if (bool) {
        return;
      }
      this.c = true;
      SpriteUtil.a(paramSpriteDrawerInfoManager, this.f, 7, 0);
      VipUtils.a(null, "cmshow", "Apollo", "0X80065F001", 0, 0, new String[] { String.valueOf(this.e) });
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_sp");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("hire_bubble_click", true).commit();
  }
  
  public boolean a()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.HireDrawerStrategy
 * JD-Core Version:    0.7.0.1
 */