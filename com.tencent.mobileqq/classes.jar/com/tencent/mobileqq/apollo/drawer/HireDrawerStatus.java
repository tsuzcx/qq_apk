package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
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
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_sp");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    paramQQAppInterface = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    this.jdField_a_of_type_Int = paramQQAppInterface.getInt("hire_priority", 1);
    this.jdField_b_of_type_Int = paramQQAppInterface.getInt("hire_action", 0);
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getString("hire_word", "");
    this.jdField_a_of_type_Long = paramQQAppInterface.getLong("hire_for", 0L);
    this.jdField_b_of_type_Long = paramQQAppInterface.getLong("hire_end", 0L);
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if ((NetConnInfoCenter.getServerTime() <= this.jdField_b_of_type_Long) && (!this.d) && (this.c))
    {
      int i = this.jdField_b_of_type_Int;
      if (i > 0)
      {
        if (CMResUtil.d(5, i))
        {
          paramContext = new ApolloActionData();
          paramContext.actionId = this.jdField_b_of_type_Int;
          paramContext.actionType = 0;
          SpriteUtil.a(paramSpriteDrawerInfoManager, 6, paramContext);
          this.d = true;
          paramSpriteDrawerInfoManager = paramAppInterface.getApp();
          paramContext = new StringBuilder();
          paramContext.append("apollo_sp");
          paramContext.append(paramAppInterface.getCurrentAccountUin());
          paramSpriteDrawerInfoManager.getSharedPreferences(paramContext.toString(), 0).edit().putLong("hire_end", NetConnInfoCenter.getServerTime()).commit();
          return 0;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("HireDrawerStatus resource is not ready, actionId:");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        QLog.w("[cmshow]AplloDrawerStatus", 2, localStringBuilder.toString());
        super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
        paramSpriteDrawerInfoManager = (IApolloResDownloader)QRoute.api(IApolloResDownloader.class);
        paramContext = new StringBuilder();
        paramContext.append(CMGetResPathUtil.d(this.jdField_b_of_type_Int));
        paramContext.append("/d.zip");
        paramSpriteDrawerInfoManager.downLoadSpecialAction(paramAppInterface, paramContext.toString(), CMResUtil.b(this.jdField_b_of_type_Int));
        return 0;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HireDrawerStatus action is not correct, actionId:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.w("[cmshow]AplloDrawerStatus", 2, localStringBuilder.toString());
      super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
      paramSpriteDrawerInfoManager = paramAppInterface.getApp();
      paramContext = new StringBuilder();
      paramContext.append("apollo_sp");
      paramContext.append(paramAppInterface.getCurrentAccountUin());
      paramSpriteDrawerInfoManager.getSharedPreferences(paramContext.toString(), 0).edit().putLong("hire_end", NetConnInfoCenter.getServerTime()).commit();
      return 0;
    }
    return super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramSpriteDrawerInfoManager = new Intent();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&tab=interactive&suin=");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramSpriteDrawerInfoManager.putExtra("extra_key_url_append", localStringBuilder.toString());
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramContext, paramSpriteDrawerInfoManager, "drawer", ApolloConstant.A, null);
    a(paramQQAppInterface);
    VipUtils.a(null, "cmshow", "Apollo", "0X80065F002", 0, 0, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!a()) {
      return;
    }
    paramContext = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_sp");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    boolean bool = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("hire_bubble_click", false);
    if (NetConnInfoCenter.getServerTime() <= this.jdField_b_of_type_Long)
    {
      if (bool) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      SpriteUtil.a(paramSpriteDrawerInfoManager, this.jdField_a_of_type_JavaLangString, 7, 0);
      VipUtils.a(null, "cmshow", "Apollo", "0X80065F001", 0, 0, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_sp");
    localStringBuilder.append(paramQQAppInterface.getCurrentUin());
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("hire_bubble_click", true).commit();
  }
  
  public boolean a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.HireDrawerStatus
 * JD-Core Version:    0.7.0.1
 */