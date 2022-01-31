package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GameBoxDrawerStatus
  extends ApolloDrawerStatus
{
  public static String a;
  long jdField_a_of_type_Long;
  DrawerPushItem jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  int b;
  int c = 7;
  
  public GameBoxDrawerStatus(QQAppInterface paramQQAppInterface, DrawerPushItem paramDrawerPushItem)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramDrawerPushItem.priority;
    PushDrawerStatus.jdField_a_of_type_JavaLangString = paramDrawerPushItem.content;
    this.b = paramDrawerPushItem.action_id;
    PushDrawerStatus.b = paramDrawerPushItem.ext_url;
    jdField_a_of_type_JavaLangString = paramDrawerPushItem.msg_id;
    if (paramDrawerPushItem.bubble_res_id == 32) {
      this.c = 7;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem = paramDrawerPushItem;
      return;
      if (paramDrawerPushItem.bubble_res_id == 33) {
        this.c = 6;
      }
    }
  }
  
  public DrawerPushItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AplloDrawerStatus", 2, "GameBoxDrawerStatus onBubbleClick");
    }
    paramSpriteDrawerInfoManager = (ApolloManager)paramQQAppInterface.getManager(152);
    if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot != 1) {
      paramSpriteDrawerInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
    }
    this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts;
    String str;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.scheme))
    {
      paramSpriteDrawerInfoManager = new Intent();
      str = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.scheme.trim();
      if (str.equals("mall")) {
        ApolloUtil.a(paramContext, null, "drawer", ApolloConstant.X, null);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot == 1) {
        ((RedTouchManager)paramQQAppInterface.getManager(35)).b("103100.103200.103240.103247");
      }
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_gamebox_RedDotClick", 0, 0, new String[] { jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.act_id });
      return;
      if (str.equals("interact"))
      {
        paramSpriteDrawerInfoManager.putExtra("extra_key_url_append", "&tab=interactive&suin=" + paramQQAppInterface.getCurrentAccountUin());
        ApolloUtil.a(paramContext, paramSpriteDrawerInfoManager, "drawer", ApolloConstant.Y, null);
      }
      else if (str.equals("game_city"))
      {
        ApolloUtil.a(paramContext, null, "drawer", ApolloConstant.ac, null);
        continue;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.ext_url))
        {
          paramSpriteDrawerInfoManager = new Intent(paramContext, QQBrowserActivity.class);
          paramSpriteDrawerInfoManager.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.ext_url);
          paramSpriteDrawerInfoManager.putExtra("startOpenPageTime", System.currentTimeMillis());
          paramContext.startActivity(paramSpriteDrawerInfoManager);
        }
      }
    }
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (a()) {
      if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot != 0) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      PushDrawerStatus.c = bool;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_gamebox_RedDotShow", 0, 0, new String[] { jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.act_id });
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SpriteDrawerInfoManager paramSpriteDrawerInfoManager)
  {
    super.a(paramQQAppInterface, paramSpriteDrawerInfoManager);
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_Long == 0L)) {}
    do
    {
      return;
      PushDrawerStatus.c = false;
    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L);
    a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
    paramSpriteDrawerInfoManager = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
    paramSpriteDrawerInfoManager.show_sum += 1;
    paramQQAppInterface = (ApolloManager)paramQQAppInterface.getManager(152);
    if ((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot != 1))
    {
      paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      return;
    }
    paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null)) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts)
    {
      PushDrawerStatus.c = false;
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.GameBoxDrawerStatus
 * JD-Core Version:    0.7.0.1
 */