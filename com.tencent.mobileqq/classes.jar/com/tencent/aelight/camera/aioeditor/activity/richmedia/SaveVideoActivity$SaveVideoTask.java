package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

class SaveVideoActivity$SaveVideoTask
  extends AsyncTask<Void, Void, Void>
{
  double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<PeakActivity> jdField_a_of_type_JavaLangRefWeakReference;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<AppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  
  SaveVideoActivity$SaveVideoTask(PeakActivity paramPeakActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPeakActivity);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  private String a(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("mini_launch_ae_tag", 0).getString("mini_launch_ae_app_id", "");
    }
    return "";
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
        return;
      }
      if (a()) {
        return;
      }
      PeakActivity localPeakActivity = (PeakActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      Object localObject1 = (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      Object localObject2 = localPeakActivity.getIntent();
      if (localObject2 == null) {
        return;
      }
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("fakeId");
      localObject2 = SaveVideoActivity.a((AppInterface)localObject1, this.jdField_a_of_type_JavaLangString);
      if (localObject2 == null)
      {
        localPeakActivity.setResult(1, localPeakActivity.getIntent());
        localPeakActivity.finish();
        return;
      }
      if (a()) {
        return;
      }
      localObject1 = ((PublishVideoEntry)localObject2).mLocalRawVideoDir;
      Object localObject3 = new File(((PublishVideoEntry)localObject2).mLocalRawVideoDir);
      if (((File)localObject3).isFile()) {
        localObject1 = ((File)localObject3).getParent();
      }
      localObject1 = com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoUtils.a(new File((String)localObject1));
      if (localObject1 != null)
      {
        localObject3 = new File((String)localObject1).getParent();
        if (localObject3 != null) {
          com.tencent.biz.qqstory.utils.FileUtils.a((String)localObject3);
        }
      }
      new VideoCompositeHelper().a((PublishVideoEntry)localObject2, (String)localObject1, false, true, new SaveVideoActivity.SaveVideoTask.1(this, localPeakActivity, (String)localObject1, null, (PublishVideoEntry)localObject2));
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        return;
      }
      if (new File(this.jdField_b_of_type_JavaLangString).exists()) {}
    }
  }
  
  private void a(int paramInt, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (!((PeakActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isFinishing()))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      SaveVideoActivity.a((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), paramPublishVideoEntry);
      localActivity.setResult(a(paramInt), localActivity.getIntent());
      localActivity.finish();
      if (a(paramInt) == -1) {
        a(this.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(PeakActivity paramPeakActivity, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry)
  {
    this.jdField_b_of_type_JavaLangString = com.tencent.mobileqq.shortvideo.ShortVideoUtils.getLocalShortVideoPath();
    if (SaveVideoActivity.a() == null) {
      SaveVideoActivity.a(FFmpeg.getInstance(paramPeakActivity.getApplicationContext()));
    }
    if (SaveVideoActivity.a().isFFmpegCommandRunning())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SaveVideoActivity", 2, "generate files mFFmpeg is running!");
      }
      return;
    }
    try
    {
      if ((((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry(paramPeakActivity.getIntent())) || (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromMiniApp(paramPeakActivity.getIntent())))
      {
        paramPeakActivity = (IMiniAppService)QRoute.api(IMiniAppService.class);
        this.jdField_b_of_type_JavaLangString = paramPeakActivity.getTmpPathFromOut(paramString1, a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()));
        paramPeakActivity = paramPeakActivity.getTmpPathFromOut(paramPublishVideoEntry.thumbPath, a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()));
        paramPublishVideoEntry.miniThumbPath = paramPeakActivity;
        if (paramPeakActivity != null) {
          com.tencent.mobileqq.utils.FileUtils.copyFile(paramPublishVideoEntry.thumbPath, paramPeakActivity);
        }
      }
      paramPeakActivity = new SaveVideoActivity.SaveVideoTask.VideoSaveAlumCallBack(this, paramPublishVideoEntry, paramString1, this.jdField_b_of_type_JavaLangString);
      SaveVideoActivity.a().setCurrentTaskUni(this.jdField_b_of_type_JavaLangString);
      SaveVideoActivity.a().watermark(paramString2, paramString1, this.jdField_b_of_type_JavaLangString, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, paramPeakActivity);
      return;
    }
    catch (Exception paramPeakActivity)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("generate files save alum:");
        paramString1.append(paramPeakActivity);
        QLog.d("SaveVideoActivity", 2, paramString1.toString());
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
        a(0, SaveVideoActivity.a((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString));
      }
      return true;
    }
    return false;
  }
  
  protected Void a(Void... paramVarArgs)
  {
    a();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity.SaveVideoTask
 * JD-Core Version:    0.7.0.1
 */