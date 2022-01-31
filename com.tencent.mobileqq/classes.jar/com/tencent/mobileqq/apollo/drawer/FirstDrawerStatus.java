package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class FirstDrawerStatus
  extends ApolloDrawerStatus
{
  public FirstDrawerStatus(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      this.b = true;
      localSharedPreferences = paramContext.getSharedPreferences("apollo_sp", 0);
    } while (!localSharedPreferences.getBoolean(paramQQAppInterface.getAccount() + "apollo_settingme_first_enter", true));
    SpriteUtil.a(paramSpriteDrawerInfoManager, "欢迎加入厘米秀", 7);
    localSharedPreferences.edit().putBoolean(paramQQAppInterface.getAccount() + "apollo_settingme_first_enter", false).commit();
    a(paramContext, paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.FirstDrawerStatus
 * JD-Core Version:    0.7.0.1
 */