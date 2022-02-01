package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class SaveVideoActivity$SaveVideoTask$VideoSaveAlumCallBack
  implements FFmpegExecuteResponseCallback
{
  PublishVideoEntry a;
  String b;
  String c;
  long d;
  
  SaveVideoActivity$SaveVideoTask$VideoSaveAlumCallBack(SaveVideoActivity.SaveVideoTask paramSaveVideoTask, PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2)
  {
    this.a = paramPublishVideoEntry;
    this.b = paramString1;
    this.c = paramString2;
    this.d = System.currentTimeMillis();
  }
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate files|third step fail:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",videoFinalPath= ");
      localStringBuilder.append(this.c);
      QLog.d("SaveVideoActivity", 2, localStringBuilder.toString());
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    double d1 = System.currentTimeMillis() - this.d;
    Double.isNaN(d1);
    d1 /= 1000.0D;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("generate files|third step cost:");
      ((StringBuilder)localObject1).append(d1);
      ((StringBuilder)localObject1).append(",videoFinalPath= ");
      ((StringBuilder)localObject1).append(this.c);
      QLog.d("SaveVideoActivity", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new HashMap();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.e.a);
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("generate_video_cost", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(d1);
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("watermark_cost", ((StringBuilder)localObject2).toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qq_ptv_save_time", true, 0L, 0L, (HashMap)localObject1, null);
    com.tencent.mobileqq.utils.FileUtils.deleteFile(this.b);
    if (SaveVideoActivity.SaveVideoTask.b(this.e).get() != null)
    {
      localObject1 = (Activity)SaveVideoActivity.SaveVideoTask.b(this.e).get();
      if (SaveVideoActivity.SaveVideoTask.c(this.e).get() != null) {
        SaveVideoActivity.a((AppInterface)SaveVideoActivity.SaveVideoTask.c(this.e).get(), this.a);
      }
      int i;
      if (paramBoolean) {
        i = SaveVideoActivity.SaveVideoTask.b(this.e, -1);
      } else {
        i = SaveVideoActivity.SaveVideoTask.b(this.e, 1);
      }
      if (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry(((Activity)localObject1).getIntent()))
      {
        localObject2 = new Intent();
        if (paramBoolean)
        {
          ((Intent)localObject2).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
          ((Intent)localObject2).putExtra("file_path", this.c);
          ((Intent)localObject2).putExtra("video_thumb_path", this.a.miniThumbPath);
          ((Intent)localObject2).putExtra("video_duration", this.a.videoDuration);
          ((Intent)localObject2).putExtra("is_video", true);
        }
        ((Activity)localObject1).sendBroadcast((Intent)localObject2);
        ((Activity)localObject1).setResult(i, ((Activity)localObject1).getIntent());
        ((Activity)localObject1).finish();
        return;
      }
      localObject2 = ((Activity)localObject1).getIntent();
      if (paramBoolean) {
        ((Intent)localObject2).putExtra("key_video_save_path", this.c);
      }
      ((Activity)localObject1).setResult(i, ((Activity)localObject1).getIntent());
      ((Activity)localObject1).finish();
      if (i == -1)
      {
        localObject1 = this.e;
        SaveVideoActivity.SaveVideoTask.c((SaveVideoActivity.SaveVideoTask)localObject1, SaveVideoActivity.SaveVideoTask.d((SaveVideoActivity.SaveVideoTask)localObject1));
      }
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoSaveAlumCallBack：onStart videoFinalPath= ");
      localStringBuilder.append(this.c);
      QLog.d("SaveVideoActivity", 2, localStringBuilder.toString());
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("VideoSaveAlumCallBack|onSuccess videoFinalPath= ");
      paramString.append(this.c);
      QLog.d("SaveVideoActivity", 2, paramString.toString());
    }
    com.tencent.biz.qqstory.utils.FileUtils.a(BaseApplication.getContext(), new File(this.c));
    com.tencent.mobileqq.utils.FileUtils.deleteFile(new File(this.b).getParent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity.SaveVideoTask.VideoSaveAlumCallBack
 * JD-Core Version:    0.7.0.1
 */