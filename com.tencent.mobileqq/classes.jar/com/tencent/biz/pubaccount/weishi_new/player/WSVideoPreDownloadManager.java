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
  private Context a;
  private WSVideoPluginInstall b;
  private WSVideoPreDownloadManager.PreDownloadController c;
  private IWSPlayerPreDownloader.Listener d;
  private IWSPlayerPreDownloader e;
  private IWSPlayerFactory f;
  private String g;
  private Set<String> h = null;
  private List<WSVideoPreDownloadManager.VideoPreDownloadParam> i = null;
  
  public WSVideoPreDownloadManager(Context paramContext)
  {
    this.a = paramContext;
    this.b = new WSVideoPluginInstall();
    this.b.a(this);
    if (!this.b.b())
    {
      this.b.a();
      return;
    }
    c();
    d();
  }
  
  private AbsWSPlayerInfo a(String paramString, int paramInt)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return null;
    }
    localObject = ((IWSPlayerFactory)localObject).a();
    ((AbsWSPlayerInfo)localObject).a(WSPlayerUtils.b(paramString), paramString, 101, paramInt);
    return localObject;
  }
  
  private void a(WSVideoPreDownloadManager.VideoPreDownloadParam paramVideoPreDownloadParam)
  {
    if (paramVideoPreDownloadParam != null)
    {
      if (TextUtils.isEmpty(paramVideoPreDownloadParam.b)) {
        return;
      }
      IWSPlayerPreDownloader localIWSPlayerPreDownloader = this.e;
      if (localIWSPlayerPreDownloader == null)
      {
        WSLog.d("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][innerDoPreDownload] start preload ERROR preDownloader == null!");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSVideoPreDownloadManager.java][innerDoPreDownload] START DOWNLOAD!! duration:");
      localStringBuilder.append(paramVideoPreDownloadParam.d);
      localStringBuilder.append(", title:");
      localStringBuilder.append(paramVideoPreDownloadParam.c);
      localStringBuilder.append(", url:");
      localStringBuilder.append(paramVideoPreDownloadParam.b);
      WSLog.e("WS_VIDEO_PRE_DL", localStringBuilder.toString());
      if (!TextUtils.isEmpty(paramVideoPreDownloadParam.b)) {
        localIWSPlayerPreDownloader.a(a(paramVideoPreDownloadParam.b, paramVideoPreDownloadParam.d));
      }
    }
  }
  
  private void c()
  {
    this.f = WSPlayerWrapHelper.a().b();
    this.e = this.f.a(BaseApplicationImpl.getContext());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSVideoPreDownloadManager.java][initCacheMgr] mPreDownloader=");
    ((StringBuilder)localObject).append(this.e);
    WSLog.e("WS_VIDEO_PRE_DL", ((StringBuilder)localObject).toString());
    localObject = this.e;
  }
  
  private void d()
  {
    if (this.e == null) {
      return;
    }
    this.h = new HashSet();
    this.i = new ArrayList();
    WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][initSerialPreDownload] setPreloadCallback");
    this.e.a(new WSVideoPreDownloadManager.2(this));
  }
  
  private void e()
  {
    WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][releaseSerialPreDownload]");
    IWSPlayerPreDownloader localIWSPlayerPreDownloader = this.e;
    if (localIWSPlayerPreDownloader != null)
    {
      localIWSPlayerPreDownloader.a(null);
      localIWSPlayerPreDownloader.b();
    }
  }
  
  private void f()
  {
    List localList = this.i;
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
        this.g = localVideoPreDownloadParam.b;
        if (a(this.g))
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("[WSVideoPreDownloadManager.java][preDownloadNotAlreadyVideo] checkIsCached is TRUE! videoTitle:");
          localStringBuilder1.append(localVideoPreDownloadParam.c);
          WSLog.e("WS_VIDEO_PRE_DL", localStringBuilder1.toString());
          this.g = null;
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
    WSVideoPluginInstall localWSVideoPluginInstall = this.b;
    if (localWSVideoPluginInstall != null)
    {
      localWSVideoPluginInstall.c();
      this.b = null;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    if (this.e != null)
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
    this.c = paramPreDownloadController;
  }
  
  public void a(IWSPlayerPreDownloader.Listener paramListener)
  {
    this.d = paramListener;
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    d();
  }
  
  public boolean a(String paramString)
  {
    IWSPlayerPreDownloader localIWSPlayerPreDownloader = this.e;
    boolean bool2 = false;
    if (localIWSPlayerPreDownloader == null) {
      return false;
    }
    Set localSet = this.h;
    boolean bool1;
    if (!localIWSPlayerPreDownloader.b(a(paramString, 0)))
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
    IWSPlayerPreDownloader localIWSPlayerPreDownloader = this.e;
    if (localIWSPlayerPreDownloader != null) {
      localIWSPlayerPreDownloader.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager
 * JD-Core Version:    0.7.0.1
 */