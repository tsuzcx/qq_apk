package com.tencent.mobileqq.ar.arengine;

import algq;
import algr;
import alhe;
import alhh;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ARLocalFaceRecog$3
  implements Runnable
{
  public ARLocalFaceRecog$3(alhe paramalhe, algq paramalgq, long paramLong) {}
  
  public void run()
  {
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.jdField_a_of_type_JavaUtilList.clear();
      this.this$0.b.clear();
      this.this$0.f = 10;
      this.this$0.jdField_a_of_type_Algq = this.jdField_a_of_type_Algq;
      if ((this.this$0.jdField_a_of_type_Algq == null) || (this.this$0.jdField_a_of_type_Algq.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus == null)) {}
    }
    for (;;)
    {
      int i;
      alhh localalhh;
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        if (this.this$0.jdField_a_of_type_Algq.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 2)
        {
          this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_Algq);
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
        if (i >= this.this$0.jdField_a_of_type_Algq.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length) {
          continue;
        }
        FaceStatus localFaceStatus = this.this$0.jdField_a_of_type_Algq.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]addFaceCloudRecogResult faceFeature = " + Arrays.toString(localFaceStatus.feature));
        }
        localalhh = new alhh();
        localalhh.jdField_a_of_type_Int = 1;
        localalhh.jdField_a_of_type_JavaLangString = "";
        if (this.this$0.jdField_a_of_type_Algq.jdField_a_of_type_JavaUtilArrayList != null)
        {
          Iterator localIterator = this.this$0.jdField_a_of_type_Algq.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            algr localalgr = (algr)localIterator.next();
            if (localalgr.jdField_a_of_type_Int != i) {
              continue;
            }
            localalhh.jdField_a_of_type_Int = 2;
            localalhh.jdField_a_of_type_JavaLangString = localalgr.jdField_a_of_type_JavaLangString;
            localalhh.jdField_b_of_type_JavaLangString = localalgr.jdField_b_of_type_JavaLangString;
            localalhh.c = String.valueOf(localalgr.jdField_a_of_type_Long);
            localalhh.d = localalgr.c;
            localalhh.e = localalgr.d;
            localalhh.f = localalgr.e;
            localalhh.jdField_a_of_type_Float = localalgr.jdField_a_of_type_Float;
          }
        }
      }
      localalhh.jdField_a_of_type_Boolean = true;
      localalhh.jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject3;
      localalhh.jdField_b_of_type_Int = i;
      this.this$0.jdField_a_of_type_JavaUtilList.add(localalhh);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3
 * JD-Core Version:    0.7.0.1
 */