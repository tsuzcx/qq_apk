package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.aelight.camera.ae.AECameraConfig;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.aioeditor.setting.CaptureEntranceParams;
import com.tencent.aelight.camera.aioeditor.setting.CapturePicParams;
import com.tencent.aelight.camera.aioeditor.setting.CapturePicParams.CapturePicParamsBuilder;
import com.tencent.aelight.camera.aioeditor.setting.CaptureVideoParams;
import com.tencent.aelight.camera.aioeditor.setting.CaptureVideoParams.CaptureVideoParamsBuilder;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.PtvFilterUtils;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QIMWebEffectCameraCaptureUnit
  extends AEPituCameraUnit
{
  private BroadcastReceiver a;
  
  public QIMWebEffectCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new QIMWebEffectCameraCaptureUnit.1(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams = new CaptureEntranceParams(10007, this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.d(), 6);
    this.b = 5;
  }
  
  private Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dynamic_text", paramIntent.getStringExtra("dynamic_text"));
    return localBundle;
  }
  
  public static Bundle a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString, boolean paramBoolean6, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    int i;
    if ((paramBoolean2) && (!paramBoolean1)) {
      i = 2;
    } else if ((!paramBoolean2) && (paramBoolean1)) {
      i = 3;
    } else {
      i = 1;
    }
    localBundle.putInt("ability_flag", i);
    localBundle.putInt("PeakConstants.ARG_FORCE_CAMERA", paramInt1);
    localBundle.putBoolean("PeakConstants.ARG_BEAUTY", paramBoolean3);
    localBundle.putBoolean("PeakConstants.ARG_SHARP_FACE", paramBoolean3);
    localBundle.putBoolean("PeakConstants.ARG_SUPPORT_DD", paramBoolean4);
    if ((paramBoolean4) && (paramBoolean5))
    {
      localBundle.putString("KEY_CURRENT_TAB", AECaptureMode.NORMAL.name);
      localBundle.putString("KEY_CURRENT_SELECT_ID", paramString);
    }
    localBundle.putBoolean("PeakConstants.ARG_SUPPORT_FILTER", paramBoolean6);
    localBundle.putInt("edit_video_type", 10007);
    localBundle.putInt("entrance_type", paramInt2);
    localBundle.putBoolean("PeakConstants.ARG_ALBUM", false);
    paramInt1 = AECameraEntry.F.a();
    if (paramInt2 == 107) {
      paramInt1 = AECameraEntry.G.a();
    } else if (paramInt2 == 108) {
      paramInt1 = AECameraEntry.D.a();
    }
    localBundle.putInt("VIDEO_STORY_FROM_TYPE", paramInt1);
    return localBundle;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10007) && (paramInt2 == -1) && (paramIntent != null))
    {
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
      if (localPublishParam.i == 1)
      {
        Activity localActivity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a();
        localActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
        Object localObject = localPublishParam.c;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("hwEncodeVideo videoMergeThumbPath =");
          localStringBuilder.append((String)localObject);
          QLog.d("QIMWebEffectCameraCaptureUnit", 2, localStringBuilder.toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("publishParam =");
          ((StringBuilder)localObject).append(localPublishParam.toString());
          QLog.d("QIMWebEffectCameraCaptureUnit", 2, ((StringBuilder)localObject).toString());
        }
        PtvFilterUtils.a(new File(localPublishParam.j).getParent(), localPublishParam.b);
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams.b() == 107) {
          paramInt1 = 15;
        } else {
          paramInt1 = 32;
        }
        localActivity.getIntent().putExtra("param_entrance", paramInt1);
        localActivity.getIntent().putExtra("fake_id", localPublishParam.b);
        paramIntent = a(paramIntent);
        localObject = new SessionInfo();
        ((SessionInfo)localObject).a = "0";
        ShortVideoProcessUtil.a(localActivity, (SessionInfo)localObject, localPublishParam, paramIntent);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.i();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.q2v.startUploadPTV");
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void h(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject = new CaptureVideoParams.CaptureVideoParamsBuilder().b(3).a();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams.a((CaptureVideoParams)localObject);
      return;
    }
    Object localObject = new CapturePicParams.CapturePicParamsBuilder(this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.getSelectedCamera()).a(3).a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams.a((CapturePicParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QIMWebEffectCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */