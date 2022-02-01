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
        if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE start");
        }
        l1 = System.currentTimeMillis();
        this.a.jdField_f_of_type_Boolean = true;
        localObject4 = (byte[])paramMessage.obj;
        localObject1 = new ArrayList();
        synchronized (this.a.jdField_a_of_type_JavaLangObject)
        {
          l2 = SystemClock.uptimeMillis();
          localObject3 = this.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.trackFace((byte[])localObject4, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, false);
          l2 = SystemClock.uptimeMillis() - l2;
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean))
          {
            paramMessage = new StringBuilder();
            paramMessage.append("[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace,trackSingeFace[TimeCost] = ");
            paramMessage.append(l2);
            QLog.d("AREngine_ARLocalFaceRecog", 2, paramMessage.toString());
            ARDebugReport.a().e(l2);
          }
          paramMessage = this.a.jdField_a_of_type_JavaUtilList.iterator();
          if (paramMessage.hasNext())
          {
            localObject5 = (ARLocalFaceRecog.FaceInfo)paramMessage.next();
            if (((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_Boolean)
            {
              if ((!QLog.isColorLevel()) || (!ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
                break;
              }
              QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace start ");
              break;
              if (i >= localObject3.length) {
                break label2208;
              }
              if (localObject3[i].trace_id != ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.trace_id) {
                break label2201;
              }
              localObject6 = ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature;
              ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject3[i];
              ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature = ((float[])localObject6);
              i = 0;
              if (i != 0)
              {
                if (QLog.isColorLevel())
                {
                  localObject6 = new StringBuilder();
                  ((StringBuilder)localObject6).append("MSG_TRACK_FACE Lost realFace  faceInfo.lostCount = ");
                  ((StringBuilder)localObject6).append(((ARLocalFaceRecog.FaceInfo)localObject5).jdField_c_of_type_Int);
                  QLog.i("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject6).toString());
                }
                ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_c_of_type_Int += 1;
                if (((ARLocalFaceRecog.FaceInfo)localObject5).jdField_c_of_type_Int <= 0) {
                  break label2213;
                }
                ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_Boolean = false;
                ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_c_of_type_Int = 0;
                localObject5 = this.a;
                ((ARLocalFaceRecog)localObject5).d += 1;
                break label2213;
              }
              ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_c_of_type_Int = 0;
              if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Track realFace success,update");
              }
              localObject6 = new DrawView2.FaceData();
              ((DrawView2.FaceData)localObject6).jdField_a_of_type_ArrayOfFloat = ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys;
              ((DrawView2.FaceData)localObject6).jdField_a_of_type_JavaLangString = ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_JavaLangString;
              ((DrawView2.FaceData)localObject6).jdField_a_of_type_AndroidGraphicsRect = new Rect(((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x, ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y, ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x + ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.width, ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y + ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.height);
              ((DrawView2.FaceData)localObject6).jdField_a_of_type_AndroidGraphicsRectF = DrawView2.FaceData.a(((DrawView2.FaceData)localObject6).jdField_a_of_type_AndroidGraphicsRect, ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys);
              ((DrawView2.FaceData)localObject6).jdField_a_of_type_Int = ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_b_of_type_Int;
              ((DrawView2.FaceData)localObject6).jdField_c_of_type_JavaLangString = ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_b_of_type_JavaLangString;
              ((DrawView2.FaceData)localObject6).jdField_b_of_type_JavaLangString = ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_c_of_type_JavaLangString;
              ((DrawView2.FaceData)localObject6).g = ((ARLocalFaceRecog.FaceInfo)localObject5).f;
              if (((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_Int != 2) {
                break label2216;
              }
              bool = true;
              label605:
              ((DrawView2.FaceData)localObject6).jdField_b_of_type_Boolean = bool;
              if (((DrawView2.FaceData)localObject6).jdField_b_of_type_Boolean)
              {
                ((DrawView2.FaceData)localObject6).jdField_c_of_type_Boolean = this.a.a(((DrawView2.FaceData)localObject6).jdField_b_of_type_JavaLangString);
                if (((DrawView2.FaceData)localObject6).jdField_c_of_type_Boolean)
                {
                  ARScanStarFaceActInfo localARScanStarFaceActInfo = this.a.a(((DrawView2.FaceData)localObject6).jdField_b_of_type_JavaLangString);
                  if (localARScanStarFaceActInfo != null)
                  {
                    ((DrawView2.FaceData)localObject6).h = localARScanStarFaceActInfo.f;
                    ((DrawView2.FaceData)localObject6).f = localARScanStarFaceActInfo.jdField_e_of_type_JavaLangString;
                  }
                }
                ((DrawView2.FaceData)localObject6).d = ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_e_of_type_JavaLangString;
                ((DrawView2.FaceData)localObject6).jdField_e_of_type_JavaLangString = ((ARLocalFaceRecog.FaceInfo)localObject5).d;
              }
              ((DrawView2.FaceData)localObject6).jdField_a_of_type_Float = ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_Float;
              ((ArrayList)localObject1).add(localObject6);
              break label2222;
            }
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("MSG_TRACK_FACE Try to recover realFace, isRecovering = ");
              ((StringBuilder)localObject5).append(this.a.jdField_e_of_type_Boolean);
              QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject5).toString());
            }
            if ((this.a.jdField_e_of_type_Boolean) || (this.a.jdField_c_of_type_Boolean)) {
              break label2222;
            }
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Send Recover Msg");
            }
            if (ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
              ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
            }
            localObject5 = Message.obtain();
            ((Message)localObject5).what = 1;
            ((Message)localObject5).obj = localObject4;
            ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject5);
            break label2222;
          }
          paramMessage = this.a.jdField_b_of_type_JavaUtilList.iterator();
          while (paramMessage.hasNext())
          {
            localObject4 = (ARLocalFaceRecog.FaceInfo)paramMessage.next();
            if (((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Boolean)
            {
              if ((!QLog.isColorLevel()) || (!ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
                break label2225;
              }
              QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE tmpFace trackSingeFace start");
              break label2225;
              label918:
              if (i >= localObject3.length) {
                break label2242;
              }
              if (localObject3[i].trace_id != ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.trace_id) {
                break label2235;
              }
              localObject5 = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature;
              ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject3[i];
              ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature = ((float[])localObject5);
              i = 0;
              label977:
              if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean))
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
                ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Boolean = false;
                paramMessage.remove();
              }
              else
              {
                if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean))
                {
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("MSG_TRACK_FACE Track tmpFace success,update ,faceInfo.faceID = ");
                  ((StringBuilder)localObject5).append(((ARLocalFaceRecog.FaceInfo)localObject4).jdField_b_of_type_Int);
                  QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject5).toString());
                }
                localObject5 = new DrawView2.FaceData();
                ((DrawView2.FaceData)localObject5).jdField_a_of_type_ArrayOfFloat = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys;
                ((DrawView2.FaceData)localObject5).jdField_a_of_type_JavaLangString = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_JavaLangString;
                ((DrawView2.FaceData)localObject5).jdField_a_of_type_Int = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_b_of_type_Int;
                ((DrawView2.FaceData)localObject5).jdField_a_of_type_AndroidGraphicsRect = new Rect(((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x + ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.width, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y + ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.height);
                ((DrawView2.FaceData)localObject5).jdField_a_of_type_AndroidGraphicsRectF = DrawView2.FaceData.a(((DrawView2.FaceData)localObject5).jdField_a_of_type_AndroidGraphicsRect, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys);
                ((DrawView2.FaceData)localObject5).jdField_e_of_type_Boolean = true;
                ((ArrayList)localObject1).add(localObject5);
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE  tmpFace not tracked ,error!");
            }
          }
          l2 = System.currentTimeMillis();
          if ((!this.a.jdField_c_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$ARLocalFaceRecogCallback != null))
          {
            paramMessage = new ARLocalFaceRecogResult();
            paramMessage.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
            paramMessage.jdField_a_of_type_Long = this.a.jdField_b_of_type_Long;
            this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$ARLocalFaceRecogCallback.a(paramMessage);
            if ((this.a.jdField_c_of_type_Long > 0L) && (((ArrayList)localObject1).size() > 0))
            {
              long l3 = System.currentTimeMillis() - this.a.jdField_c_of_type_Long;
              ARFaceDataCollector.a().f = l3;
              ARFaceDataCollector.c();
              this.a.jdField_c_of_type_Long = -1L;
              if (QLog.isColorLevel())
              {
                paramMessage = new StringBuilder();
                paramMessage.append("[DEBUG_SCAN_yt_face] MSG_TRACK_FACE update UI,firstlocalRecogCost = ");
                paramMessage.append(l3);
                QLog.d("AREngine_ARLocalFaceRecog", 2, paramMessage.toString());
              }
            }
          }
          this.a.jdField_f_of_type_Boolean = false;
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean))
          {
            paramMessage = new StringBuilder();
            paramMessage.append("MSG_TRACK_FACE finish, dataSize = ");
            paramMessage.append(((ArrayList)localObject1).size());
            paramMessage.append(",trackMsgExeCost = ");
            paramMessage.append(l2 - l1);
            paramMessage.append(",curTrackFrameIndex = ");
            paramMessage.append(this.a.jdField_b_of_type_Long);
            paramMessage.append(",mIsPause = ");
            paramMessage.append(this.a.jdField_c_of_type_Boolean);
            QLog.d("AREngine_ARLocalFaceRecog", 2, paramMessage.toString());
          }
        }
      }
    }
    long l1 = System.currentTimeMillis();
    this.a.jdField_e_of_type_Boolean = true;
    paramMessage = (byte[])paramMessage.obj;
    long l2 = SystemClock.uptimeMillis();
    ??? = this.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.trackFace(paramMessage, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, false);
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
    if ((localObject1 != null) && (localObject1.length > 0) && (!this.a.jdField_c_of_type_Boolean))
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
      ??? = this.a.jdField_a_of_type_JavaLangObject;
      i = 0;
    }
    for (;;)
    {
      if (i < j) {}
      try
      {
        if (this.a.a(this.a.jdField_a_of_type_JavaUtilList, localObject1[i])) {
          break label2247;
        }
        localObject5 = new ARLocalFaceRecog.FaceInfo();
        ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_Boolean = true;
        ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_b_of_type_Int = this.a.jdField_f_of_type_Int;
        localObject6 = this.a;
        ((ARLocalFaceRecog)localObject6).jdField_f_of_type_Int += 1;
        ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject1[i];
        this.a.jdField_b_of_type_JavaUtilList.add(localObject5);
        localObject3[i] = localObject1[i].xys;
        if (!QLog.isColorLevel()) {
          break label2247;
        }
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("MSG_DETECT_AND_RECOVER_FACE  add a tempFace ,faceInfo.faceID = ");
        ((StringBuilder)localObject6).append(((ARLocalFaceRecog.FaceInfo)localObject5).jdField_b_of_type_Int);
        QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject6).toString());
      }
      finally {}
      if ((this.a.jdField_b_of_type_AndroidOsHandler != null) && (this.a.jdField_b_of_type_AndroidOsHandler.hasMessages(1))) {
        this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
      }
      paramMessage = Message.obtain(this.a.jdField_b_of_type_AndroidOsHandler, new ARLocalFaceRecog.1.1(this, j, (float[][])localObject3, (float[][])localObject4, paramMessage));
      paramMessage.what = 1;
      i = j;
      if (this.a.jdField_b_of_type_AndroidOsHandler != null)
      {
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(paramMessage);
        i = j;
        break label2127;
        this.a.jdField_e_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detect no face");
        }
        i = 0;
      }
      label2127:
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
        label2201:
        i += 1;
        break label248;
      }
      label2208:
      i = -1;
      break label307;
      label2213:
      break label2222;
      label2216:
      bool = false;
      break label605;
      label2222:
      break label197;
      label2225:
      if (localObject3 != null)
      {
        i = 0;
        break label918;
        label2235:
        i += 1;
        break label918;
      }
      label2242:
      i = -1;
      break label977;
      label2247:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.1
 * JD-Core Version:    0.7.0.1
 */