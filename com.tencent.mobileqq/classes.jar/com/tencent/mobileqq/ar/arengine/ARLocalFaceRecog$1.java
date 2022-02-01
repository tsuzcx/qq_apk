package com.tencent.mobileqq.ar.arengine;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.mobileqq.ar.ARDebugReport;
import com.tencent.mobileqq.ar.DrawView2.FaceData;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ARLocalFaceRecog$1
  implements Handler.Callback
{
  ARLocalFaceRecog$1(ARLocalFaceRecog paramARLocalFaceRecog) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject4;
    Object localObject3;
    label197:
    Object localObject5;
    label248:
    Object localObject6;
    label307:
    boolean bool;
    if (i != 1)
    {
      if (i != 3) {}
      for (;;)
      {
        return false;
        if ((QLog.isColorLevel()) && (ARLocalFaceRecog.a)) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE start");
        }
        l1 = System.currentTimeMillis();
        this.a.s = true;
        localObject4 = (byte[])paramMessage.obj;
        localObject1 = new ArrayList();
        synchronized (this.a.x)
        {
          l2 = SystemClock.uptimeMillis();
          localObject3 = this.a.b.trackFace((byte[])localObject4, this.a.c, this.a.d, this.a.e, false);
          l2 = SystemClock.uptimeMillis() - l2;
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.a))
          {
            paramMessage = new StringBuilder();
            paramMessage.append("[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace,trackSingeFace[TimeCost] = ");
            paramMessage.append(l2);
            QLog.d("AREngine_ARLocalFaceRecog", 2, paramMessage.toString());
            ARDebugReport.a().e(l2);
          }
          paramMessage = this.a.v.iterator();
          if (paramMessage.hasNext())
          {
            localObject5 = (ARLocalFaceRecog.FaceInfo)paramMessage.next();
            if (((ARLocalFaceRecog.FaceInfo)localObject5).j)
            {
              if ((!QLog.isColorLevel()) || (!ARLocalFaceRecog.a)) {
                break;
              }
              QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace start ");
              break;
              if (i >= localObject3.length) {
                break label2210;
              }
              if (localObject3[i].trace_id != ((ARLocalFaceRecog.FaceInfo)localObject5).l.trace_id) {
                break label2203;
              }
              localObject6 = ((ARLocalFaceRecog.FaceInfo)localObject5).l.feature;
              ((ARLocalFaceRecog.FaceInfo)localObject5).l = localObject3[i];
              ((ARLocalFaceRecog.FaceInfo)localObject5).l.feature = ((float[])localObject6);
              i = 0;
              if (i != 0)
              {
                if (QLog.isColorLevel())
                {
                  localObject6 = new StringBuilder();
                  ((StringBuilder)localObject6).append("MSG_TRACK_FACE Lost realFace  faceInfo.lostCount = ");
                  ((StringBuilder)localObject6).append(((ARLocalFaceRecog.FaceInfo)localObject5).k);
                  QLog.i("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject6).toString());
                }
                ((ARLocalFaceRecog.FaceInfo)localObject5).k += 1;
                if (((ARLocalFaceRecog.FaceInfo)localObject5).k <= 0) {
                  break label2215;
                }
                ((ARLocalFaceRecog.FaceInfo)localObject5).j = false;
                ((ARLocalFaceRecog.FaceInfo)localObject5).k = 0;
                localObject5 = this.a;
                ((ARLocalFaceRecog)localObject5).m += 1;
                break label2215;
              }
              ((ARLocalFaceRecog.FaceInfo)localObject5).k = 0;
              if ((QLog.isColorLevel()) && (ARLocalFaceRecog.a)) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Track realFace success,update");
              }
              localObject6 = new DrawView2.FaceData();
              ((DrawView2.FaceData)localObject6).a = ((ARLocalFaceRecog.FaceInfo)localObject5).l.xys;
              ((DrawView2.FaceData)localObject6).d = ((ARLocalFaceRecog.FaceInfo)localObject5).c;
              ((DrawView2.FaceData)localObject6).b = new Rect(((ARLocalFaceRecog.FaceInfo)localObject5).l.x, ((ARLocalFaceRecog.FaceInfo)localObject5).l.y, ((ARLocalFaceRecog.FaceInfo)localObject5).l.x + ((ARLocalFaceRecog.FaceInfo)localObject5).l.width, ((ARLocalFaceRecog.FaceInfo)localObject5).l.y + ((ARLocalFaceRecog.FaceInfo)localObject5).l.height);
              ((DrawView2.FaceData)localObject6).c = DrawView2.FaceData.a(((DrawView2.FaceData)localObject6).b, ((ARLocalFaceRecog.FaceInfo)localObject5).l.xys);
              ((DrawView2.FaceData)localObject6).f = ((ARLocalFaceRecog.FaceInfo)localObject5).b;
              ((DrawView2.FaceData)localObject6).g = ((ARLocalFaceRecog.FaceInfo)localObject5).d;
              ((DrawView2.FaceData)localObject6).e = ((ARLocalFaceRecog.FaceInfo)localObject5).e;
              ((DrawView2.FaceData)localObject6).l = ((ARLocalFaceRecog.FaceInfo)localObject5).i;
              if (((ARLocalFaceRecog.FaceInfo)localObject5).a != 2) {
                break label2218;
              }
              bool = true;
              label605:
              ((DrawView2.FaceData)localObject6).m = bool;
              if (((DrawView2.FaceData)localObject6).m)
              {
                ((DrawView2.FaceData)localObject6).n = this.a.b(((DrawView2.FaceData)localObject6).e);
                if (((DrawView2.FaceData)localObject6).n)
                {
                  ARScanStarFaceActInfo localARScanStarFaceActInfo = this.a.a(((DrawView2.FaceData)localObject6).e);
                  if (localARScanStarFaceActInfo != null)
                  {
                    ((DrawView2.FaceData)localObject6).p = localARScanStarFaceActInfo.f;
                    ((DrawView2.FaceData)localObject6).k = localARScanStarFaceActInfo.e;
                  }
                }
                ((DrawView2.FaceData)localObject6).i = ((ARLocalFaceRecog.FaceInfo)localObject5).h;
                ((DrawView2.FaceData)localObject6).j = ((ARLocalFaceRecog.FaceInfo)localObject5).g;
              }
              ((DrawView2.FaceData)localObject6).o = ((ARLocalFaceRecog.FaceInfo)localObject5).f;
              ((ArrayList)localObject1).add(localObject6);
              break label2224;
            }
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("MSG_TRACK_FACE Try to recover realFace, isRecovering = ");
              ((StringBuilder)localObject5).append(this.a.r);
              QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject5).toString());
            }
            if ((this.a.r) || (this.a.k)) {
              break label2224;
            }
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Send Recover Msg");
            }
            if (ARLocalFaceRecog.g.hasMessages(1)) {
              ARLocalFaceRecog.g.removeMessages(1);
            }
            localObject5 = Message.obtain();
            ((Message)localObject5).what = 1;
            ((Message)localObject5).obj = localObject4;
            ARLocalFaceRecog.g.sendMessage((Message)localObject5);
            break label2224;
          }
          paramMessage = this.a.w.iterator();
          while (paramMessage.hasNext())
          {
            localObject4 = (ARLocalFaceRecog.FaceInfo)paramMessage.next();
            if (((ARLocalFaceRecog.FaceInfo)localObject4).j)
            {
              if ((!QLog.isColorLevel()) || (!ARLocalFaceRecog.a)) {
                break label2227;
              }
              QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE tmpFace trackSingeFace start");
              break label2227;
              label920:
              if (i >= localObject3.length) {
                break label2244;
              }
              if (localObject3[i].trace_id != ((ARLocalFaceRecog.FaceInfo)localObject4).l.trace_id) {
                break label2237;
              }
              localObject5 = ((ARLocalFaceRecog.FaceInfo)localObject4).l.feature;
              ((ARLocalFaceRecog.FaceInfo)localObject4).l = localObject3[i];
              ((ARLocalFaceRecog.FaceInfo)localObject4).l.feature = ((float[])localObject5);
              i = 0;
              label979:
              if ((QLog.isColorLevel()) && (ARLocalFaceRecog.a))
              {
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("[DEBUG_SCAN_yt_face]MSG_TRACK_FACE [TimeCost] tmpFace trackSingeFace = ");
                ((StringBuilder)localObject5).append(l2);
                QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject5).toString());
              }
              if (i != 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Lost tmpFace");
                }
                ((ARLocalFaceRecog.FaceInfo)localObject4).j = false;
                paramMessage.remove();
              }
              else
              {
                if ((QLog.isColorLevel()) && (ARLocalFaceRecog.a))
                {
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("MSG_TRACK_FACE Track tmpFace success,update ,faceInfo.faceID = ");
                  ((StringBuilder)localObject5).append(((ARLocalFaceRecog.FaceInfo)localObject4).b);
                  QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject5).toString());
                }
                localObject5 = new DrawView2.FaceData();
                ((DrawView2.FaceData)localObject5).a = ((ARLocalFaceRecog.FaceInfo)localObject4).l.xys;
                ((DrawView2.FaceData)localObject5).d = ((ARLocalFaceRecog.FaceInfo)localObject4).c;
                ((DrawView2.FaceData)localObject5).f = ((ARLocalFaceRecog.FaceInfo)localObject4).b;
                ((DrawView2.FaceData)localObject5).b = new Rect(((ARLocalFaceRecog.FaceInfo)localObject4).l.x, ((ARLocalFaceRecog.FaceInfo)localObject4).l.y, ((ARLocalFaceRecog.FaceInfo)localObject4).l.x + ((ARLocalFaceRecog.FaceInfo)localObject4).l.width, ((ARLocalFaceRecog.FaceInfo)localObject4).l.y + ((ARLocalFaceRecog.FaceInfo)localObject4).l.height);
                ((DrawView2.FaceData)localObject5).c = DrawView2.FaceData.a(((DrawView2.FaceData)localObject5).b, ((ARLocalFaceRecog.FaceInfo)localObject4).l.xys);
                ((DrawView2.FaceData)localObject5).r = true;
                ((ArrayList)localObject1).add(localObject5);
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE  tmpFace not tracked ,error!");
            }
          }
          l2 = System.currentTimeMillis();
          if ((!this.a.k) && (this.a.t != null))
          {
            paramMessage = new ARLocalFaceRecogResult();
            paramMessage.c = ((ArrayList)localObject1);
            paramMessage.a = this.a.u;
            this.a.t.a(paramMessage);
            if ((this.a.z > 0L) && (((ArrayList)localObject1).size() > 0))
            {
              long l3 = System.currentTimeMillis() - this.a.z;
              ARFaceDataCollector.b().h = l3;
              ARFaceDataCollector.d();
              this.a.z = -1L;
              if (QLog.isColorLevel())
              {
                paramMessage = new StringBuilder();
                paramMessage.append("[DEBUG_SCAN_yt_face] MSG_TRACK_FACE update UI,firstlocalRecogCost = ");
                paramMessage.append(l3);
                QLog.d("AREngine_ARLocalFaceRecog", 2, paramMessage.toString());
              }
            }
          }
          this.a.s = false;
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.a))
          {
            paramMessage = new StringBuilder();
            paramMessage.append("MSG_TRACK_FACE finish, dataSize = ");
            paramMessage.append(((ArrayList)localObject1).size());
            paramMessage.append(",trackMsgExeCost = ");
            paramMessage.append(l2 - l1);
            paramMessage.append(",curTrackFrameIndex = ");
            paramMessage.append(this.a.u);
            paramMessage.append(",mIsPause = ");
            paramMessage.append(this.a.k);
            QLog.d("AREngine_ARLocalFaceRecog", 2, paramMessage.toString());
          }
        }
      }
    }
    long l1 = System.currentTimeMillis();
    this.a.r = true;
    paramMessage = (byte[])paramMessage.obj;
    long l2 = SystemClock.uptimeMillis();
    ??? = this.a.b.trackFace(paramMessage, this.a.c, this.a.d, this.a.e, false);
    l2 = SystemClock.uptimeMillis() - l2;
    ARFaceDataCollector.b(l2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MSG_DETECT_AND_RECOVER_FACE  detectFace[TimeCost] = ");
      ((StringBuilder)localObject1).append(l2);
      QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject1).toString());
    }
    if ((??? != null) && (???.length > 0) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MSG_DETECT_AND_RECOVER_FACE  detectFaceCount = ");
      ((StringBuilder)localObject1).append(???.length);
      QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.a.a((FaceStatus[])???);
    this.a.a((FaceStatus[])localObject1, (FaceStatus[])???);
    int j;
    if ((localObject1 != null) && (localObject1.length > 0) && (!this.a.k))
    {
      j = localObject1.length;
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("MSG_DETECT_AND_RECOVER_FACE  detectFaceCount = ");
        ((StringBuilder)???).append(j);
        QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
      }
      localObject3 = new float[j][];
      localObject4 = new float[j][];
      ??? = this.a.x;
      i = 0;
    }
    for (;;)
    {
      if (i < j) {}
      try
      {
        if (this.a.a(this.a.v, localObject1[i])) {
          break label2249;
        }
        localObject5 = new ARLocalFaceRecog.FaceInfo();
        ((ARLocalFaceRecog.FaceInfo)localObject5).j = true;
        ((ARLocalFaceRecog.FaceInfo)localObject5).b = this.a.B;
        localObject6 = this.a;
        ((ARLocalFaceRecog)localObject6).B += 1;
        ((ARLocalFaceRecog.FaceInfo)localObject5).l = localObject1[i];
        this.a.w.add(localObject5);
        localObject3[i] = localObject1[i].xys;
        if (!QLog.isColorLevel()) {
          break label2249;
        }
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("MSG_DETECT_AND_RECOVER_FACE  add a tempFace ,faceInfo.faceID = ");
        ((StringBuilder)localObject6).append(((ARLocalFaceRecog.FaceInfo)localObject5).b);
        QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject6).toString());
      }
      finally {}
      if ((this.a.i != null) && (this.a.i.hasMessages(1))) {
        this.a.i.removeMessages(1);
      }
      paramMessage = Message.obtain(this.a.i, new ARLocalFaceRecog.1.1(this, j, (float[][])localObject3, (float[][])localObject4, paramMessage));
      paramMessage.what = 1;
      i = j;
      if (this.a.i != null)
      {
        this.a.i.sendMessage(paramMessage);
        i = j;
        break label2129;
        this.a.r = false;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detect no face");
        }
        i = 0;
      }
      label2129:
      l2 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      paramMessage = new StringBuilder();
      paramMessage.append("MSG_DETECT_AND_RECOVER_FACE finish, faceCount = ");
      paramMessage.append(i);
      paramMessage.append(",recoverMsgExeCost = ");
      paramMessage.append(l2 - l1);
      QLog.d("AREngine_ARLocalFaceRecog", 2, paramMessage.toString());
      break;
      if (localObject3 != null)
      {
        i = 0;
        break label248;
        label2203:
        i += 1;
        break label248;
      }
      label2210:
      i = -1;
      break label307;
      label2215:
      break label2224;
      label2218:
      bool = false;
      break label605;
      label2224:
      break label197;
      label2227:
      if (localObject3 != null)
      {
        i = 0;
        break label920;
        label2237:
        i += 1;
        break label920;
      }
      label2244:
      i = -1;
      break label979;
      label2249:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.1
 * JD-Core Version:    0.7.0.1
 */