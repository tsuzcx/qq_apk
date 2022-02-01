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
  long jdField_a_of_type_Long;
  PublishVideoEntry jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  SaveVideoActivity$SaveVideoTask$VideoSaveAlumCallBack(SaveVideoActivity.SaveVideoTask paramSaveVideoTask, PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry = paramPublishVideoEntry;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate files|third step fail:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",videoFinalPath= ");
      localStringBuilder.append(this.b);
      QLog.d("SaveVideoActivity", 2, localStringBuilder.toString());
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    double d = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Double.isNaN(d);
    d /= 1000.0D;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("generate files|third step cost:");
      ((StringBuilder)localObject1).append(d);
      ((StringBuilder)localObject1).append(",videoFinalPath= ");
      ((StringBuilder)localObject1).append(this.b);
      QLog.d("SaveVideoActivity", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new HashMap();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaSaveVideoActivity$SaveVideoTask.a);
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("generate_video_cost", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(d);
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("watermark_cost", ((StringBuilder)localObject2).toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qq_ptv_save_time", true, 0L, 0L, (HashMap)localObject1, null);
    com.tencent.mobileqq.utils.FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
    if (SaveVideoActivity.SaveVideoTask.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaSaveVideoActivity$SaveVideoTask).get() != null)
    {
      localObject1 = (Activity)SaveVideoActivity.SaveVideoTask.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaSaveVideoActivity$SaveVideoTask).get();
      if (SaveVideoActivity.SaveVideoTask.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaSaveVideoActivity$SaveVideoTask).get() != null) {
        SaveVideoActivity.a((AppInterface)SaveVideoActivity.SaveVideoTask.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaSaveVideoActivity$SaveVideoTask).get(), this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry);
      }
      int i;
      if (paramBoolean) {
        i = SaveVideoActivity.SaveVideoTask.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaSaveVideoActivity$SaveVideoTask, -1);
      } else {
        i = SaveVideoActivity.SaveVideoTask.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaSaveVideoActivity$SaveVideoTask, 1);
      }
      if (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry(((Activity)localObject1).getIntent()))
      {
        localObject2 = new Intent();
        if (paramBoolean)
        {
          ((Intent)localObject2).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
          ((Intent)localObject2).putExtra("file_path", this.b);
          ((Intent)localObject2).putExtra("video_thumb_path", this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.miniThumbPath);
          ((Intent)localObject2).putExtra("video_duration", this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoDuration);
          ((Intent)localObject2).putExtra("is_video", true);
        }
        ((Activity)localObject1).sendBroadcast((Intent)localObject2);
        ((Activity)localObject1).setResult(i, ((Activity)localObject1).getIntent());
        ((Activity)localObject1).finish();
        return;
      }
      localObject2 = ((Activity)localObject1).getIntent();
      if (paramBoolean) {
        ((Intent)localObject2).putExtra("key_video_save_path", this.b);
      }
      ((Activity)localObject1).setResult(i, ((Activity)localObject1).getIntent());
      ((Activity)localObject1).finish();
      if (i == -1)
      {
        localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaSaveVideoActivity$SaveVideoTask;
        SaveVideoActivity.SaveVideoTask.a((SaveVideoActivity.SaveVideoTask)localObject1, SaveVideoActivity.SaveVideoTask.a((SaveVideoActivity.SaveVideoTask)localObject1));
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
      localStringBuilder.append(this.b);
      QLog.d("SaveVideoActivity", 2, localStringBuilder.toString());
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("VideoSaveAlumCallBack|onSuccess videoFinalPath= ");
      paramString.append(this.b);
      QLog.d("SaveVideoActivity", 2, paramString.toString());
    }
    com.tencent.biz.qqstory.utils.FileUtils.a(BaseApplication.getContext(), new File(this.b));
    com.tencent.mobileqq.utils.FileUtils.deleteFile(new File(this.jdField_a_of_type_JavaLangString).getParent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity.SaveVideoTask.VideoSaveAlumCallBack
 * JD-Core Version:    0.7.0.1
 */