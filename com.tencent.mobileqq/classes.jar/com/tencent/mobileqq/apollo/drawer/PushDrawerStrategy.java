package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.CmShowLauncher;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PushDrawerStrategy
  extends ApolloDrawerStrategy
{
  public static boolean e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public DrawerPushItem j;
  private int k;
  private long l;
  private int m = 7;
  
  public PushDrawerStrategy(QQAppInterface paramQQAppInterface, DrawerPushItem paramDrawerPushItem)
  {
    super(paramQQAppInterface);
    this.a = paramDrawerPushItem.priority;
    f = paramDrawerPushItem.content;
    this.k = paramDrawerPushItem.action_id;
    g = paramDrawerPushItem.ext_url;
    i = paramDrawerPushItem.msg_id;
    h = paramDrawerPushItem.tips_str;
    if (paramDrawerPushItem.bubble_res_id == 32) {
      this.m = 7;
    } else if (paramDrawerPushItem.bubble_res_id == 33) {
      this.m = 6;
    } else {
      this.m = 9;
    }
    this.j = paramDrawerPushItem;
    if (this.j.fromTianshu) {
      this.b = false;
    }
    if (!a())
    {
      e = false;
      this.c = false;
    }
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (!this.b)
    {
      Object localObject = this.j;
      if ((localObject != null) && (((DrawerPushItem)localObject).show_sum < this.j.show_counts))
      {
        int n;
        if (this.k > ApolloConstant.f) {
          n = 3;
        } else {
          n = 2;
        }
        localObject = ApolloResManagerFacade.a.a(Scene.DRAWER);
        IApolloResDownloader localIApolloResDownloader = ((IApolloResManager)localObject).a();
        boolean bool = ((IApolloResManager)localObject).f(5, this.k);
        if (this.k > 0)
        {
          if (bool)
          {
            paramAppInterface = new ApolloActionData();
            paramAppInterface.actionId = this.k;
            paramAppInterface.actionType = 0;
            SpriteUtil.a(paramSpriteDrawerInfoManager, 6, paramAppInterface);
            paramInt = 6;
            break label218;
          }
          super.a(paramSpriteDrawerInfoManager, n, paramInt, paramAppInterface, paramContext);
          paramSpriteDrawerInfoManager = new StringBuilder();
          paramSpriteDrawerInfoManager.append(((IApolloResManager)localObject).e(this.k));
          paramSpriteDrawerInfoManager.append("/d.zip");
          localIApolloResDownloader.a(paramAppInterface, paramSpriteDrawerInfoManager.toString(), ((IApolloResManager)localObject).f(this.k));
        }
        else
        {
          super.a(paramSpriteDrawerInfoManager, n, paramInt, paramAppInterface, paramContext);
        }
        paramInt = 0;
        label218:
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloDrawerStrategy", 2, new Object[] { "PushDrawerStatus onExecAction:", Integer.valueOf(this.k), ",rscType:", Integer.valueOf(paramInt), ",isRscDone:", Boolean.valueOf(bool) });
        }
        return 0;
      }
    }
    return super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, paramContext);
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!a()) {
      return;
    }
    boolean bool;
    if ((this.j.is_reddot != 0) && (!this.j.fromTianshu)) {
      bool = false;
    } else {
      bool = true;
    }
    e = bool;
    this.c = true;
    if (!TextUtils.isEmpty(f)) {
      SpriteUtil.a(paramSpriteDrawerInfoManager, f, this.m, this.j.bubble_res_id);
    }
    this.l = System.currentTimeMillis();
    paramSpriteDrawerInfoManager = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    QLog.d("[cmshow]ApolloDrawerStrategy", 1, new Object[] { "compass report, show, advId=", i });
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotShow", 0, 0, new String[] { i, String.valueOf(paramSpriteDrawerInfoManager.mIsNewStoreUser ^ true), this.j.act_id });
    if (!TextUtils.isEmpty(this.j.reddotPath))
    {
      QLog.d("[cmshow]ApolloDrawerStrategy", 1, new Object[] { "tianshu report, show, advId=", i, ", path=", this.j.reddotPath });
      paramSpriteDrawerInfoManager = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
      paramSpriteDrawerInfoManager.onRedTouchItemExposure(paramSpriteDrawerInfoManager.getAppInfoByPath(this.j.reddotPath), "");
      return;
    }
    if (this.j.tianshuAdId != 0) {
      ApolloTianshuReportUtil.a(101, String.valueOf(this.j.tianshuAdId), this.j.tianshuTraceInfo);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (this.j == null) {
        return;
      }
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      paramQQAppInterface = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      DrawerPushItem localDrawerPushItem = this.j;
      localDrawerPushItem.show_sum = localDrawerPushItem.show_counts;
      if ((this.j.is_reddot == 1) && (!this.j.fromTianshu))
      {
        localApolloManagerServiceImpl.updateDrawerItem(this.j);
        return;
      }
      paramQQAppInterface.removePushItem(this.j);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (this.j == null) {
        return;
      }
      a(paramQQAppInterface);
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (this.j.reddotGameId > 0) {
        QLog.e("[cmshow]ApolloDrawerStrategy", 1, "light game had been remove");
      } else {
        CmShowLauncher.a(paramQQAppInterface, paramContext, this.j.scheme, this.j.ext_url, "drawer");
      }
      QLog.d("[cmshow]ApolloDrawerStrategy", 1, new Object[] { "compass report, click, advId=", i });
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotClear", 0, 0, new String[] { i, String.valueOf(localApolloManagerServiceImpl.mIsNewStoreUser ^ true), this.j.act_id });
      paramContext = this.j;
      if (paramContext != null)
      {
        if (!TextUtils.isEmpty(paramContext.reddotPath))
        {
          QLog.d("[cmshow]ApolloDrawerStrategy", 1, new Object[] { "tianshu report, click, advId=", i, ", path=", this.j.reddotPath });
          ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(this.j.reddotPath);
          return;
        }
        if (this.j.tianshuAdId != 0) {
          ApolloTianshuReportUtil.a(102, String.valueOf(this.j.tianshuAdId), this.j.tianshuTraceInfo);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SpriteDrawerInfoManager paramSpriteDrawerInfoManager)
  {
    super.a(paramQQAppInterface, paramSpriteDrawerInfoManager);
    if (paramQQAppInterface != null)
    {
      if (this.l == 0L) {
        return;
      }
      e = false;
      if (System.currentTimeMillis() - this.l > 1000L)
      {
        a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
        paramSpriteDrawerInfoManager = this.j;
        paramSpriteDrawerInfoManager.show_sum += 1;
        paramSpriteDrawerInfoManager = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        paramQQAppInterface = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        if ((this.j.show_sum >= this.j.show_counts) && ((this.j.is_reddot != 1) || (this.j.fromTianshu)))
        {
          paramQQAppInterface.removePushItem(this.j);
          return;
        }
        paramSpriteDrawerInfoManager.updateDrawerItem(this.j);
      }
    }
  }
  
  public boolean a()
  {
    if (!this.b)
    {
      DrawerPushItem localDrawerPushItem = this.j;
      if ((localDrawerPushItem != null) && (localDrawerPushItem.show_sum < this.j.show_counts)) {
        return true;
      }
    }
    return false;
  }
  
  public void b(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.PushDrawerStrategy
 * JD-Core Version:    0.7.0.1
 */