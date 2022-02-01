package com.tencent.mobileqq.ar.arengine;

import android.os.Handler;
import android.os.SystemClock;
import anxy;
import aoht;
import aohw;
import aohx;
import aohz;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class ARLocalFaceRecog$1$1
  implements Runnable
{
  public ARLocalFaceRecog$1$1(aohx paramaohx, int paramInt, float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE start ");
    }
    int i = 0;
    if (i < this.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_Array2dOfFloat[i] != null) && (!this.jdField_a_of_type_Aohx.a.jdField_c_of_type_Boolean))
      {
        long l = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature start ");
        }
        this.b[i] = this.jdField_a_of_type_Aohx.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuFaceFeature(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Aohx.a.jdField_a_of_type_Int, this.jdField_a_of_type_Aohx.a.jdField_b_of_type_Int, this.jdField_a_of_type_Array2dOfFloat[i], this.jdField_a_of_type_Aohx.a.jdField_c_of_type_Int);
        l = SystemClock.uptimeMillis() - l;
        aoht.c(l);
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature[TimeCost] = " + l);
          anxy.a().d(l);
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
      aohz localaohz1;
      aohz localaohz2;
      synchronized (this.jdField_a_of_type_Aohx.a.jdField_a_of_type_JavaLangObject)
      {
        Object localObject2 = this.jdField_a_of_type_Aohx.a.jdField_a_of_type_JavaUtilList;
        i = ((List)localObject2).size();
        if ((i > 0) && (!this.jdField_a_of_type_Aohx.a.jdField_c_of_type_Boolean))
        {
          if (i != 1) {
            continue;
          }
          localObject2 = (aohz)((List)localObject2).get(0);
          if ((this.jdField_a_of_type_Aohx.a.a((aohz)localObject2, this.b, this.jdField_a_of_type_Array2dOfFloat)) && (aohw.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            aohw.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          }
        }
        this.jdField_a_of_type_Aohx.a.a(this.jdField_a_of_type_Aohx.a.jdField_b_of_type_JavaUtilList);
        this.jdField_a_of_type_Aohx.a.f = 10;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE end ,clear tmpFace");
        }
        this.jdField_a_of_type_Aohx.a.e = false;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  finish");
        }
        return;
        if (i != 2) {
          continue;
        }
        localaohz1 = (aohz)((List)localObject2).get(0);
        localaohz2 = (aohz)((List)localObject2).get(1);
        if ((!localaohz1.jdField_a_of_type_Boolean) && (localaohz2.jdField_a_of_type_Boolean))
        {
          if ((!this.jdField_a_of_type_Aohx.a.a(localaohz1, this.b, this.jdField_a_of_type_Array2dOfFloat)) || (!aohw.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            continue;
          }
          aohw.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
      }
      if ((localaohz1.jdField_a_of_type_Boolean) && (!localaohz2.jdField_a_of_type_Boolean))
      {
        if ((this.jdField_a_of_type_Aohx.a.a(localaohz2, this.b, this.jdField_a_of_type_Array2dOfFloat)) && (aohw.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
          aohw.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
      }
      else if ((!localaohz1.jdField_a_of_type_Boolean) && (!localaohz2.jdField_a_of_type_Boolean))
      {
        i = this.jdField_a_of_type_Aohx.a.a(this.b, localaohz1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
        int j = this.jdField_a_of_type_Aohx.a.a(this.b, localaohz2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
        if ((i < 0) && (j < 0)) {}
        for (;;)
        {
          if ((!this.jdField_a_of_type_Aohx.a.a(localList)) || (!aohw.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
            break label1029;
          }
          aohw.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          break;
          if ((i >= 0) && (j < 0))
          {
            localaohz1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
            localaohz1.jdField_a_of_type_Boolean = true;
          }
          else if ((i < 0) && (j >= 0))
          {
            localaohz2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
            localaohz2.jdField_a_of_type_Boolean = true;
          }
          else if (i == j)
          {
            float f1 = this.jdField_a_of_type_Aohx.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(this.b[i], localaohz1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
            float f2 = this.jdField_a_of_type_Aohx.a.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(this.b[j], localaohz2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.feature);
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  similarity1  = " + f1 + ",similarity2 = " + f2);
            }
            if (f1 > f2)
            {
              localaohz1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
              localaohz1.jdField_a_of_type_Boolean = true;
              this.b[i] = null;
              this.jdField_a_of_type_Aohx.a.a(localaohz2, this.b, this.jdField_a_of_type_Array2dOfFloat);
            }
            else
            {
              localaohz2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
              localaohz2.jdField_a_of_type_Boolean = true;
              this.b[j] = null;
              this.jdField_a_of_type_Aohx.a.a(localaohz1, this.b, this.jdField_a_of_type_Array2dOfFloat);
            }
          }
          else
          {
            localaohz1.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[i];
            localaohz1.jdField_a_of_type_Boolean = true;
            localaohz2.jdField_a_of_type_ComTencentYTFaceModelFaceStatus.xys = this.jdField_a_of_type_Array2dOfFloat[j];
            localaohz2.jdField_a_of_type_Boolean = true;
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