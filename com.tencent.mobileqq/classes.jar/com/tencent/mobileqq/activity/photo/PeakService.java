package com.tencent.mobileqq.activity.photo;

import ahur;
import ahus;
import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import aqan;
import ayyz;
import bani;
import bann;
import bcio;
import bcls;
import bctj;
import bdzx;
import bgmg;
import bnby;
import bndd;
import bnpt;
import bnpy;
import bnyp;
import bnzb;
import bnzw;
import bojl;
import bows;
import bqcb;
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
    bnzb.b("PeakService", "[PeakService]");
  }
  
  public void a(CompressInfo paramCompressInfo, ahur paramahur)
  {
    ayyz.a(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramahur != null)
    {
      if (!paramCompressInfo.a) {
        break label64;
      }
      paramahur.a(paramCompressInfo);
    }
    for (;;)
    {
      paramahur.c(paramCompressInfo);
      return;
      label64:
      paramahur.b(paramCompressInfo);
    }
  }
  
  public void onDestroy()
  {
    bnzb.b("PeakService", "[onDestroy]");
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
      bnzb.b("PeakService", "onHandleIntent, action = " + i);
      switch (i)
      {
      default: 
        paramIntent = ThreadManager.getFileThreadHandler();
        if (paramIntent != null)
        {
          paramIntent.removeCallbacks(bgmg.a);
          paramIntent.postDelayed(bgmg.a, 1000L);
        }
        ThreadManager.excute(new PeakService.2(this), 64, null, true);
        return;
      case 1: 
        Parcelable localParcelable = paramIntent.getParcelableExtra("CompressInfo");
        BinderWarpper localBinderWarpper = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
        paramIntent = paramIntent.getIntArrayExtra("CompressConfig");
        if ((paramIntent != null) && (paramIntent.length >= 9))
        {
          ayzb.e = paramIntent[0];
          ayzb.f = paramIntent[1];
          ayzb.g = paramIntent[2];
          ayzb.h = paramIntent[3];
          ayzb.i = paramIntent[4];
          ayzb.j = paramIntent[5];
          ayzb.a = paramIntent[6];
          ayzb.b = paramIntent[7];
          ayzb.c = paramIntent[8];
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(paramIntent));
          }
        }
        if (((localParcelable instanceof CompressInfo)) && (localBinderWarpper != null))
        {
          paramIntent = ahus.a(localBinderWarpper.a);
          a((CompressInfo)localParcelable, paramIntent);
        }
        bdzx.a();
        return;
      case 2: 
        bool = paramIntent.getBooleanExtra("key_alive", false);
        bnzw.a().a(bool);
        try
        {
          l = System.currentTimeMillis();
          bctj.a(this);
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init StatisticCollector use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          new PtvCameraCaptureActivity();
          new QIMCameraCaptureActivity();
          new bows();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init Activity use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          aqan.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init CameraHolder use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          bcls.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 1, "step : init SVFilter use = " + (System.currentTimeMillis() - l));
          }
          AECameraGLSurfaceView.e();
          if (bnpy.a(bnpt.b))
          {
            bnzb.d("PeakService", "[loadBasicFeatures] start");
            FeatureManager.loadBasicFeatures();
            bnzb.d("PeakService", "[loadBasicFeatures] end");
          }
          bojl.a();
          bnby.a(-1000, null, null);
          bnyp.a().a("fake_key", "", 4);
          return;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("PeakService", 1, "", paramIntent);
          return;
        }
      case 3: 
        l = System.currentTimeMillis();
        i = bani.a();
        bqcb.a();
        CameraCaptureView.a.a(PeakAppInterface.a);
        CameraCaptureView.a.b(i);
        bndd.a();
        bool = bann.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("PeakService", 2, new Object[] { "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - l), " soloaded:", Boolean.valueOf(bool), " selectCamera:", Integer.valueOf(i) });
    return;
    bnzb.b("PeakService", "[ACTION_START_EDITOR_MISSON] receive");
    paramIntent = paramIntent.getStringExtra("generate_mission");
    bnzw.a().a();
    bnzw.a().c(paramIntent);
    return;
    boolean bool = paramIntent.getBooleanExtra("key_alive", false);
    bnzw.a().a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */