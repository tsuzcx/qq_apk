package com.tencent.livesdk.livesdkplayer;

import com.tencent.thumbplayer.utils.TPLogUtil;

class LiveSdkPlayerHelper$5
  implements IMediaPlayerMgr.OnErrorListener
{
  LiveSdkPlayerHelper$5(LiveSdkPlayerHelper paramLiveSdkPlayerHelper) {}
  
  public void onError(IMediaPlayerMgr paramIMediaPlayerMgr, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    TPLogUtil.e("LiveSdkPlayerHelper", "onError: errorCode" + paramInt2 + ", errorType " + paramInt1);
    if ((paramInt1 == 1103) || (paramInt1 == 1102) || (paramInt1 == 2001) || (paramInt1 == 1101))
    {
      if (LiveSdkPlayerHelper.access$400(this.this$0) != null) {
        LiveSdkPlayerHelper.access$400(this.this$0).onNetworkAnomaly();
      }
      if (LiveSdkPlayerHelper.access$600(this.this$0) < 3)
      {
        TPLogUtil.i("LiveSdkPlayerHelper", "onError :  errorType = " + paramInt1 + ", errorCode = " + paramInt2 + ", 网络原因，尝试重试策略：当前已重试次数" + LiveSdkPlayerHelper.access$600(this.this$0));
        this.this$0.stopPlay();
        this.this$0.openPlay();
        LiveSdkPlayerHelper.access$608(this.this$0);
      }
    }
    while (LiveSdkPlayerHelper.access$400(this.this$0) == null) {
      return;
    }
    LiveSdkPlayerHelper.access$400(this.this$0).onError(paramIMediaPlayerMgr, paramInt2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.5
 * JD-Core Version:    0.7.0.1
 */