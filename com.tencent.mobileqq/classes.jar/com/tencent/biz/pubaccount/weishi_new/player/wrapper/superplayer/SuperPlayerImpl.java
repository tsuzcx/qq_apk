package com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayer;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerListener;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSVideoView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.seamless.SPSeamlessHelper;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import java.util.Properties;

public class SuperPlayerImpl
  implements IWSPlayer<Object, SuperPlayerVideoInfo>, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  private ISuperPlayer a;
  private IWSVideoView b;
  private IWSPlayerListener c;
  
  public SuperPlayerImpl(ISuperPlayer paramISuperPlayer)
  {
    this.a = paramISuperPlayer;
  }
  
  private int c(int paramInt)
  {
    int i = 1;
    if (paramInt != 1)
    {
      i = 2;
      if (paramInt != 2)
      {
        i = 3;
        if (paramInt != 3) {
          return 0;
        }
      }
    }
    return i;
  }
  
  private int d(int paramInt)
  {
    if (paramInt != 112)
    {
      if (paramInt != 113) {
        return paramInt;
      }
      return 113;
    }
    return 112;
  }
  
  public void a()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      localISuperPlayer.start();
    }
  }
  
  public void a(int paramInt)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      localISuperPlayer.setXYaxis(c(paramInt));
    }
  }
  
  public void a(Context paramContext, long paramLong, int paramInt, AbsWSPlayerInfo<Object, SuperPlayerVideoInfo> paramAbsWSPlayerInfo)
  {
    if ((this.a != null) && (paramAbsWSPlayerInfo != null))
    {
      SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain(112);
      localSuperPlayerOption.enableCodecReuse = WSExpABTestManager.a().i();
      this.a.openMediaPlayer(paramContext, (SuperPlayerVideoInfo)paramAbsWSPlayerInfo.a(), paramLong, localSuperPlayerOption);
    }
  }
  
  public void a(IWSPlayerListener paramIWSPlayerListener)
  {
    this.c = paramIWSPlayerListener;
    paramIWSPlayerListener = this.a;
    if (paramIWSPlayerListener != null)
    {
      paramIWSPlayerListener.setOnVideoPreparedListener(this);
      this.a.setOnCompletionListener(this);
      this.a.setOnErrorListener(this);
      this.a.setOnInfoListener(this);
      this.a.setOnCaptureImageListener(this);
      this.a.setOnSeekCompleteListener(this);
    }
  }
  
  public void a(IWSVideoView paramIWSVideoView)
  {
    this.b = paramIWSVideoView;
    if ((this.a != null) && (paramIWSVideoView != null))
    {
      paramIWSVideoView = paramIWSVideoView.a();
      if ((paramIWSVideoView instanceof ISPlayerVideoView)) {
        this.a.updatePlayerVideoView((ISPlayerVideoView)paramIWSVideoView);
      }
    }
  }
  
  public void a(IWSVideoView paramIWSVideoView, ViewGroup paramViewGroup)
  {
    if (paramIWSVideoView != null)
    {
      paramIWSVideoView = paramIWSVideoView.a();
      if ((paramIWSVideoView instanceof ISPlayerVideoView)) {
        SPSeamlessHelper.get().attachVideoView(paramViewGroup, (ISPlayerVideoView)paramIWSVideoView, new ViewGroup.LayoutParams(-1, -1));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      localISuperPlayer.setLoopback(paramBoolean);
    }
  }
  
  public void b()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      localISuperPlayer.pause();
    }
  }
  
  public void b(int paramInt)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      localISuperPlayer.seekTo(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      localISuperPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void c()
  {
    if (this.a != null)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = ((IWSVideoView)localObject).a();
        if ((localObject instanceof ISPlayerVideoView))
        {
          this.a.reset();
          this.a.updatePlayerVideoView((ISPlayerVideoView)localObject);
        }
      }
    }
  }
  
  public void d()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null)
    {
      localISuperPlayer.stop();
      this.a.release();
    }
  }
  
  public void e()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      localISuperPlayer.pauseDownload();
    }
  }
  
  public void f()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      localISuperPlayer.resumeDownload();
    }
  }
  
  public boolean g()
  {
    ISuperPlayer localISuperPlayer = this.a;
    return (localISuperPlayer != null) && (localISuperPlayer.isPlaying());
  }
  
  public boolean h()
  {
    ISuperPlayer localISuperPlayer = this.a;
    return (localISuperPlayer != null) && (localISuperPlayer.isPausing());
  }
  
  public long i()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getDurationMs();
    }
    return 0L;
  }
  
  public long j()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public int k()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public int l()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public String m()
  {
    ISuperPlayer localISuperPlayer = this.a;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getStreamDumpInfo();
    }
    return "";
  }
  
  public Properties n()
  {
    return null;
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    paramISuperPlayer = this.c;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a(this, paramInt1, paramInt2);
    }
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    paramISuperPlayer = this.c;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a(this, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.c;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.b(this);
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = this.c;
    if (paramISuperPlayer != null) {
      return paramISuperPlayer.a(this, paramInt1, paramInt2, paramInt3, paramString);
    }
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("[SuperPlayerImpl.java][onInfo] what:");
    paramISuperPlayer.append(paramInt);
    paramISuperPlayer.append(", arg1:");
    paramISuperPlayer.append(paramLong1);
    paramISuperPlayer.append(", arg2:");
    paramISuperPlayer.append(paramLong2);
    paramISuperPlayer.append(", extra:");
    paramISuperPlayer.append(paramObject);
    WSLog.e("WS_VIDEO_SuperPlayerImpl", paramISuperPlayer.toString());
    if (paramInt != 201)
    {
      if (paramInt != 204)
      {
        if ((paramInt == 207) && ((paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo)))
        {
          paramISuperPlayer = (TPPlayerMsg.TPDownLoadProgressInfo)paramObject;
          paramObject = this.c;
          if (paramObject != null) {
            paramObject.a(paramISuperPlayer.downloadSpeedKBps, paramISuperPlayer.totalFileSize, paramISuperPlayer.extraInfo);
          }
          return true;
        }
      }
      else if ((paramObject instanceof TPPlayerMsg.TPCDNURLInfo))
      {
        paramISuperPlayer = (TPPlayerMsg.TPCDNURLInfo)paramObject;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[SuperPlayerImpl.java][onInfo] TPCDNURLInfo url:");
        localStringBuilder.append(paramISuperPlayer.url);
        localStringBuilder.append(", uIp:");
        localStringBuilder.append(paramISuperPlayer.uIp);
        localStringBuilder.append(", cdnIp:");
        localStringBuilder.append(paramISuperPlayer.cdnIp);
        localStringBuilder.append(", errorStr:");
        localStringBuilder.append(paramISuperPlayer.errorStr);
        WSLog.d("WS_VIDEO_SuperPlayerImpl", localStringBuilder.toString());
      }
    }
    else {
      WSLog.e("WS_VIDEO_SuperPlayerImpl", "[SuperPlayerImpl.java][onInfo] PLAYER_INFO_ALL_DOWNLOAD_FINISH!");
    }
    paramISuperPlayer = this.c;
    if (paramISuperPlayer != null) {
      return paramISuperPlayer.a(this, d(paramInt), paramObject);
    }
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.c;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.c(this);
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.c;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer.SuperPlayerImpl
 * JD-Core Version:    0.7.0.1
 */