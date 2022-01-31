package com.tencent.mobileqq.activity.photo;

import adyk;
import adyl;
import alqk;
import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import atqs;
import auto;
import autt;
import awir;
import awlw;
import awrn;
import axwd;
import bace;
import bgxr;
import bhxh;
import bjef;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import dov.com.qq.im.QIMCameraCaptureActivity;
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
  
  public void a(CompressInfo paramCompressInfo, adyk paramadyk)
  {
    atqs.a(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramadyk != null)
    {
      if (!paramCompressInfo.a) {
        break label64;
      }
      paramadyk.a(paramCompressInfo);
    }
    for (;;)
    {
      paramadyk.c(paramCompressInfo);
      return;
      label64:
      paramadyk.b(paramCompressInfo);
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
      for (;;)
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
            paramIntent.removeCallbacks(bace.a);
            paramIntent.postDelayed(bace.a, 1000L);
          }
          ThreadManager.excute(new PeakService.1(this), 64, null, true);
          return;
        case 1: 
          Parcelable localParcelable = paramIntent.getParcelableExtra("CompressInfo");
          BinderWarpper localBinderWarpper = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
          paramIntent = paramIntent.getIntArrayExtra("CompressConfig");
          if ((paramIntent != null) && (paramIntent.length >= 9))
          {
            atqu.e = paramIntent[0];
            atqu.f = paramIntent[1];
            atqu.g = paramIntent[2];
            atqu.h = paramIntent[3];
            atqu.i = paramIntent[4];
            atqu.j = paramIntent[5];
            atqu.a = paramIntent[6];
            atqu.b = paramIntent[7];
            atqu.c = paramIntent[8];
            if (QLog.isColorLevel()) {
              QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(paramIntent));
            }
          }
          if (((localParcelable instanceof CompressInfo)) && (localBinderWarpper != null))
          {
            paramIntent = adyl.a(localBinderWarpper.a);
            a((CompressInfo)localParcelable, paramIntent);
          }
          axwd.a();
          return;
        case 2: 
          try
          {
            l = System.currentTimeMillis();
            awrn.a(this);
            if (QLog.isColorLevel()) {
              QLog.d("PeakService", 2, "step : init StatisticCollector use = " + (System.currentTimeMillis() - l));
            }
            l = System.currentTimeMillis();
            new PtvCameraCaptureActivity();
            new QIMCameraCaptureActivity();
            new bhxh();
            if (QLog.isColorLevel()) {
              QLog.d("PeakService", 2, "step : init Activity use = " + (System.currentTimeMillis() - l));
            }
            l = System.currentTimeMillis();
            alqk.a();
            if (QLog.isColorLevel()) {
              QLog.d("PeakService", 2, "step : init CameraHolder use = " + (System.currentTimeMillis() - l));
            }
            l = System.currentTimeMillis();
            awlw.c();
            if (QLog.isColorLevel())
            {
              QLog.d("PeakService", 1, "step : init SVFilter use = " + (System.currentTimeMillis() - l));
              return;
            }
          }
          catch (Throwable paramIntent)
          {
            QLog.e("PeakService", 1, "", paramIntent);
            return;
          }
        }
      }
      l = System.currentTimeMillis();
      i = auto.a();
      bjef.a();
      CameraCaptureView.a.a(PeakAppInterface.a);
      CameraCaptureView.a.b(i);
      bgxr.a();
      bool = autt.b();
    } while (!QLog.isColorLevel());
    QLog.d("PeakService", 2, new Object[] { "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - l), " soloaded:", Boolean.valueOf(bool), " selectCamera:", Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */