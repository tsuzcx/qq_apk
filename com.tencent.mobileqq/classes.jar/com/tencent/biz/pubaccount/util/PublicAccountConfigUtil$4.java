package com.tencent.biz.pubaccount.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bhsj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import tyi;

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
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_name", tyi.jdField_d_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_icon", tyi.jdField_e_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_delete", tyi.jdField_a_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("service_folder_redclean_after_enter", tyi.p);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_redspots", tyi.jdField_b_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload", tyi.jdField_e_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_wifi", tyi.jdField_f_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_4G", tyi.jdField_g_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_3G", tyi.jdField_h_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_2G", tyi.jdField_i_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("public_account_bottom_bar", tyi.l);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_image_preload", tyi.j);
      ((SharedPreferences.Editor)localObject).putString("kandian_feeds_fling_LToR_host", tyi.jdField_f_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putLong("kandian_ad_background_showtime", tyi.jdField_a_of_type_Long);
      ((SharedPreferences.Editor)localObject).putBoolean("readInJoy_ip_connect", tyi.m);
      ((SharedPreferences.Editor)localObject).putInt("readInJoy_ip_connect_full_report", tyi.jdField_b_of_type_Int);
      ((SharedPreferences.Editor)localObject).putString("readInJoy_ip_connect_report_tail", tyi.jdField_i_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putBoolean("readInJoy_loading_img", tyi.n);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_redspots_delete", tyi.jdField_c_of_type_Boolean);
      ((SharedPreferences.Editor)localObject).putBoolean("big_data_share_channel", tyi.o);
      bhsj.a((SharedPreferences.Editor)localObject, "big_data_share_channel_urls", tyi.jdField_a_of_type_JavaUtilArrayList.toArray());
      ((SharedPreferences.Editor)localObject).putInt("album_predown_enable", tyi.jdField_c_of_type_Int);
      ((SharedPreferences.Editor)localObject).putInt("album_predown_photo_rule", tyi.jdField_d_of_type_Int);
      ((SharedPreferences.Editor)localObject).putInt("album_predown_slide_photocounts", tyi.jdField_e_of_type_Int);
      ((SharedPreferences.Editor)localObject).putBoolean("ad_preload_tool_process", tyi.k);
      ((SharedPreferences.Editor)localObject).putString("key_read_in_joy_preload_tool_config", tyi.jdField_g_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putString("key_read_in_joy_release_service_config", tyi.jdField_h_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "updateServiceAccountFolderConfigData success, uin:" + str + ", delete:" + tyi.jdField_a_of_type_Boolean + ", clean:" + tyi.p + ", redspot:" + tyi.jdField_b_of_type_Boolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.4
 * JD-Core Version:    0.7.0.1
 */