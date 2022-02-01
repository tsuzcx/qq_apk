package com.tencent.biz.common.offline;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.biz.common.offline.util.IThreadManager;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

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
    boolean bool = true;
    if (paramInt == 0)
    {
      OfflinePlugin.d(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_Boolean)
      {
        if (!HtmlOffline.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString))
        {
          Util.b(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_JavaLangString);
          paramString = new StringBuilder();
          paramString.append(OfflineEnvHelper.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString));
          paramString.append(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
          Util.a(paramString.toString());
          paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 10, j);
          this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
          HtmlOffline.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, 14, 0L, NetworkUtil.getNetWorkType(), "lixian_update", "0");
          OfflinePlugin.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, "Offline_Update_BSDiff", j, 14, "", "", "");
          BidDownloader.a(0, this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, 14, 0, "lixian_update", 0);
        }
      }
      else if (((this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.e)) && (!this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.b()))
      {
        paramString = BidDownloader.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("businessId ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" now un compress file error! ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_JavaLangString);
        QLog.e(paramString, 1, localStringBuilder.toString());
        return;
      }
      if (2 == this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_Int)
      {
        bool = HtmlOffline.b(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
        paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, -1, j);
        this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_Boolean) {
          bool = HtmlOffline.b(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
        }
        paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 0, j);
        this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      }
      if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_Boolean)
      {
        OfflinePlugin.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, "Offline_Update_BSDiff", j, 0, "", "", "");
      }
      else
      {
        paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString;
        if (bool) {
          i = 0;
        } else {
          i = 13;
        }
        OfflinePlugin.a(paramString, "Offline_Update", j, i, "", "", "");
      }
      BaseApplication.getContext().getSharedPreferences("bid_update_success_time", 4).edit().putLong(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, System.currentTimeMillis()).commit();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("success update bid: ");
        paramString.append(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString);
        QLog.i("OfflinePluginQQ", 2, paramString.toString());
      }
      paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString;
      l = j;
      i = NetworkUtil.getNetWorkType();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_d_of_type_Int);
      localStringBuilder.append("");
      HtmlOffline.a(paramString, paramInt, l, i, "lixian_update", localStringBuilder.toString());
      BidDownloader.a(j, this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, paramInt, this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_d_of_type_Int, "lixian_update", 0);
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader;
    paramString.jdField_b_of_type_Int += 1;
    if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_b_of_type_Int < 3)
    {
      BidDownloader.jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.c(new BidDownloader.1.1(this));
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 2, j);
    this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
    paramString = this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString;
    long l = j;
    int i = NetworkUtil.getNetWorkType();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_d_of_type_Int);
    localStringBuilder.append("");
    HtmlOffline.a(paramString, paramInt, l, i, "lixian_update", localStringBuilder.toString());
    OfflinePlugin.a(this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, "Offline_Update", j, paramInt, "", "", "");
    BidDownloader.a(j, this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_JavaLangString, paramInt, this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_d_of_type_Int, "lixian_update", 0);
  }
  
  public void progress(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
      ((AsyncBack)this.jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader.jdField_a_of_type_MqqUtilWeakReference.get()).progress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.1
 * JD-Core Version:    0.7.0.1
 */