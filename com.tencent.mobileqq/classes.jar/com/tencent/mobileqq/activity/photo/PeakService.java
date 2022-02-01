package com.tencent.mobileqq.activity.photo;

import ahav;
import ahaw;
import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import apiy;
import ayeu;
import babb;
import babd;
import bbuk;
import bbxj;
import blif;
import bljd;
import bmbk;
import bmbx;
import bmdb;
import bmqh;
import bnxr;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.util.BinderWarpper;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import java.util.Arrays;
import mqq.os.MqqHandler;

public class PeakService
  extends IntentService
{
  public static String a = "StoryTrace_";
  
  public PeakService()
  {
    super("PeakService");
    bmbx.b("PeakService", "[PeakService]");
  }
  
  public void a(CompressInfo paramCompressInfo, ahav paramahav)
  {
    ayeu.a(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramahav != null)
    {
      if (!paramCompressInfo.a) {
        break label64;
      }
      paramahav.a(paramCompressInfo);
    }
    for (;;)
    {
      paramahav.c(paramCompressInfo);
      return;
      label64:
      paramahav.b(paramCompressInfo);
    }
  }
  
  public void onDestroy()
  {
    bmbx.b("PeakService", "[onDestroy]");
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
      bmbx.b("PeakService", "onHandleIntent, action = " + i);
      switch (i)
      {
      default: 
        paramIntent = ThreadManager.getFileThreadHandler();
        if (paramIntent != null)
        {
          paramIntent.removeCallbacks(FileUtils.sCheckFolderTask);
          paramIntent.postDelayed(FileUtils.sCheckFolderTask, 1000L);
        }
        ThreadManager.excute(new PeakService.2(this), 64, null, true);
        return;
      case 1: 
        Parcelable localParcelable = paramIntent.getParcelableExtra("CompressInfo");
        BinderWarpper localBinderWarpper = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
        paramIntent = paramIntent.getIntArrayExtra("CompressConfig");
        if ((paramIntent != null) && (paramIntent.length >= 9))
        {
          ayew.e = paramIntent[0];
          ayew.f = paramIntent[1];
          ayew.g = paramIntent[2];
          ayew.h = paramIntent[3];
          ayew.i = paramIntent[4];
          ayew.j = paramIntent[5];
          ayew.a = paramIntent[6];
          ayew.b = paramIntent[7];
          ayew.c = paramIntent[8];
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(paramIntent));
          }
        }
        if (((localParcelable instanceof CompressInfo)) && (localBinderWarpper != null))
        {
          paramIntent = ahaw.a(localBinderWarpper.a);
          a((CompressInfo)localParcelable, paramIntent);
        }
        CommonImgThumbHelper.initAioThumbSizeByDpc();
        return;
      case 2: 
        bool = paramIntent.getBooleanExtra("key_alive", false);
        bmdb.a().a(bool);
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
          apiy.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init CameraHolder use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          bbxj.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 1, "step : init SVFilter use = " + (System.currentTimeMillis() - l));
          }
          AECameraGLSurfaceView.initSdk();
          if (AEResUtil.checkAEResVersionOK(AEResInfo.AE_RES_BASE_PACKAGE))
          {
            bmbx.d("PeakService", "[loadBasicFeatures] start");
            FeatureManager.loadBasicFeatures();
            bmbx.d("PeakService", "[loadBasicFeatures] end");
          }
          bmqh.a();
          blif.a(-1000, null, null);
          bmbk.a().a("fake_key", "", 4);
          return;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("PeakService", 1, "", paramIntent);
          return;
        }
      case 3: 
        l = System.currentTimeMillis();
        i = babb.a();
        bnxr.a();
        CameraCaptureView.a.a(PeakAppInterface.a);
        CameraCaptureView.a.b(i);
        bljd.a();
        bool = babd.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("PeakService", 2, new Object[] { "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - l), " soloaded:", Boolean.valueOf(bool), " selectCamera:", Integer.valueOf(i) });
    return;
    bmbx.b("PeakService", "[ACTION_START_EDITOR_MISSON] receive");
    paramIntent = paramIntent.getStringExtra("generate_mission");
    bmdb.a().a();
    bmdb.a().a(paramIntent);
    return;
    boolean bool = paramIntent.getBooleanExtra("key_alive", false);
    bmdb.a().a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */