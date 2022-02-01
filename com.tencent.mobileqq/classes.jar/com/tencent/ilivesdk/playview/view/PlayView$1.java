package com.tencent.ilivesdk.playview.view;

import android.media.MediaFormat;
import android.os.Handler;
import com.tencent.ilivesdk.playview.codec.VideoFileDecodeListener;
import com.tencent.ilivesdk.utils.LogUtils;

class PlayView$1
  implements VideoFileDecodeListener
{
  PlayView$1(PlayView paramPlayView) {}
  
  public void onVideoDecodeEnd()
  {
    LogUtils.e("MediaPESdk|PlayView", " onVideoDecodeEnd");
    PlayView.access$202(this.this$0, 0);
    PlayView.access$402(this.this$0, 0);
    PlayView.access$302(this.this$0, 0);
    PlayView.access$1302(this.this$0, false);
    PlayView.access$1402(this.this$0, null);
    this.this$0.onPause();
    PlayView.access$1500(this.this$0);
  }
  
  public void onVideoDecodeError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("========= onVideoDecodeError errorCode = ");
    localStringBuilder.append(paramInt);
    LogUtils.e("MediaPESdk|PlayView", localStringBuilder.toString());
    if (paramInt != -101)
    {
      if (paramInt != -5)
      {
        if ((paramInt != -3) && (paramInt != -2) && (paramInt != -1)) {
          return;
        }
        PlayView.access$202(this.this$0, 0);
        PlayView.access$402(this.this$0, 0);
        PlayView.access$302(this.this$0, 0);
        PlayView.access$1302(this.this$0, false);
        PlayView.access$1402(this.this$0, null);
        this.this$0.onPause();
        PlayView.access$1700(this.this$0, -1);
        return;
      }
      PlayView.access$202(this.this$0, 0);
      PlayView.access$402(this.this$0, 0);
      PlayView.access$302(this.this$0, 0);
      PlayView.access$1302(this.this$0, false);
      this.this$0.onPause();
      PlayView.access$1700(this.this$0, -2);
      return;
    }
    PlayView.access$202(this.this$0, 0);
    PlayView.access$402(this.this$0, 0);
    PlayView.access$302(this.this$0, 0);
    PlayView.access$1302(this.this$0, false);
    PlayView.access$1402(this.this$0, null);
    this.this$0.onPause();
    PlayView.access$1700(this.this$0, -11);
  }
  
  public void onVideoDecodeFrame(long paramLong, byte[] paramArrayOfByte)
  {
    if (!PlayView.access$000(this.this$0)) {
      synchronized (PlayView.access$1600(this.this$0))
      {
        PlayView.access$1302(this.this$0, true);
        System.arraycopy(paramArrayOfByte, 0, PlayView.access$100(this.this$0), 0, paramArrayOfByte.length);
        this.this$0.requestRender();
        return;
      }
    }
  }
  
  public void onVideoDecodeStart()
  {
    LogUtils.e("MediaPESdk|PlayView", " onVideoDecodeStart");
    PlayView.access$1102(this.this$0, 0L);
    PlayView.access$1202(this.this$0, 0);
    PlayView.access$600(this.this$0).post(new PlayView.1.2(this));
  }
  
  public void onVideoDecoderCreated(boolean paramBoolean)
  {
    LogUtils.e("MediaPESdk|PlayView", " onVideoDecoderCreated");
  }
  
  public void onVideoFormat(MediaFormat paramMediaFormat)
  {
    int i;
    if ((paramMediaFormat != null) && (paramMediaFormat.containsKey("frame-rate"))) {
      i = paramMediaFormat.getInteger("frame-rate");
    } else {
      i = 0;
    }
    int j = i;
    if (i <= 0) {
      j = 25;
    }
    PlayView.access$1002(this.this$0, 1000000 / j);
    paramMediaFormat = new StringBuilder();
    paramMediaFormat.append("mFrame Time  = ");
    paramMediaFormat.append(PlayView.access$1000(this.this$0));
    LogUtils.i("MediaPESdk|PlayView", paramMediaFormat.toString());
  }
  
  public void onVideoSize(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVideoSize() called with: width = [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], height = [");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    LogUtils.i("MediaPESdk|PlayView", localStringBuilder.toString());
    if ((!PlayView.access$000(this.this$0)) && (paramInt1 > 0) && (paramInt2 > 0) && ((PlayView.access$100(this.this$0) == null) || (PlayView.access$100(this.this$0).length != paramInt1 * paramInt2 * 4))) {
      PlayView.access$102(this.this$0, new byte[paramInt1 * paramInt2 * 4]);
    }
    PlayView.access$202(this.this$0, paramInt1);
    PlayView.access$302(this.this$0, paramInt1 / 2);
    PlayView.access$402(this.this$0, paramInt2);
    PlayView.access$600(this.this$0).post(new PlayView.1.1(this));
    if ((PlayView.access$200(this.this$0) > 0) && (PlayView.access$400(this.this$0) > 0) && (PlayView.access$700(this.this$0) > 0) && (PlayView.access$800(this.this$0) > 0)) {
      PlayView.access$902(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayView.1
 * JD-Core Version:    0.7.0.1
 */