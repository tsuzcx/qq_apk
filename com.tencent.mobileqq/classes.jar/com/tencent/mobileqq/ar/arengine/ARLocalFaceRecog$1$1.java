package com.tencent.mobileqq.ar.arengine;

import amsf;
import anbz;
import ancc;
import ancd;
import ancf;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class ARLocalFaceRecog$1$1
  implements Runnable
{
  public ARLocalFaceRecog$1$1(ancd paramancd, int paramInt, float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE start ");
    }
    int i = 0;
    if (i < this.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_Array2dOfFloat[i] != null) && (!this.jdField_a_of_type_Ancd.a.jdField_c_of_type_Boolean))
      {
        long l = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature start ");
        }
        this.b[i] = this.jdField_a_of_type_Ancd.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuFaceFeature(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Ancd.a.jdField_a_of_type_Int, this.jdField_a_of_type_Ancd.a.jdField_b_of_type_Int, this.jdField_a_of_type_Array2dOfFloat[i], this.jdField_a_of_type_Ancd.a.jdField_c_of_type_Int);
        l = SystemClock.uptimeMillis() - l;
        anbz.c(l);
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature[TimeCost] = " + l);
          amsf.a().d(l);
          if (this.b[i] != null) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "  calcuFaceFeature feature = " + Arrays.toString(this.b[i]));
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  faceShape is null i = " + i);
        }
      }
    }
    for (;;)
    {
      ancf localancf1;
      ancf localancf2;
      synchronized (this.jdField_a_of_type_Ancd.a.jdField_a_of_type_JavaLangObject)
      {
        Object localObject2 = this.jdField_a_of_type_Ancd.a.jdField_a_of_type_JavaUtilList;
        i = ((List)localObject2).size();
        if ((i > 0) && (!this.jdField_a_of_type_Ancd.a.jdField_c_of_type_Boolean))
        {
          if (i != 1) {
            continue;
          }
          localObject2 = (ancf)((List)localObject2).get(0);
          if ((this.jdField_a_of_type_Ancd.a.a((ancf)localObject2, this.b, this.jdField_a_of_type_Array2dOfFloat)) && (ancc.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            ancc.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          }
        }
        this.jdField_a_of_type_Ancd.a.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_Ancd.a.f = 10;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE end ,clear tmpFace");
        }
        this.jdField_a_of_type_Ancd.a.e = false;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  finish");
        }
        return;
        if (i != 2) {
          continue;
        }
        localancf1 = (ancf)((List)localObject2).get(0);
        localancf2 = (ancf)((List)localObject2).get(1);
        if ((!localancf1.jdField_a_of_type_Boolean) && (localancf2.jdField_a_of_type_Boolean))
        {
          if ((!this.jdField_a_of_type_Ancd.a.a(localancf1, this.b, this.jdField_a_of_type_Array2dOfFloat)) || (!ancc.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            continue;
          }
          ancc.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
      }
      if ((localancf1.jdField_a_of_type_Boolean) && (!localancf2.jdField_a_of_type_Boolean))
      {
        if ((this.jdField_a_of_type_Ancd.a.a(localancf2, this.b, this.jdField_a_of_type_Array2dOfFloat)) && (ancc.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
          ancc.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
      }
      else if ((!localancf1.jdField_a_of_type_Boolean) && (!localancf2.jdField_a_of_type_Boolean))
      {
        i = this.jdField_a_of_type_Ancd.a.a(this.b, localancf1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
        int j = this.jdField_a_of_type_Ancd.a.a(this.b, localancf2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
        if ((i < 0) && (j < 0)) {}
        for (;;)
        {
          if ((!this.jdField_a_of_type_Ancd.a.a(localList)) || (!ancc.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            break label1024;
          }
          ancc.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          break;
          if ((i >= 0) && (j < 0))
          {
            localancf1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
            localancf1.jdField_a_of_type_Boolean = true;
          }
          else if ((i < 0) && (j >= 0))
          {
            localancf2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
            localancf2.jdField_a_of_type_Boolean = true;
          }
          else if (i == j)
          {
            float f1 = this.jdField_a_of_type_Ancd.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(this.b[i], localancf1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
            float f2 = this.jdField_a_of_type_Ancd.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(this.b[j], localancf2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  similarity1  = " + f1 + ",similarity2 = " + f2);
            }
            if (f1 > f2)
            {
              localancf1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
              localancf1.jdField_a_of_type_Boolean = true;
              this.b[i] = null;
              this.jdField_a_of_type_Ancd.a.a(localancf2, this.b, this.jdField_a_of_type_Array2dOfFloat);
            }
            else
            {
              localancf2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
              localancf2.jdField_a_of_type_Boolean = true;
              this.b[j] = null;
              this.jdField_a_of_type_Ancd.a.a(localancf1, this.b, this.jdField_a_of_type_Array2dOfFloat);
            }
          }
          else
          {
            localancf1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
            localancf1.jdField_a_of_type_Boolean = true;
            localancf2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
            localancf2.jdField_a_of_type_Boolean = true;
          }
        }
      }
      else
      {
        label1024:
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  calc error status");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.1.1
 * JD-Core Version:    0.7.0.1
 */