package com.tencent.mobileqq.activity.qwallet.emoj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.hardware.Camera;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openai.ttpicmodule.AEHandDetector;

public class HandRecognizer
{
  public static final String TAG = HandRecognizer.class.getSimpleName();
  private static volatile HandRecognizer sInstance;
  private Runnable DoHandDetecting = new HandRecognizer.1(this);
  public YtHandBox box = new YtHandBox();
  public final String handAlignmentModel = "add_p_tu_1130_800k.rpdm";
  public final String handClassifyModel = "v3.0_int8_resnet18_3MB_1130.pb.rapidnetmodel_nhwc";
  public final String handClassifyProto = "v3.0_int8_resnet18_3MB_1130.pb_bin.rapidnetproto_nhwc";
  public final String handDetectionModel = "v3.0_1130_add_lift_epoch40.rapidnetmodel_nchw";
  public final String handDetectionProto = "v3.0_1130_add_lift_epoch40_bin.rapidnetproto_nchw_mod";
  public volatile boolean hasSDkInit;
  public boolean isDetecting;
  public boolean isTracking;
  private AEHandDetector mDetector = new AEHandDetector();
  private Bitmap rgbaBitmap;
  public final String[] soFileNames = { "libYTHandDetector.so", "libnative-lib.so" };
  public final String[] soNames = { "YTHandDetector", "native-lib" };
  public YtHandBox stable_box = new YtHandBox();
  
  public static HandRecognizer getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new HandRecognizer();
      }
      return sInstance;
    }
    finally {}
  }
  
  public native int doHandAlignment(YtHandBox paramYtHandBox1, YtHandBox paramYtHandBox2);
  
  public native int doHandClassify(YtHandBox paramYtHandBox, YtHandLabel paramYtHandLabel);
  
  public native int doHandClassifyWithGesture(YtHandBox paramYtHandBox, int paramInt, YtHandClassifyResult paramYtHandClassifyResult);
  
  public native int doHandDetection(YtHandBox paramYtHandBox);
  
  public native int doHandStable(YtHandBox paramYtHandBox1, YtHandBox paramYtHandBox2);
  
  public native String getNameOfLabel(int paramInt);
  
  public void init(Context paramContext, String paramString, IBaseRecognizer paramIBaseRecognizer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "init finished handResFolderPath: " + paramString);
      }
      this.hasSDkInit = this.mDetector.init(paramString, paramString);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QLog.e(TAG, 1, " occur an error: " + paramContext);
        this.hasSDkInit = false;
      }
    }
    finally {}
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "SDkInit : " + this.hasSDkInit);
    }
    if (paramIBaseRecognizer != null) {
      paramIBaseRecognizer.OnInitResultCallback(this.hasSDkInit);
    }
  }
  
  public native int initHandAlignment(String paramString);
  
  public native int initHandClassify(String paramString1, String paramString2);
  
  public native int initHandDetection(String paramString1, String paramString2);
  
  public void onPreviewFrameHandler(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Camera paramCamera, int paramInt3, HandRecognizer.OnPreviewFrameHandlerListener paramOnPreviewFrameHandlerListener)
  {
    if (!this.hasSDkInit) {
      return;
    }
    ThreadManagerV2.excute(new HandRecognizer.2(this, paramCamera, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramOnPreviewFrameHandlerListener), 16, null, true);
  }
  
  public native int releaseHandAlignment();
  
  public native int releaseHandClassify();
  
  public native int releaseHandDetection();
  
  public void unInit()
  {
    try
    {
      this.mDetector.clear();
      releaseHandAlignment();
      releaseHandClassify();
      releaseHandDetection();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public native Bitmap updateBufferAndCvt2Bitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Bitmap.Config paramConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer
 * JD-Core Version:    0.7.0.1
 */