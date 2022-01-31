package com.tencent.biz.huanjiplugin;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import knc;

public class HuanjiPluginProxy
{
  private static volatile HuanjiPluginProxy jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginProxy;
  public int a;
  public HuanjiPluginStartListener a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new knc(this);
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  public String a;
  
  public HuanjiPluginProxy()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static HuanjiPluginProxy a()
  {
    if (jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginProxy == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginProxy == null) {
        jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginProxy = new HuanjiPluginProxy();
      }
      return jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginProxy;
    }
    finally {}
  }
  
  public HuanjiPluginInfo a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "queryStatuspackageName = " + paramString1 + "pluginId =" + paramString2 + "version = " + paramString3);
    }
    if ((this.jdField_a_of_type_CooperationPluginIPluginManager == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return null;
    }
    paramString1 = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qhuanji_plugin.apk");
    if ((paramString1 != null) && (QLog.isColorLevel())) {
      QLog.w("HuanjiPlugin", 2, "queryPluginstate = " + paramString1.mState + "pluginSize =" + paramString1.mLength + "version = " + paramString1.mVersion);
    }
    paramString2 = new HuanjiPluginInfo();
    if (paramString1 != null)
    {
      if (paramString1.mState == 0) {
        HuanjiPluginInfo.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        HuanjiPluginInfo.jdField_a_of_type_Long = paramString1.mLength;
        return paramString2;
        if (paramString1.mState == 2) {
          HuanjiPluginInfo.jdField_a_of_type_Int = 1;
        } else if ((paramString1.mState == 4) && (paramString1.mVersion.equals(paramString3))) {
          HuanjiPluginInfo.jdField_a_of_type_Int = 2;
        } else if ((paramString1.mState == 4) && (!paramString1.mVersion.equals(paramString3))) {
          HuanjiPluginInfo.jdField_a_of_type_Int = 3;
        }
      }
    }
    HuanjiPluginInfo.jdField_a_of_type_Int = 0;
    return paramString2;
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginStartListener != null) {
      this.jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginStartListener.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)paramQQAppInterface.getManager(26));
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, HuanjiPluginStartListener paramHuanjiPluginStartListener)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "huanjiDownloadstartParam = " + paramString2);
    }
    ReportTask localReportTask = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_huanji").c("Grp_download");
    String str;
    if (paramInt == 2)
    {
      str = "Clk_start";
      localReportTask.d(str).a(new String[] { paramString1 }).a();
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString2;
      paramString1 = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qhuanji_plugin.apk");
      this.jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginStartListener = paramHuanjiPluginStartListener;
      if ((paramString1 == null) || (paramString1.mState == 4)) {
        break label163;
      }
      if (QLog.isColorLevel()) {
        QLog.w("HuanjiPlugin", 2, "换机插件还未安装 installPlugin");
      }
      this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("qhuanji_plugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
    }
    label163:
    do
    {
      return true;
      str = "Clk_download";
      break;
      if (paramInt == 2)
      {
        paramString1 = new Intent(BaseApplicationImpl.getApplication().getApplicationContext(), TranslucentActivty.class);
        paramString1.putExtra("startParam", paramString2);
        paramString1.addFlags(268435456);
        paramString1.putExtras(paramString1);
        BaseApplicationImpl.getApplication().getApplicationContext().startActivity(paramString1);
        return true;
      }
    } while (this.jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginStartListener == null);
    this.jdField_a_of_type_ComTencentBizHuanjipluginHuanjiPluginStartListener.a(3, 4, 100);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.huanjiplugin.HuanjiPluginProxy
 * JD-Core Version:    0.7.0.1
 */