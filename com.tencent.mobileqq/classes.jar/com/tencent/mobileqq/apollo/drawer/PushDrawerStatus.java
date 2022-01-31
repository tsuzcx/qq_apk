package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PushDrawerStatus
  extends ApolloDrawerStatus
{
  public static String a;
  public static String b;
  public static String c;
  public static boolean c;
  public static String d;
  long a;
  public DrawerPushItem a;
  int b;
  int c;
  
  public PushDrawerStatus(QQAppInterface paramQQAppInterface, DrawerPushItem paramDrawerPushItem)
  {
    super(paramQQAppInterface);
    this.jdField_c_of_type_Int = 7;
    this.jdField_a_of_type_Int = paramDrawerPushItem.priority;
    jdField_a_of_type_JavaLangString = paramDrawerPushItem.content;
    this.jdField_b_of_type_Int = paramDrawerPushItem.action_id;
    jdField_b_of_type_JavaLangString = paramDrawerPushItem.ext_url;
    d = paramDrawerPushItem.msg_id;
    jdField_c_of_type_JavaLangString = paramDrawerPushItem.tips_str;
    if (paramDrawerPushItem.bubble_res_id == 32) {
      this.jdField_c_of_type_Int = 7;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem = paramDrawerPushItem;
      return;
      if (paramDrawerPushItem.bubble_res_id == 33) {
        this.jdField_c_of_type_Int = 6;
      }
    }
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    int i = 0;
    if (((this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem != null) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts)) || (this.jdField_a_of_type_Boolean)) {
      i = super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
    }
    for (;;)
    {
      return i;
      boolean bool = ApolloUtil.a(ApolloUtil.b(this.jdField_b_of_type_Int));
      if (this.jdField_b_of_type_Int > 0) {
        if (bool)
        {
          paramAppInterface = new ApolloActionData();
          paramAppInterface.actionId = this.jdField_b_of_type_Int;
          paramAppInterface.actionType = 0;
          SpriteUtil.a(paramSpriteDrawerInfoManager, 6, paramAppInterface);
          paramInt = 6;
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("AplloDrawerStatus", 2, new Object[] { "PushDrawerStatus onExecAction:", Integer.valueOf(this.jdField_b_of_type_Int), ",rscType:", Integer.valueOf(paramInt), ",isRscDone:", Boolean.valueOf(bool) });
        return 0;
        super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
        ApolloResDownloader.a(paramAppInterface, ApolloUtil.b(this.jdField_b_of_type_Int) + "/d.zip", ApolloUtil.c(this.jdField_b_of_type_Int));
        paramInt = 0;
        continue;
        super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
        paramInt = 0;
      }
    }
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null)) {
      return;
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
      if (str.equals("mall"))
      {
        ApolloUtil.a(paramContext, null, "drawer", ApolloConstant.X, null);
        if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot == 1) {
          ((RedTouchManager)paramQQAppInterface.getManager(35)).b(String.valueOf("103100.103200"));
        }
        paramSpriteDrawerInfoManager = (ApolloManager)paramQQAppInterface.getManager(152);
        paramContext = d;
        if (!paramSpriteDrawerInfoManager.d) {
          break label335;
        }
      }
    }
    label335:
    for (int i = 0;; i = 1)
    {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotClear", 0, 0, new String[] { paramContext, String.valueOf(i), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.act_id });
      return;
      if (str.equals("interact"))
      {
        paramSpriteDrawerInfoManager.putExtra("extra_key_url_append", "&tab=interactive&suin=" + paramQQAppInterface.getCurrentAccountUin());
        ApolloUtil.a(paramContext, paramSpriteDrawerInfoManager, "drawer", ApolloConstant.Y, null);
        break;
      }
      if (!str.equals("game_city")) {
        break;
      }
      ApolloUtil.a(paramContext, null, "drawer", ApolloConstant.ac, null);
      break;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.ext_url)) {
        break;
      }
      paramSpriteDrawerInfoManager = new Intent(paramContext, QQBrowserActivity.class);
      paramSpriteDrawerInfoManager.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.ext_url);
      paramSpriteDrawerInfoManager.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramContext.startActivity(paramSpriteDrawerInfoManager);
      break;
    }
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts)
    {
      jdField_c_of_type_Boolean = false;
      return;
    }
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.is_reddot == 0)
    {
      bool = true;
      jdField_c_of_type_Boolean = bool;
      this.jdField_b_of_type_Boolean = true;
      SpriteUtil.a(paramSpriteDrawerInfoManager, jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramSpriteDrawerInfoManager = (ApolloManager)paramQQAppInterface.getManager(152);
      paramContext = d;
      if (!paramSpriteDrawerInfoManager.d) {
        break label149;
      }
    }
    label149:
    for (paramInt = 0;; paramInt = 1)
    {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "drawer_avatar_RedDotShow", 0, 0, new String[] { paramContext, String.valueOf(paramInt), this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.act_id });
      return;
      bool = false;
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SpriteDrawerInfoManager paramSpriteDrawerInfoManager)
  {
    super.a(paramQQAppInterface, paramSpriteDrawerInfoManager);
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_Long == 0L)) {}
    do
    {
      return;
      jdField_c_of_type_Boolean = false;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.PushDrawerStatus
 * JD-Core Version:    0.7.0.1
 */