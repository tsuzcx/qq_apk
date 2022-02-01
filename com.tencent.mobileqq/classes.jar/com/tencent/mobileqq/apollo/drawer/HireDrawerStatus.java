package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class HireDrawerStatus
  extends ApolloDrawerStatus
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  boolean d;
  
  public HireDrawerStatus(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp" + paramQQAppInterface.getCurrentUin(), 0);
    this.jdField_a_of_type_Int = paramQQAppInterface.getInt("hire_priority", 1);
    this.jdField_b_of_type_Int = paramQQAppInterface.getInt("hire_action", 0);
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getString("hire_word", "");
    this.jdField_a_of_type_Long = paramQQAppInterface.getLong("hire_for", 0L);
    this.jdField_b_of_type_Long = paramQQAppInterface.getLong("hire_end", 0L);
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if ((NetConnInfoCenter.getServerTime() > this.jdField_b_of_type_Long) || (this.d) || (!this.c)) {
      return super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
    }
    if (this.jdField_b_of_type_Int > 0) {
      if (ApolloUtilImpl.isSpecialActionResDone(5, this.jdField_b_of_type_Int))
      {
        paramContext = new ApolloActionData();
        paramContext.actionId = this.jdField_b_of_type_Int;
        paramContext.actionType = 0;
        SpriteUtil.a(paramSpriteDrawerInfoManager, 6, paramContext);
        this.d = true;
        paramAppInterface.getApp().getSharedPreferences("apollo_sp" + paramAppInterface.getCurrentAccountUin(), 0).edit().putLong("hire_end", NetConnInfoCenter.getServerTime()).commit();
      }
    }
    for (;;)
    {
      return 0;
      QLog.w("AplloDrawerStatus", 2, "HireDrawerStatus resource is not ready, actionId:" + this.jdField_b_of_type_Int);
      super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(paramAppInterface, ApolloUtilImpl.getApolloDrawerPath(this.jdField_b_of_type_Int) + "/d.zip", ApolloUtilImpl.getApolloDrawerUrl(this.jdField_b_of_type_Int));
      continue;
      QLog.w("AplloDrawerStatus", 2, "HireDrawerStatus action is not correct, actionId:" + this.jdField_b_of_type_Int);
      super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
      paramAppInterface.getApp().getSharedPreferences("apollo_sp" + paramAppInterface.getCurrentAccountUin(), 0).edit().putLong("hire_end", NetConnInfoCenter.getServerTime()).commit();
    }
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramSpriteDrawerInfoManager = new Intent();
    paramSpriteDrawerInfoManager.putExtra("extra_key_url_append", "&tab=interactive&suin=" + paramQQAppInterface.getCurrentAccountUin());
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramContext, paramSpriteDrawerInfoManager, "drawer", ApolloConstant.v, null);
    a(paramQQAppInterface);
    VipUtils.a(null, "cmshow", "Apollo", "0X80065F002", 0, 0, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!a()) {}
    boolean bool;
    do
    {
      return;
      bool = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("hire_bubble_click", false);
    } while ((NetConnInfoCenter.getServerTime() > this.jdField_b_of_type_Long) || (bool));
    this.jdField_b_of_type_Boolean = true;
    SpriteUtil.a(paramSpriteDrawerInfoManager, this.jdField_a_of_type_JavaLangString, 7, 0);
    VipUtils.a(null, "cmshow", "Apollo", "0X80065F001", 0, 0, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences("apollo_sp" + paramQQAppInterface.getCurrentUin(), 0).edit().putBoolean("hire_bubble_click", true).commit();
  }
  
  public boolean a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.HireDrawerStatus
 * JD-Core Version:    0.7.0.1
 */