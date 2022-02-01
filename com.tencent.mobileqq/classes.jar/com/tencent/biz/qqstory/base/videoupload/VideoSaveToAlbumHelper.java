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
  private int jdField_a_of_type_Int;
  private ArrayList<FFmpegCommandUnit> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public VideoSaveToAlbumHelper()
  {
    b();
  }
  
  private String a()
  {
    return QQStoryConstant.s;
  }
  
  private void a(VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo paramVideoSaveToAlbumTaskInfo)
  {
    SLog.c(jdField_a_of_type_JavaLangString, "generate ffmeng command start...");
    if (TextUtils.isEmpty(paramVideoSaveToAlbumTaskInfo.jdField_b_of_type_JavaLangString))
    {
      SLog.e(jdField_a_of_type_JavaLangString, "generate failed. the video local path is null.");
      return;
    }
    if (FileUtils.c(paramVideoSaveToAlbumTaskInfo.e))
    {
      SLog.b(jdField_a_of_type_JavaLangString, "the video has existed in the album.");
      return;
    }
    VideoSaveToAlbumHelper.SaveVideoTaskCallback localSaveVideoTaskCallback = new VideoSaveToAlbumHelper.SaveVideoTaskCallback(this, paramVideoSaveToAlbumTaskInfo);
    Object localObject2 = FileUtils.a(paramVideoSaveToAlbumTaskInfo.jdField_b_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new int[3];
      localObject1[0] = 0;
      localObject1[1] = paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_Int;
      localObject1[2] = paramVideoSaveToAlbumTaskInfo.jdField_b_of_type_Int;
    }
    int i = localObject1[0];
    paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_Int = localObject1[1];
    paramVideoSaveToAlbumTaskInfo.jdField_b_of_type_Int = localObject1[2];
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(QQStoryConstant.l);
    ((StringBuilder)localObject1).append("hflip");
    ((StringBuilder)localObject1).append(paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(".mp4");
    localObject1 = ((StringBuilder)localObject1).toString();
    if ((i != 0) && (i != -1) && (!FileUtils.c((String)localObject1)))
    {
      localObject2 = new FFmpegCommandUnit();
      ((FFmpegCommandUnit)localObject2).cmdType = 10;
      ((FFmpegCommandUnit)localObject2).arguments = new VideoSaveToAlbumHelper.1(this, paramVideoSaveToAlbumTaskInfo, (String)localObject1);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      SLog.c(jdField_a_of_type_JavaLangString, "add a hflip command to command list.");
    }
    localObject2 = new FFmpegCommandUnit();
    ((FFmpegCommandUnit)localObject2).cmdType = 1;
    ((FFmpegCommandUnit)localObject2).arguments = new VideoSaveToAlbumHelper.2(this, paramVideoSaveToAlbumTaskInfo, i, (String)localObject1);
    ((FFmpegCommandUnit)localObject2).callback = localSaveVideoTaskCallback;
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
    SLog.c(jdField_a_of_type_JavaLangString, "add a watermask command to command list.");
  }
  
  private String b()
  {
    return QQStoryConstant.u;
  }
  
  private void b()
  {
    FileUtils.a(a(), false);
    FileUtils.a(c(), false);
    FileUtils.a(b(), false);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private String c()
  {
    return QQStoryConstant.t;
  }
  
  public String a(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(paramString);
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    SLog.c(jdField_a_of_type_JavaLangString, "trigger to execute all tasks in the task list.");
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "no task need to be execute.");
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo)((Iterator)localObject).next());
    }
    localObject = FFmpeg.getInstance(BaseApplication.getContext(), true);
    String str = ((VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo)this.jdField_a_of_type_JavaUtilList.get(0)).e;
    if (((FFmpeg)localObject).isFFmpegCommandRunning())
    {
      if (((FFmpeg)localObject).checkSameTask(str))
      {
        SLog.d(jdField_a_of_type_JavaLangString, "this task is already running.");
        return;
      }
      SLog.e(jdField_a_of_type_JavaLangString, "a download task is running. let's return.");
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    try
    {
      ((FFmpeg)localObject).setCurrentTaskUni(str);
      ((FFmpeg)localObject).cmdFFmpegQueue(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      SLog.e(jdField_a_of_type_JavaLangString, "error occured during executing ffmeng commands. error message is : %s.", new Object[] { localException.getMessage() });
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, StoryVideoItem.PollLayout paramPollLayout, StoryVideoItem.InteractPasterLayout paramInteractPasterLayout)
  {
    paramString1 = new VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramBoolean);
    paramString1.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$PollLayout = paramPollLayout;
    paramString1.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout = paramInteractPasterLayout;
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    SLog.b(jdField_a_of_type_JavaLangString, "start coping file to temp directory. fromPath = %s. toPath = %s.", paramString1, paramString2);
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    if ((!bool1) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new File(paramString1);
      if (!paramString1.exists())
      {
        SLog.e(jdField_a_of_type_JavaLangString, "src file is not exist.");
        return false;
      }
      bool1 = bool2;
      try
      {
        paramString2 = FileUtils.a(paramString2);
        bool1 = bool2;
        long l = SystemClock.elapsedRealtime();
        bool1 = bool2;
        bool2 = FileUtils.a(paramString1, paramString2);
        bool1 = bool2;
        SLog.b(jdField_a_of_type_JavaLangString, "copy file to temp directory cost %d ms.", Long.valueOf(SystemClock.elapsedRealtime() - l));
        return bool2;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return bool1;
      }
    }
    SLog.e(jdField_a_of_type_JavaLangString, "fromPath or toPath is null.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper
 * JD-Core Version:    0.7.0.1
 */