package com.tencent.mobileqq.ar.arengine;

import amxs;
import anbf;
import anbz;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class ARCloudPretreatmentManager$1
  implements Runnable
{
  public ARCloudPretreatmentManager$1(anbf paramanbf, FaceStatus[] paramArrayOfFaceStatus, FaceCluster paramFaceCluster, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 0;
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] pretreat, extractFaceFeature start");
    }
    int i = j;
    if (this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus != null)
    {
      i = j;
      if (this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 0)
      {
        j = this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length;
        i = 0;
        if (i < j)
        {
          long l2 = System.currentTimeMillis();
          if (amxs.b) {
            this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].feature = this.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuFaceFeature(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].xys, 0);
          }
          for (;;)
          {
            long l3 = System.currentTimeMillis();
            if (QLog.isColorLevel())
            {
              QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "  calcuFaceFeature TimeCost = " + (l3 - l2));
              if (this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].feature != null) {
                QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "  calcuFaceFeature feature = " + Arrays.toString(this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].feature));
              }
            }
            i += 1;
            break;
            QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "[DEBUG_SCAN_yt_face] pretreat, FaceModel not init!");
          }
        }
        i = j;
      }
    }
    l1 = System.currentTimeMillis() - l1;
    anbz.a().e = l1;
    anbz.a().jdField_a_of_type_Int = i;
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] pretreat, extractFaceFeature TimeCost = " + l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.1
 * JD-Core Version:    0.7.0.1
 */