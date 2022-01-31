package com.tencent.biz.qqstory.base.videoupload;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandUnit;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.ExecuteFhlipResponseCallback;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoSaveToAlbumHelper
{
  public static String a;
  private int jdField_a_of_type_Int;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.qqstory.publish.upload.VideoSaveToAlbumHelper";
  }
  
  public VideoSaveToAlbumHelper()
  {
    b();
  }
  
  private String a()
  {
    return QQStoryConstant.n;
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
    Object localObject2 = VideoUtils.a(paramVideoSaveToAlbumTaskInfo.jdField_b_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new int[3];
      localObject1[0] = 0;
      localObject1[1] = paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_Int;
      localObject1[2] = paramVideoSaveToAlbumTaskInfo.jdField_b_of_type_Int;
    }
    int j = localObject1[0];
    paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_Int = localObject1[1];
    paramVideoSaveToAlbumTaskInfo.jdField_b_of_type_Int = localObject1[2];
    int i;
    String str1;
    String str2;
    if (paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_Boolean)
    {
      i = 2;
      str1 = FFmpegUtils.a(BaseApplication.getContext(), paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_JavaLangString, paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_Int, paramVideoSaveToAlbumTaskInfo.jdField_b_of_type_Int, i);
      if (TextUtils.isEmpty(str1)) {
        SLog.e(jdField_a_of_type_JavaLangString, "Client Error: generate water mark failed! May be this task is strange! %s", new Object[] { paramVideoSaveToAlbumTaskInfo });
      }
      localObject2 = paramVideoSaveToAlbumTaskInfo.c;
      localObject1 = FFmpegUtils.a(paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$PollLayout, paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_Int, paramVideoSaveToAlbumTaskInfo.jdField_b_of_type_Int);
      str2 = FFmpegUtils.a(paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout, paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_Int, paramVideoSaveToAlbumTaskInfo.jdField_b_of_type_Int);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label306;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        str2 = QQStoryConstant.q;
        str2 = str2 + paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_JavaLangString + System.currentTimeMillis() + "_new_mask.png";
        if (!FFmpegUtils.a((String)localObject2, (String)localObject1, str2))
        {
          SLog.e(jdField_a_of_type_JavaLangString, "combineTwoImg mask and vote failed");
          return;
          i = 1;
          break;
          label306:
          localObject1 = str2;
          continue;
        }
        localObject1 = str2;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1))) {
          break label585;
        }
        SLog.b(jdField_a_of_type_JavaLangString, "have doodle image, should combine doodle image and logo image.");
        str2 = QQStoryConstant.i + paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_JavaLangString + "_newDownloadMask.mp4";
        localObject2 = localObject1;
        if (FFmpegUtils.a((String)localObject1, str1, str2)) {
          localObject2 = str2;
        }
      }
    }
    for (;;)
    {
      paramVideoSaveToAlbumTaskInfo.c = ((String)localObject2);
      localObject1 = QQStoryConstant.i + "hflip" + paramVideoSaveToAlbumTaskInfo.jdField_a_of_type_JavaLangString + ".mp4";
      if ((j != 0) && (j != -1) && (!FileUtils.c((String)localObject1)))
      {
        localObject2 = new FFmpegCommandUnit();
        ((FFmpegCommandUnit)localObject2).jdField_a_of_type_Int = 10;
        ((FFmpegCommandUnit)localObject2).jdField_a_of_type_JavaUtilArrayList = new VideoSaveToAlbumHelper.1(this, paramVideoSaveToAlbumTaskInfo, (String)localObject1);
        ((FFmpegCommandUnit)localObject2).jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new FFmpegUtils.ExecuteFhlipResponseCallback(null);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        SLog.c(jdField_a_of_type_JavaLangString, "add a hflip command to command list.");
      }
      localObject2 = new FFmpegCommandUnit();
      ((FFmpegCommandUnit)localObject2).jdField_a_of_type_Int = 1;
      ((FFmpegCommandUnit)localObject2).jdField_a_of_type_JavaUtilArrayList = new VideoSaveToAlbumHelper.2(this, paramVideoSaveToAlbumTaskInfo, j, (String)localObject1);
      ((FFmpegCommandUnit)localObject2).jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = localSaveVideoTaskCallback;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      SLog.c(jdField_a_of_type_JavaLangString, "add a watermask command to command list.");
      return;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localObject2;
      break;
      label585:
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = str1;
      }
    }
  }
  
  private String b()
  {
    return QQStoryConstant.p;
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
    return QQStoryConstant.o;
  }
  
  public String a(@NonNull String paramString)
  {
    return a() + paramString + ".mp4";
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
    localObject = FFmpeg.a(BaseApplication.getContext(), true);
    String str = ((VideoSaveToAlbumHelper.VideoSaveToAlbumTaskInfo)this.jdField_a_of_type_JavaUtilList.get(0)).e;
    if (((FFmpeg)localObject).a())
    {
      if (((FFmpeg)localObject).a(str))
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
      ((FFmpeg)localObject).a(str);
      ((FFmpeg)localObject).a(this.jdField_a_of_type_JavaUtilArrayList);
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
  
  public boolean a(String paramString)
  {
    Object localObject = VideoCompositeHelper.a(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)((Iterator)localObject).next();
      if ((localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_FAILED) && (localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC) && (localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC))
      {
        SLog.a(jdField_a_of_type_JavaLangString, "waiting other fragments composited. group id is %s.", paramString);
        return false;
      }
    }
    SLog.a(jdField_a_of_type_JavaLangString, "all fragments are composited. group id is %s.", paramString);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    SLog.b(jdField_a_of_type_JavaLangString, "start coping file to temp directory. fromPath = %s. toPath = %s.", paramString1, paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      SLog.e(jdField_a_of_type_JavaLangString, "fromPath or toPath is null.");
      return false;
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      SLog.e(jdField_a_of_type_JavaLangString, "src file is not exist.");
      return false;
    }
    boolean bool1 = bool2;
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
    }
    return bool1;
  }
  
  public boolean b(String paramString)
  {
    paramString = VideoCompositeHelper.a(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
    if (paramString == null) {
      return false;
    }
    paramString = paramString.iterator();
    int i = 0;
    label48:
    if (paramString.hasNext())
    {
      if (((PublishVideoEntry)paramString.next()).videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_FAILED) {
        break label102;
      }
      i += 1;
    }
    label102:
    for (;;)
    {
      break label48;
      SLog.a(jdField_a_of_type_JavaLangString, "composite failed count is %d.", Integer.valueOf(i));
      if (i != 1) {
        break;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper
 * JD-Core Version:    0.7.0.1
 */