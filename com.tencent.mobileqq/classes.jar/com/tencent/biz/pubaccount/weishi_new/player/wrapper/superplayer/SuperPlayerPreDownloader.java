package com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer;

import android.util.SparseArray;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader.Listener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public class SuperPlayerPreDownloader
  implements IWSPlayerPreDownloader<Object, SuperPlayerVideoInfo>, ISPlayerPreDownloader.Listener
{
  private IWSPlayerPreDownloader.Listener a;
  private final ISPlayerPreDownloader b;
  private final SparseArray<AbsWSPlayerInfo<Object, SuperPlayerVideoInfo>> c = new SparseArray();
  
  public SuperPlayerPreDownloader(ISPlayerPreDownloader paramISPlayerPreDownloader)
  {
    this.b = paramISPlayerPreDownloader;
    paramISPlayerPreDownloader = this.b;
    if (paramISPlayerPreDownloader != null) {
      paramISPlayerPreDownloader.setOnPreDownloadListener(this);
    }
  }
  
  public void a()
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.b;
    if (localISPlayerPreDownloader == null) {
      return;
    }
    localISPlayerPreDownloader.stopAllPreDownload();
  }
  
  public void a(AbsWSPlayerInfo<Object, SuperPlayerVideoInfo> paramAbsWSPlayerInfo)
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.b;
    if (localISPlayerPreDownloader != null)
    {
      if (paramAbsWSPlayerInfo == null) {
        return;
      }
      int i = localISPlayerPreDownloader.startPreDownload((SuperPlayerVideoInfo)paramAbsWSPlayerInfo.b(), paramAbsWSPlayerInfo.d, 2000L);
      this.c.put(i, paramAbsWSPlayerInfo);
    }
  }
  
  public void a(IWSPlayerPreDownloader.Listener paramListener)
  {
    this.a = paramListener;
  }
  
  public void b()
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.b;
    if (localISPlayerPreDownloader == null) {
      return;
    }
    localISPlayerPreDownloader.destory();
  }
  
  public boolean b(AbsWSPlayerInfo<Object, SuperPlayerVideoInfo> paramAbsWSPlayerInfo)
  {
    return false;
  }
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject) {}
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString) {}
  
  public void onPrepareError(int paramInt)
  {
    IWSPlayerPreDownloader.Listener localListener = this.a;
    if (localListener == null) {
      return;
    }
    localListener.a("", 0, "");
  }
  
  public void onPrepareSuccess(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[SuperPlayerPreDownloader.java][onPrepareSuccess] taskId:");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.b("SuperPlayerPreDownloader", ((StringBuilder)localObject).toString());
    IWSPlayerPreDownloader.Listener localListener = this.a;
    if (localListener == null) {
      return;
    }
    localObject = (AbsWSPlayerInfo)this.c.get(paramInt);
    if (localObject != null) {
      localObject = ((AbsWSPlayerInfo)localObject).b;
    } else {
      localObject = "";
    }
    localListener.a((String)localObject, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer.SuperPlayerPreDownloader
 * JD-Core Version:    0.7.0.1
 */