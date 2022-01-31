package com.tencent.mobileqq.activity.photo;

import aejj;
import aejk;
import amfa;
import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import auoq;
import avsx;
import avtc;
import axhx;
import axlc;
import axrl;
import aywk;
import bbdj;
import bigr;
import biht;
import bizj;
import bizu;
import bjoz;
import bkup;
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
  
  public void a(CompressInfo paramCompressInfo, aejj paramaejj)
  {
    auoq.a(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramaejj != null)
    {
      if (!paramCompressInfo.a) {
        break label64;
      }
      paramaejj.a(paramCompressInfo);
    }
    for (;;)
    {
      paramaejj.c(paramCompressInfo);
      return;
      label64:
      paramaejj.b(paramCompressInfo);
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
          paramIntent.removeCallbacks(bbdj.a);
          paramIntent.postDelayed(bbdj.a, 1000L);
        }
        ThreadManager.excute(new PeakService.2(this), 64, null, true);
        return;
      case 1: 
        Parcelable localParcelable = paramIntent.getParcelableExtra("CompressInfo");
        BinderWarpper localBinderWarpper = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
        paramIntent = paramIntent.getIntArrayExtra("CompressConfig");
        if ((paramIntent != null) && (paramIntent.length >= 9))
        {
          auos.e = paramIntent[0];
          auos.f = paramIntent[1];
          auos.g = paramIntent[2];
          auos.h = paramIntent[3];
          auos.i = paramIntent[4];
          auos.j = paramIntent[5];
          auos.a = paramIntent[6];
          auos.b = paramIntent[7];
          auos.c = paramIntent[8];
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(paramIntent));
          }
        }
        if (((localParcelable instanceof CompressInfo)) && (localBinderWarpper != null))
        {
          paramIntent = aejk.a(localBinderWarpper.a);
          a((CompressInfo)localParcelable, paramIntent);
        }
        aywk.a();
        return;
      case 2: 
        try
        {
          l = System.currentTimeMillis();
          axrl.a(this);
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init StatisticCollector use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          new PtvCameraCaptureActivity();
          new QIMCameraCaptureActivity();
          new bjoz();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init Activity use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          amfa.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init CameraHolder use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          axlc.c();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 1, "step : init SVFilter use = " + (System.currentTimeMillis() - l));
          }
          AECameraGLSurfaceView.e();
          bizu.a();
          bigr.a(-1000, null, null);
          bizj.a().a("fake_key", "", 4);
          return;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("PeakService", 1, "", paramIntent);
          return;
        }
      }
      l = System.currentTimeMillis();
      i = avsx.a();
      bkup.a();
      CameraCaptureView.a.a(PeakAppInterface.a);
      CameraCaptureView.a.b(i);
      biht.a();
      bool = avtc.b();
    } while (!QLog.isColorLevel());
    QLog.d("PeakService", 2, new Object[] { "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - l), " soloaded:", Boolean.valueOf(bool), " selectCamera:", Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */