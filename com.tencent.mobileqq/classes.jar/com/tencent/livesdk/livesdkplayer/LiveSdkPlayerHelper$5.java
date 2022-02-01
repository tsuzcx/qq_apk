package com.tencent.livesdk.livesdkplayer;

import com.tencent.thumbplayer.utils.TPLogUtil;

class LiveSdkPlayerHelper$5
  implements IMediaPlayerMgr.OnErrorListener
{
  LiveSdkPlayerHelper$5(LiveSdkPlayerHelper paramLiveSdkPlayerHelper) {}
  
  public void onError(IMediaPlayerMgr paramIMediaPlayerMgr, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError: errorCode");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", errorType ");
    localStringBuilder.append(paramInt1);
    TPLogUtil.e("LiveSdkPlayerHelper", localStringBuilder.toString());
    if ((paramInt1 == 1103) || (paramInt1 == 1102) || (paramInt1 == 2001) || (paramInt1 == 1101))
    {
      if (LiveSdkPlayerHelper.access$400(this.this$0) != null) {
        LiveSdkPlayerHelper.access$400(this.this$0).onNetworkAnomaly();
      }
      if (LiveSdkPlayerHelper.access$1000(this.this$0) < 3)
      {
        paramIMediaPlayerMgr = new StringBuilder();
        paramIMediaPlayerMgr.append("onError :  errorType = ");
        paramIMediaPlayerMgr.append(paramInt1);
        paramIMediaPlayerMgr.append(", errorCode = ");
        paramIMediaPlayerMgr.append(paramInt2);
        paramIMediaPlayerMgr.append(", 网络原因，尝试重试策略：当前已重试次数");
        paramIMediaPlayerMgr.append(LiveSdkPlayerHelper.access$1000(this.this$0));
        TPLogUtil.e("LiveSdkPlayerHelper", paramIMediaPlayerMgr.toString());
        try
        {
          this.this$0.reset();
          this.this$0.stopPlay();
          this.this$0.openPlay();
        }
        catch (Exception paramIMediaPlayerMgr)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("retry exception:");
          localStringBuilder.append(paramIMediaPlayerMgr.getMessage());
          TPLogUtil.e("LiveSdkPlayerHelper", localStringBuilder.toString());
          paramIMediaPlayerMgr.printStackTrace();
        }
        LiveSdkPlayerHelper.access$1008(this.this$0);
        return;
      }
    }
    if (LiveSdkPlayerHelper.access$400(this.this$0) != null) {
      LiveSdkPlayerHelper.access$400(this.this$0).onError(paramIMediaPlayerMgr, paramInt2, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.5
 * JD-Core Version:    0.7.0.1
 */