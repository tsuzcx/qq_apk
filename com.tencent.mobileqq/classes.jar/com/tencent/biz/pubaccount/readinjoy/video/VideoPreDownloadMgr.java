package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.text.TextUtils;
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
import nmf;
import onk;
import onx;
import qua;
import qud;
import quf;
import qui;
import quj;
import quk;
import qul;
import qun;

public class VideoPreDownloadMgr
  implements quf
{
  private static String jdField_a_of_type_JavaLangString = "Q.readinjoy.video.VideoPreDownloadMgr";
  private static Set<String> jdField_c_of_type_JavaUtilSet = new HashSet();
  private final int jdField_a_of_type_Int = 2;
  public Context a;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private List<qul> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private qud jdField_a_of_type_Qud;
  private quk jdField_a_of_type_Quk;
  public qun a;
  private final int jdField_b_of_type_Int = 5;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  private final int jdField_c_of_type_Int = 1;
  private final String jdField_c_of_type_JavaLangString = "2";
  
  public VideoPreDownloadMgr() {}
  
  public VideoPreDownloadMgr(Context paramContext)
  {
    this();
    a(paramContext);
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 正式开始预下载 vid=" + paramString2 + ", url=" + paramString1 + ", urlType=" + paramInt1 + ", duration=" + paramInt2);
    }
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() start preload ERROR cacheMgr == null!");
      }
    }
    label256:
    label272:
    for (;;)
    {
      return;
      String str = paramString2;
      if (paramString1 != null) {
        if (paramString2 != null)
        {
          str = paramString2;
          if (!paramString1.equals(paramString2)) {}
        }
        else
        {
          str = nmf.a(paramString1);
        }
      }
      TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo("", "");
      if (1 == paramInt1)
      {
        paramString2 = new TVK_PlayerVideoInfo(1, str, "");
        paramString2.setConfigMap("cache_duration", "2");
        paramString2.setConfigMap("cache_servers_type", qua.jdField_a_of_type_JavaLangString);
        if (paramInt2 > 0) {
          paramString2.setConfigMap("duration", String.valueOf(paramInt2));
        }
        paramString2.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
        str = qua.a();
        if (paramString1 != null) {
          break label256;
        }
        localTVK_ICacheMgr.preLoadVideoById(this.jdField_a_of_type_AndroidContentContext, localTVK_UserInfo, paramString2, str);
      }
      for (;;)
      {
        if ((!paramBoolean) || (this.jdField_a_of_type_Qun == null)) {
          break label272;
        }
        paramString1 = this.jdField_a_of_type_Qun;
        paramString1.i += 1;
        return;
        paramString2 = new TVK_PlayerVideoInfo(2, str, "");
        break;
        localTVK_ICacheMgr.preLoadVideoByUrl(this.jdField_a_of_type_AndroidContentContext, paramString1, localTVK_UserInfo, paramString2);
      }
    }
  }
  
  private void a(List<qul> paramList)
  {
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadSerialTask(this, paramList), 5, null, true);
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, true);
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
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(new qui(this));
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "releaseSerialPredownload()");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.removePreloadCallback();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.releasePreload(20160519);
    }
  }
  
  private void h()
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
          localqul1 = (qul)localList.get(0);
          localqul2 = localqul1;
        }
        catch (Exception localException1)
        {
          try
          {
            localList.remove(0);
            localqul2 = localqul1;
            if ((localqul2 != null) && (!TextUtils.isEmpty(localqul2.jdField_a_of_type_JavaLangString))) {
              break;
            }
            h();
            return;
          }
          catch (Exception localException2)
          {
            qul localqul1;
            qul localqul2;
            int i;
            break label64;
          }
          localException1 = localException1;
          localqul1 = null;
        }
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "preDownloadVideoNotAlreadyList.remove(0) ERROR = " + localException1.getMessage());
          localqul2 = localqul1;
        }
      }
      this.jdField_b_of_type_JavaLangString = localqul2.jdField_a_of_type_JavaLangString;
      i = localqul2.jdField_b_of_type_Int;
      if (2 == localqul2.jdField_a_of_type_Int)
      {
        onx.a().a(localqul2.jdField_a_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new quj(this, i));
        return;
      }
      if (5 == localqul2.jdField_a_of_type_Int)
      {
        if (a(localqul2.jdField_a_of_type_JavaLangString, localqul2.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + localqul2.jdField_a_of_type_JavaLangString);
          }
          this.jdField_b_of_type_JavaLangString = null;
          h();
          return;
        }
        b(localqul2.jdField_a_of_type_JavaLangString, localqul2.jdField_a_of_type_JavaLangString, 0, i);
        return;
      }
      if (a(null, localqul2.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + localqul2.jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_JavaLangString = null;
        h();
        return;
      }
      b(null, localqul2.jdField_a_of_type_JavaLangString, 0, i);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 2, "已完成预下载，队列为空");
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Quk == null) {}
    do
    {
      List localList;
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) {
          break;
        }
        localList = this.jdField_a_of_type_Quk.a(paramInt, paramBoolean);
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
    this.jdField_a_of_type_Qud = new qud(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Qud.a(this);
    if (!this.jdField_a_of_type_Qud.a())
    {
      this.jdField_a_of_type_Qud.a();
      return;
    }
    c();
    f();
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    qun localqun = this.jdField_a_of_type_Qun;
    if (localqun == null) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      localqun.g += 1;
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString)))
      {
        localqun.j += 1;
        if ((this.jdField_b_of_type_JavaUtilSet != null) && (!this.jdField_b_of_type_JavaUtilSet.contains(paramString)))
        {
          this.jdField_b_of_type_JavaUtilSet.add(paramString);
          localqun.k += 1;
        }
      }
    } while (!jdField_c_of_type_JavaUtilSet.contains(paramString));
    localqun.l += 1;
    return;
    localqun.h += 1;
  }
  
  public void a(quk paramquk)
  {
    this.jdField_a_of_type_Quk = paramquk;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destroy()");
    }
    ThreadManager.post(new VideoPreDownloadMgr.1(this), 5, null, true);
    if ((paramBoolean) && (this.jdField_a_of_type_Qun != null))
    {
      onk.b(BaseApplication.getContext(), onk.a(), true, this.jdField_a_of_type_Qun.a());
      this.jdField_a_of_type_Qun = null;
    }
    if (this.jdField_a_of_type_Qud != null)
    {
      this.jdField_a_of_type_Qud.b();
      this.jdField_a_of_type_Qud = null;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      return false;
    }
    String str1 = paramString2;
    if (paramString1 != null) {
      if (paramString2 != null)
      {
        str1 = paramString2;
        if (!paramString1.equals(paramString2)) {}
      }
      else
      {
        str1 = nmf.a(paramString1);
      }
    }
    paramString2 = new TVK_UserInfo("", "");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, str1, "");
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", qua.jdField_a_of_type_JavaLangString);
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
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
      String str2 = arrayOfString[j];
      try
      {
        int k = localTVK_ICacheMgr.isVideoCached(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, localTVK_PlayerVideoInfo, str2);
        i = k;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, str1 + " checkIsVideoCached() cacheMgr.isVideoCached Exception = " + localException.getMessage());
          }
        }
        j += 1;
      }
      if ((i == 2) || (i == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, str1 + " checkIsVideoCached(), definition = " + str2 + ", cacheStatus = " + i + ", return TRUE");
        }
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, str1 + " checkIsVideoCached() return FALSE");
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
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(20160519);
    }
    this.jdField_b_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */