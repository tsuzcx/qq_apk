package com.tencent.mobileqq.activity.photo;

import agko;
import agkp;
import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import aoai;
import awkj;
import axph;
import axpm;
import azcr;
import azho;
import azkt;
import azri;
import bayu;
import bdhb;
import bknl;
import bkoq;
import bljc;
import bljn;
import blkf;
import blqh;
import bmfm;
import bnlc;
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
    bljn.b("PeakService", "[PeakService]");
  }
  
  public void a(CompressInfo paramCompressInfo, agko paramagko)
  {
    awkj.a(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramagko != null)
    {
      if (!paramCompressInfo.a) {
        break label64;
      }
      paramagko.a(paramCompressInfo);
    }
    for (;;)
    {
      paramagko.c(paramCompressInfo);
      return;
      label64:
      paramagko.b(paramCompressInfo);
    }
  }
  
  public void onDestroy()
  {
    bljn.b("PeakService", "[onDestroy]");
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
      bljn.b("PeakService", "onHandleIntent, action = " + i);
      switch (i)
      {
      default: 
        paramIntent = ThreadManager.getFileThreadHandler();
        if (paramIntent != null)
        {
          paramIntent.removeCallbacks(bdhb.a);
          paramIntent.postDelayed(bdhb.a, 1000L);
        }
        ThreadManager.excute(new PeakService.2(this), 64, null, true);
        return;
      case 1: 
        Parcelable localParcelable = paramIntent.getParcelableExtra("CompressInfo");
        BinderWarpper localBinderWarpper = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
        paramIntent = paramIntent.getIntArrayExtra("CompressConfig");
        if ((paramIntent != null) && (paramIntent.length >= 9))
        {
          awkl.e = paramIntent[0];
          awkl.f = paramIntent[1];
          awkl.g = paramIntent[2];
          awkl.h = paramIntent[3];
          awkl.i = paramIntent[4];
          awkl.j = paramIntent[5];
          awkl.a = paramIntent[6];
          awkl.b = paramIntent[7];
          awkl.c = paramIntent[8];
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(paramIntent));
          }
        }
        if (((localParcelable instanceof CompressInfo)) && (localBinderWarpper != null))
        {
          paramIntent = agkp.a(localBinderWarpper.a);
          a((CompressInfo)localParcelable, paramIntent);
        }
        bayu.a();
        return;
      case 2: 
        bool = paramIntent.getBooleanExtra("key_alive", false);
        blkf.a().a(bool);
        try
        {
          l = System.currentTimeMillis();
          azri.a(this);
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init StatisticCollector use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          new PtvCameraCaptureActivity();
          new QIMCameraCaptureActivity();
          new bmfm();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init Activity use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          aoai.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init CameraHolder use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          azkt.c();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 1, "step : init SVFilter use = " + (System.currentTimeMillis() - l));
          }
          AECameraGLSurfaceView.e();
          if (azcr.a()) {
            FeatureManager.loadBasicFeatures();
          }
          blqh.a();
          bknl.a(-1000, null, null);
          bljc.a().a("fake_key", "", 4);
          return;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("PeakService", 1, "", paramIntent);
          return;
        }
      case 3: 
        l = System.currentTimeMillis();
        i = axph.a();
        bnlc.a();
        CameraCaptureView.a.a(PeakAppInterface.a);
        CameraCaptureView.a.b(i);
        bkoq.a();
        bool = axpm.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("PeakService", 2, new Object[] { "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - l), " soloaded:", Boolean.valueOf(bool), " selectCamera:", Integer.valueOf(i) });
    return;
    bljn.b("PeakService", "[ACTION_START_EDITOR_MISSON] receive");
    paramIntent = paramIntent.getStringExtra("generate_mission");
    blkf.a().a();
    blkf.a().d(paramIntent);
    return;
    boolean bool = paramIntent.getBooleanExtra("key_alive", false);
    blkf.a().a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */