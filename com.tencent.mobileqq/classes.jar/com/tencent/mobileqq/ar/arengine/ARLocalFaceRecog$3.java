package com.tencent.mobileqq.ar.arengine;

import algp;
import algq;
import alhd;
import alhg;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ARLocalFaceRecog$3
  implements Runnable
{
  public ARLocalFaceRecog$3(alhd paramalhd, algp paramalgp, long paramLong) {}
  
  public void run()
  {
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.jdField_a_of_type_JavaUtilList.clear();
      this.this$0.b.clear();
      this.this$0.f = 10;
      this.this$0.jdField_a_of_type_Algp = this.jdField_a_of_type_Algp;
      if ((this.this$0.jdField_a_of_type_Algp == null) || (this.this$0.jdField_a_of_type_Algp.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus == null)) {}
    }
    for (;;)
    {
      int i;
      alhg localalhg;
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        if (this.this$0.jdField_a_of_type_Algp.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 2)
        {
          this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_Algp);
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
        if (i >= this.this$0.jdField_a_of_type_Algp.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length) {
          continue;
        }
        FaceStatus localFaceStatus = this.this$0.jdField_a_of_type_Algp.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]addFaceCloudRecogResult faceFeature = " + Arrays.toString(localFaceStatus.feature));
        }
        localalhg = new alhg();
        localalhg.jdField_a_of_type_Int = 1;
        localalhg.jdField_a_of_type_JavaLangString = "";
        if (this.this$0.jdField_a_of_type_Algp.jdField_a_of_type_JavaUtilArrayList != null)
        {
          Iterator localIterator = this.this$0.jdField_a_of_type_Algp.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            algq localalgq = (algq)localIterator.next();
            if (localalgq.jdField_a_of_type_Int != i) {
              continue;
            }
            localalhg.jdField_a_of_type_Int = 2;
            localalhg.jdField_a_of_type_JavaLangString = localalgq.jdField_a_of_type_JavaLangString;
            localalhg.jdField_b_of_type_JavaLangString = localalgq.jdField_b_of_type_JavaLangString;
            localalhg.c = String.valueOf(localalgq.jdField_a_of_type_Long);
            localalhg.d = localalgq.c;
            localalhg.e = localalgq.d;
            localalhg.f = localalgq.e;
            localalhg.jdField_a_of_type_Float = localalgq.jdField_a_of_type_Float;
          }
        }
      }
      localalhg.jdField_a_of_type_Boolean = true;
      localalhg.jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject3;
      localalhg.jdField_b_of_type_Int = i;
      this.this$0.jdField_a_of_type_JavaUtilList.add(localalhg);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3
 * JD-Core Version:    0.7.0.1
 */