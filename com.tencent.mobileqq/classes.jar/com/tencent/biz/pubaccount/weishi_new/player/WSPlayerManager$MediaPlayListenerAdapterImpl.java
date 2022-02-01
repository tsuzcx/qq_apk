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
      Object localObject = this.a;
      localObject = WSPlayerManager.a((WSPlayerManager)localObject, WSPlayerManager.a((WSPlayerManager)localObject));
      if ((localObject != null) && (!((WSPlayerWrapper)localObject).e())) {
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[WSPlayerManager.java][onDownloadFinish] 预播任务 prePlayTitle:");
    Object localObject2 = this.a;
    ((StringBuilder)localObject1).append(WSPlayerManager.a((WSPlayerManager)localObject2, WSPlayerManager.a((WSPlayerManager)localObject2)));
    WSLog.e("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject1).toString());
    localObject1 = WSPlayerManager.a(this.a);
    localObject2 = WSPlayerManager.a(this.a);
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        return;
      }
      int i = ((WSPlayerParam)localObject1).b;
      boolean bool;
      if (i > WSPlayerManager.a(this.a)) {
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
    if ((WSPlayerManager.a(this.a) != null) && (a()))
    {
      Object localObject = this.a;
      localObject = WSPlayerManager.a((WSPlayerManager)localObject, WSPlayerManager.a((WSPlayerManager)localObject));
      if ((localObject != null) && (!((WSPlayerWrapper)localObject).e())) {
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
    Object localObject = this.a;
    localObject = WSPlayerManager.a((WSPlayerManager)localObject, WSPlayerManager.a((WSPlayerManager)localObject));
    if (localObject != null) {
      ((WSPlayerWrapper)localObject).e();
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
      paramWSPlayerWrapper = new StringBuilder();
      paramWSPlayerWrapper.append("[WSPlayerManager.java][onCompletion] checkIsPlayerPlaying false! playingVideoUrl:");
      localWSPlayerManager = this.a;
      paramWSPlayerWrapper.append(WSPlayerManager.b(localWSPlayerManager, WSPlayerManager.b(localWSPlayerManager)));
      WSLog.d("WS_VIDEO_PLAYER", paramWSPlayerWrapper.toString());
      return;
    }
    paramWSPlayerWrapper = new StringBuilder();
    paramWSPlayerWrapper.append("[WSPlayerManager.java][onCompletion] 播放状态回调 playingVideoUrl:");
    WSPlayerManager localWSPlayerManager = this.a;
    paramWSPlayerWrapper.append(WSPlayerManager.b(localWSPlayerManager, WSPlayerManager.b(localWSPlayerManager)));
    WSLog.e("WS_VIDEO_PLAYER", paramWSPlayerWrapper.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerManager.java][onVideoPrepared] 视频准备完成状态! mIsOpenedVideo:");
    localStringBuilder.append(WSPlayerManager.a(this.a));
    localStringBuilder.append(", playingTitle:");
    localStringBuilder.append(WSPlayerManager.a(this.a, paramObject));
    WSLog.e("WS_VIDEO_PLAYER", localStringBuilder.toString());
    if (!WSPlayerManager.a(this.a, paramWSPlayerWrapper))
    {
      WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][onVideoPrepared] prePlayVideo prepared!");
      paramObject = this.a;
      if ((WSPlayerManager.a(paramObject, WSPlayerManager.a(paramObject)) == paramWSPlayerWrapper) && (a())) {
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
    if (!WSPlayerManager.a(this.a, paramWSPlayerWrapper))
    {
      WSPlayerManager localWSPlayerManager = this.a;
      if (paramWSPlayerWrapper == WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.a(localWSPlayerManager))) {
        WSPlayerManager.a(this.a, paramTVK_NetVideoInfo);
      }
    }
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
        paramWSPlayerWrapper.e();
        WSPlayerManager.a(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramObject = WSPlayerManager.b(this.a);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerManager.java][onError] 播放状态回调 errorStr:");
    localStringBuilder.append(str);
    localStringBuilder.append(", playingVideoUrl:");
    if (paramObject == null) {
      paramWSPlayerWrapper = "playingVideoParam is null.";
    } else if (paramObject.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo != null) {
      paramWSPlayerWrapper = paramObject.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.b;
    } else {
      paramWSPlayerWrapper = "videoInfo is null.";
    }
    localStringBuilder.append(paramWSPlayerWrapper);
    WSLog.d("WS_VIDEO_PLAYER", localStringBuilder.toString());
    WSPlayerManager.a(this.a).post(new WSPlayerManager.MediaPlayListenerAdapterImpl.4(this, paramInt1, paramInt2, paramInt3, paramObject));
    paramWSPlayerWrapper = WSPlayerManager.a(this.a, paramObject);
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
        if ((WSPlayerManager.a(this.a) != null) && (a())) {
          WSPlayerManager.d(this.a, true);
        }
        paramWSPlayerWrapper = new StringBuilder();
        paramWSPlayerWrapper.append("[WSPlayerManager.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED mIsPrePlayHWDecodeFailed:");
        paramWSPlayerWrapper.append(WSPlayerManager.c(this.a));
        WSLog.d("WS_VIDEO_PLAYER", paramWSPlayerWrapper.toString());
      }
      return false;
    }
    paramWSPlayerWrapper = WSPlayerManager.b(this.a);
    if (paramInt != 112)
    {
      if (paramInt == 113) {
        a(paramWSPlayerWrapper);
      }
    }
    else {
      b(paramWSPlayerWrapper);
    }
    paramWSPlayerWrapper = WSPlayerManager.a(this.a, paramWSPlayerWrapper);
    if (paramWSPlayerWrapper != null) {
      paramWSPlayerWrapper.a(paramInt, paramObject);
    }
    return false;
  }
  
  public void b(WSPlayerWrapper paramWSPlayerWrapper)
  {
    super.b(paramWSPlayerWrapper);
    WSPlayerManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
  
  public void c(WSPlayerWrapper paramWSPlayerWrapper)
  {
    super.c(paramWSPlayerWrapper);
    if (!WSPlayerManager.a(this.a, paramWSPlayerWrapper))
    {
      WSPlayerManager localWSPlayerManager = this.a;
      if (paramWSPlayerWrapper == WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.a(localWSPlayerManager)))
      {
        paramWSPlayerWrapper = new StringBuilder();
        paramWSPlayerWrapper.append("[WSPlayerManager.java][onDownloadFinish] 预播任务 prePlayTitle:");
        localWSPlayerManager = this.a;
        paramWSPlayerWrapper.append(WSPlayerManager.a(localWSPlayerManager, WSPlayerManager.a(localWSPlayerManager)));
        WSLog.e("WS_VIDEO_PRE_PLAY", paramWSPlayerWrapper.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */