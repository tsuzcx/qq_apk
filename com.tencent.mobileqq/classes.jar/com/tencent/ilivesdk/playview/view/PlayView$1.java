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
    LogUtils.e("MediaPESdk|PlayView", "========= onVideoDecodeError errorCode = " + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case -3: 
    case -2: 
    case -1: 
      PlayView.access$202(this.this$0, 0);
      PlayView.access$402(this.this$0, 0);
      PlayView.access$302(this.this$0, 0);
      PlayView.access$1302(this.this$0, false);
      PlayView.access$1402(this.this$0, null);
      this.this$0.onPause();
      PlayView.access$1700(this.this$0, -1);
      return;
    case -5: 
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
    int j = 0;
    int i = j;
    if (paramMediaFormat != null)
    {
      i = j;
      if (paramMediaFormat.containsKey("frame-rate")) {
        i = paramMediaFormat.getInteger("frame-rate");
      }
    }
    j = i;
    if (i <= 0) {
      j = 25;
    }
    PlayView.access$1002(this.this$0, 1000000 / j);
    LogUtils.i("MediaPESdk|PlayView", "mFrame Time  = " + PlayView.access$1000(this.this$0));
  }
  
  public void onVideoSize(int paramInt1, int paramInt2)
  {
    LogUtils.i("MediaPESdk|PlayView", "onVideoSize() called with: width = [" + paramInt1 + "], height = [" + paramInt2 + "]");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayView.1
 * JD-Core Version:    0.7.0.1
 */