package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.colornote.launcher.ReadInJoyLauncher;

class VideoFeedsPlayActivity$3
  implements IServiceInfo
{
  VideoFeedsPlayActivity$3(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public ColorNote getColorNote()
  {
    long l = 0L;
    Object localObject2 = VideoFeedsPlayActivity.a(this.a);
    if (localObject2 == null) {
      return null;
    }
    String str = ReadInJoyLauncher.a + ((VideoInfo)localObject2).g;
    if ((VideoFeedsPlayActivity.a(this.a) != null) && (VideoFeedsPlayActivity.a(this.a).getSubType().equals(str)))
    {
      localObject1 = VideoFeedsPlayActivity.a(this.a);
      if (VideoResumeManager.a.a()) {}
      for (;;)
      {
        ((ColorNote)localObject1).mExtLong = l;
        return VideoFeedsPlayActivity.a(this.a);
        l = VideoFeedsPlayActivity.a(this.a);
      }
    }
    Object localObject1 = this.a;
    localObject2 = new ColorNote.Builder().a(16908290).a(str).b(((VideoInfo)localObject2).c).c(((VideoInfo)localObject2).k).d(((VideoInfo)localObject2).b).a(VideoFeedsHelper.a((VideoInfo)localObject2));
    if (VideoResumeManager.a.a()) {}
    for (;;)
    {
      VideoFeedsPlayActivity.a((VideoFeedsPlayActivity)localObject1, ((ColorNote.Builder)localObject2).a(l).a());
      return VideoFeedsPlayActivity.a(this.a);
      l = VideoFeedsPlayActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity.3
 * JD-Core Version:    0.7.0.1
 */