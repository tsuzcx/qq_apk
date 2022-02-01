package com.tencent.mobileqq.ar.arengine;

import aohi;
import aohj;
import aohw;
import aohz;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ARLocalFaceRecog$3
  implements Runnable
{
  public ARLocalFaceRecog$3(aohw paramaohw, aohi paramaohi, long paramLong) {}
  
  public void run()
  {
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList);
      this.this$0.a(this.this$0.b);
      this.this$0.f = 10;
      this.this$0.jdField_a_of_type_Aohi = this.jdField_a_of_type_Aohi;
      if ((this.this$0.jdField_a_of_type_Aohi == null) || (this.this$0.jdField_a_of_type_Aohi.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus == null)) {}
    }
    for (;;)
    {
      int i;
      aohz localaohz;
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        if (this.this$0.jdField_a_of_type_Aohi.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 2)
        {
          this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_Aohi);
          this.this$0.b(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_Aohi);
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
        if (i >= this.this$0.jdField_a_of_type_Aohi.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length) {
          continue;
        }
        FaceStatus localFaceStatus = this.this$0.jdField_a_of_type_Aohi.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]addFaceCloudRecogResult faceFeature = " + Arrays.toString(localFaceStatus.feature));
        }
        localaohz = new aohz();
        localaohz.jdField_a_of_type_Int = 1;
        localaohz.jdField_a_of_type_JavaLangString = "";
        if (this.this$0.jdField_a_of_type_Aohi.jdField_a_of_type_JavaUtilArrayList != null)
        {
          Iterator localIterator = this.this$0.jdField_a_of_type_Aohi.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            aohj localaohj = (aohj)localIterator.next();
            if (localaohj.jdField_a_of_type_Int != i) {
              continue;
            }
            localaohz.jdField_a_of_type_Int = 2;
            localaohz.jdField_a_of_type_JavaLangString = localaohj.jdField_a_of_type_JavaLangString;
            localaohz.jdField_b_of_type_JavaLangString = localaohj.jdField_b_of_type_JavaLangString;
            localaohz.c = String.valueOf(localaohj.jdField_a_of_type_Long);
            localaohz.d = localaohj.c;
            localaohz.e = localaohj.d;
            localaohz.f = localaohj.e;
            localaohz.jdField_a_of_type_Float = localaohj.jdField_a_of_type_Float;
          }
        }
      }
      localaohz.jdField_a_of_type_Boolean = true;
      localaohz.jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject3;
      localaohz.jdField_b_of_type_Int = i;
      this.this$0.jdField_a_of_type_JavaUtilList.add(localaohz);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3
 * JD-Core Version:    0.7.0.1
 */