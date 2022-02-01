import android.graphics.Rect;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apkz
  implements Handler.Callback
{
  apkz(apky paramapky) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    long l1;
    long l2;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int i;
    label292:
    Object localObject5;
    Object localObject6;
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return false;
    case 1: 
      l1 = System.currentTimeMillis();
      this.a.jdField_e_of_type_Boolean = true;
      paramMessage = (byte[])paramMessage.obj;
      int j = 0;
      l2 = SystemClock.uptimeMillis();
      localObject2 = this.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.detectFace(paramMessage, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
      l2 = SystemClock.uptimeMillis() - l2;
      apkv.b(l2);
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
        if (i < j) {
          try
          {
            if (!this.a.a(this.a.jdField_a_of_type_JavaUtilList, ???[i]))
            {
              localObject5 = new aplb();
              ((aplb)localObject5).jdField_a_of_type_Boolean = true;
              ((aplb)localObject5).jdField_b_of_type_Int = this.a.jdField_f_of_type_Int;
              localObject6 = this.a;
              ((apky)localObject6).jdField_f_of_type_Int += 1;
              ((aplb)localObject5).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = ???[i];
              this.a.jdField_b_of_type_JavaUtilList.add(localObject5);
              localObject3[i] = ???[i].xys;
              if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  add a tempFace ,faceInfo.faceID = " + ((aplb)localObject5).jdField_b_of_type_Int);
              }
            }
            else if (???[i].nativeFaceAlignmentPtr != 0L)
            {
              this.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.releaseNativeFaceStatus(???[i]);
            }
          }
          finally {}
        }
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
        }
      }
      for (;;)
      {
        l2 = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE finish, faceCount = " + i + ",recoverMsgExeCost = " + (l2 - l1));
        break;
        this.a.jdField_e_of_type_Boolean = false;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detect no face");
          i = j;
        }
      }
    case 3: 
      if ((QLog.isColorLevel()) && (apky.jdField_a_of_type_Boolean)) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE start");
      }
      l1 = System.currentTimeMillis();
      this.a.jdField_f_of_type_Boolean = true;
      localObject2 = (byte[])paramMessage.obj;
      paramMessage = new ArrayList();
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        localObject3 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        label726:
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label1404;
          }
          localObject4 = (aplb)((Iterator)localObject3).next();
          if (!((aplb)localObject4).jdField_a_of_type_Boolean) {
            break label1284;
          }
          if ((QLog.isColorLevel()) && (apky.jdField_a_of_type_Boolean)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace start ");
          }
          l2 = SystemClock.uptimeMillis();
          i = this.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.trackSingleFace2((byte[])localObject2, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus, this.a.jdField_c_of_type_Int);
          l2 = SystemClock.uptimeMillis() - l2;
          if ((QLog.isColorLevel()) && (apky.jdField_a_of_type_Boolean))
          {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace,trackSingeFace[TimeCost] = " + l2);
            apba.a().e(l2);
          }
          if (i == 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Lost realFace  faceInfo.lostCount = " + ((aplb)localObject4).jdField_c_of_type_Int);
          }
          ((aplb)localObject4).jdField_c_of_type_Int += 1;
        } while (((aplb)localObject4).jdField_c_of_type_Int <= 0);
        ((aplb)localObject4).jdField_a_of_type_Boolean = false;
        ((aplb)localObject4).jdField_c_of_type_Int = 0;
        localObject4 = this.a;
        ((apky)localObject4).d += 1;
      }
      ((aplb)localObject4).jdField_c_of_type_Int = 0;
      if ((QLog.isColorLevel()) && (apky.jdField_a_of_type_Boolean)) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Track realFace success,update");
      }
      localObject5 = new apgl();
      ((apgl)localObject5).jdField_a_of_type_ArrayOfFloat = ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys;
      ((apgl)localObject5).jdField_a_of_type_JavaLangString = ((aplb)localObject4).jdField_a_of_type_JavaLangString;
      ((apgl)localObject5).jdField_a_of_type_AndroidGraphicsRect = new Rect(((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x, ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y, ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x + ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.width, ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y + ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.height);
      ((apgl)localObject5).jdField_a_of_type_AndroidGraphicsRectF = apgl.a(((apgl)localObject5).jdField_a_of_type_AndroidGraphicsRect, ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys);
      ((apgl)localObject5).jdField_a_of_type_Int = ((aplb)localObject4).jdField_b_of_type_Int;
      ((apgl)localObject5).jdField_c_of_type_JavaLangString = ((aplb)localObject4).jdField_b_of_type_JavaLangString;
      ((apgl)localObject5).jdField_b_of_type_JavaLangString = ((aplb)localObject4).jdField_c_of_type_JavaLangString;
      ((apgl)localObject5).g = ((aplb)localObject4).f;
      if (((aplb)localObject4).jdField_a_of_type_Int != 2) {}
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      ((apgl)localObject5).jdField_b_of_type_Boolean = bool;
      if (((apgl)localObject5).jdField_b_of_type_Boolean)
      {
        ((apgl)localObject5).jdField_c_of_type_Boolean = this.a.a(((apgl)localObject5).jdField_b_of_type_JavaLangString);
        if (((apgl)localObject5).jdField_c_of_type_Boolean)
        {
          localObject6 = this.a.a(((apgl)localObject5).jdField_b_of_type_JavaLangString);
          if (localObject6 != null)
          {
            ((apgl)localObject5).h = ((ARScanStarFaceActInfo)localObject6).f;
            ((apgl)localObject5).f = ((ARScanStarFaceActInfo)localObject6).jdField_e_of_type_JavaLangString;
          }
        }
        ((apgl)localObject5).d = ((aplb)localObject4).jdField_e_of_type_JavaLangString;
        ((apgl)localObject5).jdField_e_of_type_JavaLangString = ((aplb)localObject4).d;
      }
      ((apgl)localObject5).jdField_a_of_type_Float = ((aplb)localObject4).jdField_a_of_type_Float;
      paramMessage.add(localObject5);
      break label726;
      label1284:
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Try to recover realFace, isRecovering = " + this.a.jdField_e_of_type_Boolean);
      }
      if ((this.a.jdField_e_of_type_Boolean) || (this.a.jdField_c_of_type_Boolean)) {
        break label726;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Send Recover Msg");
      }
      if (apky.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        apky.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      localObject4 = Message.obtain();
      ((Message)localObject4).what = 1;
      ((Message)localObject4).obj = localObject2;
      apky.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
      break label726;
      label1404:
      localObject3 = this.a.jdField_b_of_type_JavaUtilList.iterator();
      long l3;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (aplb)((Iterator)localObject3).next();
        if (((aplb)localObject4).jdField_a_of_type_Boolean)
        {
          if ((QLog.isColorLevel()) && (apky.jdField_a_of_type_Boolean)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE tmpFace trackSingeFace start");
          }
          l2 = SystemClock.uptimeMillis();
          i = this.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.trackSingleFace2((byte[])localObject2, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus, this.a.jdField_c_of_type_Int);
          l3 = SystemClock.uptimeMillis();
          if ((QLog.isColorLevel()) && (apky.jdField_a_of_type_Boolean)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE [TimeCost] tmpFace trackSingeFace = " + (l3 - l2));
          }
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Lost tmpFace");
            }
            ((aplb)localObject4).jdField_a_of_type_Boolean = false;
            ((Iterator)localObject3).remove();
            if ((((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus != null) && (((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.nativeFaceAlignmentPtr != 0L)) {
              FaceCluster.getInstance().releaseNativeFaceStatus(((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus);
            }
          }
          else
          {
            if ((QLog.isColorLevel()) && (apky.jdField_a_of_type_Boolean)) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Track tmpFace success,update ,faceInfo.faceID = " + ((aplb)localObject4).jdField_b_of_type_Int);
            }
            localObject5 = new apgl();
            ((apgl)localObject5).jdField_a_of_type_ArrayOfFloat = ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys;
            ((apgl)localObject5).jdField_a_of_type_JavaLangString = ((aplb)localObject4).jdField_a_of_type_JavaLangString;
            ((apgl)localObject5).jdField_a_of_type_Int = ((aplb)localObject4).jdField_b_of_type_Int;
            ((apgl)localObject5).jdField_a_of_type_AndroidGraphicsRect = new Rect(((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x, ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y, ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.x + ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.width, ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.y + ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.height);
            ((apgl)localObject5).jdField_a_of_type_AndroidGraphicsRectF = apgl.a(((apgl)localObject5).jdField_a_of_type_AndroidGraphicsRect, ((aplb)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys);
            ((apgl)localObject5).jdField_e_of_type_Boolean = true;
            paramMessage.add(localObject5);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE  tmpFace not tracked ,error!");
        }
      }
      l2 = System.currentTimeMillis();
      if ((!this.a.jdField_c_of_type_Boolean) && (this.a.jdField_a_of_type_Apla != null))
      {
        ??? = new aplc();
        ((aplc)???).jdField_a_of_type_JavaUtilArrayList = paramMessage;
        ((aplc)???).jdField_a_of_type_Long = this.a.jdField_b_of_type_Long;
        this.a.jdField_a_of_type_Apla.a((aplc)???);
        if ((this.a.jdField_c_of_type_Long > 0L) && (paramMessage.size() > 0))
        {
          l3 = System.currentTimeMillis() - this.a.jdField_c_of_type_Long;
          apkv.a().f = l3;
          apkv.c();
          this.a.jdField_c_of_type_Long = -1L;
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face] MSG_TRACK_FACE update UI,firstlocalRecogCost = " + l3);
          }
        }
      }
      this.a.jdField_f_of_type_Boolean = false;
      if ((!QLog.isColorLevel()) || (!apky.jdField_a_of_type_Boolean)) {
        break;
      }
      QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE finish, dataSize = " + paramMessage.size() + ",trackMsgExeCost = " + (l2 - l1) + ",curTrackFrameIndex = " + this.a.jdField_b_of_type_Long + ",mIsPause = " + this.a.jdField_c_of_type_Boolean);
      break;
      i += 1;
      break label292;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkz
 * JD-Core Version:    0.7.0.1
 */