package com.tencent.biz.qqstory.playmode.util;

import android.os.SystemClock;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;

public class PlayModeUtils$ExecuteDownloadResponseCallback
  implements FFmpegExecuteResponseCallback
{
  public String a;
  public StoryVideoItem b;
  public long c;
  public String d;
  
  public PlayModeUtils$ExecuteDownloadResponseCallback(String paramString1, StoryVideoItem paramStoryVideoItem, String paramString2)
  {
    this.a = paramString1;
    this.b = paramStoryVideoItem;
    this.d = paramString2;
  }
  
  public void onFailure(String paramString)
  {
    paramString = new PlayModeUtils.DownloadStatusChangeEvent(this.d, 3, this.b);
    StoryDispatcher.a().dispatch(paramString);
    StoryReportor.a("play_video", "down_fail", 0, 0, new String[] { "", "", "", this.b.mVid });
    StoryReportor.a("play_video", "down_watermark", 0, 1, new String[0]);
  }
  
  public void onFinish(boolean paramBoolean) {}
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    this.c = SystemClock.uptimeMillis();
    PlayModeUtils.DownloadStatusChangeEvent localDownloadStatusChangeEvent = new PlayModeUtils.DownloadStatusChangeEvent(this.d, 0, this.b);
    StoryDispatcher.a().dispatch(localDownloadStatusChangeEvent);
  }
  
  public void onSuccess(String paramString)
  {
    paramString = new PlayModeUtils.DownloadStatusChangeEvent(this.d, 2, this.b);
    paramString.d = this.a;
    StoryDispatcher.a().dispatch(paramString);
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.c;
    long l3 = this.b.mVideoDuration;
    StoryReportor.a("play_video", "down_suc", 0, 0, new String[] { "", "", "", this.b.mVid });
    StoryReportor.a("play_video", "down_watermark_time", 0, 0, new String[] { String.valueOf(l1 - l2), String.valueOf(l3) });
    StoryReportor.a("play_video", "down_watermark", 0, 0, new String[0]);
    FileUtils.a(BaseApplication.getContext(), new File(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.ExecuteDownloadResponseCallback
 * JD-Core Version:    0.7.0.1
 */