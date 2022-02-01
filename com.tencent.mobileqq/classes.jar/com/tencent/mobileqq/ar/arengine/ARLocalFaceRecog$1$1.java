package com.tencent.mobileqq.ar.arengine;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.mobileqq.ar.ARDebugReport;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

class ARLocalFaceRecog$1$1
  implements Runnable
{
  ARLocalFaceRecog$1$1(ARLocalFaceRecog.1 param1, int paramInt, float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE start ");
    }
    int i = 0;
    while (i < this.a)
    {
      if ((this.b[i] != null) && (!this.e.a.k))
      {
        long l = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature start ");
        }
        this.c[i] = this.e.a.b.calcuFaceFeature(this.d, this.e.a.c, this.e.a.d, this.b[i], this.e.a.e);
        l = SystemClock.uptimeMillis() - l;
        ARFaceDataCollector.c(l);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature[TimeCost] = ");
          ((StringBuilder)???).append(l);
          QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
          ARDebugReport.a().d(l);
          if (this.c[i] != null)
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("  calcuFaceFeature feature = ");
            ((StringBuilder)???).append(Arrays.toString(this.c[i]));
            QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("SUB_MSG_EXTRACT_FACE_FEATRUE  faceShape is null i = ");
        ((StringBuilder)???).append(i);
        QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
      }
      i += 1;
    }
    synchronized (this.e.a.x)
    {
      Object localObject2 = this.e.a.v;
      i = ((List)localObject2).size();
      if ((i > 0) && (!this.e.a.k)) {
        if (i == 1)
        {
          localObject2 = (ARLocalFaceRecog.FaceInfo)((List)localObject2).get(0);
          if ((this.e.a.a((ARLocalFaceRecog.FaceInfo)localObject2, this.c, this.b)) && (ARLocalFaceRecog.g.hasMessages(1))) {
            ARLocalFaceRecog.g.removeMessages(1);
          }
        }
        else if (i == 2)
        {
          ARLocalFaceRecog.FaceInfo localFaceInfo1 = (ARLocalFaceRecog.FaceInfo)((List)localObject2).get(0);
          ARLocalFaceRecog.FaceInfo localFaceInfo2 = (ARLocalFaceRecog.FaceInfo)((List)localObject2).get(1);
          if ((!localFaceInfo1.j) && (localFaceInfo2.j))
          {
            if ((this.e.a.a(localFaceInfo1, this.c, this.b)) && (ARLocalFaceRecog.g.hasMessages(1))) {
              ARLocalFaceRecog.g.removeMessages(1);
            }
          }
          else if ((localFaceInfo1.j) && (!localFaceInfo2.j))
          {
            if ((this.e.a.a(localFaceInfo2, this.c, this.b)) && (ARLocalFaceRecog.g.hasMessages(1))) {
              ARLocalFaceRecog.g.removeMessages(1);
            }
          }
          else if ((!localFaceInfo1.j) && (!localFaceInfo2.j))
          {
            i = this.e.a.a(this.c, localFaceInfo1.l.feature);
            int j = this.e.a.a(this.c, localFaceInfo2.l.feature);
            if ((i >= 0) || (j >= 0)) {
              if ((i >= 0) && (j < 0))
              {
                localFaceInfo1.l.xys = this.b[i];
                localFaceInfo1.j = true;
              }
              else if ((i < 0) && (j >= 0))
              {
                localFaceInfo2.l.xys = this.b[j];
                localFaceInfo2.j = true;
              }
              else if (i == j)
              {
                float f1 = this.e.a.b.calcuSimilarity(this.c[i], localFaceInfo1.l.feature);
                float f2 = this.e.a.b.calcuSimilarity(this.c[j], localFaceInfo2.l.feature);
                if (QLog.isColorLevel())
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("SUB_MSG_EXTRACT_FACE_FEATRUE  similarity1  = ");
                  localStringBuilder.append(f1);
                  localStringBuilder.append(",similarity2 = ");
                  localStringBuilder.append(f2);
                  QLog.d("AREngine_ARLocalFaceRecog", 2, localStringBuilder.toString());
                }
                if (f1 > f2)
                {
                  localFaceInfo1.l.xys = this.b[i];
                  localFaceInfo1.j = true;
                  this.c[i] = null;
                  this.e.a.a(localFaceInfo2, this.c, this.b);
                }
                else
                {
                  localFaceInfo2.l.xys = this.b[j];
                  localFaceInfo2.j = true;
                  this.c[j] = null;
                  this.e.a.a(localFaceInfo1, this.c, this.b);
                }
              }
              else
              {
                localFaceInfo1.l.xys = this.b[i];
                localFaceInfo1.j = true;
                localFaceInfo2.l.xys = this.b[j];
                localFaceInfo2.j = true;
              }
            }
            if ((this.e.a.a((List)localObject2)) && (ARLocalFaceRecog.g.hasMessages(1))) {
              ARLocalFaceRecog.g.removeMessages(1);
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  calc error status");
          }
        }
      }
      this.e.a.b(this.e.a.w);
      this.e.a.B = 10;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE end ,clear tmpFace");
      }
      this.e.a.r = false;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  finish");
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.1.1
 * JD-Core Version:    0.7.0.1
 */