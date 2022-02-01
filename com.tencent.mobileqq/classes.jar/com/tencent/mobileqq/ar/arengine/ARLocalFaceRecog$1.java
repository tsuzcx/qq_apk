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
    long l1;
    long l2;
    Object localObject2;
    int j;
    Object localObject3;
    Object localObject4;
    int i;
    label291:
    Object localObject5;
    Object localObject6;
    label841:
    int k;
    label900:
    label1005:
    boolean bool;
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return false;
    case 1: 
      l1 = System.currentTimeMillis();
      this.a.jdField_e_of_type_Boolean = true;
      paramMessage = (byte[])paramMessage.obj;
      l2 = SystemClock.uptimeMillis();
      localObject2 = this.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.trackFace(paramMessage, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, false);
      l2 = SystemClock.uptimeMillis() - l2;
      ARFaceDataCollector.b(l2);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detectFace[TimeCost] = " + l2);
      }
      if ((localObject2 != null) && (localObject2.length > 0) && (QLog.isColorLevel())) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detectFaceCount = " + localObject2.length);
      }
      ??? = this.a.a((FaceStatus[])localObject2);
      this.a.a((FaceStatus[])???, (FaceStatus[])localObject2);
      if ((??? != null) && (???.length > 0) && (!this.a.jdField_c_of_type_Boolean))
      {
        j = ???.length;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detectFaceCount = " + j);
        }
        localObject3 = new float[j][];
        localObject4 = new float[j][];
        localObject2 = this.a.jdField_a_of_type_JavaLangObject;
        i = 0;
        if (i < j) {}
        try
        {
          if (this.a.a(this.a.jdField_a_of_type_JavaUtilList, ???[i])) {
            break;
          }
          localObject5 = new ARLocalFaceRecog.FaceInfo();
          ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_Boolean = true;
          ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_b_of_type_Int = this.a.jdField_f_of_type_Int;
          localObject6 = this.a;
          ((ARLocalFaceRecog)localObject6).jdField_f_of_type_Int += 1;
          ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = ???[i];
          this.a.jdField_b_of_type_JavaUtilList.add(localObject5);
          localObject3[i] = ???[i].xys;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  add a tempFace ,faceInfo.faceID = " + ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_b_of_type_Int);
        }
        finally {}
        if ((this.a.jdField_b_of_type_AndroidOsHandler != null) && (this.a.jdField_b_of_type_AndroidOsHandler.hasMessages(1))) {
          this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
        }
        paramMessage = Message.obtain(this.a.jdField_b_of_type_AndroidOsHandler, new ARLocalFaceRecog.1.1(this, j, (float[][])localObject3, (float[][])localObject4, paramMessage));
        paramMessage.what = 1;
        i = j;
        if (this.a.jdField_b_of_type_AndroidOsHandler != null) {
          this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(paramMessage);
        }
      }
      for (i = j;; i = 0)
      {
        l2 = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE finish, faceCount = " + i + ",recoverMsgExeCost = " + (l2 - l1));
        break;
        this.a.jdField_e_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detect no face");
        }
      }
    case 3: 
      if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE start");
      }
      l1 = System.currentTimeMillis();
      this.a.jdField_f_of_type_Boolean = true;
      localObject3 = (byte[])paramMessage.obj;
      paramMessage = new ArrayList();
      for (;;)
      {
        synchronized (this.a.jdField_a_of_type_JavaLangObject)
        {
          l2 = SystemClock.uptimeMillis();
          localObject2 = this.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.trackFace((byte[])localObject3, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int, false);
          l2 = SystemClock.uptimeMillis() - l2;
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean))
          {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace,trackSingeFace[TimeCost] = " + l2);
            ARDebugReport.a().e(l2);
          }
          localObject4 = this.a.jdField_a_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (ARLocalFaceRecog.FaceInfo)((Iterator)localObject4).next();
          if (!((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_Boolean) {
            break label1317;
          }
          if ((!QLog.isColorLevel()) || (!ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
            break label2099;
          }
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace start ");
          break label2099;
          j = k;
          if (i < localObject2.length)
          {
            if (localObject2[i].trace_id == ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.trace_id)
            {
              j = 0;
              localObject6 = ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature;
              ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject2[i];
              ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature = ((float[])localObject6);
            }
          }
          else
          {
            if (j == 0) {
              break label1005;
            }
            if (QLog.isColorLevel()) {
              QLog.i("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Lost realFace  faceInfo.lostCount = " + ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_c_of_type_Int);
            }
            ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_c_of_type_Int += 1;
            if (((ARLocalFaceRecog.FaceInfo)localObject5).jdField_c_of_type_Int <= 0) {
              continue;
            }
            ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_a_of_type_Boolean = false;
            ((ARLocalFaceRecog.FaceInfo)localObject5).jdField_c_of_type_Int = 0;
            localObject5 = this.a;
            ((ARLocalFaceRecog)localObject5).d += 1;
          }
        }
        i += 1;
        continue;
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
          break label2115;
        }
        bool = true;
        label1198:
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
        paramMessage.add(localObject6);
        continue;
        label1317:
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Try to recover realFace, isRecovering = " + this.a.jdField_e_of_type_Boolean);
        }
        if ((!this.a.jdField_e_of_type_Boolean) && (!this.a.jdField_c_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Send Recover Msg");
          }
          if (ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
            ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          }
          localObject5 = Message.obtain();
          ((Message)localObject5).what = 1;
          ((Message)localObject5).obj = localObject3;
          ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject5);
        }
      }
      localObject3 = this.a.jdField_b_of_type_JavaUtilList.iterator();
      label1451:
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ARLocalFaceRecog.FaceInfo)((Iterator)localObject3).next();
        if (((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Boolean)
        {
          if ((!QLog.isColorLevel()) || (!ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
            break label2121;
          }
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE tmpFace trackSingeFace start");
        }
      }
      break;
    }
    for (;;)
    {
      j = k;
      if (i < localObject2.length)
      {
        if (localObject2[i].trace_id == ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.trace_id)
        {
          j = 0;
          localObject5 = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature;
          ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject2[i];
          ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature = ((float[])localObject5);
        }
      }
      else
      {
        label2099:
        label2115:
        label2121:
        do
        {
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE [TimeCost] tmpFace trackSingeFace = " + l2);
          }
          if (j != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Lost tmpFace");
            }
            ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Boolean = false;
            ((Iterator)localObject3).remove();
            break label1451;
          }
          if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Track tmpFace success,update ,faceInfo.faceID = " + ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_b_of_type_Int);
          }
          localObject5 = new DrawView2.FaceData();
          ((DrawView2.FaceData)localObject5).jdField_a_of_type_ArrayOfFloat = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys;
          ((DrawView2.FaceData)localObject5).jdField_a_of_type_JavaLangString = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_JavaLangString;
          ((DrawView2.FaceData)localObject5).jdField_a_of_type_Int = ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_b_of_type_Int;
          ((DrawView2.FaceData)localObject5).jdField_a_of_type_AndroidGraphicsRect = new Rect(((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x + ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.width, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y + ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.height);
          ((DrawView2.FaceData)localObject5).jdField_a_of_type_AndroidGraphicsRectF = DrawView2.FaceData.a(((DrawView2.FaceData)localObject5).jdField_a_of_type_AndroidGraphicsRect, ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys);
          ((DrawView2.FaceData)localObject5).jdField_e_of_type_Boolean = true;
          paramMessage.add(localObject5);
          break label1451;
          if (!QLog.isColorLevel()) {
            break label1451;
          }
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE  tmpFace not tracked ,error!");
          break label1451;
          l2 = System.currentTimeMillis();
          if ((!this.a.jdField_c_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$ARLocalFaceRecogCallback != null))
          {
            ??? = new ARLocalFaceRecogResult();
            ((ARLocalFaceRecogResult)???).jdField_a_of_type_JavaUtilArrayList = paramMessage;
            ((ARLocalFaceRecogResult)???).jdField_a_of_type_Long = this.a.jdField_b_of_type_Long;
            this.a.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$ARLocalFaceRecogCallback.a((ARLocalFaceRecogResult)???);
            if ((this.a.jdField_c_of_type_Long > 0L) && (paramMessage.size() > 0))
            {
              long l3 = System.currentTimeMillis() - this.a.jdField_c_of_type_Long;
              ARFaceDataCollector.a().f = l3;
              ARFaceDataCollector.c();
              this.a.jdField_c_of_type_Long = -1L;
              if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face] MSG_TRACK_FACE update UI,firstlocalRecogCost = " + l3);
              }
            }
          }
          this.a.jdField_f_of_type_Boolean = false;
          if ((!QLog.isColorLevel()) || (!ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
            break;
          }
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE finish, dataSize = " + paramMessage.size() + ",trackMsgExeCost = " + (l2 - l1) + ",curTrackFrameIndex = " + this.a.jdField_b_of_type_Long + ",mIsPause = " + this.a.jdField_c_of_type_Boolean);
          break;
          i += 1;
          break label291;
          k = -1;
          j = k;
          if (localObject2 == null) {
            break label900;
          }
          i = 0;
          break label841;
          bool = false;
          break label1198;
          k = -1;
          j = k;
        } while (localObject2 == null);
        i = 0;
        continue;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.1
 * JD-Core Version:    0.7.0.1
 */