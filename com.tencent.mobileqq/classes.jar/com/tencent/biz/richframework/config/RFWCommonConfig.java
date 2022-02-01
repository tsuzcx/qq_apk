package com.tencent.biz.richframework.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;

public class RFWCommonConfig
{
  public static SharedPreferences a()
  {
    return RFApplication.getApplication().getSharedPreferences("RFW_COMMON_SHARE", 0);
  }
  
  public static void a(String paramString)
  {
    a().getString("rfw_common_ad_attach_info", paramString);
  }
  
  public static String b()
  {
    return a().getString("rfw_common_msf_server_name", "正式环境");
  }
  
  public static String c()
  {
    return a().getString("rfw_common_ad_attach_info", "");
  }
  
  public static boolean d()
  {
    return QCircleConfigHelper.a("rfwcommon", "rfw_common_hook_data_observer", Integer.valueOf(1)).intValue() == 1;
  }
  
  public static boolean e()
  {
    return QCircleConfigHelper.a("rfwcommon", "rfw_common_fix_batch_input_event", Integer.valueOf(1)).intValue() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.config.RFWCommonConfig
 * JD-Core Version:    0.7.0.1
 */