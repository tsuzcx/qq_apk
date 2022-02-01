package com.tencent.biz.pubaccount.util.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

final class PublicAccountConfigUtilImpl$4
  implements Runnable
{
  PublicAccountConfigUtilImpl$4(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.a.getCurrentAccountUin();
    Object localObject = this.a.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + str, 0);
    if (localObject != null) {}
    try
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_name", PublicAccountConfigUtilImpl.SERVICE_ACCOUNT_FOLDER_NAME);
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_icon", PublicAccountConfigUtilImpl.access$100());
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_delete", PublicAccountConfigUtilImpl.SERVICE_ACCOUNT_FOLDER_DELETE);
      ((SharedPreferences.Editor)localObject).putBoolean("service_folder_redclean_after_enter", PublicAccountConfigUtilImpl.ServiceFolder_RedClean_After_Enter);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_redspots", PublicAccountConfigUtilImpl.SERVICE_FOLDER_REDSPOTS);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload", PublicAccountConfigUtilImpl.readInJoyFeedsPreload);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_wifi", PublicAccountConfigUtilImpl.readInJoyFeedsPreloadWifi);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_4G", PublicAccountConfigUtilImpl.readInJoyFeedsPreload4G);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_3G", PublicAccountConfigUtilImpl.readInJoyFeedsPreload3G);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_preload_2G", PublicAccountConfigUtilImpl.readInJoyFeedsPreload2G);
      ((SharedPreferences.Editor)localObject).putBoolean("public_account_bottom_bar", PublicAccountConfigUtilImpl.needPABottomBar);
      ((SharedPreferences.Editor)localObject).putBoolean("kandian_feeds_image_preload", PublicAccountConfigUtilImpl.readInJoyFeedsImagePreload);
      ((SharedPreferences.Editor)localObject).putString("kandian_feeds_fling_LToR_host", PublicAccountConfigUtilImpl.readInJoyflingLToRHost);
      ((SharedPreferences.Editor)localObject).putLong("kandian_ad_background_showtime", PublicAccountConfigUtilImpl.readInJoyADBackgroundShowTime);
      ((SharedPreferences.Editor)localObject).putBoolean("readInJoy_ip_connect", PublicAccountConfigUtilImpl.readInJoyIpConnect);
      ((SharedPreferences.Editor)localObject).putInt("readInJoy_ip_connect_full_report", PublicAccountConfigUtilImpl.readInJoyIpConnectReportSwitch);
      ((SharedPreferences.Editor)localObject).putString("readInJoy_ip_connect_report_tail", PublicAccountConfigUtilImpl.readInJoyIpConnectReportTail);
      ((SharedPreferences.Editor)localObject).putBoolean("readInJoy_loading_img", PublicAccountConfigUtilImpl.readInJoyLoadImg);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_redspots_delete", PublicAccountConfigUtilImpl.SERVICE_FOLDER_RED_DELETE);
      ((SharedPreferences.Editor)localObject).putBoolean("big_data_share_channel", PublicAccountConfigUtilImpl.disableBigDataChannel);
      SharedPreferencesHandler.a((SharedPreferences.Editor)localObject, "big_data_share_channel_urls", PublicAccountConfigUtilImpl.bigDataChannelWhiteList.toArray());
      ((SharedPreferences.Editor)localObject).putInt("album_predown_enable", PublicAccountConfigUtilImpl.imageCollectionPreload);
      ((SharedPreferences.Editor)localObject).putInt("album_predown_photo_rule", PublicAccountConfigUtilImpl.imageCollectionPreloadCover);
      ((SharedPreferences.Editor)localObject).putInt("album_predown_slide_photocounts", PublicAccountConfigUtilImpl.imageCollectionPreloadImage);
      ((SharedPreferences.Editor)localObject).putBoolean("ad_preload_tool_process", PublicAccountConfigUtilImpl.preloadToolProcess);
      ((SharedPreferences.Editor)localObject).putString("key_read_in_joy_preload_tool_config", PublicAccountConfigUtilImpl.readInJoyPreloadToolConfig);
      ((SharedPreferences.Editor)localObject).putString("key_read_in_joy_release_service_config", PublicAccountConfigUtilImpl.readInJoyReleaseWebServiceConfig);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountConfigUtil", 2, "updateServiceAccountFolderConfigData success, uin:" + str + ", delete:" + PublicAccountConfigUtilImpl.SERVICE_ACCOUNT_FOLDER_DELETE + ", clean:" + PublicAccountConfigUtilImpl.ServiceFolder_RedClean_After_Enter + ", redspot:" + PublicAccountConfigUtilImpl.SERVICE_FOLDER_REDSPOTS);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl.4
 * JD-Core Version:    0.7.0.1
 */