package com.tencent.biz.pubaccount.readinjoy.skin;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class ReadInJoyBaseResManager$1
  extends DownloadListener
{
  ReadInJoyBaseResManager$1(ReadInJoyBaseResManager paramReadInJoyBaseResManager, BaseResData paramBaseResData, String paramString1, String paramString2) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((DownloadListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.get(i)).onCancel(paramDownloadTask);
      i += 1;
    }
    String str = paramDownloadTask.a().getString("resId");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilHashMap.remove(this.b + "_" + str);
    super.onCancel(paramDownloadTask);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a("onCancel", paramDownloadTask);
    QLog.d("readinjoy", 2, "mDownloader onCancel");
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Object localObject = paramDownloadTask.a();
    String str = ((Bundle)localObject).getString("resId");
    if (ReadInJoyBaseResManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData, paramDownloadTask, this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      localObject = ((Bundle)localObject).getString("prefix");
      if (paramDownloadTask.a != 0) {
        break;
      }
    } while (ReadInJoyBaseResManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager, this.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData, str, paramDownloadTask));
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilHashMap.remove((String)localObject + "_" + str);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a((String)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((DownloadListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.get(i)).onDone(paramDownloadTask);
        i += 1;
      }
      QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide failed: id = " + str);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData instanceof MaterialData)) {
        FileUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a((String)localObject, str));
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a("onDone", paramDownloadTask);
    int i = paramDownloadTask.a;
    long l1 = paramDownloadTask.h;
    long l2 = paramDownloadTask.g;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a(new String[] { String.valueOf(i), str, String.valueOf(l1 - l2) });
    QLog.d("readinjoy", 2, "mDownloader downLoadFinish");
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((DownloadListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.get(i)).onProgress(paramDownloadTask);
      i += 1;
    }
    super.onProgress(paramDownloadTask);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a("onProgress", paramDownloadTask);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((DownloadListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.jdField_a_of_type_JavaUtilArrayList.get(i)).onStart(paramDownloadTask);
      i += 1;
    }
    if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData instanceof MaterialData)) && (RIJQQAppInterfaceUtil.a() != null)) {
      AdMaterialResManager.a(RIJQQAppInterfaceUtil.a()).a((MaterialData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinBaseResData);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyBaseResManager.a("onStart", paramDownloadTask);
    QLog.d("readinjoy", 2, "mDownloader onStart");
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyBaseResManager.1
 * JD-Core Version:    0.7.0.1
 */