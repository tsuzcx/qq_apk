package com.tencent.mobileqq.activity.qwallet.emoj;

import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lsy;
import lsz;
import lta;

public class QWalletFaceTracker
{
  public static final String TAG = QWalletFaceTracker.class.getSimpleName();
  public static volatile QWalletFaceTracker sInstance;
  public List<QWalletFaceTracker.ExpressionInfo> expressionItemList;
  public volatile boolean hasSDkInit;
  public boolean hasSoInit;
  private QQFilterRenderManager mQQFilterRenderManager;
  public String[] modelPathsAlign = { "align.stb", "align583.rpdm", "align583_bin.rpdc", "eye.rpdm", "eye_bin.rpdc", "eyebrow.rpdm", "eyebrow_bin.rpdc", "mouth.rpdm", "mouth_bin.rpdc", "refine1.rmd", "refine2.rmd" };
  public String[] modelPathsDetector = { "net_1_bin.rpnproto", "net_1.rpnmodel", "net_2_bin.rpnproto", "net_2.rpnmodel", "net_3_bin.rpnproto", "net_3.rpnmodel" };
  public String[] modelPathsPose = { "meshBasis.bin", "rotBasis.bin", "pdm.txt", "pdm_82.txt" };
  private long nativePtr;
  public lsz normalFaceExpression;
  public final String[] soFileNames = { "libYTIllumination.so", "libfacetrackwrap.so" };
  public final String[] soNames = { "YTIllumination", "facetrackwrap" };
  
  private boolean checkMoreLikeNormalFaceExpression(float paramFloat, double paramDouble, double[] paramArrayOfDouble, int[] paramArrayOfInt, lsz paramlsz, List<PointF> paramList, float[] paramArrayOfFloat)
  {
    paramlsz.expressionWeight = paramArrayOfDouble;
    paramlsz.a = paramArrayOfInt;
    return lsy.a(paramlsz, paramList, paramArrayOfFloat).a * paramDouble - paramFloat > 0.0D;
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
  
  public void init(Context paramContext, String paramString, IBaseRecognizer paramIBaseRecognizer)
  {
    for (;;)
    {
      try
      {
        this.mQQFilterRenderManager = EffectsCameraCaptureView.b();
        if (this.mQQFilterRenderManager != null) {
          this.mQQFilterRenderManager.setFaceDetectFlags(true);
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "[init] configPath=" + paramString + ",baseRecognizer=" + paramIBaseRecognizer);
        }
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        this.hasSDkInit = true;
        if (this.expressionItemList == null) {
          this.expressionItemList = FaceDetector.getInstance().parseExpressionConfigFromJson(paramContext, paramString, "expression");
        }
        if ((this.normalFaceExpression == null) && (this.expressionItemList != null) && (this.expressionItemList.size() > 0))
        {
          paramContext = this.expressionItemList.iterator();
          if (paramContext.hasNext())
          {
            paramString = (QWalletFaceTracker.ExpressionInfo)paramContext.next();
            if (!paramString.expressionItem.expressionID.equals("99")) {
              continue;
            }
            this.normalFaceExpression = paramString.expressionItem;
          }
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e(TAG, 1, " occur an error: " + paramContext);
        this.hasSDkInit = false;
        continue;
      }
      finally {}
      if (paramIBaseRecognizer != null) {
        paramIBaseRecognizer.OnInitResultCallback(this.hasSDkInit);
      }
      return;
      this.hasSDkInit = false;
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "configPath invalid");
      }
    }
  }
  
  /* Error */
  public void onPreviewFrameHandler(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, QWalletFaceTracker.OnPreviewFrameHandlerListener paramOnPreviewFrameHandlerListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 190	com/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker:hasSDkInit	Z
    //   6: ifne +21 -> 27
    //   9: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: getstatic 36	com/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker:TAG	Ljava/lang/String;
    //   18: iconst_2
    //   19: ldc 254
    //   21: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: new 256	com/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker$1
    //   30: dup
    //   31: aload_0
    //   32: iload 5
    //   34: iload_2
    //   35: aload 6
    //   37: invokespecial 259	com/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker$1:<init>	(Lcom/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker;IILcom/tencent/mobileqq/activity/qwallet/emoj/QWalletFaceTracker$OnPreviewFrameHandlerListener;)V
    //   40: bipush 16
    //   42: aconst_null
    //   43: iconst_1
    //   44: invokestatic 265	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   47: goto -23 -> 24
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	QWalletFaceTracker
    //   0	55	1	paramArrayOfByte	byte[]
    //   0	55	2	paramInt1	int
    //   0	55	3	paramInt2	int
    //   0	55	4	paramInt3	int
    //   0	55	5	paramInt4	int
    //   0	55	6	paramOnPreviewFrameHandlerListener	QWalletFaceTracker.OnPreviewFrameHandlerListener
    // Exception table:
    //   from	to	target	type
    //   2	24	50	finally
    //   27	47	50	finally
  }
  
  public void unInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker
 * JD-Core Version:    0.7.0.1
 */