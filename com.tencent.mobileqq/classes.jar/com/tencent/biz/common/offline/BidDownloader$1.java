package com.tencent.biz.common.offline;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.biz.common.offline.util.IThreadManager;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class BidDownloader$1
  implements AsyncBack
{
  BidDownloader$1(BidDownloader paramBidDownloader, long paramLong) {}
  
  public void loaded(String paramString, int paramInt)
  {
    int j = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if ((HtmlOffline.a != null) && (HtmlOffline.a.containsKey(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString))) {
      HtmlOffline.a.remove(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    boolean bool;
    if (paramInt == 0)
    {
      OfflinePlugin.d(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_Boolean)
      {
        if (!HtmlOffline.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString))
        {
          Util.b(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_JavaLangString);
          Util.a(OfflineEnvHelper.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
          paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 10, j);
          this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
          HtmlOffline.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, 14, 0L, NetworkUtil.a(BidDownloader.jdField_a_of_type_AndroidContentContext), "lixian_update", "0");
          OfflinePlugin.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, "Offline_Update_BSDiff", j, 14, "", "", "");
        }
      }
      else if (((this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.e)) && (!this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.b()))
      {
        QLog.e(BidDownloader.jdField_d_of_type_JavaLangString, 1, "businessId " + this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString + " now un compress file error! " + this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_JavaLangString);
        return;
      }
      bool = true;
      if (2 == this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_Int)
      {
        bool = HtmlOffline.b(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
        paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, -1, j);
        this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        if (!this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_Boolean) {
          break label578;
        }
        OfflinePlugin.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, "Offline_Update_BSDiff", j, 0, "", "", "");
        BaseApplicationImpl.getApplication().getSharedPreferences("bid_update_success_time", 4).edit().putLong(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, System.currentTimeMillis()).commit();
        if (QLog.isColorLevel()) {
          QLog.i("OfflinePluginQQ", 2, "success update bid: " + this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
        }
        HtmlOffline.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, paramInt, j, NetworkUtil.a(BidDownloader.jdField_a_of_type_AndroidContentContext), "lixian_update", this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_d_of_type_Int + "");
        label499:
        paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString;
        if (paramInt != 0) {
          break label760;
        }
      }
    }
    label578:
    label760:
    for (paramInt = 0;; paramInt = 1)
    {
      SpringHbMonitorReporter.a(paramString, paramInt, this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_d_of_type_Int);
      return;
      if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_Boolean) {
        bool = HtmlOffline.b(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
      }
      paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 0, j);
      this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      break;
      paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString;
      if (bool) {}
      for (int i = 0;; i = 13)
      {
        OfflinePlugin.a(paramString, "Offline_Update", j, i, "", "", "");
        break;
      }
      paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader;
      paramString.jdField_b_of_type_Int += 1;
      if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_Int < 3)
      {
        BidDownloader.jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.c(new BidDownloader.1.1(this));
        break label499;
      }
      paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 2, j);
      this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      HtmlOffline.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, paramInt, j, NetworkUtil.a(BidDownloader.jdField_a_of_type_AndroidContentContext), "lixian_update", this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_d_of_type_Int + "");
      OfflinePlugin.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, "Offline_Update", j, paramInt, "", "", "");
      break label499;
    }
  }
  
  public void progress(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack != null) {
      this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.progress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.1
 * JD-Core Version:    0.7.0.1
 */