package com.tencent.mobileqq.ar.arengine;

import android.os.Handler;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudFileUploadCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ARCloudControl$6
  implements ARCloudFileUpload.ARCloudFileUploadCallback
{
  ARCloudControl$6(ARCloudControl paramARCloudControl, long paramLong, ARCloudReqInfo paramARCloudReqInfo) {}
  
  public void a(int paramInt, String paramString, ARCloudRecogResult paramARCloudRecogResult)
  {
    Object localObject1 = this.c;
    int j = 0;
    ARCloudControl.c((ARCloudControl)localObject1, false);
    if (ARCloudControl.a(this.c)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = this.c;
        if ((paramARCloudRecogResult == null) || (paramARCloudRecogResult.d == null)) {
          break label1002;
        }
        i = paramARCloudRecogResult.d.h;
        ((ARCloudControl)localObject1).y = i;
        localObject3 = this.c;
        if ((paramARCloudRecogResult == null) || (paramARCloudRecogResult.d == null) || (paramARCloudRecogResult.d.g == null) || (paramARCloudRecogResult.d.g.length <= 0)) {
          break label1008;
        }
        localObject1 = paramARCloudRecogResult.d.g[0].a;
        ((ARCloudControl)localObject3).x = ((String)localObject1);
      }
      catch (Exception localException)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("  mCloudTime  mImageId ");
        ((StringBuilder)localObject3).append(localException.getMessage());
        QLog.i("AREngine_ARCloudControl", 1, ((StringBuilder)localObject3).toString());
      }
      if (this.c.p != 0L) {
        this.c.z = (System.currentTimeMillis() - this.c.p);
      }
      if (this.c.q != 0L)
      {
        localObject2 = this.c;
        ((ARCloudControl)localObject2).u += System.currentTimeMillis() - this.c.q;
      }
      if (ARCloudControl.d(this.c) != null) {
        ARCloudControl.d(this.c).removeMessages(1);
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", rspInfo = , sessionId = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(",uploadCost = ");
      ((StringBuilder)localObject2).append(l1 - l2);
      QLog.i("AREngine_ARCloudControl", 1, ((StringBuilder)localObject2).toString());
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "requestToUpload" }));
      if (ARCloudControl.b(this.c) != null)
      {
        if ((paramInt == 0) && (paramARCloudRecogResult != null) && ((ARCloudMarkerRecogResult.a(paramARCloudRecogResult.d)) || (ARCloudObjectClassifyResult.a(paramARCloudRecogResult.e)) || (ARMIGObjectClassifyResult.a(paramARCloudRecogResult.j)) || (ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.f)) || (ARCloudSceneRecogResult.a(paramARCloudRecogResult.k))))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mResult set:");
          ((StringBuilder)localObject2).append(this.c.A);
          QLog.d("AREngine_ARCloudControl", 2, ((StringBuilder)localObject2).toString());
          this.c.A = 0;
        }
        if ((paramARCloudRecogResult != null) && (ARCloudMarkerRecogResult.a(paramARCloudRecogResult.d))) {
          paramARCloudRecogResult.d.c = this.b.b.a;
        }
        if ((paramARCloudRecogResult != null) && (ARCloudObjectClassifyResult.a(paramARCloudRecogResult.e))) {
          paramARCloudRecogResult.e.c = this.b.b.a;
        }
        if ((paramARCloudRecogResult != null) && (ARCloudSceneRecogResult.a(paramARCloudRecogResult.k))) {
          paramARCloudRecogResult.k.c = this.b.b.a;
        }
        if (!ARCloudControl.e(this.c))
        {
          boolean bool;
          if ((paramInt == 0) && (paramARCloudRecogResult != null) && ((ARCloudMarkerRecogResult.a(paramARCloudRecogResult.d)) || (ARCloudObjectClassifyResult.a(paramARCloudRecogResult.e)) || (ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.f)) || (ARCloudPreOcrResult.a(paramARCloudRecogResult.h)) || (ARCloudSceneRecogResult.a(paramARCloudRecogResult.k)))) {
            bool = true;
          } else {
            bool = false;
          }
          l1 = ARCloudControl.b(this.c).f();
          ScanEntranceReport.a().a(bool, l1);
          ARCloudControl.d(this.c, true);
        }
        if ((!ARCloudControl.f(this.c)) && (paramInt == 0) && (paramARCloudRecogResult != null) && ((ARCloudMarkerRecogResult.a(paramARCloudRecogResult.d)) || (ARCloudObjectClassifyResult.a(paramARCloudRecogResult.e)) || (ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.f)) || (ARCloudPreOcrResult.a(paramARCloudRecogResult.h)) || (ARCloudSceneRecogResult.a(paramARCloudRecogResult.k))))
        {
          l1 = ARCloudControl.b(this.c).f();
          ScanEntranceReport.a().a(l1, this.c.a.d);
          ARCloudControl.e(this.c, true);
        }
        if (ARCloudControl.g(this.c) != null) {
          ARCloudControl.g(this.c).add(paramString);
        }
        if ((this.c.A == 0) && (paramARCloudRecogResult != null) && (ARCloudRecogResult.a(this.c.n.recognitions, paramARCloudRecogResult)))
        {
          if ((this.c.n.switchLBSLocation == 1) && (paramARCloudRecogResult != null))
          {
            if (paramARCloudRecogResult.b == 128L)
            {
              i = j;
              if (paramARCloudRecogResult.b == 128L)
              {
                i = j;
                if (!ARCloudControl.b(this.c).a(paramARCloudRecogResult.j)) {}
              }
            }
            else
            {
              i = 1;
            }
            if (i != 0)
            {
              QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
              ARCloudControl.a(this.c, paramInt, paramARCloudRecogResult);
              return;
            }
            QLog.i("AREngine_ARCloudControl", 1, "MIGObjectClaasify not need  run requestToCheckLBSLocation.");
            ARCloudControl.b(this.c).a(paramInt, paramARCloudRecogResult);
            return;
          }
          ARCloudControl.b(this.c).a(2, null);
          return;
        }
        localObject2 = ARCloudControl.b(this.c);
        paramString = paramARCloudRecogResult;
        if (paramARCloudRecogResult == null) {
          paramString = null;
        }
        ((ARCloudControl.ARCloudControlCallback)localObject2).a(paramInt, paramString);
      }
      return;
      label1002:
      int i = 0;
      continue;
      label1008:
      localObject2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.6
 * JD-Core Version:    0.7.0.1
 */