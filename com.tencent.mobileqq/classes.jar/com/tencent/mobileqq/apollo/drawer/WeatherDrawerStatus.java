package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class WeatherDrawerStatus
  extends ApolloDrawerStatus
{
  public ApolloWeatherInfo a;
  private boolean c;
  
  public WeatherDrawerStatus(QQAppInterface paramQQAppInterface, ApolloWeatherInfo paramApolloWeatherInfo)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramApolloWeatherInfo.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloWeatherInfo = paramApolloWeatherInfo;
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Boolean) || (paramAppInterface == null)) {
      paramInt = super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
    }
    do
    {
      return paramInt;
      boolean bool = ApolloUtil.a(ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloWeatherInfo.jdField_a_of_type_Int));
      Object localObject = paramContext.getSharedPreferences("apollo_sp", 0);
      Calendar localCalendar = Calendar.getInstance();
      localObject = ((SharedPreferences)localObject).getString("sp_key_apollo_weather_show", "");
      if ((!bool) || (((String)localObject).equals(paramAppInterface.getCurrentAccountUin() + localCalendar.get(6))) || (this.c)) {
        break;
      }
      paramAppInterface = new ApolloActionData();
      paramAppInterface.actionId = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloWeatherInfo.jdField_a_of_type_Int;
      paramAppInterface.actionType = 0;
      SpriteUtil.a(paramSpriteDrawerInfoManager, 6, paramAppInterface);
      paramInt = i;
    } while (!QLog.isColorLevel());
    QLog.d("QQSettingRedesign", 2, "apollo weather play action=" + this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloWeatherInfo.jdField_a_of_type_Int);
    return 0;
    paramInt = super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
    ApolloResDownloader.a(paramAppInterface, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloWeatherInfo.jdField_a_of_type_Int) + "/d.zip", ApolloUtil.c(this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloWeatherInfo.jdField_a_of_type_Int));
    return paramInt;
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.c) {}
    for (paramSpriteDrawerInfoManager = "http://cmshow.qq.com/act/actTpl/html/home.html?app=tqbssm&type=1&_wv=1025";; paramSpriteDrawerInfoManager = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloWeatherInfo.jdField_a_of_type_JavaLangString)
    {
      VasWebviewUtil.openQQBrowserActivity(paramContext, paramSpriteDrawerInfoManager, -1L, new Intent(paramContext, QQBrowserActivity.class), false, -1);
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "clk_weather_bubble", (int)(System.currentTimeMillis() / 1000L), 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloWeatherInfo.jdField_c_of_type_JavaLangString });
      return;
    }
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    SharedPreferences localSharedPreferences;
    Object localObject;
    boolean bool;
    int i;
    do
    {
      return;
      localSharedPreferences = paramContext.getSharedPreferences("apollo_sp", 0);
      localObject = Calendar.getInstance();
      localObject = paramQQAppInterface.getCurrentAccountUin() + ((Calendar)localObject).get(6);
      bool = ((String)localObject).equals(localSharedPreferences.getString("sp_key_apollo_weather_show", ""));
      paramInt = localSharedPreferences.getInt(paramQQAppInterface.c() + "sp_key_apollo_weather_flag", 0);
      i = (int)(System.currentTimeMillis() / 1000L);
    } while ((Boolean.valueOf(bool).booleanValue()) || (i >= paramInt));
    SpriteUtil.a(paramSpriteDrawerInfoManager, this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloWeatherInfo.b, 7);
    localSharedPreferences.edit().putString("sp_key_apollo_weather_show", (String)localObject).commit();
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "apollo weather play bubtext=" + this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloWeatherInfo.b);
    }
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "show_weather", i, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloWeatherInfo.jdField_a_of_type_Int + "", "", "", this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloWeatherInfo.jdField_c_of_type_JavaLangString });
    a(paramContext, paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.WeatherDrawerStatus
 * JD-Core Version:    0.7.0.1
 */