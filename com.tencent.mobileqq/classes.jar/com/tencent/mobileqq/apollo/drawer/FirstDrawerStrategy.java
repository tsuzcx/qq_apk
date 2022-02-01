package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;

public class FirstDrawerStrategy
  extends ApolloDrawerStrategy
{
  public FirstDrawerStrategy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = 0;
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!a()) {
      return;
    }
    this.c = true;
    Object localObject = paramContext.getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface.getAccount());
    localStringBuilder.append("apollo_settingme_first_enter");
    if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true))
    {
      SpriteUtil.a(paramSpriteDrawerInfoManager, HardCodeUtil.a(2131902614), 7, 0);
      paramSpriteDrawerInfoManager = ((SharedPreferences)localObject).edit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramQQAppInterface.getAccount());
      ((StringBuilder)localObject).append("apollo_settingme_first_enter");
      paramSpriteDrawerInfoManager.putBoolean(((StringBuilder)localObject).toString(), false).commit();
      a(paramContext, paramQQAppInterface);
    }
  }
  
  public boolean a()
  {
    return (this.d) && (!this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.FirstDrawerStrategy
 * JD-Core Version:    0.7.0.1
 */