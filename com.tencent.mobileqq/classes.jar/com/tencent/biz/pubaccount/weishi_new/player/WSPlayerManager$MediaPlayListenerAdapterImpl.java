package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.report.IWSPlayerReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;

class WSPlayerManager$MediaPlayListenerAdapterImpl
  extends WSPlayerListenerAdapter
{
  private WSPlayerManager$MediaPlayListenerAdapterImpl(WSPlayerManager paramWSPlayerManager) {}
  
  private void a(WSPlayerParam paramWSPlayerParam)
  {
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_ENDOF_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (a()))
    {
      WSPlayerWrapper localWSPlayerWrapper = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
      if ((localWSPlayerWrapper != null) && (!localWSPlayerWrapper.e())) {
        WSPlayerManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.f();
      }
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.5(this, paramWSPlayerParam));
  }
  
  private boolean a()
  {
    WSPlayerParam localWSPlayerParam = WSPlayerManager.a(this.a);
    if (localWSPlayerParam == null) {
      return false;
    }
    return localWSPlayerParam.jdField_a_of_type_Boolean;
  }
  
  private void b()
  {
    WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onDownloadFinish] 预播任务 prePlayTitle:" + WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)));
    WSPlayerParam localWSPlayerParam = WSPlayerManager.a(this.a);
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = WSPlayerManager.a(this.a);
    if ((localWSVideoPreDownloadManager == null) || (localWSPlayerParam == null)) {
      return;
    }
    int i = localWSPlayerParam.b;
    if (i > WSPlayerManager.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      localWSVideoPreDownloadManager.a(i, bool);
      WSPlayerManager.a(this.a, i);
      return;
    }
  }
  
  private void b(WSPlayerParam paramWSPlayerParam)
  {
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_START_BUFFERING");
    if ((WSPlayerManager.a(this.a) != null) && (a()))
    {
      WSPlayerWrapper localWSPlayerWrapper = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
      if ((localWSPlayerWrapper != null) && (!localWSPlayerWrapper.e())) {
        WSPlayerManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.e();
      }
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.6(this, paramWSPlayerParam));
  }
  
  private boolean b()
  {
    if (!WSPlayerManager.e(this.a)) {
      return false;
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.3(this));
    return true;
  }
  
  private void c()
  {
    WSPlayerWrapper localWSPlayerWrapper = WSPlayerManager.a(this.a, WSPlayerManager.a(this.a));
    if (localWSPlayerWrapper != null) {
      localWSPlayerWrapper.e();
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.1(this));
    b();
  }
  
  void a()
  {
    WSPlayerManager.a(this.a).removeMessages(-3);
    WSPlayerManager.a(this.a).removeMessages(-4);
    if (WSPlayerManager.d(this.a))
    {
      this.a.a();
      return;
    }
    WSPlayerManager.b(this.a, true);
  }
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper)
  {
    super.a(paramWSPlayerWrapper);
    if (!WSPlayerManager.a(this.a, paramWSPlayerWrapper))
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] checkIsPlayerPlaying false! playingVideoUrl:" + WSPlayerManager.b(this.a, WSPlayerManager.b(this.a)));
      return;
    }
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] 播放状态回调 playingVideoUrl:" + WSPlayerManager.b(this.a, WSPlayerManager.b(this.a)));
    if (b())
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onCompletion] checkPlayerLoop:true!");
      return;
    }
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.2(this));
    WSPlayerManager.c(this.a, true);
  }
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper, Object paramObject)
  {
    paramObject = WSPlayerManager.b(this.a);
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] 视频准备完成状态! mIsOpenedVideo:" + WSPlayerManager.a(this.a) + ", playingTitle:" + WSPlayerManager.a(this.a, paramObject));
    if (!WSPlayerManager.a(this.a, paramWSPlayerWrapper))
    {
      WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onVideoPrepared] prePlayVideo prepared!");
      if ((WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)) == paramWSPlayerWrapper) && (a())) {
        c();
      }
      return;
    }
    if (!WSPlayerManager.a(this.a))
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] mIsOpenedVideo is false. return!");
      return;
    }
    WSPlayerManager.a(this.a, false);
    if (WSPlayerManager.a(this.a, paramObject) != null) {
      WSPlayerManager.a(this.a, paramObject).a(WSPlayerManager.a(this.a, paramObject));
    }
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onVideoPrepared] startVideoAfterPrepared!");
    a();
  }
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, WSPlayerWrapper paramWSPlayerWrapper)
  {
    super.a(paramTVK_NetVideoInfo, paramWSPlayerWrapper);
    if ((!WSPlayerManager.a(this.a, paramWSPlayerWrapper)) && (paramWSPlayerWrapper == WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)))) {
      WSPlayerManager.a(this.a, paramTVK_NetVideoInfo);
    }
  }
  
  public boolean a(WSPlayerWrapper paramWSPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    super.a(paramWSPlayerWrapper, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    Object localObject = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      localObject = paramObject;
      if (WSPlayerManager.a(this.a, paramWSPlayerWrapper)) {
        break;
      }
      if ((WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)) == paramWSPlayerWrapper) && (paramWSPlayerWrapper != null))
      {
        paramWSPlayerWrapper.e();
        WSPlayerManager.a(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramObject = WSPlayerManager.b(this.a);
    localObject = new StringBuilder().append("[WSPlayerManager.java][onError] 播放状态回调 errorStr:").append((String)localObject).append(", playingVideoUrl:");
    if (paramObject == null) {
      paramWSPlayerWrapper = "playingVideoParam is null.";
    }
    for (;;)
    {
      WSLog.d("WS_VIDEO_PLAYER", paramWSPlayerWrapper);
      WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.4(this, paramInt1, paramInt2, paramInt3, paramObject));
      paramWSPlayerWrapper = WSPlayerManager.a(this.a, paramObject);
      if (paramWSPlayerWrapper == null) {
        break;
      }
      paramWSPlayerWrapper.a(paramInt1, paramInt2, paramString);
      return false;
      if (paramObject.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo != null) {
        paramWSPlayerWrapper = paramObject.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.b;
      } else {
        paramWSPlayerWrapper = "videoInfo is null.";
      }
    }
  }
  
  public boolean a(WSPlayerWrapper paramWSPlayerWrapper, int paramInt, Object paramObject)
  {
    super.a(paramWSPlayerWrapper, paramInt, paramObject);
    if ((paramInt != 42) && (!WSPlayerManager.a(this.a, paramWSPlayerWrapper)))
    {
      if (paramInt == 39)
      {
        if ((WSPlayerManager.a(this.a) != null) && (a())) {
          WSPlayerManager.d(this.a, true);
        }
        WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED mIsPrePlayHWDecodeFailed:" + WSPlayerManager.c(this.a));
      }
      return false;
    }
    paramWSPlayerWrapper = WSPlayerManager.b(this.a);
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramWSPlayerWrapper = WSPlayerManager.a(this.a, paramWSPlayerWrapper);
      if (paramWSPlayerWrapper == null) {
        break;
      }
      paramWSPlayerWrapper.a(paramInt, paramObject);
      return false;
      b(paramWSPlayerWrapper);
      continue;
      a(paramWSPlayerWrapper);
    }
  }
  
  public void b(WSPlayerWrapper paramWSPlayerWrapper)
  {
    super.b(paramWSPlayerWrapper);
    WSPlayerManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
  
  public void c(WSPlayerWrapper paramWSPlayerWrapper)
  {
    super.c(paramWSPlayerWrapper);
    if ((!WSPlayerManager.a(this.a, paramWSPlayerWrapper)) && (paramWSPlayerWrapper == WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)))) {
      WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onDownloadFinish] 预播任务 prePlayTitle:" + WSPlayerManager.a(this.a, WSPlayerManager.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */