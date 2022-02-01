package com.tencent.mobileqq.ar.arengine;

import apaf;
import apag;
import apat;
import apaw;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ARLocalFaceRecog$3
  implements Runnable
{
  public ARLocalFaceRecog$3(apat paramapat, apaf paramapaf, long paramLong) {}
  
  public void run()
  {
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList);
      this.this$0.a(this.this$0.b);
      this.this$0.f = 10;
      this.this$0.jdField_a_of_type_Apaf = this.jdField_a_of_type_Apaf;
      if ((this.this$0.jdField_a_of_type_Apaf == null) || (this.this$0.jdField_a_of_type_Apaf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus == null)) {}
    }
    for (;;)
    {
      int i;
      apaw localapaw;
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        if (this.this$0.jdField_a_of_type_Apaf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 2)
        {
          this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_Apaf);
          this.this$0.b(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_Apaf);
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
        if (i >= this.this$0.jdField_a_of_type_Apaf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length) {
          continue;
        }
        FaceStatus localFaceStatus = this.this$0.jdField_a_of_type_Apaf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]addFaceCloudRecogResult faceFeature = " + Arrays.toString(localFaceStatus.feature));
        }
        localapaw = new apaw();
        localapaw.jdField_a_of_type_Int = 1;
        localapaw.jdField_a_of_type_JavaLangString = "";
        if (this.this$0.jdField_a_of_type_Apaf.jdField_a_of_type_JavaUtilArrayList != null)
        {
          Iterator localIterator = this.this$0.jdField_a_of_type_Apaf.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            apag localapag = (apag)localIterator.next();
            if (localapag.jdField_a_of_type_Int != i) {
              continue;
            }
            localapaw.jdField_a_of_type_Int = 2;
            localapaw.jdField_a_of_type_JavaLangString = localapag.jdField_a_of_type_JavaLangString;
            localapaw.jdField_b_of_type_JavaLangString = localapag.jdField_b_of_type_JavaLangString;
            localapaw.c = String.valueOf(localapag.jdField_a_of_type_Long);
            localapaw.d = localapag.c;
            localapaw.e = localapag.d;
            localapaw.f = localapag.e;
            localapaw.jdField_a_of_type_Float = localapag.jdField_a_of_type_Float;
          }
        }
      }
      localapaw.jdField_a_of_type_Boolean = true;
      localapaw.jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject3;
      localapaw.jdField_b_of_type_Int = i;
      this.this$0.jdField_a_of_type_JavaUtilList.add(localapaw);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3
 * JD-Core Version:    0.7.0.1
 */