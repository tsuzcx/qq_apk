package com.tencent.biz.qqstory.base.videoupload;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandUnit;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoSaveToAlbumHelper
{
  public static String a = "Q.qqstory.publish.upload.VideoSaveToAlbumHelper";
  private List<VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo> b = new ArrayList();
  private ArrayList<FFmpegCommandUnit> c = new ArrayList();
  private int d;
  
  public VideoSaveToAlbumHelper()
  {
    b();
  }
  
  private void a(VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo paramVideoSaveToAlbumTaskInfo)
  {
    SLog.c(a, "generate ffmeng command start...");
    if (TextUtils.isEmpty(paramVideoSaveToAlbumTaskInfo.b))
    {
      SLog.e(a, "generate failed. the video local path is null.");
      return;
    }
    if (FileUtils.d(paramVideoSaveToAlbumTaskInfo.g))
    {
      SLog.b(a, "the video has existed in the album.");
      return;
    }
    VideoSaveToAlbumHelper.SaveVideoTaskCallback localSaveVideoTaskCallback = new VideoSaveToAlbumHelper.SaveVideoTaskCallback(this, paramVideoSaveToAlbumTaskInfo);
    Object localObject2 = FileUtils.o(paramVideoSaveToAlbumTaskInfo.b);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new int[3];
      localObject1[0] = 0;
      localObject1[1] = paramVideoSaveToAlbumTaskInfo.d;
      localObject1[2] = paramVideoSaveToAlbumTaskInfo.e;
    }
    int i = localObject1[0];
    paramVideoSaveToAlbumTaskInfo.d = localObject1[1];
    paramVideoSaveToAlbumTaskInfo.e = localObject1[2];
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(QQStoryConstant.m);
    ((StringBuilder)localObject1).append("hflip");
    ((StringBuilder)localObject1).append(paramVideoSaveToAlbumTaskInfo.a);
    ((StringBuilder)localObject1).append(".mp4");
    localObject1 = ((StringBuilder)localObject1).toString();
    if ((i != 0) && (i != -1) && (!FileUtils.d((String)localObject1)))
    {
      localObject2 = new FFmpegCommandUnit();
      ((FFmpegCommandUnit)localObject2).cmdType = 10;
      ((FFmpegCommandUnit)localObject2).arguments = new VideoSaveToAlbumHelper.1(this, paramVideoSaveToAlbumTaskInfo, (String)localObject1);
      this.c.add(localObject2);
      SLog.c(a, "add a hflip command to command list.");
    }
    localObject2 = new FFmpegCommandUnit();
    ((FFmpegCommandUnit)localObject2).cmdType = 1;
    ((FFmpegCommandUnit)localObject2).arguments = new VideoSaveToAlbumHelper.2(this, paramVideoSaveToAlbumTaskInfo, i, (String)localObject1);
    ((FFmpegCommandUnit)localObject2).callback = localSaveVideoTaskCallback;
    this.c.add(localObject2);
    SLog.c(a, "add a watermask command to command list.");
  }
  
  private void b()
  {
    FileUtils.a(c(), false);
    FileUtils.a(e(), false);
    FileUtils.a(d(), false);
    this.b.clear();
    this.c.clear();
  }
  
  private String c()
  {
    return QQStoryConstant.t;
  }
  
  private String d()
  {
    return QQStoryConstant.v;
  }
  
  private String e()
  {
    return QQStoryConstant.u;
  }
  
  public String a(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(paramString);
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    SLog.c(a, "trigger to execute all tasks in the task list.");
    if (this.b.size() < 1)
    {
      SLog.e(a, "no task need to be execute.");
      return;
    }
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo)((Iterator)localObject).next());
    }
    localObject = FFmpeg.getInstance(BaseApplication.getContext(), true);
    String str = ((VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo)this.b.get(0)).g;
    if (((FFmpeg)localObject).isFFmpegCommandRunning())
    {
      if (((FFmpeg)localObject).checkSameTask(str))
      {
        SLog.d(a, "this task is already running.");
        return;
      }
      SLog.e(a, "a download task is running. let's return.");
      return;
    }
    this.d = this.c.size();
    try
    {
      ((FFmpeg)localObject).setCurrentTaskUni(str);
      ((FFmpeg)localObject).cmdFFmpegQueue(this.c);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      SLog.e(a, "error occured during executing ffmeng commands. error message is : %s.", new Object[] { localException.getMessage() });
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, StoryVideoItem.PollLayout paramPollLayout, StoryVideoItem.InteractPasterLayout paramInteractPasterLayout)
  {
    paramString1 = new VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramBoolean);
    paramString1.i = paramPollLayout;
    paramString1.j = paramInteractPasterLayout;
    this.b.add(paramString1);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    SLog.b(a, "start coping file to temp directory. fromPath = %s. toPath = %s.", paramString1, paramString2);
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    if ((!bool1) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new File(paramString1);
      if (!paramString1.exists())
      {
        SLog.e(a, "src file is not exist.");
        return false;
      }
      bool1 = bool2;
      try
      {
        paramString2 = FileUtils.n(paramString2);
        bool1 = bool2;
        long l = SystemClock.elapsedRealtime();
        bool1 = bool2;
        bool2 = FileUtils.a(paramString1, paramString2);
        bool1 = bool2;
        SLog.b(a, "copy file to temp directory cost %d ms.", Long.valueOf(SystemClock.elapsedRealtime() - l));
        return bool2;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return bool1;
      }
    }
    SLog.e(a, "fromPath or toPath is null.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper
 * JD-Core Version:    0.7.0.1
 */