package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerFactory;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerPreloader;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VideoPreDownloadMgr
  implements VideoPluginInstall.OnVideoPluginInstallListener
{
  private static String jdField_a_of_type_JavaLangString = "Q.readinjoy.video.VideoPreDownloadMgr";
  private static Set<String> c = new HashSet();
  public Context a;
  private VideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
  private VideoPreDownloadMgr.PreDownloadController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr$PreDownloadController;
  public VideoPreloadReportData a;
  private IPlayerPreloader jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader;
  private PlayerVideoInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperPlayerVideoInfo = null;
  private List<VideoPreDownloadMgr.VideoPreDownloadParam> jdField_a_of_type_JavaUtilList = null;
  private Set<String> jdField_a_of_type_JavaUtilSet = null;
  private String jdField_b_of_type_JavaLangString = null;
  private Set<String> jdField_b_of_type_JavaUtilSet = null;
  
  public VideoPreDownloadMgr() {}
  
  public VideoPreDownloadMgr(Context paramContext)
  {
    this();
    a(paramContext);
  }
  
  private PlayerVideoInfo a(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {
      return new PlayerVideoInfo(1, paramString2);
    }
    if (1 == paramInt) {}
    for (paramInt = 104;; paramInt = 101) {
      return new PlayerVideoInfo(paramInt, paramString2, new String[] { paramString1 });
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 正式开始预下载 vid=" + paramString2 + ", url=" + paramString1 + ", urlType=" + paramInt1 + ", duration=" + paramInt2);
    }
    IPlayerPreloader localIPlayerPreloader = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader;
    if (localIPlayerPreloader == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() start preload ERROR cacheMgr == null!");
      }
      return;
    }
    Object localObject = paramString2;
    if (paramString1 != null) {
      if (paramString2 != null)
      {
        localObject = paramString2;
        if (!paramString1.equals(paramString2)) {}
      }
      else
      {
        localObject = NativeAdUtils.a(paramString1);
      }
    }
    paramString2 = a(paramString1, (String)localObject, paramInt1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperPlayerVideoInfo = paramString2;
    localObject = SuperPlayerDownOption.obtain();
    ((SuperPlayerDownOption)localObject).preloadDurationMs = 2000L;
    ((SuperPlayerDownOption)localObject).videoDurationMs = paramInt2;
    if (NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext))
    {
      bool1 = QuicConfigHelper.a.a();
      label171:
      if ((!bool1) || (!QuicConfigHelper.a.a(paramString1))) {
        break label334;
      }
      bool1 = true;
      label189:
      ((SuperPlayerDownOption)localObject).enableUseQuic = bool1;
      ((SuperPlayerDownOption)localObject).enableQuicPlaintext = QuicConfigHelper.a.c();
      ((SuperPlayerDownOption)localObject).enableQuicConnectionMigration = QuicConfigHelper.a.d();
      ((SuperPlayerDownOption)localObject).quicCongestionType = QuicConfigHelper.a.a();
      if (Aladdin.getConfig(392).getIntegerFromString("enable_p2p", 0) != 1) {
        break label340;
      }
      bool1 = true;
      label248:
      ((SuperPlayerDownOption)localObject).enableP2P = bool1;
      if (Aladdin.getConfig(392).getIntegerFromString("enable_pcdn", 0) != 1) {
        break label346;
      }
    }
    label334:
    label340:
    label346:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((SuperPlayerDownOption)localObject).enablePcdn = bool1;
      localIPlayerPreloader.a(paramString2, paramInt2, (SuperPlayerDownOption)localObject);
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData == null)) {
        break;
      }
      paramString1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData;
      paramString1.j += 1;
      return;
      bool1 = QuicConfigHelper.a.b();
      break label171;
      bool1 = false;
      break label189;
      bool1 = false;
      break label248;
    }
  }
  
  private void a(List<VideoPreDownloadMgr.VideoPreDownloadParam> paramList)
  {
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadSerialTask(this, paramList), 5, null, true);
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, true);
  }
  
  private void e()
  {
    IPlayerPreloader localIPlayerPreloader = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader;
    if (localIPlayerPreloader == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "initSerialPreDownload() 设置mCacheMgr回调");
    }
    localIPlayerPreloader.a(new VideoPreDownloadMgr.2(this));
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "releaseSerialPredownload()");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader.a(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader.b();
    }
  }
  
  private void g()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0)) {}
    label64:
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
            g();
            return;
          }
          catch (Exception localException2)
          {
            VideoPreDownloadMgr.VideoPreDownloadParam localVideoPreDownloadParam1;
            VideoPreDownloadMgr.VideoPreDownloadParam localVideoPreDownloadParam2;
            int i;
            break label64;
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
      i = localVideoPreDownloadParam2.b;
      if (2 == localVideoPreDownloadParam2.jdField_a_of_type_Int)
      {
        ThirdVideoManager.a().a(localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString, new VideoPreDownloadMgr.3(this, i));
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
          g();
          return;
        }
        b(localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString, localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString, 0, i);
        return;
      }
      if (a(null, localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_JavaLangString = null;
        g();
        return;
      }
      b(null, localVideoPreDownloadParam2.jdField_a_of_type_JavaLangString, 0, i);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 2, "已完成预下载，队列为空");
  }
  
  public void a()
  {
    b(true);
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
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader == null) {
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
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = new VideoPluginInstall();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a(this);
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a();
      return;
    }
    c();
    e();
  }
  
  public void a(VideoPreDownloadMgr.PreDownloadController paramPreDownloadController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr$PreDownloadController = paramPreDownloadController;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, false);
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
      localVideoPreloadReportData.h += 1;
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString)))
      {
        localVideoPreloadReportData.k += 1;
        if ((this.jdField_b_of_type_JavaUtilSet != null) && (!this.jdField_b_of_type_JavaUtilSet.contains(paramString)))
        {
          this.jdField_b_of_type_JavaUtilSet.add(paramString);
          localVideoPreloadReportData.l += 1;
        }
      }
    } while (!c.contains(paramString));
    localVideoPreloadReportData.m += 1;
    return;
    localVideoPreloadReportData.i += 1;
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    e();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    IPlayerPreloader localIPlayerPreloader = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader;
    if (localIPlayerPreloader == null) {}
    String str;
    do
    {
      return false;
      str = paramString2;
      if (paramString1 != null) {
        if (paramString2 != null)
        {
          str = paramString2;
          if (!paramString1.equals(paramString2)) {}
        }
        else
        {
          str = NativeAdUtils.a(paramString1);
        }
      }
      paramString1 = a(paramString1, str, 101);
      try
      {
        i = localIPlayerPreloader.a(paramString1);
        if ((i == 2) || (i == 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, str + " checkIsVideoCached(), cacheStatus = " + i + ", return TRUE");
          }
          return true;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, str + " checkIsVideoCached() cacheMgr.isVideoCached Exception = " + paramString1.getMessage());
          }
          int i = 0;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, str + " checkIsVideoCached() return FALSE");
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "resume()");
    }
    c();
    e();
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destroy()");
    }
    ThreadManager.post(new VideoPreDownloadMgr.1(this), 5, null, true);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData != null))
    {
      RIJStatisticCollectorReport.b(BaseApplication.getContext(), ReadInJoyUtils.a(), true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader = PlayerHelper.a.a().a();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VideoPreDownloadController initCacheMgr mCacheMgr=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader == null) {}
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperPlayerVideoInfo != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerPreloader.a();
    }
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperPlayerVideoInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */