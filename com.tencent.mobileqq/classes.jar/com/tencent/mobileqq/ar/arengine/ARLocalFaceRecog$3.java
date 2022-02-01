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
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList);
      this.this$0.a(this.this$0.b);
      this.this$0.f = 10;
      this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult;
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus == null)) {}
    }
    for (;;)
    {
      int i;
      ARLocalFaceRecog.FaceInfo localFaceInfo;
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 2)
        {
          this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult);
          this.this$0.b(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult);
          long l1 = System.currentTimeMillis();
          long l2 = this.jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face][ScanStarFace]addFaceCloudRecogResult finish,totalFaceList = " + this.this$0.jdField_a_of_type_JavaUtilList + ",addFaceClouDResultCost = " + (l1 - l2));
          }
          this.this$0.c = System.currentTimeMillis();
          this.this$0.d = false;
          return;
          localObject2 = finally;
          throw localObject2;
        }
        i = 0;
        if (i >= this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length) {
          continue;
        }
        FaceStatus localFaceStatus = this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]addFaceCloudRecogResult faceFeature = " + Arrays.toString(localFaceStatus.feature));
        }
        localFaceInfo = new ARLocalFaceRecog.FaceInfo();
        localFaceInfo.jdField_a_of_type_Int = 1;
        localFaceInfo.jdField_a_of_type_JavaLangString = "";
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList != null)
        {
          Iterator localIterator = this.this$0.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            ARCloudRecogRspFaceResult.StarInfo localStarInfo = (ARCloudRecogRspFaceResult.StarInfo)localIterator.next();
            if (localStarInfo.jdField_a_of_type_Int != i) {
              continue;
            }
            localFaceInfo.jdField_a_of_type_Int = 2;
            localFaceInfo.jdField_a_of_type_JavaLangString = localStarInfo.jdField_a_of_type_JavaLangString;
            localFaceInfo.jdField_b_of_type_JavaLangString = localStarInfo.jdField_b_of_type_JavaLangString;
            localFaceInfo.c = String.valueOf(localStarInfo.jdField_a_of_type_Long);
            localFaceInfo.d = localStarInfo.c;
            localFaceInfo.e = localStarInfo.d;
            localFaceInfo.f = localStarInfo.e;
            localFaceInfo.jdField_a_of_type_Float = localStarInfo.jdField_a_of_type_Float;
          }
        }
      }
      localFaceInfo.jdField_a_of_type_Boolean = true;
      localFaceInfo.jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject3;
      localFaceInfo.jdField_b_of_type_Int = i;
      this.this$0.jdField_a_of_type_JavaUtilList.add(localFaceInfo);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3
 * JD-Core Version:    0.7.0.1
 */