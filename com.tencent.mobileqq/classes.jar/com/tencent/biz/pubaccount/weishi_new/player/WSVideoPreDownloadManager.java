package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
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
import thn;
import thq;
import ths;
import thv;
import thw;
import thx;
import tlo;

public class WSVideoPreDownloadManager
  implements ths
{
  public Context a;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private final String jdField_a_of_type_JavaLangString = "2";
  private List<thx> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private thq jdField_a_of_type_Thq;
  private thw jdField_a_of_type_Thw;
  private String b;
  
  public WSVideoPreDownloadManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Thq = new thq();
    this.jdField_a_of_type_Thq.a(this);
    if (!this.jdField_a_of_type_Thq.a())
    {
      this.jdField_a_of_type_Thq.a();
      return;
    }
    c();
    e();
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "innerDoPreDownload() 开始预下载 duration=" + paramInt + ", url=" + paramString1);
    }
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      if (QLog.isColorLevel()) {
        tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "innerDoPreDownload() start preload ERROR cacheMgr == null!");
      }
    }
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
    do
    {
      return;
      paramString2 = new TVK_UserInfo(paramString2, "");
      localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, "", "");
      localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
      localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", thn.jdField_a_of_type_JavaLangString);
      if (paramInt > 0) {
        localTVK_PlayerVideoInfo.setConfigMap("duration", String.valueOf(paramInt));
      }
    } while (TextUtils.isEmpty(paramString1));
    tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "preLoadVideoByUrl() 正式开始预下载 url=" + paramString1);
    paramInt = localTVK_ICacheMgr.preLoadVideoByUrlWithResult(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, localTVK_PlayerVideoInfo);
    tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "preLoadVideoByUrl() result=" + paramInt);
  }
  
  private void a(List<thx> paramList)
  {
    ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadSerialTask(this, paramList), 5, null, true);
  }
  
  private void c()
  {
    d();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getCacheMgr(this.jdField_a_of_type_AndroidContentContext);
    }
    if (QLog.isColorLevel()) {
      tlo.b("WS_VIDEO_WSVideoPreDownloadManager", 2, "VideoPreDownloadController initCacheMgr mFactory=" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory + ", mCacheMgr=" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr);
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null)) {}
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (QLog.isColorLevel()) {
      tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "initSerialPreDownload() 设置mCacheMgr回调");
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(new thv(this));
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "releaseSerialPreDownload()");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.removePreloadCallback();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.releasePreload(thn.jdField_a_of_type_Int);
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
          localthx1 = (thx)localList.get(0);
          localthx2 = localthx1;
        }
        catch (Exception localException1)
        {
          try
          {
            localList.remove(0);
            localthx2 = localthx1;
            if ((localthx2 != null) && (!TextUtils.isEmpty(localthx2.b))) {
              break;
            }
            g();
            return;
          }
          catch (Exception localException2)
          {
            thx localthx1;
            thx localthx2;
            int i;
            break label64;
          }
          localException1 = localException1;
          localthx1 = null;
        }
        if (QLog.isColorLevel())
        {
          tlo.d("WS_VIDEO_WSVideoPreDownloadManager", 2, "preDownloadVideoNotAlreadyList.remove(0) ERROR = " + localException1.getMessage());
          localthx2 = localthx1;
        }
      }
      this.b = localthx2.b;
      i = localthx2.jdField_a_of_type_Int;
      if (a(this.b))
      {
        if (QLog.isColorLevel()) {
          tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "innerDoPreDownload() 缓冲已存在，跳过, videoUrl=" + localthx2.b);
        }
        this.b = null;
        g();
        return;
      }
      a(localthx2.b, i, localthx2.jdField_a_of_type_JavaLangString);
      return;
    }
    tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "已完成预下载，队列为空");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      tlo.b("WS_VIDEO_WSVideoPreDownloadManager", 2, "destroy()");
    }
    ThreadManager.post(new WSVideoPreDownloadManager.1(this), 5, null, true);
    if (this.jdField_a_of_type_Thq != null)
    {
      this.jdField_a_of_type_Thq.b();
      this.jdField_a_of_type_Thq = null;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Thw == null) {}
    do
    {
      List localList;
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) {
          break;
        }
        localList = this.jdField_a_of_type_Thw.a(paramInt, paramBoolean);
      } while ((localList == null) || (localList.size() <= 0));
      if (QLog.isColorLevel()) {
        tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "requestPreDownload() 外部触发预下载逻辑 size = " + localList.size());
      }
      a(localList);
      return;
    } while (!QLog.isColorLevel());
    tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "requestPreDownload() is off or mCacheMgr is null, return;");
  }
  
  public void a(thw paramthw)
  {
    this.jdField_a_of_type_Thw = paramthw;
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    e();
  }
  
  public boolean a(String paramString)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      return false;
    }
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo("", "");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, "", "");
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", thn.jdField_a_of_type_JavaLangString);
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "msd";
    arrayOfString[1] = "hd";
    arrayOfString[2] = "fhd";
    arrayOfString[3] = "mp4";
    arrayOfString[4] = "shd";
    arrayOfString[5] = "sd";
    int i = 0;
    int m = arrayOfString.length;
    int j = 0;
    while (j < m)
    {
      String str = arrayOfString[j];
      try
      {
        int k = localTVK_ICacheMgr.isVideoCached(this.jdField_a_of_type_AndroidContentContext, paramString, localTVK_UserInfo, localTVK_PlayerVideoInfo, str);
        i = k;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            tlo.b("WS_VIDEO_WSVideoPreDownloadManager", 2, "checkIsVideoCached()-isVideoCached Exception url=" + paramString + ", cacheMgr.isVideoCached Exception=" + localException.getMessage());
          }
        }
        j += 1;
      }
      if ((i == 2) || (i == 1))
      {
        if (QLog.isColorLevel()) {
          tlo.b("WS_VIDEO_WSVideoPreDownloadManager", 2, "checkIsVideoCached() cacheStatus=" + i + ", definition=" + str + ", return TRUE, url=" + paramString);
        }
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      tlo.b("WS_VIDEO_WSVideoPreDownloadManager", 2, paramString + " checkIsVideoCached() return FALSE");
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(thn.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager
 * JD-Core Version:    0.7.0.1
 */