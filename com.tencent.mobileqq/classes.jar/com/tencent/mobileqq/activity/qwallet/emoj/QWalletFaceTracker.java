package com.tencent.mobileqq.activity.qwallet.emoj;

import ahbv;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ltu;
import ltv;
import ltw;

public class QWalletFaceTracker
{
  public static final String TAG = QWalletFaceTracker.class.getSimpleName();
  public static volatile QWalletFaceTracker sInstance;
  public List<QWalletFaceTracker.ExpressionInfo> expressionItemList;
  public volatile boolean hasSDkInit;
  public boolean hasSoInit;
  public String[] modelPathsAlign = { "align.stb", "align583.rpdm", "align583_bin.rpdc", "eye.rpdm", "eye_bin.rpdc", "eyebrow.rpdm", "eyebrow_bin.rpdc", "mouth.rpdm", "mouth_bin.rpdc", "refine1.rmd", "refine2.rmd" };
  public String[] modelPathsDetector = { "net_1_bin.rpnproto", "net_1.rpnmodel", "net_2_bin.rpnproto", "net_2.rpnmodel", "net_3_bin.rpnproto", "net_3.rpnmodel" };
  public String[] modelPathsPose = { "meshBasis.bin", "rotBasis.bin", "pdm.txt", "pdm_82.txt" };
  private long nativePtr;
  public ltv normalFaceExpression;
  public final String[] soFileNames = { "libYTIllumination.so", "libfacetrackwrap.so" };
  public final String[] soNames = { "YTIllumination", "facetrackwrap" };
  
  public static native boolean GlobalInit(String paramString);
  
  public static native boolean GlobalRelease();
  
  private native void NativeDestructor();
  
  private boolean checkMoreLikeNormalFaceExpression(float paramFloat, double paramDouble, double[] paramArrayOfDouble, int[] paramArrayOfInt, ltv paramltv, List<PointF> paramList, float[] paramArrayOfFloat)
  {
    paramltv.expressionWeight = paramArrayOfDouble;
    paramltv.a = paramArrayOfInt;
    return ltu.a(paramltv, paramList, paramArrayOfFloat).a * paramDouble - paramFloat > 0.0D;
  }
  
  public static QWalletFaceTracker getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QWalletFaceTracker();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static native boolean nativeInit();
  
  public native QWalletFaceTracker.FaceStatus[] DoDetectionProcessBitmap(Bitmap paramBitmap);
  
  public native QWalletFaceTracker.FaceStatus[] DoDetectionProcessYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native QWalletFaceTracker.FaceStatus3d[] DoDetectionProcessYUVPoses(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void NativeConstructor();
  
  public native Bitmap convertYUV2Bitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public void init(Context paramContext, String paramString1, String paramString2, IBaseRecognizer paramIBaseRecognizer)
  {
    try
    {
      ahbv localahbv = PreloadManager.a();
      DownloadParam localDownloadParam = new DownloadParam();
      localDownloadParam.filePos = 1;
      localDownloadParam.url = paramString1;
      localahbv.a(localDownloadParam, new QWalletFaceTracker.1(this, paramString1, paramString2, paramContext, paramIBaseRecognizer));
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QLog.e(TAG, 1, " occur an error: " + paramContext);
        this.hasSDkInit = false;
        if (paramIBaseRecognizer != null) {
          paramIBaseRecognizer.OnInitResultCallback(this.hasSDkInit);
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public void onPreviewFrameHandler(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, QWalletFaceTracker.OnPreviewFrameHandlerListener paramOnPreviewFrameHandlerListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 200	com/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker:hasSDkInit	Z
    //   6: istore 7
    //   8: iload 7
    //   10: ifne +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new 210	com/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker$2
    //   19: dup
    //   20: aload_0
    //   21: aload_1
    //   22: iload_3
    //   23: iload 4
    //   25: iload 5
    //   27: iload_2
    //   28: aload 6
    //   30: invokespecial 213	com/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker$2:<init>	(Lcom/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker;[BIIIILcom/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker$OnPreviewFrameHandlerListener;)V
    //   33: bipush 16
    //   35: aconst_null
    //   36: iconst_1
    //   37: invokestatic 219	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   40: goto -27 -> 13
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	QWalletFaceTracker
    //   0	48	1	paramArrayOfByte	byte[]
    //   0	48	2	paramInt1	int
    //   0	48	3	paramInt2	int
    //   0	48	4	paramInt3	int
    //   0	48	5	paramInt4	int
    //   0	48	6	paramOnPreviewFrameHandlerListener	QWalletFaceTracker.OnPreviewFrameHandlerListener
    //   6	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	43	finally
    //   16	40	43	finally
  }
  
  public void unInit()
  {
    try
    {
      NativeDestructor();
      GlobalRelease();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker
 * JD-Core Version:    0.7.0.1
 */