package com.tencent.biz.pubaccount.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import baih;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import rsp;

public final class PublicAccountConfigUtil$4
  implements Runnable
{
  public PublicAccountConfigUtil$4(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.a.getCurrentAccountUin();
    Object localObject = this.a.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + str, 0);
    if (localObject != null) {}
    try
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_name", rsp.jdField_d_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_icon", rsp.jdField_e_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_delete", rsp.jdField_a_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("service_folder_redclean_after_enter", rsp.p);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_redspots", rsp.jdField_b_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload", rsp.jdField_e_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_wifi", rsp.jdField_f_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_4G", rsp.jdField_g_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_3G", rsp.jdField_h_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_2G", rsp.jdField_i_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("public_account_bottom_bar", rsp.l);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_image_preload", rsp.j);
      ((SharedPreferences.Editor)localObject).putString("kandian_feeds_fling_LToR_host", rsp.jdField_f_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putLong("kandian_ad_background_showtime", rsp.jdField_a_of_type_Long);
      ((SharedPreferences.Editor)localObject).putBoolean("readInJoy_ip_connect", rsp.m);
      ((SharedPreferences.Editor)localObject).putInt("readInJoy_ip_connect_full_report", rsp.jdField_b_of_type_Int);
      ((SharedPreferences.Editor)localObject).putString("readInJoy_ip_connect_report_tail", rsp.jdField_i_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putBoolean("readInJoy_loading_img", rsp.n);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_redspots_delete", rsp.jdField_c_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("big_data_share_channel", rsp.o);
      baih.a((SharedPreferences.Editor)localObject, "big_data_share_channel_urls", rsp.jdField_a_of_type_JavaUtilArrayList.toArray());
      ((SharedPreferences.Editor)localObject).putInt("album_predown_enable", rsp.jdField_c_of_type_Int);
      ((SharedPreferences.Editor)localObject).putInt("album_predown_photo_rule", rsp.jdField_d_of_type_Int);
      ((SharedPreferences.Editor)localObject).putInt("album_predown_slide_photocounts", rsp.jdField_e_of_type_Int);
      ((SharedPreferences.Editor)localObject).putBoolean("ad_preload_tool_process", rsp.k);
      ((SharedPreferences.Editor)localObject).putString("key_read_in_joy_preload_tool_config", rsp.jdField_g_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putString("key_read_in_joy_release_service_config", rsp.jdField_h_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "updateServiceAccountFolderConfigData success, uin:" + str + ", delete:" + rsp.jdField_a_of_type_Boolean + ", clean:" + rsp.p + ", redspot:" + rsp.jdField_b_of_type_Boolean);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "updateServiceAccountFolderConfigData error, uin:" + str, localException);
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.4
 * JD-Core Version:    0.7.0.1
 */