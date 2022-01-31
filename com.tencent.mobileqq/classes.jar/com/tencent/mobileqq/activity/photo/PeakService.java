package com.tencent.mobileqq.activity.photo;

import aejh;
import aeji;
import amez;
import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import auos;
import avsz;
import avte;
import axhz;
import axle;
import axrn;
import aywm;
import bbdx;
import bihi;
import biik;
import bjaa;
import bjal;
import bjpq;
import bkvg;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
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
  }
  
  public void a(CompressInfo paramCompressInfo, aejh paramaejh)
  {
    auos.a(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramaejh != null)
    {
      if (!paramCompressInfo.a) {
        break label64;
      }
      paramaejh.a(paramCompressInfo);
    }
    for (;;)
    {
      paramaejh.c(paramCompressInfo);
      return;
      label64:
      paramaejh.b(paramCompressInfo);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "onDestroy");
    }
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
    boolean bool;
    do
    {
      return;
      i = paramIntent.getIntExtra("ServiceAction", -1);
      if (QLog.isColorLevel()) {
        QLog.d("PeakService", 2, "onHandleIntent, action = " + i);
      }
      switch (i)
      {
      default: 
        paramIntent = ThreadManager.getFileThreadHandler();
        if (paramIntent != null)
        {
          paramIntent.removeCallbacks(bbdx.a);
          paramIntent.postDelayed(bbdx.a, 1000L);
        }
        ThreadManager.excute(new PeakService.2(this), 64, null, true);
        return;
      case 1: 
        Parcelable localParcelable = paramIntent.getParcelableExtra("CompressInfo");
        BinderWarpper localBinderWarpper = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
        paramIntent = paramIntent.getIntArrayExtra("CompressConfig");
        if ((paramIntent != null) && (paramIntent.length >= 9))
        {
          auou.e = paramIntent[0];
          auou.f = paramIntent[1];
          auou.g = paramIntent[2];
          auou.h = paramIntent[3];
          auou.i = paramIntent[4];
          auou.j = paramIntent[5];
          auou.a = paramIntent[6];
          auou.b = paramIntent[7];
          auou.c = paramIntent[8];
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(paramIntent));
          }
        }
        if (((localParcelable instanceof CompressInfo)) && (localBinderWarpper != null))
        {
          paramIntent = aeji.a(localBinderWarpper.a);
          a((CompressInfo)localParcelable, paramIntent);
        }
        aywm.a();
        return;
      case 2: 
        try
        {
          l = System.currentTimeMillis();
          axrn.a(this);
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init StatisticCollector use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          new PtvCameraCaptureActivity();
          new QIMCameraCaptureActivity();
          new bjpq();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init Activity use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          amez.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init CameraHolder use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          axle.c();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 1, "step : init SVFilter use = " + (System.currentTimeMillis() - l));
          }
          AECameraGLSurfaceView.e();
          bjal.a();
          bihi.a(-1000, null, null);
          bjaa.a().a("fake_key", "", 4);
          return;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("PeakService", 1, "", paramIntent);
          return;
        }
      }
      l = System.currentTimeMillis();
      i = avsz.a();
      bkvg.a();
      CameraCaptureView.a.a(PeakAppInterface.a);
      CameraCaptureView.a.b(i);
      biik.a();
      bool = avte.b();
    } while (!QLog.isColorLevel());
    QLog.d("PeakService", 2, new Object[] { "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - l), " soloaded:", Boolean.valueOf(bool), " selectCamera:", Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */