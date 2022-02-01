package com.tencent.mobileqq.ar.arengine;

import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.mobileqq.ar.FaceScanModelsLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class ARCloudPretreatmentManager$1
  implements Runnable
{
  ARCloudPretreatmentManager$1(ARCloudPretreatmentManager paramARCloudPretreatmentManager, FaceStatus[] paramArrayOfFaceStatus, FaceCluster paramFaceCluster, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] pretreat, extractFaceFeature start");
    }
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus;
    int i = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      int k = localObject.length;
      for (;;)
      {
        j = k;
        if (i >= k) {
          break;
        }
        long l2 = System.currentTimeMillis();
        if (FaceScanModelsLoader.b)
        {
          localObject = this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus;
          localObject[i].feature = this.jdField_a_of_type_ComTencentYTFaceClusterFaceCluster.calcuFaceFeature(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.b, localObject[i].xys, 0);
        }
        else
        {
          QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "[DEBUG_SCAN_yt_face] pretreat, FaceModel not init!");
        }
        long l3 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("  calcuFaceFeature TimeCost = ");
          ((StringBuilder)localObject).append(l3 - l2);
          QLog.d("AREngine_ARCloudPretreatmentManagert", 2, ((StringBuilder)localObject).toString());
          if (this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].feature != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("  calcuFaceFeature feature = ");
            ((StringBuilder)localObject).append(Arrays.toString(this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i].feature));
            QLog.d("AREngine_ARCloudPretreatmentManagert", 2, ((StringBuilder)localObject).toString());
          }
        }
        i += 1;
      }
    }
    int j = 0;
    l1 = System.currentTimeMillis() - l1;
    ARFaceDataCollector.a().e = l1;
    ARFaceDataCollector.a().jdField_a_of_type_Int = j;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[DEBUG_SCAN_yt_face] pretreat, extractFaceFeature TimeCost = ");
      ((StringBuilder)localObject).append(l1);
      QLog.d("AREngine_ARCloudPretreatmentManagert", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.1
 * JD-Core Version:    0.7.0.1
 */