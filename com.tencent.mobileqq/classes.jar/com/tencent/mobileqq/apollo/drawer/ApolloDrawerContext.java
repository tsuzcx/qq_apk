package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ApolloDrawerContext
{
  private ApolloDrawerStatus a;
  
  private boolean a(ApolloDrawerStatus paramApolloDrawerStatus)
  {
    if (this.a == null) {}
    while (paramApolloDrawerStatus.a <= this.a.a) {
      return true;
    }
    return false;
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (this.a != null) {
      return this.a.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
    }
    return -1;
  }
  
  public ApolloDrawerStatus a()
  {
    return this.a;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.a();
      this.a.a = 9999;
    }
  }
  
  public void a(ApolloDrawerStatus paramApolloDrawerStatus)
  {
    if ((paramApolloDrawerStatus != null) && (a(paramApolloDrawerStatus)) && (paramApolloDrawerStatus.a()))
    {
      this.a = paramApolloDrawerStatus;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDrawerContext", 2, "set status success class=" + paramApolloDrawerStatus.getClass().getSimpleName());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloDrawerContext", 2, "set status fail class=" + null);
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.a(paramSpriteDrawerInfoManager, paramContext, paramQQAppInterface);
    }
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramSpriteDrawerInfoManager, paramContext, paramQQAppInterface, paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SpriteDrawerInfoManager paramSpriteDrawerInfoManager)
  {
    if (this.a != null)
    {
      this.a.a(paramQQAppInterface, paramSpriteDrawerInfoManager);
      this.a.a = 9999;
    }
  }
  
  public void b(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.b(paramSpriteDrawerInfoManager, paramContext, paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext
 * JD-Core Version:    0.7.0.1
 */