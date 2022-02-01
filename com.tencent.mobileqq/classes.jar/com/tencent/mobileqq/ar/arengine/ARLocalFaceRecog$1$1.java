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
    while (i < this.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_Array2dOfFloat[i] != null) && (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.jdField_c_of_type_Boolean))
      {
        long l = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature start ");
        }
        this.b[i] = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuFaceFeature(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.jdField_b_of_type_Int, this.jdField_a_of_type_Array2dOfFloat[i], this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.jdField_c_of_type_Int);
        l = SystemClock.uptimeMillis() - l;
        ARFaceDataCollector.c(l);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature[TimeCost] = ");
          ((StringBuilder)???).append(l);
          QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
          ARDebugReport.a().d(l);
          if (this.b[i] != null)
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("  calcuFaceFeature feature = ");
            ((StringBuilder)???).append(Arrays.toString(this.b[i]));
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
    synchronized (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.jdField_a_of_type_JavaUtilList;
      i = ((List)localObject2).size();
      if ((i > 0) && (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.jdField_c_of_type_Boolean)) {
        if (i == 1)
        {
          localObject2 = (ARLocalFaceRecog.FaceInfo)((List)localObject2).get(0);
          if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.a((ARLocalFaceRecog.FaceInfo)localObject2, this.b, this.jdField_a_of_type_Array2dOfFloat)) && (ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          }
        }
        else if (i == 2)
        {
          ARLocalFaceRecog.FaceInfo localFaceInfo1 = (ARLocalFaceRecog.FaceInfo)((List)localObject2).get(0);
          ARLocalFaceRecog.FaceInfo localFaceInfo2 = (ARLocalFaceRecog.FaceInfo)((List)localObject2).get(1);
          if ((!localFaceInfo1.jdField_a_of_type_Boolean) && (localFaceInfo2.jdField_a_of_type_Boolean))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.a(localFaceInfo1, this.b, this.jdField_a_of_type_Array2dOfFloat)) && (ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
              ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
            }
          }
          else if ((localFaceInfo1.jdField_a_of_type_Boolean) && (!localFaceInfo2.jdField_a_of_type_Boolean))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.a(localFaceInfo2, this.b, this.jdField_a_of_type_Array2dOfFloat)) && (ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
              ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
            }
          }
          else if ((!localFaceInfo1.jdField_a_of_type_Boolean) && (!localFaceInfo2.jdField_a_of_type_Boolean))
          {
            i = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.a(this.b, localFaceInfo1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
            int j = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.a(this.b, localFaceInfo2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
            if ((i >= 0) || (j >= 0)) {
              if ((i >= 0) && (j < 0))
              {
                localFaceInfo1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
                localFaceInfo1.jdField_a_of_type_Boolean = true;
              }
              else if ((i < 0) && (j >= 0))
              {
                localFaceInfo2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
                localFaceInfo2.jdField_a_of_type_Boolean = true;
              }
              else if (i == j)
              {
                float f1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(this.b[i], localFaceInfo1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
                float f2 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(this.b[j], localFaceInfo2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
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
                  localFaceInfo1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
                  localFaceInfo1.jdField_a_of_type_Boolean = true;
                  this.b[i] = null;
                  this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.a(localFaceInfo2, this.b, this.jdField_a_of_type_Array2dOfFloat);
                }
                else
                {
                  localFaceInfo2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
                  localFaceInfo2.jdField_a_of_type_Boolean = true;
                  this.b[j] = null;
                  this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.a(localFaceInfo1, this.b, this.jdField_a_of_type_Array2dOfFloat);
                }
              }
              else
              {
                localFaceInfo1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
                localFaceInfo1.jdField_a_of_type_Boolean = true;
                localFaceInfo2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
                localFaceInfo2.jdField_a_of_type_Boolean = true;
              }
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.a((List)localObject2)) && (ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
              ARLocalFaceRecog.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  calc error status");
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.jdField_b_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.f = 10;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE end ,clear tmpFace");
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog$1.a.e = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.1.1
 * JD-Core Version:    0.7.0.1
 */