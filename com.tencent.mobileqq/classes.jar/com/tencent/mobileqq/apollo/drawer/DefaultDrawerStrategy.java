package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class DefaultDrawerStrategy
  extends ApolloDrawerStrategy
{
  public DefaultDrawerStrategy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = 0;
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get_user_apollo_info_drawer_dress_sp");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
    paramQQAppInterface = paramContext.getString("bubble", "");
    if (a())
    {
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        return;
      }
      this.c = true;
      SpriteUtil.a(paramSpriteDrawerInfoManager, paramQQAppInterface, 7, 0);
      paramContext.edit().remove("bubble").commit();
    }
  }
  
  public boolean a()
  {
    return (this.d) && (!this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.DefaultDrawerStrategy
 * JD-Core Version:    0.7.0.1
 */