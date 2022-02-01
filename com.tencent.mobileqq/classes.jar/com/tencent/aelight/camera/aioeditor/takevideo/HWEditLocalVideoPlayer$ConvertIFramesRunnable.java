package com.tencent.aelight.camera.aioeditor.takevideo;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoder;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import java.util.List;

class HWEditLocalVideoPlayer$ConvertIFramesRunnable
  implements Runnable
{
  public int a = 30;
  public int b = 1;
  public int c = 0;
  
  HWEditLocalVideoPlayer$ConvertIFramesRunnable(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt2;
    this.a = paramInt1;
    this.c = paramInt3;
  }
  
  @TargetApi(17)
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("start convert i frame video. mVideoPath = ");
    ((StringBuilder)localObject1).append(HWEditLocalVideoPlayer.a(this.this$0));
    SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", ((StringBuilder)localObject1).toString());
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(HWEditLocalVideoPlayer.a(this.this$0));
      localObject1 = localMediaMetadataRetriever.extractMetadata(18);
      String str = localMediaMetadataRetriever.extractMetadata(19);
      Object localObject3 = localMediaMetadataRetriever.extractMetadata(24);
      localMediaMetadataRetriever.release();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (TextUtils.isEmpty(str)) {
          return;
        }
        int i;
        try
        {
          i = Integer.valueOf((String)localObject3).intValue();
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          i = 0;
        }
        HWEditLocalVideoPlayer.a(this.this$0, new Mp4ReEncoder());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HWEditLocalVideoPlayer.a(this.this$0));
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(this.c);
        ((StringBuilder)localObject2).append(".IFrames.mp4");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (this.b != 0) {
          HWEditLocalVideoPlayer.a(this.this$0).b = (this.b * this.a);
        }
        localObject3 = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.this$0.a.get(this.c);
        long l1 = HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject3);
        long l2 = HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject3);
        HWEditLocalVideoPlayer.a(this.this$0).a(new DecodeConfig(HWEditLocalVideoPlayer.a(this.this$0), 0, false, true, l1, l2), new EncodeConfig((String)localObject2, Integer.valueOf((String)localObject1).intValue(), Integer.valueOf(str).intValue(), 12582912, this.b, this.a, 0, false, i, null, null, null, false), new HWEditLocalVideoPlayer.ConvertIFramesRunnable.1(this, (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject3), null);
      }
      return;
    }
    catch (Exception localException)
    {
      Object localObject2;
      SLog.c("Q.qqstory.record.HWEditLocalVideoPlayer", "setDataSource failed when convert i frame", localException);
      ((MediaMetadataRetriever)localObject2).release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable
 * JD-Core Version:    0.7.0.1
 */