package com.tencent.aelight.camera.aebase;

import android.app.IntentService;
import android.content.Intent;
import android.os.Process;
import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.preload.AECircleResourcePreloader;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.DovSVParamManager;
import com.tencent.aelight.camera.aeeditor.AEEditorProcessManager;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack.Stub;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.camera.CameraHolder;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.utils.FolderUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.VoiceChangerInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.util.BinderWarpper;
import java.util.Arrays;
import mqq.os.MqqHandler;

public class PeakService
  extends IntentService
{
  public PeakService()
  {
    super("PeakService");
    AEQLog.b("PeakService", "[PeakService]");
  }
  
  public void a(CompressInfo paramCompressInfo, ICompressionCallBack paramICompressionCallBack)
  {
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(paramCompressInfo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CompressPic, current pid=");
      localStringBuilder.append(Process.myPid());
      QLog.d("PeakService", 2, localStringBuilder.toString());
    }
    if (paramICompressionCallBack != null)
    {
      if (paramCompressInfo.a) {
        paramICompressionCallBack.a(paramCompressInfo);
      } else {
        paramICompressionCallBack.b(paramCompressInfo);
      }
      paramICompressionCallBack.c(paramCompressInfo);
    }
  }
  
  public void onDestroy()
  {
    AEQLog.b("PeakService", "[onDestroy]");
    super.onDestroy();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PeakService", 2, "onHandleIntent: intent is null");
      }
      return;
    }
    int i = paramIntent.getIntExtra("ServiceAction", -1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onHandleIntent, action = ");
    ((StringBuilder)localObject).append(i);
    AEQLog.b("PeakService", ((StringBuilder)localObject).toString());
    if (i != 1)
    {
      long l;
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              paramIntent = ThreadManager.getFileThreadHandler();
              if (paramIntent != null)
              {
                paramIntent.removeCallbacks(FolderUtils.a);
                paramIntent.postDelayed(FolderUtils.a, 1000L);
              }
              ThreadManager.excute(new PeakService.2(this), 64, null, true);
              return;
            }
            bool = paramIntent.getBooleanExtra("key_alive", false);
            AEEditorProcessManager.a().a(bool);
            return;
          }
          AEQLog.b("PeakService", "[ACTION_START_EDITOR_MISSON] receive");
          paramIntent = paramIntent.getStringExtra("generate_mission");
          AEEditorProcessManager.a().a();
          AEEditorProcessManager.a().a(paramIntent);
          return;
        }
        l = System.currentTimeMillis();
        i = CameraHelper.a();
        DovSVParamManager.a();
        AEKitForQQ.a();
        bool = CaptureUtil.b();
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("PeakService", 2, new Object[] { "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - l), " soloaded:", Boolean.valueOf(bool), " selectCamera:", Integer.valueOf(i) });
        return;
      }
      boolean bool = paramIntent.getBooleanExtra("key_alive", false);
      AEEditorProcessManager.a().a(bool);
      try
      {
        l = System.currentTimeMillis();
        StatisticCollector.getInstance(this);
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("step : init StatisticCollector use = ");
          paramIntent.append(System.currentTimeMillis() - l);
          QLog.d("PeakService", 2, paramIntent.toString());
        }
        l = System.currentTimeMillis();
        new QIMCameraCaptureActivity();
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("step : init Activity use = ");
          paramIntent.append(System.currentTimeMillis() - l);
          QLog.d("PeakService", 2, paramIntent.toString());
        }
        l = System.currentTimeMillis();
        CameraHolder.a();
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("step : init CameraHolder use = ");
          paramIntent.append(System.currentTimeMillis() - l);
          QLog.d("PeakService", 2, paramIntent.toString());
        }
        l = System.currentTimeMillis();
        PtvFilterSoLoad.a();
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("step : init SVFilter use = ");
          paramIntent.append(System.currentTimeMillis() - l);
          QLog.d("PeakService", 1, paramIntent.toString());
        }
        AECameraGLSurfaceView.initSdk();
        if (AEResUtil.a(AEResInfo.AE_RES_BASE_PACKAGE))
        {
          AEQLog.d("PeakService", "[loadBasicFeatures] start");
          FeatureManager.loadBasicFeatures();
          if (!FeatureManager.Features.VOICE_CHANGER.init()) {
            AEQLog.d("PeakService", "Voice so load failed.");
          }
          AEQLog.d("PeakService", "[loadBasicFeatures] end");
        }
        AECaptureContext.a();
        QIMEffectCameraCaptureUnitBuilder.a(-1000, null, null);
        AECameraPrefsUtil.a().a("fake_key", "", 4);
        AECircleResourcePreloader.a().a(BaseApplicationImpl.getContext());
        new AECirclePhotoListLogic(null);
        return;
      }
      catch (Throwable paramIntent)
      {
        QLog.e("PeakService", 1, "", paramIntent);
        return;
      }
    }
    localObject = paramIntent.getParcelableExtra("CompressInfo");
    BinderWarpper localBinderWarpper = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
    paramIntent = paramIntent.getIntArrayExtra("CompressConfig");
    if ((paramIntent != null) && (paramIntent.length >= 9))
    {
      com.tencent.mobileqq.pic.compress.AbstractPicType.d = paramIntent[0];
      com.tencent.mobileqq.pic.compress.AbstractPicType.e = paramIntent[1];
      com.tencent.mobileqq.pic.compress.AbstractPicType.f = paramIntent[2];
      com.tencent.mobileqq.pic.compress.AbstractPicType.g = paramIntent[3];
      com.tencent.mobileqq.pic.compress.AbstractPicType.h = paramIntent[4];
      com.tencent.mobileqq.pic.compress.AbstractPicType.i = paramIntent[5];
      com.tencent.mobileqq.pic.compress.AbstractPicType.a = paramIntent[6];
      com.tencent.mobileqq.pic.compress.AbstractPicType.b = paramIntent[7];
      com.tencent.mobileqq.pic.compress.AbstractPicType.c = paramIntent[8];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onHandleIntent, compressConfig = ");
        localStringBuilder.append(Arrays.toString(paramIntent));
        QLog.d("PeakService", 2, localStringBuilder.toString());
      }
    }
    if (((localObject instanceof CompressInfo)) && (localBinderWarpper != null))
    {
      paramIntent = ICompressionCallBack.Stub.a(localBinderWarpper.a);
      a((CompressInfo)localObject, paramIntent);
    }
    CommonImgThumbHelper.initAioThumbSizeByDpc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.PeakService
 * JD-Core Version:    0.7.0.1
 */