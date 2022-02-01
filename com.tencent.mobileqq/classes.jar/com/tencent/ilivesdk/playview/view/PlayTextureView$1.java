package com.tencent.ilivesdk.playview.view;

import android.media.MediaFormat;
import android.os.Handler;
import com.tencent.ilivesdk.playview.codec.VideoFileDecodeListener;
import com.tencent.ilivesdk.utils.LogUtils;

class PlayTextureView$1
  implements VideoFileDecodeListener
{
  PlayTextureView$1(PlayTextureView paramPlayTextureView) {}
  
  public void onVideoDecodeEnd()
  {
    LogUtils.i("Render|PlayTextureView", " onVideoDecodeEnd");
    PlayTextureView.access$202(this.this$0, 0);
    PlayTextureView.access$402(this.this$0, 0);
    PlayTextureView.access$302(this.this$0, 0);
    PlayTextureView.access$1302(this.this$0, false);
    PlayTextureView.access$1402(this.this$0, null);
    this.this$0.onPause();
    PlayTextureView.access$1500(this.this$0);
  }
  
  public void onVideoDecodeError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("========= onVideoDecodeError errorCode = ");
    localStringBuilder.append(paramInt);
    LogUtils.i("Render|PlayTextureView", localStringBuilder.toString());
    if (paramInt != -101)
    {
      if (paramInt != -5)
      {
        if ((paramInt != -3) && (paramInt != -2) && (paramInt != -1)) {
          return;
        }
        PlayTextureView.access$202(this.this$0, 0);
        PlayTextureView.access$402(this.this$0, 0);
        PlayTextureView.access$302(this.this$0, 0);
        PlayTextureView.access$1302(this.this$0, false);
        PlayTextureView.access$1402(this.this$0, null);
        this.this$0.onPause();
        PlayTextureView.access$1700(this.this$0, -1);
        return;
      }
      PlayTextureView.access$202(this.this$0, 0);
      PlayTextureView.access$402(this.this$0, 0);
      PlayTextureView.access$302(this.this$0, 0);
      PlayTextureView.access$1302(this.this$0, false);
      this.this$0.onPause();
      PlayTextureView.access$1700(this.this$0, -2);
      return;
    }
    PlayTextureView.access$202(this.this$0, 0);
    PlayTextureView.access$402(this.this$0, 0);
    PlayTextureView.access$302(this.this$0, 0);
    PlayTextureView.access$1302(this.this$0, false);
    PlayTextureView.access$1402(this.this$0, null);
    this.this$0.onPause();
    PlayTextureView.access$1700(this.this$0, -11);
  }
  
  public void onVideoDecodeFrame(long paramLong, byte[] paramArrayOfByte)
  {
    if (!PlayTextureView.access$000(this.this$0)) {
      synchronized (PlayTextureView.access$1600(this.this$0))
      {
        PlayTextureView.access$1302(this.this$0, true);
        System.arraycopy(paramArrayOfByte, 0, PlayTextureView.access$100(this.this$0), 0, paramArrayOfByte.length);
        this.this$0.requestRender();
        return;
      }
    }
  }
  
  public void onVideoDecodeStart()
  {
    LogUtils.i("Render|PlayTextureView", " onVideoDecodeStart");
    PlayTextureView.access$1102(this.this$0, 0L);
    PlayTextureView.access$1202(this.this$0, 0);
    PlayTextureView.access$600(this.this$0).post(new PlayTextureView.1.2(this));
  }
  
  public void onVideoDecoderCreated(boolean paramBoolean)
  {
    LogUtils.i("Render|PlayTextureView", " onVideoDecoderCreated");
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
    PlayTextureView.access$1002(this.this$0, 1000000 / j);
    paramMediaFormat = new StringBuilder();
    paramMediaFormat.append("mFrame Time  = ");
    paramMediaFormat.append(PlayTextureView.access$1000(this.this$0));
    LogUtils.i("Render|PlayTextureView", paramMediaFormat.toString());
  }
  
  public void onVideoSize(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVideoSize() called with: width = [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], height = [");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    LogUtils.i("Render|PlayTextureView", localStringBuilder.toString());
    if ((!PlayTextureView.access$000(this.this$0)) && (paramInt1 > 0) && (paramInt2 > 0) && ((PlayTextureView.access$100(this.this$0) == null) || (PlayTextureView.access$100(this.this$0).length != paramInt1 * paramInt2 * 4))) {
      PlayTextureView.access$102(this.this$0, new byte[paramInt1 * paramInt2 * 4]);
    }
    PlayTextureView.access$202(this.this$0, paramInt1);
    PlayTextureView.access$302(this.this$0, paramInt1 / 2);
    PlayTextureView.access$402(this.this$0, paramInt2);
    PlayTextureView.access$600(this.this$0).post(new PlayTextureView.1.1(this));
    if ((PlayTextureView.access$200(this.this$0) > 0) && (PlayTextureView.access$400(this.this$0) > 0) && (PlayTextureView.access$700(this.this$0) > 0) && (PlayTextureView.access$800(this.this$0) > 0)) {
      PlayTextureView.access$902(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView.1
 * JD-Core Version:    0.7.0.1
 */