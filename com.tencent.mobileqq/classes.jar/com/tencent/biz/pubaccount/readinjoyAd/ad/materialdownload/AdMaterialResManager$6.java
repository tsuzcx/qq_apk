package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.skin.entity.BaseResData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class AdMaterialResManager$6
  extends DownloadListener
{
  AdMaterialResManager$6(AdMaterialResManager paramAdMaterialResManager, BaseResData paramBaseResData, String paramString1, String paramString2) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < AdMaterialResManager.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager).size())
    {
      ((DownloadListener)AdMaterialResManager.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager).get(i)).onCancel(paramDownloadTask);
      i += 1;
    }
    String str = paramDownloadTask.a().getString("resId");
    HashMap localHashMap = AdMaterialResManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localHashMap.remove(localStringBuilder.toString());
    super.onCancel(paramDownloadTask);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager.a("onCancel", paramDownloadTask);
    QLog.d("readinjoy", 2, "mDownloader onCancel");
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Object localObject1 = paramDownloadTask.a();
    String str = ((Bundle)localObject1).getString("resId");
    if (AdMaterialResManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager, this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinEntityBaseResData, paramDownloadTask, this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    localObject1 = ((Bundle)localObject1).getString("prefix");
    if (paramDownloadTask.a == 0)
    {
      if (!AdMaterialResManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager, this.jdField_a_of_type_JavaLangString, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinEntityBaseResData, str, paramDownloadTask)) {}
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("downloadGuide failed: id = ");
      ((StringBuilder)localObject2).append(str);
      QLog.d("AdMaterialResManager", 2, ((StringBuilder)localObject2).toString());
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinEntityBaseResData instanceof MaterialData)) {
        FileUtils.deleteDirectory(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager.a((String)localObject1, str));
      }
    }
    Object localObject2 = AdMaterialResManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    ((HashMap)localObject2).remove(localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager.a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinEntityBaseResData);
    int i = 0;
    while (i < AdMaterialResManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager).size())
    {
      ((DownloadListener)AdMaterialResManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager).get(i)).onDone(paramDownloadTask);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager.a("onDone", paramDownloadTask);
    i = paramDownloadTask.a;
    long l1 = paramDownloadTask.h;
    long l2 = paramDownloadTask.g;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager.a(new String[] { String.valueOf(i), str, String.valueOf(l1 - l2) });
    QLog.d("readinjoy", 2, "mDownloader downLoadFinish");
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < AdMaterialResManager.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager).size())
    {
      ((DownloadListener)AdMaterialResManager.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager).get(i)).onProgress(paramDownloadTask);
      i += 1;
    }
    super.onProgress(paramDownloadTask);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager.a("onProgress", paramDownloadTask);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < AdMaterialResManager.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager).size())
    {
      ((DownloadListener)AdMaterialResManager.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager).get(i)).onStart(paramDownloadTask);
      i += 1;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinEntityBaseResData instanceof MaterialData)) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime() != null)) {
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onResDownloadStart(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), (MaterialData)this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinEntityBaseResData);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadAdMaterialResManager.a("onStart", paramDownloadTask);
    QLog.d("readinjoy", 2, "mDownloader onStart");
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.6
 * JD-Core Version:    0.7.0.1
 */