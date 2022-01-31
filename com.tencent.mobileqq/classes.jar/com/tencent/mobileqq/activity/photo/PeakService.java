package com.tencent.mobileqq.activity.photo;

import agfz;
import agga;
import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import anvz;
import awga;
import axky;
import axld;
import azdf;
import azgk;
import azmz;
import baul;
import bdcs;
import bkje;
import bkkj;
import blev;
import blfg;
import blfy;
import bllv;
import bmba;
import bngq;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.util.BinderWarpper;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ptv.PtvCameraCaptureActivity;
import java.util.Arrays;
import mqq.os.MqqHandler;

public class PeakService
  extends IntentService
{
  public static String a = "StoryTrace_";
  
  public PeakService()
  {
    super("PeakService");
    blfg.b("PeakService", "[PeakService]");
  }
  
  public void a(CompressInfo paramCompressInfo, agfz paramagfz)
  {
    awga.a(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramagfz != null)
    {
      if (!paramCompressInfo.a) {
        break label64;
      }
      paramagfz.a(paramCompressInfo);
    }
    for (;;)
    {
      paramagfz.c(paramCompressInfo);
      return;
      label64:
      paramagfz.b(paramCompressInfo);
    }
  }
  
  public void onDestroy()
  {
    blfg.b("PeakService", "[onDestroy]");
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
      blfg.b("PeakService", "onHandleIntent, action = " + i);
      switch (i)
      {
      default: 
        paramIntent = ThreadManager.getFileThreadHandler();
        if (paramIntent != null)
        {
          paramIntent.removeCallbacks(bdcs.a);
          paramIntent.postDelayed(bdcs.a, 1000L);
        }
        ThreadManager.excute(new PeakService.2(this), 64, null, true);
        return;
      case 1: 
        Parcelable localParcelable = paramIntent.getParcelableExtra("CompressInfo");
        BinderWarpper localBinderWarpper = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
        paramIntent = paramIntent.getIntArrayExtra("CompressConfig");
        if ((paramIntent != null) && (paramIntent.length >= 9))
        {
          awgc.e = paramIntent[0];
          awgc.f = paramIntent[1];
          awgc.g = paramIntent[2];
          awgc.h = paramIntent[3];
          awgc.i = paramIntent[4];
          awgc.j = paramIntent[5];
          awgc.a = paramIntent[6];
          awgc.b = paramIntent[7];
          awgc.c = paramIntent[8];
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(paramIntent));
          }
        }
        if (((localParcelable instanceof CompressInfo)) && (localBinderWarpper != null))
        {
          paramIntent = agga.a(localBinderWarpper.a);
          a((CompressInfo)localParcelable, paramIntent);
        }
        baul.a();
        return;
      case 2: 
        bool = paramIntent.getBooleanExtra("key_alive", false);
        blfy.a().a(bool);
        try
        {
          l = System.currentTimeMillis();
          azmz.a(this);
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init StatisticCollector use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          new PtvCameraCaptureActivity();
          new QIMCameraCaptureActivity();
          new bmba();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init Activity use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          anvz.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init CameraHolder use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          azgk.c();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 1, "step : init SVFilter use = " + (System.currentTimeMillis() - l));
          }
          AECameraGLSurfaceView.e();
          FeatureManager.loadBasicFeatures();
          bllv.a();
          bkje.a(-1000, null, null);
          blev.a().a("fake_key", "", 4);
          return;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("PeakService", 1, "", paramIntent);
          return;
        }
      case 3: 
        l = System.currentTimeMillis();
        i = axky.a();
        bngq.a();
        CameraCaptureView.a.a(PeakAppInterface.a);
        CameraCaptureView.a.b(i);
        bkkj.a();
        bool = axld.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("PeakService", 2, new Object[] { "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - l), " soloaded:", Boolean.valueOf(bool), " selectCamera:", Integer.valueOf(i) });
    return;
    blfg.b("PeakService", "[ACTION_START_EDITOR_MISSON] receive");
    paramIntent = paramIntent.getStringExtra("generate_mission");
    blfy.a().a();
    blfy.a().d(paramIntent);
    return;
    boolean bool = paramIntent.getBooleanExtra("key_alive", false);
    blfy.a().a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */