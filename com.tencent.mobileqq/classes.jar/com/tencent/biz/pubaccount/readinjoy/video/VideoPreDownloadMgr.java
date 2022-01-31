package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mea;
import meb;
import mee;

public class VideoPreDownloadMgr
  implements VideoPluginInstall.OnVideoPluginInstallListener
{
  private static String jdField_a_of_type_JavaLangString = "Q.readinjoy.video.VideoPreDownloadMgr";
  private static Set jdField_c_of_type_JavaUtilSet = new HashSet();
  private final int jdField_a_of_type_Int = 0;
  public Context a;
  private VideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
  private VideoPreDownloadMgr.PreDownloadController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr$PreDownloadController;
  public VideoPreloadReportData a;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet;
  private final int jdField_b_of_type_Int = 2;
  private String jdField_b_of_type_JavaLangString;
  private Set jdField_b_of_type_JavaUtilSet;
  private final int jdField_c_of_type_Int = 5;
  private final String jdField_c_of_type_JavaLangString = "2";
  private final int d = 1;
  
  public VideoPreDownloadMgr(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = new VideoPluginInstall(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a(this);
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a();
      return;
    }
    c();
    f();
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 正式开始预下载 vid=" + paramString2 + ", url=" + paramString1 + ", urlType=" + paramInt);
    }
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() start preload ERROR cacheMgr == null!");
      }
    }
    label194:
    label210:
    for (;;)
    {
      return;
      TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo("", "");
      if (1 == paramInt)
      {
        paramString2 = new TVK_PlayerVideoInfo(1, paramString2, "");
        paramString2.setConfigMap("cache_duration", "2");
        paramString2.setConfigMap("cache_servers_type", "20160519");
        paramString2.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
        String str = VideoPlayUtils.a();
        if (paramString1 != null) {
          break label194;
        }
        localTVK_ICacheMgr.preLoadVideoById(this.jdField_a_of_type_AndroidContentContext, localTVK_UserInfo, paramString2, str);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData == null) {
          break label210;
        }
        paramString1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData;
        paramString1.g += 1;
        return;
        paramString2 = new TVK_PlayerVideoInfo(2, paramString2, "");
        break;
        localTVK_ICacheMgr.preLoadVideoByUrl(this.jdField_a_of_type_AndroidContentContext, paramString1, localTVK_UserInfo, paramString2);
      }
    }
  }
  
  private void a(List paramList)
  {
    ThreadManager.post(new mee(this, paramList), 5, null, true);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "initSerialPreDownload() 设置mCacheMgr回调");
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(new mea(this));
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "releaseSerialPredownload()");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.removePreloadCallback();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.releasePreload(0);
    }
  }
  
  private void h()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0)) {}
    label61:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        try
        {
          localVideoPreDownloadParam1 = (VideoPreDownloadMgr.VideoPreDownloadParam)localList.get(0);
          localVideoPreDownloadParam2 = localVideoPreDownloadParam1;
        }
        catch (Exception localException1)
        {
          try
          {
            localList.remove(0);
            localVideoPreDownloadParam2 = localVideoPreDownloadParam1;
            if ((localVideoPreDownloadParam2 != null) && (!TextUtils.isEmpty(localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString))) {
              break;
            }
            h();
            return;
          }
          catch (Exception localException2)
          {
            VideoPreDownloadMgr.VideoPreDownloadParam localVideoPreDownloadParam1;
            VideoPreDownloadMgr.VideoPreDownloadParam localVideoPreDownloadParam2;
            break label61;
          }
          localException1 = localException1;
          localVideoPreDownloadParam1 = null;
        }
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "preDownloadVideoNotAlreadyList.remove(0) ERROR = " + localException1.getMessage());
          localVideoPreDownloadParam2 = localVideoPreDownloadParam1;
        }
      }
      this.jdField_b_of_type_JavaLangString = localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString;
      if (2 == localVideoPreDownloadParam2.jdField_a_of_type_Int)
      {
        ThirdVideoManager.a().a(localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new meb(this));
        return;
      }
      if (5 == localVideoPreDownloadParam2.jdField_a_of_type_Int)
      {
        if (a(localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString, localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString);
          }
          this.jdField_b_of_type_JavaLangString = null;
          h();
          return;
        }
        a(localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString, null, 0);
        return;
      }
      if (a(null, localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_JavaLangString = null;
        h();
        return;
      }
      a(null, localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString, 0);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 2, "已完成预下载，队列为空");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destroy()");
    }
    e();
    g();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr$PreDownloadController = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData != null)
    {
      ReadInJoyUtils.b(BaseApplication.getContext(), ReadInJoyUtils.a(), true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData = null;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr$PreDownloadController == null) {}
    do
    {
      List localList;
      do
      {
        return;
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr$PreDownloadController.a()) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null)) {
          break;
        }
        localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr$PreDownloadController.a(paramInt, paramBoolean);
      } while ((localList == null) || (localList.size() <= 0));
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "requestPreDownload() 外部触发预下载逻辑 size = " + localList.size());
      }
      a(localList);
      return;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "requestPreDownload() is off or mCacheMgr is null, return;");
  }
  
  public void a(VideoPreDownloadMgr.PreDownloadController paramPreDownloadController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr$PreDownloadController = paramPreDownloadController;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    VideoPreloadReportData localVideoPreloadReportData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData;
    if (localVideoPreloadReportData == null) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      localVideoPreloadReportData.e += 1;
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString)))
      {
        localVideoPreloadReportData.h += 1;
        if ((this.jdField_b_of_type_JavaUtilSet != null) && (!this.jdField_b_of_type_JavaUtilSet.contains(paramString)))
        {
          this.jdField_b_of_type_JavaUtilSet.add(paramString);
          localVideoPreloadReportData.i += 1;
        }
      }
    } while (!jdField_c_of_type_JavaUtilSet.contains(paramString));
    localVideoPreloadReportData.j += 1;
    return;
    localVideoPreloadReportData.f += 1;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      return false;
    }
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo("", "");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, paramString2, "");
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20160519");
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "msd";
    arrayOfString[1] = "hd";
    arrayOfString[2] = "fhd";
    arrayOfString[3] = "mp4";
    arrayOfString[4] = "shd";
    arrayOfString[5] = "sd";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      int k = localTVK_ICacheMgr.isVideoCached(this.jdField_a_of_type_AndroidContentContext, paramString1, localTVK_UserInfo, localTVK_PlayerVideoInfo, str);
      if ((k == 2) || (k == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramString2 + " checkIsVideoCached(), definition = " + str + ", cacheStatus = " + k + ", return TRUE");
        }
        return true;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramString2 + " checkIsVideoCached() return FALSE");
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "resume()");
    }
    c();
    f();
  }
  
  public void c()
  {
    d();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getCacheMgr(this.jdField_a_of_type_AndroidContentContext);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoPreDownloadController initCacheMgr mFactory=" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory + ", mCacheMgr=" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr);
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null)) {}
  }
  
  public void c(boolean paramBoolean)
  {
    c();
    f();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(0);
    }
    this.jdField_b_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */