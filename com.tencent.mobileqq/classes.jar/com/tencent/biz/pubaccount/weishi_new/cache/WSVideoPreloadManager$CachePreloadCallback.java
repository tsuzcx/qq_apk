package com.tencent.biz.pubaccount.weishi_new.cache;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader.Listener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSVideoPreloadManager$CachePreloadCallback
  implements IWSPlayerPreDownloader.Listener
{
  private WSVideoPreDownloadManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
  private String jdField_a_of_type_JavaLangString;
  
  WSVideoPreloadManager$CachePreloadCallback(WSVideoPreDownloadManager paramWSVideoPreDownloadManager, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    WSLog.a("WSVideoPreloadManager", "onPreloadFailed");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    WSLog.a("WSVideoPreloadManager", "onPreloadSuccess");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.equals(paramString1, WSPlayerUtils.a(this.jdField_a_of_type_JavaLangString))))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
      WSLog.a("WSVideoPreloadManager", "videoPreDownloadManager destroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSVideoPreloadManager.CachePreloadCallback
 * JD-Core Version:    0.7.0.1
 */