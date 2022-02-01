package com.tencent.mobileqq.ar.arengine;

import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class ARLocalFaceRecog$3
  implements Runnable
{
  ARLocalFaceRecog$3(ARLocalFaceRecog paramARLocalFaceRecog, ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult, long paramLong) {}
  
  public void run()
  {
    int i;
    label563:
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList);
      this.this$0.a(this.this$0.b);
      this.this$0.f = 10;
      ??? = this.this$0;
      ((ARLocalFaceRecog)???).jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult;
      if ((((ARLocalFaceRecog)???).jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus != null)) {
        label441:
        synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
        {
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length <= 2) {
            break label563;
          }
          this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult);
          this.this$0.b(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult);
          break label441;
          while (i < this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length)
          {
            FaceStatus localFaceStatus = this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("[ScanStarFace]addFaceCloudRecogResult faceFeature = ");
              ((StringBuilder)localObject4).append(Arrays.toString(localFaceStatus.feature));
              QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)localObject4).toString());
            }
            Object localObject4 = new ARLocalFaceRecog.FaceInfo();
            ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Int = 1;
            ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_JavaLangString = "";
            if (this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList != null)
            {
              Iterator localIterator = this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList.iterator();
              while (localIterator.hasNext())
              {
                ARCloudRecogRspFaceResult.StarInfo localStarInfo = (ARCloudRecogRspFaceResult.StarInfo)localIterator.next();
                if (localStarInfo.jdField_a_of_type_Int == i)
                {
                  ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Int = 2;
                  ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_JavaLangString = localStarInfo.jdField_a_of_type_JavaLangString;
                  ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_b_of_type_JavaLangString = localStarInfo.jdField_b_of_type_JavaLangString;
                  ((ARLocalFaceRecog.FaceInfo)localObject4).c = String.valueOf(localStarInfo.jdField_a_of_type_Long);
                  ((ARLocalFaceRecog.FaceInfo)localObject4).d = localStarInfo.c;
                  ((ARLocalFaceRecog.FaceInfo)localObject4).e = localStarInfo.d;
                  ((ARLocalFaceRecog.FaceInfo)localObject4).f = localStarInfo.e;
                  ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Float = localStarInfo.jdField_a_of_type_Float;
                }
              }
            }
            ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_Boolean = true;
            ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localFaceStatus;
            ((ARLocalFaceRecog.FaceInfo)localObject4).jdField_b_of_type_Int = i;
            this.this$0.jdField_a_of_type_JavaUtilList.add(localObject4);
            i += 1;
          }
        }
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("[DEBUG_SCAN_yt_face][ScanStarFace]addFaceCloudRecogResult finish,totalFaceList = ");
        ((StringBuilder)???).append(this.this$0.jdField_a_of_type_JavaUtilList);
        ((StringBuilder)???).append(",addFaceClouDResultCost = ");
        ((StringBuilder)???).append(l1 - l2);
        QLog.d("AREngine_ARLocalFaceRecog", 2, ((StringBuilder)???).toString());
      }
      this.this$0.c = System.currentTimeMillis();
      this.this$0.d = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3
 * JD-Core Version:    0.7.0.1
 */