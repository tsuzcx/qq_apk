package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.ar.FaceScanModelsLoader;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.armap.ARMapTracer;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ARLocalFaceRecog
{
  public static boolean a = true;
  public static Handler g;
  final int A = 10;
  int B = 10;
  private ARFacePreviewResample C;
  FaceCluster b;
  int c;
  int d;
  int e = 90;
  HandlerThread f;
  HandlerThread h;
  Handler i;
  volatile boolean j;
  volatile boolean k;
  long l;
  int m;
  ARScanStarFaceConfigInfo n;
  Context o;
  volatile boolean p;
  Handler.Callback q = new ARLocalFaceRecog.1(this);
  volatile boolean r = false;
  volatile boolean s = false;
  ARLocalFaceRecog.ARLocalFaceRecogCallback t;
  long u;
  List<ARLocalFaceRecog.FaceInfo> v = new ArrayList();
  List<ARLocalFaceRecog.FaceInfo> w = new ArrayList();
  Object x = new Object();
  ARCloudRecogRspFaceResult y;
  long z = -1L;
  
  ARLocalFaceRecog()
  {
    if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.g)) {
      this.e = 270;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ARLocalFaceRecog  rotateDegree = ");
      localStringBuilder.append(this.e);
      QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean a()
  {
    boolean bool = Build.MODEL.equals("vivo X6Plus A");
    if (ARMapTracer.a() == 3) {
      bool = true;
    }
    return bool;
  }
  
  int a(float[][] paramArrayOfFloat, float[] paramArrayOfFloat1)
  {
    int i3 = paramArrayOfFloat.length;
    Object localObject = new float[i3];
    int i1 = 0;
    while (i1 < i3)
    {
      if (paramArrayOfFloat[i1] != null)
      {
        localObject[i1] = this.b.calcuSimilarity(paramArrayOfFloat[i1], paramArrayOfFloat1);
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("findFaceIndexByFaceFeature2 faceFeature is null,i = ");
        localStringBuilder.append(i1);
        QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
      }
      i1 += 1;
    }
    float f1 = localObject[0];
    i1 = 0;
    int i2 = -1;
    while (i1 < i3)
    {
      float f2 = f1;
      if (localObject[i1] >= f1)
      {
        f2 = localObject[i1];
        i2 = i1;
      }
      i1 += 1;
      f1 = f2;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findFaceIndexByFaceFeature targetFaceFeature = ");
      ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfFloat1));
      QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject).toString());
      paramArrayOfFloat1 = new StringBuilder();
      paramArrayOfFloat1.append("findFaceIndexByFaceFeature newFaceFeature = ");
      paramArrayOfFloat1.append(Arrays.toString(paramArrayOfFloat[0]));
      QLog.d("AREngine_ARLocalFaceRecog", 2, paramArrayOfFloat1.toString());
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("findFaceIndexByFaceFeature2 index = ");
      paramArrayOfFloat.append(i2);
      paramArrayOfFloat.append(",finalSimilarity = ");
      paramArrayOfFloat.append(f1);
      QLog.d("AREngine_ARLocalFaceRecog", 2, paramArrayOfFloat.toString());
    }
    Float.isNaN(f1);
    if (f1 < 0.5D) {
      return -1;
    }
    return i2;
  }
  
  ARScanStarFaceActInfo a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    ARScanStarFaceActInfo localARScanStarFaceActInfo = null;
    Object localObject1 = null;
    Object localObject2 = localARScanStarFaceActInfo;
    if (!bool)
    {
      ARScanStarFaceConfigInfo localARScanStarFaceConfigInfo = this.n;
      localObject2 = localARScanStarFaceActInfo;
      if (localARScanStarFaceConfigInfo != null)
      {
        localObject2 = localARScanStarFaceActInfo;
        if (localARScanStarFaceConfigInfo.b != null)
        {
          localObject2 = localARScanStarFaceActInfo;
          if (this.n.b.length > 0)
          {
            int i2 = this.n.b.length;
            int i1 = 0;
            for (;;)
            {
              localObject2 = localObject1;
              if (i1 >= i2) {
                break;
              }
              localARScanStarFaceActInfo = this.n.b[i1];
              localObject2 = localObject1;
              if (localARScanStarFaceActInfo != null)
              {
                localObject2 = localObject1;
                if (paramString.equals(localARScanStarFaceActInfo.b)) {
                  localObject2 = localARScanStarFaceActInfo;
                }
              }
              i1 += 1;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    return localObject2;
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (this.j) && (!this.k))
    {
      if (!FaceScanModelsLoader.b) {
        return;
      }
      synchronized (this.x)
      {
        int i1 = this.v.size();
        if ((QLog.isColorLevel()) && (a))
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("onPreviewFrame totalFaceSize = ");
          ((StringBuilder)???).append(i1);
          QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
        }
        if (i1 == 0)
        {
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("ARFaceTest onPreviewFrame totalFaceSize is 0,frameIdx = ");
            paramArrayOfByte.append(paramLong);
            paramArrayOfByte.append(",isPreparingData = ");
            paramArrayOfByte.append(this.p);
            QLog.d("AREngine_ARLocalFaceRecog", 2, paramArrayOfByte.toString());
          }
        }
        else
        {
          if ((QLog.isColorLevel()) && (a))
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append(" Try to track Face, isTracking = ");
            ((StringBuilder)???).append(this.s);
            ((StringBuilder)???).append(",frameIndex = ");
            ((StringBuilder)???).append(paramLong);
            QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
          }
          if (!this.s)
          {
            if ((QLog.isColorLevel()) && (a))
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("ARFaceTest Send track Face msg frameIdx = ");
              ((StringBuilder)???).append(paramLong);
              QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
            }
            if (g.hasMessages(3)) {
              g.removeMessages(3);
            }
            this.C.a(paramArrayOfByte);
            paramArrayOfByte = this.C.c();
            this.u = paramLong;
            ??? = Message.obtain();
            ((Message)???).what = 3;
            ((Message)???).obj = paramArrayOfByte;
            g.sendMessage((Message)???);
          }
        }
        return;
      }
    }
  }
  
  public void a(ARFacePreviewResample paramARFacePreviewResample)
  {
    this.C = paramARFacePreviewResample;
  }
  
  void a(List<ARLocalFaceRecog.FaceInfo> paramList, ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    if (paramARCloudRecogRspFaceResult.i.length > 2)
    {
      int i2;
      if (paramARCloudRecogRspFaceResult.h != null) {
        i2 = paramARCloudRecogRspFaceResult.h.size();
      } else {
        i2 = 0;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("filterCloudFaceResult starCount = ");
        ((StringBuilder)localObject1).append(i2);
        QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = "";
      if (i2 > 0)
      {
        Object localObject3 = null;
        localObject1 = null;
        int i5;
        int i1;
        int i3;
        int i4;
        if (i2 == 1)
        {
          ARLocalFaceRecog.FaceInfo localFaceInfo = new ARLocalFaceRecog.FaceInfo();
          i5 = ((ARCloudRecogRspFaceResult.StarInfo)paramARCloudRecogRspFaceResult.h.get(0)).b;
          localFaceInfo.j = true;
          localFaceInfo.b = 0;
          localFaceInfo.l = paramARCloudRecogRspFaceResult.i[i5];
          i1 = 0;
          while (i1 < i2)
          {
            localObject3 = (ARCloudRecogRspFaceResult.StarInfo)paramARCloudRecogRspFaceResult.h.get(i1);
            if (((ARCloudRecogRspFaceResult.StarInfo)localObject3).b == i5)
            {
              localFaceInfo.a = 2;
              localFaceInfo.c = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).c;
              localFaceInfo.d = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).d;
              localFaceInfo.e = String.valueOf(((ARCloudRecogRspFaceResult.StarInfo)localObject3).a);
              localFaceInfo.g = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).e;
              localFaceInfo.h = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).f;
              localFaceInfo.i = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).g;
              localFaceInfo.f = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).h;
            }
            i1 += 1;
          }
          i3 = 0;
          i1 = 0;
          while (i1 < paramARCloudRecogRspFaceResult.i.length)
          {
            i4 = i3;
            localObject3 = localObject1;
            if (i1 != i5)
            {
              if (localObject1 == null) {}
              for (localObject1 = paramARCloudRecogRspFaceResult.i[i1];; localObject1 = paramARCloudRecogRspFaceResult.i[i1])
              {
                i4 = i1;
                localObject3 = localObject1;
                break;
                i4 = i3;
                localObject3 = localObject1;
                if (paramARCloudRecogRspFaceResult.i[i1].width * paramARCloudRecogRspFaceResult.i[i1].height <= ((FaceStatus)localObject1).width * ((FaceStatus)localObject1).height) {
                  break;
                }
              }
            }
            i1 += 1;
            i3 = i4;
            localObject1 = localObject3;
          }
          if (QLog.isColorLevel())
          {
            paramARCloudRecogRspFaceResult = new StringBuilder();
            paramARCloudRecogRspFaceResult.append("filterCloudFaceResult starCount = ");
            paramARCloudRecogRspFaceResult.append(i2);
            paramARCloudRecogRspFaceResult.append(",bigFaceID = ");
            paramARCloudRecogRspFaceResult.append(i3);
            QLog.d("AREngine_ARLocalFaceRecog", 2, paramARCloudRecogRspFaceResult.toString());
          }
          paramARCloudRecogRspFaceResult = new ARLocalFaceRecog.FaceInfo();
          paramARCloudRecogRspFaceResult.a = 1;
          paramARCloudRecogRspFaceResult.c = ((String)localObject2);
          paramARCloudRecogRspFaceResult.j = true;
          paramARCloudRecogRspFaceResult.l = ((FaceStatus)localObject1);
          paramARCloudRecogRspFaceResult.b = 1;
          paramList.add(localFaceInfo);
          paramList.add(paramARCloudRecogRspFaceResult);
        }
        else if (i2 == 2)
        {
          localObject1 = new ARLocalFaceRecog.FaceInfo();
          ((ARLocalFaceRecog.FaceInfo)localObject1).j = true;
          ((ARLocalFaceRecog.FaceInfo)localObject1).b = 0;
          ((ARLocalFaceRecog.FaceInfo)localObject1).l = paramARCloudRecogRspFaceResult.i[0];
          localObject2 = new ARLocalFaceRecog.FaceInfo();
          ((ARLocalFaceRecog.FaceInfo)localObject2).j = true;
          ((ARLocalFaceRecog.FaceInfo)localObject2).b = 1;
          ((ARLocalFaceRecog.FaceInfo)localObject2).l = paramARCloudRecogRspFaceResult.i[1];
          i1 = 0;
          while (i1 < i2)
          {
            localObject3 = (ARCloudRecogRspFaceResult.StarInfo)paramARCloudRecogRspFaceResult.h.get(i1);
            if (((ARCloudRecogRspFaceResult.StarInfo)localObject3).b == 0)
            {
              ((ARLocalFaceRecog.FaceInfo)localObject1).a = 2;
              ((ARLocalFaceRecog.FaceInfo)localObject1).c = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).c;
              ((ARLocalFaceRecog.FaceInfo)localObject1).d = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).d;
              ((ARLocalFaceRecog.FaceInfo)localObject1).e = String.valueOf(((ARCloudRecogRspFaceResult.StarInfo)localObject3).a);
              ((ARLocalFaceRecog.FaceInfo)localObject1).g = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).e;
              ((ARLocalFaceRecog.FaceInfo)localObject1).h = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).f;
              ((ARLocalFaceRecog.FaceInfo)localObject1).i = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).g;
              ((ARLocalFaceRecog.FaceInfo)localObject1).f = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).h;
            }
            if (((ARCloudRecogRspFaceResult.StarInfo)localObject3).b == 1)
            {
              ((ARLocalFaceRecog.FaceInfo)localObject2).a = 2;
              ((ARLocalFaceRecog.FaceInfo)localObject2).c = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).c;
              ((ARLocalFaceRecog.FaceInfo)localObject2).d = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).d;
              ((ARLocalFaceRecog.FaceInfo)localObject2).e = String.valueOf(((ARCloudRecogRspFaceResult.StarInfo)localObject3).a);
              ((ARLocalFaceRecog.FaceInfo)localObject2).g = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).e;
              ((ARLocalFaceRecog.FaceInfo)localObject2).h = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).f;
              ((ARLocalFaceRecog.FaceInfo)localObject2).i = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).g;
              ((ARLocalFaceRecog.FaceInfo)localObject2).f = ((ARCloudRecogRspFaceResult.StarInfo)localObject3).h;
            }
            i1 += 1;
          }
          paramList.add(localObject1);
          paramList.add(localObject2);
        }
        else
        {
          localObject2 = paramARCloudRecogRspFaceResult.i[0];
          i1 = 0;
          i3 = 0;
          while (i1 < paramARCloudRecogRspFaceResult.i.length)
          {
            localObject1 = localObject2;
            if (paramARCloudRecogRspFaceResult.i[i1].width * paramARCloudRecogRspFaceResult.i[i1].height > ((FaceStatus)localObject2).width * ((FaceStatus)localObject2).height)
            {
              localObject1 = paramARCloudRecogRspFaceResult.i[i1];
              i3 = i1;
            }
            i1 += 1;
            localObject2 = localObject1;
          }
          i1 = 0;
          i4 = -2;
          localObject1 = localObject3;
          while (i1 < paramARCloudRecogRspFaceResult.i.length)
          {
            localObject3 = localObject1;
            i5 = i4;
            if (i1 != i3)
            {
              if (localObject1 == null) {}
              for (localObject1 = paramARCloudRecogRspFaceResult.i[i1];; localObject1 = paramARCloudRecogRspFaceResult.i[i1])
              {
                i5 = i1;
                localObject3 = localObject1;
                break;
                localObject3 = localObject1;
                i5 = i4;
                if (paramARCloudRecogRspFaceResult.i[i1].width * paramARCloudRecogRspFaceResult.i[i1].height <= ((FaceStatus)localObject1).width * ((FaceStatus)localObject1).height) {
                  break;
                }
              }
            }
            i1 += 1;
            localObject1 = localObject3;
            i4 = i5;
          }
          localObject3 = new ARLocalFaceRecog.FaceInfo();
          ((ARLocalFaceRecog.FaceInfo)localObject3).j = true;
          ((ARLocalFaceRecog.FaceInfo)localObject3).b = 0;
          ((ARLocalFaceRecog.FaceInfo)localObject3).l = ((FaceStatus)localObject2);
          localObject2 = new ARLocalFaceRecog.FaceInfo();
          ((ARLocalFaceRecog.FaceInfo)localObject2).j = true;
          ((ARLocalFaceRecog.FaceInfo)localObject2).b = 1;
          ((ARLocalFaceRecog.FaceInfo)localObject2).l = ((FaceStatus)localObject1);
          i1 = 0;
          while (i1 < i2)
          {
            localObject1 = (ARCloudRecogRspFaceResult.StarInfo)paramARCloudRecogRspFaceResult.h.get(i1);
            if (((ARCloudRecogRspFaceResult.StarInfo)localObject1).b == i3)
            {
              ((ARLocalFaceRecog.FaceInfo)localObject3).a = 2;
              ((ARLocalFaceRecog.FaceInfo)localObject3).c = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).c;
              ((ARLocalFaceRecog.FaceInfo)localObject3).d = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).d;
              ((ARLocalFaceRecog.FaceInfo)localObject3).e = String.valueOf(((ARCloudRecogRspFaceResult.StarInfo)localObject1).a);
              ((ARLocalFaceRecog.FaceInfo)localObject3).g = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).e;
              ((ARLocalFaceRecog.FaceInfo)localObject3).h = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).f;
              ((ARLocalFaceRecog.FaceInfo)localObject3).i = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).g;
              ((ARLocalFaceRecog.FaceInfo)localObject3).f = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).h;
            }
            if (((ARCloudRecogRspFaceResult.StarInfo)localObject1).b == i4)
            {
              ((ARLocalFaceRecog.FaceInfo)localObject2).a = 2;
              ((ARLocalFaceRecog.FaceInfo)localObject2).c = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).c;
              ((ARLocalFaceRecog.FaceInfo)localObject2).d = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).d;
              ((ARLocalFaceRecog.FaceInfo)localObject2).e = String.valueOf(((ARCloudRecogRspFaceResult.StarInfo)localObject1).a);
              ((ARLocalFaceRecog.FaceInfo)localObject2).g = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).e;
              ((ARLocalFaceRecog.FaceInfo)localObject2).h = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).f;
              ((ARLocalFaceRecog.FaceInfo)localObject2).i = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).g;
              ((ARLocalFaceRecog.FaceInfo)localObject2).f = ((ARCloudRecogRspFaceResult.StarInfo)localObject1).h;
            }
            i1 += 1;
          }
          if (QLog.isColorLevel())
          {
            paramARCloudRecogRspFaceResult = new StringBuilder();
            paramARCloudRecogRspFaceResult.append("filterCloudFaceResult starCount = ");
            paramARCloudRecogRspFaceResult.append(i2);
            paramARCloudRecogRspFaceResult.append(",bigFaceID = ");
            paramARCloudRecogRspFaceResult.append(i3);
            paramARCloudRecogRspFaceResult.append(",secondBigFaceID = ");
            paramARCloudRecogRspFaceResult.append(i4);
            QLog.d("AREngine_ARLocalFaceRecog", 2, paramARCloudRecogRspFaceResult.toString());
          }
          paramList.add(localObject3);
          paramList.add(localObject2);
        }
      }
      else
      {
        paramARCloudRecogRspFaceResult = a(paramARCloudRecogRspFaceResult.i);
        localObject1 = new ARLocalFaceRecog.FaceInfo();
        ((ARLocalFaceRecog.FaceInfo)localObject1).a = 1;
        ((ARLocalFaceRecog.FaceInfo)localObject1).c = "";
        ((ARLocalFaceRecog.FaceInfo)localObject1).j = true;
        ((ARLocalFaceRecog.FaceInfo)localObject1).b = 0;
        if (paramARCloudRecogRspFaceResult != null) {
          ((ARLocalFaceRecog.FaceInfo)localObject1).l = paramARCloudRecogRspFaceResult[0];
        }
        localObject2 = new ARLocalFaceRecog.FaceInfo();
        ((ARLocalFaceRecog.FaceInfo)localObject2).a = 1;
        ((ARLocalFaceRecog.FaceInfo)localObject2).c = "";
        ((ARLocalFaceRecog.FaceInfo)localObject2).j = true;
        ((ARLocalFaceRecog.FaceInfo)localObject2).b = 1;
        if (paramARCloudRecogRspFaceResult != null) {
          ((ARLocalFaceRecog.FaceInfo)localObject2).l = paramARCloudRecogRspFaceResult[1];
        }
        paramList.add(localObject1);
        paramList.add(localObject2);
        return;
      }
    }
  }
  
  void a(FaceStatus[] paramArrayOfFaceStatus1, FaceStatus[] paramArrayOfFaceStatus2)
  {
    if (paramArrayOfFaceStatus2 == null) {
      return;
    }
    int i3 = paramArrayOfFaceStatus2.length;
    int i1 = 0;
    while (i1 < i3)
    {
      FaceStatus localFaceStatus = paramArrayOfFaceStatus2[i1];
      if (paramArrayOfFaceStatus1 != null)
      {
        int i4 = paramArrayOfFaceStatus1.length;
        int i2 = 0;
        while ((i2 < i4) && (localFaceStatus != paramArrayOfFaceStatus1[i2])) {
          i2 += 1;
        }
      }
      i1 += 1;
    }
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, ARLocalFaceRecog.ARLocalFaceRecogCallback paramARLocalFaceRecogCallback)
  {
    long l1 = System.currentTimeMillis();
    if (!FaceCluster.useAssetSo)
    {
      boolean bool = FaceScanDownloadManager.b();
      if (bool)
      {
        FaceScanModelsLoader.a(paramContext);
        this.b = FaceCluster.getInstance();
      }
      else
      {
        FaceScanModelsLoader.b = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[ScanStarFace]init ,isResourceReady = ");
        localStringBuilder.append(bool);
        localStringBuilder.append(",FaceScanModelsLoader.hasFaceModelInit = ");
        localStringBuilder.append(FaceScanModelsLoader.b);
        QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
      }
    }
    this.o = paramContext;
    this.c = paramInt1;
    this.d = paramInt2;
    this.t = paramARLocalFaceRecogCallback;
    l1 = System.currentTimeMillis() - l1;
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("[DEBUG_SCAN_yt_face] [ScanStarFace]init result = ");
      paramContext.append(true);
      paramContext.append(",previewWidth = ");
      paramContext.append(paramInt1);
      paramContext.append(",previewHeight = ");
      paramContext.append(paramInt2);
      paramContext.append(",useAssetSo = ");
      paramContext.append(FaceCluster.useAssetSo);
      paramContext.append(",localFaceRecogerInitCost = ");
      paramContext.append(l1);
      QLog.d("AREngine_ARLocalFaceRecog", 2, paramContext.toString());
    }
    ARReport.a().g(l1, true);
    ARFaceDataCollector.a(l1);
    this.n = paramARScanStarFaceConfigInfo;
    this.j = false;
    this.k = false;
    return true;
  }
  
  public boolean a(ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[DEBUG_SCAN_yt_face][ScanStarFace]addFaceCloudRecogResult start,faceResult = ");
      localStringBuilder.append(paramARCloudRecogRspFaceResult);
      QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
    }
    this.p = true;
    long l1 = System.currentTimeMillis();
    g.post(new ARLocalFaceRecog.3(this, paramARCloudRecogRspFaceResult, l1));
    return true;
  }
  
  boolean a(ARLocalFaceRecog.FaceInfo paramFaceInfo, float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2)
  {
    boolean bool2 = paramFaceInfo.j;
    boolean bool1 = true;
    if (!bool2)
    {
      long l1 = SystemClock.uptimeMillis();
      int i1 = a(paramArrayOfFloat1, paramFaceInfo.l.feature);
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("recoverSingleFace findFaceIndexByFaceFeature[TimeCost] = ");
        localStringBuilder.append(l2 - l1);
        QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
      }
      if ((i1 >= 0) && (i1 < paramArrayOfFloat1.length))
      {
        paramFaceInfo.l.xys = paramArrayOfFloat2[i1];
        paramFaceInfo.j = true;
        break label118;
      }
    }
    bool1 = false;
    label118:
    if (QLog.isColorLevel())
    {
      paramArrayOfFloat1 = new StringBuilder();
      paramArrayOfFloat1.append("recoverSingleFace  result = ");
      paramArrayOfFloat1.append(bool1);
      paramArrayOfFloat1.append(",faceInfo = ");
      paramArrayOfFloat1.append(paramFaceInfo);
      QLog.d("AREngine_ARLocalFaceRecog", 2, paramArrayOfFloat1.toString());
    }
    return bool1;
  }
  
  boolean a(List<ARLocalFaceRecog.FaceInfo> paramList)
  {
    paramList = paramList.iterator();
    for (boolean bool = true;; bool = false)
    {
      if (!paramList.hasNext()) {
        return bool;
      }
      ARLocalFaceRecog.FaceInfo localFaceInfo = (ARLocalFaceRecog.FaceInfo)paramList.next();
      if ((bool) && (localFaceInfo.j)) {
        break;
      }
    }
    return bool;
  }
  
  boolean a(List<ARLocalFaceRecog.FaceInfo> paramList, FaceStatus paramFaceStatus)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList != null)
    {
      bool1 = bool2;
      if (paramList.size() > 0)
      {
        paramList = paramList.iterator();
        bool1 = false;
        while (paramList.hasNext())
        {
          Object localObject = (ARLocalFaceRecog.FaceInfo)paramList.next();
          if (((ARLocalFaceRecog.FaceInfo)localObject).j)
          {
            int i1 = Math.abs(((ARLocalFaceRecog.FaceInfo)localObject).l.x + ((ARLocalFaceRecog.FaceInfo)localObject).l.width / 2 - (paramFaceStatus.x + paramFaceStatus.width / 2));
            int i2 = Math.abs(((ARLocalFaceRecog.FaceInfo)localObject).l.y + ((ARLocalFaceRecog.FaceInfo)localObject).l.height / 2 - (paramFaceStatus.y + paramFaceStatus.height / 2));
            int i3 = Math.min(((ARLocalFaceRecog.FaceInfo)localObject).l.width / 2, paramFaceStatus.width / 2);
            int i4 = Math.min(((ARLocalFaceRecog.FaceInfo)localObject).l.height / 2, paramFaceStatus.height / 2);
            if ((i1 < i3) && (i2 < i4)) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" shouldFilterTmpFace,distanceX = ");
              ((StringBuilder)localObject).append(i1);
              ((StringBuilder)localObject).append(",distanceY = ");
              ((StringBuilder)localObject).append(i2);
              ((StringBuilder)localObject).append(",w = ");
              ((StringBuilder)localObject).append(i3);
              ((StringBuilder)localObject).append(",h = ");
              ((StringBuilder)localObject).append(i4);
              QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append(" shouldFilterTmpFace,result = ");
      paramList.append(bool1);
      QLog.d("AREngine_ARLocalFaceRecog", 2, paramList.toString());
    }
    return bool1;
  }
  
  FaceStatus[] a(FaceStatus[] paramArrayOfFaceStatus)
  {
    FaceStatus[] arrayOfFaceStatus;
    if ((paramArrayOfFaceStatus != null) && (paramArrayOfFaceStatus.length > 0))
    {
      arrayOfFaceStatus = paramArrayOfFaceStatus;
      if (paramArrayOfFaceStatus.length > 2)
      {
        arrayOfFaceStatus = new FaceStatus[2];
        int i4 = 0;
        arrayOfFaceStatus[0] = paramArrayOfFaceStatus[0];
        int i1 = 0;
        int i2 = 0;
        while (i1 < paramArrayOfFaceStatus.length)
        {
          if (paramArrayOfFaceStatus[i1].width * paramArrayOfFaceStatus[i1].height > arrayOfFaceStatus[0].width * arrayOfFaceStatus[0].height)
          {
            arrayOfFaceStatus[0] = paramArrayOfFaceStatus[i1];
            i2 = i1;
          }
          i1 += 1;
        }
        int i3 = -2;
        i1 = i4;
        while (i1 < paramArrayOfFaceStatus.length)
        {
          i4 = i3;
          if (i1 != i2)
          {
            if (arrayOfFaceStatus[1] == null)
            {
              arrayOfFaceStatus[1] = paramArrayOfFaceStatus[i1];
            }
            else
            {
              i4 = i3;
              if (paramArrayOfFaceStatus[i1].width * paramArrayOfFaceStatus[i1].height <= arrayOfFaceStatus[1].width * arrayOfFaceStatus[1].height) {
                break label175;
              }
              arrayOfFaceStatus[1] = paramArrayOfFaceStatus[i1];
            }
            i4 = i1;
          }
          label175:
          i1 += 1;
          i3 = i4;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("filterLocalDetectFace  bigFaceID = ");
          localStringBuilder.append(i2);
          localStringBuilder.append(",secondBigFaceID = ");
          localStringBuilder.append(i3);
          localStringBuilder.append(",faceCount = ");
          localStringBuilder.append(paramArrayOfFaceStatus.length);
          QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
        }
        return arrayOfFaceStatus;
      }
    }
    else
    {
      arrayOfFaceStatus = null;
    }
    return arrayOfFaceStatus;
  }
  
  public void b()
  {
    boolean bool = FaceScanDownloadManager.b();
    if (bool)
    {
      FaceScanModelsLoader.a(this.o);
      this.b = FaceCluster.getInstance();
    }
    else
    {
      FaceScanModelsLoader.b = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ScanStarFace]notifyResourceDownloadFinish ,isResourceReady = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(",FaceScanModelsLoader.hasFaceModelInit = ");
      localStringBuilder.append(FaceScanModelsLoader.b);
      QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
    }
  }
  
  void b(List<ARLocalFaceRecog.FaceInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      paramList.clear();
    }
  }
  
  void b(List<ARLocalFaceRecog.FaceInfo> paramList, ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    paramARCloudRecogRspFaceResult = paramARCloudRecogRspFaceResult.i;
    int i2 = paramARCloudRecogRspFaceResult.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = paramARCloudRecogRspFaceResult[i1];
      Iterator localIterator = paramList.iterator();
      while ((localIterator.hasNext()) && (((ARLocalFaceRecog.FaceInfo)localIterator.next()).l != localObject)) {}
      i1 += 1;
    }
  }
  
  boolean b(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    int i1 = 0;
    boolean bool1 = bool2;
    Object localObject;
    if (!bool3)
    {
      localObject = this.n;
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((ARScanStarFaceConfigInfo)localObject).b != null)
        {
          bool1 = bool2;
          if (this.n.b.length > 0)
          {
            int i2 = this.n.b.length;
            for (bool1 = false; i1 < i2; bool1 = bool2)
            {
              localObject = this.n.b[i1];
              long l1 = NetConnInfoCenter.getServerTimeMillis();
              bool2 = bool1;
              if (localObject != null)
              {
                bool2 = bool1;
                if (paramString.equals(((ARScanStarFaceActInfo)localObject).b))
                {
                  bool2 = bool1;
                  if (l1 > ((ARScanStarFaceActInfo)localObject).g)
                  {
                    bool2 = bool1;
                    if (l1 < ((ARScanStarFaceActInfo)localObject).h) {
                      bool2 = true;
                    }
                  }
                }
              }
              i1 += 1;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ScanStarFace]hasStarActivity result = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("starUin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public void c()
  {
    QLog.d("AREngine_ARLocalFaceRecog", 1, "[ScanStarFace] uninit");
    Handler localHandler = g;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    FaceScanModelsLoader.a();
    QLog.d("AREngine_ARLocalFaceRecog", 1, "[ScanStarFace] uninit finish");
  }
  
  public boolean d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ScanStarFace] start ,mIsStarted = ");
      localStringBuilder.append(this.j);
      QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
    }
    if (this.j) {
      return true;
    }
    if (this.f == null)
    {
      this.f = new HandlerThread("ARLocalFaceRecog");
      this.f.start();
      g = new Handler(this.f.getLooper(), this.q);
    }
    if (this.h == null)
    {
      this.h = new HandlerThread("ARLocalFaceRecog_exFeature");
      this.h.start();
      this.i = new Handler(this.h.getLooper());
    }
    this.j = true;
    this.k = false;
    return true;
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[ScanStarFace] pause ,mIsPause = ");
      ((StringBuilder)???).append(this.k);
      QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
    }
    if (this.k) {
      return;
    }
    this.k = true;
    synchronized (this.x)
    {
      b(this.v);
      b(this.w);
      this.B = 10;
      g.removeCallbacksAndMessages(null);
      this.i.removeCallbacksAndMessages(null);
      if (this.l > 0L)
      {
        ARFaceDataCollector.a(System.currentTimeMillis() - this.l, this.m);
        this.l = 0L;
        this.m = 0;
      }
      return;
    }
  }
  
  public boolean f()
  {
    return this.k;
  }
  
  public boolean g()
  {
    return this.p;
  }
  
  public void h()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ScanStarFace] resume ,mIsPause = ");
      localStringBuilder.append(this.k);
      QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
    }
    if (!this.k) {
      return;
    }
    this.k = false;
    this.l = System.currentTimeMillis();
    this.m = 0;
  }
  
  public void i()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[ScanStarFace] stop,mIsStarted = ");
      ((StringBuilder)???).append(this.j);
      QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
    }
    if (!this.j) {
      return;
    }
    this.j = false;
    synchronized (this.x)
    {
      b(this.v);
      b(this.w);
      this.B = 10;
      g.removeCallbacksAndMessages(null);
      this.i.removeCallbacksAndMessages(null);
      this.f.quit();
      this.f = null;
      g = null;
      this.h.quit();
      this.h = null;
      this.i = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog
 * JD-Core Version:    0.7.0.1
 */