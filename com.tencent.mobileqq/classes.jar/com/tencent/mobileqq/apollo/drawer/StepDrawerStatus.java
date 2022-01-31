package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import org.json.JSONObject;

public class StepDrawerStatus
  extends ApolloDrawerStatus
{
  private ApolloStepInfo a;
  private boolean c;
  
  public StepDrawerStatus(QQAppInterface paramQQAppInterface, ApolloStepInfo paramApolloStepInfo)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = 99;
    this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo = paramApolloStepInfo;
  }
  
  private int a()
  {
    int i = -1;
    int j = i;
    if (ApolloConfigUtils.c != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int > 2000) {
        break label74;
      }
      i = ApolloConfigUtils.c.optJSONObject("rule").optInt("low");
    }
    for (;;)
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("QQSettingRedesign", 2, "step action paly acitonId =" + i);
        j = i;
      }
      return j;
      label74:
      if ((2000 < this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int < 20000)) {
        i = ApolloConfigUtils.c.optJSONObject("rule").optInt("nomal");
      } else if (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int >= 20000) {
        i = ApolloConfigUtils.c.optJSONObject("rule").optInt("high");
      }
    }
  }
  
  private int b()
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int <= 2000) {
      i = 0;
    }
    do
    {
      return i;
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int > 2000) && (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int <= 20000)) {
        return 1;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int <= 20000);
    return 2;
  }
  
  private String b()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int <= 2000) {
      str = "今天走了" + this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int + "步,加油啊";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_JavaLangString = str;
      return str;
      if ((2000 < this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int < 20000)) {
        str = "今天走了" + this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int + "步,不错呀";
      } else if (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int >= 20000) {
        str = "今天走了" + this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int + "步,要休息哦";
      }
    }
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Boolean) || (paramAppInterface == null)) {
      paramInt = super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
    }
    int j;
    do
    {
      return paramInt;
      j = a();
      boolean bool1 = ApolloUtil.a(ApolloUtil.b(j));
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("apollo_sp", 0);
      Calendar localCalendar = Calendar.getInstance();
      boolean bool2 = (paramAppInterface.getCurrentAccountUin() + localCalendar.get(6)).equals(localSharedPreferences.getString("sp_key_apollo_step_flag", ""));
      if ((!bool1) || (bool2) || (this.c) || (j == -1)) {
        break;
      }
      paramAppInterface = new ApolloActionData();
      paramAppInterface.actionId = j;
      paramAppInterface.actionType = 0;
      SpriteUtil.a(paramSpriteDrawerInfoManager, 6, paramAppInterface);
      paramInt = i;
    } while (!QLog.isColorLevel());
    QLog.d("QQSettingRedesign", 2, "apollo step play action=" + j);
    return 0;
    paramInt = super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
    ApolloResDownloader.a(paramAppInterface, ApolloUtil.b(j) + "/d.zip", ApolloUtil.c(j));
    return paramInt;
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.c) {
      paramSpriteDrawerInfoManager = "http://cmshow.qq.com/act/actTpl/html/home.html?app=tqbssm&type=1&_wv=1025";
    }
    for (;;)
    {
      VasWebviewUtil.openQQBrowserActivity(paramContext, paramSpriteDrawerInfoManager, -1L, new Intent(paramContext, QQBrowserActivity.class), false, -1);
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "clk_steps_bubble", b(), 0, new String[0]);
      return;
      if (ApolloConfigUtils.c != null)
      {
        String str = ApolloConfigUtils.c.optString("stepUrl");
        paramSpriteDrawerInfoManager = str;
        if (!TextUtils.isEmpty(str)) {}
      }
      else
      {
        paramSpriteDrawerInfoManager = "http://yundong.qq.com/rank/friends?_wv=2172899&asyncMode=1";
      }
    }
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    SharedPreferences localSharedPreferences;
    String str;
    boolean bool;
    do
    {
      return;
      localSharedPreferences = paramContext.getSharedPreferences("apollo_sp", 0);
      Calendar localCalendar = Calendar.getInstance();
      str = paramQQAppInterface.getCurrentAccountUin() + localCalendar.get(6);
      bool = str.equals(localSharedPreferences.getString("sp_key_apollo_step_flag", ""));
      paramInt = localCalendar.get(11);
    } while ((bool) || (paramInt < 17));
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_Int < 100000))
    {
      this.b = true;
      SpriteUtil.a(paramSpriteDrawerInfoManager, b(), 7);
      a(paramContext, paramQQAppInterface);
    }
    localSharedPreferences.edit().putString("sp_key_apollo_step_flag", str).commit();
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "apollo step play bubtext=" + this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloStepInfo.jdField_a_of_type_JavaLangString);
    }
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "show_steps", b(), 0, new String[] { a() + "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.StepDrawerStatus
 * JD-Core Version:    0.7.0.1
 */