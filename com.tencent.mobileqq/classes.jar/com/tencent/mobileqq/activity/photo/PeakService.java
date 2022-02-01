package com.tencent.mobileqq.activity.photo;

import ahtv;
import ahtw;
import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import aqmc;
import azlg;
import bbhk;
import bbhm;
import bdbf;
import bdee;
import bmuw;
import bmwb;
import bnkt;
import bnky;
import bnqu;
import bnrh;
import bnst;
import bofz;
import bpnj;
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
import java.util.Arrays;
import mqq.os.MqqHandler;

public class PeakService
  extends IntentService
{
  public static String a = "StoryTrace_";
  
  public PeakService()
  {
    super("PeakService");
    bnrh.b("PeakService", "[PeakService]");
  }
  
  public void a(CompressInfo paramCompressInfo, ahtv paramahtv)
  {
    azlg.a(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramahtv != null)
    {
      if (!paramCompressInfo.a) {
        break label64;
      }
      paramahtv.a(paramCompressInfo);
    }
    for (;;)
    {
      paramahtv.c(paramCompressInfo);
      return;
      label64:
      paramahtv.b(paramCompressInfo);
    }
  }
  
  public void onDestroy()
  {
    bnrh.b("PeakService", "[onDestroy]");
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
      bnrh.b("PeakService", "onHandleIntent, action = " + i);
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
          azli.e = paramIntent[0];
          azli.f = paramIntent[1];
          azli.g = paramIntent[2];
          azli.h = paramIntent[3];
          azli.i = paramIntent[4];
          azli.j = paramIntent[5];
          azli.a = paramIntent[6];
          azli.b = paramIntent[7];
          azli.c = paramIntent[8];
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(paramIntent));
          }
        }
        if (((localParcelable instanceof CompressInfo)) && (localBinderWarpper != null))
        {
          paramIntent = ahtw.a(localBinderWarpper.a);
          a((CompressInfo)localParcelable, paramIntent);
        }
        CommonImgThumbHelper.initAioThumbSizeByDpc();
        return;
      case 2: 
        bool = paramIntent.getBooleanExtra("key_alive", false);
        bnst.a().a(bool);
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
          aqmc.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 2, "step : init CameraHolder use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          bdee.a();
          if (QLog.isColorLevel()) {
            QLog.d("PeakService", 1, "step : init SVFilter use = " + (System.currentTimeMillis() - l));
          }
          AECameraGLSurfaceView.initSdk();
          if (bnky.a(bnkt.b))
          {
            bnrh.d("PeakService", "[loadBasicFeatures] start");
            FeatureManager.loadBasicFeatures();
            bnrh.d("PeakService", "[loadBasicFeatures] end");
          }
          bofz.a();
          bmuw.a(-1000, null, null);
          bnqu.a().a("fake_key", "", 4);
          return;
        }
        catch (Throwable paramIntent)
        {
          QLog.e("PeakService", 1, "", paramIntent);
          return;
        }
      case 3: 
        l = System.currentTimeMillis();
        i = bbhk.a();
        bpnj.a();
        CameraCaptureView.a.a(PeakAppInterface.a);
        CameraCaptureView.a.b(i);
        bmwb.a();
        bool = bbhm.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("PeakService", 2, new Object[] { "cameraCreate finish, cost:", Long.valueOf(System.currentTimeMillis() - l), " soloaded:", Boolean.valueOf(bool), " selectCamera:", Integer.valueOf(i) });
    return;
    bnrh.b("PeakService", "[ACTION_START_EDITOR_MISSON] receive");
    paramIntent = paramIntent.getStringExtra("generate_mission");
    bnst.a().a();
    bnst.a().a(paramIntent);
    return;
    boolean bool = paramIntent.getBooleanExtra("key_alive", false);
    bnst.a().a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */