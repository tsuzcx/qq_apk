package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.common.app.AppInterface;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SaveVideoActivity
  extends FlowActivity
{
  private static FFmpeg d;
  private SaveVideoActivity.SaveVideoTask e;
  private boolean f;
  private int g;
  
  public static Intent a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = new Intent(paramContext, SaveVideoActivity.class);
    paramContext.putExtra("fakeId", paramString);
    paramContext.putExtra("sv_total_frame_count", paramInt2);
    paramContext.putExtra("sv_total_record_time", paramInt1);
    paramContext.putExtra("save_video_businessid", paramInt3);
    return paramContext;
  }
  
  private static PublishVideoEntry b(AppInterface paramAppInterface, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    if (paramAppInterface != null)
    {
      paramAppInterface = new QQStoryEntityManagerFactory(paramAppInterface);
      paramAppInterface.verifyAuthentication();
      paramString = ShortVideoRealItemBuilder.a(paramAppInterface.createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), "fakeVid=?", new String[] { paramString });
      paramAppInterface = localObject;
      if (paramString != null)
      {
        paramAppInterface = localObject;
        if (paramString.size() > 0) {
          paramAppInterface = (PublishVideoEntry)paramString.get(0);
        }
      }
      return paramAppInterface;
    }
    throw new IllegalStateException("Can not create a entity factory, the account is null.");
  }
  
  private static void b(AppInterface paramAppInterface, PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry == null) {
      return;
    }
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    if (paramAppInterface != null)
    {
      paramAppInterface = new QQStoryEntityManagerFactory(paramAppInterface);
      paramAppInterface.verifyAuthentication();
      paramAppInterface.createEntityManager().remove(paramPublishVideoEntry);
      return;
    }
    throw new IllegalStateException("Can not create a entity factory, the account is null.");
  }
  
  protected void a(ViewGroup paramViewGroup) {}
  
  public void onBackPressed()
  {
    if (this.f) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.y = false;
    this.z = false;
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return;
    }
    com.tencent.mobileqq.editor.composite.CodecParam.mRecordFrames = paramBundle.getIntExtra("sv_total_frame_count", 0);
    com.tencent.mobileqq.editor.composite.CodecParam.mRecordTime = paramBundle.getIntExtra("sv_total_record_time", 0);
    this.g = paramBundle.getIntExtra("requestCode", -1);
    this.e = new SaveVideoActivity.SaveVideoTask(this, CaptureContext.a());
    SaveVideoActivity.SaveVideoTask.a(this.e, paramBundle.getBooleanExtra("video_edit_flag", false));
    SaveVideoActivity.SaveVideoTask.a(this.e, paramBundle.getIntExtra("save_video_businessid", -1));
    Utils.executeAsyncTaskOnSerialExcuter(this.e, new Void[] { (Void)null });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.f = true;
      if ((this.e != null) && (!isFinishing()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SaveVideoActivity", 2, "cancel save video");
        }
        if (SlideShowPhotoListManager.a().e() == 22)
        {
          int i = this.g;
          if (i == 111) {
            LpReportInfo_pf00064.allReport(680, 12, 2);
          } else if (i == 222) {
            LpReportInfo_pf00064.allReport(680, 13, 2);
          }
        }
        SaveVideoActivity.SaveVideoTask.a(this.e).set(true);
        setResult(0, getIntent());
        if (getIntent() != null) {
          ThreadManager.postImmediately(new SaveVideoActivity.1(this, getIntent().getStringExtra("fakeId")), null, true);
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity
 * JD-Core Version:    0.7.0.1
 */