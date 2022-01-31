package com.tencent.mobileqq.activity.photo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack.Stub;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.camera.CameraHolder;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.fragment.AIOEffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.fragment.QuickShootEffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.util.Arrays;
import mqq.os.MqqHandler;
import wtm;

public class PeakService
  extends IntentService
{
  public PeakService()
  {
    super("PeakService");
    if (QLog.isColorLevel())
    {
      int i = URLDrawable.getPoolSize();
      QLog.i("URLDrawableOptions", 2, "URLDrawableOptions peak hit is size " + i);
    }
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
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PeakService", 2, "onHandleIntent: intent is null");
      }
      return;
    }
    int i = paramIntent.getIntExtra("ServiceAction", -1);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "onHandleIntent, action = " + i);
    }
    switch (i)
    {
    default: 
      paramIntent = ThreadManager.getFileThreadHandler();
      if (paramIntent != null)
      {
        paramIntent.removeCallbacks(FileUtils.a);
        paramIntent.postDelayed(FileUtils.a, 1000L);
      }
      ThreadManager.post(new wtm(this), 1, null, true);
    }
    for (;;)
    {
      URLDrawableHelper.a();
      return;
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
      if ((!(localParcelable instanceof CompressInfo)) || (localBinderWarpper == null)) {
        continue;
      }
      paramIntent = ICompressionCallBack.Stub.a(localBinderWarpper.a);
      a((CompressInfo)localParcelable, paramIntent);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("sv-start", 2, "step : load class begin: " + System.currentTimeMillis());
      }
      try
      {
        new CameraCaptureActivity();
        new AIOEffectsCameraCaptureFragment();
        new QuickShootEffectsCameraCaptureFragment();
        new SmallVideoCameraCaptureFragment();
        try
        {
          long l = System.currentTimeMillis();
          CaptureVideoFilterManager.a();
          if (QLog.isColorLevel()) {
            QLog.d("sv-start", 2, "step : CaptureVideoFilterManager.getInstance use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          CameraHolder.a();
          if (QLog.isColorLevel()) {
            QLog.d("sv-start", 2, "step : CameraHolder.instance() use = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          CameraHelper.a();
          if (QLog.isColorLevel()) {
            QLog.d("sv-start", 1, "CameraHelper.getLastCamera() use time = " + (System.currentTimeMillis() - l));
          }
          l = System.currentTimeMillis();
          CaptureUtil.f();
          PtvFilterSoLoad.b();
          if (QLog.isColorLevel()) {
            QLog.d("sv-start", 1, "isSupportBeauty isSupportFaceEffect start use time = " + (System.currentTimeMillis() - l));
          }
        }
        catch (Throwable paramIntent)
        {
          for (;;)
          {
            QLog.e("sv-start", 1, "", paramIntent);
          }
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("sv-start", 2, "step : load class end: " + System.currentTimeMillis());
      }
      catch (Throwable paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PeakService
 * JD-Core Version:    0.7.0.1
 */