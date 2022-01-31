package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class FirstGameDrawerStatus
  extends ApolloDrawerStatus
{
  long a;
  
  public FirstGameDrawerStatus(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    ApolloUtil.a(paramContext);
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_gamebox_NewGuideClick", 0, 0, new String[0]);
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_gamebox_NewGuideShow", 0, 0, new String[0]);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SpriteDrawerInfoManager paramSpriteDrawerInfoManager)
  {
    super.a(paramQQAppInterface, paramSpriteDrawerInfoManager);
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_Long == 0L)) {}
    while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L) {
      return;
    }
    paramQQAppInterface.getApp().getApplicationContext().getSharedPreferences("apollo_sp", 0).edit().putBoolean(paramQQAppInterface.getAccount() + "apollo_game_box_settingme_first_enter", false).commit();
    a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
  }
  
  public boolean a()
  {
    return (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.FirstGameDrawerStatus
 * JD-Core Version:    0.7.0.1
 */