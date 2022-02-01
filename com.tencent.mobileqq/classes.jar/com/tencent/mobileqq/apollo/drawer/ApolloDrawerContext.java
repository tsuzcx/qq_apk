package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ApolloDrawerContext
{
  private ApolloDrawerStatus a;
  
  private boolean a(ApolloDrawerStatus paramApolloDrawerStatus)
  {
    if (this.a == null) {
      return true;
    }
    return paramApolloDrawerStatus.a <= this.a.a;
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    ApolloDrawerStatus localApolloDrawerStatus = this.a;
    if (localApolloDrawerStatus != null) {
      return localApolloDrawerStatus.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
    }
    return -1;
  }
  
  public ApolloDrawerStatus a()
  {
    return this.a;
  }
  
  public void a()
  {
    ApolloDrawerStatus localApolloDrawerStatus = this.a;
    if (localApolloDrawerStatus != null)
    {
      localApolloDrawerStatus.a();
      this.a.a = 9999;
    }
  }
  
  public void a(ApolloDrawerStatus paramApolloDrawerStatus)
  {
    if ((paramApolloDrawerStatus != null) && (a(paramApolloDrawerStatus)) && (paramApolloDrawerStatus.a()))
    {
      this.a = paramApolloDrawerStatus;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set status success class=");
        localStringBuilder.append(paramApolloDrawerStatus.getClass().getSimpleName());
        QLog.d("[cmshow]ApolloDrawerContext", 2, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramApolloDrawerStatus = new StringBuilder();
      paramApolloDrawerStatus.append("set status fail class=");
      paramApolloDrawerStatus.append(null);
      QLog.d("[cmshow]ApolloDrawerContext", 2, paramApolloDrawerStatus.toString());
    }
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    ApolloDrawerStatus localApolloDrawerStatus = this.a;
    if (localApolloDrawerStatus != null) {
      localApolloDrawerStatus.a(paramSpriteDrawerInfoManager, paramContext, paramQQAppInterface);
    }
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    ApolloDrawerStatus localApolloDrawerStatus = this.a;
    if (localApolloDrawerStatus != null) {
      localApolloDrawerStatus.a(paramSpriteDrawerInfoManager, paramContext, paramQQAppInterface, paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SpriteDrawerInfoManager paramSpriteDrawerInfoManager)
  {
    ApolloDrawerStatus localApolloDrawerStatus = this.a;
    if (localApolloDrawerStatus != null)
    {
      localApolloDrawerStatus.a(paramQQAppInterface, paramSpriteDrawerInfoManager);
      this.a.a = 9999;
    }
  }
  
  public void b(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    ApolloDrawerStatus localApolloDrawerStatus = this.a;
    if (localApolloDrawerStatus != null) {
      localApolloDrawerStatus.b(paramSpriteDrawerInfoManager, paramContext, paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext
 * JD-Core Version:    0.7.0.1
 */