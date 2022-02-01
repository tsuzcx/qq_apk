package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ApolloDrawerContext
{
  private ApolloDrawerStrategy a;
  
  private boolean b(ApolloDrawerStrategy paramApolloDrawerStrategy)
  {
    if (this.a == null) {
      return true;
    }
    return paramApolloDrawerStrategy.a <= this.a.a;
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    ApolloDrawerStrategy localApolloDrawerStrategy = this.a;
    if (localApolloDrawerStrategy != null) {
      return localApolloDrawerStrategy.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
    }
    return -1;
  }
  
  public void a()
  {
    ApolloDrawerStrategy localApolloDrawerStrategy = this.a;
    if (localApolloDrawerStrategy != null)
    {
      localApolloDrawerStrategy.b();
      this.a.a = 9999;
    }
  }
  
  public void a(ApolloDrawerStrategy paramApolloDrawerStrategy)
  {
    if ((paramApolloDrawerStrategy != null) && (b(paramApolloDrawerStrategy)) && (paramApolloDrawerStrategy.a()))
    {
      this.a = paramApolloDrawerStrategy;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set status success class=");
        localStringBuilder.append(paramApolloDrawerStrategy.getClass().getSimpleName());
        QLog.d("[cmshow]ApolloDrawerContext", 2, localStringBuilder.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramApolloDrawerStrategy = new StringBuilder();
      paramApolloDrawerStrategy.append("set status fail class=");
      paramApolloDrawerStrategy.append(null);
      QLog.d("[cmshow]ApolloDrawerContext", 2, paramApolloDrawerStrategy.toString());
    }
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    ApolloDrawerStrategy localApolloDrawerStrategy = this.a;
    if (localApolloDrawerStrategy != null) {
      localApolloDrawerStrategy.a(paramSpriteDrawerInfoManager, paramContext, paramQQAppInterface);
    }
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    ApolloDrawerStrategy localApolloDrawerStrategy = this.a;
    if (localApolloDrawerStrategy != null) {
      localApolloDrawerStrategy.a(paramSpriteDrawerInfoManager, paramContext, paramQQAppInterface, paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SpriteDrawerInfoManager paramSpriteDrawerInfoManager)
  {
    ApolloDrawerStrategy localApolloDrawerStrategy = this.a;
    if (localApolloDrawerStrategy != null)
    {
      localApolloDrawerStrategy.a(paramQQAppInterface, paramSpriteDrawerInfoManager);
      this.a.a = 9999;
    }
  }
  
  public ApolloDrawerStrategy b()
  {
    return this.a;
  }
  
  public void b(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    ApolloDrawerStrategy localApolloDrawerStrategy = this.a;
    if (localApolloDrawerStrategy != null) {
      localApolloDrawerStrategy.b(paramSpriteDrawerInfoManager, paramContext, paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext
 * JD-Core Version:    0.7.0.1
 */