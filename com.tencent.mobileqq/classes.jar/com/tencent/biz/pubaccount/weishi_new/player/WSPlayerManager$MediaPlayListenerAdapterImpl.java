package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.report.IWSPlayerReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSPlayerManager$MediaPlayListenerAdapterImpl
  extends WSPlayerListenerAdapter
{
  private WSPlayerManager$MediaPlayListenerAdapterImpl(WSPlayerManager paramWSPlayerManager) {}
  
  private void a(WSPlayerParam paramWSPlayerParam)
  {
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_ENDOF_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (c()))
    {
      Object localObject = this.a;
      localObject = WSPlayerManager.a((WSPlayerManager)localObject, WSPlayerManager.a((WSPlayerManager)localObject));
      if ((localObject != null) && (!((WSPlayerWrapper)localObject).p())) {
        WSPlayerManager.a(this.a).d.l();
      }
    }
    WSPlayerManager.h(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.5(this, paramWSPlayerParam));
  }
  
  private void b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[WSPlayerManager.java][onDownloadFinish] 预播任务 prePlayTitle:");
    Object localObject2 = this.a;
    ((StringBuilder)localObject1).append(WSPlayerManager.b((WSPlayerManager)localObject2, WSPlayerManager.a((WSPlayerManager)localObject2)));
    WSLog.e("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject1).toString());
    localObject1 = WSPlayerManager.a(this.a);
    localObject2 = WSPlayerManager.b(this.a);
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        return;
      }
      int i = ((WSPlayerParam)localObject1).f;
      boolean bool;
      if (i > WSPlayerManager.c(this.a)) {
        bool = true;
      } else {
        bool = false;
      }
      ((WSVideoPreDownloadManager)localObject2).a(i, bool);
      WSPlayerManager.a(this.a, i);
    }
  }
  
  private void b(WSPlayerParam paramWSPlayerParam)
  {
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_START_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (c()))
    {
      Object localObject = this.a;
      localObject = WSPlayerManager.a((WSPlayerManager)localObject, WSPlayerManager.a((WSPlayerManager)localObject));
      if ((localObject != null) && (!((WSPlayerWrapper)localObject).p())) {
        WSPlayerManager.a(this.a).d.k();
      }
    }
    WSPlayerManager.h(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.6(this, paramWSPlayerParam));
  }
  
  private boolean c()
  {
    WSPlayerParam localWSPlayerParam = WSPlayerManager.a(this.a);
    if (localWSPlayerParam == null) {
      return false;
    }
    return localWSPlayerParam.h;
  }
  
  private void d()
  {
    Object localObject = this.a;
    localObject = WSPlayerManager.a((WSPlayerManager)localObject, WSPlayerManager.a((WSPlayerManager)localObject));
    if (localObject != null) {
      ((WSPlayerWrapper)localObject).k();
    }
    WSPlayerManager.h(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.1(this));
    b();
  }
  
  private boolean e()
  {
    if (!WSPlayerManager.k(this.a)) {
      return false;
    }
    WSPlayerManager.h(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.3(this));
    return true;
  }
  
  void a()
  {
    WSPlayerManager.h(this.a).removeMessages(-3);
    WSPlayerManager.h(this.a).removeMessages(-4);
    if (WSPlayerManager.i(this.a))
    {
      this.a.b();
      return;
    }
    WSPlayerManager.b(this.a, true);
  }
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper)
  {
    super.a(paramWSPlayerWrapper);
    if (!WSPlayerManager.a(this.a, paramWSPlayerWrapper))
    {
      paramWSPlayerWrapper = new StringBuilder();
      paramWSPlayerWrapper.append("[WSPlayerManager.java][onCompletion] checkIsPlayerPlaying false! playingVideoUrl:");
      localWSPlayerManager = this.a;
      paramWSPlayerWrapper.append(WSPlayerManager.d(localWSPlayerManager, WSPlayerManager.d(localWSPlayerManager)));
      WSLog.d("WS_VIDEO_PLAYER", paramWSPlayerWrapper.toString());
      return;
    }
    paramWSPlayerWrapper = new StringBuilder();
    paramWSPlayerWrapper.append("[WSPlayerManager.java][onCompletion] 播放状态回调 playingVideoUrl:");
    WSPlayerManager localWSPlayerManager = this.a;
    paramWSPlayerWrapper.append(WSPlayerManager.d(localWSPlayerManager, WSPlayerManager.d(localWSPlayerManager)));
    WSLog.e("WS_VIDEO_PLAYER", paramWSPlayerWrapper.toString());
    if (e())
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] checkPlayerLoop:true!");
      return;
    }
    WSPlayerManager.h(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.2(this));
    WSPlayerManager.c(this.a, true);
  }
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper, Object paramObject)
  {
    paramObject = WSPlayerManager.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerManager.java][onVideoPrepared] 视频准备完成状态! mIsOpenedVideo:");
    localStringBuilder.append(WSPlayerManager.e(this.a));
    localStringBuilder.append(", playingTitle:");
    localStringBuilder.append(WSPlayerManager.b(this.a, paramObject));
    WSLog.e("WS_VIDEO_PLAYER", localStringBuilder.toString());
    if (!WSPlayerManager.a(this.a, paramWSPlayerWrapper))
    {
      WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onVideoPrepared] prePlayVideo prepared!");
      paramObject = this.a;
      if ((WSPlayerManager.a(paramObject, WSPlayerManager.a(paramObject)) == paramWSPlayerWrapper) && (c())) {
        d();
      }
      return;
    }
    if (!WSPlayerManager.e(this.a))
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] mIsOpenedVideo is false. return!");
      return;
    }
    WSPlayerManager.a(this.a, false);
    if (WSPlayerManager.c(this.a, paramObject) != null) {
      WSPlayerManager.c(this.a, paramObject).a(WSPlayerManager.a(this.a, paramObject));
    }
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] startVideoAfterPrepared!");
    a();
  }
  
  public boolean a(WSPlayerWrapper paramWSPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    super.a(paramWSPlayerWrapper, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("model : ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" what : ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" extra : ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("detailInfo : ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" obj : ");
    if (paramObject != null) {
      paramObject = paramObject.toString();
    } else {
      paramObject = "";
    }
    localStringBuilder.append(paramObject);
    String str = localStringBuilder.toString();
    if (!WSPlayerManager.a(this.a, paramWSPlayerWrapper))
    {
      paramString = this.a;
      if ((WSPlayerManager.a(paramString, WSPlayerManager.a(paramString)) == paramWSPlayerWrapper) && (paramWSPlayerWrapper != null))
      {
        paramWSPlayerWrapper.k();
        WSPlayerManager.a(this.a).h = false;
      }
      return false;
    }
    paramObject = WSPlayerManager.d(this.a);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerManager.java][onError] 播放状态回调 errorStr:");
    localStringBuilder.append(str);
    localStringBuilder.append(", playingVideoUrl:");
    if (paramObject == null) {
      paramWSPlayerWrapper = "playingVideoParam is null.";
    } else if (paramObject.c != null) {
      paramWSPlayerWrapper = paramObject.c.e;
    } else {
      paramWSPlayerWrapper = "videoInfo is null.";
    }
    localStringBuilder.append(paramWSPlayerWrapper);
    WSLog.d("WS_VIDEO_PLAYER", localStringBuilder.toString());
    WSPlayerManager.h(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.4(this, paramInt1, paramInt2, paramInt3, paramObject));
    paramWSPlayerWrapper = WSPlayerManager.c(this.a, paramObject);
    if (paramWSPlayerWrapper != null) {
      paramWSPlayerWrapper.a(paramInt1, paramInt2, paramString);
    }
    return false;
  }
  
  public boolean a(WSPlayerWrapper paramWSPlayerWrapper, int paramInt, Object paramObject)
  {
    super.a(paramWSPlayerWrapper, paramInt, paramObject);
    if ((paramInt != 42) && (!WSPlayerManager.a(this.a, paramWSPlayerWrapper)))
    {
      if (paramInt == 39)
      {
        if ((WSPlayerManager.a(this.a) != null) && (c())) {
          WSPlayerManager.d(this.a, true);
        }
        paramWSPlayerWrapper = new StringBuilder();
        paramWSPlayerWrapper.append("[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED mIsPrePlayHWDecodeFailed:");
        paramWSPlayerWrapper.append(WSPlayerManager.g(this.a));
        WSLog.d("WS_VIDEO_PLAYER", paramWSPlayerWrapper.toString());
      }
      return false;
    }
    paramWSPlayerWrapper = WSPlayerManager.d(this.a);
    if (paramInt != 112)
    {
      if (paramInt == 113) {
        a(paramWSPlayerWrapper);
      }
    }
    else {
      b(paramWSPlayerWrapper);
    }
    paramWSPlayerWrapper = WSPlayerManager.c(this.a, paramWSPlayerWrapper);
    if (paramWSPlayerWrapper != null) {
      paramWSPlayerWrapper.a(paramInt, paramObject);
    }
    return false;
  }
  
  public void b(WSPlayerWrapper paramWSPlayerWrapper)
  {
    super.b(paramWSPlayerWrapper);
    WSPlayerManager.h(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */