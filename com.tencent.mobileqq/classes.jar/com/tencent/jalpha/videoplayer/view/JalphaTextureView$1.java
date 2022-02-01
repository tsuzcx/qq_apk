package com.tencent.jalpha.videoplayer.view;

import android.media.MediaFormat;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import com.tencent.jalpha.common.Logger;
import com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener;

class JalphaTextureView$1
  implements IVideoFileDecodeListener
{
  JalphaTextureView$1(JalphaTextureView paramJalphaTextureView) {}
  
  public void onVideoDecodeEnd()
  {
    Logger.e(JalphaTextureView.access$000(this.this$0), " onVideoDecodeEnd");
    JalphaTextureView.access$102(this.this$0, 0);
    JalphaTextureView.access$202(this.this$0, 0);
    JalphaTextureView.access$902(this.this$0, null);
    this.this$0.onPause();
    JalphaTextureView.access$1000(this.this$0);
  }
  
  public void onVideoDecodeError(int paramInt)
  {
    String str = JalphaTextureView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("========= onVideoDecodeError errorCode = ");
    localStringBuilder.append(paramInt);
    Logger.e(str, localStringBuilder.toString());
    if (paramInt != -101)
    {
      if (paramInt != -5)
      {
        if ((paramInt != -3) && (paramInt != -2) && (paramInt != -1)) {
          return;
        }
        JalphaTextureView.access$102(this.this$0, 0);
        JalphaTextureView.access$202(this.this$0, 0);
        JalphaTextureView.access$902(this.this$0, null);
        this.this$0.onPause();
        JalphaTextureView.access$1100(this.this$0, -1);
        return;
      }
      JalphaTextureView.access$102(this.this$0, 0);
      JalphaTextureView.access$202(this.this$0, 0);
      this.this$0.onPause();
      JalphaTextureView.access$1100(this.this$0, -2);
      return;
    }
    JalphaTextureView.access$102(this.this$0, 0);
    JalphaTextureView.access$202(this.this$0, 0);
    JalphaTextureView.access$902(this.this$0, null);
    this.this$0.onPause();
    JalphaTextureView.access$1100(this.this$0, -11);
  }
  
  public void onVideoDecodeFrame(long paramLong, byte[] paramArrayOfByte) {}
  
  public void onVideoDecodeStart()
  {
    Logger.e(JalphaTextureView.access$000(this.this$0), " onVideoDecodeStart");
    JalphaTextureView.access$702(this.this$0, 0L);
    JalphaTextureView.access$802(this.this$0, 0);
    JalphaTextureView.access$400(this.this$0).post(new JalphaTextureView.1.2(this));
  }
  
  public void onVideoDecoderCreated(boolean paramBoolean)
  {
    Logger.e(JalphaTextureView.access$000(this.this$0), " onVideoDecoderCreated");
  }
  
  @RequiresApi(api=16)
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
    JalphaTextureView.access$602(this.this$0, 1000000 / j);
    paramMediaFormat = JalphaTextureView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mFrame Time  = ");
    localStringBuilder.append(JalphaTextureView.access$600(this.this$0));
    Logger.v(paramMediaFormat, localStringBuilder.toString());
  }
  
  public void onVideoSize(int paramInt1, int paramInt2)
  {
    String str = JalphaTextureView.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVideoSize() called with: width = [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], height = [");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    Logger.e(str, localStringBuilder.toString());
    JalphaTextureView.access$102(this.this$0, paramInt1);
    JalphaTextureView.access$202(this.this$0, paramInt2);
    JalphaTextureView.access$400(this.this$0).post(new JalphaTextureView.1.1(this));
    JalphaTextureView.access$502(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView.1
 * JD-Core Version:    0.7.0.1
 */