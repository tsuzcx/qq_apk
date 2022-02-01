package com.tencent.mobileqq.activity.photo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack.Stub;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.camera.CameraHolder;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.utils.FolderUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.util.BinderWarpper;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.QIMEffectCameraCaptureUnitBuilder;
import dov.com.qq.im.ae.AEKitForQQ;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.AEEditorProcessManager;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.tencent.mobileqq.richmedia.capture.util.DovSVParamManager;
import java.util.Arrays;
import mqq.os.MqqHandler;

public class PeakService
  extends IntentService
{
  public static String a = "StoryTrace_";
  
  public PeakService()
  {
    super("PeakService");
    AEQLog.b("PeakService", "[PeakService]");
  }
  
  public void a(CompressInfo paramCompressInfo, ICompressionCallBack paramICompressionCallBack)
  {
    CompressOperator.a(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramICompressionCallBack != null)
    {
      if (!paramCompressInfo.a) {
        break label64;
      }
      paramICompressionCallBack.a(paramCompressInfo);
    }
    for (;;)
    {
      paramICompressionCallBack.c(paramCompressInfo);
      return;
      label64:
      paramICompressionCallBack.b(paramCompressInfo);
    }
  }
  
  public void onDestroy()
  {
    AEQLog.b("PeakService", "[onDestroy]");
    super.onDestroy();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PeakService", 2, "onHandleIntent: intent is null");
      }
    }
    int i;
    long l;
    do
    {
      return;
      i = paramIntent.getIntExtra("ServiceAction", -1);
      AEQLog.b("PeakService", "onHandleIntent, action = " + i);
      switch (i)
      {
      default: 
        paramIntent = ThreadManager.getFileThreadHandler();
        if (paramIntent != null)
        {
          paramIntent.removeCallbacks(FolderUtils.a);
          paramIntent.postDelayed(FolderUtils.a, 1000L);
        }
        ThreadManager.excute(new PeakService.2(this), 64, null, true);
        return;
      case 1: 
        Parcelable localParcelable = paramIntent.getParcelableExtra("CompressInfo");
        BinderWarpper localBinderWarpper = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
        paramIntent = paramIntent.getIntArrayExtra("CompressConfig");
        if ((paramIntent != null) && (paramIntent.length >= 9))
        {
          com.tencent.mobileqq.pic.compress.PicType.e = paramIntent[0];
          com.tencent.mobileqq.pic.compress.PicType.f = paramIntent[1];
          com.tencent.mobileqq.pic.compress.PicType.g = paramIntent[2];
          com.tencent.mobileqq.pic.compress.PicType.h = paramIntent[3];
          com.tencent.mobileqq.pic.compress.PicType.i = paramIntent[4];
          com.tencent.mobileqq.pic.compress.PicType.j = paramIntent[5];
          com.tencent.mobileqq.pic.compress.PicType.a = paramIntent[6];
          com.tencent.mobileqq.pic.compress.PicType.b = paramIntent[7];
          com.tencent.mobileqq.pic.compress.PicType.c = paramIntent[8];
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(paramIntent));
          }
        }
        if (((localParcelable instanceof CompressInfo)) && (localBinderWarpper != null))
        {
          paramIntent = ICompressionCallBack.Stub.a(localBinderWarpper.a);
          a((CompressInfo)localParcelable, paramIntent);
        }
        CommonImgThumbHelper.initAioThumbSizeByDpc();
        return;
      case 2: 
        bool = paramIntent.getBooleanExtra("key_alive", false);
        AEEditorProcessManager.a().a(bool);
        try
        {
          l = System.currentTimeMillis();
          StatisticCollector.getInstance(this);
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init StatisticCollector use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          new QIMCameraCaptureActivity();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init Activity use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          CameraHolder.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init CameraHolder use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          PtvFilterSoLoad.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 1, "step : init SVFilter use = " + (System.currentTimeMillis() - l));
          }
          AECameraGLSurfaceView.initSdk();
          if (AEResUtil.a(AEResInfo.b))
          {
            AEQLog.d("PeakService", "[loadBasicFeatures] start");
            FeatureManager.loadBasicFeatures();
            AEQLog.d("PeakService", "[loadBasicFeatures] end");
          }
          CaptureContext.a();
          QIMEffectCameraCaptureUnitBuilder.a(-1000, null, null);
          AECameraPrefsUtil.a().a("fake_key", "", 4);
          return;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("PeakService", 1, "", paramIntent);
          return;
        }
      case 3: 
        l = System.currentTimeMillis();
        i = CameraHelper.a();
        DovSVParamManager.a();
        CameraCaptureView.a.a(PeakAppInterface.a);
        CameraCaptureView.a.b(i);
        AEKitForQQ.a();
        bool = CaptureUtil.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("PeakService", 2, new Object[] { "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - l), " soloaded:", Boolean.valueOf(bool), " selectCamera:", Integer.valueOf(i) });
    return;
    AEQLog.b("PeakService", "[ACTION_START_EDITOR_MISSON] receive");
    paramIntent = paramIntent.getStringExtra("generate_mission");
    AEEditorProcessManager.a().a();
    AEEditorProcessManager.a().a(paramIntent);
    return;
    boolean bool = paramIntent.getBooleanExtra("key_alive", false);
    AEEditorProcessManager.a().a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */