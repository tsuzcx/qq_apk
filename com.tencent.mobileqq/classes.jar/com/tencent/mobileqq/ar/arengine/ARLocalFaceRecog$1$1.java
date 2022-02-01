package com.tencent.mobileqq.ar.arengine;

import android.os.Handler;
import android.os.SystemClock;
import apem;
import apog;
import apoj;
import apok;
import apom;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class ARLocalFaceRecog$1$1
  implements Runnable
{
  public ARLocalFaceRecog$1$1(apok paramapok, int paramInt, float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE start ");
    }
    int i = 0;
    if (i < this.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_Array2dOfFloat[i] != null) && (!this.jdField_a_of_type_Apok.a.jdField_c_of_type_Boolean))
      {
        long l = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature start ");
        }
        this.b[i] = this.jdField_a_of_type_Apok.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuFaceFeature(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Apok.a.jdField_a_of_type_Int, this.jdField_a_of_type_Apok.a.jdField_b_of_type_Int, this.jdField_a_of_type_Array2dOfFloat[i], this.jdField_a_of_type_Apok.a.jdField_c_of_type_Int);
        l = SystemClock.uptimeMillis() - l;
        apog.c(l);
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature[TimeCost] = " + l);
          apem.a().d(l);
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
      apom localapom1;
      apom localapom2;
      synchronized (this.jdField_a_of_type_Apok.a.jdField_a_of_type_JavaLangObject)
      {
        Object localObject2 = this.jdField_a_of_type_Apok.a.jdField_a_of_type_JavaUtilList;
        i = ((List)localObject2).size();
        if ((i > 0) && (!this.jdField_a_of_type_Apok.a.jdField_c_of_type_Boolean))
        {
          if (i != 1) {
            continue;
          }
          localObject2 = (apom)((List)localObject2).get(0);
          if ((this.jdField_a_of_type_Apok.a.a((apom)localObject2, this.b, this.jdField_a_of_type_Array2dOfFloat)) && (apoj.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            apoj.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          }
        }
        this.jdField_a_of_type_Apok.a.a(this.jdField_a_of_type_Apok.a.jdField_b_of_type_JavaUtilList);
        this.jdField_a_of_type_Apok.a.f = 10;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE end ,clear tmpFace");
        }
        this.jdField_a_of_type_Apok.a.e = false;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  finish");
        }
        return;
        if (i != 2) {
          continue;
        }
        localapom1 = (apom)((List)localObject2).get(0);
        localapom2 = (apom)((List)localObject2).get(1);
        if ((!localapom1.jdField_a_of_type_Boolean) && (localapom2.jdField_a_of_type_Boolean))
        {
          if ((!this.jdField_a_of_type_Apok.a.a(localapom1, this.b, this.jdField_a_of_type_Array2dOfFloat)) || (!apoj.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            continue;
          }
          apoj.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
      }
      if ((localapom1.jdField_a_of_type_Boolean) && (!localapom2.jdField_a_of_type_Boolean))
      {
        if ((this.jdField_a_of_type_Apok.a.a(localapom2, this.b, this.jdField_a_of_type_Array2dOfFloat)) && (apoj.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
          apoj.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
      }
      else if ((!localapom1.jdField_a_of_type_Boolean) && (!localapom2.jdField_a_of_type_Boolean))
      {
        i = this.jdField_a_of_type_Apok.a.a(this.b, localapom1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
        int j = this.jdField_a_of_type_Apok.a.a(this.b, localapom2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
        if ((i < 0) && (j < 0)) {}
        for (;;)
        {
          if ((!this.jdField_a_of_type_Apok.a.a(localList)) || (!apoj.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            break label1029;
          }
          apoj.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          break;
          if ((i >= 0) && (j < 0))
          {
            localapom1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
            localapom1.jdField_a_of_type_Boolean = true;
          }
          else if ((i < 0) && (j >= 0))
          {
            localapom2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
            localapom2.jdField_a_of_type_Boolean = true;
          }
          else if (i == j)
          {
            float f1 = this.jdField_a_of_type_Apok.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(this.b[i], localapom1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
            float f2 = this.jdField_a_of_type_Apok.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(this.b[j], localapom2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  similarity1  = " + f1 + ",similarity2 = " + f2);
            }
            if (f1 > f2)
            {
              localapom1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
              localapom1.jdField_a_of_type_Boolean = true;
              this.b[i] = null;
              this.jdField_a_of_type_Apok.a.a(localapom2, this.b, this.jdField_a_of_type_Array2dOfFloat);
            }
            else
            {
              localapom2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
              localapom2.jdField_a_of_type_Boolean = true;
              this.b[j] = null;
              this.jdField_a_of_type_Apok.a.a(localapom1, this.b, this.jdField_a_of_type_Array2dOfFloat);
            }
          }
          else
          {
            localapom1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
            localapom1.jdField_a_of_type_Boolean = true;
            localapom2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
            localapom2.jdField_a_of_type_Boolean = true;
          }
        }
      }
      else
      {
        label1029:
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  calc error status");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.1.1
 * JD-Core Version:    0.7.0.1
 */