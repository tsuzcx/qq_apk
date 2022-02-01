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
import com.tencent.mobileqq.qrscan.IMiniConst;
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
  public static boolean k = true;
  public static boolean l = false;
  volatile boolean a = false;
  MiniSaveImgListener b;
  Handler c;
  Context d;
  int[] e;
  int f;
  int g;
  Rect h;
  boolean i = false;
  int j = -2147483648;
  long m;
  
  public MiniRecog(Handler paramHandler, Context paramContext)
  {
    this.c = paramHandler;
    this.d = paramContext;
  }
  
  private Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect)
  {
    if ((paramInt1 != this.f) || (paramInt2 != this.g) || (this.h == null))
    {
      this.f = paramInt1;
      this.g = paramInt2;
      this.h = new Rect(0, 0, paramRect.height(), paramRect.width());
      this.h.offset(paramRect.top, paramRect.left);
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, String.format("-----> recognizeDetect Mini [preW,preH]=[%d,%d] scanRect=%s rotateScanRect=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRect, this.h }));
      }
    }
    System.currentTimeMillis();
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, this.f, this.g);
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
      paramRect = Bitmap.createBitmap(paramArrayOfByte, this.h.left, this.h.top, this.h.width(), this.h.height());
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
  
  private String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (!((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).isDecodeInited()) {
      return null;
    }
    paramArrayOfByte = ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).decode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, 0);
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
    this.m = SystemClock.uptimeMillis();
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).addInitCallback(this);
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).addDetectCallback(this);
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).init(this.d, hashCode(), "MiniRecog");
    this.j = ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).getSupportDetectType();
    boolean bool;
    if (this.j > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.i = bool;
    return 0;
  }
  
  public Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.e == null) || (this.e.length != paramInt1 * paramInt2)) {
        this.e = new int[paramInt1 * paramInt2];
      }
      if (((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).yuv2Rgba(this.e, paramArrayOfByte, paramInt1, paramInt2) == 0)
      {
        paramArrayOfByte = Bitmap.createBitmap(this.e, paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
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
  
  public void a(int paramInt)
  {
    long l1 = SystemClock.uptimeMillis() - this.m;
    if ((QLog.isColorLevel()) || (((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn())) {
      QLog.i("QRSession.MiniRecog", 1, String.format("base_test_scan mini_detect_init consume=%d", new Object[] { Long.valueOf(l1) }));
    }
    this.c.post(new MiniRecog.2(this));
    ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).onDetectInitCost(this.j, (int)l1);
  }
  
  public void a(long paramLong)
  {
    this.c.post(new MiniRecog.1(this, paramLong));
  }
  
  public void a(MiniSaveImgListener paramMiniSaveImgListener)
  {
    this.b = paramMiniSaveImgListener;
  }
  
  public void a(List<AIRect> paramList, long paramLong) {}
  
  public boolean a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, Rect paramRect, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, ScannerResult paramScannerResult, ArrayList<AIRect> paramArrayList, AtomicInteger paramAtomicInteger)
  {
    if (!((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).isDecodeInited()) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    int i1;
    if ((((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).isDetectInited()) && (((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).isDetectReady())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int n = paramAtomicInteger.get();
    boolean bool = this.i;
    Object localObject2 = "QRSession.MiniRecog";
    if ((bool) && (i1 != 0) && (n < 3))
    {
      paramScannerResult.c = true;
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
      i1 = n;
      if (bool)
      {
        localObject1 = localObject2;
        i1 = n;
        if (!paramArrayOfByte1.isEmpty())
        {
          Iterator localIterator = paramArrayOfByte1.iterator();
          paramArrayOfByte1 = (byte[])localObject2;
          for (;;)
          {
            localObject2 = this;
            localObject1 = paramArrayOfByte1;
            i1 = n;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = (AIRect)localIterator.next();
            if (!((AIRect)localObject1).b.isEmpty())
            {
              Object localObject3 = new Rect(((AIRect)localObject1).b);
              ((Rect)localObject3).offset(((MiniRecog)localObject2).h.left, ((MiniRecog)localObject2).h.top);
              localObject2 = new AIRect();
              ((AIRect)localObject2).b.set((Rect)localObject3);
              ((AIRect)localObject2).a = ((AIRect)localObject1).a;
              ((AIRect)localObject2).c = ((AIRect)localObject1).c;
              paramArrayList.add(localObject2);
              if ((((AIRect)localObject1).a == 2) || (((AIRect)localObject1).a == 3))
              {
                localObject3 = new Rect();
                localObject2 = new Rect();
                ((Rect)localObject2).set(0, 0, ((AIRect)localObject1).b.height(), ((AIRect)localObject1).b.width());
                ((Rect)localObject2).offset(paramInt3 - ((AIRect)localObject1).b.top - ((AIRect)localObject1).b.height(), ((AIRect)localObject1).b.left);
                QRScanUtil.a((Rect)localObject2, (Rect)localObject3, paramInt3, paramInt4, 1.2F);
                localObject3 = a(paramArrayOfByte2, paramInt3, paramInt4, ((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).width(), ((Rect)localObject3).height(), ((AIRect)localObject1).a);
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  ((Rect)localObject2).offset(paramRect.left, paramRect.top);
                  paramScannerResult.a((String)localObject3, (Rect)localObject2, ((AIRect)localObject1).c, paramInt2, paramInt1, ((AIRect)localObject1).a);
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
      paramInt1 = i1;
    }
    else
    {
      paramRect = "QRSession.MiniRecog";
      paramAtomicInteger.set(0);
      paramArrayOfByte2 = a(paramArrayOfByte2, paramInt3, paramInt4, 0, 0, 0, 0, 0);
      paramScannerResult.c = false;
      paramInt1 = n;
      paramArrayOfByte1 = paramRect;
      if (!TextUtils.isEmpty(paramArrayOfByte2))
      {
        paramArrayOfByte1 = paramArrayOfByte2.substring(0, IMiniConst.a);
        if ("WITHOUTAIQQ&".equals(paramArrayOfByte1)) {
          paramInt1 = 2;
        } else if ("WITHOUTAIWX&".equals(paramArrayOfByte1)) {
          paramInt1 = 3;
        } else {
          paramInt1 = 0;
        }
        paramScannerResult.a(paramArrayOfByte2.substring(IMiniConst.a), paramInt1);
        paramArrayOfByte1 = paramRect;
        paramInt1 = n;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(paramArrayOfByte1, 2, String.format("------>recognize Mini suc=%b minicode_timecost=%d lastHitAiButMissDecodeCnt=%d result=%s \nrects=%s", new Object[] { Boolean.valueOf(paramScannerResult.g()), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(paramInt1), paramScannerResult, paramArrayList }));
    }
    return paramScannerResult.g();
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public void c()
  {
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).removeInitCallback(this);
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).removeDetectCallback(this);
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).unInit(hashCode(), "MiniRecog");
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniRecog
 * JD-Core Version:    0.7.0.1
 */