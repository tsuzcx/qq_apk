package com.tencent.mobileqq.activity.photo;

import aief;
import aieg;
import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import aqpp;
import azrm;
import bbgb;
import bbgg;
import bdbg;
import bdek;
import bdmc;
import besm;
import bhmi;
import bodg;
import boem;
import borf;
import bork;
import bozz;
import bpam;
import bpbr;
import bplg;
import bpyn;
import brdw;
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
    bpam.b("PeakService", "[PeakService]");
  }
  
  public void a(CompressInfo paramCompressInfo, aief paramaief)
  {
    azrm.a(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramaief != null)
    {
      if (!paramCompressInfo.a) {
        break label64;
      }
      paramaief.a(paramCompressInfo);
    }
    for (;;)
    {
      paramaief.c(paramCompressInfo);
      return;
      label64:
      paramaief.b(paramCompressInfo);
    }
  }
  
  public void onDestroy()
  {
    bpam.b("PeakService", "[onDestroy]");
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
      bpam.b("PeakService", "onHandleIntent, action = " + i);
      switch (i)
      {
      default: 
        paramIntent = ThreadManager.getFileThreadHandler();
        if (paramIntent != null)
        {
          paramIntent.removeCallbacks(bhmi.a);
          paramIntent.postDelayed(bhmi.a, 1000L);
        }
        ThreadManager.excute(new PeakService.2(this), 64, null, true);
        return;
      case 1: 
        Parcelable localParcelable = paramIntent.getParcelableExtra("CompressInfo");
        BinderWarpper localBinderWarpper = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
        paramIntent = paramIntent.getIntArrayExtra("CompressConfig");
        if ((paramIntent != null) && (paramIntent.length >= 9))
        {
          azro.e = paramIntent[0];
          azro.f = paramIntent[1];
          azro.g = paramIntent[2];
          azro.h = paramIntent[3];
          azro.i = paramIntent[4];
          azro.j = paramIntent[5];
          azro.a = paramIntent[6];
          azro.b = paramIntent[7];
          azro.c = paramIntent[8];
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(paramIntent));
          }
        }
        if (((localParcelable instanceof CompressInfo)) && (localBinderWarpper != null))
        {
          paramIntent = aieg.a(localBinderWarpper.a);
          a((CompressInfo)localParcelable, paramIntent);
        }
        besm.a();
        return;
      case 2: 
        bool = paramIntent.getBooleanExtra("key_alive", false);
        bpbr.a().a(bool);
        try
        {
          l = System.currentTimeMillis();
          bdmc.a(this);
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init StatisticCollector use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          new PtvCameraCaptureActivity();
          new QIMCameraCaptureActivity();
          new bpyn();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init Activity use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          aqpp.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init CameraHolder use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          bdek.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 1, "step : init SVFilter use = " + (System.currentTimeMillis() - l));
          }
          AECameraGLSurfaceView.e();
          if (bork.a(borf.b))
          {
            bpam.d("PeakService", "[loadBasicFeatures] start");
            FeatureManager.loadBasicFeatures();
            bpam.d("PeakService", "[loadBasicFeatures] end");
          }
          bplg.a();
          bodg.a(-1000, null, null);
          bozz.a().a("fake_key", "", 4);
          return;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("PeakService", 1, "", paramIntent);
          return;
        }
      case 3: 
        l = System.currentTimeMillis();
        i = bbgb.a();
        brdw.a();
        CameraCaptureView.a.a(PeakAppInterface.a);
        CameraCaptureView.a.b(i);
        boem.a();
        bool = bbgg.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("PeakService", 2, new Object[] { "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - l), " soloaded:", Boolean.valueOf(bool), " selectCamera:", Integer.valueOf(i) });
    return;
    bpam.b("PeakService", "[ACTION_START_EDITOR_MISSON] receive");
    paramIntent = paramIntent.getStringExtra("generate_mission");
    bpbr.a().a();
    bpbr.a().c(paramIntent);
    return;
    boolean bool = paramIntent.getBooleanExtra("key_alive", false);
    bpbr.a().a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */