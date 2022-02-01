package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerFactory;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader.Listener;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.WSPlayerWrapHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WSVideoPreDownloadManager
  implements WSVideoPluginInstall.OnVideoPluginInstallListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private WSVideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall;
  private WSVideoPreDownloadManager.PreDownloadController jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager$PreDownloadController;
  private IWSPlayerFactory jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory;
  private IWSPlayerPreDownloader.Listener jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader$Listener;
  private IWSPlayerPreDownloader jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader;
  private String jdField_a_of_type_JavaLangString;
  private List<WSVideoPreDownloadManager.VideoPreDownloadParam> jdField_a_of_type_JavaUtilList = null;
  private Set<String> jdField_a_of_type_JavaUtilSet = null;
  
  public WSVideoPreDownloadManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall = new WSVideoPluginInstall();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a(this);
    if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a();
      return;
    }
    c();
    d();
  }
  
  private AbsWSPlayerInfo a(String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory;
    if (localObject == null) {
      return null;
    }
    localObject = ((IWSPlayerFactory)localObject).a();
    ((AbsWSPlayerInfo)localObject).a(WSPlayerUtils.a(paramString), paramString, 101, paramInt);
    return localObject;
  }
  
  private void a(WSVideoPreDownloadManager.VideoPreDownloadParam paramVideoPreDownloadParam)
  {
    if (paramVideoPreDownloadParam != null)
    {
      if (TextUtils.isEmpty(paramVideoPreDownloadParam.b)) {
        return;
      }
      IWSPlayerPreDownloader localIWSPlayerPreDownloader = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader;
      if (localIWSPlayerPreDownloader == null)
      {
        WSLog.d("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][innerDoPreDownload] start preload ERROR preDownloader == null!");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSVideoPreDownloadManager.java][innerDoPreDownload] START DOWNLOAD!! duration:");
      localStringBuilder.append(paramVideoPreDownloadParam.a);
      localStringBuilder.append(", title:");
      localStringBuilder.append(paramVideoPreDownloadParam.c);
      localStringBuilder.append(", url:");
      localStringBuilder.append(paramVideoPreDownloadParam.b);
      WSLog.e("WS_VIDEO_PRE_DL", localStringBuilder.toString());
      if (!TextUtils.isEmpty(paramVideoPreDownloadParam.b)) {
        localIWSPlayerPreDownloader.a(a(paramVideoPreDownloadParam.b, paramVideoPreDownloadParam.a));
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory = WSPlayerWrapHelper.a().a();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerFactory.a(BaseApplicationImpl.getContext());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSVideoPreDownloadManager.java][initCacheMgr] mPreDownloader=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader);
    WSLog.e("WS_VIDEO_PRE_DL", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][initSerialPreDownload] setPreloadCallback");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader.a(new WSVideoPreDownloadManager.2(this));
  }
  
  private void e()
  {
    WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][releaseSerialPreDownload]");
    IWSPlayerPreDownloader localIWSPlayerPreDownloader = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader;
    if (localIWSPlayerPreDownloader != null)
    {
      localIWSPlayerPreDownloader.a(null);
      localIWSPlayerPreDownloader.b();
    }
  }
  
  private void f()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0))
    {
      WSVideoPreDownloadManager.VideoPreDownloadParam localVideoPreDownloadParam;
      try
      {
        localVideoPreDownloadParam = (WSVideoPreDownloadManager.VideoPreDownloadParam)localList.get(0);
        try
        {
          localList.remove(0);
        }
        catch (Exception localException1) {}
        localStringBuilder2 = new StringBuilder();
      }
      catch (Exception localException2)
      {
        localVideoPreDownloadParam = null;
      }
      StringBuilder localStringBuilder2;
      localStringBuilder2.append("[WSVideoPreDownloadManager.java][preDownloadNotAlreadyVideo] remove(0) ERROR = ");
      localStringBuilder2.append(localException2.getMessage());
      WSLog.d("WS_VIDEO_PRE_DL", localStringBuilder2.toString());
      if ((localVideoPreDownloadParam != null) && (!TextUtils.isEmpty(localVideoPreDownloadParam.b)))
      {
        this.jdField_a_of_type_JavaLangString = localVideoPreDownloadParam.b;
        if (a(this.jdField_a_of_type_JavaLangString))
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("[WSVideoPreDownloadManager.java][preDownloadNotAlreadyVideo] checkIsCached is TRUE! videoTitle:");
          localStringBuilder1.append(localVideoPreDownloadParam.c);
          WSLog.e("WS_VIDEO_PRE_DL", localStringBuilder1.toString());
          this.jdField_a_of_type_JavaLangString = null;
          f();
          return;
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[WSVideoPreDownloadManager.java][preDownloadNotAlreadyVideo] checkIsCached is FALSE! videoTitle:");
        localStringBuilder1.append(localVideoPreDownloadParam.c);
        WSLog.e("WS_VIDEO_PRE_DL", localStringBuilder1.toString());
        a(localVideoPreDownloadParam);
        return;
      }
      f();
      return;
    }
    WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][preDownloadNotAlreadyVideo] preDownload finish! PreDownloadList empty.");
  }
  
  public void a()
  {
    WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][destroy]");
    ThreadManager.post(new WSVideoPreDownloadManager.1(this), 5, null, true);
    WSVideoPluginInstall localWSVideoPluginInstall = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall;
    if (localWSVideoPluginInstall != null)
    {
      localWSVideoPluginInstall.b();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall = null;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager$PreDownloadController;
    if (localObject == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader != null)
    {
      localObject = ((WSVideoPreDownloadManager.PreDownloadController)localObject).a(paramInt, paramBoolean);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(">>>>>>[WSVideoPreDownloadManager.java][requestPreDownload] START!! preDownloadList size:");
        localStringBuilder.append(((List)localObject).size());
        WSLog.f("WS_VIDEO_PRE_DL", localStringBuilder.toString());
        ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadSerialTask(this, (List)localObject), 5, null, true);
      }
    }
    else
    {
      WSLog.d("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][requestPreDownload] is off or mPreDownloader is null, return!");
    }
  }
  
  public void a(WSVideoPreDownloadManager.PreDownloadController paramPreDownloadController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager$PreDownloadController = paramPreDownloadController;
  }
  
  public void a(IWSPlayerPreDownloader.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader$Listener = paramListener;
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    d();
  }
  
  public boolean a(String paramString)
  {
    IWSPlayerPreDownloader localIWSPlayerPreDownloader = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader;
    boolean bool2 = false;
    if (localIWSPlayerPreDownloader == null) {
      return false;
    }
    Set localSet = this.jdField_a_of_type_JavaUtilSet;
    boolean bool1;
    if (!localIWSPlayerPreDownloader.a(a(paramString, 0)))
    {
      bool1 = bool2;
      if (localSet != null)
      {
        bool1 = bool2;
        if (!localSet.contains(paramString)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    IWSPlayerPreDownloader localIWSPlayerPreDownloader = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader;
    if (localIWSPlayerPreDownloader != null) {
      localIWSPlayerPreDownloader.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager
 * JD-Core Version:    0.7.0.1
 */