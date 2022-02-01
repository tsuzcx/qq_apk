package com.tencent.biz.thridappshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;

public class ThridAppShareHelper
{
  protected static ThridAppShareHelper a;
  protected SessionInfo a;
  protected HashMap<String, ThridAppShareHelper.ThirdAppInfo> a;
  
  public ThridAppShareHelper()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static ThridAppShareHelper a()
  {
    if (jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper == null) {
      jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper = new ThridAppShareHelper();
    }
    return jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_app", paramString2, 0, 0, paramString1, paramString3, paramString4, paramString5);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
  }
  
  public boolean a(Intent paramIntent, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if (!"thridapp".equals(paramIntent.getStringExtra("share_from"))) {
      return false;
    }
    paramIntent.removeExtra("share_from");
    Object localObject = a();
    Long localLong = Long.valueOf(paramIntent.getLongExtra("req_share_id", 0L));
    if (!((ThridAppShareHelper)localObject).a(String.valueOf(localLong))) {
      return true;
    }
    paramIntent.putExtra("share_from_aio", true);
    paramIntent.putExtra("forward_type", 11);
    paramIntent.putExtra("req_type", 1);
    if (!paramIntent.hasExtra("pkg_name")) {
      paramIntent.putExtra("pkg_name", "");
    }
    paramIntent.putExtra("refuse_show_share_result_dialog", true);
    localObject = ((ThridAppShareHelper)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localObject != null)
    {
      paramIntent = ForwardOptionBuilder.a(paramIntent, paramQQAppInterface, paramActivity);
      paramActivity = new Bundle();
      paramActivity.putString("uin", ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
      paramActivity.putInt("uintype", ((SessionInfo)localObject).jdField_a_of_type_Int);
      paramActivity.putString("troop_uin", ((SessionInfo)localObject).b);
      paramActivity.putString("uinname", ((SessionInfo)localObject).d);
      paramIntent.a(ForwardAbility.ForwardAbilityType.a.intValue(), paramActivity);
      a(String.valueOf(localLong), "app_share_view", "", "", "");
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.thridappshare.ThridAppShareHelper
 * JD-Core Version:    0.7.0.1
 */