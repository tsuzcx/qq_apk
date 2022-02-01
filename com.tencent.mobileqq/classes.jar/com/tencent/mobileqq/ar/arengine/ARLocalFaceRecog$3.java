package com.tencent.mobileqq.ar.arengine;

import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class ARLocalFaceRecog$3
  implements Runnable
{
  ARLocalFaceRecog$3(ARLocalFaceRecog paramARLocalFaceRecog, ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult, long paramLong) {}
  
  public void run()
  {
    int i;
    label563:
    synchronized (this.this$0.x)
    {
      this.this$0.b(this.this$0.v);
      this.this$0.b(this.this$0.w);
      this.this$0.B = 10;
      ??? = this.this$0;
      ((ARLocalFaceRecog)???).y = this.a;
      if ((((ARLocalFaceRecog)???).y != null) && (this.this$0.y.i != null)) {
        label441:
        synchronized (this.this$0.x)
        {
          if (this.this$0.y.i.length <= 2) {
            break label563;
          }
          this.this$0.a(this.this$0.v, this.this$0.y);
          this.this$0.b(this.this$0.v, this.this$0.y);
          break label441;
          while (i < this.this$0.y.i.length)
          {
            FaceStatus localFaceStatus = this.this$0.y.i[i];
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("[ScanStarFace]addFaceCloudRecogResult faceFeature = ");
              ((StringBuilder)localObject4).append(Arrays.toString(localFaceStatus.feature));
              QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject4).toString());
            }
            Object localObject4 = new ARLocalFaceRecog.FaceInfo();
            ((ARLocalFaceRecog.FaceInfo)localObject4).a = 1;
            ((ARLocalFaceRecog.FaceInfo)localObject4).c = "";
            if (this.this$0.y.h != null)
            {
              Iterator localIterator = this.this$0.y.h.iterator();
              while (localIterator.hasNext())
              {
                ARCloudRecogRspFaceResult.StarInfo localStarInfo = (ARCloudRecogRspFaceResult.StarInfo)localIterator.next();
                if (localStarInfo.b == i)
                {
                  ((ARLocalFaceRecog.FaceInfo)localObject4).a = 2;
                  ((ARLocalFaceRecog.FaceInfo)localObject4).c = localStarInfo.c;
                  ((ARLocalFaceRecog.FaceInfo)localObject4).d = localStarInfo.d;
                  ((ARLocalFaceRecog.FaceInfo)localObject4).e = String.valueOf(localStarInfo.a);
                  ((ARLocalFaceRecog.FaceInfo)localObject4).g = localStarInfo.e;
                  ((ARLocalFaceRecog.FaceInfo)localObject4).h = localStarInfo.f;
                  ((ARLocalFaceRecog.FaceInfo)localObject4).i = localStarInfo.g;
                  ((ARLocalFaceRecog.FaceInfo)localObject4).f = localStarInfo.h;
                }
              }
            }
            ((ARLocalFaceRecog.FaceInfo)localObject4).j = true;
            ((ARLocalFaceRecog.FaceInfo)localObject4).l = localFaceStatus;
            ((ARLocalFaceRecog.FaceInfo)localObject4).b = i;
            this.this$0.v.add(localObject4);
            i += 1;
          }
        }
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.b;
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("[DEBUG_SCAN_yt_face][ScanStarFace]addFaceCloudRecogResult finish,totalFaceList = ");
        ((StringBuilder)???).append(this.this$0.v);
        ((StringBuilder)???).append(",addFaceClouDResultCost = ");
        ((StringBuilder)???).append(l1 - l2);
        QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
      }
      this.this$0.z = System.currentTimeMillis();
      this.this$0.p = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3
 * JD-Core Version:    0.7.0.1
 */