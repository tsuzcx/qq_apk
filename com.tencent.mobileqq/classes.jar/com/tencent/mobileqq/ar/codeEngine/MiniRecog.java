package com.tencent.mobileqq.ar.codeEngine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.arengine.MiniSaveImgListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.mobileqq.qrscan.OnMiniCodeDetectCallback;
import com.tencent.mobileqq.qrscan.OnMiniCodeInitCallback;
import com.tencent.mobileqq.qrscan.QRScanUtil;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MiniRecog
  implements OnMiniCodeDetectCallback, OnMiniCodeInitCallback
{
  public static boolean c = true;
  public static boolean d = false;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  Handler jdField_a_of_type_AndroidOsHandler;
  MiniSaveImgListener jdField_a_of_type_ComTencentMobileqqArArengineMiniSaveImgListener;
  volatile boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  int c = -2147483648;
  
  public MiniRecog(Handler paramHandler, Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect)
  {
    if ((paramInt1 != this.jdField_a_of_type_Int) || (paramInt2 != this.jdField_b_of_type_Int) || (this.jdField_a_of_type_AndroidGraphicsRect == null))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, paramRect.height(), paramRect.width());
      this.jdField_a_of_type_AndroidGraphicsRect.offset(paramRect.top, paramRect.left);
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, String.format("-----> recognizeDetect Mini [preW,preH]=[%d,%d] scanRect=%s rotateScanRect=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRect, this.jdField_a_of_type_AndroidGraphicsRect }));
      }
    }
    System.currentTimeMillis();
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, paramArrayOfByte.getMessage(), paramArrayOfByte);
      }
      paramArrayOfByte = null;
    }
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramRect = Bitmap.createBitmap(paramArrayOfByte, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height());
      if (paramRect != paramArrayOfByte) {
        paramArrayOfByte.recycle();
      }
      return paramRect;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, "recognizeDetect exception", paramArrayOfByte);
      }
    }
    return null;
  }
  
  private String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (!((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).isDecodeInited()) {
      return null;
    }
    paramArrayOfByte = ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).decode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recognizeNoAI resultStr:");
      localStringBuilder.append(paramArrayOfByte);
      QLog.i("QRSession.MiniRecog", 2, localStringBuilder.toString());
    }
    if (((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).bValidDecodeResult(paramArrayOfByte)) {
      return paramArrayOfByte;
    }
    return null;
  }
  
  public int a()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).addInitCallback(this);
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).addDetectCallback(this);
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).init(this.jdField_a_of_type_AndroidContentContext, hashCode(), "MiniRecog");
    this.c = ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).getSupportDetectType();
    boolean bool;
    if (this.c > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
    return 0;
  }
  
  public Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ArrayOfInt.length != paramInt1 * paramInt2)) {
        this.jdField_a_of_type_ArrayOfInt = new int[paramInt1 * paramInt2];
      }
      if (((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).yuv2Rgba(this.jdField_a_of_type_ArrayOfInt, paramArrayOfByte, paramInt1, paramInt2) == 0)
      {
        paramArrayOfByte = Bitmap.createBitmap(this.jdField_a_of_type_ArrayOfInt, paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        return paramArrayOfByte;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      QLog.i("QRSession.MiniRecog", 2, "getBitmapFromYuv error ", paramArrayOfByte);
    }
    return null;
  }
  
  public void a()
  {
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).removeInitCallback(this);
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).removeDetectCallback(this);
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).unInit(hashCode(), "MiniRecog");
  }
  
  public void a(int paramInt)
  {
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    if ((QLog.isColorLevel()) || (((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn())) {
      QLog.i("QRSession.MiniRecog", 1, String.format("base_test_scan mini_detect_init consume=%d", new Object[] { Long.valueOf(l) }));
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniRecog.2(this));
    ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).onDetectInitCost(this.c, (int)l);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniRecog.1(this, paramLong));
  }
  
  public void a(MiniSaveImgListener paramMiniSaveImgListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineMiniSaveImgListener = paramMiniSaveImgListener;
  }
  
  public void a(List<AIRect> paramList, long paramLong) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, Rect paramRect, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, ScannerResult paramScannerResult, ArrayList<AIRect> paramArrayList, AtomicInteger paramAtomicInteger)
  {
    if (!((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).isDecodeInited()) {
      return false;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).isDetectInited()) && (((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).isDetectReady())) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramAtomicInteger.get();
    boolean bool = this.jdField_b_of_type_Boolean;
    Object localObject2 = "QRSession.MiniRecog";
    if ((bool) && (i != 0) && (j < 3))
    {
      paramScannerResult.jdField_a_of_type_Boolean = true;
      Object localObject1 = a(paramArrayOfByte1, paramInt1, paramInt2, paramRect);
      if (localObject1 == null) {
        return false;
      }
      paramArrayOfByte1 = new ArrayList();
      bool = ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).detectSync((Bitmap)localObject1, paramArrayOfByte1);
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, String.format("recognize exec=%b, detectRects=%s", new Object[] { Boolean.valueOf(bool), paramArrayOfByte1 }));
      }
      ((Bitmap)localObject1).recycle();
      localObject1 = localObject2;
      i = j;
      if (bool)
      {
        localObject1 = localObject2;
        i = j;
        if (!paramArrayOfByte1.isEmpty())
        {
          Iterator localIterator = paramArrayOfByte1.iterator();
          paramArrayOfByte1 = (byte[])localObject2;
          for (;;)
          {
            int k = paramInt3;
            localObject2 = this;
            localObject1 = paramArrayOfByte1;
            i = j;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = (AIRect)localIterator.next();
            if (!((AIRect)localObject1).jdField_a_of_type_AndroidGraphicsRect.isEmpty())
            {
              Object localObject3 = new Rect(((AIRect)localObject1).jdField_a_of_type_AndroidGraphicsRect);
              ((Rect)localObject3).offset(((MiniRecog)localObject2).jdField_a_of_type_AndroidGraphicsRect.left, ((MiniRecog)localObject2).jdField_a_of_type_AndroidGraphicsRect.top);
              localObject2 = new AIRect();
              ((AIRect)localObject2).jdField_a_of_type_AndroidGraphicsRect.set((Rect)localObject3);
              ((AIRect)localObject2).jdField_a_of_type_Int = ((AIRect)localObject1).jdField_a_of_type_Int;
              ((AIRect)localObject2).jdField_a_of_type_Float = ((AIRect)localObject1).jdField_a_of_type_Float;
              paramArrayList.add(localObject2);
              if (((AIRect)localObject1).jdField_a_of_type_Int == 2)
              {
                localObject3 = new Rect();
                localObject2 = new Rect();
                ((Rect)localObject2).set(0, 0, ((AIRect)localObject1).jdField_a_of_type_AndroidGraphicsRect.height(), ((AIRect)localObject1).jdField_a_of_type_AndroidGraphicsRect.width());
                ((Rect)localObject2).offset(k - ((AIRect)localObject1).jdField_a_of_type_AndroidGraphicsRect.top - ((AIRect)localObject1).jdField_a_of_type_AndroidGraphicsRect.height(), ((AIRect)localObject1).jdField_a_of_type_AndroidGraphicsRect.left);
                QRScanUtil.a((Rect)localObject2, (Rect)localObject3, k, paramInt4, 1.2F);
                localObject3 = a(paramArrayOfByte2, paramInt3, paramInt4, ((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).width(), ((Rect)localObject3).height());
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  ((Rect)localObject2).offset(paramRect.left, paramRect.top);
                  paramScannerResult.a((String)localObject3, (Rect)localObject2, ((AIRect)localObject1).jdField_a_of_type_Float, paramInt2, paramInt1);
                }
                else
                {
                  paramAtomicInteger.getAndIncrement();
                }
              }
            }
          }
        }
      }
      paramArrayOfByte1 = (byte[])localObject1;
      paramInt1 = i;
    }
    else
    {
      paramRect = "QRSession.MiniRecog";
      paramAtomicInteger.set(0);
      paramArrayOfByte2 = a(paramArrayOfByte2, paramInt3, paramInt4, 0, 0, 0, 0);
      paramScannerResult.jdField_a_of_type_Boolean = false;
      paramArrayOfByte1 = paramRect;
      paramInt1 = j;
      if (!TextUtils.isEmpty(paramArrayOfByte2))
      {
        paramScannerResult.a(paramArrayOfByte2);
        paramInt1 = j;
        paramArrayOfByte1 = paramRect;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(paramArrayOfByte1, 2, String.format("------>recognize Mini suc=%b minicode_timecost=%d lastHitAiButMissDecodeCnt=%d result=%s \nrects=%s", new Object[] { Boolean.valueOf(paramScannerResult.c()), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(paramInt1), paramScannerResult, paramArrayList }));
    }
    return paramScannerResult.c();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniRecog
 * JD-Core Version:    0.7.0.1
 */